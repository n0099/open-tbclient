package com.baidu.tieba.card;

import android.content.Context;
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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCoverView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class s extends a<CardPersonDynamicThreadData> {
    private boolean ajL;
    private final View.OnClickListener aoH;
    private TbImageView.a bEM;
    private View.OnClickListener bGB;
    private CustomMessageListener bHt;
    public ThreadViewAndCommentInfoLayout bIZ;
    public PlayVoiceBntNew bIj;
    private ConstrainImageGroup bIl;
    private final View.OnClickListener bIm;
    private final String bIr;
    private final String bIs;
    private FrsCommonImageLayout.b bIv;
    private final View.OnClickListener bIw;
    private CardPersonDynamicThreadData bJa;
    private LinearLayout bJb;
    private TextView bJc;
    private TextView bJd;
    private TextView bJe;
    private TextView bJf;
    private PhotoLiveCoverView bJg;
    private View bJh;
    private TbImageView bJi;
    private ImageView bJj;
    private LinearLayout bJk;
    private TextView bJl;
    private LinearLayout bJm;
    private TextView bJn;
    com.baidu.tieba.view.i bJo;
    private LinearLayout blh;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oV;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIr = "1";
        this.bIs = "2";
        this.mSkinType = 3;
        this.ajL = true;
        this.bJo = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bJa != null && !StringUtils.isNull(s.this.bJa.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bJa.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bGB = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.WA() != null) {
                    s.this.WA().a(view, s.this.bJa);
                }
                if (s.this.bJa.bKP != 33) {
                    if (s.this.bJa.bKP != 60) {
                        s.this.WQ();
                        return;
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bJa.threadData.rX().live_status != 1) {
                        s.this.WW();
                        return;
                    } else {
                        s.this.WV();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.oV.getPageActivity(), s.this.bJa.threadId).cB(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bB(23014).pn()));
            }
        };
        this.bHt = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bJa != null && s.this.bJa.threadId != null && s.this.mTitle != null && s.this.bJf != null && ((String) customResponsedMessage.getData()).equals(s.this.bJa.threadId) && !s.this.WE()) {
                    m.a(s.this.mTitle, s.this.bJa.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bJf, s.this.bJa.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bIv = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.s.5
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void du(int i) {
                s.this.WQ();
            }
        };
        this.bIw = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> WA = s.this.WA();
                if (WA != null) {
                    view.setTag("1");
                    WA.a(view, s.this.bJa);
                }
            }
        };
        this.bIm = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> WA = s.this.WA();
                if (WA != null) {
                    view.setTag("2");
                    WA.a(view, s.this.bJa);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.WA() != null) {
                    s.this.WA().a(view, s.this.bJa);
                }
            }
        };
        this.bEM = new TbImageView.a() { // from class: com.baidu.tieba.card.s.9
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && s.this.bJi != null) {
                    s.this.bJi.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.oV = tbPageContext;
        this.blh = (LinearLayout) this.mRootView.findViewById(d.h.content_layout);
        this.bJb = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bJc = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bJd = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bJe = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bIj = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bIj.setAfterClickListener(this.bIm);
        this.bJf = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bIl = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bIl.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bIl.setChildClickListener(this.bIw);
        this.bIl.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
        this.bJh = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bJi = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bJj = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bJg = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bIZ = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bJk = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bJl = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bJm = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bJm.setVisibility(8);
        this.bJn = (TextView) this.mRootView.findViewById(d.h.tvAlaLivingLogView);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.i(this.bJc, d.e.cp_cont_d);
            ai.i(this.bJd, d.e.cp_cont_b);
            ai.i(this.bJe, d.e.cp_cont_f);
            ai.i(this.mTitle, d.e.cp_cont_b);
            ai.i(this.bJf, d.e.cp_cont_f);
            ai.i(this.bJl, d.e.cp_cont_f);
            if (this.bJa != null && this.bJa.bKP == 60) {
                ai.j(this.bJk, d.e.cp_bg_line_e);
            } else {
                ai.j(this.bJk, d.e.transparent);
            }
            this.bIZ.onChangeSkinType();
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
        this.bJa = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGB);
        }
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        this.bJb.setVisibility(cardPersonDynamicThreadData.bKY ? 0 : 4);
        b(cardPersonDynamicThreadData);
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (c(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bKP == 33) {
                arrayList.add(new m.a(d.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bKP == 1) {
                arrayList.add(new m.a(d.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bKP == 36) {
                arrayList.add(new m.a(d.l.vote));
            }
            if (cardPersonDynamicThreadData.bKP == 2) {
                arrayList.add(new m.a(d.l.interview_live));
            }
            if (cardPersonDynamicThreadData.bKP == 49) {
                arrayList.add(new m.a(d.l.live_in));
            }
            if (cardPersonDynamicThreadData.bKP == 50) {
                arrayList.add(new m.a(d.l.live_record));
            }
            this.mTitle.setText(m.a(getContext(), cardPersonDynamicThreadData.title + " ", (ArrayList<m.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bKP == 60) {
            if (cardPersonDynamicThreadData.threadData.rX() != null && cardPersonDynamicThreadData.threadData.rX().Vt != null && !StringUtils.isNull(cardPersonDynamicThreadData.threadData.rX().Vt.content)) {
                this.mTitle.setText(cardPersonDynamicThreadData.threadData.rX().Vt.content);
                this.mTitle.setVisibility(0);
            } else {
                this.mTitle.setVisibility(8);
            }
        } else if (cardPersonDynamicThreadData.bKP == 11) {
            this.mTitle.setText(cardPersonDynamicThreadData.title + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bJc.setText(cardPersonDynamicThreadData.bKR);
        this.bJd.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bKX != null && cardPersonDynamicThreadData.bKX.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bKX.length; i++) {
                sb.append(al.d(cardPersonDynamicThreadData.bKX[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bKX.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.bar)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.bar));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bJe.setText(sb2);
                this.bJe.setVisibility(0);
            } else {
                this.bJe.setVisibility(8);
            }
        } else {
            this.bJe.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.bKP != 60 && cardPersonDynamicThreadData.bKS != null && cardPersonDynamicThreadData.bKS.length > 0) {
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < cardPersonDynamicThreadData.bKS.length; i2++) {
                sb3.append(cardPersonDynamicThreadData.bKS[i2].text);
            }
            String sb4 = sb3.toString();
            if (sb4.trim().length() > 0) {
                this.bJf.setText(sb4);
                this.bJf.setVisibility(0);
            } else {
                this.bJf.setVisibility(8);
            }
        } else {
            this.bJf.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bKU;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bIj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bIj.setVoiceModel(voiceModel);
            this.bIj.setTag(voiceModel);
            this.bIj.bix();
            if (voiceModel != null) {
                this.bIj.mQ(voiceModel.voice_status.intValue());
            }
        } else {
            this.bIj.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bKT;
        ai.j(this.bJk, d.e.transparent);
        this.bJl.setVisibility(8);
        this.bJm.setVisibility(8);
        this.bJg.setVisibility(8);
        this.bJh.setVisibility(8);
        if (cardPersonDynamicThreadData.bKP == 36) {
            this.bIl.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bKP == 33) {
            this.bIl.setVisibility(8);
            if (com.baidu.tbadk.core.h.oX().pd() && cardPersonDynamicThreadData.bKV != null && !StringUtils.isNull(cardPersonDynamicThreadData.bKV.livecover_src)) {
                this.bJg.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bKV)) {
                    this.bJg.setShowExpression(false);
                } else {
                    this.bJg.setShowExpression(true);
                }
                this.bJg.setShowImage(com.baidu.tbadk.core.h.oX().pd());
                this.bJg.setChooseStyle(d.getShowStyle());
                this.bJg.setData(d);
            }
        } else if (cardPersonDynamicThreadData.bKP == 40 || cardPersonDynamicThreadData.bKP == 50 || cardPersonDynamicThreadData.bKP == 49) {
            this.bIl.setVisibility(8);
            if (com.baidu.tbadk.core.h.oX().pd()) {
                this.bJh.setVisibility(0);
                this.bJj.setVisibility(0);
                this.bJj.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJh.getLayoutParams();
                int width = this.bJh.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams.height = width;
                this.bJh.setLayoutParams(layoutParams);
                if (this.bJa.videoInfo != null || this.bJa.threadData.rX() != null) {
                    this.bJi.setDefaultErrorResource(0);
                    this.bJi.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bJi.setEvent(this.bEM);
                    if (cardPersonDynamicThreadData.threadData.rX() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rX().cover)) {
                        this.bJi.c(cardPersonDynamicThreadData.threadData.rX().cover, 10, false);
                    } else if (this.bJa.videoInfo != null) {
                        this.bJi.c(this.bJa.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (this.bJa.bKP == 60) {
            this.bIl.setVisibility(8);
            if (this.bJa.threadData.rX() != null && this.bJa.threadData.rX().Vs != null) {
                String str = this.bJa.threadData.rX().Vs.user_name;
                if (com.baidu.tbadk.util.v.gU(str) > 14) {
                    str = com.baidu.tbadk.util.v.E(str, 14) + "...";
                }
                this.bJl.setText(m.aF(str + ":", this.bJa.threadData.getTitle()));
                this.bJl.setVisibility(0);
            } else {
                this.bJl.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oX().pd()) {
                this.bJh.setVisibility(0);
                this.bJm.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bJh.getLayoutParams();
                int width2 = this.bJh.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bJh.setLayoutParams(layoutParams2);
                if (this.bJa.threadData.rX() != null) {
                    this.bJi.setDefaultErrorResource(0);
                    this.bJi.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bJi.setEvent(this.bEM);
                    this.bJi.c(cardPersonDynamicThreadData.threadData.rX().cover, 10, false);
                    if (this.bJa.threadData.rX().live_status == 1) {
                        this.bJj.setImageResource(d.g.btn_icon_play_live);
                        this.bJn.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
                        this.bJn.setText(d.l.ala_live_card_view_live_label);
                    } else {
                        this.bJj.setImageResource(d.g.icon_play_video);
                        this.bJn.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding_replay, 0, 0, 0);
                        this.bJn.setText(d.l.ala_live_card_view_record_label);
                    }
                    ai.j(this.bJk, d.e.cp_bg_line_e);
                }
            }
        } else if (com.baidu.tbadk.core.h.oX().pd() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            final bl blVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !al.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.u.u(linkedList) > 0) {
                this.bIl.setVisibility(0);
                this.bIl.setFromCDN(this.ajL);
                this.bIl.setSingleImageRatio(0.67d);
                this.bIl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i3, boolean z) {
                        if (z) {
                            s.this.WQ();
                        } else {
                            s.this.a(linkedList2, i3, blVar);
                        }
                    }
                });
                this.bIl.setImageUrls(linkedList);
            } else {
                this.bIl.setVisibility(8);
            }
        } else {
            this.bIl.setVisibility(8);
        }
        WP();
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.bIZ.setIsShowReadNum(false);
        this.bIZ.setIsShowReplayNum(false);
        this.bIZ.setIsShowAudienceNum(false);
        this.bIZ.setIsShowZanNum(false);
        if (cardPersonDynamicThreadData.bKZ && cardPersonDynamicThreadData.threadData.rx() < 0) {
            this.bIZ.setVisibility(8);
            if (this.blh != null) {
                this.blh.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40));
            }
        } else if (cardPersonDynamicThreadData.bKP == 60) {
            this.bIZ.setVisibility(0);
            if (this.bJa.threadData.rX().live_status == 1) {
                this.bIZ.setIsShowAudienceNum(true);
                this.bIZ.setIsShowZanNum(true);
            } else {
                this.bIZ.setIsShowReadNum(true);
                this.bIZ.setIsShowReplayNum(true);
            }
            this.bIZ.setData(cardPersonDynamicThreadData.threadData);
            if (this.blh != null) {
                this.blh.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34));
            }
        } else {
            this.bIZ.setIsShowReadNum(true);
            this.bIZ.setIsShowReplayNum(true);
            this.bIZ.setVisibility(0);
            this.bIZ.setData(cardPersonDynamicThreadData.threadData);
            if (this.blh != null) {
                this.blh.setPadding(0, 0, 0, 0);
            }
        }
        if (cardPersonDynamicThreadData.bKP == 60) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIZ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            this.bIZ.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bIZ.getLayoutParams();
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds28);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
        this.bIZ.setLayoutParams(layoutParams2);
    }

    private void WP() {
        this.bIj.setClickable(true);
        int childCount = this.bIl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIl.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void WV() {
        if (this.bJa != null && this.bJa.threadData != null && this.bJa.threadData.rX() != null) {
            if (!com.baidu.adp.lib.util.i.hr()) {
                com.baidu.adp.lib.util.k.showToast(this.oV.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!WE()) {
                m.je(this.bJa.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bJa.threadData.rX());
            if (this.bJa.threadData.rX().Vs != null) {
                alaLiveInfoCoreData.setUserName(this.bJa.threadData.rX().Vs.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.oV.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WW() {
        if (this.bJa != null && this.bJa.threadData != null && this.bJa.threadData.rX() != null && this.bJa.threadData.rX().Vt != null) {
            if (!WE()) {
                m.je(this.bJa.threadId);
            }
            if (this.bJa.threadData.rX().Vt.record_tid <= 0) {
                WV();
                return;
            }
            String valueOf = String.valueOf(this.bJa.threadData.rX().Vt.record_tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oV.getPageActivity()).createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        if (this.bJa != null) {
            if (!WE()) {
                m.je(this.bJa.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oV.getPageActivity()).createCfgForPersonCenter(this.bJa.threadId, this.bJa.bKM, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WE() {
        return this.bJa.bKr && !this.bJa.aDv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIl != null) {
            this.bIl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIl != null) {
            this.bIl.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.oV.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajL ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(blVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.ajL ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.d(blVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oV.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bKP == 33 || cardPersonDynamicThreadData.bKP == 1 || cardPersonDynamicThreadData.bKP == 2 || cardPersonDynamicThreadData.bKP == 49 || cardPersonDynamicThreadData.bKP == 50;
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bKV != null) {
            if (cardPersonDynamicThreadData.bKV.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bKV.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bKV.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bKV.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bKV.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bKV.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bKV.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bKV.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bKV.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bKV.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bKS != null && cardPersonDynamicThreadData.bKS.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bKS.length; i++) {
                sb.append(cardPersonDynamicThreadData.bKS[i].text);
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
                eVar.em(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }
}
