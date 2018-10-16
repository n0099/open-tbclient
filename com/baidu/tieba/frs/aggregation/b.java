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
    public g aAV;
    public TextView aFZ;
    private boolean atr;
    private n bJP;
    public HeadImageView cxi;
    public FrameLayout dEW;
    public FrameLayout dEX;
    public TextView dEY;
    public TextView dEZ;
    public FrameLayout dFa;
    public TextView dFb;
    public TextView dFc;
    public TextView dFd;
    public TextView dFe;
    public TextView dFf;
    public ImageView dFg;
    public ImageView dFh;
    public LinearLayout dFi;
    public LinearLayout dFj;
    public com.baidu.tieba.play.c dFk;
    private h dFl;
    private z dFm;
    private z dFn;
    private boolean dFo;
    private boolean dFp;
    private Animation dFq;
    private Animation dFr;
    private ScaleAnimation dFs;
    private boolean dFt;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dFo = true;
        this.dFt = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dEW = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dEX = (FrameLayout) view.findViewById(e.g.video_container);
        this.dFk = new com.baidu.tieba.play.c(tbPageContext, (View) this.dEX, false);
        this.dEY = (TextView) view.findViewById(e.g.title);
        this.dEZ = (TextView) view.findViewById(e.g.duration);
        this.dFa = (FrameLayout) view.findViewById(e.g.mobile_network_container);
        this.dFb = (TextView) view.findViewById(e.g.mobile_network_text);
        this.dFc = (TextView) view.findViewById(e.g.mobile_network_play);
        this.cxi = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aFZ = (TextView) view.findViewById(e.g.user_name);
        this.dFd = (TextView) view.findViewById(e.g.attention);
        this.dFi = (LinearLayout) view.findViewById(e.g.thread_info_commont_container);
        this.dFj = (LinearLayout) view.findViewById(e.g.agree_view_container);
        this.dFe = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.dFf = (TextView) view.findViewById(e.g.thread_info_praise_num);
        this.dFg = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.dFh = (ImageView) view.findViewById(e.g.thread_info_praise_img);
        this.dFi.setOnClickListener(this);
        this.dFj.setOnClickListener(this);
        this.dEY.setOnClickListener(this);
        this.cxi.setOnClickListener(this);
        this.aFZ.setOnClickListener(this);
        this.dFd.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dFc.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dEW.setLayoutParams(layoutParams);
        this.cxi.setIsRound(true);
        this.bJP = new n(tbPageContext.getPageActivity());
        this.dFl = new h(this.mPageContext, this);
        this.dFq = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_200);
        this.dFr = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), e.d.cp_bg_line_d);
            if (this.aAV != null && this.aAV.dFK != null) {
                if (this.aAV.dFK.hasFocus) {
                    al.h(this.dFd, e.d.cp_cont_d);
                    this.dFd.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.dFd, e.d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, e.C0175e.ds20), l.h(this.mContext, e.C0175e.ds20));
                    this.dFd.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.aAV != null) {
                if (this.aAV.hasAgree) {
                    this.dFh.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                    al.h(this.dFf, e.d.cp_cont_h);
                } else {
                    this.dFh.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                    al.h(this.dFf, e.d.cp_cont_f);
                }
            }
            al.h(this.dFe, e.d.cp_cont_f);
            this.dFg.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dFL != null) {
            this.aAV = gVar;
            this.atr = this.aAV.autoPlay;
            this.dEY.setVisibility(0);
            this.dEY.setText(gVar.title);
            this.dEZ.setVisibility(0);
            this.dEZ.setText(ao.dt(gVar.dFL.videoDuration * 1000));
            if (gVar.dFL.videoSize == 0) {
                format = this.mPageContext.getString(e.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(e.j.video_mobile_network_tips), nF(String.format("%.1f", Float.valueOf(((float) gVar.dFL.videoSize) / 1048576.0f))));
            }
            this.dFb.setText(format);
            this.dFa.setVisibility(8);
            b(gVar, i, aVar);
            c(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dFL != null) {
            this.dFk.stopPlay();
            this.dFk.setIsNeedRecoveryVideoPlayer(true);
            this.dFk.mi(true);
            this.dFk.me(false);
            this.dFk.a(new c.InterfaceC0258c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XC() {
                    if (b.this.dFk.bpH()) {
                        b.this.dEZ.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XD() {
                    if (b.this.dFk.bpH()) {
                        b.this.dEZ.setVisibility(8);
                    }
                    if (b.this.dFp) {
                        b.this.dFk.stopPlay();
                    }
                }
            });
            this.dFk.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void aBM() {
                    b.this.dFp = false;
                    b.this.dEZ.setVisibility(8);
                    b.this.nE(b.this.atr ? "1" : "2");
                    b.this.onClick(b.this.dEX);
                }

                @Override // com.baidu.tieba.play.c.l
                public void aBN() {
                    b.this.dEZ.setVisibility(8);
                    b.this.onClick(b.this.dEW);
                }
            });
            this.dFk.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void gI(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dFb.getText().toString());
                        b.this.dFk.aW(b.this.aAV.dFL.videoUrl, b.this.aAV.threadId);
                        b.this.dEZ.setVisibility(8);
                        b.this.nE("2");
                    } else {
                        b.this.dFa.setVisibility(0);
                    }
                    b.this.onClick(b.this.dEX);
                }
            });
            this.dFk.mb(false);
            this.dFm = new z();
            this.dFm.beh = gVar.threadId;
            this.dFm.cQb = gVar.forumId;
            this.dFm.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dFn = new z();
            this.dFn.beh = gVar.threadId;
            this.dFn.cQb = gVar.forumId;
            this.dFn.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dFt) {
                am amVar = new am("c12590");
                amVar.ax("tid", gVar.threadId);
                amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.x("obj_locate", i);
                amVar.x("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dFm.gwv = "auto_midpage";
                this.dFm.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dFm.gwx = "1";
                this.dFn.gwv = "auto_midpage";
                this.dFn.mLocate = "auto_midpage";
                this.dFn.gwx = "1";
            } else {
                this.dFm.gwx = "frs_bavideotab";
                this.dFm.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dFn.gwx = "frs_bavideotab";
                this.dFn.mLocate = "frs_bavideotab";
            }
            if (gVar.dFL != null) {
                this.dFm.gwz = gVar.dFL.videoMd5;
                this.dFn.gwz = gVar.dFL.videoMd5;
            }
            this.bJP.setVideoStatsData(this.dFm);
            this.dFk.getVideoView().setBusiness(this.bJP);
            this.dFk.aXA();
            this.dFk.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void gJ(boolean z) {
                    if (!b.this.dFk.bpH()) {
                        b.this.dEY.setVisibility(0);
                    } else if (z) {
                        if (b.this.dEY.getVisibility() == 0) {
                            b.this.dEY.setVisibility(8);
                            b.this.dEY.startAnimation(b.this.dFq);
                        }
                    } else if (b.this.dEY.getVisibility() == 8) {
                        b.this.dEY.setVisibility(0);
                        b.this.dEY.startAnimation(b.this.dFr);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aBO() {
                    if (!b.this.dFk.bpH()) {
                        b.this.dEY.setVisibility(0);
                    } else if (b.this.dEY.getVisibility() == 0) {
                        b.this.dEY.setVisibility(8);
                        b.this.dEY.startAnimation(b.this.dFq);
                    }
                }
            });
            this.dFk.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dFp = true;
                        b.this.dFo = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.lL(i);
                        b.this.dFk.aKH();
                    }
                }
            });
            this.dFk.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.aAV != null && b.this.aAV.dFL != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.aAV.dFL.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dFk.setThumbnail(gVar.dFL.thumbnailUrl);
            this.dFk.setVideoUrl(gVar.dFL.videoUrl, gVar.threadId);
            this.dFk.tk(gVar.title);
            this.dFk.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void aBP() {
                    b.this.dEZ.setVisibility(8);
                }
            });
            this.dFk.aKH();
            this.dFk.show();
            if (gVar.autoPlay) {
                onClick(this.dEX);
                this.dFp = false;
                this.dFk.a(gVar.dFL.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.dFp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(String str) {
        if (this.aAV != null && this.aAV.dFL != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aAV.dFL.videoMd5, "", str, this.dFn);
            }
        }
    }

    public boolean isPlaying() {
        return this.dFk.bpH();
    }

    public void aBI() {
        if (isPlaying()) {
            this.dFk.pausePlay();
        }
    }

    public boolean lM(int i) {
        return this.dFk.sy(i);
    }

    public void aBJ() {
        this.dFa.setVisibility(8);
        this.dFk.stopPlay();
        if (this.dEY != null) {
            this.dEY.setVisibility(0);
        }
        if (this.dEZ != null) {
            this.dEZ.setVisibility(0);
        }
    }

    public void aBK() {
        if (this.dFk != null) {
            this.dFk.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aBK();
        if (this.dFl != null) {
            this.dFl.aBV();
        }
    }

    public String nF(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dFK != null) {
            this.aFZ.setText(TextUtils.isEmpty(gVar.dFK.userNickname) ? gVar.dFK.userName : gVar.dFK.userNickname);
            this.cxi.startLoad(gVar.dFK.portrait, 12, false);
            this.cxi.setShowV(gVar.dFK.isGod);
            this.cxi.setIsBigV(gVar.dFK.isGod);
            d(gVar);
            e(gVar);
            f(gVar);
        }
    }

    public void d(g gVar) {
        if (gVar != null && gVar.dFK != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dFK.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dFK.userId)) {
                this.dFd.setVisibility(8);
            } else {
                this.dFd.setVisibility(0);
            }
            if (gVar.dFK.hasFocus) {
                al.h(this.dFd, e.d.cp_cont_d);
                this.dFd.setCompoundDrawables(null, null, null, null);
                this.dFd.setText(this.mPageContext.getString(e.j.relate_forum_is_followed));
                return;
            }
            al.h(this.dFd, e.d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, e.C0175e.ds20), l.h(this.mContext, e.C0175e.ds20));
            this.dFd.setCompoundDrawables(drawable, null, null, null);
            this.dFd.setText(this.mPageContext.getString(e.j.attention));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dFh.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                al.h(this.dFf, e.d.cp_cont_h);
            } else {
                this.dFh.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                al.h(this.dFf, e.d.cp_cont_f);
            }
            this.dFf.setText(ao.N(gVar.agreeNum));
        }
    }

    public void f(g gVar) {
        if (gVar != null) {
            al.h(this.dFe, e.d.cp_cont_f);
            this.dFg.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
            this.dFe.setText(ao.N(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dFk != null && this.dEX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dFo) {
                this.dFk.bpG();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dEX.getParent() != null) {
                    if (this.dEX.getParent() == frameLayout) {
                        frameLayout.removeView(this.dEX);
                    } else if (this.dEX.getParent() == this.dEW) {
                        this.dEW.removeView(this.dEX);
                    }
                }
                if (this.dEX.getParent() == null) {
                    frameLayout.addView(this.dEX);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dEX.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dEX.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dEX.getParent() != null) {
                    if (this.dEX.getParent() == frameLayout) {
                        frameLayout.removeView(this.dEX);
                    } else if (this.dEX.getParent() == this.dEW) {
                        this.dEW.removeView(this.dEX);
                    }
                }
                if (this.dEX.getParent() == null) {
                    this.dEW.addView(this.dEX, 0);
                    this.dEX.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dFk.aXA();
                    this.dFo = true;
                } else {
                    return;
                }
            }
            this.dFk.a(this.mPageContext, configuration);
            this.dEZ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anO() != null) {
            view.setTag(this);
            anO().a(view, this.aAV);
        }
        if (view == this.cxi || view == this.aFZ) {
            boolean z = false;
            if (this.aAV != null && this.aAV.dFK != null && !TextUtils.isEmpty(this.aAV.dFK.userId)) {
                if (TbadkCoreApplication.isLogin() && this.aAV.dFK.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aAV.dFK.userId, 0L), z, this.aAV.dFK.isGod)));
            }
        } else if (view == this.dFi || view == this.dEY || view == getView()) {
            if (this.aAV != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aAV.threadId, null, null);
                if (!this.dFt) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dFc) {
            if (this.aAV != null && this.aAV.dFL != null) {
                this.dFa.setVisibility(8);
                this.dFk.bpK();
                this.dFk.aW(this.aAV.dFL.videoUrl, this.aAV.threadId);
                nE("2");
            }
        } else if (view == this.dFd) {
            if (!this.aAV.dFK.hasFocus) {
                this.dFl.g(this.aAV);
            }
        } else if (view == this.dFj) {
            this.dFl.h(this.aAV);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gH(boolean z) {
        if (this.aAV != null && this.aAV.dFK != null) {
            this.aAV.dFK.hasFocus = z;
            d(this.aAV);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aBL() {
        if (this.aAV != null) {
            this.aAV.hasAgree = !this.aAV.hasAgree;
            if (this.aAV.hasAgree) {
                this.aAV.agreeNum++;
            } else {
                this.aAV.agreeNum--;
            }
            if (this.dFh != null) {
                this.dFh.startAnimation(getScaleAnimation());
            }
            e(this.aAV);
        }
    }

    private Animation getScaleAnimation() {
        if (this.dFs == null) {
            this.dFs = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dFs.setDuration(200L);
        }
        return this.dFs;
    }
}
