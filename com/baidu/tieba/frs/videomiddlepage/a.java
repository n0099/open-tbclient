package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.h;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i {
    private com.baidu.tieba.lego.card.view.f Ps;
    private String agd;
    private ScaleAnimation axX;
    private TextView axk;
    private ImageView axl;
    private View axm;
    private TextView axn;
    private ImageView axo;
    private View axp;
    private TextView axq;
    private ImageView axr;
    private View axs;
    public TextView ayf;
    public TextView bVx;
    private n buL;
    private Animation buy;
    public HeadImageView chg;
    private View dEF;
    private View dEG;
    private ImageView dEH;
    private FrameLayout dEI;
    private TextView dEJ;
    private boolean dEK;
    private boolean dEL;
    private View dEM;
    private View dEN;
    private View dEO;
    private View dEP;
    private b dEQ;
    public com.baidu.tieba.frs.videomiddlepage.a.a dER;
    private Animation.AnimationListener dES;
    private Animation.AnimationListener dET;
    private Runnable dEU;
    public FrameLayout dnQ;
    public FrameLayout dnR;
    public TextView dnS;
    public com.baidu.tieba.play.c doe;
    public com.baidu.tieba.frs.aggregation.g dof;
    private h dog;
    private y doh;
    private y doi;
    private boolean doj;
    private boolean dok;
    private Animation dom;
    private boolean don;
    private boolean doo;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.doj = true;
        this.doo = true;
        this.dEK = false;
        this.dEL = false;
        this.dES = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dEM != null) {
                    a.this.dEM.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dEM != null) {
                    a.this.dEM.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dET = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dEM != null) {
                    a.this.dEM.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dEM != null) {
                    a.this.dEM.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dEU = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dEI.getVisibility() == 0) {
                    a.this.dEI.setVisibility(8);
                }
            }
        };
        this.doo = z;
        this.mFrom = str;
        this.agd = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dnQ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dEF = view.findViewById(d.g.card_container);
        this.dnR = (FrameLayout) view.findViewById(d.g.video_container);
        this.doe = new com.baidu.tieba.play.c(tbPageContext, this.dnR, false);
        this.doe.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dER != null && a.this.dof.doF.videoDuration > 8) {
                    a.this.dER.P(a.this.mPosition, a.this.dof.doF.videoUrl);
                }
            }
        });
        this.dnS = (TextView) view.findViewById(d.g.title);
        this.chg = (HeadImageView) view.findViewById(d.g.user_icon);
        this.ayf = (TextView) view.findViewById(d.g.user_name);
        this.bVx = (TextView) view.findViewById(d.g.attention);
        this.axk = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.axl = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.axm = view.findViewById(d.g.agree_view_container);
        this.axn = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.axo = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.axp = view.findViewById(d.g.thread_info_commont_container);
        this.axq = (TextView) view.findViewById(d.g.share_num);
        this.axr = (ImageView) view.findViewById(d.g.share_num_img);
        this.axs = view.findViewById(d.g.share_num_container);
        this.dEI = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.dEJ = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.dEI.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dEJ.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    az.zV().a((TbPageContext) com.baidu.adp.base.i.ad(a.this.ahZ().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dEG = view.findViewById(d.g.attention_container);
        this.dEH = (ImageView) view.findViewById(d.g.attention_img);
        this.dEM = view.findViewById(d.g.video_agg_container_foreground);
        this.dEN = view.findViewById(d.g.user_container_foreground);
        this.dEO = view.findViewById(d.g.title_foreground);
        this.dEP = view.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dEN.setOnClickListener(this);
        this.dEO.setOnClickListener(this);
        this.dEP.setOnClickListener(this);
        this.dEM.setOnClickListener(this);
        this.axm.setOnClickListener(this);
        this.axp.setOnClickListener(this);
        this.axs.setOnClickListener(this);
        this.dnS.setOnClickListener(this);
        this.chg.setOnClickListener(this);
        this.ayf.setOnClickListener(this);
        this.dEG.setOnClickListener(this);
        this.dEF.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dnQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dnQ.setLayoutParams(layoutParams);
        this.chg.setIsRound(true);
        this.buL = new n(tbPageContext.getPageActivity());
        this.dog = new h(this.mPageContext, this);
        this.dom = new AlphaAnimation(0.0f, 0.7f);
        this.dom.setDuration(500L);
        this.dom.setAnimationListener(this.dET);
        this.buy = new AlphaAnimation(0.7f, 0.0f);
        this.buy.setDuration(500L);
        this.buy.setAnimationListener(this.dES);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dof != null && this.dof.doE != null) {
            if (this.dof.doE.hasFocus) {
                this.bVx.setTextColor(tbPageContext.getResources().getColor(d.C0142d.cp_cont_d));
                this.dEG.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.bVx.setTextColor(tbPageContext.getResources().getColor(d.C0142d.cp_link_tip_a));
            }
        }
        if (this.dof != null) {
            if (this.dof.hasAgree) {
                this.axl.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.icon_home_card_like_s));
                this.axk.setTextColor(tbPageContext.getResources().getColor(d.C0142d.cp_cont_i));
            } else {
                this.axl.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_like_selector));
                this.axk.setTextColor(tbPageContext.getResources().getColor(d.C0142d.cp_cont_i));
            }
        }
        this.axn.setTextColor(tbPageContext.getResources().getColor(d.C0142d.cp_cont_i));
        this.axo.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_commnet_selector));
        this.axq.setTextColor(tbPageContext.getResources().getColor(d.C0142d.cp_cont_i));
        this.axr.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_share_selector));
        this.dnS.setTextColor(tbPageContext.getResources().getColor(d.C0142d.cp_cont_i));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.doF != null) {
            this.dof = gVar;
            this.don = this.dof.autoPlay;
            this.dEL = false;
            gp(false);
            this.dnS.setVisibility(0);
            this.dnS.setText(gVar.title);
            aAm();
            b(gVar, i, aVar);
            h(gVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aAl() {
        try {
            int parseInt = Integer.parseInt(this.dof.doF.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dof.doF.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aAm() {
        if (!aAl()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dnQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dnQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dnQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dnQ.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.doF != null) {
            this.doe.stopPlay();
            this.doe.lE(true);
            this.doe.lH(true);
            this.doe.lF(false);
            this.doe.lI(true);
            this.doe.N(false, false);
            this.doe.rI(i);
            this.doe.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void avD() {
                    a.this.aAn();
                }

                @Override // com.baidu.tieba.play.c.b
                public void avE() {
                    a.this.aAo();
                    if (a.this.doe.blC()) {
                    }
                    if (a.this.dok) {
                        a.this.doe.stopPlay();
                    }
                }
            });
            this.doe.a(new c.k() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.k
                public void avF() {
                    if (a.this.dof != null && a.this.dof.doF != null && com.baidu.adp.lib.g.b.g(a.this.dof.doF.videoHeight, 0) > com.baidu.adp.lib.g.b.g(a.this.dof.doF.videoWidth, 0)) {
                        a.this.doe.N(false, false);
                    } else {
                        a.this.doe.N(true, false);
                    }
                    a.this.dok = false;
                    a.this.my(a.this.don ? "1" : "2");
                    a.this.onClick(a.this.dnR);
                    if (a.this.Ps != null) {
                        a.this.Ps.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.k
                public void avG() {
                    a.this.onClick(a.this.dnQ);
                }
            });
            this.doe.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void fR(boolean z) {
                    a.this.doe.bX(a.this.dof.doF.videoUrl, a.this.dof.threadId);
                    a.this.my("2");
                    a.this.onClick(a.this.dnR);
                }
            });
            this.doe.lC(false);
            this.doh = new y();
            this.doh.aWo = gVar.threadId;
            this.doh.czo = gVar.forumId;
            this.doh.mUid = TbadkCoreApplication.getCurrentAccount();
            this.doh.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.doh.mSource = gVar.source;
            this.doh.ghc = gVar.weight;
            this.doh.ghe = this.mFrom;
            this.doh.ghf = gVar.abtest_tag;
            this.doh.agd = this.agd;
            this.doh.mExtra = gVar.extra;
            this.doh.ghi = "0";
            this.doi = new y();
            this.doi.aWo = gVar.threadId;
            this.doi.czo = gVar.forumId;
            this.doi.mUid = TbadkCoreApplication.getCurrentAccount();
            this.doi.ghc = "auto_midpage";
            this.doi.mLocate = "auto_midpage";
            this.doi.ghe = this.mFrom;
            this.doi.mSource = gVar.source;
            this.doi.ghi = "0";
            if (gVar.doF != null) {
                this.doh.ghg = gVar.doF.videoMd5;
                this.doi.ghg = gVar.doF.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.ah("tid", gVar.threadId);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.r("obj_locate", i);
            anVar.r("obj_param2", 1);
            anVar.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
            anVar.ah("obj_param1", gVar.weight);
            anVar.ah("extra", gVar.extra);
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, this.agd);
            anVar.ah("ab_tag", gVar.abtest_tag);
            anVar.ah("obj_type", this.mFrom);
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dof.source);
            anVar.r("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.buL.setVideoStatsData(this.doh);
            this.doe.getVideoView().setBusiness(this.buL);
            this.doe.aRa();
            this.doe.b(new c.InterfaceC0219c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void fS(boolean z) {
                    if (!a.this.doe.blC()) {
                        a.this.lJ(0);
                        a.this.dEP.setVisibility(0);
                        a.this.dEO.setVisibility(0);
                        a.this.dEN.setVisibility(0);
                    } else if (z) {
                        if (a.this.dEP.getVisibility() == 8) {
                            a.this.dEP.setVisibility(0);
                            a.this.gp(true);
                        }
                        if (a.this.dEO.getVisibility() == 8) {
                            a.this.dEO.setVisibility(0);
                        }
                        if (a.this.dEN.getVisibility() == 8) {
                            a.this.dEN.setVisibility(0);
                        }
                        a.this.lJ(1);
                    } else {
                        if (a.this.dEP.getVisibility() == 0) {
                            a.this.dEP.setVisibility(8);
                            a.this.gp(false);
                        }
                        if (a.this.dEO.getVisibility() == 0) {
                            a.this.dEO.setVisibility(8);
                        }
                        if (a.this.dEN.getVisibility() == 0) {
                            a.this.dEN.setVisibility(8);
                        }
                        a.this.lJ(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void avH() {
                    a.this.lJ(1);
                    if (!a.this.doe.blC()) {
                        a.this.dEP.setVisibility(0);
                        a.this.dEO.setVisibility(0);
                        a.this.dEN.setVisibility(0);
                        return;
                    }
                    if (a.this.dEP.getVisibility() == 8) {
                        a.this.dEP.setVisibility(0);
                    }
                    if (a.this.dEO.getVisibility() == 8) {
                        a.this.dEO.setVisibility(0);
                    }
                    if (a.this.dEN.getVisibility() == 8) {
                        a.this.dEN.setVisibility(0);
                    }
                }
            });
            this.doe.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dok = true;
                        a.this.doj = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.kA(i);
                        a.this.doe.aEd();
                    }
                }
            });
            this.doe.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.dof != null && a.this.dof.doF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dof.doF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.doe.pr(gVar.doF.thumbnailUrl);
            this.doe.bW(gVar.doF.videoUrl, gVar.threadId);
            this.doe.a(new c.h() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.h
                public void avI() {
                }
            });
            this.doe.aEd();
            this.doe.show();
            if (gVar.autoPlay) {
                onClick(this.dnR);
                this.dok = false;
                this.doe.a(gVar.doF.videoUrl, gVar.threadId, (c.d) null, new Object[0]);
                if (i == 0) {
                    this.dEM.setVisibility(8);
                } else {
                    this.dEM.startAnimation(this.buy);
                }
                this.dEO.setVisibility(8);
                this.dEP.setVisibility(8);
                gp(false);
                this.dEN.setVisibility(8);
            } else if (j.jF() && gVar.waitConfirm) {
                this.dEM.startAnimation(this.buy);
                this.dEO.setVisibility(8);
                this.dEP.setVisibility(8);
                gp(false);
                this.dEN.setVisibility(8);
            } else {
                this.dEO.setVisibility(0);
                this.dEP.setVisibility(0);
                this.dEN.setVisibility(0);
                this.dEM.setVisibility(0);
            }
            this.dok = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (i == 1) {
            customMessage.setExtra("low");
        } else if (i == 0) {
            customMessage.setExtra("high");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(String str) {
        if (this.dof != null && this.dof.doF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dof.doF.videoMd5, "", str, this.doi);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.doe.blC();
    }

    public void avz() {
        if (isPlaying()) {
            this.doe.pausePlay();
        }
    }

    public boolean kB(int i) {
        return this.doe.rH(i);
    }

    public void avA() {
        this.dEL = false;
        this.doe.stopPlay();
        if (this.dnS != null) {
            this.dnS.setVisibility(0);
        }
        gp(false);
        this.dEK = true;
    }

    public void avB() {
        if (this.doe != null) {
            this.doe.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        avB();
        if (this.dog != null) {
            this.dog.avN();
        }
        if (this.dEM != null) {
            this.dEM.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.doE != null) {
            this.ayf.setText(TextUtils.isEmpty(gVar.doE.userNickname) ? gVar.doE.userName : gVar.doE.userNickname);
            if (!StringUtils.isNull(gVar.doE.portrait) && gVar.doE.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.chg.startLoad(gVar.doE.portrait, 10, false);
            } else {
                this.chg.startLoad(gVar.doE.portrait, 12, false);
            }
            if (gVar.doE.isBigV) {
                this.chg.setShowV(gVar.doE.isBigV);
                this.chg.setIsBigV(gVar.doE.isBigV);
            } else if (gVar.doE.isGod) {
                this.chg.setShowV(gVar.doE.isGod);
                this.chg.setIsBigV(gVar.doE.isGod);
            } else {
                this.chg.setShowV(gVar.doE.isGod);
                this.chg.setIsBigV(gVar.doE.isGod);
            }
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.doE != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.doE.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.doE.userId)) {
                this.dEG.setVisibility(8);
            } else {
                this.dEG.setVisibility(0);
            }
            if (gVar.doE.hasFocus) {
                this.bVx.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_d));
                this.bVx.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                this.dEG.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dEH.setVisibility(8);
                return;
            }
            this.bVx.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_link_tip_a));
            this.bVx.setText(this.mPageContext.getString(d.k.attention));
            this.dEH.setVisibility(0);
            this.dEG.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.axl.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_like_s));
                this.axk.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_h_1));
            } else {
                this.axl.setImageDrawable(getContext().getResources().getDrawable(d.f.card_like_selector));
                this.axk.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_i));
            }
            if (gVar.agreeNum > 0) {
                this.axk.setText(ap.F(gVar.agreeNum));
            } else {
                this.axk.setText(d.k.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.axn.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_f));
            this.axo.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.axn.setText(ap.F(gVar.postNum));
            } else {
                this.axn.setText(this.mContext.getString(d.k.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (this.axs != null && this.axq != null && gVar != null) {
            long j = gVar.shareNum;
            String string = this.mContext.getString(d.k.share);
            if (j > 0) {
                string = ap.F(j);
            }
            this.axq.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.doe != null && this.dnR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.doj) {
                this.doe.blB();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aAn();
            } else {
                configuration.orientation = 1;
                aAo();
                this.doj = true;
            }
            this.doe.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAn() {
        if (this.doe != null && this.dnR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dnR.getParent() != null) {
                if (this.dnR.getParent() == frameLayout) {
                    frameLayout.removeView(this.dnR);
                } else if (this.dnR.getParent() == this.dnQ) {
                    this.dnQ.removeView(this.dnR);
                }
            }
            if (this.dnR.getParent() == null) {
                frameLayout.addView(this.dnR);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dnR.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dnR.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAo() {
        if (this.doe != null && this.dnR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dnR.getParent() != null) {
                if (this.dnR.getParent() == frameLayout) {
                    frameLayout.removeView(this.dnR);
                } else if (this.dnR.getParent() == this.dnQ) {
                    this.dnQ.removeView(this.dnR);
                }
            }
            if (this.dnR.getParent() == null) {
                this.dnQ.addView(this.dnR, 0);
                aAp();
                this.doe.aRa();
            }
        }
    }

    private void aAp() {
        int i;
        if (!aAl()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dnR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (aia() != null) {
            view.setTag(this);
            aia().a(view, this.dof);
        }
        if (view == this.chg || view == this.ayf) {
            if (this.dof != null && this.dof.doE != null && !TextUtils.isEmpty(this.dof.doE.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dof.doE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dof.doE.userId, 0L), z, this.dof.doE.isGod)));
            }
        } else if (view == this.axp || view == this.dnS || view == this.dEF) {
            if (this.dof != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dof.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dEG) {
            if (!this.dof.doE.hasFocus) {
                this.dog.f(this.dof);
            }
        } else if (view == this.axm) {
            this.dog.g(this.dof);
        } else if (view == this.axs) {
            AV();
        } else if (view == this.dEM && this.dEM.getVisibility() == 0) {
            if (this.dEQ != null) {
                this.dEQ.lK(this.mPosition);
            }
        } else if (view == this.dEO || view == this.dEP || view == this.dEN) {
            if (this.dEM.getVisibility() == 0) {
                if (this.dEQ != null) {
                    this.dEQ.lK(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dEP.getVisibility() == 0) {
                this.dEP.setVisibility(8);
                gp(false);
            }
            if (this.dEO.getVisibility() == 0) {
                this.dEO.setVisibility(8);
            }
            if (this.dEN.getVisibility() == 0) {
                this.dEN.setVisibility(8);
            }
            lJ(0);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fQ(boolean z) {
        if (this.dof != null && this.dof.doE != null) {
            this.dof.doE.hasFocus = z;
            c(this.dof);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void avC() {
        if (this.dof != null) {
            this.dof.hasAgree = !this.dof.hasAgree;
            if (this.dof.hasAgree) {
                this.dof.agreeNum++;
            } else {
                this.dof.agreeNum--;
            }
            if (this.axl != null) {
                this.axl.startAnimation(getScaleAnimation());
            }
            d(this.dof);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axX == null) {
            this.axX = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axX.setDuration(200L);
        }
        return this.axX;
    }

    public void go(boolean z) {
        if (this.dnQ != null) {
            this.dnQ.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dEQ = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Ps = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(boolean z) {
        this.dEK = this.mPosition == (this.dER == null ? -1 : this.dER.aAw());
        if (this.dEK && z && isPlaying() && this.don && !this.dEL) {
            this.dEI.setVisibility(0);
            this.dEL = true;
            this.dEI.postDelayed(this.dEU, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dER != null) {
                this.dER.bF(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dEI.setVisibility(8);
        if (this.dEU != null) {
            this.dEI.removeCallbacks(this.dEU);
        }
    }

    private void AV() {
        if (this.dof != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dof.forumId);
            String str = this.dof.title;
            String str2 = this.dof.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dof.doF.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dof.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.k.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aGf = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aGi = 3;
            dVar.fid = valueOf;
            dVar.aGb = "";
            dVar.tid = str2;
            dVar.aFX = true;
            dVar.aGh = 0;
            dVar.aGj = 2;
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
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aky);
            dVar.f(bundle);
            com.baidu.tieba.c.e.akp().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        avA();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        avz();
    }
}
