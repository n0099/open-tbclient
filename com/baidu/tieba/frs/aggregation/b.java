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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    private ScaleAnimation axD;
    public TextView axL;
    private n bvr;
    public HeadImageView ciQ;
    public FrameLayout dqJ;
    public FrameLayout dqK;
    public TextView dqL;
    public TextView dqM;
    public FrameLayout dqN;
    public TextView dqO;
    public TextView dqP;
    public TextView dqQ;
    public TextView dqR;
    public TextView dqS;
    public ImageView dqT;
    public ImageView dqU;
    public LinearLayout dqV;
    public LinearLayout dqW;
    public com.baidu.tieba.play.c dqX;
    public g dqY;
    private h dqZ;
    private y dra;
    private y drb;
    private boolean drc;
    private boolean drd;
    private Animation dre;
    private Animation drf;
    private boolean drg;
    private boolean drh;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.drc = true;
        this.drh = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dqJ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dqK = (FrameLayout) view.findViewById(d.g.video_container);
        this.dqX = new com.baidu.tieba.play.c(tbPageContext, this.dqK, false);
        this.dqL = (TextView) view.findViewById(d.g.title);
        this.dqM = (TextView) view.findViewById(d.g.duration);
        this.dqN = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.dqO = (TextView) view.findViewById(d.g.mobile_network_text);
        this.dqP = (TextView) view.findViewById(d.g.mobile_network_play);
        this.ciQ = (HeadImageView) view.findViewById(d.g.user_icon);
        this.axL = (TextView) view.findViewById(d.g.user_name);
        this.dqQ = (TextView) view.findViewById(d.g.attention);
        this.dqV = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.dqW = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.dqR = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.dqS = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.dqT = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.dqU = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.dqV.setOnClickListener(this);
        this.dqW.setOnClickListener(this);
        this.dqL.setOnClickListener(this);
        this.ciQ.setOnClickListener(this);
        this.axL.setOnClickListener(this);
        this.dqQ.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dqP.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqJ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dqJ.setLayoutParams(layoutParams);
        this.ciQ.setIsRound(true);
        this.bvr = new n(tbPageContext.getPageActivity());
        this.dqZ = new h(this.mPageContext, this);
        this.dre = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.drf = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.j(getView(), d.C0140d.cp_bg_line_d);
            if (this.dqY != null && this.dqY.drx != null) {
                if (this.dqY.drx.hasFocus) {
                    am.h(this.dqQ, d.C0140d.cp_cont_d);
                    this.dqQ.setCompoundDrawables(null, null, null, null);
                } else {
                    am.h(this.dqQ, d.C0140d.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.f(this.mContext, d.e.ds20), l.f(this.mContext, d.e.ds20));
                    this.dqQ.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dqY != null) {
                if (this.dqY.hasAgree) {
                    this.dqU.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_s));
                    am.h(this.dqS, d.C0140d.cp_cont_h);
                } else {
                    this.dqU.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_n));
                    am.h(this.dqS, d.C0140d.cp_cont_f);
                }
            }
            am.h(this.dqR, d.C0140d.cp_cont_f);
            this.dqT.setImageDrawable(am.getDrawable(d.f.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.dry != null) {
            this.dqY = gVar;
            this.drg = this.dqY.autoPlay;
            this.dqL.setVisibility(0);
            this.dqL.setText(gVar.title);
            this.dqM.setVisibility(0);
            this.dqM.setText(ap.da(gVar.dry.videoDuration * 1000));
            if (gVar.dry.videoSize == 0) {
                format = this.mPageContext.getString(d.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.j.video_mobile_network_tips), my(String.format("%.1f", Float.valueOf(((float) gVar.dry.videoSize) / 1048576.0f))));
            }
            this.dqO.setText(format);
            this.dqN.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dry != null) {
            this.dqX.stopPlay();
            this.dqX.setIsNeedRecoveryVideoPlayer(true);
            this.dqX.ls(true);
            this.dqX.lq(false);
            this.dqX.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                    if (b.this.dqX.bjU()) {
                        b.this.dqM.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void awj() {
                    if (b.this.dqX.bjU()) {
                        b.this.dqM.setVisibility(8);
                    }
                    if (b.this.drd) {
                        b.this.dqX.stopPlay();
                    }
                }
            });
            this.dqX.a(new c.k() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.k
                public void awk() {
                    b.this.drd = false;
                    b.this.dqM.setVisibility(8);
                    b.this.mx(b.this.drg ? "1" : "2");
                    b.this.onClick(b.this.dqK);
                }

                @Override // com.baidu.tieba.play.c.k
                public void awl() {
                    b.this.dqM.setVisibility(8);
                    b.this.onClick(b.this.dqJ);
                }
            });
            this.dqX.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.e
                public void fT(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dqO.getText().toString());
                        b.this.dqX.bS(b.this.dqY.dry.videoUrl, b.this.dqY.threadId);
                        b.this.dqM.setVisibility(8);
                        b.this.mx("2");
                    } else {
                        b.this.dqN.setVisibility(0);
                    }
                    b.this.onClick(b.this.dqK);
                }
            });
            this.dqX.lo(false);
            this.dra = new y();
            this.dra.aWq = gVar.threadId;
            this.dra.cBU = gVar.forumId;
            this.dra.mUid = TbadkCoreApplication.getCurrentAccount();
            this.drb = new y();
            this.drb.aWq = gVar.threadId;
            this.drb.cBU = gVar.forumId;
            this.drb.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.drh) {
                an anVar = new an("c12590");
                anVar.af("tid", gVar.threadId);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                anVar.r("obj_locate", i);
                anVar.r("obj_param2", 1);
                TiebaStatic.log(anVar);
                this.dra.ghC = "auto_midpage";
                this.dra.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dra.ghE = "1";
                this.drb.ghC = "auto_midpage";
                this.drb.mLocate = "auto_midpage";
                this.drb.ghE = "1";
            } else {
                this.dra.ghE = "frs_bavideotab";
                this.dra.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.drb.ghE = "frs_bavideotab";
                this.drb.mLocate = "frs_bavideotab";
            }
            if (gVar.dry != null) {
                this.dra.ghG = gVar.dry.videoMd5;
                this.drb.ghG = gVar.dry.videoMd5;
            }
            this.bvr.setVideoStatsData(this.dra);
            this.dqX.getVideoView().setBusiness(this.bvr);
            this.dqX.aSc();
            this.dqX.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (!b.this.dqX.bjU()) {
                        b.this.dqL.setVisibility(0);
                    } else if (z) {
                        if (b.this.dqL.getVisibility() == 0) {
                            b.this.dqL.setVisibility(8);
                            b.this.dqL.startAnimation(b.this.dre);
                        }
                    } else if (b.this.dqL.getVisibility() == 8) {
                        b.this.dqL.setVisibility(0);
                        b.this.dqL.startAnimation(b.this.drf);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awm() {
                    if (!b.this.dqX.bjU()) {
                        b.this.dqL.setVisibility(0);
                    } else if (b.this.dqL.getVisibility() == 0) {
                        b.this.dqL.setVisibility(8);
                        b.this.dqL.startAnimation(b.this.dre);
                    }
                }
            });
            this.dqX.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.drd = true;
                        b.this.drc = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.kL(i);
                        b.this.dqX.aFd();
                    }
                }
            });
            this.dqX.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.dqY != null && b.this.dqY.dry != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.dqY.dry.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dqX.setThumbnail(gVar.dry.thumbnailUrl);
            this.dqX.setVideoUrl(gVar.dry.videoUrl, gVar.threadId);
            this.dqX.sa(gVar.title);
            this.dqX.a(new c.h() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.h
                public void awn() {
                    b.this.dqM.setVisibility(8);
                }
            });
            this.dqX.aFd();
            this.dqX.show();
            if (gVar.autoPlay) {
                onClick(this.dqK);
                this.drd = false;
                this.dqX.a(gVar.dry.videoUrl, gVar.threadId, (c.d) null, new Object[0]);
            }
            this.drd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(String str) {
        if (this.dqY != null && this.dqY.dry != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dqY.dry.videoMd5, "", str, this.drb);
            }
        }
    }

    public boolean isPlaying() {
        return this.dqX.bjU();
    }

    public void awe() {
        if (isPlaying()) {
            this.dqX.pausePlay();
        }
    }

    public boolean kM(int i) {
        return this.dqX.rE(i);
    }

    public void awf() {
        this.dqN.setVisibility(8);
        this.dqX.stopPlay();
        if (this.dqL != null) {
            this.dqL.setVisibility(0);
        }
        if (this.dqM != null) {
            this.dqM.setVisibility(0);
        }
    }

    public void awg() {
        if (this.dqX != null) {
            this.dqX.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awg();
        if (this.dqZ != null) {
            this.dqZ.aws();
        }
    }

    public String my(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.drx != null) {
            this.axL.setText(TextUtils.isEmpty(gVar.drx.userNickname) ? gVar.drx.userName : gVar.drx.userNickname);
            this.ciQ.startLoad(gVar.drx.portrait, 12, false);
            this.ciQ.setShowV(gVar.drx.isGod);
            this.ciQ.setIsBigV(gVar.drx.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.drx != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.drx.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.drx.userId)) {
                this.dqQ.setVisibility(8);
            } else {
                this.dqQ.setVisibility(0);
            }
            if (gVar.drx.hasFocus) {
                am.h(this.dqQ, d.C0140d.cp_cont_d);
                this.dqQ.setCompoundDrawables(null, null, null, null);
                this.dqQ.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                return;
            }
            am.h(this.dqQ, d.C0140d.cp_link_tip_a);
            Drawable drawable = am.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.f(this.mContext, d.e.ds20), l.f(this.mContext, d.e.ds20));
            this.dqQ.setCompoundDrawables(drawable, null, null, null);
            this.dqQ.setText(this.mPageContext.getString(d.j.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dqU.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_s));
                am.h(this.dqS, d.C0140d.cp_cont_h);
            } else {
                this.dqU.setImageDrawable(am.getDrawable(d.f.icon_home_card_like_n));
                am.h(this.dqS, d.C0140d.cp_cont_f);
            }
            this.dqS.setText(ap.H(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.h(this.dqR, d.C0140d.cp_cont_f);
            this.dqT.setImageDrawable(am.getDrawable(d.f.icon_home_card_comment));
            this.dqR.setText(ap.H(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dqX != null && this.dqK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.drc) {
                this.dqX.bjT();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dqK.getParent() != null) {
                    if (this.dqK.getParent() == frameLayout) {
                        frameLayout.removeView(this.dqK);
                    } else if (this.dqK.getParent() == this.dqJ) {
                        this.dqJ.removeView(this.dqK);
                    }
                }
                if (this.dqK.getParent() == null) {
                    frameLayout.addView(this.dqK);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dqK.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dqK.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dqK.getParent() != null) {
                    if (this.dqK.getParent() == frameLayout) {
                        frameLayout.removeView(this.dqK);
                    } else if (this.dqK.getParent() == this.dqJ) {
                        this.dqJ.removeView(this.dqK);
                    }
                }
                if (this.dqK.getParent() == null) {
                    this.dqJ.addView(this.dqK, 0);
                    this.dqK.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dqX.aSc();
                    this.drc = true;
                } else {
                    return;
                }
            }
            this.dqX.a(this.mPageContext, configuration);
            this.dqM.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiz() != null) {
            view.setTag(this);
            aiz().a(view, this.dqY);
        }
        if (view == this.ciQ || view == this.axL) {
            boolean z = false;
            if (this.dqY != null && this.dqY.drx != null && !TextUtils.isEmpty(this.dqY.drx.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dqY.drx.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dqY.drx.userId, 0L), z, this.dqY.drx.isGod)));
            }
        } else if (view == this.dqV || view == this.dqL || view == getView()) {
            if (this.dqY != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dqY.threadId, null, null);
                if (!this.drh) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dqP) {
            if (this.dqY != null && this.dqY.dry != null) {
                this.dqN.setVisibility(8);
                this.dqX.bjX();
                this.dqX.bS(this.dqY.dry.videoUrl, this.dqY.threadId);
                mx("2");
            }
        } else if (view == this.dqQ) {
            if (!this.dqY.drx.hasFocus) {
                this.dqZ.f(this.dqY);
            }
        } else if (view == this.dqW) {
            this.dqZ.g(this.dqY);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fS(boolean z) {
        if (this.dqY != null && this.dqY.drx != null) {
            this.dqY.drx.hasFocus = z;
            c(this.dqY);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void awh() {
        if (this.dqY != null) {
            this.dqY.hasAgree = !this.dqY.hasAgree;
            if (this.dqY.hasAgree) {
                this.dqY.agreeNum++;
            } else {
                this.dqY.agreeNum--;
            }
            if (this.dqU != null) {
                this.dqU.startAnimation(getScaleAnimation());
            }
            d(this.dqY);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axD == null) {
            this.axD = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axD.setDuration(200L);
        }
        return this.axD;
    }
}
