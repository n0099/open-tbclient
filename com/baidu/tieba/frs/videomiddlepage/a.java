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
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f DG;
    public TextView Nm;
    private Animation aLM;
    private Animation aLN;
    private String cPf;
    private boolean cWz;
    protected AgreeView dhG;
    private TextView dhH;
    private ImageView dhI;
    private View dhJ;
    private TextView dhK;
    private ImageView dhL;
    private View dhM;
    private n elC;
    private com.baidu.afd.videopaster.d fKi;
    private int fYX;
    public ExpandableTextView gOK;
    private View gOL;
    private FrameLayout gOM;
    private TextView gON;
    private boolean gOO;
    private boolean gOP;
    private boolean gOQ;
    private View gOR;
    private View gOS;
    private c gOT;
    public com.baidu.tieba.frs.videomiddlepage.a.a gOU;
    private C0513a gOV;
    private VideoNetworkStateTipView gOW;
    private b gOX;
    private com.baidu.mcn.c gOY;
    private com.baidu.tieba.lego.card.view.g gOZ;
    private boolean gPa;
    private boolean gPb;
    private boolean gPc;
    private Animation.AnimationListener gPd;
    private Animation.AnimationListener gPe;
    private Runnable gPf;
    private Runnable gPg;
    public FrameLayout guA;
    public FrameLayout guB;
    public HeadImageView guH;
    public com.baidu.tieba.play.c guO;
    public com.baidu.tieba.frs.aggregation.g guP;
    private com.baidu.tieba.frs.aggregation.h guQ;
    private y guR;
    private y guS;
    private boolean guT;
    private boolean guU;
    private boolean guX;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.guT = true;
        this.guX = true;
        this.gOP = false;
        this.gOQ = false;
        this.gPa = false;
        this.gPb = false;
        this.gPc = false;
        this.startPosition = -1L;
        this.fYX = 0;
        this.gPd = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gOR != null) {
                    a.this.gOR.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gOR != null) {
                    a.this.gOR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gPe = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gOR != null) {
                    a.this.gOR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gOR != null) {
                    a.this.gOR.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gPf = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gOM.getVisibility() == 0) {
                    a.this.gOM.setVisibility(8);
                }
            }
        };
        this.gPg = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.guO != null) {
                    a.this.guO.stopPlay();
                }
            }
        };
        this.guX = z;
        this.mFrom = str;
        this.cPf = str2;
        this.gOX = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.guA = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gOL = view.findViewById(R.id.card_container);
        this.guB = (FrameLayout) view.findViewById(R.id.video_container);
        this.guO = new com.baidu.tieba.play.c(tbPageContext, this.guB, false, com.baidu.tbadk.a.b.rH("cyber_player_test") || com.baidu.tbadk.a.b.rG("cyber_player_test") ? 1 : 0);
        this.guO.rK(z);
        this.guO.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.gOU != null && a.this.guP.gvp.videoDuration > 8) {
                    a.this.gOU.aF(a.this.mPosition, a.this.guP.gvp.videoUrl);
                }
            }
        });
        this.guO.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void mr(boolean z2) {
                if (a.this.gOV != null) {
                    if (z2) {
                        a.this.gOV.uB(0);
                    } else {
                        a.this.gOV.uB(1);
                    }
                }
            }
        });
        this.guO.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.gOK = (ExpandableTextView) view.findViewById(R.id.title);
        this.guH = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nm = (TextView) view.findViewById(R.id.user_name);
        this.dhG = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNQ = 2;
        dVar.cNV = 6;
        this.dhG.setStatisticData(dVar);
        this.dhH = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dhI = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dhJ = view.findViewById(R.id.thread_info_commont_container);
        this.dhK = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dhL = (ImageView) view.findViewById(R.id.share_num_img);
        this.dhM = view.findViewById(R.id.share_num_container);
        this.gOM = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.gON = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.gOM.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gON.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_download_link_url", null);
        this.gON.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGK().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.gOW = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.gOW.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.gOW.setHasAgreeToPlay(true);
                a.this.guO.rQ(false);
                a.this.gOW.cSQ();
                if (a.this.fKi.kU()) {
                    a.this.fKi.resume();
                } else if (a.this.guP != null && a.this.guP.gvp != null) {
                    a.this.guO.eg(a.this.guP.gvp.videoUrl, a.this.guP.threadId);
                }
            }
        });
        this.gOR = view.findViewById(R.id.video_agg_container_foreground);
        this.gOS = view.findViewById(R.id.title_and_comment_container_foreground);
        this.gOR.setOnClickListener(this);
        this.dhJ.setOnClickListener(this);
        this.dhM.setOnClickListener(this);
        this.gOK.setOnClickListener(this);
        this.guH.setOnClickListener(this);
        this.Nm.setOnClickListener(this);
        this.gOL.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.fYX = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.guA.setLayoutParams(layoutParams);
        this.guH.setIsRound(true);
        this.guH.setPlaceHolder(1);
        this.elC = new n(tbPageContext.getPageActivity());
        this.guQ = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.aLM = new AlphaAnimation(0.0f, 0.7f);
        this.aLM.setDuration(500L);
        this.aLM.setAnimationListener(this.gPe);
        this.aLN = new AlphaAnimation(0.7f, 0.0f);
        this.aLN.setDuration(500L);
        this.aLN.setAnimationListener(this.gPd);
        this.gOV = new C0513a();
        this.fKi = new com.baidu.afd.videopaster.d(getContext(), this.guB);
        this.gOY = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dhG.onChangeSkinType(i);
        this.dhH.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dhK.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aGG().a(this.dhI, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.dhL, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.gOK.onChangeSkinType();
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
        if (gVar != null && gVar.gvp != null) {
            boolean z = this.guP == gVar;
            this.guP = gVar;
            this.cWz = this.guP.autoPlay;
            this.gOQ = false;
            mp(false);
            this.gOK.setVisibility(0);
            this.gOK.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.gOK.setTextColor(R.color.cp_cont_a);
            this.gOK.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.gvp != null && !StringUtils.isNull(gVar.gvp.mcnLeadPage)) {
                this.gOK.setTextMaxLine(2);
                this.gOK.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.gOK.getContentView(), gVar.title, gVar.gvp.mcnLeadPage, gVar.getThreadId());
            } else {
                this.gOK.setTextMaxLine(Integer.MAX_VALUE);
                this.gOK.setExpandable(true);
                this.gOK.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void ms(boolean z2) {
                        a.this.guP.isTitleExpanded = z2;
                    }
                });
                this.gOK.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.fYX) {
                this.guO.cyM();
                this.fYX = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.guB.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.guB.setLayoutParams(layoutParams);
            }
            bLx();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bLw() {
        try {
            int parseInt = Integer.parseInt(this.guP.gvp.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.guP.gvp.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bLx() {
        if (!bLw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.guA.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.guA.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.gvp != null) {
            this.guO.stopPlay();
            this.guO.setIsNeedRecoveryVideoPlayer(true);
            this.guO.rR(true);
            this.guO.rN(true);
            this.guO.rS(true);
            this.guO.aj(false, false);
            this.guO.Av(i);
            this.guO.a(new c.InterfaceC0590c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void lc() {
                    a.this.bLB();
                    if (a.this.fKi != null) {
                        a.this.fKi.lc();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void ld() {
                    a.this.bLC();
                    if (a.this.guO.le()) {
                    }
                    if (a.this.guU || (a.this.fKi != null && a.this.fKi.kU())) {
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(a.this.gPg);
                        com.baidu.adp.lib.f.e.gx().post(a.this.gPg);
                    }
                    if (a.this.fKi != null) {
                        a.this.fKi.ld();
                    }
                }
            });
            this.guO.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bGA() {
                    if (a.this.guP != null && a.this.guP.gvp != null && com.baidu.adp.lib.f.b.toInt(a.this.guP.gvp.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.guP.gvp.videoWidth, 0)) {
                        a.this.guO.aj(false, false);
                    } else {
                        a.this.guO.aj(true, false);
                    }
                    a.this.guU = false;
                    a.this.Bk(a.this.cWz ? "1" : "2");
                    a.this.onClick(a.this.guB);
                    if (a.this.DG != null) {
                        a.this.DG.a(a.this);
                    }
                    if (a.this.gOZ != null) {
                        a.this.gOZ.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGB() {
                    a.this.onClick(a.this.guA);
                }
            });
            this.guO.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void lM(boolean z2) {
                    a.this.guO.eg(a.this.guP.gvp.videoUrl, a.this.guP.threadId);
                    a.this.Bk("2");
                    a.this.onClick(a.this.guB);
                }
            });
            this.guO.rJ(false);
            if (this.gOY != null) {
                this.gOY.reset();
            }
            this.startPosition = -1L;
            this.elC.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void bz(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.guP.gvp.gvA;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.fKi.a(a.this.isFullScreen, a.this.guO != null && a.this.guO.cys(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.fKi.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.guO.cys() && !com.baidu.mcn.b.DN().eA(aVar2.DZ)) {
                        boolean z3 = a.this.startPosition >= (aVar2.gvs * 1000) + 1000;
                        if (i3 < aVar2.gvs * 1000 || i3 >= aVar2.gvt * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.gOY.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aLz = aVar2.gvv;
                                aVar3.aLA = aVar2.gvw;
                                aVar3.aLB = aVar2.DZ;
                                aVar3.aLy = aVar2.gvu;
                                aVar3.fid = a.this.guP != null ? a.this.guP.forumId : null;
                                aVar3.tid = a.this.guP != null ? a.this.guP.threadId : null;
                                aVar3.aLC = 3;
                                if (z3) {
                                    a.this.gOY.b(aVar3, (ViewGroup) a.this.guO.cyL());
                                } else {
                                    a.this.gOY.a(aVar3, (ViewGroup) a.this.guO.cyL());
                                }
                            }
                        } else if (a.this.gOY.isShowing()) {
                            a.this.gOY.dismiss();
                        }
                    }
                }
            });
            this.guR = new y();
            this.guR.Pk = gVar.threadId;
            this.guR.emF = gVar.forumId;
            this.guR.mUid = TbadkCoreApplication.getCurrentAccount();
            this.guR.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.guR.mSource = gVar.source;
            this.guR.jyr = gVar.weight;
            this.guR.jyt = this.mFrom;
            this.guR.mAbTag = gVar.abtest_tag;
            this.guR.cPf = this.cPf;
            this.guR.mExtra = gVar.extra;
            this.guR.jyx = "0";
            this.guR.jyu = gVar.getVideoType();
            this.guS = new y();
            this.guS.Pk = gVar.threadId;
            this.guS.emF = gVar.forumId;
            this.guS.mUid = TbadkCoreApplication.getCurrentAccount();
            this.guS.jyr = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.guS.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.guS.jyt = this.mFrom;
            this.guS.mSource = gVar.source;
            this.guS.jyx = "0";
            if (gVar.gvp != null) {
                this.guR.jyv = gVar.gvp.videoMd5;
                this.guS.jyv = gVar.gvp.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cx("tid", gVar.threadId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", i);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cx("fid", gVar.forumId);
            anVar.cx("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cx("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cx("obj_id", this.cPf);
            anVar.cx(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.cx("obj_type", this.mFrom);
            anVar.X("obj_param5", gVar.getVideoType());
            anVar.cx("obj_source", aq.isEmpty(this.guP.source) ? "0" : this.guP.source);
            anVar.X("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.cx("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.cx("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.elC.setVideoStatsData(this.guR);
            this.guO.cyu().setBusiness(this.elC);
            this.elC.a(gVar);
            this.guO.cda();
            this.guO.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.fKi.a(a.this.isFullScreen, a.this.guO != null && a.this.guO.cys(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.guU = true;
                            a.this.gOO = true;
                            a.this.guT = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.tg(i);
                            a.this.guO.bQh();
                        }
                    }
                }
            });
            this.guO.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.guP != null && a.this.guP.gvp != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.guP.gvp.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.fKi.reset();
            }
            this.fKi.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void ll() {
                    a.this.gOO = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lk() {
                    if (a.this.isFullScreen) {
                        a.this.guU = true;
                        a.this.gOO = true;
                        a.this.guT = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.tg(i);
                        a.this.guO.bQh();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lj() {
                    if (a.this.guO != null) {
                        a.this.guO.Au(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean lm() {
                    return a.this.bLA();
                }
            });
            this.guO.setThumbnail(gVar.gvp.thumbnailUrl);
            this.guO.At(gVar.gvp.videoDuration);
            this.guO.setVideoUrl(gVar.gvp.videoUrl, gVar.threadId);
            this.guO.setFid(gVar.forumId);
            this.guO.bQh();
            this.guO.show();
            mp(false);
            if (gVar.autoPlay) {
                onClick(this.guB);
                if (this.gOW.cuv()) {
                    this.guO.rP(false);
                    this.gOW.cSP();
                    this.guO.rQ(true);
                    this.guO.ef(gVar.gvp.videoUrl, gVar.threadId);
                    if (this.fKi.kU()) {
                        this.fKi.stop();
                        this.fKi.kZ();
                    }
                } else {
                    this.guO.rQ(false);
                    this.guO.rP(false);
                    this.gOW.hide();
                    if (this.fKi == null || (this.fKi != null && !this.fKi.kU())) {
                        this.guO.a(gVar.gvp.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.gvq) {
                    this.gOR.setVisibility(8);
                    this.gOV.uB(3);
                } else {
                    if (this.gOR.getVisibility() == 0) {
                        this.gOR.startAnimation(this.aLN);
                    }
                    this.gOV.uB(0);
                }
                gVar.gvq = false;
            } else {
                this.gOR.setVisibility(0);
                this.gOW.hide();
                this.guO.rP(true);
                this.gOV.uB(3);
                this.guO.ef(gVar.gvp.videoUrl, gVar.threadId);
            }
            this.guU = false;
            this.gOO = false;
            if (!z && this.fKi.kU()) {
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
        com.baidu.afd.videopaster.data.b BS = this.gOX != null ? this.gOX.BS(gVar.getThreadId()) : null;
        if (BS == null) {
            return null;
        }
        int lq = BS.lq();
        int lr = BS.lr();
        int lp = BS.lp();
        if (lp != -1) {
            i = lq != -1 ? (lp - lq) - 1 : -1;
            if (lr != -1) {
                i4 = (lr - lp) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.gvp != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.gvp.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.gvp.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", lp + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk(String str) {
        if (this.guP != null && this.guP.gvp != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.guP.gvp.videoMd5, "", str, this.guS);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.guO.le();
    }

    public boolean bLy() {
        return this.fKi.kU();
    }

    public void bGw() {
        if (isPlaying()) {
            this.guO.pausePlay();
        }
    }

    public boolean th(int i) {
        if (i == 4 && this.fKi != null && ((this.fKi.kU() || this.gOO) && this.guO != null)) {
            this.fKi.ax(i);
            if (this.isFullScreen) {
                if (this.fKi.kT()) {
                    this.guO.cyt();
                } else {
                    this.guO.Ah();
                }
                return true;
            }
        }
        return this.guO.Au(i);
    }

    public void bGx() {
        this.gOQ = false;
        this.guO.stopPlay();
        if (this.gOK != null) {
            this.gOK.setVisibility(0);
        }
        if (this.gOV != null) {
            this.gOV.uB(2);
        }
        mp(false);
        this.gOP = true;
        if (this.fKi != null && this.fKi.kU()) {
            this.fKi.stop();
        }
    }

    public void bLz() {
        this.fKi.stop();
    }

    public void bGy() {
        if (this.guO != null) {
            this.guO.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGy();
        if (this.guQ != null) {
            this.guQ.bGI();
        }
        if (this.gOR != null) {
            this.gOR.clearAnimation();
        }
        this.fKi.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.gvo != null) {
            this.Nm.setText(TextUtils.isEmpty(gVar.gvo.userNickname) ? gVar.gvo.userName : gVar.gvo.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.gvo != null) {
            if (gVar.gvo.gvz != null && !TextUtils.isEmpty(gVar.gvo.gvz.avatar)) {
                this.guH.startLoad(gVar.gvo.gvz.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.gvo.portrait) && gVar.gvo.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.guH.startLoad(gVar.gvo.portrait, 10, false);
            } else {
                this.guH.startLoad(gVar.gvo.portrait, 12, false);
            }
            if (gVar.gvo.gvz != null && gVar.gvo.gvz.auth_id.intValue() > 0) {
                this.guH.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.gvo.gvz.auth_id.intValue(), 1));
                this.guH.setShowV(true);
                this.guH.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.guH.setBjhAuthIconRes(0);
            if (gVar.gvo.isBigV) {
                this.guH.setShowV(gVar.gvo.isBigV);
                this.guH.setIsBigV(gVar.gvo.isBigV);
            } else if (gVar.gvo.isGod) {
                this.guH.setShowV(gVar.gvo.isGod);
                this.guH.setIsBigV(gVar.gvo.isGod);
            } else {
                this.guH.setShowV(gVar.gvo.isGod);
                this.guH.setIsBigV(gVar.gvo.isGod);
            }
            this.guH.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aEe() != null) {
                gVar.aEe().isInThread = true;
            }
            if (this.guP.mBaijiahao != null) {
                this.dhG.setAgreeAlone(true);
            }
            this.dhG.setIsFromMiddlePage(true);
            this.dhG.setData(gVar.aEe());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhH.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGG().a(this.dhI, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dhH.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dhH.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhK.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGG().a(this.dhL, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dhK.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dhK.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.guO != null && this.guB != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.guT) {
                this.guO.cyA();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bLB();
            } else {
                configuration.orientation = 1;
                bLC();
                this.guT = true;
            }
            this.guO.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLA() {
        if (this.guO != null && this.guB != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.guB.getParent() != null) {
                if (this.guB.getParent() == frameLayout) {
                    if (this.gPa) {
                        this.gPa = false;
                        return true;
                    } else if (!this.gPb) {
                        this.gPb = true;
                        return true;
                    }
                } else if (this.guB.getParent() == this.guA) {
                    if (this.gPb) {
                        this.gPb = false;
                        this.gPc = true;
                        return true;
                    } else if (!this.gPa && this.gPc) {
                        this.gPa = true;
                        this.gPc = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLB() {
        if (this.guO != null && this.guB != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.guB.getParent() != null) {
                if (this.guB.getParent() == frameLayout) {
                    frameLayout.removeView(this.guB);
                } else if (this.guB.getParent() == this.guA) {
                    this.guA.removeView(this.guB);
                }
            }
            if (this.guB.getParent() == null) {
                frameLayout.addView(this.guB);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.guB.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.guB.setLayoutParams(layoutParams);
                if (this.gOY != null && this.gOY.isShowing()) {
                    this.gOY.dismiss();
                }
                com.baidu.tbadk.util.d.aRW().ha(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLC() {
        if (this.guO != null && this.guB != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.guB.getParent() != null) {
                if (this.guB.getParent() == frameLayout) {
                    bLD();
                    frameLayout.removeView(this.guB);
                } else if (this.guB.getParent() == this.guA) {
                    bLD();
                    this.guA.removeView(this.guB);
                }
            }
            if (this.guB.getParent() == null) {
                this.guA.addView(this.guB, 0);
                bLE();
                this.guO.cda();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.aRW().ha(false);
            }
        }
    }

    private void bLD() {
        if (this.fKi != null && this.fKi.kU()) {
            this.fKi.Y(true);
        }
    }

    private void bLE() {
        int i;
        if (!bLw()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.guB.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (buM() != null) {
            view.setTag(this);
            buM().a(view, this.guP);
        }
        if (view == this.guH || view == this.Nm) {
            if (this.guP != null && this.guP.gvo != null && !TextUtils.isEmpty(this.guP.gvo.userId)) {
                this.gOV.uB(0);
                if (!TbadkCoreApplication.isLogin() || !this.guP.gvo.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.guP.gvo.userId, 0L), z, this.guP.gvo.isGod)));
            }
        } else if (view == this.dhJ) {
            if (this.guP != null) {
                this.gOV.uB(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.guP.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.guP.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gOK || view == this.gOL) {
            if (this.guP != null) {
                if (this.gOV.getCurrentState() != 2 && this.gOV.getCurrentState() != 3) {
                    z = false;
                }
                this.gOV.uB(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.guP.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.guP.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dhM) {
            this.gOV.uB(0);
            aIh();
        } else if (view == this.gOR && this.gOR.getVisibility() == 0 && this.gOT != null) {
            this.gOT.uF(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lL(boolean z) {
        if (this.guP != null && this.guP.gvo != null) {
            this.guP.gvo.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGz() {
        if (this.guP != null) {
            this.dhG.aHx();
        }
    }

    public void mo(boolean z) {
        if (this.guA != null) {
            this.guA.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.gOZ = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.gOT = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.DG = fVar;
    }

    private void mp(boolean z) {
        this.gOP = this.mPosition == (this.gOU == null ? -1 : this.gOU.bLQ());
        if (this.gOP && z && isPlaying() && this.cWz && !this.gOQ) {
            this.gOM.setVisibility(0);
            this.gOQ = true;
            this.gOM.postDelayed(this.gPf, 5000L);
            if (this.gOU != null) {
                this.gOU.dy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.gOM.setVisibility(8);
        if (this.gPf != null) {
            this.gOM.removeCallbacks(this.gPf);
        }
    }

    private void aIh() {
        String str;
        String str2;
        if (this.guP != null && this.mContext != null) {
            String valueOf = String.valueOf(this.guP.forumId);
            String str3 = this.guP.title;
            if (this.guP.mBaijiahao != null) {
                str = this.guP.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.guP.mBaijiahao.oriUgcType + "&dvid=" + this.guP.mBaijiahao.oriUgcVid + "&nid=" + this.guP.mBaijiahao.oriUgcNid;
            } else {
                str = this.guP.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.guP.gvp.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.guP.title;
            String format = (this.guP.mBaijiahao == null || this.guP.gvo == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.guP.gvo.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.guP.mBaijiahao != null) {
                shareItem.dqC = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.dqC = str6;
                shareItem.readCount = this.guP.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.dqF = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.dqs = true;
            shareItem.dqE = 11;
            shareItem.dqJ = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.guP.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.guP.mBaijiahao;
            shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cx("tid", str);
            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.X("obj_locate", 12);
            TiebaStatic.log(anVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqF);
            bundle.putInt("obj_type", shareItem.dqJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUP);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.bws().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bGx();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bGw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
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

    public void bLF() {
        this.fKi.resume();
    }

    public boolean bLG() {
        if (this.gOV != null) {
            return this.gOV.getCurrentState() == 2 || this.gOV.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0513a {
        private Runnable gPk;
        private int mCurrentState;

        private C0513a() {
            this.mCurrentState = -1;
            this.gPk = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(C0513a.this.gPk);
                    C0513a.this.uB(2);
                }
            };
        }

        public void uB(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uC(i);
                    bLH();
                    return;
                case 1:
                    this.mCurrentState = uC(i);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gPk);
                    return;
                case 2:
                    this.mCurrentState = uD(i);
                    return;
                case 3:
                    this.mCurrentState = uE(i);
                    bLH();
                    return;
                default:
                    this.mCurrentState = uD(i);
                    return;
            }
        }

        private void bLH() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gPk);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gPk, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int uC(int i) {
            if (i != this.mCurrentState) {
                a.this.gOS.setVisibility(8);
                a.this.mq(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uD(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.gOS.setVisibility(0);
                if (i2 != 3 || a.this.guP.autoPlay) {
                    a.this.mq(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int uE(int i) {
            if (i != this.mCurrentState) {
                a.this.gOS.setVisibility(0);
                a.this.mq(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
