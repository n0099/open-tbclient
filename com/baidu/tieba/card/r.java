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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class r extends a<CardPersonDynamicThreadData> {
    private TextView XK;
    private boolean ZP;
    public PlayVoiceBntNew ZY;
    private TbImageView.a cAl;
    public NewThreadCommentAndPraiseInfoLayout drj;
    private CustomMessageListener ehG;
    private CardPersonDynamicThreadData eiR;
    private ConstrainImageGroup ein;
    private View.OnClickListener eis;
    private final View.OnClickListener eit;
    public OriginalThreadCardView ejA;
    private View ejB;
    private View ejC;
    private boolean ejD;
    private boolean ejE;
    com.baidu.tieba.view.h ejF;
    private q.a ejG;
    private final View.OnClickListener ejH;
    public ThreadViewAndCommentInfoLayout ejc;
    private final String ejd;
    private final String eje;
    private TextView ejf;
    private LinearLayout ejg;
    private TextView ejh;
    private TextView eji;
    private TextView ejj;
    private TextView ejk;
    private ImageView ejl;
    private q ejm;
    private View ejn;
    private TbImageView ejo;
    private ImageView ejp;
    private LinearLayout ejq;
    private TextView ejr;
    private LinearLayout ejs;
    private LinearLayout ejt;
    private TextView eju;
    private TextView ejv;
    private TextView ejw;
    private TBLottieAnimationView ejx;
    private TextView ejy;
    private TextView ejz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ejd = "1";
        this.eje = "2";
        this.mSkinType = 3;
        this.ZP = true;
        this.ejF = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eiR != null && !StringUtils.isNull(r.this.eiR.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eiR.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(d.C0277d.cp_link_tip_c) : r.this.mContext.getResources().getColor(d.C0277d.cp_link_tip_a));
            }
        };
        this.eis = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aQh() != null) {
                    r.this.aQh().a(view, r.this.eiR);
                }
                if (r.this.eiR.ema != 60) {
                    if ((r.this.eiR.ema != 40 || r.this.eiR.emc != 2) && !r.this.ejE) {
                        r.this.ajX();
                        return;
                    } else {
                        BdToast.c(r.this.getContext(), r.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).abh();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eiR.threadData.Zk().live_status != 1) {
                    r.this.aQD();
                } else {
                    r.this.aQC();
                }
            }
        };
        this.ehG = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eiR != null && r.this.eiR.threadId != null && r.this.mTitle != null && r.this.XK != null && ((String) customResponsedMessage.getData()).equals(r.this.eiR.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eiR.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                    n.a(r.this.XK, r.this.eiR.threadId, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                }
            }
        };
        this.ejG = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.hP(z);
            }
        };
        this.ejH = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aQh = r.this.aQh();
                if (aQh != null) {
                    view.setTag("1");
                    aQh.a(view, r.this.eiR);
                }
                r.this.ajX();
            }
        };
        this.eit = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aQh = r.this.aQh();
                if (aQh != null) {
                    view.setTag("2");
                    aQh.a(view, r.this.eiR);
                }
            }
        };
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && r.this.ejo != null) {
                    r.this.ejo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.ejf = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.ejg = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.ejh = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.eji = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.ejj = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.ejz = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.ejk = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.ejl = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.ZY = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.ZY.setAfterClickListener(this.eit);
        this.XK = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.XK.setVisibility(8);
        this.ein = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.ein.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.ein.setChildClickListener(this.ejH);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.ein.setImageProcessor(aVar);
        this.ejn = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.ejo = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.ejp = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.ejc = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.ejt = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.eju = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.ejv = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.ejw = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.ejx = (TBLottieAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.ejx.G(true);
        al.a(this.ejx, d.i.ala_play);
        this.ejy = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.ejq = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.ejr = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.ejs = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.ejs.setVisibility(8);
        this.ejA = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.ejB = this.mRootView.findViewById(d.g.divider_line_thick);
        this.ejC = this.mRootView.findViewById(d.g.divider_line_thin);
        this.drj = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.drj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.drj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.drj.setLayoutParams(layoutParams);
        }
        this.drj.setOnClickListener(this.eis);
        this.drj.setReplyTimeVisible(false);
        this.drj.setShowPraiseNum(true);
        this.drj.setNeedAddPraiseIcon(true);
        this.drj.setNeedAddReplyIcon(true);
        this.drj.setShareVisible(true);
        this.drj.setIsBarViewVisible(false);
        this.drj.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxj = 8;
        dVar.bxo = 3;
        this.drj.setAgreeStatisticData(dVar);
        this.drj.setShareReportFrom(6);
        this.drj.setStType("person_page");
        this.drj.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aQh() != null) {
                    r.this.aQh().a(view, r.this.eiR);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.a(this.ejx, d.i.ala_play);
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.j(this.ejf, d.C0277d.cp_cont_b);
            al.j(this.ejh, d.C0277d.cp_cont_j);
            al.j(this.eji, d.C0277d.cp_cont_b);
            al.j(this.ejj, d.C0277d.cp_cont_d);
            al.j(this.ejz, d.C0277d.cp_cont_d);
            al.j(this.ejk, d.C0277d.cp_cont_d);
            if (this.ejl != null) {
                this.ejl.setImageDrawable(al.getDrawable(d.f.icon_card_more));
            }
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.j(this.XK, d.C0277d.cp_cont_f);
            al.j(this.ejr, d.C0277d.cp_cont_f);
            if (this.ejm != null) {
                this.ejm.onChangeSkinType();
            }
            this.ejc.onChangeSkinType();
            this.drj.onChangeSkinType();
            al.l(this.ejB, d.C0277d.cp_bg_line_e);
            al.l(this.ejC, d.C0277d.cp_bg_line_c);
            al.l(this.ejr, d.C0277d.cp_bg_line_e);
            if (this.ejA != null) {
                this.ejA.onChangeSkinType();
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
        this.eiR = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eis);
        }
        this.ejf.setVisibility(cardPersonDynamicThreadData.emm ? 0 : 8);
        this.ejg.setVisibility(cardPersonDynamicThreadData.eml ? 0 : 4);
        this.ejB.setVisibility(cardPersonDynamicThreadData.eml ? 0 : 8);
        this.ejC.setVisibility(cardPersonDynamicThreadData.eml ? 8 : 0);
        if (cardPersonDynamicThreadData.emn) {
            this.ejB.setVisibility(8);
            this.ejC.setVisibility(8);
        }
        this.ejD = cardPersonDynamicThreadData.ema == 40 && cardPersonDynamicThreadData.emc == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ejE = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.emc == 2;
        }
        this.ejf.setText(cardPersonDynamicThreadData.emd);
        this.ejh.setText(cardPersonDynamicThreadData.eme);
        this.eji.setText(cardPersonDynamicThreadData.emf);
        if (cardPersonDynamicThreadData.emk != null && cardPersonDynamicThreadData.emk.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.emk.length; i++) {
                sb.append(ap.g(cardPersonDynamicThreadData.emk[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.emk.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.ejj.setText(sb2);
                this.ejj.setVisibility(0);
            } else {
                this.ejj.setText(d.j.person_homepage);
            }
        } else {
            this.ejj.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.ejk.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.ejk.setVisibility(0);
            }
            hP(cardPersonDynamicThreadData.isPrivacy);
            this.ejl.setVisibility(0);
            this.ejl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.ejm == null) {
                            r.this.ejm = new q(r.this.mPageContext);
                            r.this.ejm.create();
                            r.this.ejm.a(r.this.ejG);
                        }
                        r.this.ejm.a(r.this.eiR);
                        r.this.ejm.show();
                    }
                }
            });
        } else {
            this.ejk.setVisibility(8);
            this.ejl.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.emi;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.ZY.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.ZY.setVoiceModel(voiceModel);
            this.ZY.setTag(voiceModel);
            this.ZY.bxV();
            if (voiceModel != null) {
                this.ZY.uu(voiceModel.voice_status.intValue());
            }
            this.ZY.cfD();
        } else {
            this.ZY.setVisibility(8);
            hO(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.emh;
        al.k(this.ejq, d.C0277d.transparent);
        this.ejr.setVisibility(8);
        this.ejs.setVisibility(8);
        this.ejq.setVisibility(0);
        this.ejn.setVisibility(8);
        this.ejy.setVisibility(8);
        this.ejt.setVisibility(8);
        this.ejw.setVisibility(8);
        this.ejx.cancelAnimation();
        this.ejx.setVisibility(8);
        if (cardPersonDynamicThreadData.ema == 36) {
            this.ein.setVisibility(8);
        } else if (cardPersonDynamicThreadData.ema == 40 || this.eiR.ema == 50) {
            this.ein.setVisibility(8);
            if (com.baidu.tbadk.core.i.Wy().WC()) {
                this.ejn.setVisibility(0);
                this.ejp.setVisibility(0);
                this.ejp.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejn.getLayoutParams();
                int width = this.ejn.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.ejn.setLayoutParams(layoutParams);
                if (this.eiR.videoInfo != null) {
                    this.ejo.setDefaultErrorResource(0);
                    this.ejo.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ejo.setEvent(this.cAl);
                    this.ejo.startLoad(this.eiR.videoInfo.thumbnail_url, 17, false);
                    if (this.ejD) {
                        this.ejy.setVisibility(0);
                        this.ejy.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.ejt.setVisibility(0);
                        this.eju.setText(ap.hz(this.eiR.videoInfo.video_duration.intValue() * 1000));
                        this.ejv.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.eiR.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eiR.ema == 60 || this.eiR.ema == 49) {
            this.ein.setVisibility(8);
            if (this.eiR.threadData.Zk() != null && this.eiR.threadData.Zk().user_info != null && this.eiR.ema == 60) {
                String str = this.eiR.threadData.Zk().user_info.user_name;
                if (com.baidu.tbadk.util.ab.pN(str) > 14) {
                    str = com.baidu.tbadk.util.ab.ah(str, 14) + "...";
                }
                this.ejr.setText(n.cs(str + Config.TRACE_TODAY_VISIT_SPLIT, this.eiR.threadData.getTitle()));
                this.ejr.setVisibility(0);
            } else {
                this.ejr.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.Wy().WC()) {
                this.ejn.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ejn.getLayoutParams();
                int width2 = this.ejn.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.ejn.setLayoutParams(layoutParams2);
                if (this.eiR.threadData.Zk() != null) {
                    this.ejo.setDefaultErrorResource(0);
                    this.ejo.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ejo.setEvent(this.cAl);
                    this.ejo.startLoad(cardPersonDynamicThreadData.threadData.Zk().cover, 10, false);
                    this.ejp.setVisibility(8);
                    this.ejx.setVisibility(0);
                    this.ejx.cu();
                    al.k(this.ejq, d.C0277d.cp_bg_line_e);
                    this.ejw.setVisibility(0);
                    this.ejw.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.eiR.threadData.Zk().audience_count)));
                    this.drj.getCommentContainer().setOnClickListener(this.eis);
                } else {
                    this.drj.getCommentContainer().setOnClickListener(this.drj);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.Wy().WC() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bg bgVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.S(linkedList) > 0) {
                    this.ein.setVisibility(0);
                    this.ein.setFromCDN(this.ZP);
                    this.ein.setSingleImageRatio(0.67d);
                    this.ein.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.ajX();
                            } else {
                                r.this.a(view, linkedList, i2, bgVar);
                            }
                        }
                    });
                    this.ein.setImageMediaList(linkedList);
                } else {
                    this.ein.setVisibility(8);
                }
            } else {
                this.ein.setVisibility(8);
            }
            this.ejq.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bDv != null) {
            this.ejA.setVisibility(0);
            this.ejA.b(cardPersonDynamicThreadData.threadData.bDv);
            this.ejA.setOnClickListener(this);
            this.ZY.setVisibility(8);
            this.ein.setVisibility(8);
            this.ejq.setVisibility(8);
            if (this.ejE) {
                this.ejz.setVisibility(0);
            } else {
                this.ejz.setVisibility(8);
            }
        } else {
            this.ejA.setVisibility(8);
            this.ejz.setVisibility(8);
        }
        aQz();
        c(cardPersonDynamicThreadData);
    }

    private void hO(boolean z) {
        if (this.ein != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ein.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.ein.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ejD || this.ejE) {
                this.drj.setCommentClickable(false);
                this.drj.setAgreeClickable(false);
                this.drj.setShareClickable(false);
                this.ejA.setClickable(false);
                this.ejl.setClickable(false);
            } else {
                this.drj.setCommentClickable(true);
                this.drj.setAgreeClickable(true);
                this.drj.setShareClickable(true);
                this.ejA.setClickable(true);
                this.ejl.setClickable(true);
            }
            this.drj.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.ema == 60) {
                this.drj.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.emk != null) {
                this.drj.setMultiForumCount(cardPersonDynamicThreadData.emk.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.drj.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.drj.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aQz() {
        this.ZY.setClickable(true);
        int childCount = this.ein.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ein.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aQC() {
        if (this.eiR != null && this.eiR.threadData != null && this.eiR.threadData.Zk() != null) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.tA(this.eiR.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eiR.threadData.Zk());
            if (this.eiR.threadData.Zk().user_info != null) {
                alaLiveInfoCoreData.userName = this.eiR.threadData.Zk().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQD() {
        if (this.eiR != null && this.eiR.threadData != null && this.eiR.threadData.Zk() != null && this.eiR.threadData.Zk().share_info != null) {
            if (!isHost()) {
                n.tA(this.eiR.threadId);
            }
            if (this.eiR.threadData.Zk().share_info.record_tid <= 0) {
                aQC();
                return;
            }
            String valueOf = String.valueOf(this.eiR.threadData.Zk().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajX() {
        if (this.eiR != null) {
            if (!isHost()) {
                n.tA(this.eiR.threadId);
                n.a(this.mTitle, this.eiR.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                n.a(this.XK, this.eiR.threadId, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eiR.ema == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eiR.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eiR.threadData.getFid()));
            pbActivityConfig.setForumName(this.eiR.threadData.YW());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eiR.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eiR.threadData == null || !this.eiR.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").bJ("obj_type", "2").bJ("tid", this.eiR.threadId).T("obj_param1", this.eiR.isHost ? 1 : 2));
        }
    }

    private void aQE() {
        if (this.eiR != null && this.eiR.threadData != null && this.eiR.threadData.bDv != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eiR.threadData.bDv.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").bJ("obj_type", "3").bJ("tid", this.eiR.threadId).T("obj_param1", this.eiR.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(boolean z) {
        if (this.ejk != null) {
            if (z) {
                this.ejk.setText(d.j.privacy);
                Drawable drawable = al.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.ejk.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.ejk.setText(d.j.public_open);
            Drawable drawable2 = al.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.ejk.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eiR.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ejA) {
            aQE();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
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
                imageUrlData.urlType = this.ZP ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YW(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZP, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.ejD);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(c));
        this.mTitle.setText(c);
        if (isHost()) {
            return true;
        }
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        return true;
    }
}
