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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView ajz;
    private Animation bWB;
    private boolean eIq;
    public FrameLayout iOW;
    public FrameLayout iOX;
    public TextView iOY;
    public TextView iOZ;
    public FrameLayout iPa;
    public TextView iPb;
    public TextView iPc;
    public HeadImageView iPd;
    public TextView iPe;
    public TextView iPf;
    public TextView iPg;
    public ImageView iPh;
    public ImageView iPi;
    public LinearLayout iPj;
    public LinearLayout iPk;
    public com.baidu.tieba.play.c iPl;
    public g iPm;
    private h iPn;
    private o iPo;
    private o iPp;
    private boolean iPq;
    private boolean iPr;
    private Animation iPs;
    private ScaleAnimation iPt;
    private boolean iPu;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.iPq = true;
        this.iPu = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iOW = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.iOX = (FrameLayout) view.findViewById(R.id.video_container);
        this.iPl = new com.baidu.tieba.play.c(tbPageContext, this.iOX, false);
        this.iPl.setStageType("2005");
        this.iOY = (TextView) view.findViewById(R.id.title);
        this.iOZ = (TextView) view.findViewById(R.id.duration);
        this.iPa = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.iPb = (TextView) view.findViewById(R.id.mobile_network_text);
        this.iPc = (TextView) view.findViewById(R.id.mobile_network_play);
        this.iPd = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajz = (TextView) view.findViewById(R.id.user_name);
        this.iPe = (TextView) view.findViewById(R.id.attention);
        this.iPj = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.iPk = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.iPf = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.iPg = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.iPh = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.iPi = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.iPj.setOnClickListener(this);
        this.iPk.setOnClickListener(this);
        this.iOY.setOnClickListener(this);
        this.iPd.setOnClickListener(this);
        this.ajz.setOnClickListener(this);
        this.iPe.setOnClickListener(this);
        view.setOnClickListener(this);
        this.iPc.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iOW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iOW.setLayoutParams(layoutParams);
        this.iPd.setIsRound(true);
        this.iPn = new h(this.mPageContext, this);
        this.iPs = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bWB = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.iPm != null && this.iPm.iPL != null) {
                if (this.iPm.iPL.hasFocus) {
                    ap.setViewTextColor(this.iPe, (int) R.color.CAM_X0109);
                    this.iPe.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.iPe, (int) R.color.CAM_X0302);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.iPe.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.iPm != null) {
                if (this.iPm.hasAgree) {
                    this.iPi.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.iPg, (int) R.color.CAM_X0301);
                } else {
                    this.iPi.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.iPg, (int) R.color.CAM_X0106);
                }
            }
            ap.setViewTextColor(this.iPf, (int) R.color.CAM_X0106);
            this.iPh.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.iPM != null) {
            this.iPm = gVar;
            this.eIq = this.iPm.autoPlay;
            this.iOY.setVisibility(0);
            this.iOY.setText(gVar.title);
            this.iOZ.setVisibility(0);
            this.iOZ.setText(au.stringForVideoTime(gVar.iPM.videoDuration * 1000));
            if (gVar.iPM.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), JX(String.format("%.1f", Float.valueOf(((float) gVar.iPM.videoSize) / 1048576.0f))));
            }
            this.iPb.setText(format);
            this.iPa.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.iPM != null) {
            this.iPl.stopPlay();
            this.iPl.wt(true);
            this.iPl.wp(false);
            this.iPl.a(new c.InterfaceC0829c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rI() {
                    if (b.this.iPl.rK()) {
                        b.this.iOZ.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rJ() {
                    if (b.this.iPl.rK()) {
                        b.this.iOZ.setVisibility(8);
                    }
                    if (b.this.iPr) {
                        b.this.iPl.stopPlay();
                    }
                }
            });
            this.iPl.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cAI() {
                    b.this.iPr = false;
                    b.this.iOZ.setVisibility(8);
                    b.this.JW(b.this.eIq ? "1" : "2");
                    b.this.onClick(b.this.iOX);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cAJ() {
                    b.this.iOZ.setVisibility(8);
                    b.this.onClick(b.this.iOW);
                }
            });
            this.iPl.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void pW(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.iPb.getText().toString());
                        b.this.iPl.fW(b.this.iPm.iPM.videoUrl, b.this.iPm.threadId);
                        b.this.iOZ.setVisibility(8);
                        b.this.JW("2");
                    } else {
                        b.this.iPa.setVisibility(0);
                    }
                    b.this.onClick(b.this.iOX);
                }
            });
            this.iPl.wl(false);
            this.iPo = new o();
            this.iPo.alZ = gVar.threadId;
            this.iPo.fyg = gVar.forumId;
            this.iPo.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iPp = new o();
            this.iPp.alZ = gVar.threadId;
            this.iPp.fyg = gVar.forumId;
            this.iPp.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.iPu) {
                ar arVar = new ar("c12590");
                arVar.dR("tid", gVar.threadId);
                arVar.dR("nid", gVar.nid);
                arVar.ak("obj_param5", gVar.getVideoType());
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("fid", gVar.forumId);
                arVar.ak("obj_locate", i);
                arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(arVar);
                this.iPo.mkk = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iPo.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.iPo.mkm = "1";
                this.iPp.mkk = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iPp.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iPp.mkm = "1";
            } else {
                this.iPo.mkm = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iPo.mLocate = "12";
                this.iPp.mkm = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iPp.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.iPM != null) {
                this.iPo.mkp = gVar.iPM.videoMd5;
                this.iPp.mkp = gVar.iPM.videoMd5;
            }
            this.iPl.getVideoView().setVideoStatData(this.iPo);
            this.iPl.cZk();
            this.iPl.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void pX(boolean z) {
                    if (!b.this.iPl.rK()) {
                        b.this.iOY.setVisibility(0);
                    } else if (z) {
                        if (b.this.iOY.getVisibility() == 0) {
                            b.this.iOY.setVisibility(8);
                            b.this.iOY.startAnimation(b.this.iPs);
                        }
                    } else if (b.this.iOY.getVisibility() == 8) {
                        b.this.iOY.setVisibility(0);
                        b.this.iOY.startAnimation(b.this.bWB);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cAK() {
                    if (!b.this.iPl.rK()) {
                        b.this.iOY.setVisibility(0);
                    } else if (b.this.iOY.getVisibility() == 0) {
                        b.this.iOY.setVisibility(8);
                        b.this.iOY.startAnimation(b.this.iPs);
                    }
                }
            });
            this.iPl.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.iPr = true;
                        b.this.iPq = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.zJ(i);
                        b.this.iPl.cMa();
                    }
                }
            });
            this.iPl.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.iPm != null && b.this.iPm.iPM != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.iPm.iPM.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.iPl.setThumbnail(gVar.iPM.thumbnailUrl);
            this.iPl.setVideoUrl(gVar.iPM.videoUrl, gVar.threadId);
            this.iPl.Qe(gVar.title);
            this.iPl.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cAL() {
                    b.this.iOZ.setVisibility(8);
                }
            });
            this.iPl.cMa();
            this.iPl.show();
            if (gVar.autoPlay) {
                onClick(this.iOX);
                this.iPr = false;
                this.iPl.a(gVar.iPM.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.iPr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JW(String str) {
        if (this.iPm != null && this.iPm.iPM != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iPm.iPM.videoMd5, "", str, this.iPp, this.iPl.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.iPl.rK();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iPl.aPd();
        }
    }

    public boolean zK(int i) {
        return this.iPl.HO(i);
    }

    public void cAF() {
        this.iPa.setVisibility(8);
        this.iPl.stopPlay();
        if (this.iOY != null) {
            this.iOY.setVisibility(0);
        }
        if (this.iOZ != null) {
            this.iOZ.setVisibility(0);
        }
    }

    public void cAG() {
        if (this.iPl != null) {
            this.iPl.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cAG();
        if (this.iPn != null) {
            this.iPn.cAQ();
        }
    }

    public String JX(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.iPL != null) {
            this.ajz.setText(TextUtils.isEmpty(gVar.iPL.userNickname) ? gVar.iPL.userName : gVar.iPL.userNickname);
            this.iPd.startLoad(gVar.iPL.portrait, 12, false);
            this.iPd.setShowV(gVar.iPL.isGod);
            this.iPd.setIsBigV(gVar.iPL.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.iPL != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.iPL.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.iPL.userId)) {
                this.iPe.setVisibility(8);
            } else {
                this.iPe.setVisibility(0);
            }
            if (gVar.iPL.hasFocus) {
                ap.setViewTextColor(this.iPe, (int) R.color.CAM_X0109);
                this.iPe.setCompoundDrawables(null, null, null, null);
                this.iPe.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.iPe, (int) R.color.CAM_X0302);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.iPe.setCompoundDrawables(drawable, null, null, null);
            this.iPe.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.iPi.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.iPg, (int) R.color.CAM_X0301);
            } else {
                this.iPi.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.iPg, (int) R.color.CAM_X0106);
            }
            this.iPg.setText(au.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.iPf, (int) R.color.CAM_X0106);
            this.iPh.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.iPf.setText(au.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iPl != null && this.iOX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iPq) {
                this.iPl.dwe();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.iOX.getParent() != null) {
                    if (this.iOX.getParent() == frameLayout) {
                        frameLayout.removeView(this.iOX);
                    } else if (this.iOX.getParent() == this.iOW) {
                        this.iOW.removeView(this.iOX);
                    }
                }
                if (this.iOX.getParent() == null) {
                    frameLayout.addView(this.iOX);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iOX.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.iOX.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.iOX.getParent() != null) {
                    if (this.iOX.getParent() == frameLayout) {
                        frameLayout.removeView(this.iOX);
                    } else if (this.iOX.getParent() == this.iOW) {
                        this.iOW.removeView(this.iOX);
                    }
                }
                if (this.iOX.getParent() == null) {
                    this.iOW.addView(this.iOX, 0);
                    this.iOX.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.iPl.cZk();
                    this.iPq = true;
                } else {
                    return;
                }
            }
            this.iPl.a(this.mPageContext, configuration);
            this.iOZ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            view.setTag(this);
            cnv().a(view, this.iPm);
        }
        if (view == this.iPd || view == this.ajz) {
            boolean z = false;
            if (this.iPm != null && this.iPm.iPL != null && !TextUtils.isEmpty(this.iPm.iPL.userId)) {
                if (TbadkCoreApplication.isLogin() && this.iPm.iPL.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iPm.iPL.userId, 0L), z, this.iPm.iPL.isGod)));
            }
        } else if (view == this.iPj || view == this.iOY || view == getView()) {
            if (this.iPm != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iPm.threadId, null, null);
                if (!this.iPu) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.iPc) {
            if (this.iPm != null && this.iPm.iPM != null) {
                this.iPa.setVisibility(8);
                this.iPl.dwh();
                this.iPl.fW(this.iPm.iPM.videoUrl, this.iPm.threadId);
                JW("2");
            }
        } else if (view == this.iPe) {
            if (!this.iPm.iPL.hasFocus) {
                this.iPn.f(this.iPm);
            }
        } else if (view == this.iPk) {
            this.iPn.g(this.iPm);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pV(boolean z) {
        if (this.iPm != null && this.iPm.iPL != null) {
            this.iPm.iPL.hasFocus = z;
            c(this.iPm);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cAH() {
        if (this.iPm != null) {
            this.iPm.hasAgree = !this.iPm.hasAgree;
            if (this.iPm.hasAgree) {
                this.iPm.agreeNum++;
            } else {
                this.iPm.agreeNum--;
            }
            if (this.iPi != null) {
                this.iPi.startAnimation(getScaleAnimation());
            }
            d(this.iPm);
        }
    }

    private Animation getScaleAnimation() {
        if (this.iPt == null) {
            this.iPt = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.iPt.setDuration(200L);
        }
        return this.iPt;
    }
}
