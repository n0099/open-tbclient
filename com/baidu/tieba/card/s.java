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
    private TbImageView.a bEN;
    private View.OnClickListener bGC;
    private CustomMessageListener bHu;
    public PlayVoiceBntNew bIk;
    private ConstrainImageGroup bIm;
    private final View.OnClickListener bIn;
    private final String bIs;
    private final String bIt;
    private FrsCommonImageLayout.b bIw;
    private final View.OnClickListener bIx;
    public ThreadViewAndCommentInfoLayout bJa;
    private CardPersonDynamicThreadData bJb;
    private LinearLayout bJc;
    private TextView bJd;
    private TextView bJe;
    private TextView bJf;
    private TextView bJg;
    private PhotoLiveCoverView bJh;
    private View bJi;
    private TbImageView bJj;
    private ImageView bJk;
    private LinearLayout bJl;
    private TextView bJm;
    private LinearLayout bJn;
    private TextView bJo;
    com.baidu.tieba.view.i bJp;
    private LinearLayout bli;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oW;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIs = "1";
        this.bIt = "2";
        this.mSkinType = 3;
        this.ajL = true;
        this.bJp = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bJb != null && !StringUtils.isNull(s.this.bJb.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bJb.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Wx() != null) {
                    s.this.Wx().a(view, s.this.bJb);
                }
                if (s.this.bJb.bKQ != 33) {
                    if (s.this.bJb.bKQ != 60) {
                        s.this.WN();
                        return;
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bJb.threadData.rY().live_status != 1) {
                        s.this.WT();
                        return;
                    } else {
                        s.this.WS();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.oW.getPageActivity(), s.this.bJb.threadId).cE(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bB(23014).po()));
            }
        };
        this.bHu = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bJb != null && s.this.bJb.threadId != null && s.this.mTitle != null && s.this.bJg != null && ((String) customResponsedMessage.getData()).equals(s.this.bJb.threadId) && !s.this.WB()) {
                    m.a(s.this.mTitle, s.this.bJb.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bJg, s.this.bJb.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bIw = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.s.5
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void du(int i) {
                s.this.WN();
            }
        };
        this.bIx = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Wx = s.this.Wx();
                if (Wx != null) {
                    view.setTag("1");
                    Wx.a(view, s.this.bJb);
                }
            }
        };
        this.bIn = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Wx = s.this.Wx();
                if (Wx != null) {
                    view.setTag("2");
                    Wx.a(view, s.this.bJb);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Wx() != null) {
                    s.this.Wx().a(view, s.this.bJb);
                }
            }
        };
        this.bEN = new TbImageView.a() { // from class: com.baidu.tieba.card.s.9
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && s.this.bJj != null) {
                    s.this.bJj.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.oW = tbPageContext;
        this.bli = (LinearLayout) this.mRootView.findViewById(d.h.content_layout);
        this.bJc = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bJd = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bJe = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bJf = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bIk = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bIk.setAfterClickListener(this.bIn);
        this.bJg = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bIm = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bIm.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bIm.setChildClickListener(this.bIx);
        this.bIm.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
        this.bJi = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bJj = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bJk = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bJh = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bJa = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bJl = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bJm = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bJn = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bJn.setVisibility(8);
        this.bJo = (TextView) this.mRootView.findViewById(d.h.tvAlaLivingLogView);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.i(this.bJd, d.e.cp_cont_d);
            ai.i(this.bJe, d.e.cp_cont_b);
            ai.i(this.bJf, d.e.cp_cont_f);
            ai.i(this.mTitle, d.e.cp_cont_b);
            ai.i(this.bJg, d.e.cp_cont_f);
            ai.i(this.bJm, d.e.cp_cont_f);
            if (this.bJb != null && this.bJb.bKQ == 60) {
                ai.j(this.bJl, d.e.cp_bg_line_e);
            } else {
                ai.j(this.bJl, d.e.transparent);
            }
            this.bJa.onChangeSkinType();
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
        this.bJb = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        this.bJc.setVisibility(cardPersonDynamicThreadData.bKZ ? 0 : 4);
        b(cardPersonDynamicThreadData);
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (c(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bKQ == 33) {
                arrayList.add(new m.a(d.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bKQ == 1) {
                arrayList.add(new m.a(d.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bKQ == 36) {
                arrayList.add(new m.a(d.l.vote));
            }
            if (cardPersonDynamicThreadData.bKQ == 2) {
                arrayList.add(new m.a(d.l.interview_live));
            }
            if (cardPersonDynamicThreadData.bKQ == 49) {
                arrayList.add(new m.a(d.l.live_in));
            }
            if (cardPersonDynamicThreadData.bKQ == 50) {
                arrayList.add(new m.a(d.l.live_record));
            }
            this.mTitle.setText(m.a(getContext(), cardPersonDynamicThreadData.title + " ", (ArrayList<m.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bKQ == 60) {
            if (cardPersonDynamicThreadData.threadData.rY() != null && cardPersonDynamicThreadData.threadData.rY().Vu != null && !StringUtils.isNull(cardPersonDynamicThreadData.threadData.rY().Vu.content)) {
                this.mTitle.setText(cardPersonDynamicThreadData.threadData.rY().Vu.content);
                this.mTitle.setVisibility(0);
            } else {
                this.mTitle.setVisibility(8);
            }
        } else if (cardPersonDynamicThreadData.bKQ == 11) {
            this.mTitle.setText(cardPersonDynamicThreadData.title + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bJd.setText(cardPersonDynamicThreadData.bKS);
        this.bJe.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bKY != null && cardPersonDynamicThreadData.bKY.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bKY.length; i++) {
                sb.append(al.e(cardPersonDynamicThreadData.bKY[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bKY.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.bar)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.bar));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bJf.setText(sb2);
                this.bJf.setVisibility(0);
            } else {
                this.bJf.setVisibility(8);
            }
        } else {
            this.bJf.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.bKQ != 60 && cardPersonDynamicThreadData.bKT != null && cardPersonDynamicThreadData.bKT.length > 0) {
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < cardPersonDynamicThreadData.bKT.length; i2++) {
                sb3.append(cardPersonDynamicThreadData.bKT[i2].text);
            }
            String sb4 = sb3.toString();
            if (sb4.trim().length() > 0) {
                this.bJg.setText(sb4);
                this.bJg.setVisibility(0);
            } else {
                this.bJg.setVisibility(8);
            }
        } else {
            this.bJg.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bKV;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bIk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bIk.setVoiceModel(voiceModel);
            this.bIk.setTag(voiceModel);
            this.bIk.bis();
            if (voiceModel != null) {
                this.bIk.mQ(voiceModel.voice_status.intValue());
            }
        } else {
            this.bIk.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bKU;
        ai.j(this.bJl, d.e.transparent);
        this.bJm.setVisibility(8);
        this.bJn.setVisibility(8);
        this.bJh.setVisibility(8);
        this.bJi.setVisibility(8);
        if (cardPersonDynamicThreadData.bKQ == 36) {
            this.bIm.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bKQ == 33) {
            this.bIm.setVisibility(8);
            if (com.baidu.tbadk.core.h.oY().pe() && cardPersonDynamicThreadData.bKW != null && !StringUtils.isNull(cardPersonDynamicThreadData.bKW.livecover_src)) {
                this.bJh.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bKW)) {
                    this.bJh.setShowExpression(false);
                } else {
                    this.bJh.setShowExpression(true);
                }
                this.bJh.setShowImage(com.baidu.tbadk.core.h.oY().pe());
                this.bJh.setChooseStyle(d.getShowStyle());
                this.bJh.setData(d);
            }
        } else if (cardPersonDynamicThreadData.bKQ == 40 || cardPersonDynamicThreadData.bKQ == 50 || cardPersonDynamicThreadData.bKQ == 49) {
            this.bIm.setVisibility(8);
            if (com.baidu.tbadk.core.h.oY().pe()) {
                this.bJi.setVisibility(0);
                this.bJk.setVisibility(0);
                this.bJk.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJi.getLayoutParams();
                int width = this.bJi.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams.height = width;
                this.bJi.setLayoutParams(layoutParams);
                if (this.bJb.videoInfo != null || this.bJb.threadData.rY() != null) {
                    this.bJj.setDefaultErrorResource(0);
                    this.bJj.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bJj.setEvent(this.bEN);
                    if (cardPersonDynamicThreadData.threadData.rY() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rY().cover)) {
                        this.bJj.c(cardPersonDynamicThreadData.threadData.rY().cover, 10, false);
                    } else if (this.bJb.videoInfo != null) {
                        this.bJj.c(this.bJb.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (this.bJb.bKQ == 60) {
            this.bIm.setVisibility(8);
            if (this.bJb.threadData.rY() != null && this.bJb.threadData.rY().Vt != null) {
                String str = this.bJb.threadData.rY().Vt.user_name;
                if (com.baidu.tbadk.util.v.gX(str) > 14) {
                    str = com.baidu.tbadk.util.v.E(str, 14) + "...";
                }
                this.bJm.setText(m.aG(str + ":", this.bJb.threadData.getTitle()));
                this.bJm.setVisibility(0);
            } else {
                this.bJm.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oY().pe()) {
                this.bJi.setVisibility(0);
                this.bJn.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bJi.getLayoutParams();
                int width2 = this.bJi.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bJi.setLayoutParams(layoutParams2);
                if (this.bJb.threadData.rY() != null) {
                    this.bJj.setDefaultErrorResource(0);
                    this.bJj.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bJj.setEvent(this.bEN);
                    this.bJj.c(cardPersonDynamicThreadData.threadData.rY().cover, 10, false);
                    if (this.bJb.threadData.rY().live_status == 1) {
                        this.bJk.setImageResource(d.g.btn_icon_play_live);
                        this.bJo.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
                        this.bJo.setText(d.l.ala_live_card_view_live_label);
                    } else {
                        this.bJk.setImageResource(d.g.icon_play_video);
                        this.bJo.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding_replay, 0, 0, 0);
                        this.bJo.setText(d.l.ala_live_card_view_record_label);
                    }
                    ai.j(this.bJl, d.e.cp_bg_line_e);
                }
            }
        } else if (com.baidu.tbadk.core.h.oY().pe() && mediaDataArr.length > 0) {
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
                this.bIm.setVisibility(0);
                this.bIm.setFromCDN(this.ajL);
                this.bIm.setSingleImageRatio(0.67d);
                this.bIm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i3, boolean z) {
                        if (z) {
                            s.this.WN();
                        } else {
                            s.this.a(linkedList2, i3, blVar);
                        }
                    }
                });
                this.bIm.setImageUrls(linkedList);
            } else {
                this.bIm.setVisibility(8);
            }
        } else {
            this.bIm.setVisibility(8);
        }
        WM();
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.bJa.setIsShowReadNum(false);
        this.bJa.setIsShowReplayNum(false);
        this.bJa.setIsShowAudienceNum(false);
        this.bJa.setIsShowZanNum(false);
        if (cardPersonDynamicThreadData.bLa && cardPersonDynamicThreadData.threadData.ry() < 0) {
            this.bJa.setVisibility(8);
            if (this.bli != null) {
                this.bli.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40));
            }
        } else if (cardPersonDynamicThreadData.bKQ == 60) {
            this.bJa.setVisibility(0);
            if (this.bJb.threadData.rY().live_status == 1) {
                this.bJa.setIsShowAudienceNum(true);
                this.bJa.setIsShowZanNum(true);
            } else {
                this.bJa.setIsShowReadNum(true);
                this.bJa.setIsShowReplayNum(true);
            }
            this.bJa.setData(cardPersonDynamicThreadData.threadData);
            if (this.bli != null) {
                this.bli.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34));
            }
        } else {
            this.bJa.setIsShowReadNum(true);
            this.bJa.setIsShowReplayNum(true);
            this.bJa.setVisibility(0);
            this.bJa.setData(cardPersonDynamicThreadData.threadData);
            if (this.bli != null) {
                this.bli.setPadding(0, 0, 0, 0);
            }
        }
        if (cardPersonDynamicThreadData.bKQ == 60) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJa.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            this.bJa.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bJa.getLayoutParams();
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds28);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
        this.bJa.setLayoutParams(layoutParams2);
    }

    private void WM() {
        this.bIk.setClickable(true);
        int childCount = this.bIm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIm.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void WS() {
        if (this.bJb != null && this.bJb.threadData != null && this.bJb.threadData.rY() != null) {
            if (!com.baidu.adp.lib.util.i.hr()) {
                com.baidu.adp.lib.util.k.showToast(this.oW.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!WB()) {
                m.jh(this.bJb.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bJb.threadData.rY());
            if (this.bJb.threadData.rY().Vt != null) {
                alaLiveInfoCoreData.setUserName(this.bJb.threadData.rY().Vt.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.oW.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WT() {
        if (this.bJb != null && this.bJb.threadData != null && this.bJb.threadData.rY() != null && this.bJb.threadData.rY().Vu != null) {
            if (!WB()) {
                m.jh(this.bJb.threadId);
            }
            if (this.bJb.threadData.rY().Vu.record_tid <= 0) {
                WS();
                return;
            }
            String valueOf = String.valueOf(this.bJb.threadData.rY().Vu.record_tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oW.getPageActivity()).createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        if (this.bJb != null) {
            if (!WB()) {
                m.jh(this.bJb.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oW.getPageActivity()).createCfgForPersonCenter(this.bJb.threadId, this.bJb.bKN, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WB() {
        return this.bJb.bKs && !this.bJb.aDw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIm != null) {
            this.bIm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIm != null) {
            this.bIm.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.oW.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oW.getPageActivity()).createConfig(arrayList, i, blVar.rL(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bKQ == 33 || cardPersonDynamicThreadData.bKQ == 1 || cardPersonDynamicThreadData.bKQ == 2 || cardPersonDynamicThreadData.bKQ == 49 || cardPersonDynamicThreadData.bKQ == 50;
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bKW != null) {
            if (cardPersonDynamicThreadData.bKW.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bKW.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bKW.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bKW.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bKW.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bKW.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bKW.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bKW.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bKW.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bKW.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bKT != null && cardPersonDynamicThreadData.bKT.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bKT.length; i++) {
                sb.append(cardPersonDynamicThreadData.bKT[i].text);
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
