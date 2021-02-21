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
import com.baidu.adp.base.j;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.lego.card.view.k;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, k {
    private com.baidu.tieba.lego.card.view.f aaJ;
    public TextView ajY;
    private Animation chW;
    private Animation chX;
    private TextView eID;
    private String eNE;
    private boolean eXf;
    protected AgreeView fjW;
    private ImageView fjY;
    private View fjZ;
    private ImageView fkb;
    private View fkc;
    private int iNx;
    private TextView iUb;
    private boolean isFullScreen;
    private com.baidu.afd.videopaster.d iwJ;
    private boolean jMA;
    private boolean jMB;
    private boolean jMC;
    private View jMD;
    private View jME;
    private c jMF;
    public com.baidu.tieba.frs.videomiddlepage.a.a jMG;
    private C0737a jMH;
    private VideoNetworkStateTipView jMI;
    private b jMJ;
    private com.baidu.mcn.c jMK;
    private com.baidu.tieba.lego.card.view.g jML;
    private boolean jMM;
    private boolean jMN;
    private boolean jMO;
    private Animation.AnimationListener jMP;
    private Animation.AnimationListener jMQ;
    private Runnable jMR;
    private Runnable jMS;
    public ExpandableTextView jMw;
    private View jMx;
    private FrameLayout jMy;
    private TextView jMz;
    public com.baidu.tieba.play.c jnF;
    public com.baidu.tieba.frs.aggregation.g jnG;
    private com.baidu.tieba.frs.aggregation.h jnH;
    private o jnI;
    private o jnJ;
    private boolean jnK;
    private boolean jnL;
    private boolean jnO;
    public FrameLayout jnq;
    public FrameLayout jnr;
    public HeadImageView jnx;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.jnK = true;
        this.jnO = true;
        this.jMB = false;
        this.jMC = false;
        this.jMM = false;
        this.jMN = false;
        this.jMO = false;
        this.startPosition = -1L;
        this.iNx = 0;
        this.jMP = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jMD != null) {
                    a.this.jMD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jMD != null) {
                    a.this.jMD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jMQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jMD != null) {
                    a.this.jMD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jMD != null) {
                    a.this.jMD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jMR = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jMy.getVisibility() == 0) {
                    a.this.jMy.setVisibility(8);
                }
            }
        };
        this.jMS = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jnF != null) {
                    a.this.jnF.stopPlay();
                }
            }
        };
        this.jnO = z;
        this.mFrom = str;
        this.eNE = str2;
        this.jMJ = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jnq = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jMx = view.findViewById(R.id.card_container);
        this.jnr = (FrameLayout) view.findViewById(R.id.video_container);
        this.jnF = new com.baidu.tieba.play.c(tbPageContext, this.jnr, false);
        this.jnF.setStageType("2005");
        this.jnF.xe(z);
        this.jnF.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jMG != null && a.this.jnG.jog.videoDuration > 8) {
                    a.this.jMG.bC(a.this.mPosition, a.this.jnG.jog.videoUrl);
                }
            }
        });
        this.jnF.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.a
            public void rI(boolean z2) {
                if (a.this.jMH != null) {
                    if (z2) {
                        a.this.jMH.AL(0);
                    } else {
                        a.this.jMH.AL(1);
                    }
                }
            }
        });
        this.jnF.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jMw = (ExpandableTextView) view.findViewById(R.id.title);
        this.jnx = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajY = (TextView) view.findViewById(R.id.user_name);
        this.fjW = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMb = 2;
        eVar.eMg = 6;
        this.fjW.setStatisticData(eVar);
        this.fjW.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.eID = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fjY = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fjZ = view.findViewById(R.id.thread_info_commont_container);
        this.iUb = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.fkb = (ImageView) view.findViewById(R.id.share_num_img);
        this.fkc = view.findViewById(R.id.share_num_container);
        this.jMy = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jMz = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jMy.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jMz.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_download_link_url", null);
        this.jMz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bsV().a((TbPageContext) j.K(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jMI = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jMI.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c13257"));
                a.this.jMI.setHasAgreeToPlay(true);
                a.this.jnF.xl(false);
                a.this.jMI.dVm();
                if (a.this.iwJ.rc()) {
                    a.this.iwJ.resume();
                } else if (a.this.jnG != null && a.this.jnG.jog != null) {
                    a.this.jnF.fX(a.this.jnG.jog.videoUrl, a.this.jnG.threadId);
                }
            }
        });
        this.jMD = view.findViewById(R.id.video_agg_container_foreground);
        this.jME = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jMD.setOnClickListener(this);
        this.fjZ.setOnClickListener(this);
        this.fkc.setOnClickListener(this);
        this.jMw.setOnClickListener(this);
        this.jnx.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.jMx.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.iNx = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnq.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jnq.setLayoutParams(layoutParams);
        this.jnx.setIsRound(true);
        this.jnx.setPlaceHolder(1);
        this.jnH = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.chW = new AlphaAnimation(0.0f, 0.7f);
        this.chW.setDuration(500L);
        this.chW.setAnimationListener(this.jMQ);
        this.chX = new AlphaAnimation(0.7f, 0.0f);
        this.chX.setDuration(500L);
        this.chX.setAnimationListener(this.jMP);
        this.jMH = new C0737a();
        this.iwJ = new com.baidu.afd.videopaster.d(getContext(), this.jnr);
        this.jMK = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fjW.onChangeSkinType(i);
        this.eID.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.iUb.setTextColor(ap.getColor(R.color.CAM_X0107));
        WebPManager.a(this.fkb, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fjY, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jMw.onChangeSkinType();
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
        if (gVar != null && gVar.jog != null) {
            boolean z = this.jnG == gVar;
            this.jnG = gVar;
            this.eXf = this.jnG.autoPlay;
            this.jMC = false;
            rG(false);
            this.jMw.setVisibility(0);
            this.jMw.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jMw.setTextColor(R.color.CAM_X0101);
            this.jMw.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.jog != null && !StringUtils.isNull(gVar.jog.mcnLeadPage)) {
                this.jMw.setTextMaxLine(2);
                this.jMw.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jMw.getContentView(), gVar.title, gVar.jog.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jMw.setTextMaxLine(Integer.MAX_VALUE);
                this.jMw.setExpandable(true);
                this.jMw.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rJ(boolean z2) {
                        a.this.jnG.isTitleExpanded = z2;
                    }
                });
                this.jMw.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.iNx) {
                this.jnF.dzX();
                this.iNx = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.jnr.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jnr.setLayoutParams(layoutParams);
            }
            cMg();
            a(gVar, i, aVar, z);
            j(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.jnG = gVar;
        this.eXf = this.jnG.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cMf() {
        try {
            int parseInt = Integer.parseInt(this.jnG.jog.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.jnG.jog.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cMg() {
        if (!cMf()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnq.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jnq.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jnq.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jnq.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.jog != null) {
            this.jnF.stopPlay();
            this.jnF.xm(true);
            this.jnF.xi(true);
            this.jnF.xn(true);
            this.jnF.ax(false, false);
            this.jnF.Hm(i);
            this.jnF.a(new c.InterfaceC0849c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rj() {
                    a.this.cMk();
                    if (a.this.iwJ != null) {
                        a.this.iwJ.rj();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rk() {
                    a.this.cMl();
                    if (a.this.jnF.rl()) {
                    }
                    if (a.this.jnL || (a.this.iwJ != null && a.this.iwJ.rc())) {
                        com.baidu.adp.lib.f.e.mA().removeCallbacks(a.this.jMS);
                        com.baidu.adp.lib.f.e.mA().post(a.this.jMS);
                    }
                    if (a.this.iwJ != null) {
                        a.this.iwJ.rk();
                    }
                }
            });
            this.jnF.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.l
                public void cFv() {
                    if (a.this.jnG != null && a.this.jnG.jog != null && com.baidu.adp.lib.f.b.toInt(a.this.jnG.jog.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.jnG.jog.videoWidth, 0)) {
                        a.this.jnF.ax(false, false);
                    } else {
                        a.this.jnF.ax(true, false);
                    }
                    a.this.jnL = false;
                    a.this.Kn(a.this.eXf ? "1" : "2");
                    a.this.onClick(a.this.jnr);
                    if (a.this.aaJ != null) {
                        a.this.aaJ.a(a.this);
                    }
                    if (a.this.jML != null) {
                        a.this.jML.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFw() {
                    a.this.onClick(a.this.jnq);
                }
            });
            this.jnF.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.18
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z2) {
                    a.this.jnF.fX(a.this.jnG.jog.videoUrl, a.this.jnG.threadId);
                    a.this.Kn("2");
                    a.this.onClick(a.this.jnr);
                }
            });
            this.jnF.xd(false);
            if (this.jMK != null) {
                this.jMK.reset();
            }
            this.startPosition = -1L;
            if (this.jnF.getVideoView() != null && this.jnF.getVideoView().getMediaProgressObserver() != null) {
                this.jnF.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void cf(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.jnG.jog.joq;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.iwJ.d(a.this.isFullScreen, a.this.jnF != null && a.this.jnF.dzE(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.iwJ.a(a.this.i(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.jnF.dzE() && !com.baidu.mcn.b.abr().iY(aVar2.aaY)) {
                            boolean z3 = a.this.startPosition >= (aVar2.joi * 1000) + 1000;
                            if (i3 < aVar2.joi * 1000 || i3 >= aVar2.joj * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jMK.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.chJ = aVar2.jol;
                                    aVar3.chK = aVar2.jom;
                                    aVar3.chL = aVar2.aaY;
                                    aVar3.chI = aVar2.jok;
                                    aVar3.fid = a.this.jnG != null ? a.this.jnG.forumId : null;
                                    aVar3.tid = a.this.jnG != null ? a.this.jnG.threadId : null;
                                    aVar3.chM = 3;
                                    if (z3) {
                                        a.this.jMK.b(aVar3, (ViewGroup) a.this.jnF.dzW());
                                    } else {
                                        a.this.jMK.a(aVar3, (ViewGroup) a.this.jnF.dzW());
                                    }
                                }
                            } else if (a.this.jMK.isShowing()) {
                                a.this.jMK.dismiss();
                            }
                        }
                    }
                });
            }
            this.jnI = new o();
            this.jnI.amC = gVar.threadId;
            this.jnI.eTz = gVar.nid;
            this.jnI.fNd = gVar.forumId;
            this.jnI.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jnI.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.jnI.mSource = gVar.source;
            this.jnI.mIv = gVar.weight;
            this.jnI.mIx = this.mFrom;
            this.jnI.mIz = gVar.abtest_tag;
            this.jnI.eNE = this.eNE;
            this.jnI.mExtra = gVar.extra;
            this.jnI.mIC = "0";
            this.jnI.mIy = gVar.getVideoType();
            this.jnJ = new o();
            this.jnJ.amC = gVar.threadId;
            this.jnJ.fNd = gVar.forumId;
            this.jnJ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jnJ.mIv = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jnJ.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jnJ.mIx = this.mFrom;
            this.jnJ.mSource = gVar.source;
            this.jnJ.mIC = "0";
            if (gVar.jog != null) {
                this.jnI.mIA = gVar.jog.videoMd5;
                this.jnJ.mIA = gVar.jog.videoMd5;
            }
            ar arVar = new ar("c12590");
            arVar.dR("tid", gVar.threadId);
            arVar.dR(IntentConfig.NID, gVar.nid);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.ap("obj_locate", i);
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dR("fid", gVar.forumId);
            arVar.dR("obj_param1", au.isEmpty(gVar.weight) ? "0" : gVar.weight);
            arVar.dR("extra", au.isEmpty(gVar.extra) ? "0" : gVar.extra);
            arVar.dR("obj_id", this.eNE);
            arVar.dR("ab_tag", au.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            arVar.dR("obj_type", this.mFrom);
            arVar.ap("obj_param5", gVar.getVideoType());
            arVar.dR("obj_source", au.isEmpty(gVar.source) ? "0" : gVar.source);
            arVar.ap("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                arVar.dR("obj_param4", gVar.mBaijiahao.oriUgcNid);
                arVar.dR("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(arVar);
            this.jnF.getVideoView().setVideoStatData(this.jnI);
            this.jnF.dcv();
            this.jnF.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.iwJ.d(a.this.isFullScreen, a.this.jnF != null && a.this.jnF.dzE(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.jnL = true;
                            a.this.jMA = true;
                            a.this.jnK = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.ze(i);
                            a.this.jnF.cSK();
                        }
                    }
                }
            });
            this.jnF.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.jnG != null && a.this.jnG.jog != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.jnG.jog.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.iwJ.reset();
            }
            this.iwJ.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rs() {
                    a.this.jMA = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rr() {
                    if (a.this.isFullScreen) {
                        a.this.jnL = true;
                        a.this.jMA = true;
                        a.this.jnK = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.ze(i);
                        a.this.jnF.cSK();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rq() {
                    if (a.this.jnF != null) {
                        a.this.jnF.Hl(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rt() {
                    return a.this.cMj();
                }
            });
            this.jnF.setThumbnail(gVar.jog.thumbnailUrl);
            this.jnF.Hk(gVar.jog.videoDuration);
            this.jnF.setVideoUrl(gVar.jog.videoUrl, gVar.threadId);
            this.jnF.setFid(gVar.forumId);
            this.jnF.cSK();
            this.jnF.show();
            rG(false);
            if (gVar.autoPlay) {
                onClick(this.jnr);
                if (this.jMI.dvB()) {
                    this.jnF.xk(false);
                    this.jMI.dVl();
                    this.jnF.xl(true);
                    this.jnF.fW(gVar.jog.videoUrl, gVar.threadId);
                    if (this.iwJ.rc()) {
                        this.iwJ.stop();
                        this.iwJ.rg();
                    }
                } else {
                    this.jnF.xl(false);
                    this.jnF.xk(false);
                    this.jMI.hide();
                    if (this.iwJ == null || (this.iwJ != null && !this.iwJ.rc())) {
                        this.jnF.a(gVar.jog.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.joh) {
                    this.jMD.setVisibility(8);
                    this.jMH.AL(3);
                } else {
                    if (this.jMD.getVisibility() == 0) {
                        this.jMD.startAnimation(this.chX);
                    }
                    this.jMH.AL(0);
                }
                gVar.joh = false;
            } else {
                this.jMD.setVisibility(0);
                this.jMI.hide();
                this.jnF.xk(true);
                this.jMH.AL(3);
                this.jnF.fW(gVar.jog.videoUrl, gVar.threadId);
            }
            this.jnL = false;
            this.jMA = false;
            if (!z && this.iwJ.rc()) {
                stopPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a i(com.baidu.tieba.frs.aggregation.g gVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (gVar == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b Lm = this.jMJ != null ? this.jMJ.Lm(gVar.getThreadId()) : null;
        if (Lm != null) {
            int rx2 = Lm.rx();
            int ry = Lm.ry();
            int rw = Lm.rw();
            if (rw != -1) {
                i2 = rx2 != -1 ? (rw - rx2) - 1 : -1;
                i = ry != -1 ? (ry - rw) - 1 : -1;
            } else {
                i = -1;
                i2 = -1;
            }
            if (gVar.jog != null) {
                i4 = com.baidu.adp.lib.f.b.toInt(gVar.jog.videoWidth, 0);
                i3 = com.baidu.adp.lib.f.b.toInt(gVar.jog.videoHeight, 0);
            } else {
                i3 = 0;
                i4 = 0;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("video_vid", gVar.threadId);
            hashMap.put("video_title", gVar.title);
            hashMap.put("forum_id", gVar.forumId);
            hashMap.put("forum_name", "");
            hashMap.put("up_distance", String.valueOf(i2));
            hashMap.put("down_distance", String.valueOf(i));
            com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", rw + 1, i4, i3);
            a2.u(hashMap);
            return a2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn(String str) {
        if (this.jnG != null && this.jnG.jog != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jnG.jog.videoMd5, "", str, this.jnJ, this.jnF.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jnF.rl();
    }

    public boolean cMh() {
        return this.iwJ.rc();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jnF.pausePlay();
        }
    }

    public boolean zf(int i) {
        if (i == 4 && this.iwJ != null && ((this.iwJ.rc() || this.jMA) && this.jnF != null)) {
            this.iwJ.be(i);
            if (this.isFullScreen) {
                if (this.iwJ.rb()) {
                    this.jnF.dzF();
                } else {
                    this.jnF.TZ();
                }
                return true;
            }
        }
        return this.jnF.Hl(i);
    }

    public void stopVideo() {
        this.jMC = false;
        this.jnF.stopPlay();
        if (this.jMw != null) {
            this.jMw.setVisibility(0);
        }
        if (this.jMH != null) {
            this.jMH.AL(2);
        }
        rG(false);
        this.jMB = true;
        if (this.iwJ != null && this.iwJ.rc()) {
            this.iwJ.stop();
        }
    }

    public void cMi() {
        this.iwJ.stop();
    }

    public void cFt() {
        if (this.jnF != null) {
            this.jnF.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cFt();
        if (this.jnH != null) {
            this.jnH.cFE();
        }
        if (this.jMD != null) {
            this.jMD.clearAnimation();
        }
        this.iwJ.onDestroy();
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.jof != null) {
            this.ajY.setText(TextUtils.isEmpty(gVar.jof.userNickname) ? gVar.jof.userName : gVar.jof.userNickname);
            k(gVar);
            d(gVar);
            e(gVar);
            l(gVar);
        }
    }

    private void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jof != null) {
            if (gVar.jof.jop != null && !TextUtils.isEmpty(gVar.jof.jop.avatar)) {
                this.jnx.startLoad(gVar.jof.jop.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.jof.portrait) && gVar.jof.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jnx.startLoad(gVar.jof.portrait, 10, false);
            } else {
                this.jnx.startLoad(gVar.jof.portrait, 12, false);
            }
            if (gVar.jof.jop != null && gVar.jof.jop.auth_id.intValue() > 0) {
                this.jnx.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.jof.jop.auth_id.intValue(), 1));
                this.jnx.setShowV(true);
                this.jnx.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jnx.setBjhAuthIconRes(0);
            if (gVar.jof.isBigV) {
                this.jnx.setShowV(gVar.jof.isBigV);
                this.jnx.setIsBigV(gVar.jof.isBigV);
            } else if (gVar.jof.isGod) {
                this.jnx.setShowV(gVar.jof.isGod);
                this.jnx.setIsBigV(gVar.jof.isGod);
            } else {
                this.jnx.setShowV(gVar.jof.isGod);
                this.jnx.setIsBigV(gVar.jof.isGod);
            }
            this.jnx.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(final com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bpJ() != null) {
                gVar.bpJ().isInThread = true;
                gVar.bpJ().nid = gVar.nid;
                if (this.jnG.getVideoType() == 1) {
                    gVar.bpJ().cardType = 2;
                } else if (this.jnG.getVideoType() == 2) {
                    gVar.bpJ().cardType = 8;
                } else if (this.jnG.getVideoType() == 3) {
                    gVar.bpJ().cardType = 6;
                }
                gVar.bpJ().baijiahaoData = gVar.mBaijiahao;
                gVar.bpJ().recomSource = gVar.source;
                gVar.bpJ().recomWeight = gVar.weight;
                gVar.bpJ().recomAbTag = gVar.abtest_tag;
                gVar.bpJ().recomExtra = gVar.extra;
            }
            this.fjW.setAgreeAlone(true);
            this.fjW.setIsFromMiddlePage(true);
            this.fjW.setData(gVar.bpJ());
            this.fjW.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (gVar.bpJ().hasAgree && gVar.bpJ().agreeType == 2) {
                        a.this.jMH.AL(0);
                    }
                }
            });
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eID.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fjY, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.eID.setText(au.numFormatOverWan(gVar.postNum));
            } else {
                this.eID.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void l(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.iUb.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fkb, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.iUb.setText(au.numFormatOverWan(gVar.shareNum));
            } else {
                this.iUb.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jnF != null && this.jnr != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jnK) {
                this.jnF.dzL();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cMk();
            } else {
                configuration.orientation = 1;
                cMl();
                this.jnK = true;
            }
            this.jnF.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cMj() {
        if (this.jnF != null && this.jnr != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jnr.getParent() != null) {
                if (this.jnr.getParent() == frameLayout) {
                    if (this.jMM) {
                        this.jMM = false;
                        return true;
                    } else if (!this.jMN) {
                        this.jMN = true;
                        return true;
                    }
                } else if (this.jnr.getParent() == this.jnq) {
                    if (this.jMN) {
                        this.jMN = false;
                        this.jMO = true;
                        return true;
                    } else if (!this.jMM && this.jMO) {
                        this.jMM = true;
                        this.jMO = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMk() {
        if (this.jnF != null && this.jnr != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.jnr.getParent() != null) {
                if (this.jnr.getParent() == frameLayout) {
                    frameLayout.removeView(this.jnr);
                } else if (this.jnr.getParent() == this.jnq) {
                    this.jnq.removeView(this.jnr);
                }
            }
            if (this.jnr.getParent() == null) {
                frameLayout.addView(this.jnr);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jnr.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jnr.setLayoutParams(layoutParams);
                if (this.jMK != null && this.jMK.isShowing()) {
                    this.jMK.dismiss();
                }
                com.baidu.tbadk.util.e.bFg().lu(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMl() {
        if (this.jnF != null && this.jnr != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.jnr.getParent() != null) {
                if (this.jnr.getParent() == frameLayout) {
                    cMm();
                    frameLayout.removeView(this.jnr);
                } else if (this.jnr.getParent() == this.jnq) {
                    cMm();
                    this.jnq.removeView(this.jnr);
                }
            }
            if (this.jnr.getParent() == null) {
                this.jnq.addView(this.jnr, 0);
                cMn();
                this.jnF.dcv();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bFg().lu(false);
            }
        }
    }

    private void cMm() {
        if (this.iwJ != null && this.iwJ.rc()) {
            this.iwJ.az(true);
        }
    }

    private void cMn() {
        int i;
        if (!cMf()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.jnr.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (csc() != null) {
            view.setTag(this);
            csc().a(view, this.jnG);
        }
        if (view == this.jnx || view == this.ajY) {
            if (this.jnG != null && this.jnG.jof != null && !TextUtils.isEmpty(this.jnG.jof.userId)) {
                this.jMH.AL(0);
                if (!TbadkCoreApplication.isLogin() || !this.jnG.jof.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jnG.jof.userId, 0L), z, this.jnG.jof.isGod)));
            }
        } else if (view == this.fjZ) {
            if (this.jnG != null) {
                this.jMH.AL(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jnG.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.jnG.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jMw || view == this.jMx) {
            if (this.jnG != null) {
                if (this.jMH.getCurrentState() != 2 && this.jMH.getCurrentState() != 3) {
                    z = false;
                }
                this.jMH.AL(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.jnG.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.jnG.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.fkc) {
            this.jMH.AL(0);
            buF();
        } else if (view == this.jMD && this.jMD.getVisibility() == 0 && this.jMF != null) {
            this.jMF.AP(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qW(boolean z) {
        if (this.jnG != null && this.jnG.jof != null) {
            this.jnG.jof.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cFu() {
        if (this.jnG != null) {
            this.fjW.btL();
        }
    }

    public void rF(boolean z) {
        if (this.jnq != null) {
            this.jnq.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jML = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jMF = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.aaJ = fVar;
    }

    private void rG(boolean z) {
        this.jMB = this.mPosition == (this.jMG == null ? -1 : this.jMG.cMz());
        if (this.jMB && z && isPlaying() && this.eXf && !this.jMC) {
            this.jMy.setVisibility(0);
            this.jMC = true;
            this.jMy.postDelayed(this.jMR, 5000L);
            if (this.jMG != null) {
                this.jMG.gy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jMy.setVisibility(8);
        if (this.jMR != null) {
            this.jMy.removeCallbacks(this.jMR);
        }
    }

    private void buF() {
        String str;
        String str2;
        if (this.jnG != null && this.mContext != null) {
            String valueOf = String.valueOf(this.jnG.forumId);
            String str3 = this.jnG.title;
            if (this.jnG.mBaijiahao != null) {
                str = this.jnG.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.jnG.mBaijiahao.oriUgcType + "&dvid=" + this.jnG.mBaijiahao.oriUgcVid + "&nid=" + this.jnG.mBaijiahao.oriUgcNid;
            } else {
                str = this.jnG.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.jnG.jog.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.jnG.title;
            String format = (this.jnG.mBaijiahao == null || this.jnG.jof == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.jnG.jof.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.jnG.mBaijiahao != null) {
                shareItem.fuV = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fuV = str6;
                shareItem.readCount = this.jnG.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fuY = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fuK = true;
            shareItem.fuX = 11;
            if (this.jnG.getVideoType() == 1) {
                shareItem.fvc = 2;
            } else if (this.jnG.getVideoType() == 2) {
                shareItem.fvc = 8;
            } else if (this.jnG.getVideoType() == 3) {
                shareItem.fvc = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.jnG.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.jnG.mBaijiahao;
            shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dR("tid", str);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.ap("obj_locate", 12);
            arVar.dR(IntentConfig.NID, this.jnG.nid);
            if (this.jnG.mBaijiahao != null && !au.isEmpty(this.jnG.mBaijiahao.oriUgcVid)) {
                arVar.dR("obj_param6", this.jnG.mBaijiahao.oriUgcVid);
            }
            if (this.jnG.getVideoType() == 1) {
                arVar.ap(IntentConfig.CARD_TYPE, 2);
            } else if (this.jnG.getVideoType() == 2) {
                arVar.ap(IntentConfig.CARD_TYPE, 8);
            } else if (this.jnG.getVideoType() == 3) {
                arVar.ap(IntentConfig.CARD_TYPE, 6);
            }
            arVar.dR(IntentConfig.RECOM_SOURCE, this.jnG.source);
            arVar.dR("ab_tag", this.jnG.abtest_tag);
            arVar.dR("weight", this.jnG.weight);
            arVar.dR("extra", this.jnG.extra);
            arVar.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.fr(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.fr(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.fr(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.fr(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                arVar.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                arVar.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(arVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fuY);
            bundle.putInt("obj_type", shareItem.fvc);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eUk);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.ctG().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        stopVideo();
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void pausePlay() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(boolean z) {
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

    public void cMo() {
        this.iwJ.resume();
    }

    public boolean cMp() {
        if (this.jMH != null) {
            return this.jMH.getCurrentState() == 2 || this.jMH.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0737a {
        private int ezR;
        private Runnable jMW;

        private C0737a() {
            this.ezR = -1;
            this.jMW = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(C0737a.this.jMW);
                    C0737a.this.AL(2);
                }
            };
        }

        public void AL(int i) {
            switch (i) {
                case 0:
                    this.ezR = AM(i);
                    cMq();
                    return;
                case 1:
                    this.ezR = AM(i);
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMW);
                    return;
                case 2:
                    this.ezR = AN(i);
                    return;
                case 3:
                    this.ezR = AO(i);
                    cMq();
                    return;
                default:
                    this.ezR = AN(i);
                    return;
            }
        }

        private void cMq() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMW);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jMW, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.ezR;
        }

        private int AM(int i) {
            if (i != this.ezR) {
                a.this.jME.setVisibility(8);
                a.this.rH(true);
                return i;
            }
            return this.ezR;
        }

        private int AN(int i) {
            int i2 = this.ezR;
            if (i != this.ezR) {
                a.this.jME.setVisibility(0);
                if (i2 != 3 || a.this.jnG.autoPlay) {
                    a.this.rH(false);
                    return i;
                }
                return i;
            }
            return this.ezR;
        }

        private int AO(int i) {
            if (i != this.ezR) {
                a.this.jME.setVisibility(0);
                a.this.rH(true);
                return i;
            }
            return this.ezR;
        }
    }
}
