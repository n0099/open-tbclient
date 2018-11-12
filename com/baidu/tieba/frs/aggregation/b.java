package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public g aBK;
    public TextView aGP;
    private boolean aue;
    private n bKA;
    public HeadImageView cyq;
    private h dGA;
    private z dGB;
    private z dGC;
    private boolean dGD;
    private boolean dGE;
    private Animation dGF;
    private Animation dGG;
    private ScaleAnimation dGH;
    private boolean dGI;
    public FrameLayout dGl;
    public FrameLayout dGm;
    public TextView dGn;
    public TextView dGo;
    public FrameLayout dGp;
    public TextView dGq;
    public TextView dGr;
    public TextView dGs;
    public TextView dGt;
    public TextView dGu;
    public ImageView dGv;
    public ImageView dGw;
    public LinearLayout dGx;
    public LinearLayout dGy;
    public com.baidu.tieba.play.c dGz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dGD = true;
        this.dGI = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dGl = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dGm = (FrameLayout) view.findViewById(e.g.video_container);
        this.dGz = new com.baidu.tieba.play.c(tbPageContext, (View) this.dGm, false);
        this.dGn = (TextView) view.findViewById(e.g.title);
        this.dGo = (TextView) view.findViewById(e.g.duration);
        this.dGp = (FrameLayout) view.findViewById(e.g.mobile_network_container);
        this.dGq = (TextView) view.findViewById(e.g.mobile_network_text);
        this.dGr = (TextView) view.findViewById(e.g.mobile_network_play);
        this.cyq = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aGP = (TextView) view.findViewById(e.g.user_name);
        this.dGs = (TextView) view.findViewById(e.g.attention);
        this.dGx = (LinearLayout) view.findViewById(e.g.thread_info_commont_container);
        this.dGy = (LinearLayout) view.findViewById(e.g.agree_view_container);
        this.dGt = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.dGu = (TextView) view.findViewById(e.g.thread_info_praise_num);
        this.dGv = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.dGw = (ImageView) view.findViewById(e.g.thread_info_praise_img);
        this.dGx.setOnClickListener(this);
        this.dGy.setOnClickListener(this);
        this.dGn.setOnClickListener(this);
        this.cyq.setOnClickListener(this);
        this.aGP.setOnClickListener(this);
        this.dGs.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dGr.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGl.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dGl.setLayoutParams(layoutParams);
        this.cyq.setIsRound(true);
        this.bKA = new n(tbPageContext.getPageActivity());
        this.dGA = new h(this.mPageContext, this);
        this.dGF = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_200);
        this.dGG = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), e.d.cp_bg_line_d);
            if (this.aBK != null && this.aBK.dGZ != null) {
                if (this.aBK.dGZ.hasFocus) {
                    al.h(this.dGs, e.d.cp_cont_d);
                    this.dGs.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.dGs, e.d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, e.C0200e.ds20), l.h(this.mContext, e.C0200e.ds20));
                    this.dGs.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.aBK != null) {
                if (this.aBK.hasAgree) {
                    this.dGw.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                    al.h(this.dGu, e.d.cp_cont_h);
                } else {
                    this.dGw.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                    al.h(this.dGu, e.d.cp_cont_f);
                }
            }
            al.h(this.dGt, e.d.cp_cont_f);
            this.dGv.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.dHa != null) {
            this.aBK = gVar;
            this.aue = this.aBK.autoPlay;
            this.dGn.setVisibility(0);
            this.dGn.setText(gVar.title);
            this.dGo.setVisibility(0);
            this.dGo.setText(ao.dH(gVar.dHa.videoDuration * 1000));
            if (gVar.dHa.videoSize == 0) {
                format = this.mPageContext.getString(e.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(e.j.video_mobile_network_tips), nG(String.format("%.1f", Float.valueOf(((float) gVar.dHa.videoSize) / 1048576.0f))));
            }
            this.dGq.setText(format);
            this.dGp.setVisibility(8);
            b(gVar, i, aVar);
            c(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dHa != null) {
            this.dGz.stopPlay();
            this.dGz.setIsNeedRecoveryVideoPlayer(true);
            this.dGz.mt(true);
            this.dGz.mp(false);
            this.dGz.a(new c.InterfaceC0286c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XN() {
                    if (b.this.dGz.bpd()) {
                        b.this.dGo.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XO() {
                    if (b.this.dGz.bpd()) {
                        b.this.dGo.setVisibility(8);
                    }
                    if (b.this.dGE) {
                        b.this.dGz.stopPlay();
                    }
                }
            });
            this.dGz.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void aBk() {
                    b.this.dGE = false;
                    b.this.dGo.setVisibility(8);
                    b.this.nF(b.this.aue ? "1" : "2");
                    b.this.onClick(b.this.dGm);
                }

                @Override // com.baidu.tieba.play.c.l
                public void aBl() {
                    b.this.dGo.setVisibility(8);
                    b.this.onClick(b.this.dGl);
                }
            });
            this.dGz.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void gS(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dGq.getText().toString());
                        b.this.dGz.aW(b.this.aBK.dHa.videoUrl, b.this.aBK.threadId);
                        b.this.dGo.setVisibility(8);
                        b.this.nF("2");
                    } else {
                        b.this.dGp.setVisibility(0);
                    }
                    b.this.onClick(b.this.dGm);
                }
            });
            this.dGz.mm(false);
            this.dGB = new z();
            this.dGB.beV = gVar.threadId;
            this.dGB.cRh = gVar.forumId;
            this.dGB.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dGC = new z();
            this.dGC.beV = gVar.threadId;
            this.dGC.cRh = gVar.forumId;
            this.dGC.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dGI) {
                am amVar = new am("c12590");
                amVar.ax("tid", gVar.threadId);
                amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.x("obj_locate", i);
                amVar.x("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dGB.gxX = "auto_midpage";
                this.dGB.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dGB.gxZ = "1";
                this.dGC.gxX = "auto_midpage";
                this.dGC.mLocate = "auto_midpage";
                this.dGC.gxZ = "1";
            } else {
                this.dGB.gxZ = "frs_bavideotab";
                this.dGB.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dGC.gxZ = "frs_bavideotab";
                this.dGC.mLocate = "frs_bavideotab";
            }
            if (gVar.dHa != null) {
                this.dGB.gyb = gVar.dHa.videoMd5;
                this.dGC.gyb = gVar.dHa.videoMd5;
            }
            this.bKA.setVideoStatsData(this.dGB);
            this.dGz.getVideoView().setBusiness(this.bKA);
            this.dGz.aWX();
            this.dGz.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void gT(boolean z) {
                    if (!b.this.dGz.bpd()) {
                        b.this.dGn.setVisibility(0);
                    } else if (z) {
                        if (b.this.dGn.getVisibility() == 0) {
                            b.this.dGn.setVisibility(8);
                            b.this.dGn.startAnimation(b.this.dGF);
                        }
                    } else if (b.this.dGn.getVisibility() == 8) {
                        b.this.dGn.setVisibility(0);
                        b.this.dGn.startAnimation(b.this.dGG);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aBm() {
                    if (!b.this.dGz.bpd()) {
                        b.this.dGn.setVisibility(0);
                    } else if (b.this.dGn.getVisibility() == 0) {
                        b.this.dGn.setVisibility(8);
                        b.this.dGn.startAnimation(b.this.dGF);
                    }
                }
            });
            this.dGz.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dGE = true;
                        b.this.dGD = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.md(i);
                        b.this.dGz.aKf();
                    }
                }
            });
            this.dGz.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.aBK != null && b.this.aBK.dHa != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.aBK.dHa.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dGz.setThumbnail(gVar.dHa.thumbnailUrl);
            this.dGz.setVideoUrl(gVar.dHa.videoUrl, gVar.threadId);
            this.dGz.tp(gVar.title);
            this.dGz.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void aBn() {
                    b.this.dGo.setVisibility(8);
                }
            });
            this.dGz.aKf();
            this.dGz.show();
            if (gVar.autoPlay) {
                onClick(this.dGm);
                this.dGE = false;
                this.dGz.a(gVar.dHa.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.dGE = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nF(String str) {
        if (this.aBK != null && this.aBK.dHa != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aBK.dHa.videoMd5, "", str, this.dGC);
            }
        }
    }

    public boolean isPlaying() {
        return this.dGz.bpd();
    }

    public void aBg() {
        if (isPlaying()) {
            this.dGz.pausePlay();
        }
    }

    public boolean me(int i) {
        return this.dGz.sR(i);
    }

    public void aBh() {
        this.dGp.setVisibility(8);
        this.dGz.stopPlay();
        if (this.dGn != null) {
            this.dGn.setVisibility(0);
        }
        if (this.dGo != null) {
            this.dGo.setVisibility(0);
        }
    }

    public void aBi() {
        if (this.dGz != null) {
            this.dGz.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aBi();
        if (this.dGA != null) {
            this.dGA.aBt();
        }
    }

    public String nG(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dGZ != null) {
            this.aGP.setText(TextUtils.isEmpty(gVar.dGZ.userNickname) ? gVar.dGZ.userName : gVar.dGZ.userNickname);
            this.cyq.startLoad(gVar.dGZ.portrait, 12, false);
            this.cyq.setShowV(gVar.dGZ.isGod);
            this.cyq.setIsBigV(gVar.dGZ.isGod);
            d(gVar);
            e(gVar);
            f(gVar);
        }
    }

    public void d(g gVar) {
        if (gVar != null && gVar.dGZ != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dGZ.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dGZ.userId)) {
                this.dGs.setVisibility(8);
            } else {
                this.dGs.setVisibility(0);
            }
            if (gVar.dGZ.hasFocus) {
                al.h(this.dGs, e.d.cp_cont_d);
                this.dGs.setCompoundDrawables(null, null, null, null);
                this.dGs.setText(this.mPageContext.getString(e.j.relate_forum_is_followed));
                return;
            }
            al.h(this.dGs, e.d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, e.C0200e.ds20), l.h(this.mContext, e.C0200e.ds20));
            this.dGs.setCompoundDrawables(drawable, null, null, null);
            this.dGs.setText(this.mPageContext.getString(e.j.attention));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dGw.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                al.h(this.dGu, e.d.cp_cont_h);
            } else {
                this.dGw.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                al.h(this.dGu, e.d.cp_cont_f);
            }
            this.dGu.setText(ao.P(gVar.agreeNum));
        }
    }

    public void f(g gVar) {
        if (gVar != null) {
            al.h(this.dGt, e.d.cp_cont_f);
            this.dGv.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
            this.dGt.setText(ao.P(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dGz != null && this.dGm != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dGD) {
                this.dGz.bpc();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dGm.getParent() != null) {
                    if (this.dGm.getParent() == frameLayout) {
                        frameLayout.removeView(this.dGm);
                    } else if (this.dGm.getParent() == this.dGl) {
                        this.dGl.removeView(this.dGm);
                    }
                }
                if (this.dGm.getParent() == null) {
                    frameLayout.addView(this.dGm);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dGm.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dGm.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dGm.getParent() != null) {
                    if (this.dGm.getParent() == frameLayout) {
                        frameLayout.removeView(this.dGm);
                    } else if (this.dGm.getParent() == this.dGl) {
                        this.dGl.removeView(this.dGm);
                    }
                }
                if (this.dGm.getParent() == null) {
                    this.dGl.addView(this.dGm, 0);
                    this.dGm.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dGz.aWX();
                    this.dGD = true;
                } else {
                    return;
                }
            }
            this.dGz.a(this.mPageContext, configuration);
            this.dGo.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anq() != null) {
            view.setTag(this);
            anq().a(view, this.aBK);
        }
        if (view == this.cyq || view == this.aGP) {
            boolean z = false;
            if (this.aBK != null && this.aBK.dGZ != null && !TextUtils.isEmpty(this.aBK.dGZ.userId)) {
                if (TbadkCoreApplication.isLogin() && this.aBK.dGZ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aBK.dGZ.userId, 0L), z, this.aBK.dGZ.isGod)));
            }
        } else if (view == this.dGx || view == this.dGn || view == getView()) {
            if (this.aBK != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aBK.threadId, null, null);
                if (!this.dGI) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dGr) {
            if (this.aBK != null && this.aBK.dHa != null) {
                this.dGp.setVisibility(8);
                this.dGz.bpg();
                this.dGz.aW(this.aBK.dHa.videoUrl, this.aBK.threadId);
                nF("2");
            }
        } else if (view == this.dGs) {
            if (!this.aBK.dGZ.hasFocus) {
                this.dGA.g(this.aBK);
            }
        } else if (view == this.dGy) {
            this.dGA.h(this.aBK);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gR(boolean z) {
        if (this.aBK != null && this.aBK.dGZ != null) {
            this.aBK.dGZ.hasFocus = z;
            d(this.aBK);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aBj() {
        if (this.aBK != null) {
            this.aBK.hasAgree = !this.aBK.hasAgree;
            if (this.aBK.hasAgree) {
                this.aBK.agreeNum++;
            } else {
                this.aBK.agreeNum--;
            }
            if (this.dGw != null) {
                this.dGw.startAnimation(getScaleAnimation());
            }
            e(this.aBK);
        }
    }

    private Animation getScaleAnimation() {
        if (this.dGH == null) {
            this.dGH = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dGH.setDuration(200L);
        }
        return this.dGH;
    }
}
