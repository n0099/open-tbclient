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
    public TextView XK;
    private Animation afH;
    private boolean bPn;
    private n dpp;
    public HeadImageView ehx;
    public FrameLayout fBC;
    public FrameLayout fBD;
    public TextView fBE;
    public TextView fBF;
    public FrameLayout fBG;
    public TextView fBH;
    public TextView fBI;
    public TextView fBJ;
    public TextView fBK;
    public TextView fBL;
    public ImageView fBM;
    public ImageView fBN;
    public LinearLayout fBO;
    public LinearLayout fBP;
    public com.baidu.tieba.play.c fBQ;
    public g fBR;
    private h fBS;
    private z fBT;
    private z fBU;
    private boolean fBV;
    private boolean fBW;
    private Animation fBX;
    private ScaleAnimation fBY;
    private boolean fBZ;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fBV = true;
        this.fBZ = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fBC = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fBD = (FrameLayout) view.findViewById(R.id.video_container);
        this.fBQ = new com.baidu.tieba.play.c(tbPageContext, (View) this.fBD, false);
        this.fBE = (TextView) view.findViewById(R.id.title);
        this.fBF = (TextView) view.findViewById(R.id.duration);
        this.fBG = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.fBH = (TextView) view.findViewById(R.id.mobile_network_text);
        this.fBI = (TextView) view.findViewById(R.id.mobile_network_play);
        this.ehx = (HeadImageView) view.findViewById(R.id.user_icon);
        this.XK = (TextView) view.findViewById(R.id.user_name);
        this.fBJ = (TextView) view.findViewById(R.id.attention);
        this.fBO = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.fBP = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.fBK = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fBL = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.fBM = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fBN = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.fBO.setOnClickListener(this);
        this.fBP.setOnClickListener(this);
        this.fBE.setOnClickListener(this);
        this.ehx.setOnClickListener(this);
        this.XK.setOnClickListener(this);
        this.fBJ.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fBI.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBC.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fBC.setLayoutParams(layoutParams);
        this.ehx.setIsRound(true);
        this.dpp = new n(tbPageContext.getPageActivity());
        this.fBS = new h(this.mPageContext, this);
        this.fBX = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.afH = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.l(getView(), R.color.cp_bg_line_d);
            if (this.fBR != null && this.fBR.fCq != null) {
                if (this.fBR.fCq.hasFocus) {
                    am.j(this.fBJ, R.color.cp_cont_d);
                    this.fBJ.setCompoundDrawables(null, null, null, null);
                } else {
                    am.j(this.fBJ, R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
                    this.fBJ.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fBR != null) {
                if (this.fBR.hasAgree) {
                    this.fBN.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.j(this.fBL, R.color.cp_cont_h);
                } else {
                    this.fBN.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.j(this.fBL, R.color.cp_cont_f);
                }
            }
            am.j(this.fBK, R.color.cp_cont_f);
            this.fBM.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.fCr != null) {
            this.fBR = gVar;
            this.bPn = this.fBR.autoPlay;
            this.fBE.setVisibility(0);
            this.fBE.setText(gVar.title);
            this.fBF.setVisibility(0);
            this.fBF.setText(aq.it(gVar.fCr.videoDuration * 1000));
            if (gVar.fCr.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), xA(String.format("%.1f", Float.valueOf(((float) gVar.fCr.videoSize) / 1048576.0f))));
            }
            this.fBH.setText(format);
            this.fBG.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.fCr != null) {
            this.fBQ.stopPlay();
            this.fBQ.setIsNeedRecoveryVideoPlayer(true);
            this.fBQ.qf(true);
            this.fBQ.qb(false);
            this.fBQ.a(new c.InterfaceC0403c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pA() {
                    if (b.this.fBQ.pC()) {
                        b.this.fBF.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pB() {
                    if (b.this.fBQ.pC()) {
                        b.this.fBF.setVisibility(8);
                    }
                    if (b.this.fBW) {
                        b.this.fBQ.stopPlay();
                    }
                }
            });
            this.fBQ.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bph() {
                    b.this.fBW = false;
                    b.this.fBF.setVisibility(8);
                    b.this.xz(b.this.bPn ? "1" : "2");
                    b.this.onClick(b.this.fBD);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bpi() {
                    b.this.fBF.setVisibility(8);
                    b.this.onClick(b.this.fBC);
                }
            });
            this.fBQ.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void ku(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fBH.getText().toString());
                        b.this.fBQ.ct(b.this.fBR.fCr.videoUrl, b.this.fBR.threadId);
                        b.this.fBF.setVisibility(8);
                        b.this.xz("2");
                    } else {
                        b.this.fBG.setVisibility(0);
                    }
                    b.this.onClick(b.this.fBD);
                }
            });
            this.fBQ.pX(false);
            this.fBT = new z();
            this.fBT.bXN = gVar.threadId;
            this.fBT.eHo = gVar.forumId;
            this.fBT.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fBU = new z();
            this.fBU.bXN = gVar.threadId;
            this.fBU.eHo = gVar.forumId;
            this.fBU.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fBZ) {
                an anVar = new an("c12590");
                anVar.bT("tid", gVar.threadId);
                anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bT("fid", gVar.forumId);
                anVar.P("obj_locate", i);
                anVar.P("obj_param2", 1);
                TiebaStatic.log(anVar);
                this.fBT.iAD = "auto_midpage";
                this.fBT.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.fBT.iAF = "1";
                this.fBU.iAD = "auto_midpage";
                this.fBU.mLocate = "auto_midpage";
                this.fBU.iAF = "1";
            } else {
                this.fBT.iAF = "frs_bavideotab";
                this.fBT.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fBU.iAF = "frs_bavideotab";
                this.fBU.mLocate = "frs_bavideotab";
            }
            if (gVar.fCr != null) {
                this.fBT.iAH = gVar.fCr.videoMd5;
                this.fBU.iAH = gVar.fCr.videoMd5;
            }
            this.dpp.setVideoStatsData(this.fBT);
            this.fBQ.getVideoView().setBusiness(this.dpp);
            this.fBQ.bLZ();
            this.fBQ.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void kv(boolean z) {
                    if (!b.this.fBQ.pC()) {
                        b.this.fBE.setVisibility(0);
                    } else if (z) {
                        if (b.this.fBE.getVisibility() == 0) {
                            b.this.fBE.setVisibility(8);
                            b.this.fBE.startAnimation(b.this.fBX);
                        }
                    } else if (b.this.fBE.getVisibility() == 8) {
                        b.this.fBE.setVisibility(0);
                        b.this.fBE.startAnimation(b.this.afH);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bpj() {
                    if (!b.this.fBQ.pC()) {
                        b.this.fBE.setVisibility(0);
                    } else if (b.this.fBE.getVisibility() == 0) {
                        b.this.fBE.setVisibility(8);
                        b.this.fBE.startAnimation(b.this.fBX);
                    }
                }
            });
            this.fBQ.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fBW = true;
                        b.this.fBV = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.rV(i);
                        b.this.fBQ.bzb();
                    }
                }
            });
            this.fBQ.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fBR != null && b.this.fBR.fCr != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fBR.fCr.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fBQ.setThumbnail(gVar.fCr.thumbnailUrl);
            this.fBQ.setVideoUrl(gVar.fCr.videoUrl, gVar.threadId);
            this.fBQ.Du(gVar.title);
            this.fBQ.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bpk() {
                    b.this.fBF.setVisibility(8);
                }
            });
            this.fBQ.bzb();
            this.fBQ.show();
            if (gVar.autoPlay) {
                onClick(this.fBD);
                this.fBW = false;
                this.fBQ.a(gVar.fCr.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fBW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz(String str) {
        if (this.fBR != null && this.fBR.fCr != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fBR.fCr.videoMd5, "", str, this.fBU);
            }
        }
    }

    public boolean isPlaying() {
        return this.fBQ.pC();
    }

    public void bpd() {
        if (isPlaying()) {
            this.fBQ.pausePlay();
        }
    }

    public boolean rW(int i) {
        return this.fBQ.yY(i);
    }

    public void bpe() {
        this.fBG.setVisibility(8);
        this.fBQ.stopPlay();
        if (this.fBE != null) {
            this.fBE.setVisibility(0);
        }
        if (this.fBF != null) {
            this.fBF.setVisibility(0);
        }
    }

    public void bpf() {
        if (this.fBQ != null) {
            this.fBQ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bpf();
        if (this.fBS != null) {
            this.fBS.bpq();
        }
    }

    public String xA(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.fCq != null) {
            this.XK.setText(TextUtils.isEmpty(gVar.fCq.userNickname) ? gVar.fCq.userName : gVar.fCq.userNickname);
            this.ehx.startLoad(gVar.fCq.portrait, 12, false);
            this.ehx.setShowV(gVar.fCq.isGod);
            this.ehx.setIsBigV(gVar.fCq.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.fCq != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.fCq.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.fCq.userId)) {
                this.fBJ.setVisibility(8);
            } else {
                this.fBJ.setVisibility(0);
            }
            if (gVar.fCq.hasFocus) {
                am.j(this.fBJ, R.color.cp_cont_d);
                this.fBJ.setCompoundDrawables(null, null, null, null);
                this.fBJ.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.j(this.fBJ, R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
            this.fBJ.setCompoundDrawables(drawable, null, null, null);
            this.fBJ.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.fBN.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.j(this.fBL, R.color.cp_cont_h);
            } else {
                this.fBN.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.j(this.fBL, R.color.cp_cont_f);
            }
            this.fBL.setText(aq.aO(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.j(this.fBK, R.color.cp_cont_f);
            this.fBM.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.fBK.setText(aq.aO(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fBQ != null && this.fBD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fBV) {
                this.fBQ.ceK();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fBD.getParent() != null) {
                    if (this.fBD.getParent() == frameLayout) {
                        frameLayout.removeView(this.fBD);
                    } else if (this.fBD.getParent() == this.fBC) {
                        this.fBC.removeView(this.fBD);
                    }
                }
                if (this.fBD.getParent() == null) {
                    frameLayout.addView(this.fBD);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fBD.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fBD.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fBD.getParent() != null) {
                    if (this.fBD.getParent() == frameLayout) {
                        frameLayout.removeView(this.fBD);
                    } else if (this.fBD.getParent() == this.fBC) {
                        this.fBC.removeView(this.fBD);
                    }
                }
                if (this.fBD.getParent() == null) {
                    this.fBC.addView(this.fBD, 0);
                    this.fBD.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fBQ.bLZ();
                    this.fBV = true;
                } else {
                    return;
                }
            }
            this.fBQ.a(this.mPageContext, configuration);
            this.fBF.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZU() != null) {
            view.setTag(this);
            aZU().a(view, this.fBR);
        }
        if (view == this.ehx || view == this.XK) {
            boolean z = false;
            if (this.fBR != null && this.fBR.fCq != null && !TextUtils.isEmpty(this.fBR.fCq.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fBR.fCq.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(this.fBR.fCq.userId, 0L), z, this.fBR.fCq.isGod)));
            }
        } else if (view == this.fBO || view == this.fBE || view == getView()) {
            if (this.fBR != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fBR.threadId, null, null);
                if (!this.fBZ) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fBI) {
            if (this.fBR != null && this.fBR.fCr != null) {
                this.fBG.setVisibility(8);
                this.fBQ.ceN();
                this.fBQ.ct(this.fBR.fCr.videoUrl, this.fBR.threadId);
                xz("2");
            }
        } else if (view == this.fBJ) {
            if (!this.fBR.fCq.hasFocus) {
                this.fBS.f(this.fBR);
            }
        } else if (view == this.fBP) {
            this.fBS.g(this.fBR);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kt(boolean z) {
        if (this.fBR != null && this.fBR.fCq != null) {
            this.fBR.fCq.hasFocus = z;
            c(this.fBR);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bpg() {
        if (this.fBR != null) {
            this.fBR.hasAgree = !this.fBR.hasAgree;
            if (this.fBR.hasAgree) {
                this.fBR.agreeNum++;
            } else {
                this.fBR.agreeNum--;
            }
            if (this.fBN != null) {
                this.fBN.startAnimation(getScaleAnimation());
            }
            d(this.fBR);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fBY == null) {
            this.fBY = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fBY.setDuration(200L);
        }
        return this.fBY;
    }
}
