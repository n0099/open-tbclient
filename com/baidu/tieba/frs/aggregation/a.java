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
    private ScaleAnimation bdU;
    public TextView bdY;
    public HeadImageView cGk;
    private n cba;
    public TextView cuG;
    public FrameLayout dIc;
    public FrameLayout dId;
    public TextView dIe;
    public TextView dIf;
    public FrameLayout dIg;
    public TextView dIh;
    public TextView dIi;
    public TextView dIj;
    public TextView dIk;
    public ImageView dIl;
    public ImageView dIm;
    public LinearLayout dIn;
    public LinearLayout dIo;
    public com.baidu.tieba.play.c dIp;
    public f dIq;
    private h dIr;
    private aa dIs;
    private aa dIt;
    private boolean dIu;
    private boolean dIv;
    private Animation dIw;
    private Animation dIx;
    private boolean dIy;
    private boolean dIz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dIu = true;
        this.dIz = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dIc = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dId = (FrameLayout) view.findViewById(d.g.video_container);
        this.dIp = new com.baidu.tieba.play.c(tbPageContext, this.dId, false);
        this.dIe = (TextView) view.findViewById(d.g.title);
        this.dIf = (TextView) view.findViewById(d.g.duration);
        this.dIg = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.dIh = (TextView) view.findViewById(d.g.mobile_network_text);
        this.dIi = (TextView) view.findViewById(d.g.mobile_network_play);
        this.cGk = (HeadImageView) view.findViewById(d.g.user_icon);
        this.bdY = (TextView) view.findViewById(d.g.user_name);
        this.cuG = (TextView) view.findViewById(d.g.attention);
        this.dIn = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.dIo = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.dIj = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.dIk = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.dIl = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.dIm = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.dIn.setOnClickListener(this);
        this.dIo.setOnClickListener(this);
        this.dIe.setOnClickListener(this);
        this.cGk.setOnClickListener(this);
        this.bdY.setOnClickListener(this);
        this.cuG.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dIi.setOnClickListener(this);
        this.mWidth = l.ao(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dIc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dIc.setLayoutParams(layoutParams);
        this.cGk.setIsRound(true);
        this.cba = new n(tbPageContext.getPageActivity());
        this.dIr = new h(this.mPageContext, this);
        this.dIw = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dIx = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().aQ(i == 1);
            tbPageContext.getLayoutMode().aM(getView());
            aj.t(getView(), d.C0140d.cp_bg_line_d);
            if (this.dIq != null && this.dIq.dIQ != null) {
                if (this.dIq.dIQ.hasFocus) {
                    aj.r(this.cuG, d.C0140d.cp_cont_d);
                    this.cuG.setCompoundDrawables(null, null, null, null);
                } else {
                    aj.r(this.cuG, d.C0140d.cp_link_tip_a);
                    Drawable drawable = aj.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.t(this.mContext, d.e.ds20), l.t(this.mContext, d.e.ds20));
                    this.cuG.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dIq != null) {
                if (this.dIq.hasAgree) {
                    this.dIm.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_s));
                    aj.r(this.dIk, d.C0140d.cp_cont_h);
                } else {
                    this.dIm.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_n));
                    aj.r(this.dIk, d.C0140d.cp_cont_f);
                }
            }
            aj.r(this.dIj, d.C0140d.cp_cont_f);
            this.dIl.setImageDrawable(aj.getDrawable(d.f.icon_home_card_comment));
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
        if (fVar != null && fVar.dIR != null) {
            this.dIq = fVar;
            this.dIy = this.dIq.autoPlay;
            this.dIe.setVisibility(0);
            this.dIe.setText(fVar.title);
            this.dIf.setVisibility(0);
            this.dIf.setText(am.fV(fVar.dIR.videoDuration * 1000));
            if (fVar.dIR.videoSize == 0) {
                format = this.mPageContext.getString(d.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.j.video_mobile_network_tips), lM(String.format("%.1f", Float.valueOf(((float) fVar.dIR.videoSize) / 1048576.0f))));
            }
            this.dIh.setText(format);
            this.dIg.setVisibility(8);
            b(fVar, i, aVar);
            b(fVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(f fVar, final int i, final d.a aVar) {
        if (fVar != null && fVar.dIR != null) {
            this.dIp.stopPlay();
            this.dIp.lI(true);
            this.dIp.lL(true);
            this.dIp.lJ(false);
            this.dIp.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.a.1
                @Override // com.baidu.tieba.play.c.b
                public void awB() {
                    if (a.this.dIp.bkW()) {
                        a.this.dIf.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void awC() {
                    if (a.this.dIp.bkW()) {
                        a.this.dIf.setVisibility(8);
                    }
                    if (a.this.dIv) {
                        a.this.dIp.stopPlay();
                    }
                }
            });
            this.dIp.a(new c.j() { // from class: com.baidu.tieba.frs.aggregation.a.2
                @Override // com.baidu.tieba.play.c.j
                public void awD() {
                    a.this.dIv = false;
                    a.this.dIf.setVisibility(8);
                    a.this.lL(a.this.dIy ? "1" : "2");
                    a.this.onClick(a.this.dId);
                }

                @Override // com.baidu.tieba.play.c.j
                public void awE() {
                    a.this.dIf.setVisibility(8);
                    a.this.onClick(a.this.dIc);
                }
            });
            this.dIp.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.a.3
                @Override // com.baidu.tieba.play.c.e
                public void gb(boolean z) {
                    if (z) {
                        a.this.mPageContext.showToast(a.this.dIh.getText().toString());
                        a.this.dIp.bL(a.this.dIq.dIR.videoUrl, a.this.dIq.threadId);
                        a.this.dIf.setVisibility(8);
                        a.this.lL("2");
                    } else {
                        a.this.dIg.setVisibility(0);
                    }
                    a.this.onClick(a.this.dId);
                }
            });
            this.dIp.lG(false);
            this.dIs = new aa();
            this.dIs.bDf = fVar.threadId;
            this.dIs.cZU = fVar.forumId;
            this.dIs.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dIt = new aa();
            this.dIt.bDf = fVar.threadId;
            this.dIt.cZU = fVar.forumId;
            this.dIt.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dIz) {
                ak akVar = new ak("c12590");
                akVar.ab("tid", fVar.threadId);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                akVar.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                akVar.s("obj_locate", i);
                akVar.s("obj_param2", 1);
                TiebaStatic.log(akVar);
                this.dIs.gvW = "auto_midpage";
                this.dIs.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dIs.gvY = "1";
                this.dIt.gvW = "auto_midpage";
                this.dIt.mLocate = "auto_midpage";
                this.dIt.gvY = "1";
            } else {
                this.dIs.gvY = "frs_bavideotab";
                this.dIs.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dIt.gvY = "frs_bavideotab";
                this.dIt.mLocate = "frs_bavideotab";
            }
            if (fVar.dIR != null) {
                this.dIs.gwa = fVar.dIR.videoMd5;
                this.dIt.gwa = fVar.dIR.videoMd5;
            }
            this.cba.setVideoStatsData(this.dIs);
            this.dIp.getVideoView().setBusiness(this.cba);
            this.dIp.aQz();
            this.dIp.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.frs.aggregation.a.4
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void gc(boolean z) {
                    if (!a.this.dIp.bkW()) {
                        a.this.dIe.setVisibility(0);
                    } else if (z) {
                        if (a.this.dIe.getVisibility() == 0) {
                            a.this.dIe.setVisibility(8);
                            a.this.dIe.startAnimation(a.this.dIw);
                        }
                    } else if (a.this.dIe.getVisibility() == 8) {
                        a.this.dIe.setVisibility(0);
                        a.this.dIe.startAnimation(a.this.dIx);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awF() {
                    if (!a.this.dIp.bkW()) {
                        a.this.dIe.setVisibility(0);
                    } else if (a.this.dIe.getVisibility() == 0) {
                        a.this.dIe.setVisibility(8);
                        a.this.dIe.startAnimation(a.this.dIw);
                    }
                }
            });
            this.dIp.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.a.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    if (a.this.isFullScreen) {
                        a.this.dIv = true;
                        a.this.dIu = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.nd(i);
                        a.this.dIp.aDC();
                    }
                }
            });
            this.dIp.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.a.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (a.this.dIq != null && a.this.dIq.dIR != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dIq.dIR.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dIp.ov(fVar.dIR.thumbnailUrl);
            this.dIp.bK(fVar.dIR.videoUrl, fVar.threadId);
            this.dIp.rg(fVar.title);
            this.dIp.a(new c.g() { // from class: com.baidu.tieba.frs.aggregation.a.7
                @Override // com.baidu.tieba.play.c.g
                public void awG() {
                    a.this.dIf.setVisibility(8);
                }
            });
            this.dIp.aDC();
            this.dIp.show();
            if (fVar.autoPlay) {
                onClick(this.dId);
                this.dIv = false;
                this.dIp.a(fVar.dIR.videoUrl, fVar.threadId, null, new Object[0]);
            }
            this.dIv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.dIq != null && this.dIq.dIR != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dIq.dIR.videoMd5, "", str, this.dIt);
            }
        }
    }

    public boolean isPlaying() {
        return this.dIp.bkW();
    }

    public void awx() {
        if (isPlaying()) {
            this.dIp.pausePlay();
        }
    }

    public boolean nc(int i) {
        return this.dIp.tP(i);
    }

    public void awy() {
        this.dIg.setVisibility(8);
        this.dIp.stopPlay();
        if (this.dIe != null) {
            this.dIe.setVisibility(0);
        }
        if (this.dIf != null) {
            this.dIf.setVisibility(0);
        }
    }

    public void awz() {
        if (this.dIp != null) {
            this.dIp.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awz();
        if (this.dIr != null) {
            this.dIr.awP();
        }
    }

    public String lM(String str) {
        if (str.indexOf(com.baidu.ar.util.Constants.DOT) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(f fVar) {
        if (fVar != null && fVar.dIQ != null) {
            this.bdY.setText(TextUtils.isEmpty(fVar.dIQ.userNickname) ? fVar.dIQ.userName : fVar.dIQ.userNickname);
            this.cGk.startLoad(fVar.dIQ.portrait, 12, false);
            this.cGk.setShowV(fVar.dIQ.isGod);
            this.cGk.setIsBigV(fVar.dIQ.isGod);
            c(fVar);
            d(fVar);
            e(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null && fVar.dIQ != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(fVar.dIQ.userId) && TbadkCoreApplication.getCurrentAccount().equals(fVar.dIQ.userId)) {
                this.cuG.setVisibility(8);
            } else {
                this.cuG.setVisibility(0);
            }
            if (fVar.dIQ.hasFocus) {
                aj.r(this.cuG, d.C0140d.cp_cont_d);
                this.cuG.setCompoundDrawables(null, null, null, null);
                this.cuG.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                return;
            }
            aj.r(this.cuG, d.C0140d.cp_link_tip_a);
            Drawable drawable = aj.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.t(this.mContext, d.e.ds20), l.t(this.mContext, d.e.ds20));
            this.cuG.setCompoundDrawables(drawable, null, null, null);
            this.cuG.setText(this.mPageContext.getString(d.j.attention));
        }
    }

    public void d(f fVar) {
        if (fVar != null) {
            if (fVar.hasAgree) {
                this.dIm.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_s));
                aj.r(this.dIk, d.C0140d.cp_cont_h);
            } else {
                this.dIm.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_n));
                aj.r(this.dIk, d.C0140d.cp_cont_f);
            }
            this.dIk.setText(am.J(fVar.agreeNum));
        }
    }

    public void e(f fVar) {
        if (fVar != null) {
            aj.r(this.dIj, d.C0140d.cp_cont_f);
            this.dIl.setImageDrawable(aj.getDrawable(d.f.icon_home_card_comment));
            this.dIj.setText(am.J(fVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dIp != null && this.dId != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dIu) {
                this.dIp.bkV();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dId.getParent() != null) {
                    if (this.dId.getParent() == frameLayout) {
                        frameLayout.removeView(this.dId);
                    } else if (this.dId.getParent() == this.dIc) {
                        this.dIc.removeView(this.dId);
                    }
                }
                if (this.dId.getParent() == null) {
                    frameLayout.addView(this.dId);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dId.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dId.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dId.getParent() != null) {
                    if (this.dId.getParent() == frameLayout) {
                        frameLayout.removeView(this.dId);
                    } else if (this.dId.getParent() == this.dIc) {
                        this.dIc.removeView(this.dId);
                    }
                }
                if (this.dId.getParent() == null) {
                    this.dIc.addView(this.dId, 0);
                    this.dId.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dIp.aQz();
                    this.dIu = true;
                } else {
                    return;
                }
            }
            this.dIp.a(this.mPageContext, configuration);
            this.dIf.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akP() != null) {
            view.setTag(this);
            akP().a(view, this.dIq);
        }
        if (view == this.cGk || view == this.bdY) {
            boolean z = false;
            if (this.dIq != null && this.dIq.dIQ != null && !TextUtils.isEmpty(this.dIq.dIQ.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dIq.dIQ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dIq.dIQ.userId, 0L), z, this.dIq.dIQ.isGod)));
            }
        } else if (view == this.dIn || view == this.dIe || view == getView()) {
            if (this.dIq != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dIq.threadId, null, null);
                if (!this.dIz) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dIi) {
            if (this.dIq != null && this.dIq.dIR != null) {
                this.dIg.setVisibility(8);
                this.dIp.bkY();
                this.dIp.bL(this.dIq.dIR.videoUrl, this.dIq.threadId);
                lL("2");
            }
        } else if (view == this.cuG) {
            if (!this.dIq.dIQ.hasFocus) {
                this.dIr.f(this.dIq);
            }
        } else if (view == this.dIo) {
            this.dIr.g(this.dIq);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void ga(boolean z) {
        if (this.dIq != null && this.dIq.dIQ != null) {
            this.dIq.dIQ.hasFocus = z;
            c(this.dIq);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void awA() {
        if (this.dIq != null) {
            this.dIq.hasAgree = !this.dIq.hasAgree;
            if (this.dIq.hasAgree) {
                this.dIq.agreeNum++;
            } else {
                this.dIq.agreeNum--;
            }
            if (this.dIm != null) {
                this.dIm.startAnimation(getScaleAnimation());
            }
            d(this.dIq);
        }
    }

    private Animation getScaleAnimation() {
        if (this.bdU == null) {
            this.bdU = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdU.setDuration(200L);
        }
        return this.bdU;
    }
}
