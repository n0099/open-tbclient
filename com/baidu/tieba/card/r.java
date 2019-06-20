package com.baidu.tieba.card;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.q;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class r extends a<CardPersonDynamicThreadData> {
    private TextView VB;
    private boolean XI;
    public PlayVoiceBntNew XR;
    private TbImageView.a cIx;
    public NewThreadCommentAndPraiseInfoLayout dBS;
    private ConstrainImageGroup exO;
    private View.OnClickListener exT;
    private final View.OnClickListener exU;
    private CustomMessageListener exh;
    public ThreadViewAndCommentInfoLayout eyE;
    private final String eyF;
    private final String eyG;
    private TextView eyH;
    private LinearLayout eyI;
    private TextView eyJ;
    private TextView eyK;
    private TextView eyL;
    private TextView eyM;
    private ImageView eyN;
    private q eyO;
    private View eyP;
    private TbImageView eyQ;
    private ImageView eyR;
    private LinearLayout eyS;
    private TextView eyT;
    private LinearLayout eyU;
    private LinearLayout eyV;
    private TextView eyW;
    private TextView eyX;
    private TextView eyY;
    private TBLottieAnimationView eyZ;
    private CardPersonDynamicThreadData eyt;
    private TextView eza;
    private TextView ezb;
    public OriginalThreadCardView ezc;
    private View ezd;
    private View eze;
    private boolean ezf;
    private boolean ezg;
    com.baidu.tieba.view.h ezh;
    private q.a ezi;
    private final View.OnClickListener ezj;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eyF = "1";
        this.eyG = "2";
        this.mSkinType = 3;
        this.XI = true;
        this.ezh = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eyt != null && !StringUtils.isNull(r.this.eyt.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eyt.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aXr() != null) {
                    r.this.aXr().a(view, r.this.eyt);
                }
                if (r.this.eyt.eBB != 60) {
                    if ((r.this.eyt.eBB != 40 || r.this.eyt.eBD != 2) && !r.this.ezg) {
                        r.this.aoV();
                        return;
                    } else {
                        BdToast.c(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_toast_game_error).afO();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eyt.threadData.adO().live_status != 1) {
                    r.this.aXN();
                } else {
                    r.this.aXM();
                }
            }
        };
        this.exh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eyt != null && r.this.eyt.threadId != null && r.this.mTitle != null && r.this.VB != null && ((String) customResponsedMessage.getData()).equals(r.this.eyt.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eyt.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.VB, r.this.eyt.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.ezi = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.iu(z);
            }
        };
        this.ezj = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aXr = r.this.aXr();
                if (aXr != null) {
                    view.setTag("1");
                    aXr.a(view, r.this.eyt);
                }
                r.this.aoV();
            }
        };
        this.exU = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aXr = r.this.aXr();
                if (aXr != null) {
                    view.setTag("2");
                    aXr.a(view, r.this.eyt);
                }
            }
        };
        this.cIx = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && r.this.eyQ != null) {
                    r.this.eyQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eyH = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.eyI = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.eyJ = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.eyK = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.eyL = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.ezb = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.eyM = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.eyN = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.XR = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.XR.setAfterClickListener(this.exU);
        this.VB = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.VB.setVisibility(8);
        this.exO = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.exO.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.exO.setChildClickListener(this.ezj);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.exO.setImageProcessor(aVar);
        this.eyP = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.eyQ = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.eyR = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.eyE = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.eyV = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.eyW = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.eyX = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.eyY = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.eyZ = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eyZ.y(true);
        al.a(this.eyZ, (int) R.raw.ala_play);
        this.eza = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.eyS = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.eyT = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.eyU = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.eyU.setVisibility(8);
        this.ezc = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.ezd = this.mRootView.findViewById(R.id.divider_line_thick);
        this.eze = this.mRootView.findViewById(R.id.divider_line_thin);
        this.dBS = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.dBS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBS.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBS.setLayoutParams(layoutParams);
        }
        this.dBS.setOnClickListener(this.exT);
        this.dBS.setReplyTimeVisible(false);
        this.dBS.setShowPraiseNum(true);
        this.dBS.setNeedAddPraiseIcon(true);
        this.dBS.setNeedAddReplyIcon(true);
        this.dBS.setShareVisible(true);
        this.dBS.setIsBarViewVisible(false);
        this.dBS.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEz = 8;
        dVar.bEE = 3;
        this.dBS.setAgreeStatisticData(dVar);
        this.dBS.setShareReportFrom(6);
        this.dBS.setStType("person_page");
        this.dBS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aXr() != null) {
                    r.this.aXr().a(view, r.this.eyt);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.a(this.eyZ, (int) R.raw.ala_play);
            al.k(getView(), R.drawable.home_thread_card_item_bg);
            al.j(this.eyH, R.color.cp_cont_b);
            al.j(this.eyJ, R.color.cp_cont_j);
            al.j(this.eyK, R.color.cp_cont_b);
            al.j(this.eyL, R.color.cp_cont_d);
            al.j(this.ezb, R.color.cp_cont_d);
            al.j(this.eyM, R.color.cp_cont_d);
            if (this.eyN != null) {
                this.eyN.setImageDrawable(al.getDrawable(R.drawable.icon_card_more));
            }
            al.j(this.mTitle, R.color.cp_cont_b);
            al.j(this.VB, R.color.cp_cont_f);
            al.j(this.eyT, R.color.cp_cont_f);
            if (this.eyO != null) {
                this.eyO.onChangeSkinType();
            }
            this.eyE.onChangeSkinType();
            this.dBS.onChangeSkinType();
            al.l(this.ezd, R.color.cp_bg_line_e);
            al.l(this.eze, R.color.cp_bg_line_c);
            al.l(this.eyT, R.color.cp_bg_line_e);
            if (this.ezc != null) {
                this.ezc.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.eyt = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.exT);
        }
        this.eyH.setVisibility(cardPersonDynamicThreadData.eBN ? 0 : 8);
        this.eyI.setVisibility(cardPersonDynamicThreadData.eBM ? 0 : 4);
        this.ezd.setVisibility(cardPersonDynamicThreadData.eBM ? 0 : 8);
        this.eze.setVisibility(cardPersonDynamicThreadData.eBM ? 8 : 0);
        if (cardPersonDynamicThreadData.eBO) {
            this.ezd.setVisibility(8);
            this.eze.setVisibility(8);
        }
        this.ezf = cardPersonDynamicThreadData.eBB == 40 && cardPersonDynamicThreadData.eBD == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ezg = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.eBD == 2;
        }
        this.eyH.setText(cardPersonDynamicThreadData.eBE);
        this.eyJ.setText(cardPersonDynamicThreadData.eBF);
        this.eyK.setText(cardPersonDynamicThreadData.eBG);
        if (cardPersonDynamicThreadData.eBL != null && cardPersonDynamicThreadData.eBL.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.eBL.length; i++) {
                sb.append(ap.j(cardPersonDynamicThreadData.eBL[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.eBL.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eyL.setText(sb2);
                this.eyL.setVisibility(0);
            } else {
                this.eyL.setText(R.string.person_homepage);
            }
        } else {
            this.eyL.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eyM.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eyM.setVisibility(0);
            }
            iu(cardPersonDynamicThreadData.isPrivacy);
            this.eyN.setVisibility(0);
            this.eyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eyO == null) {
                            r.this.eyO = new q(r.this.mPageContext);
                            r.this.eyO.create();
                            r.this.eyO.a(r.this.ezi);
                        }
                        r.this.eyO.a(r.this.eyt);
                        r.this.eyO.show();
                    }
                }
            });
        } else {
            this.eyM.setVisibility(8);
            this.eyN.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.eBJ;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.XR.setVisibility(0);
            it(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.XR.setVoiceModel(voiceModel);
            this.XR.setTag(voiceModel);
            this.XR.bFE();
            if (voiceModel != null) {
                this.XR.vx(voiceModel.voice_status.intValue());
            }
            this.XR.cnG();
        } else {
            this.XR.setVisibility(8);
            it(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.eBI;
        al.k(this.eyS, R.color.transparent);
        this.eyT.setVisibility(8);
        this.eyU.setVisibility(8);
        this.eyS.setVisibility(0);
        this.eyP.setVisibility(8);
        this.eza.setVisibility(8);
        this.eyV.setVisibility(8);
        this.eyY.setVisibility(8);
        this.eyZ.cancelAnimation();
        this.eyZ.setVisibility(8);
        if (cardPersonDynamicThreadData.eBB == 36) {
            this.exO.setVisibility(8);
        } else if (cardPersonDynamicThreadData.eBB == 40 || this.eyt.eBB == 50) {
            this.exO.setVisibility(8);
            if (com.baidu.tbadk.core.i.abb().abf()) {
                this.eyP.setVisibility(0);
                this.eyR.setVisibility(0);
                this.eyR.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eyP.getLayoutParams();
                int width = this.eyP.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eyP.setLayoutParams(layoutParams);
                if (this.eyt.videoInfo != null) {
                    this.eyQ.setDefaultErrorResource(0);
                    this.eyQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eyQ.setEvent(this.cIx);
                    this.eyQ.startLoad(this.eyt.videoInfo.thumbnail_url, 17, false);
                    if (this.ezf) {
                        this.eza.setVisibility(0);
                        this.eza.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.eyV.setVisibility(0);
                        this.eyW.setText(ap.im(this.eyt.videoInfo.video_duration.intValue() * 1000));
                        this.eyX.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.eyt.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eyt.eBB == 60 || this.eyt.eBB == 49) {
            this.exO.setVisibility(8);
            if (this.eyt.threadData.adO() != null && this.eyt.threadData.adO().user_info != null && this.eyt.eBB == 60) {
                String str = this.eyt.threadData.adO().user_info.user_name;
                if (com.baidu.tbadk.util.ab.qW(str) > 14) {
                    str = com.baidu.tbadk.util.ab.ad(str, 14) + "...";
                }
                this.eyT.setText(n.cF(str + ":", this.eyt.threadData.getTitle()));
                this.eyT.setVisibility(0);
            } else {
                this.eyT.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.abb().abf()) {
                this.eyP.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eyP.getLayoutParams();
                int width2 = this.eyP.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eyP.setLayoutParams(layoutParams2);
                if (this.eyt.threadData.adO() != null) {
                    this.eyQ.setDefaultErrorResource(0);
                    this.eyQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eyQ.setEvent(this.cIx);
                    this.eyQ.startLoad(cardPersonDynamicThreadData.threadData.adO().cover, 10, false);
                    this.eyR.setVisibility(8);
                    this.eyZ.setVisibility(0);
                    this.eyZ.bo();
                    al.k(this.eyS, R.color.cp_bg_line_e);
                    this.eyY.setVisibility(0);
                    this.eyY.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), ap.aN(this.eyt.threadData.adO().audience_count)));
                    this.dBS.getCommentContainer().setOnClickListener(this.exT);
                } else {
                    this.dBS.getCommentContainer().setOnClickListener(this.dBS);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.abb().abf() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bg bgVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.Z(linkedList) > 0) {
                    this.exO.setVisibility(0);
                    this.exO.setFromCDN(this.XI);
                    this.exO.setSingleImageRatio(0.67d);
                    this.exO.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.aoV();
                            } else {
                                r.this.a(view, linkedList, i2, bgVar);
                            }
                        }
                    });
                    this.exO.setImageMediaList(linkedList);
                } else {
                    this.exO.setVisibility(8);
                }
            } else {
                this.exO.setVisibility(8);
            }
            this.eyS.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bKQ != null) {
            this.ezc.setVisibility(0);
            this.ezc.b(cardPersonDynamicThreadData.threadData.bKQ);
            this.ezc.setOnClickListener(this);
            this.XR.setVisibility(8);
            this.exO.setVisibility(8);
            this.eyS.setVisibility(8);
            if (this.ezg) {
                this.ezb.setVisibility(0);
            } else {
                this.ezb.setVisibility(8);
            }
        } else {
            this.ezc.setVisibility(8);
            this.ezb.setVisibility(8);
        }
        aXJ();
        c(cardPersonDynamicThreadData);
    }

    private void it(boolean z) {
        if (this.exO != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exO.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.exO.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ezf || this.ezg) {
                this.dBS.setCommentClickable(false);
                this.dBS.setAgreeClickable(false);
                this.dBS.setShareClickable(false);
                this.ezc.setClickable(false);
                this.eyN.setClickable(false);
            } else {
                this.dBS.setCommentClickable(true);
                this.dBS.setAgreeClickable(true);
                this.dBS.setShareClickable(true);
                this.ezc.setClickable(true);
                this.eyN.setClickable(true);
            }
            this.dBS.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.eBB == 60) {
                this.dBS.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.eBL != null) {
                this.dBS.setMultiForumCount(cardPersonDynamicThreadData.eBL.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.dBS.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.dBS.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aXJ() {
        this.XR.setClickable(true);
        int childCount = this.exO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.exO.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aXM() {
        if (this.eyt != null && this.eyt.threadData != null && this.eyt.threadData.adO() != null) {
            if (!com.baidu.adp.lib.util.j.jS()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.uR(this.eyt.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eyt.threadData.adO());
            if (this.eyt.threadData.adO().user_info != null) {
                alaLiveInfoCoreData.userName = this.eyt.threadData.adO().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXN() {
        if (this.eyt != null && this.eyt.threadData != null && this.eyt.threadData.adO() != null && this.eyt.threadData.adO().share_info != null) {
            if (!isHost()) {
                n.uR(this.eyt.threadId);
            }
            if (this.eyt.threadData.adO().share_info.record_tid <= 0) {
                aXM();
                return;
            }
            String valueOf = String.valueOf(this.eyt.threadData.adO().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoV() {
        if (this.eyt != null) {
            if (!isHost()) {
                n.uR(this.eyt.threadId);
                n.a(this.mTitle, this.eyt.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VB, this.eyt.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eyt.eBB == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eyt.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eyt.threadData.getFid()));
            pbActivityConfig.setForumName(this.eyt.threadData.adA());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eyt.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eyt.threadData == null || !this.eyt.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").bT("obj_type", "2").bT("tid", this.eyt.threadId).P("obj_param1", this.eyt.isHost ? 1 : 2));
        }
    }

    private void aXO() {
        if (this.eyt != null && this.eyt.threadData != null && this.eyt.threadData.bKQ != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eyt.threadData.bKQ.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").bT("obj_type", "3").bT("tid", this.eyt.threadId).P("obj_param1", this.eyt.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu(boolean z) {
        if (this.eyM != null) {
            if (z) {
                this.eyM.setText(R.string.privacy);
                Drawable drawable = al.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eyM.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eyM.setText(R.string.public_open);
            Drawable drawable2 = al.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eyM.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eyt.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ezc) {
            aXO();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exO != null) {
            this.exO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exO != null) {
            this.exO.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.XI ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bgVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.adA(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.XI, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.ezf);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(c));
        this.mTitle.setText(c);
        if (isHost()) {
            return true;
        }
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
