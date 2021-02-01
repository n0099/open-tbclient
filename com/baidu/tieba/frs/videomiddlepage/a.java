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
    private int iNj;
    private TextView iTN;
    private boolean isFullScreen;
    private com.baidu.afd.videopaster.d iwv;
    private boolean jMA;
    private Animation.AnimationListener jMB;
    private Animation.AnimationListener jMC;
    private Runnable jMD;
    private Runnable jME;
    public ExpandableTextView jMi;
    private View jMj;
    private FrameLayout jMk;
    private TextView jMl;
    private boolean jMm;
    private boolean jMn;
    private boolean jMo;
    private View jMp;
    private View jMq;
    private c jMr;
    public com.baidu.tieba.frs.videomiddlepage.a.a jMs;
    private C0736a jMt;
    private VideoNetworkStateTipView jMu;
    private b jMv;
    private com.baidu.mcn.c jMw;
    private com.baidu.tieba.lego.card.view.g jMx;
    private boolean jMy;
    private boolean jMz;
    private boolean jnA;
    public FrameLayout jnc;
    public FrameLayout jnd;
    public HeadImageView jnj;
    public com.baidu.tieba.play.c jnr;
    public com.baidu.tieba.frs.aggregation.g jns;
    private com.baidu.tieba.frs.aggregation.h jnt;
    private o jnu;
    private o jnv;
    private boolean jnw;
    private boolean jnx;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.jnw = true;
        this.jnA = true;
        this.jMn = false;
        this.jMo = false;
        this.jMy = false;
        this.jMz = false;
        this.jMA = false;
        this.startPosition = -1L;
        this.iNj = 0;
        this.jMB = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jMp != null) {
                    a.this.jMp.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jMp != null) {
                    a.this.jMp.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jMC = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jMp != null) {
                    a.this.jMp.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jMp != null) {
                    a.this.jMp.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jMD = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jMk.getVisibility() == 0) {
                    a.this.jMk.setVisibility(8);
                }
            }
        };
        this.jME = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jnr != null) {
                    a.this.jnr.stopPlay();
                }
            }
        };
        this.jnA = z;
        this.mFrom = str;
        this.eNE = str2;
        this.jMv = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jnc = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jMj = view.findViewById(R.id.card_container);
        this.jnd = (FrameLayout) view.findViewById(R.id.video_container);
        this.jnr = new com.baidu.tieba.play.c(tbPageContext, this.jnd, false);
        this.jnr.setStageType("2005");
        this.jnr.xe(z);
        this.jnr.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jMs != null && a.this.jns.jnS.videoDuration > 8) {
                    a.this.jMs.bC(a.this.mPosition, a.this.jns.jnS.videoUrl);
                }
            }
        });
        this.jnr.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.a
            public void rI(boolean z2) {
                if (a.this.jMt != null) {
                    if (z2) {
                        a.this.jMt.AL(0);
                    } else {
                        a.this.jMt.AL(1);
                    }
                }
            }
        });
        this.jnr.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jMi = (ExpandableTextView) view.findViewById(R.id.title);
        this.jnj = (HeadImageView) view.findViewById(R.id.user_icon);
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
        this.iTN = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.fkb = (ImageView) view.findViewById(R.id.share_num_img);
        this.fkc = view.findViewById(R.id.share_num_container);
        this.jMk = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jMl = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jMk.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jMl.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_download_link_url", null);
        this.jMl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bsV().a((TbPageContext) j.K(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jMu = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jMu.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c13257"));
                a.this.jMu.setHasAgreeToPlay(true);
                a.this.jnr.xl(false);
                a.this.jMu.dVe();
                if (a.this.iwv.rc()) {
                    a.this.iwv.resume();
                } else if (a.this.jns != null && a.this.jns.jnS != null) {
                    a.this.jnr.fX(a.this.jns.jnS.videoUrl, a.this.jns.threadId);
                }
            }
        });
        this.jMp = view.findViewById(R.id.video_agg_container_foreground);
        this.jMq = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jMp.setOnClickListener(this);
        this.fjZ.setOnClickListener(this);
        this.fkc.setOnClickListener(this);
        this.jMi.setOnClickListener(this);
        this.jnj.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.jMj.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.iNj = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jnc.setLayoutParams(layoutParams);
        this.jnj.setIsRound(true);
        this.jnj.setPlaceHolder(1);
        this.jnt = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.chW = new AlphaAnimation(0.0f, 0.7f);
        this.chW.setDuration(500L);
        this.chW.setAnimationListener(this.jMC);
        this.chX = new AlphaAnimation(0.7f, 0.0f);
        this.chX.setDuration(500L);
        this.chX.setAnimationListener(this.jMB);
        this.jMt = new C0736a();
        this.iwv = new com.baidu.afd.videopaster.d(getContext(), this.jnd);
        this.jMw = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fjW.onChangeSkinType(i);
        this.eID.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.iTN.setTextColor(ap.getColor(R.color.CAM_X0107));
        WebPManager.a(this.fkb, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fjY, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jMi.onChangeSkinType();
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
        if (gVar != null && gVar.jnS != null) {
            boolean z = this.jns == gVar;
            this.jns = gVar;
            this.eXf = this.jns.autoPlay;
            this.jMo = false;
            rG(false);
            this.jMi.setVisibility(0);
            this.jMi.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jMi.setTextColor(R.color.CAM_X0101);
            this.jMi.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.jnS != null && !StringUtils.isNull(gVar.jnS.mcnLeadPage)) {
                this.jMi.setTextMaxLine(2);
                this.jMi.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jMi.getContentView(), gVar.title, gVar.jnS.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jMi.setTextMaxLine(Integer.MAX_VALUE);
                this.jMi.setExpandable(true);
                this.jMi.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rJ(boolean z2) {
                        a.this.jns.isTitleExpanded = z2;
                    }
                });
                this.jMi.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.iNj) {
                this.jnr.dzQ();
                this.iNj = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.jnd.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jnd.setLayoutParams(layoutParams);
            }
            cLZ();
            a(gVar, i, aVar, z);
            j(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.jns = gVar;
        this.eXf = this.jns.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cLY() {
        try {
            int parseInt = Integer.parseInt(this.jns.jnS.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.jns.jnS.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cLZ() {
        if (!cLY()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnc.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.jnc.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jnc.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.jnc.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.jnS != null) {
            this.jnr.stopPlay();
            this.jnr.xm(true);
            this.jnr.xi(true);
            this.jnr.xn(true);
            this.jnr.ax(false, false);
            this.jnr.Hm(i);
            this.jnr.a(new c.InterfaceC0848c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rj() {
                    a.this.cMd();
                    if (a.this.iwv != null) {
                        a.this.iwv.rj();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rk() {
                    a.this.cMe();
                    if (a.this.jnr.rl()) {
                    }
                    if (a.this.jnx || (a.this.iwv != null && a.this.iwv.rc())) {
                        com.baidu.adp.lib.f.e.mA().removeCallbacks(a.this.jME);
                        com.baidu.adp.lib.f.e.mA().post(a.this.jME);
                    }
                    if (a.this.iwv != null) {
                        a.this.iwv.rk();
                    }
                }
            });
            this.jnr.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.l
                public void cFo() {
                    if (a.this.jns != null && a.this.jns.jnS != null && com.baidu.adp.lib.f.b.toInt(a.this.jns.jnS.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.jns.jnS.videoWidth, 0)) {
                        a.this.jnr.ax(false, false);
                    } else {
                        a.this.jnr.ax(true, false);
                    }
                    a.this.jnx = false;
                    a.this.Km(a.this.eXf ? "1" : "2");
                    a.this.onClick(a.this.jnd);
                    if (a.this.aaJ != null) {
                        a.this.aaJ.a(a.this);
                    }
                    if (a.this.jMx != null) {
                        a.this.jMx.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFp() {
                    a.this.onClick(a.this.jnc);
                }
            });
            this.jnr.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.18
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z2) {
                    a.this.jnr.fX(a.this.jns.jnS.videoUrl, a.this.jns.threadId);
                    a.this.Km("2");
                    a.this.onClick(a.this.jnd);
                }
            });
            this.jnr.xd(false);
            if (this.jMw != null) {
                this.jMw.reset();
            }
            this.startPosition = -1L;
            if (this.jnr.getVideoView() != null && this.jnr.getVideoView().getMediaProgressObserver() != null) {
                this.jnr.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ce(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.jns.jnS.joc;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.iwv.d(a.this.isFullScreen, a.this.jnr != null && a.this.jnr.dzx(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.iwv.a(a.this.i(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.jnr.dzx() && !com.baidu.mcn.b.abr().iY(aVar2.aaY)) {
                            boolean z3 = a.this.startPosition >= (aVar2.jnU * 1000) + 1000;
                            if (i3 < aVar2.jnU * 1000 || i3 >= aVar2.jnV * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jMw.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.chJ = aVar2.jnX;
                                    aVar3.chK = aVar2.jnY;
                                    aVar3.chL = aVar2.aaY;
                                    aVar3.chI = aVar2.jnW;
                                    aVar3.fid = a.this.jns != null ? a.this.jns.forumId : null;
                                    aVar3.tid = a.this.jns != null ? a.this.jns.threadId : null;
                                    aVar3.chM = 3;
                                    if (z3) {
                                        a.this.jMw.b(aVar3, (ViewGroup) a.this.jnr.dzP());
                                    } else {
                                        a.this.jMw.a(aVar3, (ViewGroup) a.this.jnr.dzP());
                                    }
                                }
                            } else if (a.this.jMw.isShowing()) {
                                a.this.jMw.dismiss();
                            }
                        }
                    }
                });
            }
            this.jnu = new o();
            this.jnu.amC = gVar.threadId;
            this.jnu.eTz = gVar.nid;
            this.jnu.fNd = gVar.forumId;
            this.jnu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jnu.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.jnu.mSource = gVar.source;
            this.jnu.mIe = gVar.weight;
            this.jnu.mIg = this.mFrom;
            this.jnu.mIi = gVar.abtest_tag;
            this.jnu.eNE = this.eNE;
            this.jnu.mExtra = gVar.extra;
            this.jnu.mIl = "0";
            this.jnu.mIh = gVar.getVideoType();
            this.jnv = new o();
            this.jnv.amC = gVar.threadId;
            this.jnv.fNd = gVar.forumId;
            this.jnv.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jnv.mIe = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jnv.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jnv.mIg = this.mFrom;
            this.jnv.mSource = gVar.source;
            this.jnv.mIl = "0";
            if (gVar.jnS != null) {
                this.jnu.mIj = gVar.jnS.videoMd5;
                this.jnv.mIj = gVar.jnS.videoMd5;
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
            this.jnr.getVideoView().setVideoStatData(this.jnu);
            this.jnr.dco();
            this.jnr.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.iwv.d(a.this.isFullScreen, a.this.jnr != null && a.this.jnr.dzx(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.jnx = true;
                            a.this.jMm = true;
                            a.this.jnw = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.ze(i);
                            a.this.jnr.cSD();
                        }
                    }
                }
            });
            this.jnr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.jns != null && a.this.jns.jnS != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.jns.jnS.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.iwv.reset();
            }
            this.iwv.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rs() {
                    a.this.jMm = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rr() {
                    if (a.this.isFullScreen) {
                        a.this.jnx = true;
                        a.this.jMm = true;
                        a.this.jnw = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.ze(i);
                        a.this.jnr.cSD();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rq() {
                    if (a.this.jnr != null) {
                        a.this.jnr.Hl(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rt() {
                    return a.this.cMc();
                }
            });
            this.jnr.setThumbnail(gVar.jnS.thumbnailUrl);
            this.jnr.Hk(gVar.jnS.videoDuration);
            this.jnr.setVideoUrl(gVar.jnS.videoUrl, gVar.threadId);
            this.jnr.setFid(gVar.forumId);
            this.jnr.cSD();
            this.jnr.show();
            rG(false);
            if (gVar.autoPlay) {
                onClick(this.jnd);
                if (this.jMu.dvu()) {
                    this.jnr.xk(false);
                    this.jMu.dVd();
                    this.jnr.xl(true);
                    this.jnr.fW(gVar.jnS.videoUrl, gVar.threadId);
                    if (this.iwv.rc()) {
                        this.iwv.stop();
                        this.iwv.rg();
                    }
                } else {
                    this.jnr.xl(false);
                    this.jnr.xk(false);
                    this.jMu.hide();
                    if (this.iwv == null || (this.iwv != null && !this.iwv.rc())) {
                        this.jnr.a(gVar.jnS.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.jnT) {
                    this.jMp.setVisibility(8);
                    this.jMt.AL(3);
                } else {
                    if (this.jMp.getVisibility() == 0) {
                        this.jMp.startAnimation(this.chX);
                    }
                    this.jMt.AL(0);
                }
                gVar.jnT = false;
            } else {
                this.jMp.setVisibility(0);
                this.jMu.hide();
                this.jnr.xk(true);
                this.jMt.AL(3);
                this.jnr.fW(gVar.jnS.videoUrl, gVar.threadId);
            }
            this.jnx = false;
            this.jMm = false;
            if (!z && this.iwv.rc()) {
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
        com.baidu.afd.videopaster.data.b Ll = this.jMv != null ? this.jMv.Ll(gVar.getThreadId()) : null;
        if (Ll != null) {
            int rx2 = Ll.rx();
            int ry = Ll.ry();
            int rw = Ll.rw();
            if (rw != -1) {
                i2 = rx2 != -1 ? (rw - rx2) - 1 : -1;
                i = ry != -1 ? (ry - rw) - 1 : -1;
            } else {
                i = -1;
                i2 = -1;
            }
            if (gVar.jnS != null) {
                i4 = com.baidu.adp.lib.f.b.toInt(gVar.jnS.videoWidth, 0);
                i3 = com.baidu.adp.lib.f.b.toInt(gVar.jnS.videoHeight, 0);
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
    public void Km(String str) {
        if (this.jns != null && this.jns.jnS != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jns.jnS.videoMd5, "", str, this.jnv, this.jnr.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jnr.rl();
    }

    public boolean cMa() {
        return this.iwv.rc();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jnr.pausePlay();
        }
    }

    public boolean zf(int i) {
        if (i == 4 && this.iwv != null && ((this.iwv.rc() || this.jMm) && this.jnr != null)) {
            this.iwv.be(i);
            if (this.isFullScreen) {
                if (this.iwv.rb()) {
                    this.jnr.dzy();
                } else {
                    this.jnr.TZ();
                }
                return true;
            }
        }
        return this.jnr.Hl(i);
    }

    public void stopVideo() {
        this.jMo = false;
        this.jnr.stopPlay();
        if (this.jMi != null) {
            this.jMi.setVisibility(0);
        }
        if (this.jMt != null) {
            this.jMt.AL(2);
        }
        rG(false);
        this.jMn = true;
        if (this.iwv != null && this.iwv.rc()) {
            this.iwv.stop();
        }
    }

    public void cMb() {
        this.iwv.stop();
    }

    public void cFm() {
        if (this.jnr != null) {
            this.jnr.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cFm();
        if (this.jnt != null) {
            this.jnt.cFx();
        }
        if (this.jMp != null) {
            this.jMp.clearAnimation();
        }
        this.iwv.onDestroy();
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.jnR != null) {
            this.ajY.setText(TextUtils.isEmpty(gVar.jnR.userNickname) ? gVar.jnR.userName : gVar.jnR.userNickname);
            k(gVar);
            d(gVar);
            e(gVar);
            l(gVar);
        }
    }

    private void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jnR != null) {
            if (gVar.jnR.job != null && !TextUtils.isEmpty(gVar.jnR.job.avatar)) {
                this.jnj.startLoad(gVar.jnR.job.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.jnR.portrait) && gVar.jnR.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jnj.startLoad(gVar.jnR.portrait, 10, false);
            } else {
                this.jnj.startLoad(gVar.jnR.portrait, 12, false);
            }
            if (gVar.jnR.job != null && gVar.jnR.job.auth_id.intValue() > 0) {
                this.jnj.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.jnR.job.auth_id.intValue(), 1));
                this.jnj.setShowV(true);
                this.jnj.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jnj.setBjhAuthIconRes(0);
            if (gVar.jnR.isBigV) {
                this.jnj.setShowV(gVar.jnR.isBigV);
                this.jnj.setIsBigV(gVar.jnR.isBigV);
            } else if (gVar.jnR.isGod) {
                this.jnj.setShowV(gVar.jnR.isGod);
                this.jnj.setIsBigV(gVar.jnR.isGod);
            } else {
                this.jnj.setShowV(gVar.jnR.isGod);
                this.jnj.setIsBigV(gVar.jnR.isGod);
            }
            this.jnj.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(final com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bpJ() != null) {
                gVar.bpJ().isInThread = true;
                gVar.bpJ().nid = gVar.nid;
                if (this.jns.getVideoType() == 1) {
                    gVar.bpJ().cardType = 2;
                } else if (this.jns.getVideoType() == 2) {
                    gVar.bpJ().cardType = 8;
                } else if (this.jns.getVideoType() == 3) {
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
                        a.this.jMt.AL(0);
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
            this.iTN.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fkb, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.iTN.setText(au.numFormatOverWan(gVar.shareNum));
            } else {
                this.iTN.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jnr != null && this.jnd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jnw) {
                this.jnr.dzE();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cMd();
            } else {
                configuration.orientation = 1;
                cMe();
                this.jnw = true;
            }
            this.jnr.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cMc() {
        if (this.jnr != null && this.jnd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jnd.getParent() != null) {
                if (this.jnd.getParent() == frameLayout) {
                    if (this.jMy) {
                        this.jMy = false;
                        return true;
                    } else if (!this.jMz) {
                        this.jMz = true;
                        return true;
                    }
                } else if (this.jnd.getParent() == this.jnc) {
                    if (this.jMz) {
                        this.jMz = false;
                        this.jMA = true;
                        return true;
                    } else if (!this.jMy && this.jMA) {
                        this.jMy = true;
                        this.jMA = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMd() {
        if (this.jnr != null && this.jnd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.jnd.getParent() != null) {
                if (this.jnd.getParent() == frameLayout) {
                    frameLayout.removeView(this.jnd);
                } else if (this.jnd.getParent() == this.jnc) {
                    this.jnc.removeView(this.jnd);
                }
            }
            if (this.jnd.getParent() == null) {
                frameLayout.addView(this.jnd);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jnd.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jnd.setLayoutParams(layoutParams);
                if (this.jMw != null && this.jMw.isShowing()) {
                    this.jMw.dismiss();
                }
                com.baidu.tbadk.util.e.bFg().lu(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMe() {
        if (this.jnr != null && this.jnd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.jnd.getParent() != null) {
                if (this.jnd.getParent() == frameLayout) {
                    cMf();
                    frameLayout.removeView(this.jnd);
                } else if (this.jnd.getParent() == this.jnc) {
                    cMf();
                    this.jnc.removeView(this.jnd);
                }
            }
            if (this.jnd.getParent() == null) {
                this.jnc.addView(this.jnd, 0);
                cMg();
                this.jnr.dco();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bFg().lu(false);
            }
        }
    }

    private void cMf() {
        if (this.iwv != null && this.iwv.rc()) {
            this.iwv.az(true);
        }
    }

    private void cMg() {
        int i;
        if (!cLY()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.jnd.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (crV() != null) {
            view.setTag(this);
            crV().a(view, this.jns);
        }
        if (view == this.jnj || view == this.ajY) {
            if (this.jns != null && this.jns.jnR != null && !TextUtils.isEmpty(this.jns.jnR.userId)) {
                this.jMt.AL(0);
                if (!TbadkCoreApplication.isLogin() || !this.jns.jnR.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jns.jnR.userId, 0L), z, this.jns.jnR.isGod)));
            }
        } else if (view == this.fjZ) {
            if (this.jns != null) {
                this.jMt.AL(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jns.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.jns.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jMi || view == this.jMj) {
            if (this.jns != null) {
                if (this.jMt.getCurrentState() != 2 && this.jMt.getCurrentState() != 3) {
                    z = false;
                }
                this.jMt.AL(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.jns.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.jns.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.fkc) {
            this.jMt.AL(0);
            buF();
        } else if (view == this.jMp && this.jMp.getVisibility() == 0 && this.jMr != null) {
            this.jMr.AP(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qW(boolean z) {
        if (this.jns != null && this.jns.jnR != null) {
            this.jns.jnR.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cFn() {
        if (this.jns != null) {
            this.fjW.btL();
        }
    }

    public void rF(boolean z) {
        if (this.jnc != null) {
            this.jnc.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jMx = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jMr = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.aaJ = fVar;
    }

    private void rG(boolean z) {
        this.jMn = this.mPosition == (this.jMs == null ? -1 : this.jMs.cMs());
        if (this.jMn && z && isPlaying() && this.eXf && !this.jMo) {
            this.jMk.setVisibility(0);
            this.jMo = true;
            this.jMk.postDelayed(this.jMD, 5000L);
            if (this.jMs != null) {
                this.jMs.gy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jMk.setVisibility(8);
        if (this.jMD != null) {
            this.jMk.removeCallbacks(this.jMD);
        }
    }

    private void buF() {
        String str;
        String str2;
        if (this.jns != null && this.mContext != null) {
            String valueOf = String.valueOf(this.jns.forumId);
            String str3 = this.jns.title;
            if (this.jns.mBaijiahao != null) {
                str = this.jns.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.jns.mBaijiahao.oriUgcType + "&dvid=" + this.jns.mBaijiahao.oriUgcVid + "&nid=" + this.jns.mBaijiahao.oriUgcNid;
            } else {
                str = this.jns.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.jns.jnS.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.jns.title;
            String format = (this.jns.mBaijiahao == null || this.jns.jnR == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.jns.jnR.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.jns.mBaijiahao != null) {
                shareItem.fuV = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fuV = str6;
                shareItem.readCount = this.jns.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fuY = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fuK = true;
            shareItem.fuX = 11;
            if (this.jns.getVideoType() == 1) {
                shareItem.fvc = 2;
            } else if (this.jns.getVideoType() == 2) {
                shareItem.fvc = 8;
            } else if (this.jns.getVideoType() == 3) {
                shareItem.fvc = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.jns.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.jns.mBaijiahao;
            shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dR("tid", str);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.ap("obj_locate", 12);
            arVar.dR(IntentConfig.NID, this.jns.nid);
            if (this.jns.mBaijiahao != null && !au.isEmpty(this.jns.mBaijiahao.oriUgcVid)) {
                arVar.dR("obj_param6", this.jns.mBaijiahao.oriUgcVid);
            }
            if (this.jns.getVideoType() == 1) {
                arVar.ap(IntentConfig.CARD_TYPE, 2);
            } else if (this.jns.getVideoType() == 2) {
                arVar.ap(IntentConfig.CARD_TYPE, 8);
            } else if (this.jns.getVideoType() == 3) {
                arVar.ap(IntentConfig.CARD_TYPE, 6);
            }
            arVar.dR(IntentConfig.RECOM_SOURCE, this.jns.source);
            arVar.dR("ab_tag", this.jns.abtest_tag);
            arVar.dR("weight", this.jns.weight);
            arVar.dR("extra", this.jns.extra);
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
            com.baidu.tieba.c.f.ctz().b(shareDialogConfig);
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

    public void cMh() {
        this.iwv.resume();
    }

    public boolean cMi() {
        if (this.jMt != null) {
            return this.jMt.getCurrentState() == 2 || this.jMt.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0736a {
        private int ezR;
        private Runnable jMI;

        private C0736a() {
            this.ezR = -1;
            this.jMI = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(C0736a.this.jMI);
                    C0736a.this.AL(2);
                }
            };
        }

        public void AL(int i) {
            switch (i) {
                case 0:
                    this.ezR = AM(i);
                    cMj();
                    return;
                case 1:
                    this.ezR = AM(i);
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMI);
                    return;
                case 2:
                    this.ezR = AN(i);
                    return;
                case 3:
                    this.ezR = AO(i);
                    cMj();
                    return;
                default:
                    this.ezR = AN(i);
                    return;
            }
        }

        private void cMj() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMI);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jMI, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.ezR;
        }

        private int AM(int i) {
            if (i != this.ezR) {
                a.this.jMq.setVisibility(8);
                a.this.rH(true);
                return i;
            }
            return this.ezR;
        }

        private int AN(int i) {
            int i2 = this.ezR;
            if (i != this.ezR) {
                a.this.jMq.setVisibility(0);
                if (i2 != 3 || a.this.jns.autoPlay) {
                    a.this.rH(false);
                    return i;
                }
                return i;
            }
            return this.ezR;
        }

        private int AO(int i) {
            if (i != this.ezR) {
                a.this.jMq.setVisibility(0);
                a.this.rH(true);
                return i;
            }
            return this.ezR;
        }
    }
}
