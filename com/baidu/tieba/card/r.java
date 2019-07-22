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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private TextView VW;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private TbImageView.a cJR;
    public NewThreadCommentAndPraiseInfoLayout dFn;
    private ConstrainImageGroup eCM;
    private View.OnClickListener eCR;
    private final View.OnClickListener eCS;
    private CustomMessageListener eCg;
    public ThreadViewAndCommentInfoLayout eDB;
    private final String eDC;
    private final String eDD;
    private TextView eDE;
    private LinearLayout eDF;
    private TextView eDG;
    private TextView eDH;
    private TextView eDI;
    private TextView eDJ;
    private ImageView eDK;
    private q eDL;
    private View eDM;
    private TbImageView eDN;
    private ImageView eDO;
    private LinearLayout eDP;
    private TextView eDQ;
    private LinearLayout eDR;
    private LinearLayout eDS;
    private TextView eDT;
    private TextView eDU;
    private TextView eDV;
    private TBLottieAnimationView eDW;
    private TextView eDX;
    private TextView eDY;
    public OriginalThreadCardView eDZ;
    private CardPersonDynamicThreadData eDq;
    private View eEa;
    private View eEb;
    private boolean eEc;
    private boolean eEd;
    com.baidu.tieba.view.h eEe;
    private q.a eEf;
    private final View.OnClickListener eEg;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eDC = "1";
        this.eDD = "2";
        this.mSkinType = 3;
        this.Yd = true;
        this.eEe = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eDq != null && !StringUtils.isNull(r.this.eDq.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eDq.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.eCR = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZo() != null) {
                    r.this.aZo().a(view, r.this.eDq);
                }
                if (r.this.eDq.eGx != 60) {
                    if ((r.this.eDq.eGx != 40 || r.this.eDq.eGz != 2) && !r.this.eEd) {
                        r.this.aqb();
                        return;
                    } else {
                        BdToast.c(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_toast_game_error).agQ();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eDq.threadData.aeQ().live_status != 1) {
                    r.this.aZL();
                } else {
                    r.this.aZK();
                }
            }
        };
        this.eCg = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eDq != null && r.this.eDq.threadId != null && r.this.mTitle != null && r.this.VW != null && ((String) customResponsedMessage.getData()).equals(r.this.eDq.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eDq.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.VW, r.this.eDq.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.eEf = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.iD(z);
            }
        };
        this.eEg = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZo = r.this.aZo();
                if (aZo != null) {
                    view.setTag("1");
                    aZo.a(view, r.this.eDq);
                }
                r.this.aqb();
            }
        };
        this.eCS = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZo = r.this.aZo();
                if (aZo != null) {
                    view.setTag("2");
                    aZo.a(view, r.this.eDq);
                }
            }
        };
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && r.this.eDN != null) {
                    r.this.eDN.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eDE = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.eDF = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.eDG = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.eDH = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.eDI = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.eDY = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.eDJ = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.eDK = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.Ym = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eCS);
        this.VW = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.VW.setVisibility(8);
        this.eCM = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.eCM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eCM.setChildClickListener(this.eEg);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.eCM.setImageProcessor(aVar);
        this.eDM = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.eDN = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.eDO = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.eDB = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.eDS = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.eDT = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.eDU = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.eDV = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.eDW = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eDW.y(true);
        am.a(this.eDW, (int) R.raw.ala_play);
        this.eDX = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.eDP = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.eDQ = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.eDR = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.eDR.setVisibility(8);
        this.eDZ = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.eEa = this.mRootView.findViewById(R.id.divider_line_thick);
        this.eEb = this.mRootView.findViewById(R.id.divider_line_thin);
        this.dFn = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.dFn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFn.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dFn.setLayoutParams(layoutParams);
        }
        this.dFn.setOnClickListener(this.eCR);
        this.dFn.setReplyTimeVisible(false);
        this.dFn.setShowPraiseNum(true);
        this.dFn.setNeedAddPraiseIcon(true);
        this.dFn.setNeedAddReplyIcon(true);
        this.dFn.setShareVisible(true);
        this.dFn.setIsBarViewVisible(false);
        this.dFn.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFz = 8;
        dVar.bFE = 3;
        this.dFn.setAgreeStatisticData(dVar);
        this.dFn.setShareReportFrom(6);
        this.dFn.setStType("person_page");
        this.dFn.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZo() != null) {
                    r.this.aZo().a(view, r.this.eDq);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.eDW, (int) R.raw.ala_play);
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.j(this.eDE, R.color.cp_cont_b);
            am.j(this.eDG, R.color.cp_cont_j);
            am.j(this.eDH, R.color.cp_cont_b);
            am.j(this.eDI, R.color.cp_cont_d);
            am.j(this.eDY, R.color.cp_cont_d);
            am.j(this.eDJ, R.color.cp_cont_d);
            if (this.eDK != null) {
                this.eDK.setImageDrawable(am.getDrawable(R.drawable.icon_card_more));
            }
            am.j(this.mTitle, R.color.cp_cont_b);
            am.j(this.VW, R.color.cp_cont_f);
            am.j(this.eDQ, R.color.cp_cont_f);
            if (this.eDL != null) {
                this.eDL.onChangeSkinType();
            }
            this.eDB.onChangeSkinType();
            this.dFn.onChangeSkinType();
            am.l(this.eEa, R.color.cp_bg_line_e);
            am.l(this.eEb, R.color.cp_bg_line_c);
            am.l(this.eDQ, R.color.cp_bg_line_e);
            if (this.eDZ != null) {
                this.eDZ.onChangeSkinType();
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
        this.eDq = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCR);
        }
        this.eDE.setVisibility(cardPersonDynamicThreadData.eGJ ? 0 : 8);
        this.eDF.setVisibility(cardPersonDynamicThreadData.eGI ? 0 : 4);
        this.eEa.setVisibility(cardPersonDynamicThreadData.eGI ? 0 : 8);
        this.eEb.setVisibility(cardPersonDynamicThreadData.eGI ? 8 : 0);
        if (cardPersonDynamicThreadData.eGK) {
            this.eEa.setVisibility(8);
            this.eEb.setVisibility(8);
        }
        this.eEc = cardPersonDynamicThreadData.eGx == 40 && cardPersonDynamicThreadData.eGz == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.eEd = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.eGz == 2;
        }
        this.eDE.setText(cardPersonDynamicThreadData.eGA);
        this.eDG.setText(cardPersonDynamicThreadData.eGB);
        this.eDH.setText(cardPersonDynamicThreadData.eGC);
        if (cardPersonDynamicThreadData.eGH != null && cardPersonDynamicThreadData.eGH.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.eGH.length; i++) {
                sb.append(aq.j(cardPersonDynamicThreadData.eGH[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.eGH.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eDI.setText(sb2);
                this.eDI.setVisibility(0);
            } else {
                this.eDI.setText(R.string.person_homepage);
            }
        } else {
            this.eDI.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eDJ.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eDJ.setVisibility(0);
            }
            iD(cardPersonDynamicThreadData.isPrivacy);
            this.eDK.setVisibility(0);
            this.eDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eDL == null) {
                            r.this.eDL = new q(r.this.mPageContext);
                            r.this.eDL.create();
                            r.this.eDL.a(r.this.eEf);
                        }
                        r.this.eDL.a(r.this.eDq);
                        r.this.eDL.show();
                    }
                }
            });
        } else {
            this.eDJ.setVisibility(8);
            this.eDK.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.eGF;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.Ym.setVisibility(0);
            iC(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIl();
            if (voiceModel != null) {
                this.Ym.vY(voiceModel.voice_status.intValue());
            }
            this.Ym.cqz();
        } else {
            this.Ym.setVisibility(8);
            iC(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.eGE;
        am.k(this.eDP, R.color.transparent);
        this.eDQ.setVisibility(8);
        this.eDR.setVisibility(8);
        this.eDP.setVisibility(0);
        this.eDM.setVisibility(8);
        this.eDX.setVisibility(8);
        this.eDS.setVisibility(8);
        this.eDV.setVisibility(8);
        this.eDW.cancelAnimation();
        this.eDW.setVisibility(8);
        if (cardPersonDynamicThreadData.eGx == 36) {
            this.eCM.setVisibility(8);
        } else if (cardPersonDynamicThreadData.eGx == 40 || this.eDq.eGx == 50) {
            this.eCM.setVisibility(8);
            if (com.baidu.tbadk.core.i.aca().ace()) {
                this.eDM.setVisibility(0);
                this.eDO.setVisibility(0);
                this.eDO.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDM.getLayoutParams();
                int width = this.eDM.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eDM.setLayoutParams(layoutParams);
                if (this.eDq.videoInfo != null) {
                    this.eDN.setDefaultErrorResource(0);
                    this.eDN.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eDN.setEvent(this.cJR);
                    this.eDN.startLoad(this.eDq.videoInfo.thumbnail_url, 17, false);
                    if (this.eEc) {
                        this.eDX.setVisibility(0);
                        this.eDX.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.eDS.setVisibility(0);
                        this.eDT.setText(aq.is(this.eDq.videoInfo.video_duration.intValue() * 1000));
                        this.eDU.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eDq.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eDq.eGx == 60 || this.eDq.eGx == 49) {
            this.eCM.setVisibility(8);
            if (this.eDq.threadData.aeQ() != null && this.eDq.threadData.aeQ().user_info != null && this.eDq.eGx == 60) {
                String str = this.eDq.threadData.aeQ().user_info.user_name;
                if (com.baidu.tbadk.util.ab.ro(str) > 14) {
                    str = com.baidu.tbadk.util.ab.ad(str, 14) + "...";
                }
                this.eDQ.setText(n.cG(str + ":", this.eDq.threadData.getTitle()));
                this.eDQ.setVisibility(0);
            } else {
                this.eDQ.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.aca().ace()) {
                this.eDM.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eDM.getLayoutParams();
                int width2 = this.eDM.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eDM.setLayoutParams(layoutParams2);
                if (this.eDq.threadData.aeQ() != null) {
                    this.eDN.setDefaultErrorResource(0);
                    this.eDN.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eDN.setEvent(this.cJR);
                    this.eDN.startLoad(cardPersonDynamicThreadData.threadData.aeQ().cover, 10, false);
                    this.eDO.setVisibility(8);
                    this.eDW.setVisibility(0);
                    this.eDW.br();
                    am.k(this.eDP, R.color.cp_bg_line_e);
                    this.eDV.setVisibility(0);
                    this.eDV.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.eDq.threadData.aeQ().audience_count)));
                    this.dFn.getCommentContainer().setOnClickListener(this.eCR);
                } else {
                    this.dFn.getCommentContainer().setOnClickListener(this.dFn);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.aca().ace() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bg bgVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.Z(linkedList) > 0) {
                    this.eCM.setVisibility(0);
                    this.eCM.setFromCDN(this.Yd);
                    this.eCM.setSingleImageRatio(0.67d);
                    this.eCM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.aqb();
                            } else {
                                r.this.a(view, linkedList, i2, bgVar);
                            }
                        }
                    });
                    this.eCM.setImageMediaList(linkedList);
                } else {
                    this.eCM.setVisibility(8);
                }
            } else {
                this.eCM.setVisibility(8);
            }
            this.eDP.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bLQ != null) {
            this.eDZ.setVisibility(0);
            this.eDZ.b(cardPersonDynamicThreadData.threadData.bLQ);
            this.eDZ.setOnClickListener(this);
            this.Ym.setVisibility(8);
            this.eCM.setVisibility(8);
            this.eDP.setVisibility(8);
            if (this.eEd) {
                this.eDY.setVisibility(0);
            } else {
                this.eDY.setVisibility(8);
            }
        } else {
            this.eDZ.setVisibility(8);
            this.eDY.setVisibility(8);
        }
        aZH();
        c(cardPersonDynamicThreadData);
    }

    private void iC(boolean z) {
        if (this.eCM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCM.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.eCM.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.eEc || this.eEd) {
                this.dFn.setCommentClickable(false);
                this.dFn.setAgreeClickable(false);
                this.dFn.setShareClickable(false);
                this.eDZ.setClickable(false);
                this.eDK.setClickable(false);
            } else {
                this.dFn.setCommentClickable(true);
                this.dFn.setAgreeClickable(true);
                this.dFn.setShareClickable(true);
                this.eDZ.setClickable(true);
                this.eDK.setClickable(true);
            }
            this.dFn.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.eGx == 60) {
                this.dFn.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.eGH != null) {
                this.dFn.setMultiForumCount(cardPersonDynamicThreadData.eGH.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.dFn.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.dFn.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aZH() {
        this.Ym.setClickable(true);
        int childCount = this.eCM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eCM.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aZK() {
        if (this.eDq != null && this.eDq.threadData != null && this.eDq.threadData.aeQ() != null) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.vw(this.eDq.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eDq.threadData.aeQ());
            if (this.eDq.threadData.aeQ().user_info != null) {
                alaLiveInfoCoreData.userName = this.eDq.threadData.aeQ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZL() {
        if (this.eDq != null && this.eDq.threadData != null && this.eDq.threadData.aeQ() != null && this.eDq.threadData.aeQ().share_info != null) {
            if (!isHost()) {
                n.vw(this.eDq.threadId);
            }
            if (this.eDq.threadData.aeQ().share_info.record_tid <= 0) {
                aZK();
                return;
            }
            String valueOf = String.valueOf(this.eDq.threadData.aeQ().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqb() {
        if (this.eDq != null) {
            if (!isHost()) {
                n.vw(this.eDq.threadId);
                n.a(this.mTitle, this.eDq.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VW, this.eDq.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eDq.eGx == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eDq.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eDq.threadData.getFid()));
            pbActivityConfig.setForumName(this.eDq.threadData.aeC());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eDq.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eDq.threadData == null || !this.eDq.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").bT("obj_type", "2").bT("tid", this.eDq.threadId).P("obj_param1", this.eDq.isHost ? 1 : 2));
        }
    }

    private void aZM() {
        if (this.eDq != null && this.eDq.threadData != null && this.eDq.threadData.bLQ != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eDq.threadData.bLQ.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").bT("obj_type", "3").bT("tid", this.eDq.threadId).P("obj_param1", this.eDq.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(boolean z) {
        if (this.eDJ != null) {
            if (z) {
                this.eDJ.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eDJ.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eDJ.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eDJ.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eDq.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eDZ) {
            aZM();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCM != null) {
            this.eCM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCM != null) {
            this.eCM.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.Yd ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.aeC(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.eEc);
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
