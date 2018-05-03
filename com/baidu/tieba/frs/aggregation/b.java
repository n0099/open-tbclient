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
    public TextView bKy;
    public HeadImageView bWd;
    private n bkR;
    public FrameLayout daI;
    public FrameLayout daJ;
    public TextView daK;
    public TextView daL;
    public FrameLayout daM;
    public TextView daN;
    public TextView daO;
    public TextView daP;
    public TextView daQ;
    public ImageView daR;
    public ImageView daS;
    public LinearLayout daT;
    public LinearLayout daU;
    public com.baidu.tieba.play.c daV;
    public g daW;
    private h daX;
    private y daY;
    private y daZ;
    private boolean dba;
    private boolean dbb;
    private Animation dbc;
    private Animation dbd;
    private boolean dbe;
    private boolean dbf;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dba = true;
        this.dbf = z;
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.daI = (FrameLayout) view2.findViewById(d.g.video_agg_container);
        this.daJ = (FrameLayout) view2.findViewById(d.g.video_container);
        this.daV = new com.baidu.tieba.play.c(tbPageContext, this.daJ, false);
        this.daK = (TextView) view2.findViewById(d.g.title);
        this.daL = (TextView) view2.findViewById(d.g.duration);
        this.daM = (FrameLayout) view2.findViewById(d.g.mobile_network_container);
        this.daN = (TextView) view2.findViewById(d.g.mobile_network_text);
        this.daO = (TextView) view2.findViewById(d.g.mobile_network_play);
        this.bWd = (HeadImageView) view2.findViewById(d.g.user_icon);
        this.apg = (TextView) view2.findViewById(d.g.user_name);
        this.bKy = (TextView) view2.findViewById(d.g.attention);
        this.daT = (LinearLayout) view2.findViewById(d.g.thread_info_commont_container);
        this.daU = (LinearLayout) view2.findViewById(d.g.agree_view_container);
        this.daP = (TextView) view2.findViewById(d.g.thread_info_commont_num);
        this.daQ = (TextView) view2.findViewById(d.g.thread_info_praise_num);
        this.daR = (ImageView) view2.findViewById(d.g.thread_info_commont_img);
        this.daS = (ImageView) view2.findViewById(d.g.thread_info_praise_img);
        this.daT.setOnClickListener(this);
        this.daU.setOnClickListener(this);
        this.daK.setOnClickListener(this);
        this.bWd.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.bKy.setOnClickListener(this);
        view2.setOnClickListener(this);
        this.daO.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.daI.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.daI.setLayoutParams(layoutParams);
        this.bWd.setIsRound(true);
        this.bkR = new n(tbPageContext.getPageActivity());
        this.daX = new h(this.mPageContext, this);
        this.dbc = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dbd = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().u(getView());
            ak.j(getView(), d.C0126d.cp_bg_line_d);
            if (this.daW != null && this.daW.dbv != null) {
                if (this.daW.dbv.hasFocus) {
                    ak.h(this.bKy, d.C0126d.cp_cont_d);
                    this.bKy.setCompoundDrawables(null, null, null, null);
                } else {
                    ak.h(this.bKy, d.C0126d.cp_link_tip_a);
                    Drawable drawable = ak.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
                    this.bKy.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.daW != null) {
                if (this.daW.hasAgree) {
                    this.daS.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_s));
                    ak.h(this.daQ, d.C0126d.cp_cont_h);
                } else {
                    this.daS.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_n));
                    ak.h(this.daQ, d.C0126d.cp_cont_f);
                }
            }
            ak.h(this.daP, d.C0126d.cp_cont_f);
            this.daR.setImageDrawable(ak.getDrawable(d.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dbw != null) {
            this.daW = gVar;
            this.dbe = this.daW.autoPlay;
            this.daK.setVisibility(0);
            this.daK.setText(gVar.title);
            this.daL.setVisibility(0);
            this.daL.setText(an.cU(gVar.dbw.videoDuration * 1000));
            if (gVar.dbw.videoSize == 0) {
                format = this.mPageContext.getString(d.k.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.k.video_mobile_network_tips), lP(String.format("%.1f", Float.valueOf(((float) gVar.dbw.videoSize) / 1048576.0f))));
            }
            this.daN.setText(format);
            this.daM.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dbw != null) {
            this.daV.stopPlay();
            this.daV.ln(true);
            this.daV.lq(true);
            this.daV.lo(false);
            this.daV.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    if (b.this.daV.bga()) {
                        b.this.daL.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                    if (b.this.daV.bga()) {
                        b.this.daL.setVisibility(8);
                    }
                    if (b.this.dbb) {
                        b.this.daV.stopPlay();
                    }
                }
            });
            this.daV.a(new c.k() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    b.this.dbb = false;
                    b.this.daL.setVisibility(8);
                    b.this.lO(b.this.dbe ? "1" : "2");
                    b.this.onClick(b.this.daJ);
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqY() {
                    b.this.daL.setVisibility(8);
                    b.this.onClick(b.this.daI);
                }
            });
            this.daV.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.e
                public void fF(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.daN.getText().toString());
                        b.this.daV.bL(b.this.daW.dbw.videoUrl, b.this.daW.threadId);
                        b.this.daL.setVisibility(8);
                        b.this.lO("2");
                    } else {
                        b.this.daM.setVisibility(0);
                    }
                    b.this.onClick(b.this.daJ);
                }
            });
            this.daV.ll(false);
            this.daY = new y();
            this.daY.aNu = gVar.threadId;
            this.daY.crG = gVar.forumId;
            this.daY.mUid = TbadkCoreApplication.getCurrentAccount();
            this.daZ = new y();
            this.daZ.aNu = gVar.threadId;
            this.daZ.crG = gVar.forumId;
            this.daZ.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dbf) {
                al alVar = new al("c12590");
                alVar.ac("tid", gVar.threadId);
                alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                alVar.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                alVar.r("obj_locate", i);
                alVar.r("obj_param2", 1);
                TiebaStatic.log(alVar);
                this.daY.fQJ = "auto_midpage";
                this.daY.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.daY.fQL = "1";
                this.daZ.fQJ = "auto_midpage";
                this.daZ.mLocate = "auto_midpage";
                this.daZ.fQL = "1";
            } else {
                this.daY.fQL = "frs_bavideotab";
                this.daY.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.daZ.fQL = "frs_bavideotab";
                this.daZ.mLocate = "frs_bavideotab";
            }
            if (gVar.dbw != null) {
                this.daY.fQN = gVar.dbw.videoMd5;
                this.daZ.fQN = gVar.dbw.videoMd5;
            }
            this.bkR.setVideoStatsData(this.daY);
            this.daV.getVideoView().setBusiness(this.bkR);
            this.daV.aLy();
            this.daV.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (!b.this.daV.bga()) {
                        b.this.daK.setVisibility(0);
                    } else if (z) {
                        if (b.this.daK.getVisibility() == 0) {
                            b.this.daK.setVisibility(8);
                            b.this.daK.startAnimation(b.this.dbc);
                        }
                    } else if (b.this.daK.getVisibility() == 8) {
                        b.this.daK.setVisibility(0);
                        b.this.daK.startAnimation(b.this.dbd);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqZ() {
                    if (!b.this.daV.bga()) {
                        b.this.daK.setVisibility(0);
                    } else if (b.this.daK.getVisibility() == 0) {
                        b.this.daK.setVisibility(8);
                        b.this.daK.startAnimation(b.this.dbc);
                    }
                }
            });
            this.daV.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dbb = true;
                        b.this.dba = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.kp(i);
                        b.this.daV.ayA();
                    }
                }
            });
            this.daV.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.daW != null && b.this.daW.dbw != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.daW.dbw.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.daV.oz(gVar.dbw.thumbnailUrl);
            this.daV.bK(gVar.dbw.videoUrl, gVar.threadId);
            this.daV.rn(gVar.title);
            this.daV.a(new c.h() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.h
                public void ara() {
                    b.this.daL.setVisibility(8);
                }
            });
            this.daV.ayA();
            this.daV.show();
            if (gVar.autoPlay) {
                onClick(this.daJ);
                this.dbb = false;
                this.daV.a(gVar.dbw.videoUrl, gVar.threadId, null, new Object[0]);
            }
            this.dbb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(String str) {
        if (this.daW != null && this.daW.dbw != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.daW.dbw.videoMd5, "", str, this.daZ);
            }
        }
    }

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
        this.daM.setVisibility(8);
        this.daV.stopPlay();
        if (this.daK != null) {
            this.daK.setVisibility(0);
        }
        if (this.daL != null) {
            this.daL.setVisibility(0);
        }
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
    }

    public String lP(String str) {
        if (str.indexOf(com.baidu.ar.util.Constants.DOT) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.dbv != null) {
            this.apg.setText(TextUtils.isEmpty(gVar.dbv.userNickname) ? gVar.dbv.userName : gVar.dbv.userNickname);
            this.bWd.startLoad(gVar.dbv.portrait, 12, false);
            this.bWd.setShowV(gVar.dbv.isGod);
            this.bWd.setIsBigV(gVar.dbv.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dbv != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dbv.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dbv.userId)) {
                this.bKy.setVisibility(8);
            } else {
                this.bKy.setVisibility(0);
            }
            if (gVar.dbv.hasFocus) {
                ak.h(this.bKy, d.C0126d.cp_cont_d);
                this.bKy.setCompoundDrawables(null, null, null, null);
                this.bKy.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                return;
            }
            ak.h(this.bKy, d.C0126d.cp_link_tip_a);
            Drawable drawable = ak.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
            this.bKy.setCompoundDrawables(drawable, null, null, null);
            this.bKy.setText(this.mPageContext.getString(d.k.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.daS.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_s));
                ak.h(this.daQ, d.C0126d.cp_cont_h);
            } else {
                this.daS.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_n));
                ak.h(this.daQ, d.C0126d.cp_cont_f);
            }
            this.daQ.setText(an.B(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ak.h(this.daP, d.C0126d.cp_cont_f);
            this.daR.setImageDrawable(ak.getDrawable(d.f.icon_home_card_comment));
            this.daP.setText(an.B(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.daV != null && this.daJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dba) {
                this.daV.bfZ();
            }
            if (configuration.orientation == 2) {
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
                } else {
                    return;
                }
            } else {
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
                    this.daJ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.daV.aLy();
                    this.dba = true;
                } else {
                    return;
                }
            }
            this.daV.a(this.mPageContext, configuration);
            this.daL.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            view2.setTag(this);
            aeZ().a(view2, this.daW);
        }
        if (view2 == this.bWd || view2 == this.apg) {
            boolean z = false;
            if (this.daW != null && this.daW.dbv != null && !TextUtils.isEmpty(this.daW.dbv.userId)) {
                if (TbadkCoreApplication.isLogin() && this.daW.dbv.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.daW.dbv.userId, 0L), z, this.daW.dbv.isGod)));
            }
        } else if (view2 == this.daT || view2 == this.daK || view2 == getView()) {
            if (this.daW != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.daW.threadId, null, null);
                if (!this.dbf) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view2 == this.daO) {
            if (this.daW != null && this.daW.dbw != null) {
                this.daM.setVisibility(8);
                this.daV.bgd();
                this.daV.bL(this.daW.dbw.videoUrl, this.daW.threadId);
                lO("2");
            }
        } else if (view2 == this.bKy) {
            if (!this.daW.dbv.hasFocus) {
                this.daX.f(this.daW);
            }
        } else if (view2 == this.daU) {
            this.daX.g(this.daW);
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
            if (this.daS != null) {
                this.daS.startAnimation(getScaleAnimation());
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
}
