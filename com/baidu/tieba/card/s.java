package com.baidu.tieba.card;

import android.content.Context;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    private boolean aiG;
    private View aod;
    private View.OnClickListener bJA;
    private TbImageView.a bKT;
    private AlaPlayAnimationView bKx;
    private CustomMessageListener bKy;
    private final String bLA;
    private final String bLB;
    private final View.OnClickListener bLF;
    public PlayVoiceBntNew bLr;
    private TextView bLt;
    private ConstrainImageGroup bLu;
    private final View.OnClickListener bLv;
    private boolean bMA;
    com.baidu.tieba.view.h bMB;
    public ThreadViewAndCommentInfoLayout bMh;
    private CardPersonDynamicThreadData bMi;
    private LinearLayout bMj;
    private TextView bMk;
    private TextView bMl;
    private TextView bMm;
    private PhotoLiveCoverView bMn;
    private View bMo;
    private TbImageView bMp;
    private ImageView bMq;
    private LinearLayout bMr;
    private TextView bMs;
    private LinearLayout bMt;
    private LinearLayout bMu;
    private TextView bMv;
    private TextView bMw;
    private TextView bMx;
    private TextView bMy;
    private View bMz;
    private ThreadCommentAndPraiseInfoLayout bnj;
    private TbPageContext<?> mG;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLA = "1";
        this.bLB = "2";
        this.mSkinType = 3;
        this.aiG = true;
        this.bMB = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.s.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bMi != null && !StringUtils.isNull(s.this.bMi.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bMi.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Xr() != null) {
                    s.this.Xr().a(view, s.this.bMi);
                }
                if (s.this.bMi.bOe != 33) {
                    if (s.this.bMi.bOe != 60) {
                        if (s.this.bMi.bOe != 40 || s.this.bMi.bOg != 2) {
                            s.this.XJ();
                            return;
                        } else {
                            BdToast.b(s.this.getContext(), s.this.getContext().getString(d.l.video_check_click_msg), d.g.icon_toast_game_error).tq();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bMi.threadData.rN().live_status != 1) {
                        s.this.XQ();
                        return;
                    } else {
                        s.this.XP();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.mG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.mG.getPageActivity(), s.this.bMi.threadId).cu(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bF(23014).pj()));
            }
        };
        this.bKy = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bMi != null && s.this.bMi.threadId != null && s.this.mTitle != null && s.this.bLt != null && ((String) customResponsedMessage.getData()).equals(s.this.bMi.threadId) && !s.this.Xv()) {
                    m.a(s.this.mTitle, s.this.bMi.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bLt, s.this.bMi.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bLF = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Xr = s.this.Xr();
                if (Xr != null) {
                    view.setTag("1");
                    Xr.a(view, s.this.bMi);
                }
            }
        };
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Xr = s.this.Xr();
                if (Xr != null) {
                    view.setTag("2");
                    Xr.a(view, s.this.bMi);
                }
            }
        };
        this.bKT = new TbImageView.a() { // from class: com.baidu.tieba.card.s.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && s.this.bMp != null) {
                    s.this.bMp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mG = tbPageContext;
        this.bMj = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bMk = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bMl = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bMm = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bLr = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bLr.setAfterClickListener(this.bLv);
        this.bLt = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bLt.setVisibility(8);
        this.bLu = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bLu.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLu.setChildClickListener(this.bLF);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLu.setImageProcessor(fVar);
        this.bMo = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bMp = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bMq = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bMn = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bMh = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bMu = (LinearLayout) this.mRootView.findViewById(d.h.duration_container);
        this.bMv = (TextView) this.mRootView.findViewById(d.h.video_duration);
        this.bMw = (TextView) this.mRootView.findViewById(d.h.video_play_count);
        this.bMx = (TextView) this.mRootView.findViewById(d.h.audience_count);
        this.bKx = (AlaPlayAnimationView) this.mRootView.findViewById(d.h.ala_play);
        this.bMy = (TextView) this.mRootView.findViewById(d.h.fake_video_state);
        this.bMr = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bMs = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bMt = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bMt.setVisibility(8);
        this.bMz = this.mRootView.findViewById(d.h.divider_line_above_praise);
        this.aod = this.mRootView.findViewById(d.h.divider_line);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.card_thread_info_layout);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this.bJA);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setShareVisible(true);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setFrom(1);
        this.bnj.setShareReportFrom(6);
        this.bnj.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Xr() != null) {
                    s.this.Xr().a(view, s.this.bMi);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.i(this.bMk, d.e.cp_cont_j);
            aj.i(this.bMl, d.e.cp_cont_b);
            aj.i(this.bMm, d.e.cp_cont_f);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.i(this.bLt, d.e.cp_cont_f);
            aj.i(this.bMs, d.e.cp_cont_f);
            this.bMh.onChangeSkinType();
            this.bnj.onChangeSkinType();
            aj.k(this.aod, d.e.cp_bg_line_e);
            aj.k(this.bMs, d.e.cp_bg_line_e);
            aj.k(this.bMz, d.e.cp_bg_line_e);
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
        this.bMi = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJA);
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        this.bMj.setVisibility(cardPersonDynamicThreadData.bOo ? 0 : 4);
        this.aod.setVisibility(cardPersonDynamicThreadData.bOo ? 0 : 8);
        if (cardPersonDynamicThreadData.bOp) {
            this.aod.setVisibility(8);
        }
        this.bMA = cardPersonDynamicThreadData.bOe == 40 && cardPersonDynamicThreadData.bOg == 2;
        d(cardPersonDynamicThreadData);
        this.bMk.setText(cardPersonDynamicThreadData.bOh);
        this.bMl.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bOn != null && cardPersonDynamicThreadData.bOn.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bOn.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.bOn[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bOn.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bMm.setText(sb2);
                this.bMm.setVisibility(0);
            } else {
                this.bMm.setVisibility(8);
            }
        } else {
            this.bMm.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bOk;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bLr.setVisibility(0);
            dB(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bLr.setVoiceModel(voiceModel);
            this.bLr.setTag(voiceModel);
            this.bLr.bgh();
            if (voiceModel != null) {
                this.bLr.nh(voiceModel.voice_status.intValue());
            }
        } else {
            this.bLr.setVisibility(8);
            dB(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bOj;
        aj.j(this.bMr, d.e.transparent);
        this.bMs.setVisibility(8);
        this.bMt.setVisibility(8);
        this.bMr.setVisibility(0);
        this.bMn.setVisibility(8);
        this.bMo.setVisibility(8);
        this.bMy.setVisibility(8);
        this.bMu.setVisibility(8);
        this.bMx.setVisibility(8);
        this.bKx.bxS();
        if (cardPersonDynamicThreadData.bOe == 36) {
            this.bLu.setVisibility(8);
            this.bMz.setVisibility(0);
        } else if (cardPersonDynamicThreadData.bOe == 33) {
            this.bLu.setVisibility(8);
            this.bMz.setVisibility(8);
            if (com.baidu.tbadk.core.h.oT().oZ() && cardPersonDynamicThreadData.bOl != null && !StringUtils.isNull(cardPersonDynamicThreadData.bOl.livecover_src)) {
                this.bMn.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bOl)) {
                    this.bMn.setShowExpression(false);
                } else {
                    this.bMn.setShowExpression(true);
                }
                this.bMn.setShowImage(com.baidu.tbadk.core.h.oT().oZ());
                this.bMn.setChooseStyle(c.getShowStyle());
                this.bMn.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bOe == 40 || this.bMi.bOe == 50) {
            this.bLu.setVisibility(8);
            this.bMz.setVisibility(8);
            if (com.baidu.tbadk.core.h.oT().oZ()) {
                this.bMo.setVisibility(0);
                this.bMq.setVisibility(0);
                this.bMq.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMo.getLayoutParams();
                int width = this.bMo.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds672);
                }
                layoutParams.height = (int) (0.5625d * width);
                this.bMo.setLayoutParams(layoutParams);
                if (this.bMi.videoInfo != null) {
                    this.bMp.setDefaultErrorResource(0);
                    this.bMp.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMp.setEvent(this.bKT);
                    this.bMp.c(this.bMi.videoInfo.thumbnail_url, 17, false);
                    if (this.bMA) {
                        this.bMy.setVisibility(0);
                        this.bMy.setText(String.format(this.mContext.getResources().getString(d.l.video_review_state), new Object[0]));
                    } else {
                        this.bMu.setVisibility(0);
                        this.bMv.setText(am.cY(this.bMi.videoInfo.video_duration.intValue() * 1000));
                        this.bMw.setText(String.format(this.mContext.getResources().getString(d.l.play_count), am.z(this.bMi.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.bMi.bOe == 60 || this.bMi.bOe == 49) {
            this.bLu.setVisibility(8);
            this.bMz.setVisibility(8);
            if (this.bMi.threadData.rN() != null && this.bMi.threadData.rN().UJ != null && this.bMi.bOe == 60) {
                String str = this.bMi.threadData.rN().UJ.user_name;
                if (com.baidu.tbadk.util.u.gQ(str) > 14) {
                    str = com.baidu.tbadk.util.u.E(str, 14) + "...";
                }
                this.bMs.setText(m.aK(str + ":", this.bMi.threadData.getTitle()));
                this.bMs.setVisibility(0);
            } else {
                this.bMs.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oT().oZ()) {
                this.bMo.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bMo.getLayoutParams();
                int width2 = this.bMo.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bMo.setLayoutParams(layoutParams2);
                if (this.bMi.threadData.rN() != null) {
                    this.bMp.setDefaultErrorResource(0);
                    this.bMp.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMp.setEvent(this.bKT);
                    this.bMp.c(cardPersonDynamicThreadData.threadData.rN().cover, 10, false);
                    this.bMq.setImageResource(d.g.btn_icon_play_live_on_n);
                    this.bKx.XT();
                    aj.j(this.bMr, d.e.cp_bg_line_e);
                    this.bMx.setVisibility(0);
                    this.bMx.setText(String.format(this.mContext.getResources().getString(d.l.ala_audience_count_prefix), am.z(this.bMi.threadData.rN().audience_count)));
                }
            }
        } else {
            if (com.baidu.tbadk.core.h.oT().oZ() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.t(linkedList) > 0) {
                    this.bLu.setVisibility(0);
                    this.bMz.setVisibility(8);
                    this.bLu.setFromCDN(this.aiG);
                    this.bLu.setSingleImageRatio(0.67d);
                    this.bLu.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                s.this.XJ();
                            } else {
                                s.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.bLu.setImageMediaList(linkedList);
                } else {
                    this.bLu.setVisibility(8);
                    this.bMz.setVisibility(0);
                }
            } else {
                this.bLu.setVisibility(8);
                this.bMz.setVisibility(0);
            }
            this.bMr.setVisibility(8);
        }
        XI();
        b(cardPersonDynamicThreadData);
    }

    private void dB(boolean z) {
        if (this.bLu != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLu.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            }
            this.bLu.setLayoutParams(layoutParams);
        }
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.bMA) {
                this.bnj.setCommentClickable(false);
                this.bnj.setAgreeClickable(false);
                this.bnj.setShareClickable(false);
            } else {
                this.bnj.setCommentClickable(true);
                this.bnj.setAgreeClickable(true);
                this.bnj.setShareClickable(true);
            }
            this.bnj.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.bOe == 60) {
                this.bnj.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.bOn != null) {
                this.bnj.setMultiForumCount(cardPersonDynamicThreadData.bOn.length);
            }
            this.bnj.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void XI() {
        this.bLr.setClickable(true);
        int childCount = this.bLu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLu.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void XP() {
        if (this.bMi != null && this.bMi.threadData != null && this.bMi.threadData.rN() != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                com.baidu.adp.lib.util.l.showToast(this.mG.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!Xv()) {
                m.jm(this.bMi.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bMi.threadData.rN());
            if (this.bMi.threadData.rN().UJ != null) {
                alaLiveInfoCoreData.setUserName(this.bMi.threadData.rN().UJ.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.mG.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XQ() {
        if (this.bMi != null && this.bMi.threadData != null && this.bMi.threadData.rN() != null && this.bMi.threadData.rN().UK != null) {
            if (!Xv()) {
                m.jm(this.bMi.threadId);
            }
            if (this.bMi.threadData.rN().UK.record_tid <= 0) {
                XP();
                return;
            }
            String valueOf = String.valueOf(this.bMi.threadData.rN().UK.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mG.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        if (this.bMi != null) {
            if (!Xv()) {
                m.jm(this.bMi.threadId);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mG.getPageActivity());
            if (this.bMi.bOe == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(this.bMi.threadId, this.bMi.bOb, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xv() {
        return this.bMi.bNG && !this.bMi.aCa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLu != null) {
            this.bLu.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLu != null) {
            this.bLu.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mG.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aiG ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mG.getPageActivity()).createConfig(arrayList, i, bhVar.rA(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiG, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bOl != null) {
            if (cardPersonDynamicThreadData.bOl.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bOl.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bOl.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bOl.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bOl.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bOl.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bOl.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bOl.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bOl.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bOl.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bOi != null && cardPersonDynamicThreadData.bOi.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bOi.length; i++) {
                sb.append(cardPersonDynamicThreadData.bOi[i].text);
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
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.bMA);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(c));
        this.mTitle.setText(c);
        m.a(this.mTitle, cardPersonDynamicThreadData.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        return true;
    }
}
