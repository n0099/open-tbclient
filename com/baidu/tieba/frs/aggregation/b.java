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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView XL;
    private Animation afH;
    private boolean bOM;
    private n dnD;
    public HeadImageView efN;
    public ImageView fAa;
    public LinearLayout fAb;
    public LinearLayout fAc;
    public com.baidu.tieba.play.c fAd;
    public g fAe;
    private h fAf;
    private z fAg;
    private z fAh;
    private boolean fAi;
    private boolean fAj;
    private Animation fAk;
    private ScaleAnimation fAl;
    private boolean fAm;
    public FrameLayout fzP;
    public FrameLayout fzQ;
    public TextView fzR;
    public TextView fzS;
    public FrameLayout fzT;
    public TextView fzU;
    public TextView fzV;
    public TextView fzW;
    public TextView fzX;
    public TextView fzY;
    public ImageView fzZ;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fAi = true;
        this.fAm = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fzP = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fzQ = (FrameLayout) view.findViewById(R.id.video_container);
        this.fAd = new com.baidu.tieba.play.c(tbPageContext, (View) this.fzQ, false);
        this.fzR = (TextView) view.findViewById(R.id.title);
        this.fzS = (TextView) view.findViewById(R.id.duration);
        this.fzT = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.fzU = (TextView) view.findViewById(R.id.mobile_network_text);
        this.fzV = (TextView) view.findViewById(R.id.mobile_network_play);
        this.efN = (HeadImageView) view.findViewById(R.id.user_icon);
        this.XL = (TextView) view.findViewById(R.id.user_name);
        this.fzW = (TextView) view.findViewById(R.id.attention);
        this.fAb = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.fAc = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.fzX = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fzY = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.fzZ = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fAa = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.fAb.setOnClickListener(this);
        this.fAc.setOnClickListener(this);
        this.fzR.setOnClickListener(this);
        this.efN.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.fzW.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fzV.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fzP.setLayoutParams(layoutParams);
        this.efN.setIsRound(true);
        this.dnD = new n(tbPageContext.getPageActivity());
        this.fAf = new h(this.mPageContext, this);
        this.fAk = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.afH = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.l(getView(), R.color.cp_bg_line_d);
            if (this.fAe != null && this.fAe.fAD != null) {
                if (this.fAe.fAD.hasFocus) {
                    am.j(this.fzW, R.color.cp_cont_d);
                    this.fzW.setCompoundDrawables(null, null, null, null);
                } else {
                    am.j(this.fzW, R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
                    this.fzW.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fAe != null) {
                if (this.fAe.hasAgree) {
                    this.fAa.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.j(this.fzY, R.color.cp_cont_h);
                } else {
                    this.fAa.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.j(this.fzY, R.color.cp_cont_f);
                }
            }
            am.j(this.fzX, R.color.cp_cont_f);
            this.fzZ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.fAE != null) {
            this.fAe = gVar;
            this.bOM = this.fAe.autoPlay;
            this.fzR.setVisibility(0);
            this.fzR.setText(gVar.title);
            this.fzS.setVisibility(0);
            this.fzS.setText(aq.is(gVar.fAE.videoDuration * 1000));
            if (gVar.fAE.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), xb(String.format("%.1f", Float.valueOf(((float) gVar.fAE.videoSize) / 1048576.0f))));
            }
            this.fzU.setText(format);
            this.fzT.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.fAE != null) {
            this.fAd.stopPlay();
            this.fAd.setIsNeedRecoveryVideoPlayer(true);
            this.fAd.qc(true);
            this.fAd.pY(false);
            this.fAd.a(new c.InterfaceC0392c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pz() {
                    if (b.this.fAd.pB()) {
                        b.this.fzS.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pA() {
                    if (b.this.fAd.pB()) {
                        b.this.fzS.setVisibility(8);
                    }
                    if (b.this.fAj) {
                        b.this.fAd.stopPlay();
                    }
                }
            });
            this.fAd.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bow() {
                    b.this.fAj = false;
                    b.this.fzS.setVisibility(8);
                    b.this.xa(b.this.bOM ? "1" : "2");
                    b.this.onClick(b.this.fzQ);
                }

                @Override // com.baidu.tieba.play.c.l
                public void box() {
                    b.this.fzS.setVisibility(8);
                    b.this.onClick(b.this.fzP);
                }
            });
            this.fAd.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void kr(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fzU.getText().toString());
                        b.this.fAd.cs(b.this.fAe.fAE.videoUrl, b.this.fAe.threadId);
                        b.this.fzS.setVisibility(8);
                        b.this.xa("2");
                    } else {
                        b.this.fzT.setVisibility(0);
                    }
                    b.this.onClick(b.this.fzQ);
                }
            });
            this.fAd.pU(false);
            this.fAg = new z();
            this.fAg.bWU = gVar.threadId;
            this.fAg.eFF = gVar.forumId;
            this.fAg.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fAh = new z();
            this.fAh.bWU = gVar.threadId;
            this.fAh.eFF = gVar.forumId;
            this.fAh.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fAm) {
                an anVar = new an("c12590");
                anVar.bT("tid", gVar.threadId);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bT("fid", gVar.forumId);
                anVar.P("obj_locate", i);
                anVar.P("obj_param2", 1);
                TiebaStatic.log(anVar);
                this.fAg.iyB = "auto_midpage";
                this.fAg.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.fAg.iyD = "1";
                this.fAh.iyB = "auto_midpage";
                this.fAh.mLocate = "auto_midpage";
                this.fAh.iyD = "1";
            } else {
                this.fAg.iyD = "frs_bavideotab";
                this.fAg.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fAh.iyD = "frs_bavideotab";
                this.fAh.mLocate = "frs_bavideotab";
            }
            if (gVar.fAE != null) {
                this.fAg.iyF = gVar.fAE.videoMd5;
                this.fAh.iyF = gVar.fAE.videoMd5;
            }
            this.dnD.setVideoStatsData(this.fAg);
            this.fAd.getVideoView().setBusiness(this.dnD);
            this.fAd.bLm();
            this.fAd.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ks(boolean z) {
                    if (!b.this.fAd.pB()) {
                        b.this.fzR.setVisibility(0);
                    } else if (z) {
                        if (b.this.fzR.getVisibility() == 0) {
                            b.this.fzR.setVisibility(8);
                            b.this.fzR.startAnimation(b.this.fAk);
                        }
                    } else if (b.this.fzR.getVisibility() == 8) {
                        b.this.fzR.setVisibility(0);
                        b.this.fzR.startAnimation(b.this.afH);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void boy() {
                    if (!b.this.fAd.pB()) {
                        b.this.fzR.setVisibility(0);
                    } else if (b.this.fzR.getVisibility() == 0) {
                        b.this.fzR.setVisibility(8);
                        b.this.fzR.startAnimation(b.this.fAk);
                    }
                }
            });
            this.fAd.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fAj = true;
                        b.this.fAi = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.rS(i);
                        b.this.fAd.byn();
                    }
                }
            });
            this.fAd.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fAe != null && b.this.fAe.fAE != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fAe.fAE.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fAd.setThumbnail(gVar.fAE.thumbnailUrl);
            this.fAd.setVideoUrl(gVar.fAE.videoUrl, gVar.threadId);
            this.fAd.CV(gVar.title);
            this.fAd.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void boz() {
                    b.this.fzS.setVisibility(8);
                }
            });
            this.fAd.byn();
            this.fAd.show();
            if (gVar.autoPlay) {
                onClick(this.fzQ);
                this.fAj = false;
                this.fAd.a(gVar.fAE.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fAj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(String str) {
        if (this.fAe != null && this.fAe.fAE != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fAe.fAE.videoMd5, "", str, this.fAh);
            }
        }
    }

    public boolean isPlaying() {
        return this.fAd.pB();
    }

    public void bos() {
        if (isPlaying()) {
            this.fAd.pausePlay();
        }
    }

    public boolean rT(int i) {
        return this.fAd.yV(i);
    }

    public void bot() {
        this.fzT.setVisibility(8);
        this.fAd.stopPlay();
        if (this.fzR != null) {
            this.fzR.setVisibility(0);
        }
        if (this.fzS != null) {
            this.fzS.setVisibility(0);
        }
    }

    public void bou() {
        if (this.fAd != null) {
            this.fAd.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bou();
        if (this.fAf != null) {
            this.fAf.boF();
        }
    }

    public String xb(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.fAD != null) {
            this.XL.setText(TextUtils.isEmpty(gVar.fAD.userNickname) ? gVar.fAD.userName : gVar.fAD.userNickname);
            this.efN.startLoad(gVar.fAD.portrait, 12, false);
            this.efN.setShowV(gVar.fAD.isGod);
            this.efN.setIsBigV(gVar.fAD.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.fAD != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.fAD.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.fAD.userId)) {
                this.fzW.setVisibility(8);
            } else {
                this.fzW.setVisibility(0);
            }
            if (gVar.fAD.hasFocus) {
                am.j(this.fzW, R.color.cp_cont_d);
                this.fzW.setCompoundDrawables(null, null, null, null);
                this.fzW.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.j(this.fzW, R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
            this.fzW.setCompoundDrawables(drawable, null, null, null);
            this.fzW.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.fAa.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.j(this.fzY, R.color.cp_cont_h);
            } else {
                this.fAa.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.j(this.fzY, R.color.cp_cont_f);
            }
            this.fzY.setText(aq.aO(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.j(this.fzX, R.color.cp_cont_f);
            this.fzZ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.fzX.setText(aq.aO(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fAd != null && this.fzQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fAi) {
                this.fAd.cdU();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fzQ.getParent() != null) {
                    if (this.fzQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.fzQ);
                    } else if (this.fzQ.getParent() == this.fzP) {
                        this.fzP.removeView(this.fzQ);
                    }
                }
                if (this.fzQ.getParent() == null) {
                    frameLayout.addView(this.fzQ);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fzQ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fzQ.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fzQ.getParent() != null) {
                    if (this.fzQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.fzQ);
                    } else if (this.fzQ.getParent() == this.fzP) {
                        this.fzP.removeView(this.fzQ);
                    }
                }
                if (this.fzQ.getParent() == null) {
                    this.fzP.addView(this.fzQ, 0);
                    this.fzQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fAd.bLm();
                    this.fAi = true;
                } else {
                    return;
                }
            }
            this.fAd.a(this.mPageContext, configuration);
            this.fzS.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZq() != null) {
            view.setTag(this);
            aZq().a(view, this.fAe);
        }
        if (view == this.efN || view == this.XL) {
            boolean z = false;
            if (this.fAe != null && this.fAe.fAD != null && !TextUtils.isEmpty(this.fAe.fAD.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fAe.fAD.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fAe.fAD.userId, 0L), z, this.fAe.fAD.isGod)));
            }
        } else if (view == this.fAb || view == this.fzR || view == getView()) {
            if (this.fAe != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fAe.threadId, null, null);
                if (!this.fAm) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fzV) {
            if (this.fAe != null && this.fAe.fAE != null) {
                this.fzT.setVisibility(8);
                this.fAd.cdX();
                this.fAd.cs(this.fAe.fAE.videoUrl, this.fAe.threadId);
                xa("2");
            }
        } else if (view == this.fzW) {
            if (!this.fAe.fAD.hasFocus) {
                this.fAf.f(this.fAe);
            }
        } else if (view == this.fAc) {
            this.fAf.g(this.fAe);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kq(boolean z) {
        if (this.fAe != null && this.fAe.fAD != null) {
            this.fAe.fAD.hasFocus = z;
            c(this.fAe);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bov() {
        if (this.fAe != null) {
            this.fAe.hasAgree = !this.fAe.hasAgree;
            if (this.fAe.hasAgree) {
                this.fAe.agreeNum++;
            } else {
                this.fAe.agreeNum--;
            }
            if (this.fAa != null) {
                this.fAa.startAnimation(getScaleAnimation());
            }
            d(this.fAe);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fAl == null) {
            this.fAl = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fAl.setDuration(200L);
        }
        return this.fAl;
    }
}
