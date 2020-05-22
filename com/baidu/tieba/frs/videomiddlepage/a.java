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
    private n fbO;
    private com.baidu.afd.videopaster.d gDJ;
    private int gUq;
    public ExpandableTextView hNC;
    private View hND;
    private FrameLayout hNE;
    private TextView hNF;
    private boolean hNG;
    private boolean hNH;
    private boolean hNI;
    private View hNJ;
    private View hNK;
    private c hNL;
    public com.baidu.tieba.frs.videomiddlepage.a.a hNM;
    private C0621a hNN;
    private VideoNetworkStateTipView hNO;
    private b hNP;
    private com.baidu.mcn.c hNQ;
    private com.baidu.tieba.lego.card.view.g hNR;
    private boolean hNS;
    private boolean hNT;
    private boolean hNU;
    private Animation.AnimationListener hNV;
    private Animation.AnimationListener hNW;
    private Runnable hNX;
    private Runnable hNY;
    public FrameLayout hsF;
    public FrameLayout hsG;
    public HeadImageView hsM;
    public com.baidu.tieba.play.c hsT;
    public com.baidu.tieba.frs.aggregation.g hsU;
    private com.baidu.tieba.frs.aggregation.h hsV;
    private y hsW;
    private y hsX;
    private boolean hsY;
    private boolean hsZ;
    private boolean htc;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.hsY = true;
        this.htc = true;
        this.hNH = false;
        this.hNI = false;
        this.hNS = false;
        this.hNT = false;
        this.hNU = false;
        this.startPosition = -1L;
        this.gUq = 0;
        this.hNV = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hNJ != null) {
                    a.this.hNJ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hNJ != null) {
                    a.this.hNJ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hNW = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hNJ != null) {
                    a.this.hNJ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hNJ != null) {
                    a.this.hNJ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hNX = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hNE.getVisibility() == 0) {
                    a.this.hNE.setVisibility(8);
                }
            }
        };
        this.hNY = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hsT != null) {
                    a.this.hsT.stopPlay();
                }
            }
        };
        this.htc = z;
        this.mFrom = str;
        this.dCp = str2;
        this.hNP = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hsF = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hND = view.findViewById(R.id.card_container);
        this.hsG = (FrameLayout) view.findViewById(R.id.video_container);
        this.hsT = new com.baidu.tieba.play.c(tbPageContext, this.hsG, false, com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test") ? 1 : 0);
        this.hsT.tm(z);
        this.hsT.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.hNM != null && a.this.hsU.htu.videoDuration > 8) {
                    a.this.hNM.aZ(a.this.mPosition, a.this.hsU.htu.videoUrl);
                }
            }
        });
        this.hsT.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void nQ(boolean z2) {
                if (a.this.hNN != null) {
                    if (z2) {
                        a.this.hNN.vF(0);
                    } else {
                        a.this.hNN.vF(1);
                    }
                }
            }
        });
        this.hsT.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.hNC = (ExpandableTextView) view.findViewById(R.id.title);
        this.hsM = (HeadImageView) view.findViewById(R.id.user_icon);
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
        this.hNE = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.hNF = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.hNE.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hNF.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_link_url", null);
        this.hNF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aUZ().a((TbPageContext) i.G(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.hNO = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.hNO.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.hNO.setHasAgreeToPlay(true);
                a.this.hsT.ts(false);
                a.this.hNO.dlf();
                if (a.this.gDJ.pE()) {
                    a.this.gDJ.resume();
                } else if (a.this.hsU != null && a.this.hsU.htu != null) {
                    a.this.hsT.eW(a.this.hsU.htu.videoUrl, a.this.hsU.threadId);
                }
            }
        });
        this.hNJ = view.findViewById(R.id.video_agg_container_foreground);
        this.hNK = view.findViewById(R.id.title_and_comment_container_foreground);
        this.hNJ.setOnClickListener(this);
        this.dVX.setOnClickListener(this);
        this.dWa.setOnClickListener(this);
        this.hNC.setOnClickListener(this);
        this.hsM.setOnClickListener(this);
        this.agw.setOnClickListener(this);
        this.hND.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.gUq = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsF.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hsF.setLayoutParams(layoutParams);
        this.hsM.setIsRound(true);
        this.hsM.setPlaceHolder(1);
        this.fbO = new n(tbPageContext.getPageActivity());
        this.hsV = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.boW = new AlphaAnimation(0.0f, 0.7f);
        this.boW.setDuration(500L);
        this.boW.setAnimationListener(this.hNW);
        this.boX = new AlphaAnimation(0.7f, 0.0f);
        this.boX.setDuration(500L);
        this.boX.setAnimationListener(this.hNV);
        this.hNN = new C0621a();
        this.gDJ = new com.baidu.afd.videopaster.d(getContext(), this.hsG);
        this.hNQ = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dVU.onChangeSkinType(i);
        this.dVV.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dVY.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aUV().a(this.dVW, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUV().a(this.dVZ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hNC.onChangeSkinType();
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
        if (gVar != null && gVar.htu != null) {
            boolean z = this.hsU == gVar;
            this.hsU = gVar;
            this.dJS = this.hsU.autoPlay;
            this.hNI = false;
            nO(false);
            this.hNC.setVisibility(0);
            this.hNC.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.hNC.setTextColor(R.color.cp_cont_a);
            this.hNC.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.htu != null && !StringUtils.isNull(gVar.htu.mcnLeadPage)) {
                this.hNC.setTextMaxLine(2);
                this.hNC.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.hNC.getContentView(), gVar.title, gVar.htu.mcnLeadPage, gVar.getThreadId());
            } else {
                this.hNC.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.hNC.setExpandable(true);
                this.hNC.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nR(boolean z2) {
                        a.this.hsU.isTitleExpanded = z2;
                    }
                });
                this.hNC.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.gUq) {
                this.hsT.cQo();
                this.gUq = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hsG.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hsG.setLayoutParams(layoutParams);
            }
            ccA();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.hsU = gVar;
        this.dJS = this.hsU.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean ccz() {
        try {
            int parseInt = Integer.parseInt(this.hsU.htu.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.hsU.htu.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void ccA() {
        if (!ccz()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsF.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hsF.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsF.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hsF.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.htu != null) {
            this.hsT.stopPlay();
            this.hsT.setIsNeedRecoveryVideoPlayer(true);
            this.hsT.tt(true);
            this.hsT.tp(true);
            this.hsT.tu(true);
            this.hsT.an(false, false);
            this.hsT.BF(i);
            this.hsT.a(new c.InterfaceC0703c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pM() {
                    a.this.ccE();
                    if (a.this.gDJ != null) {
                        a.this.gDJ.pM();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pN() {
                    a.this.ccF();
                    if (a.this.hsT.pO()) {
                    }
                    if (a.this.hsZ || (a.this.gDJ != null && a.this.gDJ.pE())) {
                        com.baidu.adp.lib.f.e.ld().removeCallbacks(a.this.hNY);
                        com.baidu.adp.lib.f.e.ld().post(a.this.hNY);
                    }
                    if (a.this.gDJ != null) {
                        a.this.gDJ.pN();
                    }
                }
            });
            this.hsT.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bXw() {
                    if (a.this.hsU != null && a.this.hsU.htu != null && com.baidu.adp.lib.f.b.toInt(a.this.hsU.htu.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.hsU.htu.videoWidth, 0)) {
                        a.this.hsT.an(false, false);
                    } else {
                        a.this.hsT.an(true, false);
                    }
                    a.this.hsZ = false;
                    a.this.EG(a.this.dJS ? "1" : "2");
                    a.this.onClick(a.this.hsG);
                    if (a.this.Xr != null) {
                        a.this.Xr.a(a.this);
                    }
                    if (a.this.hNR != null) {
                        a.this.hNR.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bXx() {
                    a.this.onClick(a.this.hsF);
                }
            });
            this.hsT.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void nl(boolean z2) {
                    a.this.hsT.eW(a.this.hsU.htu.videoUrl, a.this.hsU.threadId);
                    a.this.EG("2");
                    a.this.onClick(a.this.hsG);
                }
            });
            this.hsT.tl(false);
            if (this.hNQ != null) {
                this.hNQ.reset();
            }
            this.startPosition = -1L;
            this.fbO.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.hsU.htu.htF;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.gDJ.a(a.this.isFullScreen, a.this.hsT != null && a.this.hsT.cPU(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.gDJ.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.hsT.cPU() && !com.baidu.mcn.b.Lx().gg(aVar2.XI)) {
                        boolean z3 = a.this.startPosition >= (aVar2.htx * 1000) + 1000;
                        if (i3 < aVar2.htx * 1000 || i3 >= aVar2.hty * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.hNQ.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.boJ = aVar2.htA;
                                aVar3.boK = aVar2.htB;
                                aVar3.boL = aVar2.XI;
                                aVar3.boI = aVar2.htz;
                                aVar3.fid = a.this.hsU != null ? a.this.hsU.forumId : null;
                                aVar3.tid = a.this.hsU != null ? a.this.hsU.threadId : null;
                                aVar3.boM = 3;
                                if (z3) {
                                    a.this.hNQ.b(aVar3, (ViewGroup) a.this.hsT.cQn());
                                } else {
                                    a.this.hNQ.a(aVar3, (ViewGroup) a.this.hsT.cQn());
                                }
                            }
                        } else if (a.this.hNQ.isShowing()) {
                            a.this.hNQ.dismiss();
                        }
                    }
                }
            });
            this.hsW = new y();
            this.hsW.ais = gVar.threadId;
            this.hsW.mNid = gVar.nid;
            this.hsW.evm = gVar.forumId;
            this.hsW.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hsW.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.hsW.mSource = gVar.source;
            this.hsW.kAl = gVar.weight;
            this.hsW.kAn = this.mFrom;
            this.hsW.kAp = gVar.abtest_tag;
            this.hsW.dCp = this.dCp;
            this.hsW.mExtra = gVar.extra;
            this.hsW.kAs = "0";
            this.hsW.kAo = gVar.getVideoType();
            this.hsX = new y();
            this.hsX.ais = gVar.threadId;
            this.hsX.evm = gVar.forumId;
            this.hsX.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hsX.kAl = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hsX.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hsX.kAn = this.mFrom;
            this.hsX.mSource = gVar.source;
            this.hsX.kAs = "0";
            if (gVar.htu != null) {
                this.hsW.kAq = gVar.htu.videoMd5;
                this.hsX.kAq = gVar.htu.videoMd5;
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
            this.fbO.setVideoStatsData(this.hsW);
            this.hsT.cPW().setBusiness(this.fbO);
            this.fbO.a(gVar);
            this.hsT.cub();
            this.hsT.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.gDJ.a(a.this.isFullScreen, a.this.hsT != null && a.this.hsT.cPU(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.hsZ = true;
                            a.this.hNG = true;
                            a.this.hsY = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.uj(i);
                            a.this.hsT.chf();
                        }
                    }
                }
            });
            this.hsT.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.hsU != null && a.this.hsU.htu != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.hsU.htu.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.gDJ.reset();
            }
            this.gDJ.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void pV() {
                    a.this.hNG = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pU() {
                    if (a.this.isFullScreen) {
                        a.this.hsZ = true;
                        a.this.hNG = true;
                        a.this.hsY = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.uj(i);
                        a.this.hsT.chf();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pT() {
                    if (a.this.hsT != null) {
                        a.this.hsT.BE(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean pW() {
                    return a.this.ccD();
                }
            });
            this.hsT.setThumbnail(gVar.htu.thumbnailUrl);
            this.hsT.BD(gVar.htu.videoDuration);
            this.hsT.setVideoUrl(gVar.htu.videoUrl, gVar.threadId);
            this.hsT.setFid(gVar.forumId);
            this.hsT.chf();
            this.hsT.show();
            nO(false);
            if (gVar.autoPlay) {
                onClick(this.hsG);
                if (this.hNO.cLX()) {
                    this.hsT.tr(false);
                    this.hNO.dle();
                    this.hsT.ts(true);
                    this.hsT.eV(gVar.htu.videoUrl, gVar.threadId);
                    if (this.gDJ.pE()) {
                        this.gDJ.stop();
                        this.gDJ.pJ();
                    }
                } else {
                    this.hsT.ts(false);
                    this.hsT.tr(false);
                    this.hNO.hide();
                    if (this.gDJ == null || (this.gDJ != null && !this.gDJ.pE())) {
                        this.hsT.a(gVar.htu.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.htv) {
                    this.hNJ.setVisibility(8);
                    this.hNN.vF(3);
                } else {
                    if (this.hNJ.getVisibility() == 0) {
                        this.hNJ.startAnimation(this.boX);
                    }
                    this.hNN.vF(0);
                }
                gVar.htv = false;
            } else {
                this.hNJ.setVisibility(0);
                this.hNO.hide();
                this.hsT.tr(true);
                this.hNN.vF(3);
                this.hsT.eV(gVar.htu.videoUrl, gVar.threadId);
            }
            this.hsZ = false;
            this.hNG = false;
            if (!z && this.gDJ.pE()) {
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
        com.baidu.afd.videopaster.data.b Fm = this.hNP != null ? this.hNP.Fm(gVar.getThreadId()) : null;
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
        if (gVar.htu != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.htu.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.htu.videoHeight, 0);
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
        if (this.hsU != null && this.hsU.htu != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hsU.htu.videoMd5, "", str, this.hsX);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hsT.pO();
    }

    public boolean ccB() {
        return this.gDJ.pE();
    }

    public void bXs() {
        if (isPlaying()) {
            this.hsT.avT();
        }
    }

    public boolean uk(int i) {
        if (i == 4 && this.gDJ != null && ((this.gDJ.pE() || this.hNG) && this.hsT != null)) {
            this.gDJ.aK(i);
            if (this.isFullScreen) {
                if (this.gDJ.pD()) {
                    this.hsT.cPV();
                } else {
                    this.hsT.GV();
                }
                return true;
            }
        }
        return this.hsT.BE(i);
    }

    public void bXt() {
        this.hNI = false;
        this.hsT.stopPlay();
        if (this.hNC != null) {
            this.hNC.setVisibility(0);
        }
        if (this.hNN != null) {
            this.hNN.vF(2);
        }
        nO(false);
        this.hNH = true;
        if (this.gDJ != null && this.gDJ.pE()) {
            this.gDJ.stop();
        }
    }

    public void ccC() {
        this.gDJ.stop();
    }

    public void bXu() {
        if (this.hsT != null) {
            this.hsT.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        bXu();
        if (this.hsV != null) {
            this.hsV.bXE();
        }
        if (this.hNJ != null) {
            this.hNJ.clearAnimation();
        }
        this.gDJ.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.htt != null) {
            this.agw.setText(TextUtils.isEmpty(gVar.htt.userNickname) ? gVar.htt.userName : gVar.htt.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.htt != null) {
            if (gVar.htt.htE != null && !TextUtils.isEmpty(gVar.htt.htE.avatar)) {
                this.hsM.startLoad(gVar.htt.htE.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.htt.portrait) && gVar.htt.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hsM.startLoad(gVar.htt.portrait, 10, false);
            } else {
                this.hsM.startLoad(gVar.htt.portrait, 12, false);
            }
            if (gVar.htt.htE != null && gVar.htt.htE.auth_id.intValue() > 0) {
                this.hsM.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.htt.htE.auth_id.intValue(), 1));
                this.hsM.setShowV(true);
                this.hsM.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hsM.setBjhAuthIconRes(0);
            if (gVar.htt.isBigV) {
                this.hsM.setShowV(gVar.htt.isBigV);
                this.hsM.setIsBigV(gVar.htt.isBigV);
            } else if (gVar.htt.isGod) {
                this.hsM.setShowV(gVar.htt.isGod);
                this.hsM.setIsBigV(gVar.htt.isGod);
            } else {
                this.hsM.setShowV(gVar.htt.isGod);
                this.hsM.setIsBigV(gVar.htt.isGod);
            }
            this.hsM.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aSp() != null) {
                gVar.aSp().isInThread = true;
                gVar.aSp().nid = gVar.nid;
                if (this.hsU.getVideoType() == 1) {
                    gVar.aSp().cardType = 2;
                } else if (this.hsU.getVideoType() == 2) {
                    gVar.aSp().cardType = 8;
                } else if (this.hsU.getVideoType() == 3) {
                    gVar.aSp().cardType = 6;
                }
                gVar.aSp().baijiahaoData = gVar.mBaijiahao;
                gVar.aSp().recomSource = gVar.source;
                gVar.aSp().recomWeight = gVar.weight;
                gVar.aSp().recomAbTag = gVar.abtest_tag;
                gVar.aSp().recomExtra = gVar.extra;
            }
            if (this.hsU.mBaijiahao != null) {
                this.dVU.setAgreeAlone(true);
            }
            this.dVU.setIsFromMiddlePage(true);
            this.dVU.setData(gVar.aSp());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dVV.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aUV().a(this.dVW, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            SvgManager.aUV().a(this.dVZ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dVY.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dVY.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hsT != null && this.hsG != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hsY) {
                this.hsT.cQc();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                ccE();
            } else {
                configuration.orientation = 1;
                ccF();
                this.hsY = true;
            }
            this.hsT.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccD() {
        if (this.hsT != null && this.hsG != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hsG.getParent() != null) {
                if (this.hsG.getParent() == frameLayout) {
                    if (this.hNS) {
                        this.hNS = false;
                        return true;
                    } else if (!this.hNT) {
                        this.hNT = true;
                        return true;
                    }
                } else if (this.hsG.getParent() == this.hsF) {
                    if (this.hNT) {
                        this.hNT = false;
                        this.hNU = true;
                        return true;
                    } else if (!this.hNS && this.hNU) {
                        this.hNS = true;
                        this.hNU = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccE() {
        if (this.hsT != null && this.hsG != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hsG.getParent() != null) {
                if (this.hsG.getParent() == frameLayout) {
                    frameLayout.removeView(this.hsG);
                } else if (this.hsG.getParent() == this.hsF) {
                    this.hsF.removeView(this.hsG);
                }
            }
            if (this.hsG.getParent() == null) {
                frameLayout.addView(this.hsG);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hsG.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hsG.setLayoutParams(layoutParams);
                if (this.hNQ != null && this.hNQ.isShowing()) {
                    this.hNQ.dismiss();
                }
                com.baidu.tbadk.util.d.bgn().iu(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccF() {
        if (this.hsT != null && this.hsG != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hsG.getParent() != null) {
                if (this.hsG.getParent() == frameLayout) {
                    ccG();
                    frameLayout.removeView(this.hsG);
                } else if (this.hsG.getParent() == this.hsF) {
                    ccG();
                    this.hsF.removeView(this.hsG);
                }
            }
            if (this.hsG.getParent() == null) {
                this.hsF.addView(this.hsG, 0);
                ccH();
                this.hsT.cub();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.bgn().iu(false);
            }
        }
    }

    private void ccG() {
        if (this.gDJ != null && this.gDJ.pE()) {
            this.gDJ.az(true);
        }
    }

    private void ccH() {
        int i;
        if (!ccz()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hsG.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bKS() != null) {
            view.setTag(this);
            bKS().a(view, this.hsU);
        }
        if (view == this.hsM || view == this.agw) {
            if (this.hsU != null && this.hsU.htt != null && !TextUtils.isEmpty(this.hsU.htt.userId)) {
                this.hNN.vF(0);
                if (!TbadkCoreApplication.isLogin() || !this.hsU.htt.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hsU.htt.userId, 0L), z, this.hsU.htt.isGod)));
            }
        } else if (view == this.dVX) {
            if (this.hsU != null) {
                this.hNN.vF(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hsU.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.hsU.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hNC || view == this.hND) {
            if (this.hsU != null) {
                if (this.hNN.getCurrentState() != 2 && this.hNN.getCurrentState() != 3) {
                    z = false;
                }
                this.hNN.vF(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.hsU.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.hsU.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dWa) {
            this.hNN.vF(0);
            aWI();
        } else if (view == this.hNJ && this.hNJ.getVisibility() == 0 && this.hNL != null) {
            this.hNL.vJ(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void nk(boolean z) {
        if (this.hsU != null && this.hsU.htt != null) {
            this.hsU.htt.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bXv() {
        if (this.hsU != null) {
            this.dVU.aVP();
        }
    }

    public void nN(boolean z) {
        if (this.hsF != null) {
            this.hsF.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.hNR = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.hNL = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Xr = fVar;
    }

    private void nO(boolean z) {
        this.hNH = this.mPosition == (this.hNM == null ? -1 : this.hNM.ccT());
        if (this.hNH && z && isPlaying() && this.dJS && !this.hNI) {
            this.hNE.setVisibility(0);
            this.hNI = true;
            this.hNE.postDelayed(this.hNX, 5000L);
            if (this.hNM != null) {
                this.hNM.ei(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.hNE.setVisibility(8);
        if (this.hNX != null) {
            this.hNE.removeCallbacks(this.hNX);
        }
    }

    private void aWI() {
        String str;
        String str2;
        if (this.hsU != null && this.mContext != null) {
            String valueOf = String.valueOf(this.hsU.forumId);
            String str3 = this.hsU.title;
            if (this.hsU.mBaijiahao != null) {
                str = this.hsU.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.hsU.mBaijiahao.oriUgcType + "&dvid=" + this.hsU.mBaijiahao.oriUgcVid + "&nid=" + this.hsU.mBaijiahao.oriUgcNid;
            } else {
                str = this.hsU.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.hsU.htu.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.hsU.title;
            String format = (this.hsU.mBaijiahao == null || this.hsU.htt == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.hsU.htt.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.hsU.mBaijiahao != null) {
                shareItem.eeT = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.eeT = str6;
                shareItem.readCount = this.hsU.playCount;
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
            if (this.hsU.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.hsU.mBaijiahao;
            shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.dh("tid", str);
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.ag("obj_locate", 12);
            anVar.dh("nid", this.hsU.nid);
            if (this.hsU.mBaijiahao != null && !aq.isEmpty(this.hsU.mBaijiahao.oriUgcVid)) {
                anVar.dh("obj_param6", this.hsU.mBaijiahao.oriUgcVid);
            }
            if (this.hsU.getVideoType() == 1) {
                anVar.ag(IntentConfig.CARD_TYPE, 2);
            } else if (this.hsU.getVideoType() == 2) {
                anVar.ag(IntentConfig.CARD_TYPE, 8);
            } else if (this.hsU.getVideoType() == 3) {
                anVar.ag(IntentConfig.CARD_TYPE, 6);
            }
            anVar.dh(IntentConfig.RECOM_SOURCE, this.hsU.source);
            anVar.dh("ab_tag", this.hsU.abtest_tag);
            anVar.dh("weight", this.hsU.weight);
            anVar.dh("extra", this.hsU.extra);
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
            com.baidu.tieba.c.e.bMw().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bXt();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void avT() {
        bXs();
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

    public void ccI() {
        this.gDJ.resume();
    }

    public boolean ccJ() {
        if (this.hNN != null) {
            return this.hNN.getCurrentState() == 2 || this.hNN.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0621a {
        private Runnable hOc;
        private int mCurrentState;

        private C0621a() {
            this.mCurrentState = -1;
            this.hOc = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(C0621a.this.hOc);
                    C0621a.this.vF(2);
                }
            };
        }

        public void vF(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = vG(i);
                    ccK();
                    return;
                case 1:
                    this.mCurrentState = vG(i);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hOc);
                    return;
                case 2:
                    this.mCurrentState = vH(i);
                    return;
                case 3:
                    this.mCurrentState = vI(i);
                    ccK();
                    return;
                default:
                    this.mCurrentState = vH(i);
                    return;
            }
        }

        private void ccK() {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hOc);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.hOc, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int vG(int i) {
            if (i != this.mCurrentState) {
                a.this.hNK.setVisibility(8);
                a.this.nP(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vH(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.hNK.setVisibility(0);
                if (i2 != 3 || a.this.hsU.autoPlay) {
                    a.this.nP(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vI(int i) {
            if (i != this.mCurrentState) {
                a.this.hNK.setVisibility(0);
                a.this.nP(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
