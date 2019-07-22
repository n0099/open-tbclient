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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
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
    private com.baidu.tieba.lego.card.view.f RE;
    public TextView XL;
    private Animation afH;
    private Animation afI;
    private String bGR;
    private boolean bOG;
    protected AgreeView cbb;
    private TextView cbc;
    private ImageView cbd;
    private View cbe;
    private ImageView cbg;
    private View cbh;
    private n dnw;
    private com.baidu.afd.videopaster.d eCi;
    public HeadImageView efG;
    private boolean fSA;
    private View fSB;
    private View fSC;
    private c fSD;
    public com.baidu.tieba.frs.videomiddlepage.a.a fSE;
    private C0313a fSF;
    private VideoNetworkStateTipView fSG;
    private b fSH;
    private com.baidu.mcn.c fSI;
    private com.baidu.tieba.lego.card.view.g fSJ;
    private boolean fSK;
    private boolean fSL;
    private boolean fSM;
    private Animation.AnimationListener fSN;
    private Animation.AnimationListener fSO;
    private Runnable fSP;
    private Runnable fSQ;
    public SpannableClickTextView fSu;
    private View fSv;
    private FrameLayout fSw;
    private TextView fSx;
    private boolean fSy;
    private boolean fSz;
    private int faz;
    public FrameLayout fzb;
    public FrameLayout fzc;
    public com.baidu.tieba.play.c fzp;
    public com.baidu.tieba.frs.aggregation.g fzq;
    private com.baidu.tieba.frs.aggregation.h fzr;
    private z fzs;
    private z fzt;
    private boolean fzu;
    private boolean fzv;
    private boolean fzy;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fzu = true;
        this.fzy = true;
        this.fSz = false;
        this.fSA = false;
        this.fSK = false;
        this.fSL = false;
        this.fSM = false;
        this.startPosition = -1L;
        this.faz = 0;
        this.fSN = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fSB != null) {
                    a.this.fSB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fSB != null) {
                    a.this.fSB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fSO = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fSB != null) {
                    a.this.fSB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fSB != null) {
                    a.this.fSB.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fSP = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fSw.getVisibility() == 0) {
                    a.this.fSw.setVisibility(8);
                }
            }
        };
        this.fSQ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fzp != null) {
                    a.this.fzp.stopPlay();
                }
            }
        };
        this.fzy = z;
        this.mFrom = str;
        this.bGR = str2;
        this.fSH = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fzb = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fSv = view.findViewById(R.id.card_container);
        this.fzc = (FrameLayout) view.findViewById(R.id.video_container);
        this.fzp = new com.baidu.tieba.play.c(tbPageContext, (View) this.fzc, false);
        this.fzp.pU(z);
        this.fzp.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fSE != null && a.this.fzq.fzQ.videoDuration > 8) {
                    a.this.fSE.al(a.this.mPosition, a.this.fzq.fzQ.videoUrl);
                }
            }
        });
        this.fzp.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void kV(boolean z2) {
                if (a.this.fSF != null) {
                    if (z2) {
                        a.this.fSF.tc(0);
                    } else {
                        a.this.fSF.tc(1);
                    }
                }
            }
        });
        this.fzp.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fSu = (SpannableClickTextView) view.findViewById(R.id.title);
        this.efG = (HeadImageView) view.findViewById(R.id.user_icon);
        this.XL = (TextView) view.findViewById(R.id.user_name);
        this.cbb = (AgreeView) view.findViewById(R.id.agree_view);
        this.cbb.setAgreeAnimationResource(R.raw.agree);
        this.cbb.setDisagreeAnimationResource(R.raw.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFA = 2;
        dVar.bFE = 6;
        this.cbb.setStatisticData(dVar);
        this.cbc = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.cbd = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.cbe = view.findViewById(R.id.thread_info_commont_container);
        this.cbg = (ImageView) view.findViewById(R.id.share_num_img);
        this.cbh = view.findViewById(R.id.share_num_container);
        this.fSw = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.fSx = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.fSw.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fSx.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_download_link_url", null);
        this.fSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bb.ajC().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fSG = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.fSG.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.fSG.setHasAgreeToPlay(true);
                a.this.fzp.qa(false);
                a.this.fSG.cxh();
                if (a.this.eCi.pr()) {
                    a.this.eCi.resume();
                } else if (a.this.fzq != null && a.this.fzq.fzQ != null) {
                    a.this.fzp.cs(a.this.fzq.fzQ.videoUrl, a.this.fzq.threadId);
                }
            }
        });
        this.fSB = view.findViewById(R.id.video_agg_container_foreground);
        this.fSC = view.findViewById(R.id.title_and_comment_container_foreground);
        this.fSB.setOnClickListener(this);
        this.cbe.setOnClickListener(this);
        this.cbh.setOnClickListener(this);
        this.fSu.setOnClickListener(this);
        this.efG.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.fSv.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        this.faz = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzb.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fzb.setLayoutParams(layoutParams);
        this.efG.setIsRound(true);
        this.dnw = new n(tbPageContext.getPageActivity());
        this.fzr = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.afH = new AlphaAnimation(0.0f, 0.7f);
        this.afH.setDuration(500L);
        this.afH.setAnimationListener(this.fSO);
        this.afI = new AlphaAnimation(0.7f, 0.0f);
        this.afI.setDuration(500L);
        this.afI.setAnimationListener(this.fSN);
        this.fSF = new C0313a();
        this.eCi = new com.baidu.afd.videopaster.d(getContext(), this.fzc);
        this.fSI = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.cbb.onChangeSkinType(i);
        this.cbc.setTextColor(tbPageContext.getResources().getColor(R.color.cp_cont_d));
        this.cbd.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_comment_background));
        this.cbg.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_share_background));
        this.fSu.setTextColor(tbPageContext.getResources().getColor(R.color.cp_btn_a));
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
        if (gVar != null && gVar.fzQ != null) {
            boolean z = this.fzq == gVar;
            this.fzq = gVar;
            this.bOG = this.fzq.autoPlay;
            this.fSA = false;
            kT(false);
            this.fSu.setVisibility(0);
            if (gVar.fzQ != null && !StringUtils.isNull(gVar.fzQ.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fSu, gVar.title, gVar.fzQ.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fSu.setText(gVar.title);
            }
            this.mWidth = l.af(this.mContext);
            if (this.mWidth != this.faz) {
                this.fzp.cdP();
                this.faz = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.fzc.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fzc.setLayoutParams(layoutParams);
            }
            bta();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.agn() != null) {
                gVar.agn().isInThread = true;
            }
            this.cbb.setIsFromMiddlePage(true);
            this.cbb.setData(gVar.agn());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bsZ() {
        try {
            int parseInt = Integer.parseInt(this.fzq.fzQ.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fzq.fzQ.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bta() {
        if (!bsZ()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzb.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fzb.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzb.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fzb.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.fzQ != null) {
            this.fzp.stopPlay();
            this.fzp.setIsNeedRecoveryVideoPlayer(true);
            this.fzp.qb(true);
            this.fzp.pX(true);
            this.fzp.qc(true);
            this.fzp.ag(false, false);
            this.fzp.yU(i);
            this.fzp.a(new c.InterfaceC0386c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pz() {
                    a.this.bte();
                    if (a.this.eCi != null) {
                        a.this.eCi.pz();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pA() {
                    a.this.btf();
                    if (a.this.fzp.pB()) {
                    }
                    if (a.this.fzv || (a.this.eCi != null && a.this.eCi.pr())) {
                        com.baidu.adp.lib.g.e.iK().removeCallbacks(a.this.fSQ);
                        com.baidu.adp.lib.g.e.iK().post(a.this.fSQ);
                    }
                    if (a.this.eCi != null) {
                        a.this.eCi.pA();
                    }
                }
            });
            this.fzp.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void boj() {
                    if (a.this.fzq != null && a.this.fzq.fzQ != null && com.baidu.adp.lib.g.b.f(a.this.fzq.fzQ.videoHeight, 0) > com.baidu.adp.lib.g.b.f(a.this.fzq.fzQ.videoWidth, 0)) {
                        a.this.fzp.ag(false, false);
                    } else {
                        a.this.fzp.ag(true, false);
                    }
                    a.this.fzv = false;
                    a.this.wZ(a.this.bOG ? "1" : "2");
                    a.this.onClick(a.this.fzc);
                    if (a.this.RE != null) {
                        a.this.RE.a(a.this);
                    }
                    if (a.this.fSJ != null) {
                        a.this.fSJ.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bok() {
                    a.this.onClick(a.this.fzb);
                }
            });
            this.fzp.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void kr(boolean z2) {
                    a.this.fzp.cs(a.this.fzq.fzQ.videoUrl, a.this.fzq.threadId);
                    a.this.wZ("2");
                    a.this.onClick(a.this.fzc);
                }
            });
            this.fzp.pT(false);
            if (this.fSI != null) {
                this.fSI.reset();
            }
            this.startPosition = -1L;
            this.dnw.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fzq.fzQ.fAa;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.eCi.a(a.this.isFullScreen, a.this.fzp != null && a.this.fzp.cdv(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.eCi.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fzp.cdv() && !com.baidu.mcn.b.uj().cJ(aVar2.Sa)) {
                        boolean z3 = a.this.startPosition >= (aVar2.fzT * 1000) + 1000;
                        if (i3 < aVar2.fzT * 1000 || i3 >= aVar2.fzU * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fSI.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aft = aVar2.fzW;
                                aVar3.afu = aVar2.fzX;
                                aVar3.afv = aVar2.Sa;
                                aVar3.afs = aVar2.fzV;
                                aVar3.fid = a.this.fzq != null ? a.this.fzq.forumId : null;
                                aVar3.tid = a.this.fzq != null ? a.this.fzq.threadId : null;
                                aVar3.afw = 3;
                                if (z3) {
                                    a.this.fSI.b(aVar3, (ViewGroup) a.this.fzp.cdO());
                                } else {
                                    a.this.fSI.a(aVar3, (ViewGroup) a.this.fzp.cdO());
                                }
                            }
                        } else if (a.this.fSI.isShowing()) {
                            a.this.fSI.dismiss();
                        }
                    }
                }
            });
            this.fzs = new z();
            this.fzs.bWO = gVar.threadId;
            this.fzs.eFy = gVar.forumId;
            this.fzs.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fzs.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.fzs.mSource = gVar.source;
            this.fzs.ixy = gVar.weight;
            this.fzs.ixA = this.mFrom;
            this.fzs.ixB = gVar.abtest_tag;
            this.fzs.bGR = this.bGR;
            this.fzs.eFu = gVar.extra;
            this.fzs.ixE = "0";
            this.fzt = new z();
            this.fzt.bWO = gVar.threadId;
            this.fzt.eFy = gVar.forumId;
            this.fzt.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fzt.ixy = "auto_midpage";
            this.fzt.mLocate = "auto_midpage";
            this.fzt.ixA = this.mFrom;
            this.fzt.mSource = gVar.source;
            this.fzt.ixE = "0";
            if (gVar.fzQ != null) {
                this.fzs.ixC = gVar.fzQ.videoMd5;
                this.fzt.ixC = gVar.fzQ.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.bT("tid", gVar.threadId);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.P("obj_locate", i);
            anVar.P("obj_param2", 1);
            anVar.bT("fid", gVar.forumId);
            anVar.bT("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.bT("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bGR);
            anVar.bT("ab_tag", aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.bT("obj_type", this.mFrom);
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aq.isEmpty(this.fzq.source) ? "0" : this.fzq.source);
            anVar.P("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.dnw.setVideoStatsData(this.fzs);
            this.fzp.getVideoView().setBusiness(this.dnw);
            this.dnw.a(gVar);
            this.fzp.bKY();
            this.fzp.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.eCi.a(a.this.isFullScreen, a.this.fzp != null && a.this.fzp.cdv(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fzv = true;
                            a.this.fSy = true;
                            a.this.fzu = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.rQ(i);
                            a.this.fzp.bxZ();
                        }
                    }
                }
            });
            this.fzp.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fzq != null && a.this.fzq.fzQ != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fzq.fzQ.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.eCi.reset();
            }
            this.eCi.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void pI() {
                    a.this.fSy = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pH() {
                    if (a.this.isFullScreen) {
                        a.this.fzv = true;
                        a.this.fSy = true;
                        a.this.fzu = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.rQ(i);
                        a.this.fzp.bxZ();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pG() {
                    if (a.this.fzp != null) {
                        a.this.fzp.yT(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean pJ() {
                    return a.this.btd();
                }
            });
            this.fzp.setThumbnail(gVar.fzQ.thumbnailUrl);
            this.fzp.setVideoUrl(gVar.fzQ.videoUrl, gVar.threadId);
            this.fzp.setFid(gVar.forumId);
            this.fzp.bxZ();
            this.fzp.show();
            kT(false);
            if (gVar.autoPlay) {
                onClick(this.fzc);
                if (this.fSG.cff()) {
                    this.fzp.pZ(false);
                    this.fSG.cxg();
                    this.fzp.qa(true);
                    this.fzp.dQ(gVar.fzQ.videoUrl, gVar.threadId);
                    if (this.eCi.pr()) {
                        this.eCi.stop();
                        this.eCi.pw();
                    }
                } else {
                    this.fzp.qa(false);
                    this.fzp.pZ(false);
                    this.fSG.hide();
                    if (this.eCi == null || (this.eCi != null && !this.eCi.pr())) {
                        this.fzp.a(gVar.fzQ.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.fzR) {
                    this.fSB.setVisibility(8);
                    this.fSF.tc(3);
                } else {
                    if (this.fSB.getVisibility() == 0) {
                        this.fSB.startAnimation(this.afI);
                    }
                    this.fSF.tc(0);
                }
                gVar.fzR = false;
            } else {
                this.fSB.setVisibility(0);
                this.fSG.hide();
                this.fzp.pZ(true);
                this.fSF.tc(3);
                this.fzp.dQ(gVar.fzQ.videoUrl, gVar.threadId);
            }
            this.fzv = false;
            this.fSy = false;
            if (!z && this.eCi.pr()) {
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
        com.baidu.afd.videopaster.data.b xK = this.fSH != null ? this.fSH.xK(gVar.getThreadId()) : null;
        if (xK == null) {
            return null;
        }
        int pN = xK.pN();
        int pO = xK.pO();
        int pM = xK.pM();
        if (pM != -1) {
            i = pN != -1 ? (pM - pN) - 1 : -1;
            if (pO != -1) {
                i4 = (pO - pM) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.fzQ != null) {
            i3 = com.baidu.adp.lib.g.b.f(gVar.fzQ.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.f(gVar.fzQ.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", pM + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(String str) {
        if (this.fzq != null && this.fzq.fzQ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fzq.fzQ.videoMd5, "", str, this.fzt);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fzp.pB();
    }

    public boolean btb() {
        return this.eCi.pr();
    }

    public void bof() {
        if (isPlaying()) {
            this.fzp.pausePlay();
        }
    }

    public boolean rR(int i) {
        if (i == 4 && this.eCi != null && ((this.eCi.pr() || this.fSy) && this.fzp != null)) {
            this.eCi.bc(i);
            if (this.isFullScreen) {
                if (this.eCi.pq()) {
                    this.fzp.cdw();
                } else {
                    this.fzp.bKT();
                }
                return true;
            }
        }
        return this.fzp.yT(i);
    }

    public void bog() {
        this.fSA = false;
        this.fzp.stopPlay();
        if (this.fSu != null) {
            this.fSu.setVisibility(0);
        }
        if (this.fSF != null) {
            this.fSF.tc(2);
        }
        kT(false);
        this.fSz = true;
        if (this.eCi != null && this.eCi.pr()) {
            this.eCi.stop();
        }
    }

    public void btc() {
        this.eCi.stop();
    }

    public void boh() {
        if (this.fzp != null) {
            this.fzp.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        boh();
        if (this.fzr != null) {
            this.fzr.bos();
        }
        if (this.fSB != null) {
            this.fSB.clearAnimation();
        }
        this.eCi.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.fzP != null) {
            this.XL.setText(TextUtils.isEmpty(gVar.fzP.userNickname) ? gVar.fzP.userName : gVar.fzP.userNickname);
            if (!StringUtils.isNull(gVar.fzP.portrait) && gVar.fzP.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.efG.startLoad(gVar.fzP.portrait, 10, false);
            } else {
                this.efG.startLoad(gVar.fzP.portrait, 12, false);
            }
            if (gVar.fzP.isBigV) {
                this.efG.setShowV(gVar.fzP.isBigV);
                this.efG.setIsBigV(gVar.fzP.isBigV);
            } else if (gVar.fzP.isGod) {
                this.efG.setShowV(gVar.fzP.isGod);
                this.efG.setIsBigV(gVar.fzP.isGod);
            } else {
                this.efG.setShowV(gVar.fzP.isGod);
                this.efG.setIsBigV(gVar.fzP.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cbb.setData(gVar.agn());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cbc.setTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
            this.cbd.setImageDrawable(getContext().getResources().getDrawable(R.drawable.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.cbc.setText(aq.aO(gVar.postNum));
            } else {
                this.cbc.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fzp != null && this.fzc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fzu) {
                this.fzp.cdC();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bte();
            } else {
                configuration.orientation = 1;
                btf();
                this.fzu = true;
            }
            this.fzp.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btd() {
        if (this.fzp != null && this.fzc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fzc.getParent() != null) {
                if (this.fzc.getParent() == frameLayout) {
                    if (this.fSK) {
                        this.fSK = false;
                        return true;
                    } else if (!this.fSL) {
                        this.fSL = true;
                        return true;
                    }
                } else if (this.fzc.getParent() == this.fzb) {
                    if (this.fSL) {
                        this.fSL = false;
                        this.fSM = true;
                        return true;
                    } else if (!this.fSK && this.fSM) {
                        this.fSK = true;
                        this.fSM = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bte() {
        if (this.fzp != null && this.fzc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fzc.getParent() != null) {
                if (this.fzc.getParent() == frameLayout) {
                    frameLayout.removeView(this.fzc);
                } else if (this.fzc.getParent() == this.fzb) {
                    this.fzb.removeView(this.fzc);
                }
            }
            if (this.fzc.getParent() == null) {
                frameLayout.addView(this.fzc);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fzc.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fzc.setLayoutParams(layoutParams);
                if (this.fSI != null && this.fSI.isShowing()) {
                    this.fSI.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btf() {
        if (this.fzp != null && this.fzc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fzc.getParent() != null) {
                if (this.fzc.getParent() == frameLayout) {
                    btg();
                    frameLayout.removeView(this.fzc);
                } else if (this.fzc.getParent() == this.fzb) {
                    btg();
                    this.fzb.removeView(this.fzc);
                }
            }
            if (this.fzc.getParent() == null) {
                this.fzb.addView(this.fzc, 0);
                bth();
                this.fzp.bKY();
                this.startPosition = -1L;
            }
        }
    }

    private void btg() {
        if (this.eCi != null && this.eCi.pr()) {
            this.eCi.ax(true);
        }
    }

    private void bth() {
        int i;
        if (!bsZ()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fzc.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aZo() != null) {
            view.setTag(this);
            aZo().a(view, this.fzq);
        }
        if (view == this.efG || view == this.XL) {
            if (this.fzq != null && this.fzq.fzP != null && !TextUtils.isEmpty(this.fzq.fzP.userId)) {
                this.fSF.tc(0);
                if (!TbadkCoreApplication.isLogin() || !this.fzq.fzP.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fzq.fzP.userId, 0L), z, this.fzq.fzP.isGod)));
            }
        } else if (view == this.cbe) {
            if (this.fzq != null) {
                this.fSF.tc(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fzq.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fSu || view == this.fSv) {
            if (this.fzq != null) {
                if (this.fSF.getCurrentState() != 2 && this.fSF.getCurrentState() != 3) {
                    z = false;
                }
                this.fSF.tc(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fzq.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.cbh) {
            this.fSF.tc(0);
            akY();
        } else if (view == this.fSB && this.fSB.getVisibility() == 0 && this.fSD != null) {
            this.fSD.tg(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kq(boolean z) {
        if (this.fzq != null && this.fzq.fzP != null) {
            this.fzq.fzP.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void boi() {
        if (this.fzq != null) {
            this.cbb.ake();
        }
    }

    public void kS(boolean z) {
        if (this.fzb != null) {
            this.fzb.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.fSJ = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fSD = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.RE = fVar;
    }

    private void kT(boolean z) {
        this.fSz = this.mPosition == (this.fSE == null ? -1 : this.fSE.bts());
        if (this.fSz && z && isPlaying() && this.bOG && !this.fSA) {
            this.fSw.setVisibility(0);
            this.fSA = true;
            this.fSw.postDelayed(this.fSP, 5000L);
            if (this.fSE != null) {
                this.fSE.dl(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fSw.setVisibility(8);
        if (this.fSP != null) {
            this.fSw.removeCallbacks(this.fSP);
        }
    }

    private void akY() {
        if (this.fzq != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fzq.forumId);
            String str = this.fzq.title;
            String str2 = this.fzq.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fzq.fzQ.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fzq.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = format;
            eVar.ckI = str5;
            eVar.linkUrl = str3;
            eVar.extData = str2;
            eVar.ckL = 3;
            eVar.fid = valueOf;
            eVar.ckC = "";
            eVar.tid = str2;
            eVar.ckv = true;
            eVar.ckK = 0;
            eVar.ckP = 2;
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
            bundle.putInt("obj_param1", eVar.ckL);
            bundle.putInt("obj_type", eVar.ckP);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMt);
            eVar.E(bundle);
            com.baidu.tieba.c.e.bbB().a(new ShareDialogConfig(this.mContext, eVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bog();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bof();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(boolean z) {
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

    public void bti() {
        this.eCi.resume();
    }

    public boolean btj() {
        if (this.fSF != null) {
            return this.fSF.getCurrentState() == 2 || this.fSF.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0313a {
        private Runnable fSU;
        private int mCurrentState;

        private C0313a() {
            this.mCurrentState = -1;
            this.fSU = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(C0313a.this.fSU);
                    C0313a.this.tc(2);
                }
            };
        }

        public void tc(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = td(i);
                    btk();
                    return;
                case 1:
                    this.mCurrentState = td(i);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fSU);
                    return;
                case 2:
                    this.mCurrentState = te(i);
                    return;
                case 3:
                    this.mCurrentState = tf(i);
                    btk();
                    return;
                default:
                    this.mCurrentState = te(i);
                    return;
            }
        }

        private void btk() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fSU);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.fSU, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int td(int i) {
            if (i != this.mCurrentState) {
                a.this.fSC.setVisibility(8);
                a.this.kU(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int te(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fSC.setVisibility(0);
                if (i2 != 3 || a.this.fzq.autoPlay) {
                    a.this.kU(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int tf(int i) {
            if (i != this.mCurrentState) {
                a.this.fSC.setVisibility(0);
                a.this.kU(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
