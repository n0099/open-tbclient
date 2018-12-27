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
    private com.baidu.tieba.lego.card.view.f Sk;
    protected VideoAggregationPraiseView aFj;
    protected VideoAggregationDisPraiseView aFk;
    public com.baidu.tieba.frs.aggregation.g aFl;
    private TextView aJa;
    private ImageView aJb;
    private View aJc;
    private ImageView aJe;
    private View aJf;
    public TextView aKr;
    private String arh;
    private boolean axF;
    private Animation bOg;
    private n bOs;
    public HeadImageView cDi;
    public com.baidu.tieba.play.c dPM;
    private h dPN;
    private z dPO;
    private z dPP;
    private boolean dPQ;
    private boolean dPR;
    private Animation dPT;
    private boolean dPV;
    public FrameLayout dPy;
    public FrameLayout dPz;
    public SpannableClickTextView ehc;
    private View ehd;
    protected com.baidu.tbadk.core.view.c ehe;
    private FrameLayout ehf;
    private TextView ehg;
    private boolean ehh;
    private boolean ehi;
    private View ehj;
    private View ehk;
    private b ehl;
    public com.baidu.tieba.frs.videomiddlepage.controller.a ehm;
    private C0230a ehn;
    private VideoNetworkStateTipView eho;
    private Animation.AnimationListener ehp;
    private Animation.AnimationListener ehq;
    private Runnable ehr;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dPQ = true;
        this.dPV = true;
        this.ehh = false;
        this.ehi = false;
        this.ehp = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ehj != null) {
                    a.this.ehj.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ehj != null) {
                    a.this.ehj.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehq = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ehj != null) {
                    a.this.ehj.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ehj != null) {
                    a.this.ehj.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehr = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ehf.getVisibility() == 0) {
                    a.this.ehf.setVisibility(8);
                }
            }
        };
        this.dPV = z;
        this.mFrom = str;
        this.arh = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dPy = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.ehd = view.findViewById(e.g.card_container);
        this.dPz = (FrameLayout) view.findViewById(e.g.video_container);
        this.dPM = new com.baidu.tieba.play.c(tbPageContext, (View) this.dPz, false);
        this.dPM.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.ehm != null && a.this.aFl.dQn.videoDuration > 8) {
                    a.this.ehm.O(a.this.mPosition, a.this.aFl.dQn.videoUrl);
                }
            }
        });
        this.dPM.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // com.baidu.tieba.play.c.a
            public void hw(boolean z2) {
                if (a.this.ehn != null) {
                    if (z2) {
                        a.this.ehn.nO(0);
                    } else {
                        a.this.ehn.nO(1);
                    }
                }
            }
        });
        this.ehc = (SpannableClickTextView) view.findViewById(e.g.title);
        this.cDi = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKr = (TextView) view.findViewById(e.g.user_name);
        this.aFj = (VideoAggregationPraiseView) view.findViewById(e.g.agree_view);
        this.aFk = (VideoAggregationDisPraiseView) view.findViewById(e.g.disagree_view);
        this.ehe = new com.baidu.tbadk.core.view.c(this.aFj, this.aFk);
        this.ehe.EF();
        this.ehe.h(tbPageContext.getUniqueId());
        this.aJa = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.aJb = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.aJc = view.findViewById(e.g.thread_info_commont_container);
        this.aJe = (ImageView) view.findViewById(e.g.share_num_img);
        this.aJf = view.findViewById(e.g.share_num_container);
        this.ehf = (FrameLayout) view.findViewById(e.g.download_nani_guide_container);
        this.ehg = (TextView) view.findViewById(e.g.download_nani_guide_txt);
        this.ehf.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ehg.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.ehg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Ef().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.eho = (VideoNetworkStateTipView) view.findViewById(e.g.network_state_tip);
        this.eho.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.eho.setHasAgreeToPlay(true);
                a.this.dPM.my(false);
                a.this.eho.aIF();
                if (a.this.aFl != null && a.this.aFl.dQn != null) {
                    a.this.dPM.aZ(a.this.aFl.dQn.videoUrl, a.this.aFl.threadId);
                }
            }
        });
        this.ehj = view.findViewById(e.g.video_agg_container_foreground);
        this.ehk = view.findViewById(e.g.title_and_comment_container_foreground);
        this.ehj.setOnClickListener(this);
        this.aFj.setOnClickListener(this);
        this.aFk.setOnClickListener(this);
        this.aJc.setOnClickListener(this);
        this.aJf.setOnClickListener(this);
        this.ehc.setOnClickListener(this);
        this.cDi.setOnClickListener(this);
        this.aKr.setOnClickListener(this);
        this.ehd.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dPy.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dPy.setLayoutParams(layoutParams);
        this.cDi.setIsRound(true);
        this.bOs = new n(tbPageContext.getPageActivity());
        this.dPN = new h(this.mPageContext, this);
        this.dPT = new AlphaAnimation(0.0f, 0.7f);
        this.dPT.setDuration(500L);
        this.dPT.setAnimationListener(this.ehq);
        this.bOg = new AlphaAnimation(0.7f, 0.0f);
        this.bOg.setDuration(500L);
        this.bOg.setAnimationListener(this.ehp);
        this.ehn = new C0230a();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.ehe != null) {
            this.ehe.onChangeSkinType(i);
        }
        this.aJa.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        this.aJb.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_comment_background));
        this.aJe.setImageDrawable(tbPageContext.getResources().getDrawable(e.f.video_share_background));
        this.ehc.setTextColor(tbPageContext.getResources().getColor(e.d.cp_cont_i_alpha70));
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
        if (gVar != null && gVar.dQn != null) {
            this.aFl = gVar;
            this.axF = this.aFl.autoPlay;
            this.ehi = false;
            hu(false);
            this.ehc.setVisibility(0);
            if (gVar.dQn != null && !StringUtils.isNull(gVar.dQn.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.a.a.a(this.mContext, this.ehc, gVar.title, gVar.dQn.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ehc.setText(gVar.title);
            }
            aIr();
            b(gVar, i, aVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aIq() {
        try {
            int parseInt = Integer.parseInt(this.aFl.dQn.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.aFl.dQn.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aIr() {
        if (!aIq()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dPy.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dPy.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dPy.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dPy.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dQn != null) {
            this.dPM.stopPlay();
            this.dPM.setIsNeedRecoveryVideoPlayer(true);
            this.dPM.mz(true);
            this.dPM.mv(true);
            this.dPM.mA(true);
            this.dPM.S(false, false);
            this.dPM.tz(i);
            this.dPM.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YS() {
                    a.this.aIs();
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YT() {
                    a.this.aIt();
                    if (a.this.dPM.brH()) {
                    }
                    if (a.this.dPR) {
                        a.this.dPM.stopPlay();
                    }
                }
            });
            this.dPM.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.l
                public void aDJ() {
                    if (a.this.aFl != null && a.this.aFl.dQn != null && com.baidu.adp.lib.g.b.l(a.this.aFl.dQn.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.aFl.dQn.videoWidth, 0)) {
                        a.this.dPM.S(false, false);
                    } else {
                        a.this.dPM.S(true, false);
                    }
                    a.this.dPR = false;
                    a.this.oi(a.this.axF ? "1" : "2");
                    a.this.onClick(a.this.dPz);
                    if (a.this.Sk != null) {
                        a.this.Sk.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void aDK() {
                    a.this.onClick(a.this.dPy);
                }
            });
            this.dPM.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.c.f
                public void gW(boolean z) {
                    a.this.dPM.aZ(a.this.aFl.dQn.videoUrl, a.this.aFl.threadId);
                    a.this.oi("2");
                    a.this.onClick(a.this.dPz);
                }
            });
            this.dPM.ms(false);
            this.dPO = new z();
            this.dPO.biz = gVar.threadId;
            this.dPO.daG = gVar.forumId;
            this.dPO.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dPO.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dPO.mSource = gVar.source;
            this.dPO.gHE = gVar.weight;
            this.dPO.gHG = this.mFrom;
            this.dPO.gHH = gVar.abtest_tag;
            this.dPO.arh = this.arh;
            this.dPO.mExtra = gVar.extra;
            this.dPO.gHK = "0";
            this.dPP = new z();
            this.dPP.biz = gVar.threadId;
            this.dPP.daG = gVar.forumId;
            this.dPP.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dPP.gHE = "auto_midpage";
            this.dPP.mLocate = "auto_midpage";
            this.dPP.gHG = this.mFrom;
            this.dPP.mSource = gVar.source;
            this.dPP.gHK = "0";
            if (gVar.dQn != null) {
                this.dPO.gHI = gVar.dQn.videoMd5;
                this.dPP.gHI = gVar.dQn.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.aA("tid", gVar.threadId);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", i);
            amVar.x("obj_param2", 1);
            amVar.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.aA("obj_param1", ao.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.aA("extra", ao.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.arh);
            amVar.aA("ab_tag", ao.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.aA("obj_type", this.mFrom);
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.aFl.source) ? "0" : this.aFl.source);
            amVar.x("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.bOs.setVideoStatsData(this.dPO);
            this.dPM.getVideoView().setBusiness(this.bOs);
            this.bOs.a(gVar);
            this.dPM.aZC();
            this.dPM.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dPR = true;
                        a.this.dPQ = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.mG(i);
                        a.this.dPM.aMK();
                    }
                }
            });
            this.dPM.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.aFl != null && a.this.aFl.dQn != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.aFl.dQn.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dPM.setThumbnail(gVar.dQn.thumbnailUrl);
            this.dPM.setVideoUrl(gVar.dQn.videoUrl, gVar.threadId);
            this.dPM.setFid(gVar.forumId);
            this.dPM.aMK();
            this.dPM.show();
            hu(false);
            if (gVar.autoPlay) {
                onClick(this.dPz);
                if (this.eho.aID()) {
                    this.dPM.mx(false);
                    this.eho.aIE();
                    this.dPM.my(true);
                    this.dPM.cr(gVar.dQn.videoUrl, gVar.threadId);
                } else {
                    this.dPM.my(false);
                    this.dPM.mx(false);
                    this.eho.hide();
                    this.dPM.a(gVar.dQn.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                }
                if (i == 0 && gVar.dQo) {
                    this.ehj.setVisibility(8);
                    this.ehn.nO(3);
                } else {
                    if (this.ehj.getVisibility() == 0) {
                        this.ehj.startAnimation(this.bOg);
                    }
                    this.ehn.nO(0);
                }
                gVar.dQo = false;
            } else {
                this.ehj.setVisibility(0);
                this.eho.hide();
                this.dPM.mx(true);
                this.ehn.nO(3);
                this.dPM.cr(gVar.dQn.videoUrl, gVar.threadId);
            }
            this.dPR = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(String str) {
        if (this.aFl != null && this.aFl.dQn != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFl.dQn.videoMd5, "", str, this.dPP);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dPM.brH();
    }

    public void aDF() {
        if (isPlaying()) {
            this.dPM.pausePlay();
        }
    }

    public boolean mH(int i) {
        return this.dPM.ty(i);
    }

    public void aDG() {
        this.ehi = false;
        this.dPM.stopPlay();
        if (this.ehc != null) {
            this.ehc.setVisibility(0);
        }
        if (this.ehn != null) {
            this.ehn.nO(2);
        }
        hu(false);
        this.ehh = true;
    }

    public void aDH() {
        if (this.dPM != null) {
            this.dPM.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aDH();
        if (this.dPN != null) {
            this.dPN.aDS();
        }
        if (this.ehj != null) {
            this.ehj.clearAnimation();
        }
        if (this.ehe != null) {
            this.ehe.onDestroy();
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dQm != null) {
            this.aKr.setText(TextUtils.isEmpty(gVar.dQm.userNickname) ? gVar.dQm.userName : gVar.dQm.userNickname);
            if (!StringUtils.isNull(gVar.dQm.portrait) && gVar.dQm.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.cDi.startLoad(gVar.dQm.portrait, 10, false);
            } else {
                this.cDi.startLoad(gVar.dQm.portrait, 12, false);
            }
            if (gVar.dQm.isBigV) {
                this.cDi.setShowV(gVar.dQm.isBigV);
                this.cDi.setIsBigV(gVar.dQm.isBigV);
            } else if (gVar.dQm.isGod) {
                this.cDi.setShowV(gVar.dQm.isGod);
                this.cDi.setIsBigV(gVar.dQm.isGod);
            } else {
                this.cDi.setShowV(gVar.dQm.isGod);
                this.cDi.setIsBigV(gVar.dQm.isGod);
            }
            e(gVar);
            f(gVar);
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && this.ehe != null) {
            this.ehe.a(gVar);
        }
    }

    public void f(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aJa.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha70));
            this.aJb.setImageDrawable(getContext().getResources().getDrawable(e.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aJa.setText(ao.X(gVar.postNum));
            } else {
                this.aJa.setText(this.mContext.getString(e.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dPM != null && this.dPz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dPQ) {
                this.dPM.brG();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aIs();
            } else {
                configuration.orientation = 1;
                aIt();
                this.dPQ = true;
            }
            this.dPM.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIs() {
        if (this.dPM != null && this.dPz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dPz.getParent() != null) {
                if (this.dPz.getParent() == frameLayout) {
                    frameLayout.removeView(this.dPz);
                } else if (this.dPz.getParent() == this.dPy) {
                    this.dPy.removeView(this.dPz);
                }
            }
            if (this.dPz.getParent() == null) {
                frameLayout.addView(this.dPz);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dPz.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dPz.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIt() {
        if (this.dPM != null && this.dPz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dPz.getParent() != null) {
                if (this.dPz.getParent() == frameLayout) {
                    frameLayout.removeView(this.dPz);
                } else if (this.dPz.getParent() == this.dPy) {
                    this.dPy.removeView(this.dPz);
                }
            }
            if (this.dPz.getParent() == null) {
                this.dPy.addView(this.dPz, 0);
                aIu();
                this.dPM.aZC();
            }
        }
    }

    private void aIu() {
        int i;
        if (!aIq()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dPz.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (apS() != null) {
            view.setTag(this);
            apS().a(view, this.aFl);
        }
        if (view == this.cDi || view == this.aKr) {
            if (this.aFl != null && this.aFl.dQm != null && !TextUtils.isEmpty(this.aFl.dQm.userId)) {
                this.ehn.nO(0);
                if (!TbadkCoreApplication.isLogin() || !this.aFl.dQm.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFl.dQm.userId, 0L), z, this.aFl.dQm.isGod)));
            }
        } else if (view == this.aJc) {
            if (this.aFl != null) {
                this.ehn.nO(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFl.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.ehc || view == this.ehd) {
            if (this.aFl != null) {
                if (this.ehn.getCurrentState() != 2 && this.ehn.getCurrentState() != 3) {
                    z = false;
                }
                this.ehn.nO(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.aFl.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.aJf) {
            this.ehn.nO(0);
            Fq();
        } else if (view == this.ehj && this.ehj.getVisibility() == 0) {
            if (this.ehl != null) {
                this.ehl.nS(this.mPosition);
            }
        } else if (view == this.aFj) {
            this.ehn.nO(0);
            this.aFj.L(view);
        } else if (view == this.aFk) {
            this.ehn.nO(0);
            this.aFk.L(view);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gV(boolean z) {
        if (this.aFl != null && this.aFl.dQm != null) {
            this.aFl.dQm.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aDI() {
        if (this.aFl != null && this.aFj != null) {
            this.aFj.L(this.aFj);
        }
    }

    public void ht(boolean z) {
        if (this.dPy != null) {
            this.dPy.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.ehl = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Sk = fVar;
    }

    private void hu(boolean z) {
        this.ehh = this.mPosition == (this.ehm == null ? -1 : this.ehm.aIB());
        if (this.ehh && z && isPlaying() && this.axF && !this.ehi) {
            this.ehf.setVisibility(0);
            this.ehi = true;
            this.ehf.postDelayed(this.ehr, 5000L);
            if (this.ehm != null) {
                this.ehm.cc(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ehf.setVisibility(8);
        if (this.ehr != null) {
            this.ehf.removeCallbacks(this.ehr);
        }
    }

    private void Fq() {
        if (this.aFl != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFl.forumId);
            String str = this.aFl.title;
            String str2 = this.aFl.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.aFl.dQn.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.aFl.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(e.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aSl = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aSo = 3;
            dVar.fid = valueOf;
            dVar.aSh = "";
            dVar.tid = str2;
            dVar.aSd = true;
            dVar.aSn = 0;
            dVar.aSp = 2;
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
            bundle.putInt("obj_param1", dVar.aSo);
            bundle.putInt("obj_type", dVar.aSp);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avL);
            dVar.k(bundle);
            com.baidu.tieba.c.e.asd().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aDG();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        aDF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(boolean z) {
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
    public class C0230a {
        private Runnable ehu;
        private int mCurrentState;

        private C0230a() {
            this.mCurrentState = -1;
            this.ehu = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(C0230a.this.ehu);
                    C0230a.this.nO(2);
                }
            };
        }

        public void nO(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = nP(i);
                    aIv();
                    return;
                case 1:
                    this.mCurrentState = nP(i);
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehu);
                    return;
                case 2:
                    this.mCurrentState = nQ(i);
                    return;
                case 3:
                    this.mCurrentState = nR(i);
                    aIv();
                    return;
                default:
                    this.mCurrentState = nQ(i);
                    return;
            }
        }

        private void aIv() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehu);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.ehu, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int nP(int i) {
            if (i != this.mCurrentState) {
                a.this.ehk.setVisibility(8);
                a.this.hv(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int nQ(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.ehk.setVisibility(0);
                if (i2 != 3 || a.this.aFl.autoPlay) {
                    a.this.hv(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int nR(int i) {
            if (i != this.mCurrentState) {
                a.this.ehk.setVisibility(0);
                a.this.hv(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
