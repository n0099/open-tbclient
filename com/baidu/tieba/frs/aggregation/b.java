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
    public TextView Zz;
    private Animation afe;
    private boolean bGf;
    public HeadImageView dQK;
    private n dbi;
    public FrameLayout fdQ;
    public FrameLayout fdR;
    public TextView fdS;
    public TextView fdT;
    public FrameLayout fdU;
    public TextView fdV;
    public TextView fdW;
    public TextView fdX;
    public TextView fdY;
    public TextView fdZ;
    public ImageView fea;
    public ImageView feb;
    public LinearLayout fec;
    public LinearLayout fed;
    public com.baidu.tieba.play.c fee;
    public g fef;
    private h feg;
    private z feh;
    private z fei;
    private boolean fej;
    private boolean fek;
    private Animation fel;
    private ScaleAnimation fem;
    private boolean fen;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fej = true;
        this.fen = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fdQ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.fdR = (FrameLayout) view.findViewById(d.g.video_container);
        this.fee = new com.baidu.tieba.play.c(tbPageContext, (View) this.fdR, false);
        this.fdS = (TextView) view.findViewById(d.g.title);
        this.fdT = (TextView) view.findViewById(d.g.duration);
        this.fdU = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.fdV = (TextView) view.findViewById(d.g.mobile_network_text);
        this.fdW = (TextView) view.findViewById(d.g.mobile_network_play);
        this.dQK = (HeadImageView) view.findViewById(d.g.user_icon);
        this.Zz = (TextView) view.findViewById(d.g.user_name);
        this.fdX = (TextView) view.findViewById(d.g.attention);
        this.fec = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.fed = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.fdY = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.fdZ = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.fea = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.feb = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.fec.setOnClickListener(this);
        this.fed.setOnClickListener(this);
        this.fdS.setOnClickListener(this);
        this.dQK.setOnClickListener(this);
        this.Zz.setOnClickListener(this);
        this.fdX.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fdW.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fdQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fdQ.setLayoutParams(layoutParams);
        this.dQK.setIsRound(true);
        this.dbi = new n(tbPageContext.getPageActivity());
        this.feg = new h(this.mPageContext, this);
        this.fel = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.afe = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.l(getView(), d.C0277d.cp_bg_line_d);
            if (this.fef != null && this.fef.feE != null) {
                if (this.fef.feE.hasFocus) {
                    al.j(this.fdX, d.C0277d.cp_cont_d);
                    this.fdX.setCompoundDrawables(null, null, null, null);
                } else {
                    al.j(this.fdX, d.C0277d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, d.e.ds20), l.h(this.mContext, d.e.ds20));
                    this.fdX.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fef != null) {
                if (this.fef.hasAgree) {
                    this.feb.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_s));
                    al.j(this.fdZ, d.C0277d.cp_cont_h);
                } else {
                    this.feb.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_n));
                    al.j(this.fdZ, d.C0277d.cp_cont_f);
                }
            }
            al.j(this.fdY, d.C0277d.cp_cont_f);
            this.fea.setImageDrawable(al.getDrawable(d.f.icon_home_card_comment));
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
        if (gVar != null && gVar.feF != null) {
            this.fef = gVar;
            this.bGf = this.fef.autoPlay;
            this.fdS.setVisibility(0);
            this.fdS.setText(gVar.title);
            this.fdT.setVisibility(0);
            this.fdT.setText(ap.hy(gVar.feF.videoDuration * 1000));
            if (gVar.feF.videoSize == 0) {
                format = this.mPageContext.getString(d.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.j.video_mobile_network_tips), vc(String.format("%.1f", Float.valueOf(((float) gVar.feF.videoSize) / 1048576.0f))));
            }
            this.fdV.setText(format);
            this.fdU.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.feF != null) {
            this.fee.stopPlay();
            this.fee.setIsNeedRecoveryVideoPlayer(true);
            this.fee.oX(true);
            this.fee.oT(false);
            this.fee.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                    if (b.this.fee.ql()) {
                        b.this.fdT.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                    if (b.this.fee.ql()) {
                        b.this.fdT.setVisibility(8);
                    }
                    if (b.this.fek) {
                        b.this.fee.stopPlay();
                    }
                }
            });
            this.fee.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void beN() {
                    b.this.fek = false;
                    b.this.fdT.setVisibility(8);
                    b.this.vb(b.this.bGf ? "1" : "2");
                    b.this.onClick(b.this.fdR);
                }

                @Override // com.baidu.tieba.play.c.l
                public void beO() {
                    b.this.fdT.setVisibility(8);
                    b.this.onClick(b.this.fdQ);
                }
            });
            this.fee.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void jx(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fdV.getText().toString());
                        b.this.fee.cf(b.this.fef.feF.videoUrl, b.this.fef.threadId);
                        b.this.fdT.setVisibility(8);
                        b.this.vb("2");
                    } else {
                        b.this.fdU.setVisibility(0);
                    }
                    b.this.onClick(b.this.fdR);
                }
            });
            this.fee.oP(false);
            this.feh = new z();
            this.feh.ctx = gVar.threadId;
            this.feh.ekN = gVar.forumId;
            this.feh.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fei = new z();
            this.fei.ctx = gVar.threadId;
            this.fei.ekN = gVar.forumId;
            this.fei.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fen) {
                am amVar = new am("c12590");
                amVar.bJ("tid", gVar.threadId);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.T("obj_locate", i);
                amVar.T("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.feh.hYy = "auto_midpage";
                this.feh.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.feh.hYA = "1";
                this.fei.hYy = "auto_midpage";
                this.fei.mLocate = "auto_midpage";
                this.fei.hYA = "1";
            } else {
                this.feh.hYA = "frs_bavideotab";
                this.feh.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fei.hYA = "frs_bavideotab";
                this.fei.mLocate = "frs_bavideotab";
            }
            if (gVar.feF != null) {
                this.feh.hYC = gVar.feF.videoMd5;
                this.fei.hYC = gVar.feF.videoMd5;
            }
            this.dbi.setVideoStatsData(this.feh);
            this.fee.getVideoView().setBusiness(this.dbi);
            this.fee.bAD();
            this.fee.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void jy(boolean z) {
                    if (!b.this.fee.ql()) {
                        b.this.fdS.setVisibility(0);
                    } else if (z) {
                        if (b.this.fdS.getVisibility() == 0) {
                            b.this.fdS.setVisibility(8);
                            b.this.fdS.startAnimation(b.this.fel);
                        }
                    } else if (b.this.fdS.getVisibility() == 8) {
                        b.this.fdS.setVisibility(0);
                        b.this.fdS.startAnimation(b.this.afe);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void beP() {
                    if (!b.this.fee.ql()) {
                        b.this.fdS.setVisibility(0);
                    } else if (b.this.fdS.getVisibility() == 0) {
                        b.this.fdS.setVisibility(8);
                        b.this.fdS.startAnimation(b.this.fel);
                    }
                }
            });
            this.fee.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fek = true;
                        b.this.fej = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.qr(i);
                        b.this.fee.bnN();
                    }
                }
            });
            this.fee.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fef != null && b.this.fef.feF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fef.feF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fee.setThumbnail(gVar.feF.thumbnailUrl);
            this.fee.setVideoUrl(gVar.feF.videoUrl, gVar.threadId);
            this.fee.AN(gVar.title);
            this.fee.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void beQ() {
                    b.this.fdT.setVisibility(8);
                }
            });
            this.fee.bnN();
            this.fee.show();
            if (gVar.autoPlay) {
                onClick(this.fdR);
                this.fek = false;
                this.fee.a(gVar.feF.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fek = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(String str) {
        if (this.fef != null && this.fef.feF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fef.feF.videoMd5, "", str, this.fei);
            }
        }
    }

    public boolean isPlaying() {
        return this.fee.ql();
    }

    public void beJ() {
        if (isPlaying()) {
            this.fee.pausePlay();
        }
    }

    public boolean qs(int i) {
        return this.fee.xh(i);
    }

    public void beK() {
        this.fdU.setVisibility(8);
        this.fee.stopPlay();
        if (this.fdS != null) {
            this.fdS.setVisibility(0);
        }
        if (this.fdT != null) {
            this.fdT.setVisibility(0);
        }
    }

    public void beL() {
        if (this.fee != null) {
            this.fee.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        beL();
        if (this.feg != null) {
            this.feg.beW();
        }
    }

    public String vc(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.feE != null) {
            this.Zz.setText(TextUtils.isEmpty(gVar.feE.userNickname) ? gVar.feE.userName : gVar.feE.userNickname);
            this.dQK.startLoad(gVar.feE.portrait, 12, false);
            this.dQK.setShowV(gVar.feE.isGod);
            this.dQK.setIsBigV(gVar.feE.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.feE != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.feE.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.feE.userId)) {
                this.fdX.setVisibility(8);
            } else {
                this.fdX.setVisibility(0);
            }
            if (gVar.feE.hasFocus) {
                al.j(this.fdX, d.C0277d.cp_cont_d);
                this.fdX.setCompoundDrawables(null, null, null, null);
                this.fdX.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                return;
            }
            al.j(this.fdX, d.C0277d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, d.e.ds20), l.h(this.mContext, d.e.ds20));
            this.fdX.setCompoundDrawables(drawable, null, null, null);
            this.fdX.setText(this.mPageContext.getString(d.j.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.feb.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_s));
                al.j(this.fdZ, d.C0277d.cp_cont_h);
            } else {
                this.feb.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_n));
                al.j(this.fdZ, d.C0277d.cp_cont_f);
            }
            this.fdZ.setText(ap.az(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            al.j(this.fdY, d.C0277d.cp_cont_f);
            this.fea.setImageDrawable(al.getDrawable(d.f.icon_home_card_comment));
            this.fdY.setText(ap.az(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fee != null && this.fdR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fej) {
                this.fee.bSJ();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fdR.getParent() != null) {
                    if (this.fdR.getParent() == frameLayout) {
                        frameLayout.removeView(this.fdR);
                    } else if (this.fdR.getParent() == this.fdQ) {
                        this.fdQ.removeView(this.fdR);
                    }
                }
                if (this.fdR.getParent() == null) {
                    frameLayout.addView(this.fdR);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdR.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fdR.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fdR.getParent() != null) {
                    if (this.fdR.getParent() == frameLayout) {
                        frameLayout.removeView(this.fdR);
                    } else if (this.fdR.getParent() == this.fdQ) {
                        this.fdQ.removeView(this.fdR);
                    }
                }
                if (this.fdR.getParent() == null) {
                    this.fdQ.addView(this.fdR, 0);
                    this.fdR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fee.bAD();
                    this.fej = true;
                } else {
                    return;
                }
            }
            this.fee.a(this.mPageContext, configuration);
            this.fdT.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQf() != null) {
            view.setTag(this);
            aQf().a(view, this.fef);
        }
        if (view == this.dQK || view == this.Zz) {
            boolean z = false;
            if (this.fef != null && this.fef.feE != null && !TextUtils.isEmpty(this.fef.feE.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fef.feE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.fef.feE.userId, 0L), z, this.fef.feE.isGod)));
            }
        } else if (view == this.fec || view == this.fdS || view == getView()) {
            if (this.fef != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fef.threadId, null, null);
                if (!this.fen) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fdW) {
            if (this.fef != null && this.fef.feF != null) {
                this.fdU.setVisibility(8);
                this.fee.bSM();
                this.fee.cf(this.fef.feF.videoUrl, this.fef.threadId);
                vb("2");
            }
        } else if (view == this.fdX) {
            if (!this.fef.feE.hasFocus) {
                this.feg.f(this.fef);
            }
        } else if (view == this.fed) {
            this.feg.g(this.fef);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void jw(boolean z) {
        if (this.fef != null && this.fef.feE != null) {
            this.fef.feE.hasFocus = z;
            c(this.fef);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void beM() {
        if (this.fef != null) {
            this.fef.hasAgree = !this.fef.hasAgree;
            if (this.fef.hasAgree) {
                this.fef.agreeNum++;
            } else {
                this.fef.agreeNum--;
            }
            if (this.feb != null) {
                this.feb.startAnimation(getScaleAnimation());
            }
            d(this.fef);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fem == null) {
            this.fem = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fem.setDuration(200L);
        }
        return this.fem;
    }
}
