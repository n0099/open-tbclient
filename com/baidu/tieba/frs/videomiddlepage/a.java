package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f Xr;
    public TextView agw;
    private Animation boW;
    private Animation boX;
    private String dCp;
    private boolean dJS;
    protected AgreeView dVU;
    private TextView dVV;
    private ImageView dVW;
    private View dVX;
    private TextView dVY;
    private ImageView dVZ;
    private View dWa;
    private n fbZ;
    private com.baidu.afd.videopaster.d gDU;
    private int gUB;
    private C0621a hOA;
    private VideoNetworkStateTipView hOB;
    private b hOC;
    private com.baidu.mcn.c hOD;
    private com.baidu.tieba.lego.card.view.g hOE;
    private boolean hOF;
    private boolean hOG;
    private boolean hOH;
    private Animation.AnimationListener hOI;
    private Animation.AnimationListener hOJ;
    private Runnable hOK;
    private Runnable hOL;
    public ExpandableTextView hOp;
    private View hOq;
    private FrameLayout hOr;
    private TextView hOs;
    private boolean hOt;
    private boolean hOu;
    private boolean hOv;
    private View hOw;
    private View hOx;
    private c hOy;
    public com.baidu.tieba.frs.videomiddlepage.a.a hOz;
    public FrameLayout hsQ;
    public FrameLayout hsR;
    public HeadImageView hsX;
    public com.baidu.tieba.play.c hte;
    public com.baidu.tieba.frs.aggregation.g htf;
    private com.baidu.tieba.frs.aggregation.h htg;
    private y hth;
    private y hti;
    private boolean htj;
    private boolean htk;
    private boolean htn;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.htj = true;
        this.htn = true;
        this.hOu = false;
        this.hOv = false;
        this.hOF = false;
        this.hOG = false;
        this.hOH = false;
        this.startPosition = -1L;
        this.gUB = 0;
        this.hOI = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hOw != null) {
                    a.this.hOw.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hOw != null) {
                    a.this.hOw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hOJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hOw != null) {
                    a.this.hOw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hOw != null) {
                    a.this.hOw.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hOK = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hOr.getVisibility() == 0) {
                    a.this.hOr.setVisibility(8);
                }
            }
        };
        this.hOL = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hte != null) {
                    a.this.hte.stopPlay();
                }
            }
        };
        this.htn = z;
        this.mFrom = str;
        this.dCp = str2;
        this.hOC = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hsQ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hOq = view.findViewById(R.id.card_container);
        this.hsR = (FrameLayout) view.findViewById(R.id.video_container);
        this.hte = new com.baidu.tieba.play.c(tbPageContext, this.hsR, false, com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test") ? 1 : 0);
        this.hte.tm(z);
        this.hte.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.hOz != null && a.this.htf.htF.videoDuration > 8) {
                    a.this.hOz.aZ(a.this.mPosition, a.this.htf.htF.videoUrl);
                }
            }
        });
        this.hte.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void nQ(boolean z2) {
                if (a.this.hOA != null) {
                    if (z2) {
                        a.this.hOA.vH(0);
                    } else {
                        a.this.hOA.vH(1);
                    }
                }
            }
        });
        this.hte.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.hOp = (ExpandableTextView) view.findViewById(R.id.title);
        this.hsX = (HeadImageView) view.findViewById(R.id.user_icon);
        this.agw = (TextView) view.findViewById(R.id.user_name);
        this.dVU = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dBa = 2;
        cVar.dBf = 6;
        this.dVU.setStatisticData(cVar);
        this.dVV = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dVW = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dVX = view.findViewById(R.id.thread_info_commont_container);
        this.dVY = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dVZ = (ImageView) view.findViewById(R.id.share_num_img);
        this.dWa = view.findViewById(R.id.share_num_container);
        this.hOr = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.hOs = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.hOr.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hOs.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_link_url", null);
        this.hOs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aVa().a((TbPageContext) i.G(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.hOB = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.hOB.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.hOB.setHasAgreeToPlay(true);
                a.this.hte.ts(false);
                a.this.hOB.dlu();
                if (a.this.gDU.pE()) {
                    a.this.gDU.resume();
                } else if (a.this.htf != null && a.this.htf.htF != null) {
                    a.this.hte.eW(a.this.htf.htF.videoUrl, a.this.htf.threadId);
                }
            }
        });
        this.hOw = view.findViewById(R.id.video_agg_container_foreground);
        this.hOx = view.findViewById(R.id.title_and_comment_container_foreground);
        this.hOw.setOnClickListener(this);
        this.dVX.setOnClickListener(this);
        this.dWa.setOnClickListener(this);
        this.hOp.setOnClickListener(this);
        this.hsX.setOnClickListener(this);
        this.agw.setOnClickListener(this);
        this.hOq.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.gUB = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hsQ.setLayoutParams(layoutParams);
        this.hsX.setIsRound(true);
        this.hsX.setPlaceHolder(1);
        this.fbZ = new n(tbPageContext.getPageActivity());
        this.htg = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.boW = new AlphaAnimation(0.0f, 0.7f);
        this.boW.setDuration(500L);
        this.boW.setAnimationListener(this.hOJ);
        this.boX = new AlphaAnimation(0.7f, 0.0f);
        this.boX.setDuration(500L);
        this.boX.setAnimationListener(this.hOI);
        this.hOA = new C0621a();
        this.gDU = new com.baidu.afd.videopaster.d(getContext(), this.hsR);
        this.hOD = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dVU.onChangeSkinType(i);
        this.dVV.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dVY.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aUW().a(this.dVW, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUW().a(this.dVZ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hOp.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.htF != null) {
            boolean z = this.htf == gVar;
            this.htf = gVar;
            this.dJS = this.htf.autoPlay;
            this.hOv = false;
            nO(false);
            this.hOp.setVisibility(0);
            this.hOp.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.hOp.setTextColor(R.color.cp_cont_a);
            this.hOp.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.htF != null && !StringUtils.isNull(gVar.htF.mcnLeadPage)) {
                this.hOp.setTextMaxLine(2);
                this.hOp.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.hOp.getContentView(), gVar.title, gVar.htF.mcnLeadPage, gVar.getThreadId());
            } else {
                this.hOp.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.hOp.setExpandable(true);
                this.hOp.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nR(boolean z2) {
                        a.this.htf.isTitleExpanded = z2;
                    }
                });
                this.hOp.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.gUB) {
                this.hte.cQE();
                this.gUB = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hsR.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hsR.setLayoutParams(layoutParams);
            }
            ccI();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.htf = gVar;
        this.dJS = this.htf.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean ccH() {
        try {
            int parseInt = Integer.parseInt(this.htf.htF.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.htf.htF.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void ccI() {
        if (!ccH()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hsQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hsQ.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.htF != null) {
            this.hte.stopPlay();
            this.hte.setIsNeedRecoveryVideoPlayer(true);
            this.hte.tt(true);
            this.hte.tp(true);
            this.hte.tu(true);
            this.hte.an(false, false);
            this.hte.BH(i);
            this.hte.a(new c.InterfaceC0704c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pM() {
                    a.this.ccM();
                    if (a.this.gDU != null) {
                        a.this.gDU.pM();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pN() {
                    a.this.ccN();
                    if (a.this.hte.pO()) {
                    }
                    if (a.this.htk || (a.this.gDU != null && a.this.gDU.pE())) {
                        com.baidu.adp.lib.f.e.ld().removeCallbacks(a.this.hOL);
                        com.baidu.adp.lib.f.e.ld().post(a.this.hOL);
                    }
                    if (a.this.gDU != null) {
                        a.this.gDU.pN();
                    }
                }
            });
            this.hte.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bXy() {
                    if (a.this.htf != null && a.this.htf.htF != null && com.baidu.adp.lib.f.b.toInt(a.this.htf.htF.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.htf.htF.videoWidth, 0)) {
                        a.this.hte.an(false, false);
                    } else {
                        a.this.hte.an(true, false);
                    }
                    a.this.htk = false;
                    a.this.EG(a.this.dJS ? "1" : "2");
                    a.this.onClick(a.this.hsR);
                    if (a.this.Xr != null) {
                        a.this.Xr.a(a.this);
                    }
                    if (a.this.hOE != null) {
                        a.this.hOE.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bXz() {
                    a.this.onClick(a.this.hsQ);
                }
            });
            this.hte.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void nl(boolean z2) {
                    a.this.hte.eW(a.this.htf.htF.videoUrl, a.this.htf.threadId);
                    a.this.EG("2");
                    a.this.onClick(a.this.hsR);
                }
            });
            this.hte.tl(false);
            if (this.hOD != null) {
                this.hOD.reset();
            }
            this.startPosition = -1L;
            this.fbZ.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.htf.htF.htQ;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.gDU.a(a.this.isFullScreen, a.this.hte != null && a.this.hte.cQk(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.gDU.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.hte.cQk() && !com.baidu.mcn.b.Lx().gg(aVar2.XI)) {
                        boolean z3 = a.this.startPosition >= (aVar2.htI * 1000) + 1000;
                        if (i3 < aVar2.htI * 1000 || i3 >= aVar2.htJ * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.hOD.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.boJ = aVar2.htL;
                                aVar3.boK = aVar2.htM;
                                aVar3.boL = aVar2.XI;
                                aVar3.boI = aVar2.htK;
                                aVar3.fid = a.this.htf != null ? a.this.htf.forumId : null;
                                aVar3.tid = a.this.htf != null ? a.this.htf.threadId : null;
                                aVar3.boM = 3;
                                if (z3) {
                                    a.this.hOD.b(aVar3, (ViewGroup) a.this.hte.cQD());
                                } else {
                                    a.this.hOD.a(aVar3, (ViewGroup) a.this.hte.cQD());
                                }
                            }
                        } else if (a.this.hOD.isShowing()) {
                            a.this.hOD.dismiss();
                        }
                    }
                }
            });
            this.hth = new y();
            this.hth.ais = gVar.threadId;
            this.hth.mNid = gVar.nid;
            this.hth.evm = gVar.forumId;
            this.hth.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hth.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.hth.mSource = gVar.source;
            this.hth.kBr = gVar.weight;
            this.hth.kBt = this.mFrom;
            this.hth.kBv = gVar.abtest_tag;
            this.hth.dCp = this.dCp;
            this.hth.mExtra = gVar.extra;
            this.hth.kBy = "0";
            this.hth.kBu = gVar.getVideoType();
            this.hti = new y();
            this.hti.ais = gVar.threadId;
            this.hti.evm = gVar.forumId;
            this.hti.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hti.kBr = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hti.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hti.kBt = this.mFrom;
            this.hti.mSource = gVar.source;
            this.hti.kBy = "0";
            if (gVar.htF != null) {
                this.hth.kBw = gVar.htF.videoMd5;
                this.hti.kBw = gVar.htF.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.dh("tid", gVar.threadId);
            anVar.dh("nid", gVar.nid);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.ag("obj_locate", i);
            anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.dh("fid", gVar.forumId);
            anVar.dh("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.dh("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.dh("obj_id", this.dCp);
            anVar.dh("ab_tag", aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.dh("obj_type", this.mFrom);
            anVar.ag("obj_param5", gVar.getVideoType());
            anVar.dh("obj_source", aq.isEmpty(gVar.source) ? "0" : gVar.source);
            anVar.ag("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.dh("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.dh("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.fbZ.setVideoStatsData(this.hth);
            this.hte.cQm().setBusiness(this.fbZ);
            this.fbZ.a(gVar);
            this.hte.cuk();
            this.hte.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.gDU.a(a.this.isFullScreen, a.this.hte != null && a.this.hte.cQk(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.htk = true;
                            a.this.hOt = true;
                            a.this.htj = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.ul(i);
                            a.this.hte.cho();
                        }
                    }
                }
            });
            this.hte.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.htf != null && a.this.htf.htF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.htf.htF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.gDU.reset();
            }
            this.gDU.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void pV() {
                    a.this.hOt = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pU() {
                    if (a.this.isFullScreen) {
                        a.this.htk = true;
                        a.this.hOt = true;
                        a.this.htj = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.ul(i);
                        a.this.hte.cho();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pT() {
                    if (a.this.hte != null) {
                        a.this.hte.BG(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean pW() {
                    return a.this.ccL();
                }
            });
            this.hte.setThumbnail(gVar.htF.thumbnailUrl);
            this.hte.BF(gVar.htF.videoDuration);
            this.hte.setVideoUrl(gVar.htF.videoUrl, gVar.threadId);
            this.hte.setFid(gVar.forumId);
            this.hte.cho();
            this.hte.show();
            nO(false);
            if (gVar.autoPlay) {
                onClick(this.hsR);
                if (this.hOB.cMn()) {
                    this.hte.tr(false);
                    this.hOB.dlt();
                    this.hte.ts(true);
                    this.hte.eV(gVar.htF.videoUrl, gVar.threadId);
                    if (this.gDU.pE()) {
                        this.gDU.stop();
                        this.gDU.pJ();
                    }
                } else {
                    this.hte.ts(false);
                    this.hte.tr(false);
                    this.hOB.hide();
                    if (this.gDU == null || (this.gDU != null && !this.gDU.pE())) {
                        this.hte.a(gVar.htF.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.htG) {
                    this.hOw.setVisibility(8);
                    this.hOA.vH(3);
                } else {
                    if (this.hOw.getVisibility() == 0) {
                        this.hOw.startAnimation(this.boX);
                    }
                    this.hOA.vH(0);
                }
                gVar.htG = false;
            } else {
                this.hOw.setVisibility(0);
                this.hOB.hide();
                this.hte.tr(true);
                this.hOA.vH(3);
                this.hte.eV(gVar.htF.videoUrl, gVar.threadId);
            }
            this.htk = false;
            this.hOt = false;
            if (!z && this.gDU.pE()) {
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
        com.baidu.afd.videopaster.data.b Fm = this.hOC != null ? this.hOC.Fm(gVar.getThreadId()) : null;
        if (Fm == null) {
            return null;
        }
        int qa = Fm.qa();
        int qb = Fm.qb();
        int pZ = Fm.pZ();
        if (pZ != -1) {
            i = qa != -1 ? (pZ - qa) - 1 : -1;
            if (qb != -1) {
                i4 = (qb - pZ) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.htF != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.htF.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.htF.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", pZ + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(String str) {
        if (this.htf != null && this.htf.htF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.htf.htF.videoMd5, "", str, this.hti, this.hte.cQm().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hte.pO();
    }

    public boolean ccJ() {
        return this.gDU.pE();
    }

    public void bXu() {
        if (isPlaying()) {
            this.hte.avT();
        }
    }

    public boolean um(int i) {
        if (i == 4 && this.gDU != null && ((this.gDU.pE() || this.hOt) && this.hte != null)) {
            this.gDU.aK(i);
            if (this.isFullScreen) {
                if (this.gDU.pD()) {
                    this.hte.cQl();
                } else {
                    this.hte.GV();
                }
                return true;
            }
        }
        return this.hte.BG(i);
    }

    public void bXv() {
        this.hOv = false;
        this.hte.stopPlay();
        if (this.hOp != null) {
            this.hOp.setVisibility(0);
        }
        if (this.hOA != null) {
            this.hOA.vH(2);
        }
        nO(false);
        this.hOu = true;
        if (this.gDU != null && this.gDU.pE()) {
            this.gDU.stop();
        }
    }

    public void ccK() {
        this.gDU.stop();
    }

    public void bXw() {
        if (this.hte != null) {
            this.hte.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        bXw();
        if (this.htg != null) {
            this.htg.bXG();
        }
        if (this.hOw != null) {
            this.hOw.clearAnimation();
        }
        this.gDU.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.htE != null) {
            this.agw.setText(TextUtils.isEmpty(gVar.htE.userNickname) ? gVar.htE.userName : gVar.htE.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.htE != null) {
            if (gVar.htE.htP != null && !TextUtils.isEmpty(gVar.htE.htP.avatar)) {
                this.hsX.startLoad(gVar.htE.htP.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.htE.portrait) && gVar.htE.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hsX.startLoad(gVar.htE.portrait, 10, false);
            } else {
                this.hsX.startLoad(gVar.htE.portrait, 12, false);
            }
            if (gVar.htE.htP != null && gVar.htE.htP.auth_id.intValue() > 0) {
                this.hsX.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.htE.htP.auth_id.intValue(), 1));
                this.hsX.setShowV(true);
                this.hsX.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hsX.setBjhAuthIconRes(0);
            if (gVar.htE.isBigV) {
                this.hsX.setShowV(gVar.htE.isBigV);
                this.hsX.setIsBigV(gVar.htE.isBigV);
            } else if (gVar.htE.isGod) {
                this.hsX.setShowV(gVar.htE.isGod);
                this.hsX.setIsBigV(gVar.htE.isGod);
            } else {
                this.hsX.setShowV(gVar.htE.isGod);
                this.hsX.setIsBigV(gVar.htE.isGod);
            }
            this.hsX.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aSp() != null) {
                gVar.aSp().isInThread = true;
                gVar.aSp().nid = gVar.nid;
                if (this.htf.getVideoType() == 1) {
                    gVar.aSp().cardType = 2;
                } else if (this.htf.getVideoType() == 2) {
                    gVar.aSp().cardType = 8;
                } else if (this.htf.getVideoType() == 3) {
                    gVar.aSp().cardType = 6;
                }
                gVar.aSp().baijiahaoData = gVar.mBaijiahao;
                gVar.aSp().recomSource = gVar.source;
                gVar.aSp().recomWeight = gVar.weight;
                gVar.aSp().recomAbTag = gVar.abtest_tag;
                gVar.aSp().recomExtra = gVar.extra;
            }
            if (this.htf.mBaijiahao != null) {
                this.dVU.setAgreeAlone(true);
            }
            this.dVU.setIsFromMiddlePage(true);
            this.dVU.setData(gVar.aSp());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dVV.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aUW().a(this.dVW, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dVV.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dVV.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dVY.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aUW().a(this.dVZ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dVY.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dVY.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hte != null && this.hsR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.htj) {
                this.hte.cQs();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                ccM();
            } else {
                configuration.orientation = 1;
                ccN();
                this.htj = true;
            }
            this.hte.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccL() {
        if (this.hte != null && this.hsR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hsR.getParent() != null) {
                if (this.hsR.getParent() == frameLayout) {
                    if (this.hOF) {
                        this.hOF = false;
                        return true;
                    } else if (!this.hOG) {
                        this.hOG = true;
                        return true;
                    }
                } else if (this.hsR.getParent() == this.hsQ) {
                    if (this.hOG) {
                        this.hOG = false;
                        this.hOH = true;
                        return true;
                    } else if (!this.hOF && this.hOH) {
                        this.hOF = true;
                        this.hOH = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccM() {
        if (this.hte != null && this.hsR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hsR.getParent() != null) {
                if (this.hsR.getParent() == frameLayout) {
                    frameLayout.removeView(this.hsR);
                } else if (this.hsR.getParent() == this.hsQ) {
                    this.hsQ.removeView(this.hsR);
                }
            }
            if (this.hsR.getParent() == null) {
                frameLayout.addView(this.hsR);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hsR.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hsR.setLayoutParams(layoutParams);
                if (this.hOD != null && this.hOD.isShowing()) {
                    this.hOD.dismiss();
                }
                com.baidu.tbadk.util.d.bgo().iu(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccN() {
        if (this.hte != null && this.hsR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hsR.getParent() != null) {
                if (this.hsR.getParent() == frameLayout) {
                    ccO();
                    frameLayout.removeView(this.hsR);
                } else if (this.hsR.getParent() == this.hsQ) {
                    ccO();
                    this.hsQ.removeView(this.hsR);
                }
            }
            if (this.hsR.getParent() == null) {
                this.hsQ.addView(this.hsR, 0);
                ccP();
                this.hte.cuk();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.bgo().iu(false);
            }
        }
    }

    private void ccO() {
        if (this.gDU != null && this.gDU.pE()) {
            this.gDU.az(true);
        }
    }

    private void ccP() {
        int i;
        if (!ccH()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hsR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bKU() != null) {
            view.setTag(this);
            bKU().a(view, this.htf);
        }
        if (view == this.hsX || view == this.agw) {
            if (this.htf != null && this.htf.htE != null && !TextUtils.isEmpty(this.htf.htE.userId)) {
                this.hOA.vH(0);
                if (!TbadkCoreApplication.isLogin() || !this.htf.htE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.htf.htE.userId, 0L), z, this.htf.htE.isGod)));
            }
        } else if (view == this.dVX) {
            if (this.htf != null) {
                this.hOA.vH(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.htf.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.htf.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hOp || view == this.hOq) {
            if (this.htf != null) {
                if (this.hOA.getCurrentState() != 2 && this.hOA.getCurrentState() != 3) {
                    z = false;
                }
                this.hOA.vH(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.htf.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.htf.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dWa) {
            this.hOA.vH(0);
            aWJ();
        } else if (view == this.hOw && this.hOw.getVisibility() == 0 && this.hOy != null) {
            this.hOy.vL(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void nk(boolean z) {
        if (this.htf != null && this.htf.htE != null) {
            this.htf.htE.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bXx() {
        if (this.htf != null) {
            this.dVU.aVQ();
        }
    }

    public void nN(boolean z) {
        if (this.hsQ != null) {
            this.hsQ.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.hOE = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.hOy = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Xr = fVar;
    }

    private void nO(boolean z) {
        this.hOu = this.mPosition == (this.hOz == null ? -1 : this.hOz.cdb());
        if (this.hOu && z && isPlaying() && this.dJS && !this.hOv) {
            this.hOr.setVisibility(0);
            this.hOv = true;
            this.hOr.postDelayed(this.hOK, 5000L);
            if (this.hOz != null) {
                this.hOz.ei(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.hOr.setVisibility(8);
        if (this.hOK != null) {
            this.hOr.removeCallbacks(this.hOK);
        }
    }

    private void aWJ() {
        String str;
        String str2;
        if (this.htf != null && this.mContext != null) {
            String valueOf = String.valueOf(this.htf.forumId);
            String str3 = this.htf.title;
            if (this.htf.mBaijiahao != null) {
                str = this.htf.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.htf.mBaijiahao.oriUgcType + "&dvid=" + this.htf.mBaijiahao.oriUgcVid + "&nid=" + this.htf.mBaijiahao.oriUgcNid;
            } else {
                str = this.htf.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.htf.htF.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.htf.title;
            String format = (this.htf.mBaijiahao == null || this.htf.htE == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.htf.htE.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.htf.mBaijiahao != null) {
                shareItem.eeT = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.eeT = str6;
                shareItem.readCount = this.htf.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.eeW = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.eeK = true;
            shareItem.eeV = 11;
            shareItem.efa = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.htf.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.htf.mBaijiahao;
            shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.dh("tid", str);
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.ag("obj_locate", 12);
            anVar.dh("nid", this.htf.nid);
            if (this.htf.mBaijiahao != null && !aq.isEmpty(this.htf.mBaijiahao.oriUgcVid)) {
                anVar.dh("obj_param6", this.htf.mBaijiahao.oriUgcVid);
            }
            if (this.htf.getVideoType() == 1) {
                anVar.ag(IntentConfig.CARD_TYPE, 2);
            } else if (this.htf.getVideoType() == 2) {
                anVar.ag(IntentConfig.CARD_TYPE, 8);
            } else if (this.htf.getVideoType() == 3) {
                anVar.ag(IntentConfig.CARD_TYPE, 6);
            }
            anVar.dh(IntentConfig.RECOM_SOURCE, this.htf.source);
            anVar.dh("ab_tag", this.htf.abtest_tag);
            anVar.dh("weight", this.htf.weight);
            anVar.dh("extra", this.htf.extra);
            anVar.dh("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            TiebaStatic.log(anVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eeW);
            bundle.putInt("obj_type", shareItem.efa);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dHZ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.bMy().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bXv();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void avT() {
        bXu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(boolean z) {
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

    public void ccQ() {
        this.gDU.resume();
    }

    public boolean ccR() {
        if (this.hOA != null) {
            return this.hOA.getCurrentState() == 2 || this.hOA.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0621a {
        private Runnable hOP;
        private int mCurrentState;

        private C0621a() {
            this.mCurrentState = -1;
            this.hOP = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(C0621a.this.hOP);
                    C0621a.this.vH(2);
                }
            };
        }

        public void vH(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = vI(i);
                    ccS();
                    return;
                case 1:
                    this.mCurrentState = vI(i);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hOP);
                    return;
                case 2:
                    this.mCurrentState = vJ(i);
                    return;
                case 3:
                    this.mCurrentState = vK(i);
                    ccS();
                    return;
                default:
                    this.mCurrentState = vJ(i);
                    return;
            }
        }

        private void ccS() {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hOP);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.hOP, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int vI(int i) {
            if (i != this.mCurrentState) {
                a.this.hOx.setVisibility(8);
                a.this.nP(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vJ(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.hOx.setVisibility(0);
                if (i2 != 3 || a.this.htf.autoPlay) {
                    a.this.nP(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vK(int i) {
            if (i != this.mCurrentState) {
                a.this.hOx.setVisibility(0);
                a.this.nP(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
