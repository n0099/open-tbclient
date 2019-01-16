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
    public g aFN;
    public TextView aKT;
    private boolean ayh;
    private n bPd;
    public HeadImageView cDT;
    private boolean dQA;
    private Animation dQB;
    private Animation dQC;
    private ScaleAnimation dQD;
    private boolean dQE;
    public FrameLayout dQh;
    public FrameLayout dQi;
    public TextView dQj;
    public TextView dQk;
    public FrameLayout dQl;
    public TextView dQm;
    public TextView dQn;
    public TextView dQo;
    public TextView dQp;
    public TextView dQq;
    public ImageView dQr;
    public ImageView dQs;
    public LinearLayout dQt;
    public LinearLayout dQu;
    public com.baidu.tieba.play.c dQv;
    private h dQw;
    private z dQx;
    private z dQy;
    private boolean dQz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dQz = true;
        this.dQE = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dQh = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dQi = (FrameLayout) view.findViewById(e.g.video_container);
        this.dQv = new com.baidu.tieba.play.c(tbPageContext, (View) this.dQi, false);
        this.dQj = (TextView) view.findViewById(e.g.title);
        this.dQk = (TextView) view.findViewById(e.g.duration);
        this.dQl = (FrameLayout) view.findViewById(e.g.mobile_network_container);
        this.dQm = (TextView) view.findViewById(e.g.mobile_network_text);
        this.dQn = (TextView) view.findViewById(e.g.mobile_network_play);
        this.cDT = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKT = (TextView) view.findViewById(e.g.user_name);
        this.dQo = (TextView) view.findViewById(e.g.attention);
        this.dQt = (LinearLayout) view.findViewById(e.g.thread_info_commont_container);
        this.dQu = (LinearLayout) view.findViewById(e.g.agree_view_container);
        this.dQp = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.dQq = (TextView) view.findViewById(e.g.thread_info_praise_num);
        this.dQr = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.dQs = (ImageView) view.findViewById(e.g.thread_info_praise_img);
        this.dQt.setOnClickListener(this);
        this.dQu.setOnClickListener(this);
        this.dQj.setOnClickListener(this);
        this.cDT.setOnClickListener(this);
        this.aKT.setOnClickListener(this);
        this.dQo.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dQn.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dQh.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dQh.setLayoutParams(layoutParams);
        this.cDT.setIsRound(true);
        this.bPd = new n(tbPageContext.getPageActivity());
        this.dQw = new h(this.mPageContext, this);
        this.dQB = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_200);
        this.dQC = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), e.d.cp_bg_line_d);
            if (this.aFN != null && this.aFN.dQV != null) {
                if (this.aFN.dQV.hasFocus) {
                    al.h(this.dQo, e.d.cp_cont_d);
                    this.dQo.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.dQo, e.d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
                    this.dQo.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.aFN != null) {
                if (this.aFN.hasAgree) {
                    this.dQs.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                    al.h(this.dQq, e.d.cp_cont_h);
                } else {
                    this.dQs.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                    al.h(this.dQq, e.d.cp_cont_f);
                }
            }
            al.h(this.dQp, e.d.cp_cont_f);
            this.dQr.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dQW != null) {
            this.aFN = gVar;
            this.ayh = this.aFN.autoPlay;
            this.dQj.setVisibility(0);
            this.dQj.setText(gVar.title);
            this.dQk.setVisibility(0);
            this.dQk.setText(ao.dV(gVar.dQW.videoDuration * 1000));
            if (gVar.dQW.videoSize == 0) {
                format = this.mPageContext.getString(e.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(e.j.video_mobile_network_tips), oA(String.format("%.1f", Float.valueOf(((float) gVar.dQW.videoSize) / 1048576.0f))));
            }
            this.dQm.setText(format);
            this.dQl.setVisibility(8);
            b(gVar, i, aVar);
            c(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dQW != null) {
            this.dQv.stopPlay();
            this.dQv.setIsNeedRecoveryVideoPlayer(true);
            this.dQv.mz(true);
            this.dQv.mv(false);
            this.dQv.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                    if (b.this.dQv.bsq()) {
                        b.this.dQk.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                    if (b.this.dQv.bsq()) {
                        b.this.dQk.setVisibility(8);
                    }
                    if (b.this.dQA) {
                        b.this.dQv.stopPlay();
                    }
                }
            });
            this.dQv.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void aEg() {
                    b.this.dQA = false;
                    b.this.dQk.setVisibility(8);
                    b.this.oz(b.this.ayh ? "1" : "2");
                    b.this.onClick(b.this.dQi);
                }

                @Override // com.baidu.tieba.play.c.l
                public void aEh() {
                    b.this.dQk.setVisibility(8);
                    b.this.onClick(b.this.dQh);
                }
            });
            this.dQv.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void gZ(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dQm.getText().toString());
                        b.this.dQv.ba(b.this.aFN.dQW.videoUrl, b.this.aFN.threadId);
                        b.this.dQk.setVisibility(8);
                        b.this.oz("2");
                    } else {
                        b.this.dQl.setVisibility(0);
                    }
                    b.this.onClick(b.this.dQi);
                }
            });
            this.dQv.ms(false);
            this.dQx = new z();
            this.dQx.bjm = gVar.threadId;
            this.dQx.dbr = gVar.forumId;
            this.dQx.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dQy = new z();
            this.dQy.bjm = gVar.threadId;
            this.dQy.dbr = gVar.forumId;
            this.dQy.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dQE) {
                am amVar = new am("c12590");
                amVar.aB("tid", gVar.threadId);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.y("obj_locate", i);
                amVar.y("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dQx.gII = "auto_midpage";
                this.dQx.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dQx.gIK = "1";
                this.dQy.gII = "auto_midpage";
                this.dQy.mLocate = "auto_midpage";
                this.dQy.gIK = "1";
            } else {
                this.dQx.gIK = "frs_bavideotab";
                this.dQx.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dQy.gIK = "frs_bavideotab";
                this.dQy.mLocate = "frs_bavideotab";
            }
            if (gVar.dQW != null) {
                this.dQx.gIM = gVar.dQW.videoMd5;
                this.dQy.gIM = gVar.dQW.videoMd5;
            }
            this.bPd.setVideoStatsData(this.dQx);
            this.dQv.getVideoView().setBusiness(this.bPd);
            this.dQv.bac();
            this.dQv.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ha(boolean z) {
                    if (!b.this.dQv.bsq()) {
                        b.this.dQj.setVisibility(0);
                    } else if (z) {
                        if (b.this.dQj.getVisibility() == 0) {
                            b.this.dQj.setVisibility(8);
                            b.this.dQj.startAnimation(b.this.dQB);
                        }
                    } else if (b.this.dQj.getVisibility() == 8) {
                        b.this.dQj.setVisibility(0);
                        b.this.dQj.startAnimation(b.this.dQC);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aEi() {
                    if (!b.this.dQv.bsq()) {
                        b.this.dQj.setVisibility(0);
                    } else if (b.this.dQj.getVisibility() == 0) {
                        b.this.dQj.setVisibility(8);
                        b.this.dQj.startAnimation(b.this.dQB);
                    }
                }
            });
            this.dQv.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dQA = true;
                        b.this.dQz = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.mH(i);
                        b.this.dQv.aNk();
                    }
                }
            });
            this.dQv.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.aFN != null && b.this.aFN.dQW != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.aFN.dQW.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dQv.setThumbnail(gVar.dQW.thumbnailUrl);
            this.dQv.setVideoUrl(gVar.dQW.videoUrl, gVar.threadId);
            this.dQv.uk(gVar.title);
            this.dQv.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void aEj() {
                    b.this.dQk.setVisibility(8);
                }
            });
            this.dQv.aNk();
            this.dQv.show();
            if (gVar.autoPlay) {
                onClick(this.dQi);
                this.dQA = false;
                this.dQv.a(gVar.dQW.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.dQA = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(String str) {
        if (this.aFN != null && this.aFN.dQW != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFN.dQW.videoMd5, "", str, this.dQy);
            }
        }
    }

    public boolean isPlaying() {
        return this.dQv.bsq();
    }

    public void aEc() {
        if (isPlaying()) {
            this.dQv.pausePlay();
        }
    }

    public boolean mI(int i) {
        return this.dQv.tC(i);
    }

    public void aEd() {
        this.dQl.setVisibility(8);
        this.dQv.stopPlay();
        if (this.dQj != null) {
            this.dQj.setVisibility(0);
        }
        if (this.dQk != null) {
            this.dQk.setVisibility(0);
        }
    }

    public void aEe() {
        if (this.dQv != null) {
            this.dQv.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aEe();
        if (this.dQw != null) {
            this.dQw.aEp();
        }
    }

    public String oA(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dQV != null) {
            this.aKT.setText(TextUtils.isEmpty(gVar.dQV.userNickname) ? gVar.dQV.userName : gVar.dQV.userNickname);
            this.cDT.startLoad(gVar.dQV.portrait, 12, false);
            this.cDT.setShowV(gVar.dQV.isGod);
            this.cDT.setIsBigV(gVar.dQV.isGod);
            d(gVar);
            e(gVar);
            f(gVar);
        }
    }

    public void d(g gVar) {
        if (gVar != null && gVar.dQV != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dQV.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dQV.userId)) {
                this.dQo.setVisibility(8);
            } else {
                this.dQo.setVisibility(0);
            }
            if (gVar.dQV.hasFocus) {
                al.h(this.dQo, e.d.cp_cont_d);
                this.dQo.setCompoundDrawables(null, null, null, null);
                this.dQo.setText(this.mPageContext.getString(e.j.relate_forum_is_followed));
                return;
            }
            al.h(this.dQo, e.d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
            this.dQo.setCompoundDrawables(drawable, null, null, null);
            this.dQo.setText(this.mPageContext.getString(e.j.attention));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dQs.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                al.h(this.dQq, e.d.cp_cont_h);
            } else {
                this.dQs.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                al.h(this.dQq, e.d.cp_cont_f);
            }
            this.dQq.setText(ao.X(gVar.agreeNum));
        }
    }

    public void f(g gVar) {
        if (gVar != null) {
            al.h(this.dQp, e.d.cp_cont_f);
            this.dQr.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
            this.dQp.setText(ao.X(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dQv != null && this.dQi != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dQz) {
                this.dQv.bsp();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dQi.getParent() != null) {
                    if (this.dQi.getParent() == frameLayout) {
                        frameLayout.removeView(this.dQi);
                    } else if (this.dQi.getParent() == this.dQh) {
                        this.dQh.removeView(this.dQi);
                    }
                }
                if (this.dQi.getParent() == null) {
                    frameLayout.addView(this.dQi);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dQi.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dQi.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dQi.getParent() != null) {
                    if (this.dQi.getParent() == frameLayout) {
                        frameLayout.removeView(this.dQi);
                    } else if (this.dQi.getParent() == this.dQh) {
                        this.dQh.removeView(this.dQi);
                    }
                }
                if (this.dQi.getParent() == null) {
                    this.dQh.addView(this.dQi, 0);
                    this.dQi.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dQv.bac();
                    this.dQz = true;
                } else {
                    return;
                }
            }
            this.dQv.a(this.mPageContext, configuration);
            this.dQk.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aqp() != null) {
            view.setTag(this);
            aqp().a(view, this.aFN);
        }
        if (view == this.cDT || view == this.aKT) {
            boolean z = false;
            if (this.aFN != null && this.aFN.dQV != null && !TextUtils.isEmpty(this.aFN.dQV.userId)) {
                if (TbadkCoreApplication.isLogin() && this.aFN.dQV.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFN.dQV.userId, 0L), z, this.aFN.dQV.isGod)));
            }
        } else if (view == this.dQt || view == this.dQj || view == getView()) {
            if (this.aFN != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFN.threadId, null, null);
                if (!this.dQE) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dQn) {
            if (this.aFN != null && this.aFN.dQW != null) {
                this.dQl.setVisibility(8);
                this.dQv.bst();
                this.dQv.ba(this.aFN.dQW.videoUrl, this.aFN.threadId);
                oz("2");
            }
        } else if (view == this.dQo) {
            if (!this.aFN.dQV.hasFocus) {
                this.dQw.g(this.aFN);
            }
        } else if (view == this.dQu) {
            this.dQw.h(this.aFN);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gY(boolean z) {
        if (this.aFN != null && this.aFN.dQV != null) {
            this.aFN.dQV.hasFocus = z;
            d(this.aFN);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aEf() {
        if (this.aFN != null) {
            this.aFN.hasAgree = !this.aFN.hasAgree;
            if (this.aFN.hasAgree) {
                this.aFN.agreeNum++;
            } else {
                this.aFN.agreeNum--;
            }
            if (this.dQs != null) {
                this.dQs.startAnimation(getScaleAnimation());
            }
            e(this.aFN);
        }
    }

    private Animation getScaleAnimation() {
        if (this.dQD == null) {
            this.dQD = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dQD.setDuration(200L);
        }
        return this.dQD;
    }
}
