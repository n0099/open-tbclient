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
    private boolean aje;
    private final View.OnClickListener aoc;
    private TbImageView.a bIy;
    private View.OnClickListener bKn;
    public PlayVoiceBntNew bLV;
    private TextView bLW;
    private ConstrainImageGroup bLX;
    private final View.OnClickListener bLY;
    private CustomMessageListener bLe;
    public ThreadViewAndCommentInfoLayout bMK;
    private CardPersonDynamicThreadData bML;
    private LinearLayout bMM;
    private TextView bMN;
    private TextView bMO;
    private TextView bMP;
    private PhotoLiveCoverView bMQ;
    private View bMR;
    private TbImageView bMS;
    private ImageView bMT;
    private LinearLayout bMU;
    private TextView bMV;
    private LinearLayout bMW;
    private TextView bMX;
    com.baidu.tieba.view.i bMY;
    private final String bMd;
    private final String bMe;
    private FrsCommonImageLayout.b bMh;
    private final View.OnClickListener bMi;
    private LinearLayout blC;
    private TbPageContext<?> mF;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMd = "1";
        this.bMe = "2";
        this.mSkinType = 3;
        this.aje = true;
        this.bMY = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bML != null && !StringUtils.isNull(s.this.bML.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bML.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.XL() != null) {
                    s.this.XL().a(view, s.this.bML);
                }
                if (s.this.bML.bOz != 33) {
                    if (s.this.bML.bOz != 60) {
                        if (s.this.bML.bOz != 40 || s.this.bML.bOB != 2) {
                            s.this.Yc();
                            return;
                        } else {
                            BdToast.b(s.this.getContext(), s.this.getContext().getString(d.l.video_check_click_msg), d.g.icon_toast_game_error).tw();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bML.threadData.rT().live_status != 1) {
                        s.this.Yi();
                        return;
                    } else {
                        s.this.Yh();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.mF.getPageActivity(), s.this.bML.threadId).cu(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bB(23014).pi()));
            }
        };
        this.bLe = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bML != null && s.this.bML.threadId != null && s.this.mTitle != null && s.this.bLW != null && ((String) customResponsedMessage.getData()).equals(s.this.bML.threadId) && !s.this.XP()) {
                    m.a(s.this.mTitle, s.this.bML.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bLW, s.this.bML.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bMh = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.s.5
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dv(int i) {
                s.this.Yc();
            }
        };
        this.bMi = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> XL = s.this.XL();
                if (XL != null) {
                    view.setTag("1");
                    XL.a(view, s.this.bML);
                }
            }
        };
        this.bLY = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> XL = s.this.XL();
                if (XL != null) {
                    view.setTag("2");
                    XL.a(view, s.this.bML);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.XL() != null) {
                    s.this.XL().a(view, s.this.bML);
                }
            }
        };
        this.bIy = new TbImageView.a() { // from class: com.baidu.tieba.card.s.9
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && s.this.bMS != null) {
                    s.this.bMS.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mF = tbPageContext;
        this.blC = (LinearLayout) this.mRootView.findViewById(d.h.content_layout);
        this.bMM = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bMN = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bMO = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bMP = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bLV = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bLV.setAfterClickListener(this.bLY);
        this.bLW = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bLW.setVisibility(8);
        this.bLX = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bLX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLX.setChildClickListener(this.bMi);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLX.setImageProcessor(fVar);
        this.bMR = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bMS = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bMT = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bMQ = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bMK = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bMU = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bMV = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bMW = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bMW.setVisibility(8);
        this.bMX = (TextView) this.mRootView.findViewById(d.h.tvAlaLivingLogView);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.i(this.bMN, d.e.cp_cont_d);
            aj.i(this.bMO, d.e.cp_cont_b);
            aj.i(this.bMP, d.e.cp_cont_f);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.i(this.bLW, d.e.cp_cont_f);
            aj.i(this.bMV, d.e.cp_cont_f);
            if (this.bML != null && this.bML.bOz == 60) {
                aj.j(this.bMU, d.e.cp_bg_line_e);
            } else {
                aj.j(this.bMU, d.e.transparent);
            }
            this.bMK.onChangeSkinType();
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
        this.bML = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bKn);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        this.bMM.setVisibility(cardPersonDynamicThreadData.bOJ ? 0 : 4);
        b(cardPersonDynamicThreadData);
        d(cardPersonDynamicThreadData);
        this.bMN.setText(cardPersonDynamicThreadData.bOC);
        this.bMO.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bOI != null && cardPersonDynamicThreadData.bOI.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bOI.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.bOI[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bOI.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bMP.setText(sb2);
                this.bMP.setVisibility(0);
            } else {
                this.bMP.setVisibility(8);
            }
        } else {
            this.bMP.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bOF;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bLV.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bLV.setVoiceModel(voiceModel);
            this.bLV.setTag(voiceModel);
            this.bLV.bhC();
            if (voiceModel != null) {
                this.bLV.nl(voiceModel.voice_status.intValue());
            }
        } else {
            this.bLV.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bOE;
        aj.j(this.bMU, d.e.transparent);
        this.bMV.setVisibility(8);
        this.bMW.setVisibility(8);
        this.bMQ.setVisibility(8);
        this.bMR.setVisibility(8);
        if (cardPersonDynamicThreadData.bOz == 36) {
            this.bLX.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bOz == 33) {
            this.bLX.setVisibility(8);
            if (com.baidu.tbadk.core.h.oS().oY() && cardPersonDynamicThreadData.bOG != null && !StringUtils.isNull(cardPersonDynamicThreadData.bOG.livecover_src)) {
                this.bMQ.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bOG)) {
                    this.bMQ.setShowExpression(false);
                } else {
                    this.bMQ.setShowExpression(true);
                }
                this.bMQ.setShowImage(com.baidu.tbadk.core.h.oS().oY());
                this.bMQ.setChooseStyle(c.getShowStyle());
                this.bMQ.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bOz == 40 || cardPersonDynamicThreadData.bOz == 50 || cardPersonDynamicThreadData.bOz == 49) {
            this.bLX.setVisibility(8);
            if (com.baidu.tbadk.core.h.oS().oY()) {
                this.bMR.setVisibility(0);
                this.bMT.setVisibility(0);
                this.bMT.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMR.getLayoutParams();
                int width = this.bMR.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams.height = width;
                this.bMR.setLayoutParams(layoutParams);
                if (this.bML.videoInfo != null || this.bML.threadData.rT() != null) {
                    this.bMS.setDefaultErrorResource(0);
                    this.bMS.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMS.setEvent(this.bIy);
                    if (cardPersonDynamicThreadData.threadData.rT() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rT().cover)) {
                        this.bMS.c(cardPersonDynamicThreadData.threadData.rT().cover, 10, false);
                    } else if (this.bML.videoInfo != null) {
                        this.bMS.c(this.bML.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (this.bML.bOz == 60) {
            this.bLX.setVisibility(8);
            if (this.bML.threadData.rT() != null && this.bML.threadData.rT().Uu != null) {
                String str = this.bML.threadData.rT().Uu.user_name;
                if (com.baidu.tbadk.util.v.gT(str) > 14) {
                    str = com.baidu.tbadk.util.v.E(str, 14) + "...";
                }
                this.bMV.setText(m.aK(str + ":", this.bML.threadData.getTitle()));
                this.bMV.setVisibility(0);
            } else {
                this.bMV.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oS().oY()) {
                this.bMR.setVisibility(0);
                this.bMW.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bMR.getLayoutParams();
                int width2 = this.bMR.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bMR.setLayoutParams(layoutParams2);
                if (this.bML.threadData.rT() != null) {
                    this.bMS.setDefaultErrorResource(0);
                    this.bMS.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMS.setEvent(this.bIy);
                    this.bMS.c(cardPersonDynamicThreadData.threadData.rT().cover, 10, false);
                    if (this.bML.threadData.rT().live_status == 1) {
                        this.bMT.setImageResource(d.g.btn_icon_play_live);
                        this.bMX.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
                        this.bMX.setText(d.l.live_in);
                    } else {
                        this.bMT.setImageResource(d.g.icon_play_video);
                        this.bMX.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding_replay, 0, 0, 0);
                        this.bMX.setText(d.l.ala_live_card_view_record_label);
                    }
                    aj.j(this.bMU, d.e.cp_bg_line_e);
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
                this.bLX.setVisibility(0);
                this.bLX.setFromCDN(this.aje);
                this.bLX.setSingleImageRatio(0.67d);
                this.bLX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (z) {
                            s.this.Yc();
                        } else {
                            s.this.a(linkedList2, i2, bjVar);
                        }
                    }
                });
                this.bLX.setImageUrls(linkedList);
            } else {
                this.bLX.setVisibility(8);
            }
        } else {
            this.bLX.setVisibility(8);
        }
        Yb();
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.bMK.setIsShowReadNum(false);
        this.bMK.setIsShowReplayNum(false);
        this.bMK.setIsShowAudienceNum(false);
        this.bMK.setIsShowZanNum(false);
        if (cardPersonDynamicThreadData.bOK && cardPersonDynamicThreadData.threadData.rt() < 0) {
            this.bMK.setVisibility(8);
            if (this.blC != null) {
                this.blC.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds40));
            }
        } else if (cardPersonDynamicThreadData.bOz == 60) {
            this.bMK.setVisibility(0);
            if (this.bML.threadData.rT().live_status == 1) {
                this.bMK.setIsShowAudienceNum(true);
                this.bMK.setIsShowZanNum(true);
            } else {
                this.bMK.setIsShowReadNum(true);
                this.bMK.setIsShowReplayNum(true);
            }
            this.bMK.setData(cardPersonDynamicThreadData.threadData);
            if (this.blC != null) {
                this.blC.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds34));
            }
        } else {
            this.bMK.setIsShowReadNum(true);
            this.bMK.setIsShowReplayNum(true);
            this.bMK.setVisibility(0);
            this.bMK.setData(cardPersonDynamicThreadData.threadData);
            if (this.blC != null) {
                this.blC.setPadding(0, 0, 0, 0);
            }
        }
        if (cardPersonDynamicThreadData.bOz == 60) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMK.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds16);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds16);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds16);
            this.bMK.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bMK.getLayoutParams();
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds28);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds40);
        this.bMK.setLayoutParams(layoutParams2);
    }

    private void Yb() {
        this.bLV.setClickable(true);
        int childCount = this.bLX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLX.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void Yh() {
        if (this.bML != null && this.bML.threadData != null && this.bML.threadData.rT() != null) {
            if (!com.baidu.adp.lib.util.i.hi()) {
                com.baidu.adp.lib.util.k.showToast(this.mF.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!XP()) {
                m.ju(this.bML.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bML.threadData.rT());
            if (this.bML.threadData.rT().Uu != null) {
                alaLiveInfoCoreData.setUserName(this.bML.threadData.rT().Uu.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.mF.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yi() {
        if (this.bML != null && this.bML.threadData != null && this.bML.threadData.rT() != null && this.bML.threadData.rT().Uv != null) {
            if (!XP()) {
                m.ju(this.bML.threadId);
            }
            if (this.bML.threadData.rT().Uv.record_tid <= 0) {
                Yh();
                return;
            }
            String valueOf = String.valueOf(this.bML.threadData.rT().Uv.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mF.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yc() {
        if (this.bML != null) {
            if (!XP()) {
                m.ju(this.bML.threadId);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mF.getPageActivity());
            if (this.bML.bOz == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(this.bML.threadId, this.bML.bOw, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XP() {
        return this.bML.bOb && !this.bML.aCG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLX != null) {
            this.bLX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLX != null) {
            this.bLX.setImageViewPool(bVar);
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
                    imageUrlData.urlType = this.aje ? 13 : 14;
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
                    imageUrlData2.urlType = this.aje ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.aje, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bOG != null) {
            if (cardPersonDynamicThreadData.bOG.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bOG.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bOG.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bOG.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bOG.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bOG.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bOG.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bOG.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bOG.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bOG.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bOD != null && cardPersonDynamicThreadData.bOD.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bOD.length; i++) {
                sb.append(cardPersonDynamicThreadData.bOD[i].text);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, cardPersonDynamicThreadData.bOz == 40 && cardPersonDynamicThreadData.bOB == 2);
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
