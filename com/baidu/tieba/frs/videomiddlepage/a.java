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
    private com.baidu.tieba.lego.card.view.f Rm;
    public TextView Xq;
    private Animation afk;
    private Animation afl;
    private String bFQ;
    private boolean bNG;
    protected AgreeView bZZ;
    private TextView caa;
    private ImageView cab;
    private View cac;
    private ImageView cae;
    private View caf;
    private n dlO;
    private int eVy;
    public HeadImageView ebk;
    private com.baidu.afd.videopaster.d exj;
    private TextView fNA;
    private boolean fNB;
    private boolean fNC;
    private boolean fND;
    private View fNE;
    private View fNF;
    private c fNG;
    public com.baidu.tieba.frs.videomiddlepage.a.a fNH;
    private C0316a fNI;
    private VideoNetworkStateTipView fNJ;
    private b fNK;
    private com.baidu.mcn.c fNL;
    private com.baidu.tieba.lego.card.view.g fNM;
    private boolean fNN;
    private boolean fNO;
    private boolean fNP;
    private Animation.AnimationListener fNQ;
    private Animation.AnimationListener fNR;
    private Runnable fNS;
    private Runnable fNT;
    public SpannableClickTextView fNx;
    private View fNy;
    private FrameLayout fNz;
    private boolean fuC;
    public FrameLayout fuf;
    public FrameLayout fug;
    public com.baidu.tieba.play.c fut;
    public com.baidu.tieba.frs.aggregation.g fuu;
    private com.baidu.tieba.frs.aggregation.h fuv;
    private z fuw;
    private z fux;
    private boolean fuy;
    private boolean fuz;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fuy = true;
        this.fuC = true;
        this.fNC = false;
        this.fND = false;
        this.fNN = false;
        this.fNO = false;
        this.fNP = false;
        this.startPosition = -1L;
        this.eVy = 0;
        this.fNQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fNE != null) {
                    a.this.fNE.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fNE != null) {
                    a.this.fNE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fNR = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fNE != null) {
                    a.this.fNE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fNE != null) {
                    a.this.fNE.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fNS = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fNz.getVisibility() == 0) {
                    a.this.fNz.setVisibility(8);
                }
            }
        };
        this.fNT = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fut != null) {
                    a.this.fut.stopPlay();
                }
            }
        };
        this.fuC = z;
        this.mFrom = str;
        this.bFQ = str2;
        this.fNK = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fuf = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fNy = view.findViewById(R.id.card_container);
        this.fug = (FrameLayout) view.findViewById(R.id.video_container);
        this.fut = new com.baidu.tieba.play.c(tbPageContext, (View) this.fug, false);
        this.fut.pG(z);
        this.fut.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fNH != null && a.this.fuu.fuU.videoDuration > 8) {
                    a.this.fNH.al(a.this.mPosition, a.this.fuu.fuU.videoUrl);
                }
            }
        });
        this.fut.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void kL(boolean z2) {
                if (a.this.fNI != null) {
                    if (z2) {
                        a.this.fNI.sK(0);
                    } else {
                        a.this.fNI.sK(1);
                    }
                }
            }
        });
        this.fut.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fNx = (SpannableClickTextView) view.findViewById(R.id.title);
        this.ebk = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Xq = (TextView) view.findViewById(R.id.user_name);
        this.bZZ = (AgreeView) view.findViewById(R.id.agree_view);
        this.bZZ.setAgreeAnimationResource(R.raw.agree);
        this.bZZ.setDisagreeAnimationResource(R.raw.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEA = 2;
        dVar.bEE = 6;
        this.bZZ.setStatisticData(dVar);
        this.caa = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.cab = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.cac = view.findViewById(R.id.thread_info_commont_container);
        this.cae = (ImageView) view.findViewById(R.id.share_num_img);
        this.caf = view.findViewById(R.id.share_num_container);
        this.fNz = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.fNA = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.fNz.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fNA.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_download_link_url", null);
        this.fNA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aiz().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fNJ = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.fNJ.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.fNJ.setHasAgreeToPlay(true);
                a.this.fut.pM(false);
                a.this.fNJ.cus();
                if (a.this.exj.oW()) {
                    a.this.exj.resume();
                } else if (a.this.fuu != null && a.this.fuu.fuU != null) {
                    a.this.fut.cr(a.this.fuu.fuU.videoUrl, a.this.fuu.threadId);
                }
            }
        });
        this.fNE = view.findViewById(R.id.video_agg_container_foreground);
        this.fNF = view.findViewById(R.id.title_and_comment_container_foreground);
        this.fNE.setOnClickListener(this);
        this.cac.setOnClickListener(this);
        this.caf.setOnClickListener(this);
        this.fNx.setOnClickListener(this);
        this.ebk.setOnClickListener(this);
        this.Xq.setOnClickListener(this);
        this.fNy.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        this.eVy = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuf.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fuf.setLayoutParams(layoutParams);
        this.ebk.setIsRound(true);
        this.dlO = new n(tbPageContext.getPageActivity());
        this.fuv = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.afk = new AlphaAnimation(0.0f, 0.7f);
        this.afk.setDuration(500L);
        this.afk.setAnimationListener(this.fNR);
        this.afl = new AlphaAnimation(0.7f, 0.0f);
        this.afl.setDuration(500L);
        this.afl.setAnimationListener(this.fNQ);
        this.fNI = new C0316a();
        this.exj = new com.baidu.afd.videopaster.d(getContext(), this.fug);
        this.fNL = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.bZZ.onChangeSkinType(i);
        this.caa.setTextColor(tbPageContext.getResources().getColor(R.color.cp_cont_d));
        this.cab.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_comment_background));
        this.cae.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_share_background));
        this.fNx.setTextColor(tbPageContext.getResources().getColor(R.color.cp_btn_a));
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
        if (gVar != null && gVar.fuU != null) {
            boolean z = this.fuu == gVar;
            this.fuu = gVar;
            this.bNG = this.fuu.autoPlay;
            this.fND = false;
            kJ(false);
            this.fNx.setVisibility(0);
            if (gVar.fuU != null && !StringUtils.isNull(gVar.fuU.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fNx, gVar.title, gVar.fuU.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fNx.setText(gVar.title);
            }
            this.mWidth = l.af(this.mContext);
            if (this.mWidth != this.eVy) {
                this.fut.cba();
                this.eVy = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.fug.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fug.setLayoutParams(layoutParams);
            }
            bqZ();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.afl() != null) {
                gVar.afl().isInThread = true;
            }
            this.bZZ.setIsFromMiddlePage(true);
            this.bZZ.setData(gVar.afl());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bqY() {
        try {
            int parseInt = Integer.parseInt(this.fuu.fuU.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fuu.fuU.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bqZ() {
        if (!bqY()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuf.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fuf.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fuf.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fuf.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.fuU != null) {
            this.fut.stopPlay();
            this.fut.setIsNeedRecoveryVideoPlayer(true);
            this.fut.pN(true);
            this.fut.pJ(true);
            this.fut.pO(true);
            this.fut.ad(false, false);
            this.fut.yp(i);
            this.fut.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                    a.this.brd();
                    if (a.this.exj != null) {
                        a.this.exj.pe();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                    a.this.bre();
                    if (a.this.fut.pg()) {
                    }
                    if (a.this.fuz || (a.this.exj != null && a.this.exj.oW())) {
                        com.baidu.adp.lib.g.e.iB().removeCallbacks(a.this.fNT);
                        com.baidu.adp.lib.g.e.iB().post(a.this.fNT);
                    }
                    if (a.this.exj != null) {
                        a.this.exj.pf();
                    }
                }
            });
            this.fut.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void bmi() {
                    if (a.this.fuu != null && a.this.fuu.fuU != null && com.baidu.adp.lib.g.b.f(a.this.fuu.fuU.videoHeight, 0) > com.baidu.adp.lib.g.b.f(a.this.fuu.fuU.videoWidth, 0)) {
                        a.this.fut.ad(false, false);
                    } else {
                        a.this.fut.ad(true, false);
                    }
                    a.this.fuz = false;
                    a.this.wu(a.this.bNG ? "1" : "2");
                    a.this.onClick(a.this.fug);
                    if (a.this.Rm != null) {
                        a.this.Rm.a(a.this);
                    }
                    if (a.this.fNM != null) {
                        a.this.fNM.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmj() {
                    a.this.onClick(a.this.fuf);
                }
            });
            this.fut.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z2) {
                    a.this.fut.cr(a.this.fuu.fuU.videoUrl, a.this.fuu.threadId);
                    a.this.wu("2");
                    a.this.onClick(a.this.fug);
                }
            });
            this.fut.pF(false);
            if (this.fNL != null) {
                this.fNL.reset();
            }
            this.startPosition = -1L;
            this.dlO.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fuu.fuU.fve;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.exj.a(a.this.isFullScreen, a.this.fut != null && a.this.fut.caG(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.exj.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fut.caG() && !com.baidu.mcn.b.tJ().cE(aVar2.RF)) {
                        boolean z3 = a.this.startPosition >= (aVar2.fuX * 1000) + 1000;
                        if (i3 < aVar2.fuX * 1000 || i3 >= aVar2.fuY * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fNL.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aeW = aVar2.fva;
                                aVar3.aeX = aVar2.fvb;
                                aVar3.aeY = aVar2.RF;
                                aVar3.aeV = aVar2.fuZ;
                                aVar3.fid = a.this.fuu != null ? a.this.fuu.forumId : null;
                                aVar3.tid = a.this.fuu != null ? a.this.fuu.threadId : null;
                                aVar3.aeZ = 3;
                                if (z3) {
                                    a.this.fNL.b(aVar3, (ViewGroup) a.this.fut.caZ());
                                } else {
                                    a.this.fNL.a(aVar3, (ViewGroup) a.this.fut.caZ());
                                }
                            }
                        } else if (a.this.fNL.isShowing()) {
                            a.this.fNL.dismiss();
                        }
                    }
                }
            });
            this.fuw = new z();
            this.fuw.bVM = gVar.threadId;
            this.fuw.eAC = gVar.forumId;
            this.fuw.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fuw.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.fuw.mSource = gVar.source;
            this.fuw.iri = gVar.weight;
            this.fuw.irk = this.mFrom;
            this.fuw.irl = gVar.abtest_tag;
            this.fuw.bFQ = this.bFQ;
            this.fuw.eAy = gVar.extra;
            this.fuw.iro = "0";
            this.fux = new z();
            this.fux.bVM = gVar.threadId;
            this.fux.eAC = gVar.forumId;
            this.fux.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fux.iri = "auto_midpage";
            this.fux.mLocate = "auto_midpage";
            this.fux.irk = this.mFrom;
            this.fux.mSource = gVar.source;
            this.fux.iro = "0";
            if (gVar.fuU != null) {
                this.fuw.irm = gVar.fuU.videoMd5;
                this.fux.irm = gVar.fuU.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.bT("tid", gVar.threadId);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.P("obj_locate", i);
            amVar.P("obj_param2", 1);
            amVar.bT("fid", gVar.forumId);
            amVar.bT("obj_param1", ap.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.bT("extra", ap.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFQ);
            amVar.bT("ab_tag", ap.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.bT("obj_type", this.mFrom);
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.fuu.source) ? "0" : this.fuu.source);
            amVar.P("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.dlO.setVideoStatsData(this.fuw);
            this.fut.getVideoView().setBusiness(this.dlO);
            this.dlO.a(gVar);
            this.fut.bIr();
            this.fut.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.exj.a(a.this.isFullScreen, a.this.fut != null && a.this.fut.caG(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fuz = true;
                            a.this.fNB = true;
                            a.this.fuy = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.ry(i);
                            a.this.fut.bvu();
                        }
                    }
                }
            });
            this.fut.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fuu != null && a.this.fuu.fuU != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fuu.fuU.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.exj.reset();
            }
            this.exj.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void pn() {
                    a.this.fNB = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pm() {
                    if (a.this.isFullScreen) {
                        a.this.fuz = true;
                        a.this.fNB = true;
                        a.this.fuy = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.ry(i);
                        a.this.fut.bvu();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pl() {
                    if (a.this.fut != null) {
                        a.this.fut.yo(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean po() {
                    return a.this.brc();
                }
            });
            this.fut.setThumbnail(gVar.fuU.thumbnailUrl);
            this.fut.setVideoUrl(gVar.fuU.videoUrl, gVar.threadId);
            this.fut.setFid(gVar.forumId);
            this.fut.bvu();
            this.fut.show();
            kJ(false);
            if (gVar.autoPlay) {
                onClick(this.fug);
                if (this.fNJ.ccp()) {
                    this.fut.pL(false);
                    this.fNJ.cur();
                    this.fut.pM(true);
                    this.fut.dP(gVar.fuU.videoUrl, gVar.threadId);
                    if (this.exj.oW()) {
                        this.exj.stop();
                        this.exj.pb();
                    }
                } else {
                    this.fut.pM(false);
                    this.fut.pL(false);
                    this.fNJ.hide();
                    if (this.exj == null || (this.exj != null && !this.exj.oW())) {
                        this.fut.a(gVar.fuU.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.fuV) {
                    this.fNE.setVisibility(8);
                    this.fNI.sK(3);
                } else {
                    if (this.fNE.getVisibility() == 0) {
                        this.fNE.startAnimation(this.afl);
                    }
                    this.fNI.sK(0);
                }
                gVar.fuV = false;
            } else {
                this.fNE.setVisibility(0);
                this.fNJ.hide();
                this.fut.pL(true);
                this.fNI.sK(3);
                this.fut.dP(gVar.fuU.videoUrl, gVar.threadId);
            }
            this.fuz = false;
            this.fNB = false;
            if (!z && this.exj.oW()) {
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
        com.baidu.afd.videopaster.data.b xf = this.fNK != null ? this.fNK.xf(gVar.getThreadId()) : null;
        if (xf == null) {
            return null;
        }
        int ps = xf.ps();
        int pt = xf.pt();
        int pr = xf.pr();
        if (pr != -1) {
            i = ps != -1 ? (pr - ps) - 1 : -1;
            if (pt != -1) {
                i4 = (pt - pr) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.fuU != null) {
            i3 = com.baidu.adp.lib.g.b.f(gVar.fuU.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.f(gVar.fuU.videoHeight, 0);
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
    public void wu(String str) {
        if (this.fuu != null && this.fuu.fuU != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fuu.fuU.videoMd5, "", str, this.fux);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fut.pg();
    }

    public boolean bra() {
        return this.exj.oW();
    }

    public void bme() {
        if (isPlaying()) {
            this.fut.pausePlay();
        }
    }

    public boolean rz(int i) {
        if (i == 4 && this.exj != null && ((this.exj.oW() || this.fNB) && this.fut != null)) {
            this.exj.bc(i);
            if (this.isFullScreen) {
                if (this.exj.oV()) {
                    this.fut.caH();
                } else {
                    this.fut.bIm();
                }
                return true;
            }
        }
        return this.fut.yo(i);
    }

    public void bmf() {
        this.fND = false;
        this.fut.stopPlay();
        if (this.fNx != null) {
            this.fNx.setVisibility(0);
        }
        if (this.fNI != null) {
            this.fNI.sK(2);
        }
        kJ(false);
        this.fNC = true;
        if (this.exj != null && this.exj.oW()) {
            this.exj.stop();
        }
    }

    public void brb() {
        this.exj.stop();
    }

    public void bmg() {
        if (this.fut != null) {
            this.fut.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmg();
        if (this.fuv != null) {
            this.fuv.bmr();
        }
        if (this.fNE != null) {
            this.fNE.clearAnimation();
        }
        this.exj.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.fuT != null) {
            this.Xq.setText(TextUtils.isEmpty(gVar.fuT.userNickname) ? gVar.fuT.userName : gVar.fuT.userNickname);
            if (!StringUtils.isNull(gVar.fuT.portrait) && gVar.fuT.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.ebk.startLoad(gVar.fuT.portrait, 10, false);
            } else {
                this.ebk.startLoad(gVar.fuT.portrait, 12, false);
            }
            if (gVar.fuT.isBigV) {
                this.ebk.setShowV(gVar.fuT.isBigV);
                this.ebk.setIsBigV(gVar.fuT.isBigV);
            } else if (gVar.fuT.isGod) {
                this.ebk.setShowV(gVar.fuT.isGod);
                this.ebk.setIsBigV(gVar.fuT.isGod);
            } else {
                this.ebk.setShowV(gVar.fuT.isGod);
                this.ebk.setIsBigV(gVar.fuT.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.bZZ.setData(gVar.afl());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.caa.setTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
            this.cab.setImageDrawable(getContext().getResources().getDrawable(R.drawable.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.caa.setText(ap.aN(gVar.postNum));
            } else {
                this.caa.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fut != null && this.fug != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fuy) {
                this.fut.caN();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                brd();
            } else {
                configuration.orientation = 1;
                bre();
                this.fuy = true;
            }
            this.fut.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brc() {
        if (this.fut != null && this.fug != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fug.getParent() != null) {
                if (this.fug.getParent() == frameLayout) {
                    if (this.fNN) {
                        this.fNN = false;
                        return true;
                    } else if (!this.fNO) {
                        this.fNO = true;
                        return true;
                    }
                } else if (this.fug.getParent() == this.fuf) {
                    if (this.fNO) {
                        this.fNO = false;
                        this.fNP = true;
                        return true;
                    } else if (!this.fNN && this.fNP) {
                        this.fNN = true;
                        this.fNP = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brd() {
        if (this.fut != null && this.fug != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fug.getParent() != null) {
                if (this.fug.getParent() == frameLayout) {
                    frameLayout.removeView(this.fug);
                } else if (this.fug.getParent() == this.fuf) {
                    this.fuf.removeView(this.fug);
                }
            }
            if (this.fug.getParent() == null) {
                frameLayout.addView(this.fug);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fug.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fug.setLayoutParams(layoutParams);
                if (this.fNL != null && this.fNL.isShowing()) {
                    this.fNL.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bre() {
        if (this.fut != null && this.fug != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fug.getParent() != null) {
                if (this.fug.getParent() == frameLayout) {
                    brf();
                    frameLayout.removeView(this.fug);
                } else if (this.fug.getParent() == this.fuf) {
                    brf();
                    this.fuf.removeView(this.fug);
                }
            }
            if (this.fug.getParent() == null) {
                this.fuf.addView(this.fug, 0);
                brg();
                this.fut.bIr();
                this.startPosition = -1L;
            }
        }
    }

    private void brf() {
        if (this.exj != null && this.exj.oW()) {
            this.exj.au(true);
        }
    }

    private void brg() {
        int i;
        if (!bqY()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fug.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aXr() != null) {
            view.setTag(this);
            aXr().a(view, this.fuu);
        }
        if (view == this.ebk || view == this.Xq) {
            if (this.fuu != null && this.fuu.fuT != null && !TextUtils.isEmpty(this.fuu.fuT.userId)) {
                this.fNI.sK(0);
                if (!TbadkCoreApplication.isLogin() || !this.fuu.fuT.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fuu.fuT.userId, 0L), z, this.fuu.fuT.isGod)));
            }
        } else if (view == this.cac) {
            if (this.fuu != null) {
                this.fNI.sK(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fuu.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fNx || view == this.fNy) {
            if (this.fuu != null) {
                if (this.fNI.getCurrentState() != 2 && this.fNI.getCurrentState() != 3) {
                    z = false;
                }
                this.fNI.sK(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fuu.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.caf) {
            this.fNI.sK(0);
            ajT();
        } else if (view == this.fNE && this.fNE.getVisibility() == 0 && this.fNG != null) {
            this.fNG.sO(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fuu != null && this.fuu.fuT != null) {
            this.fuu.fuT.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bmh() {
        if (this.fuu != null) {
            this.bZZ.aja();
        }
    }

    public void kI(boolean z) {
        if (this.fuf != null) {
            this.fuf.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.fNM = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fNG = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Rm = fVar;
    }

    private void kJ(boolean z) {
        this.fNC = this.mPosition == (this.fNH == null ? -1 : this.fNH.brr());
        if (this.fNC && z && isPlaying() && this.bNG && !this.fND) {
            this.fNz.setVisibility(0);
            this.fND = true;
            this.fNz.postDelayed(this.fNS, 5000L);
            if (this.fNH != null) {
                this.fNH.de(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fNz.setVisibility(8);
        if (this.fNS != null) {
            this.fNz.removeCallbacks(this.fNS);
        }
    }

    private void ajT() {
        if (this.fuu != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fuu.forumId);
            String str = this.fuu.title;
            String str2 = this.fuu.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fuu.fuU.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fuu.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = format;
            eVar.cjD = str5;
            eVar.linkUrl = str3;
            eVar.extData = str2;
            eVar.cjG = 3;
            eVar.fid = valueOf;
            eVar.cjx = "";
            eVar.tid = str2;
            eVar.cjq = true;
            eVar.cjF = 0;
            eVar.cjK = 2;
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
            bundle.putInt("obj_param1", eVar.cjG);
            bundle.putInt("obj_type", eVar.cjK);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLt);
            eVar.E(bundle);
            com.baidu.tieba.c.e.aZC().a(new ShareDialogConfig(this.mContext, eVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bmf();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(boolean z) {
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

    public void brh() {
        this.exj.resume();
    }

    public boolean bri() {
        if (this.fNI != null) {
            return this.fNI.getCurrentState() == 2 || this.fNI.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0316a {
        private Runnable fNX;
        private int mCurrentState;

        private C0316a() {
            this.mCurrentState = -1;
            this.fNX = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(C0316a.this.fNX);
                    C0316a.this.sK(2);
                }
            };
        }

        public void sK(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = sL(i);
                    brj();
                    return;
                case 1:
                    this.mCurrentState = sL(i);
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNX);
                    return;
                case 2:
                    this.mCurrentState = sM(i);
                    return;
                case 3:
                    this.mCurrentState = sN(i);
                    brj();
                    return;
                default:
                    this.mCurrentState = sM(i);
                    return;
            }
        }

        private void brj() {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNX);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.fNX, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int sL(int i) {
            if (i != this.mCurrentState) {
                a.this.fNF.setVisibility(8);
                a.this.kK(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int sM(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fNF.setVisibility(0);
                if (i2 != 3 || a.this.fuu.autoPlay) {
                    a.this.kK(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int sN(int i) {
            if (i != this.mCurrentState) {
                a.this.fNF.setVisibility(0);
                a.this.kK(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
