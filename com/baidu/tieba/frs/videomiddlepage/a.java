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
    private com.baidu.tieba.lego.card.view.f Jj;
    private String XM;
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
    public TextView bKz;
    public HeadImageView bWg;
    private Animation bkE;
    private n bkR;
    public FrameLayout daL;
    public FrameLayout daM;
    public TextView daN;
    public com.baidu.tieba.play.c daY;
    public com.baidu.tieba.frs.aggregation.g daZ;
    private h dba;
    private y dbb;
    private y dbc;
    private boolean dbd;
    private boolean dbe;
    private Animation dbg;
    private boolean dbh;
    private boolean dbi;
    private View dqZ;
    private View dra;
    private ImageView drb;
    private FrameLayout drc;
    private TextView drd;
    private boolean dre;
    private boolean drf;
    private View drg;
    private View drh;
    private View dri;
    private View drj;
    private b drk;
    public com.baidu.tieba.frs.videomiddlepage.a.a drl;
    private Animation.AnimationListener drm;
    private Animation.AnimationListener drn;
    private Runnable dro;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dbd = true;
        this.dbi = true;
        this.dre = false;
        this.drf = false;
        this.drm = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.drg != null) {
                    a.this.drg.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.drg != null) {
                    a.this.drg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.drn = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.drg != null) {
                    a.this.drg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.drg != null) {
                    a.this.drg.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dro = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.drc.getVisibility() == 0) {
                    a.this.drc.setVisibility(8);
                }
            }
        };
        this.dbi = z;
        this.mFrom = str;
        this.XM = str2;
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.daL = (FrameLayout) view2.findViewById(d.g.video_agg_container);
        this.dqZ = view2.findViewById(d.g.card_container);
        this.daM = (FrameLayout) view2.findViewById(d.g.video_container);
        this.daY = new com.baidu.tieba.play.c(tbPageContext, this.daM, false);
        this.daY.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.drl != null && a.this.daZ.dbz.videoDuration > 8) {
                    a.this.drl.S(a.this.mPosition, a.this.daZ.dbz.videoUrl);
                }
            }
        });
        this.daN = (TextView) view2.findViewById(d.g.title);
        this.bWg = (HeadImageView) view2.findViewById(d.g.user_icon);
        this.apg = (TextView) view2.findViewById(d.g.user_name);
        this.bKz = (TextView) view2.findViewById(d.g.attention);
        this.aot = (TextView) view2.findViewById(d.g.thread_info_praise_num);
        this.aou = (ImageView) view2.findViewById(d.g.thread_info_praise_img);
        this.aov = view2.findViewById(d.g.agree_view_container);
        this.aow = (TextView) view2.findViewById(d.g.thread_info_commont_num);
        this.aox = (ImageView) view2.findViewById(d.g.thread_info_commont_img);
        this.aoy = view2.findViewById(d.g.thread_info_commont_container);
        this.aoz = (TextView) view2.findViewById(d.g.share_num);
        this.aoA = (ImageView) view2.findViewById(d.g.share_num_img);
        this.aoB = view2.findViewById(d.g.share_num_container);
        this.drc = (FrameLayout) view2.findViewById(d.g.download_nani_guide_container);
        this.drd = (TextView) view2.findViewById(d.g.download_nani_guide_txt);
        this.drc.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.drd.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.drd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!TextUtils.isEmpty(string2)) {
                    ax.wg().a((TbPageContext) com.baidu.adp.base.i.ab(a.this.aeY().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dra = view2.findViewById(d.g.attention_container);
        this.drb = (ImageView) view2.findViewById(d.g.attention_img);
        this.drg = view2.findViewById(d.g.video_agg_container_foreground);
        this.drh = view2.findViewById(d.g.user_container_foreground);
        this.dri = view2.findViewById(d.g.title_foreground);
        this.drj = view2.findViewById(d.g.comment_and_priase_layout_foreground);
        this.drh.setOnClickListener(this);
        this.dri.setOnClickListener(this);
        this.drj.setOnClickListener(this);
        this.drg.setOnClickListener(this);
        this.aov.setOnClickListener(this);
        this.aoy.setOnClickListener(this);
        this.aoB.setOnClickListener(this);
        this.daN.setOnClickListener(this);
        this.bWg.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.dra.setOnClickListener(this);
        this.dqZ.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daL.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.daL.setLayoutParams(layoutParams);
        this.bWg.setIsRound(true);
        this.bkR = new n(tbPageContext.getPageActivity());
        this.dba = new h(this.mPageContext, this);
        this.dbg = new AlphaAnimation(0.0f, 0.7f);
        this.dbg.setDuration(500L);
        this.dbg.setAnimationListener(this.drn);
        this.bkE = new AlphaAnimation(0.7f, 0.0f);
        this.bkE.setDuration(500L);
        this.bkE.setAnimationListener(this.drm);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.daZ != null && this.daZ.dby != null) {
            if (this.daZ.dby.hasFocus) {
                this.bKz.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_d));
                this.dra.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.bKz.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            }
        }
        if (this.daZ != null) {
            if (this.daZ.hasAgree) {
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
        this.daN.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_i));
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
        if (gVar != null && gVar.dbz != null) {
            this.daZ = gVar;
            this.dbh = this.daZ.autoPlay;
            this.drf = false;
            fZ(false);
            this.daN.setVisibility(0);
            this.daN.setText(gVar.title);
            avx();
            b(gVar, i, aVar);
            h(gVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean avw() {
        try {
            int parseInt = Integer.parseInt(this.daZ.dbz.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.daZ.dbz.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void avx() {
        if (!avw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daL.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.daL.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.daL.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.daL.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dbz != null) {
            this.daY.stopPlay();
            this.daY.ln(true);
            this.daY.lq(true);
            this.daY.lo(false);
            this.daY.lr(true);
            this.daY.K(false, false);
            this.daY.rp(i);
            this.daY.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    a.this.avy();
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                    a.this.avz();
                    if (a.this.daY.bga()) {
                    }
                    if (a.this.dbe) {
                        a.this.daY.stopPlay();
                    }
                }
            });
            this.daY.a(new c.k() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    if (a.this.daZ != null && a.this.daZ.dbz != null && com.baidu.adp.lib.g.b.g(a.this.daZ.dbz.videoHeight, 0) > com.baidu.adp.lib.g.b.g(a.this.daZ.dbz.videoWidth, 0)) {
                        a.this.daY.K(false, false);
                    } else {
                        a.this.daY.K(true, false);
                    }
                    a.this.dbe = false;
                    a.this.lO(a.this.dbh ? "1" : "2");
                    a.this.onClick(a.this.daM);
                    if (a.this.Jj != null) {
                        a.this.Jj.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqY() {
                    a.this.onClick(a.this.daL);
                }
            });
            this.daY.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void fF(boolean z) {
                    a.this.daY.bL(a.this.daZ.dbz.videoUrl, a.this.daZ.threadId);
                    a.this.lO("2");
                    a.this.onClick(a.this.daM);
                }
            });
            this.daY.ll(false);
            this.dbb = new y();
            this.dbb.aNu = gVar.threadId;
            this.dbb.crJ = gVar.forumId;
            this.dbb.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dbb.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dbb.mSource = gVar.source;
            this.dbb.fQM = gVar.weight;
            this.dbb.fQO = this.mFrom;
            this.dbb.fQP = gVar.abtest_tag;
            this.dbb.XM = this.XM;
            this.dbb.mExtra = gVar.extra;
            this.dbb.fQS = "0";
            this.dbc = new y();
            this.dbc.aNu = gVar.threadId;
            this.dbc.crJ = gVar.forumId;
            this.dbc.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dbc.fQM = "auto_midpage";
            this.dbc.mLocate = "auto_midpage";
            this.dbc.fQO = this.mFrom;
            this.dbc.mSource = gVar.source;
            this.dbc.fQS = "0";
            if (gVar.dbz != null) {
                this.dbb.fQQ = gVar.dbz.videoMd5;
                this.dbc.fQQ = gVar.dbz.videoMd5;
            }
            al alVar = new al("c12590");
            alVar.ac("tid", gVar.threadId);
            alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            alVar.r("obj_locate", i);
            alVar.r("obj_param2", 1);
            alVar.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
            alVar.ac("obj_param1", gVar.weight);
            alVar.ac("extra", gVar.extra);
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.XM);
            alVar.ac("ab_tag", gVar.abtest_tag);
            alVar.ac("obj_type", this.mFrom);
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.daZ.source);
            alVar.r("is_vertical", 0);
            TiebaStatic.log(alVar);
            this.bkR.setVideoStatsData(this.dbb);
            this.daY.getVideoView().setBusiness(this.bkR);
            this.daY.aLy();
            this.daY.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (!a.this.daY.bga()) {
                        a.this.lx(0);
                        a.this.drj.setVisibility(0);
                        a.this.dri.setVisibility(0);
                        a.this.drh.setVisibility(0);
                    } else if (z) {
                        if (a.this.drj.getVisibility() == 8) {
                            a.this.drj.setVisibility(0);
                            a.this.fZ(true);
                        }
                        if (a.this.dri.getVisibility() == 8) {
                            a.this.dri.setVisibility(0);
                        }
                        if (a.this.drh.getVisibility() == 8) {
                            a.this.drh.setVisibility(0);
                        }
                        a.this.lx(1);
                    } else {
                        if (a.this.drj.getVisibility() == 0) {
                            a.this.drj.setVisibility(8);
                            a.this.fZ(false);
                        }
                        if (a.this.dri.getVisibility() == 0) {
                            a.this.dri.setVisibility(8);
                        }
                        if (a.this.drh.getVisibility() == 0) {
                            a.this.drh.setVisibility(8);
                        }
                        a.this.lx(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqZ() {
                    a.this.lx(1);
                    if (!a.this.daY.bga()) {
                        a.this.drj.setVisibility(0);
                        a.this.dri.setVisibility(0);
                        a.this.drh.setVisibility(0);
                        return;
                    }
                    if (a.this.drj.getVisibility() == 8) {
                        a.this.drj.setVisibility(0);
                    }
                    if (a.this.dri.getVisibility() == 8) {
                        a.this.dri.setVisibility(0);
                    }
                    if (a.this.drh.getVisibility() == 8) {
                        a.this.drh.setVisibility(0);
                    }
                }
            });
            this.daY.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dbe = true;
                        a.this.dbd = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.kq(i);
                        a.this.daY.ayA();
                    }
                }
            });
            this.daY.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.daZ != null && a.this.daZ.dbz != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.daZ.dbz.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.daY.oz(gVar.dbz.thumbnailUrl);
            this.daY.bK(gVar.dbz.videoUrl, gVar.threadId);
            this.daY.a(new c.h() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.h
                public void ara() {
                }
            });
            this.daY.ayA();
            this.daY.show();
            if (gVar.autoPlay) {
                onClick(this.daM);
                this.dbe = false;
                this.daY.a(gVar.dbz.videoUrl, gVar.threadId, null, new Object[0]);
                if (i == 0) {
                    this.drg.setVisibility(8);
                } else {
                    this.drg.startAnimation(this.bkE);
                }
                this.dri.setVisibility(8);
                this.drj.setVisibility(8);
                fZ(false);
                this.drh.setVisibility(8);
            } else if (j.gR() && gVar.waitConfirm) {
                this.drg.startAnimation(this.bkE);
                this.dri.setVisibility(8);
                this.drj.setVisibility(8);
                fZ(false);
                this.drh.setVisibility(8);
            } else {
                this.dri.setVisibility(0);
                this.drj.setVisibility(0);
                this.drh.setVisibility(0);
                this.drg.setVisibility(0);
            }
            this.dbe = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx(int i) {
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
    public void lO(String str) {
        if (this.daZ != null && this.daZ.dbz != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.daZ.dbz.videoMd5, "", str, this.dbc);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.daY.bga();
    }

    public void aqR() {
        if (isPlaying()) {
            this.daY.pausePlay();
        }
    }

    public boolean kr(int i) {
        return this.daY.ro(i);
    }

    public void aqS() {
        this.drf = false;
        this.daY.stopPlay();
        if (this.daN != null) {
            this.daN.setVisibility(0);
        }
        fZ(false);
        this.dre = true;
    }

    public void aqT() {
        if (this.daY != null) {
            this.daY.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aqT();
        if (this.dba != null) {
            this.dba.arg();
        }
        if (this.drg != null) {
            this.drg.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dby != null) {
            this.apg.setText(TextUtils.isEmpty(gVar.dby.userNickname) ? gVar.dby.userName : gVar.dby.userNickname);
            if (!StringUtils.isNull(gVar.dby.portrait) && gVar.dby.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.bWg.startLoad(gVar.dby.portrait, 10, false);
            } else {
                this.bWg.startLoad(gVar.dby.portrait, 12, false);
            }
            if (gVar.dby.isBigV) {
                this.bWg.setShowV(gVar.dby.isBigV);
                this.bWg.setIsBigV(gVar.dby.isBigV);
            } else if (gVar.dby.isGod) {
                this.bWg.setShowV(gVar.dby.isGod);
                this.bWg.setIsBigV(gVar.dby.isGod);
            } else {
                this.bWg.setShowV(gVar.dby.isGod);
                this.bWg.setIsBigV(gVar.dby.isGod);
            }
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dby != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dby.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dby.userId)) {
                this.dra.setVisibility(8);
            } else {
                this.dra.setVisibility(0);
            }
            if (gVar.dby.hasFocus) {
                this.bKz.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_d));
                this.bKz.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                this.dra.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.drb.setVisibility(8);
                return;
            }
            this.bKz.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            this.bKz.setText(this.mPageContext.getString(d.k.attention));
            this.drb.setVisibility(0);
            this.dra.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
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
        if (this.daY != null && this.daM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dbd) {
                this.daY.bfZ();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                avy();
            } else {
                configuration.orientation = 1;
                avz();
                this.dbd = true;
            }
            this.daY.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avy() {
        if (this.daY != null && this.daM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.daM.getParent() != null) {
                if (this.daM.getParent() == frameLayout) {
                    frameLayout.removeView(this.daM);
                } else if (this.daM.getParent() == this.daL) {
                    this.daL.removeView(this.daM);
                }
            }
            if (this.daM.getParent() == null) {
                frameLayout.addView(this.daM);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.daM.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.daM.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avz() {
        if (this.daY != null && this.daM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.daM.getParent() != null) {
                if (this.daM.getParent() == frameLayout) {
                    frameLayout.removeView(this.daM);
                } else if (this.daM.getParent() == this.daL) {
                    this.daL.removeView(this.daM);
                }
            }
            if (this.daM.getParent() == null) {
                this.daL.addView(this.daM, 0);
                avA();
                this.daY.aLy();
            }
        }
    }

    private void avA() {
        int i;
        if (!avw()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.daM.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z = false;
        if (aeZ() != null) {
            view2.setTag(this);
            aeZ().a(view2, this.daZ);
        }
        if (view2 == this.bWg || view2 == this.apg) {
            if (this.daZ != null && this.daZ.dby != null && !TextUtils.isEmpty(this.daZ.dby.userId)) {
                if (TbadkCoreApplication.isLogin() && this.daZ.dby.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.daZ.dby.userId, 0L), z, this.daZ.dby.isGod)));
            }
        } else if (view2 == this.aoy || view2 == this.daN || view2 == this.dqZ) {
            if (this.daZ != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.daZ.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view2 == this.dra) {
            if (!this.daZ.dby.hasFocus) {
                this.dba.f(this.daZ);
            }
        } else if (view2 == this.aov) {
            this.dba.g(this.daZ);
        } else if (view2 == this.aoB) {
            xd();
        } else if (view2 == this.drg && this.drg.getVisibility() == 0) {
            if (this.drk != null) {
                this.drk.ly(this.mPosition);
            }
        } else if (view2 == this.dri || view2 == this.drj || view2 == this.drh) {
            if (this.drg.getVisibility() == 0) {
                if (this.drk != null) {
                    this.drk.ly(this.mPosition);
                    return;
                }
                return;
            }
            if (this.drj.getVisibility() == 0) {
                this.drj.setVisibility(8);
                fZ(false);
            }
            if (this.dri.getVisibility() == 0) {
                this.dri.setVisibility(8);
            }
            if (this.drh.getVisibility() == 0) {
                this.drh.setVisibility(8);
            }
            lx(0);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fE(boolean z) {
        if (this.daZ != null && this.daZ.dby != null) {
            this.daZ.dby.hasFocus = z;
            c(this.daZ);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aqU() {
        if (this.daZ != null) {
            this.daZ.hasAgree = !this.daZ.hasAgree;
            if (this.daZ.hasAgree) {
                this.daZ.agreeNum++;
            } else {
                this.daZ.agreeNum--;
            }
            if (this.aou != null) {
                this.aou.startAnimation(getScaleAnimation());
            }
            d(this.daZ);
        }
    }

    private Animation getScaleAnimation() {
        if (this.apc == null) {
            this.apc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.apc.setDuration(200L);
        }
        return this.apc;
    }

    public void fY(boolean z) {
        if (this.daL != null) {
            this.daL.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.drk = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Jj = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(boolean z) {
        this.dre = this.mPosition == (this.drl == null ? -1 : this.drl.avH());
        if (this.dre && z && isPlaying() && this.dbh && !this.drf) {
            this.drc.setVisibility(0);
            this.drf = true;
            this.drc.postDelayed(this.dro, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.drl != null) {
                this.drl.bF(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.drc.setVisibility(8);
        if (this.dro != null) {
            this.drc.removeCallbacks(this.dro);
        }
    }

    private void xd() {
        if (this.daZ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.daZ.forumId);
            String str = this.daZ.title;
            String str2 = this.daZ.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.daZ.dbz.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.daZ.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.k.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.awY = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.axb = 3;
            dVar.fid = valueOf;
            dVar.awT = "";
            dVar.tid = str2;
            dVar.awQ = true;
            dVar.axa = 0;
            dVar.axc = 2;
            if (parse != null) {
                dVar.awV = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.axb);
            bundle.putInt("obj_type", dVar.axc);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.abU);
            dVar.f(bundle);
            com.baidu.tieba.d.d.ahh().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        aqS();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        aqR();
    }
}
