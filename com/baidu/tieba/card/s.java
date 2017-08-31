package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCoverView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class s extends a<CardPersonDynamicThreadData> {
    private boolean ajf;
    private final View.OnClickListener aoe;
    private TbImageView.a bHH;
    private View.OnClickListener bJw;
    private CustomMessageListener bKn;
    public ThreadViewAndCommentInfoLayout bLT;
    private CardPersonDynamicThreadData bLU;
    private LinearLayout bLV;
    private TextView bLW;
    private TextView bLX;
    private TextView bLY;
    private PhotoLiveCoverView bLZ;
    public PlayVoiceBntNew bLe;
    private TextView bLf;
    private ConstrainImageGroup bLg;
    private final View.OnClickListener bLh;
    private final String bLm;
    private final String bLn;
    private FrsCommonImageLayout.b bLq;
    private final View.OnClickListener bLr;
    private View bMa;
    private TbImageView bMb;
    private ImageView bMc;
    private LinearLayout bMd;
    private TextView bMe;
    private LinearLayout bMf;
    private TextView bMg;
    com.baidu.tieba.view.i bMh;
    private LinearLayout blD;
    private TbPageContext<?> mF;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLm = "1";
        this.bLn = "2";
        this.mSkinType = 3;
        this.ajf = true;
        this.bMh = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bLU != null && !StringUtils.isNull(s.this.bLU.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bLU.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.XA() != null) {
                    s.this.XA().a(view, s.this.bLU);
                }
                if (s.this.bLU.bNI != 33) {
                    if (s.this.bLU.bNI != 60) {
                        if (s.this.bLU.bNI != 40 || s.this.bLU.bNK != 2) {
                            s.this.XR();
                            return;
                        } else {
                            BdToast.b(s.this.getContext(), s.this.getContext().getString(d.l.video_check_click_msg), d.g.icon_toast_game_error).tw();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bLU.threadData.rT().live_status != 1) {
                        s.this.XX();
                        return;
                    } else {
                        s.this.XW();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.mF.getPageActivity(), s.this.bLU.threadId).cu(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bB(23014).pi()));
            }
        };
        this.bKn = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bLU != null && s.this.bLU.threadId != null && s.this.mTitle != null && s.this.bLf != null && ((String) customResponsedMessage.getData()).equals(s.this.bLU.threadId) && !s.this.XE()) {
                    m.a(s.this.mTitle, s.this.bLU.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bLf, s.this.bLU.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bLq = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.s.5
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dv(int i) {
                s.this.XR();
            }
        };
        this.bLr = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> XA = s.this.XA();
                if (XA != null) {
                    view.setTag("1");
                    XA.a(view, s.this.bLU);
                }
            }
        };
        this.bLh = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> XA = s.this.XA();
                if (XA != null) {
                    view.setTag("2");
                    XA.a(view, s.this.bLU);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.XA() != null) {
                    s.this.XA().a(view, s.this.bLU);
                }
            }
        };
        this.bHH = new TbImageView.a() { // from class: com.baidu.tieba.card.s.9
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && s.this.bMb != null) {
                    s.this.bMb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mF = tbPageContext;
        this.blD = (LinearLayout) this.mRootView.findViewById(d.h.content_layout);
        this.bLV = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bLW = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bLX = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bLY = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bLe = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bLe.setAfterClickListener(this.bLh);
        this.bLf = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bLf.setVisibility(8);
        this.bLg = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bLg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLg.setChildClickListener(this.bLr);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLg.setImageProcessor(fVar);
        this.bMa = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bMb = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bMc = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bLZ = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bLT = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bMd = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bMe = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bMf = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bMf.setVisibility(8);
        this.bMg = (TextView) this.mRootView.findViewById(d.h.tvAlaLivingLogView);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.i(this.bLW, d.e.cp_cont_d);
            aj.i(this.bLX, d.e.cp_cont_b);
            aj.i(this.bLY, d.e.cp_cont_f);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.i(this.bLf, d.e.cp_cont_f);
            aj.i(this.bMe, d.e.cp_cont_f);
            if (this.bLU != null && this.bLU.bNI == 60) {
                aj.j(this.bMd, d.e.cp_bg_line_e);
            } else {
                aj.j(this.bMd, d.e.transparent);
            }
            this.bLT.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_person_dynamic_thread;
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
        this.bLU = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        this.bLV.setVisibility(cardPersonDynamicThreadData.bNS ? 0 : 4);
        b(cardPersonDynamicThreadData);
        d(cardPersonDynamicThreadData);
        this.bLW.setText(cardPersonDynamicThreadData.bNL);
        this.bLX.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bNR != null && cardPersonDynamicThreadData.bNR.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bNR.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.bNR[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bNR.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bLY.setText(sb2);
                this.bLY.setVisibility(0);
            } else {
                this.bLY.setVisibility(8);
            }
        } else {
            this.bLY.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bNO;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bLe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bLe.setVoiceModel(voiceModel);
            this.bLe.setTag(voiceModel);
            this.bLe.bhr();
            if (voiceModel != null) {
                this.bLe.nj(voiceModel.voice_status.intValue());
            }
        } else {
            this.bLe.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bNN;
        aj.j(this.bMd, d.e.transparent);
        this.bMe.setVisibility(8);
        this.bMf.setVisibility(8);
        this.bLZ.setVisibility(8);
        this.bMa.setVisibility(8);
        if (cardPersonDynamicThreadData.bNI == 36) {
            this.bLg.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bNI == 33) {
            this.bLg.setVisibility(8);
            if (com.baidu.tbadk.core.h.oS().oY() && cardPersonDynamicThreadData.bNP != null && !StringUtils.isNull(cardPersonDynamicThreadData.bNP.livecover_src)) {
                this.bLZ.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bNP)) {
                    this.bLZ.setShowExpression(false);
                } else {
                    this.bLZ.setShowExpression(true);
                }
                this.bLZ.setShowImage(com.baidu.tbadk.core.h.oS().oY());
                this.bLZ.setChooseStyle(c.getShowStyle());
                this.bLZ.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bNI == 40 || cardPersonDynamicThreadData.bNI == 50 || cardPersonDynamicThreadData.bNI == 49) {
            this.bLg.setVisibility(8);
            if (com.baidu.tbadk.core.h.oS().oY()) {
                this.bMa.setVisibility(0);
                this.bMc.setVisibility(0);
                this.bMc.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMa.getLayoutParams();
                int width = this.bMa.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams.height = width;
                this.bMa.setLayoutParams(layoutParams);
                if (this.bLU.videoInfo != null || this.bLU.threadData.rT() != null) {
                    this.bMb.setDefaultErrorResource(0);
                    this.bMb.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMb.setEvent(this.bHH);
                    if (cardPersonDynamicThreadData.threadData.rT() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rT().cover)) {
                        this.bMb.c(cardPersonDynamicThreadData.threadData.rT().cover, 10, false);
                    } else if (this.bLU.videoInfo != null) {
                        this.bMb.c(this.bLU.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (this.bLU.bNI == 60) {
            this.bLg.setVisibility(8);
            if (this.bLU.threadData.rT() != null && this.bLU.threadData.rT().Uu != null) {
                String str = this.bLU.threadData.rT().Uu.user_name;
                if (com.baidu.tbadk.util.v.gT(str) > 14) {
                    str = com.baidu.tbadk.util.v.E(str, 14) + "...";
                }
                this.bMe.setText(m.aK(str + ":", this.bLU.threadData.getTitle()));
                this.bMe.setVisibility(0);
            } else {
                this.bMe.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oS().oY()) {
                this.bMa.setVisibility(0);
                this.bMf.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bMa.getLayoutParams();
                int width2 = this.bMa.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bMa.setLayoutParams(layoutParams2);
                if (this.bLU.threadData.rT() != null) {
                    this.bMb.setDefaultErrorResource(0);
                    this.bMb.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMb.setEvent(this.bHH);
                    this.bMb.c(cardPersonDynamicThreadData.threadData.rT().cover, 10, false);
                    if (this.bLU.threadData.rT().live_status == 1) {
                        this.bMc.setImageResource(d.g.btn_icon_play_live);
                        this.bMg.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
                        this.bMg.setText(d.l.live_in);
                    } else {
                        this.bMc.setImageResource(d.g.icon_play_video);
                        this.bMg.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding_replay, 0, 0, 0);
                        this.bMg.setText(d.l.ala_live_card_view_record_label);
                    }
                    aj.j(this.bMd, d.e.cp_bg_line_e);
                }
            }
        } else if (com.baidu.tbadk.core.h.oS().oY() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            final bj bjVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !am.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                this.bLg.setVisibility(0);
                this.bLg.setFromCDN(this.ajf);
                this.bLg.setSingleImageRatio(0.67d);
                this.bLg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (z) {
                            s.this.XR();
                        } else {
                            s.this.a(linkedList2, i2, bjVar);
                        }
                    }
                });
                this.bLg.setImageUrls(linkedList);
            } else {
                this.bLg.setVisibility(8);
            }
        } else {
            this.bLg.setVisibility(8);
        }
        XQ();
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.bLT.setIsShowReadNum(false);
        this.bLT.setIsShowReplayNum(false);
        this.bLT.setIsShowAudienceNum(false);
        this.bLT.setIsShowZanNum(false);
        if (cardPersonDynamicThreadData.bNT && cardPersonDynamicThreadData.threadData.rt() < 0) {
            this.bLT.setVisibility(8);
            if (this.blD != null) {
                this.blD.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40));
            }
        } else if (cardPersonDynamicThreadData.bNI == 60) {
            this.bLT.setVisibility(0);
            if (this.bLU.threadData.rT().live_status == 1) {
                this.bLT.setIsShowAudienceNum(true);
                this.bLT.setIsShowZanNum(true);
            } else {
                this.bLT.setIsShowReadNum(true);
                this.bLT.setIsShowReplayNum(true);
            }
            this.bLT.setData(cardPersonDynamicThreadData.threadData);
            if (this.blD != null) {
                this.blD.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34));
            }
        } else {
            this.bLT.setIsShowReadNum(true);
            this.bLT.setIsShowReplayNum(true);
            this.bLT.setVisibility(0);
            this.bLT.setData(cardPersonDynamicThreadData.threadData);
            if (this.blD != null) {
                this.blD.setPadding(0, 0, 0, 0);
            }
        }
        if (cardPersonDynamicThreadData.bNI == 60) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLT.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            this.bLT.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bLT.getLayoutParams();
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds28);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
        this.bLT.setLayoutParams(layoutParams2);
    }

    private void XQ() {
        this.bLe.setClickable(true);
        int childCount = this.bLg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLg.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void XW() {
        if (this.bLU != null && this.bLU.threadData != null && this.bLU.threadData.rT() != null) {
            if (!com.baidu.adp.lib.util.i.hi()) {
                com.baidu.adp.lib.util.k.showToast(this.mF.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!XE()) {
                m.js(this.bLU.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bLU.threadData.rT());
            if (this.bLU.threadData.rT().Uu != null) {
                alaLiveInfoCoreData.setUserName(this.bLU.threadData.rT().Uu.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.mF.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XX() {
        if (this.bLU != null && this.bLU.threadData != null && this.bLU.threadData.rT() != null && this.bLU.threadData.rT().Uv != null) {
            if (!XE()) {
                m.js(this.bLU.threadId);
            }
            if (this.bLU.threadData.rT().Uv.record_tid <= 0) {
                XW();
                return;
            }
            String valueOf = String.valueOf(this.bLU.threadData.rT().Uv.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mF.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XR() {
        if (this.bLU != null) {
            if (!XE()) {
                m.js(this.bLU.threadId);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mF.getPageActivity());
            if (this.bLU.bNI == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(this.bLU.threadId, this.bLU.bNF, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XE() {
        return this.bLU.bNk && !this.bLU.aCJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLg != null) {
            this.bLg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLg != null) {
            this.bLg.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.mF.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajf ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getThumbnails_url(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                    ImageUrlData imageUrlData2 = new ImageUrlData();
                    imageUrlData2.urlType = this.ajf ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ajf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bNP != null) {
            if (cardPersonDynamicThreadData.bNP.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bNP.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bNP.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bNP.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bNP.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bNP.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bNP.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bNP.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bNP.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bNP.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bNM != null && cardPersonDynamicThreadData.bNM.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bNM.length; i++) {
                sb.append(cardPersonDynamicThreadData.bNM[i].text);
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
                eVar.el(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, cardPersonDynamicThreadData.bNI == 40 && cardPersonDynamicThreadData.bNK == 2);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(c));
        this.mTitle.setText(c);
        m.a(this.mTitle, cardPersonDynamicThreadData.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        return true;
    }
}
