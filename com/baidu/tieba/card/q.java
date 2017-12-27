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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCoverView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.p;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class q extends a<CardPersonDynamicThreadData> {
    private boolean aXt;
    private View.OnClickListener cNS;
    private AlaPlayAnimationView cON;
    private CustomMessageListener cOO;
    private final View.OnClickListener cPC;
    private TbImageView.a cPj;
    public PlayVoiceBntNew cPw;
    private TextView cPy;
    private ConstrainImageGroup cPz;
    private LinearLayout cQA;
    private TextView cQB;
    private TextView cQC;
    private TextView cQD;
    private TextView cQE;
    private ImageView cQF;
    private p cQG;
    private PhotoLiveCoverView cQH;
    private View cQI;
    private TbImageView cQJ;
    private ImageView cQK;
    private LinearLayout cQL;
    private TextView cQM;
    private LinearLayout cQN;
    private LinearLayout cQO;
    private TextView cQP;
    private TextView cQQ;
    private TextView cQR;
    private TextView cQS;
    private TextView cQT;
    public OriginalThreadCardView cQU;
    private View cQV;
    private View cQW;
    private boolean cQX;
    private boolean cQY;
    com.baidu.tieba.view.j cQZ;
    private CardPersonDynamicThreadData cQl;
    public ThreadViewAndCommentInfoLayout cQw;
    private final String cQx;
    private final String cQy;
    private TextView cQz;
    private p.a cRa;
    private final View.OnClickListener cRb;
    public ThreadCommentAndPraiseInfoLayout ciE;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cQx = "1";
        this.cQy = "2";
        this.mSkinType = 3;
        this.aXt = true;
        this.cQZ = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.cQl != null && !StringUtils.isNull(q.this.cQl.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.cQl.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.j
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(d.C0108d.cp_link_tip_c) : q.this.mContext.getResources().getColor(d.C0108d.cp_link_tip_a));
            }
        };
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.aiY() != null) {
                    q.this.aiY().a(view, q.this.cQl);
                }
                if (q.this.cQl.cSZ != 33) {
                    if (q.this.cQl.cSZ != 60) {
                        if ((q.this.cQl.cSZ != 40 || q.this.cQl.cTc != 2) && !q.this.cQY) {
                            q.this.ajs();
                            return;
                        } else {
                            BdToast.b(q.this.getContext(), q.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).AQ();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (q.this.cQl.threadData.zq().live_status != 1) {
                        q.this.ajA();
                        return;
                    } else {
                        q.this.ajz();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                q.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(q.this.mPageContext.getPageActivity(), q.this.cQl.threadId).cG(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).eD(23014).wQ()));
            }
        };
        this.cOO = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.cQl != null && q.this.cQl.threadId != null && q.this.mTitle != null && q.this.cPy != null && ((String) customResponsedMessage.getData()).equals(q.this.cQl.threadId) && !q.this.isHost()) {
                    k.a(q.this.mTitle, q.this.cQl.threadId, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                    k.a(q.this.cPy, q.this.cQl.threadId, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
                }
            }
        };
        this.cRa = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.eA(z);
            }
        };
        this.cRb = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> aiY = q.this.aiY();
                if (aiY != null) {
                    view.setTag("1");
                    aiY.a(view, q.this.cQl);
                }
                q.this.ajs();
            }
        };
        this.cPC = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> aiY = q.this.aiY();
                if (aiY != null) {
                    view.setTag("2");
                    aiY.a(view, q.this.cQl);
                }
            }
        };
        this.cPj = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && q.this.cQJ != null) {
                    q.this.cQJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cQz = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cQA = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cQB = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cQC = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cQD = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cQT = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cQE = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cQF = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cPw = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cPw.setAfterClickListener(this.cPC);
        this.cPy = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cPy.setVisibility(8);
        this.cPz = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cPz.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cPz.setChildClickListener(this.cRb);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.f(1.0d);
        this.cPz.setImageProcessor(fVar);
        this.cQI = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cQJ = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cQK = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cQH = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cQw = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cQO = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cQP = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cQQ = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cQR = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cON = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cQS = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cQL = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cQM = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cQN = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cQN.setVisibility(8);
        this.cQU = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cQV = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cQW = this.mRootView.findViewById(d.g.divider_line_thin);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this.cNS);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setFrom(1);
        this.ciE.setShareReportFrom(6);
        this.ciE.setStType("person_page");
        this.ciE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.aiY() != null) {
                    q.this.aiY().a(view, q.this.cQl);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.cQz, d.C0108d.cp_cont_b);
            aj.r(this.cQB, d.C0108d.cp_cont_j);
            aj.r(this.cQC, d.C0108d.cp_cont_b);
            aj.r(this.cQD, d.C0108d.cp_cont_d);
            aj.r(this.cQT, d.C0108d.cp_cont_d);
            aj.r(this.cQE, d.C0108d.cp_cont_d);
            if (this.cQF != null) {
                this.cQF.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.r(this.mTitle, d.C0108d.cp_cont_b);
            aj.r(this.cPy, d.C0108d.cp_cont_f);
            aj.r(this.cQM, d.C0108d.cp_cont_f);
            if (this.cQG != null) {
                this.cQG.onChangeSkinType();
            }
            this.cQw.onChangeSkinType();
            this.ciE.onChangeSkinType();
            aj.t(this.cQV, d.C0108d.cp_bg_line_e);
            aj.t(this.cQW, d.C0108d.cp_bg_line_c);
            aj.t(this.cQM, d.C0108d.cp_bg_line_e);
            if (this.cQU != null) {
                this.cQU.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_dynamic_thread;
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
        this.cQl = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cNS);
        }
        this.cQz.setVisibility(cardPersonDynamicThreadData.cTn ? 0 : 8);
        this.cQA.setVisibility(cardPersonDynamicThreadData.cTm ? 0 : 4);
        this.cQV.setVisibility(cardPersonDynamicThreadData.cTm ? 0 : 8);
        this.cQW.setVisibility(cardPersonDynamicThreadData.cTm ? 8 : 0);
        if (cardPersonDynamicThreadData.cTo) {
            this.cQV.setVisibility(8);
            this.cQW.setVisibility(8);
        }
        this.cQX = cardPersonDynamicThreadData.cSZ == 40 && cardPersonDynamicThreadData.cTc == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cQY = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cTc == 2;
        }
        this.cQz.setText(cardPersonDynamicThreadData.cTd);
        this.cQB.setText(cardPersonDynamicThreadData.cTe);
        this.cQC.setText(cardPersonDynamicThreadData.cTf);
        if (cardPersonDynamicThreadData.cTl != null && cardPersonDynamicThreadData.cTl.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cTl.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.cTl[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cTl.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cQD.setText(sb2);
                this.cQD.setVisibility(0);
            } else {
                this.cQD.setText(d.j.person_homepage);
            }
        } else {
            this.cQD.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cQE.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cQE.setVisibility(0);
            }
            eA(cardPersonDynamicThreadData.isPrivacy);
            this.cQF.setVisibility(0);
            this.cQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.cQG == null) {
                            q.this.cQG = new p(q.this.mPageContext);
                            q.this.cQG.create();
                            q.this.cQG.a(q.this.cRa);
                        }
                        q.this.cQG.a(q.this.cQl);
                        q.this.cQG.show();
                    }
                }
            });
        } else {
            this.cQE.setVisibility(8);
            this.cQF.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cTi;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cPw.setVisibility(0);
            ez(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cPw.setVoiceModel(voiceModel);
            this.cPw.setTag(voiceModel);
            this.cPw.btM();
            if (voiceModel != null) {
                this.cPw.qL(voiceModel.voice_status.intValue());
            }
            this.cPw.bDs();
        } else {
            this.cPw.setVisibility(8);
            ez(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cTh;
        aj.s(this.cQL, d.C0108d.transparent);
        this.cQM.setVisibility(8);
        this.cQN.setVisibility(8);
        this.cQL.setVisibility(0);
        this.cQH.setVisibility(8);
        this.cQI.setVisibility(8);
        this.cQS.setVisibility(8);
        this.cQO.setVisibility(8);
        this.cQR.setVisibility(8);
        this.cON.bKr();
        if (cardPersonDynamicThreadData.cSZ == 36) {
            this.cPz.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cSZ == 33) {
            this.cPz.setVisibility(8);
            if (com.baidu.tbadk.core.i.wB().wH() && cardPersonDynamicThreadData.cTj != null && !StringUtils.isNull(cardPersonDynamicThreadData.cTj.livecover_src)) {
                this.cQH.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.cTj)) {
                    this.cQH.setShowExpression(false);
                } else {
                    this.cQH.setShowExpression(true);
                }
                this.cQH.setShowImage(com.baidu.tbadk.core.i.wB().wH());
                this.cQH.setChooseStyle(d.getShowStyle());
                this.cQH.setData(d);
            }
        } else if (cardPersonDynamicThreadData.cSZ == 40 || this.cQl.cSZ == 50) {
            this.cPz.setVisibility(8);
            if (com.baidu.tbadk.core.i.wB().wH()) {
                this.cQI.setVisibility(0);
                this.cQK.setVisibility(0);
                this.cQK.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cQI.getLayoutParams();
                int width = this.cQI.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cQI.setLayoutParams(layoutParams);
                if (this.cQl.videoInfo != null) {
                    this.cQJ.setDefaultErrorResource(0);
                    this.cQJ.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cQJ.setEvent(this.cPj);
                    this.cQJ.startLoad(this.cQl.videoInfo.thumbnail_url, 17, false);
                    if (this.cQX) {
                        this.cQS.setVisibility(0);
                        this.cQS.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cQO.setVisibility(0);
                        this.cQP.setText(am.fX(this.cQl.videoInfo.video_duration.intValue() * 1000));
                        this.cQQ.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.I(this.cQl.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cQl.cSZ == 60 || this.cQl.cSZ == 49) {
            this.cPz.setVisibility(8);
            if (this.cQl.threadData.zq() != null && this.cQl.threadData.zq().user_info != null && this.cQl.cSZ == 60) {
                String str = this.cQl.threadData.zq().user_info.user_name;
                if (com.baidu.tbadk.util.w.hb(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cQM.setText(k.aG(str + ":", this.cQl.threadData.getTitle()));
                this.cQM.setVisibility(0);
            } else {
                this.cQM.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.wB().wH()) {
                this.cQI.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cQI.getLayoutParams();
                int width2 = this.cQI.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cQI.setLayoutParams(layoutParams2);
                if (this.cQl.threadData.zq() != null) {
                    this.cQJ.setDefaultErrorResource(0);
                    this.cQJ.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cQJ.setEvent(this.cPj);
                    this.cQJ.startLoad(cardPersonDynamicThreadData.threadData.zq().cover, 10, false);
                    this.cQK.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cON.startPlayAnimation();
                    aj.s(this.cQL, d.C0108d.cp_bg_line_e);
                    this.cQR.setVisibility(0);
                    this.cQR.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.I(this.cQl.threadData.zq().audience_count)));
                    this.ciE.getCommentContainer().setOnClickListener(this.cNS);
                } else {
                    this.ciE.getCommentContainer().setOnClickListener(this.ciE);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.wB().wH() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final be beVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.F(linkedList) > 0) {
                    this.cPz.setVisibility(0);
                    this.cPz.setFromCDN(this.aXt);
                    this.cPz.setSingleImageRatio(0.67d);
                    this.cPz.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z) {
                            if (z) {
                                q.this.ajs();
                            } else {
                                q.this.a(view, linkedList, i2, beVar);
                            }
                        }
                    });
                    this.cPz.setImageMediaList(linkedList);
                } else {
                    this.cPz.setVisibility(8);
                }
            } else {
                this.cPz.setVisibility(8);
            }
            this.cQL.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aPb != null) {
            this.cQU.setVisibility(0);
            this.cQU.b(cardPersonDynamicThreadData.threadData.aPb);
            this.cQU.setOnClickListener(this);
            this.cPw.setVisibility(8);
            this.cPz.setVisibility(8);
            this.cQL.setVisibility(8);
            if (this.cQY) {
                this.cQT.setVisibility(0);
            } else {
                this.cQT.setVisibility(8);
            }
        } else {
            this.cQU.setVisibility(8);
            this.cQT.setVisibility(8);
        }
        ajr();
        c(cardPersonDynamicThreadData);
    }

    private void ez(boolean z) {
        if (this.cPz != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPz.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cPz.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cQX || this.cQY) {
                this.ciE.setCommentClickable(false);
                this.ciE.setAgreeClickable(false);
                this.ciE.setShareClickable(false);
                this.cQU.setClickable(false);
                this.cQF.setClickable(false);
            } else {
                this.ciE.setCommentClickable(true);
                this.ciE.setAgreeClickable(true);
                this.ciE.setShareClickable(true);
                this.cQU.setClickable(true);
                this.cQF.setClickable(true);
            }
            this.ciE.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cSZ == 60) {
                this.ciE.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cTl != null) {
                this.ciE.setMultiForumCount(cardPersonDynamicThreadData.cTl.length);
            }
            this.ciE.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void ajr() {
        this.cPw.setClickable(true);
        int childCount = this.cPz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cPz.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void ajz() {
        if (this.cQl != null && this.cQl.threadData != null && this.cQl.threadData.zq() != null) {
            if (!com.baidu.adp.lib.util.j.oI()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                k.jT(this.cQl.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cQl.threadData.zq());
            if (this.cQl.threadData.zq().user_info != null) {
                alaLiveInfoCoreData.userName = this.cQl.threadData.zq().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajA() {
        if (this.cQl != null && this.cQl.threadData != null && this.cQl.threadData.zq() != null && this.cQl.threadData.zq().share_info != null) {
            if (!isHost()) {
                k.jT(this.cQl.threadId);
            }
            if (this.cQl.threadData.zq().share_info.record_tid <= 0) {
                ajz();
                return;
            }
            String valueOf = String.valueOf(this.cQl.threadData.zq().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        if (this.cQl != null) {
            if (!isHost()) {
                k.jT(this.cQl.threadId);
                k.a(this.mTitle, this.cQl.threadId, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                k.a(this.cPy, this.cQl.threadId, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cQl.cSZ == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cQl.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cQl.threadData.getFid()));
            pbActivityConfig.setForumName(this.cQl.threadData.zd());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cQl.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    private void ajB() {
        if (this.cQl != null && this.cQl.threadData != null && this.cQl.threadData.aPb != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cQl.threadData.aPb.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(boolean z) {
        if (this.cQE != null) {
            if (z) {
                this.cQE.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cQE.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cQE.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cQE.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cQl.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cQU) {
            ajB();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cPz != null) {
            this.cPz.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cPz != null) {
            this.cPz.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, be beVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aXt ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(beVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, beVar.zd(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aXt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.cTj != null) {
            if (cardPersonDynamicThreadData.cTj.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.cTj.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.cTj.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.cTj.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.cTj.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.cTj.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.cTj.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.cTj.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.cTj.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.cTj.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.cTa);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.cTg != null && cardPersonDynamicThreadData.cTg.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cTg.length; i++) {
                sb.append(cardPersonDynamicThreadData.cTg[i].text);
            }
            photoLiveCardData.setContent(photoLiveCardData.deleteBlackSpace(sb.toString()));
        }
        photoLiveCardData.setTitle(photoLiveCardData.deleteBlackSpace(cardPersonDynamicThreadData.title));
        photoLiveCardData.setThreadId(Long.parseLong(cardPersonDynamicThreadData.threadId));
        return photoLiveCardData;
    }

    private int a(CardPersonDynamicThreadData.ZhiBoInfoTW zhiBoInfoTW) {
        return !StringUtils.isNull(zhiBoInfoTW.livecover_src) ? 1 : 2;
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.e> a(CardPersonDynamicThreadData.LabelInfo[] labelInfoArr) {
        ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList = new ArrayList<>();
        if (labelInfoArr == null || labelInfoArr.length <= 0) {
            return arrayList;
        }
        for (int i = 0; i < labelInfoArr.length; i++) {
            com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
            if (labelInfoArr[i] != null) {
                eVar.ht(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean e(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.threadData.d(false, true, this.cQX);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        k.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        return true;
    }
}
