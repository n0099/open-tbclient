package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.VideoAggregationDisPraiseView;
import com.baidu.tbadk.core.view.VideoAggregationPraiseView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.aggregation.h;
import com.baidu.tieba.frs.videomiddlepage.controller.VideoNetworkStateTipView;
import com.baidu.tieba.frs.view.SpannableClickTextView;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i {
    private com.baidu.tieba.lego.card.view.f Sk;
    protected VideoAggregationPraiseView aFi;
    protected VideoAggregationDisPraiseView aFj;
    public com.baidu.tieba.frs.aggregation.g aFk;
    private TextView aIZ;
    private ImageView aJa;
    private View aJb;
    private ImageView aJd;
    private View aJe;
    public TextView aKp;
    private String arh;
    private boolean axE;
    private Animation bOd;
    private n bOp;
    public HeadImageView cCi;
    public FrameLayout dMK;
    public FrameLayout dML;
    public com.baidu.tieba.play.c dMY;
    private h dMZ;
    private z dNa;
    private z dNb;
    private boolean dNc;
    private boolean dNd;
    private Animation dNf;
    private boolean dNh;
    private Runnable eeA;
    public SpannableClickTextView eel;
    private View eem;
    protected com.baidu.tbadk.core.view.c een;
    private FrameLayout eeo;
    private TextView eep;
    private boolean eeq;
    private boolean eer;
    private View ees;
    private View eet;
    private b eeu;
    public com.baidu.tieba.frs.videomiddlepage.controller.a eev;
    private C0230a eew;
    private VideoNetworkStateTipView eex;
    private Animation.AnimationListener eey;
    private Animation.AnimationListener eez;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dNc = true;
        this.dNh = true;
        this.eeq = false;
        this.eer = false;
        this.eey = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ees != null) {
                    a.this.ees.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ees != null) {
                    a.this.ees.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eez = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ees != null) {
                    a.this.ees.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ees != null) {
                    a.this.ees.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eeA = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.eeo.getVisibility() == 0) {
                    a.this.eeo.setVisibility(8);
                }
            }
        };
        this.dNh = z;
        this.mFrom = str;
        this.arh = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dMK = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.eem = view.findViewById(e.g.card_container);
        this.dML = (FrameLayout) view.findViewById(e.g.video_container);
        this.dMY = new com.baidu.tieba.play.c(tbPageContext, (View) this.dML, false);
        this.dMY.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.eev != null && a.this.aFk.dNz.videoDuration > 8) {
                    a.this.eev.N(a.this.mPosition, a.this.aFk.dNz.videoUrl);
                }
            }
        });
        this.dMY.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // com.baidu.tieba.play.c.a
            public void ht(boolean z2) {
                if (a.this.eew != null) {
                    if (z2) {
                        a.this.eew.nB(0);
                    } else {
                        a.this.eew.nB(1);
                    }
                }
            }
        });
        this.eel = (SpannableClickTextView) view.findViewById(e.g.title);
        this.cCi = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKp = (TextView) view.findViewById(e.g.user_name);
        this.aFi = (VideoAggregationPraiseView) view.findViewById(e.g.agree_view);
        this.aFj = (VideoAggregationDisPraiseView) view.findViewById(e.g.disagree_view);
        this.een = new com.baidu.tbadk.core.view.c(this.aFi, this.aFj);
        this.een.EF();
        this.een.h(tbPageContext.getUniqueId());
        this.aIZ = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.aJa = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.aJb = view.findViewById(e.g.thread_info_commont_container);
        this.aJd = (ImageView) view.findViewById(e.g.share_num_img);
        this.aJe = view.findViewById(e.g.share_num_container);
        this.eeo = (FrameLayout) view.findViewById(e.g.download_nani_guide_container);
        this.eep = (TextView) view.findViewById(e.g.download_nani_guide_txt);
        this.eeo.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.eep.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.eep.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Ef().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.eex = (VideoNetworkStateTipView) view.findViewById(e.g.network_state_tip);
        this.eex.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.eex.setHasAgreeToPlay(true);
                a.this.dMY.mv(false);
                a.this.eex.aHQ();
                if (a.this.aFk != null && a.this.aFk.dNz != null) {
                    a.this.dMY.aZ(a.this.aFk.dNz.videoUrl, a.this.aFk.threadId);
                }
            }
        });
        this.ees = view.findViewById(e.g.video_agg_container_foreground);
        this.eet = view.findViewById(e.g.title_and_comment_container_foreground);
        this.ees.setOnClickListener(this);
        this.aFi.setOnClickListener(this);
        this.aFj.setOnClickListener(this);
        this.aJb.setOnClickListener(this);
        this.aJe.setOnClickListener(this);
        this.eel.setOnClickListener(this);
        this.cCi.setOnClickListener(this);
        this.aKp.setOnClickListener(this);
        this.eem.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dMK.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dMK.setLayoutParams(layoutParams);
        this.cCi.setIsRound(true);
        this.bOp = new n(tbPageContext.getPageActivity());
        this.dMZ = new h(this.mPageContext, this);
        this.dNf = new AlphaAnimation(0.0f, 0.7f);
        this.dNf.setDuration(500L);
        this.dNf.setAnimationListener(this.eez);
        this.bOd = new AlphaAnimation(0.7f, 0.0f);
        this.bOd.setDuration(500L);
        this.bOd.setAnimationListener(this.eey);
        this.eew = new C0230a();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.een != null) {
            this.een.onChangeSkinType(i);
        }
        this.aIZ.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.aJa.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_comment_background));
        this.aJd.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_share_background));
        this.eel.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dNz != null) {
            this.aFk = gVar;
            this.axE = this.aFk.autoPlay;
            this.eer = false;
            hr(false);
            this.eel.setVisibility(0);
            if (gVar.dNz != null && !StringUtils.isNull(gVar.dNz.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.a.a.a(this.mContext, this.eel, gVar.title, gVar.dNz.mcnLeadPage, gVar.getThreadId());
            } else {
                this.eel.setText(gVar.title);
            }
            aHC();
            b(gVar, i, aVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aHB() {
        try {
            int parseInt = Integer.parseInt(this.aFk.dNz.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.aFk.dNz.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aHC() {
        if (!aHB()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dMK.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dMK.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dMK.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dMK.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dNz != null) {
            this.dMY.stopPlay();
            this.dMY.setIsNeedRecoveryVideoPlayer(true);
            this.dMY.mw(true);
            this.dMY.ms(true);
            this.dMY.mx(true);
            this.dMY.S(false, false);
            this.dMY.tm(i);
            this.dMY.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YQ() {
                    a.this.aHD();
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YR() {
                    a.this.aHE();
                    if (a.this.dMY.bqV()) {
                    }
                    if (a.this.dNd) {
                        a.this.dMY.stopPlay();
                    }
                }
            });
            this.dMY.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.l
                public void aCU() {
                    if (a.this.aFk != null && a.this.aFk.dNz != null && com.baidu.adp.lib.g.b.l(a.this.aFk.dNz.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.aFk.dNz.videoWidth, 0)) {
                        a.this.dMY.S(false, false);
                    } else {
                        a.this.dMY.S(true, false);
                    }
                    a.this.dNd = false;
                    a.this.oe(a.this.axE ? "1" : "2");
                    a.this.onClick(a.this.dML);
                    if (a.this.Sk != null) {
                        a.this.Sk.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void aCV() {
                    a.this.onClick(a.this.dMK);
                }
            });
            this.dMY.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.c.f
                public void gT(boolean z) {
                    a.this.dMY.aZ(a.this.aFk.dNz.videoUrl, a.this.aFk.threadId);
                    a.this.oe("2");
                    a.this.onClick(a.this.dML);
                }
            });
            this.dMY.mp(false);
            this.dNa = new z();
            this.dNa.biw = gVar.threadId;
            this.dNa.cXO = gVar.forumId;
            this.dNa.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dNa.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dNa.mSource = gVar.source;
            this.dNa.gEN = gVar.weight;
            this.dNa.gEP = this.mFrom;
            this.dNa.gEQ = gVar.abtest_tag;
            this.dNa.arh = this.arh;
            this.dNa.mExtra = gVar.extra;
            this.dNa.gET = "0";
            this.dNb = new z();
            this.dNb.biw = gVar.threadId;
            this.dNb.cXO = gVar.forumId;
            this.dNb.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dNb.gEN = "auto_midpage";
            this.dNb.mLocate = "auto_midpage";
            this.dNb.gEP = this.mFrom;
            this.dNb.mSource = gVar.source;
            this.dNb.gET = "0";
            if (gVar.dNz != null) {
                this.dNa.gER = gVar.dNz.videoMd5;
                this.dNb.gER = gVar.dNz.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.aA("tid", gVar.threadId);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", i);
            amVar.x("obj_param2", 1);
            amVar.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.aA("obj_param1", ao.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.aA("extra", ao.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.arh);
            amVar.aA("ab_tag", ao.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.aA("obj_type", this.mFrom);
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.aFk.source) ? "0" : this.aFk.source);
            amVar.x("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.bOp.setVideoStatsData(this.dNa);
            this.dMY.getVideoView().setBusiness(this.bOp);
            this.bOp.a(gVar);
            this.dMY.aYO();
            this.dMY.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dNd = true;
                        a.this.dNc = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.mt(i);
                        a.this.dMY.aLW();
                    }
                }
            });
            this.dMY.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.aFk != null && a.this.aFk.dNz != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.aFk.dNz.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dMY.setThumbnail(gVar.dNz.thumbnailUrl);
            this.dMY.setVideoUrl(gVar.dNz.videoUrl, gVar.threadId);
            this.dMY.setFid(gVar.forumId);
            this.dMY.aLW();
            this.dMY.show();
            hr(false);
            if (gVar.autoPlay) {
                onClick(this.dML);
                if (this.eex.aHO()) {
                    this.dMY.mu(false);
                    this.eex.aHP();
                    this.dMY.mv(true);
                    this.dMY.cr(gVar.dNz.videoUrl, gVar.threadId);
                } else {
                    this.dMY.mv(false);
                    this.dMY.mu(false);
                    this.eex.hide();
                    this.dMY.a(gVar.dNz.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                }
                if (i == 0 && gVar.dNA) {
                    this.ees.setVisibility(8);
                    this.eew.nB(3);
                } else {
                    if (this.ees.getVisibility() == 0) {
                        this.ees.startAnimation(this.bOd);
                    }
                    this.eew.nB(0);
                }
                gVar.dNA = false;
            } else {
                this.ees.setVisibility(0);
                this.eex.hide();
                this.dMY.mu(true);
                this.eew.nB(3);
                this.dMY.cr(gVar.dNz.videoUrl, gVar.threadId);
            }
            this.dNd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe(String str) {
        if (this.aFk != null && this.aFk.dNz != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFk.dNz.videoMd5, "", str, this.dNb);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dMY.bqV();
    }

    public void aCQ() {
        if (isPlaying()) {
            this.dMY.pausePlay();
        }
    }

    public boolean mu(int i) {
        return this.dMY.tl(i);
    }

    public void aCR() {
        this.eer = false;
        this.dMY.stopPlay();
        if (this.eel != null) {
            this.eel.setVisibility(0);
        }
        if (this.eew != null) {
            this.eew.nB(2);
        }
        hr(false);
        this.eeq = true;
    }

    public void aCS() {
        if (this.dMY != null) {
            this.dMY.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aCS();
        if (this.dMZ != null) {
            this.dMZ.aDd();
        }
        if (this.ees != null) {
            this.ees.clearAnimation();
        }
        if (this.een != null) {
            this.een.onDestroy();
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dNy != null) {
            this.aKp.setText(TextUtils.isEmpty(gVar.dNy.userNickname) ? gVar.dNy.userName : gVar.dNy.userNickname);
            if (!StringUtils.isNull(gVar.dNy.portrait) && gVar.dNy.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.cCi.startLoad(gVar.dNy.portrait, 10, false);
            } else {
                this.cCi.startLoad(gVar.dNy.portrait, 12, false);
            }
            if (gVar.dNy.isBigV) {
                this.cCi.setShowV(gVar.dNy.isBigV);
                this.cCi.setIsBigV(gVar.dNy.isBigV);
            } else if (gVar.dNy.isGod) {
                this.cCi.setShowV(gVar.dNy.isGod);
                this.cCi.setIsBigV(gVar.dNy.isGod);
            } else {
                this.cCi.setShowV(gVar.dNy.isGod);
                this.cCi.setIsBigV(gVar.dNy.isGod);
            }
            e(gVar);
            f(gVar);
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && this.een != null) {
            this.een.a(gVar);
        }
    }

    public void f(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aIZ.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha70));
            this.aJa.setImageDrawable(getContext().getResources().getDrawable(e.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aIZ.setText(ao.W(gVar.postNum));
            } else {
                this.aIZ.setText(this.mContext.getString(e.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dMY != null && this.dML != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dNc) {
                this.dMY.bqU();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aHD();
            } else {
                configuration.orientation = 1;
                aHE();
                this.dNc = true;
            }
            this.dMY.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHD() {
        if (this.dMY != null && this.dML != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dML.getParent() != null) {
                if (this.dML.getParent() == frameLayout) {
                    frameLayout.removeView(this.dML);
                } else if (this.dML.getParent() == this.dMK) {
                    this.dMK.removeView(this.dML);
                }
            }
            if (this.dML.getParent() == null) {
                frameLayout.addView(this.dML);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dML.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dML.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHE() {
        if (this.dMY != null && this.dML != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dML.getParent() != null) {
                if (this.dML.getParent() == frameLayout) {
                    frameLayout.removeView(this.dML);
                } else if (this.dML.getParent() == this.dMK) {
                    this.dMK.removeView(this.dML);
                }
            }
            if (this.dML.getParent() == null) {
                this.dMK.addView(this.dML, 0);
                aHF();
                this.dMY.aYO();
            }
        }
    }

    private void aHF() {
        int i;
        if (!aHB()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dML.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (apc() != null) {
            view.setTag(this);
            apc().a(view, this.aFk);
        }
        if (view == this.cCi || view == this.aKp) {
            if (this.aFk != null && this.aFk.dNy != null && !TextUtils.isEmpty(this.aFk.dNy.userId)) {
                this.eew.nB(0);
                if (!TbadkCoreApplication.isLogin() || !this.aFk.dNy.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFk.dNy.userId, 0L), z, this.aFk.dNy.isGod)));
            }
        } else if (view == this.aJb) {
            if (this.aFk != null) {
                this.eew.nB(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFk.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.eel || view == this.eem) {
            if (this.aFk != null) {
                if (this.eew.getCurrentState() != 2 && this.eew.getCurrentState() != 3) {
                    z = false;
                }
                this.eew.nB(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.aFk.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.aJe) {
            this.eew.nB(0);
            Fp();
        } else if (view == this.ees && this.ees.getVisibility() == 0) {
            if (this.eeu != null) {
                this.eeu.nF(this.mPosition);
            }
        } else if (view == this.aFi) {
            this.eew.nB(0);
            this.aFi.L(view);
        } else if (view == this.aFj) {
            this.eew.nB(0);
            this.aFj.L(view);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gS(boolean z) {
        if (this.aFk != null && this.aFk.dNy != null) {
            this.aFk.dNy.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aCT() {
        if (this.aFk != null && this.aFi != null) {
            this.aFi.L(this.aFi);
        }
    }

    public void hq(boolean z) {
        if (this.dMK != null) {
            this.dMK.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.eeu = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Sk = fVar;
    }

    private void hr(boolean z) {
        this.eeq = this.mPosition == (this.eev == null ? -1 : this.eev.aHM());
        if (this.eeq && z && isPlaying() && this.axE && !this.eer) {
            this.eeo.setVisibility(0);
            this.eer = true;
            this.eeo.postDelayed(this.eeA, 5000L);
            if (this.eev != null) {
                this.eev.bX(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.eeo.setVisibility(8);
        if (this.eeA != null) {
            this.eeo.removeCallbacks(this.eeA);
        }
    }

    private void Fp() {
        if (this.aFk != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFk.forumId);
            String str = this.aFk.title;
            String str2 = this.aFk.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.aFk.dNz.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.aFk.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(e.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aSj = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aSm = 3;
            dVar.fid = valueOf;
            dVar.aSf = "";
            dVar.tid = str2;
            dVar.aSb = true;
            dVar.aSl = 0;
            dVar.aSn = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSm);
            bundle.putInt("obj_type", dVar.aSn);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avK);
            dVar.k(bundle);
            com.baidu.tieba.c.e.aro().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aCR();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        aCQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0230a {
        private Runnable eeD;
        private int mCurrentState;

        private C0230a() {
            this.mCurrentState = -1;
            this.eeD = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(C0230a.this.eeD);
                    C0230a.this.nB(2);
                }
            };
        }

        public void nB(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = nC(i);
                    aHG();
                    return;
                case 1:
                    this.mCurrentState = nC(i);
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeD);
                    return;
                case 2:
                    this.mCurrentState = nD(i);
                    return;
                case 3:
                    this.mCurrentState = nE(i);
                    aHG();
                    return;
                default:
                    this.mCurrentState = nD(i);
                    return;
            }
        }

        private void aHG() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeD);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eeD, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int nC(int i) {
            if (i != this.mCurrentState) {
                a.this.eet.setVisibility(8);
                a.this.hs(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int nD(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.eet.setVisibility(0);
                if (i2 != 3 || a.this.aFk.autoPlay) {
                    a.this.hs(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int nE(int i) {
            if (i != this.mCurrentState) {
                a.this.eet.setVisibility(0);
                a.this.hs(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
