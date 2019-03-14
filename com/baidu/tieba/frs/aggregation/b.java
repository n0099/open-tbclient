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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView Zy;
    private Animation aeY;
    private boolean bGc;
    public HeadImageView dRs;
    private n dbe;
    private boolean feA;
    public FrameLayout fed;
    public FrameLayout fee;
    public TextView fef;
    public TextView feg;
    public FrameLayout feh;
    public TextView fei;
    public TextView fej;
    public TextView fek;
    public TextView fel;
    public TextView fem;
    public ImageView fen;
    public ImageView feo;
    public LinearLayout fep;
    public LinearLayout feq;
    public com.baidu.tieba.play.c fer;
    public g fes;
    private h fet;
    private z feu;
    private z fev;
    private boolean few;
    private boolean fex;
    private Animation fey;
    private ScaleAnimation fez;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.few = true;
        this.feA = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fed = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.fee = (FrameLayout) view.findViewById(d.g.video_container);
        this.fer = new com.baidu.tieba.play.c(tbPageContext, (View) this.fee, false);
        this.fef = (TextView) view.findViewById(d.g.title);
        this.feg = (TextView) view.findViewById(d.g.duration);
        this.feh = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.fei = (TextView) view.findViewById(d.g.mobile_network_text);
        this.fej = (TextView) view.findViewById(d.g.mobile_network_play);
        this.dRs = (HeadImageView) view.findViewById(d.g.user_icon);
        this.Zy = (TextView) view.findViewById(d.g.user_name);
        this.fek = (TextView) view.findViewById(d.g.attention);
        this.fep = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.feq = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.fel = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.fem = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.fen = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.feo = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.fep.setOnClickListener(this);
        this.feq.setOnClickListener(this);
        this.fef.setOnClickListener(this);
        this.dRs.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.fek.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fej.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fed.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fed.setLayoutParams(layoutParams);
        this.dRs.setIsRound(true);
        this.dbe = new n(tbPageContext.getPageActivity());
        this.fet = new h(this.mPageContext, this);
        this.fey = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.aeY = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.l(getView(), d.C0277d.cp_bg_line_d);
            if (this.fes != null && this.fes.feR != null) {
                if (this.fes.feR.hasFocus) {
                    al.j(this.fek, d.C0277d.cp_cont_d);
                    this.fek.setCompoundDrawables(null, null, null, null);
                } else {
                    al.j(this.fek, d.C0277d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, d.e.ds20), l.h(this.mContext, d.e.ds20));
                    this.fek.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fes != null) {
                if (this.fes.hasAgree) {
                    this.feo.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_s));
                    al.j(this.fem, d.C0277d.cp_cont_h);
                } else {
                    this.feo.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_n));
                    al.j(this.fem, d.C0277d.cp_cont_f);
                }
            }
            al.j(this.fel, d.C0277d.cp_cont_f);
            this.fen.setImageDrawable(al.getDrawable(d.f.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.feS != null) {
            this.fes = gVar;
            this.bGc = this.fes.autoPlay;
            this.fef.setVisibility(0);
            this.fef.setText(gVar.title);
            this.feg.setVisibility(0);
            this.feg.setText(ap.hz(gVar.feS.videoDuration * 1000));
            if (gVar.feS.videoSize == 0) {
                format = this.mPageContext.getString(d.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.j.video_mobile_network_tips), vd(String.format("%.1f", Float.valueOf(((float) gVar.feS.videoSize) / 1048576.0f))));
            }
            this.fei.setText(format);
            this.feh.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.feS != null) {
            this.fer.stopPlay();
            this.fer.setIsNeedRecoveryVideoPlayer(true);
            this.fer.oX(true);
            this.fer.oT(false);
            this.fer.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                    if (b.this.fer.ql()) {
                        b.this.feg.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                    if (b.this.fer.ql()) {
                        b.this.feg.setVisibility(8);
                    }
                    if (b.this.fex) {
                        b.this.fer.stopPlay();
                    }
                }
            });
            this.fer.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void beP() {
                    b.this.fex = false;
                    b.this.feg.setVisibility(8);
                    b.this.vc(b.this.bGc ? "1" : "2");
                    b.this.onClick(b.this.fee);
                }

                @Override // com.baidu.tieba.play.c.l
                public void beQ() {
                    b.this.feg.setVisibility(8);
                    b.this.onClick(b.this.fed);
                }
            });
            this.fer.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void jx(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fei.getText().toString());
                        b.this.fer.cf(b.this.fes.feS.videoUrl, b.this.fes.threadId);
                        b.this.feg.setVisibility(8);
                        b.this.vc("2");
                    } else {
                        b.this.feh.setVisibility(0);
                    }
                    b.this.onClick(b.this.fee);
                }
            });
            this.fer.oP(false);
            this.feu = new z();
            this.feu.ctu = gVar.threadId;
            this.feu.ela = gVar.forumId;
            this.feu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fev = new z();
            this.fev.ctu = gVar.threadId;
            this.fev.ela = gVar.forumId;
            this.fev.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.feA) {
                am amVar = new am("c12590");
                amVar.bJ("tid", gVar.threadId);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.T("obj_locate", i);
                amVar.T("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.feu.hYL = "auto_midpage";
                this.feu.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.feu.hYN = "1";
                this.fev.hYL = "auto_midpage";
                this.fev.mLocate = "auto_midpage";
                this.fev.hYN = "1";
            } else {
                this.feu.hYN = "frs_bavideotab";
                this.feu.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fev.hYN = "frs_bavideotab";
                this.fev.mLocate = "frs_bavideotab";
            }
            if (gVar.feS != null) {
                this.feu.hYP = gVar.feS.videoMd5;
                this.fev.hYP = gVar.feS.videoMd5;
            }
            this.dbe.setVideoStatsData(this.feu);
            this.fer.getVideoView().setBusiness(this.dbe);
            this.fer.bAG();
            this.fer.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void jy(boolean z) {
                    if (!b.this.fer.ql()) {
                        b.this.fef.setVisibility(0);
                    } else if (z) {
                        if (b.this.fef.getVisibility() == 0) {
                            b.this.fef.setVisibility(8);
                            b.this.fef.startAnimation(b.this.fey);
                        }
                    } else if (b.this.fef.getVisibility() == 8) {
                        b.this.fef.setVisibility(0);
                        b.this.fef.startAnimation(b.this.aeY);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void beR() {
                    if (!b.this.fer.ql()) {
                        b.this.fef.setVisibility(0);
                    } else if (b.this.fef.getVisibility() == 0) {
                        b.this.fef.setVisibility(8);
                        b.this.fef.startAnimation(b.this.fey);
                    }
                }
            });
            this.fer.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fex = true;
                        b.this.few = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.qv(i);
                        b.this.fer.bnQ();
                    }
                }
            });
            this.fer.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fes != null && b.this.fes.feS != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fes.feS.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fer.setThumbnail(gVar.feS.thumbnailUrl);
            this.fer.setVideoUrl(gVar.feS.videoUrl, gVar.threadId);
            this.fer.AO(gVar.title);
            this.fer.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void beS() {
                    b.this.feg.setVisibility(8);
                }
            });
            this.fer.bnQ();
            this.fer.show();
            if (gVar.autoPlay) {
                onClick(this.fee);
                this.fex = false;
                this.fer.a(gVar.feS.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fex = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(String str) {
        if (this.fes != null && this.fes.feS != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fes.feS.videoMd5, "", str, this.fev);
            }
        }
    }

    public boolean isPlaying() {
        return this.fer.ql();
    }

    public void beL() {
        if (isPlaying()) {
            this.fer.pausePlay();
        }
    }

    public boolean qw(int i) {
        return this.fer.xl(i);
    }

    public void beM() {
        this.feh.setVisibility(8);
        this.fer.stopPlay();
        if (this.fef != null) {
            this.fef.setVisibility(0);
        }
        if (this.feg != null) {
            this.feg.setVisibility(0);
        }
    }

    public void beN() {
        if (this.fer != null) {
            this.fer.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        beN();
        if (this.fet != null) {
            this.fet.beY();
        }
    }

    public String vd(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.feR != null) {
            this.Zy.setText(TextUtils.isEmpty(gVar.feR.userNickname) ? gVar.feR.userName : gVar.feR.userNickname);
            this.dRs.startLoad(gVar.feR.portrait, 12, false);
            this.dRs.setShowV(gVar.feR.isGod);
            this.dRs.setIsBigV(gVar.feR.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.feR != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.feR.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.feR.userId)) {
                this.fek.setVisibility(8);
            } else {
                this.fek.setVisibility(0);
            }
            if (gVar.feR.hasFocus) {
                al.j(this.fek, d.C0277d.cp_cont_d);
                this.fek.setCompoundDrawables(null, null, null, null);
                this.fek.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                return;
            }
            al.j(this.fek, d.C0277d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, d.e.ds20), l.h(this.mContext, d.e.ds20));
            this.fek.setCompoundDrawables(drawable, null, null, null);
            this.fek.setText(this.mPageContext.getString(d.j.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.feo.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_s));
                al.j(this.fem, d.C0277d.cp_cont_h);
            } else {
                this.feo.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_n));
                al.j(this.fem, d.C0277d.cp_cont_f);
            }
            this.fem.setText(ap.az(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            al.j(this.fel, d.C0277d.cp_cont_f);
            this.fen.setImageDrawable(al.getDrawable(d.f.icon_home_card_comment));
            this.fel.setText(ap.az(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fer != null && this.fee != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.few) {
                this.fer.bSN();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fee.getParent() != null) {
                    if (this.fee.getParent() == frameLayout) {
                        frameLayout.removeView(this.fee);
                    } else if (this.fee.getParent() == this.fed) {
                        this.fed.removeView(this.fee);
                    }
                }
                if (this.fee.getParent() == null) {
                    frameLayout.addView(this.fee);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fee.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fee.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fee.getParent() != null) {
                    if (this.fee.getParent() == frameLayout) {
                        frameLayout.removeView(this.fee);
                    } else if (this.fee.getParent() == this.fed) {
                        this.fed.removeView(this.fee);
                    }
                }
                if (this.fee.getParent() == null) {
                    this.fed.addView(this.fee, 0);
                    this.fee.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fer.bAG();
                    this.few = true;
                } else {
                    return;
                }
            }
            this.fer.a(this.mPageContext, configuration);
            this.feg.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQh() != null) {
            view.setTag(this);
            aQh().a(view, this.fes);
        }
        if (view == this.dRs || view == this.Zy) {
            boolean z = false;
            if (this.fes != null && this.fes.feR != null && !TextUtils.isEmpty(this.fes.feR.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fes.feR.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.fes.feR.userId, 0L), z, this.fes.feR.isGod)));
            }
        } else if (view == this.fep || view == this.fef || view == getView()) {
            if (this.fes != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fes.threadId, null, null);
                if (!this.feA) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fej) {
            if (this.fes != null && this.fes.feS != null) {
                this.feh.setVisibility(8);
                this.fer.bSQ();
                this.fer.cf(this.fes.feS.videoUrl, this.fes.threadId);
                vc("2");
            }
        } else if (view == this.fek) {
            if (!this.fes.feR.hasFocus) {
                this.fet.f(this.fes);
            }
        } else if (view == this.feq) {
            this.fet.g(this.fes);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void jw(boolean z) {
        if (this.fes != null && this.fes.feR != null) {
            this.fes.feR.hasFocus = z;
            c(this.fes);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void beO() {
        if (this.fes != null) {
            this.fes.hasAgree = !this.fes.hasAgree;
            if (this.fes.hasAgree) {
                this.fes.agreeNum++;
            } else {
                this.fes.agreeNum--;
            }
            if (this.feo != null) {
                this.feo.startAnimation(getScaleAnimation());
            }
            d(this.fes);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fez == null) {
            this.fez = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fez.setDuration(200L);
        }
        return this.fez;
    }
}
