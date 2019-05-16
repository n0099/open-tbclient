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
import com.baidu.adp.base.i;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.frs.view.SpannableClickTextView;
import com.baidu.tieba.lego.card.view.j;
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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f Rn;
    public TextView Xr;
    private Animation afk;
    private Animation afl;
    private String bFP;
    private boolean bNF;
    protected AgreeView bZY;
    private TextView bZZ;
    private ImageView caa;
    private View cab;
    private ImageView cad;
    private View cae;
    private n dlN;
    private int eVx;
    public HeadImageView ebj;
    private com.baidu.afd.videopaster.d exi;
    private boolean fNA;
    private View fNB;
    private View fNC;
    private c fND;
    public com.baidu.tieba.frs.videomiddlepage.a.a fNE;
    private C0316a fNF;
    private VideoNetworkStateTipView fNG;
    private b fNH;
    private com.baidu.mcn.c fNI;
    private com.baidu.tieba.lego.card.view.g fNJ;
    private boolean fNK;
    private boolean fNL;
    private boolean fNM;
    private Animation.AnimationListener fNN;
    private Animation.AnimationListener fNO;
    private Runnable fNP;
    private Runnable fNQ;
    public SpannableClickTextView fNu;
    private View fNv;
    private FrameLayout fNw;
    private TextView fNx;
    private boolean fNy;
    private boolean fNz;
    private boolean fuB;
    public FrameLayout fue;
    public FrameLayout fuf;
    public com.baidu.tieba.play.c fus;
    public com.baidu.tieba.frs.aggregation.g fut;
    private com.baidu.tieba.frs.aggregation.h fuu;
    private z fuv;
    private z fuw;
    private boolean fux;
    private boolean fuy;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fux = true;
        this.fuB = true;
        this.fNz = false;
        this.fNA = false;
        this.fNK = false;
        this.fNL = false;
        this.fNM = false;
        this.startPosition = -1L;
        this.eVx = 0;
        this.fNN = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fNB != null) {
                    a.this.fNB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fNB != null) {
                    a.this.fNB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fNO = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fNB != null) {
                    a.this.fNB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fNB != null) {
                    a.this.fNB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fNP = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fNw.getVisibility() == 0) {
                    a.this.fNw.setVisibility(8);
                }
            }
        };
        this.fNQ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fus != null) {
                    a.this.fus.stopPlay();
                }
            }
        };
        this.fuB = z;
        this.mFrom = str;
        this.bFP = str2;
        this.fNH = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fue = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fNv = view.findViewById(R.id.card_container);
        this.fuf = (FrameLayout) view.findViewById(R.id.video_container);
        this.fus = new com.baidu.tieba.play.c(tbPageContext, (View) this.fuf, false);
        this.fus.pF(z);
        this.fus.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fNE != null && a.this.fut.fuT.videoDuration > 8) {
                    a.this.fNE.al(a.this.mPosition, a.this.fut.fuT.videoUrl);
                }
            }
        });
        this.fus.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void kK(boolean z2) {
                if (a.this.fNF != null) {
                    if (z2) {
                        a.this.fNF.sK(0);
                    } else {
                        a.this.fNF.sK(1);
                    }
                }
            }
        });
        this.fus.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fNu = (SpannableClickTextView) view.findViewById(R.id.title);
        this.ebj = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Xr = (TextView) view.findViewById(R.id.user_name);
        this.bZY = (AgreeView) view.findViewById(R.id.agree_view);
        this.bZY.setAgreeAnimationResource(R.raw.agree);
        this.bZY.setDisagreeAnimationResource(R.raw.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEz = 2;
        dVar.bED = 6;
        this.bZY.setStatisticData(dVar);
        this.bZZ = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.caa = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.cab = view.findViewById(R.id.thread_info_commont_container);
        this.cad = (ImageView) view.findViewById(R.id.share_num_img);
        this.cae = view.findViewById(R.id.share_num_container);
        this.fNw = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.fNx = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.fNw.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fNx.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_download_link_url", null);
        this.fNx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aiz().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fNG = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.fNG.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.fNG.setHasAgreeToPlay(true);
                a.this.fus.pL(false);
                a.this.fNG.cur();
                if (a.this.exi.oW()) {
                    a.this.exi.resume();
                } else if (a.this.fut != null && a.this.fut.fuT != null) {
                    a.this.fus.cr(a.this.fut.fuT.videoUrl, a.this.fut.threadId);
                }
            }
        });
        this.fNB = view.findViewById(R.id.video_agg_container_foreground);
        this.fNC = view.findViewById(R.id.title_and_comment_container_foreground);
        this.fNB.setOnClickListener(this);
        this.cab.setOnClickListener(this);
        this.cae.setOnClickListener(this);
        this.fNu.setOnClickListener(this);
        this.ebj.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.fNv.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        this.eVx = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fue.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fue.setLayoutParams(layoutParams);
        this.ebj.setIsRound(true);
        this.dlN = new n(tbPageContext.getPageActivity());
        this.fuu = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.afk = new AlphaAnimation(0.0f, 0.7f);
        this.afk.setDuration(500L);
        this.afk.setAnimationListener(this.fNO);
        this.afl = new AlphaAnimation(0.7f, 0.0f);
        this.afl.setDuration(500L);
        this.afl.setAnimationListener(this.fNN);
        this.fNF = new C0316a();
        this.exi = new com.baidu.afd.videopaster.d(getContext(), this.fuf);
        this.fNI = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.bZY.onChangeSkinType(i);
        this.bZZ.setTextColor(tbPageContext.getResources().getColor(R.color.cp_cont_d));
        this.caa.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_comment_background));
        this.cad.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_share_background));
        this.fNu.setTextColor(tbPageContext.getResources().getColor(R.color.cp_btn_a));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.fuT != null) {
            boolean z = this.fut == gVar;
            this.fut = gVar;
            this.bNF = this.fut.autoPlay;
            this.fNA = false;
            kI(false);
            this.fNu.setVisibility(0);
            if (gVar.fuT != null && !StringUtils.isNull(gVar.fuT.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fNu, gVar.title, gVar.fuT.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fNu.setText(gVar.title);
            }
            this.mWidth = l.af(this.mContext);
            if (this.mWidth != this.eVx) {
                this.fus.caW();
                this.eVx = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.fuf.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fuf.setLayoutParams(layoutParams);
            }
            bqU();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.afl() != null) {
                gVar.afl().isInThread = true;
            }
            this.bZY.setIsFromMiddlePage(true);
            this.bZY.setData(gVar.afl());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bqT() {
        try {
            int parseInt = Integer.parseInt(this.fut.fuT.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fut.fuT.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bqU() {
        if (!bqT()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fue.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fue.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fue.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fue.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.fuT != null) {
            this.fus.stopPlay();
            this.fus.setIsNeedRecoveryVideoPlayer(true);
            this.fus.pM(true);
            this.fus.pI(true);
            this.fus.pN(true);
            this.fus.ad(false, false);
            this.fus.yp(i);
            this.fus.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                    a.this.bqY();
                    if (a.this.exi != null) {
                        a.this.exi.pe();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                    a.this.bqZ();
                    if (a.this.fus.pg()) {
                    }
                    if (a.this.fuy || (a.this.exi != null && a.this.exi.oW())) {
                        com.baidu.adp.lib.g.e.iB().removeCallbacks(a.this.fNQ);
                        com.baidu.adp.lib.g.e.iB().post(a.this.fNQ);
                    }
                    if (a.this.exi != null) {
                        a.this.exi.pf();
                    }
                }
            });
            this.fus.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void bmf() {
                    if (a.this.fut != null && a.this.fut.fuT != null && com.baidu.adp.lib.g.b.f(a.this.fut.fuT.videoHeight, 0) > com.baidu.adp.lib.g.b.f(a.this.fut.fuT.videoWidth, 0)) {
                        a.this.fus.ad(false, false);
                    } else {
                        a.this.fus.ad(true, false);
                    }
                    a.this.fuy = false;
                    a.this.wv(a.this.bNF ? "1" : "2");
                    a.this.onClick(a.this.fuf);
                    if (a.this.Rn != null) {
                        a.this.Rn.a(a.this);
                    }
                    if (a.this.fNJ != null) {
                        a.this.fNJ.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmg() {
                    a.this.onClick(a.this.fue);
                }
            });
            this.fus.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z2) {
                    a.this.fus.cr(a.this.fut.fuT.videoUrl, a.this.fut.threadId);
                    a.this.wv("2");
                    a.this.onClick(a.this.fuf);
                }
            });
            this.fus.pE(false);
            if (this.fNI != null) {
                this.fNI.reset();
            }
            this.startPosition = -1L;
            this.dlN.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fut.fuT.fvd;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.exi.a(a.this.isFullScreen, a.this.fus != null && a.this.fus.caC(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.exi.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fus.caC() && !com.baidu.mcn.b.tJ().cF(aVar2.RG)) {
                        boolean z3 = a.this.startPosition >= (aVar2.fuW * 1000) + 1000;
                        if (i3 < aVar2.fuW * 1000 || i3 >= aVar2.fuX * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fNI.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aeW = aVar2.fuZ;
                                aVar3.aeX = aVar2.fva;
                                aVar3.aeY = aVar2.RG;
                                aVar3.aeV = aVar2.fuY;
                                aVar3.fid = a.this.fut != null ? a.this.fut.forumId : null;
                                aVar3.tid = a.this.fut != null ? a.this.fut.threadId : null;
                                aVar3.aeZ = 3;
                                if (z3) {
                                    a.this.fNI.b(aVar3, (ViewGroup) a.this.fus.caV());
                                } else {
                                    a.this.fNI.a(aVar3, (ViewGroup) a.this.fus.caV());
                                }
                            }
                        } else if (a.this.fNI.isShowing()) {
                            a.this.fNI.dismiss();
                        }
                    }
                }
            });
            this.fuv = new z();
            this.fuv.bVL = gVar.threadId;
            this.fuv.eAB = gVar.forumId;
            this.fuv.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fuv.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.fuv.mSource = gVar.source;
            this.fuv.ire = gVar.weight;
            this.fuv.irg = this.mFrom;
            this.fuv.irh = gVar.abtest_tag;
            this.fuv.bFP = this.bFP;
            this.fuv.eAx = gVar.extra;
            this.fuv.irk = "0";
            this.fuw = new z();
            this.fuw.bVL = gVar.threadId;
            this.fuw.eAB = gVar.forumId;
            this.fuw.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fuw.ire = "auto_midpage";
            this.fuw.mLocate = "auto_midpage";
            this.fuw.irg = this.mFrom;
            this.fuw.mSource = gVar.source;
            this.fuw.irk = "0";
            if (gVar.fuT != null) {
                this.fuv.iri = gVar.fuT.videoMd5;
                this.fuw.iri = gVar.fuT.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.bT("tid", gVar.threadId);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.P("obj_locate", i);
            amVar.P("obj_param2", 1);
            amVar.bT("fid", gVar.forumId);
            amVar.bT("obj_param1", ap.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.bT("extra", ap.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFP);
            amVar.bT("ab_tag", ap.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.bT("obj_type", this.mFrom);
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.fut.source) ? "0" : this.fut.source);
            amVar.P("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.dlN.setVideoStatsData(this.fuv);
            this.fus.getVideoView().setBusiness(this.dlN);
            this.dlN.a(gVar);
            this.fus.bIn();
            this.fus.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.exi.a(a.this.isFullScreen, a.this.fus != null && a.this.fus.caC(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fuy = true;
                            a.this.fNy = true;
                            a.this.fux = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.ry(i);
                            a.this.fus.bvq();
                        }
                    }
                }
            });
            this.fus.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fut != null && a.this.fut.fuT != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fut.fuT.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.exi.reset();
            }
            this.exi.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void pn() {
                    a.this.fNy = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pm() {
                    if (a.this.isFullScreen) {
                        a.this.fuy = true;
                        a.this.fNy = true;
                        a.this.fux = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.ry(i);
                        a.this.fus.bvq();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pl() {
                    if (a.this.fus != null) {
                        a.this.fus.yo(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean po() {
                    return a.this.bqX();
                }
            });
            this.fus.setThumbnail(gVar.fuT.thumbnailUrl);
            this.fus.setVideoUrl(gVar.fuT.videoUrl, gVar.threadId);
            this.fus.setFid(gVar.forumId);
            this.fus.bvq();
            this.fus.show();
            kI(false);
            if (gVar.autoPlay) {
                onClick(this.fuf);
                if (this.fNG.ccl()) {
                    this.fus.pK(false);
                    this.fNG.cuq();
                    this.fus.pL(true);
                    this.fus.dP(gVar.fuT.videoUrl, gVar.threadId);
                    if (this.exi.oW()) {
                        this.exi.stop();
                        this.exi.pb();
                    }
                } else {
                    this.fus.pL(false);
                    this.fus.pK(false);
                    this.fNG.hide();
                    if (this.exi == null || (this.exi != null && !this.exi.oW())) {
                        this.fus.a(gVar.fuT.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.fuU) {
                    this.fNB.setVisibility(8);
                    this.fNF.sK(3);
                } else {
                    if (this.fNB.getVisibility() == 0) {
                        this.fNB.startAnimation(this.afl);
                    }
                    this.fNF.sK(0);
                }
                gVar.fuU = false;
            } else {
                this.fNB.setVisibility(0);
                this.fNG.hide();
                this.fus.pK(true);
                this.fNF.sK(3);
                this.fus.dP(gVar.fuT.videoUrl, gVar.threadId);
            }
            this.fuy = false;
            this.fNy = false;
            if (!z && this.exi.oW()) {
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
        com.baidu.afd.videopaster.data.b xd = this.fNH != null ? this.fNH.xd(gVar.getThreadId()) : null;
        if (xd == null) {
            return null;
        }
        int ps = xd.ps();
        int pt = xd.pt();
        int pr = xd.pr();
        if (pr != -1) {
            i = ps != -1 ? (pr - ps) - 1 : -1;
            if (pt != -1) {
                i4 = (pt - pr) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.fuT != null) {
            i3 = com.baidu.adp.lib.g.b.f(gVar.fuT.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.f(gVar.fuT.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", pr + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(String str) {
        if (this.fut != null && this.fut.fuT != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fut.fuT.videoMd5, "", str, this.fuw);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fus.pg();
    }

    public boolean bqV() {
        return this.exi.oW();
    }

    public void bmb() {
        if (isPlaying()) {
            this.fus.pausePlay();
        }
    }

    public boolean rz(int i) {
        if (i == 4 && this.exi != null && ((this.exi.oW() || this.fNy) && this.fus != null)) {
            this.exi.bc(i);
            if (this.isFullScreen) {
                if (this.exi.oV()) {
                    this.fus.caD();
                } else {
                    this.fus.bIi();
                }
                return true;
            }
        }
        return this.fus.yo(i);
    }

    public void bmc() {
        this.fNA = false;
        this.fus.stopPlay();
        if (this.fNu != null) {
            this.fNu.setVisibility(0);
        }
        if (this.fNF != null) {
            this.fNF.sK(2);
        }
        kI(false);
        this.fNz = true;
        if (this.exi != null && this.exi.oW()) {
            this.exi.stop();
        }
    }

    public void bqW() {
        this.exi.stop();
    }

    public void bmd() {
        if (this.fus != null) {
            this.fus.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmd();
        if (this.fuu != null) {
            this.fuu.bmo();
        }
        if (this.fNB != null) {
            this.fNB.clearAnimation();
        }
        this.exi.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.fuS != null) {
            this.Xr.setText(TextUtils.isEmpty(gVar.fuS.userNickname) ? gVar.fuS.userName : gVar.fuS.userNickname);
            if (!StringUtils.isNull(gVar.fuS.portrait) && gVar.fuS.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.ebj.startLoad(gVar.fuS.portrait, 10, false);
            } else {
                this.ebj.startLoad(gVar.fuS.portrait, 12, false);
            }
            if (gVar.fuS.isBigV) {
                this.ebj.setShowV(gVar.fuS.isBigV);
                this.ebj.setIsBigV(gVar.fuS.isBigV);
            } else if (gVar.fuS.isGod) {
                this.ebj.setShowV(gVar.fuS.isGod);
                this.ebj.setIsBigV(gVar.fuS.isGod);
            } else {
                this.ebj.setShowV(gVar.fuS.isGod);
                this.ebj.setIsBigV(gVar.fuS.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.bZY.setData(gVar.afl());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.bZZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
            this.caa.setImageDrawable(getContext().getResources().getDrawable(R.drawable.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.bZZ.setText(ap.aN(gVar.postNum));
            } else {
                this.bZZ.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fus != null && this.fuf != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fux) {
                this.fus.caJ();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bqY();
            } else {
                configuration.orientation = 1;
                bqZ();
                this.fux = true;
            }
            this.fus.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqX() {
        if (this.fus != null && this.fuf != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fuf.getParent() != null) {
                if (this.fuf.getParent() == frameLayout) {
                    if (this.fNK) {
                        this.fNK = false;
                        return true;
                    } else if (!this.fNL) {
                        this.fNL = true;
                        return true;
                    }
                } else if (this.fuf.getParent() == this.fue) {
                    if (this.fNL) {
                        this.fNL = false;
                        this.fNM = true;
                        return true;
                    } else if (!this.fNK && this.fNM) {
                        this.fNK = true;
                        this.fNM = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqY() {
        if (this.fus != null && this.fuf != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fuf.getParent() != null) {
                if (this.fuf.getParent() == frameLayout) {
                    frameLayout.removeView(this.fuf);
                } else if (this.fuf.getParent() == this.fue) {
                    this.fue.removeView(this.fuf);
                }
            }
            if (this.fuf.getParent() == null) {
                frameLayout.addView(this.fuf);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fuf.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fuf.setLayoutParams(layoutParams);
                if (this.fNI != null && this.fNI.isShowing()) {
                    this.fNI.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqZ() {
        if (this.fus != null && this.fuf != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fuf.getParent() != null) {
                if (this.fuf.getParent() == frameLayout) {
                    bra();
                    frameLayout.removeView(this.fuf);
                } else if (this.fuf.getParent() == this.fue) {
                    bra();
                    this.fue.removeView(this.fuf);
                }
            }
            if (this.fuf.getParent() == null) {
                this.fue.addView(this.fuf, 0);
                brb();
                this.fus.bIn();
                this.startPosition = -1L;
            }
        }
    }

    private void bra() {
        if (this.exi != null && this.exi.oW()) {
            this.exi.au(true);
        }
    }

    private void brb() {
        int i;
        if (!bqT()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fuf.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aXo() != null) {
            view.setTag(this);
            aXo().a(view, this.fut);
        }
        if (view == this.ebj || view == this.Xr) {
            if (this.fut != null && this.fut.fuS != null && !TextUtils.isEmpty(this.fut.fuS.userId)) {
                this.fNF.sK(0);
                if (!TbadkCoreApplication.isLogin() || !this.fut.fuS.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fut.fuS.userId, 0L), z, this.fut.fuS.isGod)));
            }
        } else if (view == this.cab) {
            if (this.fut != null) {
                this.fNF.sK(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fut.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fNu || view == this.fNv) {
            if (this.fut != null) {
                if (this.fNF.getCurrentState() != 2 && this.fNF.getCurrentState() != 3) {
                    z = false;
                }
                this.fNF.sK(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fut.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.cae) {
            this.fNF.sK(0);
            ajT();
        } else if (view == this.fNB && this.fNB.getVisibility() == 0 && this.fND != null) {
            this.fND.sO(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fut != null && this.fut.fuS != null) {
            this.fut.fuS.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bme() {
        if (this.fut != null) {
            this.bZY.aja();
        }
    }

    public void kH(boolean z) {
        if (this.fue != null) {
            this.fue.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.fNJ = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fND = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Rn = fVar;
    }

    private void kI(boolean z) {
        this.fNz = this.mPosition == (this.fNE == null ? -1 : this.fNE.brm());
        if (this.fNz && z && isPlaying() && this.bNF && !this.fNA) {
            this.fNw.setVisibility(0);
            this.fNA = true;
            this.fNw.postDelayed(this.fNP, 5000L);
            if (this.fNE != null) {
                this.fNE.de(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fNw.setVisibility(8);
        if (this.fNP != null) {
            this.fNw.removeCallbacks(this.fNP);
        }
    }

    private void ajT() {
        if (this.fut != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fut.forumId);
            String str = this.fut.title;
            String str2 = this.fut.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fut.fuT.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fut.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = format;
            eVar.cjC = str5;
            eVar.linkUrl = str3;
            eVar.extData = str2;
            eVar.cjF = 3;
            eVar.fid = valueOf;
            eVar.cjw = "";
            eVar.tid = str2;
            eVar.cjp = true;
            eVar.cjE = 0;
            eVar.cjJ = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cjF);
            bundle.putInt("obj_type", eVar.cjJ);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLs);
            eVar.E(bundle);
            com.baidu.tieba.c.e.aZz().a(new ShareDialogConfig(this.mContext, eVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bmc();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bmb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kJ(boolean z) {
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

    public void brc() {
        this.exi.resume();
    }

    public boolean brd() {
        if (this.fNF != null) {
            return this.fNF.getCurrentState() == 2 || this.fNF.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0316a {
        private Runnable fNU;
        private int mCurrentState;

        private C0316a() {
            this.mCurrentState = -1;
            this.fNU = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(C0316a.this.fNU);
                    C0316a.this.sK(2);
                }
            };
        }

        public void sK(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = sL(i);
                    bre();
                    return;
                case 1:
                    this.mCurrentState = sL(i);
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNU);
                    return;
                case 2:
                    this.mCurrentState = sM(i);
                    return;
                case 3:
                    this.mCurrentState = sN(i);
                    bre();
                    return;
                default:
                    this.mCurrentState = sM(i);
                    return;
            }
        }

        private void bre() {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNU);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.fNU, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int sL(int i) {
            if (i != this.mCurrentState) {
                a.this.fNC.setVisibility(8);
                a.this.kJ(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int sM(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fNC.setVisibility(0);
                if (i2 != 3 || a.this.fut.autoPlay) {
                    a.this.kJ(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int sN(int i) {
            if (i != this.mCurrentState) {
                a.this.fNC.setVisibility(0);
                a.this.kJ(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
