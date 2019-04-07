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
    private boolean ZQ;
    public PlayVoiceBntNew ZZ;
    private TbImageView.a cAn;
    public NewThreadCommentAndPraiseInfoLayout drm;
    private ConstrainImageGroup ehZ;
    private CustomMessageListener ehs;
    private CardPersonDynamicThreadData eiD;
    public ThreadViewAndCommentInfoLayout eiO;
    private final String eiP;
    private final String eiQ;
    private TextView eiR;
    private LinearLayout eiS;
    private TextView eiT;
    private TextView eiU;
    private TextView eiV;
    private TextView eiW;
    private ImageView eiX;
    private q eiY;
    private View eiZ;
    private View.OnClickListener eie;
    private final View.OnClickListener eif;
    private TbImageView eja;
    private ImageView ejb;
    private LinearLayout ejc;
    private TextView ejd;
    private LinearLayout eje;
    private LinearLayout ejf;
    private TextView ejg;
    private TextView ejh;
    private TextView eji;
    private TBLottieAnimationView ejj;
    private TextView ejk;
    private TextView ejl;
    public OriginalThreadCardView ejm;
    private View ejn;
    private View ejo;
    private boolean ejp;
    private boolean ejq;
    com.baidu.tieba.view.h ejr;
    private q.a ejs;
    private final View.OnClickListener ejt;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eiP = "1";
        this.eiQ = "2";
        this.mSkinType = 3;
        this.ZQ = true;
        this.ejr = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eiD != null && !StringUtils.isNull(r.this.eiD.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eiD.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(d.C0277d.cp_link_tip_c) : r.this.mContext.getResources().getColor(d.C0277d.cp_link_tip_a));
            }
        };
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aQf() != null) {
                    r.this.aQf().a(view, r.this.eiD);
                }
                if (r.this.eiD.elM != 60) {
                    if ((r.this.eiD.elM != 40 || r.this.eiD.elO != 2) && !r.this.ejq) {
                        r.this.ajU();
                        return;
                    } else {
                        BdToast.c(r.this.getContext(), r.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).abe();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eiD.threadData.Zh().live_status != 1) {
                    r.this.aQB();
                } else {
                    r.this.aQA();
                }
            }
        };
        this.ehs = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eiD != null && r.this.eiD.threadId != null && r.this.mTitle != null && r.this.XK != null && ((String) customResponsedMessage.getData()).equals(r.this.eiD.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eiD.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                    n.a(r.this.XK, r.this.eiD.threadId, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                }
            }
        };
        this.ejs = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.hP(z);
            }
        };
        this.ejt = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aQf = r.this.aQf();
                if (aQf != null) {
                    view.setTag("1");
                    aQf.a(view, r.this.eiD);
                }
                r.this.ajU();
            }
        };
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aQf = r.this.aQf();
                if (aQf != null) {
                    view.setTag("2");
                    aQf.a(view, r.this.eiD);
                }
            }
        };
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && r.this.eja != null) {
                    r.this.eja.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eiR = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.eiS = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.eiT = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.eiU = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.eiV = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.ejl = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.eiW = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.eiX = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.ZZ = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.ZZ.setAfterClickListener(this.eif);
        this.XK = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.XK.setVisibility(8);
        this.ehZ = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.ehZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.ehZ.setChildClickListener(this.ejt);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.ehZ.setImageProcessor(aVar);
        this.eiZ = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.eja = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.ejb = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.eiO = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.ejf = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.ejg = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.ejh = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.eji = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.ejj = (TBLottieAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.ejj.G(true);
        al.a(this.ejj, d.i.ala_play);
        this.ejk = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.ejc = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.ejd = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.eje = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.eje.setVisibility(8);
        this.ejm = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.ejn = this.mRootView.findViewById(d.g.divider_line_thick);
        this.ejo = this.mRootView.findViewById(d.g.divider_line_thin);
        this.drm = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.drm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.drm.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.drm.setLayoutParams(layoutParams);
        }
        this.drm.setOnClickListener(this.eie);
        this.drm.setReplyTimeVisible(false);
        this.drm.setShowPraiseNum(true);
        this.drm.setNeedAddPraiseIcon(true);
        this.drm.setNeedAddReplyIcon(true);
        this.drm.setShareVisible(true);
        this.drm.setIsBarViewVisible(false);
        this.drm.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxm = 8;
        dVar.bxr = 3;
        this.drm.setAgreeStatisticData(dVar);
        this.drm.setShareReportFrom(6);
        this.drm.setStType("person_page");
        this.drm.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aQf() != null) {
                    r.this.aQf().a(view, r.this.eiD);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.a(this.ejj, d.i.ala_play);
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.j(this.eiR, d.C0277d.cp_cont_b);
            al.j(this.eiT, d.C0277d.cp_cont_j);
            al.j(this.eiU, d.C0277d.cp_cont_b);
            al.j(this.eiV, d.C0277d.cp_cont_d);
            al.j(this.ejl, d.C0277d.cp_cont_d);
            al.j(this.eiW, d.C0277d.cp_cont_d);
            if (this.eiX != null) {
                this.eiX.setImageDrawable(al.getDrawable(d.f.icon_card_more));
            }
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.j(this.XK, d.C0277d.cp_cont_f);
            al.j(this.ejd, d.C0277d.cp_cont_f);
            if (this.eiY != null) {
                this.eiY.onChangeSkinType();
            }
            this.eiO.onChangeSkinType();
            this.drm.onChangeSkinType();
            al.l(this.ejn, d.C0277d.cp_bg_line_e);
            al.l(this.ejo, d.C0277d.cp_bg_line_c);
            al.l(this.ejd, d.C0277d.cp_bg_line_e);
            if (this.ejm != null) {
                this.ejm.onChangeSkinType();
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
        this.eiD = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eie);
        }
        this.eiR.setVisibility(cardPersonDynamicThreadData.elY ? 0 : 8);
        this.eiS.setVisibility(cardPersonDynamicThreadData.elX ? 0 : 4);
        this.ejn.setVisibility(cardPersonDynamicThreadData.elX ? 0 : 8);
        this.ejo.setVisibility(cardPersonDynamicThreadData.elX ? 8 : 0);
        if (cardPersonDynamicThreadData.elZ) {
            this.ejn.setVisibility(8);
            this.ejo.setVisibility(8);
        }
        this.ejp = cardPersonDynamicThreadData.elM == 40 && cardPersonDynamicThreadData.elO == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ejq = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.elO == 2;
        }
        this.eiR.setText(cardPersonDynamicThreadData.elP);
        this.eiT.setText(cardPersonDynamicThreadData.elQ);
        this.eiU.setText(cardPersonDynamicThreadData.elR);
        if (cardPersonDynamicThreadData.elW != null && cardPersonDynamicThreadData.elW.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.elW.length; i++) {
                sb.append(ap.g(cardPersonDynamicThreadData.elW[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.elW.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eiV.setText(sb2);
                this.eiV.setVisibility(0);
            } else {
                this.eiV.setText(d.j.person_homepage);
            }
        } else {
            this.eiV.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eiW.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eiW.setVisibility(0);
            }
            hP(cardPersonDynamicThreadData.isPrivacy);
            this.eiX.setVisibility(0);
            this.eiX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eiY == null) {
                            r.this.eiY = new q(r.this.mPageContext);
                            r.this.eiY.create();
                            r.this.eiY.a(r.this.ejs);
                        }
                        r.this.eiY.a(r.this.eiD);
                        r.this.eiY.show();
                    }
                }
            });
        } else {
            this.eiW.setVisibility(8);
            this.eiX.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.elU;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.ZZ.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.ZZ.setVoiceModel(voiceModel);
            this.ZZ.setTag(voiceModel);
            this.ZZ.bxS();
            if (voiceModel != null) {
                this.ZZ.uq(voiceModel.voice_status.intValue());
            }
            this.ZZ.cfz();
        } else {
            this.ZZ.setVisibility(8);
            hO(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.elT;
        al.k(this.ejc, d.C0277d.transparent);
        this.ejd.setVisibility(8);
        this.eje.setVisibility(8);
        this.ejc.setVisibility(0);
        this.eiZ.setVisibility(8);
        this.ejk.setVisibility(8);
        this.ejf.setVisibility(8);
        this.eji.setVisibility(8);
        this.ejj.cancelAnimation();
        this.ejj.setVisibility(8);
        if (cardPersonDynamicThreadData.elM == 36) {
            this.ehZ.setVisibility(8);
        } else if (cardPersonDynamicThreadData.elM == 40 || this.eiD.elM == 50) {
            this.ehZ.setVisibility(8);
            if (com.baidu.tbadk.core.i.Wv().Wz()) {
                this.eiZ.setVisibility(0);
                this.ejb.setVisibility(0);
                this.ejb.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eiZ.getLayoutParams();
                int width = this.eiZ.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eiZ.setLayoutParams(layoutParams);
                if (this.eiD.videoInfo != null) {
                    this.eja.setDefaultErrorResource(0);
                    this.eja.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.eja.setEvent(this.cAn);
                    this.eja.startLoad(this.eiD.videoInfo.thumbnail_url, 17, false);
                    if (this.ejp) {
                        this.ejk.setVisibility(0);
                        this.ejk.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.ejf.setVisibility(0);
                        this.ejg.setText(ap.hy(this.eiD.videoInfo.video_duration.intValue() * 1000));
                        this.ejh.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.eiD.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eiD.elM == 60 || this.eiD.elM == 49) {
            this.ehZ.setVisibility(8);
            if (this.eiD.threadData.Zh() != null && this.eiD.threadData.Zh().user_info != null && this.eiD.elM == 60) {
                String str = this.eiD.threadData.Zh().user_info.user_name;
                if (com.baidu.tbadk.util.ab.pO(str) > 14) {
                    str = com.baidu.tbadk.util.ab.ah(str, 14) + "...";
                }
                this.ejd.setText(n.ct(str + Config.TRACE_TODAY_VISIT_SPLIT, this.eiD.threadData.getTitle()));
                this.ejd.setVisibility(0);
            } else {
                this.ejd.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.Wv().Wz()) {
                this.eiZ.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eiZ.getLayoutParams();
                int width2 = this.eiZ.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eiZ.setLayoutParams(layoutParams2);
                if (this.eiD.threadData.Zh() != null) {
                    this.eja.setDefaultErrorResource(0);
                    this.eja.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.eja.setEvent(this.cAn);
                    this.eja.startLoad(cardPersonDynamicThreadData.threadData.Zh().cover, 10, false);
                    this.ejb.setVisibility(8);
                    this.ejj.setVisibility(0);
                    this.ejj.cu();
                    al.k(this.ejc, d.C0277d.cp_bg_line_e);
                    this.eji.setVisibility(0);
                    this.eji.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.eiD.threadData.Zh().audience_count)));
                    this.drm.getCommentContainer().setOnClickListener(this.eie);
                } else {
                    this.drm.getCommentContainer().setOnClickListener(this.drm);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.Wv().Wz() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bg bgVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.S(linkedList) > 0) {
                    this.ehZ.setVisibility(0);
                    this.ehZ.setFromCDN(this.ZQ);
                    this.ehZ.setSingleImageRatio(0.67d);
                    this.ehZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.ajU();
                            } else {
                                r.this.a(view, linkedList, i2, bgVar);
                            }
                        }
                    });
                    this.ehZ.setImageMediaList(linkedList);
                } else {
                    this.ehZ.setVisibility(8);
                }
            } else {
                this.ehZ.setVisibility(8);
            }
            this.ejc.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bDy != null) {
            this.ejm.setVisibility(0);
            this.ejm.b(cardPersonDynamicThreadData.threadData.bDy);
            this.ejm.setOnClickListener(this);
            this.ZZ.setVisibility(8);
            this.ehZ.setVisibility(8);
            this.ejc.setVisibility(8);
            if (this.ejq) {
                this.ejl.setVisibility(0);
            } else {
                this.ejl.setVisibility(8);
            }
        } else {
            this.ejm.setVisibility(8);
            this.ejl.setVisibility(8);
        }
        aQx();
        c(cardPersonDynamicThreadData);
    }

    private void hO(boolean z) {
        if (this.ehZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehZ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.ehZ.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ejp || this.ejq) {
                this.drm.setCommentClickable(false);
                this.drm.setAgreeClickable(false);
                this.drm.setShareClickable(false);
                this.ejm.setClickable(false);
                this.eiX.setClickable(false);
            } else {
                this.drm.setCommentClickable(true);
                this.drm.setAgreeClickable(true);
                this.drm.setShareClickable(true);
                this.ejm.setClickable(true);
                this.eiX.setClickable(true);
            }
            this.drm.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.elM == 60) {
                this.drm.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.elW != null) {
                this.drm.setMultiForumCount(cardPersonDynamicThreadData.elW.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.drm.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.drm.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aQx() {
        this.ZZ.setClickable(true);
        int childCount = this.ehZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ehZ.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aQA() {
        if (this.eiD != null && this.eiD.threadData != null && this.eiD.threadData.Zh() != null) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.tz(this.eiD.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eiD.threadData.Zh());
            if (this.eiD.threadData.Zh().user_info != null) {
                alaLiveInfoCoreData.userName = this.eiD.threadData.Zh().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQB() {
        if (this.eiD != null && this.eiD.threadData != null && this.eiD.threadData.Zh() != null && this.eiD.threadData.Zh().share_info != null) {
            if (!isHost()) {
                n.tz(this.eiD.threadId);
            }
            if (this.eiD.threadData.Zh().share_info.record_tid <= 0) {
                aQA();
                return;
            }
            String valueOf = String.valueOf(this.eiD.threadData.Zh().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajU() {
        if (this.eiD != null) {
            if (!isHost()) {
                n.tz(this.eiD.threadId);
                n.a(this.mTitle, this.eiD.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                n.a(this.XK, this.eiD.threadId, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eiD.elM == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eiD.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eiD.threadData.getFid()));
            pbActivityConfig.setForumName(this.eiD.threadData.YT());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eiD.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eiD.threadData == null || !this.eiD.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").bJ("obj_type", "2").bJ("tid", this.eiD.threadId).T("obj_param1", this.eiD.isHost ? 1 : 2));
        }
    }

    private void aQC() {
        if (this.eiD != null && this.eiD.threadData != null && this.eiD.threadData.bDy != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eiD.threadData.bDy.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").bJ("obj_type", "3").bJ("tid", this.eiD.threadId).T("obj_param1", this.eiD.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(boolean z) {
        if (this.eiW != null) {
            if (z) {
                this.eiW.setText(d.j.privacy);
                Drawable drawable = al.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eiW.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eiW.setText(d.j.public_open);
            Drawable drawable2 = al.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eiW.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eiD.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ejm) {
            aQC();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.ZQ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YT(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZQ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.ejp);
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
