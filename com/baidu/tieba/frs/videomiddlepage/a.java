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
    private com.baidu.tieba.lego.card.view.f Si;
    protected VideoAggregationPraiseView aAT;
    protected VideoAggregationDisPraiseView aAU;
    public com.baidu.tieba.frs.aggregation.g aAV;
    private TextView aEJ;
    private ImageView aEK;
    private View aEL;
    private ImageView aEN;
    private View aEO;
    public TextView aFZ;
    private String amT;
    private boolean atr;
    private Animation bJD;
    private n bJP;
    public HeadImageView cxi;
    public FrameLayout dEW;
    public FrameLayout dEX;
    public TextView dEY;
    public com.baidu.tieba.play.c dFk;
    private h dFl;
    private z dFm;
    private z dFn;
    private boolean dFo;
    private boolean dFp;
    private Animation dFr;
    private boolean dFt;
    private boolean dWA;
    private boolean dWB;
    private View dWC;
    private View dWD;
    private b dWE;
    public com.baidu.tieba.frs.videomiddlepage.controller.a dWF;
    private C0194a dWG;
    private VideoNetworkStateTipView dWH;
    private Animation.AnimationListener dWI;
    private Animation.AnimationListener dWJ;
    private Runnable dWK;
    private View dWw;
    protected com.baidu.tbadk.core.view.c dWx;
    private FrameLayout dWy;
    private TextView dWz;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dFo = true;
        this.dFt = true;
        this.dWA = false;
        this.dWB = false;
        this.dWI = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dWC != null) {
                    a.this.dWC.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dWC != null) {
                    a.this.dWC.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dWC != null) {
                    a.this.dWC.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dWC != null) {
                    a.this.dWC.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWK = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dWy.getVisibility() == 0) {
                    a.this.dWy.setVisibility(8);
                }
            }
        };
        this.dFt = z;
        this.mFrom = str;
        this.amT = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dEW = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dWw = view.findViewById(e.g.card_container);
        this.dEX = (FrameLayout) view.findViewById(e.g.video_container);
        this.dFk = new com.baidu.tieba.play.c(tbPageContext, (View) this.dEX, false);
        this.dFk.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dWF != null && a.this.aAV.dFL.videoDuration > 8) {
                    a.this.dWF.R(a.this.mPosition, a.this.aAV.dFL.videoUrl);
                }
            }
        });
        this.dFk.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // com.baidu.tieba.play.c.a
            public void hh(boolean z2) {
                if (a.this.dWG != null) {
                    if (z2) {
                        a.this.dWG.mT(0);
                    } else {
                        a.this.dWG.mT(1);
                    }
                }
            }
        });
        this.dEY = (TextView) view.findViewById(e.g.title);
        this.cxi = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aFZ = (TextView) view.findViewById(e.g.user_name);
        this.aAT = (VideoAggregationPraiseView) view.findViewById(e.g.agree_view);
        this.aAU = (VideoAggregationDisPraiseView) view.findViewById(e.g.disagree_view);
        this.dWx = new com.baidu.tbadk.core.view.c(this.aAT, this.aAU);
        this.dWx.Du();
        this.dWx.h(tbPageContext.getUniqueId());
        this.aEJ = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.aEK = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.aEL = view.findViewById(e.g.thread_info_commont_container);
        this.aEN = (ImageView) view.findViewById(e.g.share_num_img);
        this.aEO = view.findViewById(e.g.share_num_container);
        this.dWy = (FrameLayout) view.findViewById(e.g.download_nani_guide_container);
        this.dWz = (TextView) view.findViewById(e.g.download_nani_guide_txt);
        this.dWy.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dWz.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.CU().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dWH = (VideoNetworkStateTipView) view.findViewById(e.g.network_state_tip);
        this.dWH.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.dWH.setHasAgreeToPlay(true);
                a.this.dFk.mh(false);
                a.this.dWH.aGG();
                if (a.this.aAV != null && a.this.aAV.dFL != null) {
                    a.this.dFk.aW(a.this.aAV.dFL.videoUrl, a.this.aAV.threadId);
                }
            }
        });
        this.dWC = view.findViewById(e.g.video_agg_container_foreground);
        this.dWD = view.findViewById(e.g.title_and_comment_container_foreground);
        this.dWC.setOnClickListener(this);
        this.aAT.setOnClickListener(this);
        this.aAU.setOnClickListener(this);
        this.aEL.setOnClickListener(this);
        this.aEO.setOnClickListener(this);
        this.dEY.setOnClickListener(this);
        this.cxi.setOnClickListener(this);
        this.aFZ.setOnClickListener(this);
        this.dWw.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dEW.setLayoutParams(layoutParams);
        this.cxi.setIsRound(true);
        this.bJP = new n(tbPageContext.getPageActivity());
        this.dFl = new h(this.mPageContext, this);
        this.dFr = new AlphaAnimation(0.0f, 0.7f);
        this.dFr.setDuration(500L);
        this.dFr.setAnimationListener(this.dWJ);
        this.bJD = new AlphaAnimation(0.7f, 0.0f);
        this.bJD.setDuration(500L);
        this.bJD.setAnimationListener(this.dWI);
        this.dWG = new C0194a();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dWx != null) {
            this.dWx.onChangeSkinType(i);
        }
        this.aEJ.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.aEK.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_comment_background));
        this.aEN.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_share_background));
        this.dEY.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
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
        if (gVar != null && gVar.dFL != null) {
            this.aAV = gVar;
            this.atr = this.aAV.autoPlay;
            this.dWB = false;
            hf(false);
            this.dEY.setVisibility(0);
            this.dEY.setText(gVar.title);
            aGs();
            b(gVar, i, aVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aGr() {
        try {
            int parseInt = Integer.parseInt(this.aAV.dFL.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.aAV.dFL.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aGs() {
        if (!aGr()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEW.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dEW.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dEW.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dEW.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dFL != null) {
            this.dFk.stopPlay();
            this.dFk.setIsNeedRecoveryVideoPlayer(true);
            this.dFk.mi(true);
            this.dFk.me(true);
            this.dFk.mj(true);
            this.dFk.Q(false, false);
            this.dFk.sz(i);
            this.dFk.a(new c.InterfaceC0258c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XD() {
                    a.this.aGt();
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XE() {
                    a.this.aGu();
                    if (a.this.dFk.bpH()) {
                    }
                    if (a.this.dFp) {
                        a.this.dFk.stopPlay();
                    }
                }
            });
            this.dFk.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.l
                public void aBN() {
                    if (a.this.aAV != null && a.this.aAV.dFL != null && com.baidu.adp.lib.g.b.l(a.this.aAV.dFL.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.aAV.dFL.videoWidth, 0)) {
                        a.this.dFk.Q(false, false);
                    } else {
                        a.this.dFk.Q(true, false);
                    }
                    a.this.dFp = false;
                    a.this.nE(a.this.atr ? "1" : "2");
                    a.this.onClick(a.this.dEX);
                    if (a.this.Si != null) {
                        a.this.Si.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void aBO() {
                    a.this.onClick(a.this.dEW);
                }
            });
            this.dFk.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.c.f
                public void gI(boolean z) {
                    a.this.dFk.aW(a.this.aAV.dFL.videoUrl, a.this.aAV.threadId);
                    a.this.nE("2");
                    a.this.onClick(a.this.dEX);
                }
            });
            this.dFk.mb(false);
            this.dFm = new z();
            this.dFm.beh = gVar.threadId;
            this.dFm.cQb = gVar.forumId;
            this.dFm.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dFm.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dFm.mSource = gVar.source;
            this.dFm.gww = gVar.weight;
            this.dFm.gwy = this.mFrom;
            this.dFm.gwz = gVar.abtest_tag;
            this.dFm.amT = this.amT;
            this.dFm.mExtra = gVar.extra;
            this.dFm.gwC = "0";
            this.dFn = new z();
            this.dFn.beh = gVar.threadId;
            this.dFn.cQb = gVar.forumId;
            this.dFn.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dFn.gww = "auto_midpage";
            this.dFn.mLocate = "auto_midpage";
            this.dFn.gwy = this.mFrom;
            this.dFn.mSource = gVar.source;
            this.dFn.gwC = "0";
            if (gVar.dFL != null) {
                this.dFm.gwA = gVar.dFL.videoMd5;
                this.dFn.gwA = gVar.dFL.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.ax("tid", gVar.threadId);
            amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", i);
            amVar.x("obj_param2", 1);
            amVar.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.ax("obj_param1", ao.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.ax("extra", ao.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.amT);
            amVar.ax("ab_tag", ao.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.ax("obj_type", this.mFrom);
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.aAV.source) ? "0" : this.aAV.source);
            amVar.x("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.bJP.setVideoStatsData(this.dFm);
            this.dFk.getVideoView().setBusiness(this.bJP);
            this.bJP.a(gVar);
            this.dFk.aXA();
            this.dFk.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dFp = true;
                        a.this.dFo = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.lL(i);
                        a.this.dFk.aKH();
                    }
                }
            });
            this.dFk.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.aAV != null && a.this.aAV.dFL != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.aAV.dFL.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dFk.setThumbnail(gVar.dFL.thumbnailUrl);
            this.dFk.setVideoUrl(gVar.dFL.videoUrl, gVar.threadId);
            this.dFk.setFid(gVar.forumId);
            this.dFk.aKH();
            this.dFk.show();
            hf(false);
            if (gVar.autoPlay) {
                onClick(this.dEX);
                if (this.dWH.aGE()) {
                    this.dFk.mg(false);
                    this.dWH.aGF();
                    this.dFk.mh(true);
                    this.dFk.cm(gVar.dFL.videoUrl, gVar.threadId);
                } else {
                    this.dFk.mh(false);
                    this.dFk.mg(false);
                    this.dWH.hide();
                    this.dFk.a(gVar.dFL.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                }
                if (i == 0 && gVar.dFM) {
                    this.dWC.setVisibility(8);
                    this.dWG.mT(3);
                } else {
                    if (this.dWC.getVisibility() == 0) {
                        this.dWC.startAnimation(this.bJD);
                    }
                    this.dWG.mT(0);
                }
                gVar.dFM = false;
            } else {
                this.dWC.setVisibility(0);
                this.dWH.hide();
                this.dFk.mg(true);
                this.dWG.mT(3);
                this.dFk.cm(gVar.dFL.videoUrl, gVar.threadId);
            }
            this.dFp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(String str) {
        if (this.aAV != null && this.aAV.dFL != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aAV.dFL.videoMd5, "", str, this.dFn);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dFk.bpH();
    }

    public void aBJ() {
        if (isPlaying()) {
            this.dFk.pausePlay();
        }
    }

    public boolean lM(int i) {
        return this.dFk.sy(i);
    }

    public void aBK() {
        this.dWB = false;
        this.dFk.stopPlay();
        if (this.dEY != null) {
            this.dEY.setVisibility(0);
        }
        if (this.dWG != null) {
            this.dWG.mT(2);
        }
        hf(false);
        this.dWA = true;
    }

    public void aBL() {
        if (this.dFk != null) {
            this.dFk.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aBL();
        if (this.dFl != null) {
            this.dFl.aBW();
        }
        if (this.dWC != null) {
            this.dWC.clearAnimation();
        }
        if (this.dWx != null) {
            this.dWx.onDestroy();
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dFK != null) {
            this.aFZ.setText(TextUtils.isEmpty(gVar.dFK.userNickname) ? gVar.dFK.userName : gVar.dFK.userNickname);
            if (!StringUtils.isNull(gVar.dFK.portrait) && gVar.dFK.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.cxi.startLoad(gVar.dFK.portrait, 10, false);
            } else {
                this.cxi.startLoad(gVar.dFK.portrait, 12, false);
            }
            if (gVar.dFK.isBigV) {
                this.cxi.setShowV(gVar.dFK.isBigV);
                this.cxi.setIsBigV(gVar.dFK.isBigV);
            } else if (gVar.dFK.isGod) {
                this.cxi.setShowV(gVar.dFK.isGod);
                this.cxi.setIsBigV(gVar.dFK.isGod);
            } else {
                this.cxi.setShowV(gVar.dFK.isGod);
                this.cxi.setIsBigV(gVar.dFK.isGod);
            }
            e(gVar);
            f(gVar);
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && this.dWx != null) {
            this.dWx.a(gVar);
        }
    }

    public void f(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aEJ.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha70));
            this.aEK.setImageDrawable(getContext().getResources().getDrawable(e.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aEJ.setText(ao.N(gVar.postNum));
            } else {
                this.aEJ.setText(this.mContext.getString(e.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dFk != null && this.dEX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dFo) {
                this.dFk.bpG();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aGt();
            } else {
                configuration.orientation = 1;
                aGu();
                this.dFo = true;
            }
            this.dFk.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGt() {
        if (this.dFk != null && this.dEX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dEX.getParent() != null) {
                if (this.dEX.getParent() == frameLayout) {
                    frameLayout.removeView(this.dEX);
                } else if (this.dEX.getParent() == this.dEW) {
                    this.dEW.removeView(this.dEX);
                }
            }
            if (this.dEX.getParent() == null) {
                frameLayout.addView(this.dEX);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dEX.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dEX.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGu() {
        if (this.dFk != null && this.dEX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dEX.getParent() != null) {
                if (this.dEX.getParent() == frameLayout) {
                    frameLayout.removeView(this.dEX);
                } else if (this.dEX.getParent() == this.dEW) {
                    this.dEW.removeView(this.dEX);
                }
            }
            if (this.dEX.getParent() == null) {
                this.dEW.addView(this.dEX, 0);
                aGv();
                this.dFk.aXA();
            }
        }
    }

    private void aGv() {
        int i;
        if (!aGr()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dEX.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (anP() != null) {
            view.setTag(this);
            anP().a(view, this.aAV);
        }
        if (view == this.cxi || view == this.aFZ) {
            if (this.aAV != null && this.aAV.dFK != null && !TextUtils.isEmpty(this.aAV.dFK.userId)) {
                this.dWG.mT(0);
                if (!TbadkCoreApplication.isLogin() || !this.aAV.dFK.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aAV.dFK.userId, 0L), z, this.aAV.dFK.isGod)));
            }
        } else if (view == this.aEL) {
            if (this.aAV != null) {
                this.dWG.mT(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aAV.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dEY || view == this.dWw) {
            if (this.aAV != null) {
                if (this.dWG.getCurrentState() != 2 && this.dWG.getCurrentState() != 3) {
                    z = false;
                }
                this.dWG.mT(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.aAV.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.aEO) {
            this.dWG.mT(0);
            Eb();
        } else if (view == this.dWC && this.dWC.getVisibility() == 0) {
            if (this.dWE != null) {
                this.dWE.mX(this.mPosition);
            }
        } else if (view == this.aAT) {
            this.dWG.mT(0);
            this.aAT.L(view);
        } else if (view == this.aAU) {
            this.dWG.mT(0);
            this.aAU.L(view);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gH(boolean z) {
        if (this.aAV != null && this.aAV.dFK != null) {
            this.aAV.dFK.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aBM() {
        if (this.aAV != null && this.aAT != null) {
            this.aAT.L(this.aAT);
        }
    }

    public void he(boolean z) {
        if (this.dEW != null) {
            this.dEW.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dWE = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Si = fVar;
    }

    private void hf(boolean z) {
        this.dWA = this.mPosition == (this.dWF == null ? -1 : this.dWF.aGC());
        if (this.dWA && z && isPlaying() && this.atr && !this.dWB) {
            this.dWy.setVisibility(0);
            this.dWB = true;
            this.dWy.postDelayed(this.dWK, 5000L);
            if (this.dWF != null) {
                this.dWF.bV(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dWy.setVisibility(8);
        if (this.dWK != null) {
            this.dWy.removeCallbacks(this.dWK);
        }
    }

    private void Eb() {
        if (this.aAV != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aAV.forumId);
            String str = this.aAV.title;
            String str2 = this.aAV.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.aAV.dFL.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.aAV.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(e.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aNU = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aNX = 3;
            dVar.fid = valueOf;
            dVar.aNQ = "";
            dVar.tid = str2;
            dVar.aNM = true;
            dVar.aNW = 0;
            dVar.aNY = 2;
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
            bundle.putInt("obj_param1", dVar.aNX);
            bundle.putInt("obj_type", dVar.aNY);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.arx);
            dVar.f(bundle);
            com.baidu.tieba.c.e.aqb().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aBK();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        aBJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg(boolean z) {
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
    public class C0194a {
        private Runnable dWN;
        private int mCurrentState;

        private C0194a() {
            this.mCurrentState = -1;
            this.dWN = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jI().removeCallbacks(C0194a.this.dWN);
                    C0194a.this.mT(2);
                }
            };
        }

        public void mT(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = mU(i);
                    aGw();
                    return;
                case 1:
                    this.mCurrentState = mU(i);
                    com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dWN);
                    return;
                case 2:
                    this.mCurrentState = mV(i);
                    return;
                case 3:
                    this.mCurrentState = mW(i);
                    aGw();
                    return;
                default:
                    this.mCurrentState = mV(i);
                    return;
            }
        }

        private void aGw() {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dWN);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.dWN, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int mU(int i) {
            if (i != this.mCurrentState) {
                a.this.dWD.setVisibility(8);
                a.this.hg(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int mV(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.dWD.setVisibility(0);
                if (i2 != 3 || a.this.aAV.autoPlay) {
                    a.this.hg(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int mW(int i) {
            if (i != this.mCurrentState) {
                a.this.dWD.setVisibility(0);
                a.this.hg(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
