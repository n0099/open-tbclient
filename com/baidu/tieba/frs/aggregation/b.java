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
    private boolean bOG;
    private n dnw;
    public HeadImageView efG;
    public FrameLayout fzb;
    public FrameLayout fzc;
    public TextView fzd;
    public TextView fze;
    public FrameLayout fzf;
    public TextView fzg;
    public TextView fzh;
    public TextView fzi;
    public TextView fzj;
    public TextView fzk;
    public ImageView fzl;
    public ImageView fzm;
    public LinearLayout fzn;
    public LinearLayout fzo;
    public com.baidu.tieba.play.c fzp;
    public g fzq;
    private h fzr;
    private z fzs;
    private z fzt;
    private boolean fzu;
    private boolean fzv;
    private Animation fzw;
    private ScaleAnimation fzx;
    private boolean fzy;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fzu = true;
        this.fzy = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fzb = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fzc = (FrameLayout) view.findViewById(R.id.video_container);
        this.fzp = new com.baidu.tieba.play.c(tbPageContext, (View) this.fzc, false);
        this.fzd = (TextView) view.findViewById(R.id.title);
        this.fze = (TextView) view.findViewById(R.id.duration);
        this.fzf = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.fzg = (TextView) view.findViewById(R.id.mobile_network_text);
        this.fzh = (TextView) view.findViewById(R.id.mobile_network_play);
        this.efG = (HeadImageView) view.findViewById(R.id.user_icon);
        this.XL = (TextView) view.findViewById(R.id.user_name);
        this.fzi = (TextView) view.findViewById(R.id.attention);
        this.fzn = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.fzo = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.fzj = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fzk = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.fzl = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fzm = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.fzn.setOnClickListener(this);
        this.fzo.setOnClickListener(this);
        this.fzd.setOnClickListener(this);
        this.efG.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.fzi.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fzh.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzb.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fzb.setLayoutParams(layoutParams);
        this.efG.setIsRound(true);
        this.dnw = new n(tbPageContext.getPageActivity());
        this.fzr = new h(this.mPageContext, this);
        this.fzw = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.afH = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.l(getView(), R.color.cp_bg_line_d);
            if (this.fzq != null && this.fzq.fzP != null) {
                if (this.fzq.fzP.hasFocus) {
                    am.j(this.fzi, R.color.cp_cont_d);
                    this.fzi.setCompoundDrawables(null, null, null, null);
                } else {
                    am.j(this.fzi, R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
                    this.fzi.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fzq != null) {
                if (this.fzq.hasAgree) {
                    this.fzm.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.j(this.fzk, R.color.cp_cont_h);
                } else {
                    this.fzm.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.j(this.fzk, R.color.cp_cont_f);
                }
            }
            am.j(this.fzj, R.color.cp_cont_f);
            this.fzl.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.fzQ != null) {
            this.fzq = gVar;
            this.bOG = this.fzq.autoPlay;
            this.fzd.setVisibility(0);
            this.fzd.setText(gVar.title);
            this.fze.setVisibility(0);
            this.fze.setText(aq.is(gVar.fzQ.videoDuration * 1000));
            if (gVar.fzQ.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), xa(String.format("%.1f", Float.valueOf(((float) gVar.fzQ.videoSize) / 1048576.0f))));
            }
            this.fzg.setText(format);
            this.fzf.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.fzQ != null) {
            this.fzp.stopPlay();
            this.fzp.setIsNeedRecoveryVideoPlayer(true);
            this.fzp.qb(true);
            this.fzp.pX(false);
            this.fzp.a(new c.InterfaceC0386c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pz() {
                    if (b.this.fzp.pB()) {
                        b.this.fze.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pA() {
                    if (b.this.fzp.pB()) {
                        b.this.fze.setVisibility(8);
                    }
                    if (b.this.fzv) {
                        b.this.fzp.stopPlay();
                    }
                }
            });
            this.fzp.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void boj() {
                    b.this.fzv = false;
                    b.this.fze.setVisibility(8);
                    b.this.wZ(b.this.bOG ? "1" : "2");
                    b.this.onClick(b.this.fzc);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bok() {
                    b.this.fze.setVisibility(8);
                    b.this.onClick(b.this.fzb);
                }
            });
            this.fzp.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void kr(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fzg.getText().toString());
                        b.this.fzp.cs(b.this.fzq.fzQ.videoUrl, b.this.fzq.threadId);
                        b.this.fze.setVisibility(8);
                        b.this.wZ("2");
                    } else {
                        b.this.fzf.setVisibility(0);
                    }
                    b.this.onClick(b.this.fzc);
                }
            });
            this.fzp.pT(false);
            this.fzs = new z();
            this.fzs.bWO = gVar.threadId;
            this.fzs.eFy = gVar.forumId;
            this.fzs.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fzt = new z();
            this.fzt.bWO = gVar.threadId;
            this.fzt.eFy = gVar.forumId;
            this.fzt.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fzy) {
                an anVar = new an("c12590");
                anVar.bT("tid", gVar.threadId);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bT("fid", gVar.forumId);
                anVar.P("obj_locate", i);
                anVar.P("obj_param2", 1);
                TiebaStatic.log(anVar);
                this.fzs.ixy = "auto_midpage";
                this.fzs.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.fzs.ixA = "1";
                this.fzt.ixy = "auto_midpage";
                this.fzt.mLocate = "auto_midpage";
                this.fzt.ixA = "1";
            } else {
                this.fzs.ixA = "frs_bavideotab";
                this.fzs.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fzt.ixA = "frs_bavideotab";
                this.fzt.mLocate = "frs_bavideotab";
            }
            if (gVar.fzQ != null) {
                this.fzs.ixC = gVar.fzQ.videoMd5;
                this.fzt.ixC = gVar.fzQ.videoMd5;
            }
            this.dnw.setVideoStatsData(this.fzs);
            this.fzp.getVideoView().setBusiness(this.dnw);
            this.fzp.bKY();
            this.fzp.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ks(boolean z) {
                    if (!b.this.fzp.pB()) {
                        b.this.fzd.setVisibility(0);
                    } else if (z) {
                        if (b.this.fzd.getVisibility() == 0) {
                            b.this.fzd.setVisibility(8);
                            b.this.fzd.startAnimation(b.this.fzw);
                        }
                    } else if (b.this.fzd.getVisibility() == 8) {
                        b.this.fzd.setVisibility(0);
                        b.this.fzd.startAnimation(b.this.afH);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bol() {
                    if (!b.this.fzp.pB()) {
                        b.this.fzd.setVisibility(0);
                    } else if (b.this.fzd.getVisibility() == 0) {
                        b.this.fzd.setVisibility(8);
                        b.this.fzd.startAnimation(b.this.fzw);
                    }
                }
            });
            this.fzp.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fzv = true;
                        b.this.fzu = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.rQ(i);
                        b.this.fzp.bxZ();
                    }
                }
            });
            this.fzp.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fzq != null && b.this.fzq.fzQ != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fzq.fzQ.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fzp.setThumbnail(gVar.fzQ.thumbnailUrl);
            this.fzp.setVideoUrl(gVar.fzQ.videoUrl, gVar.threadId);
            this.fzp.CU(gVar.title);
            this.fzp.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bom() {
                    b.this.fze.setVisibility(8);
                }
            });
            this.fzp.bxZ();
            this.fzp.show();
            if (gVar.autoPlay) {
                onClick(this.fzc);
                this.fzv = false;
                this.fzp.a(gVar.fzQ.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fzv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(String str) {
        if (this.fzq != null && this.fzq.fzQ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fzq.fzQ.videoMd5, "", str, this.fzt);
            }
        }
    }

    public boolean isPlaying() {
        return this.fzp.pB();
    }

    public void bof() {
        if (isPlaying()) {
            this.fzp.pausePlay();
        }
    }

    public boolean rR(int i) {
        return this.fzp.yT(i);
    }

    public void bog() {
        this.fzf.setVisibility(8);
        this.fzp.stopPlay();
        if (this.fzd != null) {
            this.fzd.setVisibility(0);
        }
        if (this.fze != null) {
            this.fze.setVisibility(0);
        }
    }

    public void boh() {
        if (this.fzp != null) {
            this.fzp.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        boh();
        if (this.fzr != null) {
            this.fzr.bos();
        }
    }

    public String xa(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.fzP != null) {
            this.XL.setText(TextUtils.isEmpty(gVar.fzP.userNickname) ? gVar.fzP.userName : gVar.fzP.userNickname);
            this.efG.startLoad(gVar.fzP.portrait, 12, false);
            this.efG.setShowV(gVar.fzP.isGod);
            this.efG.setIsBigV(gVar.fzP.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.fzP != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.fzP.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.fzP.userId)) {
                this.fzi.setVisibility(8);
            } else {
                this.fzi.setVisibility(0);
            }
            if (gVar.fzP.hasFocus) {
                am.j(this.fzi, R.color.cp_cont_d);
                this.fzi.setCompoundDrawables(null, null, null, null);
                this.fzi.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.j(this.fzi, R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.g(this.mContext, R.dimen.ds20), l.g(this.mContext, R.dimen.ds20));
            this.fzi.setCompoundDrawables(drawable, null, null, null);
            this.fzi.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.fzm.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.j(this.fzk, R.color.cp_cont_h);
            } else {
                this.fzm.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.j(this.fzk, R.color.cp_cont_f);
            }
            this.fzk.setText(aq.aO(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.j(this.fzj, R.color.cp_cont_f);
            this.fzl.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.fzj.setText(aq.aO(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fzp != null && this.fzc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fzu) {
                this.fzp.cdC();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fzc.getParent() != null) {
                    if (this.fzc.getParent() == frameLayout) {
                        frameLayout.removeView(this.fzc);
                    } else if (this.fzc.getParent() == this.fzb) {
                        this.fzb.removeView(this.fzc);
                    }
                }
                if (this.fzc.getParent() == null) {
                    frameLayout.addView(this.fzc);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fzc.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fzc.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fzc.getParent() != null) {
                    if (this.fzc.getParent() == frameLayout) {
                        frameLayout.removeView(this.fzc);
                    } else if (this.fzc.getParent() == this.fzb) {
                        this.fzb.removeView(this.fzc);
                    }
                }
                if (this.fzc.getParent() == null) {
                    this.fzb.addView(this.fzc, 0);
                    this.fzc.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fzp.bKY();
                    this.fzu = true;
                } else {
                    return;
                }
            }
            this.fzp.a(this.mPageContext, configuration);
            this.fze.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZo() != null) {
            view.setTag(this);
            aZo().a(view, this.fzq);
        }
        if (view == this.efG || view == this.XL) {
            boolean z = false;
            if (this.fzq != null && this.fzq.fzP != null && !TextUtils.isEmpty(this.fzq.fzP.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fzq.fzP.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.fzq.fzP.userId, 0L), z, this.fzq.fzP.isGod)));
            }
        } else if (view == this.fzn || view == this.fzd || view == getView()) {
            if (this.fzq != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fzq.threadId, null, null);
                if (!this.fzy) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fzh) {
            if (this.fzq != null && this.fzq.fzQ != null) {
                this.fzf.setVisibility(8);
                this.fzp.cdF();
                this.fzp.cs(this.fzq.fzQ.videoUrl, this.fzq.threadId);
                wZ("2");
            }
        } else if (view == this.fzi) {
            if (!this.fzq.fzP.hasFocus) {
                this.fzr.f(this.fzq);
            }
        } else if (view == this.fzo) {
            this.fzr.g(this.fzq);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kq(boolean z) {
        if (this.fzq != null && this.fzq.fzP != null) {
            this.fzq.fzP.hasFocus = z;
            c(this.fzq);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void boi() {
        if (this.fzq != null) {
            this.fzq.hasAgree = !this.fzq.hasAgree;
            if (this.fzq.hasAgree) {
                this.fzq.agreeNum++;
            } else {
                this.fzq.agreeNum--;
            }
            if (this.fzm != null) {
                this.fzm.startAnimation(getScaleAnimation());
            }
            d(this.fzq);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fzx == null) {
            this.fzx = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fzx.setDuration(200L);
        }
        return this.fzx;
    }
}
