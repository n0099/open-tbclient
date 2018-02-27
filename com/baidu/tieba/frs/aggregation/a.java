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
    private ScaleAnimation bdI;
    public TextView bdM;
    public HeadImageView cFY;
    private n caO;
    public TextView cuu;
    public FrameLayout dHQ;
    public FrameLayout dHR;
    public TextView dHS;
    public TextView dHT;
    public FrameLayout dHU;
    public TextView dHV;
    public TextView dHW;
    public TextView dHX;
    public TextView dHY;
    public ImageView dHZ;
    public ImageView dIa;
    public LinearLayout dIb;
    public LinearLayout dIc;
    public com.baidu.tieba.play.c dId;
    public f dIe;
    private h dIf;
    private aa dIg;
    private aa dIh;
    private boolean dIi;
    private boolean dIj;
    private Animation dIk;
    private Animation dIl;
    private boolean dIm;
    private boolean dIn;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dIi = true;
        this.dIn = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dHQ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dHR = (FrameLayout) view.findViewById(d.g.video_container);
        this.dId = new com.baidu.tieba.play.c(tbPageContext, this.dHR, false);
        this.dHS = (TextView) view.findViewById(d.g.title);
        this.dHT = (TextView) view.findViewById(d.g.duration);
        this.dHU = (FrameLayout) view.findViewById(d.g.mobile_network_container);
        this.dHV = (TextView) view.findViewById(d.g.mobile_network_text);
        this.dHW = (TextView) view.findViewById(d.g.mobile_network_play);
        this.cFY = (HeadImageView) view.findViewById(d.g.user_icon);
        this.bdM = (TextView) view.findViewById(d.g.user_name);
        this.cuu = (TextView) view.findViewById(d.g.attention);
        this.dIb = (LinearLayout) view.findViewById(d.g.thread_info_commont_container);
        this.dIc = (LinearLayout) view.findViewById(d.g.agree_view_container);
        this.dHX = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.dHY = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.dHZ = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.dIa = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.dIb.setOnClickListener(this);
        this.dIc.setOnClickListener(this);
        this.dHS.setOnClickListener(this);
        this.cFY.setOnClickListener(this);
        this.bdM.setOnClickListener(this);
        this.cuu.setOnClickListener(this);
        view.setOnClickListener(this);
        this.dHW.setOnClickListener(this);
        this.mWidth = l.ao(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dHQ.setLayoutParams(layoutParams);
        this.cFY.setIsRound(true);
        this.caO = new n(tbPageContext.getPageActivity());
        this.dIf = new h(this.mPageContext, this);
        this.dIk = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_200);
        this.dIl = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().aQ(i == 1);
            tbPageContext.getLayoutMode().aM(getView());
            aj.t(getView(), d.C0141d.cp_bg_line_d);
            if (this.dIe != null && this.dIe.dIE != null) {
                if (this.dIe.dIE.hasFocus) {
                    aj.r(this.cuu, d.C0141d.cp_cont_d);
                    this.cuu.setCompoundDrawables(null, null, null, null);
                } else {
                    aj.r(this.cuu, d.C0141d.cp_link_tip_a);
                    Drawable drawable = aj.getDrawable(d.f.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.t(this.mContext, d.e.ds20), l.t(this.mContext, d.e.ds20));
                    this.cuu.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.dIe != null) {
                if (this.dIe.hasAgree) {
                    this.dIa.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_s));
                    aj.r(this.dHY, d.C0141d.cp_cont_h);
                } else {
                    this.dIa.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_n));
                    aj.r(this.dHY, d.C0141d.cp_cont_f);
                }
            }
            aj.r(this.dHX, d.C0141d.cp_cont_f);
            this.dHZ.setImageDrawable(aj.getDrawable(d.f.icon_home_card_comment));
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
        if (fVar != null && fVar.dIF != null) {
            this.dIe = fVar;
            this.dIm = this.dIe.autoPlay;
            this.dHS.setVisibility(0);
            this.dHS.setText(fVar.title);
            this.dHT.setVisibility(0);
            this.dHT.setText(am.fV(fVar.dIF.videoDuration * 1000));
            if (fVar.dIF.videoSize == 0) {
                format = this.mPageContext.getString(d.j.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(d.j.video_mobile_network_tips), lM(String.format("%.1f", Float.valueOf(((float) fVar.dIF.videoSize) / 1048576.0f))));
            }
            this.dHV.setText(format);
            this.dHU.setVisibility(8);
            b(fVar, i, aVar);
            b(fVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(f fVar, final int i, final d.a aVar) {
        if (fVar != null && fVar.dIF != null) {
            this.dId.stopPlay();
            this.dId.lI(true);
            this.dId.lL(true);
            this.dId.lJ(false);
            this.dId.a(new c.b() { // from class: com.baidu.tieba.frs.aggregation.a.1
                @Override // com.baidu.tieba.play.c.b
                public void awA() {
                    if (a.this.dId.bkV()) {
                        a.this.dHT.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.b
                public void awB() {
                    if (a.this.dId.bkV()) {
                        a.this.dHT.setVisibility(8);
                    }
                    if (a.this.dIj) {
                        a.this.dId.stopPlay();
                    }
                }
            });
            this.dId.a(new c.j() { // from class: com.baidu.tieba.frs.aggregation.a.2
                @Override // com.baidu.tieba.play.c.j
                public void awC() {
                    a.this.dIj = false;
                    a.this.dHT.setVisibility(8);
                    a.this.lL(a.this.dIm ? "1" : "2");
                    a.this.onClick(a.this.dHR);
                }

                @Override // com.baidu.tieba.play.c.j
                public void awD() {
                    a.this.dHT.setVisibility(8);
                    a.this.onClick(a.this.dHQ);
                }
            });
            this.dId.a(new c.e() { // from class: com.baidu.tieba.frs.aggregation.a.3
                @Override // com.baidu.tieba.play.c.e
                public void gb(boolean z) {
                    if (z) {
                        a.this.mPageContext.showToast(a.this.dHV.getText().toString());
                        a.this.dId.bL(a.this.dIe.dIF.videoUrl, a.this.dIe.threadId);
                        a.this.dHT.setVisibility(8);
                        a.this.lL("2");
                    } else {
                        a.this.dHU.setVisibility(0);
                    }
                    a.this.onClick(a.this.dHR);
                }
            });
            this.dId.lG(false);
            this.dIg = new aa();
            this.dIg.bCS = fVar.threadId;
            this.dIg.cZI = fVar.forumId;
            this.dIg.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dIh = new aa();
            this.dIh.bCS = fVar.threadId;
            this.dIh.cZI = fVar.forumId;
            this.dIh.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dIn) {
                ak akVar = new ak("c12590");
                akVar.ab("tid", fVar.threadId);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                akVar.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                akVar.s("obj_locate", i);
                akVar.s("obj_param2", 1);
                TiebaStatic.log(akVar);
                this.dIg.gvL = "auto_midpage";
                this.dIg.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dIg.gvN = "1";
                this.dIh.gvL = "auto_midpage";
                this.dIh.mLocate = "auto_midpage";
                this.dIh.gvN = "1";
            } else {
                this.dIg.gvN = "frs_bavideotab";
                this.dIg.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.dIh.gvN = "frs_bavideotab";
                this.dIh.mLocate = "frs_bavideotab";
            }
            if (fVar.dIF != null) {
                this.dIg.gvP = fVar.dIF.videoMd5;
                this.dIh.gvP = fVar.dIF.videoMd5;
            }
            this.caO.setVideoStatsData(this.dIg);
            this.dId.getVideoView().setBusiness(this.caO);
            this.dId.aQy();
            this.dId.b(new c.InterfaceC0219c() { // from class: com.baidu.tieba.frs.aggregation.a.4
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void gc(boolean z) {
                    if (!a.this.dId.bkV()) {
                        a.this.dHS.setVisibility(0);
                    } else if (z) {
                        if (a.this.dHS.getVisibility() == 0) {
                            a.this.dHS.setVisibility(8);
                            a.this.dHS.startAnimation(a.this.dIk);
                        }
                    } else if (a.this.dHS.getVisibility() == 8) {
                        a.this.dHS.setVisibility(0);
                        a.this.dHS.startAnimation(a.this.dIl);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void awE() {
                    if (!a.this.dId.bkV()) {
                        a.this.dHS.setVisibility(0);
                    } else if (a.this.dHS.getVisibility() == 0) {
                        a.this.dHS.setVisibility(8);
                        a.this.dHS.startAnimation(a.this.dIk);
                    }
                }
            });
            this.dId.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.a.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    if (a.this.isFullScreen) {
                        a.this.dIj = true;
                        a.this.dIi = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.nd(i);
                        a.this.dId.aDB();
                    }
                }
            });
            this.dId.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.a.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (a.this.dIe != null && a.this.dIe.dIF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dIe.dIF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dId.ov(fVar.dIF.thumbnailUrl);
            this.dId.bK(fVar.dIF.videoUrl, fVar.threadId);
            this.dId.rg(fVar.title);
            this.dId.a(new c.g() { // from class: com.baidu.tieba.frs.aggregation.a.7
                @Override // com.baidu.tieba.play.c.g
                public void awF() {
                    a.this.dHT.setVisibility(8);
                }
            });
            this.dId.aDB();
            this.dId.show();
            if (fVar.autoPlay) {
                onClick(this.dHR);
                this.dIj = false;
                this.dId.a(fVar.dIF.videoUrl, fVar.threadId, null, new Object[0]);
            }
            this.dIj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.dIe != null && this.dIe.dIF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dIe.dIF.videoMd5, "", str, this.dIh);
            }
        }
    }

    public boolean isPlaying() {
        return this.dId.bkV();
    }

    public void aww() {
        if (isPlaying()) {
            this.dId.pausePlay();
        }
    }

    public boolean nc(int i) {
        return this.dId.tQ(i);
    }

    public void awx() {
        this.dHU.setVisibility(8);
        this.dId.stopPlay();
        if (this.dHS != null) {
            this.dHS.setVisibility(0);
        }
        if (this.dHT != null) {
            this.dHT.setVisibility(0);
        }
    }

    public void awy() {
        if (this.dId != null) {
            this.dId.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awy();
        if (this.dIf != null) {
            this.dIf.awO();
        }
    }

    public String lM(String str) {
        if (str.indexOf(com.baidu.ar.util.Constants.DOT) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(f fVar) {
        if (fVar != null && fVar.dIE != null) {
            this.bdM.setText(TextUtils.isEmpty(fVar.dIE.userNickname) ? fVar.dIE.userName : fVar.dIE.userNickname);
            this.cFY.startLoad(fVar.dIE.portrait, 12, false);
            this.cFY.setShowV(fVar.dIE.isGod);
            this.cFY.setIsBigV(fVar.dIE.isGod);
            c(fVar);
            d(fVar);
            e(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null && fVar.dIE != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(fVar.dIE.userId) && TbadkCoreApplication.getCurrentAccount().equals(fVar.dIE.userId)) {
                this.cuu.setVisibility(8);
            } else {
                this.cuu.setVisibility(0);
            }
            if (fVar.dIE.hasFocus) {
                aj.r(this.cuu, d.C0141d.cp_cont_d);
                this.cuu.setCompoundDrawables(null, null, null, null);
                this.cuu.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                return;
            }
            aj.r(this.cuu, d.C0141d.cp_link_tip_a);
            Drawable drawable = aj.getDrawable(d.f.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.t(this.mContext, d.e.ds20), l.t(this.mContext, d.e.ds20));
            this.cuu.setCompoundDrawables(drawable, null, null, null);
            this.cuu.setText(this.mPageContext.getString(d.j.attention));
        }
    }

    public void d(f fVar) {
        if (fVar != null) {
            if (fVar.hasAgree) {
                this.dIa.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_s));
                aj.r(this.dHY, d.C0141d.cp_cont_h);
            } else {
                this.dIa.setImageDrawable(aj.getDrawable(d.f.icon_home_card_like_n));
                aj.r(this.dHY, d.C0141d.cp_cont_f);
            }
            this.dHY.setText(am.J(fVar.agreeNum));
        }
    }

    public void e(f fVar) {
        if (fVar != null) {
            aj.r(this.dHX, d.C0141d.cp_cont_f);
            this.dHZ.setImageDrawable(aj.getDrawable(d.f.icon_home_card_comment));
            this.dHX.setText(am.J(fVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dId != null && this.dHR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dIi) {
                this.dId.bkU();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.dHR.getParent() != null) {
                    if (this.dHR.getParent() == frameLayout) {
                        frameLayout.removeView(this.dHR);
                    } else if (this.dHR.getParent() == this.dHQ) {
                        this.dHQ.removeView(this.dHR);
                    }
                }
                if (this.dHR.getParent() == null) {
                    frameLayout.addView(this.dHR);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dHR.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.dHR.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.dHR.getParent() != null) {
                    if (this.dHR.getParent() == frameLayout) {
                        frameLayout.removeView(this.dHR);
                    } else if (this.dHR.getParent() == this.dHQ) {
                        this.dHQ.removeView(this.dHR);
                    }
                }
                if (this.dHR.getParent() == null) {
                    this.dHQ.addView(this.dHR, 0);
                    this.dHR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.dId.aQy();
                    this.dIi = true;
                } else {
                    return;
                }
            }
            this.dId.a(this.mPageContext, configuration);
            this.dHT.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akO() != null) {
            view.setTag(this);
            akO().a(view, this.dIe);
        }
        if (view == this.cFY || view == this.bdM) {
            boolean z = false;
            if (this.dIe != null && this.dIe.dIE != null && !TextUtils.isEmpty(this.dIe.dIE.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dIe.dIE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dIe.dIE.userId, 0L), z, this.dIe.dIE.isGod)));
            }
        } else if (view == this.dIb || view == this.dHS || view == getView()) {
            if (this.dIe != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dIe.threadId, null, null);
                if (!this.dIn) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dHW) {
            if (this.dIe != null && this.dIe.dIF != null) {
                this.dHU.setVisibility(8);
                this.dId.bkX();
                this.dId.bL(this.dIe.dIF.videoUrl, this.dIe.threadId);
                lL("2");
            }
        } else if (view == this.cuu) {
            if (!this.dIe.dIE.hasFocus) {
                this.dIf.f(this.dIe);
            }
        } else if (view == this.dIc) {
            this.dIf.g(this.dIe);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void ga(boolean z) {
        if (this.dIe != null && this.dIe.dIE != null) {
            this.dIe.dIE.hasFocus = z;
            c(this.dIe);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void awz() {
        if (this.dIe != null) {
            this.dIe.hasAgree = !this.dIe.hasAgree;
            if (this.dIe.hasAgree) {
                this.dIe.agreeNum++;
            } else {
                this.dIe.agreeNum--;
            }
            if (this.dIa != null) {
                this.dIa.startAnimation(getScaleAnimation());
            }
            d(this.dIe);
        }
    }

    private Animation getScaleAnimation() {
        if (this.bdI == null) {
            this.bdI = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdI.setDuration(200L);
        }
        return this.bdI;
    }
}
