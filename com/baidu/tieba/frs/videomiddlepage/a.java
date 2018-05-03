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
    public TextView bKy;
    public HeadImageView bWd;
    private Animation bkE;
    private n bkR;
    public FrameLayout daI;
    public FrameLayout daJ;
    public TextView daK;
    public com.baidu.tieba.play.c daV;
    public com.baidu.tieba.frs.aggregation.g daW;
    private h daX;
    private y daY;
    private y daZ;
    private boolean dba;
    private boolean dbb;
    private Animation dbd;
    private boolean dbe;
    private boolean dbf;
    private View dqW;
    private View dqX;
    private ImageView dqY;
    private FrameLayout dqZ;
    private TextView dra;
    private boolean drb;
    private boolean drc;
    private View drd;
    private View dre;
    private View drf;
    private View drg;
    private b drh;
    public com.baidu.tieba.frs.videomiddlepage.a.a dri;
    private Animation.AnimationListener drj;
    private Animation.AnimationListener drk;
    private Runnable drl;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dba = true;
        this.dbf = true;
        this.drb = false;
        this.drc = false;
        this.drj = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.drd != null) {
                    a.this.drd.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.drd != null) {
                    a.this.drd.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.drk = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.drd != null) {
                    a.this.drd.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.drd != null) {
                    a.this.drd.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.drl = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dqZ.getVisibility() == 0) {
                    a.this.dqZ.setVisibility(8);
                }
            }
        };
        this.dbf = z;
        this.mFrom = str;
        this.XM = str2;
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.daI = (FrameLayout) view2.findViewById(d.g.video_agg_container);
        this.dqW = view2.findViewById(d.g.card_container);
        this.daJ = (FrameLayout) view2.findViewById(d.g.video_container);
        this.daV = new com.baidu.tieba.play.c(tbPageContext, this.daJ, false);
        this.daV.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dri != null && a.this.daW.dbw.videoDuration > 8) {
                    a.this.dri.S(a.this.mPosition, a.this.daW.dbw.videoUrl);
                }
            }
        });
        this.daK = (TextView) view2.findViewById(d.g.title);
        this.bWd = (HeadImageView) view2.findViewById(d.g.user_icon);
        this.apg = (TextView) view2.findViewById(d.g.user_name);
        this.bKy = (TextView) view2.findViewById(d.g.attention);
        this.aot = (TextView) view2.findViewById(d.g.thread_info_praise_num);
        this.aou = (ImageView) view2.findViewById(d.g.thread_info_praise_img);
        this.aov = view2.findViewById(d.g.agree_view_container);
        this.aow = (TextView) view2.findViewById(d.g.thread_info_commont_num);
        this.aox = (ImageView) view2.findViewById(d.g.thread_info_commont_img);
        this.aoy = view2.findViewById(d.g.thread_info_commont_container);
        this.aoz = (TextView) view2.findViewById(d.g.share_num);
        this.aoA = (ImageView) view2.findViewById(d.g.share_num_img);
        this.aoB = view2.findViewById(d.g.share_num_container);
        this.dqZ = (FrameLayout) view2.findViewById(d.g.download_nani_guide_container);
        this.dra = (TextView) view2.findViewById(d.g.download_nani_guide_txt);
        this.dqZ.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dra.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dra.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!TextUtils.isEmpty(string2)) {
                    ax.wg().a((TbPageContext) com.baidu.adp.base.i.ab(a.this.aeY().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dqX = view2.findViewById(d.g.attention_container);
        this.dqY = (ImageView) view2.findViewById(d.g.attention_img);
        this.drd = view2.findViewById(d.g.video_agg_container_foreground);
        this.dre = view2.findViewById(d.g.user_container_foreground);
        this.drf = view2.findViewById(d.g.title_foreground);
        this.drg = view2.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dre.setOnClickListener(this);
        this.drf.setOnClickListener(this);
        this.drg.setOnClickListener(this);
        this.drd.setOnClickListener(this);
        this.aov.setOnClickListener(this);
        this.aoy.setOnClickListener(this);
        this.aoB.setOnClickListener(this);
        this.daK.setOnClickListener(this);
        this.bWd.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.dqX.setOnClickListener(this);
        this.dqW.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daI.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.daI.setLayoutParams(layoutParams);
        this.bWd.setIsRound(true);
        this.bkR = new n(tbPageContext.getPageActivity());
        this.daX = new h(this.mPageContext, this);
        this.dbd = new AlphaAnimation(0.0f, 0.7f);
        this.dbd.setDuration(500L);
        this.dbd.setAnimationListener(this.drk);
        this.bkE = new AlphaAnimation(0.7f, 0.0f);
        this.bkE.setDuration(500L);
        this.bkE.setAnimationListener(this.drj);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.daW != null && this.daW.dbv != null) {
            if (this.daW.dbv.hasFocus) {
                this.bKy.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_d));
                this.dqX.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.bKy.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            }
        }
        if (this.daW != null) {
            if (this.daW.hasAgree) {
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
        this.daK.setTextColor(tbPageContext.getResources().getColor(d.C0126d.cp_cont_i));
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
        if (gVar != null && gVar.dbw != null) {
            this.daW = gVar;
            this.dbe = this.daW.autoPlay;
            this.drc = false;
            fZ(false);
            this.daK.setVisibility(0);
            this.daK.setText(gVar.title);
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
            int parseInt = Integer.parseInt(this.daW.dbw.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.daW.dbw.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void avx() {
        if (!avw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daI.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.daI.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.daI.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.daI.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dbw != null) {
            this.daV.stopPlay();
            this.daV.ln(true);
            this.daV.lq(true);
            this.daV.lo(false);
            this.daV.lr(true);
            this.daV.K(false, false);
            this.daV.ro(i);
            this.daV.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    a.this.avy();
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                    a.this.avz();
                    if (a.this.daV.bga()) {
                    }
                    if (a.this.dbb) {
                        a.this.daV.stopPlay();
                    }
                }
            });
            this.daV.a(new c.k() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    if (a.this.daW != null && a.this.daW.dbw != null && com.baidu.adp.lib.g.b.g(a.this.daW.dbw.videoHeight, 0) > com.baidu.adp.lib.g.b.g(a.this.daW.dbw.videoWidth, 0)) {
                        a.this.daV.K(false, false);
                    } else {
                        a.this.daV.K(true, false);
                    }
                    a.this.dbb = false;
                    a.this.lO(a.this.dbe ? "1" : "2");
                    a.this.onClick(a.this.daJ);
                    if (a.this.Jj != null) {
                        a.this.Jj.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqY() {
                    a.this.onClick(a.this.daI);
                }
            });
            this.daV.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void fF(boolean z) {
                    a.this.daV.bL(a.this.daW.dbw.videoUrl, a.this.daW.threadId);
                    a.this.lO("2");
                    a.this.onClick(a.this.daJ);
                }
            });
            this.daV.ll(false);
            this.daY = new y();
            this.daY.aNu = gVar.threadId;
            this.daY.crG = gVar.forumId;
            this.daY.mUid = TbadkCoreApplication.getCurrentAccount();
            this.daY.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.daY.mSource = gVar.source;
            this.daY.fQJ = gVar.weight;
            this.daY.fQL = this.mFrom;
            this.daY.fQM = gVar.abtest_tag;
            this.daY.XM = this.XM;
            this.daY.mExtra = gVar.extra;
            this.daY.fQP = "0";
            this.daZ = new y();
            this.daZ.aNu = gVar.threadId;
            this.daZ.crG = gVar.forumId;
            this.daZ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.daZ.fQJ = "auto_midpage";
            this.daZ.mLocate = "auto_midpage";
            this.daZ.fQL = this.mFrom;
            this.daZ.mSource = gVar.source;
            this.daZ.fQP = "0";
            if (gVar.dbw != null) {
                this.daY.fQN = gVar.dbw.videoMd5;
                this.daZ.fQN = gVar.dbw.videoMd5;
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
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.daW.source);
            alVar.r("is_vertical", 0);
            TiebaStatic.log(alVar);
            this.bkR.setVideoStatsData(this.daY);
            this.daV.getVideoView().setBusiness(this.bkR);
            this.daV.aLy();
            this.daV.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (!a.this.daV.bga()) {
                        a.this.lw(0);
                        a.this.drg.setVisibility(0);
                        a.this.drf.setVisibility(0);
                        a.this.dre.setVisibility(0);
                    } else if (z) {
                        if (a.this.drg.getVisibility() == 8) {
                            a.this.drg.setVisibility(0);
                            a.this.fZ(true);
                        }
                        if (a.this.drf.getVisibility() == 8) {
                            a.this.drf.setVisibility(0);
                        }
                        if (a.this.dre.getVisibility() == 8) {
                            a.this.dre.setVisibility(0);
                        }
                        a.this.lw(1);
                    } else {
                        if (a.this.drg.getVisibility() == 0) {
                            a.this.drg.setVisibility(8);
                            a.this.fZ(false);
                        }
                        if (a.this.drf.getVisibility() == 0) {
                            a.this.drf.setVisibility(8);
                        }
                        if (a.this.dre.getVisibility() == 0) {
                            a.this.dre.setVisibility(8);
                        }
                        a.this.lw(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqZ() {
                    a.this.lw(1);
                    if (!a.this.daV.bga()) {
                        a.this.drg.setVisibility(0);
                        a.this.drf.setVisibility(0);
                        a.this.dre.setVisibility(0);
                        return;
                    }
                    if (a.this.drg.getVisibility() == 8) {
                        a.this.drg.setVisibility(0);
                    }
                    if (a.this.drf.getVisibility() == 8) {
                        a.this.drf.setVisibility(0);
                    }
                    if (a.this.dre.getVisibility() == 8) {
                        a.this.dre.setVisibility(0);
                    }
                }
            });
            this.daV.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dbb = true;
                        a.this.dba = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.kp(i);
                        a.this.daV.ayA();
                    }
                }
            });
            this.daV.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.daW != null && a.this.daW.dbw != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.daW.dbw.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.daV.oz(gVar.dbw.thumbnailUrl);
            this.daV.bK(gVar.dbw.videoUrl, gVar.threadId);
            this.daV.a(new c.h() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.h
                public void ara() {
                }
            });
            this.daV.ayA();
            this.daV.show();
            if (gVar.autoPlay) {
                onClick(this.daJ);
                this.dbb = false;
                this.daV.a(gVar.dbw.videoUrl, gVar.threadId, null, new Object[0]);
                if (i == 0) {
                    this.drd.setVisibility(8);
                } else {
                    this.drd.startAnimation(this.bkE);
                }
                this.drf.setVisibility(8);
                this.drg.setVisibility(8);
                fZ(false);
                this.dre.setVisibility(8);
            } else if (j.gR() && gVar.waitConfirm) {
                this.drd.startAnimation(this.bkE);
                this.drf.setVisibility(8);
                this.drg.setVisibility(8);
                fZ(false);
                this.dre.setVisibility(8);
            } else {
                this.drf.setVisibility(0);
                this.drg.setVisibility(0);
                this.dre.setVisibility(0);
                this.drd.setVisibility(0);
            }
            this.dbb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(int i) {
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
        if (this.daW != null && this.daW.dbw != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.daW.dbw.videoMd5, "", str, this.daZ);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.daV.bga();
    }

    public void aqR() {
        if (isPlaying()) {
            this.daV.pausePlay();
        }
    }

    public boolean kq(int i) {
        return this.daV.rn(i);
    }

    public void aqS() {
        this.drc = false;
        this.daV.stopPlay();
        if (this.daK != null) {
            this.daK.setVisibility(0);
        }
        fZ(false);
        this.drb = true;
    }

    public void aqT() {
        if (this.daV != null) {
            this.daV.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aqT();
        if (this.daX != null) {
            this.daX.arg();
        }
        if (this.drd != null) {
            this.drd.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dbv != null) {
            this.apg.setText(TextUtils.isEmpty(gVar.dbv.userNickname) ? gVar.dbv.userName : gVar.dbv.userNickname);
            if (!StringUtils.isNull(gVar.dbv.portrait) && gVar.dbv.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.bWd.startLoad(gVar.dbv.portrait, 10, false);
            } else {
                this.bWd.startLoad(gVar.dbv.portrait, 12, false);
            }
            if (gVar.dbv.isBigV) {
                this.bWd.setShowV(gVar.dbv.isBigV);
                this.bWd.setIsBigV(gVar.dbv.isBigV);
            } else if (gVar.dbv.isGod) {
                this.bWd.setShowV(gVar.dbv.isGod);
                this.bWd.setIsBigV(gVar.dbv.isGod);
            } else {
                this.bWd.setShowV(gVar.dbv.isGod);
                this.bWd.setIsBigV(gVar.dbv.isGod);
            }
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dbv != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dbv.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dbv.userId)) {
                this.dqX.setVisibility(8);
            } else {
                this.dqX.setVisibility(0);
            }
            if (gVar.dbv.hasFocus) {
                this.bKy.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_d));
                this.bKy.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                this.dqX.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dqY.setVisibility(8);
                return;
            }
            this.bKy.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            this.bKy.setText(this.mPageContext.getString(d.k.attention));
            this.dqY.setVisibility(0);
            this.dqX.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
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
        if (this.daV != null && this.daJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dba) {
                this.daV.bfZ();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                avy();
            } else {
                configuration.orientation = 1;
                avz();
                this.dba = true;
            }
            this.daV.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avy() {
        if (this.daV != null && this.daJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.daJ.getParent() != null) {
                if (this.daJ.getParent() == frameLayout) {
                    frameLayout.removeView(this.daJ);
                } else if (this.daJ.getParent() == this.daI) {
                    this.daI.removeView(this.daJ);
                }
            }
            if (this.daJ.getParent() == null) {
                frameLayout.addView(this.daJ);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.daJ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.daJ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avz() {
        if (this.daV != null && this.daJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.daJ.getParent() != null) {
                if (this.daJ.getParent() == frameLayout) {
                    frameLayout.removeView(this.daJ);
                } else if (this.daJ.getParent() == this.daI) {
                    this.daI.removeView(this.daJ);
                }
            }
            if (this.daJ.getParent() == null) {
                this.daI.addView(this.daJ, 0);
                avA();
                this.daV.aLy();
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
            this.daJ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z = false;
        if (aeZ() != null) {
            view2.setTag(this);
            aeZ().a(view2, this.daW);
        }
        if (view2 == this.bWd || view2 == this.apg) {
            if (this.daW != null && this.daW.dbv != null && !TextUtils.isEmpty(this.daW.dbv.userId)) {
                if (TbadkCoreApplication.isLogin() && this.daW.dbv.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.daW.dbv.userId, 0L), z, this.daW.dbv.isGod)));
            }
        } else if (view2 == this.aoy || view2 == this.daK || view2 == this.dqW) {
            if (this.daW != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.daW.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view2 == this.dqX) {
            if (!this.daW.dbv.hasFocus) {
                this.daX.f(this.daW);
            }
        } else if (view2 == this.aov) {
            this.daX.g(this.daW);
        } else if (view2 == this.aoB) {
            xd();
        } else if (view2 == this.drd && this.drd.getVisibility() == 0) {
            if (this.drh != null) {
                this.drh.lx(this.mPosition);
            }
        } else if (view2 == this.drf || view2 == this.drg || view2 == this.dre) {
            if (this.drd.getVisibility() == 0) {
                if (this.drh != null) {
                    this.drh.lx(this.mPosition);
                    return;
                }
                return;
            }
            if (this.drg.getVisibility() == 0) {
                this.drg.setVisibility(8);
                fZ(false);
            }
            if (this.drf.getVisibility() == 0) {
                this.drf.setVisibility(8);
            }
            if (this.dre.getVisibility() == 0) {
                this.dre.setVisibility(8);
            }
            lw(0);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fE(boolean z) {
        if (this.daW != null && this.daW.dbv != null) {
            this.daW.dbv.hasFocus = z;
            c(this.daW);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aqU() {
        if (this.daW != null) {
            this.daW.hasAgree = !this.daW.hasAgree;
            if (this.daW.hasAgree) {
                this.daW.agreeNum++;
            } else {
                this.daW.agreeNum--;
            }
            if (this.aou != null) {
                this.aou.startAnimation(getScaleAnimation());
            }
            d(this.daW);
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
        if (this.daI != null) {
            this.daI.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.drh = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Jj = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(boolean z) {
        this.drb = this.mPosition == (this.dri == null ? -1 : this.dri.avH());
        if (this.drb && z && isPlaying() && this.dbe && !this.drc) {
            this.dqZ.setVisibility(0);
            this.drc = true;
            this.dqZ.postDelayed(this.drl, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dri != null) {
                this.dri.bF(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dqZ.setVisibility(8);
        if (this.drl != null) {
            this.dqZ.removeCallbacks(this.drl);
        }
    }

    private void xd() {
        if (this.daW != null && this.mContext != null) {
            String valueOf = String.valueOf(this.daW.forumId);
            String str = this.daW.title;
            String str2 = this.daW.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.daW.dbw.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.daW.title;
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
