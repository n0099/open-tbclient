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
    private n dlN;
    public HeadImageView ebj;
    private ScaleAnimation fuA;
    private boolean fuB;
    public FrameLayout fue;
    public FrameLayout fuf;
    public TextView fug;
    public TextView fuh;
    public FrameLayout fui;
    public TextView fuj;
    public TextView fuk;
    public TextView ful;
    public TextView fum;
    public TextView fun;
    public ImageView fuo;
    public ImageView fup;
    public LinearLayout fuq;
    public LinearLayout fur;
    public com.baidu.tieba.play.c fus;
    public g fut;
    private h fuu;
    private z fuv;
    private z fuw;
    private boolean fux;
    private boolean fuy;
    private Animation fuz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fux = true;
        this.fuB = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fue = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fuf = (FrameLayout) view.findViewById(R.id.video_container);
        this.fus = new com.baidu.tieba.play.c(tbPageContext, (View) this.fuf, false);
        this.fug = (TextView) view.findViewById(R.id.title);
        this.fuh = (TextView) view.findViewById(R.id.duration);
        this.fui = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.fuj = (TextView) view.findViewById(R.id.mobile_network_text);
        this.fuk = (TextView) view.findViewById(R.id.mobile_network_play);
        this.ebj = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Xr = (TextView) view.findViewById(R.id.user_name);
        this.ful = (TextView) view.findViewById(R.id.attention);
        this.fuq = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.fur = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.fum = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fun = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.fuo = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fup = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.fuq.setOnClickListener(this);
        this.fur.setOnClickListener(this);
        this.fug.setOnClickListener(this);
        this.ebj.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.ful.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fuk.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fue.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fue.setLayoutParams(layoutParams);
        this.ebj.setIsRound(true);
        this.dlN = new n(tbPageContext.getPageActivity());
        this.fuu = new h(this.mPageContext, this);
        this.fuz = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.afk = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.l(getView(), R.color.cp_bg_line_d);
            if (this.fut != null && this.fut.fuS != null) {
                if (this.fut.fuS.hasFocus) {
                    al.j(this.ful, R.color.cp_cont_d);
                    this.ful.setCompoundDrawables(null, null, null, null);
                } else {
                    al.j(this.ful, R.color.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
                    this.ful.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fut != null) {
                if (this.fut.hasAgree) {
                    this.fup.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_s));
                    al.j(this.fun, R.color.cp_cont_h);
                } else {
                    this.fup.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_n));
                    al.j(this.fun, R.color.cp_cont_f);
                }
            }
            al.j(this.fum, R.color.cp_cont_f);
            this.fuo.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.fuT != null) {
            this.fut = gVar;
            this.bNF = this.fut.autoPlay;
            this.fug.setVisibility(0);
            this.fug.setText(gVar.title);
            this.fuh.setVisibility(0);
            this.fuh.setText(ap.im(gVar.fuT.videoDuration * 1000));
            if (gVar.fuT.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), ww(String.format("%.1f", Float.valueOf(((float) gVar.fuT.videoSize) / 1048576.0f))));
            }
            this.fuj.setText(format);
            this.fui.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.fuT != null) {
            this.fus.stopPlay();
            this.fus.setIsNeedRecoveryVideoPlayer(true);
            this.fus.pM(true);
            this.fus.pI(false);
            this.fus.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                    if (b.this.fus.pg()) {
                        b.this.fuh.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                    if (b.this.fus.pg()) {
                        b.this.fuh.setVisibility(8);
                    }
                    if (b.this.fuy) {
                        b.this.fus.stopPlay();
                    }
                }
            });
            this.fus.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bmf() {
                    b.this.fuy = false;
                    b.this.fuh.setVisibility(8);
                    b.this.wv(b.this.bNF ? "1" : "2");
                    b.this.onClick(b.this.fuf);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmg() {
                    b.this.fuh.setVisibility(8);
                    b.this.onClick(b.this.fue);
                }
            });
            this.fus.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fuj.getText().toString());
                        b.this.fus.cr(b.this.fut.fuT.videoUrl, b.this.fut.threadId);
                        b.this.fuh.setVisibility(8);
                        b.this.wv("2");
                    } else {
                        b.this.fui.setVisibility(0);
                    }
                    b.this.onClick(b.this.fuf);
                }
            });
            this.fus.pE(false);
            this.fuv = new z();
            this.fuv.bVL = gVar.threadId;
            this.fuv.eAB = gVar.forumId;
            this.fuv.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fuw = new z();
            this.fuw.bVL = gVar.threadId;
            this.fuw.eAB = gVar.forumId;
            this.fuw.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fuB) {
                am amVar = new am("c12590");
                amVar.bT("tid", gVar.threadId);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.bT("fid", gVar.forumId);
                amVar.P("obj_locate", i);
                amVar.P("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.fuv.ire = "auto_midpage";
                this.fuv.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.fuv.irg = "1";
                this.fuw.ire = "auto_midpage";
                this.fuw.mLocate = "auto_midpage";
                this.fuw.irg = "1";
            } else {
                this.fuv.irg = "frs_bavideotab";
                this.fuv.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fuw.irg = "frs_bavideotab";
                this.fuw.mLocate = "frs_bavideotab";
            }
            if (gVar.fuT != null) {
                this.fuv.iri = gVar.fuT.videoMd5;
                this.fuw.iri = gVar.fuT.videoMd5;
            }
            this.dlN.setVideoStatsData(this.fuv);
            this.fus.getVideoView().setBusiness(this.dlN);
            this.fus.bIn();
            this.fus.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (!b.this.fus.pg()) {
                        b.this.fug.setVisibility(0);
                    } else if (z) {
                        if (b.this.fug.getVisibility() == 0) {
                            b.this.fug.setVisibility(8);
                            b.this.fug.startAnimation(b.this.fuz);
                        }
                    } else if (b.this.fug.getVisibility() == 8) {
                        b.this.fug.setVisibility(0);
                        b.this.fug.startAnimation(b.this.afk);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmh() {
                    if (!b.this.fus.pg()) {
                        b.this.fug.setVisibility(0);
                    } else if (b.this.fug.getVisibility() == 0) {
                        b.this.fug.setVisibility(8);
                        b.this.fug.startAnimation(b.this.fuz);
                    }
                }
            });
            this.fus.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fuy = true;
                        b.this.fux = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.ry(i);
                        b.this.fus.bvq();
                    }
                }
            });
            this.fus.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fut != null && b.this.fut.fuT != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fut.fuT.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fus.setThumbnail(gVar.fuT.thumbnailUrl);
            this.fus.setVideoUrl(gVar.fuT.videoUrl, gVar.threadId);
            this.fus.Cf(gVar.title);
            this.fus.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bmi() {
                    b.this.fuh.setVisibility(8);
                }
            });
            this.fus.bvq();
            this.fus.show();
            if (gVar.autoPlay) {
                onClick(this.fuf);
                this.fuy = false;
                this.fus.a(gVar.fuT.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fuy = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(String str) {
        if (this.fut != null && this.fut.fuT != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fut.fuT.videoMd5, "", str, this.fuw);
            }
        }
    }

    public boolean isPlaying() {
        return this.fus.pg();
    }

    public void bmb() {
        if (isPlaying()) {
            this.fus.pausePlay();
        }
    }

    public boolean rz(int i) {
        return this.fus.yo(i);
    }

    public void bmc() {
        this.fui.setVisibility(8);
        this.fus.stopPlay();
        if (this.fug != null) {
            this.fug.setVisibility(0);
        }
        if (this.fuh != null) {
            this.fuh.setVisibility(0);
        }
    }

    public void bmd() {
        if (this.fus != null) {
            this.fus.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmd();
        if (this.fuu != null) {
            this.fuu.bmo();
        }
    }

    public String ww(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.fuS != null) {
            this.Xr.setText(TextUtils.isEmpty(gVar.fuS.userNickname) ? gVar.fuS.userName : gVar.fuS.userNickname);
            this.ebj.startLoad(gVar.fuS.portrait, 12, false);
            this.ebj.setShowV(gVar.fuS.isGod);
            this.ebj.setIsBigV(gVar.fuS.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.fuS != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.fuS.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.fuS.userId)) {
                this.ful.setVisibility(8);
            } else {
                this.ful.setVisibility(0);
            }
            if (gVar.fuS.hasFocus) {
                al.j(this.ful, R.color.cp_cont_d);
                this.ful.setCompoundDrawables(null, null, null, null);
                this.ful.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            al.j(this.ful, R.color.cp_link_tip_a);
            Drawable drawable = al.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
            this.ful.setCompoundDrawables(drawable, null, null, null);
            this.ful.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.fup.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_s));
                al.j(this.fun, R.color.cp_cont_h);
            } else {
                this.fup.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_like_n));
                al.j(this.fun, R.color.cp_cont_f);
            }
            this.fun.setText(ap.aN(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            al.j(this.fum, R.color.cp_cont_f);
            this.fuo.setImageDrawable(al.getDrawable(R.drawable.icon_home_card_comment));
            this.fum.setText(ap.aN(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fus != null && this.fuf != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fux) {
                this.fus.caJ();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fuf.getParent() != null) {
                    if (this.fuf.getParent() == frameLayout) {
                        frameLayout.removeView(this.fuf);
                    } else if (this.fuf.getParent() == this.fue) {
                        this.fue.removeView(this.fuf);
                    }
                }
                if (this.fuf.getParent() == null) {
                    frameLayout.addView(this.fuf);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fuf.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fuf.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fuf.getParent() != null) {
                    if (this.fuf.getParent() == frameLayout) {
                        frameLayout.removeView(this.fuf);
                    } else if (this.fuf.getParent() == this.fue) {
                        this.fue.removeView(this.fuf);
                    }
                }
                if (this.fuf.getParent() == null) {
                    this.fue.addView(this.fuf, 0);
                    this.fuf.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fus.bIn();
                    this.fux = true;
                } else {
                    return;
                }
            }
            this.fus.a(this.mPageContext, configuration);
            this.fuh.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXo() != null) {
            view.setTag(this);
            aXo().a(view, this.fut);
        }
        if (view == this.ebj || view == this.Xr) {
            boolean z = false;
            if (this.fut != null && this.fut.fuS != null && !TextUtils.isEmpty(this.fut.fuS.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fut.fuS.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fut.fuS.userId, 0L), z, this.fut.fuS.isGod)));
            }
        } else if (view == this.fuq || view == this.fug || view == getView()) {
            if (this.fut != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fut.threadId, null, null);
                if (!this.fuB) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fuk) {
            if (this.fut != null && this.fut.fuT != null) {
                this.fui.setVisibility(8);
                this.fus.caM();
                this.fus.cr(this.fut.fuT.videoUrl, this.fut.threadId);
                wv("2");
            }
        } else if (view == this.ful) {
            if (!this.fut.fuS.hasFocus) {
                this.fuu.f(this.fut);
            }
        } else if (view == this.fur) {
            this.fuu.g(this.fut);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fut != null && this.fut.fuS != null) {
            this.fut.fuS.hasFocus = z;
            c(this.fut);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bme() {
        if (this.fut != null) {
            this.fut.hasAgree = !this.fut.hasAgree;
            if (this.fut.hasAgree) {
                this.fut.agreeNum++;
            } else {
                this.fut.agreeNum--;
            }
            if (this.fup != null) {
                this.fup.startAnimation(getScaleAnimation());
            }
            d(this.fut);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fuA == null) {
            this.fuA = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fuA.setDuration(200L);
        }
        return this.fuA;
    }
}
