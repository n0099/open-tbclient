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
    protected VideoAggregationPraiseView aBI;
    protected VideoAggregationDisPraiseView aBJ;
    public com.baidu.tieba.frs.aggregation.g aBK;
    private ImageView aFA;
    private View aFB;
    private ImageView aFD;
    private View aFE;
    private TextView aFz;
    public TextView aGP;
    private String anG;
    private boolean aue;
    private n bKA;
    private Animation bKo;
    public HeadImageView cyq;
    private h dGA;
    private z dGB;
    private z dGC;
    private boolean dGD;
    private boolean dGE;
    private Animation dGG;
    private boolean dGI;
    public FrameLayout dGl;
    public FrameLayout dGm;
    public com.baidu.tieba.play.c dGz;
    public SpannableClickTextView dXI;
    private View dXJ;
    protected com.baidu.tbadk.core.view.c dXK;
    private FrameLayout dXL;
    private TextView dXM;
    private boolean dXN;
    private boolean dXO;
    private View dXP;
    private View dXQ;
    private b dXR;
    public com.baidu.tieba.frs.videomiddlepage.controller.a dXS;
    private C0219a dXT;
    private VideoNetworkStateTipView dXU;
    private Animation.AnimationListener dXV;
    private Animation.AnimationListener dXW;
    private Runnable dXX;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dGD = true;
        this.dGI = true;
        this.dXN = false;
        this.dXO = false;
        this.dXV = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dXP != null) {
                    a.this.dXP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dXP != null) {
                    a.this.dXP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dXW = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dXP != null) {
                    a.this.dXP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dXP != null) {
                    a.this.dXP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dXX = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dXL.getVisibility() == 0) {
                    a.this.dXL.setVisibility(8);
                }
            }
        };
        this.dGI = z;
        this.mFrom = str;
        this.anG = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dGl = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dXJ = view.findViewById(e.g.card_container);
        this.dGm = (FrameLayout) view.findViewById(e.g.video_container);
        this.dGz = new com.baidu.tieba.play.c(tbPageContext, (View) this.dGm, false);
        this.dGz.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dXS != null && a.this.aBK.dHa.videoDuration > 8) {
                    a.this.dXS.N(a.this.mPosition, a.this.aBK.dHa.videoUrl);
                }
            }
        });
        this.dGz.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // com.baidu.tieba.play.c.a
            public void hr(boolean z2) {
                if (a.this.dXT != null) {
                    if (z2) {
                        a.this.dXT.nl(0);
                    } else {
                        a.this.dXT.nl(1);
                    }
                }
            }
        });
        this.dXI = (SpannableClickTextView) view.findViewById(e.g.title);
        this.cyq = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aGP = (TextView) view.findViewById(e.g.user_name);
        this.aBI = (VideoAggregationPraiseView) view.findViewById(e.g.agree_view);
        this.aBJ = (VideoAggregationDisPraiseView) view.findViewById(e.g.disagree_view);
        this.dXK = new com.baidu.tbadk.core.view.c(this.aBI, this.aBJ);
        this.dXK.DB();
        this.dXK.h(tbPageContext.getUniqueId());
        this.aFz = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.aFA = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.aFB = view.findViewById(e.g.thread_info_commont_container);
        this.aFD = (ImageView) view.findViewById(e.g.share_num_img);
        this.aFE = view.findViewById(e.g.share_num_container);
        this.dXL = (FrameLayout) view.findViewById(e.g.download_nani_guide_container);
        this.dXM = (TextView) view.findViewById(e.g.download_nani_guide_txt);
        this.dXL.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dXM.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dXM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Db().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dXU = (VideoNetworkStateTipView) view.findViewById(e.g.network_state_tip);
        this.dXU.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.dXU.setHasAgreeToPlay(true);
                a.this.dGz.ms(false);
                a.this.dXU.aGe();
                if (a.this.aBK != null && a.this.aBK.dHa != null) {
                    a.this.dGz.aW(a.this.aBK.dHa.videoUrl, a.this.aBK.threadId);
                }
            }
        });
        this.dXP = view.findViewById(e.g.video_agg_container_foreground);
        this.dXQ = view.findViewById(e.g.title_and_comment_container_foreground);
        this.dXP.setOnClickListener(this);
        this.aBI.setOnClickListener(this);
        this.aBJ.setOnClickListener(this);
        this.aFB.setOnClickListener(this);
        this.aFE.setOnClickListener(this);
        this.dXI.setOnClickListener(this);
        this.cyq.setOnClickListener(this);
        this.aGP.setOnClickListener(this);
        this.dXJ.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dGl.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dGl.setLayoutParams(layoutParams);
        this.cyq.setIsRound(true);
        this.bKA = new n(tbPageContext.getPageActivity());
        this.dGA = new h(this.mPageContext, this);
        this.dGG = new AlphaAnimation(0.0f, 0.7f);
        this.dGG.setDuration(500L);
        this.dGG.setAnimationListener(this.dXW);
        this.bKo = new AlphaAnimation(0.7f, 0.0f);
        this.bKo.setDuration(500L);
        this.bKo.setAnimationListener(this.dXV);
        this.dXT = new C0219a();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dXK != null) {
            this.dXK.onChangeSkinType(i);
        }
        this.aFz.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.aFA.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_comment_background));
        this.aFD.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_share_background));
        this.dXI.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
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
        if (gVar != null && gVar.dHa != null) {
            this.aBK = gVar;
            this.aue = this.aBK.autoPlay;
            this.dXO = false;
            hp(false);
            this.dXI.setVisibility(0);
            if (gVar.dHa != null && !StringUtils.isNull(gVar.dHa.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.a.a.a(this.mContext, this.dXI, gVar.title, gVar.dHa.mcnLeadPage, gVar.getThreadId());
            } else {
                this.dXI.setText(gVar.title);
            }
            aFQ();
            b(gVar, i, aVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aFP() {
        try {
            int parseInt = Integer.parseInt(this.aBK.dHa.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.aBK.dHa.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aFQ() {
        if (!aFP()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dGl.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dGl.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dGl.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dGl.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dHa != null) {
            this.dGz.stopPlay();
            this.dGz.setIsNeedRecoveryVideoPlayer(true);
            this.dGz.mt(true);
            this.dGz.mp(true);
            this.dGz.mu(true);
            this.dGz.S(false, false);
            this.dGz.sS(i);
            this.dGz.a(new c.InterfaceC0286c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XN() {
                    a.this.aFR();
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XO() {
                    a.this.aFS();
                    if (a.this.dGz.bpd()) {
                    }
                    if (a.this.dGE) {
                        a.this.dGz.stopPlay();
                    }
                }
            });
            this.dGz.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.l
                public void aBk() {
                    if (a.this.aBK != null && a.this.aBK.dHa != null && com.baidu.adp.lib.g.b.l(a.this.aBK.dHa.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.aBK.dHa.videoWidth, 0)) {
                        a.this.dGz.S(false, false);
                    } else {
                        a.this.dGz.S(true, false);
                    }
                    a.this.dGE = false;
                    a.this.nF(a.this.aue ? "1" : "2");
                    a.this.onClick(a.this.dGm);
                    if (a.this.Sk != null) {
                        a.this.Sk.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void aBl() {
                    a.this.onClick(a.this.dGl);
                }
            });
            this.dGz.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.c.f
                public void gS(boolean z) {
                    a.this.dGz.aW(a.this.aBK.dHa.videoUrl, a.this.aBK.threadId);
                    a.this.nF("2");
                    a.this.onClick(a.this.dGm);
                }
            });
            this.dGz.mm(false);
            this.dGB = new z();
            this.dGB.beV = gVar.threadId;
            this.dGB.cRh = gVar.forumId;
            this.dGB.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dGB.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dGB.mSource = gVar.source;
            this.dGB.gxX = gVar.weight;
            this.dGB.gxZ = this.mFrom;
            this.dGB.gya = gVar.abtest_tag;
            this.dGB.anG = this.anG;
            this.dGB.mExtra = gVar.extra;
            this.dGB.gyd = "0";
            this.dGC = new z();
            this.dGC.beV = gVar.threadId;
            this.dGC.cRh = gVar.forumId;
            this.dGC.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dGC.gxX = "auto_midpage";
            this.dGC.mLocate = "auto_midpage";
            this.dGC.gxZ = this.mFrom;
            this.dGC.mSource = gVar.source;
            this.dGC.gyd = "0";
            if (gVar.dHa != null) {
                this.dGB.gyb = gVar.dHa.videoMd5;
                this.dGC.gyb = gVar.dHa.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.ax("tid", gVar.threadId);
            amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", i);
            amVar.x("obj_param2", 1);
            amVar.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.ax("obj_param1", ao.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.ax("extra", ao.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.anG);
            amVar.ax("ab_tag", ao.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.ax("obj_type", this.mFrom);
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.aBK.source) ? "0" : this.aBK.source);
            amVar.x("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.bKA.setVideoStatsData(this.dGB);
            this.dGz.getVideoView().setBusiness(this.bKA);
            this.bKA.a(gVar);
            this.dGz.aWX();
            this.dGz.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dGE = true;
                        a.this.dGD = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.md(i);
                        a.this.dGz.aKf();
                    }
                }
            });
            this.dGz.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.aBK != null && a.this.aBK.dHa != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.aBK.dHa.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dGz.setThumbnail(gVar.dHa.thumbnailUrl);
            this.dGz.setVideoUrl(gVar.dHa.videoUrl, gVar.threadId);
            this.dGz.setFid(gVar.forumId);
            this.dGz.aKf();
            this.dGz.show();
            hp(false);
            if (gVar.autoPlay) {
                onClick(this.dGm);
                if (this.dXU.aGc()) {
                    this.dGz.mr(false);
                    this.dXU.aGd();
                    this.dGz.ms(true);
                    this.dGz.cm(gVar.dHa.videoUrl, gVar.threadId);
                } else {
                    this.dGz.ms(false);
                    this.dGz.mr(false);
                    this.dXU.hide();
                    this.dGz.a(gVar.dHa.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                }
                if (i == 0 && gVar.dHb) {
                    this.dXP.setVisibility(8);
                    this.dXT.nl(3);
                } else {
                    if (this.dXP.getVisibility() == 0) {
                        this.dXP.startAnimation(this.bKo);
                    }
                    this.dXT.nl(0);
                }
                gVar.dHb = false;
            } else {
                this.dXP.setVisibility(0);
                this.dXU.hide();
                this.dGz.mr(true);
                this.dXT.nl(3);
                this.dGz.cm(gVar.dHa.videoUrl, gVar.threadId);
            }
            this.dGE = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nF(String str) {
        if (this.aBK != null && this.aBK.dHa != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aBK.dHa.videoMd5, "", str, this.dGC);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dGz.bpd();
    }

    public void aBg() {
        if (isPlaying()) {
            this.dGz.pausePlay();
        }
    }

    public boolean me(int i) {
        return this.dGz.sR(i);
    }

    public void aBh() {
        this.dXO = false;
        this.dGz.stopPlay();
        if (this.dXI != null) {
            this.dXI.setVisibility(0);
        }
        if (this.dXT != null) {
            this.dXT.nl(2);
        }
        hp(false);
        this.dXN = true;
    }

    public void aBi() {
        if (this.dGz != null) {
            this.dGz.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aBi();
        if (this.dGA != null) {
            this.dGA.aBt();
        }
        if (this.dXP != null) {
            this.dXP.clearAnimation();
        }
        if (this.dXK != null) {
            this.dXK.onDestroy();
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dGZ != null) {
            this.aGP.setText(TextUtils.isEmpty(gVar.dGZ.userNickname) ? gVar.dGZ.userName : gVar.dGZ.userNickname);
            if (!StringUtils.isNull(gVar.dGZ.portrait) && gVar.dGZ.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.cyq.startLoad(gVar.dGZ.portrait, 10, false);
            } else {
                this.cyq.startLoad(gVar.dGZ.portrait, 12, false);
            }
            if (gVar.dGZ.isBigV) {
                this.cyq.setShowV(gVar.dGZ.isBigV);
                this.cyq.setIsBigV(gVar.dGZ.isBigV);
            } else if (gVar.dGZ.isGod) {
                this.cyq.setShowV(gVar.dGZ.isGod);
                this.cyq.setIsBigV(gVar.dGZ.isGod);
            } else {
                this.cyq.setShowV(gVar.dGZ.isGod);
                this.cyq.setIsBigV(gVar.dGZ.isGod);
            }
            e(gVar);
            f(gVar);
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && this.dXK != null) {
            this.dXK.a(gVar);
        }
    }

    public void f(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aFz.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha70));
            this.aFA.setImageDrawable(getContext().getResources().getDrawable(e.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aFz.setText(ao.P(gVar.postNum));
            } else {
                this.aFz.setText(this.mContext.getString(e.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dGz != null && this.dGm != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dGD) {
                this.dGz.bpc();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aFR();
            } else {
                configuration.orientation = 1;
                aFS();
                this.dGD = true;
            }
            this.dGz.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFR() {
        if (this.dGz != null && this.dGm != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dGm.getParent() != null) {
                if (this.dGm.getParent() == frameLayout) {
                    frameLayout.removeView(this.dGm);
                } else if (this.dGm.getParent() == this.dGl) {
                    this.dGl.removeView(this.dGm);
                }
            }
            if (this.dGm.getParent() == null) {
                frameLayout.addView(this.dGm);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dGm.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dGm.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFS() {
        if (this.dGz != null && this.dGm != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dGm.getParent() != null) {
                if (this.dGm.getParent() == frameLayout) {
                    frameLayout.removeView(this.dGm);
                } else if (this.dGm.getParent() == this.dGl) {
                    this.dGl.removeView(this.dGm);
                }
            }
            if (this.dGm.getParent() == null) {
                this.dGl.addView(this.dGm, 0);
                aFT();
                this.dGz.aWX();
            }
        }
    }

    private void aFT() {
        int i;
        if (!aFP()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dGm.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (anq() != null) {
            view.setTag(this);
            anq().a(view, this.aBK);
        }
        if (view == this.cyq || view == this.aGP) {
            if (this.aBK != null && this.aBK.dGZ != null && !TextUtils.isEmpty(this.aBK.dGZ.userId)) {
                this.dXT.nl(0);
                if (!TbadkCoreApplication.isLogin() || !this.aBK.dGZ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aBK.dGZ.userId, 0L), z, this.aBK.dGZ.isGod)));
            }
        } else if (view == this.aFB) {
            if (this.aBK != null) {
                this.dXT.nl(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aBK.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dXI || view == this.dXJ) {
            if (this.aBK != null) {
                if (this.dXT.getCurrentState() != 2 && this.dXT.getCurrentState() != 3) {
                    z = false;
                }
                this.dXT.nl(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.aBK.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.aFE) {
            this.dXT.nl(0);
            El();
        } else if (view == this.dXP && this.dXP.getVisibility() == 0) {
            if (this.dXR != null) {
                this.dXR.np(this.mPosition);
            }
        } else if (view == this.aBI) {
            this.dXT.nl(0);
            this.aBI.L(view);
        } else if (view == this.aBJ) {
            this.dXT.nl(0);
            this.aBJ.L(view);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gR(boolean z) {
        if (this.aBK != null && this.aBK.dGZ != null) {
            this.aBK.dGZ.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aBj() {
        if (this.aBK != null && this.aBI != null) {
            this.aBI.L(this.aBI);
        }
    }

    public void ho(boolean z) {
        if (this.dGl != null) {
            this.dGl.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dXR = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Sk = fVar;
    }

    private void hp(boolean z) {
        this.dXN = this.mPosition == (this.dXS == null ? -1 : this.dXS.aGa());
        if (this.dXN && z && isPlaying() && this.aue && !this.dXO) {
            this.dXL.setVisibility(0);
            this.dXO = true;
            this.dXL.postDelayed(this.dXX, 5000L);
            if (this.dXS != null) {
                this.dXS.bQ(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dXL.setVisibility(8);
        if (this.dXX != null) {
            this.dXL.removeCallbacks(this.dXX);
        }
    }

    private void El() {
        if (this.aBK != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aBK.forumId);
            String str = this.aBK.title;
            String str2 = this.aBK.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.aBK.dHa.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.aBK.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(e.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aOK = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aON = 3;
            dVar.fid = valueOf;
            dVar.aOG = "";
            dVar.tid = str2;
            dVar.aOC = true;
            dVar.aOM = 0;
            dVar.aOO = 2;
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
            bundle.putInt("obj_param1", dVar.aON);
            bundle.putInt("obj_type", dVar.aOO);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ask);
            dVar.i(bundle);
            com.baidu.tieba.c.e.apC().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aBh();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        aBg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(boolean z) {
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
    public class C0219a {
        private Runnable dYa;
        private int mCurrentState;

        private C0219a() {
            this.mCurrentState = -1;
            this.dYa = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(C0219a.this.dYa);
                    C0219a.this.nl(2);
                }
            };
        }

        public void nl(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = nm(i);
                    aFU();
                    return;
                case 1:
                    this.mCurrentState = nm(i);
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dYa);
                    return;
                case 2:
                    this.mCurrentState = nn(i);
                    return;
                case 3:
                    this.mCurrentState = no(i);
                    aFU();
                    return;
                default:
                    this.mCurrentState = nn(i);
                    return;
            }
        }

        private void aFU() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dYa);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dYa, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int nm(int i) {
            if (i != this.mCurrentState) {
                a.this.dXQ.setVisibility(8);
                a.this.hq(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int nn(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.dXQ.setVisibility(0);
                if (i2 != 3 || a.this.aBK.autoPlay) {
                    a.this.hq(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int no(int i) {
            if (i != this.mCurrentState) {
                a.this.dXQ.setVisibility(0);
                a.this.hq(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
