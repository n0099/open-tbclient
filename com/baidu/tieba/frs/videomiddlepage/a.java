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
    protected VideoAggregationPraiseView aFL;
    protected VideoAggregationDisPraiseView aFM;
    public com.baidu.tieba.frs.aggregation.g aFN;
    private TextView aJC;
    private ImageView aJD;
    private View aJE;
    private ImageView aJG;
    private View aJH;
    public TextView aKT;
    private String arJ;
    private boolean ayh;
    private Animation bOS;
    private n bPd;
    public HeadImageView cDT;
    private boolean dQA;
    private Animation dQC;
    private boolean dQE;
    public FrameLayout dQh;
    public FrameLayout dQi;
    public com.baidu.tieba.play.c dQv;
    private h dQw;
    private z dQx;
    private z dQy;
    private boolean dQz;
    public SpannableClickTextView ehI;
    private View ehJ;
    protected com.baidu.tbadk.core.view.c ehK;
    private FrameLayout ehL;
    private TextView ehM;
    private boolean ehN;
    private boolean ehO;
    private View ehP;
    private View ehQ;
    private b ehR;
    public com.baidu.tieba.frs.videomiddlepage.controller.a ehS;
    private C0230a ehT;
    private VideoNetworkStateTipView ehU;
    private Animation.AnimationListener ehV;
    private Animation.AnimationListener ehW;
    private Runnable ehX;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dQz = true;
        this.dQE = true;
        this.ehN = false;
        this.ehO = false;
        this.ehV = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ehP != null) {
                    a.this.ehP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ehP != null) {
                    a.this.ehP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehW = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ehP != null) {
                    a.this.ehP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ehP != null) {
                    a.this.ehP.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehX = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ehL.getVisibility() == 0) {
                    a.this.ehL.setVisibility(8);
                }
            }
        };
        this.dQE = z;
        this.mFrom = str;
        this.arJ = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dQh = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.ehJ = view.findViewById(e.g.card_container);
        this.dQi = (FrameLayout) view.findViewById(e.g.video_container);
        this.dQv = new com.baidu.tieba.play.c(tbPageContext, (View) this.dQi, false);
        this.dQv.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.ehS != null && a.this.aFN.dQW.videoDuration > 8) {
                    a.this.ehS.Q(a.this.mPosition, a.this.aFN.dQW.videoUrl);
                }
            }
        });
        this.dQv.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // com.baidu.tieba.play.c.a
            public void hz(boolean z2) {
                if (a.this.ehT != null) {
                    if (z2) {
                        a.this.ehT.nP(0);
                    } else {
                        a.this.ehT.nP(1);
                    }
                }
            }
        });
        this.ehI = (SpannableClickTextView) view.findViewById(e.g.title);
        this.cDT = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKT = (TextView) view.findViewById(e.g.user_name);
        this.aFL = (VideoAggregationPraiseView) view.findViewById(e.g.agree_view);
        this.aFM = (VideoAggregationDisPraiseView) view.findViewById(e.g.disagree_view);
        this.ehK = new com.baidu.tbadk.core.view.c(this.aFL, this.aFM);
        this.ehK.ES();
        this.ehK.h(tbPageContext.getUniqueId());
        this.aJC = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.aJD = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.aJE = view.findViewById(e.g.thread_info_commont_container);
        this.aJG = (ImageView) view.findViewById(e.g.share_num_img);
        this.aJH = view.findViewById(e.g.share_num_container);
        this.ehL = (FrameLayout) view.findViewById(e.g.download_nani_guide_container);
        this.ehM = (TextView) view.findViewById(e.g.download_nani_guide_txt);
        this.ehL.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ehM.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.ehM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Es().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.ehU = (VideoNetworkStateTipView) view.findViewById(e.g.network_state_tip);
        this.ehU.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.ehU.setHasAgreeToPlay(true);
                a.this.dQv.my(false);
                a.this.ehU.aJd();
                if (a.this.aFN != null && a.this.aFN.dQW != null) {
                    a.this.dQv.ba(a.this.aFN.dQW.videoUrl, a.this.aFN.threadId);
                }
            }
        });
        this.ehP = view.findViewById(e.g.video_agg_container_foreground);
        this.ehQ = view.findViewById(e.g.title_and_comment_container_foreground);
        this.ehP.setOnClickListener(this);
        this.aFL.setOnClickListener(this);
        this.aFM.setOnClickListener(this);
        this.aJE.setOnClickListener(this);
        this.aJH.setOnClickListener(this);
        this.ehI.setOnClickListener(this);
        this.cDT.setOnClickListener(this);
        this.aKT.setOnClickListener(this);
        this.ehJ.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQh.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dQh.setLayoutParams(layoutParams);
        this.cDT.setIsRound(true);
        this.bPd = new n(tbPageContext.getPageActivity());
        this.dQw = new h(this.mPageContext, this);
        this.dQC = new AlphaAnimation(0.0f, 0.7f);
        this.dQC.setDuration(500L);
        this.dQC.setAnimationListener(this.ehW);
        this.bOS = new AlphaAnimation(0.7f, 0.0f);
        this.bOS.setDuration(500L);
        this.bOS.setAnimationListener(this.ehV);
        this.ehT = new C0230a();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.ehK != null) {
            this.ehK.onChangeSkinType(i);
        }
        this.aJC.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.aJD.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_comment_background));
        this.aJG.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_share_background));
        this.ehI.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
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
        if (gVar != null && gVar.dQW != null) {
            this.aFN = gVar;
            this.ayh = this.aFN.autoPlay;
            this.ehO = false;
            hx(false);
            this.ehI.setVisibility(0);
            if (gVar.dQW != null && !StringUtils.isNull(gVar.dQW.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.a.a.a(this.mContext, this.ehI, gVar.title, gVar.dQW.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ehI.setText(gVar.title);
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
            int parseInt = Integer.parseInt(this.aFN.dQW.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.aFN.dQW.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aIO() {
        if (!aIN()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQh.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dQh.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dQh.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dQh.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dQW != null) {
            this.dQv.stopPlay();
            this.dQv.setIsNeedRecoveryVideoPlayer(true);
            this.dQv.mz(true);
            this.dQv.mv(true);
            this.dQv.mA(true);
            this.dQv.S(false, false);
            this.dQv.tD(i);
            this.dQv.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                    a.this.aIP();
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                    a.this.aIQ();
                    if (a.this.dQv.bsq()) {
                    }
                    if (a.this.dQA) {
                        a.this.dQv.stopPlay();
                    }
                }
            });
            this.dQv.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.l
                public void aEg() {
                    if (a.this.aFN != null && a.this.aFN.dQW != null && com.baidu.adp.lib.g.b.l(a.this.aFN.dQW.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.aFN.dQW.videoWidth, 0)) {
                        a.this.dQv.S(false, false);
                    } else {
                        a.this.dQv.S(true, false);
                    }
                    a.this.dQA = false;
                    a.this.oz(a.this.ayh ? "1" : "2");
                    a.this.onClick(a.this.dQi);
                    if (a.this.St != null) {
                        a.this.St.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void aEh() {
                    a.this.onClick(a.this.dQh);
                }
            });
            this.dQv.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.c.f
                public void gZ(boolean z) {
                    a.this.dQv.ba(a.this.aFN.dQW.videoUrl, a.this.aFN.threadId);
                    a.this.oz("2");
                    a.this.onClick(a.this.dQi);
                }
            });
            this.dQv.ms(false);
            this.dQx = new z();
            this.dQx.bjm = gVar.threadId;
            this.dQx.dbr = gVar.forumId;
            this.dQx.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dQx.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dQx.mSource = gVar.source;
            this.dQx.gII = gVar.weight;
            this.dQx.gIK = this.mFrom;
            this.dQx.gIL = gVar.abtest_tag;
            this.dQx.arJ = this.arJ;
            this.dQx.mExtra = gVar.extra;
            this.dQx.gIO = "0";
            this.dQy = new z();
            this.dQy.bjm = gVar.threadId;
            this.dQy.dbr = gVar.forumId;
            this.dQy.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dQy.gII = "auto_midpage";
            this.dQy.mLocate = "auto_midpage";
            this.dQy.gIK = this.mFrom;
            this.dQy.mSource = gVar.source;
            this.dQy.gIO = "0";
            if (gVar.dQW != null) {
                this.dQx.gIM = gVar.dQW.videoMd5;
                this.dQy.gIM = gVar.dQW.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.aB("tid", gVar.threadId);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.y("obj_locate", i);
            amVar.y("obj_param2", 1);
            amVar.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.aB("obj_param1", ao.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.aB("extra", ao.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.arJ);
            amVar.aB("ab_tag", ao.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.aB("obj_type", this.mFrom);
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.aFN.source) ? "0" : this.aFN.source);
            amVar.y("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.bPd.setVideoStatsData(this.dQx);
            this.dQv.getVideoView().setBusiness(this.bPd);
            this.bPd.a(gVar);
            this.dQv.bac();
            this.dQv.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dQA = true;
                        a.this.dQz = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.mH(i);
                        a.this.dQv.aNk();
                    }
                }
            });
            this.dQv.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.aFN != null && a.this.aFN.dQW != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.aFN.dQW.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dQv.setThumbnail(gVar.dQW.thumbnailUrl);
            this.dQv.setVideoUrl(gVar.dQW.videoUrl, gVar.threadId);
            this.dQv.setFid(gVar.forumId);
            this.dQv.aNk();
            this.dQv.show();
            hx(false);
            if (gVar.autoPlay) {
                onClick(this.dQi);
                if (this.ehU.aJb()) {
                    this.dQv.mx(false);
                    this.ehU.aJc();
                    this.dQv.my(true);
                    this.dQv.cs(gVar.dQW.videoUrl, gVar.threadId);
                } else {
                    this.dQv.my(false);
                    this.dQv.mx(false);
                    this.ehU.hide();
                    this.dQv.a(gVar.dQW.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                }
                if (i == 0 && gVar.dQX) {
                    this.ehP.setVisibility(8);
                    this.ehT.nP(3);
                } else {
                    if (this.ehP.getVisibility() == 0) {
                        this.ehP.startAnimation(this.bOS);
                    }
                    this.ehT.nP(0);
                }
                gVar.dQX = false;
            } else {
                this.ehP.setVisibility(0);
                this.ehU.hide();
                this.dQv.mx(true);
                this.ehT.nP(3);
                this.dQv.cs(gVar.dQW.videoUrl, gVar.threadId);
            }
            this.dQA = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(String str) {
        if (this.aFN != null && this.aFN.dQW != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFN.dQW.videoMd5, "", str, this.dQy);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dQv.bsq();
    }

    public void aEc() {
        if (isPlaying()) {
            this.dQv.pausePlay();
        }
    }

    public boolean mI(int i) {
        return this.dQv.tC(i);
    }

    public void aEd() {
        this.ehO = false;
        this.dQv.stopPlay();
        if (this.ehI != null) {
            this.ehI.setVisibility(0);
        }
        if (this.ehT != null) {
            this.ehT.nP(2);
        }
        hx(false);
        this.ehN = true;
    }

    public void aEe() {
        if (this.dQv != null) {
            this.dQv.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aEe();
        if (this.dQw != null) {
            this.dQw.aEp();
        }
        if (this.ehP != null) {
            this.ehP.clearAnimation();
        }
        if (this.ehK != null) {
            this.ehK.onDestroy();
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dQV != null) {
            this.aKT.setText(TextUtils.isEmpty(gVar.dQV.userNickname) ? gVar.dQV.userName : gVar.dQV.userNickname);
            if (!StringUtils.isNull(gVar.dQV.portrait) && gVar.dQV.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.cDT.startLoad(gVar.dQV.portrait, 10, false);
            } else {
                this.cDT.startLoad(gVar.dQV.portrait, 12, false);
            }
            if (gVar.dQV.isBigV) {
                this.cDT.setShowV(gVar.dQV.isBigV);
                this.cDT.setIsBigV(gVar.dQV.isBigV);
            } else if (gVar.dQV.isGod) {
                this.cDT.setShowV(gVar.dQV.isGod);
                this.cDT.setIsBigV(gVar.dQV.isGod);
            } else {
                this.cDT.setShowV(gVar.dQV.isGod);
                this.cDT.setIsBigV(gVar.dQV.isGod);
            }
            e(gVar);
            f(gVar);
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && this.ehK != null) {
            this.ehK.a(gVar);
        }
    }

    public void f(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aJC.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha70));
            this.aJD.setImageDrawable(getContext().getResources().getDrawable(e.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aJC.setText(ao.X(gVar.postNum));
            } else {
                this.aJC.setText(this.mContext.getString(e.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dQv != null && this.dQi != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dQz) {
                this.dQv.bsp();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aIP();
            } else {
                configuration.orientation = 1;
                aIQ();
                this.dQz = true;
            }
            this.dQv.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIP() {
        if (this.dQv != null && this.dQi != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dQi.getParent() != null) {
                if (this.dQi.getParent() == frameLayout) {
                    frameLayout.removeView(this.dQi);
                } else if (this.dQi.getParent() == this.dQh) {
                    this.dQh.removeView(this.dQi);
                }
            }
            if (this.dQi.getParent() == null) {
                frameLayout.addView(this.dQi);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dQi.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dQi.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIQ() {
        if (this.dQv != null && this.dQi != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dQi.getParent() != null) {
                if (this.dQi.getParent() == frameLayout) {
                    frameLayout.removeView(this.dQi);
                } else if (this.dQi.getParent() == this.dQh) {
                    this.dQh.removeView(this.dQi);
                }
            }
            if (this.dQi.getParent() == null) {
                this.dQh.addView(this.dQi, 0);
                aIR();
                this.dQv.bac();
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
            this.dQi.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aqp() != null) {
            view.setTag(this);
            aqp().a(view, this.aFN);
        }
        if (view == this.cDT || view == this.aKT) {
            if (this.aFN != null && this.aFN.dQV != null && !TextUtils.isEmpty(this.aFN.dQV.userId)) {
                this.ehT.nP(0);
                if (!TbadkCoreApplication.isLogin() || !this.aFN.dQV.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFN.dQV.userId, 0L), z, this.aFN.dQV.isGod)));
            }
        } else if (view == this.aJE) {
            if (this.aFN != null) {
                this.ehT.nP(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFN.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.ehI || view == this.ehJ) {
            if (this.aFN != null) {
                if (this.ehT.getCurrentState() != 2 && this.ehT.getCurrentState() != 3) {
                    z = false;
                }
                this.ehT.nP(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.aFN.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.aJH) {
            this.ehT.nP(0);
            FD();
        } else if (view == this.ehP && this.ehP.getVisibility() == 0) {
            if (this.ehR != null) {
                this.ehR.nT(this.mPosition);
            }
        } else if (view == this.aFL) {
            this.ehT.nP(0);
            this.aFL.L(view);
        } else if (view == this.aFM) {
            this.ehT.nP(0);
            this.aFM.L(view);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gY(boolean z) {
        if (this.aFN != null && this.aFN.dQV != null) {
            this.aFN.dQV.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aEf() {
        if (this.aFN != null && this.aFL != null) {
            this.aFL.L(this.aFL);
        }
    }

    public void hw(boolean z) {
        if (this.dQh != null) {
            this.dQh.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.ehR = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.St = fVar;
    }

    private void hx(boolean z) {
        this.ehN = this.mPosition == (this.ehS == null ? -1 : this.ehS.aIZ());
        if (this.ehN && z && isPlaying() && this.ayh && !this.ehO) {
            this.ehL.setVisibility(0);
            this.ehO = true;
            this.ehL.postDelayed(this.ehX, 5000L);
            if (this.ehS != null) {
                this.ehS.cc(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ehL.setVisibility(8);
        if (this.ehX != null) {
            this.ehL.removeCallbacks(this.ehX);
        }
    }

    private void FD() {
        if (this.aFN != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFN.forumId);
            String str = this.aFN.title;
            String str2 = this.aFN.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.aFN.dQW.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.aFN.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(e.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aSQ = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aST = 3;
            dVar.fid = valueOf;
            dVar.aSL = "";
            dVar.tid = str2;
            dVar.aSH = true;
            dVar.aSS = 0;
            dVar.aSU = 2;
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
            bundle.putInt("obj_param1", dVar.aST);
            bundle.putInt("obj_type", dVar.aSU);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.awn);
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
        if (this.ehT != null) {
            return this.ehT.getCurrentState() == 2 || this.ehT.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0230a {
        private Runnable eia;
        private int mCurrentState;

        private C0230a() {
            this.mCurrentState = -1;
            this.eia = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(C0230a.this.eia);
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
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eia);
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
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eia);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eia, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int nQ(int i) {
            if (i != this.mCurrentState) {
                a.this.ehQ.setVisibility(8);
                a.this.hy(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int nR(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.ehQ.setVisibility(0);
                if (i2 != 3 || a.this.aFN.autoPlay) {
                    a.this.hy(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int nS(int i) {
            if (i != this.mCurrentState) {
                a.this.ehQ.setVisibility(0);
                a.this.hy(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
