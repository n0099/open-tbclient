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
    private boolean aiu;
    private View anR;
    private View.OnClickListener bJo;
    private TbImageView.a bKH;
    private AlaPlayAnimationView bKl;
    private CustomMessageListener bKm;
    public ThreadViewAndCommentInfoLayout bLV;
    private CardPersonDynamicThreadData bLW;
    private LinearLayout bLX;
    private TextView bLY;
    private TextView bLZ;
    public PlayVoiceBntNew bLf;
    private TextView bLh;
    private ConstrainImageGroup bLi;
    private final View.OnClickListener bLj;
    private final String bLo;
    private final String bLp;
    private final View.OnClickListener bLt;
    private TextView bMa;
    private PhotoLiveCoverView bMb;
    private View bMc;
    private TbImageView bMd;
    private ImageView bMe;
    private LinearLayout bMf;
    private TextView bMg;
    private LinearLayout bMh;
    private LinearLayout bMi;
    private TextView bMj;
    private TextView bMk;
    private TextView bMl;
    private TextView bMm;
    private View bMn;
    private boolean bMo;
    com.baidu.tieba.view.h bMp;
    private ThreadCommentAndPraiseInfoLayout bmV;
    private TbPageContext<?> mH;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLo = "1";
        this.bLp = "2";
        this.mSkinType = 3;
        this.aiu = true;
        this.bMp = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.s.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bLW != null && !StringUtils.isNull(s.this.bLW.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bLW.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.e.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.e.cp_link_tip_a));
            }
        };
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Xn() != null) {
                    s.this.Xn().a(view, s.this.bLW);
                }
                if (s.this.bLW.bNS != 33) {
                    if (s.this.bLW.bNS != 60) {
                        if (s.this.bLW.bNS != 40 || s.this.bLW.bNU != 2) {
                            s.this.XF();
                            return;
                        } else {
                            BdToast.b(s.this.getContext(), s.this.getContext().getString(d.l.video_check_click_msg), d.g.icon_toast_game_error).tj();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bLW.threadData.rG().live_status != 1) {
                        s.this.XM();
                        return;
                    } else {
                        s.this.XL();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.mH.getPageActivity(), s.this.bLW.threadId).ct(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bE(23014).pc()));
            }
        };
        this.bKm = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bLW != null && s.this.bLW.threadId != null && s.this.mTitle != null && s.this.bLh != null && ((String) customResponsedMessage.getData()).equals(s.this.bLW.threadId) && !s.this.Xr()) {
                    m.a(s.this.mTitle, s.this.bLW.threadId, d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(s.this.bLh, s.this.bLW.threadId, d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        this.bLt = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Xn = s.this.Xn();
                if (Xn != null) {
                    view.setTag("1");
                    Xn.a(view, s.this.bLW);
                }
            }
        };
        this.bLj = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> Xn = s.this.Xn();
                if (Xn != null) {
                    view.setTag("2");
                    Xn.a(view, s.this.bLW);
                }
            }
        };
        this.bKH = new TbImageView.a() { // from class: com.baidu.tieba.card.s.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && s.this.bMd != null) {
                    s.this.bMd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mH = tbPageContext;
        this.bLX = (LinearLayout) this.mRootView.findViewById(d.h.left_time_view);
        this.bLY = (TextView) this.mRootView.findViewById(d.h.month_num);
        this.bLZ = (TextView) this.mRootView.findViewById(d.h.day_num);
        this.bMa = (TextView) this.mRootView.findViewById(d.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.thread_title);
        this.bLf = (PlayVoiceBntNew) this.mRootView.findViewById(d.h.card_dynamic_thread_abstract_voice);
        this.bLf.setAfterClickListener(this.bLj);
        this.bLh = (TextView) this.mRootView.findViewById(d.h.thread_content);
        this.bLh.setVisibility(8);
        this.bLi = (ConstrainImageGroup) this.mRootView.findViewById(d.h.card_dynamic_thread_img_layout);
        this.bLi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLi.setChildClickListener(this.bLt);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLi.setImageProcessor(fVar);
        this.bMc = this.mRootView.findViewById(d.h.thread_view_img_container);
        this.bMd = (TbImageView) this.mRootView.findViewById(d.h.thread_video_thumbnail);
        this.bMe = (ImageView) this.mRootView.findViewById(d.h.thread_img_pause_play);
        this.bMb = (PhotoLiveCoverView) this.mRootView.findViewById(d.h.photo_live_cover_view);
        this.bLV = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.h.card_dynamic_thread_info_layout);
        this.bMi = (LinearLayout) this.mRootView.findViewById(d.h.duration_container);
        this.bMj = (TextView) this.mRootView.findViewById(d.h.video_duration);
        this.bMk = (TextView) this.mRootView.findViewById(d.h.video_play_count);
        this.bMl = (TextView) this.mRootView.findViewById(d.h.audience_count);
        this.bKl = (AlaPlayAnimationView) this.mRootView.findViewById(d.h.ala_play);
        this.bMm = (TextView) this.mRootView.findViewById(d.h.fake_video_state);
        this.bMf = (LinearLayout) this.mRootView.findViewById(d.h.shared_ala_live_layout);
        this.bMg = (TextView) this.mRootView.findViewById(d.h.shared_ala_live_room_title);
        this.bMh = (LinearLayout) this.mRootView.findViewById(d.h.llAlaLivingLogLayout);
        this.bMh.setVisibility(8);
        this.bMn = this.mRootView.findViewById(d.h.divider_line_above_praise);
        this.anR = this.mRootView.findViewById(d.h.divider_line);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.card_thread_info_layout);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this.bJo);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setShareVisible(true);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setFrom(1);
        this.bmV.setShareReportFrom(6);
        this.bmV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.Xn() != null) {
                    s.this.Xn().a(view, s.this.bLW);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.i(this.bLY, d.e.cp_cont_j);
            aj.i(this.bLZ, d.e.cp_cont_b);
            aj.i(this.bMa, d.e.cp_cont_f);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.i(this.bLh, d.e.cp_cont_f);
            aj.i(this.bMg, d.e.cp_cont_f);
            this.bLV.onChangeSkinType();
            this.bmV.onChangeSkinType();
            aj.k(this.anR, d.e.cp_bg_line_e);
            aj.k(this.bMg, d.e.cp_bg_line_e);
            aj.k(this.bMn, d.e.cp_bg_line_e);
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
        this.bLW = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJo);
        }
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        this.bLX.setVisibility(cardPersonDynamicThreadData.bOc ? 0 : 4);
        this.anR.setVisibility(cardPersonDynamicThreadData.bOc ? 0 : 8);
        if (cardPersonDynamicThreadData.bOd) {
            this.anR.setVisibility(8);
        }
        this.bMo = cardPersonDynamicThreadData.bNS == 40 && cardPersonDynamicThreadData.bNU == 2;
        d(cardPersonDynamicThreadData);
        this.bLY.setText(cardPersonDynamicThreadData.bNV);
        this.bLZ.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bOb != null && cardPersonDynamicThreadData.bOb.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bOb.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.bOb[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bOb.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.l.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.l.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bMa.setText(sb2);
                this.bMa.setVisibility(0);
            } else {
                this.bMa.setVisibility(8);
            }
        } else {
            this.bMa.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bNY;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bLf.setVisibility(0);
            dA(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bLf.setVoiceModel(voiceModel);
            this.bLf.setTag(voiceModel);
            this.bLf.bgc();
            if (voiceModel != null) {
                this.bLf.ng(voiceModel.voice_status.intValue());
            }
        } else {
            this.bLf.setVisibility(8);
            dA(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bNX;
        aj.j(this.bMf, d.e.transparent);
        this.bMg.setVisibility(8);
        this.bMh.setVisibility(8);
        this.bMf.setVisibility(0);
        this.bMb.setVisibility(8);
        this.bMc.setVisibility(8);
        this.bMm.setVisibility(8);
        this.bMi.setVisibility(8);
        this.bMl.setVisibility(8);
        this.bKl.bxK();
        if (cardPersonDynamicThreadData.bNS == 36) {
            this.bLi.setVisibility(8);
            this.bMn.setVisibility(0);
        } else if (cardPersonDynamicThreadData.bNS == 33) {
            this.bLi.setVisibility(8);
            this.bMn.setVisibility(8);
            if (com.baidu.tbadk.core.h.oM().oS() && cardPersonDynamicThreadData.bNZ != null && !StringUtils.isNull(cardPersonDynamicThreadData.bNZ.livecover_src)) {
                this.bMb.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bNZ)) {
                    this.bMb.setShowExpression(false);
                } else {
                    this.bMb.setShowExpression(true);
                }
                this.bMb.setShowImage(com.baidu.tbadk.core.h.oM().oS());
                this.bMb.setChooseStyle(c.getShowStyle());
                this.bMb.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bNS == 40 || this.bLW.bNS == 50) {
            this.bLi.setVisibility(8);
            this.bMn.setVisibility(8);
            if (com.baidu.tbadk.core.h.oM().oS()) {
                this.bMc.setVisibility(0);
                this.bMe.setVisibility(0);
                this.bMe.setImageResource(d.g.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMc.getLayoutParams();
                int width = this.bMc.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.f.ds672);
                }
                layoutParams.height = (int) (0.5625d * width);
                this.bMc.setLayoutParams(layoutParams);
                if (this.bLW.videoInfo != null) {
                    this.bMd.setDefaultErrorResource(0);
                    this.bMd.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMd.setEvent(this.bKH);
                    this.bMd.c(this.bLW.videoInfo.thumbnail_url, 17, false);
                    if (this.bMo) {
                        this.bMm.setVisibility(0);
                        this.bMm.setText(String.format(this.mContext.getResources().getString(d.l.video_review_state), new Object[0]));
                    } else {
                        this.bMi.setVisibility(0);
                        this.bMj.setText(am.cX(this.bLW.videoInfo.video_duration.intValue() * 1000));
                        this.bMk.setText(String.format(this.mContext.getResources().getString(d.l.play_count), am.A(this.bLW.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.bLW.bNS == 60 || this.bLW.bNS == 49) {
            this.bLi.setVisibility(8);
            this.bMn.setVisibility(8);
            if (this.bLW.threadData.rG() != null && this.bLW.threadData.rG().Uw != null && this.bLW.bNS == 60) {
                String str = this.bLW.threadData.rG().Uw.user_name;
                if (com.baidu.tbadk.util.u.gP(str) > 14) {
                    str = com.baidu.tbadk.util.u.E(str, 14) + "...";
                }
                this.bMg.setText(m.aJ(str + ":", this.bLW.threadData.getTitle()));
                this.bMg.setVisibility(0);
            } else {
                this.bMg.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oM().oS()) {
                this.bMc.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bMc.getLayoutParams();
                int width2 = this.bMc.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.f.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bMc.setLayoutParams(layoutParams2);
                if (this.bLW.threadData.rG() != null) {
                    this.bMd.setDefaultErrorResource(0);
                    this.bMd.setDefaultBgResource(d.g.pic_bg_video_frs);
                    this.bMd.setEvent(this.bKH);
                    this.bMd.c(cardPersonDynamicThreadData.threadData.rG().cover, 10, false);
                    this.bMe.setImageResource(d.g.btn_icon_play_live_on_n);
                    this.bKl.XP();
                    aj.j(this.bMf, d.e.cp_bg_line_e);
                    this.bMl.setVisibility(0);
                    this.bMl.setText(String.format(this.mContext.getResources().getString(d.l.ala_audience_count_prefix), am.A(this.bLW.threadData.rG().audience_count)));
                }
            }
        } else {
            if (com.baidu.tbadk.core.h.oM().oS() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.t(linkedList) > 0) {
                    this.bLi.setVisibility(0);
                    this.bMn.setVisibility(8);
                    this.bLi.setFromCDN(this.aiu);
                    this.bLi.setSingleImageRatio(0.67d);
                    this.bLi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                s.this.XF();
                            } else {
                                s.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.bLi.setImageMediaList(linkedList);
                } else {
                    this.bLi.setVisibility(8);
                    this.bMn.setVisibility(0);
                }
            } else {
                this.bLi.setVisibility(8);
                this.bMn.setVisibility(0);
            }
            this.bMf.setVisibility(8);
        }
        XE();
        b(cardPersonDynamicThreadData);
    }

    private void dA(boolean z) {
        if (this.bLi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLi.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            }
            this.bLi.setLayoutParams(layoutParams);
        }
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.bMo) {
                this.bmV.setCommentClickable(false);
                this.bmV.setAgreeClickable(false);
                this.bmV.setShareClickable(false);
            } else {
                this.bmV.setCommentClickable(true);
                this.bmV.setAgreeClickable(true);
                this.bmV.setShareClickable(true);
            }
            this.bmV.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.bNS == 60) {
                this.bmV.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.bOb != null) {
                this.bmV.setMultiForumCount(cardPersonDynamicThreadData.bOb.length);
            }
            this.bmV.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void XE() {
        this.bLf.setClickable(true);
        int childCount = this.bLi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLi.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void XL() {
        if (this.bLW != null && this.bLW.threadData != null && this.bLW.threadData.rG() != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                com.baidu.adp.lib.util.l.showToast(this.mH.getPageActivity(), d.l.no_network_guide);
                return;
            }
            if (!Xr()) {
                m.jl(this.bLW.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bLW.threadData.rG());
            if (this.bLW.threadData.rG().Uw != null) {
                alaLiveInfoCoreData.setUserName(this.bLW.threadData.rG().Uw.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.mH.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XM() {
        if (this.bLW != null && this.bLW.threadData != null && this.bLW.threadData.rG() != null && this.bLW.threadData.rG().Ux != null) {
            if (!Xr()) {
                m.jl(this.bLW.threadId);
            }
            if (this.bLW.threadData.rG().Ux.record_tid <= 0) {
                XL();
                return;
            }
            String valueOf = String.valueOf(this.bLW.threadData.rG().Ux.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mH.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XF() {
        if (this.bLW != null) {
            if (!Xr()) {
                m.jl(this.bLW.threadId);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mH.getPageActivity());
            if (this.bLW.bNS == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(this.bLW.threadId, this.bLW.bNP, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xr() {
        return this.bLW.bNu && !this.bLW.aBN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLi != null) {
            this.bLi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLi != null) {
            this.bLi.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mH.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aiu ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mH.getPageActivity()).createConfig(arrayList, i, bhVar.rt(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiu, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (cardPersonDynamicThreadData.bNZ != null) {
            if (cardPersonDynamicThreadData.bNZ.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bNZ.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bNZ.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bNZ.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bNZ.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bNZ.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bNZ.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bNZ.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bNZ.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bNZ.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bNW != null && cardPersonDynamicThreadData.bNW.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bNW.length; i++) {
                sb.append(cardPersonDynamicThreadData.bNW[i].text);
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
                eVar.eu(labelInfoArr[i].labelHot);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.bMo);
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
