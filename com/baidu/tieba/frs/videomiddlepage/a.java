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
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f Dg;
    public TextView ME;
    private Animation aGA;
    private Animation aGz;
    private String cKC;
    private boolean cRY;
    protected AgreeView dcQ;
    private TextView dcR;
    private ImageView dcS;
    private View dcT;
    private TextView dcU;
    private ImageView dcV;
    private View dcW;
    private n egK;
    private com.baidu.afd.videopaster.d fDE;
    private int fSQ;
    public ExpandableTextView gId;
    private View gIe;
    private FrameLayout gIf;
    private TextView gIg;
    private boolean gIh;
    private boolean gIi;
    private boolean gIj;
    private View gIk;
    private View gIl;
    private c gIm;
    public com.baidu.tieba.frs.videomiddlepage.a.a gIn;
    private C0502a gIo;
    private VideoNetworkStateTipView gIp;
    private b gIq;
    private com.baidu.mcn.c gIr;
    private com.baidu.tieba.lego.card.view.g gIs;
    private boolean gIt;
    private boolean gIu;
    private boolean gIv;
    private Animation.AnimationListener gIw;
    private Animation.AnimationListener gIx;
    private Runnable gIy;
    private Runnable gIz;
    public HeadImageView goF;
    public com.baidu.tieba.play.c goM;
    public com.baidu.tieba.frs.aggregation.g goN;
    private com.baidu.tieba.frs.aggregation.h goO;
    private y goP;
    private y goQ;
    private boolean goR;
    private boolean goS;
    private boolean goV;
    public FrameLayout goy;
    public FrameLayout goz;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.goR = true;
        this.goV = true;
        this.gIi = false;
        this.gIj = false;
        this.gIt = false;
        this.gIu = false;
        this.gIv = false;
        this.startPosition = -1L;
        this.fSQ = 0;
        this.gIw = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gIk != null) {
                    a.this.gIk.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gIk != null) {
                    a.this.gIk.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gIx = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gIk != null) {
                    a.this.gIk.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gIk != null) {
                    a.this.gIk.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gIy = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gIf.getVisibility() == 0) {
                    a.this.gIf.setVisibility(8);
                }
            }
        };
        this.gIz = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.goM != null) {
                    a.this.goM.stopPlay();
                }
            }
        };
        this.goV = z;
        this.mFrom = str;
        this.cKC = str2;
        this.gIq = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.goy = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gIe = view.findViewById(R.id.card_container);
        this.goz = (FrameLayout) view.findViewById(R.id.video_container);
        this.goM = new com.baidu.tieba.play.c(tbPageContext, this.goz, false, com.baidu.tbadk.a.b.rp("cyber_player_test") ? 1 : 0);
        this.goM.ro(z);
        this.goM.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.gIn != null && a.this.goN.gpn.videoDuration > 8) {
                    a.this.gIn.az(a.this.mPosition, a.this.goN.gpn.videoUrl);
                }
            }
        });
        this.goM.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void lY(boolean z2) {
                if (a.this.gIo != null) {
                    if (z2) {
                        a.this.gIo.uj(0);
                    } else {
                        a.this.gIo.uj(1);
                    }
                }
            }
        });
        this.goM.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.gId = (ExpandableTextView) view.findViewById(R.id.title);
        this.goF = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ME = (TextView) view.findViewById(R.id.user_name);
        this.dcQ = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJn = 2;
        dVar.cJs = 6;
        this.dcQ.setStatisticData(dVar);
        this.dcR = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dcS = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dcT = view.findViewById(R.id.thread_info_commont_container);
        this.dcU = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dcV = (ImageView) view.findViewById(R.id.share_num_img);
        this.dcW = view.findViewById(R.id.share_num_container);
        this.dcW.setVisibility(8);
        this.gIf = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.gIg = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.gIf.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gIg.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_download_link_url", null);
        this.gIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aEa().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.gIp = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.gIp.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.gIp.setHasAgreeToPlay(true);
                a.this.goM.ru(false);
                a.this.gIp.cPV();
                if (a.this.fDE.kE()) {
                    a.this.fDE.resume();
                } else if (a.this.goN != null && a.this.goN.gpn != null) {
                    a.this.goM.dX(a.this.goN.gpn.videoUrl, a.this.goN.threadId);
                }
            }
        });
        this.gIk = view.findViewById(R.id.video_agg_container_foreground);
        this.gIl = view.findViewById(R.id.title_and_comment_container_foreground);
        this.gIk.setOnClickListener(this);
        this.dcT.setOnClickListener(this);
        this.dcW.setOnClickListener(this);
        this.gId.setOnClickListener(this);
        this.goF.setOnClickListener(this);
        this.ME.setOnClickListener(this);
        this.gIe.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.fSQ = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.goy.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.goy.setLayoutParams(layoutParams);
        this.goF.setIsRound(true);
        this.goF.setPlaceHolder(1);
        this.egK = new n(tbPageContext.getPageActivity());
        this.goO = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.aGz = new AlphaAnimation(0.0f, 0.7f);
        this.aGz.setDuration(500L);
        this.aGz.setAnimationListener(this.gIx);
        this.aGA = new AlphaAnimation(0.7f, 0.0f);
        this.aGA.setDuration(500L);
        this.aGA.setAnimationListener(this.gIw);
        this.gIo = new C0502a();
        this.fDE = new com.baidu.afd.videopaster.d(getContext(), this.goz);
        this.gIr = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dcQ.onChangeSkinType(i);
        this.dcR.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dcU.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aDW().a(this.dcS, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aDW().a(this.dcV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.gId.onChangeSkinType();
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
        if (gVar != null && gVar.gpn != null) {
            boolean z = this.goN == gVar;
            this.goN = gVar;
            this.cRY = this.goN.autoPlay;
            this.gIj = false;
            lW(false);
            this.gId.setVisibility(0);
            this.gId.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.gId.setTextColor(R.color.cp_cont_a);
            this.gId.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.gpn != null && !StringUtils.isNull(gVar.gpn.mcnLeadPage)) {
                this.gId.setTextMaxLine(2);
                this.gId.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.gId.getContentView(), gVar.title, gVar.gpn.mcnLeadPage, gVar.getThreadId());
            } else {
                this.gId.setTextMaxLine(Integer.MAX_VALUE);
                this.gId.setExpandable(true);
                this.gId.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void lZ(boolean z2) {
                        a.this.goN.isTitleExpanded = z2;
                    }
                });
                this.gId.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.fSQ) {
                this.goM.cvO();
                this.fSQ = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.goz.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.goz.setLayoutParams(layoutParams);
            }
            bID();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bIC() {
        try {
            int parseInt = Integer.parseInt(this.goN.gpn.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.goN.gpn.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bID() {
        if (!bIC()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.goy.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.goy.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.goy.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.goy.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.gpn != null) {
            this.goM.stopPlay();
            this.goM.setIsNeedRecoveryVideoPlayer(true);
            this.goM.rv(true);
            this.goM.rr(true);
            this.goM.rw(true);
            this.goM.ah(false, false);
            this.goM.zZ(i);
            this.goM.a(new c.InterfaceC0576c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kM() {
                    a.this.bIH();
                    if (a.this.fDE != null) {
                        a.this.fDE.kM();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kN() {
                    a.this.bII();
                    if (a.this.goM.kO()) {
                    }
                    if (a.this.goS || (a.this.fDE != null && a.this.fDE.kE())) {
                        com.baidu.adp.lib.f.e.gy().removeCallbacks(a.this.gIz);
                        com.baidu.adp.lib.f.e.gy().post(a.this.gIz);
                    }
                    if (a.this.fDE != null) {
                        a.this.fDE.kN();
                    }
                }
            });
            this.goM.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bDH() {
                    if (a.this.goN != null && a.this.goN.gpn != null && com.baidu.adp.lib.f.b.toInt(a.this.goN.gpn.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.goN.gpn.videoWidth, 0)) {
                        a.this.goM.ah(false, false);
                    } else {
                        a.this.goM.ah(true, false);
                    }
                    a.this.goS = false;
                    a.this.AI(a.this.cRY ? "1" : "2");
                    a.this.onClick(a.this.goz);
                    if (a.this.Dg != null) {
                        a.this.Dg.a(a.this);
                    }
                    if (a.this.gIs != null) {
                        a.this.gIs.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bDI() {
                    a.this.onClick(a.this.goy);
                }
            });
            this.goM.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void lt(boolean z2) {
                    a.this.goM.dX(a.this.goN.gpn.videoUrl, a.this.goN.threadId);
                    a.this.AI("2");
                    a.this.onClick(a.this.goz);
                }
            });
            this.goM.rn(false);
            if (this.gIr != null) {
                this.gIr.reset();
            }
            this.startPosition = -1L;
            this.egK.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.goN.gpn.gpy;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.fDE.a(a.this.isFullScreen, a.this.goM != null && a.this.goM.cvu(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.fDE.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.goM.cvu() && !com.baidu.mcn.b.AS().ej(aVar2.Dx)) {
                        boolean z3 = a.this.startPosition >= (aVar2.gpq * 1000) + 1000;
                        if (i3 < aVar2.gpq * 1000 || i3 >= aVar2.gpr * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.gIr.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aGm = aVar2.gpt;
                                aVar3.aGn = aVar2.gpu;
                                aVar3.aGo = aVar2.Dx;
                                aVar3.aGl = aVar2.gps;
                                aVar3.fid = a.this.goN != null ? a.this.goN.forumId : null;
                                aVar3.tid = a.this.goN != null ? a.this.goN.threadId : null;
                                aVar3.aGp = 3;
                                if (z3) {
                                    a.this.gIr.b(aVar3, (ViewGroup) a.this.goM.cvN());
                                } else {
                                    a.this.gIr.a(aVar3, (ViewGroup) a.this.goM.cvN());
                                }
                            }
                        } else if (a.this.gIr.isShowing()) {
                            a.this.gIr.dismiss();
                        }
                    }
                }
            });
            this.goP = new y();
            this.goP.OC = gVar.threadId;
            this.goP.fGQ = gVar.forumId;
            this.goP.mUid = TbadkCoreApplication.getCurrentAccount();
            this.goP.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.goP.mSource = gVar.source;
            this.goP.jsi = gVar.weight;
            this.goP.jsk = this.mFrom;
            this.goP.mAbTag = gVar.abtest_tag;
            this.goP.cKC = this.cKC;
            this.goP.mExtra = gVar.extra;
            this.goP.jsn = "0";
            this.goQ = new y();
            this.goQ.OC = gVar.threadId;
            this.goQ.fGQ = gVar.forumId;
            this.goQ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.goQ.jsi = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.goQ.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.goQ.jsk = this.mFrom;
            this.goQ.mSource = gVar.source;
            this.goQ.jsn = "0";
            if (gVar.gpn != null) {
                this.goP.jsl = gVar.gpn.videoMd5;
                this.goQ.jsl = gVar.gpn.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cp("tid", gVar.threadId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.Z("obj_locate", i);
            anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cp("fid", gVar.forumId);
            anVar.cp("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cp("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cp("obj_id", this.cKC);
            anVar.cp(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.cp("obj_type", this.mFrom);
            anVar.Z("obj_param5", gVar.getVideoType());
            anVar.cp("obj_source", aq.isEmpty(this.goN.source) ? "0" : this.goN.source);
            anVar.Z("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.cp("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.cp("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.egK.setVideoStatsData(this.goP);
            this.goM.cvw().setBusiness(this.egK);
            this.egK.a(gVar);
            this.goM.bZU();
            this.goM.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.fDE.a(a.this.isFullScreen, a.this.goM != null && a.this.goM.cvu(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.goS = true;
                            a.this.gIh = true;
                            a.this.goR = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.sT(i);
                            a.this.goM.bNb();
                        }
                    }
                }
            });
            this.goM.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.goN != null && a.this.goN.gpn != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.goN.gpn.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.fDE.reset();
            }
            this.fDE.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void kV() {
                    a.this.gIh = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kU() {
                    if (a.this.isFullScreen) {
                        a.this.goS = true;
                        a.this.gIh = true;
                        a.this.goR = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.sT(i);
                        a.this.goM.bNb();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kT() {
                    if (a.this.goM != null) {
                        a.this.goM.zY(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean kW() {
                    return a.this.bIG();
                }
            });
            this.goM.setThumbnail(gVar.gpn.thumbnailUrl);
            this.goM.setVideoUrl(gVar.gpn.videoUrl, gVar.threadId);
            this.goM.setFid(gVar.forumId);
            this.goM.bNb();
            this.goM.show();
            lW(false);
            if (gVar.autoPlay) {
                onClick(this.goz);
                if (this.gIp.crv()) {
                    this.goM.rt(false);
                    this.gIp.cPU();
                    this.goM.ru(true);
                    this.goM.dW(gVar.gpn.videoUrl, gVar.threadId);
                    if (this.fDE.kE()) {
                        this.fDE.stop();
                        this.fDE.kJ();
                    }
                } else {
                    this.goM.ru(false);
                    this.goM.rt(false);
                    this.gIp.hide();
                    if (this.fDE == null || (this.fDE != null && !this.fDE.kE())) {
                        this.goM.a(gVar.gpn.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.gpo) {
                    this.gIk.setVisibility(8);
                    this.gIo.uj(3);
                } else {
                    if (this.gIk.getVisibility() == 0) {
                        this.gIk.startAnimation(this.aGA);
                    }
                    this.gIo.uj(0);
                }
                gVar.gpo = false;
            } else {
                this.gIk.setVisibility(0);
                this.gIp.hide();
                this.goM.rt(true);
                this.gIo.uj(3);
                this.goM.dW(gVar.gpn.videoUrl, gVar.threadId);
            }
            this.goS = false;
            this.gIh = false;
            if (!z && this.fDE.kE()) {
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
        com.baidu.afd.videopaster.data.b Br = this.gIq != null ? this.gIq.Br(gVar.getThreadId()) : null;
        if (Br == null) {
            return null;
        }
        int la = Br.la();
        int lb = Br.lb();
        int kZ = Br.kZ();
        if (kZ != -1) {
            i = la != -1 ? (kZ - la) - 1 : -1;
            if (lb != -1) {
                i4 = (lb - kZ) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.gpn != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.gpn.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.gpn.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", kZ + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AI(String str) {
        if (this.goN != null && this.goN.gpn != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.goN.gpn.videoMd5, "", str, this.goQ);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.goM.kO();
    }

    public boolean bIE() {
        return this.fDE.kE();
    }

    public void bDD() {
        if (isPlaying()) {
            this.goM.pausePlay();
        }
    }

    public boolean sU(int i) {
        if (i == 4 && this.fDE != null && ((this.fDE.kE() || this.gIh) && this.goM != null)) {
            this.fDE.au(i);
            if (this.isFullScreen) {
                if (this.fDE.kD()) {
                    this.goM.cvv();
                } else {
                    this.goM.xr();
                }
                return true;
            }
        }
        return this.goM.zY(i);
    }

    public void bDE() {
        this.gIj = false;
        this.goM.stopPlay();
        if (this.gId != null) {
            this.gId.setVisibility(0);
        }
        if (this.gIo != null) {
            this.gIo.uj(2);
        }
        lW(false);
        this.gIi = true;
        if (this.fDE != null && this.fDE.kE()) {
            this.fDE.stop();
        }
    }

    public void bIF() {
        this.fDE.stop();
    }

    public void bDF() {
        if (this.goM != null) {
            this.goM.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bDF();
        if (this.goO != null) {
            this.goO.bDP();
        }
        if (this.gIk != null) {
            this.gIk.clearAnimation();
        }
        this.fDE.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.gpm != null) {
            this.ME.setText(TextUtils.isEmpty(gVar.gpm.userNickname) ? gVar.gpm.userName : gVar.gpm.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.gpm != null) {
            if (gVar.gpm.gpx != null && !TextUtils.isEmpty(gVar.gpm.gpx.avatar)) {
                this.goF.startLoad(gVar.gpm.gpx.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.gpm.portrait) && gVar.gpm.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.goF.startLoad(gVar.gpm.portrait, 10, false);
            } else {
                this.goF.startLoad(gVar.gpm.portrait, 12, false);
            }
            if (gVar.gpm.gpx != null && gVar.gpm.gpx.auth_id.intValue() > 0) {
                this.goF.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.gpm.gpx.auth_id.intValue(), 1));
                this.goF.setShowV(true);
                this.goF.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.goF.setBjhAuthIconRes(0);
            if (gVar.gpm.isBigV) {
                this.goF.setShowV(gVar.gpm.isBigV);
                this.goF.setIsBigV(gVar.gpm.isBigV);
            } else if (gVar.gpm.isGod) {
                this.goF.setShowV(gVar.gpm.isGod);
                this.goF.setIsBigV(gVar.gpm.isGod);
            } else {
                this.goF.setShowV(gVar.gpm.isGod);
                this.goF.setIsBigV(gVar.gpm.isGod);
            }
            this.goF.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aBt() != null) {
                gVar.aBt().isInThread = true;
            }
            if (this.goN.mBaijiahao != null) {
                this.dcQ.setAgreeAlone(true);
            }
            this.dcQ.setIsFromMiddlePage(true);
            this.dcQ.setData(gVar.aBt());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dcR.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aDW().a(this.dcS, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dcR.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dcR.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dcU.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aDW().a(this.dcV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dcU.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dcU.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.goM != null && this.goz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.goR) {
                this.goM.cvC();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bIH();
            } else {
                configuration.orientation = 1;
                bII();
                this.goR = true;
            }
            this.goM.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIG() {
        if (this.goM != null && this.goz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.goz.getParent() != null) {
                if (this.goz.getParent() == frameLayout) {
                    if (this.gIt) {
                        this.gIt = false;
                        return true;
                    } else if (!this.gIu) {
                        this.gIu = true;
                        return true;
                    }
                } else if (this.goz.getParent() == this.goy) {
                    if (this.gIu) {
                        this.gIu = false;
                        this.gIv = true;
                        return true;
                    } else if (!this.gIt && this.gIv) {
                        this.gIt = true;
                        this.gIv = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIH() {
        if (this.goM != null && this.goz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.goz.getParent() != null) {
                if (this.goz.getParent() == frameLayout) {
                    frameLayout.removeView(this.goz);
                } else if (this.goz.getParent() == this.goy) {
                    this.goy.removeView(this.goz);
                }
            }
            if (this.goz.getParent() == null) {
                frameLayout.addView(this.goz);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.goz.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.goz.setLayoutParams(layoutParams);
                if (this.gIr != null && this.gIr.isShowing()) {
                    this.gIr.dismiss();
                }
                com.baidu.tbadk.util.d.aPf().gN(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bII() {
        if (this.goM != null && this.goz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.goz.getParent() != null) {
                if (this.goz.getParent() == frameLayout) {
                    bIJ();
                    frameLayout.removeView(this.goz);
                } else if (this.goz.getParent() == this.goy) {
                    bIJ();
                    this.goy.removeView(this.goz);
                }
            }
            if (this.goz.getParent() == null) {
                this.goy.addView(this.goz, 0);
                bIK();
                this.goM.bZU();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.aPf().gN(false);
            }
        }
    }

    private void bIJ() {
        if (this.fDE != null && this.fDE.kE()) {
            this.fDE.V(true);
        }
    }

    private void bIK() {
        int i;
        if (!bIC()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.goz.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (brY() != null) {
            view.setTag(this);
            brY().a(view, this.goN);
        }
        if (view == this.goF || view == this.ME) {
            if (this.goN != null && this.goN.gpm != null && !TextUtils.isEmpty(this.goN.gpm.userId)) {
                this.gIo.uj(0);
                if (!TbadkCoreApplication.isLogin() || !this.goN.gpm.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.goN.gpm.userId, 0L), z, this.goN.gpm.isGod)));
            }
        } else if (view == this.dcT) {
            if (this.goN != null) {
                this.gIo.uj(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.goN.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.goN.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gId || view == this.gIe) {
            if (this.goN != null) {
                if (this.gIo.getCurrentState() != 2 && this.gIo.getCurrentState() != 3) {
                    z = false;
                }
                this.gIo.uj(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.goN.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.goN.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dcW) {
            this.gIo.uj(0);
            aFs();
        } else if (view == this.gIk && this.gIk.getVisibility() == 0 && this.gIm != null) {
            this.gIm.un(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ls(boolean z) {
        if (this.goN != null && this.goN.gpm != null) {
            this.goN.gpm.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bDG() {
        if (this.goN != null) {
            this.dcQ.aEL();
        }
    }

    public void lV(boolean z) {
        if (this.goy != null) {
            this.goy.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.gIs = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.gIm = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Dg = fVar;
    }

    private void lW(boolean z) {
        this.gIi = this.mPosition == (this.gIn == null ? -1 : this.gIn.bIV());
        if (this.gIi && z && isPlaying() && this.cRY && !this.gIj) {
            this.gIf.setVisibility(0);
            this.gIj = true;
            this.gIf.postDelayed(this.gIy, 5000L);
            if (this.gIn != null) {
                this.gIn.dt(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.gIf.setVisibility(8);
        if (this.gIy != null) {
            this.gIf.removeCallbacks(this.gIy);
        }
    }

    private void aFs() {
        if (this.goN != null && this.mContext != null) {
            if (this.goN.mBaijiahao != null && !TbadkCoreApplication.isLogin()) {
                bc.skipToLoginActivity(getContext());
                return;
            }
            String valueOf = String.valueOf(this.goN.forumId);
            String str = this.goN.title;
            String str2 = this.goN.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.goN.gpn.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.goN.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = format;
            shareItem.dlC = str5;
            shareItem.linkUrl = str3;
            shareItem.extData = str2;
            shareItem.dlF = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str2;
            shareItem.dlt = true;
            shareItem.dlE = 0;
            shareItem.dlJ = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.goN.mBaijiahao != null) {
                shareItem.dlP = false;
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            originalThreadInfo.oriUgcInfo = this.goN.mBaijiahao;
            shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dlF);
            bundle.putInt("obj_type", shareItem.dlJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cQo);
            shareItem.Y(bundle);
            com.baidu.tieba.c.e.btE().a(new ShareDialogConfig(this.mContext, shareItem, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bDE();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bDD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX(boolean z) {
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

    public void bIL() {
        this.fDE.resume();
    }

    public boolean bIM() {
        if (this.gIo != null) {
            return this.gIo.getCurrentState() == 2 || this.gIo.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0502a {
        private Runnable gID;
        private int mCurrentState;

        private C0502a() {
            this.mCurrentState = -1;
            this.gID = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(C0502a.this.gID);
                    C0502a.this.uj(2);
                }
            };
        }

        public void uj(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uk(i);
                    bIN();
                    return;
                case 1:
                    this.mCurrentState = uk(i);
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gID);
                    return;
                case 2:
                    this.mCurrentState = ul(i);
                    return;
                case 3:
                    this.mCurrentState = um(i);
                    bIN();
                    return;
                default:
                    this.mCurrentState = ul(i);
                    return;
            }
        }

        private void bIN() {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gID);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.gID, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int uk(int i) {
            if (i != this.mCurrentState) {
                a.this.gIl.setVisibility(8);
                a.this.lX(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int ul(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.gIl.setVisibility(0);
                if (i2 != 3 || a.this.goN.autoPlay) {
                    a.this.lX(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int um(int i) {
            if (i != this.mCurrentState) {
                a.this.gIl.setVisibility(0);
                a.this.lX(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
