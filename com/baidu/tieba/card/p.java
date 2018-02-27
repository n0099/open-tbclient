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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCoverView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class p extends a<CardPersonDynamicThreadData> {
    private boolean aYX;
    private View.OnClickListener cVx;
    private TbImageView.a cWC;
    public PlayVoiceBntNew cWQ;
    private TextView cWS;
    private ConstrainImageGroup cWT;
    private final View.OnClickListener cWW;
    private AlaPlayAnimationView cWg;
    private CustomMessageListener cWh;
    private CardPersonDynamicThreadData cXH;
    public ThreadViewAndCommentInfoLayout cXS;
    private final String cXT;
    private final String cXU;
    private TextView cXV;
    private LinearLayout cXW;
    private TextView cXX;
    private TextView cXY;
    private TextView cXZ;
    private TextView cYa;
    private ImageView cYb;
    private o cYc;
    private PhotoLiveCoverView cYd;
    private View cYe;
    private TbImageView cYf;
    private ImageView cYg;
    private LinearLayout cYh;
    private TextView cYi;
    private LinearLayout cYj;
    private LinearLayout cYk;
    private TextView cYl;
    private TextView cYm;
    private TextView cYn;
    private TextView cYo;
    private TextView cYp;
    public OriginalThreadCardView cYq;
    private View cYr;
    private View cYs;
    private boolean cYt;
    private boolean cYu;
    com.baidu.tieba.view.j cYv;
    private o.a cYw;
    private final View.OnClickListener cYx;
    public ThreadCommentAndPraiseInfoLayout clX;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cXT = "1";
        this.cXU = "2";
        this.mSkinType = 3;
        this.aYX = true;
        this.cYv = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.cXH != null && !StringUtils.isNull(p.this.cXH.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.cXH.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.j
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(d.C0141d.cp_link_tip_c) : p.this.mContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            }
        };
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.akO() != null) {
                    p.this.akO().a(view, p.this.cXH);
                }
                if (p.this.cXH.dax != 33) {
                    if (p.this.cXH.dax != 60) {
                        if ((p.this.cXH.dax != 40 || p.this.cXH.daA != 2) && !p.this.cYu) {
                            p.this.ali();
                            return;
                        } else {
                            BdToast.b(p.this.getContext(), p.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).Bc();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (p.this.cXH.threadData.zG().live_status != 1) {
                        p.this.alq();
                        return;
                    } else {
                        p.this.alp();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                p.this.mPageContext.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(p.this.mPageContext.getPageActivity(), p.this.cXH.threadId).cR(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).eC(23014).xD()));
            }
        };
        this.cWh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.cXH != null && p.this.cXH.threadId != null && p.this.mTitle != null && p.this.cWS != null && ((String) customResponsedMessage.getData()).equals(p.this.cXH.threadId) && !p.this.isHost()) {
                    j.a(p.this.mTitle, p.this.cXH.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                    j.a(p.this.cWS, p.this.cXH.threadId, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                }
            }
        };
        this.cYw = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.eN(z);
            }
        };
        this.cYx = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akO = p.this.akO();
                if (akO != null) {
                    view.setTag("1");
                    akO.a(view, p.this.cXH);
                }
                p.this.ali();
            }
        };
        this.cWW = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akO = p.this.akO();
                if (akO != null) {
                    view.setTag("2");
                    akO.a(view, p.this.cXH);
                }
            }
        };
        this.cWC = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && p.this.cYf != null) {
                    p.this.cYf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cXV = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cXW = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cXX = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cXY = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cXZ = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cYp = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cYa = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cYb = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cWQ = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cWQ.setAfterClickListener(this.cWW);
        this.cWS = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cWS.setVisibility(8);
        this.cWT = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cWT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cWT.setChildClickListener(this.cYx);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWT.setImageProcessor(fVar);
        this.cYe = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cYf = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cYg = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cYd = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cXS = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cYk = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cYl = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cYm = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cYn = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cWg = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cYo = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cYh = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cYi = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cYj = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cYj.setVisibility(8);
        this.cYq = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cYr = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cYs = this.mRootView.findViewById(d.g.divider_line_thin);
        this.clX = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this.cVx);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.setIsBarViewVisible(false);
        this.clX.setFrom(8);
        this.clX.setShareReportFrom(6);
        this.clX.setStType("person_page");
        this.clX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.akO() != null) {
                    p.this.akO().a(view, p.this.cXH);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.cXV, d.C0141d.cp_cont_b);
            aj.r(this.cXX, d.C0141d.cp_cont_j);
            aj.r(this.cXY, d.C0141d.cp_cont_b);
            aj.r(this.cXZ, d.C0141d.cp_cont_d);
            aj.r(this.cYp, d.C0141d.cp_cont_d);
            aj.r(this.cYa, d.C0141d.cp_cont_d);
            if (this.cYb != null) {
                this.cYb.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.r(this.mTitle, d.C0141d.cp_cont_b);
            aj.r(this.cWS, d.C0141d.cp_cont_f);
            aj.r(this.cYi, d.C0141d.cp_cont_f);
            if (this.cYc != null) {
                this.cYc.onChangeSkinType();
            }
            this.cXS.onChangeSkinType();
            this.clX.onChangeSkinType();
            aj.t(this.cYr, d.C0141d.cp_bg_line_e);
            aj.t(this.cYs, d.C0141d.cp_bg_line_c);
            aj.t(this.cYi, d.C0141d.cp_bg_line_e);
            if (this.cYq != null) {
                this.cYq.onChangeSkinType();
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
        this.cXH = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVx);
        }
        this.cXV.setVisibility(cardPersonDynamicThreadData.daL ? 0 : 8);
        this.cXW.setVisibility(cardPersonDynamicThreadData.daK ? 0 : 4);
        this.cYr.setVisibility(cardPersonDynamicThreadData.daK ? 0 : 8);
        this.cYs.setVisibility(cardPersonDynamicThreadData.daK ? 8 : 0);
        if (cardPersonDynamicThreadData.daM) {
            this.cYr.setVisibility(8);
            this.cYs.setVisibility(8);
        }
        this.cYt = cardPersonDynamicThreadData.dax == 40 && cardPersonDynamicThreadData.daA == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cYu = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.daA == 2;
        }
        this.cXV.setText(cardPersonDynamicThreadData.daB);
        this.cXX.setText(cardPersonDynamicThreadData.daC);
        this.cXY.setText(cardPersonDynamicThreadData.daD);
        if (cardPersonDynamicThreadData.daJ != null && cardPersonDynamicThreadData.daJ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.daJ.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.daJ[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.daJ.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cXZ.setText(sb2);
                this.cXZ.setVisibility(0);
            } else {
                this.cXZ.setText(d.j.person_homepage);
            }
        } else {
            this.cXZ.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cYa.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cYa.setVisibility(0);
            }
            eN(cardPersonDynamicThreadData.isPrivacy);
            this.cYb.setVisibility(0);
            this.cYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.cYc == null) {
                            p.this.cYc = new o(p.this.mPageContext);
                            p.this.cYc.create();
                            p.this.cYc.a(p.this.cYw);
                        }
                        p.this.cYc.a(p.this.cXH);
                        p.this.cYc.show();
                    }
                }
            });
        } else {
            this.cYa.setVisibility(8);
            this.cYb.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.daG;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cWQ.setVisibility(0);
            eM(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cWQ.setVoiceModel(voiceModel);
            this.cWQ.setTag(voiceModel);
            this.cWQ.aNQ();
            if (voiceModel != null) {
                this.cWQ.qG(voiceModel.voice_status.intValue());
            }
            this.cWQ.bya();
        } else {
            this.cWQ.setVisibility(8);
            eM(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.daF;
        aj.s(this.cYh, d.C0141d.transparent);
        this.cYi.setVisibility(8);
        this.cYj.setVisibility(8);
        this.cYh.setVisibility(0);
        this.cYd.setVisibility(8);
        this.cYe.setVisibility(8);
        this.cYo.setVisibility(8);
        this.cYk.setVisibility(8);
        this.cYn.setVisibility(8);
        this.cWg.bEI();
        if (cardPersonDynamicThreadData.dax == 36) {
            this.cWT.setVisibility(8);
        } else if (cardPersonDynamicThreadData.dax == 33) {
            this.cWT.setVisibility(8);
            if (com.baidu.tbadk.core.i.xo().xu() && cardPersonDynamicThreadData.daH != null && !StringUtils.isNull(cardPersonDynamicThreadData.daH.livecover_src)) {
                this.cYd.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.daH)) {
                    this.cYd.setShowExpression(false);
                } else {
                    this.cYd.setShowExpression(true);
                }
                this.cYd.setShowImage(com.baidu.tbadk.core.i.xo().xu());
                this.cYd.setChooseStyle(d.getShowStyle());
                this.cYd.setData(d);
            }
        } else if (cardPersonDynamicThreadData.dax == 40 || this.cXH.dax == 50) {
            this.cWT.setVisibility(8);
            if (com.baidu.tbadk.core.i.xo().xu()) {
                this.cYe.setVisibility(0);
                this.cYg.setVisibility(0);
                this.cYg.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYe.getLayoutParams();
                int width = this.cYe.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cYe.setLayoutParams(layoutParams);
                if (this.cXH.videoInfo != null) {
                    this.cYf.setDefaultErrorResource(0);
                    this.cYf.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cYf.setEvent(this.cWC);
                    this.cYf.startLoad(this.cXH.videoInfo.thumbnail_url, 17, false);
                    if (this.cYt) {
                        this.cYo.setVisibility(0);
                        this.cYo.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cYk.setVisibility(0);
                        this.cYl.setText(am.fV(this.cXH.videoInfo.video_duration.intValue() * 1000));
                        this.cYm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.J(this.cXH.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cXH.dax == 60 || this.cXH.dax == 49) {
            this.cWT.setVisibility(8);
            if (this.cXH.threadData.zG() != null && this.cXH.threadData.zG().user_info != null && this.cXH.dax == 60) {
                String str = this.cXH.threadData.zG().user_info.user_name;
                if (com.baidu.tbadk.util.w.ht(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cYi.setText(j.aH(str + ":", this.cXH.threadData.getTitle()));
                this.cYi.setVisibility(0);
            } else {
                this.cYi.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.xo().xu()) {
                this.cYe.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYe.getLayoutParams();
                int width2 = this.cYe.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cYe.setLayoutParams(layoutParams2);
                if (this.cXH.threadData.zG() != null) {
                    this.cYf.setDefaultErrorResource(0);
                    this.cYf.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cYf.setEvent(this.cWC);
                    this.cYf.startLoad(cardPersonDynamicThreadData.threadData.zG().cover, 10, false);
                    this.cYg.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cWg.startPlayAnimation();
                    aj.s(this.cYh, d.C0141d.cp_bg_line_e);
                    this.cYn.setVisibility(0);
                    this.cYn.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cXH.threadData.zG().audience_count)));
                    this.clX.getCommentContainer().setOnClickListener(this.cVx);
                } else {
                    this.clX.getCommentContainer().setOnClickListener(this.clX);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.xo().xu() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cWT.setVisibility(0);
                    this.cWT.setFromCDN(this.aYX);
                    this.cWT.setSingleImageRatio(0.67d);
                    this.cWT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z) {
                            if (z) {
                                p.this.ali();
                            } else {
                                p.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.cWT.setImageMediaList(linkedList);
                } else {
                    this.cWT.setVisibility(8);
                }
            } else {
                this.cWT.setVisibility(8);
            }
            this.cYh.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aQl != null) {
            this.cYq.setVisibility(0);
            this.cYq.b(cardPersonDynamicThreadData.threadData.aQl);
            this.cYq.setOnClickListener(this);
            this.cWQ.setVisibility(8);
            this.cWT.setVisibility(8);
            this.cYh.setVisibility(8);
            if (this.cYu) {
                this.cYp.setVisibility(0);
            } else {
                this.cYp.setVisibility(8);
            }
        } else {
            this.cYq.setVisibility(8);
            this.cYp.setVisibility(8);
        }
        alh();
        c(cardPersonDynamicThreadData);
    }

    private void eM(boolean z) {
        if (this.cWT != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWT.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cWT.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cYt || this.cYu) {
                this.clX.setCommentClickable(false);
                this.clX.setAgreeClickable(false);
                this.clX.setShareClickable(false);
                this.cYq.setClickable(false);
                this.cYb.setClickable(false);
            } else {
                this.clX.setCommentClickable(true);
                this.clX.setAgreeClickable(true);
                this.clX.setShareClickable(true);
                this.cYq.setClickable(true);
                this.cYb.setClickable(true);
            }
            this.clX.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.dax == 60) {
                this.clX.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.daJ != null) {
                this.clX.setMultiForumCount(cardPersonDynamicThreadData.daJ.length);
            }
            this.clX.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void alh() {
        this.cWQ.setClickable(true);
        int childCount = this.cWT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWT.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void alp() {
        if (this.cXH != null && this.cXH.threadData != null && this.cXH.threadData.zG() != null) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                j.kr(this.cXH.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXH.threadData.zG());
            if (this.cXH.threadData.zG().user_info != null) {
                alaLiveInfoCoreData.userName = this.cXH.threadData.zG().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alq() {
        if (this.cXH != null && this.cXH.threadData != null && this.cXH.threadData.zG() != null && this.cXH.threadData.zG().share_info != null) {
            if (!isHost()) {
                j.kr(this.cXH.threadId);
            }
            if (this.cXH.threadData.zG().share_info.record_tid <= 0) {
                alp();
                return;
            }
            String valueOf = String.valueOf(this.cXH.threadData.zG().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ali() {
        if (this.cXH != null) {
            if (!isHost()) {
                j.kr(this.cXH.threadId);
                j.a(this.mTitle, this.cXH.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                j.a(this.cWS, this.cXH.threadId, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cXH.dax == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cXH.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cXH.threadData.getFid()));
            pbActivityConfig.setForumName(this.cXH.threadData.zt());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cXH.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cXH.threadData == null || !this.cXH.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new ak("c12943").ab("obj_type", "2").ab("tid", this.cXH.threadId).s("obj_param1", this.cXH.isHost ? 1 : 2));
        }
    }

    private void alr() {
        if (this.cXH != null && this.cXH.threadData != null && this.cXH.threadData.aQl != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cXH.threadData.aQl.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new ak("c12943").ab("obj_type", "3").ab("tid", this.cXH.threadId).s("obj_param1", this.cXH.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(boolean z) {
        if (this.cYa != null) {
            if (z) {
                this.cYa.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cYa.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cYa.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cYa.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cXH.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cYq) {
            alr();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWT != null) {
            this.cWT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWT != null) {
            this.cWT.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aYX ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYX, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.daH != null) {
            if (cardPersonDynamicThreadData.daH.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.daH.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.daH.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.daH.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.daH.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.daH.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.daH.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.daH.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.daH.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.daH.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.azL);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.daE != null && cardPersonDynamicThreadData.daE.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.daE.length; i++) {
                sb.append(cardPersonDynamicThreadData.daE[i].text);
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
                eVar.ho(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.fL(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean e(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.threadData.d(false, true, this.cYt);
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
        j.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        return true;
    }
}
