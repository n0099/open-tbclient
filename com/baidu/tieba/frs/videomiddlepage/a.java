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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private com.baidu.tieba.lego.card.view.f RD;
    public TextView XK;
    private Animation afH;
    private Animation afI;
    private String bHq;
    private boolean bPn;
    protected AgreeView ccb;
    private TextView ccc;
    private ImageView ccd;
    private View cce;
    private ImageView ccg;
    private View cch;
    private n dpp;
    private com.baidu.afd.videopaster.d eDY;
    public HeadImageView ehx;
    public FrameLayout fBC;
    public FrameLayout fBD;
    public com.baidu.tieba.play.c fBQ;
    public com.baidu.tieba.frs.aggregation.g fBR;
    private com.baidu.tieba.frs.aggregation.h fBS;
    private z fBT;
    private z fBU;
    private boolean fBV;
    private boolean fBW;
    private boolean fBZ;
    public SpannableClickTextView fVb;
    private View fVc;
    private FrameLayout fVd;
    private TextView fVe;
    private boolean fVf;
    private boolean fVg;
    private boolean fVh;
    private View fVi;
    private View fVj;
    private c fVk;
    public com.baidu.tieba.frs.videomiddlepage.a.a fVl;
    private C0330a fVm;
    private VideoNetworkStateTipView fVn;
    private b fVo;
    private com.baidu.mcn.c fVp;
    private com.baidu.tieba.lego.card.view.g fVq;
    private boolean fVr;
    private boolean fVs;
    private boolean fVt;
    private Animation.AnimationListener fVu;
    private Animation.AnimationListener fVv;
    private Runnable fVw;
    private Runnable fVx;
    private int fct;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fBV = true;
        this.fBZ = true;
        this.fVg = false;
        this.fVh = false;
        this.fVr = false;
        this.fVs = false;
        this.fVt = false;
        this.startPosition = -1L;
        this.fct = 0;
        this.fVu = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fVi != null) {
                    a.this.fVi.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fVi != null) {
                    a.this.fVi.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fVv = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fVi != null) {
                    a.this.fVi.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fVi != null) {
                    a.this.fVi.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fVw = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fVd.getVisibility() == 0) {
                    a.this.fVd.setVisibility(8);
                }
            }
        };
        this.fVx = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fBQ != null) {
                    a.this.fBQ.stopPlay();
                }
            }
        };
        this.fBZ = z;
        this.mFrom = str;
        this.bHq = str2;
        this.fVo = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fBC = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fVc = view.findViewById(R.id.card_container);
        this.fBD = (FrameLayout) view.findViewById(R.id.video_container);
        this.fBQ = new com.baidu.tieba.play.c(tbPageContext, this.fBD, false, com.baidu.tbadk.a.b.ly("cyber_player_test") ? 1 : 0);
        this.fBQ.pY(z);
        this.fBQ.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fVl != null && a.this.fBR.fCr.videoDuration > 8) {
                    a.this.fVl.al(a.this.mPosition, a.this.fBR.fCr.videoUrl);
                }
            }
        });
        this.fBQ.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void kY(boolean z2) {
                if (a.this.fVm != null) {
                    if (z2) {
                        a.this.fVm.ti(0);
                    } else {
                        a.this.fVm.ti(1);
                    }
                }
            }
        });
        this.fBQ.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fVb = (SpannableClickTextView) view.findViewById(R.id.title);
        this.ehx = (HeadImageView) view.findViewById(R.id.user_icon);
        this.XK = (TextView) view.findViewById(R.id.user_name);
        this.ccb = (AgreeView) view.findViewById(R.id.agree_view);
        this.ccb.setAgreeAnimationResource(R.raw.agree);
        this.ccb.setDisagreeAnimationResource(R.raw.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFZ = 2;
        dVar.bGd = 6;
        this.ccb.setStatisticData(dVar);
        this.ccc = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.ccd = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.cce = view.findViewById(R.id.thread_info_commont_container);
        this.ccg = (ImageView) view.findViewById(R.id.share_num_img);
        this.cch = view.findViewById(R.id.share_num_container);
        this.fVd = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.fVe = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.fVd.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fVe.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_download_link_url", null);
        this.fVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.ajK().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fVn = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.fVn.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.fVn.setHasAgreeToPlay(true);
                a.this.fBQ.qe(false);
                a.this.fVn.cyr();
                if (a.this.eDY.ps()) {
                    a.this.eDY.resume();
                } else if (a.this.fBR != null && a.this.fBR.fCr != null) {
                    a.this.fBQ.ct(a.this.fBR.fCr.videoUrl, a.this.fBR.threadId);
                }
            }
        });
        this.fVi = view.findViewById(R.id.video_agg_container_foreground);
        this.fVj = view.findViewById(R.id.title_and_comment_container_foreground);
        this.fVi.setOnClickListener(this);
        this.cce.setOnClickListener(this);
        this.cch.setOnClickListener(this);
        this.fVb.setOnClickListener(this);
        this.ehx.setOnClickListener(this);
        this.XK.setOnClickListener(this);
        this.fVc.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        this.fct = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBC.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fBC.setLayoutParams(layoutParams);
        this.ehx.setIsRound(true);
        this.dpp = new n(tbPageContext.getPageActivity());
        this.fBS = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.afH = new AlphaAnimation(0.0f, 0.7f);
        this.afH.setDuration(500L);
        this.afH.setAnimationListener(this.fVv);
        this.afI = new AlphaAnimation(0.7f, 0.0f);
        this.afI.setDuration(500L);
        this.afI.setAnimationListener(this.fVu);
        this.fVm = new C0330a();
        this.eDY = new com.baidu.afd.videopaster.d(getContext(), this.fBD);
        this.fVp = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ccb.onChangeSkinType(i);
        this.ccc.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.ajv().a(this.ccd, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.ajv().a(this.ccg, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fVb.setTextColor(tbPageContext.getResources().getColor(R.color.cp_cont_a));
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
        if (gVar != null && gVar.fCr != null) {
            boolean z = this.fBR == gVar;
            this.fBR = gVar;
            this.bPn = this.fBR.autoPlay;
            this.fVh = false;
            kW(false);
            this.fVb.setVisibility(0);
            if (gVar.fCr != null && !StringUtils.isNull(gVar.fCr.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fVb, gVar.title, gVar.fCr.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fVb.setText(gVar.title);
            }
            this.mWidth = l.af(this.mContext);
            if (this.mWidth != this.fct) {
                this.fBQ.ceW();
                this.fct = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.fBD.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fBD.setLayoutParams(layoutParams);
            }
            bub();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.ags() != null) {
                gVar.ags().isInThread = true;
            }
            this.ccb.setIsFromMiddlePage(true);
            this.ccb.setData(gVar.ags());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bua() {
        try {
            int parseInt = Integer.parseInt(this.fBR.fCr.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fBR.fCr.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bub() {
        if (!bua()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBC.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fBC.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fBC.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fBC.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.fCr != null) {
            this.fBQ.stopPlay();
            this.fBQ.setIsNeedRecoveryVideoPlayer(true);
            this.fBQ.qf(true);
            this.fBQ.qb(true);
            this.fBQ.qg(true);
            this.fBQ.ae(false, false);
            this.fBQ.yZ(i);
            this.fBQ.a(new c.InterfaceC0403c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pA() {
                    a.this.buf();
                    if (a.this.eDY != null) {
                        a.this.eDY.pA();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pB() {
                    a.this.bug();
                    if (a.this.fBQ.pC()) {
                    }
                    if (a.this.fBW || (a.this.eDY != null && a.this.eDY.ps())) {
                        com.baidu.adp.lib.g.e.iK().removeCallbacks(a.this.fVx);
                        com.baidu.adp.lib.g.e.iK().post(a.this.fVx);
                    }
                    if (a.this.eDY != null) {
                        a.this.eDY.pB();
                    }
                }
            });
            this.fBQ.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void bph() {
                    if (a.this.fBR != null && a.this.fBR.fCr != null && com.baidu.adp.lib.g.b.f(a.this.fBR.fCr.videoHeight, 0) > com.baidu.adp.lib.g.b.f(a.this.fBR.fCr.videoWidth, 0)) {
                        a.this.fBQ.ae(false, false);
                    } else {
                        a.this.fBQ.ae(true, false);
                    }
                    a.this.fBW = false;
                    a.this.xz(a.this.bPn ? "1" : "2");
                    a.this.onClick(a.this.fBD);
                    if (a.this.RD != null) {
                        a.this.RD.a(a.this);
                    }
                    if (a.this.fVq != null) {
                        a.this.fVq.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bpi() {
                    a.this.onClick(a.this.fBC);
                }
            });
            this.fBQ.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void ku(boolean z2) {
                    a.this.fBQ.ct(a.this.fBR.fCr.videoUrl, a.this.fBR.threadId);
                    a.this.xz("2");
                    a.this.onClick(a.this.fBD);
                }
            });
            this.fBQ.pX(false);
            if (this.fVp != null) {
                this.fVp.reset();
            }
            this.startPosition = -1L;
            this.dpp.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fBR.fCr.fCB;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.eDY.a(a.this.isFullScreen, a.this.fBQ != null && a.this.fBQ.ceC(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.eDY.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fBQ.ceC() && !com.baidu.mcn.b.uj().cJ(aVar2.RZ)) {
                        boolean z3 = a.this.startPosition >= (aVar2.fCu * 1000) + 1000;
                        if (i3 < aVar2.fCu * 1000 || i3 >= aVar2.fCv * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fVp.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aft = aVar2.fCx;
                                aVar3.afu = aVar2.fCy;
                                aVar3.afv = aVar2.RZ;
                                aVar3.afs = aVar2.fCw;
                                aVar3.fid = a.this.fBR != null ? a.this.fBR.forumId : null;
                                aVar3.tid = a.this.fBR != null ? a.this.fBR.threadId : null;
                                aVar3.afw = 3;
                                if (z3) {
                                    a.this.fVp.b(aVar3, (ViewGroup) a.this.fBQ.ceV());
                                } else {
                                    a.this.fVp.a(aVar3, (ViewGroup) a.this.fBQ.ceV());
                                }
                            }
                        } else if (a.this.fVp.isShowing()) {
                            a.this.fVp.dismiss();
                        }
                    }
                }
            });
            this.fBT = new z();
            this.fBT.bXN = gVar.threadId;
            this.fBT.eHo = gVar.forumId;
            this.fBT.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fBT.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.fBT.mSource = gVar.source;
            this.fBT.iAD = gVar.weight;
            this.fBT.iAF = this.mFrom;
            this.fBT.iAG = gVar.abtest_tag;
            this.fBT.bHq = this.bHq;
            this.fBT.eHk = gVar.extra;
            this.fBT.iAJ = "0";
            this.fBU = new z();
            this.fBU.bXN = gVar.threadId;
            this.fBU.eHo = gVar.forumId;
            this.fBU.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fBU.iAD = "auto_midpage";
            this.fBU.mLocate = "auto_midpage";
            this.fBU.iAF = this.mFrom;
            this.fBU.mSource = gVar.source;
            this.fBU.iAJ = "0";
            if (gVar.fCr != null) {
                this.fBT.iAH = gVar.fCr.videoMd5;
                this.fBU.iAH = gVar.fCr.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.bT("tid", gVar.threadId);
            anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.P("obj_locate", i);
            anVar.P("obj_param2", 1);
            anVar.bT("fid", gVar.forumId);
            anVar.bT("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.bT("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bHq);
            anVar.bT("ab_tag", aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.bT("obj_type", this.mFrom);
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aq.isEmpty(this.fBR.source) ? "0" : this.fBR.source);
            anVar.P("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.dpp.setVideoStatsData(this.fBT);
            this.fBQ.ceE().setBusiness(this.dpp);
            this.dpp.a(gVar);
            this.fBQ.bLZ();
            this.fBQ.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.eDY.a(a.this.isFullScreen, a.this.fBQ != null && a.this.fBQ.ceC(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fBW = true;
                            a.this.fVf = true;
                            a.this.fBV = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.rV(i);
                            a.this.fBQ.bzb();
                        }
                    }
                }
            });
            this.fBQ.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fBR != null && a.this.fBR.fCr != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fBR.fCr.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.eDY.reset();
            }
            this.eDY.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void pJ() {
                    a.this.fVf = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pI() {
                    if (a.this.isFullScreen) {
                        a.this.fBW = true;
                        a.this.fVf = true;
                        a.this.fBV = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.rV(i);
                        a.this.fBQ.bzb();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pH() {
                    if (a.this.fBQ != null) {
                        a.this.fBQ.yY(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean pK() {
                    return a.this.bue();
                }
            });
            this.fBQ.setThumbnail(gVar.fCr.thumbnailUrl);
            this.fBQ.setVideoUrl(gVar.fCr.videoUrl, gVar.threadId);
            this.fBQ.setFid(gVar.forumId);
            this.fBQ.bzb();
            this.fBQ.show();
            kW(false);
            if (gVar.autoPlay) {
                onClick(this.fBD);
                if (this.fVn.cgl()) {
                    this.fBQ.qd(false);
                    this.fVn.cyq();
                    this.fBQ.qe(true);
                    this.fBQ.dS(gVar.fCr.videoUrl, gVar.threadId);
                    if (this.eDY.ps()) {
                        this.eDY.stop();
                        this.eDY.px();
                    }
                } else {
                    this.fBQ.qe(false);
                    this.fBQ.qd(false);
                    this.fVn.hide();
                    if (this.eDY == null || (this.eDY != null && !this.eDY.ps())) {
                        this.fBQ.a(gVar.fCr.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.fCs) {
                    this.fVi.setVisibility(8);
                    this.fVm.ti(3);
                } else {
                    if (this.fVi.getVisibility() == 0) {
                        this.fVi.startAnimation(this.afI);
                    }
                    this.fVm.ti(0);
                }
                gVar.fCs = false;
            } else {
                this.fVi.setVisibility(0);
                this.fVn.hide();
                this.fBQ.qd(true);
                this.fVm.ti(3);
                this.fBQ.dS(gVar.fCr.videoUrl, gVar.threadId);
            }
            this.fBW = false;
            this.fVf = false;
            if (!z && this.eDY.ps()) {
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
        com.baidu.afd.videopaster.data.b yk = this.fVo != null ? this.fVo.yk(gVar.getThreadId()) : null;
        if (yk == null) {
            return null;
        }
        int pO = yk.pO();
        int pP = yk.pP();
        int pN = yk.pN();
        if (pN != -1) {
            i = pO != -1 ? (pN - pO) - 1 : -1;
            if (pP != -1) {
                i4 = (pP - pN) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.fCr != null) {
            i3 = com.baidu.adp.lib.g.b.f(gVar.fCr.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.f(gVar.fCr.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", pN + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz(String str) {
        if (this.fBR != null && this.fBR.fCr != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fBR.fCr.videoMd5, "", str, this.fBU);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fBQ.pC();
    }

    public boolean buc() {
        return this.eDY.ps();
    }

    public void bpd() {
        if (isPlaying()) {
            this.fBQ.pausePlay();
        }
    }

    public boolean rW(int i) {
        if (i == 4 && this.eDY != null && ((this.eDY.ps() || this.fVf) && this.fBQ != null)) {
            this.eDY.bc(i);
            if (this.isFullScreen) {
                if (this.eDY.pr()) {
                    this.fBQ.ceD();
                } else {
                    this.fBQ.bLU();
                }
                return true;
            }
        }
        return this.fBQ.yY(i);
    }

    public void bpe() {
        this.fVh = false;
        this.fBQ.stopPlay();
        if (this.fVb != null) {
            this.fVb.setVisibility(0);
        }
        if (this.fVm != null) {
            this.fVm.ti(2);
        }
        kW(false);
        this.fVg = true;
        if (this.eDY != null && this.eDY.ps()) {
            this.eDY.stop();
        }
    }

    public void bud() {
        this.eDY.stop();
    }

    public void bpf() {
        if (this.fBQ != null) {
            this.fBQ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bpf();
        if (this.fBS != null) {
            this.fBS.bpq();
        }
        if (this.fVi != null) {
            this.fVi.clearAnimation();
        }
        this.eDY.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.fCq != null) {
            this.XK.setText(TextUtils.isEmpty(gVar.fCq.userNickname) ? gVar.fCq.userName : gVar.fCq.userNickname);
            if (!StringUtils.isNull(gVar.fCq.portrait) && gVar.fCq.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.ehx.startLoad(gVar.fCq.portrait, 10, false);
            } else {
                this.ehx.startLoad(gVar.fCq.portrait, 12, false);
            }
            if (gVar.fCq.isBigV) {
                this.ehx.setShowV(gVar.fCq.isBigV);
                this.ehx.setIsBigV(gVar.fCq.isBigV);
            } else if (gVar.fCq.isGod) {
                this.ehx.setShowV(gVar.fCq.isGod);
                this.ehx.setIsBigV(gVar.fCq.isGod);
            } else {
                this.ehx.setShowV(gVar.fCq.isGod);
                this.ehx.setIsBigV(gVar.fCq.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.ccb.setData(gVar.ags());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.ccc.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.ajv().a(this.ccd, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.ccc.setText(aq.aO(gVar.postNum));
            } else {
                this.ccc.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fBQ != null && this.fBD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fBV) {
                this.fBQ.ceK();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                buf();
            } else {
                configuration.orientation = 1;
                bug();
                this.fBV = true;
            }
            this.fBQ.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bue() {
        if (this.fBQ != null && this.fBD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fBD.getParent() != null) {
                if (this.fBD.getParent() == frameLayout) {
                    if (this.fVr) {
                        this.fVr = false;
                        return true;
                    } else if (!this.fVs) {
                        this.fVs = true;
                        return true;
                    }
                } else if (this.fBD.getParent() == this.fBC) {
                    if (this.fVs) {
                        this.fVs = false;
                        this.fVt = true;
                        return true;
                    } else if (!this.fVr && this.fVt) {
                        this.fVr = true;
                        this.fVt = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buf() {
        if (this.fBQ != null && this.fBD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fBD.getParent() != null) {
                if (this.fBD.getParent() == frameLayout) {
                    frameLayout.removeView(this.fBD);
                } else if (this.fBD.getParent() == this.fBC) {
                    this.fBC.removeView(this.fBD);
                }
            }
            if (this.fBD.getParent() == null) {
                frameLayout.addView(this.fBD);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fBD.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fBD.setLayoutParams(layoutParams);
                if (this.fVp != null && this.fVp.isShowing()) {
                    this.fVp.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bug() {
        if (this.fBQ != null && this.fBD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fBD.getParent() != null) {
                if (this.fBD.getParent() == frameLayout) {
                    buh();
                    frameLayout.removeView(this.fBD);
                } else if (this.fBD.getParent() == this.fBC) {
                    buh();
                    this.fBC.removeView(this.fBD);
                }
            }
            if (this.fBD.getParent() == null) {
                this.fBC.addView(this.fBD, 0);
                bui();
                this.fBQ.bLZ();
                this.startPosition = -1L;
            }
        }
    }

    private void buh() {
        if (this.eDY != null && this.eDY.ps()) {
            this.eDY.ax(true);
        }
    }

    private void bui() {
        int i;
        if (!bua()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fBD.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aZU() != null) {
            view.setTag(this);
            aZU().a(view, this.fBR);
        }
        if (view == this.ehx || view == this.XK) {
            if (this.fBR != null && this.fBR.fCq != null && !TextUtils.isEmpty(this.fBR.fCq.userId)) {
                this.fVm.ti(0);
                if (!TbadkCoreApplication.isLogin() || !this.fBR.fCq.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(this.fBR.fCq.userId, 0L), z, this.fBR.fCq.isGod)));
            }
        } else if (view == this.cce) {
            if (this.fBR != null) {
                this.fVm.ti(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fBR.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fVb || view == this.fVc) {
            if (this.fBR != null) {
                if (this.fVm.getCurrentState() != 2 && this.fVm.getCurrentState() != 3) {
                    z = false;
                }
                this.fVm.ti(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fBR.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.cch) {
            this.fVm.ti(0);
            alm();
        } else if (view == this.fVi && this.fVi.getVisibility() == 0 && this.fVk != null) {
            this.fVk.tm(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kt(boolean z) {
        if (this.fBR != null && this.fBR.fCq != null) {
            this.fBR.fCq.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bpg() {
        if (this.fBR != null) {
            this.ccb.aks();
        }
    }

    public void kV(boolean z) {
        if (this.fBC != null) {
            this.fBC.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.fVq = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fVk = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.RD = fVar;
    }

    private void kW(boolean z) {
        this.fVg = this.mPosition == (this.fVl == null ? -1 : this.fVl.but());
        if (this.fVg && z && isPlaying() && this.bPn && !this.fVh) {
            this.fVd.setVisibility(0);
            this.fVh = true;
            this.fVd.postDelayed(this.fVw, 5000L);
            if (this.fVl != null) {
                this.fVl.m21do(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fVd.setVisibility(8);
        if (this.fVw != null) {
            this.fVd.removeCallbacks(this.fVw);
        }
    }

    private void alm() {
        if (this.fBR != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fBR.forumId);
            String str = this.fBR.title;
            String str2 = this.fBR.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fBR.fCr.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fBR.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = format;
            eVar.clK = str5;
            eVar.linkUrl = str3;
            eVar.extData = str2;
            eVar.clN = 3;
            eVar.fid = valueOf;
            eVar.clE = "";
            eVar.tid = str2;
            eVar.clx = true;
            eVar.clM = 0;
            eVar.clR = 2;
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
            bundle.putInt("obj_param1", eVar.clN);
            bundle.putInt("obj_type", eVar.clR);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMX);
            eVar.E(bundle);
            com.baidu.tieba.c.e.bch().a(new ShareDialogConfig(this.mContext, eVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bpe();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bpd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX(boolean z) {
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

    public void buj() {
        this.eDY.resume();
    }

    public boolean buk() {
        if (this.fVm != null) {
            return this.fVm.getCurrentState() == 2 || this.fVm.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0330a {
        private Runnable fVB;
        private int mCurrentState;

        private C0330a() {
            this.mCurrentState = -1;
            this.fVB = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(C0330a.this.fVB);
                    C0330a.this.ti(2);
                }
            };
        }

        public void ti(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = tj(i);
                    bul();
                    return;
                case 1:
                    this.mCurrentState = tj(i);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fVB);
                    return;
                case 2:
                    this.mCurrentState = tk(i);
                    return;
                case 3:
                    this.mCurrentState = tl(i);
                    bul();
                    return;
                default:
                    this.mCurrentState = tk(i);
                    return;
            }
        }

        private void bul() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fVB);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.fVB, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int tj(int i) {
            if (i != this.mCurrentState) {
                a.this.fVj.setVisibility(8);
                a.this.kX(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int tk(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fVj.setVisibility(0);
                if (i2 != 3 || a.this.fBR.autoPlay) {
                    a.this.kX(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int tl(int i) {
            if (i != this.mCurrentState) {
                a.this.fVj.setVisibility(0);
                a.this.kX(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
