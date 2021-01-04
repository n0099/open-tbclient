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
import androidx.appcompat.widget.ActivityChooserView;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
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
    private com.baidu.tieba.lego.card.view.f aaP;
    public TextView ala;
    private Animation ciB;
    private Animation ciC;
    private TextView eLi;
    private String eQd;
    private boolean eZA;
    protected AgreeView fmo;
    private ImageView fmr;
    private View fms;
    private ImageView fmu;
    private View fmv;
    private int iMi;
    private TextView iSN;
    private boolean isFullScreen;
    private com.baidu.afd.videopaster.d ivy;
    private boolean jLA;
    private boolean jLB;
    private boolean jLC;
    private Animation.AnimationListener jLD;
    private Animation.AnimationListener jLE;
    private Runnable jLF;
    private Runnable jLG;
    public ExpandableTextView jLk;
    private View jLl;
    private FrameLayout jLm;
    private TextView jLn;
    private boolean jLo;
    private boolean jLp;
    private boolean jLq;
    private View jLr;
    private View jLs;
    private c jLt;
    public com.baidu.tieba.frs.videomiddlepage.a.a jLu;
    private C0746a jLv;
    private VideoNetworkStateTipView jLw;
    private b jLx;
    private com.baidu.mcn.c jLy;
    private com.baidu.tieba.lego.card.view.g jLz;
    private boolean jmA;
    public FrameLayout jmb;
    public FrameLayout jmc;
    public HeadImageView jmi;
    public com.baidu.tieba.play.c jmr;
    public com.baidu.tieba.frs.aggregation.g jms;
    private com.baidu.tieba.frs.aggregation.h jmt;
    private o jmu;
    private o jmv;
    private boolean jmw;
    private boolean jmx;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.jmw = true;
        this.jmA = true;
        this.jLp = false;
        this.jLq = false;
        this.jLA = false;
        this.jLB = false;
        this.jLC = false;
        this.startPosition = -1L;
        this.iMi = 0;
        this.jLD = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jLr != null) {
                    a.this.jLr.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jLr != null) {
                    a.this.jLr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jLE = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jLr != null) {
                    a.this.jLr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jLr != null) {
                    a.this.jLr.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jLF = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jLm.getVisibility() == 0) {
                    a.this.jLm.setVisibility(8);
                }
            }
        };
        this.jLG = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jmr != null) {
                    a.this.jmr.stopPlay();
                }
            }
        };
        this.jmA = z;
        this.mFrom = str;
        this.eQd = str2;
        this.jLx = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jmb = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jLl = view.findViewById(R.id.card_container);
        this.jmc = (FrameLayout) view.findViewById(R.id.video_container);
        this.jmr = new com.baidu.tieba.play.c(tbPageContext, this.jmc, false);
        this.jmr.setStageType("2005");
        this.jmr.wR(z);
        this.jmr.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jLu != null && a.this.jms.jmS.videoDuration > 8) {
                    a.this.jLu.bv(a.this.mPosition, a.this.jms.jmS.videoUrl);
                }
            }
        });
        this.jmr.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.a
            public void rC(boolean z2) {
                if (a.this.jLv != null) {
                    if (z2) {
                        a.this.jLv.Ch(0);
                    } else {
                        a.this.jLv.Ch(1);
                    }
                }
            }
        });
        this.jmr.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jLk = (ExpandableTextView) view.findViewById(R.id.title);
        this.jmi = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ala = (TextView) view.findViewById(R.id.user_name);
        this.fmo = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eOA = 2;
        dVar.eOF = 6;
        this.fmo.setStatisticData(dVar);
        this.fmo.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.eLi = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fmr = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fms = view.findViewById(R.id.thread_info_commont_container);
        this.iSN = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.fmu = (ImageView) view.findViewById(R.id.share_num_img);
        this.fmv = view.findViewById(R.id.share_num_container);
        this.jLm = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jLn = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jLm.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jLn.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bvq().getString("nani_key_download_link_url", null);
        this.jLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bwu().a((TbPageContext) j.K(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jLw = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jLw.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.jLw.setHasAgreeToPlay(true);
                a.this.jmr.wX(false);
                a.this.jLw.dWK();
                if (a.this.ivy.re()) {
                    a.this.ivy.resume();
                } else if (a.this.jms != null && a.this.jms.jmS != null) {
                    a.this.jmr.fY(a.this.jms.jmS.videoUrl, a.this.jms.threadId);
                }
            }
        });
        this.jLr = view.findViewById(R.id.video_agg_container_foreground);
        this.jLs = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jLr.setOnClickListener(this);
        this.fms.setOnClickListener(this);
        this.fmv.setOnClickListener(this);
        this.jLk.setOnClickListener(this);
        this.jmi.setOnClickListener(this);
        this.ala.setOnClickListener(this);
        this.jLl.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.iMi = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jmb.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jmb.setLayoutParams(layoutParams);
        this.jmi.setIsRound(true);
        this.jmi.setPlaceHolder(1);
        this.jmt = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.ciB = new AlphaAnimation(0.0f, 0.7f);
        this.ciB.setDuration(500L);
        this.ciB.setAnimationListener(this.jLE);
        this.ciC = new AlphaAnimation(0.7f, 0.0f);
        this.ciC.setDuration(500L);
        this.ciC.setAnimationListener(this.jLD);
        this.jLv = new C0746a();
        this.ivy = new com.baidu.afd.videopaster.d(getContext(), this.jmc);
        this.jLy = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fmo.onChangeSkinType(i);
        this.eLi.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.iSN.setTextColor(ao.getColor(R.color.CAM_X0107));
        WebPManager.a(this.fmu, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fmr, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jLk.onChangeSkinType();
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
        if (gVar != null && gVar.jmS != null) {
            boolean z = this.jms == gVar;
            this.jms = gVar;
            this.eZA = this.jms.autoPlay;
            this.jLq = false;
            rA(false);
            this.jLk.setVisibility(0);
            this.jLk.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jLk.setTextColor(R.color.CAM_X0101);
            this.jLk.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.jmS != null && !StringUtils.isNull(gVar.jmS.mcnLeadPage)) {
                this.jLk.setTextMaxLine(2);
                this.jLk.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jLk.getContentView(), gVar.title, gVar.jmS.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jLk.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.jLk.setExpandable(true);
                this.jLk.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rD(boolean z2) {
                        a.this.jms.isTitleExpanded = z2;
                    }
                });
                this.jLk.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.iMi) {
                this.jmr.dBy();
                this.iMi = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.jmc.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jmc.setLayoutParams(layoutParams);
            }
            cOC();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.jms = gVar;
        this.eZA = this.jms.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cOB() {
        try {
            int parseInt = Integer.parseInt(this.jms.jmS.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.jms.jmS.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cOC() {
        if (!cOB()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jmb.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jmb.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jmb.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jmb.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.jmS != null) {
            this.jmr.stopPlay();
            this.jmr.wY(true);
            this.jmr.wU(true);
            this.jmr.wZ(true);
            this.jmr.ax(false, false);
            this.jmr.IA(i);
            this.jmr.a(new c.InterfaceC0829c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rl() {
                    a.this.cOG();
                    if (a.this.ivy != null) {
                        a.this.ivy.rl();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rm() {
                    a.this.cOH();
                    if (a.this.jmr.rn()) {
                    }
                    if (a.this.jmx || (a.this.ivy != null && a.this.ivy.re())) {
                        com.baidu.adp.lib.f.e.mB().removeCallbacks(a.this.jLG);
                        com.baidu.adp.lib.f.e.mB().post(a.this.jLG);
                    }
                    if (a.this.ivy != null) {
                        a.this.ivy.rm();
                    }
                }
            });
            this.jmr.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.l
                public void cHT() {
                    if (a.this.jms != null && a.this.jms.jmS != null && com.baidu.adp.lib.f.b.toInt(a.this.jms.jmS.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.jms.jmS.videoWidth, 0)) {
                        a.this.jmr.ax(false, false);
                    } else {
                        a.this.jmr.ax(true, false);
                    }
                    a.this.jmx = false;
                    a.this.KM(a.this.eZA ? "1" : "2");
                    a.this.onClick(a.this.jmc);
                    if (a.this.aaP != null) {
                        a.this.aaP.a(a.this);
                    }
                    if (a.this.jLz != null) {
                        a.this.jLz.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cHU() {
                    a.this.onClick(a.this.jmb);
                }
            });
            this.jmr.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.18
                @Override // com.baidu.tieba.play.c.f
                public void qR(boolean z2) {
                    a.this.jmr.fY(a.this.jms.jmS.videoUrl, a.this.jms.threadId);
                    a.this.KM("2");
                    a.this.onClick(a.this.jmc);
                }
            });
            this.jmr.wQ(false);
            if (this.jLy != null) {
                this.jLy.reset();
            }
            this.startPosition = -1L;
            if (this.jmr.getVideoView() != null && this.jmr.getVideoView().getMediaProgressObserver() != null) {
                this.jmr.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ch(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.jms.jmS.jnc;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.ivy.d(a.this.isFullScreen, a.this.jmr != null && a.this.jmr.dBf(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.ivy.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.jmr.dBf() && !com.baidu.mcn.b.adu().jD(aVar2.abf)) {
                            boolean z3 = a.this.startPosition >= (aVar2.jmU * 1000) + 1000;
                            if (i3 < aVar2.jmU * 1000 || i3 >= aVar2.jmV * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jLy.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.cio = aVar2.jmX;
                                    aVar3.cip = aVar2.jmY;
                                    aVar3.ciq = aVar2.abf;
                                    aVar3.cin = aVar2.jmW;
                                    aVar3.fid = a.this.jms != null ? a.this.jms.forumId : null;
                                    aVar3.tid = a.this.jms != null ? a.this.jms.threadId : null;
                                    aVar3.cir = 3;
                                    if (z3) {
                                        a.this.jLy.b(aVar3, (ViewGroup) a.this.jmr.dBx());
                                    } else {
                                        a.this.jLy.a(aVar3, (ViewGroup) a.this.jmr.dBx());
                                    }
                                }
                            } else if (a.this.jLy.isShowing()) {
                                a.this.jLy.dismiss();
                            }
                        }
                    }
                });
            }
            this.jmu = new o();
            this.jmu.anD = gVar.threadId;
            this.jmu.eVY = gVar.nid;
            this.jmu.fPy = gVar.forumId;
            this.jmu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jmu.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.jmu.mSource = gVar.source;
            this.jmu.mDH = gVar.weight;
            this.jmu.mDJ = this.mFrom;
            this.jmu.mDL = gVar.abtest_tag;
            this.jmu.eQd = this.eQd;
            this.jmu.mExtra = gVar.extra;
            this.jmu.mDO = "0";
            this.jmu.mDK = gVar.getVideoType();
            this.jmv = new o();
            this.jmv.anD = gVar.threadId;
            this.jmv.fPy = gVar.forumId;
            this.jmv.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jmv.mDH = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jmv.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jmv.mDJ = this.mFrom;
            this.jmv.mSource = gVar.source;
            this.jmv.mDO = "0";
            if (gVar.jmS != null) {
                this.jmu.mDM = gVar.jmS.videoMd5;
                this.jmv.mDM = gVar.jmS.videoMd5;
            }
            aq aqVar = new aq("c12590");
            aqVar.dX("tid", gVar.threadId);
            aqVar.dX(IntentConfig.NID, gVar.nid);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.an("obj_locate", i);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dX("fid", gVar.forumId);
            aqVar.dX("obj_param1", at.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aqVar.dX("extra", at.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aqVar.dX("obj_id", this.eQd);
            aqVar.dX("ab_tag", at.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aqVar.dX("obj_type", this.mFrom);
            aqVar.an("obj_param5", gVar.getVideoType());
            aqVar.dX("obj_source", at.isEmpty(gVar.source) ? "0" : gVar.source);
            aqVar.an("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aqVar.dX("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aqVar.dX("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aqVar);
            this.jmr.getVideoView().setVideoStatData(this.jmu);
            this.jmr.deh();
            this.jmr.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.ivy.d(a.this.isFullScreen, a.this.jmr != null && a.this.jmr.dBf(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.jmx = true;
                            a.this.jLo = true;
                            a.this.jmw = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.AA(i);
                            a.this.jmr.cUv();
                        }
                    }
                }
            });
            this.jmr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.jms != null && a.this.jms.jmS != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.jms.jmS.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.ivy.reset();
            }
            this.ivy.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void ru() {
                    a.this.jLo = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rt() {
                    if (a.this.isFullScreen) {
                        a.this.jmx = true;
                        a.this.jLo = true;
                        a.this.jmw = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.AA(i);
                        a.this.jmr.cUv();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rs() {
                    if (a.this.jmr != null) {
                        a.this.jmr.Iz(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rv() {
                    return a.this.cOF();
                }
            });
            this.jmr.setThumbnail(gVar.jmS.thumbnailUrl);
            this.jmr.Iy(gVar.jmS.videoDuration);
            this.jmr.setVideoUrl(gVar.jmS.videoUrl, gVar.threadId);
            this.jmr.setFid(gVar.forumId);
            this.jmr.cUv();
            this.jmr.show();
            rA(false);
            if (gVar.autoPlay) {
                onClick(this.jmc);
                if (this.jLw.dwY()) {
                    this.jmr.wW(false);
                    this.jLw.dWJ();
                    this.jmr.wX(true);
                    this.jmr.fX(gVar.jmS.videoUrl, gVar.threadId);
                    if (this.ivy.re()) {
                        this.ivy.stop();
                        this.ivy.ri();
                    }
                } else {
                    this.jmr.wX(false);
                    this.jmr.wW(false);
                    this.jLw.hide();
                    if (this.ivy == null || (this.ivy != null && !this.ivy.re())) {
                        this.jmr.a(gVar.jmS.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.jmT) {
                    this.jLr.setVisibility(8);
                    this.jLv.Ch(3);
                } else {
                    if (this.jLr.getVisibility() == 0) {
                        this.jLr.startAnimation(this.ciC);
                    }
                    this.jLv.Ch(0);
                }
                gVar.jmT = false;
            } else {
                this.jLr.setVisibility(0);
                this.jLw.hide();
                this.jmr.wW(true);
                this.jLv.Ch(3);
                this.jmr.fX(gVar.jmS.videoUrl, gVar.threadId);
            }
            this.jmx = false;
            this.jLo = false;
            if (!z && this.ivy.re()) {
                stopPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a h(com.baidu.tieba.frs.aggregation.g gVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (gVar == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b LL = this.jLx != null ? this.jLx.LL(gVar.getThreadId()) : null;
        if (LL != null) {
            int rz = LL.rz();
            int rA = LL.rA();
            int ry = LL.ry();
            if (ry != -1) {
                i2 = rz != -1 ? (ry - rz) - 1 : -1;
                i = rA != -1 ? (rA - ry) - 1 : -1;
            } else {
                i = -1;
                i2 = -1;
            }
            if (gVar.jmS != null) {
                i4 = com.baidu.adp.lib.f.b.toInt(gVar.jmS.videoWidth, 0);
                i3 = com.baidu.adp.lib.f.b.toInt(gVar.jmS.videoHeight, 0);
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
            com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", ry + 1, i4, i3);
            a2.u(hashMap);
            return a2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM(String str) {
        if (this.jms != null && this.jms.jmS != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jms.jmS.videoMd5, "", str, this.jmv, this.jmr.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jmr.rn();
    }

    public boolean cOD() {
        return this.ivy.re();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jmr.aUC();
        }
    }

    public boolean AB(int i) {
        if (i == 4 && this.ivy != null && ((this.ivy.re() || this.jLo) && this.jmr != null)) {
            this.ivy.be(i);
            if (this.isFullScreen) {
                if (this.ivy.rd()) {
                    this.jmr.dBg();
                } else {
                    this.jmr.Wl();
                }
                return true;
            }
        }
        return this.jmr.Iz(i);
    }

    public void stopVideo() {
        this.jLq = false;
        this.jmr.stopPlay();
        if (this.jLk != null) {
            this.jLk.setVisibility(0);
        }
        if (this.jLv != null) {
            this.jLv.Ch(2);
        }
        rA(false);
        this.jLp = true;
        if (this.ivy != null && this.ivy.re()) {
            this.ivy.stop();
        }
    }

    public void cOE() {
        this.ivy.stop();
    }

    public void cHR() {
        if (this.jmr != null) {
            this.jmr.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cHR();
        if (this.jmt != null) {
            this.jmt.cIb();
        }
        if (this.jLr != null) {
            this.jLr.clearAnimation();
        }
        this.ivy.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.jmR != null) {
            this.ala.setText(TextUtils.isEmpty(gVar.jmR.userNickname) ? gVar.jmR.userName : gVar.jmR.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jmR != null) {
            if (gVar.jmR.jnb != null && !TextUtils.isEmpty(gVar.jmR.jnb.avatar)) {
                this.jmi.startLoad(gVar.jmR.jnb.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.jmR.portrait) && gVar.jmR.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jmi.startLoad(gVar.jmR.portrait, 10, false);
            } else {
                this.jmi.startLoad(gVar.jmR.portrait, 12, false);
            }
            if (gVar.jmR.jnb != null && gVar.jmR.jnb.auth_id.intValue() > 0) {
                this.jmi.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.jmR.jnb.auth_id.intValue(), 1));
                this.jmi.setShowV(true);
                this.jmi.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jmi.setBjhAuthIconRes(0);
            if (gVar.jmR.isBigV) {
                this.jmi.setShowV(gVar.jmR.isBigV);
                this.jmi.setIsBigV(gVar.jmR.isBigV);
            } else if (gVar.jmR.isGod) {
                this.jmi.setShowV(gVar.jmR.isGod);
                this.jmi.setIsBigV(gVar.jmR.isGod);
            } else {
                this.jmi.setShowV(gVar.jmR.isGod);
                this.jmi.setIsBigV(gVar.jmR.isGod);
            }
            this.jmi.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(final com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.btk() != null) {
                gVar.btk().isInThread = true;
                gVar.btk().nid = gVar.nid;
                if (this.jms.getVideoType() == 1) {
                    gVar.btk().cardType = 2;
                } else if (this.jms.getVideoType() == 2) {
                    gVar.btk().cardType = 8;
                } else if (this.jms.getVideoType() == 3) {
                    gVar.btk().cardType = 6;
                }
                gVar.btk().baijiahaoData = gVar.mBaijiahao;
                gVar.btk().recomSource = gVar.source;
                gVar.btk().recomWeight = gVar.weight;
                gVar.btk().recomAbTag = gVar.abtest_tag;
                gVar.btk().recomExtra = gVar.extra;
            }
            this.fmo.setAgreeAlone(true);
            this.fmo.setIsFromMiddlePage(true);
            this.fmo.setData(gVar.btk());
            this.fmo.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (gVar.btk().hasAgree && gVar.btk().agreeType == 2) {
                        a.this.jLv.Ch(0);
                    }
                }
            });
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eLi.setTextColor(ao.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fmr, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.eLi.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.eLi.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.iSN.setTextColor(ao.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fmu, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.iSN.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.iSN.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jmr != null && this.jmc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jmw) {
                this.jmr.dBm();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cOG();
            } else {
                configuration.orientation = 1;
                cOH();
                this.jmw = true;
            }
            this.jmr.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOF() {
        if (this.jmr != null && this.jmc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jmc.getParent() != null) {
                if (this.jmc.getParent() == frameLayout) {
                    if (this.jLA) {
                        this.jLA = false;
                        return true;
                    } else if (!this.jLB) {
                        this.jLB = true;
                        return true;
                    }
                } else if (this.jmc.getParent() == this.jmb) {
                    if (this.jLB) {
                        this.jLB = false;
                        this.jLC = true;
                        return true;
                    } else if (!this.jLA && this.jLC) {
                        this.jLA = true;
                        this.jLC = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOG() {
        if (this.jmr != null && this.jmc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.jmc.getParent() != null) {
                if (this.jmc.getParent() == frameLayout) {
                    frameLayout.removeView(this.jmc);
                } else if (this.jmc.getParent() == this.jmb) {
                    this.jmb.removeView(this.jmc);
                }
            }
            if (this.jmc.getParent() == null) {
                frameLayout.addView(this.jmc);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jmc.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jmc.setLayoutParams(layoutParams);
                if (this.jLy != null && this.jLy.isShowing()) {
                    this.jLy.dismiss();
                }
                com.baidu.tbadk.util.d.bIE().lv(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOH() {
        if (this.jmr != null && this.jmc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.jmc.getParent() != null) {
                if (this.jmc.getParent() == frameLayout) {
                    cOI();
                    frameLayout.removeView(this.jmc);
                } else if (this.jmc.getParent() == this.jmb) {
                    cOI();
                    this.jmb.removeView(this.jmc);
                }
            }
            if (this.jmc.getParent() == null) {
                this.jmb.addView(this.jmc, 0);
                cOJ();
                this.jmr.deh();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.bIE().lv(false);
            }
        }
    }

    private void cOI() {
        if (this.ivy != null && this.ivy.re()) {
            this.ivy.az(true);
        }
    }

    private void cOJ() {
        int i;
        if (!cOB()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.jmc.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cuC() != null) {
            view.setTag(this);
            cuC().a(view, this.jms);
        }
        if (view == this.jmi || view == this.ala) {
            if (this.jms != null && this.jms.jmR != null && !TextUtils.isEmpty(this.jms.jmR.userId)) {
                this.jLv.Ch(0);
                if (!TbadkCoreApplication.isLogin() || !this.jms.jmR.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jms.jmR.userId, 0L), z, this.jms.jmR.isGod)));
            }
        } else if (view == this.fms) {
            if (this.jms != null) {
                this.jLv.Ch(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jms.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.jms.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jLk || view == this.jLl) {
            if (this.jms != null) {
                if (this.jLv.getCurrentState() != 2 && this.jLv.getCurrentState() != 3) {
                    z = false;
                }
                this.jLv.Ch(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.jms.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.jms.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.fmv) {
            this.jLv.Ch(0);
            bye();
        } else if (view == this.jLr && this.jLr.getVisibility() == 0 && this.jLt != null) {
            this.jLt.Cl(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qQ(boolean z) {
        if (this.jms != null && this.jms.jmR != null) {
            this.jms.jmR.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cHS() {
        if (this.jms != null) {
            this.fmo.bxk();
        }
    }

    public void rz(boolean z) {
        if (this.jmb != null) {
            this.jmb.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jLz = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jLt = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.aaP = fVar;
    }

    private void rA(boolean z) {
        this.jLp = this.mPosition == (this.jLu == null ? -1 : this.jLu.cOV());
        if (this.jLp && z && isPlaying() && this.eZA && !this.jLq) {
            this.jLm.setVisibility(0);
            this.jLq = true;
            this.jLm.postDelayed(this.jLF, 5000L);
            if (this.jLu != null) {
                this.jLu.gt(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jLm.setVisibility(8);
        if (this.jLF != null) {
            this.jLm.removeCallbacks(this.jLF);
        }
    }

    private void bye() {
        String str;
        String str2;
        if (this.jms != null && this.mContext != null) {
            String valueOf = String.valueOf(this.jms.forumId);
            String str3 = this.jms.title;
            if (this.jms.mBaijiahao != null) {
                str = this.jms.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.jms.mBaijiahao.oriUgcType + "&dvid=" + this.jms.mBaijiahao.oriUgcVid + "&nid=" + this.jms.mBaijiahao.oriUgcNid;
            } else {
                str = this.jms.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.jms.jmS.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.jms.title;
            String format = (this.jms.mBaijiahao == null || this.jms.jmR == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.jms.jmR.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.jms.mBaijiahao != null) {
                shareItem.fxm = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fxm = str6;
                shareItem.readCount = this.jms.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fxp = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fxb = true;
            shareItem.fxo = 11;
            if (this.jms.getVideoType() == 1) {
                shareItem.fxt = 2;
            } else if (this.jms.getVideoType() == 2) {
                shareItem.fxt = 8;
            } else if (this.jms.getVideoType() == 3) {
                shareItem.fxt = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.jms.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.jms.mBaijiahao;
            shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dX("tid", str);
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.an("obj_locate", 12);
            aqVar.dX(IntentConfig.NID, this.jms.nid);
            if (this.jms.mBaijiahao != null && !at.isEmpty(this.jms.mBaijiahao.oriUgcVid)) {
                aqVar.dX("obj_param6", this.jms.mBaijiahao.oriUgcVid);
            }
            if (this.jms.getVideoType() == 1) {
                aqVar.an(IntentConfig.CARD_TYPE, 2);
            } else if (this.jms.getVideoType() == 2) {
                aqVar.an(IntentConfig.CARD_TYPE, 8);
            } else if (this.jms.getVideoType() == 3) {
                aqVar.an(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dX(IntentConfig.RECOM_SOURCE, this.jms.source);
            aqVar.dX("ab_tag", this.jms.abtest_tag);
            aqVar.dX("weight", this.jms.weight);
            aqVar.dX("extra", this.jms.extra);
            aqVar.dX("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dX("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dX("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fxp);
            bundle.putInt("obj_type", shareItem.fxt);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eWH);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.cwe().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        stopVideo();
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aUC() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(boolean z) {
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

    public void cOK() {
        this.ivy.resume();
    }

    public boolean cOL() {
        if (this.jLv != null) {
            return this.jLv.getCurrentState() == 2 || this.jLv.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0746a {
        private int cvb;
        private Runnable jLK;

        private C0746a() {
            this.cvb = -1;
            this.jLK = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(C0746a.this.jLK);
                    C0746a.this.Ch(2);
                }
            };
        }

        public void Ch(int i) {
            switch (i) {
                case 0:
                    this.cvb = Ci(i);
                    cOM();
                    return;
                case 1:
                    this.cvb = Ci(i);
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLK);
                    return;
                case 2:
                    this.cvb = Cj(i);
                    return;
                case 3:
                    this.cvb = Ck(i);
                    cOM();
                    return;
                default:
                    this.cvb = Cj(i);
                    return;
            }
        }

        private void cOM() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLK);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jLK, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.cvb;
        }

        private int Ci(int i) {
            if (i != this.cvb) {
                a.this.jLs.setVisibility(8);
                a.this.rB(true);
                return i;
            }
            return this.cvb;
        }

        private int Cj(int i) {
            int i2 = this.cvb;
            if (i != this.cvb) {
                a.this.jLs.setVisibility(0);
                if (i2 != 3 || a.this.jms.autoPlay) {
                    a.this.rB(false);
                    return i;
                }
                return i;
            }
            return this.cvb;
        }

        private int Ck(int i) {
            if (i != this.cvb) {
                a.this.jLs.setVisibility(0);
                a.this.rB(true);
                return i;
            }
            return this.cvb;
        }
    }
}
