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
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public g aFO;
    public TextView aKU;
    private boolean ayi;
    private n bPe;
    public HeadImageView cDU;
    private boolean dQA;
    private boolean dQB;
    private Animation dQC;
    private Animation dQD;
    private ScaleAnimation dQE;
    private boolean dQF;
    public FrameLayout dQi;
    public FrameLayout dQj;
    public TextView dQk;
    public TextView dQl;
    public FrameLayout dQm;
    public TextView dQn;
    public TextView dQo;
    public TextView dQp;
    public TextView dQq;
    public TextView dQr;
    public ImageView dQs;
    public ImageView dQt;
    public LinearLayout dQu;
    public LinearLayout dQv;
    public com.baidu.tieba.play.c dQw;
    private h dQx;
    private z dQy;
    private z dQz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dQA = true;
        this.dQF = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dQi = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dQj = (FrameLayout) view.findViewById(e.g.video_container);
        this.dQw = new com.baidu.tieba.play.c(tbPageContext, (View) this.dQj, false);
        this.dQk = (TextView) view.findViewById(e.g.title);
        this.dQl = (TextView) view.findViewById(e.g.duration);
        this.dQm = (FrameLayout) view.findViewById(e.g.mobile_network_container);
        this.dQn = (TextView) view.findViewById(e.g.mobile_network_text);
        this.dQo = (TextView) view.findViewById(e.g.mobile_network_play);
        this.cDU = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKU = (TextView) view.findViewById(e.g.user_name);
        this.dQp = (TextView) view.findViewById(e.g.attention);
        this.dQu = (LinearLayout) view.findViewById(e.g.thread_info_commont_container);
        this.dQv = (LinearLayout) view.findViewById(e.g.agree_view_container);
        this.dQq = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.dQr = (TextView) view.findViewById(e.g.thread_info_praise_num);
        this.dQs = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.dQt = (ImageView) view.findViewById(e.g.thread_info_praise_img);
        this.dQu.setOnClickListener(this);
        this.dQv.setOnClickListener(this);
        this.dQk.setOnClickListener(this);
        this.cDU.setOnClickListener(this);
        this.aKU.setOnClickListener(this);
        this.dQp.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dQo.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dQi.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dQi.setLayoutParams(layoutParams);
        this.cDU.setIsRound(true);
        this.bPe = new n(tbPageContext.getPageActivity());
        this.dQx = new h(this.mPageContext, this);
        this.dQC = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_200);
        this.dQD = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), e.d.cp_bg_line_d);
            if (this.aFO != null && this.aFO.dQW != null) {
                if (this.aFO.dQW.hasFocus) {
                    al.h(this.dQp, e.d.cp_cont_d);
                    this.dQp.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.dQp, e.d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
                    this.dQp.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.aFO != null) {
                if (this.aFO.hasAgree) {
                    this.dQt.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                    al.h(this.dQr, e.d.cp_cont_h);
                } else {
                    this.dQt.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                    al.h(this.dQr, e.d.cp_cont_f);
                }
            }
            al.h(this.dQq, e.d.cp_cont_f);
            this.dQs.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dQX != null) {
            this.aFO = gVar;
            this.ayi = this.aFO.autoPlay;
            this.dQk.setVisibility(0);
            this.dQk.setText(gVar.title);
            this.dQl.setVisibility(0);
            this.dQl.setText(ao.dV(gVar.dQX.videoDuration * 1000));
            if (gVar.dQX.videoSize == 0) {
                format = this.mPageContext.getString(e.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(e.j.video_mobile_network_tips), oA(String.format("%.1f", Float.valueOf(((float) gVar.dQX.videoSize) / 1048576.0f))));
            }
            this.dQn.setText(format);
            this.dQm.setVisibility(8);
            b(gVar, i, aVar);
            c(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dQX != null) {
            this.dQw.stopPlay();
            this.dQw.setIsNeedRecoveryVideoPlayer(true);
            this.dQw.mz(true);
            this.dQw.mv(false);
            this.dQw.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                    if (b.this.dQw.bsq()) {
                        b.this.dQl.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                    if (b.this.dQw.bsq()) {
                        b.this.dQl.setVisibility(8);
                    }
                    if (b.this.dQB) {
                        b.this.dQw.stopPlay();
                    }
                }
            });
            this.dQw.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void aEg() {
                    b.this.dQB = false;
                    b.this.dQl.setVisibility(8);
                    b.this.oz(b.this.ayi ? "1" : "2");
                    b.this.onClick(b.this.dQj);
                }

                @Override // com.baidu.tieba.play.c.l
                public void aEh() {
                    b.this.dQl.setVisibility(8);
                    b.this.onClick(b.this.dQi);
                }
            });
            this.dQw.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void gZ(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dQn.getText().toString());
                        b.this.dQw.ba(b.this.aFO.dQX.videoUrl, b.this.aFO.threadId);
                        b.this.dQl.setVisibility(8);
                        b.this.oz("2");
                    } else {
                        b.this.dQm.setVisibility(0);
                    }
                    b.this.onClick(b.this.dQj);
                }
            });
            this.dQw.ms(false);
            this.dQy = new z();
            this.dQy.bjn = gVar.threadId;
            this.dQy.dbs = gVar.forumId;
            this.dQy.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dQz = new z();
            this.dQz.bjn = gVar.threadId;
            this.dQz.dbs = gVar.forumId;
            this.dQz.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dQF) {
                am amVar = new am("c12590");
                amVar.aB("tid", gVar.threadId);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.y("obj_locate", i);
                amVar.y("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dQy.gIJ = "auto_midpage";
                this.dQy.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dQy.gIL = "1";
                this.dQz.gIJ = "auto_midpage";
                this.dQz.mLocate = "auto_midpage";
                this.dQz.gIL = "1";
            } else {
                this.dQy.gIL = "frs_bavideotab";
                this.dQy.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dQz.gIL = "frs_bavideotab";
                this.dQz.mLocate = "frs_bavideotab";
            }
            if (gVar.dQX != null) {
                this.dQy.gIN = gVar.dQX.videoMd5;
                this.dQz.gIN = gVar.dQX.videoMd5;
            }
            this.bPe.setVideoStatsData(this.dQy);
            this.dQw.getVideoView().setBusiness(this.bPe);
            this.dQw.bac();
            this.dQw.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ha(boolean z) {
                    if (!b.this.dQw.bsq()) {
                        b.this.dQk.setVisibility(0);
                    } else if (z) {
                        if (b.this.dQk.getVisibility() == 0) {
                            b.this.dQk.setVisibility(8);
                            b.this.dQk.startAnimation(b.this.dQC);
                        }
                    } else if (b.this.dQk.getVisibility() == 8) {
                        b.this.dQk.setVisibility(0);
                        b.this.dQk.startAnimation(b.this.dQD);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aEi() {
                    if (!b.this.dQw.bsq()) {
                        b.this.dQk.setVisibility(0);
                    } else if (b.this.dQk.getVisibility() == 0) {
                        b.this.dQk.setVisibility(8);
                        b.this.dQk.startAnimation(b.this.dQC);
                    }
                }
            });
            this.dQw.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dQB = true;
                        b.this.dQA = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.mH(i);
                        b.this.dQw.aNk();
                    }
                }
            });
            this.dQw.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.aFO != null && b.this.aFO.dQX != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.aFO.dQX.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dQw.setThumbnail(gVar.dQX.thumbnailUrl);
            this.dQw.setVideoUrl(gVar.dQX.videoUrl, gVar.threadId);
            this.dQw.uk(gVar.title);
            this.dQw.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void aEj() {
                    b.this.dQl.setVisibility(8);
                }
            });
            this.dQw.aNk();
            this.dQw.show();
            if (gVar.autoPlay) {
                onClick(this.dQj);
                this.dQB = false;
                this.dQw.a(gVar.dQX.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.dQB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(String str) {
        if (this.aFO != null && this.aFO.dQX != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFO.dQX.videoMd5, "", str, this.dQz);
            }
        }
    }

    public boolean isPlaying() {
        return this.dQw.bsq();
    }

    public void aEc() {
        if (isPlaying()) {
            this.dQw.pausePlay();
        }
    }

    public boolean mI(int i) {
        return this.dQw.tC(i);
    }

    public void aEd() {
        this.dQm.setVisibility(8);
        this.dQw.stopPlay();
        if (this.dQk != null) {
            this.dQk.setVisibility(0);
        }
        if (this.dQl != null) {
            this.dQl.setVisibility(0);
        }
    }

    public void aEe() {
        if (this.dQw != null) {
            this.dQw.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aEe();
        if (this.dQx != null) {
            this.dQx.aEp();
        }
    }

    public String oA(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dQW != null) {
            this.aKU.setText(TextUtils.isEmpty(gVar.dQW.userNickname) ? gVar.dQW.userName : gVar.dQW.userNickname);
            this.cDU.startLoad(gVar.dQW.portrait, 12, false);
            this.cDU.setShowV(gVar.dQW.isGod);
            this.cDU.setIsBigV(gVar.dQW.isGod);
            d(gVar);
            e(gVar);
            f(gVar);
        }
    }

    public void d(g gVar) {
        if (gVar != null && gVar.dQW != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dQW.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dQW.userId)) {
                this.dQp.setVisibility(8);
            } else {
                this.dQp.setVisibility(0);
            }
            if (gVar.dQW.hasFocus) {
                al.h(this.dQp, e.d.cp_cont_d);
                this.dQp.setCompoundDrawables(null, null, null, null);
                this.dQp.setText(this.mPageContext.getString(e.j.relate_forum_is_followed));
                return;
            }
            al.h(this.dQp, e.d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
            this.dQp.setCompoundDrawables(drawable, null, null, null);
            this.dQp.setText(this.mPageContext.getString(e.j.attention));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dQt.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                al.h(this.dQr, e.d.cp_cont_h);
            } else {
                this.dQt.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                al.h(this.dQr, e.d.cp_cont_f);
            }
            this.dQr.setText(ao.X(gVar.agreeNum));
        }
    }

    public void f(g gVar) {
        if (gVar != null) {
            al.h(this.dQq, e.d.cp_cont_f);
            this.dQs.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
            this.dQq.setText(ao.X(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dQw != null && this.dQj != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dQA) {
                this.dQw.bsp();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dQj.getParent() != null) {
                    if (this.dQj.getParent() == frameLayout) {
                        frameLayout.removeView(this.dQj);
                    } else if (this.dQj.getParent() == this.dQi) {
                        this.dQi.removeView(this.dQj);
                    }
                }
                if (this.dQj.getParent() == null) {
                    frameLayout.addView(this.dQj);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dQj.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dQj.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dQj.getParent() != null) {
                    if (this.dQj.getParent() == frameLayout) {
                        frameLayout.removeView(this.dQj);
                    } else if (this.dQj.getParent() == this.dQi) {
                        this.dQi.removeView(this.dQj);
                    }
                }
                if (this.dQj.getParent() == null) {
                    this.dQi.addView(this.dQj, 0);
                    this.dQj.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dQw.bac();
                    this.dQA = true;
                } else {
                    return;
                }
            }
            this.dQw.a(this.mPageContext, configuration);
            this.dQl.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aqp() != null) {
            view.setTag(this);
            aqp().a(view, this.aFO);
        }
        if (view == this.cDU || view == this.aKU) {
            boolean z = false;
            if (this.aFO != null && this.aFO.dQW != null && !TextUtils.isEmpty(this.aFO.dQW.userId)) {
                if (TbadkCoreApplication.isLogin() && this.aFO.dQW.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFO.dQW.userId, 0L), z, this.aFO.dQW.isGod)));
            }
        } else if (view == this.dQu || view == this.dQk || view == getView()) {
            if (this.aFO != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFO.threadId, null, null);
                if (!this.dQF) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dQo) {
            if (this.aFO != null && this.aFO.dQX != null) {
                this.dQm.setVisibility(8);
                this.dQw.bst();
                this.dQw.ba(this.aFO.dQX.videoUrl, this.aFO.threadId);
                oz("2");
            }
        } else if (view == this.dQp) {
            if (!this.aFO.dQW.hasFocus) {
                this.dQx.g(this.aFO);
            }
        } else if (view == this.dQv) {
            this.dQx.h(this.aFO);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gY(boolean z) {
        if (this.aFO != null && this.aFO.dQW != null) {
            this.aFO.dQW.hasFocus = z;
            d(this.aFO);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aEf() {
        if (this.aFO != null) {
            this.aFO.hasAgree = !this.aFO.hasAgree;
            if (this.aFO.hasAgree) {
                this.aFO.agreeNum++;
            } else {
                this.aFO.agreeNum--;
            }
            if (this.dQt != null) {
                this.dQt.startAnimation(getScaleAnimation());
            }
            e(this.aFO);
        }
    }

    private Animation getScaleAnimation() {
        if (this.dQE == null) {
            this.dQE = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dQE.setDuration(200L);
        }
        return this.dQE;
    }
}
