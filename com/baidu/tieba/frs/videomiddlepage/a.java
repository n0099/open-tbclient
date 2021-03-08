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
    private com.baidu.tieba.lego.card.view.f acd;
    public TextView alr;
    private Animation cjx;
    private Animation cjy;
    private TextView eKe;
    private String ePf;
    private boolean eYE;
    private ImageView flA;
    private View flB;
    protected AgreeView flv;
    private ImageView flx;
    private View fly;
    private int iPg;
    private TextView iVK;
    private boolean isFullScreen;
    private com.baidu.afd.videopaster.d iys;
    private Runnable jOA;
    private Runnable jOB;
    public ExpandableTextView jOf;
    private View jOg;
    private FrameLayout jOh;
    private TextView jOi;
    private boolean jOj;
    private boolean jOk;
    private boolean jOl;
    private View jOm;
    private View jOn;
    private c jOo;
    public com.baidu.tieba.frs.videomiddlepage.a.a jOp;
    private C0743a jOq;
    private VideoNetworkStateTipView jOr;
    private b jOs;
    private com.baidu.mcn.c jOt;
    private com.baidu.tieba.lego.card.view.g jOu;
    private boolean jOv;
    private boolean jOw;
    private boolean jOx;
    private Animation.AnimationListener jOy;
    private Animation.AnimationListener jOz;
    public FrameLayout joZ;
    public FrameLayout jpa;
    public HeadImageView jpg;
    public com.baidu.tieba.play.c jpo;
    public com.baidu.tieba.frs.aggregation.g jpp;
    private com.baidu.tieba.frs.aggregation.h jpq;
    private o jpr;
    private o jps;
    private boolean jpt;
    private boolean jpu;
    private boolean jpx;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.jpt = true;
        this.jpx = true;
        this.jOk = false;
        this.jOl = false;
        this.jOv = false;
        this.jOw = false;
        this.jOx = false;
        this.startPosition = -1L;
        this.iPg = 0;
        this.jOy = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jOm != null) {
                    a.this.jOm.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jOm != null) {
                    a.this.jOm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOz = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jOm != null) {
                    a.this.jOm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jOm != null) {
                    a.this.jOm.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOA = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jOh.getVisibility() == 0) {
                    a.this.jOh.setVisibility(8);
                }
            }
        };
        this.jOB = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jpo != null) {
                    a.this.jpo.stopPlay();
                }
            }
        };
        this.jpx = z;
        this.mFrom = str;
        this.ePf = str2;
        this.jOs = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.joZ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jOg = view.findViewById(R.id.card_container);
        this.jpa = (FrameLayout) view.findViewById(R.id.video_container);
        this.jpo = new com.baidu.tieba.play.c(tbPageContext, this.jpa, false);
        this.jpo.setStageType("2005");
        this.jpo.xe(z);
        this.jpo.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jOp != null && a.this.jpp.jpP.videoDuration > 8) {
                    a.this.jOp.bC(a.this.mPosition, a.this.jpp.jpP.videoUrl);
                }
            }
        });
        this.jpo.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.a
            public void rI(boolean z2) {
                if (a.this.jOq != null) {
                    if (z2) {
                        a.this.jOq.AM(0);
                    } else {
                        a.this.jOq.AM(1);
                    }
                }
            }
        });
        this.jpo.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jOf = (ExpandableTextView) view.findViewById(R.id.title);
        this.jpg = (HeadImageView) view.findViewById(R.id.user_icon);
        this.alr = (TextView) view.findViewById(R.id.user_name);
        this.flv = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNC = 2;
        eVar.eNH = 6;
        this.flv.setStatisticData(eVar);
        this.flv.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.eKe = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.flx = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fly = view.findViewById(R.id.thread_info_commont_container);
        this.iVK = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.flA = (ImageView) view.findViewById(R.id.share_num_img);
        this.flB = view.findViewById(R.id.share_num_container);
        this.jOh = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jOi = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jOh.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jOi.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.brR().getString("nani_key_download_link_url", null);
        this.jOi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bsY().a((TbPageContext) j.J(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jOr = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jOr.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c13257"));
                a.this.jOr.setHasAgreeToPlay(true);
                a.this.jpo.xl(false);
                a.this.jOr.dVu();
                if (a.this.iys.rc()) {
                    a.this.iys.resume();
                } else if (a.this.jpp != null && a.this.jpp.jpP != null) {
                    a.this.jpo.fX(a.this.jpp.jpP.videoUrl, a.this.jpp.threadId);
                }
            }
        });
        this.jOm = view.findViewById(R.id.video_agg_container_foreground);
        this.jOn = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jOm.setOnClickListener(this);
        this.fly.setOnClickListener(this);
        this.flB.setOnClickListener(this);
        this.jOf.setOnClickListener(this);
        this.jpg.setOnClickListener(this);
        this.alr.setOnClickListener(this);
        this.jOg.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.iPg = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joZ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.joZ.setLayoutParams(layoutParams);
        this.jpg.setIsRound(true);
        this.jpg.setPlaceHolder(1);
        this.jpq = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.cjx = new AlphaAnimation(0.0f, 0.7f);
        this.cjx.setDuration(500L);
        this.cjx.setAnimationListener(this.jOz);
        this.cjy = new AlphaAnimation(0.7f, 0.0f);
        this.cjy.setDuration(500L);
        this.cjy.setAnimationListener(this.jOy);
        this.jOq = new C0743a();
        this.iys = new com.baidu.afd.videopaster.d(getContext(), this.jpa);
        this.jOt = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.flv.onChangeSkinType(i);
        this.eKe.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.iVK.setTextColor(ap.getColor(R.color.CAM_X0107));
        WebPManager.a(this.flA, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.flx, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jOf.onChangeSkinType();
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
        if (gVar != null && gVar.jpP != null) {
            boolean z = this.jpp == gVar;
            this.jpp = gVar;
            this.eYE = this.jpp.autoPlay;
            this.jOl = false;
            rG(false);
            this.jOf.setVisibility(0);
            this.jOf.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jOf.setTextColor(R.color.CAM_X0101);
            this.jOf.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.jpP != null && !StringUtils.isNull(gVar.jpP.mcnLeadPage)) {
                this.jOf.setTextMaxLine(2);
                this.jOf.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jOf.getContentView(), gVar.title, gVar.jpP.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jOf.setTextMaxLine(Integer.MAX_VALUE);
                this.jOf.setExpandable(true);
                this.jOf.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rJ(boolean z2) {
                        a.this.jpp.isTitleExpanded = z2;
                    }
                });
                this.jOf.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.iPg) {
                this.jpo.dAg();
                this.iPg = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.jpa.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jpa.setLayoutParams(layoutParams);
            }
            cMm();
            a(gVar, i, aVar, z);
            j(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.jpp = gVar;
        this.eYE = this.jpp.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cMl() {
        try {
            int parseInt = Integer.parseInt(this.jpp.jpP.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.jpp.jpP.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cMm() {
        if (!cMl()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joZ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.joZ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.joZ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.joZ.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.jpP != null) {
            this.jpo.stopPlay();
            this.jpo.xm(true);
            this.jpo.xi(true);
            this.jpo.xn(true);
            this.jpo.ax(false, false);
            this.jpo.Hp(i);
            this.jpo.a(new c.InterfaceC0855c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rj() {
                    a.this.cMq();
                    if (a.this.iys != null) {
                        a.this.iys.rj();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rk() {
                    a.this.cMr();
                    if (a.this.jpo.rl()) {
                    }
                    if (a.this.jpu || (a.this.iys != null && a.this.iys.rc())) {
                        com.baidu.adp.lib.f.e.mA().removeCallbacks(a.this.jOB);
                        com.baidu.adp.lib.f.e.mA().post(a.this.jOB);
                    }
                    if (a.this.iys != null) {
                        a.this.iys.rk();
                    }
                }
            });
            this.jpo.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.l
                public void cFB() {
                    if (a.this.jpp != null && a.this.jpp.jpP != null && com.baidu.adp.lib.f.b.toInt(a.this.jpp.jpP.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.jpp.jpP.videoWidth, 0)) {
                        a.this.jpo.ax(false, false);
                    } else {
                        a.this.jpo.ax(true, false);
                    }
                    a.this.jpu = false;
                    a.this.Kw(a.this.eYE ? "1" : "2");
                    a.this.onClick(a.this.jpa);
                    if (a.this.acd != null) {
                        a.this.acd.a(a.this);
                    }
                    if (a.this.jOu != null) {
                        a.this.jOu.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFC() {
                    a.this.onClick(a.this.joZ);
                }
            });
            this.jpo.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.18
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z2) {
                    a.this.jpo.fX(a.this.jpp.jpP.videoUrl, a.this.jpp.threadId);
                    a.this.Kw("2");
                    a.this.onClick(a.this.jpa);
                }
            });
            this.jpo.xd(false);
            if (this.jOt != null) {
                this.jOt.reset();
            }
            this.startPosition = -1L;
            if (this.jpo.getVideoView() != null && this.jpo.getVideoView().getMediaProgressObserver() != null) {
                this.jpo.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void cf(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.jpp.jpP.jpZ;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.iys.b(a.this.isFullScreen, a.this.jpo != null && a.this.jpo.dzN(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.iys.a(a.this.i(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.jpo.dzN() && !com.baidu.mcn.b.abu().je(aVar2.acv)) {
                            boolean z3 = a.this.startPosition >= (aVar2.jpR * 1000) + 1000;
                            if (i3 < aVar2.jpR * 1000 || i3 >= aVar2.jpS * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jOt.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.cjk = aVar2.jpU;
                                    aVar3.cjl = aVar2.jpV;
                                    aVar3.cjm = aVar2.acv;
                                    aVar3.cjj = aVar2.jpT;
                                    aVar3.fid = a.this.jpp != null ? a.this.jpp.forumId : null;
                                    aVar3.tid = a.this.jpp != null ? a.this.jpp.threadId : null;
                                    aVar3.cjn = 3;
                                    if (z3) {
                                        a.this.jOt.b(aVar3, (ViewGroup) a.this.jpo.dAf());
                                    } else {
                                        a.this.jOt.a(aVar3, (ViewGroup) a.this.jpo.dAf());
                                    }
                                }
                            } else if (a.this.jOt.isShowing()) {
                                a.this.jOt.dismiss();
                            }
                        }
                    }
                });
            }
            this.jpr = new o();
            this.jpr.anU = gVar.threadId;
            this.jpr.eVa = gVar.nid;
            this.jpr.fOD = gVar.forumId;
            this.jpr.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jpr.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.jpr.mSource = gVar.source;
            this.jpr.mKz = gVar.weight;
            this.jpr.mKB = this.mFrom;
            this.jpr.mKD = gVar.abtest_tag;
            this.jpr.ePf = this.ePf;
            this.jpr.mExtra = gVar.extra;
            this.jpr.mKG = "0";
            this.jpr.mKC = gVar.getVideoType();
            this.jps = new o();
            this.jps.anU = gVar.threadId;
            this.jps.fOD = gVar.forumId;
            this.jps.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jps.mKz = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jps.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jps.mKB = this.mFrom;
            this.jps.mSource = gVar.source;
            this.jps.mKG = "0";
            if (gVar.jpP != null) {
                this.jpr.mKE = gVar.jpP.videoMd5;
                this.jps.mKE = gVar.jpP.videoMd5;
            }
            ar arVar = new ar("c12590");
            arVar.dR("tid", gVar.threadId);
            arVar.dR(IntentConfig.NID, gVar.nid);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.aq("obj_locate", i);
            arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dR("fid", gVar.forumId);
            arVar.dR("obj_param1", au.isEmpty(gVar.weight) ? "0" : gVar.weight);
            arVar.dR("extra", au.isEmpty(gVar.extra) ? "0" : gVar.extra);
            arVar.dR("obj_id", this.ePf);
            arVar.dR("ab_tag", au.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            arVar.dR("obj_type", this.mFrom);
            arVar.aq("obj_param5", gVar.getVideoType());
            arVar.dR("obj_source", au.isEmpty(gVar.source) ? "0" : gVar.source);
            arVar.aq("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                arVar.dR("obj_param4", gVar.mBaijiahao.oriUgcNid);
                arVar.dR("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(arVar);
            this.jpo.getVideoView().setVideoStatData(this.jpr);
            this.jpo.dcE();
            this.jpo.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.iys.b(a.this.isFullScreen, a.this.jpo != null && a.this.jpo.dzN(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.jpu = true;
                            a.this.jOj = true;
                            a.this.jpt = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.zf(i);
                            a.this.jpo.cSR();
                        }
                    }
                }
            });
            this.jpo.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.jpp != null && a.this.jpp.jpP != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.jpp.jpP.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.iys.reset();
            }
            this.iys.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rs() {
                    a.this.jOj = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rr() {
                    if (a.this.isFullScreen) {
                        a.this.jpu = true;
                        a.this.jOj = true;
                        a.this.jpt = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.zf(i);
                        a.this.jpo.cSR();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rq() {
                    if (a.this.jpo != null) {
                        a.this.jpo.Ho(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rt() {
                    return a.this.cMp();
                }
            });
            this.jpo.setThumbnail(gVar.jpP.thumbnailUrl);
            this.jpo.Hn(gVar.jpP.videoDuration);
            this.jpo.setVideoUrl(gVar.jpP.videoUrl, gVar.threadId);
            this.jpo.setFid(gVar.forumId);
            this.jpo.cSR();
            this.jpo.show();
            rG(false);
            if (gVar.autoPlay) {
                onClick(this.jpa);
                if (this.jOr.dvK()) {
                    this.jpo.xk(false);
                    this.jOr.dVt();
                    this.jpo.xl(true);
                    this.jpo.fW(gVar.jpP.videoUrl, gVar.threadId);
                    if (this.iys.rc()) {
                        this.iys.stop();
                        this.iys.rg();
                    }
                } else {
                    this.jpo.xl(false);
                    this.jpo.xk(false);
                    this.jOr.hide();
                    if (this.iys == null || (this.iys != null && !this.iys.rc())) {
                        this.jpo.a(gVar.jpP.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.jpQ) {
                    this.jOm.setVisibility(8);
                    this.jOq.AM(3);
                } else {
                    if (this.jOm.getVisibility() == 0) {
                        this.jOm.startAnimation(this.cjy);
                    }
                    this.jOq.AM(0);
                }
                gVar.jpQ = false;
            } else {
                this.jOm.setVisibility(0);
                this.jOr.hide();
                this.jpo.xk(true);
                this.jOq.AM(3);
                this.jpo.fW(gVar.jpP.videoUrl, gVar.threadId);
            }
            this.jpu = false;
            this.jOj = false;
            if (!z && this.iys.rc()) {
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
        com.baidu.afd.videopaster.data.b Lv = this.jOs != null ? this.jOs.Lv(gVar.getThreadId()) : null;
        if (Lv != null) {
            int rx2 = Lv.rx();
            int ry = Lv.ry();
            int rw = Lv.rw();
            if (rw != -1) {
                i2 = rx2 != -1 ? (rw - rx2) - 1 : -1;
                i = ry != -1 ? (ry - rw) - 1 : -1;
            } else {
                i = -1;
                i2 = -1;
            }
            if (gVar.jpP != null) {
                i4 = com.baidu.adp.lib.f.b.toInt(gVar.jpP.videoWidth, 0);
                i3 = com.baidu.adp.lib.f.b.toInt(gVar.jpP.videoHeight, 0);
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
    public void Kw(String str) {
        if (this.jpp != null && this.jpp.jpP != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jpp.jpP.videoMd5, "", str, this.jps, this.jpo.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jpo.rl();
    }

    public boolean cMn() {
        return this.iys.rc();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jpo.pausePlay();
        }
    }

    public boolean zg(int i) {
        if (i == 4 && this.iys != null && ((this.iys.rc() || this.jOj) && this.jpo != null)) {
            this.iys.bf(i);
            if (this.isFullScreen) {
                if (this.iys.rb()) {
                    this.jpo.dzO();
                } else {
                    this.jpo.Uc();
                }
                return true;
            }
        }
        return this.jpo.Ho(i);
    }

    public void stopVideo() {
        this.jOl = false;
        this.jpo.stopPlay();
        if (this.jOf != null) {
            this.jOf.setVisibility(0);
        }
        if (this.jOq != null) {
            this.jOq.AM(2);
        }
        rG(false);
        this.jOk = true;
        if (this.iys != null && this.iys.rc()) {
            this.iys.stop();
        }
    }

    public void cMo() {
        this.iys.stop();
    }

    public void cFz() {
        if (this.jpo != null) {
            this.jpo.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cFz();
        if (this.jpq != null) {
            this.jpq.cFK();
        }
        if (this.jOm != null) {
            this.jOm.clearAnimation();
        }
        this.iys.onDestroy();
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.jpO != null) {
            this.alr.setText(TextUtils.isEmpty(gVar.jpO.userNickname) ? gVar.jpO.userName : gVar.jpO.userNickname);
            k(gVar);
            d(gVar);
            e(gVar);
            l(gVar);
        }
    }

    private void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jpO != null) {
            if (gVar.jpO.jpY != null && !TextUtils.isEmpty(gVar.jpO.jpY.avatar)) {
                this.jpg.startLoad(gVar.jpO.jpY.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.jpO.portrait) && gVar.jpO.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jpg.startLoad(gVar.jpO.portrait, 10, false);
            } else {
                this.jpg.startLoad(gVar.jpO.portrait, 12, false);
            }
            if (gVar.jpO.jpY != null && gVar.jpO.jpY.auth_id.intValue() > 0) {
                this.jpg.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.jpO.jpY.auth_id.intValue(), 1));
                this.jpg.setShowV(true);
                this.jpg.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jpg.setBjhAuthIconRes(0);
            if (gVar.jpO.isBigV) {
                this.jpg.setShowV(gVar.jpO.isBigV);
                this.jpg.setIsBigV(gVar.jpO.isBigV);
            } else if (gVar.jpO.isGod) {
                this.jpg.setShowV(gVar.jpO.isGod);
                this.jpg.setIsBigV(gVar.jpO.isGod);
            } else {
                this.jpg.setShowV(gVar.jpO.isGod);
                this.jpg.setIsBigV(gVar.jpO.isGod);
            }
            this.jpg.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(final com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bpL() != null) {
                gVar.bpL().isInThread = true;
                gVar.bpL().nid = gVar.nid;
                if (this.jpp.getVideoType() == 1) {
                    gVar.bpL().cardType = 2;
                } else if (this.jpp.getVideoType() == 2) {
                    gVar.bpL().cardType = 8;
                } else if (this.jpp.getVideoType() == 3) {
                    gVar.bpL().cardType = 6;
                }
                gVar.bpL().baijiahaoData = gVar.mBaijiahao;
                gVar.bpL().recomSource = gVar.source;
                gVar.bpL().recomWeight = gVar.weight;
                gVar.bpL().recomAbTag = gVar.abtest_tag;
                gVar.bpL().recomExtra = gVar.extra;
            }
            this.flv.setAgreeAlone(true);
            this.flv.setIsFromMiddlePage(true);
            this.flv.setData(gVar.bpL());
            this.flv.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (gVar.bpL().hasAgree && gVar.bpL().agreeType == 2) {
                        a.this.jOq.AM(0);
                    }
                }
            });
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eKe.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.flx, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.eKe.setText(au.numFormatOverWan(gVar.postNum));
            } else {
                this.eKe.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void l(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.iVK.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.flA, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.iVK.setText(au.numFormatOverWan(gVar.shareNum));
            } else {
                this.iVK.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jpo != null && this.jpa != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jpt) {
                this.jpo.dzU();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cMq();
            } else {
                configuration.orientation = 1;
                cMr();
                this.jpt = true;
            }
            this.jpo.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cMp() {
        if (this.jpo != null && this.jpa != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jpa.getParent() != null) {
                if (this.jpa.getParent() == frameLayout) {
                    if (this.jOv) {
                        this.jOv = false;
                        return true;
                    } else if (!this.jOw) {
                        this.jOw = true;
                        return true;
                    }
                } else if (this.jpa.getParent() == this.joZ) {
                    if (this.jOw) {
                        this.jOw = false;
                        this.jOx = true;
                        return true;
                    } else if (!this.jOv && this.jOx) {
                        this.jOv = true;
                        this.jOx = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMq() {
        if (this.jpo != null && this.jpa != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.jpa.getParent() != null) {
                if (this.jpa.getParent() == frameLayout) {
                    frameLayout.removeView(this.jpa);
                } else if (this.jpa.getParent() == this.joZ) {
                    this.joZ.removeView(this.jpa);
                }
            }
            if (this.jpa.getParent() == null) {
                frameLayout.addView(this.jpa);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jpa.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jpa.setLayoutParams(layoutParams);
                if (this.jOt != null && this.jOt.isShowing()) {
                    this.jOt.dismiss();
                }
                com.baidu.tbadk.util.e.bFk().lu(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMr() {
        if (this.jpo != null && this.jpa != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.jpa.getParent() != null) {
                if (this.jpa.getParent() == frameLayout) {
                    cMs();
                    frameLayout.removeView(this.jpa);
                } else if (this.jpa.getParent() == this.joZ) {
                    cMs();
                    this.joZ.removeView(this.jpa);
                }
            }
            if (this.jpa.getParent() == null) {
                this.joZ.addView(this.jpa, 0);
                cMt();
                this.jpo.dcE();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bFk().lu(false);
            }
        }
    }

    private void cMs() {
        if (this.iys != null && this.iys.rc()) {
            this.iys.az(true);
        }
    }

    private void cMt() {
        int i;
        if (!cMl()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.jpa.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (csi() != null) {
            view.setTag(this);
            csi().a(view, this.jpp);
        }
        if (view == this.jpg || view == this.alr) {
            if (this.jpp != null && this.jpp.jpO != null && !TextUtils.isEmpty(this.jpp.jpO.userId)) {
                this.jOq.AM(0);
                if (!TbadkCoreApplication.isLogin() || !this.jpp.jpO.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jpp.jpO.userId, 0L), z, this.jpp.jpO.isGod)));
            }
        } else if (view == this.fly) {
            if (this.jpp != null) {
                this.jOq.AM(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jpp.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.jpp.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jOf || view == this.jOg) {
            if (this.jpp != null) {
                if (this.jOq.getCurrentState() != 2 && this.jOq.getCurrentState() != 3) {
                    z = false;
                }
                this.jOq.AM(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.jpp.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.jpp.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.flB) {
            this.jOq.AM(0);
            buI();
        } else if (view == this.jOm && this.jOm.getVisibility() == 0 && this.jOo != null) {
            this.jOo.AQ(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qW(boolean z) {
        if (this.jpp != null && this.jpp.jpO != null) {
            this.jpp.jpO.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cFA() {
        if (this.jpp != null) {
            this.flv.btO();
        }
    }

    public void rF(boolean z) {
        if (this.joZ != null) {
            this.joZ.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jOu = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jOo = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.acd = fVar;
    }

    private void rG(boolean z) {
        this.jOk = this.mPosition == (this.jOp == null ? -1 : this.jOp.cMF());
        if (this.jOk && z && isPlaying() && this.eYE && !this.jOl) {
            this.jOh.setVisibility(0);
            this.jOl = true;
            this.jOh.postDelayed(this.jOA, 5000L);
            if (this.jOp != null) {
                this.jOp.gy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jOh.setVisibility(8);
        if (this.jOA != null) {
            this.jOh.removeCallbacks(this.jOA);
        }
    }

    private void buI() {
        String str;
        String str2;
        if (this.jpp != null && this.mContext != null) {
            String valueOf = String.valueOf(this.jpp.forumId);
            String str3 = this.jpp.title;
            if (this.jpp.mBaijiahao != null) {
                str = this.jpp.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.jpp.mBaijiahao.oriUgcType + "&dvid=" + this.jpp.mBaijiahao.oriUgcVid + "&nid=" + this.jpp.mBaijiahao.oriUgcNid;
            } else {
                str = this.jpp.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.jpp.jpP.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.jpp.title;
            String format = (this.jpp.mBaijiahao == null || this.jpp.jpO == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.jpp.jpO.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.jpp.mBaijiahao != null) {
                shareItem.fwu = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fwu = str6;
                shareItem.readCount = this.jpp.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fwx = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fwj = true;
            shareItem.fww = 11;
            if (this.jpp.getVideoType() == 1) {
                shareItem.fwB = 2;
            } else if (this.jpp.getVideoType() == 2) {
                shareItem.fwB = 8;
            } else if (this.jpp.getVideoType() == 3) {
                shareItem.fwB = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.jpp.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.jpp.mBaijiahao;
            shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dR("tid", str);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.aq("obj_locate", 12);
            arVar.dR(IntentConfig.NID, this.jpp.nid);
            if (this.jpp.mBaijiahao != null && !au.isEmpty(this.jpp.mBaijiahao.oriUgcVid)) {
                arVar.dR("obj_param6", this.jpp.mBaijiahao.oriUgcVid);
            }
            if (this.jpp.getVideoType() == 1) {
                arVar.aq(IntentConfig.CARD_TYPE, 2);
            } else if (this.jpp.getVideoType() == 2) {
                arVar.aq(IntentConfig.CARD_TYPE, 8);
            } else if (this.jpp.getVideoType() == 3) {
                arVar.aq(IntentConfig.CARD_TYPE, 6);
            }
            arVar.dR(IntentConfig.RECOM_SOURCE, this.jpp.source);
            arVar.dR("ab_tag", this.jpp.abtest_tag);
            arVar.dR("weight", this.jpp.weight);
            arVar.dR("extra", this.jpp.extra);
            arVar.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                arVar.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                arVar.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(arVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fwx);
            bundle.putInt("obj_type", shareItem.fwB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eVJ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.ctM().b(shareDialogConfig);
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

    public void cMu() {
        this.iys.resume();
    }

    public boolean cMv() {
        if (this.jOq != null) {
            return this.jOq.getCurrentState() == 2 || this.jOq.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0743a {
        private int eBs;
        private Runnable jOF;

        private C0743a() {
            this.eBs = -1;
            this.jOF = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(C0743a.this.jOF);
                    C0743a.this.AM(2);
                }
            };
        }

        public void AM(int i) {
            switch (i) {
                case 0:
                    this.eBs = AN(i);
                    cMw();
                    return;
                case 1:
                    this.eBs = AN(i);
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jOF);
                    return;
                case 2:
                    this.eBs = AO(i);
                    return;
                case 3:
                    this.eBs = AP(i);
                    cMw();
                    return;
                default:
                    this.eBs = AO(i);
                    return;
            }
        }

        private void cMw() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jOF);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jOF, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.eBs;
        }

        private int AN(int i) {
            if (i != this.eBs) {
                a.this.jOn.setVisibility(8);
                a.this.rH(true);
                return i;
            }
            return this.eBs;
        }

        private int AO(int i) {
            int i2 = this.eBs;
            if (i != this.eBs) {
                a.this.jOn.setVisibility(0);
                if (i2 != 3 || a.this.jpp.autoPlay) {
                    a.this.rH(false);
                    return i;
                }
                return i;
            }
            return this.eBs;
        }

        private int AP(int i) {
            if (i != this.eBs) {
                a.this.jOn.setVisibility(0);
                a.this.rH(true);
                return i;
            }
            return this.eBs;
        }
    }
}
