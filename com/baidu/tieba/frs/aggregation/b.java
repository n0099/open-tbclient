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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView Xr;
    private Animation afk;
    private boolean bNF;
    private n dlO;
    public HeadImageView ebk;
    private Animation fuA;
    private ScaleAnimation fuB;
    private boolean fuC;
    public FrameLayout fuf;
    public FrameLayout fug;
    public TextView fuh;
    public TextView fui;
    public FrameLayout fuj;
    public TextView fuk;
    public TextView ful;
    public TextView fum;
    public TextView fun;
    public TextView fuo;
    public ImageView fup;
    public ImageView fuq;
    public LinearLayout fur;
    public LinearLayout fus;
    public com.baidu.tieba.play.c fut;
    public g fuu;
    private h fuv;
    private z fuw;
    private z fux;
    private boolean fuy;
    private boolean fuz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fuy = true;
        this.fuC = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fuf = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fug = (FrameLayout) view.findViewById(R.id.video_container);
        this.fut = new com.baidu.tieba.play.c(tbPageContext, (View) this.fug, false);
        this.fuh = (TextView) view.findViewById(R.id.title);
        this.fui = (TextView) view.findViewById(R.id.duration);
        this.fuj = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.fuk = (TextView) view.findViewById(R.id.mobile_network_text);
        this.ful = (TextView) view.findViewById(R.id.mobile_network_play);
        this.ebk = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Xr = (TextView) view.findViewById(R.id.user_name);
        this.fum = (TextView) view.findViewById(R.id.attention);
        this.fur = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.fus = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.fun = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fuo = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.fup = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fuq = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.fur.setOnClickListener(this);
        this.fus.setOnClickListener(this);
        this.fuh.setOnClickListener(this);
        this.ebk.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.fum.setOnClickListener(this);
        view.setOnClickListener(this);
        this.ful.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fuf.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fuf.setLayoutParams(layoutParams);
        this.ebk.setIsRound(true);
        this.dlO = new n(tbPageContext.getPageActivity());
        this.fuv = new h(this.mPageContext, this);
        this.fuA = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.afk = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.l(getView(), R.color.cp_bg_line_d);
            if (this.fuu != null && this.fuu.fuT != null) {
                if (this.fuu.fuT.hasFocus) {
                    al.j(this.fum, R.color.cp_cont_d);
                    this.fum.setCompoundDrawables(null, null, null, null);
                } else {
                    al.j(this.fum, R.color.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
                    this.fum.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fuu != null) {
                if (this.fuu.hasAgree) {
                    this.fuq.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_s));
                    al.j(this.fuo, R.color.cp_cont_h);
                } else {
                    this.fuq.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_n));
                    al.j(this.fuo, R.color.cp_cont_f);
                }
            }
            al.j(this.fun, R.color.cp_cont_f);
            this.fup.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.fuU != null) {
            this.fuu = gVar;
            this.bNF = this.fuu.autoPlay;
            this.fuh.setVisibility(0);
            this.fuh.setText(gVar.title);
            this.fui.setVisibility(0);
            this.fui.setText(ap.im(gVar.fuU.videoDuration * 1000));
            if (gVar.fuU.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), ww(String.format("%.1f", Float.valueOf(((float) gVar.fuU.videoSize) / 1048576.0f))));
            }
            this.fuk.setText(format);
            this.fuj.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.fuU != null) {
            this.fut.stopPlay();
            this.fut.setIsNeedRecoveryVideoPlayer(true);
            this.fut.pM(true);
            this.fut.pI(false);
            this.fut.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                    if (b.this.fut.pg()) {
                        b.this.fui.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                    if (b.this.fut.pg()) {
                        b.this.fui.setVisibility(8);
                    }
                    if (b.this.fuz) {
                        b.this.fut.stopPlay();
                    }
                }
            });
            this.fut.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bmi() {
                    b.this.fuz = false;
                    b.this.fui.setVisibility(8);
                    b.this.wv(b.this.bNF ? "1" : "2");
                    b.this.onClick(b.this.fug);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmj() {
                    b.this.fui.setVisibility(8);
                    b.this.onClick(b.this.fuf);
                }
            });
            this.fut.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fuk.getText().toString());
                        b.this.fut.cr(b.this.fuu.fuU.videoUrl, b.this.fuu.threadId);
                        b.this.fui.setVisibility(8);
                        b.this.wv("2");
                    } else {
                        b.this.fuj.setVisibility(0);
                    }
                    b.this.onClick(b.this.fug);
                }
            });
            this.fut.pE(false);
            this.fuw = new z();
            this.fuw.bVL = gVar.threadId;
            this.fuw.eAC = gVar.forumId;
            this.fuw.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fux = new z();
            this.fux.bVL = gVar.threadId;
            this.fux.eAC = gVar.forumId;
            this.fux.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fuC) {
                am amVar = new am("c12590");
                amVar.bT("tid", gVar.threadId);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.bT("fid", gVar.forumId);
                amVar.P("obj_locate", i);
                amVar.P("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.fuw.irh = "auto_midpage";
                this.fuw.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.fuw.irj = "1";
                this.fux.irh = "auto_midpage";
                this.fux.mLocate = "auto_midpage";
                this.fux.irj = "1";
            } else {
                this.fuw.irj = "frs_bavideotab";
                this.fuw.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fux.irj = "frs_bavideotab";
                this.fux.mLocate = "frs_bavideotab";
            }
            if (gVar.fuU != null) {
                this.fuw.irl = gVar.fuU.videoMd5;
                this.fux.irl = gVar.fuU.videoMd5;
            }
            this.dlO.setVideoStatsData(this.fuw);
            this.fut.getVideoView().setBusiness(this.dlO);
            this.fut.bIq();
            this.fut.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (!b.this.fut.pg()) {
                        b.this.fuh.setVisibility(0);
                    } else if (z) {
                        if (b.this.fuh.getVisibility() == 0) {
                            b.this.fuh.setVisibility(8);
                            b.this.fuh.startAnimation(b.this.fuA);
                        }
                    } else if (b.this.fuh.getVisibility() == 8) {
                        b.this.fuh.setVisibility(0);
                        b.this.fuh.startAnimation(b.this.afk);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmk() {
                    if (!b.this.fut.pg()) {
                        b.this.fuh.setVisibility(0);
                    } else if (b.this.fuh.getVisibility() == 0) {
                        b.this.fuh.setVisibility(8);
                        b.this.fuh.startAnimation(b.this.fuA);
                    }
                }
            });
            this.fut.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fuz = true;
                        b.this.fuy = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.ry(i);
                        b.this.fut.bvt();
                    }
                }
            });
            this.fut.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fuu != null && b.this.fuu.fuU != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fuu.fuU.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fut.setThumbnail(gVar.fuU.thumbnailUrl);
            this.fut.setVideoUrl(gVar.fuU.videoUrl, gVar.threadId);
            this.fut.Cf(gVar.title);
            this.fut.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bml() {
                    b.this.fui.setVisibility(8);
                }
            });
            this.fut.bvt();
            this.fut.show();
            if (gVar.autoPlay) {
                onClick(this.fug);
                this.fuz = false;
                this.fut.a(gVar.fuU.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fuz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(String str) {
        if (this.fuu != null && this.fuu.fuU != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fuu.fuU.videoMd5, "", str, this.fux);
            }
        }
    }

    public boolean isPlaying() {
        return this.fut.pg();
    }

    public void bme() {
        if (isPlaying()) {
            this.fut.pausePlay();
        }
    }

    public boolean rz(int i) {
        return this.fut.yo(i);
    }

    public void bmf() {
        this.fuj.setVisibility(8);
        this.fut.stopPlay();
        if (this.fuh != null) {
            this.fuh.setVisibility(0);
        }
        if (this.fui != null) {
            this.fui.setVisibility(0);
        }
    }

    public void bmg() {
        if (this.fut != null) {
            this.fut.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmg();
        if (this.fuv != null) {
            this.fuv.bmr();
        }
    }

    public String ww(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.fuT != null) {
            this.Xr.setText(TextUtils.isEmpty(gVar.fuT.userNickname) ? gVar.fuT.userName : gVar.fuT.userNickname);
            this.ebk.startLoad(gVar.fuT.portrait, 12, false);
            this.ebk.setShowV(gVar.fuT.isGod);
            this.ebk.setIsBigV(gVar.fuT.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.fuT != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.fuT.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.fuT.userId)) {
                this.fum.setVisibility(8);
            } else {
                this.fum.setVisibility(0);
            }
            if (gVar.fuT.hasFocus) {
                al.j(this.fum, R.color.cp_cont_d);
                this.fum.setCompoundDrawables(null, null, null, null);
                this.fum.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            al.j(this.fum, R.color.cp_link_tip_a);
            Drawable drawable = al.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
            this.fum.setCompoundDrawables(drawable, null, null, null);
            this.fum.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.fuq.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_s));
                al.j(this.fuo, R.color.cp_cont_h);
            } else {
                this.fuq.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_n));
                al.j(this.fuo, R.color.cp_cont_f);
            }
            this.fuo.setText(ap.aN(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            al.j(this.fun, R.color.cp_cont_f);
            this.fup.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_comment));
            this.fun.setText(ap.aN(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fut != null && this.fug != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fuy) {
                this.fut.caM();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fug.getParent() != null) {
                    if (this.fug.getParent() == frameLayout) {
                        frameLayout.removeView(this.fug);
                    } else if (this.fug.getParent() == this.fuf) {
                        this.fuf.removeView(this.fug);
                    }
                }
                if (this.fug.getParent() == null) {
                    frameLayout.addView(this.fug);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fug.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fug.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fug.getParent() != null) {
                    if (this.fug.getParent() == frameLayout) {
                        frameLayout.removeView(this.fug);
                    } else if (this.fug.getParent() == this.fuf) {
                        this.fuf.removeView(this.fug);
                    }
                }
                if (this.fug.getParent() == null) {
                    this.fuf.addView(this.fug, 0);
                    this.fug.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fut.bIq();
                    this.fuy = true;
                } else {
                    return;
                }
            }
            this.fut.a(this.mPageContext, configuration);
            this.fui.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXr() != null) {
            view.setTag(this);
            aXr().a(view, this.fuu);
        }
        if (view == this.ebk || view == this.Xr) {
            boolean z = false;
            if (this.fuu != null && this.fuu.fuT != null && !TextUtils.isEmpty(this.fuu.fuT.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fuu.fuT.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fuu.fuT.userId, 0L), z, this.fuu.fuT.isGod)));
            }
        } else if (view == this.fur || view == this.fuh || view == getView()) {
            if (this.fuu != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fuu.threadId, null, null);
                if (!this.fuC) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.ful) {
            if (this.fuu != null && this.fuu.fuU != null) {
                this.fuj.setVisibility(8);
                this.fut.caP();
                this.fut.cr(this.fuu.fuU.videoUrl, this.fuu.threadId);
                wv("2");
            }
        } else if (view == this.fum) {
            if (!this.fuu.fuT.hasFocus) {
                this.fuv.f(this.fuu);
            }
        } else if (view == this.fus) {
            this.fuv.g(this.fuu);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fuu != null && this.fuu.fuT != null) {
            this.fuu.fuT.hasFocus = z;
            c(this.fuu);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bmh() {
        if (this.fuu != null) {
            this.fuu.hasAgree = !this.fuu.hasAgree;
            if (this.fuu.hasAgree) {
                this.fuu.agreeNum++;
            } else {
                this.fuu.agreeNum--;
            }
            if (this.fuq != null) {
                this.fuq.startAnimation(getScaleAnimation());
            }
            d(this.fuu);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fuB == null) {
            this.fuB = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fuB.setDuration(200L);
        }
        return this.fuB;
    }
}
