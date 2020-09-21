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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f YN;
    public TextView ajb;
    private Animation bDE;
    private Animation bDF;
    private TextView dVT;
    private String eaC;
    private boolean eiU;
    protected AgreeView evE;
    private ImageView evF;
    private View evG;
    private TextView evH;
    private ImageView evI;
    private View evJ;
    private int hGT;
    private com.baidu.afd.videopaster.d hqq;
    private com.baidu.mcn.c iDA;
    private com.baidu.tieba.lego.card.view.g iDB;
    private boolean iDC;
    private boolean iDD;
    private boolean iDE;
    private Animation.AnimationListener iDF;
    private Animation.AnimationListener iDG;
    private Runnable iDH;
    private Runnable iDI;
    public ExpandableTextView iDm;
    private View iDn;
    private FrameLayout iDo;
    private TextView iDp;
    private boolean iDq;
    private boolean iDr;
    private boolean iDs;
    private View iDt;
    private View iDu;
    private c iDv;
    public com.baidu.tieba.frs.videomiddlepage.a.a iDw;
    private C0688a iDx;
    private VideoNetworkStateTipView iDy;
    private b iDz;
    public FrameLayout igT;
    public FrameLayout igU;
    public HeadImageView iha;
    public com.baidu.tieba.play.c ihi;
    public com.baidu.tieba.frs.aggregation.g ihj;
    private com.baidu.tieba.frs.aggregation.h ihk;
    private o ihl;
    private o ihm;
    private boolean ihn;
    private boolean iho;
    private boolean ihr;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.ihn = true;
        this.ihr = true;
        this.iDr = false;
        this.iDs = false;
        this.iDC = false;
        this.iDD = false;
        this.iDE = false;
        this.startPosition = -1L;
        this.hGT = 0;
        this.iDF = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.iDt != null) {
                    a.this.iDt.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.iDt != null) {
                    a.this.iDt.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iDG = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.iDt != null) {
                    a.this.iDt.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.iDt != null) {
                    a.this.iDt.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iDH = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iDo.getVisibility() == 0) {
                    a.this.iDo.setVisibility(8);
                }
            }
        };
        this.iDI = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ihi != null) {
                    a.this.ihi.stopPlay();
                }
            }
        };
        this.ihr = z;
        this.mFrom = str;
        this.eaC = str2;
        this.iDz = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.igT = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.iDn = view.findViewById(R.id.card_container);
        this.igU = (FrameLayout) view.findViewById(R.id.video_container);
        this.ihi = new com.baidu.tieba.play.c(tbPageContext, this.igU, false);
        this.ihi.setStageType("2005");
        this.ihi.vc(z);
        this.ihi.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.iDw != null && a.this.ihj.ihJ.videoDuration > 8) {
                    a.this.iDw.bg(a.this.mPosition, a.this.ihj.ihJ.videoUrl);
                }
            }
        });
        this.ihi.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void pt(boolean z2) {
                if (a.this.iDx != null) {
                    if (z2) {
                        a.this.iDx.zw(0);
                    } else {
                        a.this.iDx.zw(1);
                    }
                }
            }
        });
        this.ihi.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.iDm = (ExpandableTextView) view.findViewById(R.id.title);
        this.iha = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajb = (TextView) view.findViewById(R.id.user_name);
        this.evE = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYZ = 2;
        cVar.dZe = 6;
        this.evE.setStatisticData(cVar);
        this.dVT = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.evF = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.evG = view.findViewById(R.id.thread_info_commont_container);
        this.evH = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.evI = (ImageView) view.findViewById(R.id.share_num_img);
        this.evJ = view.findViewById(R.id.share_num_container);
        this.iDo = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.iDp = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.iDo.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.iDp.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bjf().getString("nani_key_download_link_url", null);
        this.iDp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bkp().a((TbPageContext) i.I(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.iDy = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.iDy.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.iDy.setHasAgreeToPlay(true);
                a.this.ihi.vi(false);
                a.this.iDy.dIr();
                if (a.this.hqq.rA()) {
                    a.this.hqq.resume();
                } else if (a.this.ihj != null && a.this.ihj.ihJ != null) {
                    a.this.ihi.fK(a.this.ihj.ihJ.videoUrl, a.this.ihj.threadId);
                }
            }
        });
        this.iDt = view.findViewById(R.id.video_agg_container_foreground);
        this.iDu = view.findViewById(R.id.title_and_comment_container_foreground);
        this.iDt.setOnClickListener(this);
        this.evG.setOnClickListener(this);
        this.evJ.setOnClickListener(this);
        this.iDm.setOnClickListener(this);
        this.iha.setOnClickListener(this);
        this.ajb.setOnClickListener(this);
        this.iDn.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.hGT = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igT.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.igT.setLayoutParams(layoutParams);
        this.iha.setIsRound(true);
        this.iha.setPlaceHolder(1);
        this.ihk = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bDE = new AlphaAnimation(0.0f, 0.7f);
        this.bDE.setDuration(500L);
        this.bDE.setAnimationListener(this.iDG);
        this.bDF = new AlphaAnimation(0.7f, 0.0f);
        this.bDF.setDuration(500L);
        this.bDF.setAnimationListener(this.iDF);
        this.iDx = new C0688a();
        this.hqq = new com.baidu.afd.videopaster.d(getContext(), this.igU);
        this.iDA = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.evE.onChangeSkinType(i);
        this.dVT.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.evH.setTextColor(ap.getColor(R.color.cp_cont_d));
        SvgManager.bkl().a(this.evF, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bkl().a(this.evI, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iDm.onChangeSkinType();
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
        if (gVar != null && gVar.ihJ != null) {
            boolean z = this.ihj == gVar;
            this.ihj = gVar;
            this.eiU = this.ihj.autoPlay;
            this.iDs = false;
            pr(false);
            this.iDm.setVisibility(0);
            this.iDm.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.iDm.setTextColor(R.color.cp_cont_a);
            this.iDm.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.ihJ != null && !StringUtils.isNull(gVar.ihJ.mcnLeadPage)) {
                this.iDm.setTextMaxLine(2);
                this.iDm.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.iDm.getContentView(), gVar.title, gVar.ihJ.mcnLeadPage, gVar.getThreadId());
            } else {
                this.iDm.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.iDm.setExpandable(true);
                this.iDm.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void pu(boolean z2) {
                        a.this.ihj.isTitleExpanded = z2;
                    }
                });
                this.iDm.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.hGT) {
                this.ihi.dnw();
                this.hGT = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.igU.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.igU.setLayoutParams(layoutParams);
            }
            cxz();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.ihj = gVar;
        this.eiU = this.ihj.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cxy() {
        try {
            int parseInt = Integer.parseInt(this.ihj.ihJ.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.ihj.ihJ.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cxz() {
        if (!cxy()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igT.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.igT.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.igT.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.igT.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.ihJ != null) {
            this.ihi.stopPlay();
            this.ihi.vj(true);
            this.ihi.vf(true);
            this.ihi.vk(true);
            this.ihi.aw(false, false);
            this.ihi.Gf(i);
            this.ihi.a(new c.InterfaceC0779c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rI() {
                    a.this.cxD();
                    if (a.this.hqq != null) {
                        a.this.hqq.rI();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rJ() {
                    a.this.cxE();
                    if (a.this.ihi.rK()) {
                    }
                    if (a.this.iho || (a.this.hqq != null && a.this.hqq.rA())) {
                        com.baidu.adp.lib.f.e.mX().removeCallbacks(a.this.iDI);
                        com.baidu.adp.lib.f.e.mX().post(a.this.iDI);
                    }
                    if (a.this.hqq != null) {
                        a.this.hqq.rJ();
                    }
                }
            });
            this.ihi.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void csa() {
                    if (a.this.ihj != null && a.this.ihj.ihJ != null && com.baidu.adp.lib.f.b.toInt(a.this.ihj.ihJ.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.ihj.ihJ.videoWidth, 0)) {
                        a.this.ihi.aw(false, false);
                    } else {
                        a.this.ihi.aw(true, false);
                    }
                    a.this.iho = false;
                    a.this.IS(a.this.eiU ? "1" : "2");
                    a.this.onClick(a.this.igU);
                    if (a.this.YN != null) {
                        a.this.YN.a(a.this);
                    }
                    if (a.this.iDB != null) {
                        a.this.iDB.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void csb() {
                    a.this.onClick(a.this.igT);
                }
            });
            this.ihi.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void oN(boolean z2) {
                    a.this.ihi.fK(a.this.ihj.ihJ.videoUrl, a.this.ihj.threadId);
                    a.this.IS("2");
                    a.this.onClick(a.this.igU);
                }
            });
            this.ihi.vb(false);
            if (this.iDA != null) {
                this.iDA.reset();
            }
            this.startPosition = -1L;
            if (this.ihi.getVideoView() != null && this.ihi.getVideoView().getMediaProgressObserver() != null) {
                this.ihi.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ca(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.ihj.ihJ.ihT;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.hqq.a(a.this.isFullScreen, a.this.ihi != null && a.this.ihi.dnc(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.hqq.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.ihi.dnc() && !com.baidu.mcn.b.TD().m29if(aVar2.Zc)) {
                            boolean z3 = a.this.startPosition >= (aVar2.ihL * 1000) + 1000;
                            if (i3 < aVar2.ihL * 1000 || i3 >= aVar2.ihM * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.iDA.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bDr = aVar2.ihO;
                                    aVar3.bDs = aVar2.ihP;
                                    aVar3.bDt = aVar2.Zc;
                                    aVar3.bDq = aVar2.ihN;
                                    aVar3.fid = a.this.ihj != null ? a.this.ihj.forumId : null;
                                    aVar3.tid = a.this.ihj != null ? a.this.ihj.threadId : null;
                                    aVar3.bDu = 3;
                                    if (z3) {
                                        a.this.iDA.b(aVar3, (ViewGroup) a.this.ihi.dnv());
                                    } else {
                                        a.this.iDA.a(aVar3, (ViewGroup) a.this.ihi.dnv());
                                    }
                                }
                            } else if (a.this.iDA.isShowing()) {
                                a.this.iDA.dismiss();
                            }
                        }
                    }
                });
            }
            this.ihl = new o();
            this.ihl.alA = gVar.threadId;
            this.ihl.mNid = gVar.nid;
            this.ihl.eYo = gVar.forumId;
            this.ihl.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ihl.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.ihl.mSource = gVar.source;
            this.ihl.lCf = gVar.weight;
            this.ihl.lCh = this.mFrom;
            this.ihl.lCj = gVar.abtest_tag;
            this.ihl.eaC = this.eaC;
            this.ihl.mExtra = gVar.extra;
            this.ihl.lCm = "0";
            this.ihl.lCi = gVar.getVideoType();
            this.ihm = new o();
            this.ihm.alA = gVar.threadId;
            this.ihm.eYo = gVar.forumId;
            this.ihm.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ihm.lCf = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.ihm.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.ihm.lCh = this.mFrom;
            this.ihm.mSource = gVar.source;
            this.ihm.lCm = "0";
            if (gVar.ihJ != null) {
                this.ihl.lCk = gVar.ihJ.videoMd5;
                this.ihm.lCk = gVar.ihJ.videoMd5;
            }
            aq aqVar = new aq("c12590");
            aqVar.dF("tid", gVar.threadId);
            aqVar.dF("nid", gVar.nid);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", i);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dF("fid", gVar.forumId);
            aqVar.dF("obj_param1", at.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aqVar.dF("extra", at.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aqVar.dF("obj_id", this.eaC);
            aqVar.dF("ab_tag", at.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aqVar.dF("obj_type", this.mFrom);
            aqVar.ai("obj_param5", gVar.getVideoType());
            aqVar.dF("obj_source", at.isEmpty(gVar.source) ? "0" : gVar.source);
            aqVar.ai("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aqVar.dF("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aqVar.dF("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aqVar);
            this.ihi.getVideoView().setVideoStatData(this.ihl);
            this.ihi.cQw();
            this.ihi.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.hqq.a(a.this.isFullScreen, a.this.ihi != null && a.this.ihi.dnc(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.iho = true;
                            a.this.iDq = true;
                            a.this.ihn = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.xZ(i);
                            a.this.ihi.cDc();
                        }
                    }
                }
            });
            this.ihi.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.ihj != null && a.this.ihj.ihJ != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.ihj.ihJ.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.hqq.reset();
            }
            this.hqq.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rR() {
                    a.this.iDq = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rQ() {
                    if (a.this.isFullScreen) {
                        a.this.iho = true;
                        a.this.iDq = true;
                        a.this.ihn = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.xZ(i);
                        a.this.ihi.cDc();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rP() {
                    if (a.this.ihi != null) {
                        a.this.ihi.Ge(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rS() {
                    return a.this.cxC();
                }
            });
            this.ihi.setThumbnail(gVar.ihJ.thumbnailUrl);
            this.ihi.Gd(gVar.ihJ.videoDuration);
            this.ihi.setVideoUrl(gVar.ihJ.videoUrl, gVar.threadId);
            this.ihi.setFid(gVar.forumId);
            this.ihi.cDc();
            this.ihi.show();
            pr(false);
            if (gVar.autoPlay) {
                onClick(this.igU);
                if (this.iDy.diX()) {
                    this.ihi.vh(false);
                    this.iDy.dIq();
                    this.ihi.vi(true);
                    this.ihi.fJ(gVar.ihJ.videoUrl, gVar.threadId);
                    if (this.hqq.rA()) {
                        this.hqq.stop();
                        this.hqq.rF();
                    }
                } else {
                    this.ihi.vi(false);
                    this.ihi.vh(false);
                    this.iDy.hide();
                    if (this.hqq == null || (this.hqq != null && !this.hqq.rA())) {
                        this.ihi.a(gVar.ihJ.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.ihK) {
                    this.iDt.setVisibility(8);
                    this.iDx.zw(3);
                } else {
                    if (this.iDt.getVisibility() == 0) {
                        this.iDt.startAnimation(this.bDF);
                    }
                    this.iDx.zw(0);
                }
                gVar.ihK = false;
            } else {
                this.iDt.setVisibility(0);
                this.iDy.hide();
                this.ihi.vh(true);
                this.iDx.zw(3);
                this.ihi.fJ(gVar.ihJ.videoUrl, gVar.threadId);
            }
            this.iho = false;
            this.iDq = false;
            if (!z && this.hqq.rA()) {
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
        com.baidu.afd.videopaster.data.b JA = this.iDz != null ? this.iDz.JA(gVar.getThreadId()) : null;
        if (JA == null) {
            return null;
        }
        int rW = JA.rW();
        int rX = JA.rX();
        int rV = JA.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.ihJ != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.ihJ.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.ihJ.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", rV + 1, i3, i2);
        a.u(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IS(String str) {
        if (this.ihj != null && this.ihj.ihJ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.ihj.ihJ.videoMd5, "", str, this.ihm, this.ihi.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.ihi.rK();
    }

    public boolean cxA() {
        return this.hqq.rA();
    }

    public void crW() {
        if (isPlaying()) {
            this.ihi.aII();
        }
    }

    public boolean ya(int i) {
        if (i == 4 && this.hqq != null && ((this.hqq.rA() || this.iDq) && this.ihi != null)) {
            this.hqq.aZ(i);
            if (this.isFullScreen) {
                if (this.hqq.rz()) {
                    this.ihi.dnd();
                } else {
                    this.ihi.OK();
                }
                return true;
            }
        }
        return this.ihi.Ge(i);
    }

    public void crX() {
        this.iDs = false;
        this.ihi.stopPlay();
        if (this.iDm != null) {
            this.iDm.setVisibility(0);
        }
        if (this.iDx != null) {
            this.iDx.zw(2);
        }
        pr(false);
        this.iDr = true;
        if (this.hqq != null && this.hqq.rA()) {
            this.hqq.stop();
        }
    }

    public void cxB() {
        this.hqq.stop();
    }

    public void crY() {
        if (this.ihi != null) {
            this.ihi.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        crY();
        if (this.ihk != null) {
            this.ihk.csi();
        }
        if (this.iDt != null) {
            this.iDt.clearAnimation();
        }
        this.hqq.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.ihI != null) {
            this.ajb.setText(TextUtils.isEmpty(gVar.ihI.userNickname) ? gVar.ihI.userName : gVar.ihI.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.ihI != null) {
            if (gVar.ihI.ihS != null && !TextUtils.isEmpty(gVar.ihI.ihS.avatar)) {
                this.iha.startLoad(gVar.ihI.ihS.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.ihI.portrait) && gVar.ihI.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iha.startLoad(gVar.ihI.portrait, 10, false);
            } else {
                this.iha.startLoad(gVar.ihI.portrait, 12, false);
            }
            if (gVar.ihI.ihS != null && gVar.ihI.ihS.auth_id.intValue() > 0) {
                this.iha.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.ihI.ihS.auth_id.intValue(), 1));
                this.iha.setShowV(true);
                this.iha.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.iha.setBjhAuthIconRes(0);
            if (gVar.ihI.isBigV) {
                this.iha.setShowV(gVar.ihI.isBigV);
                this.iha.setIsBigV(gVar.ihI.isBigV);
            } else if (gVar.ihI.isGod) {
                this.iha.setShowV(gVar.ihI.isGod);
                this.iha.setIsBigV(gVar.ihI.isGod);
            } else {
                this.iha.setShowV(gVar.ihI.isGod);
                this.iha.setIsBigV(gVar.ihI.isGod);
            }
            this.iha.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bhp() != null) {
                gVar.bhp().isInThread = true;
                gVar.bhp().nid = gVar.nid;
                if (this.ihj.getVideoType() == 1) {
                    gVar.bhp().cardType = 2;
                } else if (this.ihj.getVideoType() == 2) {
                    gVar.bhp().cardType = 8;
                } else if (this.ihj.getVideoType() == 3) {
                    gVar.bhp().cardType = 6;
                }
                gVar.bhp().baijiahaoData = gVar.mBaijiahao;
                gVar.bhp().recomSource = gVar.source;
                gVar.bhp().recomWeight = gVar.weight;
                gVar.bhp().recomAbTag = gVar.abtest_tag;
                gVar.bhp().recomExtra = gVar.extra;
            }
            if (this.ihj.mBaijiahao != null) {
                this.evE.setAgreeAlone(true);
            }
            this.evE.setIsFromMiddlePage(true);
            this.evE.setData(gVar.bhp());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dVT.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bkl().a(this.evF, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dVT.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.dVT.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.evH.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bkl().a(this.evI, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.evH.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.evH.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.ihi != null && this.igU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.ihn) {
                this.ihi.dnj();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cxD();
            } else {
                configuration.orientation = 1;
                cxE();
                this.ihn = true;
            }
            this.ihi.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxC() {
        if (this.ihi != null && this.igU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.igU.getParent() != null) {
                if (this.igU.getParent() == frameLayout) {
                    if (this.iDC) {
                        this.iDC = false;
                        return true;
                    } else if (!this.iDD) {
                        this.iDD = true;
                        return true;
                    }
                } else if (this.igU.getParent() == this.igT) {
                    if (this.iDD) {
                        this.iDD = false;
                        this.iDE = true;
                        return true;
                    } else if (!this.iDC && this.iDE) {
                        this.iDC = true;
                        this.iDE = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxD() {
        if (this.ihi != null && this.igU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.igU.getParent() != null) {
                if (this.igU.getParent() == frameLayout) {
                    frameLayout.removeView(this.igU);
                } else if (this.igU.getParent() == this.igT) {
                    this.igT.removeView(this.igU);
                }
            }
            if (this.igU.getParent() == null) {
                frameLayout.addView(this.igU);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igU.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.igU.setLayoutParams(layoutParams);
                if (this.iDA != null && this.iDA.isShowing()) {
                    this.iDA.dismiss();
                }
                com.baidu.tbadk.util.e.bwo().jL(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxE() {
        if (this.ihi != null && this.igU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.igU.getParent() != null) {
                if (this.igU.getParent() == frameLayout) {
                    cxF();
                    frameLayout.removeView(this.igU);
                } else if (this.igU.getParent() == this.igT) {
                    cxF();
                    this.igT.removeView(this.igU);
                }
            }
            if (this.igU.getParent() == null) {
                this.igT.addView(this.igU, 0);
                cxG();
                this.ihi.cQw();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bwo().jL(false);
            }
        }
    }

    private void cxF() {
        if (this.hqq != null && this.hqq.rA()) {
            this.hqq.aB(true);
        }
    }

    private void cxG() {
        int i;
        if (!cxy()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.igU.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (ceP() != null) {
            view.setTag(this);
            ceP().a(view, this.ihj);
        }
        if (view == this.iha || view == this.ajb) {
            if (this.ihj != null && this.ihj.ihI != null && !TextUtils.isEmpty(this.ihj.ihI.userId)) {
                this.iDx.zw(0);
                if (!TbadkCoreApplication.isLogin() || !this.ihj.ihI.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.ihj.ihI.userId, 0L), z, this.ihj.ihI.isGod)));
            }
        } else if (view == this.evG) {
            if (this.ihj != null) {
                this.iDx.zw(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.ihj.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.ihj.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.iDm || view == this.iDn) {
            if (this.ihj != null) {
                if (this.iDx.getCurrentState() != 2 && this.iDx.getCurrentState() != 3) {
                    z = false;
                }
                this.iDx.zw(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.ihj.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.ihj.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.evJ) {
            this.iDx.zw(0);
            blQ();
        } else if (view == this.iDt && this.iDt.getVisibility() == 0 && this.iDv != null) {
            this.iDv.zA(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oM(boolean z) {
        if (this.ihj != null && this.ihj.ihI != null) {
            this.ihj.ihI.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void crZ() {
        if (this.ihj != null) {
            this.evE.blb();
        }
    }

    public void pq(boolean z) {
        if (this.igT != null) {
            this.igT.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.iDB = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.iDv = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.YN = fVar;
    }

    private void pr(boolean z) {
        this.iDr = this.mPosition == (this.iDw == null ? -1 : this.iDw.cxS());
        if (this.iDr && z && isPlaying() && this.eiU && !this.iDs) {
            this.iDo.setVisibility(0);
            this.iDs = true;
            this.iDo.postDelayed(this.iDH, 5000L);
            if (this.iDw != null) {
                this.iDw.eX(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.iDo.setVisibility(8);
        if (this.iDH != null) {
            this.iDo.removeCallbacks(this.iDH);
        }
    }

    private void blQ() {
        String str;
        String str2;
        if (this.ihj != null && this.mContext != null) {
            String valueOf = String.valueOf(this.ihj.forumId);
            String str3 = this.ihj.title;
            if (this.ihj.mBaijiahao != null) {
                str = this.ihj.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.ihj.mBaijiahao.oriUgcType + "&dvid=" + this.ihj.mBaijiahao.oriUgcVid + "&nid=" + this.ihj.mBaijiahao.oriUgcNid;
            } else {
                str = this.ihj.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.ihj.ihJ.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.ihj.title;
            String format = (this.ihj.mBaijiahao == null || this.ihj.ihI == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.ihj.ihI.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.ihj.mBaijiahao != null) {
                shareItem.eGA = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.eGA = str6;
                shareItem.readCount = this.ihj.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.eGD = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.eGp = true;
            shareItem.eGC = 11;
            if (this.ihj.getVideoType() == 1) {
                shareItem.eGH = 2;
            } else if (this.ihj.getVideoType() == 2) {
                shareItem.eGH = 8;
            } else if (this.ihj.getVideoType() == 3) {
                shareItem.eGH = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.ihj.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.ihj.mBaijiahao;
            shareItem.eGK = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dF("tid", str);
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.ai("obj_locate", 12);
            aqVar.dF("nid", this.ihj.nid);
            if (this.ihj.mBaijiahao != null && !at.isEmpty(this.ihj.mBaijiahao.oriUgcVid)) {
                aqVar.dF("obj_param6", this.ihj.mBaijiahao.oriUgcVid);
            }
            if (this.ihj.getVideoType() == 1) {
                aqVar.ai(IntentConfig.CARD_TYPE, 2);
            } else if (this.ihj.getVideoType() == 2) {
                aqVar.ai(IntentConfig.CARD_TYPE, 8);
            } else if (this.ihj.getVideoType() == 3) {
                aqVar.ai(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dF(IntentConfig.RECOM_SOURCE, this.ihj.source);
            aqVar.dF("ab_tag", this.ihj.abtest_tag);
            aqVar.dF("weight", this.ihj.weight);
            aqVar.dF("extra", this.ihj.extra);
            aqVar.dF("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dF("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dF("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eGD);
            bundle.putInt("obj_type", shareItem.eGH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.egT);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.cgr().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        crX();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aII() {
        crW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ps(boolean z) {
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

    public void cxH() {
        this.hqq.resume();
    }

    public boolean cxI() {
        if (this.iDx != null) {
            return this.iDx.getCurrentState() == 2 || this.iDx.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0688a {
        private int bOf;
        private Runnable iDM;

        private C0688a() {
            this.bOf = -1;
            this.iDM = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(C0688a.this.iDM);
                    C0688a.this.zw(2);
                }
            };
        }

        public void zw(int i) {
            switch (i) {
                case 0:
                    this.bOf = zx(i);
                    cxJ();
                    return;
                case 1:
                    this.bOf = zx(i);
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDM);
                    return;
                case 2:
                    this.bOf = zy(i);
                    return;
                case 3:
                    this.bOf = zz(i);
                    cxJ();
                    return;
                default:
                    this.bOf = zy(i);
                    return;
            }
        }

        private void cxJ() {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDM);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.iDM, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.bOf;
        }

        private int zx(int i) {
            if (i != this.bOf) {
                a.this.iDu.setVisibility(8);
                a.this.ps(true);
                return i;
            }
            return this.bOf;
        }

        private int zy(int i) {
            int i2 = this.bOf;
            if (i != this.bOf) {
                a.this.iDu.setVisibility(0);
                if (i2 != 3 || a.this.ihj.autoPlay) {
                    a.this.ps(false);
                    return i;
                }
                return i;
            }
            return this.bOf;
        }

        private int zz(int i) {
            if (i != this.bOf) {
                a.this.iDu.setVisibility(0);
                a.this.ps(true);
                return i;
            }
            return this.bOf;
        }
    }
}
