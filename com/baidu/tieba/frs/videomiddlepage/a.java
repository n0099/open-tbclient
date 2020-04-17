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
    private com.baidu.tieba.lego.card.view.f WZ;
    public TextView afW;
    private Animation bht;
    private Animation bhu;
    protected AgreeView dHB;
    private TextView dHC;
    private ImageView dHD;
    private View dHE;
    private TextView dHF;
    private ImageView dHG;
    private View dHH;
    private String dol;
    private boolean dvK;
    private n ePc;
    private int gFC;
    private com.baidu.afd.videopaster.d goO;
    public FrameLayout hdL;
    public FrameLayout hdM;
    public HeadImageView hdS;
    public com.baidu.tieba.play.c hdZ;
    public com.baidu.tieba.frs.aggregation.g hea;
    private com.baidu.tieba.frs.aggregation.h heb;
    private y hec;
    private y hed;
    private boolean hee;
    private boolean hef;
    private boolean hei;
    public ExpandableTextView hyJ;
    private View hyK;
    private FrameLayout hyL;
    private TextView hyM;
    private boolean hyN;
    private boolean hyO;
    private boolean hyP;
    private View hyQ;
    private View hyR;
    private c hyS;
    public com.baidu.tieba.frs.videomiddlepage.a.a hyT;
    private C0550a hyU;
    private VideoNetworkStateTipView hyV;
    private b hyW;
    private com.baidu.mcn.c hyX;
    private com.baidu.tieba.lego.card.view.g hyY;
    private boolean hyZ;
    private boolean hza;
    private boolean hzb;
    private Animation.AnimationListener hzc;
    private Animation.AnimationListener hzd;
    private Runnable hze;
    private Runnable hzf;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.hee = true;
        this.hei = true;
        this.hyO = false;
        this.hyP = false;
        this.hyZ = false;
        this.hza = false;
        this.hzb = false;
        this.startPosition = -1L;
        this.gFC = 0;
        this.hzc = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hyQ != null) {
                    a.this.hyQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hyQ != null) {
                    a.this.hyQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hzd = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hyQ != null) {
                    a.this.hyQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hyQ != null) {
                    a.this.hyQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hze = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hyL.getVisibility() == 0) {
                    a.this.hyL.setVisibility(8);
                }
            }
        };
        this.hzf = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hdZ != null) {
                    a.this.hdZ.stopPlay();
                }
            }
        };
        this.hei = z;
        this.mFrom = str;
        this.dol = str2;
        this.hyW = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hdL = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hyK = view.findViewById(R.id.card_container);
        this.hdM = (FrameLayout) view.findViewById(R.id.video_container);
        this.hdZ = new com.baidu.tieba.play.c(tbPageContext, this.hdM, false, com.baidu.tbadk.a.b.sV("cyber_player_test") || com.baidu.tbadk.a.b.sU("cyber_player_test") ? 1 : 0);
        this.hdZ.sO(z);
        this.hdZ.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.hyT != null && a.this.hea.heA.videoDuration > 8) {
                    a.this.hyT.aU(a.this.mPosition, a.this.hea.heA.videoUrl);
                }
            }
        });
        this.hdZ.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void nv(boolean z2) {
                if (a.this.hyU != null) {
                    if (z2) {
                        a.this.hyU.uZ(0);
                    } else {
                        a.this.hyU.uZ(1);
                    }
                }
            }
        });
        this.hdZ.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.hyJ = (ExpandableTextView) view.findViewById(R.id.title);
        this.hdS = (HeadImageView) view.findViewById(R.id.user_icon);
        this.afW = (TextView) view.findViewById(R.id.user_name);
        this.dHB = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmU = 2;
        dVar.dmZ = 6;
        this.dHB.setStatisticData(dVar);
        this.dHC = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dHD = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dHE = view.findViewById(R.id.thread_info_commont_container);
        this.dHF = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dHG = (ImageView) view.findViewById(R.id.share_num_img);
        this.dHH = view.findViewById(R.id.share_num_container);
        this.hyL = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.hyM = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.hyL.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hyM.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_download_link_url", null);
        this.hyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aOY().a((TbPageContext) i.T(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.hyV = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.hyV.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.hyV.setHasAgreeToPlay(true);
                a.this.hdZ.sU(false);
                a.this.hyV.ddT();
                if (a.this.goO.py()) {
                    a.this.goO.resume();
                } else if (a.this.hea != null && a.this.hea.heA != null) {
                    a.this.hdZ.ev(a.this.hea.heA.videoUrl, a.this.hea.threadId);
                }
            }
        });
        this.hyQ = view.findViewById(R.id.video_agg_container_foreground);
        this.hyR = view.findViewById(R.id.title_and_comment_container_foreground);
        this.hyQ.setOnClickListener(this);
        this.dHE.setOnClickListener(this);
        this.dHH.setOnClickListener(this);
        this.hyJ.setOnClickListener(this);
        this.hdS.setOnClickListener(this);
        this.afW.setOnClickListener(this);
        this.hyK.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.gFC = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hdL.setLayoutParams(layoutParams);
        this.hdS.setIsRound(true);
        this.hdS.setPlaceHolder(1);
        this.ePc = new n(tbPageContext.getPageActivity());
        this.heb = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bht = new AlphaAnimation(0.0f, 0.7f);
        this.bht.setDuration(500L);
        this.bht.setAnimationListener(this.hzd);
        this.bhu = new AlphaAnimation(0.7f, 0.0f);
        this.bhu.setDuration(500L);
        this.bhu.setAnimationListener(this.hzc);
        this.hyU = new C0550a();
        this.goO = new com.baidu.afd.videopaster.d(getContext(), this.hdM);
        this.hyX = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dHB.onChangeSkinType(i);
        this.dHC.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dHF.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aOU().a(this.dHD, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hyJ.onChangeSkinType();
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
        if (gVar != null && gVar.heA != null) {
            boolean z = this.hea == gVar;
            this.hea = gVar;
            this.dvK = this.hea.autoPlay;
            this.hyP = false;
            nt(false);
            this.hyJ.setVisibility(0);
            this.hyJ.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.hyJ.setTextColor(R.color.cp_cont_a);
            this.hyJ.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.heA != null && !StringUtils.isNull(gVar.heA.mcnLeadPage)) {
                this.hyJ.setTextMaxLine(2);
                this.hyJ.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.hyJ.getContentView(), gVar.title, gVar.heA.mcnLeadPage, gVar.getThreadId());
            } else {
                this.hyJ.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.hyJ.setExpandable(true);
                this.hyJ.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nw(boolean z2) {
                        a.this.hea.isTitleExpanded = z2;
                    }
                });
                this.hyJ.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.gFC) {
                this.hdZ.cJr();
                this.gFC = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hdM.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hdM.setLayoutParams(layoutParams);
            }
            bWd();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.hea = gVar;
        this.dvK = this.hea.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean bWc() {
        try {
            int parseInt = Integer.parseInt(this.hea.heA.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.hea.heA.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bWd() {
        if (!bWc()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hdL.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hdL.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.heA != null) {
            this.hdZ.stopPlay();
            this.hdZ.setIsNeedRecoveryVideoPlayer(true);
            this.hdZ.sV(true);
            this.hdZ.sR(true);
            this.hdZ.sW(true);
            this.hdZ.ak(false, false);
            this.hdZ.AV(i);
            this.hdZ.a(new c.InterfaceC0629c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pG() {
                    a.this.bWh();
                    if (a.this.goO != null) {
                        a.this.goO.pG();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pH() {
                    a.this.bWi();
                    if (a.this.hdZ.pI()) {
                    }
                    if (a.this.hef || (a.this.goO != null && a.this.goO.py())) {
                        com.baidu.adp.lib.f.e.lb().removeCallbacks(a.this.hzf);
                        com.baidu.adp.lib.f.e.lb().post(a.this.hzf);
                    }
                    if (a.this.goO != null) {
                        a.this.goO.pH();
                    }
                }
            });
            this.hdZ.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bRb() {
                    if (a.this.hea != null && a.this.hea.heA != null && com.baidu.adp.lib.f.b.toInt(a.this.hea.heA.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.hea.heA.videoWidth, 0)) {
                        a.this.hdZ.ak(false, false);
                    } else {
                        a.this.hdZ.ak(true, false);
                    }
                    a.this.hef = false;
                    a.this.CU(a.this.dvK ? "1" : "2");
                    a.this.onClick(a.this.hdM);
                    if (a.this.WZ != null) {
                        a.this.WZ.a(a.this);
                    }
                    if (a.this.hyY != null) {
                        a.this.hyY.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bRc() {
                    a.this.onClick(a.this.hdL);
                }
            });
            this.hdZ.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void mQ(boolean z2) {
                    a.this.hdZ.ev(a.this.hea.heA.videoUrl, a.this.hea.threadId);
                    a.this.CU("2");
                    a.this.onClick(a.this.hdM);
                }
            });
            this.hdZ.sN(false);
            if (this.hyX != null) {
                this.hyX.reset();
            }
            this.startPosition = -1L;
            this.ePc.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.hea.heA.heL;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.goO.a(a.this.isFullScreen, a.this.hdZ != null && a.this.hdZ.cIX(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.goO.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.hdZ.cIX() && !com.baidu.mcn.b.JF().fu(aVar2.Xq)) {
                        boolean z3 = a.this.startPosition >= (aVar2.heD * 1000) + 1000;
                        if (i3 < aVar2.heD * 1000 || i3 >= aVar2.heE * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.hyX.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.bhg = aVar2.heG;
                                aVar3.bhh = aVar2.heH;
                                aVar3.bhi = aVar2.Xq;
                                aVar3.bhf = aVar2.heF;
                                aVar3.fid = a.this.hea != null ? a.this.hea.forumId : null;
                                aVar3.tid = a.this.hea != null ? a.this.hea.threadId : null;
                                aVar3.bhj = 3;
                                if (z3) {
                                    a.this.hyX.b(aVar3, (ViewGroup) a.this.hdZ.cJq());
                                } else {
                                    a.this.hyX.a(aVar3, (ViewGroup) a.this.hdZ.cJq());
                                }
                            }
                        } else if (a.this.hyX.isShowing()) {
                            a.this.hyX.dismiss();
                        }
                    }
                }
            });
            this.hec = new y();
            this.hec.ahL = gVar.threadId;
            this.hec.eQf = gVar.forumId;
            this.hec.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hec.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.hec.mSource = gVar.source;
            this.hec.kin = gVar.weight;
            this.hec.kip = this.mFrom;
            this.hec.kir = gVar.abtest_tag;
            this.hec.dol = this.dol;
            this.hec.mExtra = gVar.extra;
            this.hec.kiu = "0";
            this.hec.kiq = gVar.getVideoType();
            this.hed = new y();
            this.hed.ahL = gVar.threadId;
            this.hed.eQf = gVar.forumId;
            this.hed.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hed.kin = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hed.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hed.kip = this.mFrom;
            this.hed.mSource = gVar.source;
            this.hed.kiu = "0";
            if (gVar.heA != null) {
                this.hec.kis = gVar.heA.videoMd5;
                this.hed.kis = gVar.heA.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cI("tid", gVar.threadId);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.af("obj_locate", i);
            anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cI("fid", gVar.forumId);
            anVar.cI("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cI("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cI("obj_id", this.dol);
            anVar.cI(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.cI("obj_type", this.mFrom);
            anVar.af("obj_param5", gVar.getVideoType());
            anVar.cI("obj_source", aq.isEmpty(gVar.source) ? "0" : gVar.source);
            anVar.af("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.cI("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.cI("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.ePc.setVideoStatsData(this.hec);
            this.hdZ.cIZ().setBusiness(this.ePc);
            this.ePc.a(gVar);
            this.hdZ.cnB();
            this.hdZ.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.goO.a(a.this.isFullScreen, a.this.hdZ != null && a.this.hdZ.cIX(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.hef = true;
                            a.this.hyN = true;
                            a.this.hee = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.tE(i);
                            a.this.hdZ.caH();
                        }
                    }
                }
            });
            this.hdZ.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.hea != null && a.this.hea.heA != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.hea.heA.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.goO.reset();
            }
            this.goO.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void pP() {
                    a.this.hyN = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pO() {
                    if (a.this.isFullScreen) {
                        a.this.hef = true;
                        a.this.hyN = true;
                        a.this.hee = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.tE(i);
                        a.this.hdZ.caH();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pN() {
                    if (a.this.hdZ != null) {
                        a.this.hdZ.AU(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean pQ() {
                    return a.this.bWg();
                }
            });
            this.hdZ.setThumbnail(gVar.heA.thumbnailUrl);
            this.hdZ.AT(gVar.heA.videoDuration);
            this.hdZ.setVideoUrl(gVar.heA.videoUrl, gVar.threadId);
            this.hdZ.setFid(gVar.forumId);
            this.hdZ.caH();
            this.hdZ.show();
            nt(false);
            if (gVar.autoPlay) {
                onClick(this.hdM);
                if (this.hyV.cFb()) {
                    this.hdZ.sT(false);
                    this.hyV.ddS();
                    this.hdZ.sU(true);
                    this.hdZ.eu(gVar.heA.videoUrl, gVar.threadId);
                    if (this.goO.py()) {
                        this.goO.stop();
                        this.goO.pD();
                    }
                } else {
                    this.hdZ.sU(false);
                    this.hdZ.sT(false);
                    this.hyV.hide();
                    if (this.goO == null || (this.goO != null && !this.goO.py())) {
                        this.hdZ.a(gVar.heA.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.heB) {
                    this.hyQ.setVisibility(8);
                    this.hyU.uZ(3);
                } else {
                    if (this.hyQ.getVisibility() == 0) {
                        this.hyQ.startAnimation(this.bhu);
                    }
                    this.hyU.uZ(0);
                }
                gVar.heB = false;
            } else {
                this.hyQ.setVisibility(0);
                this.hyV.hide();
                this.hdZ.sT(true);
                this.hyU.uZ(3);
                this.hdZ.eu(gVar.heA.videoUrl, gVar.threadId);
            }
            this.hef = false;
            this.hyN = false;
            if (!z && this.goO.py()) {
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
        com.baidu.afd.videopaster.data.b DA = this.hyW != null ? this.hyW.DA(gVar.getThreadId()) : null;
        if (DA == null) {
            return null;
        }
        int pU = DA.pU();
        int pV = DA.pV();
        int pT = DA.pT();
        if (pT != -1) {
            i = pU != -1 ? (pT - pU) - 1 : -1;
            if (pV != -1) {
                i4 = (pV - pT) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.heA != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.heA.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.heA.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", pT + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU(String str) {
        if (this.hea != null && this.hea.heA != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hea.heA.videoMd5, "", str, this.hed);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hdZ.pI();
    }

    public boolean bWe() {
        return this.goO.py();
    }

    public void bQX() {
        if (isPlaying()) {
            this.hdZ.asn();
        }
    }

    public boolean tF(int i) {
        if (i == 4 && this.goO != null && ((this.goO.py() || this.hyN) && this.hdZ != null)) {
            this.goO.aJ(i);
            if (this.isFullScreen) {
                if (this.goO.px()) {
                    this.hdZ.cIY();
                } else {
                    this.hdZ.Ff();
                }
                return true;
            }
        }
        return this.hdZ.AU(i);
    }

    public void bQY() {
        this.hyP = false;
        this.hdZ.stopPlay();
        if (this.hyJ != null) {
            this.hyJ.setVisibility(0);
        }
        if (this.hyU != null) {
            this.hyU.uZ(2);
        }
        nt(false);
        this.hyO = true;
        if (this.goO != null && this.goO.py()) {
            this.goO.stop();
        }
    }

    public void bWf() {
        this.goO.stop();
    }

    public void bQZ() {
        if (this.hdZ != null) {
            this.hdZ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bQZ();
        if (this.heb != null) {
            this.heb.bRj();
        }
        if (this.hyQ != null) {
            this.hyQ.clearAnimation();
        }
        this.goO.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.hez != null) {
            this.afW.setText(TextUtils.isEmpty(gVar.hez.userNickname) ? gVar.hez.userName : gVar.hez.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.hez != null) {
            if (gVar.hez.heK != null && !TextUtils.isEmpty(gVar.hez.heK.avatar)) {
                this.hdS.startLoad(gVar.hez.heK.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.hez.portrait) && gVar.hez.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hdS.startLoad(gVar.hez.portrait, 10, false);
            } else {
                this.hdS.startLoad(gVar.hez.portrait, 12, false);
            }
            if (gVar.hez.heK != null && gVar.hez.heK.auth_id.intValue() > 0) {
                this.hdS.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.hez.heK.auth_id.intValue(), 1));
                this.hdS.setShowV(true);
                this.hdS.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hdS.setBjhAuthIconRes(0);
            if (gVar.hez.isBigV) {
                this.hdS.setShowV(gVar.hez.isBigV);
                this.hdS.setIsBigV(gVar.hez.isBigV);
            } else if (gVar.hez.isGod) {
                this.hdS.setShowV(gVar.hez.isGod);
                this.hdS.setIsBigV(gVar.hez.isGod);
            } else {
                this.hdS.setShowV(gVar.hez.isGod);
                this.hdS.setIsBigV(gVar.hez.isGod);
            }
            this.hdS.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aMs() != null) {
                gVar.aMs().isInThread = true;
            }
            if (this.hea.mBaijiahao != null) {
                this.dHB.setAgreeAlone(true);
            }
            this.dHB.setIsFromMiddlePage(true);
            this.dHB.setData(gVar.aMs());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dHC.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aOU().a(this.dHD, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dHC.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dHC.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dHF.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dHF.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dHF.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hdZ != null && this.hdM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hee) {
                this.hdZ.cJf();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bWh();
            } else {
                configuration.orientation = 1;
                bWi();
                this.hee = true;
            }
            this.hdZ.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bWg() {
        if (this.hdZ != null && this.hdM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hdM.getParent() != null) {
                if (this.hdM.getParent() == frameLayout) {
                    if (this.hyZ) {
                        this.hyZ = false;
                        return true;
                    } else if (!this.hza) {
                        this.hza = true;
                        return true;
                    }
                } else if (this.hdM.getParent() == this.hdL) {
                    if (this.hza) {
                        this.hza = false;
                        this.hzb = true;
                        return true;
                    } else if (!this.hyZ && this.hzb) {
                        this.hyZ = true;
                        this.hzb = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWh() {
        if (this.hdZ != null && this.hdM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hdM.getParent() != null) {
                if (this.hdM.getParent() == frameLayout) {
                    frameLayout.removeView(this.hdM);
                } else if (this.hdM.getParent() == this.hdL) {
                    this.hdL.removeView(this.hdM);
                }
            }
            if (this.hdM.getParent() == null) {
                frameLayout.addView(this.hdM);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdM.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hdM.setLayoutParams(layoutParams);
                if (this.hyX != null && this.hyX.isShowing()) {
                    this.hyX.dismiss();
                }
                com.baidu.tbadk.util.d.baf().hY(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWi() {
        if (this.hdZ != null && this.hdM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hdM.getParent() != null) {
                if (this.hdM.getParent() == frameLayout) {
                    bWj();
                    frameLayout.removeView(this.hdM);
                } else if (this.hdM.getParent() == this.hdL) {
                    bWj();
                    this.hdL.removeView(this.hdM);
                }
            }
            if (this.hdM.getParent() == null) {
                this.hdL.addView(this.hdM, 0);
                bWk();
                this.hdZ.cnB();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.baf().hY(false);
            }
        }
    }

    private void bWj() {
        if (this.goO != null && this.goO.py()) {
            this.goO.ax(true);
        }
    }

    private void bWk() {
        int i;
        if (!bWc()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hdM.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bEy() != null) {
            view.setTag(this);
            bEy().a(view, this.hea);
        }
        if (view == this.hdS || view == this.afW) {
            if (this.hea != null && this.hea.hez != null && !TextUtils.isEmpty(this.hea.hez.userId)) {
                this.hyU.uZ(0);
                if (!TbadkCoreApplication.isLogin() || !this.hea.hez.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hea.hez.userId, 0L), z, this.hea.hez.isGod)));
            }
        } else if (view == this.dHE) {
            if (this.hea != null) {
                this.hyU.uZ(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hea.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.hea.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hyJ || view == this.hyK) {
            if (this.hea != null) {
                if (this.hyU.getCurrentState() != 2 && this.hyU.getCurrentState() != 3) {
                    z = false;
                }
                this.hyU.uZ(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.hea.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.hea.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dHH) {
            this.hyU.uZ(0);
            aQD();
        } else if (view == this.hyQ && this.hyQ.getVisibility() == 0 && this.hyS != null) {
            this.hyS.vd(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void mP(boolean z) {
        if (this.hea != null && this.hea.hez != null) {
            this.hea.hez.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bRa() {
        if (this.hea != null) {
            this.dHB.aPP();
        }
    }

    public void ns(boolean z) {
        if (this.hdL != null) {
            this.hdL.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.hyY = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.hyS = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.WZ = fVar;
    }

    private void nt(boolean z) {
        this.hyO = this.mPosition == (this.hyT == null ? -1 : this.hyT.bWw());
        if (this.hyO && z && isPlaying() && this.dvK && !this.hyP) {
            this.hyL.setVisibility(0);
            this.hyP = true;
            this.hyL.postDelayed(this.hze, 5000L);
            if (this.hyT != null) {
                this.hyT.eh(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.hyL.setVisibility(8);
        if (this.hze != null) {
            this.hyL.removeCallbacks(this.hze);
        }
    }

    private void aQD() {
        String str;
        String str2;
        if (this.hea != null && this.mContext != null) {
            String valueOf = String.valueOf(this.hea.forumId);
            String str3 = this.hea.title;
            if (this.hea.mBaijiahao != null) {
                str = this.hea.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.hea.mBaijiahao.oriUgcType + "&dvid=" + this.hea.mBaijiahao.oriUgcVid + "&nid=" + this.hea.mBaijiahao.oriUgcNid;
            } else {
                str = this.hea.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.hea.heA.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.hea.title;
            String format = (this.hea.mBaijiahao == null || this.hea.hez == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.hea.hez.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.hea.mBaijiahao != null) {
                shareItem.dQv = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.dQv = str6;
                shareItem.readCount = this.hea.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.dQy = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.dQl = true;
            shareItem.dQx = 11;
            shareItem.dQC = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.hea.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.hea.mBaijiahao;
            shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cI("tid", str);
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.af("obj_locate", 12);
            TiebaStatic.log(anVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQy);
            bundle.putInt("obj_type", shareItem.dQC);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dua);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.bGe().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bQY();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void asn() {
        bQX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu(boolean z) {
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

    public void bWl() {
        this.goO.resume();
    }

    public boolean bWm() {
        if (this.hyU != null) {
            return this.hyU.getCurrentState() == 2 || this.hyU.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0550a {
        private Runnable hzj;
        private int mCurrentState;

        private C0550a() {
            this.mCurrentState = -1;
            this.hzj = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(C0550a.this.hzj);
                    C0550a.this.uZ(2);
                }
            };
        }

        public void uZ(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = va(i);
                    bWn();
                    return;
                case 1:
                    this.mCurrentState = va(i);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hzj);
                    return;
                case 2:
                    this.mCurrentState = vb(i);
                    return;
                case 3:
                    this.mCurrentState = vc(i);
                    bWn();
                    return;
                default:
                    this.mCurrentState = vb(i);
                    return;
            }
        }

        private void bWn() {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hzj);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hzj, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int va(int i) {
            if (i != this.mCurrentState) {
                a.this.hyR.setVisibility(8);
                a.this.nu(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vb(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.hyR.setVisibility(0);
                if (i2 != 3 || a.this.hea.autoPlay) {
                    a.this.nu(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vc(int i) {
            if (i != this.mCurrentState) {
                a.this.hyR.setVisibility(0);
                a.this.nu(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
