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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
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
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f XN;
    public TextView ahr;
    private Animation but;
    private Animation buu;
    private TextView dKx;
    private String dOV;
    private boolean dXa;
    protected AgreeView ejB;
    private ImageView ejC;
    private View ejD;
    private TextView ejE;
    private ImageView ejF;
    private View ejG;
    private com.baidu.afd.videopaster.d gWq;
    public FrameLayout hLE;
    public FrameLayout hLF;
    public HeadImageView hLL;
    public com.baidu.tieba.play.c hLS;
    public com.baidu.tieba.frs.aggregation.g hLT;
    private com.baidu.tieba.frs.aggregation.h hLU;
    private o hLV;
    private o hLW;
    private boolean hLX;
    private boolean hLY;
    private boolean hMb;
    private int hmU;
    public ExpandableTextView ihF;
    private View ihG;
    private FrameLayout ihH;
    private TextView ihI;
    private boolean ihJ;
    private boolean ihK;
    private boolean ihL;
    private View ihM;
    private View ihN;
    private c ihO;
    public com.baidu.tieba.frs.videomiddlepage.a.a ihP;
    private C0640a ihQ;
    private VideoNetworkStateTipView ihR;
    private b ihS;
    private com.baidu.mcn.c ihT;
    private com.baidu.tieba.lego.card.view.g ihU;
    private boolean ihV;
    private boolean ihW;
    private boolean ihX;
    private Animation.AnimationListener ihY;
    private Animation.AnimationListener ihZ;
    private Runnable iia;
    private Runnable iib;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.hLX = true;
        this.hMb = true;
        this.ihK = false;
        this.ihL = false;
        this.ihV = false;
        this.ihW = false;
        this.ihX = false;
        this.startPosition = -1L;
        this.hmU = 0;
        this.ihY = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ihM != null) {
                    a.this.ihM.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ihM != null) {
                    a.this.ihM.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ihZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ihM != null) {
                    a.this.ihM.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ihM != null) {
                    a.this.ihM.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iia = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ihH.getVisibility() == 0) {
                    a.this.ihH.setVisibility(8);
                }
            }
        };
        this.iib = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hLS != null) {
                    a.this.hLS.stopPlay();
                }
            }
        };
        this.hMb = z;
        this.mFrom = str;
        this.dOV = str2;
        this.ihS = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hLE = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.ihG = view.findViewById(R.id.card_container);
        this.hLF = (FrameLayout) view.findViewById(R.id.video_container);
        this.hLS = new com.baidu.tieba.play.c(tbPageContext, this.hLF, false);
        this.hLS.ug(z);
        this.hLS.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.ihP != null && a.this.hLT.hMt.videoDuration > 8) {
                    a.this.ihP.bf(a.this.mPosition, a.this.hLT.hMt.videoUrl);
                }
            }
        });
        this.hLS.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void oH(boolean z2) {
                if (a.this.ihQ != null) {
                    if (z2) {
                        a.this.ihQ.wE(0);
                    } else {
                        a.this.ihQ.wE(1);
                    }
                }
            }
        });
        this.hLS.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.ihF = (ExpandableTextView) view.findViewById(R.id.title);
        this.hLL = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ahr = (TextView) view.findViewById(R.id.user_name);
        this.ejB = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNC = 2;
        cVar.dNH = 6;
        this.ejB.setStatisticData(cVar);
        this.dKx = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.ejC = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.ejD = view.findViewById(R.id.thread_info_commont_container);
        this.ejE = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.ejF = (ImageView) view.findViewById(R.id.share_num_img);
        this.ejG = view.findViewById(R.id.share_num_container);
        this.ihH = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.ihI = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.ihH.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ihI.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_download_link_url", null);
        this.ihI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bd.baV().a((TbPageContext) i.G(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.ihR = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.ihR.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ap("c13257"));
                a.this.ihR.setHasAgreeToPlay(true);
                a.this.hLS.um(false);
                a.this.ihR.dsT();
                if (a.this.gWq.pW()) {
                    a.this.gWq.resume();
                } else if (a.this.hLT != null && a.this.hLT.hMt != null) {
                    a.this.hLS.ff(a.this.hLT.hMt.videoUrl, a.this.hLT.threadId);
                }
            }
        });
        this.ihM = view.findViewById(R.id.video_agg_container_foreground);
        this.ihN = view.findViewById(R.id.title_and_comment_container_foreground);
        this.ihM.setOnClickListener(this);
        this.ejD.setOnClickListener(this);
        this.ejG.setOnClickListener(this);
        this.ihF.setOnClickListener(this);
        this.hLL.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.ihG.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.hmU = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLE.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hLE.setLayoutParams(layoutParams);
        this.hLL.setIsRound(true);
        this.hLL.setPlaceHolder(1);
        this.hLU = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.but = new AlphaAnimation(0.0f, 0.7f);
        this.but.setDuration(500L);
        this.but.setAnimationListener(this.ihZ);
        this.buu = new AlphaAnimation(0.7f, 0.0f);
        this.buu.setDuration(500L);
        this.buu.setAnimationListener(this.ihY);
        this.ihQ = new C0640a();
        this.gWq = new com.baidu.afd.videopaster.d(getContext(), this.hLF);
        this.ihT = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ejB.onChangeSkinType(i);
        this.dKx.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.ejE.setTextColor(ao.getColor(R.color.cp_cont_d));
        SvgManager.baR().a(this.ejC, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.ejF, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ihF.onChangeSkinType();
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
        if (gVar != null && gVar.hMt != null) {
            boolean z = this.hLT == gVar;
            this.hLT = gVar;
            this.dXa = this.hLT.autoPlay;
            this.ihL = false;
            oF(false);
            this.ihF.setVisibility(0);
            this.ihF.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.ihF.setTextColor(R.color.cp_cont_a);
            this.ihF.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.hMt != null && !StringUtils.isNull(gVar.hMt.mcnLeadPage)) {
                this.ihF.setTextMaxLine(2);
                this.ihF.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.ihF.getContentView(), gVar.title, gVar.hMt.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ihF.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ihF.setExpandable(true);
                this.ihF.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void oI(boolean z2) {
                        a.this.hLT.isTitleExpanded = z2;
                    }
                });
                this.ihF.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.hmU) {
                this.hLS.cYK();
                this.hmU = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hLF.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hLF.setLayoutParams(layoutParams);
            }
            cjB();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.hLT = gVar;
        this.dXa = this.hLT.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cjA() {
        try {
            int parseInt = Integer.parseInt(this.hLT.hMt.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.hLT.hMt.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cjB() {
        if (!cjA()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLE.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hLE.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hLE.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hLE.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.hMt != null) {
            this.hLS.stopPlay();
            this.hLS.un(true);
            this.hLS.uj(true);
            this.hLS.uo(true);
            this.hLS.ap(false, false);
            this.hLS.Dj(i);
            this.hLS.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qe() {
                    a.this.cjF();
                    if (a.this.gWq != null) {
                        a.this.gWq.qe();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qf() {
                    a.this.cjG();
                    if (a.this.hLS.qg()) {
                    }
                    if (a.this.hLY || (a.this.gWq != null && a.this.gWq.pW())) {
                        com.baidu.adp.lib.f.e.lt().removeCallbacks(a.this.iib);
                        com.baidu.adp.lib.f.e.lt().post(a.this.iib);
                    }
                    if (a.this.gWq != null) {
                        a.this.gWq.qf();
                    }
                }
            });
            this.hLS.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void cei() {
                    if (a.this.hLT != null && a.this.hLT.hMt != null && com.baidu.adp.lib.f.b.toInt(a.this.hLT.hMt.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.hLT.hMt.videoWidth, 0)) {
                        a.this.hLS.ap(false, false);
                    } else {
                        a.this.hLS.ap(true, false);
                    }
                    a.this.hLY = false;
                    a.this.FS(a.this.dXa ? "1" : "2");
                    a.this.onClick(a.this.hLF);
                    if (a.this.XN != null) {
                        a.this.XN.a(a.this);
                    }
                    if (a.this.ihU != null) {
                        a.this.ihU.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cej() {
                    a.this.onClick(a.this.hLE);
                }
            });
            this.hLS.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void ob(boolean z2) {
                    a.this.hLS.ff(a.this.hLT.hMt.videoUrl, a.this.hLT.threadId);
                    a.this.FS("2");
                    a.this.onClick(a.this.hLF);
                }
            });
            this.hLS.uf(false);
            if (this.ihT != null) {
                this.ihT.reset();
            }
            this.startPosition = -1L;
            if (this.hLS.getVideoView() != null && this.hLS.getVideoView().getMediaProgressObserver() != null) {
                this.hLS.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bP(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.hLT.hMt.hMD;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.gWq.a(a.this.isFullScreen, a.this.hLS != null && a.this.hLS.cYr(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.gWq.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.hLS.cYr() && !com.baidu.mcn.b.MN().gn(aVar2.Yc)) {
                            boolean z3 = a.this.startPosition >= (aVar2.hMv * 1000) + 1000;
                            if (i3 < aVar2.hMv * 1000 || i3 >= aVar2.hMw * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.ihT.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bug = aVar2.hMy;
                                    aVar3.buh = aVar2.hMz;
                                    aVar3.bui = aVar2.Yc;
                                    aVar3.bue = aVar2.hMx;
                                    aVar3.fid = a.this.hLT != null ? a.this.hLT.forumId : null;
                                    aVar3.tid = a.this.hLT != null ? a.this.hLT.threadId : null;
                                    aVar3.buj = 3;
                                    if (z3) {
                                        a.this.ihT.b(aVar3, (ViewGroup) a.this.hLS.cYJ());
                                    } else {
                                        a.this.ihT.a(aVar3, (ViewGroup) a.this.hLS.cYJ());
                                    }
                                }
                            } else if (a.this.ihT.isShowing()) {
                                a.this.ihT.dismiss();
                            }
                        }
                    }
                });
            }
            this.hLV = new o();
            this.hLV.ajJ = gVar.threadId;
            this.hLV.mNid = gVar.nid;
            this.hLV.eKO = gVar.forumId;
            this.hLV.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hLV.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.hLV.mSource = gVar.source;
            this.hLV.lcJ = gVar.weight;
            this.hLV.lcL = this.mFrom;
            this.hLV.lcN = gVar.abtest_tag;
            this.hLV.dOV = this.dOV;
            this.hLV.mExtra = gVar.extra;
            this.hLV.lcQ = "0";
            this.hLV.lcM = gVar.getVideoType();
            this.hLW = new o();
            this.hLW.ajJ = gVar.threadId;
            this.hLW.eKO = gVar.forumId;
            this.hLW.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hLW.lcJ = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hLW.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hLW.lcL = this.mFrom;
            this.hLW.mSource = gVar.source;
            this.hLW.lcQ = "0";
            if (gVar.hMt != null) {
                this.hLV.lcO = gVar.hMt.videoMd5;
                this.hLW.lcO = gVar.hMt.videoMd5;
            }
            ap apVar = new ap("c12590");
            apVar.dn("tid", gVar.threadId);
            apVar.dn("nid", gVar.nid);
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            apVar.ah("obj_locate", i);
            apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
            apVar.dn("fid", gVar.forumId);
            apVar.dn("obj_param1", as.isEmpty(gVar.weight) ? "0" : gVar.weight);
            apVar.dn("extra", as.isEmpty(gVar.extra) ? "0" : gVar.extra);
            apVar.dn("obj_id", this.dOV);
            apVar.dn("ab_tag", as.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            apVar.dn("obj_type", this.mFrom);
            apVar.ah("obj_param5", gVar.getVideoType());
            apVar.dn("obj_source", as.isEmpty(gVar.source) ? "0" : gVar.source);
            apVar.ah("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                apVar.dn("obj_param4", gVar.mBaijiahao.oriUgcNid);
                apVar.dn("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(apVar);
            this.hLS.getVideoView().setVideoStatData(this.hLV);
            this.hLS.cBY();
            this.hLS.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.gWq.a(a.this.isFullScreen, a.this.hLS != null && a.this.hLS.cYr(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.hLY = true;
                            a.this.ihJ = true;
                            a.this.hLX = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.vi(i);
                            a.this.hLS.coB();
                        }
                    }
                }
            });
            this.hLS.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.hLT != null && a.this.hLT.hMt != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.hLT.hMt.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.gWq.reset();
            }
            this.gWq.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void qn() {
                    a.this.ihJ = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void qm() {
                    if (a.this.isFullScreen) {
                        a.this.hLY = true;
                        a.this.ihJ = true;
                        a.this.hLX = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.vi(i);
                        a.this.hLS.coB();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void ql() {
                    if (a.this.hLS != null) {
                        a.this.hLS.Di(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean qo() {
                    return a.this.cjE();
                }
            });
            this.hLS.setThumbnail(gVar.hMt.thumbnailUrl);
            this.hLS.Dh(gVar.hMt.videoDuration);
            this.hLS.setVideoUrl(gVar.hMt.videoUrl, gVar.threadId);
            this.hLS.setFid(gVar.forumId);
            this.hLS.coB();
            this.hLS.show();
            oF(false);
            if (gVar.autoPlay) {
                onClick(this.hLF);
                if (this.ihR.cUv()) {
                    this.hLS.ul(false);
                    this.ihR.dsS();
                    this.hLS.um(true);
                    this.hLS.fe(gVar.hMt.videoUrl, gVar.threadId);
                    if (this.gWq.pW()) {
                        this.gWq.stop();
                        this.gWq.qb();
                    }
                } else {
                    this.hLS.um(false);
                    this.hLS.ul(false);
                    this.ihR.hide();
                    if (this.gWq == null || (this.gWq != null && !this.gWq.pW())) {
                        this.hLS.a(gVar.hMt.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.hMu) {
                    this.ihM.setVisibility(8);
                    this.ihQ.wE(3);
                } else {
                    if (this.ihM.getVisibility() == 0) {
                        this.ihM.startAnimation(this.buu);
                    }
                    this.ihQ.wE(0);
                }
                gVar.hMu = false;
            } else {
                this.ihM.setVisibility(0);
                this.ihR.hide();
                this.hLS.ul(true);
                this.ihQ.wE(3);
                this.hLS.fe(gVar.hMt.videoUrl, gVar.threadId);
            }
            this.hLY = false;
            this.ihJ = false;
            if (!z && this.gWq.pW()) {
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
        com.baidu.afd.videopaster.data.b Gz = this.ihS != null ? this.ihS.Gz(gVar.getThreadId()) : null;
        if (Gz == null) {
            return null;
        }
        int qs = Gz.qs();
        int qt = Gz.qt();
        int qr = Gz.qr();
        if (qr != -1) {
            i = qs != -1 ? (qr - qs) - 1 : -1;
            if (qt != -1) {
                i4 = (qt - qr) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.hMt != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.hMt.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.hMt.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", qr + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(String str) {
        if (this.hLT != null && this.hLT.hMt != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.hLT.hMt.videoMd5, "", str, this.hLW, this.hLS.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hLS.qg();
    }

    public boolean cjC() {
        return this.gWq.pW();
    }

    public void cee() {
        if (isPlaying()) {
            this.hLS.azN();
        }
    }

    public boolean vj(int i) {
        if (i == 4 && this.gWq != null && ((this.gWq.pW() || this.ihJ) && this.hLS != null)) {
            this.gWq.aS(i);
            if (this.isFullScreen) {
                if (this.gWq.pV()) {
                    this.hLS.cYs();
                } else {
                    this.hLS.Io();
                }
                return true;
            }
        }
        return this.hLS.Di(i);
    }

    public void cef() {
        this.ihL = false;
        this.hLS.stopPlay();
        if (this.ihF != null) {
            this.ihF.setVisibility(0);
        }
        if (this.ihQ != null) {
            this.ihQ.wE(2);
        }
        oF(false);
        this.ihK = true;
        if (this.gWq != null && this.gWq.pW()) {
            this.gWq.stop();
        }
    }

    public void cjD() {
        this.gWq.stop();
    }

    public void ceg() {
        if (this.hLS != null) {
            this.hLS.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        ceg();
        if (this.hLU != null) {
            this.hLU.ceq();
        }
        if (this.ihM != null) {
            this.ihM.clearAnimation();
        }
        this.gWq.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.hMs != null) {
            this.ahr.setText(TextUtils.isEmpty(gVar.hMs.userNickname) ? gVar.hMs.userName : gVar.hMs.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.hMs != null) {
            if (gVar.hMs.hMC != null && !TextUtils.isEmpty(gVar.hMs.hMC.avatar)) {
                this.hLL.startLoad(gVar.hMs.hMC.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.hMs.portrait) && gVar.hMs.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hLL.startLoad(gVar.hMs.portrait, 10, false);
            } else {
                this.hLL.startLoad(gVar.hMs.portrait, 12, false);
            }
            if (gVar.hMs.hMC != null && gVar.hMs.hMC.auth_id.intValue() > 0) {
                this.hLL.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.hMs.hMC.auth_id.intValue(), 1));
                this.hLL.setShowV(true);
                this.hLL.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hLL.setBjhAuthIconRes(0);
            if (gVar.hMs.isBigV) {
                this.hLL.setShowV(gVar.hMs.isBigV);
                this.hLL.setIsBigV(gVar.hMs.isBigV);
            } else if (gVar.hMs.isGod) {
                this.hLL.setShowV(gVar.hMs.isGod);
                this.hLL.setIsBigV(gVar.hMs.isGod);
            } else {
                this.hLL.setShowV(gVar.hMs.isGod);
                this.hLL.setIsBigV(gVar.hMs.isGod);
            }
            this.hLL.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aYc() != null) {
                gVar.aYc().isInThread = true;
                gVar.aYc().nid = gVar.nid;
                if (this.hLT.getVideoType() == 1) {
                    gVar.aYc().cardType = 2;
                } else if (this.hLT.getVideoType() == 2) {
                    gVar.aYc().cardType = 8;
                } else if (this.hLT.getVideoType() == 3) {
                    gVar.aYc().cardType = 6;
                }
                gVar.aYc().baijiahaoData = gVar.mBaijiahao;
                gVar.aYc().recomSource = gVar.source;
                gVar.aYc().recomWeight = gVar.weight;
                gVar.aYc().recomAbTag = gVar.abtest_tag;
                gVar.aYc().recomExtra = gVar.extra;
            }
            if (this.hLT.mBaijiahao != null) {
                this.ejB.setAgreeAlone(true);
            }
            this.ejB.setIsFromMiddlePage(true);
            this.ejB.setData(gVar.aYc());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dKx.setTextColor(ao.getColor(R.color.cp_cont_d));
            SvgManager.baR().a(this.ejC, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dKx.setText(as.numFormatOverWan(gVar.postNum));
            } else {
                this.dKx.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.ejE.setTextColor(ao.getColor(R.color.cp_cont_d));
            SvgManager.baR().a(this.ejF, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.ejE.setText(as.numFormatOverWan(gVar.shareNum));
            } else {
                this.ejE.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hLS != null && this.hLF != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hLX) {
                this.hLS.cYy();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cjF();
            } else {
                configuration.orientation = 1;
                cjG();
                this.hLX = true;
            }
            this.hLS.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cjE() {
        if (this.hLS != null && this.hLF != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hLF.getParent() != null) {
                if (this.hLF.getParent() == frameLayout) {
                    if (this.ihV) {
                        this.ihV = false;
                        return true;
                    } else if (!this.ihW) {
                        this.ihW = true;
                        return true;
                    }
                } else if (this.hLF.getParent() == this.hLE) {
                    if (this.ihW) {
                        this.ihW = false;
                        this.ihX = true;
                        return true;
                    } else if (!this.ihV && this.ihX) {
                        this.ihV = true;
                        this.ihX = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjF() {
        if (this.hLS != null && this.hLF != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hLF.getParent() != null) {
                if (this.hLF.getParent() == frameLayout) {
                    frameLayout.removeView(this.hLF);
                } else if (this.hLF.getParent() == this.hLE) {
                    this.hLE.removeView(this.hLF);
                }
            }
            if (this.hLF.getParent() == null) {
                frameLayout.addView(this.hLF);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hLF.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hLF.setLayoutParams(layoutParams);
                if (this.ihT != null && this.ihT.isShowing()) {
                    this.ihT.dismiss();
                }
                com.baidu.tbadk.util.e.bmw().jk(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjG() {
        if (this.hLS != null && this.hLF != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hLF.getParent() != null) {
                if (this.hLF.getParent() == frameLayout) {
                    cjH();
                    frameLayout.removeView(this.hLF);
                } else if (this.hLF.getParent() == this.hLE) {
                    cjH();
                    this.hLE.removeView(this.hLF);
                }
            }
            if (this.hLF.getParent() == null) {
                this.hLE.addView(this.hLF, 0);
                cjI();
                this.hLS.cBY();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bmw().jk(false);
            }
        }
    }

    private void cjH() {
        if (this.gWq != null && this.gWq.pW()) {
            this.gWq.aA(true);
        }
    }

    private void cjI() {
        int i;
        if (!cjA()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hLF.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bRn() != null) {
            view.setTag(this);
            bRn().a(view, this.hLT);
        }
        if (view == this.hLL || view == this.ahr) {
            if (this.hLT != null && this.hLT.hMs != null && !TextUtils.isEmpty(this.hLT.hMs.userId)) {
                this.ihQ.wE(0);
                if (!TbadkCoreApplication.isLogin() || !this.hLT.hMs.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hLT.hMs.userId, 0L), z, this.hLT.hMs.isGod)));
            }
        } else if (view == this.ejD) {
            if (this.hLT != null) {
                this.ihQ.wE(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hLT.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.hLT.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.ihF || view == this.ihG) {
            if (this.hLT != null) {
                if (this.ihQ.getCurrentState() != 2 && this.ihQ.getCurrentState() != 3) {
                    z = false;
                }
                this.ihQ.wE(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.hLT.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.hLT.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.ejG) {
            this.ihQ.wE(0);
            bcy();
        } else if (view == this.ihM && this.ihM.getVisibility() == 0 && this.ihO != null) {
            this.ihO.wI(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oa(boolean z) {
        if (this.hLT != null && this.hLT.hMs != null) {
            this.hLT.hMs.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ceh() {
        if (this.hLT != null) {
            this.ejB.bbK();
        }
    }

    public void oE(boolean z) {
        if (this.hLE != null) {
            this.hLE.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.ihU = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.ihO = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.XN = fVar;
    }

    private void oF(boolean z) {
        this.ihK = this.mPosition == (this.ihP == null ? -1 : this.ihP.cjU());
        if (this.ihK && z && isPlaying() && this.dXa && !this.ihL) {
            this.ihH.setVisibility(0);
            this.ihL = true;
            this.ihH.postDelayed(this.iia, 5000L);
            if (this.ihP != null) {
                this.ihP.ey(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ihH.setVisibility(8);
        if (this.iia != null) {
            this.ihH.removeCallbacks(this.iia);
        }
    }

    private void bcy() {
        String str;
        String str2;
        if (this.hLT != null && this.mContext != null) {
            String valueOf = String.valueOf(this.hLT.forumId);
            String str3 = this.hLT.title;
            if (this.hLT.mBaijiahao != null) {
                str = this.hLT.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.hLT.mBaijiahao.oriUgcType + "&dvid=" + this.hLT.mBaijiahao.oriUgcVid + "&nid=" + this.hLT.mBaijiahao.oriUgcNid;
            } else {
                str = this.hLT.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.hLT.hMt.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.hLT.title;
            String format = (this.hLT.mBaijiahao == null || this.hLT.hMs == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.hLT.hMs.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.hLT.mBaijiahao != null) {
                shareItem.etQ = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.etQ = str6;
                shareItem.readCount = this.hLT.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.etT = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.etH = true;
            shareItem.etS = 11;
            shareItem.etX = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.hLT.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.hLT.mBaijiahao;
            shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            apVar.dn("tid", str);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.ah("obj_locate", 12);
            apVar.dn("nid", this.hLT.nid);
            if (this.hLT.mBaijiahao != null && !as.isEmpty(this.hLT.mBaijiahao.oriUgcVid)) {
                apVar.dn("obj_param6", this.hLT.mBaijiahao.oriUgcVid);
            }
            if (this.hLT.getVideoType() == 1) {
                apVar.ah(IntentConfig.CARD_TYPE, 2);
            } else if (this.hLT.getVideoType() == 2) {
                apVar.ah(IntentConfig.CARD_TYPE, 8);
            } else if (this.hLT.getVideoType() == 3) {
                apVar.ah(IntentConfig.CARD_TYPE, 6);
            }
            apVar.dn(IntentConfig.RECOM_SOURCE, this.hLT.source);
            apVar.dn("ab_tag", this.hLT.abtest_tag);
            apVar.dn("weight", this.hLT.weight);
            apVar.dn("extra", this.hLT.extra);
            apVar.dn("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                apVar.dn("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                apVar.dn("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(apVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.etT);
            bundle.putInt("obj_type", shareItem.etX);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dVb);
            shareItem.af(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.bSP().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        cef();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void azN() {
        cee();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oG(boolean z) {
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

    public void cjJ() {
        this.gWq.resume();
    }

    public boolean cjK() {
        if (this.ihQ != null) {
            return this.ihQ.getCurrentState() == 2 || this.ihQ.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0640a {
        private int bGB;
        private Runnable iif;

        private C0640a() {
            this.bGB = -1;
            this.iif = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(C0640a.this.iif);
                    C0640a.this.wE(2);
                }
            };
        }

        public void wE(int i) {
            switch (i) {
                case 0:
                    this.bGB = wF(i);
                    cjL();
                    return;
                case 1:
                    this.bGB = wF(i);
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iif);
                    return;
                case 2:
                    this.bGB = wG(i);
                    return;
                case 3:
                    this.bGB = wH(i);
                    cjL();
                    return;
                default:
                    this.bGB = wG(i);
                    return;
            }
        }

        private void cjL() {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iif);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.iif, 3000L);
        }

        public int getCurrentState() {
            return this.bGB;
        }

        private int wF(int i) {
            if (i != this.bGB) {
                a.this.ihN.setVisibility(8);
                a.this.oG(true);
                return i;
            }
            return this.bGB;
        }

        private int wG(int i) {
            int i2 = this.bGB;
            if (i != this.bGB) {
                a.this.ihN.setVisibility(0);
                if (i2 != 3 || a.this.hLT.autoPlay) {
                    a.this.oG(false);
                    return i;
                }
                return i;
            }
            return this.bGB;
        }

        private int wH(int i) {
            if (i != this.bGB) {
                a.this.ihN.setVisibility(0);
                a.this.oG(true);
                return i;
            }
            return this.bGB;
        }
    }
}
