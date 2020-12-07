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
    private TextView iGz;
    public FrameLayout iZN;
    public FrameLayout iZO;
    public HeadImageView iZU;
    private com.baidu.afd.videopaster.d ijb;
    private boolean isFullScreen;
    private int izT;
    public com.baidu.tieba.play.c jac;
    public com.baidu.tieba.frs.aggregation.g jad;
    private com.baidu.tieba.frs.aggregation.h jae;
    private o jaf;
    private o jag;
    private boolean jah;
    private boolean jai;
    private boolean jal;
    public ExpandableTextView jyJ;
    private View jyK;
    private FrameLayout jyL;
    private TextView jyM;
    private boolean jyN;
    private boolean jyO;
    private boolean jyP;
    private View jyQ;
    private View jyR;
    private c jyS;
    public com.baidu.tieba.frs.videomiddlepage.a.a jyT;
    private C0753a jyU;
    private VideoNetworkStateTipView jyV;
    private b jyW;
    private com.baidu.mcn.c jyX;
    private com.baidu.tieba.lego.card.view.g jyY;
    private boolean jyZ;
    private boolean jza;
    private boolean jzb;
    private Animation.AnimationListener jzc;
    private Animation.AnimationListener jzd;
    private Runnable jze;
    private Runnable jzf;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.jah = true;
        this.jal = true;
        this.jyO = false;
        this.jyP = false;
        this.jyZ = false;
        this.jza = false;
        this.jzb = false;
        this.startPosition = -1L;
        this.izT = 0;
        this.jzc = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jyQ != null) {
                    a.this.jyQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jyQ != null) {
                    a.this.jyQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jzd = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.jyQ != null) {
                    a.this.jyQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.jyQ != null) {
                    a.this.jyQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jze = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jyL.getVisibility() == 0) {
                    a.this.jyL.setVisibility(8);
                }
            }
        };
        this.jzf = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jac != null) {
                    a.this.jac.stopPlay();
                }
            }
        };
        this.jal = z;
        this.mFrom = str;
        this.eGn = str2;
        this.jyW = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iZN = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jyK = view.findViewById(R.id.card_container);
        this.iZO = (FrameLayout) view.findViewById(R.id.video_container);
        this.jac = new com.baidu.tieba.play.c(tbPageContext, this.iZO, false);
        this.jac.setStageType("2005");
        this.jac.wQ(z);
        this.jac.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.jyT != null && a.this.jad.jaD.videoDuration > 8) {
                    a.this.jyT.bt(a.this.mPosition, a.this.jad.jaD.videoUrl);
                }
            }
        });
        this.jac.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.a
            public void rd(boolean z2) {
                if (a.this.jyU != null) {
                    if (z2) {
                        a.this.jyU.BV(0);
                    } else {
                        a.this.jyU.BV(1);
                    }
                }
            }
        });
        this.jac.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.jyJ = (ExpandableTextView) view.findViewById(R.id.title);
        this.iZU = (HeadImageView) view.findViewById(R.id.user_icon);
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
        this.iGz = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.fcK = (ImageView) view.findViewById(R.id.share_num_img);
        this.fcL = view.findViewById(R.id.share_num_container);
        this.jyL = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.jyM = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.jyL.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jyM.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_download_link_url", null);
        this.jyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bua().a((TbPageContext) i.J(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.jyV = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.jyV.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c13257"));
                a.this.jyV.setHasAgreeToPlay(true);
                a.this.jac.wW(false);
                a.this.jyV.dXg();
                if (a.this.ijb.rC()) {
                    a.this.ijb.resume();
                } else if (a.this.jad != null && a.this.jad.jaD != null) {
                    a.this.jac.gb(a.this.jad.jaD.videoUrl, a.this.jad.threadId);
                }
            }
        });
        this.jyQ = view.findViewById(R.id.video_agg_container_foreground);
        this.jyR = view.findViewById(R.id.title_and_comment_container_foreground);
        this.jyQ.setOnClickListener(this);
        this.fcI.setOnClickListener(this);
        this.fcL.setOnClickListener(this);
        this.jyJ.setOnClickListener(this);
        this.iZU.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.jyK.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.izT = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZN.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iZN.setLayoutParams(layoutParams);
        this.iZU.setIsRound(true);
        this.iZU.setPlaceHolder(1);
        this.jae = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.cbQ = new AlphaAnimation(0.0f, 0.7f);
        this.cbQ.setDuration(500L);
        this.cbQ.setAnimationListener(this.jzd);
        this.cbR = new AlphaAnimation(0.7f, 0.0f);
        this.cbR.setDuration(500L);
        this.cbR.setAnimationListener(this.jzc);
        this.jyU = new C0753a();
        this.ijb = new com.baidu.afd.videopaster.d(getContext(), this.iZO);
        this.jyX = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fcF.onChangeSkinType(i);
        this.eBF.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.iGz.setTextColor(ap.getColor(R.color.CAM_X0107));
        WebPManager.a(this.fcK, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fcH, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.jyJ.onChangeSkinType();
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
        if (gVar != null && gVar.jaD != null) {
            boolean z = this.jad == gVar;
            this.jad = gVar;
            this.ePB = this.jad.autoPlay;
            this.jyP = false;
            rb(false);
            this.jyJ.setVisibility(0);
            this.jyJ.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.jyJ.setTextColor(R.color.CAM_X0101);
            this.jyJ.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.jaD != null && !StringUtils.isNull(gVar.jaD.mcnLeadPage)) {
                this.jyJ.setTextMaxLine(2);
                this.jyJ.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.jyJ.getContentView(), gVar.title, gVar.jaD.mcnLeadPage, gVar.getThreadId());
            } else {
                this.jyJ.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.jyJ.setExpandable(true);
                this.jyJ.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void re(boolean z2) {
                        a.this.jad.isTitleExpanded = z2;
                    }
                });
                this.jyJ.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.izT) {
                this.jac.dBI();
                this.izT = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.iZO.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iZO.setLayoutParams(layoutParams);
            }
            cLy();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.jad = gVar;
        this.ePB = this.jad.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cLx() {
        try {
            int parseInt = Integer.parseInt(this.jad.jaD.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.jad.jaD.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cLy() {
        if (!cLx()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZN.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.iZN.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iZN.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.iZN.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.jaD != null) {
            this.jac.stopPlay();
            this.jac.wX(true);
            this.jac.wT(true);
            this.jac.wY(true);
            this.jac.av(false, false);
            this.jac.IG(i);
            this.jac.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                    a.this.cLC();
                    if (a.this.ijb != null) {
                        a.this.ijb.rK();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                    a.this.cLD();
                    if (a.this.jac.rM()) {
                    }
                    if (a.this.jai || (a.this.ijb != null && a.this.ijb.rC())) {
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(a.this.jzf);
                        com.baidu.adp.lib.f.e.mY().post(a.this.jzf);
                    }
                    if (a.this.ijb != null) {
                        a.this.ijb.rL();
                    }
                }
            });
            this.jac.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.l
                public void cEY() {
                    if (a.this.jad != null && a.this.jad.jaD != null && com.baidu.adp.lib.f.b.toInt(a.this.jad.jaD.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.jad.jaD.videoWidth, 0)) {
                        a.this.jac.av(false, false);
                    } else {
                        a.this.jac.av(true, false);
                    }
                    a.this.jai = false;
                    a.this.KN(a.this.ePB ? "1" : "2");
                    a.this.onClick(a.this.iZO);
                    if (a.this.aag != null) {
                        a.this.aag.a(a.this);
                    }
                    if (a.this.jyY != null) {
                        a.this.jyY.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void cEZ() {
                    a.this.onClick(a.this.iZN);
                }
            });
            this.jac.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.18
                @Override // com.baidu.tieba.play.c.f
                public void qt(boolean z2) {
                    a.this.jac.gb(a.this.jad.jaD.videoUrl, a.this.jad.threadId);
                    a.this.KN("2");
                    a.this.onClick(a.this.iZO);
                }
            });
            this.jac.wP(false);
            if (this.jyX != null) {
                this.jyX.reset();
            }
            this.startPosition = -1L;
            if (this.jac.getVideoView() != null && this.jac.getVideoView().getMediaProgressObserver() != null) {
                this.jac.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ci(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.jad.jaD.jaN;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.ijb.a(a.this.isFullScreen, a.this.jac != null && a.this.jac.dBp(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.ijb.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.jac.dBp() && !com.baidu.mcn.b.abJ().jK(aVar2.aav)) {
                            boolean z3 = a.this.startPosition >= (aVar2.jaF * 1000) + 1000;
                            if (i3 < aVar2.jaF * 1000 || i3 >= aVar2.jaG * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.jyX.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.cbD = aVar2.jaI;
                                    aVar3.cbE = aVar2.jaJ;
                                    aVar3.cbF = aVar2.aav;
                                    aVar3.cbC = aVar2.jaH;
                                    aVar3.fid = a.this.jad != null ? a.this.jad.forumId : null;
                                    aVar3.tid = a.this.jad != null ? a.this.jad.threadId : null;
                                    aVar3.cbG = 3;
                                    if (z3) {
                                        a.this.jyX.b(aVar3, (ViewGroup) a.this.jac.dBH());
                                    } else {
                                        a.this.jyX.a(aVar3, (ViewGroup) a.this.jac.dBH());
                                    }
                                }
                            } else if (a.this.jyX.isShowing()) {
                                a.this.jyX.dismiss();
                            }
                        }
                    }
                });
            }
            this.jaf = new o();
            this.jaf.amY = gVar.threadId;
            this.jaf.mNid = gVar.nid;
            this.jaf.fFV = gVar.forumId;
            this.jaf.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jaf.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.jaf.mSource = gVar.source;
            this.jaf.myo = gVar.weight;
            this.jaf.myq = this.mFrom;
            this.jaf.mys = gVar.abtest_tag;
            this.jaf.eGn = this.eGn;
            this.jaf.mExtra = gVar.extra;
            this.jaf.myv = "0";
            this.jaf.myr = gVar.getVideoType();
            this.jag = new o();
            this.jag.amY = gVar.threadId;
            this.jag.fFV = gVar.forumId;
            this.jag.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jag.myo = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jag.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.jag.myq = this.mFrom;
            this.jag.mSource = gVar.source;
            this.jag.myv = "0";
            if (gVar.jaD != null) {
                this.jaf.myt = gVar.jaD.videoMd5;
                this.jag.myt = gVar.jaD.videoMd5;
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
            this.jac.getVideoView().setVideoStatData(this.jaf);
            this.jac.dev();
            this.jac.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.ijb.a(a.this.isFullScreen, a.this.jac != null && a.this.jac.dBp(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.jai = true;
                            a.this.jyN = true;
                            a.this.jah = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.Ao(i);
                            a.this.jac.cRo();
                        }
                    }
                }
            });
            this.jac.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.jad != null && a.this.jad.jaD != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.jad.jaD.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.ijb.reset();
            }
            this.ijb.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rT() {
                    a.this.jyN = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rS() {
                    if (a.this.isFullScreen) {
                        a.this.jai = true;
                        a.this.jyN = true;
                        a.this.jah = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.Ao(i);
                        a.this.jac.cRo();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rR() {
                    if (a.this.jac != null) {
                        a.this.jac.IF(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rU() {
                    return a.this.cLB();
                }
            });
            this.jac.setThumbnail(gVar.jaD.thumbnailUrl);
            this.jac.IE(gVar.jaD.videoDuration);
            this.jac.setVideoUrl(gVar.jaD.videoUrl, gVar.threadId);
            this.jac.setFid(gVar.forumId);
            this.jac.cRo();
            this.jac.show();
            rb(false);
            if (gVar.autoPlay) {
                onClick(this.iZO);
                if (this.jyV.dxi()) {
                    this.jac.wV(false);
                    this.jyV.dXf();
                    this.jac.wW(true);
                    this.jac.ga(gVar.jaD.videoUrl, gVar.threadId);
                    if (this.ijb.rC()) {
                        this.ijb.stop();
                        this.ijb.rH();
                    }
                } else {
                    this.jac.wW(false);
                    this.jac.wV(false);
                    this.jyV.hide();
                    if (this.ijb == null || (this.ijb != null && !this.ijb.rC())) {
                        this.jac.a(gVar.jaD.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.jaE) {
                    this.jyQ.setVisibility(8);
                    this.jyU.BV(3);
                } else {
                    if (this.jyQ.getVisibility() == 0) {
                        this.jyQ.startAnimation(this.cbR);
                    }
                    this.jyU.BV(0);
                }
                gVar.jaE = false;
            } else {
                this.jyQ.setVisibility(0);
                this.jyV.hide();
                this.jac.wV(true);
                this.jyU.BV(3);
                this.jac.ga(gVar.jaD.videoUrl, gVar.threadId);
            }
            this.jai = false;
            this.jyN = false;
            if (!z && this.ijb.rC()) {
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
        com.baidu.afd.videopaster.data.b LL = this.jyW != null ? this.jyW.LL(gVar.getThreadId()) : null;
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
        if (gVar.jaD != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.jaD.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.jaD.videoHeight, 0);
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
        if (this.jad != null && this.jad.jaD != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jad.jaD.videoMd5, "", str, this.jag, this.jac.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public boolean isPlaying() {
        return this.jac.rM();
    }

    public boolean cLz() {
        return this.ijb.rC();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jac.aSi();
        }
    }

    public boolean Ap(int i) {
        if (i == 4 && this.ijb != null && ((this.ijb.rC() || this.jyN) && this.jac != null)) {
            this.ijb.bd(i);
            if (this.isFullScreen) {
                if (this.ijb.rB()) {
                    this.jac.dBq();
                } else {
                    this.jac.Vh();
                }
                return true;
            }
        }
        return this.jac.IF(i);
    }

    public void cEV() {
        this.jyP = false;
        this.jac.stopPlay();
        if (this.jyJ != null) {
            this.jyJ.setVisibility(0);
        }
        if (this.jyU != null) {
            this.jyU.BV(2);
        }
        rb(false);
        this.jyO = true;
        if (this.ijb != null && this.ijb.rC()) {
            this.ijb.stop();
        }
    }

    public void cLA() {
        this.ijb.stop();
    }

    public void cEW() {
        if (this.jac != null) {
            this.jac.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cEW();
        if (this.jae != null) {
            this.jae.cFg();
        }
        if (this.jyQ != null) {
            this.jyQ.clearAnimation();
        }
        this.ijb.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.jaC != null) {
            this.aky.setText(TextUtils.isEmpty(gVar.jaC.userNickname) ? gVar.jaC.userName : gVar.jaC.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jaC != null) {
            if (gVar.jaC.jaM != null && !TextUtils.isEmpty(gVar.jaC.jaM.avatar)) {
                this.iZU.startLoad(gVar.jaC.jaM.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.jaC.portrait) && gVar.jaC.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iZU.startLoad(gVar.jaC.portrait, 10, false);
            } else {
                this.iZU.startLoad(gVar.jaC.portrait, 12, false);
            }
            if (gVar.jaC.jaM != null && gVar.jaC.jaM.auth_id.intValue() > 0) {
                this.iZU.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.jaC.jaM.auth_id.intValue(), 1));
                this.iZU.setShowV(true);
                this.iZU.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.iZU.setBjhAuthIconRes(0);
            if (gVar.jaC.isBigV) {
                this.iZU.setShowV(gVar.jaC.isBigV);
                this.iZU.setIsBigV(gVar.jaC.isBigV);
            } else if (gVar.jaC.isGod) {
                this.iZU.setShowV(gVar.jaC.isGod);
                this.iZU.setIsBigV(gVar.jaC.isGod);
            } else {
                this.iZU.setShowV(gVar.jaC.isGod);
                this.iZU.setIsBigV(gVar.jaC.isGod);
            }
            this.iZU.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(final com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bqI() != null) {
                gVar.bqI().isInThread = true;
                gVar.bqI().nid = gVar.nid;
                if (this.jad.getVideoType() == 1) {
                    gVar.bqI().cardType = 2;
                } else if (this.jad.getVideoType() == 2) {
                    gVar.bqI().cardType = 8;
                } else if (this.jad.getVideoType() == 3) {
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
                        a.this.jyU.BV(0);
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
            this.iGz.setTextColor(ap.getColor(R.color.CAM_X0107));
            WebPManager.a(this.fcK, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.iGz.setText(au.numFormatOverWan(gVar.shareNum));
            } else {
                this.iGz.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jac != null && this.iZO != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jah) {
                this.jac.dBw();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cLC();
            } else {
                configuration.orientation = 1;
                cLD();
                this.jah = true;
            }
            this.jac.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLB() {
        if (this.jac != null && this.iZO != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iZO.getParent() != null) {
                if (this.iZO.getParent() == frameLayout) {
                    if (this.jyZ) {
                        this.jyZ = false;
                        return true;
                    } else if (!this.jza) {
                        this.jza = true;
                        return true;
                    }
                } else if (this.iZO.getParent() == this.iZN) {
                    if (this.jza) {
                        this.jza = false;
                        this.jzb = true;
                        return true;
                    } else if (!this.jyZ && this.jzb) {
                        this.jyZ = true;
                        this.jzb = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLC() {
        if (this.jac != null && this.iZO != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.iZO.getParent() != null) {
                if (this.iZO.getParent() == frameLayout) {
                    frameLayout.removeView(this.iZO);
                } else if (this.iZO.getParent() == this.iZN) {
                    this.iZN.removeView(this.iZO);
                }
            }
            if (this.iZO.getParent() == null) {
                frameLayout.addView(this.iZO);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iZO.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iZO.setLayoutParams(layoutParams);
                if (this.jyX != null && this.jyX.isShowing()) {
                    this.jyX.dismiss();
                }
                com.baidu.tbadk.util.e.bGk().kZ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLD() {
        if (this.jac != null && this.iZO != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.iZO.getParent() != null) {
                if (this.iZO.getParent() == frameLayout) {
                    cLE();
                    frameLayout.removeView(this.iZO);
                } else if (this.iZO.getParent() == this.iZN) {
                    cLE();
                    this.iZN.removeView(this.iZO);
                }
            }
            if (this.iZO.getParent() == null) {
                this.iZN.addView(this.iZO, 0);
                cLF();
                this.jac.dev();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bGk().kZ(false);
            }
        }
    }

    private void cLE() {
        if (this.ijb != null && this.ijb.rC()) {
            this.ijb.aA(true);
        }
    }

    private void cLF() {
        int i;
        if (!cLx()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.iZO.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (crI() != null) {
            view.setTag(this);
            crI().a(view, this.jad);
        }
        if (view == this.iZU || view == this.aky) {
            if (this.jad != null && this.jad.jaC != null && !TextUtils.isEmpty(this.jad.jaC.userId)) {
                this.jyU.BV(0);
                if (!TbadkCoreApplication.isLogin() || !this.jad.jaC.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jad.jaC.userId, 0L), z, this.jad.jaC.isGod)));
            }
        } else if (view == this.fcI) {
            if (this.jad != null) {
                this.jyU.BV(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jad.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.jad.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jyJ || view == this.jyK) {
            if (this.jad != null) {
                if (this.jyU.getCurrentState() != 2 && this.jyU.getCurrentState() != 3) {
                    z = false;
                }
                this.jyU.BV(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.jad.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.jad.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.fcL) {
            this.jyU.BV(0);
            bvJ();
        } else if (view == this.jyQ && this.jyQ.getVisibility() == 0 && this.jyS != null) {
            this.jyS.BZ(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qs(boolean z) {
        if (this.jad != null && this.jad.jaC != null) {
            this.jad.jaC.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cEX() {
        if (this.jad != null) {
            this.fcF.buP();
        }
    }

    public void ra(boolean z) {
        if (this.iZN != null) {
            this.iZN.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.jyY = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.jyS = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.aag = fVar;
    }

    private void rb(boolean z) {
        this.jyO = this.mPosition == (this.jyT == null ? -1 : this.jyT.cLR());
        if (this.jyO && z && isPlaying() && this.ePB && !this.jyP) {
            this.jyL.setVisibility(0);
            this.jyP = true;
            this.jyL.postDelayed(this.jze, 5000L);
            if (this.jyT != null) {
                this.jyT.gt(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.jyL.setVisibility(8);
        if (this.jze != null) {
            this.jyL.removeCallbacks(this.jze);
        }
    }

    private void bvJ() {
        String str;
        String str2;
        if (this.jad != null && this.mContext != null) {
            String valueOf = String.valueOf(this.jad.forumId);
            String str3 = this.jad.title;
            if (this.jad.mBaijiahao != null) {
                str = this.jad.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.jad.mBaijiahao.oriUgcType + "&dvid=" + this.jad.mBaijiahao.oriUgcVid + "&nid=" + this.jad.mBaijiahao.oriUgcNid;
            } else {
                str = this.jad.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str5 = this.jad.jaD.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.jad.title;
            String format = (this.jad.mBaijiahao == null || this.jad.jaC == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.jad.jaC.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.jad.mBaijiahao != null) {
                shareItem.fnC = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.fnC = str6;
                shareItem.readCount = this.jad.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.fnF = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.fnr = true;
            shareItem.fnE = 11;
            if (this.jad.getVideoType() == 1) {
                shareItem.fnJ = 2;
            } else if (this.jad.getVideoType() == 2) {
                shareItem.fnJ = 8;
            } else if (this.jad.getVideoType() == 3) {
                shareItem.fnJ = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.jad.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.jad.mBaijiahao;
            shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            arVar.dY("tid", str);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.al("obj_locate", 12);
            arVar.dY("nid", this.jad.nid);
            if (this.jad.mBaijiahao != null && !au.isEmpty(this.jad.mBaijiahao.oriUgcVid)) {
                arVar.dY("obj_param6", this.jad.mBaijiahao.oriUgcVid);
            }
            if (this.jad.getVideoType() == 1) {
                arVar.al(IntentConfig.CARD_TYPE, 2);
            } else if (this.jad.getVideoType() == 2) {
                arVar.al(IntentConfig.CARD_TYPE, 8);
            } else if (this.jad.getVideoType() == 3) {
                arVar.al(IntentConfig.CARD_TYPE, 6);
            }
            arVar.dY(IntentConfig.RECOM_SOURCE, this.jad.source);
            arVar.dY("ab_tag", this.jad.abtest_tag);
            arVar.dY("weight", this.jad.weight);
            arVar.dY("extra", this.jad.extra);
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
            com.baidu.tieba.d.f.ctk().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.k
    public void stopPlay() {
        cEV();
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

    public void cLG() {
        this.ijb.resume();
    }

    public boolean cLH() {
        if (this.jyU != null) {
            return this.jyU.getCurrentState() == 2 || this.jyU.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0753a {
        private int cnU;
        private Runnable jzj;

        private C0753a() {
            this.cnU = -1;
            this.jzj = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(C0753a.this.jzj);
                    C0753a.this.BV(2);
                }
            };
        }

        public void BV(int i) {
            switch (i) {
                case 0:
                    this.cnU = BW(i);
                    cLI();
                    return;
                case 1:
                    this.cnU = BW(i);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jzj);
                    return;
                case 2:
                    this.cnU = BX(i);
                    return;
                case 3:
                    this.cnU = BY(i);
                    cLI();
                    return;
                default:
                    this.cnU = BX(i);
                    return;
            }
        }

        private void cLI() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jzj);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jzj, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.cnU;
        }

        private int BW(int i) {
            if (i != this.cnU) {
                a.this.jyR.setVisibility(8);
                a.this.rc(true);
                return i;
            }
            return this.cnU;
        }

        private int BX(int i) {
            int i2 = this.cnU;
            if (i != this.cnU) {
                a.this.jyR.setVisibility(0);
                if (i2 != 3 || a.this.jad.autoPlay) {
                    a.this.rc(false);
                    return i;
                }
                return i;
            }
            return this.cnU;
        }

        private int BY(int i) {
            if (i != this.cnU) {
                a.this.jyR.setVisibility(0);
                a.this.rc(true);
                return i;
            }
            return this.cnU;
        }
    }
}
