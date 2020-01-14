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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f Dl;
    public TextView MK;
    private Animation aHr;
    private Animation aHs;
    private String cKN;
    private boolean cSi;
    protected AgreeView dda;
    private TextView ddb;
    private ImageView ddc;
    private View ddd;
    private TextView dde;
    private ImageView ddf;
    private View ddg;
    private n egU;
    private com.baidu.afd.videopaster.d fGO;
    private int fVZ;
    public com.baidu.tieba.frs.videomiddlepage.a.a gLA;
    private C0506a gLB;
    private VideoNetworkStateTipView gLC;
    private b gLD;
    private com.baidu.mcn.c gLE;
    private com.baidu.tieba.lego.card.view.g gLF;
    private boolean gLG;
    private boolean gLH;
    private boolean gLI;
    private Animation.AnimationListener gLJ;
    private Animation.AnimationListener gLK;
    private Runnable gLL;
    private Runnable gLM;
    public ExpandableTextView gLq;
    private View gLr;
    private FrameLayout gLs;
    private TextView gLt;
    private boolean gLu;
    private boolean gLv;
    private boolean gLw;
    private View gLx;
    private View gLy;
    private c gLz;
    public FrameLayout grH;
    public FrameLayout grI;
    public HeadImageView grO;
    public com.baidu.tieba.play.c grV;
    public com.baidu.tieba.frs.aggregation.g grW;
    private com.baidu.tieba.frs.aggregation.h grX;
    private y grY;
    private y grZ;
    private boolean gsa;
    private boolean gsb;
    private boolean gse;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.gsa = true;
        this.gse = true;
        this.gLv = false;
        this.gLw = false;
        this.gLG = false;
        this.gLH = false;
        this.gLI = false;
        this.startPosition = -1L;
        this.fVZ = 0;
        this.gLJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gLx != null) {
                    a.this.gLx.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gLx != null) {
                    a.this.gLx.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gLK = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gLx != null) {
                    a.this.gLx.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gLx != null) {
                    a.this.gLx.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gLL = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gLs.getVisibility() == 0) {
                    a.this.gLs.setVisibility(8);
                }
            }
        };
        this.gLM = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.grV != null) {
                    a.this.grV.stopPlay();
                }
            }
        };
        this.gse = z;
        this.mFrom = str;
        this.cKN = str2;
        this.gLD = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.grH = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gLr = view.findViewById(R.id.card_container);
        this.grI = (FrameLayout) view.findViewById(R.id.video_container);
        this.grV = new com.baidu.tieba.play.c(tbPageContext, this.grI, false, com.baidu.tbadk.a.b.rs("cyber_player_test") ? 1 : 0);
        this.grV.rB(z);
        this.grV.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.gLA != null && a.this.grW.gsw.videoDuration > 8) {
                    a.this.gLA.aF(a.this.mPosition, a.this.grW.gsw.videoUrl);
                }
            }
        });
        this.grV.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void mj(boolean z2) {
                if (a.this.gLB != null) {
                    if (z2) {
                        a.this.gLB.uo(0);
                    } else {
                        a.this.gLB.uo(1);
                    }
                }
            }
        });
        this.grV.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.gLq = (ExpandableTextView) view.findViewById(R.id.title);
        this.grO = (HeadImageView) view.findViewById(R.id.user_icon);
        this.MK = (TextView) view.findViewById(R.id.user_name);
        this.dda = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJy = 2;
        dVar.cJD = 6;
        this.dda.setStatisticData(dVar);
        this.ddb = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.ddc = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.ddd = view.findViewById(R.id.thread_info_commont_container);
        this.dde = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.ddf = (ImageView) view.findViewById(R.id.share_num_img);
        this.ddg = view.findViewById(R.id.share_num_container);
        this.ddg.setVisibility(8);
        this.gLs = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.gLt = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.gLs.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gLt.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_download_link_url", null);
        this.gLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aEt().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.gLC = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.gLC.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.gLC.setHasAgreeToPlay(true);
                a.this.grV.rH(false);
                a.this.gLC.cRa();
                if (a.this.fGO.kF()) {
                    a.this.fGO.resume();
                } else if (a.this.grW != null && a.this.grW.gsw != null) {
                    a.this.grV.dZ(a.this.grW.gsw.videoUrl, a.this.grW.threadId);
                }
            }
        });
        this.gLx = view.findViewById(R.id.video_agg_container_foreground);
        this.gLy = view.findViewById(R.id.title_and_comment_container_foreground);
        this.gLx.setOnClickListener(this);
        this.ddd.setOnClickListener(this);
        this.ddg.setOnClickListener(this);
        this.gLq.setOnClickListener(this);
        this.grO.setOnClickListener(this);
        this.MK.setOnClickListener(this);
        this.gLr.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.fVZ = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grH.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.grH.setLayoutParams(layoutParams);
        this.grO.setIsRound(true);
        this.grO.setPlaceHolder(1);
        this.egU = new n(tbPageContext.getPageActivity());
        this.grX = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.aHr = new AlphaAnimation(0.0f, 0.7f);
        this.aHr.setDuration(500L);
        this.aHr.setAnimationListener(this.gLK);
        this.aHs = new AlphaAnimation(0.7f, 0.0f);
        this.aHs.setDuration(500L);
        this.aHs.setAnimationListener(this.gLJ);
        this.gLB = new C0506a();
        this.fGO = new com.baidu.afd.videopaster.d(getContext(), this.grI);
        this.gLE = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dda.onChangeSkinType(i);
        this.ddb.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dde.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.gLq.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.gsw != null) {
            boolean z = this.grW == gVar;
            this.grW = gVar;
            this.cSi = this.grW.autoPlay;
            this.gLw = false;
            mh(false);
            this.gLq.setVisibility(0);
            this.gLq.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.gLq.setTextColor(R.color.cp_cont_a);
            this.gLq.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.gsw != null && !StringUtils.isNull(gVar.gsw.mcnLeadPage)) {
                this.gLq.setTextMaxLine(2);
                this.gLq.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.gLq.getContentView(), gVar.title, gVar.gsw.mcnLeadPage, gVar.getThreadId());
            } else {
                this.gLq.setTextMaxLine(Integer.MAX_VALUE);
                this.gLq.setExpandable(true);
                this.gLq.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mk(boolean z2) {
                        a.this.grW.isTitleExpanded = z2;
                    }
                });
                this.gLq.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.fVZ) {
                this.grV.cwX();
                this.fVZ = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.grI.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.grI.setLayoutParams(layoutParams);
            }
            bJF();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bJE() {
        try {
            int parseInt = Integer.parseInt(this.grW.gsw.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.grW.gsw.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bJF() {
        if (!bJE()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grH.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.grH.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.grH.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.grH.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.gsw != null) {
            this.grV.stopPlay();
            this.grV.setIsNeedRecoveryVideoPlayer(true);
            this.grV.rI(true);
            this.grV.rE(true);
            this.grV.rJ(true);
            this.grV.ah(false, false);
            this.grV.Ae(i);
            this.grV.a(new c.InterfaceC0581c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kN() {
                    a.this.bJJ();
                    if (a.this.fGO != null) {
                        a.this.fGO.kN();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kO() {
                    a.this.bJK();
                    if (a.this.grV.kP()) {
                    }
                    if (a.this.gsb || (a.this.fGO != null && a.this.fGO.kF())) {
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(a.this.gLM);
                        com.baidu.adp.lib.f.e.gx().post(a.this.gLM);
                    }
                    if (a.this.fGO != null) {
                        a.this.fGO.kO();
                    }
                }
            });
            this.grV.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bEJ() {
                    if (a.this.grW != null && a.this.grW.gsw != null && com.baidu.adp.lib.f.b.toInt(a.this.grW.gsw.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.grW.gsw.videoWidth, 0)) {
                        a.this.grV.ah(false, false);
                    } else {
                        a.this.grV.ah(true, false);
                    }
                    a.this.gsb = false;
                    a.this.AS(a.this.cSi ? "1" : "2");
                    a.this.onClick(a.this.grI);
                    if (a.this.Dl != null) {
                        a.this.Dl.a(a.this);
                    }
                    if (a.this.gLF != null) {
                        a.this.gLF.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bEK() {
                    a.this.onClick(a.this.grH);
                }
            });
            this.grV.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void lE(boolean z2) {
                    a.this.grV.dZ(a.this.grW.gsw.videoUrl, a.this.grW.threadId);
                    a.this.AS("2");
                    a.this.onClick(a.this.grI);
                }
            });
            this.grV.rA(false);
            if (this.gLE != null) {
                this.gLE.reset();
            }
            this.startPosition = -1L;
            this.egU.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void bx(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.grW.gsw.gsH;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.fGO.a(a.this.isFullScreen, a.this.grV != null && a.this.grV.cwD(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.fGO.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.grV.cwD() && !com.baidu.mcn.b.Bo().em(aVar2.DD)) {
                        boolean z3 = a.this.startPosition >= (aVar2.gsz * 1000) + 1000;
                        if (i3 < aVar2.gsz * 1000 || i3 >= aVar2.gsA * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.gLE.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aHe = aVar2.gsC;
                                aVar3.aHf = aVar2.gsD;
                                aVar3.aHg = aVar2.DD;
                                aVar3.aHd = aVar2.gsB;
                                aVar3.fid = a.this.grW != null ? a.this.grW.forumId : null;
                                aVar3.tid = a.this.grW != null ? a.this.grW.threadId : null;
                                aVar3.aHh = 3;
                                if (z3) {
                                    a.this.gLE.b(aVar3, (ViewGroup) a.this.grV.cwW());
                                } else {
                                    a.this.gLE.a(aVar3, (ViewGroup) a.this.grV.cwW());
                                }
                            }
                        } else if (a.this.gLE.isShowing()) {
                            a.this.gLE.dismiss();
                        }
                    }
                }
            });
            this.grY = new y();
            this.grY.OG = gVar.threadId;
            this.grY.fKa = gVar.forumId;
            this.grY.mUid = TbadkCoreApplication.getCurrentAccount();
            this.grY.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.grY.mSource = gVar.source;
            this.grY.jvO = gVar.weight;
            this.grY.jvQ = this.mFrom;
            this.grY.mAbTag = gVar.abtest_tag;
            this.grY.cKN = this.cKN;
            this.grY.mExtra = gVar.extra;
            this.grY.jvU = "0";
            this.grY.jvR = gVar.getVideoType();
            this.grZ = new y();
            this.grZ.OG = gVar.threadId;
            this.grZ.fKa = gVar.forumId;
            this.grZ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.grZ.jvO = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.grZ.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.grZ.jvQ = this.mFrom;
            this.grZ.mSource = gVar.source;
            this.grZ.jvU = "0";
            if (gVar.gsw != null) {
                this.grY.jvS = gVar.gsw.videoMd5;
                this.grZ.jvS = gVar.gsw.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cp("tid", gVar.threadId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.Z("obj_locate", i);
            anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cp("fid", gVar.forumId);
            anVar.cp("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cp("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cp("obj_id", this.cKN);
            anVar.cp(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.cp("obj_type", this.mFrom);
            anVar.Z("obj_param5", gVar.getVideoType());
            anVar.cp("obj_source", aq.isEmpty(this.grW.source) ? "0" : this.grW.source);
            anVar.Z("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.cp("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.cp("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.egU.setVideoStatsData(this.grY);
            this.grV.cwF().setBusiness(this.egU);
            this.egU.a(gVar);
            this.grV.cbd();
            this.grV.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.fGO.a(a.this.isFullScreen, a.this.grV != null && a.this.grV.cwD(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.gsb = true;
                            a.this.gLu = true;
                            a.this.gsa = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.sY(i);
                            a.this.grV.bOk();
                        }
                    }
                }
            });
            this.grV.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.grW != null && a.this.grW.gsw != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.grW.gsw.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.fGO.reset();
            }
            this.fGO.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void kW() {
                    a.this.gLu = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kV() {
                    if (a.this.isFullScreen) {
                        a.this.gsb = true;
                        a.this.gLu = true;
                        a.this.gsa = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.sY(i);
                        a.this.grV.bOk();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kU() {
                    if (a.this.grV != null) {
                        a.this.grV.Ad(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean kX() {
                    return a.this.bJI();
                }
            });
            this.grV.setThumbnail(gVar.gsw.thumbnailUrl);
            this.grV.setVideoUrl(gVar.gsw.videoUrl, gVar.threadId);
            this.grV.setFid(gVar.forumId);
            this.grV.bOk();
            this.grV.show();
            mh(false);
            if (gVar.autoPlay) {
                onClick(this.grI);
                if (this.gLC.csE()) {
                    this.grV.rG(false);
                    this.gLC.cQZ();
                    this.grV.rH(true);
                    this.grV.dY(gVar.gsw.videoUrl, gVar.threadId);
                    if (this.fGO.kF()) {
                        this.fGO.stop();
                        this.fGO.kK();
                    }
                } else {
                    this.grV.rH(false);
                    this.grV.rG(false);
                    this.gLC.hide();
                    if (this.fGO == null || (this.fGO != null && !this.fGO.kF())) {
                        this.grV.a(gVar.gsw.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.gsx) {
                    this.gLx.setVisibility(8);
                    this.gLB.uo(3);
                } else {
                    if (this.gLx.getVisibility() == 0) {
                        this.gLx.startAnimation(this.aHs);
                    }
                    this.gLB.uo(0);
                }
                gVar.gsx = false;
            } else {
                this.gLx.setVisibility(0);
                this.gLC.hide();
                this.grV.rG(true);
                this.gLB.uo(3);
                this.grV.dY(gVar.gsw.videoUrl, gVar.threadId);
            }
            this.gsb = false;
            this.gLu = false;
            if (!z && this.fGO.kF()) {
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
        com.baidu.afd.videopaster.data.b BB = this.gLD != null ? this.gLD.BB(gVar.getThreadId()) : null;
        if (BB == null) {
            return null;
        }
        int lb = BB.lb();
        int lc = BB.lc();
        int la = BB.la();
        if (la != -1) {
            i = lb != -1 ? (la - lb) - 1 : -1;
            if (lc != -1) {
                i4 = (lc - la) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.gsw != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.gsw.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.gsw.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", la + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS(String str) {
        if (this.grW != null && this.grW.gsw != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.grW.gsw.videoMd5, "", str, this.grZ);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.grV.kP();
    }

    public boolean bJG() {
        return this.fGO.kF();
    }

    public void bEF() {
        if (isPlaying()) {
            this.grV.pausePlay();
        }
    }

    public boolean sZ(int i) {
        if (i == 4 && this.fGO != null && ((this.fGO.kF() || this.gLu) && this.grV != null)) {
            this.fGO.au(i);
            if (this.isFullScreen) {
                if (this.fGO.kE()) {
                    this.grV.cwE();
                } else {
                    this.grV.xH();
                }
                return true;
            }
        }
        return this.grV.Ad(i);
    }

    public void bEG() {
        this.gLw = false;
        this.grV.stopPlay();
        if (this.gLq != null) {
            this.gLq.setVisibility(0);
        }
        if (this.gLB != null) {
            this.gLB.uo(2);
        }
        mh(false);
        this.gLv = true;
        if (this.fGO != null && this.fGO.kF()) {
            this.fGO.stop();
        }
    }

    public void bJH() {
        this.fGO.stop();
    }

    public void bEH() {
        if (this.grV != null) {
            this.grV.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bEH();
        if (this.grX != null) {
            this.grX.bER();
        }
        if (this.gLx != null) {
            this.gLx.clearAnimation();
        }
        this.fGO.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.gsv != null) {
            this.MK.setText(TextUtils.isEmpty(gVar.gsv.userNickname) ? gVar.gsv.userName : gVar.gsv.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.gsv != null) {
            if (gVar.gsv.gsG != null && !TextUtils.isEmpty(gVar.gsv.gsG.avatar)) {
                this.grO.startLoad(gVar.gsv.gsG.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.gsv.portrait) && gVar.gsv.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.grO.startLoad(gVar.gsv.portrait, 10, false);
            } else {
                this.grO.startLoad(gVar.gsv.portrait, 12, false);
            }
            if (gVar.gsv.gsG != null && gVar.gsv.gsG.auth_id.intValue() > 0) {
                this.grO.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.gsv.gsG.auth_id.intValue(), 1));
                this.grO.setShowV(true);
                this.grO.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.grO.setBjhAuthIconRes(0);
            if (gVar.gsv.isBigV) {
                this.grO.setShowV(gVar.gsv.isBigV);
                this.grO.setIsBigV(gVar.gsv.isBigV);
            } else if (gVar.gsv.isGod) {
                this.grO.setShowV(gVar.gsv.isGod);
                this.grO.setIsBigV(gVar.gsv.isGod);
            } else {
                this.grO.setShowV(gVar.gsv.isGod);
                this.grO.setIsBigV(gVar.gsv.isGod);
            }
            this.grO.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aBM() != null) {
                gVar.aBM().isInThread = true;
            }
            if (this.grW.mBaijiahao != null) {
                this.dda.setAgreeAlone(true);
            }
            this.dda.setIsFromMiddlePage(true);
            this.dda.setData(gVar.aBM());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.ddb.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.ddb.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.ddb.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dde.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dde.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dde.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.grV != null && this.grI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gsa) {
                this.grV.cwL();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bJJ();
            } else {
                configuration.orientation = 1;
                bJK();
                this.gsa = true;
            }
            this.grV.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJI() {
        if (this.grV != null && this.grI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.grI.getParent() != null) {
                if (this.grI.getParent() == frameLayout) {
                    if (this.gLG) {
                        this.gLG = false;
                        return true;
                    } else if (!this.gLH) {
                        this.gLH = true;
                        return true;
                    }
                } else if (this.grI.getParent() == this.grH) {
                    if (this.gLH) {
                        this.gLH = false;
                        this.gLI = true;
                        return true;
                    } else if (!this.gLG && this.gLI) {
                        this.gLG = true;
                        this.gLI = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        if (this.grV != null && this.grI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.grI.getParent() != null) {
                if (this.grI.getParent() == frameLayout) {
                    frameLayout.removeView(this.grI);
                } else if (this.grI.getParent() == this.grH) {
                    this.grH.removeView(this.grI);
                }
            }
            if (this.grI.getParent() == null) {
                frameLayout.addView(this.grI);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.grI.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.grI.setLayoutParams(layoutParams);
                if (this.gLE != null && this.gLE.isShowing()) {
                    this.gLE.dismiss();
                }
                com.baidu.tbadk.util.d.aPy().gS(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        if (this.grV != null && this.grI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.grI.getParent() != null) {
                if (this.grI.getParent() == frameLayout) {
                    bJL();
                    frameLayout.removeView(this.grI);
                } else if (this.grI.getParent() == this.grH) {
                    bJL();
                    this.grH.removeView(this.grI);
                }
            }
            if (this.grI.getParent() == null) {
                this.grH.addView(this.grI, 0);
                bJM();
                this.grV.cbd();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.aPy().gS(false);
            }
        }
    }

    private void bJL() {
        if (this.fGO != null && this.fGO.kF()) {
            this.fGO.V(true);
        }
    }

    private void bJM() {
        int i;
        if (!bJE()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.grI.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (bta() != null) {
            view.setTag(this);
            bta().a(view, this.grW);
        }
        if (view == this.grO || view == this.MK) {
            if (this.grW != null && this.grW.gsv != null && !TextUtils.isEmpty(this.grW.gsv.userId)) {
                this.gLB.uo(0);
                if (!TbadkCoreApplication.isLogin() || !this.grW.gsv.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.grW.gsv.userId, 0L), z, this.grW.gsv.isGod)));
            }
        } else if (view == this.ddd) {
            if (this.grW != null) {
                this.gLB.uo(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.grW.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.grW.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gLq || view == this.gLr) {
            if (this.grW != null) {
                if (this.gLB.getCurrentState() != 2 && this.gLB.getCurrentState() != 3) {
                    z = false;
                }
                this.gLB.uo(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.grW.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.grW.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.ddg) {
            this.gLB.uo(0);
            aFL();
        } else if (view == this.gLx && this.gLx.getVisibility() == 0 && this.gLz != null) {
            this.gLz.us(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lD(boolean z) {
        if (this.grW != null && this.grW.gsv != null) {
            this.grW.gsv.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bEI() {
        if (this.grW != null) {
            this.dda.aFe();
        }
    }

    public void mg(boolean z) {
        if (this.grH != null) {
            this.grH.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.gLF = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.gLz = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Dl = fVar;
    }

    private void mh(boolean z) {
        this.gLv = this.mPosition == (this.gLA == null ? -1 : this.gLA.bJX());
        if (this.gLv && z && isPlaying() && this.cSi && !this.gLw) {
            this.gLs.setVisibility(0);
            this.gLw = true;
            this.gLs.postDelayed(this.gLL, 5000L);
            if (this.gLA != null) {
                this.gLA.dy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.gLs.setVisibility(8);
        if (this.gLL != null) {
            this.gLs.removeCallbacks(this.gLL);
        }
    }

    private void aFL() {
        if (this.grW != null && this.mContext != null) {
            if (this.grW.mBaijiahao != null && !TbadkCoreApplication.isLogin()) {
                bc.skipToLoginActivity(getContext());
                return;
            }
            String valueOf = String.valueOf(this.grW.forumId);
            String str = this.grW.title;
            String str2 = this.grW.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.grW.gsw.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.grW.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = format;
            shareItem.dlS = str5;
            shareItem.linkUrl = str3;
            shareItem.extData = str2;
            shareItem.dlV = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str2;
            shareItem.dlJ = true;
            shareItem.dlU = 0;
            shareItem.dlZ = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.grW.mBaijiahao != null) {
                shareItem.dmf = false;
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            originalThreadInfo.oriUgcInfo = this.grW.mBaijiahao;
            shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dlV);
            bundle.putInt("obj_type", shareItem.dlZ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cQy);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.buG().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bEG();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bEF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(boolean z) {
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

    public void bJN() {
        this.fGO.resume();
    }

    public boolean bJO() {
        if (this.gLB != null) {
            return this.gLB.getCurrentState() == 2 || this.gLB.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0506a {
        private Runnable gLQ;
        private int mCurrentState;

        private C0506a() {
            this.mCurrentState = -1;
            this.gLQ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(C0506a.this.gLQ);
                    C0506a.this.uo(2);
                }
            };
        }

        public void uo(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = up(i);
                    bJP();
                    return;
                case 1:
                    this.mCurrentState = up(i);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gLQ);
                    return;
                case 2:
                    this.mCurrentState = uq(i);
                    return;
                case 3:
                    this.mCurrentState = ur(i);
                    bJP();
                    return;
                default:
                    this.mCurrentState = uq(i);
                    return;
            }
        }

        private void bJP() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gLQ);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gLQ, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int up(int i) {
            if (i != this.mCurrentState) {
                a.this.gLy.setVisibility(8);
                a.this.mi(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uq(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.gLy.setVisibility(0);
                if (i2 != 3 || a.this.grW.autoPlay) {
                    a.this.mi(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ur(int i) {
            if (i != this.mCurrentState) {
                a.this.gLy.setVisibility(0);
                a.this.mi(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
