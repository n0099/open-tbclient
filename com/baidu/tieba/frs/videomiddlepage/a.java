package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.h;
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
    private com.baidu.tieba.lego.card.view.f Jf;
    private String XN;
    private ImageView aoA;
    private View aoB;
    private TextView aot;
    private ImageView aou;
    private View aov;
    private TextView aow;
    private ImageView aox;
    private View aoy;
    private TextView aoz;
    private ScaleAnimation apc;
    public TextView apg;
    public TextView bLo;
    public HeadImageView bWT;
    private Animation bkT;
    private n blg;
    public FrameLayout dbP;
    public FrameLayout dbQ;
    public TextView dbR;
    public com.baidu.tieba.play.c dcc;
    public com.baidu.tieba.frs.aggregation.g dcd;
    private h dce;
    private y dcf;
    private y dcg;
    private boolean dch;
    private boolean dci;
    private Animation dck;
    private boolean dcl;
    private boolean dcm;
    private View dse;
    private View dsf;
    private ImageView dsg;
    private FrameLayout dsh;
    private TextView dsi;
    private boolean dsj;
    private boolean dsk;
    private View dsl;
    private View dsm;
    private View dsn;
    private View dso;
    private b dsp;
    public com.baidu.tieba.frs.videomiddlepage.a.a dsq;
    private Animation.AnimationListener dsr;
    private Animation.AnimationListener dss;
    private Runnable dst;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dch = true;
        this.dcm = true;
        this.dsj = false;
        this.dsk = false;
        this.dsr = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dsl != null) {
                    a.this.dsl.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dsl != null) {
                    a.this.dsl.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dss = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dsl != null) {
                    a.this.dsl.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dsl != null) {
                    a.this.dsl.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dst = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dsh.getVisibility() == 0) {
                    a.this.dsh.setVisibility(8);
                }
            }
        };
        this.dcm = z;
        this.mFrom = str;
        this.XN = str2;
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.dbP = (FrameLayout) view2.findViewById(d.g.video_agg_container);
        this.dse = view2.findViewById(d.g.card_container);
        this.dbQ = (FrameLayout) view2.findViewById(d.g.video_container);
        this.dcc = new com.baidu.tieba.play.c(tbPageContext, this.dbQ, false);
        this.dcc.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dsq != null && a.this.dcd.dcE.videoDuration > 8) {
                    a.this.dsq.S(a.this.mPosition, a.this.dcd.dcE.videoUrl);
                }
            }
        });
        this.dbR = (TextView) view2.findViewById(d.g.title);
        this.bWT = (HeadImageView) view2.findViewById(d.g.user_icon);
        this.apg = (TextView) view2.findViewById(d.g.user_name);
        this.bLo = (TextView) view2.findViewById(d.g.attention);
        this.aot = (TextView) view2.findViewById(d.g.thread_info_praise_num);
        this.aou = (ImageView) view2.findViewById(d.g.thread_info_praise_img);
        this.aov = view2.findViewById(d.g.agree_view_container);
        this.aow = (TextView) view2.findViewById(d.g.thread_info_commont_num);
        this.aox = (ImageView) view2.findViewById(d.g.thread_info_commont_img);
        this.aoy = view2.findViewById(d.g.thread_info_commont_container);
        this.aoz = (TextView) view2.findViewById(d.g.share_num);
        this.aoA = (ImageView) view2.findViewById(d.g.share_num_img);
        this.aoB = view2.findViewById(d.g.share_num_container);
        this.dsh = (FrameLayout) view2.findViewById(d.g.download_nani_guide_container);
        this.dsi = (TextView) view2.findViewById(d.g.download_nani_guide_txt);
        this.dsh.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dsi.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dsi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!TextUtils.isEmpty(string2)) {
                    ax.wf().a((TbPageContext) com.baidu.adp.base.i.ab(a.this.aeY().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dsf = view2.findViewById(d.g.attention_container);
        this.dsg = (ImageView) view2.findViewById(d.g.attention_img);
        this.dsl = view2.findViewById(d.g.video_agg_container_foreground);
        this.dsm = view2.findViewById(d.g.user_container_foreground);
        this.dsn = view2.findViewById(d.g.title_foreground);
        this.dso = view2.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dsm.setOnClickListener(this);
        this.dsn.setOnClickListener(this);
        this.dso.setOnClickListener(this);
        this.dsl.setOnClickListener(this);
        this.aov.setOnClickListener(this);
        this.aoy.setOnClickListener(this);
        this.aoB.setOnClickListener(this);
        this.dbR.setOnClickListener(this);
        this.bWT.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.dsf.setOnClickListener(this);
        this.dse.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dbP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dbP.setLayoutParams(layoutParams);
        this.bWT.setIsRound(true);
        this.blg = new n(tbPageContext.getPageActivity());
        this.dce = new h(this.mPageContext, this);
        this.dck = new AlphaAnimation(0.0f, 0.7f);
        this.dck.setDuration(500L);
        this.dck.setAnimationListener(this.dss);
        this.bkT = new AlphaAnimation(0.7f, 0.0f);
        this.bkT.setDuration(500L);
        this.bkT.setAnimationListener(this.dsr);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dcd != null && this.dcd.dcD != null) {
            if (this.dcd.dcD.hasFocus) {
                this.bLo.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_d));
                this.dsf.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.bLo.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            }
        }
        if (this.dcd != null) {
            if (this.dcd.hasAgree) {
                this.aou.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.icon_home_card_like_s));
                this.aot.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_i));
            } else {
                this.aou.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_like_selector));
                this.aot.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_i));
            }
        }
        this.aow.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_i));
        this.aox.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_commnet_selector));
        this.aoz.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_i));
        this.aoA.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_share_selector));
        this.dbR.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_i));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dcE != null) {
            this.dcd = gVar;
            this.dcl = this.dcd.autoPlay;
            this.dsk = false;
            ga(false);
            this.dbR.setVisibility(0);
            this.dbR.setText(gVar.title);
            avw();
            b(gVar, i, aVar);
            h(gVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean avv() {
        try {
            int parseInt = Integer.parseInt(this.dcd.dcE.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dcd.dcE.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void avw() {
        if (!avv()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dbP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dbP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dbP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dbP.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dcE != null) {
            this.dcc.stopPlay();
            this.dcc.lo(true);
            this.dcc.lr(true);
            this.dcc.lp(false);
            this.dcc.ls(true);
            this.dcc.K(false, false);
            this.dcc.rn(i);
            this.dcc.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void aqU() {
                    a.this.avx();
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    a.this.avy();
                    if (a.this.dcc.bga()) {
                    }
                    if (a.this.dci) {
                        a.this.dcc.stopPlay();
                    }
                }
            });
            this.dcc.a(new c.k() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.k
                public void aqW() {
                    if (a.this.dcd != null && a.this.dcd.dcE != null && com.baidu.adp.lib.g.b.g(a.this.dcd.dcE.videoHeight, 0) > com.baidu.adp.lib.g.b.g(a.this.dcd.dcE.videoWidth, 0)) {
                        a.this.dcc.K(false, false);
                    } else {
                        a.this.dcc.K(true, false);
                    }
                    a.this.dci = false;
                    a.this.lR(a.this.dcl ? "1" : "2");
                    a.this.onClick(a.this.dbQ);
                    if (a.this.Jf != null) {
                        a.this.Jf.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    a.this.onClick(a.this.dbP);
                }
            });
            this.dcc.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void fG(boolean z) {
                    a.this.dcc.bL(a.this.dcd.dcE.videoUrl, a.this.dcd.threadId);
                    a.this.lR("2");
                    a.this.onClick(a.this.dbQ);
                }
            });
            this.dcc.lm(false);
            this.dcf = new y();
            this.dcf.aNv = gVar.threadId;
            this.dcf.csP = gVar.forumId;
            this.dcf.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dcf.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dcf.mSource = gVar.source;
            this.dcf.fRP = gVar.weight;
            this.dcf.fRR = this.mFrom;
            this.dcf.fRS = gVar.abtest_tag;
            this.dcf.XN = this.XN;
            this.dcf.mExtra = gVar.extra;
            this.dcf.fRV = "0";
            this.dcg = new y();
            this.dcg.aNv = gVar.threadId;
            this.dcg.csP = gVar.forumId;
            this.dcg.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dcg.fRP = "auto_midpage";
            this.dcg.mLocate = "auto_midpage";
            this.dcg.fRR = this.mFrom;
            this.dcg.mSource = gVar.source;
            this.dcg.fRV = "0";
            if (gVar.dcE != null) {
                this.dcf.fRT = gVar.dcE.videoMd5;
                this.dcg.fRT = gVar.dcE.videoMd5;
            }
            al alVar = new al("c12590");
            alVar.ac("tid", gVar.threadId);
            alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            alVar.r("obj_locate", i);
            alVar.r("obj_param2", 1);
            alVar.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
            alVar.ac("obj_param1", gVar.weight);
            alVar.ac("extra", gVar.extra);
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.XN);
            alVar.ac("ab_tag", gVar.abtest_tag);
            alVar.ac("obj_type", this.mFrom);
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dcd.source);
            alVar.r("is_vertical", 0);
            TiebaStatic.log(alVar);
            this.blg.setVideoStatsData(this.dcf);
            this.dcc.getVideoView().setBusiness(this.blg);
            this.dcc.aLx();
            this.dcc.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fH(boolean z) {
                    if (!a.this.dcc.bga()) {
                        a.this.lv(0);
                        a.this.dso.setVisibility(0);
                        a.this.dsn.setVisibility(0);
                        a.this.dsm.setVisibility(0);
                    } else if (z) {
                        if (a.this.dso.getVisibility() == 8) {
                            a.this.dso.setVisibility(0);
                            a.this.ga(true);
                        }
                        if (a.this.dsn.getVisibility() == 8) {
                            a.this.dsn.setVisibility(0);
                        }
                        if (a.this.dsm.getVisibility() == 8) {
                            a.this.dsm.setVisibility(0);
                        }
                        a.this.lv(1);
                    } else {
                        if (a.this.dso.getVisibility() == 0) {
                            a.this.dso.setVisibility(8);
                            a.this.ga(false);
                        }
                        if (a.this.dsn.getVisibility() == 0) {
                            a.this.dsn.setVisibility(8);
                        }
                        if (a.this.dsm.getVisibility() == 0) {
                            a.this.dsm.setVisibility(8);
                        }
                        a.this.lv(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqY() {
                    a.this.lv(1);
                    if (!a.this.dcc.bga()) {
                        a.this.dso.setVisibility(0);
                        a.this.dsn.setVisibility(0);
                        a.this.dsm.setVisibility(0);
                        return;
                    }
                    if (a.this.dso.getVisibility() == 8) {
                        a.this.dso.setVisibility(0);
                    }
                    if (a.this.dsn.getVisibility() == 8) {
                        a.this.dsn.setVisibility(0);
                    }
                    if (a.this.dsm.getVisibility() == 8) {
                        a.this.dsm.setVisibility(0);
                    }
                }
            });
            this.dcc.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dci = true;
                        a.this.dch = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.ko(i);
                        a.this.dcc.ayy();
                    }
                }
            });
            this.dcc.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.dcd != null && a.this.dcd.dcE != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dcd.dcE.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dcc.oC(gVar.dcE.thumbnailUrl);
            this.dcc.bK(gVar.dcE.videoUrl, gVar.threadId);
            this.dcc.a(new c.h() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.h
                public void aqZ() {
                }
            });
            this.dcc.ayy();
            this.dcc.show();
            if (gVar.autoPlay) {
                onClick(this.dbQ);
                this.dci = false;
                this.dcc.a(gVar.dcE.videoUrl, gVar.threadId, null, new Object[0]);
                if (i == 0) {
                    this.dsl.setVisibility(8);
                } else {
                    this.dsl.startAnimation(this.bkT);
                }
                this.dsn.setVisibility(8);
                this.dso.setVisibility(8);
                ga(false);
                this.dsm.setVisibility(8);
            } else if (j.gR() && gVar.waitConfirm) {
                this.dsl.startAnimation(this.bkT);
                this.dsn.setVisibility(8);
                this.dso.setVisibility(8);
                ga(false);
                this.dsm.setVisibility(8);
            } else {
                this.dsn.setVisibility(0);
                this.dso.setVisibility(0);
                this.dsm.setVisibility(0);
                this.dsl.setVisibility(0);
            }
            this.dci = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (i == 1) {
            customMessage.setExtra("low");
        } else if (i == 0) {
            customMessage.setExtra("high");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(String str) {
        if (this.dcd != null && this.dcd.dcE != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dcd.dcE.videoMd5, "", str, this.dcg);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dcc.bga();
    }

    public void aqQ() {
        if (isPlaying()) {
            this.dcc.pausePlay();
        }
    }

    public boolean kp(int i) {
        return this.dcc.rm(i);
    }

    public void aqR() {
        this.dsk = false;
        this.dcc.stopPlay();
        if (this.dbR != null) {
            this.dbR.setVisibility(0);
        }
        ga(false);
        this.dsj = true;
    }

    public void aqS() {
        if (this.dcc != null) {
            this.dcc.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aqS();
        if (this.dce != null) {
            this.dce.arf();
        }
        if (this.dsl != null) {
            this.dsl.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dcD != null) {
            this.apg.setText(TextUtils.isEmpty(gVar.dcD.userNickname) ? gVar.dcD.userName : gVar.dcD.userNickname);
            if (!StringUtils.isNull(gVar.dcD.portrait) && gVar.dcD.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.bWT.startLoad(gVar.dcD.portrait, 10, false);
            } else {
                this.bWT.startLoad(gVar.dcD.portrait, 12, false);
            }
            if (gVar.dcD.isBigV) {
                this.bWT.setShowV(gVar.dcD.isBigV);
                this.bWT.setIsBigV(gVar.dcD.isBigV);
            } else if (gVar.dcD.isGod) {
                this.bWT.setShowV(gVar.dcD.isGod);
                this.bWT.setIsBigV(gVar.dcD.isGod);
            } else {
                this.bWT.setShowV(gVar.dcD.isGod);
                this.bWT.setIsBigV(gVar.dcD.isGod);
            }
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dcD != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dcD.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dcD.userId)) {
                this.dsf.setVisibility(8);
            } else {
                this.dsf.setVisibility(0);
            }
            if (gVar.dcD.hasFocus) {
                this.bLo.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_d));
                this.bLo.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                this.dsf.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dsg.setVisibility(8);
                return;
            }
            this.bLo.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            this.bLo.setText(this.mPageContext.getString(d.k.attention));
            this.dsg.setVisibility(0);
            this.dsf.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.aou.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_like_s));
                this.aot.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_h_1));
            } else {
                this.aou.setImageDrawable(getContext().getResources().getDrawable(d.f.card_like_selector));
                this.aot.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_i));
            }
            if (gVar.agreeNum > 0) {
                this.aot.setText(an.B(gVar.agreeNum));
            } else {
                this.aot.setText(d.k.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.aow.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.aox.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.aow.setText(an.B(gVar.postNum));
            } else {
                this.aow.setText(this.mContext.getString(d.k.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (this.aoB != null && this.aoz != null && gVar != null) {
            long j = gVar.shareNum;
            String string = this.mContext.getString(d.k.share);
            if (j > 0) {
                string = an.B(j);
            }
            this.aoz.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dcc != null && this.dbQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dch) {
                this.dcc.bfZ();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                avx();
            } else {
                configuration.orientation = 1;
                avy();
                this.dch = true;
            }
            this.dcc.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avx() {
        if (this.dcc != null && this.dbQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dbQ.getParent() != null) {
                if (this.dbQ.getParent() == frameLayout) {
                    frameLayout.removeView(this.dbQ);
                } else if (this.dbQ.getParent() == this.dbP) {
                    this.dbP.removeView(this.dbQ);
                }
            }
            if (this.dbQ.getParent() == null) {
                frameLayout.addView(this.dbQ);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dbQ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dbQ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avy() {
        if (this.dcc != null && this.dbQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dbQ.getParent() != null) {
                if (this.dbQ.getParent() == frameLayout) {
                    frameLayout.removeView(this.dbQ);
                } else if (this.dbQ.getParent() == this.dbP) {
                    this.dbP.removeView(this.dbQ);
                }
            }
            if (this.dbQ.getParent() == null) {
                this.dbP.addView(this.dbQ, 0);
                avz();
                this.dcc.aLx();
            }
        }
    }

    private void avz() {
        int i;
        if (!avv()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dbQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z = false;
        if (aeZ() != null) {
            view2.setTag(this);
            aeZ().a(view2, this.dcd);
        }
        if (view2 == this.bWT || view2 == this.apg) {
            if (this.dcd != null && this.dcd.dcD != null && !TextUtils.isEmpty(this.dcd.dcD.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dcd.dcD.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dcd.dcD.userId, 0L), z, this.dcd.dcD.isGod)));
            }
        } else if (view2 == this.aoy || view2 == this.dbR || view2 == this.dse) {
            if (this.dcd != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dcd.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view2 == this.dsf) {
            if (!this.dcd.dcD.hasFocus) {
                this.dce.f(this.dcd);
            }
        } else if (view2 == this.aov) {
            this.dce.g(this.dcd);
        } else if (view2 == this.aoB) {
            xc();
        } else if (view2 == this.dsl && this.dsl.getVisibility() == 0) {
            if (this.dsp != null) {
                this.dsp.lw(this.mPosition);
            }
        } else if (view2 == this.dsn || view2 == this.dso || view2 == this.dsm) {
            if (this.dsl.getVisibility() == 0) {
                if (this.dsp != null) {
                    this.dsp.lw(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dso.getVisibility() == 0) {
                this.dso.setVisibility(8);
                ga(false);
            }
            if (this.dsn.getVisibility() == 0) {
                this.dsn.setVisibility(8);
            }
            if (this.dsm.getVisibility() == 0) {
                this.dsm.setVisibility(8);
            }
            lv(0);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fF(boolean z) {
        if (this.dcd != null && this.dcd.dcD != null) {
            this.dcd.dcD.hasFocus = z;
            c(this.dcd);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aqT() {
        if (this.dcd != null) {
            this.dcd.hasAgree = !this.dcd.hasAgree;
            if (this.dcd.hasAgree) {
                this.dcd.agreeNum++;
            } else {
                this.dcd.agreeNum--;
            }
            if (this.aou != null) {
                this.aou.startAnimation(getScaleAnimation());
            }
            d(this.dcd);
        }
    }

    private Animation getScaleAnimation() {
        if (this.apc == null) {
            this.apc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.apc.setDuration(200L);
        }
        return this.apc;
    }

    public void fZ(boolean z) {
        if (this.dbP != null) {
            this.dbP.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dsp = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Jf = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(boolean z) {
        this.dsj = this.mPosition == (this.dsq == null ? -1 : this.dsq.avG());
        if (this.dsj && z && isPlaying() && this.dcl && !this.dsk) {
            this.dsh.setVisibility(0);
            this.dsk = true;
            this.dsh.postDelayed(this.dst, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dsq != null) {
                this.dsq.bF(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dsh.setVisibility(8);
        if (this.dst != null) {
            this.dsh.removeCallbacks(this.dst);
        }
    }

    private void xc() {
        if (this.dcd != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dcd.forumId);
            String str = this.dcd.title;
            String str2 = this.dcd.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dcd.dcE.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dcd.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.k.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.awZ = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.axc = 3;
            dVar.fid = valueOf;
            dVar.awU = "";
            dVar.tid = str2;
            dVar.awR = true;
            dVar.axb = 0;
            dVar.axd = 2;
            if (parse != null) {
                dVar.awW = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.axc);
            bundle.putInt("obj_type", dVar.axd);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.abV);
            dVar.f(bundle);
            com.baidu.tieba.d.d.ahh().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aqR();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        aqQ();
    }
}
