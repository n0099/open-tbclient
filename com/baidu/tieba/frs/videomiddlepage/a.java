package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.VideoAggregationDisPraiseView;
import com.baidu.tbadk.core.view.VideoAggregationPraiseView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.aggregation.h;
import com.baidu.tieba.frs.videomiddlepage.controller.VideoNetworkStateTipView;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i {
    private com.baidu.tieba.lego.card.view.f RT;
    private TextView aAb;
    private ImageView aAc;
    private View aAd;
    private ImageView aAf;
    private View aAg;
    public TextView aBt;
    private String ahY;
    private boolean aoz;
    protected VideoAggregationPraiseView awi;
    protected VideoAggregationDisPraiseView awj;
    public com.baidu.tieba.frs.aggregation.g awk;
    private Animation bAV;
    private n bBi;
    public HeadImageView coE;
    private View dOA;
    protected com.baidu.tbadk.core.view.c dOB;
    private FrameLayout dOC;
    private TextView dOD;
    private boolean dOE;
    private boolean dOF;
    private View dOG;
    private View dOH;
    private b dOI;
    public com.baidu.tieba.frs.videomiddlepage.controller.a dOJ;
    private C0160a dOK;
    private VideoNetworkStateTipView dOL;
    private Animation.AnimationListener dOM;
    private Animation.AnimationListener dON;
    private Runnable dOO;
    public FrameLayout dwV;
    public FrameLayout dwW;
    public TextView dwX;
    public com.baidu.tieba.play.c dxj;
    private h dxk;
    private y dxl;
    private y dxm;
    private boolean dxn;
    private boolean dxo;
    private Animation dxq;
    private boolean dxs;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dxn = true;
        this.dxs = true;
        this.dOE = false;
        this.dOF = false;
        this.dOM = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dOG != null) {
                    a.this.dOG.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dOG != null) {
                    a.this.dOG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dON = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dOG != null) {
                    a.this.dOG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dOG != null) {
                    a.this.dOG.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dOO = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dOC.getVisibility() == 0) {
                    a.this.dOC.setVisibility(8);
                }
            }
        };
        this.dxs = z;
        this.mFrom = str;
        this.ahY = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dwV = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dOA = view.findViewById(e.g.card_container);
        this.dwW = (FrameLayout) view.findViewById(e.g.video_container);
        this.dxj = new com.baidu.tieba.play.c(tbPageContext, this.dwW, false);
        this.dxj.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dOJ != null && a.this.awk.dxK.videoDuration > 8) {
                    a.this.dOJ.R(a.this.mPosition, a.this.awk.dxK.videoUrl);
                }
            }
        });
        this.dxj.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // com.baidu.tieba.play.c.a
            public void gP(boolean z2) {
                if (a.this.dOK != null) {
                    if (z2) {
                        a.this.dOK.mv(0);
                    } else {
                        a.this.dOK.mv(1);
                    }
                }
            }
        });
        this.dwX = (TextView) view.findViewById(e.g.title);
        this.coE = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aBt = (TextView) view.findViewById(e.g.user_name);
        this.awi = (VideoAggregationPraiseView) view.findViewById(e.g.agree_view);
        this.awj = (VideoAggregationDisPraiseView) view.findViewById(e.g.disagree_view);
        this.dOB = new com.baidu.tbadk.core.view.c(this.awi, this.awj);
        this.dOB.Bn();
        this.dOB.h(tbPageContext.getUniqueId());
        this.aAb = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.aAc = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.aAd = view.findViewById(e.g.thread_info_commont_container);
        this.aAf = (ImageView) view.findViewById(e.g.share_num_img);
        this.aAg = view.findViewById(e.g.share_num_container);
        this.dOC = (FrameLayout) view.findViewById(e.g.download_nani_guide_container);
        this.dOD = (TextView) view.findViewById(e.g.download_nani_guide_txt);
        this.dOC.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dOD.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.AN().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dOL = (VideoNetworkStateTipView) view.findViewById(e.g.network_state_tip);
        this.dOL.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.dOL.setHasAgreeToPlay(true);
                a.this.dxj.lQ(false);
                a.this.dOL.aDo();
                if (a.this.awk != null && a.this.awk.dxK != null) {
                    a.this.dxj.cb(a.this.awk.dxK.videoUrl, a.this.awk.threadId);
                }
            }
        });
        this.dOG = view.findViewById(e.g.video_agg_container_foreground);
        this.dOH = view.findViewById(e.g.title_and_comment_container_foreground);
        this.dOG.setOnClickListener(this);
        this.awi.setOnClickListener(this);
        this.awj.setOnClickListener(this);
        this.aAd.setOnClickListener(this);
        this.aAg.setOnClickListener(this);
        this.dwX.setOnClickListener(this);
        this.coE.setOnClickListener(this);
        this.aBt.setOnClickListener(this);
        this.dOA.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dwV.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dwV.setLayoutParams(layoutParams);
        this.coE.setIsRound(true);
        this.bBi = new n(tbPageContext.getPageActivity());
        this.dxk = new h(this.mPageContext, this);
        this.dxq = new AlphaAnimation(0.0f, 0.7f);
        this.dxq.setDuration(500L);
        this.dxq.setAnimationListener(this.dON);
        this.bAV = new AlphaAnimation(0.7f, 0.0f);
        this.bAV.setDuration(500L);
        this.bAV.setAnimationListener(this.dOM);
        this.dOK = new C0160a();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dOB != null) {
            this.dOB.onChangeSkinType(i);
        }
        this.aAb.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.aAc.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_comment_background));
        this.aAf.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_share_background));
        this.dwX.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dxK != null) {
            this.awk = gVar;
            this.aoz = this.awk.autoPlay;
            this.dOF = false;
            gN(false);
            this.dwX.setVisibility(0);
            this.dwX.setText(gVar.title);
            aDa();
            b(gVar, i, aVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aCZ() {
        try {
            int parseInt = Integer.parseInt(this.awk.dxK.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.awk.dxK.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aDa() {
        if (!aCZ()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dwV.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dwV.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dwV.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dwV.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dxK != null) {
            this.dxj.stopPlay();
            this.dxj.setIsNeedRecoveryVideoPlayer(true);
            this.dxj.lR(true);
            this.dxj.lN(true);
            this.dxj.lS(true);
            this.dxj.P(false, false);
            this.dxj.sc(i);
            this.dxj.a(new c.InterfaceC0224c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ayr() {
                    a.this.aDb();
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ays() {
                    a.this.aDc();
                    if (a.this.dxj.bmu()) {
                    }
                    if (a.this.dxo) {
                        a.this.dxj.stopPlay();
                    }
                }
            });
            this.dxj.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.l
                public void ayt() {
                    if (a.this.awk != null && a.this.awk.dxK != null && com.baidu.adp.lib.g.b.l(a.this.awk.dxK.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.awk.dxK.videoWidth, 0)) {
                        a.this.dxj.P(false, false);
                    } else {
                        a.this.dxj.P(true, false);
                    }
                    a.this.dxo = false;
                    a.this.nc(a.this.aoz ? "1" : "2");
                    a.this.onClick(a.this.dwW);
                    if (a.this.RT != null) {
                        a.this.RT.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void ayu() {
                    a.this.onClick(a.this.dwV);
                }
            });
            this.dxj.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.c.f
                public void gq(boolean z) {
                    a.this.dxj.cb(a.this.awk.dxK.videoUrl, a.this.awk.threadId);
                    a.this.nc("2");
                    a.this.onClick(a.this.dwW);
                }
            });
            this.dxj.lK(false);
            this.dxl = new y();
            this.dxl.aZG = gVar.threadId;
            this.dxl.cHI = gVar.forumId;
            this.dxl.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dxl.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dxl.mSource = gVar.source;
            this.dxl.goU = gVar.weight;
            this.dxl.goW = this.mFrom;
            this.dxl.goX = gVar.abtest_tag;
            this.dxl.ahY = this.ahY;
            this.dxl.cHE = gVar.extra;
            this.dxl.gpa = "0";
            this.dxm = new y();
            this.dxm.aZG = gVar.threadId;
            this.dxm.cHI = gVar.forumId;
            this.dxm.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dxm.goU = "auto_midpage";
            this.dxm.mLocate = "auto_midpage";
            this.dxm.goW = this.mFrom;
            this.dxm.mSource = gVar.source;
            this.dxm.gpa = "0";
            if (gVar.dxK != null) {
                this.dxl.goY = gVar.dxK.videoMd5;
                this.dxm.goY = gVar.dxK.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.al("tid", gVar.threadId);
            amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.w("obj_locate", i);
            amVar.w("obj_param2", 1);
            amVar.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.al("obj_param1", ao.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.al("extra", ao.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.al(VideoPlayActivityConfig.OBJ_ID, this.ahY);
            amVar.al("ab_tag", ao.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.al("obj_type", this.mFrom);
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.awk.source) ? "0" : this.awk.source);
            amVar.w("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.bBi.setVideoStatsData(this.dxl);
            this.dxj.getVideoView().setBusiness(this.bBi);
            this.bBi.a(gVar);
            this.dxj.aUn();
            this.dxj.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dxo = true;
                        a.this.dxn = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.ln(i);
                        a.this.dxj.aHp();
                    }
                }
            });
            this.dxj.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.awk != null && a.this.awk.dxK != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.awk.dxK.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dxj.setThumbnail(gVar.dxK.thumbnailUrl);
            this.dxj.setVideoUrl(gVar.dxK.videoUrl, gVar.threadId);
            this.dxj.setFid(gVar.forumId);
            this.dxj.aHp();
            this.dxj.show();
            gN(false);
            if (gVar.autoPlay) {
                onClick(this.dwW);
                if (this.dOL.aDm()) {
                    this.dxj.lP(false);
                    this.dOL.aDn();
                    this.dxj.lQ(true);
                    this.dxj.ca(gVar.dxK.videoUrl, gVar.threadId);
                } else {
                    this.dxj.lQ(false);
                    this.dxj.lP(false);
                    this.dOL.hide();
                    this.dxj.a(gVar.dxK.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                }
                if (i == 0 && gVar.dxL) {
                    this.dOG.setVisibility(8);
                    this.dOK.mv(3);
                } else {
                    if (this.dOG.getVisibility() == 0) {
                        this.dOG.startAnimation(this.bAV);
                    }
                    this.dOK.mv(0);
                }
                gVar.dxL = false;
            } else {
                this.dOG.setVisibility(0);
                this.dOL.hide();
                this.dxj.lP(true);
                this.dOK.mv(3);
                this.dxj.ca(gVar.dxK.videoUrl, gVar.threadId);
            }
            this.dxo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(String str) {
        if (this.awk != null && this.awk.dxK != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.awk.dxK.videoMd5, "", str, this.dxm);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dxj.bmu();
    }

    public void ayn() {
        if (isPlaying()) {
            this.dxj.pausePlay();
        }
    }

    public boolean lo(int i) {
        return this.dxj.sb(i);
    }

    public void ayo() {
        this.dOF = false;
        this.dxj.stopPlay();
        if (this.dwX != null) {
            this.dwX.setVisibility(0);
        }
        if (this.dOK != null) {
            this.dOK.mv(2);
        }
        gN(false);
        this.dOE = true;
    }

    public void ayp() {
        if (this.dxj != null) {
            this.dxj.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        ayp();
        if (this.dxk != null) {
            this.dxk.ayC();
        }
        if (this.dOG != null) {
            this.dOG.clearAnimation();
        }
        if (this.dOB != null) {
            this.dOB.onDestroy();
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dxJ != null) {
            this.aBt.setText(TextUtils.isEmpty(gVar.dxJ.userNickname) ? gVar.dxJ.userName : gVar.dxJ.userNickname);
            if (!StringUtils.isNull(gVar.dxJ.portrait) && gVar.dxJ.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.coE.startLoad(gVar.dxJ.portrait, 10, false);
            } else {
                this.coE.startLoad(gVar.dxJ.portrait, 12, false);
            }
            if (gVar.dxJ.isBigV) {
                this.coE.setShowV(gVar.dxJ.isBigV);
                this.coE.setIsBigV(gVar.dxJ.isBigV);
            } else if (gVar.dxJ.isGod) {
                this.coE.setShowV(gVar.dxJ.isGod);
                this.coE.setIsBigV(gVar.dxJ.isGod);
            } else {
                this.coE.setShowV(gVar.dxJ.isGod);
                this.coE.setIsBigV(gVar.dxJ.isGod);
            }
            e(gVar);
            f(gVar);
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && this.dOB != null) {
            this.dOB.a(gVar);
        }
    }

    public void f(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aAb.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha70));
            this.aAc.setImageDrawable(getContext().getResources().getDrawable(e.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aAb.setText(ao.L(gVar.postNum));
            } else {
                this.aAb.setText(this.mContext.getString(e.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dxj != null && this.dwW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dxn) {
                this.dxj.bmt();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aDb();
            } else {
                configuration.orientation = 1;
                aDc();
                this.dxn = true;
            }
            this.dxj.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDb() {
        if (this.dxj != null && this.dwW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dwW.getParent() != null) {
                if (this.dwW.getParent() == frameLayout) {
                    frameLayout.removeView(this.dwW);
                } else if (this.dwW.getParent() == this.dwV) {
                    this.dwV.removeView(this.dwW);
                }
            }
            if (this.dwW.getParent() == null) {
                frameLayout.addView(this.dwW);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dwW.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dwW.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDc() {
        if (this.dxj != null && this.dwW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dwW.getParent() != null) {
                if (this.dwW.getParent() == frameLayout) {
                    frameLayout.removeView(this.dwW);
                } else if (this.dwW.getParent() == this.dwV) {
                    this.dwV.removeView(this.dwW);
                }
            }
            if (this.dwW.getParent() == null) {
                this.dwV.addView(this.dwW, 0);
                aDd();
                this.dxj.aUn();
            }
        }
    }

    private void aDd() {
        int i;
        if (!aCZ()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dwW.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (akm() != null) {
            view.setTag(this);
            akm().a(view, this.awk);
        }
        if (view == this.coE || view == this.aBt) {
            if (this.awk != null && this.awk.dxJ != null && !TextUtils.isEmpty(this.awk.dxJ.userId)) {
                this.dOK.mv(0);
                if (!TbadkCoreApplication.isLogin() || !this.awk.dxJ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.awk.dxJ.userId, 0L), z, this.awk.dxJ.isGod)));
            }
        } else if (view == this.aAd) {
            if (this.awk != null) {
                this.dOK.mv(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.awk.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dwX || view == this.dOA) {
            if (this.awk != null) {
                if (this.dOK.getCurrentState() != 2 && this.dOK.getCurrentState() != 3) {
                    z = false;
                }
                this.dOK.mv(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.awk.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.aAg) {
            this.dOK.mv(0);
            BW();
        } else if (view == this.dOG && this.dOG.getVisibility() == 0) {
            if (this.dOI != null) {
                this.dOI.mz(this.mPosition);
            }
        } else if (view == this.awi) {
            this.dOK.mv(0);
            this.awi.L(view);
        } else if (view == this.awj) {
            this.dOK.mv(0);
            this.awj.L(view);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gp(boolean z) {
        if (this.awk != null && this.awk.dxJ != null) {
            this.awk.dxJ.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ayq() {
        if (this.awk != null && this.awi != null) {
            this.awi.L(this.awi);
        }
    }

    public void gM(boolean z) {
        if (this.dwV != null) {
            this.dwV.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dOI = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.RT = fVar;
    }

    private void gN(boolean z) {
        this.dOE = this.mPosition == (this.dOJ == null ? -1 : this.dOJ.aDk());
        if (this.dOE && z && isPlaying() && this.aoz && !this.dOF) {
            this.dOC.setVisibility(0);
            this.dOF = true;
            this.dOC.postDelayed(this.dOO, 5000L);
            if (this.dOJ != null) {
                this.dOJ.bO(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dOC.setVisibility(8);
        if (this.dOO != null) {
            this.dOC.removeCallbacks(this.dOO);
        }
    }

    private void BW() {
        if (this.awk != null && this.mContext != null) {
            String valueOf = String.valueOf(this.awk.forumId);
            String str = this.awk.title;
            String str2 = this.awk.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.awk.dxK.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.awk.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(e.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aJs = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aJv = 3;
            dVar.fid = valueOf;
            dVar.aJo = "";
            dVar.tid = str2;
            dVar.aJk = true;
            dVar.aJu = 0;
            dVar.aJw = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aJv);
            bundle.putInt("obj_type", dVar.aJw);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.amC);
            dVar.f(bundle);
            com.baidu.tieba.c.e.amB().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        ayo();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        ayn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0160a {
        private Runnable dOR;
        private int mCurrentState;

        private C0160a() {
            this.mCurrentState = -1;
            this.dOR = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jt().removeCallbacks(C0160a.this.dOR);
                    C0160a.this.mv(2);
                }
            };
        }

        public void mv(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = mw(i);
                    aDe();
                    return;
                case 1:
                    this.mCurrentState = mw(i);
                    com.baidu.adp.lib.g.e.jt().removeCallbacks(this.dOR);
                    return;
                case 2:
                    this.mCurrentState = mx(i);
                    return;
                case 3:
                    this.mCurrentState = my(i);
                    aDe();
                    return;
                default:
                    this.mCurrentState = mx(i);
                    return;
            }
        }

        private void aDe() {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.dOR);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.dOR, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int mw(int i) {
            if (i != this.mCurrentState) {
                a.this.dOH.setVisibility(8);
                a.this.gO(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int mx(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.dOH.setVisibility(0);
                if (i2 != 3 || a.this.awk.autoPlay) {
                    a.this.gO(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int my(int i) {
            if (i != this.mCurrentState) {
                a.this.dOH.setVisibility(0);
                a.this.gO(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
