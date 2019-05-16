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
    private TextView VC;
    private boolean XJ;
    public PlayVoiceBntNew XS;
    private TbImageView.a cIw;
    public NewThreadCommentAndPraiseInfoLayout dBR;
    private ConstrainImageGroup exN;
    private View.OnClickListener exS;
    private final View.OnClickListener exT;
    private CustomMessageListener exg;
    public ThreadViewAndCommentInfoLayout eyD;
    private final String eyE;
    private final String eyF;
    private TextView eyG;
    private LinearLayout eyH;
    private TextView eyI;
    private TextView eyJ;
    private TextView eyK;
    private TextView eyL;
    private ImageView eyM;
    private q eyN;
    private View eyO;
    private TbImageView eyP;
    private ImageView eyQ;
    private LinearLayout eyR;
    private TextView eyS;
    private LinearLayout eyT;
    private LinearLayout eyU;
    private TextView eyV;
    private TextView eyW;
    private TextView eyX;
    private TBLottieAnimationView eyY;
    private TextView eyZ;
    private CardPersonDynamicThreadData eys;
    private TextView eza;
    public OriginalThreadCardView ezb;
    private View ezc;
    private View ezd;
    private boolean eze;
    private boolean ezf;
    com.baidu.tieba.view.h ezg;
    private q.a ezh;
    private final View.OnClickListener ezi;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eyE = "1";
        this.eyF = "2";
        this.mSkinType = 3;
        this.XJ = true;
        this.ezg = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eys != null && !StringUtils.isNull(r.this.eys.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eys.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.exS = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aXo() != null) {
                    r.this.aXo().a(view, r.this.eys);
                }
                if (r.this.eys.eBA != 60) {
                    if ((r.this.eys.eBA != 40 || r.this.eys.eBC != 2) && !r.this.ezf) {
                        r.this.aoV();
                        return;
                    } else {
                        BdToast.c(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_toast_game_error).afO();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eys.threadData.adO().live_status != 1) {
                    r.this.aXK();
                } else {
                    r.this.aXJ();
                }
            }
        };
        this.exg = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eys != null && r.this.eys.threadId != null && r.this.mTitle != null && r.this.VC != null && ((String) customResponsedMessage.getData()).equals(r.this.eys.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eys.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.VC, r.this.eys.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.ezh = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.iu(z);
            }
        };
        this.ezi = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aXo = r.this.aXo();
                if (aXo != null) {
                    view.setTag("1");
                    aXo.a(view, r.this.eys);
                }
                r.this.aoV();
            }
        };
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aXo = r.this.aXo();
                if (aXo != null) {
                    view.setTag("2");
                    aXo.a(view, r.this.eys);
                }
            }
        };
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && r.this.eyP != null) {
                    r.this.eyP.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eyG = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.eyH = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.eyI = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.eyJ = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.eyK = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.eza = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.eyL = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.eyM = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.XS = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.XS.setAfterClickListener(this.exT);
        this.VC = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.VC.setVisibility(8);
        this.exN = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.exN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.exN.setChildClickListener(this.ezi);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.exN.setImageProcessor(aVar);
        this.eyO = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.eyP = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.eyQ = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.eyD = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.eyU = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.eyV = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.eyW = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.eyX = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.eyY = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eyY.y(true);
        al.a(this.eyY, (int) R.raw.ala_play);
        this.eyZ = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.eyR = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.eyS = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.eyT = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.eyT.setVisibility(8);
        this.ezb = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.ezc = this.mRootView.findViewById(R.id.divider_line_thick);
        this.ezd = this.mRootView.findViewById(R.id.divider_line_thin);
        this.dBR = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.dBR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBR.setLayoutParams(layoutParams);
        }
        this.dBR.setOnClickListener(this.exS);
        this.dBR.setReplyTimeVisible(false);
        this.dBR.setShowPraiseNum(true);
        this.dBR.setNeedAddPraiseIcon(true);
        this.dBR.setNeedAddReplyIcon(true);
        this.dBR.setShareVisible(true);
        this.dBR.setIsBarViewVisible(false);
        this.dBR.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEy = 8;
        dVar.bED = 3;
        this.dBR.setAgreeStatisticData(dVar);
        this.dBR.setShareReportFrom(6);
        this.dBR.setStType("person_page");
        this.dBR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aXo() != null) {
                    r.this.aXo().a(view, r.this.eys);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.a(this.eyY, (int) R.raw.ala_play);
            al.k(getView(), R.drawable.home_thread_card_item_bg);
            al.j(this.eyG, R.color.cp_cont_b);
            al.j(this.eyI, R.color.cp_cont_j);
            al.j(this.eyJ, R.color.cp_cont_b);
            al.j(this.eyK, R.color.cp_cont_d);
            al.j(this.eza, R.color.cp_cont_d);
            al.j(this.eyL, R.color.cp_cont_d);
            if (this.eyM != null) {
                this.eyM.setImageDrawable(al.getDrawable(R.drawable.icon_card_more));
            }
            al.j(this.mTitle, R.color.cp_cont_b);
            al.j(this.VC, R.color.cp_cont_f);
            al.j(this.eyS, R.color.cp_cont_f);
            if (this.eyN != null) {
                this.eyN.onChangeSkinType();
            }
            this.eyD.onChangeSkinType();
            this.dBR.onChangeSkinType();
            al.l(this.ezc, R.color.cp_bg_line_e);
            al.l(this.ezd, R.color.cp_bg_line_c);
            al.l(this.eyS, R.color.cp_bg_line_e);
            if (this.ezb != null) {
                this.ezb.onChangeSkinType();
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
        this.eys = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.exS);
        }
        this.eyG.setVisibility(cardPersonDynamicThreadData.eBM ? 0 : 8);
        this.eyH.setVisibility(cardPersonDynamicThreadData.eBL ? 0 : 4);
        this.ezc.setVisibility(cardPersonDynamicThreadData.eBL ? 0 : 8);
        this.ezd.setVisibility(cardPersonDynamicThreadData.eBL ? 8 : 0);
        if (cardPersonDynamicThreadData.eBN) {
            this.ezc.setVisibility(8);
            this.ezd.setVisibility(8);
        }
        this.eze = cardPersonDynamicThreadData.eBA == 40 && cardPersonDynamicThreadData.eBC == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ezf = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.eBC == 2;
        }
        this.eyG.setText(cardPersonDynamicThreadData.eBD);
        this.eyI.setText(cardPersonDynamicThreadData.eBE);
        this.eyJ.setText(cardPersonDynamicThreadData.eBF);
        if (cardPersonDynamicThreadData.eBK != null && cardPersonDynamicThreadData.eBK.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.eBK.length; i++) {
                sb.append(ap.j(cardPersonDynamicThreadData.eBK[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.eBK.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eyK.setText(sb2);
                this.eyK.setVisibility(0);
            } else {
                this.eyK.setText(R.string.person_homepage);
            }
        } else {
            this.eyK.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eyL.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eyL.setVisibility(0);
            }
            iu(cardPersonDynamicThreadData.isPrivacy);
            this.eyM.setVisibility(0);
            this.eyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eyN == null) {
                            r.this.eyN = new q(r.this.mPageContext);
                            r.this.eyN.create();
                            r.this.eyN.a(r.this.ezh);
                        }
                        r.this.eyN.a(r.this.eys);
                        r.this.eyN.show();
                    }
                }
            });
        } else {
            this.eyL.setVisibility(8);
            this.eyM.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.eBI;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.XS.setVisibility(0);
            it(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.XS.setVoiceModel(voiceModel);
            this.XS.setTag(voiceModel);
            this.XS.bFA();
            if (voiceModel != null) {
                this.XS.vx(voiceModel.voice_status.intValue());
            }
            this.XS.cnD();
        } else {
            this.XS.setVisibility(8);
            it(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.eBH;
        al.k(this.eyR, R.color.transparent);
        this.eyS.setVisibility(8);
        this.eyT.setVisibility(8);
        this.eyR.setVisibility(0);
        this.eyO.setVisibility(8);
        this.eyZ.setVisibility(8);
        this.eyU.setVisibility(8);
        this.eyX.setVisibility(8);
        this.eyY.cancelAnimation();
        this.eyY.setVisibility(8);
        if (cardPersonDynamicThreadData.eBA == 36) {
            this.exN.setVisibility(8);
        } else if (cardPersonDynamicThreadData.eBA == 40 || this.eys.eBA == 50) {
            this.exN.setVisibility(8);
            if (com.baidu.tbadk.core.i.abb().abf()) {
                this.eyO.setVisibility(0);
                this.eyQ.setVisibility(0);
                this.eyQ.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eyO.getLayoutParams();
                int width = this.eyO.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eyO.setLayoutParams(layoutParams);
                if (this.eys.videoInfo != null) {
                    this.eyP.setDefaultErrorResource(0);
                    this.eyP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eyP.setEvent(this.cIw);
                    this.eyP.startLoad(this.eys.videoInfo.thumbnail_url, 17, false);
                    if (this.eze) {
                        this.eyZ.setVisibility(0);
                        this.eyZ.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.eyU.setVisibility(0);
                        this.eyV.setText(ap.im(this.eys.videoInfo.video_duration.intValue() * 1000));
                        this.eyW.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.eys.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eys.eBA == 60 || this.eys.eBA == 49) {
            this.exN.setVisibility(8);
            if (this.eys.threadData.adO() != null && this.eys.threadData.adO().user_info != null && this.eys.eBA == 60) {
                String str = this.eys.threadData.adO().user_info.user_name;
                if (com.baidu.tbadk.util.ab.qX(str) > 14) {
                    str = com.baidu.tbadk.util.ab.ad(str, 14) + "...";
                }
                this.eyS.setText(n.cF(str + ":", this.eys.threadData.getTitle()));
                this.eyS.setVisibility(0);
            } else {
                this.eyS.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.abb().abf()) {
                this.eyO.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eyO.getLayoutParams();
                int width2 = this.eyO.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eyO.setLayoutParams(layoutParams2);
                if (this.eys.threadData.adO() != null) {
                    this.eyP.setDefaultErrorResource(0);
                    this.eyP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eyP.setEvent(this.cIw);
                    this.eyP.startLoad(cardPersonDynamicThreadData.threadData.adO().cover, 10, false);
                    this.eyQ.setVisibility(8);
                    this.eyY.setVisibility(0);
                    this.eyY.bo();
                    al.k(this.eyR, R.color.cp_bg_line_e);
                    this.eyX.setVisibility(0);
                    this.eyX.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), ap.aN(this.eys.threadData.adO().audience_count)));
                    this.dBR.getCommentContainer().setOnClickListener(this.exS);
                } else {
                    this.dBR.getCommentContainer().setOnClickListener(this.dBR);
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
                    this.exN.setVisibility(0);
                    this.exN.setFromCDN(this.XJ);
                    this.exN.setSingleImageRatio(0.67d);
                    this.exN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.aoV();
                            } else {
                                r.this.a(view, linkedList, i2, bgVar);
                            }
                        }
                    });
                    this.exN.setImageMediaList(linkedList);
                } else {
                    this.exN.setVisibility(8);
                }
            } else {
                this.exN.setVisibility(8);
            }
            this.eyR.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bKP != null) {
            this.ezb.setVisibility(0);
            this.ezb.b(cardPersonDynamicThreadData.threadData.bKP);
            this.ezb.setOnClickListener(this);
            this.XS.setVisibility(8);
            this.exN.setVisibility(8);
            this.eyR.setVisibility(8);
            if (this.ezf) {
                this.eza.setVisibility(0);
            } else {
                this.eza.setVisibility(8);
            }
        } else {
            this.ezb.setVisibility(8);
            this.eza.setVisibility(8);
        }
        aXG();
        c(cardPersonDynamicThreadData);
    }

    private void it(boolean z) {
        if (this.exN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exN.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.exN.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.eze || this.ezf) {
                this.dBR.setCommentClickable(false);
                this.dBR.setAgreeClickable(false);
                this.dBR.setShareClickable(false);
                this.ezb.setClickable(false);
                this.eyM.setClickable(false);
            } else {
                this.dBR.setCommentClickable(true);
                this.dBR.setAgreeClickable(true);
                this.dBR.setShareClickable(true);
                this.ezb.setClickable(true);
                this.eyM.setClickable(true);
            }
            this.dBR.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.eBA == 60) {
                this.dBR.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.eBK != null) {
                this.dBR.setMultiForumCount(cardPersonDynamicThreadData.eBK.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.dBR.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.dBR.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aXG() {
        this.XS.setClickable(true);
        int childCount = this.exN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.exN.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aXJ() {
        if (this.eys != null && this.eys.threadData != null && this.eys.threadData.adO() != null) {
            if (!com.baidu.adp.lib.util.j.jS()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.uS(this.eys.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eys.threadData.adO());
            if (this.eys.threadData.adO().user_info != null) {
                alaLiveInfoCoreData.userName = this.eys.threadData.adO().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXK() {
        if (this.eys != null && this.eys.threadData != null && this.eys.threadData.adO() != null && this.eys.threadData.adO().share_info != null) {
            if (!isHost()) {
                n.uS(this.eys.threadId);
            }
            if (this.eys.threadData.adO().share_info.record_tid <= 0) {
                aXJ();
                return;
            }
            String valueOf = String.valueOf(this.eys.threadData.adO().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoV() {
        if (this.eys != null) {
            if (!isHost()) {
                n.uS(this.eys.threadId);
                n.a(this.mTitle, this.eys.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VC, this.eys.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eys.eBA == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eys.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eys.threadData.getFid()));
            pbActivityConfig.setForumName(this.eys.threadData.adA());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eys.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eys.threadData == null || !this.eys.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").bT("obj_type", "2").bT("tid", this.eys.threadId).P("obj_param1", this.eys.isHost ? 1 : 2));
        }
    }

    private void aXL() {
        if (this.eys != null && this.eys.threadData != null && this.eys.threadData.bKP != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eys.threadData.bKP.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").bT("obj_type", "3").bT("tid", this.eys.threadId).P("obj_param1", this.eys.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu(boolean z) {
        if (this.eyL != null) {
            if (z) {
                this.eyL.setText(R.string.privacy);
                Drawable drawable = al.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eyL.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eyL.setText(R.string.public_open);
            Drawable drawable2 = al.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eyL.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eys.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ezb) {
            aXL();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exN != null) {
            this.exN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exN != null) {
            this.exN.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.XJ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.adA(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.XJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.eze);
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
