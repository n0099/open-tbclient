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
    private String bGS;
    private boolean bOM;
    protected AgreeView cbi;
    private TextView cbj;
    private ImageView cbk;
    private View cbl;
    private ImageView cbn;
    private View cbo;
    private n dnD;
    private com.baidu.afd.videopaster.d eCp;
    public HeadImageView efN;
    public com.baidu.tieba.play.c fAd;
    public com.baidu.tieba.frs.aggregation.g fAe;
    private com.baidu.tieba.frs.aggregation.h fAf;
    private z fAg;
    private z fAh;
    private boolean fAi;
    private boolean fAj;
    private boolean fAm;
    private boolean fTA;
    private boolean fTB;
    private boolean fTC;
    private Animation.AnimationListener fTD;
    private Animation.AnimationListener fTE;
    private Runnable fTF;
    private Runnable fTG;
    public SpannableClickTextView fTk;
    private View fTl;
    private FrameLayout fTm;
    private TextView fTn;
    private boolean fTo;
    private boolean fTp;
    private boolean fTq;
    private View fTr;
    private View fTs;
    private c fTt;
    public com.baidu.tieba.frs.videomiddlepage.a.a fTu;
    private C0319a fTv;
    private VideoNetworkStateTipView fTw;
    private b fTx;
    private com.baidu.mcn.c fTy;
    private com.baidu.tieba.lego.card.view.g fTz;
    private int faN;
    public FrameLayout fzP;
    public FrameLayout fzQ;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fAi = true;
        this.fAm = true;
        this.fTp = false;
        this.fTq = false;
        this.fTA = false;
        this.fTB = false;
        this.fTC = false;
        this.startPosition = -1L;
        this.faN = 0;
        this.fTD = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fTr != null) {
                    a.this.fTr.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fTr != null) {
                    a.this.fTr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fTE = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fTr != null) {
                    a.this.fTr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fTr != null) {
                    a.this.fTr.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fTF = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fTm.getVisibility() == 0) {
                    a.this.fTm.setVisibility(8);
                }
            }
        };
        this.fTG = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fAd != null) {
                    a.this.fAd.stopPlay();
                }
            }
        };
        this.fAm = z;
        this.mFrom = str;
        this.bGS = str2;
        this.fTx = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fzP = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fTl = view.findViewById(R.id.card_container);
        this.fzQ = (FrameLayout) view.findViewById(R.id.video_container);
        this.fAd = new com.baidu.tieba.play.c(tbPageContext, (View) this.fzQ, false);
        this.fAd.pV(z);
        this.fAd.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fTu != null && a.this.fAe.fAE.videoDuration > 8) {
                    a.this.fTu.al(a.this.mPosition, a.this.fAe.fAE.videoUrl);
                }
            }
        });
        this.fAd.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void kV(boolean z2) {
                if (a.this.fTv != null) {
                    if (z2) {
                        a.this.fTv.te(0);
                    } else {
                        a.this.fTv.te(1);
                    }
                }
            }
        });
        this.fAd.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fTk = (SpannableClickTextView) view.findViewById(R.id.title);
        this.efN = (HeadImageView) view.findViewById(R.id.user_icon);
        this.XL = (TextView) view.findViewById(R.id.user_name);
        this.cbi = (AgreeView) view.findViewById(R.id.agree_view);
        this.cbi.setAgreeAnimationResource(R.raw.agree);
        this.cbi.setDisagreeAnimationResource(R.raw.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFB = 2;
        dVar.bFF = 6;
        this.cbi.setStatisticData(dVar);
        this.cbj = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.cbk = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.cbl = view.findViewById(R.id.thread_info_commont_container);
        this.cbn = (ImageView) view.findViewById(R.id.share_num_img);
        this.cbo = view.findViewById(R.id.share_num_container);
        this.fTm = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.fTn = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.fTm.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fTn.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_download_link_url", null);
        this.fTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bb.ajE().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fTw = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.fTw.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.fTw.setHasAgreeToPlay(true);
                a.this.fAd.qb(false);
                a.this.fTw.cxD();
                if (a.this.eCp.pr()) {
                    a.this.eCp.resume();
                } else if (a.this.fAe != null && a.this.fAe.fAE != null) {
                    a.this.fAd.cs(a.this.fAe.fAE.videoUrl, a.this.fAe.threadId);
                }
            }
        });
        this.fTr = view.findViewById(R.id.video_agg_container_foreground);
        this.fTs = view.findViewById(R.id.title_and_comment_container_foreground);
        this.fTr.setOnClickListener(this);
        this.cbl.setOnClickListener(this);
        this.cbo.setOnClickListener(this);
        this.fTk.setOnClickListener(this);
        this.efN.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.fTl.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        this.faN = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fzP.setLayoutParams(layoutParams);
        this.efN.setIsRound(true);
        this.dnD = new n(tbPageContext.getPageActivity());
        this.fAf = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.afH = new AlphaAnimation(0.0f, 0.7f);
        this.afH.setDuration(500L);
        this.afH.setAnimationListener(this.fTE);
        this.afI = new AlphaAnimation(0.7f, 0.0f);
        this.afI.setDuration(500L);
        this.afI.setAnimationListener(this.fTD);
        this.fTv = new C0319a();
        this.eCp = new com.baidu.afd.videopaster.d(getContext(), this.fzQ);
        this.fTy = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.cbi.onChangeSkinType(i);
        this.cbj.setTextColor(tbPageContext.getResources().getColor(R.color.cp_cont_d));
        this.cbk.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_comment_background));
        this.cbn.setImageDrawable(tbPageContext.getResources().getDrawable(R.drawable.video_share_background));
        this.fTk.setTextColor(tbPageContext.getResources().getColor(R.color.cp_btn_a));
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
        if (gVar != null && gVar.fAE != null) {
            boolean z = this.fAe == gVar;
            this.fAe = gVar;
            this.bOM = this.fAe.autoPlay;
            this.fTq = false;
            kT(false);
            this.fTk.setVisibility(0);
            if (gVar.fAE != null && !StringUtils.isNull(gVar.fAE.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fTk, gVar.title, gVar.fAE.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fTk.setText(gVar.title);
            }
            this.mWidth = l.af(this.mContext);
            if (this.mWidth != this.faN) {
                this.fAd.ceh();
                this.faN = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.fzQ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fzQ.setLayoutParams(layoutParams);
            }
            btn();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.ago() != null) {
                gVar.ago().isInThread = true;
            }
            this.cbi.setIsFromMiddlePage(true);
            this.cbi.setData(gVar.ago());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean btm() {
        try {
            int parseInt = Integer.parseInt(this.fAe.fAE.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fAe.fAE.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void btn() {
        if (!btm()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fzP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fzP.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.fAE != null) {
            this.fAd.stopPlay();
            this.fAd.setIsNeedRecoveryVideoPlayer(true);
            this.fAd.qc(true);
            this.fAd.pY(true);
            this.fAd.qd(true);
            this.fAd.ag(false, false);
            this.fAd.yW(i);
            this.fAd.a(new c.InterfaceC0392c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pz() {
                    a.this.btr();
                    if (a.this.eCp != null) {
                        a.this.eCp.pz();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pA() {
                    a.this.bts();
                    if (a.this.fAd.pB()) {
                    }
                    if (a.this.fAj || (a.this.eCp != null && a.this.eCp.pr())) {
                        com.baidu.adp.lib.g.e.iK().removeCallbacks(a.this.fTG);
                        com.baidu.adp.lib.g.e.iK().post(a.this.fTG);
                    }
                    if (a.this.eCp != null) {
                        a.this.eCp.pA();
                    }
                }
            });
            this.fAd.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void bow() {
                    if (a.this.fAe != null && a.this.fAe.fAE != null && com.baidu.adp.lib.g.b.f(a.this.fAe.fAE.videoHeight, 0) > com.baidu.adp.lib.g.b.f(a.this.fAe.fAE.videoWidth, 0)) {
                        a.this.fAd.ag(false, false);
                    } else {
                        a.this.fAd.ag(true, false);
                    }
                    a.this.fAj = false;
                    a.this.xa(a.this.bOM ? "1" : "2");
                    a.this.onClick(a.this.fzQ);
                    if (a.this.RE != null) {
                        a.this.RE.a(a.this);
                    }
                    if (a.this.fTz != null) {
                        a.this.fTz.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void box() {
                    a.this.onClick(a.this.fzP);
                }
            });
            this.fAd.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void kr(boolean z2) {
                    a.this.fAd.cs(a.this.fAe.fAE.videoUrl, a.this.fAe.threadId);
                    a.this.xa("2");
                    a.this.onClick(a.this.fzQ);
                }
            });
            this.fAd.pU(false);
            if (this.fTy != null) {
                this.fTy.reset();
            }
            this.startPosition = -1L;
            this.dnD.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fAe.fAE.fAO;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.eCp.a(a.this.isFullScreen, a.this.fAd != null && a.this.fAd.cdN(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.eCp.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fAd.cdN() && !com.baidu.mcn.b.uj().cJ(aVar2.Sa)) {
                        boolean z3 = a.this.startPosition >= (aVar2.fAH * 1000) + 1000;
                        if (i3 < aVar2.fAH * 1000 || i3 >= aVar2.fAI * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fTy.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aft = aVar2.fAK;
                                aVar3.afu = aVar2.fAL;
                                aVar3.afv = aVar2.Sa;
                                aVar3.afs = aVar2.fAJ;
                                aVar3.fid = a.this.fAe != null ? a.this.fAe.forumId : null;
                                aVar3.tid = a.this.fAe != null ? a.this.fAe.threadId : null;
                                aVar3.afw = 3;
                                if (z3) {
                                    a.this.fTy.b(aVar3, (ViewGroup) a.this.fAd.ceg());
                                } else {
                                    a.this.fTy.a(aVar3, (ViewGroup) a.this.fAd.ceg());
                                }
                            }
                        } else if (a.this.fTy.isShowing()) {
                            a.this.fTy.dismiss();
                        }
                    }
                }
            });
            this.fAg = new z();
            this.fAg.bWU = gVar.threadId;
            this.fAg.eFF = gVar.forumId;
            this.fAg.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fAg.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.fAg.mSource = gVar.source;
            this.fAg.iyB = gVar.weight;
            this.fAg.iyD = this.mFrom;
            this.fAg.iyE = gVar.abtest_tag;
            this.fAg.bGS = this.bGS;
            this.fAg.eFB = gVar.extra;
            this.fAg.iyH = "0";
            this.fAh = new z();
            this.fAh.bWU = gVar.threadId;
            this.fAh.eFF = gVar.forumId;
            this.fAh.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fAh.iyB = "auto_midpage";
            this.fAh.mLocate = "auto_midpage";
            this.fAh.iyD = this.mFrom;
            this.fAh.mSource = gVar.source;
            this.fAh.iyH = "0";
            if (gVar.fAE != null) {
                this.fAg.iyF = gVar.fAE.videoMd5;
                this.fAh.iyF = gVar.fAE.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.bT("tid", gVar.threadId);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.P("obj_locate", i);
            anVar.P("obj_param2", 1);
            anVar.bT("fid", gVar.forumId);
            anVar.bT("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.bT("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bGS);
            anVar.bT("ab_tag", aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.bT("obj_type", this.mFrom);
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aq.isEmpty(this.fAe.source) ? "0" : this.fAe.source);
            anVar.P("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.dnD.setVideoStatsData(this.fAg);
            this.fAd.getVideoView().setBusiness(this.dnD);
            this.dnD.a(gVar);
            this.fAd.bLm();
            this.fAd.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.eCp.a(a.this.isFullScreen, a.this.fAd != null && a.this.fAd.cdN(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fAj = true;
                            a.this.fTo = true;
                            a.this.fAi = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.rS(i);
                            a.this.fAd.byn();
                        }
                    }
                }
            });
            this.fAd.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fAe != null && a.this.fAe.fAE != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fAe.fAE.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.eCp.reset();
            }
            this.eCp.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void pI() {
                    a.this.fTo = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pH() {
                    if (a.this.isFullScreen) {
                        a.this.fAj = true;
                        a.this.fTo = true;
                        a.this.fAi = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.rS(i);
                        a.this.fAd.byn();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pG() {
                    if (a.this.fAd != null) {
                        a.this.fAd.yV(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean pJ() {
                    return a.this.btq();
                }
            });
            this.fAd.setThumbnail(gVar.fAE.thumbnailUrl);
            this.fAd.setVideoUrl(gVar.fAE.videoUrl, gVar.threadId);
            this.fAd.setFid(gVar.forumId);
            this.fAd.byn();
            this.fAd.show();
            kT(false);
            if (gVar.autoPlay) {
                onClick(this.fzQ);
                if (this.fTw.cfx()) {
                    this.fAd.qa(false);
                    this.fTw.cxC();
                    this.fAd.qb(true);
                    this.fAd.dQ(gVar.fAE.videoUrl, gVar.threadId);
                    if (this.eCp.pr()) {
                        this.eCp.stop();
                        this.eCp.pw();
                    }
                } else {
                    this.fAd.qb(false);
                    this.fAd.qa(false);
                    this.fTw.hide();
                    if (this.eCp == null || (this.eCp != null && !this.eCp.pr())) {
                        this.fAd.a(gVar.fAE.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.fAF) {
                    this.fTr.setVisibility(8);
                    this.fTv.te(3);
                } else {
                    if (this.fTr.getVisibility() == 0) {
                        this.fTr.startAnimation(this.afI);
                    }
                    this.fTv.te(0);
                }
                gVar.fAF = false;
            } else {
                this.fTr.setVisibility(0);
                this.fTw.hide();
                this.fAd.qa(true);
                this.fTv.te(3);
                this.fAd.dQ(gVar.fAE.videoUrl, gVar.threadId);
            }
            this.fAj = false;
            this.fTo = false;
            if (!z && this.eCp.pr()) {
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
        com.baidu.afd.videopaster.data.b xL = this.fTx != null ? this.fTx.xL(gVar.getThreadId()) : null;
        if (xL == null) {
            return null;
        }
        int pN = xL.pN();
        int pO = xL.pO();
        int pM = xL.pM();
        if (pM != -1) {
            i = pN != -1 ? (pM - pN) - 1 : -1;
            if (pO != -1) {
                i4 = (pO - pM) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.fAE != null) {
            i3 = com.baidu.adp.lib.g.b.f(gVar.fAE.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.f(gVar.fAE.videoHeight, 0);
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
    public void xa(String str) {
        if (this.fAe != null && this.fAe.fAE != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fAe.fAE.videoMd5, "", str, this.fAh);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fAd.pB();
    }

    public boolean bto() {
        return this.eCp.pr();
    }

    public void bos() {
        if (isPlaying()) {
            this.fAd.pausePlay();
        }
    }

    public boolean rT(int i) {
        if (i == 4 && this.eCp != null && ((this.eCp.pr() || this.fTo) && this.fAd != null)) {
            this.eCp.bc(i);
            if (this.isFullScreen) {
                if (this.eCp.pq()) {
                    this.fAd.cdO();
                } else {
                    this.fAd.bLh();
                }
                return true;
            }
        }
        return this.fAd.yV(i);
    }

    public void bot() {
        this.fTq = false;
        this.fAd.stopPlay();
        if (this.fTk != null) {
            this.fTk.setVisibility(0);
        }
        if (this.fTv != null) {
            this.fTv.te(2);
        }
        kT(false);
        this.fTp = true;
        if (this.eCp != null && this.eCp.pr()) {
            this.eCp.stop();
        }
    }

    public void btp() {
        this.eCp.stop();
    }

    public void bou() {
        if (this.fAd != null) {
            this.fAd.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bou();
        if (this.fAf != null) {
            this.fAf.boF();
        }
        if (this.fTr != null) {
            this.fTr.clearAnimation();
        }
        this.eCp.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.fAD != null) {
            this.XL.setText(TextUtils.isEmpty(gVar.fAD.userNickname) ? gVar.fAD.userName : gVar.fAD.userNickname);
            if (!StringUtils.isNull(gVar.fAD.portrait) && gVar.fAD.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.efN.startLoad(gVar.fAD.portrait, 10, false);
            } else {
                this.efN.startLoad(gVar.fAD.portrait, 12, false);
            }
            if (gVar.fAD.isBigV) {
                this.efN.setShowV(gVar.fAD.isBigV);
                this.efN.setIsBigV(gVar.fAD.isBigV);
            } else if (gVar.fAD.isGod) {
                this.efN.setShowV(gVar.fAD.isGod);
                this.efN.setIsBigV(gVar.fAD.isGod);
            } else {
                this.efN.setShowV(gVar.fAD.isGod);
                this.efN.setIsBigV(gVar.fAD.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cbi.setData(gVar.ago());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cbj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
            this.cbk.setImageDrawable(getContext().getResources().getDrawable(R.drawable.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.cbj.setText(aq.aO(gVar.postNum));
            } else {
                this.cbj.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fAd != null && this.fzQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fAi) {
                this.fAd.cdU();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                btr();
            } else {
                configuration.orientation = 1;
                bts();
                this.fAi = true;
            }
            this.fAd.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btq() {
        if (this.fAd != null && this.fzQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fzQ.getParent() != null) {
                if (this.fzQ.getParent() == frameLayout) {
                    if (this.fTA) {
                        this.fTA = false;
                        return true;
                    } else if (!this.fTB) {
                        this.fTB = true;
                        return true;
                    }
                } else if (this.fzQ.getParent() == this.fzP) {
                    if (this.fTB) {
                        this.fTB = false;
                        this.fTC = true;
                        return true;
                    } else if (!this.fTA && this.fTC) {
                        this.fTA = true;
                        this.fTC = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btr() {
        if (this.fAd != null && this.fzQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fzQ.getParent() != null) {
                if (this.fzQ.getParent() == frameLayout) {
                    frameLayout.removeView(this.fzQ);
                } else if (this.fzQ.getParent() == this.fzP) {
                    this.fzP.removeView(this.fzQ);
                }
            }
            if (this.fzQ.getParent() == null) {
                frameLayout.addView(this.fzQ);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fzQ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fzQ.setLayoutParams(layoutParams);
                if (this.fTy != null && this.fTy.isShowing()) {
                    this.fTy.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bts() {
        if (this.fAd != null && this.fzQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fzQ.getParent() != null) {
                if (this.fzQ.getParent() == frameLayout) {
                    btt();
                    frameLayout.removeView(this.fzQ);
                } else if (this.fzQ.getParent() == this.fzP) {
                    btt();
                    this.fzP.removeView(this.fzQ);
                }
            }
            if (this.fzQ.getParent() == null) {
                this.fzP.addView(this.fzQ, 0);
                btu();
                this.fAd.bLm();
                this.startPosition = -1L;
            }
        }
    }

    private void btt() {
        if (this.eCp != null && this.eCp.pr()) {
            this.eCp.ax(true);
        }
    }

    private void btu() {
        int i;
        if (!btm()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fzQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aZq() != null) {
            view.setTag(this);
            aZq().a(view, this.fAe);
        }
        if (view == this.efN || view == this.XL) {
            if (this.fAe != null && this.fAe.fAD != null && !TextUtils.isEmpty(this.fAe.fAD.userId)) {
                this.fTv.te(0);
                if (!TbadkCoreApplication.isLogin() || !this.fAe.fAD.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fAe.fAD.userId, 0L), z, this.fAe.fAD.isGod)));
            }
        } else if (view == this.cbl) {
            if (this.fAe != null) {
                this.fTv.te(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fAe.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fTk || view == this.fTl) {
            if (this.fAe != null) {
                if (this.fTv.getCurrentState() != 2 && this.fTv.getCurrentState() != 3) {
                    z = false;
                }
                this.fTv.te(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fAe.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.cbo) {
            this.fTv.te(0);
            ala();
        } else if (view == this.fTr && this.fTr.getVisibility() == 0 && this.fTt != null) {
            this.fTt.ti(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kq(boolean z) {
        if (this.fAe != null && this.fAe.fAD != null) {
            this.fAe.fAD.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bov() {
        if (this.fAe != null) {
            this.cbi.akg();
        }
    }

    public void kS(boolean z) {
        if (this.fzP != null) {
            this.fzP.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.fTz = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fTt = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.RE = fVar;
    }

    private void kT(boolean z) {
        this.fTp = this.mPosition == (this.fTu == null ? -1 : this.fTu.btF());
        if (this.fTp && z && isPlaying() && this.bOM && !this.fTq) {
            this.fTm.setVisibility(0);
            this.fTq = true;
            this.fTm.postDelayed(this.fTF, 5000L);
            if (this.fTu != null) {
                this.fTu.dl(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fTm.setVisibility(8);
        if (this.fTF != null) {
            this.fTm.removeCallbacks(this.fTF);
        }
    }

    private void ala() {
        if (this.fAe != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fAe.forumId);
            String str = this.fAe.title;
            String str2 = this.fAe.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fAe.fAE.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fAe.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = format;
            eVar.ckP = str5;
            eVar.linkUrl = str3;
            eVar.extData = str2;
            eVar.ckS = 3;
            eVar.fid = valueOf;
            eVar.ckJ = "";
            eVar.tid = str2;
            eVar.ckC = true;
            eVar.ckR = 0;
            eVar.ckW = 2;
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
            bundle.putInt("obj_param1", eVar.ckS);
            bundle.putInt("obj_type", eVar.ckW);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMy);
            eVar.E(bundle);
            com.baidu.tieba.c.e.bbD().a(new ShareDialogConfig(this.mContext, eVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bot();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bos();
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

    public void btv() {
        this.eCp.resume();
    }

    public boolean btw() {
        if (this.fTv != null) {
            return this.fTv.getCurrentState() == 2 || this.fTv.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0319a {
        private Runnable fTK;
        private int mCurrentState;

        private C0319a() {
            this.mCurrentState = -1;
            this.fTK = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(C0319a.this.fTK);
                    C0319a.this.te(2);
                }
            };
        }

        public void te(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = tf(i);
                    btx();
                    return;
                case 1:
                    this.mCurrentState = tf(i);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fTK);
                    return;
                case 2:
                    this.mCurrentState = tg(i);
                    return;
                case 3:
                    this.mCurrentState = th(i);
                    btx();
                    return;
                default:
                    this.mCurrentState = tg(i);
                    return;
            }
        }

        private void btx() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fTK);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.fTK, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int tf(int i) {
            if (i != this.mCurrentState) {
                a.this.fTs.setVisibility(8);
                a.this.kU(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int tg(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fTs.setVisibility(0);
                if (i2 != 3 || a.this.fAe.autoPlay) {
                    a.this.kU(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int th(int i) {
            if (i != this.mCurrentState) {
                a.this.fTs.setVisibility(0);
                a.this.kU(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
