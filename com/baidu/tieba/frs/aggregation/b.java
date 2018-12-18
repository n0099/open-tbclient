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
    public g aFk;
    public TextView aKp;
    private boolean axE;
    private n bOp;
    public HeadImageView cCi;
    public FrameLayout dMK;
    public FrameLayout dML;
    public TextView dMM;
    public TextView dMN;
    public FrameLayout dMO;
    public TextView dMP;
    public TextView dMQ;
    public TextView dMR;
    public TextView dMS;
    public TextView dMT;
    public ImageView dMU;
    public ImageView dMV;
    public LinearLayout dMW;
    public LinearLayout dMX;
    public com.baidu.tieba.play.c dMY;
    private h dMZ;
    private z dNa;
    private z dNb;
    private boolean dNc;
    private boolean dNd;
    private Animation dNe;
    private Animation dNf;
    private ScaleAnimation dNg;
    private boolean dNh;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dNc = true;
        this.dNh = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dMK = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dML = (FrameLayout) view.findViewById(e.g.video_container);
        this.dMY = new com.baidu.tieba.play.c(tbPageContext, (View) this.dML, false);
        this.dMM = (TextView) view.findViewById(e.g.title);
        this.dMN = (TextView) view.findViewById(e.g.duration);
        this.dMO = (FrameLayout) view.findViewById(e.g.mobile_network_container);
        this.dMP = (TextView) view.findViewById(e.g.mobile_network_text);
        this.dMQ = (TextView) view.findViewById(e.g.mobile_network_play);
        this.cCi = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKp = (TextView) view.findViewById(e.g.user_name);
        this.dMR = (TextView) view.findViewById(e.g.attention);
        this.dMW = (LinearLayout) view.findViewById(e.g.thread_info_commont_container);
        this.dMX = (LinearLayout) view.findViewById(e.g.agree_view_container);
        this.dMS = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.dMT = (TextView) view.findViewById(e.g.thread_info_praise_num);
        this.dMU = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.dMV = (ImageView) view.findViewById(e.g.thread_info_praise_img);
        this.dMW.setOnClickListener(this);
        this.dMX.setOnClickListener(this);
        this.dMM.setOnClickListener(this);
        this.cCi.setOnClickListener(this);
        this.aKp.setOnClickListener(this);
        this.dMR.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dMQ.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dMK.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dMK.setLayoutParams(layoutParams);
        this.cCi.setIsRound(true);
        this.bOp = new n(tbPageContext.getPageActivity());
        this.dMZ = new h(this.mPageContext, this);
        this.dNe = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_200);
        this.dNf = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), e.d.cp_bg_line_d);
            if (this.aFk != null && this.aFk.dNy != null) {
                if (this.aFk.dNy.hasFocus) {
                    al.h(this.dMR, e.d.cp_cont_d);
                    this.dMR.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.dMR, e.d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
                    this.dMR.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.aFk != null) {
                if (this.aFk.hasAgree) {
                    this.dMV.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                    al.h(this.dMT, e.d.cp_cont_h);
                } else {
                    this.dMV.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                    al.h(this.dMT, e.d.cp_cont_f);
                }
            }
            al.h(this.dMS, e.d.cp_cont_f);
            this.dMU.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dNz != null) {
            this.aFk = gVar;
            this.axE = this.aFk.autoPlay;
            this.dMM.setVisibility(0);
            this.dMM.setText(gVar.title);
            this.dMN.setVisibility(0);
            this.dMN.setText(ao.dV(gVar.dNz.videoDuration * 1000));
            if (gVar.dNz.videoSize == 0) {
                format = this.mPageContext.getString(e.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(e.j.video_mobile_network_tips), og(String.format("%.1f", Float.valueOf(((float) gVar.dNz.videoSize) / 1048576.0f))));
            }
            this.dMP.setText(format);
            this.dMO.setVisibility(8);
            b(gVar, i, aVar);
            c(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dNz != null) {
            this.dMY.stopPlay();
            this.dMY.setIsNeedRecoveryVideoPlayer(true);
            this.dMY.mw(true);
            this.dMY.ms(false);
            this.dMY.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YQ() {
                    if (b.this.dMY.bqV()) {
                        b.this.dMN.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YR() {
                    if (b.this.dMY.bqV()) {
                        b.this.dMN.setVisibility(8);
                    }
                    if (b.this.dNd) {
                        b.this.dMY.stopPlay();
                    }
                }
            });
            this.dMY.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void aCU() {
                    b.this.dNd = false;
                    b.this.dMN.setVisibility(8);
                    b.this.oe(b.this.axE ? "1" : "2");
                    b.this.onClick(b.this.dML);
                }

                @Override // com.baidu.tieba.play.c.l
                public void aCV() {
                    b.this.dMN.setVisibility(8);
                    b.this.onClick(b.this.dMK);
                }
            });
            this.dMY.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void gT(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dMP.getText().toString());
                        b.this.dMY.aZ(b.this.aFk.dNz.videoUrl, b.this.aFk.threadId);
                        b.this.dMN.setVisibility(8);
                        b.this.oe("2");
                    } else {
                        b.this.dMO.setVisibility(0);
                    }
                    b.this.onClick(b.this.dML);
                }
            });
            this.dMY.mp(false);
            this.dNa = new z();
            this.dNa.biw = gVar.threadId;
            this.dNa.cXO = gVar.forumId;
            this.dNa.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dNb = new z();
            this.dNb.biw = gVar.threadId;
            this.dNb.cXO = gVar.forumId;
            this.dNb.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dNh) {
                am amVar = new am("c12590");
                amVar.aA("tid", gVar.threadId);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.x("obj_locate", i);
                amVar.x("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dNa.gEN = "auto_midpage";
                this.dNa.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dNa.gEP = "1";
                this.dNb.gEN = "auto_midpage";
                this.dNb.mLocate = "auto_midpage";
                this.dNb.gEP = "1";
            } else {
                this.dNa.gEP = "frs_bavideotab";
                this.dNa.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dNb.gEP = "frs_bavideotab";
                this.dNb.mLocate = "frs_bavideotab";
            }
            if (gVar.dNz != null) {
                this.dNa.gER = gVar.dNz.videoMd5;
                this.dNb.gER = gVar.dNz.videoMd5;
            }
            this.bOp.setVideoStatsData(this.dNa);
            this.dMY.getVideoView().setBusiness(this.bOp);
            this.dMY.aYO();
            this.dMY.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void gU(boolean z) {
                    if (!b.this.dMY.bqV()) {
                        b.this.dMM.setVisibility(0);
                    } else if (z) {
                        if (b.this.dMM.getVisibility() == 0) {
                            b.this.dMM.setVisibility(8);
                            b.this.dMM.startAnimation(b.this.dNe);
                        }
                    } else if (b.this.dMM.getVisibility() == 8) {
                        b.this.dMM.setVisibility(0);
                        b.this.dMM.startAnimation(b.this.dNf);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aCW() {
                    if (!b.this.dMY.bqV()) {
                        b.this.dMM.setVisibility(0);
                    } else if (b.this.dMM.getVisibility() == 0) {
                        b.this.dMM.setVisibility(8);
                        b.this.dMM.startAnimation(b.this.dNe);
                    }
                }
            });
            this.dMY.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dNd = true;
                        b.this.dNc = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.mt(i);
                        b.this.dMY.aLW();
                    }
                }
            });
            this.dMY.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.aFk != null && b.this.aFk.dNz != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.aFk.dNz.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dMY.setThumbnail(gVar.dNz.thumbnailUrl);
            this.dMY.setVideoUrl(gVar.dNz.videoUrl, gVar.threadId);
            this.dMY.tR(gVar.title);
            this.dMY.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void aCX() {
                    b.this.dMN.setVisibility(8);
                }
            });
            this.dMY.aLW();
            this.dMY.show();
            if (gVar.autoPlay) {
                onClick(this.dML);
                this.dNd = false;
                this.dMY.a(gVar.dNz.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.dNd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe(String str) {
        if (this.aFk != null && this.aFk.dNz != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFk.dNz.videoMd5, "", str, this.dNb);
            }
        }
    }

    public boolean isPlaying() {
        return this.dMY.bqV();
    }

    public void aCQ() {
        if (isPlaying()) {
            this.dMY.pausePlay();
        }
    }

    public boolean mu(int i) {
        return this.dMY.tl(i);
    }

    public void aCR() {
        this.dMO.setVisibility(8);
        this.dMY.stopPlay();
        if (this.dMM != null) {
            this.dMM.setVisibility(0);
        }
        if (this.dMN != null) {
            this.dMN.setVisibility(0);
        }
    }

    public void aCS() {
        if (this.dMY != null) {
            this.dMY.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aCS();
        if (this.dMZ != null) {
            this.dMZ.aDd();
        }
    }

    public String og(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dNy != null) {
            this.aKp.setText(TextUtils.isEmpty(gVar.dNy.userNickname) ? gVar.dNy.userName : gVar.dNy.userNickname);
            this.cCi.startLoad(gVar.dNy.portrait, 12, false);
            this.cCi.setShowV(gVar.dNy.isGod);
            this.cCi.setIsBigV(gVar.dNy.isGod);
            d(gVar);
            e(gVar);
            f(gVar);
        }
    }

    public void d(g gVar) {
        if (gVar != null && gVar.dNy != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dNy.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dNy.userId)) {
                this.dMR.setVisibility(8);
            } else {
                this.dMR.setVisibility(0);
            }
            if (gVar.dNy.hasFocus) {
                al.h(this.dMR, e.d.cp_cont_d);
                this.dMR.setCompoundDrawables(null, null, null, null);
                this.dMR.setText(this.mPageContext.getString(e.j.relate_forum_is_followed));
                return;
            }
            al.h(this.dMR, e.d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
            this.dMR.setCompoundDrawables(drawable, null, null, null);
            this.dMR.setText(this.mPageContext.getString(e.j.attention));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dMV.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                al.h(this.dMT, e.d.cp_cont_h);
            } else {
                this.dMV.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                al.h(this.dMT, e.d.cp_cont_f);
            }
            this.dMT.setText(ao.W(gVar.agreeNum));
        }
    }

    public void f(g gVar) {
        if (gVar != null) {
            al.h(this.dMS, e.d.cp_cont_f);
            this.dMU.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
            this.dMS.setText(ao.W(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dMY != null && this.dML != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dNc) {
                this.dMY.bqU();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dML.getParent() != null) {
                    if (this.dML.getParent() == frameLayout) {
                        frameLayout.removeView(this.dML);
                    } else if (this.dML.getParent() == this.dMK) {
                        this.dMK.removeView(this.dML);
                    }
                }
                if (this.dML.getParent() == null) {
                    frameLayout.addView(this.dML);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dML.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dML.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dML.getParent() != null) {
                    if (this.dML.getParent() == frameLayout) {
                        frameLayout.removeView(this.dML);
                    } else if (this.dML.getParent() == this.dMK) {
                        this.dMK.removeView(this.dML);
                    }
                }
                if (this.dML.getParent() == null) {
                    this.dMK.addView(this.dML, 0);
                    this.dML.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dMY.aYO();
                    this.dNc = true;
                } else {
                    return;
                }
            }
            this.dMY.a(this.mPageContext, configuration);
            this.dMN.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apc() != null) {
            view.setTag(this);
            apc().a(view, this.aFk);
        }
        if (view == this.cCi || view == this.aKp) {
            boolean z = false;
            if (this.aFk != null && this.aFk.dNy != null && !TextUtils.isEmpty(this.aFk.dNy.userId)) {
                if (TbadkCoreApplication.isLogin() && this.aFk.dNy.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFk.dNy.userId, 0L), z, this.aFk.dNy.isGod)));
            }
        } else if (view == this.dMW || view == this.dMM || view == getView()) {
            if (this.aFk != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFk.threadId, null, null);
                if (!this.dNh) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dMQ) {
            if (this.aFk != null && this.aFk.dNz != null) {
                this.dMO.setVisibility(8);
                this.dMY.bqY();
                this.dMY.aZ(this.aFk.dNz.videoUrl, this.aFk.threadId);
                oe("2");
            }
        } else if (view == this.dMR) {
            if (!this.aFk.dNy.hasFocus) {
                this.dMZ.g(this.aFk);
            }
        } else if (view == this.dMX) {
            this.dMZ.h(this.aFk);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gS(boolean z) {
        if (this.aFk != null && this.aFk.dNy != null) {
            this.aFk.dNy.hasFocus = z;
            d(this.aFk);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aCT() {
        if (this.aFk != null) {
            this.aFk.hasAgree = !this.aFk.hasAgree;
            if (this.aFk.hasAgree) {
                this.aFk.agreeNum++;
            } else {
                this.aFk.agreeNum--;
            }
            if (this.dMV != null) {
                this.dMV.startAnimation(getScaleAnimation());
            }
            e(this.aFk);
        }
    }

    private Animation getScaleAnimation() {
        if (this.dNg == null) {
            this.dNg = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dNg.setDuration(200L);
        }
        return this.dNg;
    }
}
