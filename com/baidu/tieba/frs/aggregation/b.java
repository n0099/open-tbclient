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
    public g aFl;
    public TextView aKr;
    private boolean axF;
    private n bOs;
    public HeadImageView cDi;
    public TextView dPA;
    public TextView dPB;
    public FrameLayout dPC;
    public TextView dPD;
    public TextView dPE;
    public TextView dPF;
    public TextView dPG;
    public TextView dPH;
    public ImageView dPI;
    public ImageView dPJ;
    public LinearLayout dPK;
    public LinearLayout dPL;
    public com.baidu.tieba.play.c dPM;
    private h dPN;
    private z dPO;
    private z dPP;
    private boolean dPQ;
    private boolean dPR;
    private Animation dPS;
    private Animation dPT;
    private ScaleAnimation dPU;
    private boolean dPV;
    public FrameLayout dPy;
    public FrameLayout dPz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dPQ = true;
        this.dPV = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dPy = (FrameLayout) view.findViewById(e.g.video_agg_container);
        this.dPz = (FrameLayout) view.findViewById(e.g.video_container);
        this.dPM = new com.baidu.tieba.play.c(tbPageContext, (View) this.dPz, false);
        this.dPA = (TextView) view.findViewById(e.g.title);
        this.dPB = (TextView) view.findViewById(e.g.duration);
        this.dPC = (FrameLayout) view.findViewById(e.g.mobile_network_container);
        this.dPD = (TextView) view.findViewById(e.g.mobile_network_text);
        this.dPE = (TextView) view.findViewById(e.g.mobile_network_play);
        this.cDi = (HeadImageView) view.findViewById(e.g.user_icon);
        this.aKr = (TextView) view.findViewById(e.g.user_name);
        this.dPF = (TextView) view.findViewById(e.g.attention);
        this.dPK = (LinearLayout) view.findViewById(e.g.thread_info_commont_container);
        this.dPL = (LinearLayout) view.findViewById(e.g.agree_view_container);
        this.dPG = (TextView) view.findViewById(e.g.thread_info_commont_num);
        this.dPH = (TextView) view.findViewById(e.g.thread_info_praise_num);
        this.dPI = (ImageView) view.findViewById(e.g.thread_info_commont_img);
        this.dPJ = (ImageView) view.findViewById(e.g.thread_info_praise_img);
        this.dPK.setOnClickListener(this);
        this.dPL.setOnClickListener(this);
        this.dPA.setOnClickListener(this);
        this.cDi.setOnClickListener(this);
        this.aKr.setOnClickListener(this);
        this.dPF.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dPE.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dPy.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dPy.setLayoutParams(layoutParams);
        this.cDi.setIsRound(true);
        this.bOs = new n(tbPageContext.getPageActivity());
        this.dPN = new h(this.mPageContext, this);
        this.dPS = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_200);
        this.dPT = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            al.j(getView(), e.d.cp_bg_line_d);
            if (this.aFl != null && this.aFl.dQm != null) {
                if (this.aFl.dQm.hasFocus) {
                    al.h(this.dPF, e.d.cp_cont_d);
                    this.dPF.setCompoundDrawables(null, null, null, null);
                } else {
                    al.h(this.dPF, e.d.cp_link_tip_a);
                    Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
                    this.dPF.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.aFl != null) {
                if (this.aFl.hasAgree) {
                    this.dPJ.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                    al.h(this.dPH, e.d.cp_cont_h);
                } else {
                    this.dPJ.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                    al.h(this.dPH, e.d.cp_cont_f);
                }
            }
            al.h(this.dPG, e.d.cp_cont_f);
            this.dPI.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
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
        if (gVar != null && gVar.dQn != null) {
            this.aFl = gVar;
            this.axF = this.aFl.autoPlay;
            this.dPA.setVisibility(0);
            this.dPA.setText(gVar.title);
            this.dPB.setVisibility(0);
            this.dPB.setText(ao.dV(gVar.dQn.videoDuration * 1000));
            if (gVar.dQn.videoSize == 0) {
                format = this.mPageContext.getString(e.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(e.j.video_mobile_network_tips), oj(String.format("%.1f", Float.valueOf(((float) gVar.dQn.videoSize) / 1048576.0f))));
            }
            this.dPD.setText(format);
            this.dPC.setVisibility(8);
            b(gVar, i, aVar);
            c(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.dQn != null) {
            this.dPM.stopPlay();
            this.dPM.setIsNeedRecoveryVideoPlayer(true);
            this.dPM.mz(true);
            this.dPM.mv(false);
            this.dPM.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YS() {
                    if (b.this.dPM.brH()) {
                        b.this.dPB.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YT() {
                    if (b.this.dPM.brH()) {
                        b.this.dPB.setVisibility(8);
                    }
                    if (b.this.dPR) {
                        b.this.dPM.stopPlay();
                    }
                }
            });
            this.dPM.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void aDJ() {
                    b.this.dPR = false;
                    b.this.dPB.setVisibility(8);
                    b.this.oi(b.this.axF ? "1" : "2");
                    b.this.onClick(b.this.dPz);
                }

                @Override // com.baidu.tieba.play.c.l
                public void aDK() {
                    b.this.dPB.setVisibility(8);
                    b.this.onClick(b.this.dPy);
                }
            });
            this.dPM.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void gW(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.dPD.getText().toString());
                        b.this.dPM.aZ(b.this.aFl.dQn.videoUrl, b.this.aFl.threadId);
                        b.this.dPB.setVisibility(8);
                        b.this.oi("2");
                    } else {
                        b.this.dPC.setVisibility(0);
                    }
                    b.this.onClick(b.this.dPz);
                }
            });
            this.dPM.ms(false);
            this.dPO = new z();
            this.dPO.biz = gVar.threadId;
            this.dPO.daG = gVar.forumId;
            this.dPO.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dPP = new z();
            this.dPP.biz = gVar.threadId;
            this.dPP.daG = gVar.forumId;
            this.dPP.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dPV) {
                am amVar = new am("c12590");
                amVar.aA("tid", gVar.threadId);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                amVar.x("obj_locate", i);
                amVar.x("obj_param2", 1);
                TiebaStatic.log(amVar);
                this.dPO.gHE = "auto_midpage";
                this.dPO.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dPO.gHG = "1";
                this.dPP.gHE = "auto_midpage";
                this.dPP.mLocate = "auto_midpage";
                this.dPP.gHG = "1";
            } else {
                this.dPO.gHG = "frs_bavideotab";
                this.dPO.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dPP.gHG = "frs_bavideotab";
                this.dPP.mLocate = "frs_bavideotab";
            }
            if (gVar.dQn != null) {
                this.dPO.gHI = gVar.dQn.videoMd5;
                this.dPP.gHI = gVar.dQn.videoMd5;
            }
            this.bOs.setVideoStatsData(this.dPO);
            this.dPM.getVideoView().setBusiness(this.bOs);
            this.dPM.aZC();
            this.dPM.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void gX(boolean z) {
                    if (!b.this.dPM.brH()) {
                        b.this.dPA.setVisibility(0);
                    } else if (z) {
                        if (b.this.dPA.getVisibility() == 0) {
                            b.this.dPA.setVisibility(8);
                            b.this.dPA.startAnimation(b.this.dPS);
                        }
                    } else if (b.this.dPA.getVisibility() == 8) {
                        b.this.dPA.setVisibility(0);
                        b.this.dPA.startAnimation(b.this.dPT);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aDL() {
                    if (!b.this.dPM.brH()) {
                        b.this.dPA.setVisibility(0);
                    } else if (b.this.dPA.getVisibility() == 0) {
                        b.this.dPA.setVisibility(8);
                        b.this.dPA.startAnimation(b.this.dPS);
                    }
                }
            });
            this.dPM.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.dPR = true;
                        b.this.dPQ = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.mG(i);
                        b.this.dPM.aMK();
                    }
                }
            });
            this.dPM.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.aFl != null && b.this.aFl.dQn != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.aFl.dQn.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dPM.setThumbnail(gVar.dQn.thumbnailUrl);
            this.dPM.setVideoUrl(gVar.dQn.videoUrl, gVar.threadId);
            this.dPM.tU(gVar.title);
            this.dPM.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void aDM() {
                    b.this.dPB.setVisibility(8);
                }
            });
            this.dPM.aMK();
            this.dPM.show();
            if (gVar.autoPlay) {
                onClick(this.dPz);
                this.dPR = false;
                this.dPM.a(gVar.dQn.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.dPR = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(String str) {
        if (this.aFl != null && this.aFl.dQn != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.aFl.dQn.videoMd5, "", str, this.dPP);
            }
        }
    }

    public boolean isPlaying() {
        return this.dPM.brH();
    }

    public void aDF() {
        if (isPlaying()) {
            this.dPM.pausePlay();
        }
    }

    public boolean mH(int i) {
        return this.dPM.ty(i);
    }

    public void aDG() {
        this.dPC.setVisibility(8);
        this.dPM.stopPlay();
        if (this.dPA != null) {
            this.dPA.setVisibility(0);
        }
        if (this.dPB != null) {
            this.dPB.setVisibility(0);
        }
    }

    public void aDH() {
        if (this.dPM != null) {
            this.dPM.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        aDH();
        if (this.dPN != null) {
            this.dPN.aDS();
        }
    }

    public String oj(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void c(g gVar) {
        if (gVar != null && gVar.dQm != null) {
            this.aKr.setText(TextUtils.isEmpty(gVar.dQm.userNickname) ? gVar.dQm.userName : gVar.dQm.userNickname);
            this.cDi.startLoad(gVar.dQm.portrait, 12, false);
            this.cDi.setShowV(gVar.dQm.isGod);
            this.cDi.setIsBigV(gVar.dQm.isGod);
            d(gVar);
            e(gVar);
            f(gVar);
        }
    }

    public void d(g gVar) {
        if (gVar != null && gVar.dQm != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dQm.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dQm.userId)) {
                this.dPF.setVisibility(8);
            } else {
                this.dPF.setVisibility(0);
            }
            if (gVar.dQm.hasFocus) {
                al.h(this.dPF, e.d.cp_cont_d);
                this.dPF.setCompoundDrawables(null, null, null, null);
                this.dPF.setText(this.mPageContext.getString(e.j.relate_forum_is_followed));
                return;
            }
            al.h(this.dPF, e.d.cp_link_tip_a);
            Drawable drawable = al.getDrawable(e.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.h(this.mContext, e.C0210e.ds20), l.h(this.mContext, e.C0210e.ds20));
            this.dPF.setCompoundDrawables(drawable, null, null, null);
            this.dPF.setText(this.mPageContext.getString(e.j.attention));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.dPJ.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_s));
                al.h(this.dPH, e.d.cp_cont_h);
            } else {
                this.dPJ.setImageDrawable(al.getDrawable(e.f.icon_home_card_like_n));
                al.h(this.dPH, e.d.cp_cont_f);
            }
            this.dPH.setText(ao.X(gVar.agreeNum));
        }
    }

    public void f(g gVar) {
        if (gVar != null) {
            al.h(this.dPG, e.d.cp_cont_f);
            this.dPI.setImageDrawable(al.getDrawable(e.f.icon_home_card_comment));
            this.dPG.setText(ao.X(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dPM != null && this.dPz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dPQ) {
                this.dPM.brG();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dPz.getParent() != null) {
                    if (this.dPz.getParent() == frameLayout) {
                        frameLayout.removeView(this.dPz);
                    } else if (this.dPz.getParent() == this.dPy) {
                        this.dPy.removeView(this.dPz);
                    }
                }
                if (this.dPz.getParent() == null) {
                    frameLayout.addView(this.dPz);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dPz.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dPz.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dPz.getParent() != null) {
                    if (this.dPz.getParent() == frameLayout) {
                        frameLayout.removeView(this.dPz);
                    } else if (this.dPz.getParent() == this.dPy) {
                        this.dPy.removeView(this.dPz);
                    }
                }
                if (this.dPz.getParent() == null) {
                    this.dPy.addView(this.dPz, 0);
                    this.dPz.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dPM.aZC();
                    this.dPQ = true;
                } else {
                    return;
                }
            }
            this.dPM.a(this.mPageContext, configuration);
            this.dPB.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apS() != null) {
            view.setTag(this);
            apS().a(view, this.aFl);
        }
        if (view == this.cDi || view == this.aKr) {
            boolean z = false;
            if (this.aFl != null && this.aFl.dQm != null && !TextUtils.isEmpty(this.aFl.dQm.userId)) {
                if (TbadkCoreApplication.isLogin() && this.aFl.dQm.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.aFl.dQm.userId, 0L), z, this.aFl.dQm.isGod)));
            }
        } else if (view == this.dPK || view == this.dPA || view == getView()) {
            if (this.aFl != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.aFl.threadId, null, null);
                if (!this.dPV) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dPE) {
            if (this.aFl != null && this.aFl.dQn != null) {
                this.dPC.setVisibility(8);
                this.dPM.brK();
                this.dPM.aZ(this.aFl.dQn.videoUrl, this.aFl.threadId);
                oi("2");
            }
        } else if (view == this.dPF) {
            if (!this.aFl.dQm.hasFocus) {
                this.dPN.g(this.aFl);
            }
        } else if (view == this.dPL) {
            this.dPN.h(this.aFl);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void gV(boolean z) {
        if (this.aFl != null && this.aFl.dQm != null) {
            this.aFl.dQm.hasFocus = z;
            d(this.aFl);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void aDI() {
        if (this.aFl != null) {
            this.aFl.hasAgree = !this.aFl.hasAgree;
            if (this.aFl.hasAgree) {
                this.aFl.agreeNum++;
            } else {
                this.aFl.agreeNum--;
            }
            if (this.dPJ != null) {
                this.dPJ.startAnimation(getScaleAnimation());
            }
            e(this.aFl);
        }
    }

    private Animation getScaleAnimation() {
        if (this.dPU == null) {
            this.dPU = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dPU.setDuration(200L);
        }
        return this.dPU;
    }
}
