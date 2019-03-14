package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.afd.videopaster.d;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.frs.view.SpannableClickTextView;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i {
    private com.baidu.tieba.lego.card.view.f TB;
    public TextView Zy;
    private Animation aeY;
    private Animation aeZ;
    private boolean bGc;
    protected AgreeView bSd;
    private TextView bSe;
    private ImageView bSf;
    private View bSg;
    private ImageView bSi;
    private View bSj;
    private String byA;
    public HeadImageView dRs;
    private n dbe;
    private com.baidu.afd.videopaster.d ehI;
    private boolean feA;
    public FrameLayout fed;
    public FrameLayout fee;
    public com.baidu.tieba.play.c fer;
    public com.baidu.tieba.frs.aggregation.g fes;
    private com.baidu.tieba.frs.aggregation.h fet;
    private z feu;
    private z fev;
    private boolean few;
    private boolean fex;
    public SpannableClickTextView fwQ;
    private View fwR;
    private FrameLayout fwS;
    private TextView fwT;
    private boolean fwU;
    private boolean fwV;
    private boolean fwW;
    private View fwX;
    private View fwY;
    private c fwZ;
    public com.baidu.tieba.frs.videomiddlepage.a.a fxa;
    private C0298a fxb;
    private VideoNetworkStateTipView fxc;
    private b fxd;
    private com.baidu.mcn.c fxe;
    private boolean fxf;
    private boolean fxg;
    private boolean fxh;
    private Animation.AnimationListener fxi;
    private Animation.AnimationListener fxj;
    private Runnable fxk;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.few = true;
        this.feA = true;
        this.fwV = false;
        this.fwW = false;
        this.fxf = false;
        this.fxg = false;
        this.fxh = false;
        this.startPosition = -1L;
        this.fxi = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fwX != null) {
                    a.this.fwX.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fwX != null) {
                    a.this.fwX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fxj = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fwX != null) {
                    a.this.fwX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fwX != null) {
                    a.this.fwX.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fxk = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fwS.getVisibility() == 0) {
                    a.this.fwS.setVisibility(8);
                }
            }
        };
        this.feA = z;
        this.mFrom = str;
        this.byA = str2;
        this.fxd = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fed = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.fwR = view.findViewById(d.g.card_container);
        this.fee = (FrameLayout) view.findViewById(d.g.video_container);
        this.fer = new com.baidu.tieba.play.c(tbPageContext, (View) this.fee, false);
        this.fer.oQ(z);
        this.fer.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fxa != null && a.this.fes.feS.videoDuration > 8) {
                    a.this.fxa.ag(a.this.mPosition, a.this.fes.feS.videoUrl);
                }
            }
        });
        this.fer.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // com.baidu.tieba.play.c.a
            public void jV(boolean z2) {
                if (a.this.fxb != null) {
                    if (z2) {
                        a.this.fxb.rG(0);
                    } else {
                        a.this.fxb.rG(1);
                    }
                }
            }
        });
        this.fer.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fwQ = (SpannableClickTextView) view.findViewById(d.g.title);
        this.dRs = (HeadImageView) view.findViewById(d.g.user_icon);
        this.Zy = (TextView) view.findViewById(d.g.user_name);
        this.bSd = (AgreeView) view.findViewById(d.g.agree_view);
        this.bSd.setAgreeAnimationResource(d.i.agree);
        this.bSd.setDisagreeAnimationResource(d.i.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxk = 2;
        dVar.bxo = 6;
        this.bSd.setStatisticData(dVar);
        this.bSe = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.bSf = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.bSg = view.findViewById(d.g.thread_info_commont_container);
        this.bSi = (ImageView) view.findViewById(d.g.share_num_img);
        this.bSj = view.findViewById(d.g.share_num_container);
        this.fwS = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.fwT = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.fwS.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fwT.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.fwT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.adD().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fxc = (VideoNetworkStateTipView) view.findViewById(d.g.network_state_tip);
        this.fxc.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.fxc.setHasAgreeToPlay(true);
                a.this.fer.oW(false);
                a.this.fxc.cmq();
                if (a.this.ehI.qb()) {
                    a.this.ehI.resume();
                } else if (a.this.fes != null && a.this.fes.feS != null) {
                    a.this.fer.cf(a.this.fes.feS.videoUrl, a.this.fes.threadId);
                }
            }
        });
        this.fwX = view.findViewById(d.g.video_agg_container_foreground);
        this.fwY = view.findViewById(d.g.title_and_comment_container_foreground);
        this.fwX.setOnClickListener(this);
        this.bSg.setOnClickListener(this);
        this.bSj.setOnClickListener(this);
        this.fwQ.setOnClickListener(this);
        this.dRs.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.fwR.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fed.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fed.setLayoutParams(layoutParams);
        this.dRs.setIsRound(true);
        this.dbe = new n(tbPageContext.getPageActivity());
        this.fet = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.aeY = new AlphaAnimation(0.0f, 0.7f);
        this.aeY.setDuration(500L);
        this.aeY.setAnimationListener(this.fxj);
        this.aeZ = new AlphaAnimation(0.7f, 0.0f);
        this.aeZ.setDuration(500L);
        this.aeZ.setAnimationListener(this.fxi);
        this.fxb = new C0298a();
        this.ehI = new com.baidu.afd.videopaster.d(getContext(), this.fee);
        this.fxe = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.bSd.onChangeSkinType(i);
        this.bSe.setTextColor(tbPageContext.getResources().getColor(d.C0277d.cp_cont_d));
        this.bSf.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.video_comment_background));
        this.bSi.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.video_share_background));
        this.fwQ.setTextColor(tbPageContext.getResources().getColor(d.C0277d.cp_btn_a));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.feS != null) {
            boolean z = this.fes == gVar;
            this.fes = gVar;
            this.bGc = this.fes.autoPlay;
            this.fwW = false;
            jT(false);
            this.fwQ.setVisibility(0);
            if (gVar.feS != null && !StringUtils.isNull(gVar.feS.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fwQ, gVar.title, gVar.feS.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fwQ.setText(gVar.title);
            }
            bjE();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.aaH() != null) {
                gVar.aaH().isInThread = true;
            }
            this.bSd.setIsFromMiddlePage(true);
            this.bSd.setData(gVar.aaH());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bjD() {
        try {
            int parseInt = Integer.parseInt(this.fes.feS.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fes.feS.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bjE() {
        if (!bjD()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fed.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fed.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fed.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fed.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.feS != null) {
            this.fer.stopPlay();
            this.fer.setIsNeedRecoveryVideoPlayer(true);
            this.fer.oX(true);
            this.fer.oT(true);
            this.fer.oY(true);
            this.fer.ae(false, false);
            this.fer.xm(i);
            this.fer.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                    a.this.bjI();
                    if (a.this.ehI != null) {
                        a.this.ehI.qj();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                    a.this.bjJ();
                    if (a.this.fer.ql()) {
                    }
                    if (a.this.fex || (a.this.ehI != null && a.this.ehI.qb())) {
                        a.this.fer.stopPlay();
                    }
                    if (a.this.ehI != null) {
                        a.this.ehI.qk();
                    }
                }
            });
            this.fer.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.l
                public void beP() {
                    if (a.this.fes != null && a.this.fes.feS != null && com.baidu.adp.lib.g.b.l(a.this.fes.feS.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.fes.feS.videoWidth, 0)) {
                        a.this.fer.ae(false, false);
                    } else {
                        a.this.fer.ae(true, false);
                    }
                    a.this.fex = false;
                    a.this.vc(a.this.bGc ? "1" : "2");
                    a.this.onClick(a.this.fee);
                    if (a.this.TB != null) {
                        a.this.TB.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void beQ() {
                    a.this.onClick(a.this.fed);
                }
            });
            this.fer.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.f
                public void jx(boolean z2) {
                    a.this.fer.cf(a.this.fes.feS.videoUrl, a.this.fes.threadId);
                    a.this.vc("2");
                    a.this.onClick(a.this.fee);
                }
            });
            this.fer.oP(false);
            if (this.fxe != null) {
                this.fxe.reset();
            }
            this.startPosition = -1L;
            this.dbe.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fes.feS.ffc;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.ehI.a(a.this.isFullScreen, a.this.fer != null && a.this.fer.bSG(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.ehI.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fer.bSG() && !com.baidu.mcn.b.sY().cR(aVar2.TW)) {
                        boolean z3 = a.this.startPosition >= (aVar2.feV * 1000) + 1000;
                        if (i3 < aVar2.feV * 1000 || i3 >= aVar2.feW * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fxe.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aeK = aVar2.feY;
                                aVar3.aeL = aVar2.feZ;
                                aVar3.aeM = aVar2.TW;
                                aVar3.aeJ = aVar2.feX;
                                aVar3.fid = a.this.fes != null ? a.this.fes.forumId : null;
                                aVar3.tid = a.this.fes != null ? a.this.fes.threadId : null;
                                aVar3.aeN = 3;
                                if (z3) {
                                    a.this.fxe.b(aVar3, (ViewGroup) a.this.fer.bSZ());
                                } else {
                                    a.this.fxe.a(aVar3, (ViewGroup) a.this.fer.bSZ());
                                }
                            }
                        } else if (a.this.fxe.isShowing()) {
                            a.this.fxe.dismiss();
                        }
                    }
                }
            });
            this.feu = new z();
            this.feu.ctu = gVar.threadId;
            this.feu.ela = gVar.forumId;
            this.feu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.feu.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.feu.mSource = gVar.source;
            this.feu.hYL = gVar.weight;
            this.feu.hYN = this.mFrom;
            this.feu.hYO = gVar.abtest_tag;
            this.feu.byA = this.byA;
            this.feu.ekW = gVar.extra;
            this.feu.hYR = "0";
            this.fev = new z();
            this.fev.ctu = gVar.threadId;
            this.fev.ela = gVar.forumId;
            this.fev.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fev.hYL = "auto_midpage";
            this.fev.mLocate = "auto_midpage";
            this.fev.hYN = this.mFrom;
            this.fev.mSource = gVar.source;
            this.fev.hYR = "0";
            if (gVar.feS != null) {
                this.feu.hYP = gVar.feS.videoMd5;
                this.fev.hYP = gVar.feS.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.bJ("tid", gVar.threadId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.T("obj_locate", i);
            amVar.T("obj_param2", 1);
            amVar.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.bJ("obj_param1", ap.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.bJ("extra", ap.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byA);
            amVar.bJ("ab_tag", ap.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.bJ("obj_type", this.mFrom);
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.fes.source) ? "0" : this.fes.source);
            amVar.T("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.dbe.setVideoStatsData(this.feu);
            this.fer.getVideoView().setBusiness(this.dbe);
            this.dbe.a(gVar);
            this.fer.bAG();
            this.fer.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.ehI.a(a.this.isFullScreen, a.this.fer != null && a.this.fer.bSG(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fex = true;
                            a.this.fwU = true;
                            a.this.few = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.qv(i);
                            a.this.fer.bnQ();
                        }
                    }
                }
            });
            this.fer.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fes != null && a.this.fes.feS != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fes.feS.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.ehI.reset();
            }
            this.ehI.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void qs() {
                    a.this.fwU = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void qr() {
                    if (a.this.isFullScreen) {
                        a.this.fex = true;
                        a.this.fwU = true;
                        a.this.few = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.qv(i);
                        a.this.fer.bnQ();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void qq() {
                    if (a.this.fer != null) {
                        a.this.fer.xl(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean qt() {
                    return a.this.bjH();
                }
            });
            this.fer.setThumbnail(gVar.feS.thumbnailUrl);
            this.fer.setVideoUrl(gVar.feS.videoUrl, gVar.threadId);
            this.fer.setFid(gVar.forumId);
            this.fer.bnQ();
            this.fer.show();
            jT(false);
            if (gVar.autoPlay) {
                onClick(this.fee);
                if (this.fxc.bUo()) {
                    this.fer.oV(false);
                    this.fxc.cmp();
                    this.fer.oW(true);
                    this.fer.dC(gVar.feS.videoUrl, gVar.threadId);
                    if (this.ehI.qb()) {
                        this.ehI.stop();
                        this.ehI.qg();
                    }
                } else {
                    this.fer.oW(false);
                    this.fer.oV(false);
                    this.fxc.hide();
                    if (this.ehI == null || (this.ehI != null && !this.ehI.qb())) {
                        this.fer.a(gVar.feS.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.feT) {
                    this.fwX.setVisibility(8);
                    this.fxb.rG(3);
                } else {
                    if (this.fwX.getVisibility() == 0) {
                        this.fwX.startAnimation(this.aeZ);
                    }
                    this.fxb.rG(0);
                }
                gVar.feT = false;
            } else {
                this.fwX.setVisibility(0);
                this.fxc.hide();
                this.fer.oV(true);
                this.fxb.rG(3);
                this.fer.dC(gVar.feS.videoUrl, gVar.threadId);
            }
            this.fex = false;
            this.fwU = false;
            if (!z && this.ehI.qb()) {
                stopPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a h(com.baidu.tieba.frs.aggregation.g gVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (gVar == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b vP = this.fxd != null ? this.fxd.vP(gVar.getThreadId()) : null;
        if (vP == null) {
            return null;
        }
        int qx = vP.qx();
        int qy = vP.qy();
        int qw = vP.qw();
        if (qw != -1) {
            i = qx != -1 ? (qw - qx) - 1 : -1;
            if (qy != -1) {
                i4 = (qy - qw) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.feS != null) {
            i3 = com.baidu.adp.lib.g.b.l(gVar.feS.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.l(gVar.feS.videoHeight, 0);
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", gVar.threadId);
        hashMap.put("video_title", gVar.title);
        hashMap.put("forum_id", gVar.forumId);
        hashMap.put("forum_name", "");
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", qw + 1, i3, i2);
        a.l(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(String str) {
        if (this.fes != null && this.fes.feS != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fes.feS.videoMd5, "", str, this.fev);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.fer.ql();
    }

    public boolean bjF() {
        return this.ehI.qb();
    }

    public void beL() {
        if (isPlaying()) {
            this.fer.pausePlay();
        }
    }

    public boolean qw(int i) {
        if (i == 4 && this.ehI != null && ((this.ehI.qb() || this.fwU) && this.fer != null)) {
            this.ehI.bk(i);
            if (this.isFullScreen) {
                if (this.ehI.qa()) {
                    this.fer.bSH();
                } else {
                    this.fer.bAB();
                }
                return true;
            }
        }
        return this.fer.xl(i);
    }

    public void beM() {
        this.fwW = false;
        this.fer.stopPlay();
        if (this.fwQ != null) {
            this.fwQ.setVisibility(0);
        }
        if (this.fxb != null) {
            this.fxb.rG(2);
        }
        jT(false);
        this.fwV = true;
        if (this.ehI != null && this.ehI.qb()) {
            this.ehI.stop();
        }
    }

    public void bjG() {
        this.ehI.stop();
    }

    public void beN() {
        if (this.fer != null) {
            this.fer.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        beN();
        if (this.fet != null) {
            this.fet.beY();
        }
        if (this.fwX != null) {
            this.fwX.clearAnimation();
        }
        this.ehI.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.feR != null) {
            this.Zy.setText(TextUtils.isEmpty(gVar.feR.userNickname) ? gVar.feR.userName : gVar.feR.userNickname);
            if (!StringUtils.isNull(gVar.feR.portrait) && gVar.feR.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.dRs.startLoad(gVar.feR.portrait, 10, false);
            } else {
                this.dRs.startLoad(gVar.feR.portrait, 12, false);
            }
            if (gVar.feR.isBigV) {
                this.dRs.setShowV(gVar.feR.isBigV);
                this.dRs.setIsBigV(gVar.feR.isBigV);
            } else if (gVar.feR.isGod) {
                this.dRs.setShowV(gVar.feR.isGod);
                this.dRs.setIsBigV(gVar.feR.isGod);
            } else {
                this.dRs.setShowV(gVar.feR.isGod);
                this.dRs.setIsBigV(gVar.feR.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.bSd.setData(gVar.aaH());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.bSe.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_d));
            this.bSf.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.bSe.setText(ap.az(gVar.postNum));
            } else {
                this.bSe.setText(this.mContext.getString(d.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fer != null && this.fee != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.few) {
                this.fer.bSN();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bjI();
            } else {
                configuration.orientation = 1;
                bjJ();
                this.few = true;
            }
            this.fer.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjH() {
        if (this.fer != null && this.fee != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fee.getParent() != null) {
                if (this.fee.getParent() == frameLayout) {
                    if (this.fxf) {
                        this.fxf = false;
                        return true;
                    } else if (!this.fxg) {
                        this.fxg = true;
                        return true;
                    }
                } else if (this.fee.getParent() == this.fed) {
                    if (this.fxg) {
                        this.fxg = false;
                        this.fxh = true;
                        return true;
                    } else if (!this.fxf && this.fxh) {
                        this.fxf = true;
                        this.fxh = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjI() {
        if (this.fer != null && this.fee != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fee.getParent() != null) {
                if (this.fee.getParent() == frameLayout) {
                    frameLayout.removeView(this.fee);
                } else if (this.fee.getParent() == this.fed) {
                    this.fed.removeView(this.fee);
                }
            }
            if (this.fee.getParent() == null) {
                frameLayout.addView(this.fee);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fee.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fee.setLayoutParams(layoutParams);
                if (this.fxe != null && this.fxe.isShowing()) {
                    this.fxe.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjJ() {
        if (this.fer != null && this.fee != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fee.getParent() != null) {
                if (this.fee.getParent() == frameLayout) {
                    bjK();
                    frameLayout.removeView(this.fee);
                } else if (this.fee.getParent() == this.fed) {
                    bjK();
                    this.fed.removeView(this.fee);
                }
            }
            if (this.fee.getParent() == null) {
                this.fed.addView(this.fee, 0);
                bjL();
                this.fer.bAG();
                this.startPosition = -1L;
            }
        }
    }

    private void bjK() {
        if (this.ehI != null && this.ehI.qb()) {
            this.ehI.aC(true);
        }
    }

    private void bjL() {
        int i;
        if (!bjD()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fee.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aQh() != null) {
            view.setTag(this);
            aQh().a(view, this.fes);
        }
        if (view == this.dRs || view == this.Zy) {
            if (this.fes != null && this.fes.feR != null && !TextUtils.isEmpty(this.fes.feR.userId)) {
                this.fxb.rG(0);
                if (!TbadkCoreApplication.isLogin() || !this.fes.feR.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.fes.feR.userId, 0L), z, this.fes.feR.isGod)));
            }
        } else if (view == this.bSg) {
            if (this.fes != null) {
                this.fxb.rG(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fes.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fwQ || view == this.fwR) {
            if (this.fes != null) {
                if (this.fxb.getCurrentState() != 2 && this.fxb.getCurrentState() != 3) {
                    z = false;
                }
                this.fxb.rG(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fes.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.bSj) {
            this.fxb.rG(0);
            aeX();
        } else if (view == this.fwX && this.fwX.getVisibility() == 0 && this.fwZ != null) {
            this.fwZ.rK(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void jw(boolean z) {
        if (this.fes != null && this.fes.feR != null) {
            this.fes.feR.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void beO() {
        if (this.fes != null) {
            this.bSd.aee();
        }
    }

    public void jS(boolean z) {
        if (this.fed != null) {
            this.fed.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fwZ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.TB = fVar;
    }

    private void jT(boolean z) {
        this.fwV = this.mPosition == (this.fxa == null ? -1 : this.fxa.bjW());
        if (this.fwV && z && isPlaying() && this.bGc && !this.fwW) {
            this.fwS.setVisibility(0);
            this.fwW = true;
            this.fwS.postDelayed(this.fxk, 5000L);
            if (this.fxa != null) {
                this.fxa.cH(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fwS.setVisibility(8);
        if (this.fxk != null) {
            this.fwS.removeCallbacks(this.fxk);
        }
    }

    private void aeX() {
        if (this.fes != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fes.forumId);
            String str = this.fes.title;
            String str2 = this.fes.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fes.feS.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fes.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.cby = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.cbB = 3;
            dVar.fid = valueOf;
            dVar.cbs = "";
            dVar.tid = str2;
            dVar.cbm = true;
            dVar.cbA = 0;
            dVar.cbF = 2;
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
            bundle.putInt("obj_param1", dVar.cbB);
            bundle.putInt("obj_type", dVar.cbF);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDV);
            dVar.D(bundle);
            com.baidu.tieba.c.e.aSt().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        beM();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        beL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jU(boolean z) {
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

    public void bjM() {
        this.ehI.resume();
    }

    public boolean bjN() {
        if (this.fxb != null) {
            return this.fxb.getCurrentState() == 2 || this.fxb.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0298a {
        private Runnable fxo;
        private int mCurrentState;

        private C0298a() {
            this.mCurrentState = -1;
            this.fxo = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(C0298a.this.fxo);
                    C0298a.this.rG(2);
                }
            };
        }

        public void rG(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = rH(i);
                    bjO();
                    return;
                case 1:
                    this.mCurrentState = rH(i);
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fxo);
                    return;
                case 2:
                    this.mCurrentState = rI(i);
                    return;
                case 3:
                    this.mCurrentState = rJ(i);
                    bjO();
                    return;
                default:
                    this.mCurrentState = rI(i);
                    return;
            }
        }

        private void bjO() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fxo);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fxo, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int rH(int i) {
            if (i != this.mCurrentState) {
                a.this.fwY.setVisibility(8);
                a.this.jU(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int rI(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fwY.setVisibility(0);
                if (i2 != 3 || a.this.fes.autoPlay) {
                    a.this.jU(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int rJ(int i) {
            if (i != this.mCurrentState) {
                a.this.fwY.setVisibility(0);
                a.this.jU(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
