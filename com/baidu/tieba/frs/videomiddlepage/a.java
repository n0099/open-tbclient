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
    private com.baidu.tieba.lego.card.view.f Ze;
    public TextView ajt;
    private Animation bKg;
    private Animation bKh;
    protected AgreeView eHO;
    private ImageView eHP;
    private View eHQ;
    private TextView eHR;
    private ImageView eHS;
    private View eHT;
    private TextView ehV;
    private String emE;
    private boolean evc;
    private com.baidu.afd.videopaster.d hFk;
    private int hVO;
    public ExpandableTextView iSc;
    private View iSd;
    private FrameLayout iSe;
    private TextView iSf;
    private boolean iSg;
    private boolean iSh;
    private boolean iSi;
    private View iSj;
    private View iSk;
    private c iSl;
    public com.baidu.tieba.frs.videomiddlepage.a.a iSm;
    private C0706a iSn;
    private VideoNetworkStateTipView iSo;
    private b iSp;
    private com.baidu.mcn.c iSq;
    private com.baidu.tieba.lego.card.view.g iSr;
    private boolean iSs;
    private boolean iSt;
    private boolean iSu;
    private Animation.AnimationListener iSv;
    private Animation.AnimationListener iSw;
    private Runnable iSx;
    private Runnable iSy;
    private boolean isFullScreen;
    public FrameLayout ivQ;
    public FrameLayout ivR;
    public HeadImageView ivX;
    public com.baidu.tieba.play.c iwf;
    public com.baidu.tieba.frs.aggregation.g iwg;
    private com.baidu.tieba.frs.aggregation.h iwh;
    private o iwi;
    private o iwj;
    private boolean iwk;
    private boolean iwl;
    private boolean iwo;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.iwk = true;
        this.iwo = true;
        this.iSh = false;
        this.iSi = false;
        this.iSs = false;
        this.iSt = false;
        this.iSu = false;
        this.startPosition = -1L;
        this.hVO = 0;
        this.iSv = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.iSj != null) {
                    a.this.iSj.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.iSj != null) {
                    a.this.iSj.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iSw = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.iSj != null) {
                    a.this.iSj.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.iSj != null) {
                    a.this.iSj.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iSx = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iSe.getVisibility() == 0) {
                    a.this.iSe.setVisibility(8);
                }
            }
        };
        this.iSy = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iwf != null) {
                    a.this.iwf.stopPlay();
                }
            }
        };
        this.iwo = z;
        this.mFrom = str;
        this.emE = str2;
        this.iSp = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.ivQ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.iSd = view.findViewById(R.id.card_container);
        this.ivR = (FrameLayout) view.findViewById(R.id.video_container);
        this.iwf = new com.baidu.tieba.play.c(tbPageContext, this.ivR, false);
        this.iwf.setStageType("2005");
        this.iwf.vJ(z);
        this.iwf.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.iSm != null && a.this.iwg.iwG.videoDuration > 8) {
                    a.this.iSm.bq(a.this.mPosition, a.this.iwg.iwG.videoUrl);
                }
            }
        });
        this.iwf.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void pY(boolean z2) {
                if (a.this.iSn != null) {
                    if (z2) {
                        a.this.iSn.Ac(0);
                    } else {
                        a.this.iSn.Ac(1);
                    }
                }
            }
        });
        this.iwf.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.iSc = (ExpandableTextView) view.findViewById(R.id.title);
        this.ivX = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajt = (TextView) view.findViewById(R.id.user_name);
        this.eHO = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.elb = 2;
        cVar.elg = 6;
        this.eHO.setStatisticData(cVar);
        this.ehV = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eHP = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eHQ = view.findViewById(R.id.thread_info_commont_container);
        this.eHR = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.eHS = (ImageView) view.findViewById(R.id.share_num_img);
        this.eHT = view.findViewById(R.id.share_num_container);
        this.iSe = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.iSf = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.iSe.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.iSf.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.blO().getString("nani_key_download_link_url", null);
        this.iSf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bmY().a((TbPageContext) i.I(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.iSo = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.iSo.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.iSo.setHasAgreeToPlay(true);
                a.this.iwf.vP(false);
                a.this.iSo.dMd();
                if (a.this.hFk.rA()) {
                    a.this.hFk.resume();
                } else if (a.this.iwg != null && a.this.iwg.iwG != null) {
                    a.this.iwf.fR(a.this.iwg.iwG.videoUrl, a.this.iwg.threadId);
                }
            }
        });
        this.iSj = view.findViewById(R.id.video_agg_container_foreground);
        this.iSk = view.findViewById(R.id.title_and_comment_container_foreground);
        this.iSj.setOnClickListener(this);
        this.eHQ.setOnClickListener(this);
        this.eHT.setOnClickListener(this);
        this.iSc.setOnClickListener(this);
        this.ivX.setOnClickListener(this);
        this.ajt.setOnClickListener(this);
        this.iSd.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.hVO = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.ivQ.setLayoutParams(layoutParams);
        this.ivX.setIsRound(true);
        this.ivX.setPlaceHolder(1);
        this.iwh = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bKg = new AlphaAnimation(0.0f, 0.7f);
        this.bKg.setDuration(500L);
        this.bKg.setAnimationListener(this.iSw);
        this.bKh = new AlphaAnimation(0.7f, 0.0f);
        this.bKh.setDuration(500L);
        this.bKh.setAnimationListener(this.iSv);
        this.iSn = new C0706a();
        this.hFk = new com.baidu.afd.videopaster.d(getContext(), this.ivR);
        this.iSq = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eHO.onChangeSkinType(i);
        this.ehV.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.eHR.setTextColor(ap.getColor(R.color.cp_cont_d));
        SvgManager.bmU().a(this.eHP, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bmU().a(this.eHS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iSc.onChangeSkinType();
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
        if (gVar != null && gVar.iwG != null) {
            boolean z = this.iwg == gVar;
            this.iwg = gVar;
            this.evc = this.iwg.autoPlay;
            this.iSi = false;
            pW(false);
            this.iSc.setVisibility(0);
            this.iSc.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.iSc.setTextColor(R.color.cp_cont_a);
            this.iSc.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.iwG != null && !StringUtils.isNull(gVar.iwG.mcnLeadPage)) {
                this.iSc.setTextMaxLine(2);
                this.iSc.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.iSc.getContentView(), gVar.title, gVar.iwG.mcnLeadPage, gVar.getThreadId());
            } else {
                this.iSc.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.iSc.setExpandable(true);
                this.iSc.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void pZ(boolean z2) {
                        a.this.iwg.isTitleExpanded = z2;
                    }
                });
                this.iSc.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.hVO) {
                this.iwf.drh();
                this.hVO = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.ivR.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.ivR.setLayoutParams(layoutParams);
            }
            cAW();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.iwg = gVar;
        this.evc = this.iwg.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cAV() {
        try {
            int parseInt = Integer.parseInt(this.iwg.iwG.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.iwg.iwG.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cAW() {
        if (!cAV()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.ivQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ivQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.ivQ.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.iwG != null) {
            this.iwf.stopPlay();
            this.iwf.vQ(true);
            this.iwf.vM(true);
            this.iwf.vR(true);
            this.iwf.av(false, false);
            this.iwf.GL(i);
            this.iwf.a(new c.InterfaceC0797c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rI() {
                    a.this.cBa();
                    if (a.this.hFk != null) {
                        a.this.hFk.rI();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rJ() {
                    a.this.cBb();
                    if (a.this.iwf.rK()) {
                    }
                    if (a.this.iwl || (a.this.hFk != null && a.this.hFk.rA())) {
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(a.this.iSy);
                        com.baidu.adp.lib.f.e.mY().post(a.this.iSy);
                    }
                    if (a.this.hFk != null) {
                        a.this.hFk.rJ();
                    }
                }
            });
            this.iwf.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void cvx() {
                    if (a.this.iwg != null && a.this.iwg.iwG != null && com.baidu.adp.lib.f.b.toInt(a.this.iwg.iwG.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.iwg.iwG.videoWidth, 0)) {
                        a.this.iwf.av(false, false);
                    } else {
                        a.this.iwf.av(true, false);
                    }
                    a.this.iwl = false;
                    a.this.JF(a.this.evc ? "1" : "2");
                    a.this.onClick(a.this.ivR);
                    if (a.this.Ze != null) {
                        a.this.Ze.a(a.this);
                    }
                    if (a.this.iSr != null) {
                        a.this.iSr.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cvy() {
                    a.this.onClick(a.this.ivQ);
                }
            });
            this.iwf.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void ps(boolean z2) {
                    a.this.iwf.fR(a.this.iwg.iwG.videoUrl, a.this.iwg.threadId);
                    a.this.JF("2");
                    a.this.onClick(a.this.ivR);
                }
            });
            this.iwf.vI(false);
            if (this.iSq != null) {
                this.iSq.reset();
            }
            this.startPosition = -1L;
            if (this.iwf.getVideoView() != null && this.iwf.getVideoView().getMediaProgressObserver() != null) {
                this.iwf.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ca(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.iwg.iwG.iwQ;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.hFk.a(a.this.isFullScreen, a.this.iwf != null && a.this.iwf.dqO(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.hFk.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.iwf.dqO() && !com.baidu.mcn.b.Vw().iG(aVar2.Zt)) {
                            boolean z3 = a.this.startPosition >= (aVar2.iwI * 1000) + 1000;
                            if (i3 < aVar2.iwI * 1000 || i3 >= aVar2.iwJ * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.iSq.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bJT = aVar2.iwL;
                                    aVar3.bJU = aVar2.iwM;
                                    aVar3.bJV = aVar2.Zt;
                                    aVar3.bJS = aVar2.iwK;
                                    aVar3.fid = a.this.iwg != null ? a.this.iwg.forumId : null;
                                    aVar3.tid = a.this.iwg != null ? a.this.iwg.threadId : null;
                                    aVar3.bJW = 3;
                                    if (z3) {
                                        a.this.iSq.b(aVar3, (ViewGroup) a.this.iwf.drg());
                                    } else {
                                        a.this.iSq.a(aVar3, (ViewGroup) a.this.iwf.drg());
                                    }
                                }
                            } else if (a.this.iSq.isShowing()) {
                                a.this.iSq.dismiss();
                            }
                        }
                    }
                });
            }
            this.iwi = new o();
            this.iwi.alS = gVar.threadId;
            this.iwi.mNid = gVar.nid;
            this.iwi.fkA = gVar.forumId;
            this.iwi.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iwi.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.iwi.mSource = gVar.source;
            this.iwi.lRu = gVar.weight;
            this.iwi.lRw = this.mFrom;
            this.iwi.lRy = gVar.abtest_tag;
            this.iwi.emE = this.emE;
            this.iwi.mExtra = gVar.extra;
            this.iwi.lRB = "0";
            this.iwi.lRx = gVar.getVideoType();
            this.iwj = new o();
            this.iwj.alS = gVar.threadId;
            this.iwj.fkA = gVar.forumId;
            this.iwj.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iwj.lRu = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iwj.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iwj.lRw = this.mFrom;
            this.iwj.mSource = gVar.source;
            this.iwj.lRB = "0";
            if (gVar.iwG != null) {
                this.iwi.lRz = gVar.iwG.videoMd5;
                this.iwj.lRz = gVar.iwG.videoMd5;
            }
            aq aqVar = new aq("c12590");
            aqVar.dK("tid", gVar.threadId);
            aqVar.dK("nid", gVar.nid);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", i);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dK("fid", gVar.forumId);
            aqVar.dK("obj_param1", at.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aqVar.dK("extra", at.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aqVar.dK("obj_id", this.emE);
            aqVar.dK("ab_tag", at.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aqVar.dK("obj_type", this.mFrom);
            aqVar.aj("obj_param5", gVar.getVideoType());
            aqVar.dK("obj_source", at.isEmpty(gVar.source) ? "0" : gVar.source);
            aqVar.aj("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aqVar.dK("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aqVar.dK("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aqVar);
            this.iwf.getVideoView().setVideoStatData(this.iwi);
            this.iwf.cUg();
            this.iwf.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.hFk.a(a.this.isFullScreen, a.this.iwf != null && a.this.iwf.dqO(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.iwl = true;
                            a.this.iSg = true;
                            a.this.iwk = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.yF(i);
                            a.this.iwf.cGL();
                        }
                    }
                }
            });
            this.iwf.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.iwg != null && a.this.iwg.iwG != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.iwg.iwG.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.hFk.reset();
            }
            this.hFk.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rR() {
                    a.this.iSg = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rQ() {
                    if (a.this.isFullScreen) {
                        a.this.iwl = true;
                        a.this.iSg = true;
                        a.this.iwk = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.yF(i);
                        a.this.iwf.cGL();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rP() {
                    if (a.this.iwf != null) {
                        a.this.iwf.GK(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rS() {
                    return a.this.cAZ();
                }
            });
            this.iwf.setThumbnail(gVar.iwG.thumbnailUrl);
            this.iwf.GJ(gVar.iwG.videoDuration);
            this.iwf.setVideoUrl(gVar.iwG.videoUrl, gVar.threadId);
            this.iwf.setFid(gVar.forumId);
            this.iwf.cGL();
            this.iwf.show();
            pW(false);
            if (gVar.autoPlay) {
                onClick(this.ivR);
                if (this.iSo.dmG()) {
                    this.iwf.vO(false);
                    this.iSo.dMc();
                    this.iwf.vP(true);
                    this.iwf.fQ(gVar.iwG.videoUrl, gVar.threadId);
                    if (this.hFk.rA()) {
                        this.hFk.stop();
                        this.hFk.rF();
                    }
                } else {
                    this.iwf.vP(false);
                    this.iwf.vO(false);
                    this.iSo.hide();
                    if (this.hFk == null || (this.hFk != null && !this.hFk.rA())) {
                        this.iwf.a(gVar.iwG.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.iwH) {
                    this.iSj.setVisibility(8);
                    this.iSn.Ac(3);
                } else {
                    if (this.iSj.getVisibility() == 0) {
                        this.iSj.startAnimation(this.bKh);
                    }
                    this.iSn.Ac(0);
                }
                gVar.iwH = false;
            } else {
                this.iSj.setVisibility(0);
                this.iSo.hide();
                this.iwf.vO(true);
                this.iSn.Ac(3);
                this.iwf.fQ(gVar.iwG.videoUrl, gVar.threadId);
            }
            this.iwl = false;
            this.iSg = false;
            if (!z && this.hFk.rA()) {
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
        com.baidu.afd.videopaster.data.b Kn = this.iSp != null ? this.iSp.Kn(gVar.getThreadId()) : null;
        if (Kn == null) {
            return null;
        }
        int rW = Kn.rW();
        int rX = Kn.rX();
        int rV = Kn.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.iwG != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.iwG.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.iwG.videoHeight, 0);
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
    public void JF(String str) {
        if (this.iwg != null && this.iwg.iwG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iwg.iwG.videoMd5, "", str, this.iwj, this.iwf.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iwf.rK();
    }

    public boolean cAX() {
        return this.hFk.rA();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iwf.aLr();
        }
    }

    public boolean yG(int i) {
        if (i == 4 && this.hFk != null && ((this.hFk.rA() || this.iSg) && this.iwf != null)) {
            this.hFk.aZ(i);
            if (this.isFullScreen) {
                if (this.hFk.rz()) {
                    this.iwf.dqP();
                } else {
                    this.iwf.PP();
                }
                return true;
            }
        }
        return this.iwf.GK(i);
    }

    public void cvu() {
        this.iSi = false;
        this.iwf.stopPlay();
        if (this.iSc != null) {
            this.iSc.setVisibility(0);
        }
        if (this.iSn != null) {
            this.iSn.Ac(2);
        }
        pW(false);
        this.iSh = true;
        if (this.hFk != null && this.hFk.rA()) {
            this.hFk.stop();
        }
    }

    public void cAY() {
        this.hFk.stop();
    }

    public void cvv() {
        if (this.iwf != null) {
            this.iwf.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cvv();
        if (this.iwh != null) {
            this.iwh.cvF();
        }
        if (this.iSj != null) {
            this.iSj.clearAnimation();
        }
        this.hFk.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.iwF != null) {
            this.ajt.setText(TextUtils.isEmpty(gVar.iwF.userNickname) ? gVar.iwF.userName : gVar.iwF.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.iwF != null) {
            if (gVar.iwF.iwP != null && !TextUtils.isEmpty(gVar.iwF.iwP.avatar)) {
                this.ivX.startLoad(gVar.iwF.iwP.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.iwF.portrait) && gVar.iwF.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.ivX.startLoad(gVar.iwF.portrait, 10, false);
            } else {
                this.ivX.startLoad(gVar.iwF.portrait, 12, false);
            }
            if (gVar.iwF.iwP != null && gVar.iwF.iwP.auth_id.intValue() > 0) {
                this.ivX.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.iwF.iwP.auth_id.intValue(), 1));
                this.ivX.setShowV(true);
                this.ivX.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.ivX.setBjhAuthIconRes(0);
            if (gVar.iwF.isBigV) {
                this.ivX.setShowV(gVar.iwF.isBigV);
                this.ivX.setIsBigV(gVar.iwF.isBigV);
            } else if (gVar.iwF.isGod) {
                this.ivX.setShowV(gVar.iwF.isGod);
                this.ivX.setIsBigV(gVar.iwF.isGod);
            } else {
                this.ivX.setShowV(gVar.iwF.isGod);
                this.ivX.setIsBigV(gVar.iwF.isGod);
            }
            this.ivX.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bjY() != null) {
                gVar.bjY().isInThread = true;
                gVar.bjY().nid = gVar.nid;
                if (this.iwg.getVideoType() == 1) {
                    gVar.bjY().cardType = 2;
                } else if (this.iwg.getVideoType() == 2) {
                    gVar.bjY().cardType = 8;
                } else if (this.iwg.getVideoType() == 3) {
                    gVar.bjY().cardType = 6;
                }
                gVar.bjY().baijiahaoData = gVar.mBaijiahao;
                gVar.bjY().recomSource = gVar.source;
                gVar.bjY().recomWeight = gVar.weight;
                gVar.bjY().recomAbTag = gVar.abtest_tag;
                gVar.bjY().recomExtra = gVar.extra;
            }
            if (this.iwg.mBaijiahao != null) {
                this.eHO.setAgreeAlone(true);
            }
            this.eHO.setIsFromMiddlePage(true);
            this.eHO.setData(gVar.bjY());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.ehV.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bmU().a(this.eHP, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.ehV.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.ehV.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eHR.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bmU().a(this.eHS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.eHR.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.eHR.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iwf != null && this.ivR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iwk) {
                this.iwf.dqV();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cBa();
            } else {
                configuration.orientation = 1;
                cBb();
                this.iwk = true;
            }
            this.iwf.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAZ() {
        if (this.iwf != null && this.ivR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.ivR.getParent() != null) {
                if (this.ivR.getParent() == frameLayout) {
                    if (this.iSs) {
                        this.iSs = false;
                        return true;
                    } else if (!this.iSt) {
                        this.iSt = true;
                        return true;
                    }
                } else if (this.ivR.getParent() == this.ivQ) {
                    if (this.iSt) {
                        this.iSt = false;
                        this.iSu = true;
                        return true;
                    } else if (!this.iSs && this.iSu) {
                        this.iSs = true;
                        this.iSu = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBa() {
        if (this.iwf != null && this.ivR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.ivR.getParent() != null) {
                if (this.ivR.getParent() == frameLayout) {
                    frameLayout.removeView(this.ivR);
                } else if (this.ivR.getParent() == this.ivQ) {
                    this.ivQ.removeView(this.ivR);
                }
            }
            if (this.ivR.getParent() == null) {
                frameLayout.addView(this.ivR);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivR.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.ivR.setLayoutParams(layoutParams);
                if (this.iSq != null && this.iSq.isShowing()) {
                    this.iSq.dismiss();
                }
                com.baidu.tbadk.util.e.byY().kj(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBb() {
        if (this.iwf != null && this.ivR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.ivR.getParent() != null) {
                if (this.ivR.getParent() == frameLayout) {
                    cBc();
                    frameLayout.removeView(this.ivR);
                } else if (this.ivR.getParent() == this.ivQ) {
                    cBc();
                    this.ivQ.removeView(this.ivR);
                }
            }
            if (this.ivR.getParent() == null) {
                this.ivQ.addView(this.ivR, 0);
                cBd();
                this.iwf.cUg();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.byY().kj(false);
            }
        }
    }

    private void cBc() {
        if (this.hFk != null && this.hFk.rA()) {
            this.hFk.aB(true);
        }
    }

    private void cBd() {
        int i;
        if (!cAV()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.ivR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cil() != null) {
            view.setTag(this);
            cil().a(view, this.iwg);
        }
        if (view == this.ivX || view == this.ajt) {
            if (this.iwg != null && this.iwg.iwF != null && !TextUtils.isEmpty(this.iwg.iwF.userId)) {
                this.iSn.Ac(0);
                if (!TbadkCoreApplication.isLogin() || !this.iwg.iwF.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iwg.iwF.userId, 0L), z, this.iwg.iwF.isGod)));
            }
        } else if (view == this.eHQ) {
            if (this.iwg != null) {
                this.iSn.Ac(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iwg.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.iwg.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.iSc || view == this.iSd) {
            if (this.iwg != null) {
                if (this.iSn.getCurrentState() != 2 && this.iSn.getCurrentState() != 3) {
                    z = false;
                }
                this.iSn.Ac(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.iwg.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.iwg.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.eHT) {
            this.iSn.Ac(0);
            boA();
        } else if (view == this.iSj && this.iSj.getVisibility() == 0 && this.iSl != null) {
            this.iSl.Ag(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pr(boolean z) {
        if (this.iwg != null && this.iwg.iwF != null) {
            this.iwg.iwF.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cvw() {
        if (this.iwg != null) {
            this.eHO.bnL();
        }
    }

    public void pV(boolean z) {
        if (this.ivQ != null) {
            this.ivQ.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.iSr = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.iSl = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Ze = fVar;
    }

    private void pW(boolean z) {
        this.iSh = this.mPosition == (this.iSm == null ? -1 : this.iSm.cBp());
        if (this.iSh && z && isPlaying() && this.evc && !this.iSi) {
            this.iSe.setVisibility(0);
            this.iSi = true;
            this.iSe.postDelayed(this.iSx, 5000L);
            if (this.iSm != null) {
                this.iSm.fo(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.iSe.setVisibility(8);
        if (this.iSx != null) {
            this.iSe.removeCallbacks(this.iSx);
        }
    }

    private void boA() {
        String str;
        String str2;
        if (this.iwg != null && this.mContext != null) {
            String valueOf = String.valueOf(this.iwg.forumId);
            String str3 = this.iwg.title;
            if (this.iwg.mBaijiahao != null) {
                str = this.iwg.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.iwg.mBaijiahao.oriUgcType + "&dvid=" + this.iwg.mBaijiahao.oriUgcVid + "&nid=" + this.iwg.mBaijiahao.oriUgcNid;
            } else {
                str = this.iwg.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.iwg.iwG.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.iwg.title;
            String format = (this.iwg.mBaijiahao == null || this.iwg.iwF == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.iwg.iwF.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.iwg.mBaijiahao != null) {
                shareItem.eSH = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.eSH = str6;
                shareItem.readCount = this.iwg.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.eSK = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.eSw = true;
            shareItem.eSJ = 11;
            if (this.iwg.getVideoType() == 1) {
                shareItem.eSO = 2;
            } else if (this.iwg.getVideoType() == 2) {
                shareItem.eSO = 8;
            } else if (this.iwg.getVideoType() == 3) {
                shareItem.eSO = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.iwg.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.iwg.mBaijiahao;
            shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dK("tid", str);
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.aj("obj_locate", 12);
            aqVar.dK("nid", this.iwg.nid);
            if (this.iwg.mBaijiahao != null && !at.isEmpty(this.iwg.mBaijiahao.oriUgcVid)) {
                aqVar.dK("obj_param6", this.iwg.mBaijiahao.oriUgcVid);
            }
            if (this.iwg.getVideoType() == 1) {
                aqVar.aj(IntentConfig.CARD_TYPE, 2);
            } else if (this.iwg.getVideoType() == 2) {
                aqVar.aj(IntentConfig.CARD_TYPE, 8);
            } else if (this.iwg.getVideoType() == 3) {
                aqVar.aj(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dK(IntentConfig.RECOM_SOURCE, this.iwg.source);
            aqVar.dK("ab_tag", this.iwg.abtest_tag);
            aqVar.dK("weight", this.iwg.weight);
            aqVar.dK("extra", this.iwg.extra);
            aqVar.dK("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dK("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dK("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eSK);
            bundle.putInt("obj_type", shareItem.eSO);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.esZ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.cjN().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        cvu();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aLr() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(boolean z) {
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

    public void cBe() {
        this.hFk.resume();
    }

    public boolean cBf() {
        if (this.iSn != null) {
            return this.iSn.getCurrentState() == 2 || this.iSn.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0706a {
        private int bUO;
        private Runnable iSC;

        private C0706a() {
            this.bUO = -1;
            this.iSC = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(C0706a.this.iSC);
                    C0706a.this.Ac(2);
                }
            };
        }

        public void Ac(int i) {
            switch (i) {
                case 0:
                    this.bUO = Ad(i);
                    cBg();
                    return;
                case 1:
                    this.bUO = Ad(i);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iSC);
                    return;
                case 2:
                    this.bUO = Ae(i);
                    return;
                case 3:
                    this.bUO = Af(i);
                    cBg();
                    return;
                default:
                    this.bUO = Ae(i);
                    return;
            }
        }

        private void cBg() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iSC);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.iSC, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.bUO;
        }

        private int Ad(int i) {
            if (i != this.bUO) {
                a.this.iSk.setVisibility(8);
                a.this.pX(true);
                return i;
            }
            return this.bUO;
        }

        private int Ae(int i) {
            int i2 = this.bUO;
            if (i != this.bUO) {
                a.this.iSk.setVisibility(0);
                if (i2 != 3 || a.this.iwg.autoPlay) {
                    a.this.pX(false);
                    return i;
                }
                return i;
            }
            return this.bUO;
        }

        private int Af(int i) {
            if (i != this.bUO) {
                a.this.iSk.setVisibility(0);
                a.this.pX(true);
                return i;
            }
            return this.bUO;
        }
    }
}
