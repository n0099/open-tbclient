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
    private com.baidu.tieba.lego.card.view.f aaN;
    public TextView akj;
    private Animation cdO;
    private Animation cdP;
    private TextView eGx;
    private String eLs;
    private boolean eUP;
    protected AgreeView fhD;
    private ImageView fhF;
    private View fhG;
    private ImageView fhI;
    private View fhJ;
    private int iHB;
    private TextView iOg;
    private com.baidu.afd.videopaster.d iqR;
    private boolean isFullScreen;
    public ExpandableTextView jGE;
    private View jGF;
    private FrameLayout jGG;
    private TextView jGH;
    private boolean jGI;
    private boolean jGJ;
    private boolean jGK;
    private View jGL;
    private View jGM;
    private c jGN;
    public com.baidu.tieba.frs.videomiddlepage.a.a jGO;
    private C0736a jGP;
    private VideoNetworkStateTipView jGQ;
    private b jGR;
    private com.baidu.mcn.c jGS;
    private com.baidu.tieba.lego.card.view.g jGT;
    private boolean jGU;
    private boolean jGV;
    private boolean jGW;
    private Animation.AnimationListener jGX;
    private Animation.AnimationListener jGY;
    private Runnable jGZ;
    private Runnable jHa;
    public HeadImageView jhB;
    public com.baidu.tieba.play.c jhJ;
    public com.baidu.tieba.frs.aggregation.g jhK;
    private com.baidu.tieba.frs.aggregation.h jhL;
    private o jhM;
    private o jhN;
    private boolean jhO;
    private boolean jhP;
    private boolean jhS;
    public FrameLayout jhu;
    public FrameLayout jhv;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.jhO = true;
        this.jhS = true;
        this.jGJ = false;
        this.jGK = false;
        this.jGU = false;
        this.jGV = false;
        this.jGW = false;
        this.startPosition = -1L;
        this.iHB = 0;
        this.jGX = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jGL != null) {
                    a.this.jGL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jGL != null) {
                    a.this.jGL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jGY = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jGL != null) {
                    a.this.jGL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jGL != null) {
                    a.this.jGL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jGZ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jGG.getVisibility() == 0) {
                    a.this.jGG.setVisibility(8);
                }
            }
        };
        this.jHa = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jhJ != null) {
                    a.this.jhJ.stopPlay();
                }
            }
        };
        this.jhS = z;
        this.mFrom = str;
        this.eLs = str2;
        this.jGR = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jhu = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jGF = view.findViewById(R.id.card_container);
        this.jhv = (FrameLayout) view.findViewById(R.id.video_container);
        this.jhJ = new com.baidu.tieba.play.c(tbPageContext, this.jhv, false);
        this.jhJ.setStageType("2005");
        this.jhJ.wN(z);
        this.jhJ.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jGO != null && a.this.jhK.jil.videoDuration > 8) {
                    a.this.jGO.bw(a.this.mPosition, a.this.jhK.jil.videoUrl);
                }
            }
        });
        this.jhJ.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.a
            public void ry(boolean z2) {
                if (a.this.jGP != null) {
                    if (z2) {
                        a.this.jGP.AB(0);
                    } else {
                        a.this.jGP.AB(1);
                    }
                }
            }
        });
        this.jhJ.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jGE = (ExpandableTextView) view.findViewById(R.id.title);
        this.jhB = (HeadImageView) view.findViewById(R.id.user_icon);
        this.akj = (TextView) view.findViewById(R.id.user_name);
        this.fhD = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eJP = 2;
        dVar.eJU = 6;
        this.fhD.setStatisticData(dVar);
        this.fhD.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.eGx = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fhF = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fhG = view.findViewById(R.id.thread_info_commont_container);
        this.iOg = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.fhI = (ImageView) view.findViewById(R.id.share_num_img);
        this.fhJ = view.findViewById(R.id.share_num_container);
        this.jGG = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jGH = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jGG.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jGH.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.brx().getString("nani_key_download_link_url", null);
        this.jGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bsB().a((TbPageContext) j.K(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jGQ = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jGQ.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.jGQ.setHasAgreeToPlay(true);
                a.this.jhJ.wT(false);
                a.this.jGQ.dST();
                if (a.this.iqR.re()) {
                    a.this.iqR.resume();
                } else if (a.this.jhK != null && a.this.jhK.jil != null) {
                    a.this.jhJ.fX(a.this.jhK.jil.videoUrl, a.this.jhK.threadId);
                }
            }
        });
        this.jGL = view.findViewById(R.id.video_agg_container_foreground);
        this.jGM = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jGL.setOnClickListener(this);
        this.fhG.setOnClickListener(this);
        this.fhJ.setOnClickListener(this);
        this.jGE.setOnClickListener(this);
        this.jhB.setOnClickListener(this);
        this.akj.setOnClickListener(this);
        this.jGF.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.iHB = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jhu.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jhu.setLayoutParams(layoutParams);
        this.jhB.setIsRound(true);
        this.jhB.setPlaceHolder(1);
        this.jhL = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.cdO = new AlphaAnimation(0.0f, 0.7f);
        this.cdO.setDuration(500L);
        this.cdO.setAnimationListener(this.jGY);
        this.cdP = new AlphaAnimation(0.7f, 0.0f);
        this.cdP.setDuration(500L);
        this.cdP.setAnimationListener(this.jGX);
        this.jGP = new C0736a();
        this.iqR = new com.baidu.afd.videopaster.d(getContext(), this.jhv);
        this.jGS = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fhD.onChangeSkinType(i);
        this.eGx.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.iOg.setTextColor(ao.getColor(R.color.CAM_X0107));
        WebPManager.a(this.fhI, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fhF, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jGE.onChangeSkinType();
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
        if (gVar != null && gVar.jil != null) {
            boolean z = this.jhK == gVar;
            this.jhK = gVar;
            this.eUP = this.jhK.autoPlay;
            this.jGK = false;
            rw(false);
            this.jGE.setVisibility(0);
            this.jGE.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jGE.setTextColor(R.color.CAM_X0101);
            this.jGE.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.jil != null && !StringUtils.isNull(gVar.jil.mcnLeadPage)) {
                this.jGE.setTextMaxLine(2);
                this.jGE.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jGE.getContentView(), gVar.title, gVar.jil.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jGE.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.jGE.setExpandable(true);
                this.jGE.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rz(boolean z2) {
                        a.this.jhK.isTitleExpanded = z2;
                    }
                });
                this.jGE.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.iHB) {
                this.jhJ.dxH();
                this.iHB = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.jhv.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jhv.setLayoutParams(layoutParams);
            }
            cKL();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.jhK = gVar;
        this.eUP = this.jhK.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cKK() {
        try {
            int parseInt = Integer.parseInt(this.jhK.jil.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.jhK.jil.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cKL() {
        if (!cKK()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jhu.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jhu.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jhu.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jhu.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.jil != null) {
            this.jhJ.stopPlay();
            this.jhJ.wU(true);
            this.jhJ.wQ(true);
            this.jhJ.wV(true);
            this.jhJ.ax(false, false);
            this.jhJ.GT(i);
            this.jhJ.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rl() {
                    a.this.cKP();
                    if (a.this.iqR != null) {
                        a.this.iqR.rl();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rm() {
                    a.this.cKQ();
                    if (a.this.jhJ.rn()) {
                    }
                    if (a.this.jhP || (a.this.iqR != null && a.this.iqR.re())) {
                        com.baidu.adp.lib.f.e.mB().removeCallbacks(a.this.jHa);
                        com.baidu.adp.lib.f.e.mB().post(a.this.jHa);
                    }
                    if (a.this.iqR != null) {
                        a.this.iqR.rm();
                    }
                }
            });
            this.jhJ.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.l
                public void cEc() {
                    if (a.this.jhK != null && a.this.jhK.jil != null && com.baidu.adp.lib.f.b.toInt(a.this.jhK.jil.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.jhK.jil.videoWidth, 0)) {
                        a.this.jhJ.ax(false, false);
                    } else {
                        a.this.jhJ.ax(true, false);
                    }
                    a.this.jhP = false;
                    a.this.JB(a.this.eUP ? "1" : "2");
                    a.this.onClick(a.this.jhv);
                    if (a.this.aaN != null) {
                        a.this.aaN.a(a.this);
                    }
                    if (a.this.jGT != null) {
                        a.this.jGT.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cEd() {
                    a.this.onClick(a.this.jhu);
                }
            });
            this.jhJ.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.18
                @Override // com.baidu.tieba.play.c.f
                public void qN(boolean z2) {
                    a.this.jhJ.fX(a.this.jhK.jil.videoUrl, a.this.jhK.threadId);
                    a.this.JB("2");
                    a.this.onClick(a.this.jhv);
                }
            });
            this.jhJ.wM(false);
            if (this.jGS != null) {
                this.jGS.reset();
            }
            this.startPosition = -1L;
            if (this.jhJ.getVideoView() != null && this.jhJ.getVideoView().getMediaProgressObserver() != null) {
                this.jhJ.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ch(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.jhK.jil.jiv;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.iqR.d(a.this.isFullScreen, a.this.jhJ != null && a.this.jhJ.dxo(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.iqR.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.jhJ.dxo() && !com.baidu.mcn.b.ZC().is(aVar2.abd)) {
                            boolean z3 = a.this.startPosition >= (aVar2.jin * 1000) + 1000;
                            if (i3 < aVar2.jin * 1000 || i3 >= aVar2.jio * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jGS.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.cdB = aVar2.jiq;
                                    aVar3.cdC = aVar2.jir;
                                    aVar3.cdD = aVar2.abd;
                                    aVar3.cdA = aVar2.jip;
                                    aVar3.fid = a.this.jhK != null ? a.this.jhK.forumId : null;
                                    aVar3.tid = a.this.jhK != null ? a.this.jhK.threadId : null;
                                    aVar3.cdE = 3;
                                    if (z3) {
                                        a.this.jGS.b(aVar3, (ViewGroup) a.this.jhJ.dxG());
                                    } else {
                                        a.this.jGS.a(aVar3, (ViewGroup) a.this.jhJ.dxG());
                                    }
                                }
                            } else if (a.this.jGS.isShowing()) {
                                a.this.jGS.dismiss();
                            }
                        }
                    }
                });
            }
            this.jhM = new o();
            this.jhM.amM = gVar.threadId;
            this.jhM.eRn = gVar.nid;
            this.jhM.fKR = gVar.forumId;
            this.jhM.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jhM.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.jhM.mSource = gVar.source;
            this.jhM.myX = gVar.weight;
            this.jhM.myZ = this.mFrom;
            this.jhM.mzb = gVar.abtest_tag;
            this.jhM.eLs = this.eLs;
            this.jhM.mExtra = gVar.extra;
            this.jhM.mze = "0";
            this.jhM.mza = gVar.getVideoType();
            this.jhN = new o();
            this.jhN.amM = gVar.threadId;
            this.jhN.fKR = gVar.forumId;
            this.jhN.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jhN.myX = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jhN.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jhN.myZ = this.mFrom;
            this.jhN.mSource = gVar.source;
            this.jhN.mze = "0";
            if (gVar.jil != null) {
                this.jhM.mzc = gVar.jil.videoMd5;
                this.jhN.mzc = gVar.jil.videoMd5;
            }
            aq aqVar = new aq("c12590");
            aqVar.dW("tid", gVar.threadId);
            aqVar.dW(IntentConfig.NID, gVar.nid);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.an("obj_locate", i);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dW("fid", gVar.forumId);
            aqVar.dW("obj_param1", at.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aqVar.dW("extra", at.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aqVar.dW("obj_id", this.eLs);
            aqVar.dW("ab_tag", at.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aqVar.dW("obj_type", this.mFrom);
            aqVar.an("obj_param5", gVar.getVideoType());
            aqVar.dW("obj_source", at.isEmpty(gVar.source) ? "0" : gVar.source);
            aqVar.an("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aqVar.dW("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aqVar.dW("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aqVar);
            this.jhJ.getVideoView().setVideoStatData(this.jhM);
            this.jhJ.daq();
            this.jhJ.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.iqR.d(a.this.isFullScreen, a.this.jhJ != null && a.this.jhJ.dxo(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.jhP = true;
                            a.this.jGI = true;
                            a.this.jhO = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.yU(i);
                            a.this.jhJ.cQE();
                        }
                    }
                }
            });
            this.jhJ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.jhK != null && a.this.jhK.jil != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.jhK.jil.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.iqR.reset();
            }
            this.iqR.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void ru() {
                    a.this.jGI = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rt() {
                    if (a.this.isFullScreen) {
                        a.this.jhP = true;
                        a.this.jGI = true;
                        a.this.jhO = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.yU(i);
                        a.this.jhJ.cQE();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rs() {
                    if (a.this.jhJ != null) {
                        a.this.jhJ.GS(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rv() {
                    return a.this.cKO();
                }
            });
            this.jhJ.setThumbnail(gVar.jil.thumbnailUrl);
            this.jhJ.GR(gVar.jil.videoDuration);
            this.jhJ.setVideoUrl(gVar.jil.videoUrl, gVar.threadId);
            this.jhJ.setFid(gVar.forumId);
            this.jhJ.cQE();
            this.jhJ.show();
            rw(false);
            if (gVar.autoPlay) {
                onClick(this.jhv);
                if (this.jGQ.dth()) {
                    this.jhJ.wS(false);
                    this.jGQ.dSS();
                    this.jhJ.wT(true);
                    this.jhJ.fW(gVar.jil.videoUrl, gVar.threadId);
                    if (this.iqR.re()) {
                        this.iqR.stop();
                        this.iqR.ri();
                    }
                } else {
                    this.jhJ.wT(false);
                    this.jhJ.wS(false);
                    this.jGQ.hide();
                    if (this.iqR == null || (this.iqR != null && !this.iqR.re())) {
                        this.jhJ.a(gVar.jil.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.jim) {
                    this.jGL.setVisibility(8);
                    this.jGP.AB(3);
                } else {
                    if (this.jGL.getVisibility() == 0) {
                        this.jGL.startAnimation(this.cdP);
                    }
                    this.jGP.AB(0);
                }
                gVar.jim = false;
            } else {
                this.jGL.setVisibility(0);
                this.jGQ.hide();
                this.jhJ.wS(true);
                this.jGP.AB(3);
                this.jhJ.fW(gVar.jil.videoUrl, gVar.threadId);
            }
            this.jhP = false;
            this.jGI = false;
            if (!z && this.iqR.re()) {
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
        com.baidu.afd.videopaster.data.b KA = this.jGR != null ? this.jGR.KA(gVar.getThreadId()) : null;
        if (KA != null) {
            int rz = KA.rz();
            int rA = KA.rA();
            int ry = KA.ry();
            if (ry != -1) {
                i2 = rz != -1 ? (ry - rz) - 1 : -1;
                i = rA != -1 ? (rA - ry) - 1 : -1;
            } else {
                i = -1;
                i2 = -1;
            }
            if (gVar.jil != null) {
                i4 = com.baidu.adp.lib.f.b.toInt(gVar.jil.videoWidth, 0);
                i3 = com.baidu.adp.lib.f.b.toInt(gVar.jil.videoHeight, 0);
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
    public void JB(String str) {
        if (this.jhK != null && this.jhK.jil != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jhK.jil.videoMd5, "", str, this.jhN, this.jhJ.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jhJ.rn();
    }

    public boolean cKM() {
        return this.iqR.re();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jhJ.aQJ();
        }
    }

    public boolean yV(int i) {
        if (i == 4 && this.iqR != null && ((this.iqR.re() || this.jGI) && this.jhJ != null)) {
            this.iqR.be(i);
            if (this.isFullScreen) {
                if (this.iqR.rd()) {
                    this.jhJ.dxp();
                } else {
                    this.jhJ.Ss();
                }
                return true;
            }
        }
        return this.jhJ.GS(i);
    }

    public void stopVideo() {
        this.jGK = false;
        this.jhJ.stopPlay();
        if (this.jGE != null) {
            this.jGE.setVisibility(0);
        }
        if (this.jGP != null) {
            this.jGP.AB(2);
        }
        rw(false);
        this.jGJ = true;
        if (this.iqR != null && this.iqR.re()) {
            this.iqR.stop();
        }
    }

    public void cKN() {
        this.iqR.stop();
    }

    public void cEa() {
        if (this.jhJ != null) {
            this.jhJ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cEa();
        if (this.jhL != null) {
            this.jhL.cEk();
        }
        if (this.jGL != null) {
            this.jGL.clearAnimation();
        }
        this.iqR.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.jik != null) {
            this.akj.setText(TextUtils.isEmpty(gVar.jik.userNickname) ? gVar.jik.userName : gVar.jik.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jik != null) {
            if (gVar.jik.jiu != null && !TextUtils.isEmpty(gVar.jik.jiu.avatar)) {
                this.jhB.startLoad(gVar.jik.jiu.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.jik.portrait) && gVar.jik.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jhB.startLoad(gVar.jik.portrait, 10, false);
            } else {
                this.jhB.startLoad(gVar.jik.portrait, 12, false);
            }
            if (gVar.jik.jiu != null && gVar.jik.jiu.auth_id.intValue() > 0) {
                this.jhB.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.jik.jiu.auth_id.intValue(), 1));
                this.jhB.setShowV(true);
                this.jhB.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jhB.setBjhAuthIconRes(0);
            if (gVar.jik.isBigV) {
                this.jhB.setShowV(gVar.jik.isBigV);
                this.jhB.setIsBigV(gVar.jik.isBigV);
            } else if (gVar.jik.isGod) {
                this.jhB.setShowV(gVar.jik.isGod);
                this.jhB.setIsBigV(gVar.jik.isGod);
            } else {
                this.jhB.setShowV(gVar.jik.isGod);
                this.jhB.setIsBigV(gVar.jik.isGod);
            }
            this.jhB.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(final com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bpr() != null) {
                gVar.bpr().isInThread = true;
                gVar.bpr().nid = gVar.nid;
                if (this.jhK.getVideoType() == 1) {
                    gVar.bpr().cardType = 2;
                } else if (this.jhK.getVideoType() == 2) {
                    gVar.bpr().cardType = 8;
                } else if (this.jhK.getVideoType() == 3) {
                    gVar.bpr().cardType = 6;
                }
                gVar.bpr().baijiahaoData = gVar.mBaijiahao;
                gVar.bpr().recomSource = gVar.source;
                gVar.bpr().recomWeight = gVar.weight;
                gVar.bpr().recomAbTag = gVar.abtest_tag;
                gVar.bpr().recomExtra = gVar.extra;
            }
            this.fhD.setAgreeAlone(true);
            this.fhD.setIsFromMiddlePage(true);
            this.fhD.setData(gVar.bpr());
            this.fhD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (gVar.bpr().hasAgree && gVar.bpr().agreeType == 2) {
                        a.this.jGP.AB(0);
                    }
                }
            });
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eGx.setTextColor(ao.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fhF, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.eGx.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.eGx.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.iOg.setTextColor(ao.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fhI, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.iOg.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.iOg.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jhJ != null && this.jhv != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jhO) {
                this.jhJ.dxv();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cKP();
            } else {
                configuration.orientation = 1;
                cKQ();
                this.jhO = true;
            }
            this.jhJ.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKO() {
        if (this.jhJ != null && this.jhv != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jhv.getParent() != null) {
                if (this.jhv.getParent() == frameLayout) {
                    if (this.jGU) {
                        this.jGU = false;
                        return true;
                    } else if (!this.jGV) {
                        this.jGV = true;
                        return true;
                    }
                } else if (this.jhv.getParent() == this.jhu) {
                    if (this.jGV) {
                        this.jGV = false;
                        this.jGW = true;
                        return true;
                    } else if (!this.jGU && this.jGW) {
                        this.jGU = true;
                        this.jGW = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKP() {
        if (this.jhJ != null && this.jhv != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.jhv.getParent() != null) {
                if (this.jhv.getParent() == frameLayout) {
                    frameLayout.removeView(this.jhv);
                } else if (this.jhv.getParent() == this.jhu) {
                    this.jhu.removeView(this.jhv);
                }
            }
            if (this.jhv.getParent() == null) {
                frameLayout.addView(this.jhv);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jhv.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jhv.setLayoutParams(layoutParams);
                if (this.jGS != null && this.jGS.isShowing()) {
                    this.jGS.dismiss();
                }
                com.baidu.tbadk.util.d.bEN().lr(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKQ() {
        if (this.jhJ != null && this.jhv != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.jhv.getParent() != null) {
                if (this.jhv.getParent() == frameLayout) {
                    cKR();
                    frameLayout.removeView(this.jhv);
                } else if (this.jhv.getParent() == this.jhu) {
                    cKR();
                    this.jhu.removeView(this.jhv);
                }
            }
            if (this.jhv.getParent() == null) {
                this.jhu.addView(this.jhv, 0);
                cKS();
                this.jhJ.daq();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.bEN().lr(false);
            }
        }
    }

    private void cKR() {
        if (this.iqR != null && this.iqR.re()) {
            this.iqR.az(true);
        }
    }

    private void cKS() {
        int i;
        if (!cKK()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.jhv.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cqL() != null) {
            view.setTag(this);
            cqL().a(view, this.jhK);
        }
        if (view == this.jhB || view == this.akj) {
            if (this.jhK != null && this.jhK.jik != null && !TextUtils.isEmpty(this.jhK.jik.userId)) {
                this.jGP.AB(0);
                if (!TbadkCoreApplication.isLogin() || !this.jhK.jik.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jhK.jik.userId, 0L), z, this.jhK.jik.isGod)));
            }
        } else if (view == this.fhG) {
            if (this.jhK != null) {
                this.jGP.AB(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jhK.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.jhK.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jGE || view == this.jGF) {
            if (this.jhK != null) {
                if (this.jGP.getCurrentState() != 2 && this.jGP.getCurrentState() != 3) {
                    z = false;
                }
                this.jGP.AB(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.jhK.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.jhK.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.fhJ) {
            this.jGP.AB(0);
            bul();
        } else if (view == this.jGL && this.jGL.getVisibility() == 0 && this.jGN != null) {
            this.jGN.AF(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qM(boolean z) {
        if (this.jhK != null && this.jhK.jik != null) {
            this.jhK.jik.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cEb() {
        if (this.jhK != null) {
            this.fhD.btr();
        }
    }

    public void rv(boolean z) {
        if (this.jhu != null) {
            this.jhu.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jGT = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jGN = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.aaN = fVar;
    }

    private void rw(boolean z) {
        this.jGJ = this.mPosition == (this.jGO == null ? -1 : this.jGO.cLe());
        if (this.jGJ && z && isPlaying() && this.eUP && !this.jGK) {
            this.jGG.setVisibility(0);
            this.jGK = true;
            this.jGG.postDelayed(this.jGZ, 5000L);
            if (this.jGO != null) {
                this.jGO.gt(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jGG.setVisibility(8);
        if (this.jGZ != null) {
            this.jGG.removeCallbacks(this.jGZ);
        }
    }

    private void bul() {
        String str;
        String str2;
        if (this.jhK != null && this.mContext != null) {
            String valueOf = String.valueOf(this.jhK.forumId);
            String str3 = this.jhK.title;
            if (this.jhK.mBaijiahao != null) {
                str = this.jhK.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.jhK.mBaijiahao.oriUgcType + "&dvid=" + this.jhK.mBaijiahao.oriUgcVid + "&nid=" + this.jhK.mBaijiahao.oriUgcNid;
            } else {
                str = this.jhK.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.jhK.jil.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.jhK.title;
            String format = (this.jhK.mBaijiahao == null || this.jhK.jik == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.jhK.jik.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.jhK.mBaijiahao != null) {
                shareItem.fsD = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fsD = str6;
                shareItem.readCount = this.jhK.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fsG = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fss = true;
            shareItem.fsF = 11;
            if (this.jhK.getVideoType() == 1) {
                shareItem.fsK = 2;
            } else if (this.jhK.getVideoType() == 2) {
                shareItem.fsK = 8;
            } else if (this.jhK.getVideoType() == 3) {
                shareItem.fsK = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.jhK.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.jhK.mBaijiahao;
            shareItem.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dW("tid", str);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.an("obj_locate", 12);
            aqVar.dW(IntentConfig.NID, this.jhK.nid);
            if (this.jhK.mBaijiahao != null && !at.isEmpty(this.jhK.mBaijiahao.oriUgcVid)) {
                aqVar.dW("obj_param6", this.jhK.mBaijiahao.oriUgcVid);
            }
            if (this.jhK.getVideoType() == 1) {
                aqVar.an(IntentConfig.CARD_TYPE, 2);
            } else if (this.jhK.getVideoType() == 2) {
                aqVar.an(IntentConfig.CARD_TYPE, 8);
            } else if (this.jhK.getVideoType() == 3) {
                aqVar.an(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dW(IntentConfig.RECOM_SOURCE, this.jhK.source);
            aqVar.dW("ab_tag", this.jhK.abtest_tag);
            aqVar.dW("weight", this.jhK.weight);
            aqVar.dW("extra", this.jhK.extra);
            aqVar.dW("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dW("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dW("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fsG);
            bundle.putInt("obj_type", shareItem.fsK);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eRW);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.csn().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        stopVideo();
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aQJ() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx(boolean z) {
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

    public void cKT() {
        this.iqR.resume();
    }

    public boolean cKU() {
        if (this.jGP != null) {
            return this.jGP.getCurrentState() == 2 || this.jGP.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0736a {
        private int cqj;
        private Runnable jHe;

        private C0736a() {
            this.cqj = -1;
            this.jHe = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(C0736a.this.jHe);
                    C0736a.this.AB(2);
                }
            };
        }

        public void AB(int i) {
            switch (i) {
                case 0:
                    this.cqj = AC(i);
                    cKV();
                    return;
                case 1:
                    this.cqj = AC(i);
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jHe);
                    return;
                case 2:
                    this.cqj = AD(i);
                    return;
                case 3:
                    this.cqj = AE(i);
                    cKV();
                    return;
                default:
                    this.cqj = AD(i);
                    return;
            }
        }

        private void cKV() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jHe);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jHe, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.cqj;
        }

        private int AC(int i) {
            if (i != this.cqj) {
                a.this.jGM.setVisibility(8);
                a.this.rx(true);
                return i;
            }
            return this.cqj;
        }

        private int AD(int i) {
            int i2 = this.cqj;
            if (i != this.cqj) {
                a.this.jGM.setVisibility(0);
                if (i2 != 3 || a.this.jhK.autoPlay) {
                    a.this.rx(false);
                    return i;
                }
                return i;
            }
            return this.cqj;
        }

        private int AE(int i) {
            if (i != this.cqj) {
                a.this.jGM.setVisibility(0);
                a.this.rx(true);
                return i;
            }
            return this.cqj;
        }
    }
}
