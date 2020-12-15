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
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, k {
    private com.baidu.tieba.lego.card.view.f aag;
    public TextView aky;
    private Animation cbQ;
    private Animation cbR;
    private TextView eBF;
    private String eGn;
    private boolean ePB;
    protected AgreeView fcF;
    private ImageView fcH;
    private View fcI;
    private ImageView fcK;
    private View fcL;
    private TextView iGB;
    public FrameLayout iZP;
    public FrameLayout iZQ;
    public HeadImageView iZW;
    private com.baidu.afd.videopaster.d ijd;
    private boolean isFullScreen;
    private int izV;
    public com.baidu.tieba.play.c jae;
    public com.baidu.tieba.frs.aggregation.g jaf;
    private com.baidu.tieba.frs.aggregation.h jag;
    private o jah;
    private o jai;
    private boolean jaj;
    private boolean jak;
    private boolean jan;
    public ExpandableTextView jyL;
    private View jyM;
    private FrameLayout jyN;
    private TextView jyO;
    private boolean jyP;
    private boolean jyQ;
    private boolean jyR;
    private View jyS;
    private View jyT;
    private c jyU;
    public com.baidu.tieba.frs.videomiddlepage.a.a jyV;
    private C0753a jyW;
    private VideoNetworkStateTipView jyX;
    private b jyY;
    private com.baidu.mcn.c jyZ;
    private com.baidu.tieba.lego.card.view.g jza;
    private boolean jzb;
    private boolean jzc;
    private boolean jzd;
    private Animation.AnimationListener jze;
    private Animation.AnimationListener jzf;
    private Runnable jzg;
    private Runnable jzh;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.jaj = true;
        this.jan = true;
        this.jyQ = false;
        this.jyR = false;
        this.jzb = false;
        this.jzc = false;
        this.jzd = false;
        this.startPosition = -1L;
        this.izV = 0;
        this.jze = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jyS != null) {
                    a.this.jyS.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jyS != null) {
                    a.this.jyS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jzf = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jyS != null) {
                    a.this.jyS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jyS != null) {
                    a.this.jyS.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jzg = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jyN.getVisibility() == 0) {
                    a.this.jyN.setVisibility(8);
                }
            }
        };
        this.jzh = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jae != null) {
                    a.this.jae.stopPlay();
                }
            }
        };
        this.jan = z;
        this.mFrom = str;
        this.eGn = str2;
        this.jyY = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iZP = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jyM = view.findViewById(R.id.card_container);
        this.iZQ = (FrameLayout) view.findViewById(R.id.video_container);
        this.jae = new com.baidu.tieba.play.c(tbPageContext, this.iZQ, false);
        this.jae.setStageType("2005");
        this.jae.wQ(z);
        this.jae.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jyV != null && a.this.jaf.jaF.videoDuration > 8) {
                    a.this.jyV.bt(a.this.mPosition, a.this.jaf.jaF.videoUrl);
                }
            }
        });
        this.jae.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.a
            public void rd(boolean z2) {
                if (a.this.jyW != null) {
                    if (z2) {
                        a.this.jyW.BV(0);
                    } else {
                        a.this.jyW.BV(1);
                    }
                }
            }
        });
        this.jae.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jyL = (ExpandableTextView) view.findViewById(R.id.title);
        this.iZW = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aky = (TextView) view.findViewById(R.id.user_name);
        this.fcF = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEK = 2;
        dVar.eEP = 6;
        this.fcF.setStatisticData(dVar);
        this.fcF.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.eBF = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fcH = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fcI = view.findViewById(R.id.thread_info_commont_container);
        this.iGB = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.fcK = (ImageView) view.findViewById(R.id.share_num_img);
        this.fcL = view.findViewById(R.id.share_num_container);
        this.jyN = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jyO = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jyN.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jyO.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_download_link_url", null);
        this.jyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bua().a((TbPageContext) i.J(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jyX = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jyX.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c13257"));
                a.this.jyX.setHasAgreeToPlay(true);
                a.this.jae.wW(false);
                a.this.jyX.dXh();
                if (a.this.ijd.rC()) {
                    a.this.ijd.resume();
                } else if (a.this.jaf != null && a.this.jaf.jaF != null) {
                    a.this.jae.gb(a.this.jaf.jaF.videoUrl, a.this.jaf.threadId);
                }
            }
        });
        this.jyS = view.findViewById(R.id.video_agg_container_foreground);
        this.jyT = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jyS.setOnClickListener(this);
        this.fcI.setOnClickListener(this);
        this.fcL.setOnClickListener(this);
        this.jyL.setOnClickListener(this);
        this.iZW.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.jyM.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.izV = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iZP.setLayoutParams(layoutParams);
        this.iZW.setIsRound(true);
        this.iZW.setPlaceHolder(1);
        this.jag = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.cbQ = new AlphaAnimation(0.0f, 0.7f);
        this.cbQ.setDuration(500L);
        this.cbQ.setAnimationListener(this.jzf);
        this.cbR = new AlphaAnimation(0.7f, 0.0f);
        this.cbR.setDuration(500L);
        this.cbR.setAnimationListener(this.jze);
        this.jyW = new C0753a();
        this.ijd = new com.baidu.afd.videopaster.d(getContext(), this.iZQ);
        this.jyZ = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fcF.onChangeSkinType(i);
        this.eBF.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.iGB.setTextColor(ap.getColor(R.color.CAM_X0107));
        WebPManager.a(this.fcK, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fcH, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jyL.onChangeSkinType();
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
        if (gVar != null && gVar.jaF != null) {
            boolean z = this.jaf == gVar;
            this.jaf = gVar;
            this.ePB = this.jaf.autoPlay;
            this.jyR = false;
            rb(false);
            this.jyL.setVisibility(0);
            this.jyL.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jyL.setTextColor(R.color.CAM_X0101);
            this.jyL.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.jaF != null && !StringUtils.isNull(gVar.jaF.mcnLeadPage)) {
                this.jyL.setTextMaxLine(2);
                this.jyL.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jyL.getContentView(), gVar.title, gVar.jaF.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jyL.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.jyL.setExpandable(true);
                this.jyL.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void re(boolean z2) {
                        a.this.jaf.isTitleExpanded = z2;
                    }
                });
                this.jyL.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.izV) {
                this.jae.dBJ();
                this.izV = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.iZQ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iZQ.setLayoutParams(layoutParams);
            }
            cLz();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.jaf = gVar;
        this.ePB = this.jaf.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cLy() {
        try {
            int parseInt = Integer.parseInt(this.jaf.jaF.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.jaf.jaF.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cLz() {
        if (!cLy()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iZP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iZP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iZP.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.jaF != null) {
            this.jae.stopPlay();
            this.jae.wX(true);
            this.jae.wT(true);
            this.jae.wY(true);
            this.jae.av(false, false);
            this.jae.IG(i);
            this.jae.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                    a.this.cLD();
                    if (a.this.ijd != null) {
                        a.this.ijd.rK();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                    a.this.cLE();
                    if (a.this.jae.rM()) {
                    }
                    if (a.this.jak || (a.this.ijd != null && a.this.ijd.rC())) {
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(a.this.jzh);
                        com.baidu.adp.lib.f.e.mY().post(a.this.jzh);
                    }
                    if (a.this.ijd != null) {
                        a.this.ijd.rL();
                    }
                }
            });
            this.jae.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.l
                public void cEZ() {
                    if (a.this.jaf != null && a.this.jaf.jaF != null && com.baidu.adp.lib.f.b.toInt(a.this.jaf.jaF.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.jaf.jaF.videoWidth, 0)) {
                        a.this.jae.av(false, false);
                    } else {
                        a.this.jae.av(true, false);
                    }
                    a.this.jak = false;
                    a.this.KN(a.this.ePB ? "1" : "2");
                    a.this.onClick(a.this.iZQ);
                    if (a.this.aag != null) {
                        a.this.aag.a(a.this);
                    }
                    if (a.this.jza != null) {
                        a.this.jza.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFa() {
                    a.this.onClick(a.this.iZP);
                }
            });
            this.jae.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.18
                @Override // com.baidu.tieba.play.c.f
                public void qt(boolean z2) {
                    a.this.jae.gb(a.this.jaf.jaF.videoUrl, a.this.jaf.threadId);
                    a.this.KN("2");
                    a.this.onClick(a.this.iZQ);
                }
            });
            this.jae.wP(false);
            if (this.jyZ != null) {
                this.jyZ.reset();
            }
            this.startPosition = -1L;
            if (this.jae.getVideoView() != null && this.jae.getVideoView().getMediaProgressObserver() != null) {
                this.jae.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ci(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.jaf.jaF.jaP;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.ijd.a(a.this.isFullScreen, a.this.jae != null && a.this.jae.dBq(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.ijd.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.jae.dBq() && !com.baidu.mcn.b.abJ().jK(aVar2.aav)) {
                            boolean z3 = a.this.startPosition >= (aVar2.jaH * 1000) + 1000;
                            if (i3 < aVar2.jaH * 1000 || i3 >= aVar2.jaI * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jyZ.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.cbD = aVar2.jaK;
                                    aVar3.cbE = aVar2.jaL;
                                    aVar3.cbF = aVar2.aav;
                                    aVar3.cbC = aVar2.jaJ;
                                    aVar3.fid = a.this.jaf != null ? a.this.jaf.forumId : null;
                                    aVar3.tid = a.this.jaf != null ? a.this.jaf.threadId : null;
                                    aVar3.cbG = 3;
                                    if (z3) {
                                        a.this.jyZ.b(aVar3, (ViewGroup) a.this.jae.dBI());
                                    } else {
                                        a.this.jyZ.a(aVar3, (ViewGroup) a.this.jae.dBI());
                                    }
                                }
                            } else if (a.this.jyZ.isShowing()) {
                                a.this.jyZ.dismiss();
                            }
                        }
                    }
                });
            }
            this.jah = new o();
            this.jah.amY = gVar.threadId;
            this.jah.mNid = gVar.nid;
            this.jah.fFV = gVar.forumId;
            this.jah.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jah.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.jah.mSource = gVar.source;
            this.jah.myq = gVar.weight;
            this.jah.mys = this.mFrom;
            this.jah.myu = gVar.abtest_tag;
            this.jah.eGn = this.eGn;
            this.jah.mExtra = gVar.extra;
            this.jah.myx = "0";
            this.jah.myt = gVar.getVideoType();
            this.jai = new o();
            this.jai.amY = gVar.threadId;
            this.jai.fFV = gVar.forumId;
            this.jai.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jai.myq = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jai.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jai.mys = this.mFrom;
            this.jai.mSource = gVar.source;
            this.jai.myx = "0";
            if (gVar.jaF != null) {
                this.jah.myv = gVar.jaF.videoMd5;
                this.jai.myv = gVar.jaF.videoMd5;
            }
            ar arVar = new ar("c12590");
            arVar.dY("tid", gVar.threadId);
            arVar.dY("nid", gVar.nid);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.al("obj_locate", i);
            arVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dY("fid", gVar.forumId);
            arVar.dY("obj_param1", au.isEmpty(gVar.weight) ? "0" : gVar.weight);
            arVar.dY("extra", au.isEmpty(gVar.extra) ? "0" : gVar.extra);
            arVar.dY("obj_id", this.eGn);
            arVar.dY("ab_tag", au.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            arVar.dY("obj_type", this.mFrom);
            arVar.al("obj_param5", gVar.getVideoType());
            arVar.dY("obj_source", au.isEmpty(gVar.source) ? "0" : gVar.source);
            arVar.al("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                arVar.dY("obj_param4", gVar.mBaijiahao.oriUgcNid);
                arVar.dY("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(arVar);
            this.jae.getVideoView().setVideoStatData(this.jah);
            this.jae.dew();
            this.jae.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.ijd.a(a.this.isFullScreen, a.this.jae != null && a.this.jae.dBq(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.jak = true;
                            a.this.jyP = true;
                            a.this.jaj = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.Ao(i);
                            a.this.jae.cRp();
                        }
                    }
                }
            });
            this.jae.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.jaf != null && a.this.jaf.jaF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.jaf.jaF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.ijd.reset();
            }
            this.ijd.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rT() {
                    a.this.jyP = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rS() {
                    if (a.this.isFullScreen) {
                        a.this.jak = true;
                        a.this.jyP = true;
                        a.this.jaj = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.Ao(i);
                        a.this.jae.cRp();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rR() {
                    if (a.this.jae != null) {
                        a.this.jae.IF(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rU() {
                    return a.this.cLC();
                }
            });
            this.jae.setThumbnail(gVar.jaF.thumbnailUrl);
            this.jae.IE(gVar.jaF.videoDuration);
            this.jae.setVideoUrl(gVar.jaF.videoUrl, gVar.threadId);
            this.jae.setFid(gVar.forumId);
            this.jae.cRp();
            this.jae.show();
            rb(false);
            if (gVar.autoPlay) {
                onClick(this.iZQ);
                if (this.jyX.dxj()) {
                    this.jae.wV(false);
                    this.jyX.dXg();
                    this.jae.wW(true);
                    this.jae.ga(gVar.jaF.videoUrl, gVar.threadId);
                    if (this.ijd.rC()) {
                        this.ijd.stop();
                        this.ijd.rH();
                    }
                } else {
                    this.jae.wW(false);
                    this.jae.wV(false);
                    this.jyX.hide();
                    if (this.ijd == null || (this.ijd != null && !this.ijd.rC())) {
                        this.jae.a(gVar.jaF.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.jaG) {
                    this.jyS.setVisibility(8);
                    this.jyW.BV(3);
                } else {
                    if (this.jyS.getVisibility() == 0) {
                        this.jyS.startAnimation(this.cbR);
                    }
                    this.jyW.BV(0);
                }
                gVar.jaG = false;
            } else {
                this.jyS.setVisibility(0);
                this.jyX.hide();
                this.jae.wV(true);
                this.jyW.BV(3);
                this.jae.ga(gVar.jaF.videoUrl, gVar.threadId);
            }
            this.jak = false;
            this.jyP = false;
            if (!z && this.ijd.rC()) {
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
        com.baidu.afd.videopaster.data.b LL = this.jyY != null ? this.jyY.LL(gVar.getThreadId()) : null;
        if (LL == null) {
            return null;
        }
        int rY = LL.rY();
        int rZ = LL.rZ();
        int rX = LL.rX();
        if (rX != -1) {
            i = rY != -1 ? (rX - rY) - 1 : -1;
            if (rZ != -1) {
                i4 = (rZ - rX) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.jaF != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.jaF.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.jaF.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", rX + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN(String str) {
        if (this.jaf != null && this.jaf.jaF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jaf.jaF.videoMd5, "", str, this.jai, this.jae.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jae.rM();
    }

    public boolean cLA() {
        return this.ijd.rC();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jae.aSi();
        }
    }

    public boolean Ap(int i) {
        if (i == 4 && this.ijd != null && ((this.ijd.rC() || this.jyP) && this.jae != null)) {
            this.ijd.bd(i);
            if (this.isFullScreen) {
                if (this.ijd.rB()) {
                    this.jae.dBr();
                } else {
                    this.jae.Vh();
                }
                return true;
            }
        }
        return this.jae.IF(i);
    }

    public void cEW() {
        this.jyR = false;
        this.jae.stopPlay();
        if (this.jyL != null) {
            this.jyL.setVisibility(0);
        }
        if (this.jyW != null) {
            this.jyW.BV(2);
        }
        rb(false);
        this.jyQ = true;
        if (this.ijd != null && this.ijd.rC()) {
            this.ijd.stop();
        }
    }

    public void cLB() {
        this.ijd.stop();
    }

    public void cEX() {
        if (this.jae != null) {
            this.jae.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cEX();
        if (this.jag != null) {
            this.jag.cFh();
        }
        if (this.jyS != null) {
            this.jyS.clearAnimation();
        }
        this.ijd.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.jaE != null) {
            this.aky.setText(TextUtils.isEmpty(gVar.jaE.userNickname) ? gVar.jaE.userName : gVar.jaE.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jaE != null) {
            if (gVar.jaE.jaO != null && !TextUtils.isEmpty(gVar.jaE.jaO.avatar)) {
                this.iZW.startLoad(gVar.jaE.jaO.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.jaE.portrait) && gVar.jaE.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iZW.startLoad(gVar.jaE.portrait, 10, false);
            } else {
                this.iZW.startLoad(gVar.jaE.portrait, 12, false);
            }
            if (gVar.jaE.jaO != null && gVar.jaE.jaO.auth_id.intValue() > 0) {
                this.iZW.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.jaE.jaO.auth_id.intValue(), 1));
                this.iZW.setShowV(true);
                this.iZW.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.iZW.setBjhAuthIconRes(0);
            if (gVar.jaE.isBigV) {
                this.iZW.setShowV(gVar.jaE.isBigV);
                this.iZW.setIsBigV(gVar.jaE.isBigV);
            } else if (gVar.jaE.isGod) {
                this.iZW.setShowV(gVar.jaE.isGod);
                this.iZW.setIsBigV(gVar.jaE.isGod);
            } else {
                this.iZW.setShowV(gVar.jaE.isGod);
                this.iZW.setIsBigV(gVar.jaE.isGod);
            }
            this.iZW.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(final com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bqI() != null) {
                gVar.bqI().isInThread = true;
                gVar.bqI().nid = gVar.nid;
                if (this.jaf.getVideoType() == 1) {
                    gVar.bqI().cardType = 2;
                } else if (this.jaf.getVideoType() == 2) {
                    gVar.bqI().cardType = 8;
                } else if (this.jaf.getVideoType() == 3) {
                    gVar.bqI().cardType = 6;
                }
                gVar.bqI().baijiahaoData = gVar.mBaijiahao;
                gVar.bqI().recomSource = gVar.source;
                gVar.bqI().recomWeight = gVar.weight;
                gVar.bqI().recomAbTag = gVar.abtest_tag;
                gVar.bqI().recomExtra = gVar.extra;
            }
            this.fcF.setAgreeAlone(true);
            this.fcF.setIsFromMiddlePage(true);
            this.fcF.setData(gVar.bqI());
            this.fcF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (gVar.bqI().hasAgree && gVar.bqI().agreeType == 2) {
                        a.this.jyW.BV(0);
                    }
                }
            });
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.eBF.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fcH, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.eBF.setText(au.numFormatOverWan(gVar.postNum));
            } else {
                this.eBF.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.iGB.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fcK, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.iGB.setText(au.numFormatOverWan(gVar.shareNum));
            } else {
                this.iGB.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jae != null && this.iZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jaj) {
                this.jae.dBx();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cLD();
            } else {
                configuration.orientation = 1;
                cLE();
                this.jaj = true;
            }
            this.jae.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLC() {
        if (this.jae != null && this.iZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iZQ.getParent() != null) {
                if (this.iZQ.getParent() == frameLayout) {
                    if (this.jzb) {
                        this.jzb = false;
                        return true;
                    } else if (!this.jzc) {
                        this.jzc = true;
                        return true;
                    }
                } else if (this.iZQ.getParent() == this.iZP) {
                    if (this.jzc) {
                        this.jzc = false;
                        this.jzd = true;
                        return true;
                    } else if (!this.jzb && this.jzd) {
                        this.jzb = true;
                        this.jzd = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLD() {
        if (this.jae != null && this.iZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.iZQ.getParent() != null) {
                if (this.iZQ.getParent() == frameLayout) {
                    frameLayout.removeView(this.iZQ);
                } else if (this.iZQ.getParent() == this.iZP) {
                    this.iZP.removeView(this.iZQ);
                }
            }
            if (this.iZQ.getParent() == null) {
                frameLayout.addView(this.iZQ);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iZQ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iZQ.setLayoutParams(layoutParams);
                if (this.jyZ != null && this.jyZ.isShowing()) {
                    this.jyZ.dismiss();
                }
                com.baidu.tbadk.util.e.bGk().kZ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLE() {
        if (this.jae != null && this.iZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.iZQ.getParent() != null) {
                if (this.iZQ.getParent() == frameLayout) {
                    cLF();
                    frameLayout.removeView(this.iZQ);
                } else if (this.iZQ.getParent() == this.iZP) {
                    cLF();
                    this.iZP.removeView(this.iZQ);
                }
            }
            if (this.iZQ.getParent() == null) {
                this.iZP.addView(this.iZQ, 0);
                cLG();
                this.jae.dew();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bGk().kZ(false);
            }
        }
    }

    private void cLF() {
        if (this.ijd != null && this.ijd.rC()) {
            this.ijd.aA(true);
        }
    }

    private void cLG() {
        int i;
        if (!cLy()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.iZQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (crJ() != null) {
            view.setTag(this);
            crJ().a(view, this.jaf);
        }
        if (view == this.iZW || view == this.aky) {
            if (this.jaf != null && this.jaf.jaE != null && !TextUtils.isEmpty(this.jaf.jaE.userId)) {
                this.jyW.BV(0);
                if (!TbadkCoreApplication.isLogin() || !this.jaf.jaE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jaf.jaE.userId, 0L), z, this.jaf.jaE.isGod)));
            }
        } else if (view == this.fcI) {
            if (this.jaf != null) {
                this.jyW.BV(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jaf.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.jaf.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jyL || view == this.jyM) {
            if (this.jaf != null) {
                if (this.jyW.getCurrentState() != 2 && this.jyW.getCurrentState() != 3) {
                    z = false;
                }
                this.jyW.BV(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.jaf.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.jaf.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.fcL) {
            this.jyW.BV(0);
            bvJ();
        } else if (view == this.jyS && this.jyS.getVisibility() == 0 && this.jyU != null) {
            this.jyU.BZ(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qs(boolean z) {
        if (this.jaf != null && this.jaf.jaE != null) {
            this.jaf.jaE.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cEY() {
        if (this.jaf != null) {
            this.fcF.buP();
        }
    }

    public void ra(boolean z) {
        if (this.iZP != null) {
            this.iZP.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jza = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jyU = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.aag = fVar;
    }

    private void rb(boolean z) {
        this.jyQ = this.mPosition == (this.jyV == null ? -1 : this.jyV.cLS());
        if (this.jyQ && z && isPlaying() && this.ePB && !this.jyR) {
            this.jyN.setVisibility(0);
            this.jyR = true;
            this.jyN.postDelayed(this.jzg, 5000L);
            if (this.jyV != null) {
                this.jyV.gt(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jyN.setVisibility(8);
        if (this.jzg != null) {
            this.jyN.removeCallbacks(this.jzg);
        }
    }

    private void bvJ() {
        String str;
        String str2;
        if (this.jaf != null && this.mContext != null) {
            String valueOf = String.valueOf(this.jaf.forumId);
            String str3 = this.jaf.title;
            if (this.jaf.mBaijiahao != null) {
                str = this.jaf.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.jaf.mBaijiahao.oriUgcType + "&dvid=" + this.jaf.mBaijiahao.oriUgcVid + "&nid=" + this.jaf.mBaijiahao.oriUgcNid;
            } else {
                str = this.jaf.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.jaf.jaF.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.jaf.title;
            String format = (this.jaf.mBaijiahao == null || this.jaf.jaE == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.jaf.jaE.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.jaf.mBaijiahao != null) {
                shareItem.fnC = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fnC = str6;
                shareItem.readCount = this.jaf.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fnF = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fnr = true;
            shareItem.fnE = 11;
            if (this.jaf.getVideoType() == 1) {
                shareItem.fnJ = 2;
            } else if (this.jaf.getVideoType() == 2) {
                shareItem.fnJ = 8;
            } else if (this.jaf.getVideoType() == 3) {
                shareItem.fnJ = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.jaf.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.jaf.mBaijiahao;
            shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dY("tid", str);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.al("obj_locate", 12);
            arVar.dY("nid", this.jaf.nid);
            if (this.jaf.mBaijiahao != null && !au.isEmpty(this.jaf.mBaijiahao.oriUgcVid)) {
                arVar.dY("obj_param6", this.jaf.mBaijiahao.oriUgcVid);
            }
            if (this.jaf.getVideoType() == 1) {
                arVar.al(IntentConfig.CARD_TYPE, 2);
            } else if (this.jaf.getVideoType() == 2) {
                arVar.al(IntentConfig.CARD_TYPE, 8);
            } else if (this.jaf.getVideoType() == 3) {
                arVar.al(IntentConfig.CARD_TYPE, 6);
            }
            arVar.dY(IntentConfig.RECOM_SOURCE, this.jaf.source);
            arVar.dY("ab_tag", this.jaf.abtest_tag);
            arVar.dY("weight", this.jaf.weight);
            arVar.dY("extra", this.jaf.extra);
            arVar.dY("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                arVar.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                arVar.dY("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(arVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fnF);
            bundle.putInt("obj_type", shareItem.fnJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eMJ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.d.f.ctl().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        cEW();
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void aSi() {
        pauseVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(boolean z) {
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

    public void cLH() {
        this.ijd.resume();
    }

    public boolean cLI() {
        if (this.jyW != null) {
            return this.jyW.getCurrentState() == 2 || this.jyW.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0753a {
        private int cnU;
        private Runnable jzl;

        private C0753a() {
            this.cnU = -1;
            this.jzl = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(C0753a.this.jzl);
                    C0753a.this.BV(2);
                }
            };
        }

        public void BV(int i) {
            switch (i) {
                case 0:
                    this.cnU = BW(i);
                    cLJ();
                    return;
                case 1:
                    this.cnU = BW(i);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jzl);
                    return;
                case 2:
                    this.cnU = BX(i);
                    return;
                case 3:
                    this.cnU = BY(i);
                    cLJ();
                    return;
                default:
                    this.cnU = BX(i);
                    return;
            }
        }

        private void cLJ() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jzl);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jzl, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.cnU;
        }

        private int BW(int i) {
            if (i != this.cnU) {
                a.this.jyT.setVisibility(8);
                a.this.rc(true);
                return i;
            }
            return this.cnU;
        }

        private int BX(int i) {
            int i2 = this.cnU;
            if (i != this.cnU) {
                a.this.jyT.setVisibility(0);
                if (i2 != 3 || a.this.jaf.autoPlay) {
                    a.this.rc(false);
                    return i;
                }
                return i;
            }
            return this.cnU;
        }

        private int BY(int i) {
            if (i != this.cnU) {
                a.this.jyT.setVisibility(0);
                a.this.rc(true);
                return i;
            }
            return this.cnU;
        }
    }
}
