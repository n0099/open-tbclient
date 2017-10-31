package com.baidu.tieba.card;

import android.graphics.Rect;
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
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class s extends a<CardPersonDynamicThreadData> {
    private boolean aiR;
    private View aom;
    private View.OnClickListener bQU;
    private AlaPlayAnimationView bRR;
    private CustomMessageListener bRS;
    public PlayVoiceBntNew bSJ;
    private TextView bSL;
    private ConstrainImageGroup bSM;
    private final View.OnClickListener bSN;
    private final String bSS;
    private final String bST;
    private final View.OnClickListener bSX;
    private TbImageView.a bSo;
    private CardPersonDynamicThreadData bTA;
    private LinearLayout bTB;
    private TextView bTC;
    private TextView bTD;
    private TextView bTE;
    private PhotoLiveCoverView bTF;
    private View bTG;
    private TbImageView bTH;
    private ImageView bTI;
    private LinearLayout bTJ;
    private TextView bTK;
    private LinearLayout bTL;
    private LinearLayout bTM;
    private TextView bTN;
    private TextView bTO;
    private TextView bTP;
    private TextView bTQ;
    private View bTR;
    private boolean bTS;
    com.baidu.tieba.view.i bTT;
    public ThreadViewAndCommentInfoLayout bTz;
    private ThreadCommentAndPraiseInfoLayout boD;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bSS = "1";
        this.bST = "2";
        this.mSkinType = 3;
        this.aiR = true;
        this.bTT = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bTA != null && !StringUtils.isNull(s.this.bTA.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bTA.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.C0080d.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.C0080d.cp_link_tip_a));
            }
        };
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Zx() != null) {
                    s.this.Zx().a(view, s.this.bTA);
                }
                if (s.this.bTA.bVw != 33) {
                    if (s.this.bTA.bVw != 60) {
                        if (s.this.bTA.bVw != 40 || s.this.bTA.bVz != 2) {
                            s.this.ZP();
                            return;
                        } else {
                            BdToast.b(s.this.getContext(), s.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).tq();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bTA.blk.rM().live_status != 1) {
                        s.this.ZW();
                        return;
                    } else {
                        s.this.ZV();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.mPageContext.getPageActivity(), s.this.bTA.threadId).cz(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bC(23014).pi()));
            }
        };
        this.bRS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bTA != null && s.this.bTA.threadId != null && s.this.mTitle != null && s.this.bSL != null && ((String) customResponsedMessage.getData()).equals(s.this.bTA.threadId) && !s.this.ZB()) {
                    m.a(s.this.mTitle, s.this.bTA.threadId, d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                    m.a(s.this.bSL, s.this.bTA.threadId, d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
                }
            }
        };
        this.bSX = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Zx = s.this.Zx();
                if (Zx != null) {
                    view.setTag("1");
                    Zx.a(view, s.this.bTA);
                }
            }
        };
        this.bSN = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Zx = s.this.Zx();
                if (Zx != null) {
                    view.setTag("2");
                    Zx.a(view, s.this.bTA);
                }
            }
        };
        this.bSo = new TbImageView.a() { // from class: com.baidu.tieba.card.s.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && s.this.bTH != null) {
                    s.this.bTH.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.bTB = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.bTC = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.bTD = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.bTE = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.bSJ = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.bSJ.setAfterClickListener(this.bSN);
        this.bSL = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.bSL.setVisibility(8);
        this.bSM = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.bSM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
        this.bSM.setChildClickListener(this.bSX);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bSM.setImageProcessor(fVar);
        this.bTG = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.bTH = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.bTI = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.bTF = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.bTz = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.bTM = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.bTN = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.bTO = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.bTP = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.bRR = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.bTQ = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.bTJ = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.bTK = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.bTL = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.bTL.setVisibility(8);
        this.bTR = this.mRootView.findViewById(d.g.divider_line_above_praise);
        this.aom = this.mRootView.findViewById(d.g.divider_line);
        this.boD = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this.bQU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setShareVisible(true);
        this.boD.setIsBarViewVisible(false);
        this.boD.setFrom(1);
        this.boD.setShareReportFrom(6);
        this.boD.setStType("person_page");
        this.boD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Zx() != null) {
                    s.this.Zx().a(view, s.this.bTA);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.i(this.bTC, d.C0080d.cp_cont_j);
            aj.i(this.bTD, d.C0080d.cp_cont_b);
            aj.i(this.bTE, d.C0080d.cp_cont_f);
            aj.i(this.mTitle, d.C0080d.cp_cont_b);
            aj.i(this.bSL, d.C0080d.cp_cont_f);
            aj.i(this.bTK, d.C0080d.cp_cont_f);
            this.bTz.onChangeSkinType();
            this.boD.onChangeSkinType();
            aj.k(this.aom, d.C0080d.cp_bg_line_e);
            aj.k(this.bTK, d.C0080d.cp_bg_line_e);
            aj.k(this.bTR, d.C0080d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bTA = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bQU);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bTB.setVisibility(cardPersonDynamicThreadData.bVH ? 0 : 4);
        this.aom.setVisibility(cardPersonDynamicThreadData.bVH ? 0 : 8);
        if (cardPersonDynamicThreadData.bVI) {
            this.aom.setVisibility(8);
        }
        this.bTS = cardPersonDynamicThreadData.bVw == 40 && cardPersonDynamicThreadData.bVz == 2;
        d(cardPersonDynamicThreadData);
        this.bTC.setText(cardPersonDynamicThreadData.bVA);
        this.bTD.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bVG != null && cardPersonDynamicThreadData.bVG.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bVG.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.bVG[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bVG.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bTE.setText(sb2);
                this.bTE.setVisibility(0);
            } else {
                this.bTE.setVisibility(8);
            }
        } else {
            this.bTE.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bVD;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bSJ.setVisibility(0);
            dz(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bSJ.setVoiceModel(voiceModel);
            this.bSJ.setTag(voiceModel);
            this.bSJ.bjo();
            if (voiceModel != null) {
                this.bSJ.nx(voiceModel.voice_status.intValue());
            }
        } else {
            this.bSJ.setVisibility(8);
            dz(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bVC;
        aj.j(this.bTJ, d.C0080d.transparent);
        this.bTK.setVisibility(8);
        this.bTL.setVisibility(8);
        this.bTJ.setVisibility(0);
        this.bTF.setVisibility(8);
        this.bTG.setVisibility(8);
        this.bTQ.setVisibility(8);
        this.bTM.setVisibility(8);
        this.bTP.setVisibility(8);
        this.bRR.bBd();
        if (cardPersonDynamicThreadData.bVw == 36) {
            this.bSM.setVisibility(8);
            this.bTR.setVisibility(0);
        } else if (cardPersonDynamicThreadData.bVw == 33) {
            this.bSM.setVisibility(8);
            this.bTR.setVisibility(8);
            if (com.baidu.tbadk.core.h.oT().oZ() && cardPersonDynamicThreadData.bVE != null && !StringUtils.isNull(cardPersonDynamicThreadData.bVE.livecover_src)) {
                this.bTF.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bVE)) {
                    this.bTF.setShowExpression(false);
                } else {
                    this.bTF.setShowExpression(true);
                }
                this.bTF.setShowImage(com.baidu.tbadk.core.h.oT().oZ());
                this.bTF.setChooseStyle(c.getShowStyle());
                this.bTF.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bVw == 40 || this.bTA.bVw == 50) {
            this.bSM.setVisibility(8);
            this.bTR.setVisibility(8);
            if (com.baidu.tbadk.core.h.oT().oZ()) {
                this.bTG.setVisibility(0);
                this.bTI.setVisibility(0);
                this.bTI.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTG.getLayoutParams();
                int width = this.bTG.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (0.5625d * width);
                this.bTG.setLayoutParams(layoutParams);
                if (this.bTA.videoInfo != null) {
                    this.bTH.setDefaultErrorResource(0);
                    this.bTH.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.bTH.setEvent(this.bSo);
                    this.bTH.startLoad(this.bTA.videoInfo.thumbnail_url, 17, false);
                    if (this.bTS) {
                        this.bTQ.setVisibility(0);
                        this.bTQ.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.bTM.setVisibility(0);
                        this.bTN.setText(am.cY(this.bTA.videoInfo.video_duration.intValue() * 1000));
                        this.bTO.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.A(this.bTA.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.bTA.bVw == 60 || this.bTA.bVw == 49) {
            this.bSM.setVisibility(8);
            this.bTR.setVisibility(8);
            if (this.bTA.blk.rM() != null && this.bTA.blk.rM().UQ != null && this.bTA.bVw == 60) {
                String str = this.bTA.blk.rM().UQ.user_name;
                if (com.baidu.tbadk.util.w.gW(str) > 14) {
                    str = com.baidu.tbadk.util.w.H(str, 14) + "...";
                }
                this.bTK.setText(m.aF(str + ":", this.bTA.blk.getTitle()));
                this.bTK.setVisibility(0);
            } else {
                this.bTK.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oT().oZ()) {
                this.bTG.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bTG.getLayoutParams();
                int width2 = this.bTG.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bTG.setLayoutParams(layoutParams2);
                if (this.bTA.blk.rM() != null) {
                    this.bTH.setDefaultErrorResource(0);
                    this.bTH.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.bTH.setEvent(this.bSo);
                    this.bTH.startLoad(cardPersonDynamicThreadData.blk.rM().cover, 10, false);
                    this.bTI.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.bRR.ZZ();
                    aj.j(this.bTJ, d.C0080d.cp_bg_line_e);
                    this.bTP.setVisibility(0);
                    this.bTP.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bTA.blk.rM().audience_count)));
                }
            }
        } else {
            if (com.baidu.tbadk.core.h.oT().oZ() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.blk;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                    this.bSM.setVisibility(0);
                    this.bTR.setVisibility(8);
                    this.bSM.setFromCDN(this.aiR);
                    this.bSM.setSingleImageRatio(0.67d);
                    this.bSM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                s.this.ZP();
                            } else {
                                s.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.bSM.setImageMediaList(linkedList);
                } else {
                    this.bSM.setVisibility(8);
                    this.bTR.setVisibility(0);
                }
            } else {
                this.bSM.setVisibility(8);
                this.bTR.setVisibility(0);
            }
            this.bTJ.setVisibility(8);
        }
        ZO();
        b(cardPersonDynamicThreadData);
    }

    private void dz(boolean z) {
        if (this.bSM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSM.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.bSM.setLayoutParams(layoutParams);
        }
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.bTS) {
                this.boD.setCommentClickable(false);
                this.boD.setAgreeClickable(false);
                this.boD.setShareClickable(false);
            } else {
                this.boD.setCommentClickable(true);
                this.boD.setAgreeClickable(true);
                this.boD.setShareClickable(true);
            }
            this.boD.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.bVw == 60) {
                this.boD.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.bVG != null) {
                this.boD.setMultiForumCount(cardPersonDynamicThreadData.bVG.length);
            }
            this.boD.setData(cardPersonDynamicThreadData.blk);
        }
    }

    private void ZO() {
        this.bSJ.setClickable(true);
        int childCount = this.bSM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSM.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void ZV() {
        if (this.bTA != null && this.bTA.blk != null && this.bTA.blk.rM() != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!ZB()) {
                m.jK(this.bTA.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bTA.blk.rM());
            if (this.bTA.blk.rM().UQ != null) {
                alaLiveInfoCoreData.userName = this.bTA.blk.rM().UQ.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZW() {
        if (this.bTA != null && this.bTA.blk != null && this.bTA.blk.rM() != null && this.bTA.blk.rM().UR != null) {
            if (!ZB()) {
                m.jK(this.bTA.threadId);
            }
            if (this.bTA.blk.rM().UR.record_tid <= 0) {
                ZV();
                return;
            }
            String valueOf = String.valueOf(this.bTA.blk.rM().UR.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZP() {
        if (this.bTA != null) {
            if (!ZB()) {
                m.jK(this.bTA.threadId);
                m.a(this.mTitle, this.bTA.threadId, d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                m.a(this.bSL, this.bTA.threadId, d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.bTA.bVw == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.bTA.blk, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.bTA.blk.getFid()));
            pbActivityConfig.setForumName(this.bTA.blk.rz());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZB() {
        return this.bTA.bUY && !this.bTA.aCw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSM != null) {
            this.bSM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSM != null) {
            this.bSM.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                imageUrlData.urlType = this.aiR ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.rz(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bVE != null) {
            if (cardPersonDynamicThreadData.bVE.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bVE.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bVE.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bVE.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bVE.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bVE.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bVE.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bVE.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bVE.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bVE.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.bVx);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bVB != null && cardPersonDynamicThreadData.bVB.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bVB.length; i++) {
                sb.append(cardPersonDynamicThreadData.bVB[i].text);
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
                eVar.ev(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.blk == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.blk.c(false, true, this.bTS);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(c));
        this.mTitle.setText(c);
        m.a(this.mTitle, cardPersonDynamicThreadData.blk.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        return true;
    }
}
