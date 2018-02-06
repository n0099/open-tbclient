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
    private boolean aZj;
    private View.OnClickListener cVJ;
    private TbImageView.a cWO;
    private AlaPlayAnimationView cWs;
    private CustomMessageListener cWt;
    private CardPersonDynamicThreadData cXT;
    public PlayVoiceBntNew cXc;
    private TextView cXe;
    private ConstrainImageGroup cXf;
    private final View.OnClickListener cXi;
    private TextView cYA;
    private TextView cYB;
    public OriginalThreadCardView cYC;
    private View cYD;
    private View cYE;
    private boolean cYF;
    private boolean cYG;
    com.baidu.tieba.view.j cYH;
    private o.a cYI;
    private final View.OnClickListener cYJ;
    public ThreadViewAndCommentInfoLayout cYe;
    private final String cYf;
    private final String cYg;
    private TextView cYh;
    private LinearLayout cYi;
    private TextView cYj;
    private TextView cYk;
    private TextView cYl;
    private TextView cYm;
    private ImageView cYn;
    private o cYo;
    private PhotoLiveCoverView cYp;
    private View cYq;
    private TbImageView cYr;
    private ImageView cYs;
    private LinearLayout cYt;
    private TextView cYu;
    private LinearLayout cYv;
    private LinearLayout cYw;
    private TextView cYx;
    private TextView cYy;
    private TextView cYz;
    public ThreadCommentAndPraiseInfoLayout cmk;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cYf = "1";
        this.cYg = "2";
        this.mSkinType = 3;
        this.aZj = true;
        this.cYH = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.cXT != null && !StringUtils.isNull(p.this.cXT.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.cXT.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.j
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(d.C0140d.cp_link_tip_c) : p.this.mContext.getResources().getColor(d.C0140d.cp_link_tip_a));
            }
        };
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.akP() != null) {
                    p.this.akP().a(view, p.this.cXT);
                }
                if (p.this.cXT.daK != 33) {
                    if (p.this.cXT.daK != 60) {
                        if ((p.this.cXT.daK != 40 || p.this.cXT.daM != 2) && !p.this.cYG) {
                            p.this.alj();
                            return;
                        } else {
                            BdToast.b(p.this.getContext(), p.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).Bc();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (p.this.cXT.threadData.zG().live_status != 1) {
                        p.this.alr();
                        return;
                    } else {
                        p.this.alq();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                p.this.mPageContext.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(p.this.mPageContext.getPageActivity(), p.this.cXT.threadId).cR(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).eC(23014).xD()));
            }
        };
        this.cWt = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.cXT != null && p.this.cXT.threadId != null && p.this.mTitle != null && p.this.cXe != null && ((String) customResponsedMessage.getData()).equals(p.this.cXT.threadId) && !p.this.isHost()) {
                    j.a(p.this.mTitle, p.this.cXT.threadId, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                    j.a(p.this.cXe, p.this.cXT.threadId, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                }
            }
        };
        this.cYI = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.eN(z);
            }
        };
        this.cYJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akP = p.this.akP();
                if (akP != null) {
                    view.setTag("1");
                    akP.a(view, p.this.cXT);
                }
                p.this.alj();
            }
        };
        this.cXi = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akP = p.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, p.this.cXT);
                }
            }
        };
        this.cWO = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && p.this.cYr != null) {
                    p.this.cYr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cYh = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cYi = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cYj = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cYk = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cYl = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cYB = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cYm = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cYn = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cXc = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cXc.setAfterClickListener(this.cXi);
        this.cXe = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cXe.setVisibility(8);
        this.cXf = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cXf.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cXf.setChildClickListener(this.cYJ);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cXf.setImageProcessor(fVar);
        this.cYq = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cYr = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cYs = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cYp = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cYe = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cYw = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cYx = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cYy = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cYz = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cWs = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cYA = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cYt = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cYu = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cYv = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cYv.setVisibility(8);
        this.cYC = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cYD = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cYE = this.mRootView.findViewById(d.g.divider_line_thin);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this.cVJ);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setFrom(8);
        this.cmk.setShareReportFrom(6);
        this.cmk.setStType("person_page");
        this.cmk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.akP() != null) {
                    p.this.akP().a(view, p.this.cXT);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.cYh, d.C0140d.cp_cont_b);
            aj.r(this.cYj, d.C0140d.cp_cont_j);
            aj.r(this.cYk, d.C0140d.cp_cont_b);
            aj.r(this.cYl, d.C0140d.cp_cont_d);
            aj.r(this.cYB, d.C0140d.cp_cont_d);
            aj.r(this.cYm, d.C0140d.cp_cont_d);
            if (this.cYn != null) {
                this.cYn.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.r(this.mTitle, d.C0140d.cp_cont_b);
            aj.r(this.cXe, d.C0140d.cp_cont_f);
            aj.r(this.cYu, d.C0140d.cp_cont_f);
            if (this.cYo != null) {
                this.cYo.onChangeSkinType();
            }
            this.cYe.onChangeSkinType();
            this.cmk.onChangeSkinType();
            aj.t(this.cYD, d.C0140d.cp_bg_line_e);
            aj.t(this.cYE, d.C0140d.cp_bg_line_c);
            aj.t(this.cYu, d.C0140d.cp_bg_line_e);
            if (this.cYC != null) {
                this.cYC.onChangeSkinType();
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
        this.cXT = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVJ);
        }
        this.cYh.setVisibility(cardPersonDynamicThreadData.daX ? 0 : 8);
        this.cYi.setVisibility(cardPersonDynamicThreadData.daW ? 0 : 4);
        this.cYD.setVisibility(cardPersonDynamicThreadData.daW ? 0 : 8);
        this.cYE.setVisibility(cardPersonDynamicThreadData.daW ? 8 : 0);
        if (cardPersonDynamicThreadData.daY) {
            this.cYD.setVisibility(8);
            this.cYE.setVisibility(8);
        }
        this.cYF = cardPersonDynamicThreadData.daK == 40 && cardPersonDynamicThreadData.daM == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cYG = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.daM == 2;
        }
        this.cYh.setText(cardPersonDynamicThreadData.daN);
        this.cYj.setText(cardPersonDynamicThreadData.daO);
        this.cYk.setText(cardPersonDynamicThreadData.daP);
        if (cardPersonDynamicThreadData.daV != null && cardPersonDynamicThreadData.daV.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.daV.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.daV[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.daV.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cYl.setText(sb2);
                this.cYl.setVisibility(0);
            } else {
                this.cYl.setText(d.j.person_homepage);
            }
        } else {
            this.cYl.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cYm.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cYm.setVisibility(0);
            }
            eN(cardPersonDynamicThreadData.isPrivacy);
            this.cYn.setVisibility(0);
            this.cYn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.cYo == null) {
                            p.this.cYo = new o(p.this.mPageContext);
                            p.this.cYo.create();
                            p.this.cYo.a(p.this.cYI);
                        }
                        p.this.cYo.a(p.this.cXT);
                        p.this.cYo.show();
                    }
                }
            });
        } else {
            this.cYm.setVisibility(8);
            this.cYn.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.daS;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cXc.setVisibility(0);
            eM(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cXc.setVoiceModel(voiceModel);
            this.cXc.setTag(voiceModel);
            this.cXc.aNR();
            if (voiceModel != null) {
                this.cXc.qG(voiceModel.voice_status.intValue());
            }
            this.cXc.byb();
        } else {
            this.cXc.setVisibility(8);
            eM(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.daR;
        aj.s(this.cYt, d.C0140d.transparent);
        this.cYu.setVisibility(8);
        this.cYv.setVisibility(8);
        this.cYt.setVisibility(0);
        this.cYp.setVisibility(8);
        this.cYq.setVisibility(8);
        this.cYA.setVisibility(8);
        this.cYw.setVisibility(8);
        this.cYz.setVisibility(8);
        this.cWs.bEJ();
        if (cardPersonDynamicThreadData.daK == 36) {
            this.cXf.setVisibility(8);
        } else if (cardPersonDynamicThreadData.daK == 33) {
            this.cXf.setVisibility(8);
            if (com.baidu.tbadk.core.i.xo().xu() && cardPersonDynamicThreadData.daT != null && !StringUtils.isNull(cardPersonDynamicThreadData.daT.livecover_src)) {
                this.cYp.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.daT)) {
                    this.cYp.setShowExpression(false);
                } else {
                    this.cYp.setShowExpression(true);
                }
                this.cYp.setShowImage(com.baidu.tbadk.core.i.xo().xu());
                this.cYp.setChooseStyle(d.getShowStyle());
                this.cYp.setData(d);
            }
        } else if (cardPersonDynamicThreadData.daK == 40 || this.cXT.daK == 50) {
            this.cXf.setVisibility(8);
            if (com.baidu.tbadk.core.i.xo().xu()) {
                this.cYq.setVisibility(0);
                this.cYs.setVisibility(0);
                this.cYs.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYq.getLayoutParams();
                int width = this.cYq.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cYq.setLayoutParams(layoutParams);
                if (this.cXT.videoInfo != null) {
                    this.cYr.setDefaultErrorResource(0);
                    this.cYr.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cYr.setEvent(this.cWO);
                    this.cYr.startLoad(this.cXT.videoInfo.thumbnail_url, 17, false);
                    if (this.cYF) {
                        this.cYA.setVisibility(0);
                        this.cYA.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cYw.setVisibility(0);
                        this.cYx.setText(am.fV(this.cXT.videoInfo.video_duration.intValue() * 1000));
                        this.cYy.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.J(this.cXT.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cXT.daK == 60 || this.cXT.daK == 49) {
            this.cXf.setVisibility(8);
            if (this.cXT.threadData.zG() != null && this.cXT.threadData.zG().user_info != null && this.cXT.daK == 60) {
                String str = this.cXT.threadData.zG().user_info.user_name;
                if (com.baidu.tbadk.util.w.ht(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cYu.setText(j.aH(str + ":", this.cXT.threadData.getTitle()));
                this.cYu.setVisibility(0);
            } else {
                this.cYu.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.xo().xu()) {
                this.cYq.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYq.getLayoutParams();
                int width2 = this.cYq.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cYq.setLayoutParams(layoutParams2);
                if (this.cXT.threadData.zG() != null) {
                    this.cYr.setDefaultErrorResource(0);
                    this.cYr.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cYr.setEvent(this.cWO);
                    this.cYr.startLoad(cardPersonDynamicThreadData.threadData.zG().cover, 10, false);
                    this.cYs.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cWs.startPlayAnimation();
                    aj.s(this.cYt, d.C0140d.cp_bg_line_e);
                    this.cYz.setVisibility(0);
                    this.cYz.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cXT.threadData.zG().audience_count)));
                    this.cmk.getCommentContainer().setOnClickListener(this.cVJ);
                } else {
                    this.cmk.getCommentContainer().setOnClickListener(this.cmk);
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
                    this.cXf.setVisibility(0);
                    this.cXf.setFromCDN(this.aZj);
                    this.cXf.setSingleImageRatio(0.67d);
                    this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z) {
                            if (z) {
                                p.this.alj();
                            } else {
                                p.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.cXf.setImageMediaList(linkedList);
                } else {
                    this.cXf.setVisibility(8);
                }
            } else {
                this.cXf.setVisibility(8);
            }
            this.cYt.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aQw != null) {
            this.cYC.setVisibility(0);
            this.cYC.b(cardPersonDynamicThreadData.threadData.aQw);
            this.cYC.setOnClickListener(this);
            this.cXc.setVisibility(8);
            this.cXf.setVisibility(8);
            this.cYt.setVisibility(8);
            if (this.cYG) {
                this.cYB.setVisibility(0);
            } else {
                this.cYB.setVisibility(8);
            }
        } else {
            this.cYC.setVisibility(8);
            this.cYB.setVisibility(8);
        }
        ali();
        c(cardPersonDynamicThreadData);
    }

    private void eM(boolean z) {
        if (this.cXf != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXf.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cXf.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cYF || this.cYG) {
                this.cmk.setCommentClickable(false);
                this.cmk.setAgreeClickable(false);
                this.cmk.setShareClickable(false);
                this.cYC.setClickable(false);
                this.cYn.setClickable(false);
            } else {
                this.cmk.setCommentClickable(true);
                this.cmk.setAgreeClickable(true);
                this.cmk.setShareClickable(true);
                this.cYC.setClickable(true);
                this.cYn.setClickable(true);
            }
            this.cmk.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.daK == 60) {
                this.cmk.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.daV != null) {
                this.cmk.setMultiForumCount(cardPersonDynamicThreadData.daV.length);
            }
            this.cmk.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void ali() {
        this.cXc.setClickable(true);
        int childCount = this.cXf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cXf.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void alq() {
        if (this.cXT != null && this.cXT.threadData != null && this.cXT.threadData.zG() != null) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                j.kr(this.cXT.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXT.threadData.zG());
            if (this.cXT.threadData.zG().user_info != null) {
                alaLiveInfoCoreData.userName = this.cXT.threadData.zG().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        if (this.cXT != null && this.cXT.threadData != null && this.cXT.threadData.zG() != null && this.cXT.threadData.zG().share_info != null) {
            if (!isHost()) {
                j.kr(this.cXT.threadId);
            }
            if (this.cXT.threadData.zG().share_info.record_tid <= 0) {
                alq();
                return;
            }
            String valueOf = String.valueOf(this.cXT.threadData.zG().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        if (this.cXT != null) {
            if (!isHost()) {
                j.kr(this.cXT.threadId);
                j.a(this.mTitle, this.cXT.threadId, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                j.a(this.cXe, this.cXT.threadId, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cXT.daK == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cXT.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cXT.threadData.getFid()));
            pbActivityConfig.setForumName(this.cXT.threadData.zt());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cXT.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cXT.threadData == null || !this.cXT.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new ak("c12943").ab("obj_type", "2").ab("tid", this.cXT.threadId).s("obj_param1", this.cXT.isHost ? 1 : 2));
        }
    }

    private void als() {
        if (this.cXT != null && this.cXT.threadData != null && this.cXT.threadData.aQw != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cXT.threadData.aQw.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new ak("c12943").ab("obj_type", "3").ab("tid", this.cXT.threadId).s("obj_param1", this.cXT.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(boolean z) {
        if (this.cYm != null) {
            if (z) {
                this.cYm.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cYm.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cYm.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cYm.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cXT.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cYC) {
            als();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cXf != null) {
            this.cXf.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXf != null) {
            this.cXf.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aZj ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aZj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (cardPersonDynamicThreadData.daT != null) {
            if (cardPersonDynamicThreadData.daT.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.daT.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.daT.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.daT.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.daT.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.daT.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.daT.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.daT.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.daT.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.daT.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.azU);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.daQ != null && cardPersonDynamicThreadData.daQ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.daQ.length; i++) {
                sb.append(cardPersonDynamicThreadData.daQ[i].text);
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
        SpannableStringBuilder d = cardPersonDynamicThreadData.threadData.d(false, true, this.cYF);
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
        j.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        return true;
    }
}
