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
    private boolean aYZ;
    private View.OnClickListener cVA;
    private TbImageView.a cWF;
    public PlayVoiceBntNew cWT;
    private TextView cWV;
    private ConstrainImageGroup cWW;
    private final View.OnClickListener cWZ;
    private AlaPlayAnimationView cWj;
    private CustomMessageListener cWk;
    private CardPersonDynamicThreadData cXK;
    public ThreadViewAndCommentInfoLayout cXV;
    private final String cXW;
    private final String cXX;
    private TextView cXY;
    private LinearLayout cXZ;
    private final View.OnClickListener cYA;
    private TextView cYa;
    private TextView cYb;
    private TextView cYc;
    private TextView cYd;
    private ImageView cYe;
    private o cYf;
    private PhotoLiveCoverView cYg;
    private View cYh;
    private TbImageView cYi;
    private ImageView cYj;
    private LinearLayout cYk;
    private TextView cYl;
    private LinearLayout cYm;
    private LinearLayout cYn;
    private TextView cYo;
    private TextView cYp;
    private TextView cYq;
    private TextView cYr;
    private TextView cYs;
    public OriginalThreadCardView cYt;
    private View cYu;
    private View cYv;
    private boolean cYw;
    private boolean cYx;
    com.baidu.tieba.view.j cYy;
    private o.a cYz;
    public ThreadCommentAndPraiseInfoLayout cma;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cXW = "1";
        this.cXX = "2";
        this.mSkinType = 3;
        this.aYZ = true;
        this.cYy = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.cXK != null && !StringUtils.isNull(p.this.cXK.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.cXK.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.j
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(d.C0141d.cp_link_tip_c) : p.this.mContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            }
        };
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.akP() != null) {
                    p.this.akP().a(view, p.this.cXK);
                }
                if (p.this.cXK.daB != 33) {
                    if (p.this.cXK.daB != 60) {
                        if ((p.this.cXK.daB != 40 || p.this.cXK.daD != 2) && !p.this.cYx) {
                            p.this.alj();
                            return;
                        } else {
                            BdToast.b(p.this.getContext(), p.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).Bd();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (p.this.cXK.threadData.zG().live_status != 1) {
                        p.this.alr();
                        return;
                    } else {
                        p.this.alq();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                p.this.mPageContext.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(p.this.mPageContext.getPageActivity(), p.this.cXK.threadId).cR(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).eC(23014).xD()));
            }
        };
        this.cWk = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.cXK != null && p.this.cXK.threadId != null && p.this.mTitle != null && p.this.cWV != null && ((String) customResponsedMessage.getData()).equals(p.this.cXK.threadId) && !p.this.isHost()) {
                    j.a(p.this.mTitle, p.this.cXK.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                    j.a(p.this.cWV, p.this.cXK.threadId, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                }
            }
        };
        this.cYz = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.eN(z);
            }
        };
        this.cYA = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akP = p.this.akP();
                if (akP != null) {
                    view.setTag("1");
                    akP.a(view, p.this.cXK);
                }
                p.this.alj();
            }
        };
        this.cWZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akP = p.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, p.this.cXK);
                }
            }
        };
        this.cWF = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && p.this.cYi != null) {
                    p.this.cYi.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cXY = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cXZ = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cYa = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cYb = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cYc = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cYs = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cYd = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cYe = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cWT = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cWT.setAfterClickListener(this.cWZ);
        this.cWV = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cWV.setVisibility(8);
        this.cWW = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cWW.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cWW.setChildClickListener(this.cYA);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWW.setImageProcessor(fVar);
        this.cYh = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cYi = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cYj = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cYg = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cXV = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cYn = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cYo = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cYp = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cYq = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cWj = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cYr = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cYk = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cYl = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cYm = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cYm.setVisibility(8);
        this.cYt = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cYu = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cYv = this.mRootView.findViewById(d.g.divider_line_thin);
        this.cma = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this.cVA);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.setIsBarViewVisible(false);
        this.cma.setFrom(8);
        this.cma.setShareReportFrom(6);
        this.cma.setStType("person_page");
        this.cma.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.akP() != null) {
                    p.this.akP().a(view, p.this.cXK);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.cXY, d.C0141d.cp_cont_b);
            aj.r(this.cYa, d.C0141d.cp_cont_j);
            aj.r(this.cYb, d.C0141d.cp_cont_b);
            aj.r(this.cYc, d.C0141d.cp_cont_d);
            aj.r(this.cYs, d.C0141d.cp_cont_d);
            aj.r(this.cYd, d.C0141d.cp_cont_d);
            if (this.cYe != null) {
                this.cYe.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.r(this.mTitle, d.C0141d.cp_cont_b);
            aj.r(this.cWV, d.C0141d.cp_cont_f);
            aj.r(this.cYl, d.C0141d.cp_cont_f);
            if (this.cYf != null) {
                this.cYf.onChangeSkinType();
            }
            this.cXV.onChangeSkinType();
            this.cma.onChangeSkinType();
            aj.t(this.cYu, d.C0141d.cp_bg_line_e);
            aj.t(this.cYv, d.C0141d.cp_bg_line_c);
            aj.t(this.cYl, d.C0141d.cp_bg_line_e);
            if (this.cYt != null) {
                this.cYt.onChangeSkinType();
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
        this.cXK = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVA);
        }
        this.cXY.setVisibility(cardPersonDynamicThreadData.daO ? 0 : 8);
        this.cXZ.setVisibility(cardPersonDynamicThreadData.daN ? 0 : 4);
        this.cYu.setVisibility(cardPersonDynamicThreadData.daN ? 0 : 8);
        this.cYv.setVisibility(cardPersonDynamicThreadData.daN ? 8 : 0);
        if (cardPersonDynamicThreadData.daP) {
            this.cYu.setVisibility(8);
            this.cYv.setVisibility(8);
        }
        this.cYw = cardPersonDynamicThreadData.daB == 40 && cardPersonDynamicThreadData.daD == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cYx = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.daD == 2;
        }
        this.cXY.setText(cardPersonDynamicThreadData.daE);
        this.cYa.setText(cardPersonDynamicThreadData.daF);
        this.cYb.setText(cardPersonDynamicThreadData.daG);
        if (cardPersonDynamicThreadData.daM != null && cardPersonDynamicThreadData.daM.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.daM.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.daM[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.daM.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cYc.setText(sb2);
                this.cYc.setVisibility(0);
            } else {
                this.cYc.setText(d.j.person_homepage);
            }
        } else {
            this.cYc.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cYd.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cYd.setVisibility(0);
            }
            eN(cardPersonDynamicThreadData.isPrivacy);
            this.cYe.setVisibility(0);
            this.cYe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.cYf == null) {
                            p.this.cYf = new o(p.this.mPageContext);
                            p.this.cYf.create();
                            p.this.cYf.a(p.this.cYz);
                        }
                        p.this.cYf.a(p.this.cXK);
                        p.this.cYf.show();
                    }
                }
            });
        } else {
            this.cYd.setVisibility(8);
            this.cYe.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.daJ;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cWT.setVisibility(0);
            eM(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cWT.setVoiceModel(voiceModel);
            this.cWT.setTag(voiceModel);
            this.cWT.aNR();
            if (voiceModel != null) {
                this.cWT.of(voiceModel.voice_status.intValue());
            }
            this.cWT.byf();
        } else {
            this.cWT.setVisibility(8);
            eM(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.daI;
        aj.s(this.cYk, d.C0141d.transparent);
        this.cYl.setVisibility(8);
        this.cYm.setVisibility(8);
        this.cYk.setVisibility(0);
        this.cYg.setVisibility(8);
        this.cYh.setVisibility(8);
        this.cYr.setVisibility(8);
        this.cYn.setVisibility(8);
        this.cYq.setVisibility(8);
        this.cWj.bEN();
        if (cardPersonDynamicThreadData.daB == 36) {
            this.cWW.setVisibility(8);
        } else if (cardPersonDynamicThreadData.daB == 33) {
            this.cWW.setVisibility(8);
            if (com.baidu.tbadk.core.i.xo().xu() && cardPersonDynamicThreadData.daK != null && !StringUtils.isNull(cardPersonDynamicThreadData.daK.livecover_src)) {
                this.cYg.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.daK)) {
                    this.cYg.setShowExpression(false);
                } else {
                    this.cYg.setShowExpression(true);
                }
                this.cYg.setShowImage(com.baidu.tbadk.core.i.xo().xu());
                this.cYg.setChooseStyle(d.getShowStyle());
                this.cYg.setData(d);
            }
        } else if (cardPersonDynamicThreadData.daB == 40 || this.cXK.daB == 50) {
            this.cWW.setVisibility(8);
            if (com.baidu.tbadk.core.i.xo().xu()) {
                this.cYh.setVisibility(0);
                this.cYj.setVisibility(0);
                this.cYj.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYh.getLayoutParams();
                int width = this.cYh.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cYh.setLayoutParams(layoutParams);
                if (this.cXK.videoInfo != null) {
                    this.cYi.setDefaultErrorResource(0);
                    this.cYi.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cYi.setEvent(this.cWF);
                    this.cYi.startLoad(this.cXK.videoInfo.thumbnail_url, 17, false);
                    if (this.cYw) {
                        this.cYr.setVisibility(0);
                        this.cYr.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cYn.setVisibility(0);
                        this.cYo.setText(am.fV(this.cXK.videoInfo.video_duration.intValue() * 1000));
                        this.cYp.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.J(this.cXK.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cXK.daB == 60 || this.cXK.daB == 49) {
            this.cWW.setVisibility(8);
            if (this.cXK.threadData.zG() != null && this.cXK.threadData.zG().user_info != null && this.cXK.daB == 60) {
                String str = this.cXK.threadData.zG().user_info.user_name;
                if (com.baidu.tbadk.util.w.ht(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cYl.setText(j.aH(str + ":", this.cXK.threadData.getTitle()));
                this.cYl.setVisibility(0);
            } else {
                this.cYl.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.xo().xu()) {
                this.cYh.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYh.getLayoutParams();
                int width2 = this.cYh.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cYh.setLayoutParams(layoutParams2);
                if (this.cXK.threadData.zG() != null) {
                    this.cYi.setDefaultErrorResource(0);
                    this.cYi.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cYi.setEvent(this.cWF);
                    this.cYi.startLoad(cardPersonDynamicThreadData.threadData.zG().cover, 10, false);
                    this.cYj.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cWj.startPlayAnimation();
                    aj.s(this.cYk, d.C0141d.cp_bg_line_e);
                    this.cYq.setVisibility(0);
                    this.cYq.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cXK.threadData.zG().audience_count)));
                    this.cma.getCommentContainer().setOnClickListener(this.cVA);
                } else {
                    this.cma.getCommentContainer().setOnClickListener(this.cma);
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
                    this.cWW.setVisibility(0);
                    this.cWW.setFromCDN(this.aYZ);
                    this.cWW.setSingleImageRatio(0.67d);
                    this.cWW.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z) {
                            if (z) {
                                p.this.alj();
                            } else {
                                p.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.cWW.setImageMediaList(linkedList);
                } else {
                    this.cWW.setVisibility(8);
                }
            } else {
                this.cWW.setVisibility(8);
            }
            this.cYk.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aQm != null) {
            this.cYt.setVisibility(0);
            this.cYt.b(cardPersonDynamicThreadData.threadData.aQm);
            this.cYt.setOnClickListener(this);
            this.cWT.setVisibility(8);
            this.cWW.setVisibility(8);
            this.cYk.setVisibility(8);
            if (this.cYx) {
                this.cYs.setVisibility(0);
            } else {
                this.cYs.setVisibility(8);
            }
        } else {
            this.cYt.setVisibility(8);
            this.cYs.setVisibility(8);
        }
        ali();
        c(cardPersonDynamicThreadData);
    }

    private void eM(boolean z) {
        if (this.cWW != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWW.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cWW.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cYw || this.cYx) {
                this.cma.setCommentClickable(false);
                this.cma.setAgreeClickable(false);
                this.cma.setShareClickable(false);
                this.cYt.setClickable(false);
                this.cYe.setClickable(false);
            } else {
                this.cma.setCommentClickable(true);
                this.cma.setAgreeClickable(true);
                this.cma.setShareClickable(true);
                this.cYt.setClickable(true);
                this.cYe.setClickable(true);
            }
            this.cma.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.daB == 60) {
                this.cma.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.daM != null) {
                this.cma.setMultiForumCount(cardPersonDynamicThreadData.daM.length);
            }
            this.cma.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void ali() {
        this.cWT.setClickable(true);
        int childCount = this.cWW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWW.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void alq() {
        if (this.cXK != null && this.cXK.threadData != null && this.cXK.threadData.zG() != null) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                j.kr(this.cXK.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXK.threadData.zG());
            if (this.cXK.threadData.zG().user_info != null) {
                alaLiveInfoCoreData.userName = this.cXK.threadData.zG().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        if (this.cXK != null && this.cXK.threadData != null && this.cXK.threadData.zG() != null && this.cXK.threadData.zG().share_info != null) {
            if (!isHost()) {
                j.kr(this.cXK.threadId);
            }
            if (this.cXK.threadData.zG().share_info.record_tid <= 0) {
                alq();
                return;
            }
            String valueOf = String.valueOf(this.cXK.threadData.zG().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        if (this.cXK != null) {
            if (!isHost()) {
                j.kr(this.cXK.threadId);
                j.a(this.mTitle, this.cXK.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                j.a(this.cWV, this.cXK.threadId, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cXK.daB == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cXK.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cXK.threadData.getFid()));
            pbActivityConfig.setForumName(this.cXK.threadData.zt());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cXK.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cXK.threadData == null || !this.cXK.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new ak("c12943").ab("obj_type", "2").ab("tid", this.cXK.threadId).s("obj_param1", this.cXK.isHost ? 1 : 2));
        }
    }

    private void als() {
        if (this.cXK != null && this.cXK.threadData != null && this.cXK.threadData.aQm != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cXK.threadData.aQm.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new ak("c12943").ab("obj_type", "3").ab("tid", this.cXK.threadId).s("obj_param1", this.cXK.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(boolean z) {
        if (this.cYd != null) {
            if (z) {
                this.cYd.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cYd.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cYd.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cYd.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cXK.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cYt) {
            als();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWW != null) {
            this.cWW.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWW != null) {
            this.cWW.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aYZ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYZ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (cardPersonDynamicThreadData.daK != null) {
            if (cardPersonDynamicThreadData.daK.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.daK.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.daK.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.daK.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.daK.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.daK.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.daK.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.daK.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.daK.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.daK.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.azM);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.daH != null && cardPersonDynamicThreadData.daH.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.daH.length; i++) {
                sb.append(cardPersonDynamicThreadData.daH[i].text);
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
        SpannableStringBuilder d = cardPersonDynamicThreadData.threadData.d(false, true, this.cYw);
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
