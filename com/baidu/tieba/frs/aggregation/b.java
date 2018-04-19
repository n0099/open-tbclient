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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    private ScaleAnimation apc;
    public TextView apg;
    public TextView bKz;
    public HeadImageView bWg;
    private n bkR;
    public FrameLayout daL;
    public FrameLayout daM;
    public TextView daN;
    public TextView daO;
    public FrameLayout daP;
    public TextView daQ;
    public TextView daR;
    public TextView daS;
    public TextView daT;
    public ImageView daU;
    public ImageView daV;
    public LinearLayout daW;
    public LinearLayout daX;
    public com.baidu.tieba.play.c daY;
    public g daZ;
    private h dba;
    private y dbb;
    private y dbc;
    private boolean dbd;
    private boolean dbe;
    private Animation dbf;
    private Animation dbg;
    private boolean dbh;
    private boolean dbi;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dbd = true;
        this.dbi = z;
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.daL = (FrameLayout) view2.findViewById(d.g.video_agg_container);
        this.daM = (FrameLayout) view2.findViewById(d.g.video_container);
        this.daY = new com.baidu.tieba.play.c(tbPageContext, this.daM, false);
        this.daN = (TextView) view2.findViewById(d.g.title);
        this.daO = (TextView) view2.findViewById(d.g.duration);
        this.daP = (FrameLayout) view2.findViewById(d.g.mobile_network_container);
        this.daQ = (TextView) view2.findViewById(d.g.mobile_network_text);
        this.daR = (TextView) view2.findViewById(d.g.mobile_network_play);
        this.bWg = (HeadImageView) view2.findViewById(d.g.user_icon);
        this.apg = (TextView) view2.findViewById(d.g.user_name);
        this.bKz = (TextView) view2.findViewById(d.g.attention);
        this.daW = (LinearLayout) view2.findViewById(d.g.thread_info_commont_container);
        this.daX = (LinearLayout) view2.findViewById(d.g.agree_view_container);
        this.daS = (TextView) view2.findViewById(d.g.thread_info_commont_num);
        this.daT = (TextView) view2.findViewById(d.g.thread_info_praise_num);
        this.daU = (ImageView) view2.findViewById(d.g.thread_info_commont_img);
        this.daV = (ImageView) view2.findViewById(d.g.thread_info_praise_img);
        this.daW.setOnClickListener(this);
        this.daX.setOnClickListener(this);
        this.daN.setOnClickListener(this);
        this.bWg.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.bKz.setOnClickListener(this);
        view2.setOnClickListener(this);
        this.daR.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.daL.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.daL.setLayoutParams(layoutParams);
        this.bWg.setIsRound(true);
        this.bkR = new n(tbPageContext.getPageActivity());
        this.dba = new h(this.mPageContext, this);
        this.dbf = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dbg = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().u(getView());
            ak.j(getView(), d.C0126d.cp_bg_line_d);
            if (this.daZ != null && this.daZ.dby != null) {
                if (this.daZ.dby.hasFocus) {
                    ak.h(this.bKz, d.C0126d.cp_cont_d);
                    this.bKz.setCompoundDrawables(null, null, null, null);
                } else {
                    ak.h(this.bKz, d.C0126d.cp_link_tip_a);
                    Drawable drawable = ak.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
                    this.bKz.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.daZ != null) {
                if (this.daZ.hasAgree) {
                    this.daV.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_s));
                    ak.h(this.daT, d.C0126d.cp_cont_h);
                } else {
                    this.daV.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_n));
                    ak.h(this.daT, d.C0126d.cp_cont_f);
                }
            }
            ak.h(this.daS, d.C0126d.cp_cont_f);
            this.daU.setImageDrawable(ak.getDrawable(d.f.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.dbz != null) {
            this.daZ = gVar;
            this.dbh = this.daZ.autoPlay;
            this.daN.setVisibility(0);
            this.daN.setText(gVar.title);
            this.daO.setVisibility(0);
            this.daO.setText(an.cU(gVar.dbz.videoDuration * 1000));
            if (gVar.dbz.videoSize == 0) {
                format = this.mPageContext.getString(d.k.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.k.video_mobile_network_tips), lP(String.format("%.1f", Float.valueOf(((float) gVar.dbz.videoSize) / 1048576.0f))));
            }
            this.daQ.setText(format);
            this.daP.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dbz != null) {
            this.daY.stopPlay();
            this.daY.ln(true);
            this.daY.lq(true);
            this.daY.lo(false);
            this.daY.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    if (b.this.daY.bga()) {
                        b.this.daO.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                    if (b.this.daY.bga()) {
                        b.this.daO.setVisibility(8);
                    }
                    if (b.this.dbe) {
                        b.this.daY.stopPlay();
                    }
                }
            });
            this.daY.a(new c.k() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    b.this.dbe = false;
                    b.this.daO.setVisibility(8);
                    b.this.lO(b.this.dbh ? "1" : "2");
                    b.this.onClick(b.this.daM);
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqY() {
                    b.this.daO.setVisibility(8);
                    b.this.onClick(b.this.daL);
                }
            });
            this.daY.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.e
                public void fF(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.daQ.getText().toString());
                        b.this.daY.bL(b.this.daZ.dbz.videoUrl, b.this.daZ.threadId);
                        b.this.daO.setVisibility(8);
                        b.this.lO("2");
                    } else {
                        b.this.daP.setVisibility(0);
                    }
                    b.this.onClick(b.this.daM);
                }
            });
            this.daY.ll(false);
            this.dbb = new y();
            this.dbb.aNu = gVar.threadId;
            this.dbb.crJ = gVar.forumId;
            this.dbb.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dbc = new y();
            this.dbc.aNu = gVar.threadId;
            this.dbc.crJ = gVar.forumId;
            this.dbc.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dbi) {
                al alVar = new al("c12590");
                alVar.ac("tid", gVar.threadId);
                alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                alVar.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                alVar.r("obj_locate", i);
                alVar.r("obj_param2", 1);
                TiebaStatic.log(alVar);
                this.dbb.fQM = "auto_midpage";
                this.dbb.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dbb.fQO = "1";
                this.dbc.fQM = "auto_midpage";
                this.dbc.mLocate = "auto_midpage";
                this.dbc.fQO = "1";
            } else {
                this.dbb.fQO = "frs_bavideotab";
                this.dbb.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dbc.fQO = "frs_bavideotab";
                this.dbc.mLocate = "frs_bavideotab";
            }
            if (gVar.dbz != null) {
                this.dbb.fQQ = gVar.dbz.videoMd5;
                this.dbc.fQQ = gVar.dbz.videoMd5;
            }
            this.bkR.setVideoStatsData(this.dbb);
            this.daY.getVideoView().setBusiness(this.bkR);
            this.daY.aLy();
            this.daY.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (!b.this.daY.bga()) {
                        b.this.daN.setVisibility(0);
                    } else if (z) {
                        if (b.this.daN.getVisibility() == 0) {
                            b.this.daN.setVisibility(8);
                            b.this.daN.startAnimation(b.this.dbf);
                        }
                    } else if (b.this.daN.getVisibility() == 8) {
                        b.this.daN.setVisibility(0);
                        b.this.daN.startAnimation(b.this.dbg);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqZ() {
                    if (!b.this.daY.bga()) {
                        b.this.daN.setVisibility(0);
                    } else if (b.this.daN.getVisibility() == 0) {
                        b.this.daN.setVisibility(8);
                        b.this.daN.startAnimation(b.this.dbf);
                    }
                }
            });
            this.daY.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dbe = true;
                        b.this.dbd = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.kp(i);
                        b.this.daY.ayA();
                    }
                }
            });
            this.daY.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.daZ != null && b.this.daZ.dbz != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.daZ.dbz.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.daY.oz(gVar.dbz.thumbnailUrl);
            this.daY.bK(gVar.dbz.videoUrl, gVar.threadId);
            this.daY.rn(gVar.title);
            this.daY.a(new c.h() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.h
                public void ara() {
                    b.this.daO.setVisibility(8);
                }
            });
            this.daY.ayA();
            this.daY.show();
            if (gVar.autoPlay) {
                onClick(this.daM);
                this.dbe = false;
                this.daY.a(gVar.dbz.videoUrl, gVar.threadId, null, new Object[0]);
            }
            this.dbe = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(String str) {
        if (this.daZ != null && this.daZ.dbz != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.daZ.dbz.videoMd5, "", str, this.dbc);
            }
        }
    }

    public boolean isPlaying() {
        return this.daY.bga();
    }

    public void aqR() {
        if (isPlaying()) {
            this.daY.pausePlay();
        }
    }

    public boolean kq(int i) {
        return this.daY.rn(i);
    }

    public void aqS() {
        this.daP.setVisibility(8);
        this.daY.stopPlay();
        if (this.daN != null) {
            this.daN.setVisibility(0);
        }
        if (this.daO != null) {
            this.daO.setVisibility(0);
        }
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
    }

    public String lP(String str) {
        if (str.indexOf(com.baidu.ar.util.Constants.DOT) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.dby != null) {
            this.apg.setText(TextUtils.isEmpty(gVar.dby.userNickname) ? gVar.dby.userName : gVar.dby.userNickname);
            this.bWg.startLoad(gVar.dby.portrait, 12, false);
            this.bWg.setShowV(gVar.dby.isGod);
            this.bWg.setIsBigV(gVar.dby.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dby != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dby.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dby.userId)) {
                this.bKz.setVisibility(8);
            } else {
                this.bKz.setVisibility(0);
            }
            if (gVar.dby.hasFocus) {
                ak.h(this.bKz, d.C0126d.cp_cont_d);
                this.bKz.setCompoundDrawables(null, null, null, null);
                this.bKz.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                return;
            }
            ak.h(this.bKz, d.C0126d.cp_link_tip_a);
            Drawable drawable = ak.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
            this.bKz.setCompoundDrawables(drawable, null, null, null);
            this.bKz.setText(this.mPageContext.getString(d.k.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.daV.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_s));
                ak.h(this.daT, d.C0126d.cp_cont_h);
            } else {
                this.daV.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_n));
                ak.h(this.daT, d.C0126d.cp_cont_f);
            }
            this.daT.setText(an.B(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ak.h(this.daS, d.C0126d.cp_cont_f);
            this.daU.setImageDrawable(ak.getDrawable(d.f.icon_home_card_comment));
            this.daS.setText(an.B(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.daY != null && this.daM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dbd) {
                this.daY.bfZ();
            }
            if (configuration.orientation == 2) {
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
                } else {
                    return;
                }
            } else {
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
                    this.daM.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.daY.aLy();
                    this.dbd = true;
                } else {
                    return;
                }
            }
            this.daY.a(this.mPageContext, configuration);
            this.daO.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            view2.setTag(this);
            aeZ().a(view2, this.daZ);
        }
        if (view2 == this.bWg || view2 == this.apg) {
            boolean z = false;
            if (this.daZ != null && this.daZ.dby != null && !TextUtils.isEmpty(this.daZ.dby.userId)) {
                if (TbadkCoreApplication.isLogin() && this.daZ.dby.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.daZ.dby.userId, 0L), z, this.daZ.dby.isGod)));
            }
        } else if (view2 == this.daW || view2 == this.daN || view2 == getView()) {
            if (this.daZ != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.daZ.threadId, null, null);
                if (!this.dbi) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view2 == this.daR) {
            if (this.daZ != null && this.daZ.dbz != null) {
                this.daP.setVisibility(8);
                this.daY.bgd();
                this.daY.bL(this.daZ.dbz.videoUrl, this.daZ.threadId);
                lO("2");
            }
        } else if (view2 == this.bKz) {
            if (!this.daZ.dby.hasFocus) {
                this.dba.f(this.daZ);
            }
        } else if (view2 == this.daX) {
            this.dba.g(this.daZ);
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
            if (this.daV != null) {
                this.daV.startAnimation(getScaleAnimation());
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
}
