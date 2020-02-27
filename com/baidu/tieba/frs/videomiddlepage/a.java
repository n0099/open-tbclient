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
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f DG;
    public TextView Nl;
    private Animation aLw;
    private Animation aLx;
    private String cOQ;
    private boolean cWk;
    protected AgreeView dhf;
    private TextView dhg;
    private ImageView dhh;
    private View dhi;
    private TextView dhj;
    private ImageView dhk;
    private View dhl;
    private n ekY;
    private com.baidu.afd.videopaster.d fJl;
    private int fYa;
    private C0513a gNA;
    private VideoNetworkStateTipView gNB;
    private b gNC;
    private com.baidu.mcn.c gND;
    private com.baidu.tieba.lego.card.view.g gNE;
    private boolean gNF;
    private boolean gNG;
    private boolean gNH;
    private Animation.AnimationListener gNI;
    private Animation.AnimationListener gNJ;
    private Runnable gNK;
    private Runnable gNL;
    public ExpandableTextView gNp;
    private View gNq;
    private FrameLayout gNr;
    private TextView gNs;
    private boolean gNt;
    private boolean gNu;
    private boolean gNv;
    private View gNw;
    private View gNx;
    private c gNy;
    public com.baidu.tieba.frs.videomiddlepage.a.a gNz;
    public FrameLayout gtI;
    public FrameLayout gtJ;
    public HeadImageView gtP;
    public com.baidu.tieba.play.c gtW;
    public com.baidu.tieba.frs.aggregation.g gtX;
    private com.baidu.tieba.frs.aggregation.h gtY;
    private y gtZ;
    private y gua;
    private boolean gub;
    private boolean guc;
    private boolean guf;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.gub = true;
        this.guf = true;
        this.gNu = false;
        this.gNv = false;
        this.gNF = false;
        this.gNG = false;
        this.gNH = false;
        this.startPosition = -1L;
        this.fYa = 0;
        this.gNI = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gNw != null) {
                    a.this.gNw.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gNw != null) {
                    a.this.gNw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gNw != null) {
                    a.this.gNw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gNw != null) {
                    a.this.gNw.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNK = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gNr.getVisibility() == 0) {
                    a.this.gNr.setVisibility(8);
                }
            }
        };
        this.gNL = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gtW != null) {
                    a.this.gtW.stopPlay();
                }
            }
        };
        this.guf = z;
        this.mFrom = str;
        this.cOQ = str2;
        this.gNC = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gtI = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gNq = view.findViewById(R.id.card_container);
        this.gtJ = (FrameLayout) view.findViewById(R.id.video_container);
        this.gtW = new com.baidu.tieba.play.c(tbPageContext, this.gtJ, false, com.baidu.tbadk.a.b.rH("cyber_player_test") ? 1 : 0);
        this.gtW.rE(z);
        this.gtW.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.gNz != null && a.this.gtX.gux.videoDuration > 8) {
                    a.this.gNz.aF(a.this.mPosition, a.this.gtX.gux.videoUrl);
                }
            }
        });
        this.gtW.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void ml(boolean z2) {
                if (a.this.gNA != null) {
                    if (z2) {
                        a.this.gNA.uu(0);
                    } else {
                        a.this.gNA.uu(1);
                    }
                }
            }
        });
        this.gtW.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.gNp = (ExpandableTextView) view.findViewById(R.id.title);
        this.gtP = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nl = (TextView) view.findViewById(R.id.user_name);
        this.dhf = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 2;
        dVar.cNG = 6;
        this.dhf.setStatisticData(dVar);
        this.dhg = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dhh = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dhi = view.findViewById(R.id.thread_info_commont_container);
        this.dhj = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dhk = (ImageView) view.findViewById(R.id.share_num_img);
        this.dhl = view.findViewById(R.id.share_num_container);
        this.gNr = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.gNs = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.gNr.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gNs.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_download_link_url", null);
        this.gNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGE().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.gNB = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.gNB.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.gNB.setHasAgreeToPlay(true);
                a.this.gtW.rK(false);
                a.this.gNB.cSt();
                if (a.this.fJl.kU()) {
                    a.this.fJl.resume();
                } else if (a.this.gtX != null && a.this.gtX.gux != null) {
                    a.this.gtW.ei(a.this.gtX.gux.videoUrl, a.this.gtX.threadId);
                }
            }
        });
        this.gNw = view.findViewById(R.id.video_agg_container_foreground);
        this.gNx = view.findViewById(R.id.title_and_comment_container_foreground);
        this.gNw.setOnClickListener(this);
        this.dhi.setOnClickListener(this);
        this.dhl.setOnClickListener(this);
        this.gNp.setOnClickListener(this);
        this.gtP.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.gNq.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.fYa = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtI.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtI.setLayoutParams(layoutParams);
        this.gtP.setIsRound(true);
        this.gtP.setPlaceHolder(1);
        this.ekY = new n(tbPageContext.getPageActivity());
        this.gtY = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.aLw = new AlphaAnimation(0.0f, 0.7f);
        this.aLw.setDuration(500L);
        this.aLw.setAnimationListener(this.gNJ);
        this.aLx = new AlphaAnimation(0.7f, 0.0f);
        this.aLx.setDuration(500L);
        this.aLx.setAnimationListener(this.gNI);
        this.gNA = new C0513a();
        this.fJl = new com.baidu.afd.videopaster.d(getContext(), this.gtJ);
        this.gND = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dhf.onChangeSkinType(i);
        this.dhg.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dhj.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aGA().a(this.dhh, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.dhk, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.gNp.onChangeSkinType();
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
        if (gVar != null && gVar.gux != null) {
            boolean z = this.gtX == gVar;
            this.gtX = gVar;
            this.cWk = this.gtX.autoPlay;
            this.gNv = false;
            mj(false);
            this.gNp.setVisibility(0);
            this.gNp.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.gNp.setTextColor(R.color.cp_cont_a);
            this.gNp.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.gux != null && !StringUtils.isNull(gVar.gux.mcnLeadPage)) {
                this.gNp.setTextMaxLine(2);
                this.gNp.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.gNp.getContentView(), gVar.title, gVar.gux.mcnLeadPage, gVar.getThreadId());
            } else {
                this.gNp.setTextMaxLine(Integer.MAX_VALUE);
                this.gNp.setExpandable(true);
                this.gNp.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mm(boolean z2) {
                        a.this.gtX.isTitleExpanded = z2;
                    }
                });
                this.gNp.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.fYa) {
                this.gtW.cyq();
                this.fYa = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.gtJ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gtJ.setLayoutParams(layoutParams);
            }
            bLg();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bLf() {
        try {
            int parseInt = Integer.parseInt(this.gtX.gux.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.gtX.gux.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bLg() {
        if (!bLf()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtI.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.gtI.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gtI.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.gtI.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.gux != null) {
            this.gtW.stopPlay();
            this.gtW.setIsNeedRecoveryVideoPlayer(true);
            this.gtW.rL(true);
            this.gtW.rH(true);
            this.gtW.rM(true);
            this.gtW.aj(false, false);
            this.gtW.An(i);
            this.gtW.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    a.this.bLk();
                    if (a.this.fJl != null) {
                        a.this.fJl.lc();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    a.this.bLl();
                    if (a.this.gtW.le()) {
                    }
                    if (a.this.guc || (a.this.fJl != null && a.this.fJl.kU())) {
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(a.this.gNL);
                        com.baidu.adp.lib.f.e.gx().post(a.this.gNL);
                    }
                    if (a.this.fJl != null) {
                        a.this.fJl.ld();
                    }
                }
            });
            this.gtW.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bGl() {
                    if (a.this.gtX != null && a.this.gtX.gux != null && com.baidu.adp.lib.f.b.toInt(a.this.gtX.gux.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.gtX.gux.videoWidth, 0)) {
                        a.this.gtW.aj(false, false);
                    } else {
                        a.this.gtW.aj(true, false);
                    }
                    a.this.guc = false;
                    a.this.Bi(a.this.cWk ? "1" : "2");
                    a.this.onClick(a.this.gtJ);
                    if (a.this.DG != null) {
                        a.this.DG.a(a.this);
                    }
                    if (a.this.gNE != null) {
                        a.this.gNE.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGm() {
                    a.this.onClick(a.this.gtI);
                }
            });
            this.gtW.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z2) {
                    a.this.gtW.ei(a.this.gtX.gux.videoUrl, a.this.gtX.threadId);
                    a.this.Bi("2");
                    a.this.onClick(a.this.gtJ);
                }
            });
            this.gtW.rD(false);
            if (this.gND != null) {
                this.gND.reset();
            }
            this.startPosition = -1L;
            this.ekY.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.gtX.gux.guI;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.fJl.a(a.this.isFullScreen, a.this.gtW != null && a.this.gtW.cxW(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.fJl.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.gtW.cxW() && !com.baidu.mcn.b.DE().eB(aVar2.DZ)) {
                        boolean z3 = a.this.startPosition >= (aVar2.guA * 1000) + 1000;
                        if (i3 < aVar2.guA * 1000 || i3 >= aVar2.guB * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.gND.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aLj = aVar2.guD;
                                aVar3.aLk = aVar2.guE;
                                aVar3.aLl = aVar2.DZ;
                                aVar3.aLi = aVar2.guC;
                                aVar3.fid = a.this.gtX != null ? a.this.gtX.forumId : null;
                                aVar3.tid = a.this.gtX != null ? a.this.gtX.threadId : null;
                                aVar3.aLm = 3;
                                if (z3) {
                                    a.this.gND.b(aVar3, (ViewGroup) a.this.gtW.cyp());
                                } else {
                                    a.this.gND.a(aVar3, (ViewGroup) a.this.gtW.cyp());
                                }
                            }
                        } else if (a.this.gND.isShowing()) {
                            a.this.gND.dismiss();
                        }
                    }
                }
            });
            this.gtZ = new y();
            this.gtZ.Pj = gVar.threadId;
            this.gtZ.ema = gVar.forumId;
            this.gtZ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gtZ.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.gtZ.mSource = gVar.source;
            this.gtZ.jwE = gVar.weight;
            this.gtZ.jwG = this.mFrom;
            this.gtZ.mAbTag = gVar.abtest_tag;
            this.gtZ.cOQ = this.cOQ;
            this.gtZ.mExtra = gVar.extra;
            this.gtZ.jwK = "0";
            this.gtZ.jwH = gVar.getVideoType();
            this.gua = new y();
            this.gua.Pj = gVar.threadId;
            this.gua.ema = gVar.forumId;
            this.gua.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gua.jwE = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.gua.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.gua.jwG = this.mFrom;
            this.gua.mSource = gVar.source;
            this.gua.jwK = "0";
            if (gVar.gux != null) {
                this.gtZ.jwI = gVar.gux.videoMd5;
                this.gua.jwI = gVar.gux.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cy("tid", gVar.threadId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", i);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cy("fid", gVar.forumId);
            anVar.cy("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cy("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cy("obj_id", this.cOQ);
            anVar.cy(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.cy("obj_type", this.mFrom);
            anVar.X("obj_param5", gVar.getVideoType());
            anVar.cy("obj_source", aq.isEmpty(this.gtX.source) ? "0" : this.gtX.source);
            anVar.X("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.cy("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.cy("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.ekY.setVideoStatsData(this.gtZ);
            this.gtW.cxY().setBusiness(this.ekY);
            this.ekY.a(gVar);
            this.gtW.ccE();
            this.gtW.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.fJl.a(a.this.isFullScreen, a.this.gtW != null && a.this.gtW.cxW(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.guc = true;
                            a.this.gNt = true;
                            a.this.gub = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.te(i);
                            a.this.gtW.bPM();
                        }
                    }
                }
            });
            this.gtW.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.gtX != null && a.this.gtX.gux != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.gtX.gux.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.fJl.reset();
            }
            this.fJl.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void ll() {
                    a.this.gNt = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lk() {
                    if (a.this.isFullScreen) {
                        a.this.guc = true;
                        a.this.gNt = true;
                        a.this.gub = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.te(i);
                        a.this.gtW.bPM();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lj() {
                    if (a.this.gtW != null) {
                        a.this.gtW.Am(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean lm() {
                    return a.this.bLj();
                }
            });
            this.gtW.setThumbnail(gVar.gux.thumbnailUrl);
            this.gtW.Al(gVar.gux.videoDuration);
            this.gtW.setVideoUrl(gVar.gux.videoUrl, gVar.threadId);
            this.gtW.setFid(gVar.forumId);
            this.gtW.bPM();
            this.gtW.show();
            mj(false);
            if (gVar.autoPlay) {
                onClick(this.gtJ);
                if (this.gNB.ctZ()) {
                    this.gtW.rJ(false);
                    this.gNB.cSs();
                    this.gtW.rK(true);
                    this.gtW.eh(gVar.gux.videoUrl, gVar.threadId);
                    if (this.fJl.kU()) {
                        this.fJl.stop();
                        this.fJl.kZ();
                    }
                } else {
                    this.gtW.rK(false);
                    this.gtW.rJ(false);
                    this.gNB.hide();
                    if (this.fJl == null || (this.fJl != null && !this.fJl.kU())) {
                        this.gtW.a(gVar.gux.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.guy) {
                    this.gNw.setVisibility(8);
                    this.gNA.uu(3);
                } else {
                    if (this.gNw.getVisibility() == 0) {
                        this.gNw.startAnimation(this.aLx);
                    }
                    this.gNA.uu(0);
                }
                gVar.guy = false;
            } else {
                this.gNw.setVisibility(0);
                this.gNB.hide();
                this.gtW.rJ(true);
                this.gNA.uu(3);
                this.gtW.eh(gVar.gux.videoUrl, gVar.threadId);
            }
            this.guc = false;
            this.gNt = false;
            if (!z && this.fJl.kU()) {
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
        com.baidu.afd.videopaster.data.b BR = this.gNC != null ? this.gNC.BR(gVar.getThreadId()) : null;
        if (BR == null) {
            return null;
        }
        int lq = BR.lq();
        int lr = BR.lr();
        int lp = BR.lp();
        if (lp != -1) {
            i = lq != -1 ? (lp - lq) - 1 : -1;
            if (lr != -1) {
                i4 = (lr - lp) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.gux != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.gux.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.gux.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", lp + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(String str) {
        if (this.gtX != null && this.gtX.gux != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gtX.gux.videoMd5, "", str, this.gua);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.gtW.le();
    }

    public boolean bLh() {
        return this.fJl.kU();
    }

    public void bGh() {
        if (isPlaying()) {
            this.gtW.pausePlay();
        }
    }

    public boolean tf(int i) {
        if (i == 4 && this.fJl != null && ((this.fJl.kU() || this.gNt) && this.gtW != null)) {
            this.fJl.ax(i);
            if (this.isFullScreen) {
                if (this.fJl.kT()) {
                    this.gtW.cxX();
                } else {
                    this.gtW.zY();
                }
                return true;
            }
        }
        return this.gtW.Am(i);
    }

    public void bGi() {
        this.gNv = false;
        this.gtW.stopPlay();
        if (this.gNp != null) {
            this.gNp.setVisibility(0);
        }
        if (this.gNA != null) {
            this.gNA.uu(2);
        }
        mj(false);
        this.gNu = true;
        if (this.fJl != null && this.fJl.kU()) {
            this.fJl.stop();
        }
    }

    public void bLi() {
        this.fJl.stop();
    }

    public void bGj() {
        if (this.gtW != null) {
            this.gtW.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGj();
        if (this.gtY != null) {
            this.gtY.bGt();
        }
        if (this.gNw != null) {
            this.gNw.clearAnimation();
        }
        this.fJl.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.guw != null) {
            this.Nl.setText(TextUtils.isEmpty(gVar.guw.userNickname) ? gVar.guw.userName : gVar.guw.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.guw != null) {
            if (gVar.guw.guH != null && !TextUtils.isEmpty(gVar.guw.guH.avatar)) {
                this.gtP.startLoad(gVar.guw.guH.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.guw.portrait) && gVar.guw.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.gtP.startLoad(gVar.guw.portrait, 10, false);
            } else {
                this.gtP.startLoad(gVar.guw.portrait, 12, false);
            }
            if (gVar.guw.guH != null && gVar.guw.guH.auth_id.intValue() > 0) {
                this.gtP.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.guw.guH.auth_id.intValue(), 1));
                this.gtP.setShowV(true);
                this.gtP.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.gtP.setBjhAuthIconRes(0);
            if (gVar.guw.isBigV) {
                this.gtP.setShowV(gVar.guw.isBigV);
                this.gtP.setIsBigV(gVar.guw.isBigV);
            } else if (gVar.guw.isGod) {
                this.gtP.setShowV(gVar.guw.isGod);
                this.gtP.setIsBigV(gVar.guw.isGod);
            } else {
                this.gtP.setShowV(gVar.guw.isGod);
                this.gtP.setIsBigV(gVar.guw.isGod);
            }
            this.gtP.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aDY() != null) {
                gVar.aDY().isInThread = true;
            }
            if (this.gtX.mBaijiahao != null) {
                this.dhf.setAgreeAlone(true);
            }
            this.dhf.setIsFromMiddlePage(true);
            this.dhf.setData(gVar.aDY());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhg.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGA().a(this.dhh, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dhg.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dhg.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhj.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGA().a(this.dhk, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dhj.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dhj.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gtW != null && this.gtJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gub) {
                this.gtW.cye();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bLk();
            } else {
                configuration.orientation = 1;
                bLl();
                this.gub = true;
            }
            this.gtW.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLj() {
        if (this.gtW != null && this.gtJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gtJ.getParent() != null) {
                if (this.gtJ.getParent() == frameLayout) {
                    if (this.gNF) {
                        this.gNF = false;
                        return true;
                    } else if (!this.gNG) {
                        this.gNG = true;
                        return true;
                    }
                } else if (this.gtJ.getParent() == this.gtI) {
                    if (this.gNG) {
                        this.gNG = false;
                        this.gNH = true;
                        return true;
                    } else if (!this.gNF && this.gNH) {
                        this.gNF = true;
                        this.gNH = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLk() {
        if (this.gtW != null && this.gtJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.gtJ.getParent() != null) {
                if (this.gtJ.getParent() == frameLayout) {
                    frameLayout.removeView(this.gtJ);
                } else if (this.gtJ.getParent() == this.gtI) {
                    this.gtI.removeView(this.gtJ);
                }
            }
            if (this.gtJ.getParent() == null) {
                frameLayout.addView(this.gtJ);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gtJ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gtJ.setLayoutParams(layoutParams);
                if (this.gND != null && this.gND.isShowing()) {
                    this.gND.dismiss();
                }
                com.baidu.tbadk.util.d.aRP().gZ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLl() {
        if (this.gtW != null && this.gtJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.gtJ.getParent() != null) {
                if (this.gtJ.getParent() == frameLayout) {
                    bLm();
                    frameLayout.removeView(this.gtJ);
                } else if (this.gtJ.getParent() == this.gtI) {
                    bLm();
                    this.gtI.removeView(this.gtJ);
                }
            }
            if (this.gtJ.getParent() == null) {
                this.gtI.addView(this.gtJ, 0);
                bLn();
                this.gtW.ccE();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.aRP().gZ(false);
            }
        }
    }

    private void bLm() {
        if (this.fJl != null && this.fJl.kU()) {
            this.fJl.Y(true);
        }
    }

    private void bLn() {
        int i;
        if (!bLf()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.gtJ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (buE() != null) {
            view.setTag(this);
            buE().a(view, this.gtX);
        }
        if (view == this.gtP || view == this.Nl) {
            if (this.gtX != null && this.gtX.guw != null && !TextUtils.isEmpty(this.gtX.guw.userId)) {
                this.gNA.uu(0);
                if (!TbadkCoreApplication.isLogin() || !this.gtX.guw.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gtX.guw.userId, 0L), z, this.gtX.guw.isGod)));
            }
        } else if (view == this.dhi) {
            if (this.gtX != null) {
                this.gNA.uu(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.gtX.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.gtX.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gNp || view == this.gNq) {
            if (this.gtX != null) {
                if (this.gNA.getCurrentState() != 2 && this.gNA.getCurrentState() != 3) {
                    z = false;
                }
                this.gNA.uu(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.gtX.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.gtX.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dhl) {
            this.gNA.uu(0);
            aIa();
        } else if (view == this.gNw && this.gNw.getVisibility() == 0 && this.gNy != null) {
            this.gNy.uy(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lG(boolean z) {
        if (this.gtX != null && this.gtX.guw != null) {
            this.gtX.guw.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGk() {
        if (this.gtX != null) {
            this.dhf.aHq();
        }
    }

    public void mi(boolean z) {
        if (this.gtI != null) {
            this.gtI.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.gNE = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.gNy = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.DG = fVar;
    }

    private void mj(boolean z) {
        this.gNu = this.mPosition == (this.gNz == null ? -1 : this.gNz.bLz());
        if (this.gNu && z && isPlaying() && this.cWk && !this.gNv) {
            this.gNr.setVisibility(0);
            this.gNv = true;
            this.gNr.postDelayed(this.gNK, 5000L);
            if (this.gNz != null) {
                this.gNz.dy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.gNr.setVisibility(8);
        if (this.gNK != null) {
            this.gNr.removeCallbacks(this.gNK);
        }
    }

    private void aIa() {
        String str;
        String str2;
        if (this.gtX != null && this.mContext != null) {
            String valueOf = String.valueOf(this.gtX.forumId);
            String str3 = this.gtX.title;
            if (this.gtX.mBaijiahao != null) {
                str = this.gtX.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.gtX.mBaijiahao.oriUgcType + "&dvid=" + this.gtX.mBaijiahao.oriUgcVid + "&nid=" + this.gtX.mBaijiahao.oriUgcNid;
            } else {
                str = this.gtX.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.gtX.gux.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.gtX.title;
            String format = (this.gtX.mBaijiahao == null || this.gtX.guw == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.gtX.guw.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.gtX.mBaijiahao != null) {
                shareItem.dqb = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.dqb = str6;
                shareItem.readCount = this.gtX.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.dqe = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.dpR = true;
            shareItem.dqd = 11;
            shareItem.dqi = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.gtX.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.gtX.mBaijiahao;
            shareItem.dql = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cy("tid", str);
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.X("obj_locate", 12);
            TiebaStatic.log(anVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqe);
            bundle.putInt("obj_type", shareItem.dqi);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUA);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.bwk().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bGi();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bGh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk(boolean z) {
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

    public void bLo() {
        this.fJl.resume();
    }

    public boolean bLp() {
        if (this.gNA != null) {
            return this.gNA.getCurrentState() == 2 || this.gNA.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0513a {
        private Runnable gNP;
        private int mCurrentState;

        private C0513a() {
            this.mCurrentState = -1;
            this.gNP = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(C0513a.this.gNP);
                    C0513a.this.uu(2);
                }
            };
        }

        public void uu(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uv(i);
                    bLq();
                    return;
                case 1:
                    this.mCurrentState = uv(i);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNP);
                    return;
                case 2:
                    this.mCurrentState = uw(i);
                    return;
                case 3:
                    this.mCurrentState = ux(i);
                    bLq();
                    return;
                default:
                    this.mCurrentState = uw(i);
                    return;
            }
        }

        private void bLq() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNP);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gNP, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int uv(int i) {
            if (i != this.mCurrentState) {
                a.this.gNx.setVisibility(8);
                a.this.mk(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uw(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.gNx.setVisibility(0);
                if (i2 != 3 || a.this.gtX.autoPlay) {
                    a.this.mk(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ux(int i) {
            if (i != this.mCurrentState) {
                a.this.gNx.setVisibility(0);
                a.this.mk(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
