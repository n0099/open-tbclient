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
import com.baidu.tieba.f;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    private boolean alU;
    private ScaleAnimation axA;
    public TextView axI;
    private n bvt;
    public HeadImageView ciN;
    public FrameLayout dqH;
    public FrameLayout dqI;
    public TextView dqJ;
    public TextView dqK;
    public FrameLayout dqL;
    public TextView dqM;
    public TextView dqN;
    public TextView dqO;
    public TextView dqP;
    public TextView dqQ;
    public ImageView dqR;
    public ImageView dqS;
    public LinearLayout dqT;
    public LinearLayout dqU;
    public com.baidu.tieba.play.c dqV;
    public g dqW;
    private h dqX;
    private y dqY;
    private y dqZ;
    private boolean dra;
    private boolean drb;
    private Animation drc;
    private Animation drd;
    private boolean dre;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dra = true;
        this.dre = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dqH = (FrameLayout) view.findViewById(f.g.video_agg_container);
        this.dqI = (FrameLayout) view.findViewById(f.g.video_container);
        this.dqV = new com.baidu.tieba.play.c(tbPageContext, this.dqI, false);
        this.dqJ = (TextView) view.findViewById(f.g.title);
        this.dqK = (TextView) view.findViewById(f.g.duration);
        this.dqL = (FrameLayout) view.findViewById(f.g.mobile_network_container);
        this.dqM = (TextView) view.findViewById(f.g.mobile_network_text);
        this.dqN = (TextView) view.findViewById(f.g.mobile_network_play);
        this.ciN = (HeadImageView) view.findViewById(f.g.user_icon);
        this.axI = (TextView) view.findViewById(f.g.user_name);
        this.dqO = (TextView) view.findViewById(f.g.attention);
        this.dqT = (LinearLayout) view.findViewById(f.g.thread_info_commont_container);
        this.dqU = (LinearLayout) view.findViewById(f.g.agree_view_container);
        this.dqP = (TextView) view.findViewById(f.g.thread_info_commont_num);
        this.dqQ = (TextView) view.findViewById(f.g.thread_info_praise_num);
        this.dqR = (ImageView) view.findViewById(f.g.thread_info_commont_img);
        this.dqS = (ImageView) view.findViewById(f.g.thread_info_praise_img);
        this.dqT.setOnClickListener(this);
        this.dqU.setOnClickListener(this);
        this.dqJ.setOnClickListener(this);
        this.ciN.setOnClickListener(this);
        this.axI.setOnClickListener(this);
        this.dqO.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dqN.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqH.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dqH.setLayoutParams(layoutParams);
        this.ciN.setIsRound(true);
        this.bvt = new n(tbPageContext.getPageActivity());
        this.dqX = new h(this.mPageContext, this);
        this.drc = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), f.a.anim_alpha_1_to_0_duration_200);
        this.drd = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), f.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.j(getView(), f.d.cp_bg_line_d);
            if (this.dqW != null && this.dqW.dru != null) {
                if (this.dqW.dru.hasFocus) {
                    am.h(this.dqO, f.d.cp_cont_d);
                    this.dqO.setCompoundDrawables(null, null, null, null);
                } else {
                    am.h(this.dqO, f.d.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(f.C0146f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.f(this.mContext, f.e.ds20), l.f(this.mContext, f.e.ds20));
                    this.dqO.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dqW != null) {
                if (this.dqW.hasAgree) {
                    this.dqS.setImageDrawable(am.getDrawable(f.C0146f.icon_home_card_like_s));
                    am.h(this.dqQ, f.d.cp_cont_h);
                } else {
                    this.dqS.setImageDrawable(am.getDrawable(f.C0146f.icon_home_card_like_n));
                    am.h(this.dqQ, f.d.cp_cont_f);
                }
            }
            am.h(this.dqP, f.d.cp_cont_f);
            this.dqR.setImageDrawable(am.getDrawable(f.C0146f.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.drv != null) {
            this.dqW = gVar;
            this.alU = this.dqW.autoPlay;
            this.dqJ.setVisibility(0);
            this.dqJ.setText(gVar.title);
            this.dqK.setVisibility(0);
            this.dqK.setText(ap.da(gVar.drv.videoDuration * 1000));
            if (gVar.drv.videoSize == 0) {
                format = this.mPageContext.getString(f.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(f.j.video_mobile_network_tips), mA(String.format("%.1f", Float.valueOf(((float) gVar.drv.videoSize) / 1048576.0f))));
            }
            this.dqM.setText(format);
            this.dqL.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.drv != null) {
            this.dqV.stopPlay();
            this.dqV.setIsNeedRecoveryVideoPlayer(true);
            this.dqV.ls(true);
            this.dqV.lq(false);
            this.dqV.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.b
                public void awh() {
                    if (b.this.dqV.bjR()) {
                        b.this.dqK.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                    if (b.this.dqV.bjR()) {
                        b.this.dqK.setVisibility(8);
                    }
                    if (b.this.drb) {
                        b.this.dqV.stopPlay();
                    }
                }
            });
            this.dqV.a(new c.k() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.k
                public void awj() {
                    b.this.drb = false;
                    b.this.dqK.setVisibility(8);
                    b.this.mz(b.this.alU ? "1" : "2");
                    b.this.onClick(b.this.dqI);
                }

                @Override // com.baidu.tieba.play.c.k
                public void awk() {
                    b.this.dqK.setVisibility(8);
                    b.this.onClick(b.this.dqH);
                }
            });
            this.dqV.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.e
                public void fT(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dqM.getText().toString());
                        b.this.dqV.bS(b.this.dqW.drv.videoUrl, b.this.dqW.threadId);
                        b.this.dqK.setVisibility(8);
                        b.this.mz("2");
                    } else {
                        b.this.dqL.setVisibility(0);
                    }
                    b.this.onClick(b.this.dqI);
                }
            });
            this.dqV.lo(false);
            this.dqY = new y();
            this.dqY.aWq = gVar.threadId;
            this.dqY.cBR = gVar.forumId;
            this.dqY.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dqZ = new y();
            this.dqZ.aWq = gVar.threadId;
            this.dqZ.cBR = gVar.forumId;
            this.dqZ.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dre) {
                an anVar = new an("c12590");
                anVar.ae("tid", gVar.threadId);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
                anVar.r("obj_locate", i);
                anVar.r("obj_param2", 1);
                TiebaStatic.log(anVar);
                this.dqY.ghB = "auto_midpage";
                this.dqY.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dqY.ghD = "1";
                this.dqZ.ghB = "auto_midpage";
                this.dqZ.mLocate = "auto_midpage";
                this.dqZ.ghD = "1";
            } else {
                this.dqY.ghD = "frs_bavideotab";
                this.dqY.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dqZ.ghD = "frs_bavideotab";
                this.dqZ.mLocate = "frs_bavideotab";
            }
            if (gVar.drv != null) {
                this.dqY.ghF = gVar.drv.videoMd5;
                this.dqZ.ghF = gVar.drv.videoMd5;
            }
            this.bvt.setVideoStatsData(this.dqY);
            this.dqV.getVideoView().setBusiness(this.bvt);
            this.dqV.aRZ();
            this.dqV.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (!b.this.dqV.bjR()) {
                        b.this.dqJ.setVisibility(0);
                    } else if (z) {
                        if (b.this.dqJ.getVisibility() == 0) {
                            b.this.dqJ.setVisibility(8);
                            b.this.dqJ.startAnimation(b.this.drc);
                        }
                    } else if (b.this.dqJ.getVisibility() == 8) {
                        b.this.dqJ.setVisibility(0);
                        b.this.dqJ.startAnimation(b.this.drd);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awl() {
                    if (!b.this.dqV.bjR()) {
                        b.this.dqJ.setVisibility(0);
                    } else if (b.this.dqJ.getVisibility() == 0) {
                        b.this.dqJ.setVisibility(8);
                        b.this.dqJ.startAnimation(b.this.drc);
                    }
                }
            });
            this.dqV.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.drb = true;
                        b.this.dra = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.kK(i);
                        b.this.dqV.aFa();
                    }
                }
            });
            this.dqV.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.dqW != null && b.this.dqW.drv != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.dqW.drv.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dqV.setThumbnail(gVar.drv.thumbnailUrl);
            this.dqV.setVideoUrl(gVar.drv.videoUrl, gVar.threadId);
            this.dqV.sd(gVar.title);
            this.dqV.a(new c.h() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.h
                public void awm() {
                    b.this.dqK.setVisibility(8);
                }
            });
            this.dqV.aFa();
            this.dqV.show();
            if (gVar.autoPlay) {
                onClick(this.dqI);
                this.drb = false;
                this.dqV.a(gVar.drv.videoUrl, gVar.threadId, (c.d) null, new Object[0]);
            }
            this.drb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(String str) {
        if (this.dqW != null && this.dqW.drv != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dqW.drv.videoMd5, "", str, this.dqZ);
            }
        }
    }

    public boolean isPlaying() {
        return this.dqV.bjR();
    }

    public void awd() {
        if (isPlaying()) {
            this.dqV.pausePlay();
        }
    }

    public boolean kL(int i) {
        return this.dqV.rE(i);
    }

    public void awe() {
        this.dqL.setVisibility(8);
        this.dqV.stopPlay();
        if (this.dqJ != null) {
            this.dqJ.setVisibility(0);
        }
        if (this.dqK != null) {
            this.dqK.setVisibility(0);
        }
    }

    public void awf() {
        if (this.dqV != null) {
            this.dqV.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awf();
        if (this.dqX != null) {
            this.dqX.awr();
        }
    }

    public String mA(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.dru != null) {
            this.axI.setText(TextUtils.isEmpty(gVar.dru.userNickname) ? gVar.dru.userName : gVar.dru.userNickname);
            this.ciN.startLoad(gVar.dru.portrait, 12, false);
            this.ciN.setShowV(gVar.dru.isGod);
            this.ciN.setIsBigV(gVar.dru.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dru != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dru.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dru.userId)) {
                this.dqO.setVisibility(8);
            } else {
                this.dqO.setVisibility(0);
            }
            if (gVar.dru.hasFocus) {
                am.h(this.dqO, f.d.cp_cont_d);
                this.dqO.setCompoundDrawables(null, null, null, null);
                this.dqO.setText(this.mPageContext.getString(f.j.relate_forum_is_followed));
                return;
            }
            am.h(this.dqO, f.d.cp_link_tip_a);
            Drawable drawable = am.getDrawable(f.C0146f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.f(this.mContext, f.e.ds20), l.f(this.mContext, f.e.ds20));
            this.dqO.setCompoundDrawables(drawable, null, null, null);
            this.dqO.setText(this.mPageContext.getString(f.j.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dqS.setImageDrawable(am.getDrawable(f.C0146f.icon_home_card_like_s));
                am.h(this.dqQ, f.d.cp_cont_h);
            } else {
                this.dqS.setImageDrawable(am.getDrawable(f.C0146f.icon_home_card_like_n));
                am.h(this.dqQ, f.d.cp_cont_f);
            }
            this.dqQ.setText(ap.H(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.h(this.dqP, f.d.cp_cont_f);
            this.dqR.setImageDrawable(am.getDrawable(f.C0146f.icon_home_card_comment));
            this.dqP.setText(ap.H(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dqV != null && this.dqI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dra) {
                this.dqV.bjQ();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dqI.getParent() != null) {
                    if (this.dqI.getParent() == frameLayout) {
                        frameLayout.removeView(this.dqI);
                    } else if (this.dqI.getParent() == this.dqH) {
                        this.dqH.removeView(this.dqI);
                    }
                }
                if (this.dqI.getParent() == null) {
                    frameLayout.addView(this.dqI);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dqI.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dqI.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dqI.getParent() != null) {
                    if (this.dqI.getParent() == frameLayout) {
                        frameLayout.removeView(this.dqI);
                    } else if (this.dqI.getParent() == this.dqH) {
                        this.dqH.removeView(this.dqI);
                    }
                }
                if (this.dqI.getParent() == null) {
                    this.dqH.addView(this.dqI, 0);
                    this.dqI.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dqV.aRZ();
                    this.dra = true;
                } else {
                    return;
                }
            }
            this.dqV.a(this.mPageContext, configuration);
            this.dqK.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiC() != null) {
            view.setTag(this);
            aiC().a(view, this.dqW);
        }
        if (view == this.ciN || view == this.axI) {
            boolean z = false;
            if (this.dqW != null && this.dqW.dru != null && !TextUtils.isEmpty(this.dqW.dru.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dqW.dru.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dqW.dru.userId, 0L), z, this.dqW.dru.isGod)));
            }
        } else if (view == this.dqT || view == this.dqJ || view == getView()) {
            if (this.dqW != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dqW.threadId, null, null);
                if (!this.dre) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dqN) {
            if (this.dqW != null && this.dqW.drv != null) {
                this.dqL.setVisibility(8);
                this.dqV.bjU();
                this.dqV.bS(this.dqW.drv.videoUrl, this.dqW.threadId);
                mz("2");
            }
        } else if (view == this.dqO) {
            if (!this.dqW.dru.hasFocus) {
                this.dqX.f(this.dqW);
            }
        } else if (view == this.dqU) {
            this.dqX.g(this.dqW);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fS(boolean z) {
        if (this.dqW != null && this.dqW.dru != null) {
            this.dqW.dru.hasFocus = z;
            c(this.dqW);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void awg() {
        if (this.dqW != null) {
            this.dqW.hasAgree = !this.dqW.hasAgree;
            if (this.dqW.hasAgree) {
                this.dqW.agreeNum++;
            } else {
                this.dqW.agreeNum--;
            }
            if (this.dqS != null) {
                this.dqS.startAnimation(getScaleAnimation());
            }
            d(this.dqW);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axA == null) {
            this.axA = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axA.setDuration(200L);
        }
        return this.axA;
    }
}
