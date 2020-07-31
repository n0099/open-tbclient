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
    public FrameLayout hLC;
    public FrameLayout hLD;
    public HeadImageView hLJ;
    public com.baidu.tieba.play.c hLQ;
    public com.baidu.tieba.frs.aggregation.g hLR;
    private com.baidu.tieba.frs.aggregation.h hLS;
    private o hLT;
    private o hLU;
    private boolean hLV;
    private boolean hLW;
    private boolean hLZ;
    private int hmU;
    public ExpandableTextView ihD;
    private View ihE;
    private FrameLayout ihF;
    private TextView ihG;
    private boolean ihH;
    private boolean ihI;
    private boolean ihJ;
    private View ihK;
    private View ihL;
    private c ihM;
    public com.baidu.tieba.frs.videomiddlepage.a.a ihN;
    private C0640a ihO;
    private VideoNetworkStateTipView ihP;
    private b ihQ;
    private com.baidu.mcn.c ihR;
    private com.baidu.tieba.lego.card.view.g ihS;
    private boolean ihT;
    private boolean ihU;
    private boolean ihV;
    private Animation.AnimationListener ihW;
    private Animation.AnimationListener ihX;
    private Runnable ihY;
    private Runnable ihZ;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.hLV = true;
        this.hLZ = true;
        this.ihI = false;
        this.ihJ = false;
        this.ihT = false;
        this.ihU = false;
        this.ihV = false;
        this.startPosition = -1L;
        this.hmU = 0;
        this.ihW = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ihK != null) {
                    a.this.ihK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ihK != null) {
                    a.this.ihK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ihX = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ihK != null) {
                    a.this.ihK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ihK != null) {
                    a.this.ihK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ihY = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ihF.getVisibility() == 0) {
                    a.this.ihF.setVisibility(8);
                }
            }
        };
        this.ihZ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hLQ != null) {
                    a.this.hLQ.stopPlay();
                }
            }
        };
        this.hLZ = z;
        this.mFrom = str;
        this.dOV = str2;
        this.ihQ = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hLC = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.ihE = view.findViewById(R.id.card_container);
        this.hLD = (FrameLayout) view.findViewById(R.id.video_container);
        this.hLQ = new com.baidu.tieba.play.c(tbPageContext, this.hLD, false);
        this.hLQ.ug(z);
        this.hLQ.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.ihN != null && a.this.hLR.hMr.videoDuration > 8) {
                    a.this.ihN.bf(a.this.mPosition, a.this.hLR.hMr.videoUrl);
                }
            }
        });
        this.hLQ.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void oH(boolean z2) {
                if (a.this.ihO != null) {
                    if (z2) {
                        a.this.ihO.wE(0);
                    } else {
                        a.this.ihO.wE(1);
                    }
                }
            }
        });
        this.hLQ.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.ihD = (ExpandableTextView) view.findViewById(R.id.title);
        this.hLJ = (HeadImageView) view.findViewById(R.id.user_icon);
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
        this.ihF = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.ihG = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.ihF.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ihG.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_download_link_url", null);
        this.ihG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bd.baV().a((TbPageContext) i.G(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.ihP = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.ihP.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ap("c13257"));
                a.this.ihP.setHasAgreeToPlay(true);
                a.this.hLQ.um(false);
                a.this.ihP.dsS();
                if (a.this.gWq.pW()) {
                    a.this.gWq.resume();
                } else if (a.this.hLR != null && a.this.hLR.hMr != null) {
                    a.this.hLQ.ff(a.this.hLR.hMr.videoUrl, a.this.hLR.threadId);
                }
            }
        });
        this.ihK = view.findViewById(R.id.video_agg_container_foreground);
        this.ihL = view.findViewById(R.id.title_and_comment_container_foreground);
        this.ihK.setOnClickListener(this);
        this.ejD.setOnClickListener(this);
        this.ejG.setOnClickListener(this);
        this.ihD.setOnClickListener(this);
        this.hLJ.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.ihE.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.hmU = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hLC.setLayoutParams(layoutParams);
        this.hLJ.setIsRound(true);
        this.hLJ.setPlaceHolder(1);
        this.hLS = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.but = new AlphaAnimation(0.0f, 0.7f);
        this.but.setDuration(500L);
        this.but.setAnimationListener(this.ihX);
        this.buu = new AlphaAnimation(0.7f, 0.0f);
        this.buu.setDuration(500L);
        this.buu.setAnimationListener(this.ihW);
        this.ihO = new C0640a();
        this.gWq = new com.baidu.afd.videopaster.d(getContext(), this.hLD);
        this.ihR = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ejB.onChangeSkinType(i);
        this.dKx.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.ejE.setTextColor(ao.getColor(R.color.cp_cont_d));
        SvgManager.baR().a(this.ejC, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.ejF, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ihD.onChangeSkinType();
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
        if (gVar != null && gVar.hMr != null) {
            boolean z = this.hLR == gVar;
            this.hLR = gVar;
            this.dXa = this.hLR.autoPlay;
            this.ihJ = false;
            oF(false);
            this.ihD.setVisibility(0);
            this.ihD.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.ihD.setTextColor(R.color.cp_cont_a);
            this.ihD.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.hMr != null && !StringUtils.isNull(gVar.hMr.mcnLeadPage)) {
                this.ihD.setTextMaxLine(2);
                this.ihD.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.ihD.getContentView(), gVar.title, gVar.hMr.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ihD.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ihD.setExpandable(true);
                this.ihD.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void oI(boolean z2) {
                        a.this.hLR.isTitleExpanded = z2;
                    }
                });
                this.ihD.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.hmU) {
                this.hLQ.cYK();
                this.hmU = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hLD.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hLD.setLayoutParams(layoutParams);
            }
            cjB();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.hLR = gVar;
        this.dXa = this.hLR.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cjA() {
        try {
            int parseInt = Integer.parseInt(this.hLR.hMr.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.hLR.hMr.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cjB() {
        if (!cjA()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hLC.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hLC.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.hMr != null) {
            this.hLQ.stopPlay();
            this.hLQ.un(true);
            this.hLQ.uj(true);
            this.hLQ.uo(true);
            this.hLQ.ap(false, false);
            this.hLQ.Dj(i);
            this.hLQ.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
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
                    if (a.this.hLQ.qg()) {
                    }
                    if (a.this.hLW || (a.this.gWq != null && a.this.gWq.pW())) {
                        com.baidu.adp.lib.f.e.lt().removeCallbacks(a.this.ihZ);
                        com.baidu.adp.lib.f.e.lt().post(a.this.ihZ);
                    }
                    if (a.this.gWq != null) {
                        a.this.gWq.qf();
                    }
                }
            });
            this.hLQ.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void cei() {
                    if (a.this.hLR != null && a.this.hLR.hMr != null && com.baidu.adp.lib.f.b.toInt(a.this.hLR.hMr.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.hLR.hMr.videoWidth, 0)) {
                        a.this.hLQ.ap(false, false);
                    } else {
                        a.this.hLQ.ap(true, false);
                    }
                    a.this.hLW = false;
                    a.this.FS(a.this.dXa ? "1" : "2");
                    a.this.onClick(a.this.hLD);
                    if (a.this.XN != null) {
                        a.this.XN.a(a.this);
                    }
                    if (a.this.ihS != null) {
                        a.this.ihS.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cej() {
                    a.this.onClick(a.this.hLC);
                }
            });
            this.hLQ.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void ob(boolean z2) {
                    a.this.hLQ.ff(a.this.hLR.hMr.videoUrl, a.this.hLR.threadId);
                    a.this.FS("2");
                    a.this.onClick(a.this.hLD);
                }
            });
            this.hLQ.uf(false);
            if (this.ihR != null) {
                this.ihR.reset();
            }
            this.startPosition = -1L;
            if (this.hLQ.getVideoView() != null && this.hLQ.getVideoView().getMediaProgressObserver() != null) {
                this.hLQ.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bP(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.hLR.hMr.hMB;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.gWq.a(a.this.isFullScreen, a.this.hLQ != null && a.this.hLQ.cYr(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.gWq.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.hLQ.cYr() && !com.baidu.mcn.b.MN().gn(aVar2.Yc)) {
                            boolean z3 = a.this.startPosition >= (aVar2.hMt * 1000) + 1000;
                            if (i3 < aVar2.hMt * 1000 || i3 >= aVar2.hMu * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.ihR.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bug = aVar2.hMw;
                                    aVar3.buh = aVar2.hMx;
                                    aVar3.bui = aVar2.Yc;
                                    aVar3.bue = aVar2.hMv;
                                    aVar3.fid = a.this.hLR != null ? a.this.hLR.forumId : null;
                                    aVar3.tid = a.this.hLR != null ? a.this.hLR.threadId : null;
                                    aVar3.buj = 3;
                                    if (z3) {
                                        a.this.ihR.b(aVar3, (ViewGroup) a.this.hLQ.cYJ());
                                    } else {
                                        a.this.ihR.a(aVar3, (ViewGroup) a.this.hLQ.cYJ());
                                    }
                                }
                            } else if (a.this.ihR.isShowing()) {
                                a.this.ihR.dismiss();
                            }
                        }
                    }
                });
            }
            this.hLT = new o();
            this.hLT.ajJ = gVar.threadId;
            this.hLT.mNid = gVar.nid;
            this.hLT.eKO = gVar.forumId;
            this.hLT.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hLT.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.hLT.mSource = gVar.source;
            this.hLT.lcH = gVar.weight;
            this.hLT.lcJ = this.mFrom;
            this.hLT.lcL = gVar.abtest_tag;
            this.hLT.dOV = this.dOV;
            this.hLT.mExtra = gVar.extra;
            this.hLT.lcO = "0";
            this.hLT.lcK = gVar.getVideoType();
            this.hLU = new o();
            this.hLU.ajJ = gVar.threadId;
            this.hLU.eKO = gVar.forumId;
            this.hLU.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hLU.lcH = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hLU.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hLU.lcJ = this.mFrom;
            this.hLU.mSource = gVar.source;
            this.hLU.lcO = "0";
            if (gVar.hMr != null) {
                this.hLT.lcM = gVar.hMr.videoMd5;
                this.hLU.lcM = gVar.hMr.videoMd5;
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
            this.hLQ.getVideoView().setVideoStatData(this.hLT);
            this.hLQ.cBY();
            this.hLQ.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.gWq.a(a.this.isFullScreen, a.this.hLQ != null && a.this.hLQ.cYr(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.hLW = true;
                            a.this.ihH = true;
                            a.this.hLV = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.vi(i);
                            a.this.hLQ.coB();
                        }
                    }
                }
            });
            this.hLQ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.hLR != null && a.this.hLR.hMr != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.hLR.hMr.videoUrl);
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
                    a.this.ihH = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void qm() {
                    if (a.this.isFullScreen) {
                        a.this.hLW = true;
                        a.this.ihH = true;
                        a.this.hLV = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.vi(i);
                        a.this.hLQ.coB();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void ql() {
                    if (a.this.hLQ != null) {
                        a.this.hLQ.Di(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean qo() {
                    return a.this.cjE();
                }
            });
            this.hLQ.setThumbnail(gVar.hMr.thumbnailUrl);
            this.hLQ.Dh(gVar.hMr.videoDuration);
            this.hLQ.setVideoUrl(gVar.hMr.videoUrl, gVar.threadId);
            this.hLQ.setFid(gVar.forumId);
            this.hLQ.coB();
            this.hLQ.show();
            oF(false);
            if (gVar.autoPlay) {
                onClick(this.hLD);
                if (this.ihP.cUv()) {
                    this.hLQ.ul(false);
                    this.ihP.dsR();
                    this.hLQ.um(true);
                    this.hLQ.fe(gVar.hMr.videoUrl, gVar.threadId);
                    if (this.gWq.pW()) {
                        this.gWq.stop();
                        this.gWq.qb();
                    }
                } else {
                    this.hLQ.um(false);
                    this.hLQ.ul(false);
                    this.ihP.hide();
                    if (this.gWq == null || (this.gWq != null && !this.gWq.pW())) {
                        this.hLQ.a(gVar.hMr.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.hMs) {
                    this.ihK.setVisibility(8);
                    this.ihO.wE(3);
                } else {
                    if (this.ihK.getVisibility() == 0) {
                        this.ihK.startAnimation(this.buu);
                    }
                    this.ihO.wE(0);
                }
                gVar.hMs = false;
            } else {
                this.ihK.setVisibility(0);
                this.ihP.hide();
                this.hLQ.ul(true);
                this.ihO.wE(3);
                this.hLQ.fe(gVar.hMr.videoUrl, gVar.threadId);
            }
            this.hLW = false;
            this.ihH = false;
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
        com.baidu.afd.videopaster.data.b Gz = this.ihQ != null ? this.ihQ.Gz(gVar.getThreadId()) : null;
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
        if (gVar.hMr != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.hMr.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.hMr.videoHeight, 0);
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
        if (this.hLR != null && this.hLR.hMr != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.hLR.hMr.videoMd5, "", str, this.hLU, this.hLQ.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hLQ.qg();
    }

    public boolean cjC() {
        return this.gWq.pW();
    }

    public void cee() {
        if (isPlaying()) {
            this.hLQ.azN();
        }
    }

    public boolean vj(int i) {
        if (i == 4 && this.gWq != null && ((this.gWq.pW() || this.ihH) && this.hLQ != null)) {
            this.gWq.aS(i);
            if (this.isFullScreen) {
                if (this.gWq.pV()) {
                    this.hLQ.cYs();
                } else {
                    this.hLQ.Io();
                }
                return true;
            }
        }
        return this.hLQ.Di(i);
    }

    public void cef() {
        this.ihJ = false;
        this.hLQ.stopPlay();
        if (this.ihD != null) {
            this.ihD.setVisibility(0);
        }
        if (this.ihO != null) {
            this.ihO.wE(2);
        }
        oF(false);
        this.ihI = true;
        if (this.gWq != null && this.gWq.pW()) {
            this.gWq.stop();
        }
    }

    public void cjD() {
        this.gWq.stop();
    }

    public void ceg() {
        if (this.hLQ != null) {
            this.hLQ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        ceg();
        if (this.hLS != null) {
            this.hLS.ceq();
        }
        if (this.ihK != null) {
            this.ihK.clearAnimation();
        }
        this.gWq.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.hMq != null) {
            this.ahr.setText(TextUtils.isEmpty(gVar.hMq.userNickname) ? gVar.hMq.userName : gVar.hMq.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.hMq != null) {
            if (gVar.hMq.hMA != null && !TextUtils.isEmpty(gVar.hMq.hMA.avatar)) {
                this.hLJ.startLoad(gVar.hMq.hMA.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.hMq.portrait) && gVar.hMq.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hLJ.startLoad(gVar.hMq.portrait, 10, false);
            } else {
                this.hLJ.startLoad(gVar.hMq.portrait, 12, false);
            }
            if (gVar.hMq.hMA != null && gVar.hMq.hMA.auth_id.intValue() > 0) {
                this.hLJ.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.hMq.hMA.auth_id.intValue(), 1));
                this.hLJ.setShowV(true);
                this.hLJ.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hLJ.setBjhAuthIconRes(0);
            if (gVar.hMq.isBigV) {
                this.hLJ.setShowV(gVar.hMq.isBigV);
                this.hLJ.setIsBigV(gVar.hMq.isBigV);
            } else if (gVar.hMq.isGod) {
                this.hLJ.setShowV(gVar.hMq.isGod);
                this.hLJ.setIsBigV(gVar.hMq.isGod);
            } else {
                this.hLJ.setShowV(gVar.hMq.isGod);
                this.hLJ.setIsBigV(gVar.hMq.isGod);
            }
            this.hLJ.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aYc() != null) {
                gVar.aYc().isInThread = true;
                gVar.aYc().nid = gVar.nid;
                if (this.hLR.getVideoType() == 1) {
                    gVar.aYc().cardType = 2;
                } else if (this.hLR.getVideoType() == 2) {
                    gVar.aYc().cardType = 8;
                } else if (this.hLR.getVideoType() == 3) {
                    gVar.aYc().cardType = 6;
                }
                gVar.aYc().baijiahaoData = gVar.mBaijiahao;
                gVar.aYc().recomSource = gVar.source;
                gVar.aYc().recomWeight = gVar.weight;
                gVar.aYc().recomAbTag = gVar.abtest_tag;
                gVar.aYc().recomExtra = gVar.extra;
            }
            if (this.hLR.mBaijiahao != null) {
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
        if (this.hLQ != null && this.hLD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hLV) {
                this.hLQ.cYy();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cjF();
            } else {
                configuration.orientation = 1;
                cjG();
                this.hLV = true;
            }
            this.hLQ.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cjE() {
        if (this.hLQ != null && this.hLD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hLD.getParent() != null) {
                if (this.hLD.getParent() == frameLayout) {
                    if (this.ihT) {
                        this.ihT = false;
                        return true;
                    } else if (!this.ihU) {
                        this.ihU = true;
                        return true;
                    }
                } else if (this.hLD.getParent() == this.hLC) {
                    if (this.ihU) {
                        this.ihU = false;
                        this.ihV = true;
                        return true;
                    } else if (!this.ihT && this.ihV) {
                        this.ihT = true;
                        this.ihV = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjF() {
        if (this.hLQ != null && this.hLD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hLD.getParent() != null) {
                if (this.hLD.getParent() == frameLayout) {
                    frameLayout.removeView(this.hLD);
                } else if (this.hLD.getParent() == this.hLC) {
                    this.hLC.removeView(this.hLD);
                }
            }
            if (this.hLD.getParent() == null) {
                frameLayout.addView(this.hLD);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hLD.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hLD.setLayoutParams(layoutParams);
                if (this.ihR != null && this.ihR.isShowing()) {
                    this.ihR.dismiss();
                }
                com.baidu.tbadk.util.e.bmw().jk(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjG() {
        if (this.hLQ != null && this.hLD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hLD.getParent() != null) {
                if (this.hLD.getParent() == frameLayout) {
                    cjH();
                    frameLayout.removeView(this.hLD);
                } else if (this.hLD.getParent() == this.hLC) {
                    cjH();
                    this.hLC.removeView(this.hLD);
                }
            }
            if (this.hLD.getParent() == null) {
                this.hLC.addView(this.hLD, 0);
                cjI();
                this.hLQ.cBY();
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
            this.hLD.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bRn() != null) {
            view.setTag(this);
            bRn().a(view, this.hLR);
        }
        if (view == this.hLJ || view == this.ahr) {
            if (this.hLR != null && this.hLR.hMq != null && !TextUtils.isEmpty(this.hLR.hMq.userId)) {
                this.ihO.wE(0);
                if (!TbadkCoreApplication.isLogin() || !this.hLR.hMq.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hLR.hMq.userId, 0L), z, this.hLR.hMq.isGod)));
            }
        } else if (view == this.ejD) {
            if (this.hLR != null) {
                this.ihO.wE(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hLR.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.hLR.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.ihD || view == this.ihE) {
            if (this.hLR != null) {
                if (this.ihO.getCurrentState() != 2 && this.ihO.getCurrentState() != 3) {
                    z = false;
                }
                this.ihO.wE(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.hLR.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.hLR.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.ejG) {
            this.ihO.wE(0);
            bcy();
        } else if (view == this.ihK && this.ihK.getVisibility() == 0 && this.ihM != null) {
            this.ihM.wI(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oa(boolean z) {
        if (this.hLR != null && this.hLR.hMq != null) {
            this.hLR.hMq.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ceh() {
        if (this.hLR != null) {
            this.ejB.bbK();
        }
    }

    public void oE(boolean z) {
        if (this.hLC != null) {
            this.hLC.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.ihS = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.ihM = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.XN = fVar;
    }

    private void oF(boolean z) {
        this.ihI = this.mPosition == (this.ihN == null ? -1 : this.ihN.cjU());
        if (this.ihI && z && isPlaying() && this.dXa && !this.ihJ) {
            this.ihF.setVisibility(0);
            this.ihJ = true;
            this.ihF.postDelayed(this.ihY, 5000L);
            if (this.ihN != null) {
                this.ihN.ey(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ihF.setVisibility(8);
        if (this.ihY != null) {
            this.ihF.removeCallbacks(this.ihY);
        }
    }

    private void bcy() {
        String str;
        String str2;
        if (this.hLR != null && this.mContext != null) {
            String valueOf = String.valueOf(this.hLR.forumId);
            String str3 = this.hLR.title;
            if (this.hLR.mBaijiahao != null) {
                str = this.hLR.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.hLR.mBaijiahao.oriUgcType + "&dvid=" + this.hLR.mBaijiahao.oriUgcVid + "&nid=" + this.hLR.mBaijiahao.oriUgcNid;
            } else {
                str = this.hLR.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.hLR.hMr.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.hLR.title;
            String format = (this.hLR.mBaijiahao == null || this.hLR.hMq == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.hLR.hMq.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.hLR.mBaijiahao != null) {
                shareItem.etQ = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.etQ = str6;
                shareItem.readCount = this.hLR.playCount;
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
            if (this.hLR.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.hLR.mBaijiahao;
            shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            apVar.dn("tid", str);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.ah("obj_locate", 12);
            apVar.dn("nid", this.hLR.nid);
            if (this.hLR.mBaijiahao != null && !as.isEmpty(this.hLR.mBaijiahao.oriUgcVid)) {
                apVar.dn("obj_param6", this.hLR.mBaijiahao.oriUgcVid);
            }
            if (this.hLR.getVideoType() == 1) {
                apVar.ah(IntentConfig.CARD_TYPE, 2);
            } else if (this.hLR.getVideoType() == 2) {
                apVar.ah(IntentConfig.CARD_TYPE, 8);
            } else if (this.hLR.getVideoType() == 3) {
                apVar.ah(IntentConfig.CARD_TYPE, 6);
            }
            apVar.dn(IntentConfig.RECOM_SOURCE, this.hLR.source);
            apVar.dn("ab_tag", this.hLR.abtest_tag);
            apVar.dn("weight", this.hLR.weight);
            apVar.dn("extra", this.hLR.extra);
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
        if (this.ihO != null) {
            return this.ihO.getCurrentState() == 2 || this.ihO.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0640a {
        private int bGB;
        private Runnable iid;

        private C0640a() {
            this.bGB = -1;
            this.iid = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(C0640a.this.iid);
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
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iid);
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
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iid);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.iid, 3000L);
        }

        public int getCurrentState() {
            return this.bGB;
        }

        private int wF(int i) {
            if (i != this.bGB) {
                a.this.ihL.setVisibility(8);
                a.this.oG(true);
                return i;
            }
            return this.bGB;
        }

        private int wG(int i) {
            int i2 = this.bGB;
            if (i != this.bGB) {
                a.this.ihL.setVisibility(0);
                if (i2 != 3 || a.this.hLR.autoPlay) {
                    a.this.oG(false);
                    return i;
                }
                return i;
            }
            return this.bGB;
        }

        private int wH(int i) {
            if (i != this.bGB) {
                a.this.ihL.setVisibility(0);
                a.this.oG(true);
                return i;
            }
            return this.bGB;
        }
    }
}
