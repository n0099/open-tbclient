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
    private Animation bYl;
    private Animation bYm;
    private String eAX;
    private boolean eJq;
    protected AgreeView eVZ;
    private ImageView eWa;
    private View eWb;
    private TextView eWc;
    private ImageView eWd;
    private View eWe;
    private TextView ewm;
    private com.baidu.afd.videopaster.d hXE;
    private com.baidu.tieba.frs.aggregation.h iOA;
    private o iOB;
    private o iOC;
    private boolean iOD;
    private boolean iOE;
    private boolean iOH;
    public FrameLayout iOj;
    public FrameLayout iOk;
    public HeadImageView iOq;
    public com.baidu.tieba.play.c iOy;
    public com.baidu.tieba.frs.aggregation.g iOz;
    private int ion;
    private boolean isFullScreen;
    private boolean jkA;
    private boolean jkB;
    private boolean jkC;
    private View jkD;
    private View jkE;
    private c jkF;
    public com.baidu.tieba.frs.videomiddlepage.a.a jkG;
    private C0736a jkH;
    private VideoNetworkStateTipView jkI;
    private b jkJ;
    private com.baidu.mcn.c jkK;
    private com.baidu.tieba.lego.card.view.g jkL;
    private boolean jkM;
    private boolean jkN;
    private boolean jkO;
    private Animation.AnimationListener jkP;
    private Animation.AnimationListener jkQ;
    private Runnable jkR;
    private Runnable jkS;
    public ExpandableTextView jkw;
    private View jkx;
    private FrameLayout jky;
    private TextView jkz;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.iOD = true;
        this.iOH = true;
        this.jkB = false;
        this.jkC = false;
        this.jkM = false;
        this.jkN = false;
        this.jkO = false;
        this.startPosition = -1L;
        this.ion = 0;
        this.jkP = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jkD != null) {
                    a.this.jkD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jkD != null) {
                    a.this.jkD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jkQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jkD != null) {
                    a.this.jkD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jkD != null) {
                    a.this.jkD.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jkR = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jky.getVisibility() == 0) {
                    a.this.jky.setVisibility(8);
                }
            }
        };
        this.jkS = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iOy != null) {
                    a.this.iOy.stopPlay();
                }
            }
        };
        this.iOH = z;
        this.mFrom = str;
        this.eAX = str2;
        this.jkJ = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iOj = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jkx = view.findViewById(R.id.card_container);
        this.iOk = (FrameLayout) view.findViewById(R.id.video_container);
        this.iOy = new com.baidu.tieba.play.c(tbPageContext, this.iOk, false);
        this.iOy.setStageType("2005");
        this.iOy.wj(z);
        this.iOy.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jkG != null && a.this.iOz.iOZ.videoDuration > 8) {
                    a.this.jkG.bv(a.this.mPosition, a.this.iOz.iOZ.videoUrl);
                }
            }
        });
        this.iOy.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void qz(boolean z2) {
                if (a.this.jkH != null) {
                    if (z2) {
                        a.this.jkH.AI(0);
                    } else {
                        a.this.jkH.AI(1);
                    }
                }
            }
        });
        this.iOy.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jkw = (ExpandableTextView) view.findViewById(R.id.title);
        this.iOq = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aju = (TextView) view.findViewById(R.id.user_name);
        this.eVZ = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezu = 2;
        cVar.ezz = 6;
        this.eVZ.setStatisticData(cVar);
        this.ewm = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eWa = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eWb = view.findViewById(R.id.thread_info_commont_container);
        this.eWc = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.eWd = (ImageView) view.findViewById(R.id.share_num_img);
        this.eWe = view.findViewById(R.id.share_num_container);
        this.jky = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jkz = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jky.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jkz.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bqh().getString("nani_key_download_link_url", null);
        this.jkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.brr().a((TbPageContext) i.I(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jkI = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jkI.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.jkI.setHasAgreeToPlay(true);
                a.this.iOy.wp(false);
                a.this.jkI.dRN();
                if (a.this.hXE.rA()) {
                    a.this.hXE.resume();
                } else if (a.this.iOz != null && a.this.iOz.iOZ != null) {
                    a.this.iOy.fW(a.this.iOz.iOZ.videoUrl, a.this.iOz.threadId);
                }
            }
        });
        this.jkD = view.findViewById(R.id.video_agg_container_foreground);
        this.jkE = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jkD.setOnClickListener(this);
        this.eWb.setOnClickListener(this);
        this.eWe.setOnClickListener(this);
        this.jkw.setOnClickListener(this);
        this.iOq.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.jkx.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.ion = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOj.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iOj.setLayoutParams(layoutParams);
        this.iOq.setIsRound(true);
        this.iOq.setPlaceHolder(1);
        this.iOA = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bYl = new AlphaAnimation(0.0f, 0.7f);
        this.bYl.setDuration(500L);
        this.bYl.setAnimationListener(this.jkQ);
        this.bYm = new AlphaAnimation(0.7f, 0.0f);
        this.bYm.setDuration(500L);
        this.bYm.setAnimationListener(this.jkP);
        this.jkH = new C0736a();
        this.hXE = new com.baidu.afd.videopaster.d(getContext(), this.iOk);
        this.jkK = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eVZ.onChangeSkinType(i);
        this.ewm.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.eWc.setTextColor(ap.getColor(R.color.cp_cont_d));
        SvgManager.brn().a(this.eWa, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.brn().a(this.eWd, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jkw.onChangeSkinType();
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
        if (gVar != null && gVar.iOZ != null) {
            boolean z = this.iOz == gVar;
            this.iOz = gVar;
            this.eJq = this.iOz.autoPlay;
            this.jkC = false;
            qx(false);
            this.jkw.setVisibility(0);
            this.jkw.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jkw.setTextColor(R.color.cp_cont_a);
            this.jkw.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.iOZ != null && !StringUtils.isNull(gVar.iOZ.mcnLeadPage)) {
                this.jkw.setTextMaxLine(2);
                this.jkw.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jkw.getContentView(), gVar.title, gVar.iOZ.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jkw.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.jkw.setExpandable(true);
                this.jkw.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void qA(boolean z2) {
                        a.this.iOz.isTitleExpanded = z2;
                    }
                });
                this.jkw.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.ion) {
                this.iOy.dwQ();
                this.ion = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.iOk.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iOk.setLayoutParams(layoutParams);
            }
            cGE();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.iOz = gVar;
        this.eJq = this.iOz.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cGD() {
        try {
            int parseInt = Integer.parseInt(this.iOz.iOZ.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.iOz.iOZ.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cGE() {
        if (!cGD()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOj.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iOj.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iOj.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iOj.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.iOZ != null) {
            this.iOy.stopPlay();
            this.iOy.wq(true);
            this.iOy.wm(true);
            this.iOy.wr(true);
            this.iOy.ay(false, false);
            this.iOy.Hr(i);
            this.iOy.a(new c.InterfaceC0827c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rI() {
                    a.this.cGI();
                    if (a.this.hXE != null) {
                        a.this.hXE.rI();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rJ() {
                    a.this.cGJ();
                    if (a.this.iOy.rK()) {
                    }
                    if (a.this.iOE || (a.this.hXE != null && a.this.hXE.rA())) {
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(a.this.jkS);
                        com.baidu.adp.lib.f.e.mY().post(a.this.jkS);
                    }
                    if (a.this.hXE != null) {
                        a.this.hXE.rJ();
                    }
                }
            });
            this.iOy.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void cBf() {
                    if (a.this.iOz != null && a.this.iOz.iOZ != null && com.baidu.adp.lib.f.b.toInt(a.this.iOz.iOZ.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.iOz.iOZ.videoWidth, 0)) {
                        a.this.iOy.ay(false, false);
                    } else {
                        a.this.iOy.ay(true, false);
                    }
                    a.this.iOE = false;
                    a.this.Kv(a.this.eJq ? "1" : "2");
                    a.this.onClick(a.this.iOk);
                    if (a.this.Zf != null) {
                        a.this.Zf.a(a.this);
                    }
                    if (a.this.jkL != null) {
                        a.this.jkL.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cBg() {
                    a.this.onClick(a.this.iOj);
                }
            });
            this.iOy.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void pT(boolean z2) {
                    a.this.iOy.fW(a.this.iOz.iOZ.videoUrl, a.this.iOz.threadId);
                    a.this.Kv("2");
                    a.this.onClick(a.this.iOk);
                }
            });
            this.iOy.wi(false);
            if (this.jkK != null) {
                this.jkK.reset();
            }
            this.startPosition = -1L;
            if (this.iOy.getVideoView() != null && this.iOy.getVideoView().getMediaProgressObserver() != null) {
                this.iOy.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ce(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.iOz.iOZ.iPj;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.hXE.a(a.this.isFullScreen, a.this.iOy != null && a.this.iOy.dwx(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.hXE.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.iOy.dwx() && !com.baidu.mcn.b.ZP().jm(aVar2.Zu)) {
                            boolean z3 = a.this.startPosition >= (aVar2.iPb * 1000) + 1000;
                            if (i3 < aVar2.iPb * 1000 || i3 >= aVar2.iPc * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jkK.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bXY = aVar2.iPe;
                                    aVar3.bXZ = aVar2.iPf;
                                    aVar3.bYa = aVar2.Zu;
                                    aVar3.bXX = aVar2.iPd;
                                    aVar3.fid = a.this.iOz != null ? a.this.iOz.forumId : null;
                                    aVar3.tid = a.this.iOz != null ? a.this.iOz.threadId : null;
                                    aVar3.bYb = 3;
                                    if (z3) {
                                        a.this.jkK.b(aVar3, (ViewGroup) a.this.iOy.dwP());
                                    } else {
                                        a.this.jkK.a(aVar3, (ViewGroup) a.this.iOy.dwP());
                                    }
                                }
                            } else if (a.this.jkK.isShowing()) {
                                a.this.jkK.dismiss();
                            }
                        }
                    }
                });
            }
            this.iOB = new o();
            this.iOB.alT = gVar.threadId;
            this.iOB.mNid = gVar.nid;
            this.iOB.fyR = gVar.forumId;
            this.iOB.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iOB.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.iOB.mSource = gVar.source;
            this.iOB.mjR = gVar.weight;
            this.iOB.mjT = this.mFrom;
            this.iOB.mjV = gVar.abtest_tag;
            this.iOB.eAX = this.eAX;
            this.iOB.mExtra = gVar.extra;
            this.iOB.mjY = "0";
            this.iOB.mjU = gVar.getVideoType();
            this.iOC = new o();
            this.iOC.alT = gVar.threadId;
            this.iOC.fyR = gVar.forumId;
            this.iOC.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iOC.mjR = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iOC.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iOC.mjT = this.mFrom;
            this.iOC.mSource = gVar.source;
            this.iOC.mjY = "0";
            if (gVar.iOZ != null) {
                this.iOB.mjW = gVar.iOZ.videoMd5;
                this.iOC.mjW = gVar.iOZ.videoMd5;
            }
            aq aqVar = new aq("c12590");
            aqVar.dR("tid", gVar.threadId);
            aqVar.dR("nid", gVar.nid);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.al("obj_locate", i);
            aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dR("fid", gVar.forumId);
            aqVar.dR("obj_param1", at.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aqVar.dR("extra", at.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aqVar.dR("obj_id", this.eAX);
            aqVar.dR("ab_tag", at.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aqVar.dR("obj_type", this.mFrom);
            aqVar.al("obj_param5", gVar.getVideoType());
            aqVar.dR("obj_source", at.isEmpty(gVar.source) ? "0" : gVar.source);
            aqVar.al("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aqVar.dR("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aqVar.dR("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aqVar);
            this.iOy.getVideoView().setVideoStatData(this.iOB);
            this.iOy.cZO();
            this.iOy.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.hXE.a(a.this.isFullScreen, a.this.iOy != null && a.this.iOy.dwx(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.iOE = true;
                            a.this.jkA = true;
                            a.this.iOD = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.zl(i);
                            a.this.iOy.cMt();
                        }
                    }
                }
            });
            this.iOy.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.iOz != null && a.this.iOz.iOZ != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.iOz.iOZ.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.hXE.reset();
            }
            this.hXE.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rR() {
                    a.this.jkA = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rQ() {
                    if (a.this.isFullScreen) {
                        a.this.iOE = true;
                        a.this.jkA = true;
                        a.this.iOD = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.zl(i);
                        a.this.iOy.cMt();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rP() {
                    if (a.this.iOy != null) {
                        a.this.iOy.Hq(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rS() {
                    return a.this.cGH();
                }
            });
            this.iOy.setThumbnail(gVar.iOZ.thumbnailUrl);
            this.iOy.Hp(gVar.iOZ.videoDuration);
            this.iOy.setVideoUrl(gVar.iOZ.videoUrl, gVar.threadId);
            this.iOy.setFid(gVar.forumId);
            this.iOy.cMt();
            this.iOy.show();
            qx(false);
            if (gVar.autoPlay) {
                onClick(this.iOk);
                if (this.jkI.dsq()) {
                    this.iOy.wo(false);
                    this.jkI.dRM();
                    this.iOy.wp(true);
                    this.iOy.fV(gVar.iOZ.videoUrl, gVar.threadId);
                    if (this.hXE.rA()) {
                        this.hXE.stop();
                        this.hXE.rF();
                    }
                } else {
                    this.iOy.wp(false);
                    this.iOy.wo(false);
                    this.jkI.hide();
                    if (this.hXE == null || (this.hXE != null && !this.hXE.rA())) {
                        this.iOy.a(gVar.iOZ.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.iPa) {
                    this.jkD.setVisibility(8);
                    this.jkH.AI(3);
                } else {
                    if (this.jkD.getVisibility() == 0) {
                        this.jkD.startAnimation(this.bYm);
                    }
                    this.jkH.AI(0);
                }
                gVar.iPa = false;
            } else {
                this.jkD.setVisibility(0);
                this.jkI.hide();
                this.iOy.wo(true);
                this.jkH.AI(3);
                this.iOy.fV(gVar.iOZ.videoUrl, gVar.threadId);
            }
            this.iOE = false;
            this.jkA = false;
            if (!z && this.hXE.rA()) {
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
        com.baidu.afd.videopaster.data.b Ld = this.jkJ != null ? this.jkJ.Ld(gVar.getThreadId()) : null;
        if (Ld == null) {
            return null;
        }
        int rW = Ld.rW();
        int rX = Ld.rX();
        int rV = Ld.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.iOZ != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.iOZ.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.iOZ.videoHeight, 0);
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
    public void Kv(String str) {
        if (this.iOz != null && this.iOz.iOZ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iOz.iOZ.videoMd5, "", str, this.iOC, this.iOy.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iOy.rK();
    }

    public boolean cGF() {
        return this.hXE.rA();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iOy.aPL();
        }
    }

    public boolean zm(int i) {
        if (i == 4 && this.hXE != null && ((this.hXE.rA() || this.jkA) && this.iOy != null)) {
            this.hXE.aZ(i);
            if (this.isFullScreen) {
                if (this.hXE.rz()) {
                    this.iOy.dwy();
                } else {
                    this.iOy.Tq();
                }
                return true;
            }
        }
        return this.iOy.Hq(i);
    }

    public void cBc() {
        this.jkC = false;
        this.iOy.stopPlay();
        if (this.jkw != null) {
            this.jkw.setVisibility(0);
        }
        if (this.jkH != null) {
            this.jkH.AI(2);
        }
        qx(false);
        this.jkB = true;
        if (this.hXE != null && this.hXE.rA()) {
            this.hXE.stop();
        }
    }

    public void cGG() {
        this.hXE.stop();
    }

    public void cBd() {
        if (this.iOy != null) {
            this.iOy.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cBd();
        if (this.iOA != null) {
            this.iOA.cBn();
        }
        if (this.jkD != null) {
            this.jkD.clearAnimation();
        }
        this.hXE.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.iOY != null) {
            this.aju.setText(TextUtils.isEmpty(gVar.iOY.userNickname) ? gVar.iOY.userName : gVar.iOY.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.iOY != null) {
            if (gVar.iOY.iPi != null && !TextUtils.isEmpty(gVar.iOY.iPi.avatar)) {
                this.iOq.startLoad(gVar.iOY.iPi.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.iOY.portrait) && gVar.iOY.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iOq.startLoad(gVar.iOY.portrait, 10, false);
            } else {
                this.iOq.startLoad(gVar.iOY.portrait, 12, false);
            }
            if (gVar.iOY.iPi != null && gVar.iOY.iPi.auth_id.intValue() > 0) {
                this.iOq.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.iOY.iPi.auth_id.intValue(), 1));
                this.iOq.setShowV(true);
                this.iOq.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.iOq.setBjhAuthIconRes(0);
            if (gVar.iOY.isBigV) {
                this.iOq.setShowV(gVar.iOY.isBigV);
                this.iOq.setIsBigV(gVar.iOY.isBigV);
            } else if (gVar.iOY.isGod) {
                this.iOq.setShowV(gVar.iOY.isGod);
                this.iOq.setIsBigV(gVar.iOY.isGod);
            } else {
                this.iOq.setShowV(gVar.iOY.isGod);
                this.iOq.setIsBigV(gVar.iOY.isGod);
            }
            this.iOq.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bor() != null) {
                gVar.bor().isInThread = true;
                gVar.bor().nid = gVar.nid;
                if (this.iOz.getVideoType() == 1) {
                    gVar.bor().cardType = 2;
                } else if (this.iOz.getVideoType() == 2) {
                    gVar.bor().cardType = 8;
                } else if (this.iOz.getVideoType() == 3) {
                    gVar.bor().cardType = 6;
                }
                gVar.bor().baijiahaoData = gVar.mBaijiahao;
                gVar.bor().recomSource = gVar.source;
                gVar.bor().recomWeight = gVar.weight;
                gVar.bor().recomAbTag = gVar.abtest_tag;
                gVar.bor().recomExtra = gVar.extra;
            }
            if (this.iOz.mBaijiahao != null) {
                this.eVZ.setAgreeAlone(true);
            }
            this.eVZ.setIsFromMiddlePage(true);
            this.eVZ.setData(gVar.bor());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.ewm.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.brn().a(this.eWa, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.ewm.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.ewm.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eWc.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.brn().a(this.eWd, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.eWc.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.eWc.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iOy != null && this.iOk != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iOD) {
                this.iOy.dwE();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cGI();
            } else {
                configuration.orientation = 1;
                cGJ();
                this.iOD = true;
            }
            this.iOy.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cGH() {
        if (this.iOy != null && this.iOk != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iOk.getParent() != null) {
                if (this.iOk.getParent() == frameLayout) {
                    if (this.jkM) {
                        this.jkM = false;
                        return true;
                    } else if (!this.jkN) {
                        this.jkN = true;
                        return true;
                    }
                } else if (this.iOk.getParent() == this.iOj) {
                    if (this.jkN) {
                        this.jkN = false;
                        this.jkO = true;
                        return true;
                    } else if (!this.jkM && this.jkO) {
                        this.jkM = true;
                        this.jkO = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGI() {
        if (this.iOy != null && this.iOk != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.iOk.getParent() != null) {
                if (this.iOk.getParent() == frameLayout) {
                    frameLayout.removeView(this.iOk);
                } else if (this.iOk.getParent() == this.iOj) {
                    this.iOj.removeView(this.iOk);
                }
            }
            if (this.iOk.getParent() == null) {
                frameLayout.addView(this.iOk);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iOk.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iOk.setLayoutParams(layoutParams);
                if (this.jkK != null && this.jkK.isShowing()) {
                    this.jkK.dismiss();
                }
                com.baidu.tbadk.util.e.bDq().kF(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGJ() {
        if (this.iOy != null && this.iOk != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.iOk.getParent() != null) {
                if (this.iOk.getParent() == frameLayout) {
                    cGK();
                    frameLayout.removeView(this.iOk);
                } else if (this.iOk.getParent() == this.iOj) {
                    cGK();
                    this.iOj.removeView(this.iOk);
                }
            }
            if (this.iOk.getParent() == null) {
                this.iOj.addView(this.iOk, 0);
                cGL();
                this.iOy.cZO();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bDq().kF(false);
            }
        }
    }

    private void cGK() {
        if (this.hXE != null && this.hXE.rA()) {
            this.hXE.aB(true);
        }
    }

    private void cGL() {
        int i;
        if (!cGD()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.iOk.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cnT() != null) {
            view.setTag(this);
            cnT().a(view, this.iOz);
        }
        if (view == this.iOq || view == this.aju) {
            if (this.iOz != null && this.iOz.iOY != null && !TextUtils.isEmpty(this.iOz.iOY.userId)) {
                this.jkH.AI(0);
                if (!TbadkCoreApplication.isLogin() || !this.iOz.iOY.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iOz.iOY.userId, 0L), z, this.iOz.iOY.isGod)));
            }
        } else if (view == this.eWb) {
            if (this.iOz != null) {
                this.jkH.AI(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iOz.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.iOz.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jkw || view == this.jkx) {
            if (this.iOz != null) {
                if (this.jkH.getCurrentState() != 2 && this.jkH.getCurrentState() != 3) {
                    z = false;
                }
                this.jkH.AI(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.iOz.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.iOz.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.eWe) {
            this.jkH.AI(0);
            bsT();
        } else if (view == this.jkD && this.jkD.getVisibility() == 0 && this.jkF != null) {
            this.jkF.AM(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pS(boolean z) {
        if (this.iOz != null && this.iOz.iOY != null) {
            this.iOz.iOY.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cBe() {
        if (this.iOz != null) {
            this.eVZ.bse();
        }
    }

    public void qw(boolean z) {
        if (this.iOj != null) {
            this.iOj.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jkL = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jkF = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Zf = fVar;
    }

    private void qx(boolean z) {
        this.jkB = this.mPosition == (this.jkG == null ? -1 : this.jkG.cGX());
        if (this.jkB && z && isPlaying() && this.eJq && !this.jkC) {
            this.jky.setVisibility(0);
            this.jkC = true;
            this.jky.postDelayed(this.jkR, 5000L);
            if (this.jkG != null) {
                this.jkG.fL(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jky.setVisibility(8);
        if (this.jkR != null) {
            this.jky.removeCallbacks(this.jkR);
        }
    }

    private void bsT() {
        String str;
        String str2;
        if (this.iOz != null && this.mContext != null) {
            String valueOf = String.valueOf(this.iOz.forumId);
            String str3 = this.iOz.title;
            if (this.iOz.mBaijiahao != null) {
                str = this.iOz.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.iOz.mBaijiahao.oriUgcType + "&dvid=" + this.iOz.mBaijiahao.oriUgcVid + "&nid=" + this.iOz.mBaijiahao.oriUgcNid;
            } else {
                str = this.iOz.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.iOz.iOZ.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.iOz.title;
            String format = (this.iOz.mBaijiahao == null || this.iOz.iOY == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.iOz.iOY.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.iOz.mBaijiahao != null) {
                shareItem.fgU = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fgU = str6;
                shareItem.readCount = this.iOz.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fgX = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fgJ = true;
            shareItem.fgW = 11;
            if (this.iOz.getVideoType() == 1) {
                shareItem.fhb = 2;
            } else if (this.iOz.getVideoType() == 2) {
                shareItem.fhb = 8;
            } else if (this.iOz.getVideoType() == 3) {
                shareItem.fhb = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.iOz.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.iOz.mBaijiahao;
            shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dR("tid", str);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.al("obj_locate", 12);
            aqVar.dR("nid", this.iOz.nid);
            if (this.iOz.mBaijiahao != null && !at.isEmpty(this.iOz.mBaijiahao.oriUgcVid)) {
                aqVar.dR("obj_param6", this.iOz.mBaijiahao.oriUgcVid);
            }
            if (this.iOz.getVideoType() == 1) {
                aqVar.al(IntentConfig.CARD_TYPE, 2);
            } else if (this.iOz.getVideoType() == 2) {
                aqVar.al(IntentConfig.CARD_TYPE, 8);
            } else if (this.iOz.getVideoType() == 3) {
                aqVar.al(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dR(IntentConfig.RECOM_SOURCE, this.iOz.source);
            aqVar.dR("ab_tag", this.iOz.abtest_tag);
            aqVar.dR("weight", this.iOz.weight);
            aqVar.dR("extra", this.iOz.extra);
            aqVar.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgX);
            bundle.putInt("obj_type", shareItem.fhb);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eHo);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.cpv().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        cBc();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aPL() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qy(boolean z) {
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

    public void cGM() {
        this.hXE.resume();
    }

    public boolean cGN() {
        if (this.jkH != null) {
            return this.jkH.getCurrentState() == 2 || this.jkH.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0736a {
        private int ciY;
        private Runnable jkW;

        private C0736a() {
            this.ciY = -1;
            this.jkW = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(C0736a.this.jkW);
                    C0736a.this.AI(2);
                }
            };
        }

        public void AI(int i) {
            switch (i) {
                case 0:
                    this.ciY = AJ(i);
                    cGO();
                    return;
                case 1:
                    this.ciY = AJ(i);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkW);
                    return;
                case 2:
                    this.ciY = AK(i);
                    return;
                case 3:
                    this.ciY = AL(i);
                    cGO();
                    return;
                default:
                    this.ciY = AK(i);
                    return;
            }
        }

        private void cGO() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkW);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jkW, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.ciY;
        }

        private int AJ(int i) {
            if (i != this.ciY) {
                a.this.jkE.setVisibility(8);
                a.this.qy(true);
                return i;
            }
            return this.ciY;
        }

        private int AK(int i) {
            int i2 = this.ciY;
            if (i != this.ciY) {
                a.this.jkE.setVisibility(0);
                if (i2 != 3 || a.this.iOz.autoPlay) {
                    a.this.qy(false);
                    return i;
                }
                return i;
            }
            return this.ciY;
        }

        private int AL(int i) {
            if (i != this.ciY) {
                a.this.jkE.setVisibility(0);
                a.this.qy(true);
                return i;
            }
            return this.ciY;
        }
    }
}
