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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
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
    private TextView VV;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private TbImageView.a cKO;
    public NewThreadCommentAndPraiseInfoLayout dHf;
    private CustomMessageListener eDW;
    private ConstrainImageGroup eEC;
    private View.OnClickListener eEH;
    private final View.OnClickListener eEI;
    private ImageView eFA;
    private q eFB;
    private View eFC;
    private TbImageView eFD;
    private ImageView eFE;
    private LinearLayout eFF;
    private TextView eFG;
    private LinearLayout eFH;
    private LinearLayout eFI;
    private TextView eFJ;
    private TextView eFK;
    private TextView eFL;
    private TBLottieAnimationView eFM;
    private TextView eFN;
    private TextView eFO;
    public OriginalThreadCardView eFP;
    private View eFQ;
    private View eFR;
    private boolean eFS;
    private boolean eFT;
    com.baidu.tieba.view.h eFU;
    private q.a eFV;
    private final View.OnClickListener eFW;
    private CardPersonDynamicThreadData eFg;
    public ThreadViewAndCommentInfoLayout eFr;
    private final String eFs;
    private final String eFt;
    private TextView eFu;
    private LinearLayout eFv;
    private TextView eFw;
    private TextView eFx;
    private TextView eFy;
    private TextView eFz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eFs = "1";
        this.eFt = "2";
        this.mSkinType = 3;
        this.Yd = true;
        this.eFU = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eFg != null && !StringUtils.isNull(r.this.eFg.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eFg.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.eEH = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZU() != null) {
                    r.this.aZU().a(view, r.this.eFg);
                }
                if (r.this.eFg.eIn != 60) {
                    if ((r.this.eFg.eIn != 40 || r.this.eFg.eIp != 2) && !r.this.eFT) {
                        r.this.aqp();
                        return;
                    } else {
                        BdToast.b(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake_n_svg, true).agW();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eFg.threadData.aeV().live_status != 1) {
                    r.this.bar();
                } else {
                    r.this.baq();
                }
            }
        };
        this.eDW = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eFg != null && r.this.eFg.threadId != null && r.this.mTitle != null && r.this.VV != null && ((String) customResponsedMessage.getData()).equals(r.this.eFg.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eFg.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.VV, r.this.eFg.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.eFV = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.iG(z);
            }
        };
        this.eFW = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZU = r.this.aZU();
                if (aZU != null) {
                    view.setTag("1");
                    aZU.a(view, r.this.eFg);
                }
                r.this.aqp();
            }
        };
        this.eEI = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZU = r.this.aZU();
                if (aZU != null) {
                    view.setTag("2");
                    aZU.a(view, r.this.eFg);
                }
            }
        };
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && r.this.eFD != null) {
                    r.this.eFD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eFu = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.eFv = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.eFw = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.eFx = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.eFy = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.eFO = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.eFz = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.eFA = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.Ym = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eEI);
        this.VV = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.VV.setVisibility(8);
        this.eEC = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.eEC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eEC.setChildClickListener(this.eFW);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.eEC.setImageProcessor(aVar);
        this.eFC = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.eFD = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.eFE = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.eFr = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.eFI = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.eFJ = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.eFK = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.eFL = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.eFM = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eFM.y(true);
        am.a(this.eFM, (int) R.raw.ala_play);
        this.eFN = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.eFF = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.eFG = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.eFH = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.eFH.setVisibility(8);
        this.eFP = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.eFQ = this.mRootView.findViewById(R.id.divider_line_thick);
        this.eFR = this.mRootView.findViewById(R.id.divider_line_thin);
        this.dHf = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.dHf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dHf.setLayoutParams(layoutParams);
        }
        this.dHf.setOnClickListener(this.eEH);
        this.dHf.setReplyTimeVisible(false);
        this.dHf.setShowPraiseNum(true);
        this.dHf.setNeedAddPraiseIcon(true);
        this.dHf.setNeedAddReplyIcon(true);
        this.dHf.setShareVisible(true);
        this.dHf.setIsBarViewVisible(false);
        this.dHf.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFY = 8;
        dVar.bGd = 3;
        this.dHf.setAgreeStatisticData(dVar);
        this.dHf.setShareReportFrom(6);
        this.dHf.setStType("person_page");
        this.dHf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZU() != null) {
                    r.this.aZU().a(view, r.this.eFg);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.eFM, (int) R.raw.ala_play);
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.j(this.eFu, R.color.cp_cont_b);
            am.j(this.eFw, R.color.cp_cont_j);
            am.j(this.eFx, R.color.cp_cont_b);
            am.j(this.eFy, R.color.cp_cont_d);
            am.j(this.eFO, R.color.cp_cont_d);
            am.j(this.eFz, R.color.cp_cont_d);
            if (this.eFA != null) {
                this.eFA.setImageDrawable(SvgManager.ajv().a(R.drawable.icon_pure_card_more_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.j(this.mTitle, R.color.cp_cont_b);
            am.j(this.VV, R.color.cp_cont_f);
            am.j(this.eFG, R.color.cp_cont_f);
            if (this.eFB != null) {
                this.eFB.onChangeSkinType();
            }
            this.eFr.onChangeSkinType();
            this.dHf.onChangeSkinType();
            am.l(this.eFQ, R.color.cp_bg_line_c);
            am.l(this.eFR, R.color.cp_bg_line_e);
            am.l(this.eFG, R.color.cp_bg_line_e);
            if (this.eFP != null) {
                this.eFP.onChangeSkinType();
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
        this.eFg = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eEH);
        }
        this.eFu.setVisibility(cardPersonDynamicThreadData.eIz ? 0 : 8);
        this.eFv.setVisibility(cardPersonDynamicThreadData.eIy ? 0 : 4);
        this.eFQ.setVisibility(cardPersonDynamicThreadData.eIy ? 0 : 8);
        this.eFR.setVisibility(cardPersonDynamicThreadData.eIy ? 8 : 0);
        if (cardPersonDynamicThreadData.eIA) {
            this.eFQ.setVisibility(8);
            this.eFR.setVisibility(8);
        }
        this.eFS = cardPersonDynamicThreadData.eIn == 40 && cardPersonDynamicThreadData.eIp == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.eFT = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.eIp == 2;
        }
        this.eFu.setText(cardPersonDynamicThreadData.eIq);
        this.eFw.setText(cardPersonDynamicThreadData.eIr);
        this.eFx.setText(cardPersonDynamicThreadData.eIs);
        if (cardPersonDynamicThreadData.eIx != null && cardPersonDynamicThreadData.eIx.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.eIx.length; i++) {
                sb.append(aq.j(cardPersonDynamicThreadData.eIx[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.eIx.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eFy.setText(sb2);
                this.eFy.setVisibility(0);
            } else {
                this.eFy.setText(R.string.person_homepage);
            }
        } else {
            this.eFy.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eFz.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eFz.setVisibility(0);
            }
            iG(cardPersonDynamicThreadData.isPrivacy);
            this.eFA.setVisibility(0);
            this.eFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eFB == null) {
                            r.this.eFB = new q(r.this.mPageContext);
                            r.this.eFB.create();
                            r.this.eFB.a(r.this.eFV);
                        }
                        r.this.eFB.a(r.this.eFg);
                        r.this.eFB.show();
                    }
                }
            });
        } else {
            this.eFz.setVisibility(8);
            this.eFA.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.eIv;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.Ym.setVisibility(0);
            iF(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bql();
            if (voiceModel != null) {
                this.Ym.we(voiceModel.voice_status.intValue());
            }
            this.Ym.crJ();
        } else {
            this.Ym.setVisibility(8);
            iF(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.eIu;
        am.k(this.eFF, R.color.transparent);
        this.eFG.setVisibility(8);
        this.eFH.setVisibility(8);
        this.eFF.setVisibility(0);
        this.eFC.setVisibility(8);
        this.eFN.setVisibility(8);
        this.eFI.setVisibility(8);
        this.eFL.setVisibility(8);
        this.eFM.cancelAnimation();
        this.eFM.setVisibility(8);
        if (cardPersonDynamicThreadData.eIn == 36) {
            this.eEC.setVisibility(8);
        } else if (cardPersonDynamicThreadData.eIn == 40 || this.eFg.eIn == 50) {
            this.eEC.setVisibility(8);
            if (com.baidu.tbadk.core.i.ace().aci()) {
                this.eFC.setVisibility(0);
                this.eFE.setVisibility(0);
                this.eFE.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFC.getLayoutParams();
                int width = this.eFC.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eFC.setLayoutParams(layoutParams);
                if (this.eFg.videoInfo != null) {
                    this.eFD.setDefaultErrorResource(0);
                    this.eFD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eFD.setEvent(this.cKO);
                    this.eFD.startLoad(this.eFg.videoInfo.thumbnail_url, 17, false);
                    if (this.eFS) {
                        this.eFN.setVisibility(0);
                        this.eFN.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.eFI.setVisibility(0);
                        this.eFJ.setText(aq.it(this.eFg.videoInfo.video_duration.intValue() * 1000));
                        this.eFK.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eFg.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eFg.eIn == 60 || this.eFg.eIn == 49) {
            this.eEC.setVisibility(8);
            if (this.eFg.threadData.aeV() != null && this.eFg.threadData.aeV().user_info != null && this.eFg.eIn == 60) {
                String str = this.eFg.threadData.aeV().user_info.user_name;
                if (com.baidu.tbadk.util.aa.rz(str) > 14) {
                    str = com.baidu.tbadk.util.aa.ad(str, 14) + "...";
                }
                this.eFG.setText(n.cH(str + ":", this.eFg.threadData.getTitle()));
                this.eFG.setVisibility(0);
            } else {
                this.eFG.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.ace().aci()) {
                this.eFC.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eFC.getLayoutParams();
                int width2 = this.eFC.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eFC.setLayoutParams(layoutParams2);
                if (this.eFg.threadData.aeV() != null) {
                    this.eFD.setDefaultErrorResource(0);
                    this.eFD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eFD.setEvent(this.cKO);
                    this.eFD.startLoad(cardPersonDynamicThreadData.threadData.aeV().cover, 10, false);
                    this.eFE.setVisibility(8);
                    this.eFM.setVisibility(0);
                    this.eFM.br();
                    am.k(this.eFF, R.color.cp_bg_line_e);
                    this.eFL.setVisibility(0);
                    this.eFL.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.eFg.threadData.aeV().audience_count)));
                    this.dHf.getCommentContainer().setOnClickListener(this.eEH);
                } else {
                    this.dHf.getCommentContainer().setOnClickListener(this.dHf);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.ace().aci() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.Z(linkedList) > 0) {
                    this.eEC.setVisibility(0);
                    this.eEC.setFromCDN(this.Yd);
                    this.eEC.setSingleImageRatio(0.67d);
                    this.eEC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.aqp();
                            } else {
                                r.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.eEC.setImageMediaList(linkedList);
                } else {
                    this.eEC.setVisibility(8);
                }
            } else {
                this.eEC.setVisibility(8);
            }
            this.eFF.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bMt != null) {
            this.eFP.setVisibility(0);
            this.eFP.b(cardPersonDynamicThreadData.threadData.bMt);
            this.eFP.setOnClickListener(this);
            this.Ym.setVisibility(8);
            this.eEC.setVisibility(8);
            this.eFF.setVisibility(8);
            if (this.eFT) {
                this.eFO.setVisibility(0);
            } else {
                this.eFO.setVisibility(8);
            }
        } else {
            this.eFP.setVisibility(8);
            this.eFO.setVisibility(8);
        }
        ban();
        c(cardPersonDynamicThreadData);
    }

    private void iF(boolean z) {
        if (this.eEC != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEC.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.eEC.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.eFS || this.eFT) {
                this.dHf.setCommentClickable(false);
                this.dHf.setAgreeClickable(false);
                this.dHf.setShareClickable(false);
                this.eFP.setClickable(false);
                this.eFA.setClickable(false);
            } else {
                this.dHf.setCommentClickable(true);
                this.dHf.setAgreeClickable(true);
                this.dHf.setShareClickable(true);
                this.eFP.setClickable(true);
                this.eFA.setClickable(true);
            }
            this.dHf.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.eIn == 60) {
                this.dHf.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.eIx != null) {
                this.dHf.setMultiForumCount(cardPersonDynamicThreadData.eIx.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.dHf.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.dHf.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void ban() {
        this.Ym.setClickable(true);
        int childCount = this.eEC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eEC.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void baq() {
        if (this.eFg != null && this.eFg.threadData != null && this.eFg.threadData.aeV() != null) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.vW(this.eFg.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eFg.threadData.aeV());
            if (this.eFg.threadData.aeV().user_info != null) {
                alaLiveInfoCoreData.userName = this.eFg.threadData.aeV().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bar() {
        if (this.eFg != null && this.eFg.threadData != null && this.eFg.threadData.aeV() != null && this.eFg.threadData.aeV().share_info != null) {
            if (!isHost()) {
                n.vW(this.eFg.threadId);
            }
            if (this.eFg.threadData.aeV().share_info.record_tid <= 0) {
                baq();
                return;
            }
            String valueOf = String.valueOf(this.eFg.threadData.aeV().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqp() {
        if (this.eFg != null) {
            if (!isHost()) {
                n.vW(this.eFg.threadId);
                n.a(this.mTitle, this.eFg.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VV, this.eFg.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eFg.eIn == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eFg.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eFg.threadData.getFid()));
            pbActivityConfig.setForumName(this.eFg.threadData.aeH());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eFg.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eFg.threadData == null || !this.eFg.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").bT("obj_type", "2").bT("tid", this.eFg.threadId).P("obj_param1", this.eFg.isHost ? 1 : 2));
        }
    }

    private void bas() {
        if (this.eFg != null && this.eFg.threadData != null && this.eFg.threadData.bMt != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eFg.threadData.bMt.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").bT("obj_type", "3").bT("tid", this.eFg.threadId).P("obj_param1", this.eFg.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iG(boolean z) {
        if (this.eFz != null) {
            if (z) {
                this.eFz.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eFz.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eFz.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eFz.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eFg.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFP) {
            bas();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eEC != null) {
            this.eEC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eEC != null) {
            this.eEC.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                imageUrlData.threadId = com.baidu.adp.lib.g.b.e(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeH(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.eFS);
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
