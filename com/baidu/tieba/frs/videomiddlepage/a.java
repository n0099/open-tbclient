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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f XV;
    public TextView ahA;
    private Animation btW;
    private Animation btX;
    private TextView dEA;
    private String dIK;
    private boolean dQI;
    protected AgreeView edr;
    private ImageView eds;
    private View edt;
    private TextView edu;
    private ImageView edv;
    private View edw;
    private n fnj;
    private com.baidu.afd.videopaster.d gQK;
    public FrameLayout hFG;
    public FrameLayout hFH;
    public HeadImageView hFN;
    public com.baidu.tieba.play.c hFU;
    public com.baidu.tieba.frs.aggregation.g hFV;
    private com.baidu.tieba.frs.aggregation.h hFW;
    private y hFX;
    private y hFY;
    private boolean hFZ;
    private boolean hGa;
    private boolean hGd;
    private int hhk;
    public ExpandableTextView ibB;
    private View ibC;
    private FrameLayout ibD;
    private TextView ibE;
    private boolean ibF;
    private boolean ibG;
    private boolean ibH;
    private View ibI;
    private View ibJ;
    private c ibK;
    public com.baidu.tieba.frs.videomiddlepage.a.a ibL;
    private C0630a ibM;
    private VideoNetworkStateTipView ibN;
    private b ibO;
    private com.baidu.mcn.c ibP;
    private com.baidu.tieba.lego.card.view.g ibQ;
    private boolean ibR;
    private boolean ibS;
    private boolean ibT;
    private Animation.AnimationListener ibU;
    private Animation.AnimationListener ibV;
    private Runnable ibW;
    private Runnable ibX;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.hFZ = true;
        this.hGd = true;
        this.ibG = false;
        this.ibH = false;
        this.ibR = false;
        this.ibS = false;
        this.ibT = false;
        this.startPosition = -1L;
        this.hhk = 0;
        this.ibU = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ibI != null) {
                    a.this.ibI.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ibI != null) {
                    a.this.ibI.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ibV = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ibI != null) {
                    a.this.ibI.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ibI != null) {
                    a.this.ibI.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ibW = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ibD.getVisibility() == 0) {
                    a.this.ibD.setVisibility(8);
                }
            }
        };
        this.ibX = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hFU != null) {
                    a.this.hFU.stopPlay();
                }
            }
        };
        this.hGd = z;
        this.mFrom = str;
        this.dIK = str2;
        this.ibO = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hFG = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.ibC = view.findViewById(R.id.card_container);
        this.hFH = (FrameLayout) view.findViewById(R.id.video_container);
        this.hFU = new com.baidu.tieba.play.c(tbPageContext, this.hFH, false, com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test") ? 1 : 0);
        this.hFU.tA(z);
        this.hFU.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.ibL != null && a.this.hFV.hGv.videoDuration > 8) {
                    a.this.ibL.bd(a.this.mPosition, a.this.hFV.hGv.videoUrl);
                }
            }
        });
        this.hFU.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void oc(boolean z2) {
                if (a.this.ibM != null) {
                    if (z2) {
                        a.this.ibM.wm(0);
                    } else {
                        a.this.ibM.wm(1);
                    }
                }
            }
        });
        this.hFU.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.ibB = (ExpandableTextView) view.findViewById(R.id.title);
        this.hFN = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ahA = (TextView) view.findViewById(R.id.user_name);
        this.edr = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHr = 2;
        cVar.dHw = 6;
        this.edr.setStatisticData(cVar);
        this.dEA = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eds = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.edt = view.findViewById(R.id.thread_info_commont_container);
        this.edu = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.edv = (ImageView) view.findViewById(R.id.share_num_img);
        this.edw = view.findViewById(R.id.share_num_container);
        this.ibD = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.ibE = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.ibD.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ibE.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_download_link_url", null);
        this.ibE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    bc.aWU().a((TbPageContext) i.G(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.ibN = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.ibN.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ao("c13257"));
                a.this.ibN.setHasAgreeToPlay(true);
                a.this.hFU.tG(false);
                a.this.ibN.dpK();
                if (a.this.gQK.pV()) {
                    a.this.gQK.resume();
                } else if (a.this.hFV != null && a.this.hFV.hGv != null) {
                    a.this.hFU.fd(a.this.hFV.hGv.videoUrl, a.this.hFV.threadId);
                }
            }
        });
        this.ibI = view.findViewById(R.id.video_agg_container_foreground);
        this.ibJ = view.findViewById(R.id.title_and_comment_container_foreground);
        this.ibI.setOnClickListener(this);
        this.edt.setOnClickListener(this);
        this.edw.setOnClickListener(this);
        this.ibB.setOnClickListener(this);
        this.hFN.setOnClickListener(this);
        this.ahA.setOnClickListener(this);
        this.ibC.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.hhk = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFG.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hFG.setLayoutParams(layoutParams);
        this.hFN.setIsRound(true);
        this.hFN.setPlaceHolder(1);
        this.fnj = new n(tbPageContext.getPageActivity());
        this.hFW = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.btW = new AlphaAnimation(0.0f, 0.7f);
        this.btW.setDuration(500L);
        this.btW.setAnimationListener(this.ibV);
        this.btX = new AlphaAnimation(0.7f, 0.0f);
        this.btX.setDuration(500L);
        this.btX.setAnimationListener(this.ibU);
        this.ibM = new C0630a();
        this.gQK = new com.baidu.afd.videopaster.d(getContext(), this.hFH);
        this.ibP = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.edr.onChangeSkinType(i);
        this.dEA.setTextColor(an.getColor(R.color.cp_cont_d));
        this.edu.setTextColor(an.getColor(R.color.cp_cont_d));
        SvgManager.aWQ().a(this.eds, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aWQ().a(this.edv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ibB.onChangeSkinType();
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
        if (gVar != null && gVar.hGv != null) {
            boolean z = this.hFV == gVar;
            this.hFV = gVar;
            this.dQI = this.hFV.autoPlay;
            this.ibH = false;
            oa(false);
            this.ibB.setVisibility(0);
            this.ibB.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.ibB.setTextColor(R.color.cp_cont_a);
            this.ibB.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.hGv != null && !StringUtils.isNull(gVar.hGv.mcnLeadPage)) {
                this.ibB.setTextMaxLine(2);
                this.ibB.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.ibB.getContentView(), gVar.title, gVar.hGv.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ibB.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ibB.setExpandable(true);
                this.ibB.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void od(boolean z2) {
                        a.this.hFV.isTitleExpanded = z2;
                    }
                });
                this.ibB.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.hhk) {
                this.hFU.cUW();
                this.hhk = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hFH.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hFH.setLayoutParams(layoutParams);
            }
            cgc();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.hFV = gVar;
        this.dQI = this.hFV.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cgb() {
        try {
            int parseInt = Integer.parseInt(this.hFV.hGv.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.hFV.hGv.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cgc() {
        if (!cgb()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFG.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hFG.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hFG.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hFG.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.hGv != null) {
            this.hFU.stopPlay();
            this.hFU.setIsNeedRecoveryVideoPlayer(true);
            this.hFU.tH(true);
            this.hFU.tD(true);
            this.hFU.tI(true);
            this.hFU.ao(false, false);
            this.hFU.CJ(i);
            this.hFU.a(new c.InterfaceC0720c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qd() {
                    a.this.cgg();
                    if (a.this.gQK != null) {
                        a.this.gQK.qd();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qe() {
                    a.this.cgh();
                    if (a.this.hFU.qf()) {
                    }
                    if (a.this.hGa || (a.this.gQK != null && a.this.gQK.pV())) {
                        com.baidu.adp.lib.f.e.lt().removeCallbacks(a.this.ibX);
                        com.baidu.adp.lib.f.e.lt().post(a.this.ibX);
                    }
                    if (a.this.gQK != null) {
                        a.this.gQK.qe();
                    }
                }
            });
            this.hFU.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void caK() {
                    if (a.this.hFV != null && a.this.hFV.hGv != null && com.baidu.adp.lib.f.b.toInt(a.this.hFV.hGv.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.hFV.hGv.videoWidth, 0)) {
                        a.this.hFU.ao(false, false);
                    } else {
                        a.this.hFU.ao(true, false);
                    }
                    a.this.hGa = false;
                    a.this.Fh(a.this.dQI ? "1" : "2");
                    a.this.onClick(a.this.hFH);
                    if (a.this.XV != null) {
                        a.this.XV.a(a.this);
                    }
                    if (a.this.ibQ != null) {
                        a.this.ibQ.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void caL() {
                    a.this.onClick(a.this.hFG);
                }
            });
            this.hFU.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void nw(boolean z2) {
                    a.this.hFU.fd(a.this.hFV.hGv.videoUrl, a.this.hFV.threadId);
                    a.this.Fh("2");
                    a.this.onClick(a.this.hFH);
                }
            });
            this.hFU.tz(false);
            if (this.ibP != null) {
                this.ibP.reset();
            }
            this.startPosition = -1L;
            this.fnj.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void bM(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.hFV.hGv.hGG;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.gQK.a(a.this.isFullScreen, a.this.hFU != null && a.this.hFU.cUC(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.gQK.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.hFU.cUC() && !com.baidu.mcn.b.MG().go(aVar2.Yn)) {
                        boolean z3 = a.this.startPosition >= (aVar2.hGy * 1000) + 1000;
                        if (i3 < aVar2.hGy * 1000 || i3 >= aVar2.hGz * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.ibP.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.btJ = aVar2.hGB;
                                aVar3.btK = aVar2.hGC;
                                aVar3.btL = aVar2.Yn;
                                aVar3.btI = aVar2.hGA;
                                aVar3.fid = a.this.hFV != null ? a.this.hFV.forumId : null;
                                aVar3.tid = a.this.hFV != null ? a.this.hFV.threadId : null;
                                aVar3.btM = 3;
                                if (z3) {
                                    a.this.ibP.b(aVar3, (ViewGroup) a.this.hFU.cUV());
                                } else {
                                    a.this.ibP.a(aVar3, (ViewGroup) a.this.hFU.cUV());
                                }
                            }
                        } else if (a.this.ibP.isShowing()) {
                            a.this.ibP.dismiss();
                        }
                    }
                }
            });
            this.hFX = new y();
            this.hFX.ajO = gVar.threadId;
            this.hFX.mNid = gVar.nid;
            this.hFX.eEs = gVar.forumId;
            this.hFX.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hFX.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.hFX.mSource = gVar.source;
            this.hFX.kVo = gVar.weight;
            this.hFX.kVq = this.mFrom;
            this.hFX.kVs = gVar.abtest_tag;
            this.hFX.dIK = this.dIK;
            this.hFX.mExtra = gVar.extra;
            this.hFX.kVv = "0";
            this.hFX.kVr = gVar.getVideoType();
            this.hFY = new y();
            this.hFY.ajO = gVar.threadId;
            this.hFY.eEs = gVar.forumId;
            this.hFY.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hFY.kVo = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hFY.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.hFY.kVq = this.mFrom;
            this.hFY.mSource = gVar.source;
            this.hFY.kVv = "0";
            if (gVar.hGv != null) {
                this.hFX.kVt = gVar.hGv.videoMd5;
                this.hFY.kVt = gVar.hGv.videoMd5;
            }
            ao aoVar = new ao("c12590");
            aoVar.dk("tid", gVar.threadId);
            aoVar.dk("nid", gVar.nid);
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            aoVar.ag("obj_locate", i);
            aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aoVar.dk("fid", gVar.forumId);
            aoVar.dk("obj_param1", ar.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aoVar.dk("extra", ar.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aoVar.dk("obj_id", this.dIK);
            aoVar.dk("ab_tag", ar.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aoVar.dk("obj_type", this.mFrom);
            aoVar.ag("obj_param5", gVar.getVideoType());
            aoVar.dk("obj_source", ar.isEmpty(gVar.source) ? "0" : gVar.source);
            aoVar.ag("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aoVar.dk("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aoVar.dk("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aoVar);
            this.fnj.setVideoStatsData(this.hFX);
            this.hFU.cUE().setBusiness(this.fnj);
            this.fnj.a(gVar);
            this.hFU.cya();
            this.hFU.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.gQK.a(a.this.isFullScreen, a.this.hFU != null && a.this.hFU.cUC(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.hGa = true;
                            a.this.ibF = true;
                            a.this.hFZ = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.uQ(i);
                            a.this.hFU.clb();
                        }
                    }
                }
            });
            this.hFU.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.hFV != null && a.this.hFV.hGv != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.hFV.hGv.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.gQK.reset();
            }
            this.gQK.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void qm() {
                    a.this.ibF = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void ql() {
                    if (a.this.isFullScreen) {
                        a.this.hGa = true;
                        a.this.ibF = true;
                        a.this.hFZ = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.uQ(i);
                        a.this.hFU.clb();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void qk() {
                    if (a.this.hFU != null) {
                        a.this.hFU.CI(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean qn() {
                    return a.this.cgf();
                }
            });
            this.hFU.setThumbnail(gVar.hGv.thumbnailUrl);
            this.hFU.CH(gVar.hGv.videoDuration);
            this.hFU.setVideoUrl(gVar.hGv.videoUrl, gVar.threadId);
            this.hFU.setFid(gVar.forumId);
            this.hFU.clb();
            this.hFU.show();
            oa(false);
            if (gVar.autoPlay) {
                onClick(this.hFH);
                if (this.ibN.cQF()) {
                    this.hFU.tF(false);
                    this.ibN.dpJ();
                    this.hFU.tG(true);
                    this.hFU.fc(gVar.hGv.videoUrl, gVar.threadId);
                    if (this.gQK.pV()) {
                        this.gQK.stop();
                        this.gQK.qa();
                    }
                } else {
                    this.hFU.tG(false);
                    this.hFU.tF(false);
                    this.ibN.hide();
                    if (this.gQK == null || (this.gQK != null && !this.gQK.pV())) {
                        this.hFU.a(gVar.hGv.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.hGw) {
                    this.ibI.setVisibility(8);
                    this.ibM.wm(3);
                } else {
                    if (this.ibI.getVisibility() == 0) {
                        this.ibI.startAnimation(this.btX);
                    }
                    this.ibM.wm(0);
                }
                gVar.hGw = false;
            } else {
                this.ibI.setVisibility(0);
                this.ibN.hide();
                this.hFU.tF(true);
                this.ibM.wm(3);
                this.hFU.fc(gVar.hGv.videoUrl, gVar.threadId);
            }
            this.hGa = false;
            this.ibF = false;
            if (!z && this.gQK.pV()) {
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
        com.baidu.afd.videopaster.data.b FN = this.ibO != null ? this.ibO.FN(gVar.getThreadId()) : null;
        if (FN == null) {
            return null;
        }
        int qr = FN.qr();
        int qs = FN.qs();
        int qq = FN.qq();
        if (qq != -1) {
            i = qr != -1 ? (qq - qr) - 1 : -1;
            if (qs != -1) {
                i4 = (qs - qq) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.hGv != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.hGv.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.hGv.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", qq + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(String str) {
        if (this.hFV != null && this.hFV.hGv != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hFV.hGv.videoMd5, "", str, this.hFY, this.hFU.cUE().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hFU.qf();
    }

    public boolean cgd() {
        return this.gQK.pV();
    }

    public void caG() {
        if (isPlaying()) {
            this.hFU.awZ();
        }
    }

    public boolean uR(int i) {
        if (i == 4 && this.gQK != null && ((this.gQK.pV() || this.ibF) && this.hFU != null)) {
            this.gQK.aQ(i);
            if (this.isFullScreen) {
                if (this.gQK.pU()) {
                    this.hFU.cUD();
                } else {
                    this.hFU.Ii();
                }
                return true;
            }
        }
        return this.hFU.CI(i);
    }

    public void caH() {
        this.ibH = false;
        this.hFU.stopPlay();
        if (this.ibB != null) {
            this.ibB.setVisibility(0);
        }
        if (this.ibM != null) {
            this.ibM.wm(2);
        }
        oa(false);
        this.ibG = true;
        if (this.gQK != null && this.gQK.pV()) {
            this.gQK.stop();
        }
    }

    public void cge() {
        this.gQK.stop();
    }

    public void caI() {
        if (this.hFU != null) {
            this.hFU.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        caI();
        if (this.hFW != null) {
            this.hFW.caS();
        }
        if (this.ibI != null) {
            this.ibI.clearAnimation();
        }
        this.gQK.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.hGu != null) {
            this.ahA.setText(TextUtils.isEmpty(gVar.hGu.userNickname) ? gVar.hGu.userName : gVar.hGu.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.hGu != null) {
            if (gVar.hGu.hGF != null && !TextUtils.isEmpty(gVar.hGu.hGF.avatar)) {
                this.hFN.startLoad(gVar.hGu.hGF.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.hGu.portrait) && gVar.hGu.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hFN.startLoad(gVar.hGu.portrait, 10, false);
            } else {
                this.hFN.startLoad(gVar.hGu.portrait, 12, false);
            }
            if (gVar.hGu.hGF != null && gVar.hGu.hGF.auth_id.intValue() > 0) {
                this.hFN.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.hGu.hGF.auth_id.intValue(), 1));
                this.hFN.setShowV(true);
                this.hFN.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hFN.setBjhAuthIconRes(0);
            if (gVar.hGu.isBigV) {
                this.hFN.setShowV(gVar.hGu.isBigV);
                this.hFN.setIsBigV(gVar.hGu.isBigV);
            } else if (gVar.hGu.isGod) {
                this.hFN.setShowV(gVar.hGu.isGod);
                this.hFN.setIsBigV(gVar.hGu.isGod);
            } else {
                this.hFN.setShowV(gVar.hGu.isGod);
                this.hFN.setIsBigV(gVar.hGu.isGod);
            }
            this.hFN.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aUg() != null) {
                gVar.aUg().isInThread = true;
                gVar.aUg().nid = gVar.nid;
                if (this.hFV.getVideoType() == 1) {
                    gVar.aUg().cardType = 2;
                } else if (this.hFV.getVideoType() == 2) {
                    gVar.aUg().cardType = 8;
                } else if (this.hFV.getVideoType() == 3) {
                    gVar.aUg().cardType = 6;
                }
                gVar.aUg().baijiahaoData = gVar.mBaijiahao;
                gVar.aUg().recomSource = gVar.source;
                gVar.aUg().recomWeight = gVar.weight;
                gVar.aUg().recomAbTag = gVar.abtest_tag;
                gVar.aUg().recomExtra = gVar.extra;
            }
            if (this.hFV.mBaijiahao != null) {
                this.edr.setAgreeAlone(true);
            }
            this.edr.setIsFromMiddlePage(true);
            this.edr.setData(gVar.aUg());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dEA.setTextColor(an.getColor(R.color.cp_cont_d));
            SvgManager.aWQ().a(this.eds, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dEA.setText(ar.numFormatOverWan(gVar.postNum));
            } else {
                this.dEA.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.edu.setTextColor(an.getColor(R.color.cp_cont_d));
            SvgManager.aWQ().a(this.edv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.edu.setText(ar.numFormatOverWan(gVar.shareNum));
            } else {
                this.edu.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hFU != null && this.hFH != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hFZ) {
                this.hFU.cUK();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cgg();
            } else {
                configuration.orientation = 1;
                cgh();
                this.hFZ = true;
            }
            this.hFU.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgf() {
        if (this.hFU != null && this.hFH != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hFH.getParent() != null) {
                if (this.hFH.getParent() == frameLayout) {
                    if (this.ibR) {
                        this.ibR = false;
                        return true;
                    } else if (!this.ibS) {
                        this.ibS = true;
                        return true;
                    }
                } else if (this.hFH.getParent() == this.hFG) {
                    if (this.ibS) {
                        this.ibS = false;
                        this.ibT = true;
                        return true;
                    } else if (!this.ibR && this.ibT) {
                        this.ibR = true;
                        this.ibT = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgg() {
        if (this.hFU != null && this.hFH != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hFH.getParent() != null) {
                if (this.hFH.getParent() == frameLayout) {
                    frameLayout.removeView(this.hFH);
                } else if (this.hFH.getParent() == this.hFG) {
                    this.hFG.removeView(this.hFH);
                }
            }
            if (this.hFH.getParent() == null) {
                frameLayout.addView(this.hFH);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hFH.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hFH.setLayoutParams(layoutParams);
                if (this.ibP != null && this.ibP.isShowing()) {
                    this.ibP.dismiss();
                }
                com.baidu.tbadk.util.d.biC().iD(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgh() {
        if (this.hFU != null && this.hFH != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hFH.getParent() != null) {
                if (this.hFH.getParent() == frameLayout) {
                    cgi();
                    frameLayout.removeView(this.hFH);
                } else if (this.hFH.getParent() == this.hFG) {
                    cgi();
                    this.hFG.removeView(this.hFH);
                }
            }
            if (this.hFH.getParent() == null) {
                this.hFG.addView(this.hFH, 0);
                cgj();
                this.hFU.cya();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.biC().iD(false);
            }
        }
    }

    private void cgi() {
        if (this.gQK != null && this.gQK.pV()) {
            this.gQK.aA(true);
        }
    }

    private void cgj() {
        int i;
        if (!cgb()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hFH.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bOd() != null) {
            view.setTag(this);
            bOd().a(view, this.hFV);
        }
        if (view == this.hFN || view == this.ahA) {
            if (this.hFV != null && this.hFV.hGu != null && !TextUtils.isEmpty(this.hFV.hGu.userId)) {
                this.ibM.wm(0);
                if (!TbadkCoreApplication.isLogin() || !this.hFV.hGu.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hFV.hGu.userId, 0L), z, this.hFV.hGu.isGod)));
            }
        } else if (view == this.edt) {
            if (this.hFV != null) {
                this.ibM.wm(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hFV.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.hFV.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.ibB || view == this.ibC) {
            if (this.hFV != null) {
                if (this.ibM.getCurrentState() != 2 && this.ibM.getCurrentState() != 3) {
                    z = false;
                }
                this.ibM.wm(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.hFV.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.hFV.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.edw) {
            this.ibM.wm(0);
            aYB();
        } else if (view == this.ibI && this.ibI.getVisibility() == 0 && this.ibK != null) {
            this.ibK.wq(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void nv(boolean z) {
        if (this.hFV != null && this.hFV.hGu != null) {
            this.hFV.hGu.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void caJ() {
        if (this.hFV != null) {
            this.edr.aXK();
        }
    }

    public void nZ(boolean z) {
        if (this.hFG != null) {
            this.hFG.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.ibQ = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.ibK = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.XV = fVar;
    }

    private void oa(boolean z) {
        this.ibG = this.mPosition == (this.ibL == null ? -1 : this.ibL.cgv());
        if (this.ibG && z && isPlaying() && this.dQI && !this.ibH) {
            this.ibD.setVisibility(0);
            this.ibH = true;
            this.ibD.postDelayed(this.ibW, 5000L);
            if (this.ibL != null) {
                this.ibL.el(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ibD.setVisibility(8);
        if (this.ibW != null) {
            this.ibD.removeCallbacks(this.ibW);
        }
    }

    private void aYB() {
        String str;
        String str2;
        if (this.hFV != null && this.mContext != null) {
            String valueOf = String.valueOf(this.hFV.forumId);
            String str3 = this.hFV.title;
            if (this.hFV.mBaijiahao != null) {
                str = this.hFV.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.hFV.mBaijiahao.oriUgcType + "&dvid=" + this.hFV.mBaijiahao.oriUgcVid + "&nid=" + this.hFV.mBaijiahao.oriUgcNid;
            } else {
                str = this.hFV.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.hFV.hGv.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.hFV.title;
            String format = (this.hFV.mBaijiahao == null || this.hFV.hGu == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.hFV.hGu.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.hFV.mBaijiahao != null) {
                shareItem.enE = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.enE = str6;
                shareItem.readCount = this.hFV.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.enH = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.enu = true;
            shareItem.enG = 11;
            shareItem.enL = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.hFV.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.hFV.mBaijiahao;
            shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aoVar.dk("tid", str);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.ag("obj_locate", 12);
            aoVar.dk("nid", this.hFV.nid);
            if (this.hFV.mBaijiahao != null && !ar.isEmpty(this.hFV.mBaijiahao.oriUgcVid)) {
                aoVar.dk("obj_param6", this.hFV.mBaijiahao.oriUgcVid);
            }
            if (this.hFV.getVideoType() == 1) {
                aoVar.ag(IntentConfig.CARD_TYPE, 2);
            } else if (this.hFV.getVideoType() == 2) {
                aoVar.ag(IntentConfig.CARD_TYPE, 8);
            } else if (this.hFV.getVideoType() == 3) {
                aoVar.ag(IntentConfig.CARD_TYPE, 6);
            }
            aoVar.dk(IntentConfig.RECOM_SOURCE, this.hFV.source);
            aoVar.dk("ab_tag", this.hFV.abtest_tag);
            aoVar.dk("weight", this.hFV.weight);
            aoVar.dk("extra", this.hFV.extra);
            aoVar.dk("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            TiebaStatic.log(aoVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.enH);
            bundle.putInt("obj_type", shareItem.enL);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dOP);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.bPE().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        caH();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void awZ() {
        caG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
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

    public void cgk() {
        this.gQK.resume();
    }

    public boolean cgl() {
        if (this.ibM != null) {
            return this.ibM.getCurrentState() == 2 || this.ibM.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0630a {
        private Runnable icb;
        private int mCurrentState;

        private C0630a() {
            this.mCurrentState = -1;
            this.icb = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(C0630a.this.icb);
                    C0630a.this.wm(2);
                }
            };
        }

        public void wm(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = wn(i);
                    cgm();
                    return;
                case 1:
                    this.mCurrentState = wn(i);
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.icb);
                    return;
                case 2:
                    this.mCurrentState = wo(i);
                    return;
                case 3:
                    this.mCurrentState = wp(i);
                    cgm();
                    return;
                default:
                    this.mCurrentState = wo(i);
                    return;
            }
        }

        private void cgm() {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.icb);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.icb, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int wn(int i) {
            if (i != this.mCurrentState) {
                a.this.ibJ.setVisibility(8);
                a.this.ob(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int wo(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.ibJ.setVisibility(0);
                if (i2 != 3 || a.this.hFV.autoPlay) {
                    a.this.ob(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int wp(int i) {
            if (i != this.mCurrentState) {
                a.this.ibJ.setVisibility(0);
                a.this.ob(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
