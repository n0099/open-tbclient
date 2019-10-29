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
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
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
    private com.baidu.tieba.lego.card.view.f Bc;
    public TextView HE;
    private Animation azf;
    private Animation azg;
    private String bZb;
    private boolean cgq;
    protected AgreeView cqp;
    private TextView cqq;
    private ImageView cqr;
    private View cqs;
    private ImageView cqu;
    private View cqv;
    private n dwz;
    private com.baidu.afd.videopaster.d eMF;
    public FrameLayout fAT;
    public FrameLayout fAU;
    public HeadImageView fBa;
    public com.baidu.tieba.play.c fBh;
    public com.baidu.tieba.frs.aggregation.g fBi;
    private com.baidu.tieba.frs.aggregation.h fBj;
    private z fBk;
    private z fBl;
    private boolean fBm;
    private boolean fBn;
    private boolean fBq;
    private boolean fUA;
    private boolean fUB;
    private View fUC;
    private View fUD;
    private c fUE;
    public com.baidu.tieba.frs.videomiddlepage.a.a fUF;
    private C0419a fUG;
    private VideoNetworkStateTipView fUH;
    private b fUI;
    private com.baidu.mcn.c fUJ;
    private com.baidu.tieba.lego.card.view.g fUK;
    private boolean fUL;
    private boolean fUM;
    private boolean fUN;
    private Animation.AnimationListener fUO;
    private Animation.AnimationListener fUP;
    private Runnable fUQ;
    private Runnable fUR;
    public SpannableClickTextView fUv;
    private View fUw;
    private FrameLayout fUx;
    private TextView fUy;
    private boolean fUz;
    private int ffe;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fBm = true;
        this.fBq = true;
        this.fUA = false;
        this.fUB = false;
        this.fUL = false;
        this.fUM = false;
        this.fUN = false;
        this.startPosition = -1L;
        this.ffe = 0;
        this.fUO = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fUC != null) {
                    a.this.fUC.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fUC != null) {
                    a.this.fUC.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fUP = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fUC != null) {
                    a.this.fUC.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fUC != null) {
                    a.this.fUC.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fUQ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fUx.getVisibility() == 0) {
                    a.this.fUx.setVisibility(8);
                }
            }
        };
        this.fUR = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fBh != null) {
                    a.this.fBh.stopPlay();
                }
            }
        };
        this.fBq = z;
        this.mFrom = str;
        this.bZb = str2;
        this.fUI = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fAT = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fUw = view.findViewById(R.id.card_container);
        this.fAU = (FrameLayout) view.findViewById(R.id.video_container);
        this.fBh = new com.baidu.tieba.play.c(tbPageContext, this.fAU, false, com.baidu.tbadk.a.b.mb("cyber_player_test") ? 1 : 0);
        this.fBh.pG(z);
        this.fBh.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fUF != null && a.this.fBi.fBI.videoDuration > 8) {
                    a.this.fUF.al(a.this.mPosition, a.this.fBi.fBI.videoUrl);
                }
            }
        });
        this.fBh.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void kL(boolean z2) {
                if (a.this.fUG != null) {
                    if (z2) {
                        a.this.fUG.sc(0);
                    } else {
                        a.this.fUG.sc(1);
                    }
                }
            }
        });
        this.fBh.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fUv = (SpannableClickTextView) view.findViewById(R.id.title);
        this.fBa = (HeadImageView) view.findViewById(R.id.user_icon);
        this.HE = (TextView) view.findViewById(R.id.user_name);
        this.cqp = (AgreeView) view.findViewById(R.id.agree_view);
        this.cqp.setAgreeAnimationResource(R.raw.agree);
        this.cqp.setDisagreeAnimationResource(R.raw.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bXR = 2;
        dVar.bXV = 6;
        this.cqp.setStatisticData(dVar);
        this.cqq = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.cqr = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.cqs = view.findViewById(R.id.thread_info_commont_container);
        this.cqu = (ImageView) view.findViewById(R.id.share_num_img);
        this.cqv = view.findViewById(R.id.share_num_container);
        this.fUx = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.fUy = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.fUx.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fUy.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_download_link_url", null);
        this.fUy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.amQ().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fUH = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.fUH.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.fUH.setHasAgreeToPlay(true);
                a.this.fBh.pM(false);
                a.this.fUH.cwh();
                if (a.this.eMF.kn()) {
                    a.this.eMF.resume();
                } else if (a.this.fBi != null && a.this.fBi.fBI != null) {
                    a.this.fBh.cm(a.this.fBi.fBI.videoUrl, a.this.fBi.threadId);
                }
            }
        });
        this.fUC = view.findViewById(R.id.video_agg_container_foreground);
        this.fUD = view.findViewById(R.id.title_and_comment_container_foreground);
        this.fUC.setOnClickListener(this);
        this.cqs.setOnClickListener(this);
        this.cqv.setOnClickListener(this);
        this.fUv.setOnClickListener(this);
        this.fBa.setOnClickListener(this);
        this.HE.setOnClickListener(this);
        this.fUw.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.ffe = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAT.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fAT.setLayoutParams(layoutParams);
        this.fBa.setIsRound(true);
        this.dwz = new n(tbPageContext.getPageActivity());
        this.fBj = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.azf = new AlphaAnimation(0.0f, 0.7f);
        this.azf.setDuration(500L);
        this.azf.setAnimationListener(this.fUP);
        this.azg = new AlphaAnimation(0.7f, 0.0f);
        this.azg.setDuration(500L);
        this.azg.setAnimationListener(this.fUO);
        this.fUG = new C0419a();
        this.eMF = new com.baidu.afd.videopaster.d(getContext(), this.fAU);
        this.fUJ = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.cqp.onChangeSkinType(i);
        this.cqq.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.amN().a(this.cqr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amN().a(this.cqu, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fUv.setTextColor(tbPageContext.getResources().getColor(R.color.cp_cont_a));
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
        if (gVar != null && gVar.fBI != null) {
            boolean z = this.fBi == gVar;
            this.fBi = gVar;
            this.cgq = this.fBi.autoPlay;
            this.fUB = false;
            kJ(false);
            this.fUv.setVisibility(0);
            if (gVar.fBI != null && !StringUtils.isNull(gVar.fBI.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fUv, gVar.title, gVar.fBI.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fUv.setText(gVar.title);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.ffe) {
                this.fBh.cbY();
                this.ffe = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.fAU.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fAU.setLayoutParams(layoutParams);
            }
            bre();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.akv() != null) {
                gVar.akv().isInThread = true;
            }
            this.cqp.setIsFromMiddlePage(true);
            this.cqp.setData(gVar.akv());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean brd() {
        try {
            int parseInt = Integer.parseInt(this.fBi.fBI.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fBi.fBI.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bre() {
        if (!brd()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAT.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fAT.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAT.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fAT.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.fBI != null) {
            this.fBh.stopPlay();
            this.fBh.setIsNeedRecoveryVideoPlayer(true);
            this.fBh.pN(true);
            this.fBh.pJ(true);
            this.fBh.pO(true);
            this.fBh.ag(false, false);
            this.fBh.xE(i);
            this.fBh.a(new c.InterfaceC0497c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kv() {
                    a.this.bri();
                    if (a.this.eMF != null) {
                        a.this.eMF.kv();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kw() {
                    a.this.brj();
                    if (a.this.fBh.kx()) {
                    }
                    if (a.this.fBn || (a.this.eMF != null && a.this.eMF.kn())) {
                        com.baidu.adp.lib.g.e.fZ().removeCallbacks(a.this.fUR);
                        com.baidu.adp.lib.g.e.fZ().post(a.this.fUR);
                    }
                    if (a.this.eMF != null) {
                        a.this.eMF.kw();
                    }
                }
            });
            this.fBh.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void bmm() {
                    if (a.this.fBi != null && a.this.fBi.fBI != null && com.baidu.adp.lib.g.b.toInt(a.this.fBi.fBI.videoHeight, 0) > com.baidu.adp.lib.g.b.toInt(a.this.fBi.fBI.videoWidth, 0)) {
                        a.this.fBh.ag(false, false);
                    } else {
                        a.this.fBh.ag(true, false);
                    }
                    a.this.fBn = false;
                    a.this.vR(a.this.cgq ? "1" : "2");
                    a.this.onClick(a.this.fAU);
                    if (a.this.Bc != null) {
                        a.this.Bc.a(a.this);
                    }
                    if (a.this.fUK != null) {
                        a.this.fUK.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmn() {
                    a.this.onClick(a.this.fAT);
                }
            });
            this.fBh.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z2) {
                    a.this.fBh.cm(a.this.fBi.fBI.videoUrl, a.this.fBi.threadId);
                    a.this.vR("2");
                    a.this.onClick(a.this.fAU);
                }
            });
            this.fBh.pF(false);
            if (this.fUJ != null) {
                this.fUJ.reset();
            }
            this.startPosition = -1L;
            this.dwz.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void bj(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fBi.fBI.fBS;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.eMF.a(a.this.isFullScreen, a.this.fBh != null && a.this.fBh.cbE(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.eMF.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fBh.cbE() && !com.baidu.mcn.b.zd().du(aVar2.Bu)) {
                        boolean z3 = a.this.startPosition >= (aVar2.fBL * 1000) + 1000;
                        if (i3 < aVar2.fBL * 1000 || i3 >= aVar2.fBM * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fUJ.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.ayR = aVar2.fBO;
                                aVar3.ayS = aVar2.fBP;
                                aVar3.ayT = aVar2.Bu;
                                aVar3.ayQ = aVar2.fBN;
                                aVar3.fid = a.this.fBi != null ? a.this.fBi.forumId : null;
                                aVar3.tid = a.this.fBi != null ? a.this.fBi.threadId : null;
                                aVar3.ayU = 3;
                                if (z3) {
                                    a.this.fUJ.b(aVar3, (ViewGroup) a.this.fBh.cbX());
                                } else {
                                    a.this.fUJ.a(aVar3, (ViewGroup) a.this.fBh.cbX());
                                }
                            }
                        } else if (a.this.fUJ.isShowing()) {
                            a.this.fUJ.dismiss();
                        }
                    }
                }
            });
            this.fBk = new z();
            this.fBk.cmS = gVar.threadId;
            this.fBk.ePT = gVar.forumId;
            this.fBk.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fBk.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.fBk.mSource = gVar.source;
            this.fBk.iza = gVar.weight;
            this.fBk.izc = this.mFrom;
            this.fBk.izd = gVar.abtest_tag;
            this.fBk.bZb = this.bZb;
            this.fBk.din = gVar.extra;
            this.fBk.izg = "0";
            this.fBl = new z();
            this.fBl.cmS = gVar.threadId;
            this.fBl.ePT = gVar.forumId;
            this.fBl.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fBl.iza = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.fBl.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.fBl.izc = this.mFrom;
            this.fBl.mSource = gVar.source;
            this.fBl.izg = "0";
            if (gVar.fBI != null) {
                this.fBk.ize = gVar.fBI.videoMd5;
                this.fBl.ize = gVar.fBI.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.bS("tid", gVar.threadId);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.O("obj_locate", i);
            anVar.O(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.bS("fid", gVar.forumId);
            anVar.bS("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.bS("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.bS("obj_id", this.bZb);
            anVar.bS(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.bS("obj_type", this.mFrom);
            anVar.bS("obj_source", aq.isEmpty(this.fBi.source) ? "0" : this.fBi.source);
            anVar.O("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.dwz.setVideoStatsData(this.fBk);
            this.fBh.cbG().setBusiness(this.dwz);
            this.dwz.a(gVar);
            this.fBh.bII();
            this.fBh.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.eMF.a(a.this.isFullScreen, a.this.fBh != null && a.this.fBh.cbE(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fBn = true;
                            a.this.fUz = true;
                            a.this.fBm = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.qO(i);
                            a.this.fBh.bvM();
                        }
                    }
                }
            });
            this.fBh.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fBi != null && a.this.fBi.fBI != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fBi.fBI.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.eMF.reset();
            }
            this.eMF.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void kE() {
                    a.this.fUz = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kD() {
                    if (a.this.isFullScreen) {
                        a.this.fBn = true;
                        a.this.fUz = true;
                        a.this.fBm = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.qO(i);
                        a.this.fBh.bvM();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kC() {
                    if (a.this.fBh != null) {
                        a.this.fBh.xD(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean kF() {
                    return a.this.brh();
                }
            });
            this.fBh.setThumbnail(gVar.fBI.thumbnailUrl);
            this.fBh.setVideoUrl(gVar.fBI.videoUrl, gVar.threadId);
            this.fBh.setFid(gVar.forumId);
            this.fBh.bvM();
            this.fBh.show();
            kJ(false);
            if (gVar.autoPlay) {
                onClick(this.fAU);
                if (this.fUH.cdl()) {
                    this.fBh.pL(false);
                    this.fUH.cwg();
                    this.fBh.pM(true);
                    this.fBh.dE(gVar.fBI.videoUrl, gVar.threadId);
                    if (this.eMF.kn()) {
                        this.eMF.stop();
                        this.eMF.ks();
                    }
                } else {
                    this.fBh.pM(false);
                    this.fBh.pL(false);
                    this.fUH.hide();
                    if (this.eMF == null || (this.eMF != null && !this.eMF.kn())) {
                        this.fBh.a(gVar.fBI.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.fBJ) {
                    this.fUC.setVisibility(8);
                    this.fUG.sc(3);
                } else {
                    if (this.fUC.getVisibility() == 0) {
                        this.fUC.startAnimation(this.azg);
                    }
                    this.fUG.sc(0);
                }
                gVar.fBJ = false;
            } else {
                this.fUC.setVisibility(0);
                this.fUH.hide();
                this.fBh.pL(true);
                this.fUG.sc(3);
                this.fBh.dE(gVar.fBI.videoUrl, gVar.threadId);
            }
            this.fBn = false;
            this.fUz = false;
            if (!z && this.eMF.kn()) {
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
        com.baidu.afd.videopaster.data.b wC = this.fUI != null ? this.fUI.wC(gVar.getThreadId()) : null;
        if (wC == null) {
            return null;
        }
        int kJ = wC.kJ();
        int kK = wC.kK();
        int kI = wC.kI();
        if (kI != -1) {
            i = kJ != -1 ? (kI - kJ) - 1 : -1;
            if (kK != -1) {
                i4 = (kK - kI) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.fBI != null) {
            i3 = com.baidu.adp.lib.g.b.toInt(gVar.fBI.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.toInt(gVar.fBI.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", kI + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(String str) {
        if (this.fBi != null && this.fBi.fBI != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fBi.fBI.videoMd5, "", str, this.fBl);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fBh.kx();
    }

    public boolean brf() {
        return this.eMF.kn();
    }

    public void bmi() {
        if (isPlaying()) {
            this.fBh.pausePlay();
        }
    }

    public boolean qP(int i) {
        if (i == 4 && this.eMF != null && ((this.eMF.kn() || this.fUz) && this.fBh != null)) {
            this.eMF.ar(i);
            if (this.isFullScreen) {
                if (this.eMF.km()) {
                    this.fBh.cbF();
                } else {
                    this.fBh.vs();
                }
                return true;
            }
        }
        return this.fBh.xD(i);
    }

    public void bmj() {
        this.fUB = false;
        this.fBh.stopPlay();
        if (this.fUv != null) {
            this.fUv.setVisibility(0);
        }
        if (this.fUG != null) {
            this.fUG.sc(2);
        }
        kJ(false);
        this.fUA = true;
        if (this.eMF != null && this.eMF.kn()) {
            this.eMF.stop();
        }
    }

    public void brg() {
        this.eMF.stop();
    }

    public void bmk() {
        if (this.fBh != null) {
            this.fBh.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmk();
        if (this.fBj != null) {
            this.fBj.bmv();
        }
        if (this.fUC != null) {
            this.fUC.clearAnimation();
        }
        this.eMF.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.fBH != null) {
            this.HE.setText(TextUtils.isEmpty(gVar.fBH.userNickname) ? gVar.fBH.userName : gVar.fBH.userNickname);
            if (!StringUtils.isNull(gVar.fBH.portrait) && gVar.fBH.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.fBa.startLoad(gVar.fBH.portrait, 10, false);
            } else {
                this.fBa.startLoad(gVar.fBH.portrait, 12, false);
            }
            if (gVar.fBH.isBigV) {
                this.fBa.setShowV(gVar.fBH.isBigV);
                this.fBa.setIsBigV(gVar.fBH.isBigV);
            } else if (gVar.fBH.isGod) {
                this.fBa.setShowV(gVar.fBH.isGod);
                this.fBa.setIsBigV(gVar.fBH.isGod);
            } else {
                this.fBa.setShowV(gVar.fBH.isGod);
                this.fBa.setIsBigV(gVar.fBH.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cqp.setData(gVar.akv());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cqq.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.amN().a(this.cqr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.cqq.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.cqq.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fBh != null && this.fAU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fBm) {
                this.fBh.cbM();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bri();
            } else {
                configuration.orientation = 1;
                brj();
                this.fBm = true;
            }
            this.fBh.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brh() {
        if (this.fBh != null && this.fAU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fAU.getParent() != null) {
                if (this.fAU.getParent() == frameLayout) {
                    if (this.fUL) {
                        this.fUL = false;
                        return true;
                    } else if (!this.fUM) {
                        this.fUM = true;
                        return true;
                    }
                } else if (this.fAU.getParent() == this.fAT) {
                    if (this.fUM) {
                        this.fUM = false;
                        this.fUN = true;
                        return true;
                    } else if (!this.fUL && this.fUN) {
                        this.fUL = true;
                        this.fUN = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bri() {
        if (this.fBh != null && this.fAU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fAU.getParent() != null) {
                if (this.fAU.getParent() == frameLayout) {
                    frameLayout.removeView(this.fAU);
                } else if (this.fAU.getParent() == this.fAT) {
                    this.fAT.removeView(this.fAU);
                }
            }
            if (this.fAU.getParent() == null) {
                frameLayout.addView(this.fAU);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fAU.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fAU.setLayoutParams(layoutParams);
                if (this.fUJ != null && this.fUJ.isShowing()) {
                    this.fUJ.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brj() {
        if (this.fBh != null && this.fAU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fAU.getParent() != null) {
                if (this.fAU.getParent() == frameLayout) {
                    brk();
                    frameLayout.removeView(this.fAU);
                } else if (this.fAU.getParent() == this.fAT) {
                    brk();
                    this.fAT.removeView(this.fAU);
                }
            }
            if (this.fAU.getParent() == null) {
                this.fAT.addView(this.fAU, 0);
                brl();
                this.fBh.bII();
                this.startPosition = -1L;
            }
        }
    }

    private void brk() {
        if (this.eMF != null && this.eMF.kn()) {
            this.eMF.Q(true);
        }
    }

    private void brl() {
        int i;
        if (!brd()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fAU.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aZX() != null) {
            view.setTag(this);
            aZX().a(view, this.fBi);
        }
        if (view == this.fBa || view == this.HE) {
            if (this.fBi != null && this.fBi.fBH != null && !TextUtils.isEmpty(this.fBi.fBH.userId)) {
                this.fUG.sc(0);
                if (!TbadkCoreApplication.isLogin() || !this.fBi.fBH.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(this.fBi.fBH.userId, 0L), z, this.fBi.fBH.isGod)));
            }
        } else if (view == this.cqs) {
            if (this.fBi != null) {
                this.fUG.sc(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fBi.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.fUv || view == this.fUw) {
            if (this.fBi != null) {
                if (this.fUG.getCurrentState() != 2 && this.fUG.getCurrentState() != 3) {
                    z = false;
                }
                this.fUG.sc(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fBi.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.cqv) {
            this.fUG.sc(0);
            aoa();
        } else if (view == this.fUC && this.fUC.getVisibility() == 0 && this.fUE != null) {
            this.fUE.sg(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fBi != null && this.fBi.fBH != null) {
            this.fBi.fBH.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bml() {
        if (this.fBi != null) {
            this.cqp.anu();
        }
    }

    public void kI(boolean z) {
        if (this.fAT != null) {
            this.fAT.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.fUK = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fUE = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Bc = fVar;
    }

    private void kJ(boolean z) {
        this.fUA = this.mPosition == (this.fUF == null ? -1 : this.fUF.brv());
        if (this.fUA && z && isPlaying() && this.cgq && !this.fUB) {
            this.fUx.setVisibility(0);
            this.fUB = true;
            this.fUx.postDelayed(this.fUQ, 5000L);
            if (this.fUF != null) {
                this.fUF.cO(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fUx.setVisibility(8);
        if (this.fUQ != null) {
            this.fUx.removeCallbacks(this.fUQ);
        }
    }

    private void aoa() {
        if (this.fBi != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fBi.forumId);
            String str = this.fBi.title;
            String str2 = this.fBi.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fBi.fBI.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fBi.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = format;
            eVar.cyK = str5;
            eVar.linkUrl = str3;
            eVar.extData = str2;
            eVar.cyN = 3;
            eVar.fid = valueOf;
            eVar.cyE = "";
            eVar.tid = str2;
            eVar.cyx = true;
            eVar.cyM = 0;
            eVar.cyR = 2;
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
            bundle.putInt("obj_param1", eVar.cyN);
            bundle.putInt("obj_type", eVar.cyR);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt("obj_source", eVar.ceG);
            eVar.E(bundle);
            com.baidu.tieba.c.e.bcj().a(new ShareDialogConfig(this.mContext, eVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bmj();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bmi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void brm() {
        this.eMF.resume();
    }

    public boolean brn() {
        if (this.fUG != null) {
            return this.fUG.getCurrentState() == 2 || this.fUG.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0419a {
        private Runnable fUV;
        private int mCurrentState;

        private C0419a() {
            this.mCurrentState = -1;
            this.fUV = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(C0419a.this.fUV);
                    C0419a.this.sc(2);
                }
            };
        }

        public void sc(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = sd(i);
                    bro();
                    return;
                case 1:
                    this.mCurrentState = sd(i);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fUV);
                    return;
                case 2:
                    this.mCurrentState = se(i);
                    return;
                case 3:
                    this.mCurrentState = sf(i);
                    bro();
                    return;
                default:
                    this.mCurrentState = se(i);
                    return;
            }
        }

        private void bro() {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fUV);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.fUV, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int sd(int i) {
            if (i != this.mCurrentState) {
                a.this.fUD.setVisibility(8);
                a.this.kK(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int se(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fUD.setVisibility(0);
                if (i2 != 3 || a.this.fBi.autoPlay) {
                    a.this.kK(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int sf(int i) {
            if (i != this.mCurrentState) {
                a.this.fUD.setVisibility(0);
                a.this.kK(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
