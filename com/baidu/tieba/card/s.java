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
    private boolean aiq;
    private TbPageContext<?> ako;
    private final View.OnClickListener ann;
    private TbImageView.a bCT;
    private View.OnClickListener bEI;
    private CustomMessageListener bFA;
    private FrsCommonImageLayout.b bGC;
    private final View.OnClickListener bGD;
    public PlayVoiceBntNew bGq;
    private ConstrainImageGroup bGs;
    private final View.OnClickListener bGt;
    private final String bGy;
    private final String bGz;
    public ThreadViewAndCommentInfoLayout bHg;
    private CardPersonDynamicThreadData bHh;
    private LinearLayout bHi;
    private TextView bHj;
    private TextView bHk;
    private TextView bHl;
    private TextView bHm;
    private PhotoLiveCoverView bHn;
    private View bHo;
    private TbImageView bHp;
    private ImageView bHq;
    private LinearLayout bHr;
    private TextView bHs;
    private LinearLayout bHt;
    private TextView bHu;
    com.baidu.tieba.view.i bHv;
    private LinearLayout bjT;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGy = "1";
        this.bGz = "2";
        this.mSkinType = 3;
        this.aiq = true;
        this.bHv = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bHh != null && !StringUtils.isNull(s.this.bHh.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bHh.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.VZ() != null) {
                    s.this.VZ().a(view, s.this.bHh);
                }
                if (s.this.bHh.bIW != 33) {
                    if (s.this.bHh.bIW != 60) {
                        s.this.Wp();
                        return;
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bHh.threadData.rN().live_status != 1) {
                        s.this.Wv();
                        return;
                    } else {
                        s.this.Wu();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.ako.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.ako.getPageActivity(), s.this.bHh.threadId).cv(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bz(23014).pd()));
            }
        };
        this.bFA = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bHh != null && s.this.bHh.threadId != null && s.this.mTitle != null && s.this.bHm != null && ((String) customResponsedMessage.getData()).equals(s.this.bHh.threadId) && !s.this.Wd()) {
                    m.a(s.this.mTitle, s.this.bHh.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bHm, s.this.bHh.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bGC = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.s.5
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void ds(int i) {
                s.this.Wp();
            }
        };
        this.bGD = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> VZ = s.this.VZ();
                if (VZ != null) {
                    view.setTag("1");
                    VZ.a(view, s.this.bHh);
                }
            }
        };
        this.bGt = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> VZ = s.this.VZ();
                if (VZ != null) {
                    view.setTag("2");
                    VZ.a(view, s.this.bHh);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.VZ() != null) {
                    s.this.VZ().a(view, s.this.bHh);
                }
            }
        };
        this.bCT = new TbImageView.a() { // from class: com.baidu.tieba.card.s.9
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && s.this.bHp != null) {
                    s.this.bHp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.ako = tbPageContext;
        this.bjT = (LinearLayout) this.mRootView.findViewById(d.h.content_layout);
        this.bHi = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bHj = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bHk = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bHl = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bGq = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bGq.setAfterClickListener(this.bGt);
        this.bHm = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bGs = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bGs.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bGs.setChildClickListener(this.bGD);
        this.bGs.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
        this.bHo = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bHp = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bHq = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bHn = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bHg = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bHr = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bHs = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bHt = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bHt.setVisibility(8);
        this.bHu = (TextView) this.mRootView.findViewById(d.h.tvAlaLivingLogView);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.i(this.bHj, d.e.cp_cont_d);
            ai.i(this.bHk, d.e.cp_cont_b);
            ai.i(this.bHl, d.e.cp_cont_f);
            ai.i(this.mTitle, d.e.cp_cont_b);
            ai.i(this.bHm, d.e.cp_cont_f);
            ai.i(this.bHs, d.e.cp_cont_f);
            if (this.bHh != null && this.bHh.bIW == 60) {
                ai.j(this.bHr, d.e.cp_bg_line_e);
            } else {
                ai.j(this.bHr, d.e.transparent);
            }
            this.bHg.onChangeSkinType();
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
        this.bHh = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        this.bHi.setVisibility(cardPersonDynamicThreadData.bJf ? 0 : 4);
        b(cardPersonDynamicThreadData);
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (c(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bIW == 33) {
                arrayList.add(new m.a(d.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bIW == 1) {
                arrayList.add(new m.a(d.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bIW == 36) {
                arrayList.add(new m.a(d.l.vote));
            }
            if (cardPersonDynamicThreadData.bIW == 2) {
                arrayList.add(new m.a(d.l.interview_live));
            }
            if (cardPersonDynamicThreadData.bIW == 49) {
                arrayList.add(new m.a(d.l.live_in));
            }
            if (cardPersonDynamicThreadData.bIW == 50) {
                arrayList.add(new m.a(d.l.live_record));
            }
            this.mTitle.setText(m.a(getContext(), cardPersonDynamicThreadData.title + " ", (ArrayList<m.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bIW == 60) {
            if (cardPersonDynamicThreadData.threadData.rN() != null && cardPersonDynamicThreadData.threadData.rN().TS != null && !StringUtils.isNull(cardPersonDynamicThreadData.threadData.rN().TS.content)) {
                this.mTitle.setText(cardPersonDynamicThreadData.threadData.rN().TS.content);
                this.mTitle.setVisibility(0);
            } else {
                this.mTitle.setVisibility(8);
            }
        } else if (cardPersonDynamicThreadData.bIW == 11) {
            this.mTitle.setText(cardPersonDynamicThreadData.title + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bHj.setText(cardPersonDynamicThreadData.bIY);
        this.bHk.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bJe != null && cardPersonDynamicThreadData.bJe.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bJe.length; i++) {
                sb.append(al.d(cardPersonDynamicThreadData.bJe[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bJe.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.bar)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.bar));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bHl.setText(sb2);
                this.bHl.setVisibility(0);
            } else {
                this.bHl.setVisibility(8);
            }
        } else {
            this.bHl.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.bIW != 60 && cardPersonDynamicThreadData.bIZ != null && cardPersonDynamicThreadData.bIZ.length > 0) {
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < cardPersonDynamicThreadData.bIZ.length; i2++) {
                sb3.append(cardPersonDynamicThreadData.bIZ[i2].text);
            }
            String sb4 = sb3.toString();
            if (sb4.trim().length() > 0) {
                this.bHm.setText(sb4);
                this.bHm.setVisibility(0);
            } else {
                this.bHm.setVisibility(8);
            }
        } else {
            this.bHm.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bJb;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bGq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bGq.setVoiceModel(voiceModel);
            this.bGq.setTag(voiceModel);
            this.bGq.bhH();
            if (voiceModel != null) {
                this.bGq.mH(voiceModel.voice_status.intValue());
            }
        } else {
            this.bGq.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bJa;
        ai.j(this.bHr, d.e.transparent);
        this.bHs.setVisibility(8);
        this.bHt.setVisibility(8);
        this.bHn.setVisibility(8);
        this.bHo.setVisibility(8);
        if (cardPersonDynamicThreadData.bIW == 36) {
            this.bGs.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bIW == 33) {
            this.bGs.setVisibility(8);
            if (com.baidu.tbadk.core.h.oN().oT() && cardPersonDynamicThreadData.bJc != null && !StringUtils.isNull(cardPersonDynamicThreadData.bJc.livecover_src)) {
                this.bHn.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bJc)) {
                    this.bHn.setShowExpression(false);
                } else {
                    this.bHn.setShowExpression(true);
                }
                this.bHn.setShowImage(com.baidu.tbadk.core.h.oN().oT());
                this.bHn.setChooseStyle(d.getShowStyle());
                this.bHn.setData(d);
            }
        } else if (cardPersonDynamicThreadData.bIW == 40 || cardPersonDynamicThreadData.bIW == 50 || cardPersonDynamicThreadData.bIW == 49) {
            this.bGs.setVisibility(8);
            if (com.baidu.tbadk.core.h.oN().oT()) {
                this.bHo.setVisibility(0);
                this.bHq.setVisibility(0);
                this.bHq.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHo.getLayoutParams();
                int width = this.bHo.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams.height = width;
                this.bHo.setLayoutParams(layoutParams);
                if (this.bHh.videoInfo != null || this.bHh.threadData.rN() != null) {
                    this.bHp.setDefaultErrorResource(0);
                    this.bHp.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bHp.setEvent(this.bCT);
                    if (cardPersonDynamicThreadData.threadData.rN() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rN().cover)) {
                        this.bHp.c(cardPersonDynamicThreadData.threadData.rN().cover, 10, false);
                    } else if (this.bHh.videoInfo != null) {
                        this.bHp.c(this.bHh.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (this.bHh.bIW == 60) {
            this.bGs.setVisibility(8);
            if (this.bHh.threadData.rN() != null && this.bHh.threadData.rN().TR != null) {
                String str = this.bHh.threadData.rN().TR.user_name;
                if (com.baidu.tbadk.util.v.gP(str) > 14) {
                    str = com.baidu.tbadk.util.v.E(str, 14) + "...";
                }
                this.bHs.setText(m.aF(str + ":", this.bHh.threadData.getTitle()));
                this.bHs.setVisibility(0);
            } else {
                this.bHs.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oN().oT()) {
                this.bHo.setVisibility(0);
                this.bHt.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bHo.getLayoutParams();
                int width2 = this.bHo.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bHo.setLayoutParams(layoutParams2);
                if (this.bHh.threadData.rN() != null) {
                    this.bHp.setDefaultErrorResource(0);
                    this.bHp.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bHp.setEvent(this.bCT);
                    this.bHp.c(cardPersonDynamicThreadData.threadData.rN().cover, 10, false);
                    if (this.bHh.threadData.rN().live_status == 1) {
                        this.bHq.setImageResource(d.g.btn_icon_play_live);
                        this.bHu.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
                        this.bHu.setText(d.l.ala_live_card_view_live_label);
                    } else {
                        this.bHq.setImageResource(d.g.icon_play_video);
                        this.bHu.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding_replay, 0, 0, 0);
                        this.bHu.setText(d.l.ala_live_card_view_record_label);
                    }
                    ai.j(this.bHr, d.e.cp_bg_line_e);
                }
            }
        } else if (com.baidu.tbadk.core.h.oN().oT() && mediaDataArr.length > 0) {
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
                this.bGs.setVisibility(0);
                this.bGs.setFromCDN(this.aiq);
                this.bGs.setSingleImageRatio(0.67d);
                this.bGs.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i3, boolean z) {
                        if (z) {
                            s.this.Wp();
                        } else {
                            s.this.a(linkedList2, i3, blVar);
                        }
                    }
                });
                this.bGs.setImageUrls(linkedList);
            } else {
                this.bGs.setVisibility(8);
            }
        } else {
            this.bGs.setVisibility(8);
        }
        Wo();
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.bHg.setIsShowReadNum(false);
        this.bHg.setIsShowReplayNum(false);
        this.bHg.setIsShowAudienceNum(false);
        this.bHg.setIsShowZanNum(false);
        if (cardPersonDynamicThreadData.bJg && cardPersonDynamicThreadData.threadData.rn() < 0) {
            this.bHg.setVisibility(8);
            if (this.bjT != null) {
                this.bjT.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40));
            }
        } else if (cardPersonDynamicThreadData.bIW == 60) {
            this.bHg.setVisibility(0);
            if (this.bHh.threadData.rN().live_status == 1) {
                this.bHg.setIsShowAudienceNum(true);
                this.bHg.setIsShowZanNum(true);
            } else {
                this.bHg.setIsShowReadNum(true);
                this.bHg.setIsShowReplayNum(true);
            }
            this.bHg.setData(cardPersonDynamicThreadData.threadData);
            if (this.bjT != null) {
                this.bjT.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34));
            }
        } else {
            this.bHg.setIsShowReadNum(true);
            this.bHg.setIsShowReplayNum(true);
            this.bHg.setVisibility(0);
            this.bHg.setData(cardPersonDynamicThreadData.threadData);
            if (this.bjT != null) {
                this.bjT.setPadding(0, 0, 0, 0);
            }
        }
        if (cardPersonDynamicThreadData.bIW == 60) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHg.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            this.bHg.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bHg.getLayoutParams();
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds28);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
        this.bHg.setLayoutParams(layoutParams2);
    }

    private void Wo() {
        this.bGq.setClickable(true);
        int childCount = this.bGs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bGs.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void Wu() {
        if (this.bHh != null && this.bHh.threadData != null && this.bHh.threadData.rN() != null) {
            if (!com.baidu.adp.lib.util.i.hh()) {
                com.baidu.adp.lib.util.k.showToast(this.ako.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!Wd()) {
                m.iY(this.bHh.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bHh.threadData.rN());
            if (this.bHh.threadData.rN().TR != null) {
                alaLiveInfoCoreData.setUserName(this.bHh.threadData.rN().TR.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.ako.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wv() {
        if (this.bHh != null && this.bHh.threadData != null && this.bHh.threadData.rN() != null && this.bHh.threadData.rN().TS != null) {
            if (!Wd()) {
                m.iY(this.bHh.threadId);
            }
            if (this.bHh.threadData.rN().TS.record_tid <= 0) {
                Wu();
                return;
            }
            String valueOf = String.valueOf(this.bHh.threadData.rN().TS.record_tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ako.getPageActivity()).createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        if (this.bHh != null) {
            if (!Wd()) {
                m.iY(this.bHh.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ako.getPageActivity()).createCfgForPersonCenter(this.bHh.threadId, this.bHh.bIT, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wd() {
        return this.bHh.bIy && !this.bHh.aCd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bGs != null) {
            this.bGs.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bGs != null) {
            this.bGs.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ako.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiq ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.aiq ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ako.getPageActivity()).createConfig(arrayList, i, blVar.rA(), String.valueOf(blVar.getFid()), blVar.getTid(), this.aiq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bIW == 33 || cardPersonDynamicThreadData.bIW == 1 || cardPersonDynamicThreadData.bIW == 2 || cardPersonDynamicThreadData.bIW == 49 || cardPersonDynamicThreadData.bIW == 50;
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bJc != null) {
            if (cardPersonDynamicThreadData.bJc.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bJc.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bJc.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bJc.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bJc.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bJc.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bJc.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bJc.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bJc.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bJc.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bIZ != null && cardPersonDynamicThreadData.bIZ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bIZ.length; i++) {
                sb.append(cardPersonDynamicThreadData.bIZ[i].text);
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
                eVar.ek(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }
}
