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
    private boolean ajJ;
    private TbPageContext<?> alI;
    private final View.OnClickListener aoG;
    private TbImageView.a bEd;
    private View.OnClickListener bFS;
    private CustomMessageListener bGK;
    public PlayVoiceBntNew bHA;
    private ConstrainImageGroup bHC;
    private final View.OnClickListener bHD;
    private final String bHI;
    private final String bHJ;
    private FrsCommonImageLayout.b bHM;
    private final View.OnClickListener bHN;
    private ImageView bIA;
    private LinearLayout bIB;
    private TextView bIC;
    private LinearLayout bID;
    private TextView bIE;
    com.baidu.tieba.view.i bIF;
    public ThreadViewAndCommentInfoLayout bIq;
    private CardPersonDynamicThreadData bIr;
    private LinearLayout bIs;
    private TextView bIt;
    private TextView bIu;
    private TextView bIv;
    private TextView bIw;
    private PhotoLiveCoverView bIx;
    private View bIy;
    private TbImageView bIz;
    private LinearLayout bld;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHI = "1";
        this.bHJ = "2";
        this.mSkinType = 3;
        this.ajJ = true;
        this.bIF = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bIr != null && !StringUtils.isNull(s.this.bIr.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bIr.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.We() != null) {
                    s.this.We().a(view, s.this.bIr);
                }
                if (s.this.bIr.bKg != 33) {
                    if (s.this.bIr.bKg != 60) {
                        s.this.Wu();
                        return;
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bIr.threadData.rX().live_status != 1) {
                        s.this.WA();
                        return;
                    } else {
                        s.this.Wz();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.alI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.alI.getPageActivity(), s.this.bIr.threadId).cB(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bB(23014).pn()));
            }
        };
        this.bGK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bIr != null && s.this.bIr.threadId != null && s.this.mTitle != null && s.this.bIw != null && ((String) customResponsedMessage.getData()).equals(s.this.bIr.threadId) && !s.this.Wi()) {
                    m.a(s.this.mTitle, s.this.bIr.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bIw, s.this.bIr.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bHM = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.s.5
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void du(int i) {
                s.this.Wu();
            }
        };
        this.bHN = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> We = s.this.We();
                if (We != null) {
                    view.setTag("1");
                    We.a(view, s.this.bIr);
                }
            }
        };
        this.bHD = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> We = s.this.We();
                if (We != null) {
                    view.setTag("2");
                    We.a(view, s.this.bIr);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.We() != null) {
                    s.this.We().a(view, s.this.bIr);
                }
            }
        };
        this.bEd = new TbImageView.a() { // from class: com.baidu.tieba.card.s.9
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && s.this.bIz != null) {
                    s.this.bIz.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.alI = tbPageContext;
        this.bld = (LinearLayout) this.mRootView.findViewById(d.h.content_layout);
        this.bIs = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bIt = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bIu = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bIv = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bHA = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bHA.setAfterClickListener(this.bHD);
        this.bIw = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bHC = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bHC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bHC.setChildClickListener(this.bHN);
        this.bHC.setImageProcessor(new com.baidu.tbadk.widget.layout.f(3));
        this.bIy = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bIz = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bIA = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bIx = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bIq = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bIB = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bIC = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bID = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bID.setVisibility(8);
        this.bIE = (TextView) this.mRootView.findViewById(d.h.tvAlaLivingLogView);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.i(this.bIt, d.e.cp_cont_d);
            ai.i(this.bIu, d.e.cp_cont_b);
            ai.i(this.bIv, d.e.cp_cont_f);
            ai.i(this.mTitle, d.e.cp_cont_b);
            ai.i(this.bIw, d.e.cp_cont_f);
            ai.i(this.bIC, d.e.cp_cont_f);
            if (this.bIr != null && this.bIr.bKg == 60) {
                ai.j(this.bIB, d.e.cp_bg_line_e);
            } else {
                ai.j(this.bIB, d.e.transparent);
            }
            this.bIq.onChangeSkinType();
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
        this.bIr = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        this.bIs.setVisibility(cardPersonDynamicThreadData.bKp ? 0 : 4);
        b(cardPersonDynamicThreadData);
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (c(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bKg == 33) {
                arrayList.add(new m.a(d.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bKg == 1) {
                arrayList.add(new m.a(d.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bKg == 36) {
                arrayList.add(new m.a(d.l.vote));
            }
            if (cardPersonDynamicThreadData.bKg == 2) {
                arrayList.add(new m.a(d.l.interview_live));
            }
            if (cardPersonDynamicThreadData.bKg == 49) {
                arrayList.add(new m.a(d.l.live_in));
            }
            if (cardPersonDynamicThreadData.bKg == 50) {
                arrayList.add(new m.a(d.l.live_record));
            }
            this.mTitle.setText(m.a(getContext(), cardPersonDynamicThreadData.title + " ", (ArrayList<m.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bKg == 60) {
            if (cardPersonDynamicThreadData.threadData.rX() != null && cardPersonDynamicThreadData.threadData.rX().Vr != null && !StringUtils.isNull(cardPersonDynamicThreadData.threadData.rX().Vr.content)) {
                this.mTitle.setText(cardPersonDynamicThreadData.threadData.rX().Vr.content);
                this.mTitle.setVisibility(0);
            } else {
                this.mTitle.setVisibility(8);
            }
        } else if (cardPersonDynamicThreadData.bKg == 11) {
            this.mTitle.setText(cardPersonDynamicThreadData.title + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bIt.setText(cardPersonDynamicThreadData.bKi);
        this.bIu.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bKo != null && cardPersonDynamicThreadData.bKo.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bKo.length; i++) {
                sb.append(al.d(cardPersonDynamicThreadData.bKo[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bKo.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.bar)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.bar));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bIv.setText(sb2);
                this.bIv.setVisibility(0);
            } else {
                this.bIv.setVisibility(8);
            }
        } else {
            this.bIv.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.bKg != 60 && cardPersonDynamicThreadData.bKj != null && cardPersonDynamicThreadData.bKj.length > 0) {
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < cardPersonDynamicThreadData.bKj.length; i2++) {
                sb3.append(cardPersonDynamicThreadData.bKj[i2].text);
            }
            String sb4 = sb3.toString();
            if (sb4.trim().length() > 0) {
                this.bIw.setText(sb4);
                this.bIw.setVisibility(0);
            } else {
                this.bIw.setVisibility(8);
            }
        } else {
            this.bIw.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bKl;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bHA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bHA.setVoiceModel(voiceModel);
            this.bHA.setTag(voiceModel);
            this.bHA.bhR();
            if (voiceModel != null) {
                this.bHA.mG(voiceModel.voice_status.intValue());
            }
        } else {
            this.bHA.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bKk;
        ai.j(this.bIB, d.e.transparent);
        this.bIC.setVisibility(8);
        this.bID.setVisibility(8);
        this.bIx.setVisibility(8);
        this.bIy.setVisibility(8);
        if (cardPersonDynamicThreadData.bKg == 36) {
            this.bHC.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bKg == 33) {
            this.bHC.setVisibility(8);
            if (com.baidu.tbadk.core.h.oX().pd() && cardPersonDynamicThreadData.bKm != null && !StringUtils.isNull(cardPersonDynamicThreadData.bKm.livecover_src)) {
                this.bIx.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bKm)) {
                    this.bIx.setShowExpression(false);
                } else {
                    this.bIx.setShowExpression(true);
                }
                this.bIx.setShowImage(com.baidu.tbadk.core.h.oX().pd());
                this.bIx.setChooseStyle(d.getShowStyle());
                this.bIx.setData(d);
            }
        } else if (cardPersonDynamicThreadData.bKg == 40 || cardPersonDynamicThreadData.bKg == 50 || cardPersonDynamicThreadData.bKg == 49) {
            this.bHC.setVisibility(8);
            if (com.baidu.tbadk.core.h.oX().pd()) {
                this.bIy.setVisibility(0);
                this.bIA.setVisibility(0);
                this.bIA.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIy.getLayoutParams();
                int width = this.bIy.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams.height = width;
                this.bIy.setLayoutParams(layoutParams);
                if (this.bIr.videoInfo != null || this.bIr.threadData.rX() != null) {
                    this.bIz.setDefaultErrorResource(0);
                    this.bIz.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bIz.setEvent(this.bEd);
                    if (cardPersonDynamicThreadData.threadData.rX() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rX().cover)) {
                        this.bIz.c(cardPersonDynamicThreadData.threadData.rX().cover, 10, false);
                    } else if (this.bIr.videoInfo != null) {
                        this.bIz.c(this.bIr.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (this.bIr.bKg == 60) {
            this.bHC.setVisibility(8);
            if (this.bIr.threadData.rX() != null && this.bIr.threadData.rX().Vq != null) {
                String str = this.bIr.threadData.rX().Vq.user_name;
                if (com.baidu.tbadk.util.v.gU(str) > 14) {
                    str = com.baidu.tbadk.util.v.E(str, 14) + "...";
                }
                this.bIC.setText(m.aF(str + ":", this.bIr.threadData.getTitle()));
                this.bIC.setVisibility(0);
            } else {
                this.bIC.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oX().pd()) {
                this.bIy.setVisibility(0);
                this.bID.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bIy.getLayoutParams();
                int width2 = this.bIy.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bIy.setLayoutParams(layoutParams2);
                if (this.bIr.threadData.rX() != null) {
                    this.bIz.setDefaultErrorResource(0);
                    this.bIz.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bIz.setEvent(this.bEd);
                    this.bIz.c(cardPersonDynamicThreadData.threadData.rX().cover, 10, false);
                    if (this.bIr.threadData.rX().live_status == 1) {
                        this.bIA.setImageResource(d.g.btn_icon_play_live);
                        this.bIE.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
                        this.bIE.setText(d.l.ala_live_card_view_live_label);
                    } else {
                        this.bIA.setImageResource(d.g.icon_play_video);
                        this.bIE.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding_replay, 0, 0, 0);
                        this.bIE.setText(d.l.ala_live_card_view_record_label);
                    }
                    ai.j(this.bIB, d.e.cp_bg_line_e);
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
                this.bHC.setVisibility(0);
                this.bHC.setFromCDN(this.ajJ);
                this.bHC.setSingleImageRatio(0.67d);
                this.bHC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i3, boolean z) {
                        if (z) {
                            s.this.Wu();
                        } else {
                            s.this.a(linkedList2, i3, blVar);
                        }
                    }
                });
                this.bHC.setImageUrls(linkedList);
            } else {
                this.bHC.setVisibility(8);
            }
        } else {
            this.bHC.setVisibility(8);
        }
        Wt();
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.bIq.setIsShowReadNum(false);
        this.bIq.setIsShowReplayNum(false);
        this.bIq.setIsShowAudienceNum(false);
        this.bIq.setIsShowZanNum(false);
        if (cardPersonDynamicThreadData.bKq && cardPersonDynamicThreadData.threadData.rx() < 0) {
            this.bIq.setVisibility(8);
            if (this.bld != null) {
                this.bld.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40));
            }
        } else if (cardPersonDynamicThreadData.bKg == 60) {
            this.bIq.setVisibility(0);
            if (this.bIr.threadData.rX().live_status == 1) {
                this.bIq.setIsShowAudienceNum(true);
                this.bIq.setIsShowZanNum(true);
            } else {
                this.bIq.setIsShowReadNum(true);
                this.bIq.setIsShowReplayNum(true);
            }
            this.bIq.setData(cardPersonDynamicThreadData.threadData);
            if (this.bld != null) {
                this.bld.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34));
            }
        } else {
            this.bIq.setIsShowReadNum(true);
            this.bIq.setIsShowReplayNum(true);
            this.bIq.setVisibility(0);
            this.bIq.setData(cardPersonDynamicThreadData.threadData);
            if (this.bld != null) {
                this.bld.setPadding(0, 0, 0, 0);
            }
        }
        if (cardPersonDynamicThreadData.bKg == 60) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIq.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
            this.bIq.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bIq.getLayoutParams();
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds28);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
        this.bIq.setLayoutParams(layoutParams2);
    }

    private void Wt() {
        this.bHA.setClickable(true);
        int childCount = this.bHC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bHC.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void Wz() {
        if (this.bIr != null && this.bIr.threadData != null && this.bIr.threadData.rX() != null) {
            if (!com.baidu.adp.lib.util.i.hr()) {
                com.baidu.adp.lib.util.k.showToast(this.alI.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!Wi()) {
                m.jd(this.bIr.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bIr.threadData.rX());
            if (this.bIr.threadData.rX().Vq != null) {
                alaLiveInfoCoreData.setUserName(this.bIr.threadData.rX().Vq.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.alI.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WA() {
        if (this.bIr != null && this.bIr.threadData != null && this.bIr.threadData.rX() != null && this.bIr.threadData.rX().Vr != null) {
            if (!Wi()) {
                m.jd(this.bIr.threadId);
            }
            if (this.bIr.threadData.rX().Vr.record_tid <= 0) {
                Wz();
                return;
            }
            String valueOf = String.valueOf(this.bIr.threadData.rX().Vr.record_tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.alI.getPageActivity()).createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wu() {
        if (this.bIr != null) {
            if (!Wi()) {
                m.jd(this.bIr.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.alI.getPageActivity()).createCfgForPersonCenter(this.bIr.threadId, this.bIr.bKd, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wi() {
        return this.bIr.bJI && !this.bIr.aDu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bHC != null) {
            this.bHC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bHC != null) {
            this.bHC.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.alI.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajJ ? 13 : 14;
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
                    imageUrlData2.urlType = this.ajJ ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.d(blVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.alI.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bKg == 33 || cardPersonDynamicThreadData.bKg == 1 || cardPersonDynamicThreadData.bKg == 2 || cardPersonDynamicThreadData.bKg == 49 || cardPersonDynamicThreadData.bKg == 50;
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bKm != null) {
            if (cardPersonDynamicThreadData.bKm.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bKm.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bKm.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bKm.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bKm.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bKm.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bKm.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bKm.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bKm.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bKm.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bKj != null && cardPersonDynamicThreadData.bKj.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bKj.length; i++) {
                sb.append(cardPersonDynamicThreadData.bKj[i].text);
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
