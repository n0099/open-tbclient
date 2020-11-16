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
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, k {
    private com.baidu.tieba.lego.card.view.f Zk;
    public TextView ajz;
    private Animation bWB;
    private Animation bWC;
    private boolean eIq;
    protected AgreeView eVi;
    private ImageView eVk;
    private View eVl;
    private ImageView eVn;
    private View eVo;
    private TextView euD;
    private String ezo;
    private com.baidu.afd.videopaster.d hYe;
    public FrameLayout iOW;
    public FrameLayout iOX;
    public HeadImageView iPd;
    public com.baidu.tieba.play.c iPl;
    public com.baidu.tieba.frs.aggregation.g iPm;
    private com.baidu.tieba.frs.aggregation.h iPn;
    private o iPo;
    private o iPp;
    private boolean iPq;
    private boolean iPr;
    private boolean iPu;
    private int ipb;
    private boolean isFullScreen;
    private TextView ivH;
    private Animation.AnimationListener jlA;
    private Runnable jlB;
    private Runnable jlC;
    public ExpandableTextView jlg;
    private View jlh;
    private FrameLayout jli;
    private TextView jlj;
    private boolean jlk;
    private boolean jll;
    private boolean jlm;
    private View jln;
    private View jlo;
    private c jlp;
    public com.baidu.tieba.frs.videomiddlepage.a.a jlq;
    private C0737a jlr;
    private VideoNetworkStateTipView jls;
    private b jlt;
    private com.baidu.mcn.c jlu;
    private com.baidu.tieba.lego.card.view.g jlv;
    private boolean jlw;
    private boolean jlx;
    private boolean jly;
    private Animation.AnimationListener jlz;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.iPq = true;
        this.iPu = true;
        this.jll = false;
        this.jlm = false;
        this.jlw = false;
        this.jlx = false;
        this.jly = false;
        this.startPosition = -1L;
        this.ipb = 0;
        this.jlz = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jln != null) {
                    a.this.jln.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jln != null) {
                    a.this.jln.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jlA = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jln != null) {
                    a.this.jln.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jln != null) {
                    a.this.jln.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jlB = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jli.getVisibility() == 0) {
                    a.this.jli.setVisibility(8);
                }
            }
        };
        this.jlC = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iPl != null) {
                    a.this.iPl.stopPlay();
                }
            }
        };
        this.iPu = z;
        this.mFrom = str;
        this.ezo = str2;
        this.jlt = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iOW = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jlh = view.findViewById(R.id.card_container);
        this.iOX = (FrameLayout) view.findViewById(R.id.video_container);
        this.iPl = new com.baidu.tieba.play.c(tbPageContext, this.iOX, false);
        this.iPl.setStageType("2005");
        this.iPl.wm(z);
        this.iPl.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jlq != null && a.this.iPm.iPM.videoDuration > 8) {
                    a.this.jlq.bt(a.this.mPosition, a.this.iPm.iPM.videoUrl);
                }
            }
        });
        this.iPl.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void qC(boolean z2) {
                if (a.this.jlr != null) {
                    if (z2) {
                        a.this.jlr.Bg(0);
                    } else {
                        a.this.jlr.Bg(1);
                    }
                }
            }
        });
        this.iPl.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jlg = (ExpandableTextView) view.findViewById(R.id.title);
        this.iPd = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajz = (TextView) view.findViewById(R.id.user_name);
        this.eVi = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exJ = 2;
        dVar.exO = 6;
        this.eVi.setStatisticData(dVar);
        this.eVi.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.euD = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eVk = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eVl = view.findViewById(R.id.thread_info_commont_container);
        this.ivH = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.eVn = (ImageView) view.findViewById(R.id.share_num_img);
        this.eVo = view.findViewById(R.id.share_num_container);
        this.jli = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jlj = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jli.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jlj.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bpu().getString("nani_key_download_link_url", null);
        this.jlj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bqF().a((TbPageContext) i.I(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jls = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jls.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c13257"));
                a.this.jls.setHasAgreeToPlay(true);
                a.this.iPl.ws(false);
                a.this.jls.dRM();
                if (a.this.hYe.rA()) {
                    a.this.hYe.resume();
                } else if (a.this.iPm != null && a.this.iPm.iPM != null) {
                    a.this.iPl.fW(a.this.iPm.iPM.videoUrl, a.this.iPm.threadId);
                }
            }
        });
        this.jln = view.findViewById(R.id.video_agg_container_foreground);
        this.jlo = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jln.setOnClickListener(this);
        this.eVl.setOnClickListener(this);
        this.eVo.setOnClickListener(this);
        this.jlg.setOnClickListener(this);
        this.iPd.setOnClickListener(this);
        this.ajz.setOnClickListener(this);
        this.jlh.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.ipb = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iOW.setLayoutParams(layoutParams);
        this.iPd.setIsRound(true);
        this.iPd.setPlaceHolder(1);
        this.iPn = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bWB = new AlphaAnimation(0.0f, 0.7f);
        this.bWB.setDuration(500L);
        this.bWB.setAnimationListener(this.jlA);
        this.bWC = new AlphaAnimation(0.7f, 0.0f);
        this.bWC.setDuration(500L);
        this.bWC.setAnimationListener(this.jlz);
        this.jlr = new C0737a();
        this.hYe = new com.baidu.afd.videopaster.d(getContext(), this.iOX);
        this.jlu = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eVi.onChangeSkinType(i);
        this.euD.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.ivH.setTextColor(ap.getColor(R.color.CAM_X0107));
        WebPManager.a(this.eVn, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.eVk, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jlg.onChangeSkinType();
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
        if (gVar != null && gVar.iPM != null) {
            boolean z = this.iPm == gVar;
            this.iPm = gVar;
            this.eIq = this.iPm.autoPlay;
            this.jlm = false;
            qA(false);
            this.jlg.setVisibility(0);
            this.jlg.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jlg.setTextColor(R.color.CAM_X0101);
            this.jlg.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.iPM != null && !StringUtils.isNull(gVar.iPM.mcnLeadPage)) {
                this.jlg.setTextMaxLine(2);
                this.jlg.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jlg.getContentView(), gVar.title, gVar.iPM.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jlg.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.jlg.setExpandable(true);
                this.jlg.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void qD(boolean z2) {
                        a.this.iPm.isTitleExpanded = z2;
                    }
                });
                this.jlg.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.ipb) {
                this.iPl.dwq();
                this.ipb = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.iOX.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iOX.setLayoutParams(layoutParams);
            }
            cGj();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.iPm = gVar;
        this.eIq = this.iPm.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cGi() {
        try {
            int parseInt = Integer.parseInt(this.iPm.iPM.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.iPm.iPM.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cGj() {
        if (!cGi()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOW.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iOW.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iOW.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iOW.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.iPM != null) {
            this.iPl.stopPlay();
            this.iPl.wt(true);
            this.iPl.wp(true);
            this.iPl.wu(true);
            this.iPl.av(false, false);
            this.iPl.HP(i);
            this.iPl.a(new c.InterfaceC0829c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rI() {
                    a.this.cGn();
                    if (a.this.hYe != null) {
                        a.this.hYe.rI();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rJ() {
                    a.this.cGo();
                    if (a.this.iPl.rK()) {
                    }
                    if (a.this.iPr || (a.this.hYe != null && a.this.hYe.rA())) {
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(a.this.jlC);
                        com.baidu.adp.lib.f.e.mY().post(a.this.jlC);
                    }
                    if (a.this.hYe != null) {
                        a.this.hYe.rJ();
                    }
                }
            });
            this.iPl.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void cAI() {
                    if (a.this.iPm != null && a.this.iPm.iPM != null && com.baidu.adp.lib.f.b.toInt(a.this.iPm.iPM.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.iPm.iPM.videoWidth, 0)) {
                        a.this.iPl.av(false, false);
                    } else {
                        a.this.iPl.av(true, false);
                    }
                    a.this.iPr = false;
                    a.this.JW(a.this.eIq ? "1" : "2");
                    a.this.onClick(a.this.iOX);
                    if (a.this.Zk != null) {
                        a.this.Zk.a(a.this);
                    }
                    if (a.this.jlv != null) {
                        a.this.jlv.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cAJ() {
                    a.this.onClick(a.this.iOW);
                }
            });
            this.iPl.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void pW(boolean z2) {
                    a.this.iPl.fW(a.this.iPm.iPM.videoUrl, a.this.iPm.threadId);
                    a.this.JW("2");
                    a.this.onClick(a.this.iOX);
                }
            });
            this.iPl.wl(false);
            if (this.jlu != null) {
                this.jlu.reset();
            }
            this.startPosition = -1L;
            if (this.iPl.getVideoView() != null && this.iPl.getVideoView().getMediaProgressObserver() != null) {
                this.iPl.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ce(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.iPm.iPM.iPW;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.hYe.a(a.this.isFullScreen, a.this.iPl != null && a.this.iPl.dvX(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.hYe.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.iPl.dvX() && !com.baidu.mcn.b.Zg().jg(aVar2.Zz)) {
                            boolean z3 = a.this.startPosition >= (aVar2.iPO * 1000) + 1000;
                            if (i3 < aVar2.iPO * 1000 || i3 >= aVar2.iPP * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jlu.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bWo = aVar2.iPR;
                                    aVar3.bWp = aVar2.iPS;
                                    aVar3.bWq = aVar2.Zz;
                                    aVar3.bWn = aVar2.iPQ;
                                    aVar3.fid = a.this.iPm != null ? a.this.iPm.forumId : null;
                                    aVar3.tid = a.this.iPm != null ? a.this.iPm.threadId : null;
                                    aVar3.bWr = 3;
                                    if (z3) {
                                        a.this.jlu.b(aVar3, (ViewGroup) a.this.iPl.dwp());
                                    } else {
                                        a.this.jlu.a(aVar3, (ViewGroup) a.this.iPl.dwp());
                                    }
                                }
                            } else if (a.this.jlu.isShowing()) {
                                a.this.jlu.dismiss();
                            }
                        }
                    }
                });
            }
            this.iPo = new o();
            this.iPo.alZ = gVar.threadId;
            this.iPo.mNid = gVar.nid;
            this.iPo.fyg = gVar.forumId;
            this.iPo.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iPo.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.iPo.mSource = gVar.source;
            this.iPo.mkk = gVar.weight;
            this.iPo.mkm = this.mFrom;
            this.iPo.mko = gVar.abtest_tag;
            this.iPo.ezo = this.ezo;
            this.iPo.mExtra = gVar.extra;
            this.iPo.mkr = "0";
            this.iPo.mkn = gVar.getVideoType();
            this.iPp = new o();
            this.iPp.alZ = gVar.threadId;
            this.iPp.fyg = gVar.forumId;
            this.iPp.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iPp.mkk = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iPp.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iPp.mkm = this.mFrom;
            this.iPp.mSource = gVar.source;
            this.iPp.mkr = "0";
            if (gVar.iPM != null) {
                this.iPo.mkp = gVar.iPM.videoMd5;
                this.iPp.mkp = gVar.iPM.videoMd5;
            }
            ar arVar = new ar("c12590");
            arVar.dR("tid", gVar.threadId);
            arVar.dR("nid", gVar.nid);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.ak("obj_locate", i);
            arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dR("fid", gVar.forumId);
            arVar.dR("obj_param1", au.isEmpty(gVar.weight) ? "0" : gVar.weight);
            arVar.dR("extra", au.isEmpty(gVar.extra) ? "0" : gVar.extra);
            arVar.dR("obj_id", this.ezo);
            arVar.dR("ab_tag", au.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            arVar.dR("obj_type", this.mFrom);
            arVar.ak("obj_param5", gVar.getVideoType());
            arVar.dR("obj_source", au.isEmpty(gVar.source) ? "0" : gVar.source);
            arVar.ak("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                arVar.dR("obj_param4", gVar.mBaijiahao.oriUgcNid);
                arVar.dR("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(arVar);
            this.iPl.getVideoView().setVideoStatData(this.iPo);
            this.iPl.cZk();
            this.iPl.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.hYe.a(a.this.isFullScreen, a.this.iPl != null && a.this.iPl.dvX(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.iPr = true;
                            a.this.jlk = true;
                            a.this.iPq = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.zJ(i);
                            a.this.iPl.cMa();
                        }
                    }
                }
            });
            this.iPl.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.iPm != null && a.this.iPm.iPM != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.iPm.iPM.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.hYe.reset();
            }
            this.hYe.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rR() {
                    a.this.jlk = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rQ() {
                    if (a.this.isFullScreen) {
                        a.this.iPr = true;
                        a.this.jlk = true;
                        a.this.iPq = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.zJ(i);
                        a.this.iPl.cMa();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rP() {
                    if (a.this.iPl != null) {
                        a.this.iPl.HO(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rS() {
                    return a.this.cGm();
                }
            });
            this.iPl.setThumbnail(gVar.iPM.thumbnailUrl);
            this.iPl.HN(gVar.iPM.videoDuration);
            this.iPl.setVideoUrl(gVar.iPM.videoUrl, gVar.threadId);
            this.iPl.setFid(gVar.forumId);
            this.iPl.cMa();
            this.iPl.show();
            qA(false);
            if (gVar.autoPlay) {
                onClick(this.iOX);
                if (this.jls.drQ()) {
                    this.iPl.wr(false);
                    this.jls.dRL();
                    this.iPl.ws(true);
                    this.iPl.fV(gVar.iPM.videoUrl, gVar.threadId);
                    if (this.hYe.rA()) {
                        this.hYe.stop();
                        this.hYe.rF();
                    }
                } else {
                    this.iPl.ws(false);
                    this.iPl.wr(false);
                    this.jls.hide();
                    if (this.hYe == null || (this.hYe != null && !this.hYe.rA())) {
                        this.iPl.a(gVar.iPM.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.iPN) {
                    this.jln.setVisibility(8);
                    this.jlr.Bg(3);
                } else {
                    if (this.jln.getVisibility() == 0) {
                        this.jln.startAnimation(this.bWC);
                    }
                    this.jlr.Bg(0);
                }
                gVar.iPN = false;
            } else {
                this.jln.setVisibility(0);
                this.jls.hide();
                this.iPl.wr(true);
                this.jlr.Bg(3);
                this.iPl.fV(gVar.iPM.videoUrl, gVar.threadId);
            }
            this.iPr = false;
            this.jlk = false;
            if (!z && this.hYe.rA()) {
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
        com.baidu.afd.videopaster.data.b KE = this.jlt != null ? this.jlt.KE(gVar.getThreadId()) : null;
        if (KE == null) {
            return null;
        }
        int rW = KE.rW();
        int rX = KE.rX();
        int rV = KE.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.iPM != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.iPM.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.iPM.videoHeight, 0);
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
    public void JW(String str) {
        if (this.iPm != null && this.iPm.iPM != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iPm.iPM.videoMd5, "", str, this.iPp, this.iPl.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.iPl.rK();
    }

    public boolean cGk() {
        return this.hYe.rA();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iPl.aPd();
        }
    }

    public boolean zK(int i) {
        if (i == 4 && this.hYe != null && ((this.hYe.rA() || this.jlk) && this.iPl != null)) {
            this.hYe.aZ(i);
            if (this.isFullScreen) {
                if (this.hYe.rz()) {
                    this.iPl.dvY();
                } else {
                    this.iPl.SH();
                }
                return true;
            }
        }
        return this.iPl.HO(i);
    }

    public void cAF() {
        this.jlm = false;
        this.iPl.stopPlay();
        if (this.jlg != null) {
            this.jlg.setVisibility(0);
        }
        if (this.jlr != null) {
            this.jlr.Bg(2);
        }
        qA(false);
        this.jll = true;
        if (this.hYe != null && this.hYe.rA()) {
            this.hYe.stop();
        }
    }

    public void cGl() {
        this.hYe.stop();
    }

    public void cAG() {
        if (this.iPl != null) {
            this.iPl.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cAG();
        if (this.iPn != null) {
            this.iPn.cAQ();
        }
        if (this.jln != null) {
            this.jln.clearAnimation();
        }
        this.hYe.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.iPL != null) {
            this.ajz.setText(TextUtils.isEmpty(gVar.iPL.userNickname) ? gVar.iPL.userName : gVar.iPL.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.iPL != null) {
            if (gVar.iPL.iPV != null && !TextUtils.isEmpty(gVar.iPL.iPV.avatar)) {
                this.iPd.startLoad(gVar.iPL.iPV.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.iPL.portrait) && gVar.iPL.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iPd.startLoad(gVar.iPL.portrait, 10, false);
            } else {
                this.iPd.startLoad(gVar.iPL.portrait, 12, false);
            }
            if (gVar.iPL.iPV != null && gVar.iPL.iPV.auth_id.intValue() > 0) {
                this.iPd.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.iPL.iPV.auth_id.intValue(), 1));
                this.iPd.setShowV(true);
                this.iPd.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.iPd.setBjhAuthIconRes(0);
            if (gVar.iPL.isBigV) {
                this.iPd.setShowV(gVar.iPL.isBigV);
                this.iPd.setIsBigV(gVar.iPL.isBigV);
            } else if (gVar.iPL.isGod) {
                this.iPd.setShowV(gVar.iPL.isGod);
                this.iPd.setIsBigV(gVar.iPL.isGod);
            } else {
                this.iPd.setShowV(gVar.iPL.isGod);
                this.iPd.setIsBigV(gVar.iPL.isGod);
            }
            this.iPd.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bnv() != null) {
                gVar.bnv().isInThread = true;
                gVar.bnv().nid = gVar.nid;
                if (this.iPm.getVideoType() == 1) {
                    gVar.bnv().cardType = 2;
                } else if (this.iPm.getVideoType() == 2) {
                    gVar.bnv().cardType = 8;
                } else if (this.iPm.getVideoType() == 3) {
                    gVar.bnv().cardType = 6;
                }
                gVar.bnv().baijiahaoData = gVar.mBaijiahao;
                gVar.bnv().recomSource = gVar.source;
                gVar.bnv().recomWeight = gVar.weight;
                gVar.bnv().recomAbTag = gVar.abtest_tag;
                gVar.bnv().recomExtra = gVar.extra;
            }
            this.eVi.setAgreeAlone(true);
            this.eVi.setIsFromMiddlePage(true);
            this.eVi.setData(gVar.bnv());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.euD.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.eVk, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.euD.setText(au.numFormatOverWan(gVar.postNum));
            } else {
                this.euD.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.ivH.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.eVn, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.ivH.setText(au.numFormatOverWan(gVar.shareNum));
            } else {
                this.ivH.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iPl != null && this.iOX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iPq) {
                this.iPl.dwe();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cGn();
            } else {
                configuration.orientation = 1;
                cGo();
                this.iPq = true;
            }
            this.iPl.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cGm() {
        if (this.iPl != null && this.iOX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iOX.getParent() != null) {
                if (this.iOX.getParent() == frameLayout) {
                    if (this.jlw) {
                        this.jlw = false;
                        return true;
                    } else if (!this.jlx) {
                        this.jlx = true;
                        return true;
                    }
                } else if (this.iOX.getParent() == this.iOW) {
                    if (this.jlx) {
                        this.jlx = false;
                        this.jly = true;
                        return true;
                    } else if (!this.jlw && this.jly) {
                        this.jlw = true;
                        this.jly = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGn() {
        if (this.iPl != null && this.iOX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.iOX.getParent() != null) {
                if (this.iOX.getParent() == frameLayout) {
                    frameLayout.removeView(this.iOX);
                } else if (this.iOX.getParent() == this.iOW) {
                    this.iOW.removeView(this.iOX);
                }
            }
            if (this.iOX.getParent() == null) {
                frameLayout.addView(this.iOX);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iOX.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iOX.setLayoutParams(layoutParams);
                if (this.jlu != null && this.jlu.isShowing()) {
                    this.jlu.dismiss();
                }
                com.baidu.tbadk.util.e.bCJ().kG(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGo() {
        if (this.iPl != null && this.iOX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.iOX.getParent() != null) {
                if (this.iOX.getParent() == frameLayout) {
                    cGp();
                    frameLayout.removeView(this.iOX);
                } else if (this.iOX.getParent() == this.iOW) {
                    cGp();
                    this.iOW.removeView(this.iOX);
                }
            }
            if (this.iOX.getParent() == null) {
                this.iOW.addView(this.iOX, 0);
                cGq();
                this.iPl.cZk();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bCJ().kG(false);
            }
        }
    }

    private void cGp() {
        if (this.hYe != null && this.hYe.rA()) {
            this.hYe.aB(true);
        }
    }

    private void cGq() {
        int i;
        if (!cGi()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.iOX.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cnv() != null) {
            view.setTag(this);
            cnv().a(view, this.iPm);
        }
        if (view == this.iPd || view == this.ajz) {
            if (this.iPm != null && this.iPm.iPL != null && !TextUtils.isEmpty(this.iPm.iPL.userId)) {
                this.jlr.Bg(0);
                if (!TbadkCoreApplication.isLogin() || !this.iPm.iPL.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iPm.iPL.userId, 0L), z, this.iPm.iPL.isGod)));
            }
        } else if (view == this.eVl) {
            if (this.iPm != null) {
                this.jlr.Bg(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iPm.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.iPm.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jlg || view == this.jlh) {
            if (this.iPm != null) {
                if (this.jlr.getCurrentState() != 2 && this.jlr.getCurrentState() != 3) {
                    z = false;
                }
                this.jlr.Bg(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.iPm.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.iPm.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.eVo) {
            this.jlr.Bg(0);
            bsj();
        } else if (view == this.jln && this.jln.getVisibility() == 0 && this.jlp != null) {
            this.jlp.Bk(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pV(boolean z) {
        if (this.iPm != null && this.iPm.iPL != null) {
            this.iPm.iPL.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cAH() {
        if (this.iPm != null) {
            this.eVi.brs();
        }
    }

    public void qz(boolean z) {
        if (this.iOW != null) {
            this.iOW.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jlv = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jlp = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Zk = fVar;
    }

    private void qA(boolean z) {
        this.jll = this.mPosition == (this.jlq == null ? -1 : this.jlq.cGC());
        if (this.jll && z && isPlaying() && this.eIq && !this.jlm) {
            this.jli.setVisibility(0);
            this.jlm = true;
            this.jli.postDelayed(this.jlB, 5000L);
            if (this.jlq != null) {
                this.jlq.fO(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jli.setVisibility(8);
        if (this.jlB != null) {
            this.jli.removeCallbacks(this.jlB);
        }
    }

    private void bsj() {
        String str;
        String str2;
        if (this.iPm != null && this.mContext != null) {
            String valueOf = String.valueOf(this.iPm.forumId);
            String str3 = this.iPm.title;
            if (this.iPm.mBaijiahao != null) {
                str = this.iPm.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.iPm.mBaijiahao.oriUgcType + "&dvid=" + this.iPm.mBaijiahao.oriUgcVid + "&nid=" + this.iPm.mBaijiahao.oriUgcNid;
            } else {
                str = this.iPm.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.iPm.iPM.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.iPm.title;
            String format = (this.iPm.mBaijiahao == null || this.iPm.iPL == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.iPm.iPL.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.iPm.mBaijiahao != null) {
                shareItem.fgc = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fgc = str6;
                shareItem.readCount = this.iPm.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fgf = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.ffR = true;
            shareItem.fge = 11;
            if (this.iPm.getVideoType() == 1) {
                shareItem.fgj = 2;
            } else if (this.iPm.getVideoType() == 2) {
                shareItem.fgj = 8;
            } else if (this.iPm.getVideoType() == 3) {
                shareItem.fgj = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.iPm.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.iPm.mBaijiahao;
            shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dR("tid", str);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.ak("obj_locate", 12);
            arVar.dR("nid", this.iPm.nid);
            if (this.iPm.mBaijiahao != null && !au.isEmpty(this.iPm.mBaijiahao.oriUgcVid)) {
                arVar.dR("obj_param6", this.iPm.mBaijiahao.oriUgcVid);
            }
            if (this.iPm.getVideoType() == 1) {
                arVar.ak(IntentConfig.CARD_TYPE, 2);
            } else if (this.iPm.getVideoType() == 2) {
                arVar.ak(IntentConfig.CARD_TYPE, 8);
            } else if (this.iPm.getVideoType() == 3) {
                arVar.ak(IntentConfig.CARD_TYPE, 6);
            }
            arVar.dR(IntentConfig.RECOM_SOURCE, this.iPm.source);
            arVar.dR("ab_tag", this.iPm.abtest_tag);
            arVar.dR("weight", this.iPm.weight);
            arVar.dR("extra", this.iPm.extra);
            arVar.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                arVar.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                arVar.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(arVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgf);
            bundle.putInt("obj_type", shareItem.fgj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eFG);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.d.f.coW().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        cAF();
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aPd() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(boolean z) {
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

    public void cGr() {
        this.hYe.resume();
    }

    public boolean cGs() {
        if (this.jlr != null) {
            return this.jlr.getCurrentState() == 2 || this.jlr.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0737a {
        private int chm;
        private Runnable jlG;

        private C0737a() {
            this.chm = -1;
            this.jlG = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(C0737a.this.jlG);
                    C0737a.this.Bg(2);
                }
            };
        }

        public void Bg(int i) {
            switch (i) {
                case 0:
                    this.chm = Bh(i);
                    cGt();
                    return;
                case 1:
                    this.chm = Bh(i);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jlG);
                    return;
                case 2:
                    this.chm = Bi(i);
                    return;
                case 3:
                    this.chm = Bj(i);
                    cGt();
                    return;
                default:
                    this.chm = Bi(i);
                    return;
            }
        }

        private void cGt() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jlG);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jlG, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.chm;
        }

        private int Bh(int i) {
            if (i != this.chm) {
                a.this.jlo.setVisibility(8);
                a.this.qB(true);
                return i;
            }
            return this.chm;
        }

        private int Bi(int i) {
            int i2 = this.chm;
            if (i != this.chm) {
                a.this.jlo.setVisibility(0);
                if (i2 != 3 || a.this.iPm.autoPlay) {
                    a.this.qB(false);
                    return i;
                }
                return i;
            }
            return this.chm;
        }

        private int Bj(int i) {
            if (i != this.chm) {
                a.this.jlo.setVisibility(0);
                a.this.qB(true);
                return i;
            }
            return this.chm;
        }
    }
}
