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
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView aBt;
    private boolean aoz;
    public g awk;
    private n bBi;
    public HeadImageView coE;
    public FrameLayout dwV;
    public FrameLayout dwW;
    public TextView dwX;
    public TextView dwY;
    public FrameLayout dwZ;
    public TextView dxa;
    public TextView dxb;
    public TextView dxc;
    public TextView dxd;
    public TextView dxe;
    public ImageView dxf;
    public ImageView dxg;
    public LinearLayout dxh;
    public LinearLayout dxi;
    public com.baidu.tieba.play.c dxj;
    private h dxk;
    private y dxl;
    private y dxm;
    private boolean dxn;
    private boolean dxo;
    private Animation dxp;
    private Animation dxq;
    private ScaleAnimation dxr;
    private boolean dxs;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dxn = true;
        this.dxs = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dwV = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dwW = (FrameLayout) view.findViewById(e.g.video_container);
        this.dxj = new com.baidu.tieba.play.c(tbPageContext, this.dwW, false);
        this.dwX = (TextView) view.findViewById(e.g.title);
        this.dwY = (TextView) view.findViewById(e.g.duration);
        this.dwZ = (FrameLayout) view.findViewById(e.g.mobile_network_container);
        this.dxa = (TextView) view.findViewById(e.g.mobile_network_text);
        this.dxb = (TextView) view.findViewById(e.g.mobile_network_play);
        this.coE = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aBt = (TextView) view.findViewById(e.g.user_name);
        this.dxc = (TextView) view.findViewById(e.g.attention);
        this.dxh = (LinearLayout) view.findViewById(e.g.thread_info_commont_container);
        this.dxi = (LinearLayout) view.findViewById(e.g.agree_view_container);
        this.dxd = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.dxe = (TextView) view.findViewById(e.g.thread_info_praise_num);
        this.dxf = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.dxg = (ImageView) view.findViewById(e.g.thread_info_praise_img);
        this.dxh.setOnClickListener(this);
        this.dxi.setOnClickListener(this);
        this.dwX.setOnClickListener(this);
        this.coE.setOnClickListener(this);
        this.aBt.setOnClickListener(this);
        this.dxc.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dxb.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dwV.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dwV.setLayoutParams(layoutParams);
        this.coE.setIsRound(true);
        this.bBi = new n(tbPageContext.getPageActivity());
        this.dxk = new h(this.mPageContext, this);
        this.dxp = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_200);
        this.dxq = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), e.d.cp_bg_line_d);
            if (this.awk != null && this.awk.dxJ != null) {
                if (this.awk.dxJ.hasFocus) {
                    al.h(this.dxc, e.d.cp_cont_d);
                    this.dxc.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.dxc, e.d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, e.C0141e.ds20), l.h(this.mContext, e.C0141e.ds20));
                    this.dxc.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.awk != null) {
                if (this.awk.hasAgree) {
                    this.dxg.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                    al.h(this.dxe, e.d.cp_cont_h);
                } else {
                    this.dxg.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                    al.h(this.dxe, e.d.cp_cont_f);
                }
            }
            al.h(this.dxd, e.d.cp_cont_f);
            this.dxf.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dxK != null) {
            this.awk = gVar;
            this.aoz = this.awk.autoPlay;
            this.dwX.setVisibility(0);
            this.dwX.setText(gVar.title);
            this.dwY.setVisibility(0);
            this.dwY.setText(ao.dj(gVar.dxK.videoDuration * 1000));
            if (gVar.dxK.videoSize == 0) {
                format = this.mPageContext.getString(e.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(e.j.video_mobile_network_tips), nd(String.format("%.1f", Float.valueOf(((float) gVar.dxK.videoSize) / 1048576.0f))));
            }
            this.dxa.setText(format);
            this.dwZ.setVisibility(8);
            b(gVar, i, aVar);
            c(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dxK != null) {
            this.dxj.stopPlay();
            this.dxj.setIsNeedRecoveryVideoPlayer(true);
            this.dxj.lR(true);
            this.dxj.lN(false);
            this.dxj.a(new c.InterfaceC0224c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ayr() {
                    if (b.this.dxj.bmu()) {
                        b.this.dwY.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ays() {
                    if (b.this.dxj.bmu()) {
                        b.this.dwY.setVisibility(8);
                    }
                    if (b.this.dxo) {
                        b.this.dxj.stopPlay();
                    }
                }
            });
            this.dxj.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void ayt() {
                    b.this.dxo = false;
                    b.this.dwY.setVisibility(8);
                    b.this.nc(b.this.aoz ? "1" : "2");
                    b.this.onClick(b.this.dwW);
                }

                @Override // com.baidu.tieba.play.c.l
                public void ayu() {
                    b.this.dwY.setVisibility(8);
                    b.this.onClick(b.this.dwV);
                }
            });
            this.dxj.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void gq(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dxa.getText().toString());
                        b.this.dxj.cb(b.this.awk.dxK.videoUrl, b.this.awk.threadId);
                        b.this.dwY.setVisibility(8);
                        b.this.nc("2");
                    } else {
                        b.this.dwZ.setVisibility(0);
                    }
                    b.this.onClick(b.this.dwW);
                }
            });
            this.dxj.lK(false);
            this.dxl = new y();
            this.dxl.aZG = gVar.threadId;
            this.dxl.cHI = gVar.forumId;
            this.dxl.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dxm = new y();
            this.dxm.aZG = gVar.threadId;
            this.dxm.cHI = gVar.forumId;
            this.dxm.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dxs) {
                am amVar = new am("c12590");
                amVar.al("tid", gVar.threadId);
                amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.w("obj_locate", i);
                amVar.w("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dxl.goU = "auto_midpage";
                this.dxl.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dxl.goW = "1";
                this.dxm.goU = "auto_midpage";
                this.dxm.mLocate = "auto_midpage";
                this.dxm.goW = "1";
            } else {
                this.dxl.goW = "frs_bavideotab";
                this.dxl.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dxm.goW = "frs_bavideotab";
                this.dxm.mLocate = "frs_bavideotab";
            }
            if (gVar.dxK != null) {
                this.dxl.goY = gVar.dxK.videoMd5;
                this.dxm.goY = gVar.dxK.videoMd5;
            }
            this.bBi.setVideoStatsData(this.dxl);
            this.dxj.getVideoView().setBusiness(this.bBi);
            this.dxj.aUn();
            this.dxj.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void gr(boolean z) {
                    if (!b.this.dxj.bmu()) {
                        b.this.dwX.setVisibility(0);
                    } else if (z) {
                        if (b.this.dwX.getVisibility() == 0) {
                            b.this.dwX.setVisibility(8);
                            b.this.dwX.startAnimation(b.this.dxp);
                        }
                    } else if (b.this.dwX.getVisibility() == 8) {
                        b.this.dwX.setVisibility(0);
                        b.this.dwX.startAnimation(b.this.dxq);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void ayv() {
                    if (!b.this.dxj.bmu()) {
                        b.this.dwX.setVisibility(0);
                    } else if (b.this.dwX.getVisibility() == 0) {
                        b.this.dwX.setVisibility(8);
                        b.this.dwX.startAnimation(b.this.dxp);
                    }
                }
            });
            this.dxj.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dxo = true;
                        b.this.dxn = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.ln(i);
                        b.this.dxj.aHp();
                    }
                }
            });
            this.dxj.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.awk != null && b.this.awk.dxK != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.awk.dxK.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dxj.setThumbnail(gVar.dxK.thumbnailUrl);
            this.dxj.setVideoUrl(gVar.dxK.videoUrl, gVar.threadId);
            this.dxj.sK(gVar.title);
            this.dxj.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void ayw() {
                    b.this.dwY.setVisibility(8);
                }
            });
            this.dxj.aHp();
            this.dxj.show();
            if (gVar.autoPlay) {
                onClick(this.dwW);
                this.dxo = false;
                this.dxj.a(gVar.dxK.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.dxo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(String str) {
        if (this.awk != null && this.awk.dxK != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.awk.dxK.videoMd5, "", str, this.dxm);
            }
        }
    }

    public boolean isPlaying() {
        return this.dxj.bmu();
    }

    public void ayn() {
        if (isPlaying()) {
            this.dxj.pausePlay();
        }
    }

    public boolean lo(int i) {
        return this.dxj.sb(i);
    }

    public void ayo() {
        this.dwZ.setVisibility(8);
        this.dxj.stopPlay();
        if (this.dwX != null) {
            this.dwX.setVisibility(0);
        }
        if (this.dwY != null) {
            this.dwY.setVisibility(0);
        }
    }

    public void ayp() {
        if (this.dxj != null) {
            this.dxj.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        ayp();
        if (this.dxk != null) {
            this.dxk.ayC();
        }
    }

    public String nd(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dxJ != null) {
            this.aBt.setText(TextUtils.isEmpty(gVar.dxJ.userNickname) ? gVar.dxJ.userName : gVar.dxJ.userNickname);
            this.coE.startLoad(gVar.dxJ.portrait, 12, false);
            this.coE.setShowV(gVar.dxJ.isGod);
            this.coE.setIsBigV(gVar.dxJ.isGod);
            d(gVar);
            e(gVar);
            f(gVar);
        }
    }

    public void d(g gVar) {
        if (gVar != null && gVar.dxJ != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dxJ.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dxJ.userId)) {
                this.dxc.setVisibility(8);
            } else {
                this.dxc.setVisibility(0);
            }
            if (gVar.dxJ.hasFocus) {
                al.h(this.dxc, e.d.cp_cont_d);
                this.dxc.setCompoundDrawables(null, null, null, null);
                this.dxc.setText(this.mPageContext.getString(e.j.relate_forum_is_followed));
                return;
            }
            al.h(this.dxc, e.d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, e.C0141e.ds20), l.h(this.mContext, e.C0141e.ds20));
            this.dxc.setCompoundDrawables(drawable, null, null, null);
            this.dxc.setText(this.mPageContext.getString(e.j.attention));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dxg.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                al.h(this.dxe, e.d.cp_cont_h);
            } else {
                this.dxg.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                al.h(this.dxe, e.d.cp_cont_f);
            }
            this.dxe.setText(ao.L(gVar.agreeNum));
        }
    }

    public void f(g gVar) {
        if (gVar != null) {
            al.h(this.dxd, e.d.cp_cont_f);
            this.dxf.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
            this.dxd.setText(ao.L(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dxj != null && this.dwW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dxn) {
                this.dxj.bmt();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dwW.getParent() != null) {
                    if (this.dwW.getParent() == frameLayout) {
                        frameLayout.removeView(this.dwW);
                    } else if (this.dwW.getParent() == this.dwV) {
                        this.dwV.removeView(this.dwW);
                    }
                }
                if (this.dwW.getParent() == null) {
                    frameLayout.addView(this.dwW);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dwW.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dwW.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dwW.getParent() != null) {
                    if (this.dwW.getParent() == frameLayout) {
                        frameLayout.removeView(this.dwW);
                    } else if (this.dwW.getParent() == this.dwV) {
                        this.dwV.removeView(this.dwW);
                    }
                }
                if (this.dwW.getParent() == null) {
                    this.dwV.addView(this.dwW, 0);
                    this.dwW.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dxj.aUn();
                    this.dxn = true;
                } else {
                    return;
                }
            }
            this.dxj.a(this.mPageContext, configuration);
            this.dwY.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akm() != null) {
            view.setTag(this);
            akm().a(view, this.awk);
        }
        if (view == this.coE || view == this.aBt) {
            boolean z = false;
            if (this.awk != null && this.awk.dxJ != null && !TextUtils.isEmpty(this.awk.dxJ.userId)) {
                if (TbadkCoreApplication.isLogin() && this.awk.dxJ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.awk.dxJ.userId, 0L), z, this.awk.dxJ.isGod)));
            }
        } else if (view == this.dxh || view == this.dwX || view == getView()) {
            if (this.awk != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.awk.threadId, null, null);
                if (!this.dxs) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dxb) {
            if (this.awk != null && this.awk.dxK != null) {
                this.dwZ.setVisibility(8);
                this.dxj.bmx();
                this.dxj.cb(this.awk.dxK.videoUrl, this.awk.threadId);
                nc("2");
            }
        } else if (view == this.dxc) {
            if (!this.awk.dxJ.hasFocus) {
                this.dxk.g(this.awk);
            }
        } else if (view == this.dxi) {
            this.dxk.h(this.awk);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gp(boolean z) {
        if (this.awk != null && this.awk.dxJ != null) {
            this.awk.dxJ.hasFocus = z;
            d(this.awk);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ayq() {
        if (this.awk != null) {
            this.awk.hasAgree = !this.awk.hasAgree;
            if (this.awk.hasAgree) {
                this.awk.agreeNum++;
            } else {
                this.awk.agreeNum--;
            }
            if (this.dxg != null) {
                this.dxg.startAnimation(getScaleAnimation());
            }
            e(this.awk);
        }
    }

    private Animation getScaleAnimation() {
        if (this.dxr == null) {
            this.dxr = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dxr.setDuration(200L);
        }
        return this.dxr;
    }
}
