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
import com.baidu.tieba.frs.view.SpannableClickTextView;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i {
    private com.baidu.tieba.lego.card.view.f St;
    protected VideoAggregationPraiseView aFM;
    protected VideoAggregationDisPraiseView aFN;
    public com.baidu.tieba.frs.aggregation.g aFO;
    private TextView aJD;
    private ImageView aJE;
    private View aJF;
    private ImageView aJH;
    private View aJI;
    public TextView aKU;
    private String arK;
    private boolean ayi;
    private Animation bOT;
    private n bPe;
    public HeadImageView cDU;
    private boolean dQA;
    private boolean dQB;
    private Animation dQD;
    private boolean dQF;
    public FrameLayout dQi;
    public FrameLayout dQj;
    public com.baidu.tieba.play.c dQw;
    private h dQx;
    private z dQy;
    private z dQz;
    public SpannableClickTextView ehJ;
    private View ehK;
    protected com.baidu.tbadk.core.view.c ehL;
    private FrameLayout ehM;
    private TextView ehN;
    private boolean ehO;
    private boolean ehP;
    private View ehQ;
    private View ehR;
    private b ehS;
    public com.baidu.tieba.frs.videomiddlepage.controller.a ehT;
    private C0230a ehU;
    private VideoNetworkStateTipView ehV;
    private Animation.AnimationListener ehW;
    private Animation.AnimationListener ehX;
    private Runnable ehY;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dQA = true;
        this.dQF = true;
        this.ehO = false;
        this.ehP = false;
        this.ehW = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ehQ != null) {
                    a.this.ehQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ehQ != null) {
                    a.this.ehQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehX = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ehQ != null) {
                    a.this.ehQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ehQ != null) {
                    a.this.ehQ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehY = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ehM.getVisibility() == 0) {
                    a.this.ehM.setVisibility(8);
                }
            }
        };
        this.dQF = z;
        this.mFrom = str;
        this.arK = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dQi = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.ehK = view.findViewById(e.g.card_container);
        this.dQj = (FrameLayout) view.findViewById(e.g.video_container);
        this.dQw = new com.baidu.tieba.play.c(tbPageContext, (View) this.dQj, false);
        this.dQw.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.ehT != null && a.this.aFO.dQX.videoDuration > 8) {
                    a.this.ehT.Q(a.this.mPosition, a.this.aFO.dQX.videoUrl);
                }
            }
        });
        this.dQw.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // com.baidu.tieba.play.c.a
            public void hz(boolean z2) {
                if (a.this.ehU != null) {
                    if (z2) {
                        a.this.ehU.nP(0);
                    } else {
                        a.this.ehU.nP(1);
                    }
                }
            }
        });
        this.ehJ = (SpannableClickTextView) view.findViewById(e.g.title);
        this.cDU = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKU = (TextView) view.findViewById(e.g.user_name);
        this.aFM = (VideoAggregationPraiseView) view.findViewById(e.g.agree_view);
        this.aFN = (VideoAggregationDisPraiseView) view.findViewById(e.g.disagree_view);
        this.ehL = new com.baidu.tbadk.core.view.c(this.aFM, this.aFN);
        this.ehL.ES();
        this.ehL.h(tbPageContext.getUniqueId());
        this.aJD = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.aJE = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.aJF = view.findViewById(e.g.thread_info_commont_container);
        this.aJH = (ImageView) view.findViewById(e.g.share_num_img);
        this.aJI = view.findViewById(e.g.share_num_container);
        this.ehM = (FrameLayout) view.findViewById(e.g.download_nani_guide_container);
        this.ehN = (TextView) view.findViewById(e.g.download_nani_guide_txt);
        this.ehM.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ehN.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.ehN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Es().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.ehV = (VideoNetworkStateTipView) view.findViewById(e.g.network_state_tip);
        this.ehV.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.ehV.setHasAgreeToPlay(true);
                a.this.dQw.my(false);
                a.this.ehV.aJd();
                if (a.this.aFO != null && a.this.aFO.dQX != null) {
                    a.this.dQw.ba(a.this.aFO.dQX.videoUrl, a.this.aFO.threadId);
                }
            }
        });
        this.ehQ = view.findViewById(e.g.video_agg_container_foreground);
        this.ehR = view.findViewById(e.g.title_and_comment_container_foreground);
        this.ehQ.setOnClickListener(this);
        this.aFM.setOnClickListener(this);
        this.aFN.setOnClickListener(this);
        this.aJF.setOnClickListener(this);
        this.aJI.setOnClickListener(this);
        this.ehJ.setOnClickListener(this);
        this.cDU.setOnClickListener(this);
        this.aKU.setOnClickListener(this);
        this.ehK.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQi.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dQi.setLayoutParams(layoutParams);
        this.cDU.setIsRound(true);
        this.bPe = new n(tbPageContext.getPageActivity());
        this.dQx = new h(this.mPageContext, this);
        this.dQD = new AlphaAnimation(0.0f, 0.7f);
        this.dQD.setDuration(500L);
        this.dQD.setAnimationListener(this.ehX);
        this.bOT = new AlphaAnimation(0.7f, 0.0f);
        this.bOT.setDuration(500L);
        this.bOT.setAnimationListener(this.ehW);
        this.ehU = new C0230a();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.ehL != null) {
            this.ehL.onChangeSkinType(i);
        }
        this.aJD.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.aJE.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_comment_background));
        this.aJH.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_share_background));
        this.ehJ.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
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
        if (gVar != null && gVar.dQX != null) {
            this.aFO = gVar;
            this.ayi = this.aFO.autoPlay;
            this.ehP = false;
            hx(false);
            this.ehJ.setVisibility(0);
            if (gVar.dQX != null && !StringUtils.isNull(gVar.dQX.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.a.a.a(this.mContext, this.ehJ, gVar.title, gVar.dQX.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ehJ.setText(gVar.title);
            }
            aIO();
            b(gVar, i, aVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aIN() {
        try {
            int parseInt = Integer.parseInt(this.aFO.dQX.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.aFO.dQX.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aIO() {
        if (!aIN()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQi.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dQi.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dQi.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dQi.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dQX != null) {
            this.dQw.stopPlay();
            this.dQw.setIsNeedRecoveryVideoPlayer(true);
            this.dQw.mz(true);
            this.dQw.mv(true);
            this.dQw.mA(true);
            this.dQw.S(false, false);
            this.dQw.tD(i);
            this.dQw.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                    a.this.aIP();
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                    a.this.aIQ();
                    if (a.this.dQw.bsq()) {
                    }
                    if (a.this.dQB) {
                        a.this.dQw.stopPlay();
                    }
                }
            });
            this.dQw.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.l
                public void aEg() {
                    if (a.this.aFO != null && a.this.aFO.dQX != null && com.baidu.adp.lib.g.b.l(a.this.aFO.dQX.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.aFO.dQX.videoWidth, 0)) {
                        a.this.dQw.S(false, false);
                    } else {
                        a.this.dQw.S(true, false);
                    }
                    a.this.dQB = false;
                    a.this.oz(a.this.ayi ? "1" : "2");
                    a.this.onClick(a.this.dQj);
                    if (a.this.St != null) {
                        a.this.St.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void aEh() {
                    a.this.onClick(a.this.dQi);
                }
            });
            this.dQw.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.c.f
                public void gZ(boolean z) {
                    a.this.dQw.ba(a.this.aFO.dQX.videoUrl, a.this.aFO.threadId);
                    a.this.oz("2");
                    a.this.onClick(a.this.dQj);
                }
            });
            this.dQw.ms(false);
            this.dQy = new z();
            this.dQy.bjn = gVar.threadId;
            this.dQy.dbs = gVar.forumId;
            this.dQy.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dQy.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dQy.mSource = gVar.source;
            this.dQy.gIJ = gVar.weight;
            this.dQy.gIL = this.mFrom;
            this.dQy.gIM = gVar.abtest_tag;
            this.dQy.arK = this.arK;
            this.dQy.mExtra = gVar.extra;
            this.dQy.gIP = "0";
            this.dQz = new z();
            this.dQz.bjn = gVar.threadId;
            this.dQz.dbs = gVar.forumId;
            this.dQz.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dQz.gIJ = "auto_midpage";
            this.dQz.mLocate = "auto_midpage";
            this.dQz.gIL = this.mFrom;
            this.dQz.mSource = gVar.source;
            this.dQz.gIP = "0";
            if (gVar.dQX != null) {
                this.dQy.gIN = gVar.dQX.videoMd5;
                this.dQz.gIN = gVar.dQX.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.aB("tid", gVar.threadId);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.y("obj_locate", i);
            amVar.y("obj_param2", 1);
            amVar.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.aB("obj_param1", ao.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.aB("extra", ao.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.arK);
            amVar.aB("ab_tag", ao.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.aB("obj_type", this.mFrom);
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.aFO.source) ? "0" : this.aFO.source);
            amVar.y("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.bPe.setVideoStatsData(this.dQy);
            this.dQw.getVideoView().setBusiness(this.bPe);
            this.bPe.a(gVar);
            this.dQw.bac();
            this.dQw.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dQB = true;
                        a.this.dQA = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.mH(i);
                        a.this.dQw.aNk();
                    }
                }
            });
            this.dQw.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.aFO != null && a.this.aFO.dQX != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.aFO.dQX.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dQw.setThumbnail(gVar.dQX.thumbnailUrl);
            this.dQw.setVideoUrl(gVar.dQX.videoUrl, gVar.threadId);
            this.dQw.setFid(gVar.forumId);
            this.dQw.aNk();
            this.dQw.show();
            hx(false);
            if (gVar.autoPlay) {
                onClick(this.dQj);
                if (this.ehV.aJb()) {
                    this.dQw.mx(false);
                    this.ehV.aJc();
                    this.dQw.my(true);
                    this.dQw.cs(gVar.dQX.videoUrl, gVar.threadId);
                } else {
                    this.dQw.my(false);
                    this.dQw.mx(false);
                    this.ehV.hide();
                    this.dQw.a(gVar.dQX.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                }
                if (i == 0 && gVar.dQY) {
                    this.ehQ.setVisibility(8);
                    this.ehU.nP(3);
                } else {
                    if (this.ehQ.getVisibility() == 0) {
                        this.ehQ.startAnimation(this.bOT);
                    }
                    this.ehU.nP(0);
                }
                gVar.dQY = false;
            } else {
                this.ehQ.setVisibility(0);
                this.ehV.hide();
                this.dQw.mx(true);
                this.ehU.nP(3);
                this.dQw.cs(gVar.dQX.videoUrl, gVar.threadId);
            }
            this.dQB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(String str) {
        if (this.aFO != null && this.aFO.dQX != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFO.dQX.videoMd5, "", str, this.dQz);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dQw.bsq();
    }

    public void aEc() {
        if (isPlaying()) {
            this.dQw.pausePlay();
        }
    }

    public boolean mI(int i) {
        return this.dQw.tC(i);
    }

    public void aEd() {
        this.ehP = false;
        this.dQw.stopPlay();
        if (this.ehJ != null) {
            this.ehJ.setVisibility(0);
        }
        if (this.ehU != null) {
            this.ehU.nP(2);
        }
        hx(false);
        this.ehO = true;
    }

    public void aEe() {
        if (this.dQw != null) {
            this.dQw.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aEe();
        if (this.dQx != null) {
            this.dQx.aEp();
        }
        if (this.ehQ != null) {
            this.ehQ.clearAnimation();
        }
        if (this.ehL != null) {
            this.ehL.onDestroy();
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dQW != null) {
            this.aKU.setText(TextUtils.isEmpty(gVar.dQW.userNickname) ? gVar.dQW.userName : gVar.dQW.userNickname);
            if (!StringUtils.isNull(gVar.dQW.portrait) && gVar.dQW.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.cDU.startLoad(gVar.dQW.portrait, 10, false);
            } else {
                this.cDU.startLoad(gVar.dQW.portrait, 12, false);
            }
            if (gVar.dQW.isBigV) {
                this.cDU.setShowV(gVar.dQW.isBigV);
                this.cDU.setIsBigV(gVar.dQW.isBigV);
            } else if (gVar.dQW.isGod) {
                this.cDU.setShowV(gVar.dQW.isGod);
                this.cDU.setIsBigV(gVar.dQW.isGod);
            } else {
                this.cDU.setShowV(gVar.dQW.isGod);
                this.cDU.setIsBigV(gVar.dQW.isGod);
            }
            e(gVar);
            f(gVar);
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && this.ehL != null) {
            this.ehL.a(gVar);
        }
    }

    public void f(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aJD.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha70));
            this.aJE.setImageDrawable(getContext().getResources().getDrawable(e.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aJD.setText(ao.X(gVar.postNum));
            } else {
                this.aJD.setText(this.mContext.getString(e.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dQw != null && this.dQj != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dQA) {
                this.dQw.bsp();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aIP();
            } else {
                configuration.orientation = 1;
                aIQ();
                this.dQA = true;
            }
            this.dQw.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIP() {
        if (this.dQw != null && this.dQj != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dQj.getParent() != null) {
                if (this.dQj.getParent() == frameLayout) {
                    frameLayout.removeView(this.dQj);
                } else if (this.dQj.getParent() == this.dQi) {
                    this.dQi.removeView(this.dQj);
                }
            }
            if (this.dQj.getParent() == null) {
                frameLayout.addView(this.dQj);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dQj.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dQj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIQ() {
        if (this.dQw != null && this.dQj != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dQj.getParent() != null) {
                if (this.dQj.getParent() == frameLayout) {
                    frameLayout.removeView(this.dQj);
                } else if (this.dQj.getParent() == this.dQi) {
                    this.dQi.removeView(this.dQj);
                }
            }
            if (this.dQj.getParent() == null) {
                this.dQi.addView(this.dQj, 0);
                aIR();
                this.dQw.bac();
            }
        }
    }

    private void aIR() {
        int i;
        if (!aIN()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dQj.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aqp() != null) {
            view.setTag(this);
            aqp().a(view, this.aFO);
        }
        if (view == this.cDU || view == this.aKU) {
            if (this.aFO != null && this.aFO.dQW != null && !TextUtils.isEmpty(this.aFO.dQW.userId)) {
                this.ehU.nP(0);
                if (!TbadkCoreApplication.isLogin() || !this.aFO.dQW.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFO.dQW.userId, 0L), z, this.aFO.dQW.isGod)));
            }
        } else if (view == this.aJF) {
            if (this.aFO != null) {
                this.ehU.nP(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFO.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.ehJ || view == this.ehK) {
            if (this.aFO != null) {
                if (this.ehU.getCurrentState() != 2 && this.ehU.getCurrentState() != 3) {
                    z = false;
                }
                this.ehU.nP(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.aFO.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.aJI) {
            this.ehU.nP(0);
            FD();
        } else if (view == this.ehQ && this.ehQ.getVisibility() == 0) {
            if (this.ehS != null) {
                this.ehS.nT(this.mPosition);
            }
        } else if (view == this.aFM) {
            this.ehU.nP(0);
            this.aFM.L(view);
        } else if (view == this.aFN) {
            this.ehU.nP(0);
            this.aFN.L(view);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gY(boolean z) {
        if (this.aFO != null && this.aFO.dQW != null) {
            this.aFO.dQW.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aEf() {
        if (this.aFO != null && this.aFM != null) {
            this.aFM.L(this.aFM);
        }
    }

    public void hw(boolean z) {
        if (this.dQi != null) {
            this.dQi.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.ehS = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.St = fVar;
    }

    private void hx(boolean z) {
        this.ehO = this.mPosition == (this.ehT == null ? -1 : this.ehT.aIZ());
        if (this.ehO && z && isPlaying() && this.ayi && !this.ehP) {
            this.ehM.setVisibility(0);
            this.ehP = true;
            this.ehM.postDelayed(this.ehY, 5000L);
            if (this.ehT != null) {
                this.ehT.cc(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ehM.setVisibility(8);
        if (this.ehY != null) {
            this.ehM.removeCallbacks(this.ehY);
        }
    }

    private void FD() {
        if (this.aFO != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFO.forumId);
            String str = this.aFO.title;
            String str2 = this.aFO.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.aFO.dQX.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.aFO.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(e.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aSR = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aSU = 3;
            dVar.fid = valueOf;
            dVar.aSM = "";
            dVar.tid = str2;
            dVar.aSI = true;
            dVar.aST = 0;
            dVar.aSV = 2;
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
            bundle.putInt("obj_param1", dVar.aSU);
            bundle.putInt("obj_type", dVar.aSV);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.awo);
            dVar.k(bundle);
            com.baidu.tieba.c.e.asB().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aEd();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        aEc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(boolean z) {
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

    public boolean aIS() {
        if (this.ehU != null) {
            return this.ehU.getCurrentState() == 2 || this.ehU.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0230a {
        private Runnable eib;
        private int mCurrentState;

        private C0230a() {
            this.mCurrentState = -1;
            this.eib = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(C0230a.this.eib);
                    C0230a.this.nP(2);
                }
            };
        }

        public void nP(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = nQ(i);
                    aIT();
                    return;
                case 1:
                    this.mCurrentState = nQ(i);
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eib);
                    return;
                case 2:
                    this.mCurrentState = nR(i);
                    return;
                case 3:
                    this.mCurrentState = nS(i);
                    aIT();
                    return;
                default:
                    this.mCurrentState = nR(i);
                    return;
            }
        }

        private void aIT() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eib);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eib, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int nQ(int i) {
            if (i != this.mCurrentState) {
                a.this.ehR.setVisibility(8);
                a.this.hy(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int nR(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.ehR.setVisibility(0);
                if (i2 != 3 || a.this.aFO.autoPlay) {
                    a.this.hy(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int nS(int i) {
            if (i != this.mCurrentState) {
                a.this.ehR.setVisibility(0);
                a.this.hy(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
