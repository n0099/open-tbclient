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
    private Animation aLy;
    private Animation aLz;
    private String cOS;
    private boolean cWm;
    protected AgreeView dht;
    private TextView dhu;
    private ImageView dhv;
    private View dhw;
    private TextView dhx;
    private ImageView dhy;
    private View dhz;
    private n elm;
    private com.baidu.afd.videopaster.d fJA;
    private int fYp;
    public ExpandableTextView gND;
    private View gNE;
    private FrameLayout gNF;
    private TextView gNG;
    private boolean gNH;
    private boolean gNI;
    private boolean gNJ;
    private View gNK;
    private View gNL;
    private c gNM;
    public com.baidu.tieba.frs.videomiddlepage.a.a gNN;
    private C0513a gNO;
    private VideoNetworkStateTipView gNP;
    private b gNQ;
    private com.baidu.mcn.c gNR;
    private com.baidu.tieba.lego.card.view.g gNS;
    private boolean gNT;
    private boolean gNU;
    private boolean gNV;
    private Animation.AnimationListener gNW;
    private Animation.AnimationListener gNX;
    private Runnable gNY;
    private Runnable gNZ;
    public FrameLayout gtW;
    public FrameLayout gtX;
    public HeadImageView gud;
    public com.baidu.tieba.play.c guk;
    public com.baidu.tieba.frs.aggregation.g gul;
    private com.baidu.tieba.frs.aggregation.h gum;
    private y gun;
    private y guo;
    private boolean gup;
    private boolean guq;
    private boolean gut;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.gup = true;
        this.gut = true;
        this.gNI = false;
        this.gNJ = false;
        this.gNT = false;
        this.gNU = false;
        this.gNV = false;
        this.startPosition = -1L;
        this.fYp = 0;
        this.gNW = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gNK != null) {
                    a.this.gNK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gNK != null) {
                    a.this.gNK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNX = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gNK != null) {
                    a.this.gNK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gNK != null) {
                    a.this.gNK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNY = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gNF.getVisibility() == 0) {
                    a.this.gNF.setVisibility(8);
                }
            }
        };
        this.gNZ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.guk != null) {
                    a.this.guk.stopPlay();
                }
            }
        };
        this.gut = z;
        this.mFrom = str;
        this.cOS = str2;
        this.gNQ = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gtW = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gNE = view.findViewById(R.id.card_container);
        this.gtX = (FrameLayout) view.findViewById(R.id.video_container);
        this.guk = new com.baidu.tieba.play.c(tbPageContext, this.gtX, false, com.baidu.tbadk.a.b.rH("cyber_player_test") ? 1 : 0);
        this.guk.rE(z);
        this.guk.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.gNN != null && a.this.gul.guL.videoDuration > 8) {
                    a.this.gNN.aF(a.this.mPosition, a.this.gul.guL.videoUrl);
                }
            }
        });
        this.guk.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void ml(boolean z2) {
                if (a.this.gNO != null) {
                    if (z2) {
                        a.this.gNO.uu(0);
                    } else {
                        a.this.gNO.uu(1);
                    }
                }
            }
        });
        this.guk.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.gND = (ExpandableTextView) view.findViewById(R.id.title);
        this.gud = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nl = (TextView) view.findViewById(R.id.user_name);
        this.dht = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cND = 2;
        dVar.cNI = 6;
        this.dht.setStatisticData(dVar);
        this.dhu = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dhv = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dhw = view.findViewById(R.id.thread_info_commont_container);
        this.dhx = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dhy = (ImageView) view.findViewById(R.id.share_num_img);
        this.dhz = view.findViewById(R.id.share_num_container);
        this.gNF = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.gNG = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.gNF.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gNG.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_link_url", null);
        this.gNG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGG().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.gNP = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.gNP.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.gNP.setHasAgreeToPlay(true);
                a.this.guk.rK(false);
                a.this.gNP.cSw();
                if (a.this.fJA.kU()) {
                    a.this.fJA.resume();
                } else if (a.this.gul != null && a.this.gul.guL != null) {
                    a.this.guk.ei(a.this.gul.guL.videoUrl, a.this.gul.threadId);
                }
            }
        });
        this.gNK = view.findViewById(R.id.video_agg_container_foreground);
        this.gNL = view.findViewById(R.id.title_and_comment_container_foreground);
        this.gNK.setOnClickListener(this);
        this.dhw.setOnClickListener(this);
        this.dhz.setOnClickListener(this);
        this.gND.setOnClickListener(this);
        this.gud.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.gNE.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.fYp = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtW.setLayoutParams(layoutParams);
        this.gud.setIsRound(true);
        this.gud.setPlaceHolder(1);
        this.elm = new n(tbPageContext.getPageActivity());
        this.gum = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.aLy = new AlphaAnimation(0.0f, 0.7f);
        this.aLy.setDuration(500L);
        this.aLy.setAnimationListener(this.gNX);
        this.aLz = new AlphaAnimation(0.7f, 0.0f);
        this.aLz.setDuration(500L);
        this.aLz.setAnimationListener(this.gNW);
        this.gNO = new C0513a();
        this.fJA = new com.baidu.afd.videopaster.d(getContext(), this.gtX);
        this.gNR = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dht.onChangeSkinType(i);
        this.dhu.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dhx.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aGC().a(this.dhv, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.dhy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.gND.onChangeSkinType();
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
        if (gVar != null && gVar.guL != null) {
            boolean z = this.gul == gVar;
            this.gul = gVar;
            this.cWm = this.gul.autoPlay;
            this.gNJ = false;
            mj(false);
            this.gND.setVisibility(0);
            this.gND.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.gND.setTextColor(R.color.cp_cont_a);
            this.gND.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.guL != null && !StringUtils.isNull(gVar.guL.mcnLeadPage)) {
                this.gND.setTextMaxLine(2);
                this.gND.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.gND.getContentView(), gVar.title, gVar.guL.mcnLeadPage, gVar.getThreadId());
            } else {
                this.gND.setTextMaxLine(Integer.MAX_VALUE);
                this.gND.setExpandable(true);
                this.gND.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mm(boolean z2) {
                        a.this.gul.isTitleExpanded = z2;
                    }
                });
                this.gND.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.fYp) {
                this.guk.cyt();
                this.fYp = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.gtX.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gtX.setLayoutParams(layoutParams);
            }
            bLj();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bLi() {
        try {
            int parseInt = Integer.parseInt(this.gul.guL.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.gul.guL.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bLj() {
        if (!bLi()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtW.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.gtW.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gtW.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.gtW.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.guL != null) {
            this.guk.stopPlay();
            this.guk.setIsNeedRecoveryVideoPlayer(true);
            this.guk.rL(true);
            this.guk.rH(true);
            this.guk.rM(true);
            this.guk.aj(false, false);
            this.guk.An(i);
            this.guk.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    a.this.bLn();
                    if (a.this.fJA != null) {
                        a.this.fJA.lc();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    a.this.bLo();
                    if (a.this.guk.le()) {
                    }
                    if (a.this.guq || (a.this.fJA != null && a.this.fJA.kU())) {
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(a.this.gNZ);
                        com.baidu.adp.lib.f.e.gx().post(a.this.gNZ);
                    }
                    if (a.this.fJA != null) {
                        a.this.fJA.ld();
                    }
                }
            });
            this.guk.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bGo() {
                    if (a.this.gul != null && a.this.gul.guL != null && com.baidu.adp.lib.f.b.toInt(a.this.gul.guL.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.gul.guL.videoWidth, 0)) {
                        a.this.guk.aj(false, false);
                    } else {
                        a.this.guk.aj(true, false);
                    }
                    a.this.guq = false;
                    a.this.Bj(a.this.cWm ? "1" : "2");
                    a.this.onClick(a.this.gtX);
                    if (a.this.DG != null) {
                        a.this.DG.a(a.this);
                    }
                    if (a.this.gNS != null) {
                        a.this.gNS.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGp() {
                    a.this.onClick(a.this.gtW);
                }
            });
            this.guk.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z2) {
                    a.this.guk.ei(a.this.gul.guL.videoUrl, a.this.gul.threadId);
                    a.this.Bj("2");
                    a.this.onClick(a.this.gtX);
                }
            });
            this.guk.rD(false);
            if (this.gNR != null) {
                this.gNR.reset();
            }
            this.startPosition = -1L;
            this.elm.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.gul.guL.guW;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.fJA.a(a.this.isFullScreen, a.this.guk != null && a.this.guk.cxZ(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.fJA.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.guk.cxZ() && !com.baidu.mcn.b.DG().eB(aVar2.DZ)) {
                        boolean z3 = a.this.startPosition >= (aVar2.guO * 1000) + 1000;
                        if (i3 < aVar2.guO * 1000 || i3 >= aVar2.guP * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.gNR.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aLl = aVar2.guR;
                                aVar3.aLm = aVar2.guS;
                                aVar3.aLn = aVar2.DZ;
                                aVar3.aLk = aVar2.guQ;
                                aVar3.fid = a.this.gul != null ? a.this.gul.forumId : null;
                                aVar3.tid = a.this.gul != null ? a.this.gul.threadId : null;
                                aVar3.aLo = 3;
                                if (z3) {
                                    a.this.gNR.b(aVar3, (ViewGroup) a.this.guk.cys());
                                } else {
                                    a.this.gNR.a(aVar3, (ViewGroup) a.this.guk.cys());
                                }
                            }
                        } else if (a.this.gNR.isShowing()) {
                            a.this.gNR.dismiss();
                        }
                    }
                }
            });
            this.gun = new y();
            this.gun.Pj = gVar.threadId;
            this.gun.emo = gVar.forumId;
            this.gun.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gun.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.gun.mSource = gVar.source;
            this.gun.jwS = gVar.weight;
            this.gun.jwU = this.mFrom;
            this.gun.mAbTag = gVar.abtest_tag;
            this.gun.cOS = this.cOS;
            this.gun.mExtra = gVar.extra;
            this.gun.jwY = "0";
            this.gun.jwV = gVar.getVideoType();
            this.guo = new y();
            this.guo.Pj = gVar.threadId;
            this.guo.emo = gVar.forumId;
            this.guo.mUid = TbadkCoreApplication.getCurrentAccount();
            this.guo.jwS = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.guo.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.guo.jwU = this.mFrom;
            this.guo.mSource = gVar.source;
            this.guo.jwY = "0";
            if (gVar.guL != null) {
                this.gun.jwW = gVar.guL.videoMd5;
                this.guo.jwW = gVar.guL.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cy("tid", gVar.threadId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", i);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cy("fid", gVar.forumId);
            anVar.cy("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cy("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cy("obj_id", this.cOS);
            anVar.cy(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.cy("obj_type", this.mFrom);
            anVar.X("obj_param5", gVar.getVideoType());
            anVar.cy("obj_source", aq.isEmpty(this.gul.source) ? "0" : this.gul.source);
            anVar.X("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.cy("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.cy("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.elm.setVideoStatsData(this.gun);
            this.guk.cyb().setBusiness(this.elm);
            this.elm.a(gVar);
            this.guk.ccH();
            this.guk.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.fJA.a(a.this.isFullScreen, a.this.guk != null && a.this.guk.cxZ(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.guq = true;
                            a.this.gNH = true;
                            a.this.gup = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.te(i);
                            a.this.guk.bPP();
                        }
                    }
                }
            });
            this.guk.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.gul != null && a.this.gul.guL != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.gul.guL.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.fJA.reset();
            }
            this.fJA.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void ll() {
                    a.this.gNH = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lk() {
                    if (a.this.isFullScreen) {
                        a.this.guq = true;
                        a.this.gNH = true;
                        a.this.gup = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.te(i);
                        a.this.guk.bPP();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lj() {
                    if (a.this.guk != null) {
                        a.this.guk.Am(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean lm() {
                    return a.this.bLm();
                }
            });
            this.guk.setThumbnail(gVar.guL.thumbnailUrl);
            this.guk.Al(gVar.guL.videoDuration);
            this.guk.setVideoUrl(gVar.guL.videoUrl, gVar.threadId);
            this.guk.setFid(gVar.forumId);
            this.guk.bPP();
            this.guk.show();
            mj(false);
            if (gVar.autoPlay) {
                onClick(this.gtX);
                if (this.gNP.cuc()) {
                    this.guk.rJ(false);
                    this.gNP.cSv();
                    this.guk.rK(true);
                    this.guk.eh(gVar.guL.videoUrl, gVar.threadId);
                    if (this.fJA.kU()) {
                        this.fJA.stop();
                        this.fJA.kZ();
                    }
                } else {
                    this.guk.rK(false);
                    this.guk.rJ(false);
                    this.gNP.hide();
                    if (this.fJA == null || (this.fJA != null && !this.fJA.kU())) {
                        this.guk.a(gVar.guL.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.guM) {
                    this.gNK.setVisibility(8);
                    this.gNO.uu(3);
                } else {
                    if (this.gNK.getVisibility() == 0) {
                        this.gNK.startAnimation(this.aLz);
                    }
                    this.gNO.uu(0);
                }
                gVar.guM = false;
            } else {
                this.gNK.setVisibility(0);
                this.gNP.hide();
                this.guk.rJ(true);
                this.gNO.uu(3);
                this.guk.eh(gVar.guL.videoUrl, gVar.threadId);
            }
            this.guq = false;
            this.gNH = false;
            if (!z && this.fJA.kU()) {
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
        com.baidu.afd.videopaster.data.b BS = this.gNQ != null ? this.gNQ.BS(gVar.getThreadId()) : null;
        if (BS == null) {
            return null;
        }
        int lq = BS.lq();
        int lr = BS.lr();
        int lp = BS.lp();
        if (lp != -1) {
            i = lq != -1 ? (lp - lq) - 1 : -1;
            if (lr != -1) {
                i4 = (lr - lp) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.guL != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.guL.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.guL.videoHeight, 0);
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
    public void Bj(String str) {
        if (this.gul != null && this.gul.guL != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gul.guL.videoMd5, "", str, this.guo);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.guk.le();
    }

    public boolean bLk() {
        return this.fJA.kU();
    }

    public void bGk() {
        if (isPlaying()) {
            this.guk.pausePlay();
        }
    }

    public boolean tf(int i) {
        if (i == 4 && this.fJA != null && ((this.fJA.kU() || this.gNH) && this.guk != null)) {
            this.fJA.ax(i);
            if (this.isFullScreen) {
                if (this.fJA.kT()) {
                    this.guk.cya();
                } else {
                    this.guk.Aa();
                }
                return true;
            }
        }
        return this.guk.Am(i);
    }

    public void bGl() {
        this.gNJ = false;
        this.guk.stopPlay();
        if (this.gND != null) {
            this.gND.setVisibility(0);
        }
        if (this.gNO != null) {
            this.gNO.uu(2);
        }
        mj(false);
        this.gNI = true;
        if (this.fJA != null && this.fJA.kU()) {
            this.fJA.stop();
        }
    }

    public void bLl() {
        this.fJA.stop();
    }

    public void bGm() {
        if (this.guk != null) {
            this.guk.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGm();
        if (this.gum != null) {
            this.gum.bGw();
        }
        if (this.gNK != null) {
            this.gNK.clearAnimation();
        }
        this.fJA.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.guK != null) {
            this.Nl.setText(TextUtils.isEmpty(gVar.guK.userNickname) ? gVar.guK.userName : gVar.guK.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.guK != null) {
            if (gVar.guK.guV != null && !TextUtils.isEmpty(gVar.guK.guV.avatar)) {
                this.gud.startLoad(gVar.guK.guV.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.guK.portrait) && gVar.guK.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.gud.startLoad(gVar.guK.portrait, 10, false);
            } else {
                this.gud.startLoad(gVar.guK.portrait, 12, false);
            }
            if (gVar.guK.guV != null && gVar.guK.guV.auth_id.intValue() > 0) {
                this.gud.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.guK.guV.auth_id.intValue(), 1));
                this.gud.setShowV(true);
                this.gud.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.gud.setBjhAuthIconRes(0);
            if (gVar.guK.isBigV) {
                this.gud.setShowV(gVar.guK.isBigV);
                this.gud.setIsBigV(gVar.guK.isBigV);
            } else if (gVar.guK.isGod) {
                this.gud.setShowV(gVar.guK.isGod);
                this.gud.setIsBigV(gVar.guK.isGod);
            } else {
                this.gud.setShowV(gVar.guK.isGod);
                this.gud.setIsBigV(gVar.guK.isGod);
            }
            this.gud.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aEa() != null) {
                gVar.aEa().isInThread = true;
            }
            if (this.gul.mBaijiahao != null) {
                this.dht.setAgreeAlone(true);
            }
            this.dht.setIsFromMiddlePage(true);
            this.dht.setData(gVar.aEa());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhu.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGC().a(this.dhv, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dhu.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dhu.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhx.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGC().a(this.dhy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dhx.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dhx.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.guk != null && this.gtX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gup) {
                this.guk.cyh();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bLn();
            } else {
                configuration.orientation = 1;
                bLo();
                this.gup = true;
            }
            this.guk.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLm() {
        if (this.guk != null && this.gtX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gtX.getParent() != null) {
                if (this.gtX.getParent() == frameLayout) {
                    if (this.gNT) {
                        this.gNT = false;
                        return true;
                    } else if (!this.gNU) {
                        this.gNU = true;
                        return true;
                    }
                } else if (this.gtX.getParent() == this.gtW) {
                    if (this.gNU) {
                        this.gNU = false;
                        this.gNV = true;
                        return true;
                    } else if (!this.gNT && this.gNV) {
                        this.gNT = true;
                        this.gNV = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLn() {
        if (this.guk != null && this.gtX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.gtX.getParent() != null) {
                if (this.gtX.getParent() == frameLayout) {
                    frameLayout.removeView(this.gtX);
                } else if (this.gtX.getParent() == this.gtW) {
                    this.gtW.removeView(this.gtX);
                }
            }
            if (this.gtX.getParent() == null) {
                frameLayout.addView(this.gtX);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gtX.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gtX.setLayoutParams(layoutParams);
                if (this.gNR != null && this.gNR.isShowing()) {
                    this.gNR.dismiss();
                }
                com.baidu.tbadk.util.d.aRS().gZ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLo() {
        if (this.guk != null && this.gtX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.gtX.getParent() != null) {
                if (this.gtX.getParent() == frameLayout) {
                    bLp();
                    frameLayout.removeView(this.gtX);
                } else if (this.gtX.getParent() == this.gtW) {
                    bLp();
                    this.gtW.removeView(this.gtX);
                }
            }
            if (this.gtX.getParent() == null) {
                this.gtW.addView(this.gtX, 0);
                bLq();
                this.guk.ccH();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.aRS().gZ(false);
            }
        }
    }

    private void bLp() {
        if (this.fJA != null && this.fJA.kU()) {
            this.fJA.Y(true);
        }
    }

    private void bLq() {
        int i;
        if (!bLi()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.gtX.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (buH() != null) {
            view.setTag(this);
            buH().a(view, this.gul);
        }
        if (view == this.gud || view == this.Nl) {
            if (this.gul != null && this.gul.guK != null && !TextUtils.isEmpty(this.gul.guK.userId)) {
                this.gNO.uu(0);
                if (!TbadkCoreApplication.isLogin() || !this.gul.guK.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gul.guK.userId, 0L), z, this.gul.guK.isGod)));
            }
        } else if (view == this.dhw) {
            if (this.gul != null) {
                this.gNO.uu(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.gul.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.gul.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gND || view == this.gNE) {
            if (this.gul != null) {
                if (this.gNO.getCurrentState() != 2 && this.gNO.getCurrentState() != 3) {
                    z = false;
                }
                this.gNO.uu(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.gul.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.gul.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dhz) {
            this.gNO.uu(0);
            aId();
        } else if (view == this.gNK && this.gNK.getVisibility() == 0 && this.gNM != null) {
            this.gNM.uy(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lG(boolean z) {
        if (this.gul != null && this.gul.guK != null) {
            this.gul.guK.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGn() {
        if (this.gul != null) {
            this.dht.aHt();
        }
    }

    public void mi(boolean z) {
        if (this.gtW != null) {
            this.gtW.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.gNS = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.gNM = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.DG = fVar;
    }

    private void mj(boolean z) {
        this.gNI = this.mPosition == (this.gNN == null ? -1 : this.gNN.bLC());
        if (this.gNI && z && isPlaying() && this.cWm && !this.gNJ) {
            this.gNF.setVisibility(0);
            this.gNJ = true;
            this.gNF.postDelayed(this.gNY, 5000L);
            if (this.gNN != null) {
                this.gNN.dy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.gNF.setVisibility(8);
        if (this.gNY != null) {
            this.gNF.removeCallbacks(this.gNY);
        }
    }

    private void aId() {
        String str;
        String str2;
        if (this.gul != null && this.mContext != null) {
            String valueOf = String.valueOf(this.gul.forumId);
            String str3 = this.gul.title;
            if (this.gul.mBaijiahao != null) {
                str = this.gul.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.gul.mBaijiahao.oriUgcType + "&dvid=" + this.gul.mBaijiahao.oriUgcVid + "&nid=" + this.gul.mBaijiahao.oriUgcNid;
            } else {
                str = this.gul.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.gul.guL.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.gul.title;
            String format = (this.gul.mBaijiahao == null || this.gul.guK == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.gul.guK.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.gul.mBaijiahao != null) {
                shareItem.dqp = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.dqp = str6;
                shareItem.readCount = this.gul.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.dqs = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.dqf = true;
            shareItem.dqr = 11;
            shareItem.dqw = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.gul.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.gul.mBaijiahao;
            shareItem.dqz = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cy("tid", str);
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.X("obj_locate", 12);
            TiebaStatic.log(anVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqs);
            bundle.putInt("obj_type", shareItem.dqw);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUC);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.bwn().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bGl();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bGk();
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

    public void bLr() {
        this.fJA.resume();
    }

    public boolean bLs() {
        if (this.gNO != null) {
            return this.gNO.getCurrentState() == 2 || this.gNO.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0513a {
        private Runnable gOd;
        private int mCurrentState;

        private C0513a() {
            this.mCurrentState = -1;
            this.gOd = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(C0513a.this.gOd);
                    C0513a.this.uu(2);
                }
            };
        }

        public void uu(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uv(i);
                    bLt();
                    return;
                case 1:
                    this.mCurrentState = uv(i);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gOd);
                    return;
                case 2:
                    this.mCurrentState = uw(i);
                    return;
                case 3:
                    this.mCurrentState = ux(i);
                    bLt();
                    return;
                default:
                    this.mCurrentState = uw(i);
                    return;
            }
        }

        private void bLt() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gOd);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gOd, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int uv(int i) {
            if (i != this.mCurrentState) {
                a.this.gNL.setVisibility(8);
                a.this.mk(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uw(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.gNL.setVisibility(0);
                if (i2 != 3 || a.this.gul.autoPlay) {
                    a.this.mk(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ux(int i) {
            if (i != this.mCurrentState) {
                a.this.gNL.setVisibility(0);
                a.this.mk(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
