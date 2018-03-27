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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.d;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> implements b {
    private ScaleAnimation bdK;
    public TextView bdP;
    public HeadImageView cGb;
    private n caR;
    public TextView cux;
    public FrameLayout dHV;
    public FrameLayout dHW;
    public TextView dHX;
    public TextView dHY;
    public FrameLayout dHZ;
    public TextView dIa;
    public TextView dIb;
    public TextView dIc;
    public TextView dId;
    public ImageView dIe;
    public ImageView dIf;
    public LinearLayout dIg;
    public LinearLayout dIh;
    public com.baidu.tieba.play.c dIi;
    public f dIj;
    private h dIk;
    private aa dIl;
    private aa dIm;
    private boolean dIn;
    private boolean dIo;
    private Animation dIp;
    private Animation dIq;
    private boolean dIr;
    private boolean dIs;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dIn = true;
        this.dIs = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dHV = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dHW = (FrameLayout) view.findViewById(d.g.video_container);
        this.dIi = new com.baidu.tieba.play.c(tbPageContext, this.dHW, false);
        this.dHX = (TextView) view.findViewById(d.g.title);
        this.dHY = (TextView) view.findViewById(d.g.duration);
        this.dHZ = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.dIa = (TextView) view.findViewById(d.g.mobile_network_text);
        this.dIb = (TextView) view.findViewById(d.g.mobile_network_play);
        this.cGb = (HeadImageView) view.findViewById(d.g.user_icon);
        this.bdP = (TextView) view.findViewById(d.g.user_name);
        this.cux = (TextView) view.findViewById(d.g.attention);
        this.dIg = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.dIh = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.dIc = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.dId = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.dIe = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.dIf = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.dIg.setOnClickListener(this);
        this.dIh.setOnClickListener(this);
        this.dHX.setOnClickListener(this);
        this.cGb.setOnClickListener(this);
        this.bdP.setOnClickListener(this);
        this.cux.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dIb.setOnClickListener(this);
        this.mWidth = l.ao(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHV.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dHV.setLayoutParams(layoutParams);
        this.cGb.setIsRound(true);
        this.caR = new n(tbPageContext.getPageActivity());
        this.dIk = new h(this.mPageContext, this);
        this.dIp = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dIq = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().aQ(i == 1);
            tbPageContext.getLayoutMode().aM(getView());
            aj.t(getView(), d.C0141d.cp_bg_line_d);
            if (this.dIj != null && this.dIj.dIJ != null) {
                if (this.dIj.dIJ.hasFocus) {
                    aj.r(this.cux, d.C0141d.cp_cont_d);
                    this.cux.setCompoundDrawables(null, null, null, null);
                } else {
                    aj.r(this.cux, d.C0141d.cp_link_tip_a);
                    Drawable drawable = aj.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.t(this.mContext, d.e.ds20), l.t(this.mContext, d.e.ds20));
                    this.cux.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dIj != null) {
                if (this.dIj.hasAgree) {
                    this.dIf.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_s));
                    aj.r(this.dId, d.C0141d.cp_cont_h);
                } else {
                    this.dIf.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_n));
                    aj.r(this.dId, d.C0141d.cp_cont_f);
                }
            }
            aj.r(this.dIc, d.C0141d.cp_cont_f);
            this.dIe.setImageDrawable(aj.getDrawable(d.f.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
    }

    public void a(f fVar, int i, d.a aVar) {
        String format;
        if (fVar != null && fVar.dIK != null) {
            this.dIj = fVar;
            this.dIr = this.dIj.autoPlay;
            this.dHX.setVisibility(0);
            this.dHX.setText(fVar.title);
            this.dHY.setVisibility(0);
            this.dHY.setText(am.fV(fVar.dIK.videoDuration * 1000));
            if (fVar.dIK.videoSize == 0) {
                format = this.mPageContext.getString(d.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.j.video_mobile_network_tips), lM(String.format("%.1f", Float.valueOf(((float) fVar.dIK.videoSize) / 1048576.0f))));
            }
            this.dIa.setText(format);
            this.dHZ.setVisibility(8);
            b(fVar, i, aVar);
            b(fVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(f fVar, final int i, final d.a aVar) {
        if (fVar != null && fVar.dIK != null) {
            this.dIi.stopPlay();
            this.dIi.lN(true);
            this.dIi.lQ(true);
            this.dIi.lO(false);
            this.dIi.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.a.1
                @Override // com.baidu.tieba.play.c.b
                public void awC() {
                    if (a.this.dIi.bkW()) {
                        a.this.dHY.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void awD() {
                    if (a.this.dIi.bkW()) {
                        a.this.dHY.setVisibility(8);
                    }
                    if (a.this.dIo) {
                        a.this.dIi.stopPlay();
                    }
                }
            });
            this.dIi.a(new c.j() { // from class: com.baidu.tieba.frs.aggregation.a.2
                @Override // com.baidu.tieba.play.c.j
                public void awE() {
                    a.this.dIo = false;
                    a.this.dHY.setVisibility(8);
                    a.this.lL(a.this.dIr ? "1" : "2");
                    a.this.onClick(a.this.dHW);
                }

                @Override // com.baidu.tieba.play.c.j
                public void awF() {
                    a.this.dHY.setVisibility(8);
                    a.this.onClick(a.this.dHV);
                }
            });
            this.dIi.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.a.3
                @Override // com.baidu.tieba.play.c.e
                public void gb(boolean z) {
                    if (z) {
                        a.this.mPageContext.showToast(a.this.dIa.getText().toString());
                        a.this.dIi.bL(a.this.dIj.dIK.videoUrl, a.this.dIj.threadId);
                        a.this.dHY.setVisibility(8);
                        a.this.lL("2");
                    } else {
                        a.this.dHZ.setVisibility(0);
                    }
                    a.this.onClick(a.this.dHW);
                }
            });
            this.dIi.lL(false);
            this.dIl = new aa();
            this.dIl.bCV = fVar.threadId;
            this.dIl.cZL = fVar.forumId;
            this.dIl.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dIm = new aa();
            this.dIm.bCV = fVar.threadId;
            this.dIm.cZL = fVar.forumId;
            this.dIm.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dIs) {
                ak akVar = new ak("c12590");
                akVar.ab("tid", fVar.threadId);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                akVar.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                akVar.s("obj_locate", i);
                akVar.s("obj_param2", 1);
                TiebaStatic.log(akVar);
                this.dIl.gwb = "auto_midpage";
                this.dIl.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dIl.gwd = "1";
                this.dIm.gwb = "auto_midpage";
                this.dIm.mLocate = "auto_midpage";
                this.dIm.gwd = "1";
            } else {
                this.dIl.gwd = "frs_bavideotab";
                this.dIl.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dIm.gwd = "frs_bavideotab";
                this.dIm.mLocate = "frs_bavideotab";
            }
            if (fVar.dIK != null) {
                this.dIl.gwf = fVar.dIK.videoMd5;
                this.dIm.gwf = fVar.dIK.videoMd5;
            }
            this.caR.setVideoStatsData(this.dIl);
            this.dIi.getVideoView().setBusiness(this.caR);
            this.dIi.aQz();
            this.dIi.b(new c.InterfaceC0219c() { // from class: com.baidu.tieba.frs.aggregation.a.4
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void gc(boolean z) {
                    if (!a.this.dIi.bkW()) {
                        a.this.dHX.setVisibility(0);
                    } else if (z) {
                        if (a.this.dHX.getVisibility() == 0) {
                            a.this.dHX.setVisibility(8);
                            a.this.dHX.startAnimation(a.this.dIp);
                        }
                    } else if (a.this.dHX.getVisibility() == 8) {
                        a.this.dHX.setVisibility(0);
                        a.this.dHX.startAnimation(a.this.dIq);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void awG() {
                    if (!a.this.dIi.bkW()) {
                        a.this.dHX.setVisibility(0);
                    } else if (a.this.dHX.getVisibility() == 0) {
                        a.this.dHX.setVisibility(8);
                        a.this.dHX.startAnimation(a.this.dIp);
                    }
                }
            });
            this.dIi.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.a.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    if (a.this.isFullScreen) {
                        a.this.dIo = true;
                        a.this.dIn = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.nd(i);
                        a.this.dIi.aDC();
                    }
                }
            });
            this.dIi.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.a.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (a.this.dIj != null && a.this.dIj.dIK != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dIj.dIK.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dIi.ov(fVar.dIK.thumbnailUrl);
            this.dIi.bK(fVar.dIK.videoUrl, fVar.threadId);
            this.dIi.rg(fVar.title);
            this.dIi.a(new c.g() { // from class: com.baidu.tieba.frs.aggregation.a.7
                @Override // com.baidu.tieba.play.c.g
                public void awH() {
                    a.this.dHY.setVisibility(8);
                }
            });
            this.dIi.aDC();
            this.dIi.show();
            if (fVar.autoPlay) {
                onClick(this.dHW);
                this.dIo = false;
                this.dIi.a(fVar.dIK.videoUrl, fVar.threadId, null, new Object[0]);
            }
            this.dIo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.dIj != null && this.dIj.dIK != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dIj.dIK.videoMd5, "", str, this.dIm);
            }
        }
    }

    public boolean isPlaying() {
        return this.dIi.bkW();
    }

    public void awy() {
        if (isPlaying()) {
            this.dIi.pausePlay();
        }
    }

    public boolean nc(int i) {
        return this.dIi.tQ(i);
    }

    public void awz() {
        this.dHZ.setVisibility(8);
        this.dIi.stopPlay();
        if (this.dHX != null) {
            this.dHX.setVisibility(0);
        }
        if (this.dHY != null) {
            this.dHY.setVisibility(0);
        }
    }

    public void awA() {
        if (this.dIi != null) {
            this.dIi.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awA();
        if (this.dIk != null) {
            this.dIk.awQ();
        }
    }

    public String lM(String str) {
        if (str.indexOf(com.baidu.ar.util.Constants.DOT) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(f fVar) {
        if (fVar != null && fVar.dIJ != null) {
            this.bdP.setText(TextUtils.isEmpty(fVar.dIJ.userNickname) ? fVar.dIJ.userName : fVar.dIJ.userNickname);
            this.cGb.startLoad(fVar.dIJ.portrait, 12, false);
            this.cGb.setShowV(fVar.dIJ.isGod);
            this.cGb.setIsBigV(fVar.dIJ.isGod);
            c(fVar);
            d(fVar);
            e(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null && fVar.dIJ != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(fVar.dIJ.userId) && TbadkCoreApplication.getCurrentAccount().equals(fVar.dIJ.userId)) {
                this.cux.setVisibility(8);
            } else {
                this.cux.setVisibility(0);
            }
            if (fVar.dIJ.hasFocus) {
                aj.r(this.cux, d.C0141d.cp_cont_d);
                this.cux.setCompoundDrawables(null, null, null, null);
                this.cux.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                return;
            }
            aj.r(this.cux, d.C0141d.cp_link_tip_a);
            Drawable drawable = aj.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.t(this.mContext, d.e.ds20), l.t(this.mContext, d.e.ds20));
            this.cux.setCompoundDrawables(drawable, null, null, null);
            this.cux.setText(this.mPageContext.getString(d.j.attention));
        }
    }

    public void d(f fVar) {
        if (fVar != null) {
            if (fVar.hasAgree) {
                this.dIf.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_s));
                aj.r(this.dId, d.C0141d.cp_cont_h);
            } else {
                this.dIf.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_n));
                aj.r(this.dId, d.C0141d.cp_cont_f);
            }
            this.dId.setText(am.J(fVar.agreeNum));
        }
    }

    public void e(f fVar) {
        if (fVar != null) {
            aj.r(this.dIc, d.C0141d.cp_cont_f);
            this.dIe.setImageDrawable(aj.getDrawable(d.f.icon_home_card_comment));
            this.dIc.setText(am.J(fVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dIi != null && this.dHW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dIn) {
                this.dIi.bkV();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dHW.getParent() != null) {
                    if (this.dHW.getParent() == frameLayout) {
                        frameLayout.removeView(this.dHW);
                    } else if (this.dHW.getParent() == this.dHV) {
                        this.dHV.removeView(this.dHW);
                    }
                }
                if (this.dHW.getParent() == null) {
                    frameLayout.addView(this.dHW);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dHW.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dHW.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dHW.getParent() != null) {
                    if (this.dHW.getParent() == frameLayout) {
                        frameLayout.removeView(this.dHW);
                    } else if (this.dHW.getParent() == this.dHV) {
                        this.dHV.removeView(this.dHW);
                    }
                }
                if (this.dHW.getParent() == null) {
                    this.dHV.addView(this.dHW, 0);
                    this.dHW.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dIi.aQz();
                    this.dIn = true;
                } else {
                    return;
                }
            }
            this.dIi.a(this.mPageContext, configuration);
            this.dHY.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akP() != null) {
            view.setTag(this);
            akP().a(view, this.dIj);
        }
        if (view == this.cGb || view == this.bdP) {
            boolean z = false;
            if (this.dIj != null && this.dIj.dIJ != null && !TextUtils.isEmpty(this.dIj.dIJ.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dIj.dIJ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dIj.dIJ.userId, 0L), z, this.dIj.dIJ.isGod)));
            }
        } else if (view == this.dIg || view == this.dHX || view == getView()) {
            if (this.dIj != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dIj.threadId, null, null);
                if (!this.dIs) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dIb) {
            if (this.dIj != null && this.dIj.dIK != null) {
                this.dHZ.setVisibility(8);
                this.dIi.bkY();
                this.dIi.bL(this.dIj.dIK.videoUrl, this.dIj.threadId);
                lL("2");
            }
        } else if (view == this.cux) {
            if (!this.dIj.dIJ.hasFocus) {
                this.dIk.f(this.dIj);
            }
        } else if (view == this.dIh) {
            this.dIk.g(this.dIj);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void ga(boolean z) {
        if (this.dIj != null && this.dIj.dIJ != null) {
            this.dIj.dIJ.hasFocus = z;
            c(this.dIj);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void awB() {
        if (this.dIj != null) {
            this.dIj.hasAgree = !this.dIj.hasAgree;
            if (this.dIj.hasAgree) {
                this.dIj.agreeNum++;
            } else {
                this.dIj.agreeNum--;
            }
            if (this.dIf != null) {
                this.dIf.startAnimation(getScaleAnimation());
            }
            d(this.dIj);
        }
    }

    private Animation getScaleAnimation() {
        if (this.bdK == null) {
            this.bdK = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdK.setDuration(200L);
        }
        return this.bdK;
    }
}
