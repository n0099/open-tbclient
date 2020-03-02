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
    private Animation aLx;
    private Animation aLy;
    private String cOR;
    private boolean cWl;
    protected AgreeView dhg;
    private TextView dhh;
    private ImageView dhi;
    private View dhj;
    private TextView dhk;
    private ImageView dhl;
    private View dhm;
    private n ekZ;
    private com.baidu.afd.videopaster.d fJn;
    private int fYc;
    private c gNA;
    public com.baidu.tieba.frs.videomiddlepage.a.a gNB;
    private C0513a gNC;
    private VideoNetworkStateTipView gND;
    private b gNE;
    private com.baidu.mcn.c gNF;
    private com.baidu.tieba.lego.card.view.g gNG;
    private boolean gNH;
    private boolean gNI;
    private boolean gNJ;
    private Animation.AnimationListener gNK;
    private Animation.AnimationListener gNL;
    private Runnable gNM;
    private Runnable gNN;
    public ExpandableTextView gNr;
    private View gNs;
    private FrameLayout gNt;
    private TextView gNu;
    private boolean gNv;
    private boolean gNw;
    private boolean gNx;
    private View gNy;
    private View gNz;
    public FrameLayout gtK;
    public FrameLayout gtL;
    public HeadImageView gtR;
    public com.baidu.tieba.play.c gtY;
    public com.baidu.tieba.frs.aggregation.g gtZ;
    private com.baidu.tieba.frs.aggregation.h gua;
    private y gub;
    private y guc;
    private boolean gud;
    private boolean gue;
    private boolean guh;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.gud = true;
        this.guh = true;
        this.gNw = false;
        this.gNx = false;
        this.gNH = false;
        this.gNI = false;
        this.gNJ = false;
        this.startPosition = -1L;
        this.fYc = 0;
        this.gNK = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gNy != null) {
                    a.this.gNy.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gNy != null) {
                    a.this.gNy.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNL = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.gNy != null) {
                    a.this.gNy.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.gNy != null) {
                    a.this.gNy.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gNM = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gNt.getVisibility() == 0) {
                    a.this.gNt.setVisibility(8);
                }
            }
        };
        this.gNN = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gtY != null) {
                    a.this.gtY.stopPlay();
                }
            }
        };
        this.guh = z;
        this.mFrom = str;
        this.cOR = str2;
        this.gNE = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gtK = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gNs = view.findViewById(R.id.card_container);
        this.gtL = (FrameLayout) view.findViewById(R.id.video_container);
        this.gtY = new com.baidu.tieba.play.c(tbPageContext, this.gtL, false, com.baidu.tbadk.a.b.rH("cyber_player_test") ? 1 : 0);
        this.gtY.rE(z);
        this.gtY.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.gNB != null && a.this.gtZ.guz.videoDuration > 8) {
                    a.this.gNB.aF(a.this.mPosition, a.this.gtZ.guz.videoUrl);
                }
            }
        });
        this.gtY.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void ml(boolean z2) {
                if (a.this.gNC != null) {
                    if (z2) {
                        a.this.gNC.uu(0);
                    } else {
                        a.this.gNC.uu(1);
                    }
                }
            }
        });
        this.gtY.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.gNr = (ExpandableTextView) view.findViewById(R.id.title);
        this.gtR = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nl = (TextView) view.findViewById(R.id.user_name);
        this.dhg = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 2;
        dVar.cNH = 6;
        this.dhg.setStatisticData(dVar);
        this.dhh = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dhi = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dhj = view.findViewById(R.id.thread_info_commont_container);
        this.dhk = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.dhl = (ImageView) view.findViewById(R.id.share_num_img);
        this.dhm = view.findViewById(R.id.share_num_container);
        this.gNt = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.gNu = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.gNt.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gNu.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_link_url", null);
        this.gNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGG().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.gND = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.gND.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.gND.setHasAgreeToPlay(true);
                a.this.gtY.rK(false);
                a.this.gND.cSv();
                if (a.this.fJn.kU()) {
                    a.this.fJn.resume();
                } else if (a.this.gtZ != null && a.this.gtZ.guz != null) {
                    a.this.gtY.ei(a.this.gtZ.guz.videoUrl, a.this.gtZ.threadId);
                }
            }
        });
        this.gNy = view.findViewById(R.id.video_agg_container_foreground);
        this.gNz = view.findViewById(R.id.title_and_comment_container_foreground);
        this.gNy.setOnClickListener(this);
        this.dhj.setOnClickListener(this);
        this.dhm.setOnClickListener(this);
        this.gNr.setOnClickListener(this);
        this.gtR.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.gNs.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.fYc = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtK.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtK.setLayoutParams(layoutParams);
        this.gtR.setIsRound(true);
        this.gtR.setPlaceHolder(1);
        this.ekZ = new n(tbPageContext.getPageActivity());
        this.gua = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.aLx = new AlphaAnimation(0.0f, 0.7f);
        this.aLx.setDuration(500L);
        this.aLx.setAnimationListener(this.gNL);
        this.aLy = new AlphaAnimation(0.7f, 0.0f);
        this.aLy.setDuration(500L);
        this.aLy.setAnimationListener(this.gNK);
        this.gNC = new C0513a();
        this.fJn = new com.baidu.afd.videopaster.d(getContext(), this.gtL);
        this.gNF = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dhg.onChangeSkinType(i);
        this.dhh.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dhk.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.aGC().a(this.dhi, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.dhl, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.gNr.onChangeSkinType();
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
        if (gVar != null && gVar.guz != null) {
            boolean z = this.gtZ == gVar;
            this.gtZ = gVar;
            this.cWl = this.gtZ.autoPlay;
            this.gNx = false;
            mj(false);
            this.gNr.setVisibility(0);
            this.gNr.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.gNr.setTextColor(R.color.cp_cont_a);
            this.gNr.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.guz != null && !StringUtils.isNull(gVar.guz.mcnLeadPage)) {
                this.gNr.setTextMaxLine(2);
                this.gNr.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.gNr.getContentView(), gVar.title, gVar.guz.mcnLeadPage, gVar.getThreadId());
            } else {
                this.gNr.setTextMaxLine(Integer.MAX_VALUE);
                this.gNr.setExpandable(true);
                this.gNr.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mm(boolean z2) {
                        a.this.gtZ.isTitleExpanded = z2;
                    }
                });
                this.gNr.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.fYc) {
                this.gtY.cys();
                this.fYc = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.gtL.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gtL.setLayoutParams(layoutParams);
            }
            bLi();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bLh() {
        try {
            int parseInt = Integer.parseInt(this.gtZ.guz.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.gtZ.guz.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bLi() {
        if (!bLh()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtK.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.gtK.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gtK.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.gtK.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.guz != null) {
            this.gtY.stopPlay();
            this.gtY.setIsNeedRecoveryVideoPlayer(true);
            this.gtY.rL(true);
            this.gtY.rH(true);
            this.gtY.rM(true);
            this.gtY.aj(false, false);
            this.gtY.An(i);
            this.gtY.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    a.this.bLm();
                    if (a.this.fJn != null) {
                        a.this.fJn.lc();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    a.this.bLn();
                    if (a.this.gtY.le()) {
                    }
                    if (a.this.gue || (a.this.fJn != null && a.this.fJn.kU())) {
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(a.this.gNN);
                        com.baidu.adp.lib.f.e.gx().post(a.this.gNN);
                    }
                    if (a.this.fJn != null) {
                        a.this.fJn.ld();
                    }
                }
            });
            this.gtY.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void bGn() {
                    if (a.this.gtZ != null && a.this.gtZ.guz != null && com.baidu.adp.lib.f.b.toInt(a.this.gtZ.guz.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.gtZ.guz.videoWidth, 0)) {
                        a.this.gtY.aj(false, false);
                    } else {
                        a.this.gtY.aj(true, false);
                    }
                    a.this.gue = false;
                    a.this.Bi(a.this.cWl ? "1" : "2");
                    a.this.onClick(a.this.gtL);
                    if (a.this.DG != null) {
                        a.this.DG.a(a.this);
                    }
                    if (a.this.gNG != null) {
                        a.this.gNG.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGo() {
                    a.this.onClick(a.this.gtK);
                }
            });
            this.gtY.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z2) {
                    a.this.gtY.ei(a.this.gtZ.guz.videoUrl, a.this.gtZ.threadId);
                    a.this.Bi("2");
                    a.this.onClick(a.this.gtL);
                }
            });
            this.gtY.rD(false);
            if (this.gNF != null) {
                this.gNF.reset();
            }
            this.startPosition = -1L;
            this.ekZ.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.gtZ.guz.guK;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.fJn.a(a.this.isFullScreen, a.this.gtY != null && a.this.gtY.cxY(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.fJn.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.gtY.cxY() && !com.baidu.mcn.b.DG().eB(aVar2.DZ)) {
                        boolean z3 = a.this.startPosition >= (aVar2.guC * 1000) + 1000;
                        if (i3 < aVar2.guC * 1000 || i3 >= aVar2.guD * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.gNF.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aLk = aVar2.guF;
                                aVar3.aLl = aVar2.guG;
                                aVar3.aLm = aVar2.DZ;
                                aVar3.aLj = aVar2.guE;
                                aVar3.fid = a.this.gtZ != null ? a.this.gtZ.forumId : null;
                                aVar3.tid = a.this.gtZ != null ? a.this.gtZ.threadId : null;
                                aVar3.aLn = 3;
                                if (z3) {
                                    a.this.gNF.b(aVar3, (ViewGroup) a.this.gtY.cyr());
                                } else {
                                    a.this.gNF.a(aVar3, (ViewGroup) a.this.gtY.cyr());
                                }
                            }
                        } else if (a.this.gNF.isShowing()) {
                            a.this.gNF.dismiss();
                        }
                    }
                }
            });
            this.gub = new y();
            this.gub.Pj = gVar.threadId;
            this.gub.emb = gVar.forumId;
            this.gub.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gub.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.gub.mSource = gVar.source;
            this.gub.jwG = gVar.weight;
            this.gub.jwI = this.mFrom;
            this.gub.mAbTag = gVar.abtest_tag;
            this.gub.cOR = this.cOR;
            this.gub.mExtra = gVar.extra;
            this.gub.jwM = "0";
            this.gub.jwJ = gVar.getVideoType();
            this.guc = new y();
            this.guc.Pj = gVar.threadId;
            this.guc.emb = gVar.forumId;
            this.guc.mUid = TbadkCoreApplication.getCurrentAccount();
            this.guc.jwG = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.guc.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.guc.jwI = this.mFrom;
            this.guc.mSource = gVar.source;
            this.guc.jwM = "0";
            if (gVar.guz != null) {
                this.gub.jwK = gVar.guz.videoMd5;
                this.guc.jwK = gVar.guz.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.cy("tid", gVar.threadId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", i);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cy("fid", gVar.forumId);
            anVar.cy("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.cy("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.cy("obj_id", this.cOR);
            anVar.cy(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.cy("obj_type", this.mFrom);
            anVar.X("obj_param5", gVar.getVideoType());
            anVar.cy("obj_source", aq.isEmpty(this.gtZ.source) ? "0" : this.gtZ.source);
            anVar.X("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                anVar.cy("obj_param4", gVar.mBaijiahao.oriUgcNid);
                anVar.cy("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(anVar);
            this.ekZ.setVideoStatsData(this.gub);
            this.gtY.cya().setBusiness(this.ekZ);
            this.ekZ.a(gVar);
            this.gtY.ccG();
            this.gtY.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.fJn.a(a.this.isFullScreen, a.this.gtY != null && a.this.gtY.cxY(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.gue = true;
                            a.this.gNv = true;
                            a.this.gud = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.te(i);
                            a.this.gtY.bPO();
                        }
                    }
                }
            });
            this.gtY.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.gtZ != null && a.this.gtZ.guz != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.gtZ.guz.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.fJn.reset();
            }
            this.fJn.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void ll() {
                    a.this.gNv = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lk() {
                    if (a.this.isFullScreen) {
                        a.this.gue = true;
                        a.this.gNv = true;
                        a.this.gud = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.te(i);
                        a.this.gtY.bPO();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void lj() {
                    if (a.this.gtY != null) {
                        a.this.gtY.Am(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean lm() {
                    return a.this.bLl();
                }
            });
            this.gtY.setThumbnail(gVar.guz.thumbnailUrl);
            this.gtY.Al(gVar.guz.videoDuration);
            this.gtY.setVideoUrl(gVar.guz.videoUrl, gVar.threadId);
            this.gtY.setFid(gVar.forumId);
            this.gtY.bPO();
            this.gtY.show();
            mj(false);
            if (gVar.autoPlay) {
                onClick(this.gtL);
                if (this.gND.cub()) {
                    this.gtY.rJ(false);
                    this.gND.cSu();
                    this.gtY.rK(true);
                    this.gtY.eh(gVar.guz.videoUrl, gVar.threadId);
                    if (this.fJn.kU()) {
                        this.fJn.stop();
                        this.fJn.kZ();
                    }
                } else {
                    this.gtY.rK(false);
                    this.gtY.rJ(false);
                    this.gND.hide();
                    if (this.fJn == null || (this.fJn != null && !this.fJn.kU())) {
                        this.gtY.a(gVar.guz.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.guA) {
                    this.gNy.setVisibility(8);
                    this.gNC.uu(3);
                } else {
                    if (this.gNy.getVisibility() == 0) {
                        this.gNy.startAnimation(this.aLy);
                    }
                    this.gNC.uu(0);
                }
                gVar.guA = false;
            } else {
                this.gNy.setVisibility(0);
                this.gND.hide();
                this.gtY.rJ(true);
                this.gNC.uu(3);
                this.gtY.eh(gVar.guz.videoUrl, gVar.threadId);
            }
            this.gue = false;
            this.gNv = false;
            if (!z && this.fJn.kU()) {
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
        com.baidu.afd.videopaster.data.b BR = this.gNE != null ? this.gNE.BR(gVar.getThreadId()) : null;
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
        if (gVar.guz != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.guz.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.guz.videoHeight, 0);
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
        if (this.gtZ != null && this.gtZ.guz != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gtZ.guz.videoMd5, "", str, this.guc);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.gtY.le();
    }

    public boolean bLj() {
        return this.fJn.kU();
    }

    public void bGj() {
        if (isPlaying()) {
            this.gtY.pausePlay();
        }
    }

    public boolean tf(int i) {
        if (i == 4 && this.fJn != null && ((this.fJn.kU() || this.gNv) && this.gtY != null)) {
            this.fJn.ax(i);
            if (this.isFullScreen) {
                if (this.fJn.kT()) {
                    this.gtY.cxZ();
                } else {
                    this.gtY.Aa();
                }
                return true;
            }
        }
        return this.gtY.Am(i);
    }

    public void bGk() {
        this.gNx = false;
        this.gtY.stopPlay();
        if (this.gNr != null) {
            this.gNr.setVisibility(0);
        }
        if (this.gNC != null) {
            this.gNC.uu(2);
        }
        mj(false);
        this.gNw = true;
        if (this.fJn != null && this.fJn.kU()) {
            this.fJn.stop();
        }
    }

    public void bLk() {
        this.fJn.stop();
    }

    public void bGl() {
        if (this.gtY != null) {
            this.gtY.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGl();
        if (this.gua != null) {
            this.gua.bGv();
        }
        if (this.gNy != null) {
            this.gNy.clearAnimation();
        }
        this.fJn.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.guy != null) {
            this.Nl.setText(TextUtils.isEmpty(gVar.guy.userNickname) ? gVar.guy.userName : gVar.guy.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.guy != null) {
            if (gVar.guy.guJ != null && !TextUtils.isEmpty(gVar.guy.guJ.avatar)) {
                this.gtR.startLoad(gVar.guy.guJ.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.guy.portrait) && gVar.guy.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.gtR.startLoad(gVar.guy.portrait, 10, false);
            } else {
                this.gtR.startLoad(gVar.guy.portrait, 12, false);
            }
            if (gVar.guy.guJ != null && gVar.guy.guJ.auth_id.intValue() > 0) {
                this.gtR.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.guy.guJ.auth_id.intValue(), 1));
                this.gtR.setShowV(true);
                this.gtR.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.gtR.setBjhAuthIconRes(0);
            if (gVar.guy.isBigV) {
                this.gtR.setShowV(gVar.guy.isBigV);
                this.gtR.setIsBigV(gVar.guy.isBigV);
            } else if (gVar.guy.isGod) {
                this.gtR.setShowV(gVar.guy.isGod);
                this.gtR.setIsBigV(gVar.guy.isGod);
            } else {
                this.gtR.setShowV(gVar.guy.isGod);
                this.gtR.setIsBigV(gVar.guy.isGod);
            }
            this.gtR.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.aEa() != null) {
                gVar.aEa().isInThread = true;
            }
            if (this.gtZ.mBaijiahao != null) {
                this.dhg.setAgreeAlone(true);
            }
            this.dhg.setIsFromMiddlePage(true);
            this.dhg.setData(gVar.aEa());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhh.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGC().a(this.dhi, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dhh.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.dhh.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dhk.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.aGC().a(this.dhl, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.dhk.setText(aq.numFormatOverWan(gVar.shareNum));
            } else {
                this.dhk.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gtY != null && this.gtL != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gud) {
                this.gtY.cyg();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bLm();
            } else {
                configuration.orientation = 1;
                bLn();
                this.gud = true;
            }
            this.gtY.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLl() {
        if (this.gtY != null && this.gtL != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gtL.getParent() != null) {
                if (this.gtL.getParent() == frameLayout) {
                    if (this.gNH) {
                        this.gNH = false;
                        return true;
                    } else if (!this.gNI) {
                        this.gNI = true;
                        return true;
                    }
                } else if (this.gtL.getParent() == this.gtK) {
                    if (this.gNI) {
                        this.gNI = false;
                        this.gNJ = true;
                        return true;
                    } else if (!this.gNH && this.gNJ) {
                        this.gNH = true;
                        this.gNJ = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLm() {
        if (this.gtY != null && this.gtL != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.gtL.getParent() != null) {
                if (this.gtL.getParent() == frameLayout) {
                    frameLayout.removeView(this.gtL);
                } else if (this.gtL.getParent() == this.gtK) {
                    this.gtK.removeView(this.gtL);
                }
            }
            if (this.gtL.getParent() == null) {
                frameLayout.addView(this.gtL);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gtL.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gtL.setLayoutParams(layoutParams);
                if (this.gNF != null && this.gNF.isShowing()) {
                    this.gNF.dismiss();
                }
                com.baidu.tbadk.util.d.aRR().gZ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLn() {
        if (this.gtY != null && this.gtL != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.gtL.getParent() != null) {
                if (this.gtL.getParent() == frameLayout) {
                    bLo();
                    frameLayout.removeView(this.gtL);
                } else if (this.gtL.getParent() == this.gtK) {
                    bLo();
                    this.gtK.removeView(this.gtL);
                }
            }
            if (this.gtL.getParent() == null) {
                this.gtK.addView(this.gtL, 0);
                bLp();
                this.gtY.ccG();
                this.startPosition = -1L;
                com.baidu.tbadk.util.d.aRR().gZ(false);
            }
        }
    }

    private void bLo() {
        if (this.fJn != null && this.fJn.kU()) {
            this.fJn.Y(true);
        }
    }

    private void bLp() {
        int i;
        if (!bLh()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.gtL.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (buG() != null) {
            view.setTag(this);
            buG().a(view, this.gtZ);
        }
        if (view == this.gtR || view == this.Nl) {
            if (this.gtZ != null && this.gtZ.guy != null && !TextUtils.isEmpty(this.gtZ.guy.userId)) {
                this.gNC.uu(0);
                if (!TbadkCoreApplication.isLogin() || !this.gtZ.guy.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gtZ.guy.userId, 0L), z, this.gtZ.guy.isGod)));
            }
        } else if (view == this.dhj) {
            if (this.gtZ != null) {
                this.gNC.uu(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.gtZ.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.gtZ.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gNr || view == this.gNs) {
            if (this.gtZ != null) {
                if (this.gNC.getCurrentState() != 2 && this.gNC.getCurrentState() != 3) {
                    z = false;
                }
                this.gNC.uu(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.gtZ.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.gtZ.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.dhm) {
            this.gNC.uu(0);
            aIc();
        } else if (view == this.gNy && this.gNy.getVisibility() == 0 && this.gNA != null) {
            this.gNA.uy(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lG(boolean z) {
        if (this.gtZ != null && this.gtZ.guy != null) {
            this.gtZ.guy.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGm() {
        if (this.gtZ != null) {
            this.dhg.aHs();
        }
    }

    public void mi(boolean z) {
        if (this.gtK != null) {
            this.gtK.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.gNG = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.gNA = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.DG = fVar;
    }

    private void mj(boolean z) {
        this.gNw = this.mPosition == (this.gNB == null ? -1 : this.gNB.bLB());
        if (this.gNw && z && isPlaying() && this.cWl && !this.gNx) {
            this.gNt.setVisibility(0);
            this.gNx = true;
            this.gNt.postDelayed(this.gNM, 5000L);
            if (this.gNB != null) {
                this.gNB.dy(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.gNt.setVisibility(8);
        if (this.gNM != null) {
            this.gNt.removeCallbacks(this.gNM);
        }
    }

    private void aIc() {
        String str;
        String str2;
        if (this.gtZ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.gtZ.forumId);
            String str3 = this.gtZ.title;
            if (this.gtZ.mBaijiahao != null) {
                str = this.gtZ.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.gtZ.mBaijiahao.oriUgcType + "&dvid=" + this.gtZ.mBaijiahao.oriUgcVid + "&nid=" + this.gtZ.mBaijiahao.oriUgcNid;
            } else {
                str = this.gtZ.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.gtZ.guz.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.gtZ.title;
            String format = (this.gtZ.mBaijiahao == null || this.gtZ.guy == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.gtZ.guy.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.gtZ.mBaijiahao != null) {
                shareItem.dqc = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.dqc = str6;
                shareItem.readCount = this.gtZ.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.dqf = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.dpS = true;
            shareItem.dqe = 11;
            shareItem.dqj = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.gtZ.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.gtZ.mBaijiahao;
            shareItem.dqm = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            anVar.cy("tid", str);
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.X("obj_locate", 12);
            TiebaStatic.log(anVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqf);
            bundle.putInt("obj_type", shareItem.dqj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUB);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.e.bwm().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bGk();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bGj();
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

    public void bLq() {
        this.fJn.resume();
    }

    public boolean bLr() {
        if (this.gNC != null) {
            return this.gNC.getCurrentState() == 2 || this.gNC.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0513a {
        private Runnable gNR;
        private int mCurrentState;

        private C0513a() {
            this.mCurrentState = -1;
            this.gNR = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(C0513a.this.gNR);
                    C0513a.this.uu(2);
                }
            };
        }

        public void uu(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = uv(i);
                    bLs();
                    return;
                case 1:
                    this.mCurrentState = uv(i);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNR);
                    return;
                case 2:
                    this.mCurrentState = uw(i);
                    return;
                case 3:
                    this.mCurrentState = ux(i);
                    bLs();
                    return;
                default:
                    this.mCurrentState = uw(i);
                    return;
            }
        }

        private void bLs() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNR);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gNR, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int uv(int i) {
            if (i != this.mCurrentState) {
                a.this.gNz.setVisibility(8);
                a.this.mk(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int uw(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.gNz.setVisibility(0);
                if (i2 != 3 || a.this.gtZ.autoPlay) {
                    a.this.mk(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int ux(int i) {
            if (i != this.mCurrentState) {
                a.this.gNz.setVisibility(0);
                a.this.mk(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
