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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    private ScaleAnimation apc;
    public TextView apg;
    public TextView bLo;
    public HeadImageView bWT;
    private n blg;
    public FrameLayout dbP;
    public FrameLayout dbQ;
    public TextView dbR;
    public TextView dbS;
    public FrameLayout dbT;
    public TextView dbU;
    public TextView dbV;
    public TextView dbW;
    public TextView dbX;
    public ImageView dbY;
    public ImageView dbZ;
    public LinearLayout dca;
    public LinearLayout dcb;
    public com.baidu.tieba.play.c dcc;
    public g dcd;
    private h dce;
    private y dcf;
    private y dcg;
    private boolean dch;
    private boolean dci;
    private Animation dcj;
    private Animation dck;
    private boolean dcl;
    private boolean dcm;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dch = true;
        this.dcm = z;
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.dbP = (FrameLayout) view2.findViewById(d.g.video_agg_container);
        this.dbQ = (FrameLayout) view2.findViewById(d.g.video_container);
        this.dcc = new com.baidu.tieba.play.c(tbPageContext, this.dbQ, false);
        this.dbR = (TextView) view2.findViewById(d.g.title);
        this.dbS = (TextView) view2.findViewById(d.g.duration);
        this.dbT = (FrameLayout) view2.findViewById(d.g.mobile_network_container);
        this.dbU = (TextView) view2.findViewById(d.g.mobile_network_text);
        this.dbV = (TextView) view2.findViewById(d.g.mobile_network_play);
        this.bWT = (HeadImageView) view2.findViewById(d.g.user_icon);
        this.apg = (TextView) view2.findViewById(d.g.user_name);
        this.bLo = (TextView) view2.findViewById(d.g.attention);
        this.dca = (LinearLayout) view2.findViewById(d.g.thread_info_commont_container);
        this.dcb = (LinearLayout) view2.findViewById(d.g.agree_view_container);
        this.dbW = (TextView) view2.findViewById(d.g.thread_info_commont_num);
        this.dbX = (TextView) view2.findViewById(d.g.thread_info_praise_num);
        this.dbY = (ImageView) view2.findViewById(d.g.thread_info_commont_img);
        this.dbZ = (ImageView) view2.findViewById(d.g.thread_info_praise_img);
        this.dca.setOnClickListener(this);
        this.dcb.setOnClickListener(this);
        this.dbR.setOnClickListener(this);
        this.bWT.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.bLo.setOnClickListener(this);
        view2.setOnClickListener(this);
        this.dbV.setOnClickListener(this);
        this.mWidth = l.af(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dbP.setLayoutParams(layoutParams);
        this.bWT.setIsRound(true);
        this.blg = new n(tbPageContext.getPageActivity());
        this.dce = new h(this.mPageContext, this);
        this.dcj = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dck = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().u(getView());
            ak.j(getView(), d.C0126d.cp_bg_line_d);
            if (this.dcd != null && this.dcd.dcD != null) {
                if (this.dcd.dcD.hasFocus) {
                    ak.h(this.bLo, d.C0126d.cp_cont_d);
                    this.bLo.setCompoundDrawables(null, null, null, null);
                } else {
                    ak.h(this.bLo, d.C0126d.cp_link_tip_a);
                    Drawable drawable = ak.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
                    this.bLo.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dcd != null) {
                if (this.dcd.hasAgree) {
                    this.dbZ.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_s));
                    ak.h(this.dbX, d.C0126d.cp_cont_h);
                } else {
                    this.dbZ.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_n));
                    ak.h(this.dbX, d.C0126d.cp_cont_f);
                }
            }
            ak.h(this.dbW, d.C0126d.cp_cont_f);
            this.dbY.setImageDrawable(ak.getDrawable(d.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dcE != null) {
            this.dcd = gVar;
            this.dcl = this.dcd.autoPlay;
            this.dbR.setVisibility(0);
            this.dbR.setText(gVar.title);
            this.dbS.setVisibility(0);
            this.dbS.setText(an.cV(gVar.dcE.videoDuration * 1000));
            if (gVar.dcE.videoSize == 0) {
                format = this.mPageContext.getString(d.k.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.k.video_mobile_network_tips), lS(String.format("%.1f", Float.valueOf(((float) gVar.dcE.videoSize) / 1048576.0f))));
            }
            this.dbU.setText(format);
            this.dbT.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dcE != null) {
            this.dcc.stopPlay();
            this.dcc.lo(true);
            this.dcc.lr(true);
            this.dcc.lp(false);
            this.dcc.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.b
                public void aqU() {
                    if (b.this.dcc.bga()) {
                        b.this.dbS.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    if (b.this.dcc.bga()) {
                        b.this.dbS.setVisibility(8);
                    }
                    if (b.this.dci) {
                        b.this.dcc.stopPlay();
                    }
                }
            });
            this.dcc.a(new c.k() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.k
                public void aqW() {
                    b.this.dci = false;
                    b.this.dbS.setVisibility(8);
                    b.this.lR(b.this.dcl ? "1" : "2");
                    b.this.onClick(b.this.dbQ);
                }

                @Override // com.baidu.tieba.play.c.k
                public void aqX() {
                    b.this.dbS.setVisibility(8);
                    b.this.onClick(b.this.dbP);
                }
            });
            this.dcc.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.e
                public void fG(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dbU.getText().toString());
                        b.this.dcc.bL(b.this.dcd.dcE.videoUrl, b.this.dcd.threadId);
                        b.this.dbS.setVisibility(8);
                        b.this.lR("2");
                    } else {
                        b.this.dbT.setVisibility(0);
                    }
                    b.this.onClick(b.this.dbQ);
                }
            });
            this.dcc.lm(false);
            this.dcf = new y();
            this.dcf.aNv = gVar.threadId;
            this.dcf.csP = gVar.forumId;
            this.dcf.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dcg = new y();
            this.dcg.aNv = gVar.threadId;
            this.dcg.csP = gVar.forumId;
            this.dcg.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dcm) {
                al alVar = new al("c12590");
                alVar.ac("tid", gVar.threadId);
                alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                alVar.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                alVar.r("obj_locate", i);
                alVar.r("obj_param2", 1);
                TiebaStatic.log(alVar);
                this.dcf.fRP = "auto_midpage";
                this.dcf.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dcf.fRR = "1";
                this.dcg.fRP = "auto_midpage";
                this.dcg.mLocate = "auto_midpage";
                this.dcg.fRR = "1";
            } else {
                this.dcf.fRR = "frs_bavideotab";
                this.dcf.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dcg.fRR = "frs_bavideotab";
                this.dcg.mLocate = "frs_bavideotab";
            }
            if (gVar.dcE != null) {
                this.dcf.fRT = gVar.dcE.videoMd5;
                this.dcg.fRT = gVar.dcE.videoMd5;
            }
            this.blg.setVideoStatsData(this.dcf);
            this.dcc.getVideoView().setBusiness(this.blg);
            this.dcc.aLx();
            this.dcc.b(new c.InterfaceC0201c() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fH(boolean z) {
                    if (!b.this.dcc.bga()) {
                        b.this.dbR.setVisibility(0);
                    } else if (z) {
                        if (b.this.dbR.getVisibility() == 0) {
                            b.this.dbR.setVisibility(8);
                            b.this.dbR.startAnimation(b.this.dcj);
                        }
                    } else if (b.this.dbR.getVisibility() == 8) {
                        b.this.dbR.setVisibility(0);
                        b.this.dbR.startAnimation(b.this.dck);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqY() {
                    if (!b.this.dcc.bga()) {
                        b.this.dbR.setVisibility(0);
                    } else if (b.this.dbR.getVisibility() == 0) {
                        b.this.dbR.setVisibility(8);
                        b.this.dbR.startAnimation(b.this.dcj);
                    }
                }
            });
            this.dcc.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dci = true;
                        b.this.dch = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.ko(i);
                        b.this.dcc.ayy();
                    }
                }
            });
            this.dcc.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.dcd != null && b.this.dcd.dcE != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.dcd.dcE.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dcc.oC(gVar.dcE.thumbnailUrl);
            this.dcc.bK(gVar.dcE.videoUrl, gVar.threadId);
            this.dcc.rq(gVar.title);
            this.dcc.a(new c.h() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.h
                public void aqZ() {
                    b.this.dbS.setVisibility(8);
                }
            });
            this.dcc.ayy();
            this.dcc.show();
            if (gVar.autoPlay) {
                onClick(this.dbQ);
                this.dci = false;
                this.dcc.a(gVar.dcE.videoUrl, gVar.threadId, null, new Object[0]);
            }
            this.dci = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(String str) {
        if (this.dcd != null && this.dcd.dcE != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dcd.dcE.videoMd5, "", str, this.dcg);
            }
        }
    }

    public boolean isPlaying() {
        return this.dcc.bga();
    }

    public void aqQ() {
        if (isPlaying()) {
            this.dcc.pausePlay();
        }
    }

    public boolean kp(int i) {
        return this.dcc.rm(i);
    }

    public void aqR() {
        this.dbT.setVisibility(8);
        this.dcc.stopPlay();
        if (this.dbR != null) {
            this.dbR.setVisibility(0);
        }
        if (this.dbS != null) {
            this.dbS.setVisibility(0);
        }
    }

    public void aqS() {
        if (this.dcc != null) {
            this.dcc.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aqS();
        if (this.dce != null) {
            this.dce.arf();
        }
    }

    public String lS(String str) {
        if (str.indexOf(com.baidu.ar.util.Constants.DOT) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.dcD != null) {
            this.apg.setText(TextUtils.isEmpty(gVar.dcD.userNickname) ? gVar.dcD.userName : gVar.dcD.userNickname);
            this.bWT.startLoad(gVar.dcD.portrait, 12, false);
            this.bWT.setShowV(gVar.dcD.isGod);
            this.bWT.setIsBigV(gVar.dcD.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dcD != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dcD.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dcD.userId)) {
                this.bLo.setVisibility(8);
            } else {
                this.bLo.setVisibility(0);
            }
            if (gVar.dcD.hasFocus) {
                ak.h(this.bLo, d.C0126d.cp_cont_d);
                this.bLo.setCompoundDrawables(null, null, null, null);
                this.bLo.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                return;
            }
            ak.h(this.bLo, d.C0126d.cp_link_tip_a);
            Drawable drawable = ak.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.e(this.mContext, d.e.ds20), l.e(this.mContext, d.e.ds20));
            this.bLo.setCompoundDrawables(drawable, null, null, null);
            this.bLo.setText(this.mPageContext.getString(d.k.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dbZ.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_s));
                ak.h(this.dbX, d.C0126d.cp_cont_h);
            } else {
                this.dbZ.setImageDrawable(ak.getDrawable(d.f.icon_home_card_like_n));
                ak.h(this.dbX, d.C0126d.cp_cont_f);
            }
            this.dbX.setText(an.B(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ak.h(this.dbW, d.C0126d.cp_cont_f);
            this.dbY.setImageDrawable(ak.getDrawable(d.f.icon_home_card_comment));
            this.dbW.setText(an.B(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dcc != null && this.dbQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dch) {
                this.dcc.bfZ();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dbQ.getParent() != null) {
                    if (this.dbQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.dbQ);
                    } else if (this.dbQ.getParent() == this.dbP) {
                        this.dbP.removeView(this.dbQ);
                    }
                }
                if (this.dbQ.getParent() == null) {
                    frameLayout.addView(this.dbQ);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dbQ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dbQ.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dbQ.getParent() != null) {
                    if (this.dbQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.dbQ);
                    } else if (this.dbQ.getParent() == this.dbP) {
                        this.dbP.removeView(this.dbQ);
                    }
                }
                if (this.dbQ.getParent() == null) {
                    this.dbP.addView(this.dbQ, 0);
                    this.dbQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dcc.aLx();
                    this.dch = true;
                } else {
                    return;
                }
            }
            this.dcc.a(this.mPageContext, configuration);
            this.dbS.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            view2.setTag(this);
            aeZ().a(view2, this.dcd);
        }
        if (view2 == this.bWT || view2 == this.apg) {
            boolean z = false;
            if (this.dcd != null && this.dcd.dcD != null && !TextUtils.isEmpty(this.dcd.dcD.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dcd.dcD.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dcd.dcD.userId, 0L), z, this.dcd.dcD.isGod)));
            }
        } else if (view2 == this.dca || view2 == this.dbR || view2 == getView()) {
            if (this.dcd != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dcd.threadId, null, null);
                if (!this.dcm) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view2 == this.dbV) {
            if (this.dcd != null && this.dcd.dcE != null) {
                this.dbT.setVisibility(8);
                this.dcc.bgd();
                this.dcc.bL(this.dcd.dcE.videoUrl, this.dcd.threadId);
                lR("2");
            }
        } else if (view2 == this.bLo) {
            if (!this.dcd.dcD.hasFocus) {
                this.dce.f(this.dcd);
            }
        } else if (view2 == this.dcb) {
            this.dce.g(this.dcd);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fF(boolean z) {
        if (this.dcd != null && this.dcd.dcD != null) {
            this.dcd.dcD.hasFocus = z;
            c(this.dcd);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aqT() {
        if (this.dcd != null) {
            this.dcd.hasAgree = !this.dcd.hasAgree;
            if (this.dcd.hasAgree) {
                this.dcd.agreeNum++;
            } else {
                this.dcd.agreeNum--;
            }
            if (this.dbZ != null) {
                this.dbZ.startAnimation(getScaleAnimation());
            }
            d(this.dcd);
        }
    }

    private Animation getScaleAnimation() {
        if (this.apc == null) {
            this.apc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.apc.setDuration(200L);
        }
        return this.apc;
    }
}
