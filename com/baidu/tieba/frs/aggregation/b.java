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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    private ScaleAnimation axX;
    public TextView ayf;
    public TextView bVx;
    private n buL;
    public HeadImageView chg;
    public FrameLayout dnQ;
    public FrameLayout dnR;
    public TextView dnS;
    public TextView dnT;
    public FrameLayout dnU;
    public TextView dnV;
    public TextView dnW;
    public TextView dnX;
    public TextView dnY;
    public ImageView dnZ;
    public ImageView doa;
    public LinearLayout dob;
    public LinearLayout dod;
    public com.baidu.tieba.play.c doe;
    public g dof;
    private h dog;
    private y doh;
    private y doi;
    private boolean doj;
    private boolean dok;
    private Animation dol;
    private Animation dom;
    private boolean don;
    private boolean doo;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.doj = true;
        this.doo = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dnQ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dnR = (FrameLayout) view.findViewById(d.g.video_container);
        this.doe = new com.baidu.tieba.play.c(tbPageContext, this.dnR, false);
        this.dnS = (TextView) view.findViewById(d.g.title);
        this.dnT = (TextView) view.findViewById(d.g.duration);
        this.dnU = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.dnV = (TextView) view.findViewById(d.g.mobile_network_text);
        this.dnW = (TextView) view.findViewById(d.g.mobile_network_play);
        this.chg = (HeadImageView) view.findViewById(d.g.user_icon);
        this.ayf = (TextView) view.findViewById(d.g.user_name);
        this.bVx = (TextView) view.findViewById(d.g.attention);
        this.dob = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.dod = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.dnX = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.dnY = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.dnZ = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.doa = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.dob.setOnClickListener(this);
        this.dod.setOnClickListener(this);
        this.dnS.setOnClickListener(this);
        this.chg.setOnClickListener(this);
        this.ayf.setOnClickListener(this);
        this.bVx.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dnW.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dnQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dnQ.setLayoutParams(layoutParams);
        this.chg.setIsRound(true);
        this.buL = new n(tbPageContext.getPageActivity());
        this.dog = new h(this.mPageContext, this);
        this.dol = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dom = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.j(getView(), d.C0142d.cp_bg_line_d);
            if (this.dof != null && this.dof.doE != null) {
                if (this.dof.doE.hasFocus) {
                    am.h(this.bVx, d.C0142d.cp_cont_d);
                    this.bVx.setCompoundDrawables(null, null, null, null);
                } else {
                    am.h(this.bVx, d.C0142d.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
                    this.bVx.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dof != null) {
                if (this.dof.hasAgree) {
                    this.doa.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_s));
                    am.h(this.dnY, d.C0142d.cp_cont_h);
                } else {
                    this.doa.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_n));
                    am.h(this.dnY, d.C0142d.cp_cont_f);
                }
            }
            am.h(this.dnX, d.C0142d.cp_cont_f);
            this.dnZ.setImageDrawable(am.getDrawable(d.f.icon_home_card_comment));
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
        if (gVar != null && gVar.doF != null) {
            this.dof = gVar;
            this.don = this.dof.autoPlay;
            this.dnS.setVisibility(0);
            this.dnS.setText(gVar.title);
            this.dnT.setVisibility(0);
            this.dnT.setText(ap.cY(gVar.doF.videoDuration * 1000));
            if (gVar.doF.videoSize == 0) {
                format = this.mPageContext.getString(d.k.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.k.video_mobile_network_tips), mz(String.format("%.1f", Float.valueOf(((float) gVar.doF.videoSize) / 1048576.0f))));
            }
            this.dnV.setText(format);
            this.dnU.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.doF != null) {
            this.doe.stopPlay();
            this.doe.lE(true);
            this.doe.lH(true);
            this.doe.lF(false);
            this.doe.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.b
                public void avD() {
                    if (b.this.doe.blC()) {
                        b.this.dnT.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void avE() {
                    if (b.this.doe.blC()) {
                        b.this.dnT.setVisibility(8);
                    }
                    if (b.this.dok) {
                        b.this.doe.stopPlay();
                    }
                }
            });
            this.doe.a(new c.k() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.k
                public void avF() {
                    b.this.dok = false;
                    b.this.dnT.setVisibility(8);
                    b.this.my(b.this.don ? "1" : "2");
                    b.this.onClick(b.this.dnR);
                }

                @Override // com.baidu.tieba.play.c.k
                public void avG() {
                    b.this.dnT.setVisibility(8);
                    b.this.onClick(b.this.dnQ);
                }
            });
            this.doe.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.e
                public void fR(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dnV.getText().toString());
                        b.this.doe.bX(b.this.dof.doF.videoUrl, b.this.dof.threadId);
                        b.this.dnT.setVisibility(8);
                        b.this.my("2");
                    } else {
                        b.this.dnU.setVisibility(0);
                    }
                    b.this.onClick(b.this.dnR);
                }
            });
            this.doe.lC(false);
            this.doh = new y();
            this.doh.aWo = gVar.threadId;
            this.doh.czo = gVar.forumId;
            this.doh.mUid = TbadkCoreApplication.getCurrentAccount();
            this.doi = new y();
            this.doi.aWo = gVar.threadId;
            this.doi.czo = gVar.forumId;
            this.doi.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.doo) {
                an anVar = new an("c12590");
                anVar.ah("tid", gVar.threadId);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                anVar.r("obj_locate", i);
                anVar.r("obj_param2", 1);
                TiebaStatic.log(anVar);
                this.doh.ghc = "auto_midpage";
                this.doh.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.doh.ghe = "1";
                this.doi.ghc = "auto_midpage";
                this.doi.mLocate = "auto_midpage";
                this.doi.ghe = "1";
            } else {
                this.doh.ghe = "frs_bavideotab";
                this.doh.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.doi.ghe = "frs_bavideotab";
                this.doi.mLocate = "frs_bavideotab";
            }
            if (gVar.doF != null) {
                this.doh.ghg = gVar.doF.videoMd5;
                this.doi.ghg = gVar.doF.videoMd5;
            }
            this.buL.setVideoStatsData(this.doh);
            this.doe.getVideoView().setBusiness(this.buL);
            this.doe.aRa();
            this.doe.b(new c.InterfaceC0219c() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void fS(boolean z) {
                    if (!b.this.doe.blC()) {
                        b.this.dnS.setVisibility(0);
                    } else if (z) {
                        if (b.this.dnS.getVisibility() == 0) {
                            b.this.dnS.setVisibility(8);
                            b.this.dnS.startAnimation(b.this.dol);
                        }
                    } else if (b.this.dnS.getVisibility() == 8) {
                        b.this.dnS.setVisibility(0);
                        b.this.dnS.startAnimation(b.this.dom);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void avH() {
                    if (!b.this.doe.blC()) {
                        b.this.dnS.setVisibility(0);
                    } else if (b.this.dnS.getVisibility() == 0) {
                        b.this.dnS.setVisibility(8);
                        b.this.dnS.startAnimation(b.this.dol);
                    }
                }
            });
            this.doe.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dok = true;
                        b.this.doj = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.kA(i);
                        b.this.doe.aEd();
                    }
                }
            });
            this.doe.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.dof != null && b.this.dof.doF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.dof.doF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.doe.pr(gVar.doF.thumbnailUrl);
            this.doe.bW(gVar.doF.videoUrl, gVar.threadId);
            this.doe.sg(gVar.title);
            this.doe.a(new c.h() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.h
                public void avI() {
                    b.this.dnT.setVisibility(8);
                }
            });
            this.doe.aEd();
            this.doe.show();
            if (gVar.autoPlay) {
                onClick(this.dnR);
                this.dok = false;
                this.doe.a(gVar.doF.videoUrl, gVar.threadId, (c.d) null, new Object[0]);
            }
            this.dok = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(String str) {
        if (this.dof != null && this.dof.doF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dof.doF.videoMd5, "", str, this.doi);
            }
        }
    }

    public boolean isPlaying() {
        return this.doe.blC();
    }

    public void avz() {
        if (isPlaying()) {
            this.doe.pausePlay();
        }
    }

    public boolean kB(int i) {
        return this.doe.rH(i);
    }

    public void avA() {
        this.dnU.setVisibility(8);
        this.doe.stopPlay();
        if (this.dnS != null) {
            this.dnS.setVisibility(0);
        }
        if (this.dnT != null) {
            this.dnT.setVisibility(0);
        }
    }

    public void avB() {
        if (this.doe != null) {
            this.doe.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        avB();
        if (this.dog != null) {
            this.dog.avN();
        }
    }

    public String mz(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.doE != null) {
            this.ayf.setText(TextUtils.isEmpty(gVar.doE.userNickname) ? gVar.doE.userName : gVar.doE.userNickname);
            this.chg.startLoad(gVar.doE.portrait, 12, false);
            this.chg.setShowV(gVar.doE.isGod);
            this.chg.setIsBigV(gVar.doE.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.doE != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.doE.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.doE.userId)) {
                this.bVx.setVisibility(8);
            } else {
                this.bVx.setVisibility(0);
            }
            if (gVar.doE.hasFocus) {
                am.h(this.bVx, d.C0142d.cp_cont_d);
                this.bVx.setCompoundDrawables(null, null, null, null);
                this.bVx.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                return;
            }
            am.h(this.bVx, d.C0142d.cp_link_tip_a);
            Drawable drawable = am.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
            this.bVx.setCompoundDrawables(drawable, null, null, null);
            this.bVx.setText(this.mPageContext.getString(d.k.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.doa.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_s));
                am.h(this.dnY, d.C0142d.cp_cont_h);
            } else {
                this.doa.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_n));
                am.h(this.dnY, d.C0142d.cp_cont_f);
            }
            this.dnY.setText(ap.F(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.h(this.dnX, d.C0142d.cp_cont_f);
            this.dnZ.setImageDrawable(am.getDrawable(d.f.icon_home_card_comment));
            this.dnX.setText(ap.F(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.doe != null && this.dnR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.doj) {
                this.doe.blB();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dnR.getParent() != null) {
                    if (this.dnR.getParent() == frameLayout) {
                        frameLayout.removeView(this.dnR);
                    } else if (this.dnR.getParent() == this.dnQ) {
                        this.dnQ.removeView(this.dnR);
                    }
                }
                if (this.dnR.getParent() == null) {
                    frameLayout.addView(this.dnR);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dnR.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dnR.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dnR.getParent() != null) {
                    if (this.dnR.getParent() == frameLayout) {
                        frameLayout.removeView(this.dnR);
                    } else if (this.dnR.getParent() == this.dnQ) {
                        this.dnQ.removeView(this.dnR);
                    }
                }
                if (this.dnR.getParent() == null) {
                    this.dnQ.addView(this.dnR, 0);
                    this.dnR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.doe.aRa();
                    this.doj = true;
                } else {
                    return;
                }
            }
            this.doe.a(this.mPageContext, configuration);
            this.dnT.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aia() != null) {
            view.setTag(this);
            aia().a(view, this.dof);
        }
        if (view == this.chg || view == this.ayf) {
            boolean z = false;
            if (this.dof != null && this.dof.doE != null && !TextUtils.isEmpty(this.dof.doE.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dof.doE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dof.doE.userId, 0L), z, this.dof.doE.isGod)));
            }
        } else if (view == this.dob || view == this.dnS || view == getView()) {
            if (this.dof != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dof.threadId, null, null);
                if (!this.doo) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dnW) {
            if (this.dof != null && this.dof.doF != null) {
                this.dnU.setVisibility(8);
                this.doe.blF();
                this.doe.bX(this.dof.doF.videoUrl, this.dof.threadId);
                my("2");
            }
        } else if (view == this.bVx) {
            if (!this.dof.doE.hasFocus) {
                this.dog.f(this.dof);
            }
        } else if (view == this.dod) {
            this.dog.g(this.dof);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fQ(boolean z) {
        if (this.dof != null && this.dof.doE != null) {
            this.dof.doE.hasFocus = z;
            c(this.dof);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void avC() {
        if (this.dof != null) {
            this.dof.hasAgree = !this.dof.hasAgree;
            if (this.dof.hasAgree) {
                this.dof.agreeNum++;
            } else {
                this.dof.agreeNum--;
            }
            if (this.doa != null) {
                this.doa.startAnimation(getScaleAnimation());
            }
            d(this.dof);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axX == null) {
            this.axX = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axX.setDuration(200L);
        }
        return this.axX;
    }
}
