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
    private com.baidu.tieba.lego.card.view.f Xc;
    public TextView afZ;
    private Animation bhy;
    private Animation bhz;
    protected AgreeView dHF;
    private TextView dHG;
    private ImageView dHH;
    private View dHI;
    private TextView dHJ;
    private ImageView dHK;
    private View dHL;
    private String dop;
    private boolean dvO;
    private n ePh;
    private int gFI;
    private com.baidu.afd.videopaster.d goU;
    public FrameLayout hdR;
    public FrameLayout hdS;
    public HeadImageView hdY;
    public com.baidu.tieba.play.c hef;
    public com.baidu.tieba.frs.aggregation.g heg;
    private com.baidu.tieba.frs.aggregation.h heh;
    private y hei;
    private y hej;
    private boolean hek;
    private boolean hel;
    private boolean heo;
    public ExpandableTextView hyP;
    private View hyQ;
    private FrameLayout hyR;
    private TextView hyS;
    private boolean hyT;
    private boolean hyU;
    private boolean hyV;
    private View hyW;
    private View hyX;
    private c hyY;
    public com.baidu.tieba.frs.videomiddlepage.a.a hyZ;
    private C0571a hza;
    private VideoNetworkStateTipView hzb;
    private b hzc;
    private com.baidu.mcn.c hzd;
    private com.baidu.tieba.lego.card.view.g hze;
    private boolean hzf;
    private boolean hzg;
    private boolean hzh;
    private Animation.AnimationListener hzi;
    private Animation.AnimationListener hzj;
    private Runnable hzk;
    private Runnable hzl;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.hek = true;
        this.heo = true;
        this.hyU = false;
        this.hyV = false;
        this.hzf = false;
        this.hzg = false;
        this.hzh = false;
        this.startPosition = -1L;
        this.gFI = 0;
        this.hzi = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hyW != null) {
                    a.this.hyW.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hyW != null) {
                    a.this.hyW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hzj = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.hyW != null) {
                    a.this.hyW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hyW != null) {
                    a.this.hyW.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hzk = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hyR.getVisibility() == 0) {
                    a.this.hyR.setVisibility(8);
                }
            }
        };
        this.hzl = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hef != null) {
                    a.this.hef.stopPlay();
                }
            }
        };
        this.heo = z;
        this.mFrom = str;
        this.dop = str2;
        this.hzc = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hdR = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hyQ = view.findViewById(R.id.card_container);
        this.hdS = (FrameLayout) view.findViewById(R.id.video_container);
        this.hef = new com.baidu.tieba.play.c(tbPageContext, this.hdS, false, com.baidu.tbadk.a.b.sY("cyber_player_test") || com.baidu.tbadk.a.b.sX("cyber_player_test") ? 1 : 0);
        this.hef.sO(z);
        this.hef.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.hyZ != null && a.this.heg.heG.videoDuration > 8) {
                    a.this.hyZ.aU(a.this.mPosition, a.this.heg.heG.videoUrl);
                }
            }
        });
        this.hef.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void nv(boolean z2) {
                if (a.this.hza != null) {
                    if (z2) {
                        a.this.hza.uZ(0);
                    } else {
                        a.this.hza.uZ(1);
                    }
                }
            }
        });
        this.hef.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.hyP = (ExpandableTextView) view.findViewById(R.id.title);
        this.hdY = (HeadImageView) view.findViewById(R.id.user_icon);
        this.afZ = (TextView) view.findViewById(R.id.user_name);
        this.dHF = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmY = 2;
        dVar.dnd = 6;
        this.dHF.setStatisticData(dVar);
        this.dHG = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dHH = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dHI = view.findViewById(R.id.thread_info_commont_container);
        this.dHJ = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dHK = (ImageView) view.findViewById(R.id.share_num_img);
        this.dHL = view.findViewById(R.id.share_num_container);
        this.hyR = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.hyS = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.hyR.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hyS.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_download_link_url", null);
        this.hyS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aOV().a((TbPageContext) i.G(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.hzb = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.hzb.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.hzb.setHasAgreeToPlay(true);
                a.this.hef.sU(false);
                a.this.hzb.ddR();
                if (a.this.goU.py()) {
                    a.this.goU.resume();
                } else if (a.this.heg != null && a.this.heg.heG != null) {
                    a.this.hef.ev(a.this.heg.heG.videoUrl, a.this.heg.threadId);
                }
            }
        });
        this.hyW = view.findViewById(R.id.video_agg_container_foreground);
        this.hyX = view.findViewById(R.id.title_and_comment_container_foreground);
        this.hyW.setOnClickListener(this);
        this.dHI.setOnClickListener(this);
        this.dHL.setOnClickListener(this);
        this.hyP.setOnClickListener(this);
        this.hdY.setOnClickListener(this);
        this.afZ.setOnClickListener(this);
        this.hyQ.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.gFI = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdR.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hdR.setLayoutParams(layoutParams);
        this.hdY.setIsRound(true);
        this.hdY.setPlaceHolder(1);
        this.ePh = new n(tbPageContext.getPageActivity());
        this.heh = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bhy = new AlphaAnimation(0.0f, 0.7f);
        this.bhy.setDuration(500L);
        this.bhy.setAnimationListener(this.hzj);
        this.bhz = new AlphaAnimation(0.7f, 0.0f);
        this.bhz.setDuration(500L);
        this.bhz.setAnimationListener(this.hzi);
        this.hza = new C0571a();
        this.goU = new com.baidu.afd.videopaster.d(getContext(), this.hdS);
        this.hzd = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dHF.onChangeSkinType(i);
        this.dHG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dHJ.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aOR().a(this.dHH, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.dHK, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hyP.onChangeSkinType();
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
        if (gVar != null && gVar.heG != null) {
            boolean z = this.heg == gVar;
            this.heg = gVar;
            this.dvO = this.heg.autoPlay;
            this.hyV = false;
            nt(false);
            this.hyP.setVisibility(0);
            this.hyP.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.hyP.setTextColor(R.color.cp_cont_a);
            this.hyP.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.heG != null && !StringUtils.isNull(gVar.heG.mcnLeadPage)) {
                this.hyP.setTextMaxLine(2);
                this.hyP.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.hyP.getContentView(), gVar.title, gVar.heG.mcnLeadPage, gVar.getThreadId());
            } else {
                this.hyP.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.hyP.setExpandable(true);
                this.hyP.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nw(boolean z2) {
                        a.this.heg.isTitleExpanded = z2;
                    }
                });
                this.hyP.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.gFI) {
                this.hef.cJp();
                this.gFI = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hdS.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hdS.setLayoutParams(layoutParams);
            }
            bWc();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.heg = gVar;
        this.dvO = this.heg.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean bWb() {
        try {
            int parseInt = Integer.parseInt(this.heg.heG.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.heg.heG.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bWc() {
        if (!bWb()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdR.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hdR.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hdR.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hdR.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.heG != null) {
            this.hef.stopPlay();
            this.hef.setIsNeedRecoveryVideoPlayer(true);
            this.hef.sV(true);
            this.hef.sR(true);
            this.hef.sW(true);
            this.hef.ak(false, false);
            this.hef.AV(i);
            this.hef.a(new c.InterfaceC0650c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pG() {
                    a.this.bWg();
                    if (a.this.goU != null) {
                        a.this.goU.pG();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pH() {
                    a.this.bWh();
                    if (a.this.hef.pI()) {
                    }
                    if (a.this.hel || (a.this.goU != null && a.this.goU.py())) {
                        com.baidu.adp.lib.f.e.lb().removeCallbacks(a.this.hzl);
                        com.baidu.adp.lib.f.e.lb().post(a.this.hzl);
                    }
                    if (a.this.goU != null) {
                        a.this.goU.pH();
                    }
                }
            });
            this.hef.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bRa() {
                    if (a.this.heg != null && a.this.heg.heG != null && com.baidu.adp.lib.f.b.toInt(a.this.heg.heG.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.heg.heG.videoWidth, 0)) {
                        a.this.hef.ak(false, false);
                    } else {
                        a.this.hef.ak(true, false);
                    }
                    a.this.hel = false;
                    a.this.CX(a.this.dvO ? "1" : "2");
                    a.this.onClick(a.this.hdS);
                    if (a.this.Xc != null) {
                        a.this.Xc.a(a.this);
                    }
                    if (a.this.hze != null) {
                        a.this.hze.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bRb() {
                    a.this.onClick(a.this.hdR);
                }
            });
            this.hef.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void mQ(boolean z2) {
                    a.this.hef.ev(a.this.heg.heG.videoUrl, a.this.heg.threadId);
                    a.this.CX("2");
                    a.this.onClick(a.this.hdS);
                }
            });
            this.hef.sN(false);
            if (this.hzd != null) {
                this.hzd.reset();
            }
            this.startPosition = -1L;
            this.ePh.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.heg.heG.heR;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.goU.a(a.this.isFullScreen, a.this.hef != null && a.this.hef.cIV(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.goU.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.hef.cIV() && !com.baidu.mcn.b.JE().fu(aVar2.Xt)) {
                        boolean z3 = a.this.startPosition >= (aVar2.heJ * 1000) + 1000;
                        if (i3 < aVar2.heJ * 1000 || i3 >= aVar2.heK * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.hzd.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.bhl = aVar2.heM;
                                aVar3.bhm = aVar2.heN;
                                aVar3.bhn = aVar2.Xt;
                                aVar3.bhk = aVar2.heL;
                                aVar3.fid = a.this.heg != null ? a.this.heg.forumId : null;
                                aVar3.tid = a.this.heg != null ? a.this.heg.threadId : null;
                                aVar3.bho = 3;
                                if (z3) {
                                    a.this.hzd.b(aVar3, (ViewGroup) a.this.hef.cJo());
                                } else {
                                    a.this.hzd.a(aVar3, (ViewGroup) a.this.hef.cJo());
                                }
                            }
                        } else if (a.this.hzd.isShowing()) {
                            a.this.hzd.dismiss();
                        }
                    }
                }
            });
            this.hei = new y();
            this.hei.ahO = gVar.threadId;
            this.hei.eQk = gVar.forumId;
            this.hei.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hei.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.hei.mSource = gVar.source;
            this.hei.kir = gVar.weight;
            this.hei.kit = this.mFrom;
            this.hei.kiv = gVar.abtest_tag;
            this.hei.dop = this.dop;
            this.hei.mExtra = gVar.extra;
            this.hei.kiy = "0";
            this.hei.kiu = gVar.getVideoType();
            this.hej = new y();
            this.hej.ahO = gVar.threadId;
            this.hej.eQk = gVar.forumId;
            this.hej.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hej.kir = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hej.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hej.kit = this.mFrom;
            this.hej.mSource = gVar.source;
            this.hej.kiy = "0";
            if (gVar.heG != null) {
                this.hei.kiw = gVar.heG.videoMd5;
                this.hej.kiw = gVar.heG.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cI("tid", gVar.threadId);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.af("obj_locate", i);
            anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cI("fid", gVar.forumId);
            anVar.cI("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cI("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cI("obj_id", this.dop);
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
            this.ePh.setVideoStatsData(this.hei);
            this.hef.cIX().setBusiness(this.ePh);
            this.ePh.a(gVar);
            this.hef.cnz();
            this.hef.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.goU.a(a.this.isFullScreen, a.this.hef != null && a.this.hef.cIV(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.hel = true;
                            a.this.hyT = true;
                            a.this.hek = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.tE(i);
                            a.this.hef.caG();
                        }
                    }
                }
            });
            this.hef.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.heg != null && a.this.heg.heG != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.heg.heG.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.goU.reset();
            }
            this.goU.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void pP() {
                    a.this.hyT = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pO() {
                    if (a.this.isFullScreen) {
                        a.this.hel = true;
                        a.this.hyT = true;
                        a.this.hek = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.tE(i);
                        a.this.hef.caG();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void pN() {
                    if (a.this.hef != null) {
                        a.this.hef.AU(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean pQ() {
                    return a.this.bWf();
                }
            });
            this.hef.setThumbnail(gVar.heG.thumbnailUrl);
            this.hef.AT(gVar.heG.videoDuration);
            this.hef.setVideoUrl(gVar.heG.videoUrl, gVar.threadId);
            this.hef.setFid(gVar.forumId);
            this.hef.caG();
            this.hef.show();
            nt(false);
            if (gVar.autoPlay) {
                onClick(this.hdS);
                if (this.hzb.cEZ()) {
                    this.hef.sT(false);
                    this.hzb.ddQ();
                    this.hef.sU(true);
                    this.hef.eu(gVar.heG.videoUrl, gVar.threadId);
                    if (this.goU.py()) {
                        this.goU.stop();
                        this.goU.pD();
                    }
                } else {
                    this.hef.sU(false);
                    this.hef.sT(false);
                    this.hzb.hide();
                    if (this.goU == null || (this.goU != null && !this.goU.py())) {
                        this.hef.a(gVar.heG.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.heH) {
                    this.hyW.setVisibility(8);
                    this.hza.uZ(3);
                } else {
                    if (this.hyW.getVisibility() == 0) {
                        this.hyW.startAnimation(this.bhz);
                    }
                    this.hza.uZ(0);
                }
                gVar.heH = false;
            } else {
                this.hyW.setVisibility(0);
                this.hzb.hide();
                this.hef.sT(true);
                this.hza.uZ(3);
                this.hef.eu(gVar.heG.videoUrl, gVar.threadId);
            }
            this.hel = false;
            this.hyT = false;
            if (!z && this.goU.py()) {
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
        com.baidu.afd.videopaster.data.b DD = this.hzc != null ? this.hzc.DD(gVar.getThreadId()) : null;
        if (DD == null) {
            return null;
        }
        int pU = DD.pU();
        int pV = DD.pV();
        int pT = DD.pT();
        if (pT != -1) {
            i = pU != -1 ? (pT - pU) - 1 : -1;
            if (pV != -1) {
                i4 = (pV - pT) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.heG != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.heG.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.heG.videoHeight, 0);
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
    public void CX(String str) {
        if (this.heg != null && this.heg.heG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.heg.heG.videoMd5, "", str, this.hej);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hef.pI();
    }

    public boolean bWd() {
        return this.goU.py();
    }

    public void bQW() {
        if (isPlaying()) {
            this.hef.asl();
        }
    }

    public boolean tF(int i) {
        if (i == 4 && this.goU != null && ((this.goU.py() || this.hyT) && this.hef != null)) {
            this.goU.aJ(i);
            if (this.isFullScreen) {
                if (this.goU.px()) {
                    this.hef.cIW();
                } else {
                    this.hef.Fe();
                }
                return true;
            }
        }
        return this.hef.AU(i);
    }

    public void bQX() {
        this.hyV = false;
        this.hef.stopPlay();
        if (this.hyP != null) {
            this.hyP.setVisibility(0);
        }
        if (this.hza != null) {
            this.hza.uZ(2);
        }
        nt(false);
        this.hyU = true;
        if (this.goU != null && this.goU.py()) {
            this.goU.stop();
        }
    }

    public void bWe() {
        this.goU.stop();
    }

    public void bQY() {
        if (this.hef != null) {
            this.hef.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bQY();
        if (this.heh != null) {
            this.heh.bRi();
        }
        if (this.hyW != null) {
            this.hyW.clearAnimation();
        }
        this.goU.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.heF != null) {
            this.afZ.setText(TextUtils.isEmpty(gVar.heF.userNickname) ? gVar.heF.userName : gVar.heF.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.heF != null) {
            if (gVar.heF.heQ != null && !TextUtils.isEmpty(gVar.heF.heQ.avatar)) {
                this.hdY.startLoad(gVar.heF.heQ.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.heF.portrait) && gVar.heF.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hdY.startLoad(gVar.heF.portrait, 10, false);
            } else {
                this.hdY.startLoad(gVar.heF.portrait, 12, false);
            }
            if (gVar.heF.heQ != null && gVar.heF.heQ.auth_id.intValue() > 0) {
                this.hdY.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.heF.heQ.auth_id.intValue(), 1));
                this.hdY.setShowV(true);
                this.hdY.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hdY.setBjhAuthIconRes(0);
            if (gVar.heF.isBigV) {
                this.hdY.setShowV(gVar.heF.isBigV);
                this.hdY.setIsBigV(gVar.heF.isBigV);
            } else if (gVar.heF.isGod) {
                this.hdY.setShowV(gVar.heF.isGod);
                this.hdY.setIsBigV(gVar.heF.isGod);
            } else {
                this.hdY.setShowV(gVar.heF.isGod);
                this.hdY.setIsBigV(gVar.heF.isGod);
            }
            this.hdY.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aMq() != null) {
                gVar.aMq().isInThread = true;
            }
            if (this.heg.mBaijiahao != null) {
                this.dHF.setAgreeAlone(true);
            }
            this.dHF.setIsFromMiddlePage(true);
            this.dHF.setData(gVar.aMq());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dHG.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aOR().a(this.dHH, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dHG.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dHG.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dHJ.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aOR().a(this.dHK, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dHJ.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dHJ.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hef != null && this.hdS != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hek) {
                this.hef.cJd();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bWg();
            } else {
                configuration.orientation = 1;
                bWh();
                this.hek = true;
            }
            this.hef.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bWf() {
        if (this.hef != null && this.hdS != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hdS.getParent() != null) {
                if (this.hdS.getParent() == frameLayout) {
                    if (this.hzf) {
                        this.hzf = false;
                        return true;
                    } else if (!this.hzg) {
                        this.hzg = true;
                        return true;
                    }
                } else if (this.hdS.getParent() == this.hdR) {
                    if (this.hzg) {
                        this.hzg = false;
                        this.hzh = true;
                        return true;
                    } else if (!this.hzf && this.hzh) {
                        this.hzf = true;
                        this.hzh = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWg() {
        if (this.hef != null && this.hdS != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hdS.getParent() != null) {
                if (this.hdS.getParent() == frameLayout) {
                    frameLayout.removeView(this.hdS);
                } else if (this.hdS.getParent() == this.hdR) {
                    this.hdR.removeView(this.hdS);
                }
            }
            if (this.hdS.getParent() == null) {
                frameLayout.addView(this.hdS);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdS.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hdS.setLayoutParams(layoutParams);
                if (this.hzd != null && this.hzd.isShowing()) {
                    this.hzd.dismiss();
                }
                com.baidu.tbadk.util.d.bad().hY(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWh() {
        if (this.hef != null && this.hdS != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hdS.getParent() != null) {
                if (this.hdS.getParent() == frameLayout) {
                    bWi();
                    frameLayout.removeView(this.hdS);
                } else if (this.hdS.getParent() == this.hdR) {
                    bWi();
                    this.hdR.removeView(this.hdS);
                }
            }
            if (this.hdS.getParent() == null) {
                this.hdR.addView(this.hdS, 0);
                bWj();
                this.hef.cnz();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.bad().hY(false);
            }
        }
    }

    private void bWi() {
        if (this.goU != null && this.goU.py()) {
            this.goU.ax(true);
        }
    }

    private void bWj() {
        int i;
        if (!bWb()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hdS.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bEx() != null) {
            view.setTag(this);
            bEx().a(view, this.heg);
        }
        if (view == this.hdY || view == this.afZ) {
            if (this.heg != null && this.heg.heF != null && !TextUtils.isEmpty(this.heg.heF.userId)) {
                this.hza.uZ(0);
                if (!TbadkCoreApplication.isLogin() || !this.heg.heF.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.heg.heF.userId, 0L), z, this.heg.heF.isGod)));
            }
        } else if (view == this.dHI) {
            if (this.heg != null) {
                this.hza.uZ(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.heg.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.heg.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hyP || view == this.hyQ) {
            if (this.heg != null) {
                if (this.hza.getCurrentState() != 2 && this.hza.getCurrentState() != 3) {
                    z = false;
                }
                this.hza.uZ(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.heg.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.heg.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dHL) {
            this.hza.uZ(0);
            aQA();
        } else if (view == this.hyW && this.hyW.getVisibility() == 0 && this.hyY != null) {
            this.hyY.vd(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void mP(boolean z) {
        if (this.heg != null && this.heg.heF != null) {
            this.heg.heF.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bQZ() {
        if (this.heg != null) {
            this.dHF.aPM();
        }
    }

    public void ns(boolean z) {
        if (this.hdR != null) {
            this.hdR.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.hze = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.hyY = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Xc = fVar;
    }

    private void nt(boolean z) {
        this.hyU = this.mPosition == (this.hyZ == null ? -1 : this.hyZ.bWv());
        if (this.hyU && z && isPlaying() && this.dvO && !this.hyV) {
            this.hyR.setVisibility(0);
            this.hyV = true;
            this.hyR.postDelayed(this.hzk, 5000L);
            if (this.hyZ != null) {
                this.hyZ.eh(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.hyR.setVisibility(8);
        if (this.hzk != null) {
            this.hyR.removeCallbacks(this.hzk);
        }
    }

    private void aQA() {
        String str;
        String str2;
        if (this.heg != null && this.mContext != null) {
            String valueOf = String.valueOf(this.heg.forumId);
            String str3 = this.heg.title;
            if (this.heg.mBaijiahao != null) {
                str = this.heg.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.heg.mBaijiahao.oriUgcType + "&dvid=" + this.heg.mBaijiahao.oriUgcVid + "&nid=" + this.heg.mBaijiahao.oriUgcNid;
            } else {
                str = this.heg.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.heg.heG.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.heg.title;
            String format = (this.heg.mBaijiahao == null || this.heg.heF == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.heg.heF.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.heg.mBaijiahao != null) {
                shareItem.dQA = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.dQA = str6;
                shareItem.readCount = this.heg.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.dQD = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.dQq = true;
            shareItem.dQC = 11;
            shareItem.dQH = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.heg.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.heg.mBaijiahao;
            shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cI("tid", str);
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.af("obj_locate", 12);
            TiebaStatic.log(anVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQD);
            bundle.putInt("obj_type", shareItem.dQH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.due);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.bGd().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bQX();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void asl() {
        bQW();
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

    public void bWk() {
        this.goU.resume();
    }

    public boolean bWl() {
        if (this.hza != null) {
            return this.hza.getCurrentState() == 2 || this.hza.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0571a {
        private Runnable hzp;
        private int mCurrentState;

        private C0571a() {
            this.mCurrentState = -1;
            this.hzp = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(C0571a.this.hzp);
                    C0571a.this.uZ(2);
                }
            };
        }

        public void uZ(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = va(i);
                    bWm();
                    return;
                case 1:
                    this.mCurrentState = va(i);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hzp);
                    return;
                case 2:
                    this.mCurrentState = vb(i);
                    return;
                case 3:
                    this.mCurrentState = vc(i);
                    bWm();
                    return;
                default:
                    this.mCurrentState = vb(i);
                    return;
            }
        }

        private void bWm() {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hzp);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hzp, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int va(int i) {
            if (i != this.mCurrentState) {
                a.this.hyX.setVisibility(8);
                a.this.nu(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int vb(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.hyX.setVisibility(0);
                if (i2 != 3 || a.this.heg.autoPlay) {
                    a.this.nu(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int vc(int i) {
            if (i != this.mCurrentState) {
                a.this.hyX.setVisibility(0);
                a.this.nu(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
