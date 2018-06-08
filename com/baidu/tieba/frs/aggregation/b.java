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
import com.baidu.tieba.d;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    private ScaleAnimation axk;
    public TextView axo;
    public TextView bTp;
    private n btk;
    public HeadImageView ceW;
    private Animation dlA;
    private boolean dlB;
    private boolean dlC;
    public FrameLayout dlf;
    public FrameLayout dlg;
    public TextView dlh;
    public TextView dli;
    public FrameLayout dlj;
    public TextView dlk;
    public TextView dll;
    public TextView dlm;
    public TextView dln;
    public ImageView dlo;
    public ImageView dlp;
    public LinearLayout dlq;
    public LinearLayout dlr;
    public com.baidu.tieba.play.c dls;
    public g dlt;
    private h dlu;
    private y dlv;
    private y dlw;
    private boolean dlx;
    private boolean dly;
    private Animation dlz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dlx = true;
        this.dlC = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dlf = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dlg = (FrameLayout) view.findViewById(d.g.video_container);
        this.dls = new com.baidu.tieba.play.c(tbPageContext, this.dlg, false);
        this.dlh = (TextView) view.findViewById(d.g.title);
        this.dli = (TextView) view.findViewById(d.g.duration);
        this.dlj = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.dlk = (TextView) view.findViewById(d.g.mobile_network_text);
        this.dll = (TextView) view.findViewById(d.g.mobile_network_play);
        this.ceW = (HeadImageView) view.findViewById(d.g.user_icon);
        this.axo = (TextView) view.findViewById(d.g.user_name);
        this.bTp = (TextView) view.findViewById(d.g.attention);
        this.dlq = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.dlr = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.dlm = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.dln = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.dlo = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.dlp = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.dlq.setOnClickListener(this);
        this.dlr.setOnClickListener(this);
        this.dlh.setOnClickListener(this);
        this.ceW.setOnClickListener(this);
        this.axo.setOnClickListener(this);
        this.bTp.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dll.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dlf.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dlf.setLayoutParams(layoutParams);
        this.ceW.setIsRound(true);
        this.btk = new n(tbPageContext.getPageActivity());
        this.dlu = new h(this.mPageContext, this);
        this.dlz = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dlA = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), d.C0141d.cp_bg_line_d);
            if (this.dlt != null && this.dlt.dlS != null) {
                if (this.dlt.dlS.hasFocus) {
                    al.h(this.bTp, d.C0141d.cp_cont_d);
                    this.bTp.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.bTp, d.C0141d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
                    this.bTp.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dlt != null) {
                if (this.dlt.hasAgree) {
                    this.dlp.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_s));
                    al.h(this.dln, d.C0141d.cp_cont_h);
                } else {
                    this.dlp.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_n));
                    al.h(this.dln, d.C0141d.cp_cont_f);
                }
            }
            al.h(this.dlm, d.C0141d.cp_cont_f);
            this.dlo.setImageDrawable(al.getDrawable(d.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dlT != null) {
            this.dlt = gVar;
            this.dlB = this.dlt.autoPlay;
            this.dlh.setVisibility(0);
            this.dlh.setText(gVar.title);
            this.dli.setVisibility(0);
            this.dli.setText(ao.cX(gVar.dlT.videoDuration * 1000));
            if (gVar.dlT.videoSize == 0) {
                format = this.mPageContext.getString(d.k.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.k.video_mobile_network_tips), mz(String.format("%.1f", Float.valueOf(((float) gVar.dlT.videoSize) / 1048576.0f))));
            }
            this.dlk.setText(format);
            this.dlj.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dlT != null) {
            this.dls.stopPlay();
            this.dls.lu(true);
            this.dls.lx(true);
            this.dls.lv(false);
            this.dls.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.b
                public void auZ() {
                    if (b.this.dls.bkY()) {
                        b.this.dli.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void ava() {
                    if (b.this.dls.bkY()) {
                        b.this.dli.setVisibility(8);
                    }
                    if (b.this.dly) {
                        b.this.dls.stopPlay();
                    }
                }
            });
            this.dls.a(new c.k() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.k
                public void avb() {
                    b.this.dly = false;
                    b.this.dli.setVisibility(8);
                    b.this.my(b.this.dlB ? "1" : "2");
                    b.this.onClick(b.this.dlg);
                }

                @Override // com.baidu.tieba.play.c.k
                public void avc() {
                    b.this.dli.setVisibility(8);
                    b.this.onClick(b.this.dlf);
                }
            });
            this.dls.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.e
                public void fL(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dlk.getText().toString());
                        b.this.dls.bT(b.this.dlt.dlT.videoUrl, b.this.dlt.threadId);
                        b.this.dli.setVisibility(8);
                        b.this.my("2");
                    } else {
                        b.this.dlj.setVisibility(0);
                    }
                    b.this.onClick(b.this.dlg);
                }
            });
            this.dls.ls(false);
            this.dlv = new y();
            this.dlv.aVt = gVar.threadId;
            this.dlv.cBu = gVar.forumId;
            this.dlv.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dlw = new y();
            this.dlw.aVt = gVar.threadId;
            this.dlw.cBu = gVar.forumId;
            this.dlw.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dlC) {
                am amVar = new am("c12590");
                amVar.ah("tid", gVar.threadId);
                amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.r("obj_locate", i);
                amVar.r("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dlv.gdb = "auto_midpage";
                this.dlv.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dlv.gdd = "1";
                this.dlw.gdb = "auto_midpage";
                this.dlw.mLocate = "auto_midpage";
                this.dlw.gdd = "1";
            } else {
                this.dlv.gdd = "frs_bavideotab";
                this.dlv.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dlw.gdd = "frs_bavideotab";
                this.dlw.mLocate = "frs_bavideotab";
            }
            if (gVar.dlT != null) {
                this.dlv.gdf = gVar.dlT.videoMd5;
                this.dlw.gdf = gVar.dlT.videoMd5;
            }
            this.btk.setVideoStatsData(this.dlv);
            this.dls.getVideoView().setBusiness(this.btk);
            this.dls.aQu();
            this.dls.b(new c.InterfaceC0217c() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void fM(boolean z) {
                    if (!b.this.dls.bkY()) {
                        b.this.dlh.setVisibility(0);
                    } else if (z) {
                        if (b.this.dlh.getVisibility() == 0) {
                            b.this.dlh.setVisibility(8);
                            b.this.dlh.startAnimation(b.this.dlz);
                        }
                    } else if (b.this.dlh.getVisibility() == 8) {
                        b.this.dlh.setVisibility(0);
                        b.this.dlh.startAnimation(b.this.dlA);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void avd() {
                    if (!b.this.dls.bkY()) {
                        b.this.dlh.setVisibility(0);
                    } else if (b.this.dlh.getVisibility() == 0) {
                        b.this.dlh.setVisibility(8);
                        b.this.dlh.startAnimation(b.this.dlz);
                    }
                }
            });
            this.dls.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dly = true;
                        b.this.dlx = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.kt(i);
                        b.this.dls.aDt();
                    }
                }
            });
            this.dls.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.dlt != null && b.this.dlt.dlT != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.dlt.dlT.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dls.pq(gVar.dlT.thumbnailUrl);
            this.dls.bS(gVar.dlT.videoUrl, gVar.threadId);
            this.dls.sh(gVar.title);
            this.dls.a(new c.h() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.h
                public void ave() {
                    b.this.dli.setVisibility(8);
                }
            });
            this.dls.aDt();
            this.dls.show();
            if (gVar.autoPlay) {
                onClick(this.dlg);
                this.dly = false;
                this.dls.a(gVar.dlT.videoUrl, gVar.threadId, null, new Object[0]);
            }
            this.dly = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(String str) {
        if (this.dlt != null && this.dlt.dlT != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dlt.dlT.videoMd5, "", str, this.dlw);
            }
        }
    }

    public boolean isPlaying() {
        return this.dls.bkY();
    }

    public void auV() {
        if (isPlaying()) {
            this.dls.pausePlay();
        }
    }

    public boolean ku(int i) {
        return this.dls.ry(i);
    }

    public void auW() {
        this.dlj.setVisibility(8);
        this.dls.stopPlay();
        if (this.dlh != null) {
            this.dlh.setVisibility(0);
        }
        if (this.dli != null) {
            this.dli.setVisibility(0);
        }
    }

    public void auX() {
        if (this.dls != null) {
            this.dls.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        auX();
        if (this.dlu != null) {
            this.dlu.avk();
        }
    }

    public String mz(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.dlS != null) {
            this.axo.setText(TextUtils.isEmpty(gVar.dlS.userNickname) ? gVar.dlS.userName : gVar.dlS.userNickname);
            this.ceW.startLoad(gVar.dlS.portrait, 12, false);
            this.ceW.setShowV(gVar.dlS.isGod);
            this.ceW.setIsBigV(gVar.dlS.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dlS != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dlS.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dlS.userId)) {
                this.bTp.setVisibility(8);
            } else {
                this.bTp.setVisibility(0);
            }
            if (gVar.dlS.hasFocus) {
                al.h(this.bTp, d.C0141d.cp_cont_d);
                this.bTp.setCompoundDrawables(null, null, null, null);
                this.bTp.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                return;
            }
            al.h(this.bTp, d.C0141d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
            this.bTp.setCompoundDrawables(drawable, null, null, null);
            this.bTp.setText(this.mPageContext.getString(d.k.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dlp.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_s));
                al.h(this.dln, d.C0141d.cp_cont_h);
            } else {
                this.dlp.setImageDrawable(al.getDrawable(d.f.icon_home_card_like_n));
                al.h(this.dln, d.C0141d.cp_cont_f);
            }
            this.dln.setText(ao.E(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            al.h(this.dlm, d.C0141d.cp_cont_f);
            this.dlo.setImageDrawable(al.getDrawable(d.f.icon_home_card_comment));
            this.dlm.setText(ao.E(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dls != null && this.dlg != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dlx) {
                this.dls.bkX();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dlg.getParent() != null) {
                    if (this.dlg.getParent() == frameLayout) {
                        frameLayout.removeView(this.dlg);
                    } else if (this.dlg.getParent() == this.dlf) {
                        this.dlf.removeView(this.dlg);
                    }
                }
                if (this.dlg.getParent() == null) {
                    frameLayout.addView(this.dlg);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dlg.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dlg.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dlg.getParent() != null) {
                    if (this.dlg.getParent() == frameLayout) {
                        frameLayout.removeView(this.dlg);
                    } else if (this.dlg.getParent() == this.dlf) {
                        this.dlf.removeView(this.dlg);
                    }
                }
                if (this.dlg.getParent() == null) {
                    this.dlf.addView(this.dlg, 0);
                    this.dlg.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dls.aQu();
                    this.dlx = true;
                } else {
                    return;
                }
            }
            this.dls.a(this.mPageContext, configuration);
            this.dli.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiI() != null) {
            view.setTag(this);
            aiI().a(view, this.dlt);
        }
        if (view == this.ceW || view == this.axo) {
            boolean z = false;
            if (this.dlt != null && this.dlt.dlS != null && !TextUtils.isEmpty(this.dlt.dlS.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dlt.dlS.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dlt.dlS.userId, 0L), z, this.dlt.dlS.isGod)));
            }
        } else if (view == this.dlq || view == this.dlh || view == getView()) {
            if (this.dlt != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dlt.threadId, null, null);
                if (!this.dlC) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dll) {
            if (this.dlt != null && this.dlt.dlT != null) {
                this.dlj.setVisibility(8);
                this.dls.blb();
                this.dls.bT(this.dlt.dlT.videoUrl, this.dlt.threadId);
                my("2");
            }
        } else if (view == this.bTp) {
            if (!this.dlt.dlS.hasFocus) {
                this.dlu.f(this.dlt);
            }
        } else if (view == this.dlr) {
            this.dlu.g(this.dlt);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fK(boolean z) {
        if (this.dlt != null && this.dlt.dlS != null) {
            this.dlt.dlS.hasFocus = z;
            c(this.dlt);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void auY() {
        if (this.dlt != null) {
            this.dlt.hasAgree = !this.dlt.hasAgree;
            if (this.dlt.hasAgree) {
                this.dlt.agreeNum++;
            } else {
                this.dlt.agreeNum--;
            }
            if (this.dlp != null) {
                this.dlp.startAnimation(getScaleAnimation());
            }
            d(this.dlt);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axk == null) {
            this.axk = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axk.setDuration(200L);
        }
        return this.axk;
    }
}
