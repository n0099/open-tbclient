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
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f Zf;
    public TextView aju;
    private Animation bSB;
    private Animation bSC;
    private boolean eDB;
    protected AgreeView eQk;
    private ImageView eQl;
    private View eQm;
    private TextView eQn;
    private ImageView eQo;
    private View eQp;
    private TextView eqt;
    private String eve;
    private com.baidu.afd.videopaster.d hRH;
    public com.baidu.tieba.play.c iIB;
    public com.baidu.tieba.frs.aggregation.g iIC;
    private com.baidu.tieba.frs.aggregation.h iID;
    private o iIE;
    private o iIF;
    private boolean iIG;
    private boolean iIH;
    private boolean iIK;
    public FrameLayout iIm;
    public FrameLayout iIn;
    public HeadImageView iIt;
    private int iio;
    private boolean isFullScreen;
    private FrameLayout jeA;
    private TextView jeB;
    private boolean jeC;
    private boolean jeD;
    private boolean jeE;
    private View jeF;
    private View jeG;
    private c jeH;
    public com.baidu.tieba.frs.videomiddlepage.a.a jeI;
    private C0722a jeJ;
    private VideoNetworkStateTipView jeK;
    private b jeL;
    private com.baidu.mcn.c jeM;
    private com.baidu.tieba.lego.card.view.g jeN;
    private boolean jeO;
    private boolean jeP;
    private boolean jeQ;
    private Animation.AnimationListener jeR;
    private Animation.AnimationListener jeS;
    private Runnable jeT;
    private Runnable jeU;
    public ExpandableTextView jey;
    private View jez;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.iIG = true;
        this.iIK = true;
        this.jeD = false;
        this.jeE = false;
        this.jeO = false;
        this.jeP = false;
        this.jeQ = false;
        this.startPosition = -1L;
        this.iio = 0;
        this.jeR = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jeF != null) {
                    a.this.jeF.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jeF != null) {
                    a.this.jeF.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jeS = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jeF != null) {
                    a.this.jeF.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jeF != null) {
                    a.this.jeF.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jeT = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jeA.getVisibility() == 0) {
                    a.this.jeA.setVisibility(8);
                }
            }
        };
        this.jeU = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iIB != null) {
                    a.this.iIB.stopPlay();
                }
            }
        };
        this.iIK = z;
        this.mFrom = str;
        this.eve = str2;
        this.jeL = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iIm = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jez = view.findViewById(R.id.card_container);
        this.iIn = (FrameLayout) view.findViewById(R.id.video_container);
        this.iIB = new com.baidu.tieba.play.c(tbPageContext, this.iIn, false);
        this.iIB.setStageType("2005");
        this.iIB.wa(z);
        this.iIB.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jeI != null && a.this.iIC.iJc.videoDuration > 8) {
                    a.this.jeI.br(a.this.mPosition, a.this.iIC.iJc.videoUrl);
                }
            }
        });
        this.iIB.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void qq(boolean z2) {
                if (a.this.jeJ != null) {
                    if (z2) {
                        a.this.jeJ.Av(0);
                    } else {
                        a.this.jeJ.Av(1);
                    }
                }
            }
        });
        this.iIB.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jey = (ExpandableTextView) view.findViewById(R.id.title);
        this.iIt = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aju = (TextView) view.findViewById(R.id.user_name);
        this.eQk = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etB = 2;
        cVar.etG = 6;
        this.eQk.setStatisticData(cVar);
        this.eqt = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eQl = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eQm = view.findViewById(R.id.thread_info_commont_container);
        this.eQn = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.eQo = (ImageView) view.findViewById(R.id.share_num_img);
        this.eQp = view.findViewById(R.id.share_num_container);
        this.jeA = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jeB = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jeA.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jeB.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bnH().getString("nani_key_download_link_url", null);
        this.jeB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.boR().a((TbPageContext) i.I(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jeK = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jeK.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.jeK.setHasAgreeToPlay(true);
                a.this.iIB.wg(false);
                a.this.jeK.dPl();
                if (a.this.hRH.rA()) {
                    a.this.hRH.resume();
                } else if (a.this.iIC != null && a.this.iIC.iJc != null) {
                    a.this.iIB.fW(a.this.iIC.iJc.videoUrl, a.this.iIC.threadId);
                }
            }
        });
        this.jeF = view.findViewById(R.id.video_agg_container_foreground);
        this.jeG = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jeF.setOnClickListener(this);
        this.eQm.setOnClickListener(this);
        this.eQp.setOnClickListener(this);
        this.jey.setOnClickListener(this);
        this.iIt.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.jez.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.iio = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iIm.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iIm.setLayoutParams(layoutParams);
        this.iIt.setIsRound(true);
        this.iIt.setPlaceHolder(1);
        this.iID = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bSB = new AlphaAnimation(0.0f, 0.7f);
        this.bSB.setDuration(500L);
        this.bSB.setAnimationListener(this.jeS);
        this.bSC = new AlphaAnimation(0.7f, 0.0f);
        this.bSC.setDuration(500L);
        this.bSC.setAnimationListener(this.jeR);
        this.jeJ = new C0722a();
        this.hRH = new com.baidu.afd.videopaster.d(getContext(), this.iIn);
        this.jeM = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eQk.onChangeSkinType(i);
        this.eqt.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.eQn.setTextColor(ap.getColor(R.color.cp_cont_d));
        SvgManager.boN().a(this.eQl, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.boN().a(this.eQo, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jey.onChangeSkinType();
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
        if (gVar != null && gVar.iJc != null) {
            boolean z = this.iIC == gVar;
            this.iIC = gVar;
            this.eDB = this.iIC.autoPlay;
            this.jeE = false;
            qo(false);
            this.jey.setVisibility(0);
            this.jey.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jey.setTextColor(R.color.cp_cont_a);
            this.jey.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.iJc != null && !StringUtils.isNull(gVar.iJc.mcnLeadPage)) {
                this.jey.setTextMaxLine(2);
                this.jey.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jey.getContentView(), gVar.title, gVar.iJc.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jey.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.jey.setExpandable(true);
                this.jey.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void qr(boolean z2) {
                        a.this.iIC.isTitleExpanded = z2;
                    }
                });
                this.jey.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.iio) {
                this.iIB.duo();
                this.iio = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.iIn.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iIn.setLayoutParams(layoutParams);
            }
            cEd();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.iIC = gVar;
        this.eDB = this.iIC.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cEc() {
        try {
            int parseInt = Integer.parseInt(this.iIC.iJc.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.iIC.iJc.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cEd() {
        if (!cEc()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iIm.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iIm.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iIm.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iIm.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.iJc != null) {
            this.iIB.stopPlay();
            this.iIB.wh(true);
            this.iIB.wd(true);
            this.iIB.wi(true);
            this.iIB.ay(false, false);
            this.iIB.He(i);
            this.iIB.a(new c.InterfaceC0812c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rI() {
                    a.this.cEh();
                    if (a.this.hRH != null) {
                        a.this.hRH.rI();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rJ() {
                    a.this.cEi();
                    if (a.this.iIB.rK()) {
                    }
                    if (a.this.iIH || (a.this.hRH != null && a.this.hRH.rA())) {
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(a.this.jeU);
                        com.baidu.adp.lib.f.e.mY().post(a.this.jeU);
                    }
                    if (a.this.hRH != null) {
                        a.this.hRH.rJ();
                    }
                }
            });
            this.iIB.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void cyE() {
                    if (a.this.iIC != null && a.this.iIC.iJc != null && com.baidu.adp.lib.f.b.toInt(a.this.iIC.iJc.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.iIC.iJc.videoWidth, 0)) {
                        a.this.iIB.ay(false, false);
                    } else {
                        a.this.iIB.ay(true, false);
                    }
                    a.this.iIH = false;
                    a.this.Ke(a.this.eDB ? "1" : "2");
                    a.this.onClick(a.this.iIn);
                    if (a.this.Zf != null) {
                        a.this.Zf.a(a.this);
                    }
                    if (a.this.jeN != null) {
                        a.this.jeN.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cyF() {
                    a.this.onClick(a.this.iIm);
                }
            });
            this.iIB.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void pK(boolean z2) {
                    a.this.iIB.fW(a.this.iIC.iJc.videoUrl, a.this.iIC.threadId);
                    a.this.Ke("2");
                    a.this.onClick(a.this.iIn);
                }
            });
            this.iIB.vZ(false);
            if (this.jeM != null) {
                this.jeM.reset();
            }
            this.startPosition = -1L;
            if (this.iIB.getVideoView() != null && this.iIB.getVideoView().getMediaProgressObserver() != null) {
                this.iIB.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void cc(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.iIC.iJc.iJm;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.hRH.a(a.this.isFullScreen, a.this.iIB != null && a.this.iIB.dtV(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.hRH.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.iIB.dtV() && !com.baidu.mcn.b.Xq().iZ(aVar2.Zu)) {
                            boolean z3 = a.this.startPosition >= (aVar2.iJe * 1000) + 1000;
                            if (i3 < aVar2.iJe * 1000 || i3 >= aVar2.iJf * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jeM.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bSo = aVar2.iJh;
                                    aVar3.bSp = aVar2.iJi;
                                    aVar3.bSq = aVar2.Zu;
                                    aVar3.bSn = aVar2.iJg;
                                    aVar3.fid = a.this.iIC != null ? a.this.iIC.forumId : null;
                                    aVar3.tid = a.this.iIC != null ? a.this.iIC.threadId : null;
                                    aVar3.bSr = 3;
                                    if (z3) {
                                        a.this.jeM.b(aVar3, (ViewGroup) a.this.iIB.dun());
                                    } else {
                                        a.this.jeM.a(aVar3, (ViewGroup) a.this.iIB.dun());
                                    }
                                }
                            } else if (a.this.jeM.isShowing()) {
                                a.this.jeM.dismiss();
                            }
                        }
                    }
                });
            }
            this.iIE = new o();
            this.iIE.alT = gVar.threadId;
            this.iIE.mNid = gVar.nid;
            this.iIE.fsZ = gVar.forumId;
            this.iIE.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iIE.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.iIE.mSource = gVar.source;
            this.iIE.mdS = gVar.weight;
            this.iIE.mdU = this.mFrom;
            this.iIE.mdW = gVar.abtest_tag;
            this.iIE.eve = this.eve;
            this.iIE.mExtra = gVar.extra;
            this.iIE.mdZ = "0";
            this.iIE.mdV = gVar.getVideoType();
            this.iIF = new o();
            this.iIF.alT = gVar.threadId;
            this.iIF.fsZ = gVar.forumId;
            this.iIF.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iIF.mdS = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iIF.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iIF.mdU = this.mFrom;
            this.iIF.mSource = gVar.source;
            this.iIF.mdZ = "0";
            if (gVar.iJc != null) {
                this.iIE.mdX = gVar.iJc.videoMd5;
                this.iIF.mdX = gVar.iJc.videoMd5;
            }
            aq aqVar = new aq("c12590");
            aqVar.dR("tid", gVar.threadId);
            aqVar.dR("nid", gVar.nid);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", i);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dR("fid", gVar.forumId);
            aqVar.dR("obj_param1", at.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aqVar.dR("extra", at.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aqVar.dR("obj_id", this.eve);
            aqVar.dR("ab_tag", at.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aqVar.dR("obj_type", this.mFrom);
            aqVar.aj("obj_param5", gVar.getVideoType());
            aqVar.dR("obj_source", at.isEmpty(gVar.source) ? "0" : gVar.source);
            aqVar.aj("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aqVar.dR("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aqVar.dR("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aqVar);
            this.iIB.getVideoView().setVideoStatData(this.iIE);
            this.iIB.cXn();
            this.iIB.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.hRH.a(a.this.isFullScreen, a.this.iIB != null && a.this.iIB.dtV(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.iIH = true;
                            a.this.jeC = true;
                            a.this.iIG = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.yY(i);
                            a.this.iIB.cJS();
                        }
                    }
                }
            });
            this.iIB.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.iIC != null && a.this.iIC.iJc != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.iIC.iJc.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.hRH.reset();
            }
            this.hRH.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rR() {
                    a.this.jeC = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rQ() {
                    if (a.this.isFullScreen) {
                        a.this.iIH = true;
                        a.this.jeC = true;
                        a.this.iIG = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.yY(i);
                        a.this.iIB.cJS();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rP() {
                    if (a.this.iIB != null) {
                        a.this.iIB.Hd(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rS() {
                    return a.this.cEg();
                }
            });
            this.iIB.setThumbnail(gVar.iJc.thumbnailUrl);
            this.iIB.Hc(gVar.iJc.videoDuration);
            this.iIB.setVideoUrl(gVar.iJc.videoUrl, gVar.threadId);
            this.iIB.setFid(gVar.forumId);
            this.iIB.cJS();
            this.iIB.show();
            qo(false);
            if (gVar.autoPlay) {
                onClick(this.iIn);
                if (this.jeK.dpO()) {
                    this.iIB.wf(false);
                    this.jeK.dPk();
                    this.iIB.wg(true);
                    this.iIB.fV(gVar.iJc.videoUrl, gVar.threadId);
                    if (this.hRH.rA()) {
                        this.hRH.stop();
                        this.hRH.rF();
                    }
                } else {
                    this.iIB.wg(false);
                    this.iIB.wf(false);
                    this.jeK.hide();
                    if (this.hRH == null || (this.hRH != null && !this.hRH.rA())) {
                        this.iIB.a(gVar.iJc.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.iJd) {
                    this.jeF.setVisibility(8);
                    this.jeJ.Av(3);
                } else {
                    if (this.jeF.getVisibility() == 0) {
                        this.jeF.startAnimation(this.bSC);
                    }
                    this.jeJ.Av(0);
                }
                gVar.iJd = false;
            } else {
                this.jeF.setVisibility(0);
                this.jeK.hide();
                this.iIB.wf(true);
                this.jeJ.Av(3);
                this.iIB.fV(gVar.iJc.videoUrl, gVar.threadId);
            }
            this.iIH = false;
            this.jeC = false;
            if (!z && this.hRH.rA()) {
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
        com.baidu.afd.videopaster.data.b KM = this.jeL != null ? this.jeL.KM(gVar.getThreadId()) : null;
        if (KM == null) {
            return null;
        }
        int rW = KM.rW();
        int rX = KM.rX();
        int rV = KM.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.iJc != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.iJc.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.iJc.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", rV + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke(String str) {
        if (this.iIC != null && this.iIC.iJc != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iIC.iJc.videoMd5, "", str, this.iIF, this.iIB.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iIB.rK();
    }

    public boolean cEe() {
        return this.hRH.rA();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iIB.aNl();
        }
    }

    public boolean yZ(int i) {
        if (i == 4 && this.hRH != null && ((this.hRH.rA() || this.jeC) && this.iIB != null)) {
            this.hRH.aZ(i);
            if (this.isFullScreen) {
                if (this.hRH.rz()) {
                    this.iIB.dtW();
                } else {
                    this.iIB.QI();
                }
                return true;
            }
        }
        return this.iIB.Hd(i);
    }

    public void cyB() {
        this.jeE = false;
        this.iIB.stopPlay();
        if (this.jey != null) {
            this.jey.setVisibility(0);
        }
        if (this.jeJ != null) {
            this.jeJ.Av(2);
        }
        qo(false);
        this.jeD = true;
        if (this.hRH != null && this.hRH.rA()) {
            this.hRH.stop();
        }
    }

    public void cEf() {
        this.hRH.stop();
    }

    public void cyC() {
        if (this.iIB != null) {
            this.iIB.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cyC();
        if (this.iID != null) {
            this.iID.cyM();
        }
        if (this.jeF != null) {
            this.jeF.clearAnimation();
        }
        this.hRH.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.iJb != null) {
            this.aju.setText(TextUtils.isEmpty(gVar.iJb.userNickname) ? gVar.iJb.userName : gVar.iJb.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.iJb != null) {
            if (gVar.iJb.iJl != null && !TextUtils.isEmpty(gVar.iJb.iJl.avatar)) {
                this.iIt.startLoad(gVar.iJb.iJl.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.iJb.portrait) && gVar.iJb.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iIt.startLoad(gVar.iJb.portrait, 10, false);
            } else {
                this.iIt.startLoad(gVar.iJb.portrait, 12, false);
            }
            if (gVar.iJb.iJl != null && gVar.iJb.iJl.auth_id.intValue() > 0) {
                this.iIt.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.iJb.iJl.auth_id.intValue(), 1));
                this.iIt.setShowV(true);
                this.iIt.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.iIt.setBjhAuthIconRes(0);
            if (gVar.iJb.isBigV) {
                this.iIt.setShowV(gVar.iJb.isBigV);
                this.iIt.setIsBigV(gVar.iJb.isBigV);
            } else if (gVar.iJb.isGod) {
                this.iIt.setShowV(gVar.iJb.isGod);
                this.iIt.setIsBigV(gVar.iJb.isGod);
            } else {
                this.iIt.setShowV(gVar.iJb.isGod);
                this.iIt.setIsBigV(gVar.iJb.isGod);
            }
            this.iIt.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.blR() != null) {
                gVar.blR().isInThread = true;
                gVar.blR().nid = gVar.nid;
                if (this.iIC.getVideoType() == 1) {
                    gVar.blR().cardType = 2;
                } else if (this.iIC.getVideoType() == 2) {
                    gVar.blR().cardType = 8;
                } else if (this.iIC.getVideoType() == 3) {
                    gVar.blR().cardType = 6;
                }
                gVar.blR().baijiahaoData = gVar.mBaijiahao;
                gVar.blR().recomSource = gVar.source;
                gVar.blR().recomWeight = gVar.weight;
                gVar.blR().recomAbTag = gVar.abtest_tag;
                gVar.blR().recomExtra = gVar.extra;
            }
            if (this.iIC.mBaijiahao != null) {
                this.eQk.setAgreeAlone(true);
            }
            this.eQk.setIsFromMiddlePage(true);
            this.eQk.setData(gVar.blR());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eqt.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.boN().a(this.eQl, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.eqt.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.eqt.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eQn.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.boN().a(this.eQo, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.eQn.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.eQn.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iIB != null && this.iIn != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iIG) {
                this.iIB.duc();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cEh();
            } else {
                configuration.orientation = 1;
                cEi();
                this.iIG = true;
            }
            this.iIB.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cEg() {
        if (this.iIB != null && this.iIn != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iIn.getParent() != null) {
                if (this.iIn.getParent() == frameLayout) {
                    if (this.jeO) {
                        this.jeO = false;
                        return true;
                    } else if (!this.jeP) {
                        this.jeP = true;
                        return true;
                    }
                } else if (this.iIn.getParent() == this.iIm) {
                    if (this.jeP) {
                        this.jeP = false;
                        this.jeQ = true;
                        return true;
                    } else if (!this.jeO && this.jeQ) {
                        this.jeO = true;
                        this.jeQ = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEh() {
        if (this.iIB != null && this.iIn != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.iIn.getParent() != null) {
                if (this.iIn.getParent() == frameLayout) {
                    frameLayout.removeView(this.iIn);
                } else if (this.iIn.getParent() == this.iIm) {
                    this.iIm.removeView(this.iIn);
                }
            }
            if (this.iIn.getParent() == null) {
                frameLayout.addView(this.iIn);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iIn.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iIn.setLayoutParams(layoutParams);
                if (this.jeM != null && this.jeM.isShowing()) {
                    this.jeM.dismiss();
                }
                com.baidu.tbadk.util.e.bAR().kw(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEi() {
        if (this.iIB != null && this.iIn != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.iIn.getParent() != null) {
                if (this.iIn.getParent() == frameLayout) {
                    cEj();
                    frameLayout.removeView(this.iIn);
                } else if (this.iIn.getParent() == this.iIm) {
                    cEj();
                    this.iIm.removeView(this.iIn);
                }
            }
            if (this.iIn.getParent() == null) {
                this.iIm.addView(this.iIn, 0);
                cEk();
                this.iIB.cXn();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bAR().kw(false);
            }
        }
    }

    private void cEj() {
        if (this.hRH != null && this.hRH.rA()) {
            this.hRH.aB(true);
        }
    }

    private void cEk() {
        int i;
        if (!cEc()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.iIn.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cls() != null) {
            view.setTag(this);
            cls().a(view, this.iIC);
        }
        if (view == this.iIt || view == this.aju) {
            if (this.iIC != null && this.iIC.iJb != null && !TextUtils.isEmpty(this.iIC.iJb.userId)) {
                this.jeJ.Av(0);
                if (!TbadkCoreApplication.isLogin() || !this.iIC.iJb.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iIC.iJb.userId, 0L), z, this.iIC.iJb.isGod)));
            }
        } else if (view == this.eQm) {
            if (this.iIC != null) {
                this.jeJ.Av(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iIC.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.iIC.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jey || view == this.jez) {
            if (this.iIC != null) {
                if (this.jeJ.getCurrentState() != 2 && this.jeJ.getCurrentState() != 3) {
                    z = false;
                }
                this.jeJ.Av(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.iIC.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.iIC.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.eQp) {
            this.jeJ.Av(0);
            bqt();
        } else if (view == this.jeF && this.jeF.getVisibility() == 0 && this.jeH != null) {
            this.jeH.Az(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pJ(boolean z) {
        if (this.iIC != null && this.iIC.iJb != null) {
            this.iIC.iJb.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cyD() {
        if (this.iIC != null) {
            this.eQk.bpE();
        }
    }

    public void qn(boolean z) {
        if (this.iIm != null) {
            this.iIm.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jeN = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jeH = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Zf = fVar;
    }

    private void qo(boolean z) {
        this.jeD = this.mPosition == (this.jeI == null ? -1 : this.jeI.cEw());
        if (this.jeD && z && isPlaying() && this.eDB && !this.jeE) {
            this.jeA.setVisibility(0);
            this.jeE = true;
            this.jeA.postDelayed(this.jeT, 5000L);
            if (this.jeI != null) {
                this.jeI.fp(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jeA.setVisibility(8);
        if (this.jeT != null) {
            this.jeA.removeCallbacks(this.jeT);
        }
    }

    private void bqt() {
        String str;
        String str2;
        if (this.iIC != null && this.mContext != null) {
            String valueOf = String.valueOf(this.iIC.forumId);
            String str3 = this.iIC.title;
            if (this.iIC.mBaijiahao != null) {
                str = this.iIC.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.iIC.mBaijiahao.oriUgcType + "&dvid=" + this.iIC.mBaijiahao.oriUgcVid + "&nid=" + this.iIC.mBaijiahao.oriUgcNid;
            } else {
                str = this.iIC.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.iIC.iJc.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.iIC.title;
            String format = (this.iIC.mBaijiahao == null || this.iIC.iJb == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.iIC.iJb.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.iIC.mBaijiahao != null) {
                shareItem.fbd = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fbd = str6;
                shareItem.readCount = this.iIC.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fbg = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.faS = true;
            shareItem.fbf = 11;
            if (this.iIC.getVideoType() == 1) {
                shareItem.fbk = 2;
            } else if (this.iIC.getVideoType() == 2) {
                shareItem.fbk = 8;
            } else if (this.iIC.getVideoType() == 3) {
                shareItem.fbk = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.iIC.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.iIC.mBaijiahao;
            shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dR("tid", str);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.aj("obj_locate", 12);
            aqVar.dR("nid", this.iIC.nid);
            if (this.iIC.mBaijiahao != null && !at.isEmpty(this.iIC.mBaijiahao.oriUgcVid)) {
                aqVar.dR("obj_param6", this.iIC.mBaijiahao.oriUgcVid);
            }
            if (this.iIC.getVideoType() == 1) {
                aqVar.aj(IntentConfig.CARD_TYPE, 2);
            } else if (this.iIC.getVideoType() == 2) {
                aqVar.aj(IntentConfig.CARD_TYPE, 8);
            } else if (this.iIC.getVideoType() == 3) {
                aqVar.aj(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dR(IntentConfig.RECOM_SOURCE, this.iIC.source);
            aqVar.dR("ab_tag", this.iIC.abtest_tag);
            aqVar.dR("weight", this.iIC.weight);
            aqVar.dR("extra", this.iIC.extra);
            aqVar.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fbg);
            bundle.putInt("obj_type", shareItem.fbk);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eBz);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.cmU().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        cyB();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aNl() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp(boolean z) {
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

    public void cEl() {
        this.hRH.resume();
    }

    public boolean cEm() {
        if (this.jeJ != null) {
            return this.jeJ.getCurrentState() == 2 || this.jeJ.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0722a {
        private int cdn;
        private Runnable jeY;

        private C0722a() {
            this.cdn = -1;
            this.jeY = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(C0722a.this.jeY);
                    C0722a.this.Av(2);
                }
            };
        }

        public void Av(int i) {
            switch (i) {
                case 0:
                    this.cdn = Aw(i);
                    cEn();
                    return;
                case 1:
                    this.cdn = Aw(i);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jeY);
                    return;
                case 2:
                    this.cdn = Ax(i);
                    return;
                case 3:
                    this.cdn = Ay(i);
                    cEn();
                    return;
                default:
                    this.cdn = Ax(i);
                    return;
            }
        }

        private void cEn() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jeY);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jeY, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.cdn;
        }

        private int Aw(int i) {
            if (i != this.cdn) {
                a.this.jeG.setVisibility(8);
                a.this.qp(true);
                return i;
            }
            return this.cdn;
        }

        private int Ax(int i) {
            int i2 = this.cdn;
            if (i != this.cdn) {
                a.this.jeG.setVisibility(0);
                if (i2 != 3 || a.this.iIC.autoPlay) {
                    a.this.qp(false);
                    return i;
                }
                return i;
            }
            return this.cdn;
        }

        private int Ay(int i) {
            if (i != this.cdn) {
                a.this.jeG.setVisibility(0);
                a.this.qp(true);
                return i;
            }
            return this.cdn;
        }
    }
}
