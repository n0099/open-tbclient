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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.frs.view.SpannableClickTextView;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f AA;
    public TextView He;
    private Animation ayN;
    private Animation ayO;
    private String bYk;
    private boolean cfz;
    private ImageView cpA;
    private View cpB;
    private ImageView cpD;
    private View cpE;
    protected AgreeView cpy;
    private TextView cpz;
    private n dvI;
    private com.baidu.afd.videopaster.d eLO;
    public FrameLayout fAc;
    public FrameLayout fAd;
    public HeadImageView fAj;
    public com.baidu.tieba.play.c fAq;
    public com.baidu.tieba.frs.aggregation.g fAr;
    private com.baidu.tieba.frs.aggregation.h fAs;
    private z fAt;
    private z fAu;
    private boolean fAv;
    private boolean fAw;
    private boolean fAz;
    public SpannableClickTextView fTE;
    private View fTF;
    private FrameLayout fTG;
    private TextView fTH;
    private boolean fTI;
    private boolean fTJ;
    private boolean fTK;
    private View fTL;
    private View fTM;
    private c fTN;
    public com.baidu.tieba.frs.videomiddlepage.a.a fTO;
    private C0414a fTP;
    private VideoNetworkStateTipView fTQ;
    private b fTR;
    private com.baidu.mcn.c fTS;
    private com.baidu.tieba.lego.card.view.g fTT;
    private boolean fTU;
    private boolean fTV;
    private boolean fTW;
    private Animation.AnimationListener fTX;
    private Animation.AnimationListener fTY;
    private Runnable fTZ;
    private Runnable fUa;
    private int fen;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fAv = true;
        this.fAz = true;
        this.fTJ = false;
        this.fTK = false;
        this.fTU = false;
        this.fTV = false;
        this.fTW = false;
        this.startPosition = -1L;
        this.fen = 0;
        this.fTX = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fTL != null) {
                    a.this.fTL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fTL != null) {
                    a.this.fTL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fTY = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fTL != null) {
                    a.this.fTL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fTL != null) {
                    a.this.fTL.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fTZ = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fTG.getVisibility() == 0) {
                    a.this.fTG.setVisibility(8);
                }
            }
        };
        this.fUa = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fAq != null) {
                    a.this.fAq.stopPlay();
                }
            }
        };
        this.fAz = z;
        this.mFrom = str;
        this.bYk = str2;
        this.fTR = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fAc = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fTF = view.findViewById(R.id.card_container);
        this.fAd = (FrameLayout) view.findViewById(R.id.video_container);
        this.fAq = new com.baidu.tieba.play.c(tbPageContext, this.fAd, false, com.baidu.tbadk.a.b.mb("cyber_player_test") ? 1 : 0);
        this.fAq.pG(z);
        this.fAq.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fTO != null && a.this.fAr.fAR.videoDuration > 8) {
                    a.this.fTO.ak(a.this.mPosition, a.this.fAr.fAR.videoUrl);
                }
            }
        });
        this.fAq.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void kL(boolean z2) {
                if (a.this.fTP != null) {
                    if (z2) {
                        a.this.fTP.sb(0);
                    } else {
                        a.this.fTP.sb(1);
                    }
                }
            }
        });
        this.fAq.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fTE = (SpannableClickTextView) view.findViewById(R.id.title);
        this.fAj = (HeadImageView) view.findViewById(R.id.user_icon);
        this.He = (TextView) view.findViewById(R.id.user_name);
        this.cpy = (AgreeView) view.findViewById(R.id.agree_view);
        this.cpy.setAgreeAnimationResource(R.raw.agree);
        this.cpy.setDisagreeAnimationResource(R.raw.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bXa = 2;
        dVar.bXe = 6;
        this.cpy.setStatisticData(dVar);
        this.cpz = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.cpA = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.cpB = view.findViewById(R.id.thread_info_commont_container);
        this.cpD = (ImageView) view.findViewById(R.id.share_num_img);
        this.cpE = view.findViewById(R.id.share_num_container);
        this.fTG = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.fTH = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.fTG.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fTH.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_download_link_url", null);
        this.fTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.amO().a((TbPageContext) i.ab(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fTQ = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.fTQ.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c13257"));
                a.this.fTQ.setHasAgreeToPlay(true);
                a.this.fAq.pM(false);
                a.this.fTQ.cwf();
                if (a.this.eLO.kn()) {
                    a.this.eLO.resume();
                } else if (a.this.fAr != null && a.this.fAr.fAR != null) {
                    a.this.fAq.cm(a.this.fAr.fAR.videoUrl, a.this.fAr.threadId);
                }
            }
        });
        this.fTL = view.findViewById(R.id.video_agg_container_foreground);
        this.fTM = view.findViewById(R.id.title_and_comment_container_foreground);
        this.fTL.setOnClickListener(this);
        this.cpB.setOnClickListener(this);
        this.cpE.setOnClickListener(this);
        this.fTE.setOnClickListener(this);
        this.fAj.setOnClickListener(this);
        this.He.setOnClickListener(this);
        this.fTF.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.fen = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fAc.setLayoutParams(layoutParams);
        this.fAj.setIsRound(true);
        this.dvI = new n(tbPageContext.getPageActivity());
        this.fAs = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.ayN = new AlphaAnimation(0.0f, 0.7f);
        this.ayN.setDuration(500L);
        this.ayN.setAnimationListener(this.fTY);
        this.ayO = new AlphaAnimation(0.7f, 0.0f);
        this.ayO.setDuration(500L);
        this.ayO.setAnimationListener(this.fTX);
        this.fTP = new C0414a();
        this.eLO = new com.baidu.afd.videopaster.d(getContext(), this.fAd);
        this.fTS = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.cpy.onChangeSkinType(i);
        this.cpz.setTextColor(am.getColor(R.color.cp_cont_d));
        SvgManager.amL().a(this.cpA, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amL().a(this.cpD, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fTE.setTextColor(tbPageContext.getResources().getColor(R.color.cp_cont_a));
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
        if (gVar != null && gVar.fAR != null) {
            boolean z = this.fAr == gVar;
            this.fAr = gVar;
            this.cfz = this.fAr.autoPlay;
            this.fTK = false;
            kJ(false);
            this.fTE.setVisibility(0);
            if (gVar.fAR != null && !StringUtils.isNull(gVar.fAR.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fTE, gVar.title, gVar.fAR.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fTE.setText(gVar.title);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.fen) {
                this.fAq.cbW();
                this.fen = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.fAd.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fAd.setLayoutParams(layoutParams);
            }
            brc();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.akt() != null) {
                gVar.akt().isInThread = true;
            }
            this.cpy.setIsFromMiddlePage(true);
            this.cpy.setData(gVar.akt());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean brb() {
        try {
            int parseInt = Integer.parseInt(this.fAr.fAR.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fAr.fAR.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void brc() {
        if (!brb()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAc.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fAc.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAc.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fAc.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.fAR != null) {
            this.fAq.stopPlay();
            this.fAq.setIsNeedRecoveryVideoPlayer(true);
            this.fAq.pN(true);
            this.fAq.pJ(true);
            this.fAq.pO(true);
            this.fAq.ag(false, false);
            this.fAq.xD(i);
            this.fAq.a(new c.InterfaceC0492c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0492c
                public void kv() {
                    a.this.brg();
                    if (a.this.eLO != null) {
                        a.this.eLO.kv();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0492c
                public void kw() {
                    a.this.brh();
                    if (a.this.fAq.kx()) {
                    }
                    if (a.this.fAw || (a.this.eLO != null && a.this.eLO.kn())) {
                        com.baidu.adp.lib.g.e.fZ().removeCallbacks(a.this.fUa);
                        com.baidu.adp.lib.g.e.fZ().post(a.this.fUa);
                    }
                    if (a.this.eLO != null) {
                        a.this.eLO.kw();
                    }
                }
            });
            this.fAq.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void bmk() {
                    if (a.this.fAr != null && a.this.fAr.fAR != null && com.baidu.adp.lib.g.b.toInt(a.this.fAr.fAR.videoHeight, 0) > com.baidu.adp.lib.g.b.toInt(a.this.fAr.fAR.videoWidth, 0)) {
                        a.this.fAq.ag(false, false);
                    } else {
                        a.this.fAq.ag(true, false);
                    }
                    a.this.fAw = false;
                    a.this.vR(a.this.cfz ? "1" : "2");
                    a.this.onClick(a.this.fAd);
                    if (a.this.AA != null) {
                        a.this.AA.a(a.this);
                    }
                    if (a.this.fTT != null) {
                        a.this.fTT.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void bml() {
                    a.this.onClick(a.this.fAc);
                }
            });
            this.fAq.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z2) {
                    a.this.fAq.cm(a.this.fAr.fAR.videoUrl, a.this.fAr.threadId);
                    a.this.vR("2");
                    a.this.onClick(a.this.fAd);
                }
            });
            this.fAq.pF(false);
            if (this.fTS != null) {
                this.fTS.reset();
            }
            this.startPosition = -1L;
            this.dvI.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fAr.fAR.fBb;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.eLO.a(a.this.isFullScreen, a.this.fAq != null && a.this.fAq.cbC(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.eLO.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fAq.cbC() && !com.baidu.mcn.b.ze().du(aVar2.AU)) {
                        boolean z3 = a.this.startPosition >= (aVar2.fAU * 1000) + 1000;
                        if (i3 < aVar2.fAU * 1000 || i3 >= aVar2.fAV * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fTS.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.ayz = aVar2.fAX;
                                aVar3.ayA = aVar2.fAY;
                                aVar3.ayB = aVar2.AU;
                                aVar3.ayy = aVar2.fAW;
                                aVar3.fid = a.this.fAr != null ? a.this.fAr.forumId : null;
                                aVar3.tid = a.this.fAr != null ? a.this.fAr.threadId : null;
                                aVar3.ayC = 3;
                                if (z3) {
                                    a.this.fTS.b(aVar3, (ViewGroup) a.this.fAq.cbV());
                                } else {
                                    a.this.fTS.a(aVar3, (ViewGroup) a.this.fAq.cbV());
                                }
                            }
                        } else if (a.this.fTS.isShowing()) {
                            a.this.fTS.dismiss();
                        }
                    }
                }
            });
            this.fAt = new z();
            this.fAt.cma = gVar.threadId;
            this.fAt.ePc = gVar.forumId;
            this.fAt.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fAt.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.fAt.mSource = gVar.source;
            this.fAt.iyj = gVar.weight;
            this.fAt.iyl = this.mFrom;
            this.fAt.iym = gVar.abtest_tag;
            this.fAt.bYk = this.bYk;
            this.fAt.dhw = gVar.extra;
            this.fAt.iyp = "0";
            this.fAu = new z();
            this.fAu.cma = gVar.threadId;
            this.fAu.ePc = gVar.forumId;
            this.fAu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fAu.iyj = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.fAu.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.fAu.iyl = this.mFrom;
            this.fAu.mSource = gVar.source;
            this.fAu.iyp = "0";
            if (gVar.fAR != null) {
                this.fAt.iyn = gVar.fAR.videoMd5;
                this.fAu.iyn = gVar.fAR.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.bS("tid", gVar.threadId);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.O("obj_locate", i);
            anVar.O(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.bS("fid", gVar.forumId);
            anVar.bS("obj_param1", aq.isEmpty(gVar.weight) ? "0" : gVar.weight);
            anVar.bS("extra", aq.isEmpty(gVar.extra) ? "0" : gVar.extra);
            anVar.bS("obj_id", this.bYk);
            anVar.bS(TiebaInitialize.Params.AB_TAG, aq.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            anVar.bS("obj_type", this.mFrom);
            anVar.bS("obj_source", aq.isEmpty(this.fAr.source) ? "0" : this.fAr.source);
            anVar.O("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.dvI.setVideoStatsData(this.fAt);
            this.fAq.cbE().setBusiness(this.dvI);
            this.dvI.a(gVar);
            this.fAq.bIG();
            this.fAq.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.eLO.a(a.this.isFullScreen, a.this.fAq != null && a.this.fAq.cbC(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fAw = true;
                            a.this.fTI = true;
                            a.this.fAv = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.qN(i);
                            a.this.fAq.bvK();
                        }
                    }
                }
            });
            this.fAq.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fAr != null && a.this.fAr.fAR != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fAr.fAR.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.eLO.reset();
            }
            this.eLO.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void kE() {
                    a.this.fTI = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kD() {
                    if (a.this.isFullScreen) {
                        a.this.fAw = true;
                        a.this.fTI = true;
                        a.this.fAv = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.qN(i);
                        a.this.fAq.bvK();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void kC() {
                    if (a.this.fAq != null) {
                        a.this.fAq.xC(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean kF() {
                    return a.this.brf();
                }
            });
            this.fAq.setThumbnail(gVar.fAR.thumbnailUrl);
            this.fAq.setVideoUrl(gVar.fAR.videoUrl, gVar.threadId);
            this.fAq.setFid(gVar.forumId);
            this.fAq.bvK();
            this.fAq.show();
            kJ(false);
            if (gVar.autoPlay) {
                onClick(this.fAd);
                if (this.fTQ.cdj()) {
                    this.fAq.pL(false);
                    this.fTQ.cwe();
                    this.fAq.pM(true);
                    this.fAq.dE(gVar.fAR.videoUrl, gVar.threadId);
                    if (this.eLO.kn()) {
                        this.eLO.stop();
                        this.eLO.ks();
                    }
                } else {
                    this.fAq.pM(false);
                    this.fAq.pL(false);
                    this.fTQ.hide();
                    if (this.eLO == null || (this.eLO != null && !this.eLO.kn())) {
                        this.fAq.a(gVar.fAR.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.fAS) {
                    this.fTL.setVisibility(8);
                    this.fTP.sb(3);
                } else {
                    if (this.fTL.getVisibility() == 0) {
                        this.fTL.startAnimation(this.ayO);
                    }
                    this.fTP.sb(0);
                }
                gVar.fAS = false;
            } else {
                this.fTL.setVisibility(0);
                this.fTQ.hide();
                this.fAq.pL(true);
                this.fTP.sb(3);
                this.fAq.dE(gVar.fAR.videoUrl, gVar.threadId);
            }
            this.fAw = false;
            this.fTI = false;
            if (!z && this.eLO.kn()) {
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
        com.baidu.afd.videopaster.data.b wC = this.fTR != null ? this.fTR.wC(gVar.getThreadId()) : null;
        if (wC == null) {
            return null;
        }
        int kJ = wC.kJ();
        int kK = wC.kK();
        int kI = wC.kI();
        if (kI != -1) {
            i = kJ != -1 ? (kI - kJ) - 1 : -1;
            if (kK != -1) {
                i4 = (kK - kI) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.fAR != null) {
            i3 = com.baidu.adp.lib.g.b.toInt(gVar.fAR.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.toInt(gVar.fAR.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", kI + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(String str) {
        if (this.fAr != null && this.fAr.fAR != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fAr.fAR.videoMd5, "", str, this.fAu);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.fAq.kx();
    }

    public boolean brd() {
        return this.eLO.kn();
    }

    public void bmg() {
        if (isPlaying()) {
            this.fAq.pausePlay();
        }
    }

    public boolean qO(int i) {
        if (i == 4 && this.eLO != null && ((this.eLO.kn() || this.fTI) && this.fAq != null)) {
            this.eLO.ar(i);
            if (this.isFullScreen) {
                if (this.eLO.km()) {
                    this.fAq.cbD();
                } else {
                    this.fAq.vt();
                }
                return true;
            }
        }
        return this.fAq.xC(i);
    }

    public void bmh() {
        this.fTK = false;
        this.fAq.stopPlay();
        if (this.fTE != null) {
            this.fTE.setVisibility(0);
        }
        if (this.fTP != null) {
            this.fTP.sb(2);
        }
        kJ(false);
        this.fTJ = true;
        if (this.eLO != null && this.eLO.kn()) {
            this.eLO.stop();
        }
    }

    public void bre() {
        this.eLO.stop();
    }

    public void bmi() {
        if (this.fAq != null) {
            this.fAq.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmi();
        if (this.fAs != null) {
            this.fAs.bmt();
        }
        if (this.fTL != null) {
            this.fTL.clearAnimation();
        }
        this.eLO.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.fAQ != null) {
            this.He.setText(TextUtils.isEmpty(gVar.fAQ.userNickname) ? gVar.fAQ.userName : gVar.fAQ.userNickname);
            if (!StringUtils.isNull(gVar.fAQ.portrait) && gVar.fAQ.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.fAj.startLoad(gVar.fAQ.portrait, 10, false);
            } else {
                this.fAj.startLoad(gVar.fAQ.portrait, 12, false);
            }
            if (gVar.fAQ.isBigV) {
                this.fAj.setShowV(gVar.fAQ.isBigV);
                this.fAj.setIsBigV(gVar.fAQ.isBigV);
            } else if (gVar.fAQ.isGod) {
                this.fAj.setShowV(gVar.fAQ.isGod);
                this.fAj.setIsBigV(gVar.fAQ.isGod);
            } else {
                this.fAj.setShowV(gVar.fAQ.isGod);
                this.fAj.setIsBigV(gVar.fAQ.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cpy.setData(gVar.akt());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.cpz.setTextColor(am.getColor(R.color.cp_cont_d));
            SvgManager.amL().a(this.cpA, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.cpz.setText(aq.numFormatOverWan(gVar.postNum));
            } else {
                this.cpz.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fAq != null && this.fAd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fAv) {
                this.fAq.cbK();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                brg();
            } else {
                configuration.orientation = 1;
                brh();
                this.fAv = true;
            }
            this.fAq.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brf() {
        if (this.fAq != null && this.fAd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fAd.getParent() != null) {
                if (this.fAd.getParent() == frameLayout) {
                    if (this.fTU) {
                        this.fTU = false;
                        return true;
                    } else if (!this.fTV) {
                        this.fTV = true;
                        return true;
                    }
                } else if (this.fAd.getParent() == this.fAc) {
                    if (this.fTV) {
                        this.fTV = false;
                        this.fTW = true;
                        return true;
                    } else if (!this.fTU && this.fTW) {
                        this.fTU = true;
                        this.fTW = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brg() {
        if (this.fAq != null && this.fAd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fAd.getParent() != null) {
                if (this.fAd.getParent() == frameLayout) {
                    frameLayout.removeView(this.fAd);
                } else if (this.fAd.getParent() == this.fAc) {
                    this.fAc.removeView(this.fAd);
                }
            }
            if (this.fAd.getParent() == null) {
                frameLayout.addView(this.fAd);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fAd.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fAd.setLayoutParams(layoutParams);
                if (this.fTS != null && this.fTS.isShowing()) {
                    this.fTS.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brh() {
        if (this.fAq != null && this.fAd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fAd.getParent() != null) {
                if (this.fAd.getParent() == frameLayout) {
                    bri();
                    frameLayout.removeView(this.fAd);
                } else if (this.fAd.getParent() == this.fAc) {
                    bri();
                    this.fAc.removeView(this.fAd);
                }
            }
            if (this.fAd.getParent() == null) {
                this.fAc.addView(this.fAd, 0);
                brj();
                this.fAq.bIG();
                this.startPosition = -1L;
            }
        }
    }

    private void bri() {
        if (this.eLO != null && this.eLO.kn()) {
            this.eLO.Q(true);
        }
    }

    private void brj() {
        int i;
        if (!brb()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fAd.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aZV() != null) {
            view.setTag(this);
            aZV().a(view, this.fAr);
        }
        if (view == this.fAj || view == this.He) {
            if (this.fAr != null && this.fAr.fAQ != null && !TextUtils.isEmpty(this.fAr.fAQ.userId)) {
                this.fTP.sb(0);
                if (!TbadkCoreApplication.isLogin() || !this.fAr.fAQ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(this.fAr.fAQ.userId, 0L), z, this.fAr.fAQ.isGod)));
            }
        } else if (view == this.cpB) {
            if (this.fAr != null) {
                this.fTP.sb(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fAr.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.fTE || view == this.fTF) {
            if (this.fAr != null) {
                if (this.fTP.getCurrentState() != 2 && this.fTP.getCurrentState() != 3) {
                    z = false;
                }
                this.fTP.sb(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fAr.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.cpE) {
            this.fTP.sb(0);
            anY();
        } else if (view == this.fTL && this.fTL.getVisibility() == 0 && this.fTN != null) {
            this.fTN.sf(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fAr != null && this.fAr.fAQ != null) {
            this.fAr.fAQ.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bmj() {
        if (this.fAr != null) {
            this.cpy.ans();
        }
    }

    public void kI(boolean z) {
        if (this.fAc != null) {
            this.fAc.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.fTT = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fTN = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.AA = fVar;
    }

    private void kJ(boolean z) {
        this.fTJ = this.mPosition == (this.fTO == null ? -1 : this.fTO.brt());
        if (this.fTJ && z && isPlaying() && this.cfz && !this.fTK) {
            this.fTG.setVisibility(0);
            this.fTK = true;
            this.fTG.postDelayed(this.fTZ, 5000L);
            if (this.fTO != null) {
                this.fTO.cN(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fTG.setVisibility(8);
        if (this.fTZ != null) {
            this.fTG.removeCallbacks(this.fTZ);
        }
    }

    private void anY() {
        if (this.fAr != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fAr.forumId);
            String str = this.fAr.title;
            String str2 = this.fAr.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fAr.fAR.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fAr.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = format;
            eVar.cxT = str5;
            eVar.linkUrl = str3;
            eVar.extData = str2;
            eVar.cxW = 3;
            eVar.fid = valueOf;
            eVar.cxN = "";
            eVar.tid = str2;
            eVar.cxG = true;
            eVar.cxV = 0;
            eVar.cya = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cxW);
            bundle.putInt("obj_type", eVar.cya);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt("obj_source", eVar.cdP);
            eVar.E(bundle);
            com.baidu.tieba.c.e.bch().a(new ShareDialogConfig(this.mContext, eVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        bmh();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        bmg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(boolean z) {
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

    public void brk() {
        this.eLO.resume();
    }

    public boolean brl() {
        if (this.fTP != null) {
            return this.fTP.getCurrentState() == 2 || this.fTP.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0414a {
        private Runnable fUe;
        private int mCurrentState;

        private C0414a() {
            this.mCurrentState = -1;
            this.fUe = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(C0414a.this.fUe);
                    C0414a.this.sb(2);
                }
            };
        }

        public void sb(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = sc(i);
                    brm();
                    return;
                case 1:
                    this.mCurrentState = sc(i);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fUe);
                    return;
                case 2:
                    this.mCurrentState = sd(i);
                    return;
                case 3:
                    this.mCurrentState = se(i);
                    brm();
                    return;
                default:
                    this.mCurrentState = sd(i);
                    return;
            }
        }

        private void brm() {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fUe);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.fUe, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int sc(int i) {
            if (i != this.mCurrentState) {
                a.this.fTM.setVisibility(8);
                a.this.kK(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int sd(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fTM.setVisibility(0);
                if (i2 != 3 || a.this.fAr.autoPlay) {
                    a.this.kK(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int se(int i) {
            if (i != this.mCurrentState) {
                a.this.fTM.setVisibility(0);
                a.this.kK(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
