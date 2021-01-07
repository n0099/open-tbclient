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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView ala;
    private Animation ciB;
    private boolean eZA;
    private boolean isFullScreen;
    private boolean jmA;
    public FrameLayout jmb;
    public FrameLayout jmc;
    public TextView jmd;
    public TextView jme;
    public FrameLayout jmf;
    public TextView jmg;
    public TextView jmh;
    public HeadImageView jmi;
    public TextView jmj;
    public TextView jmk;
    public TextView jml;
    public ImageView jmm;
    public ImageView jmn;
    public LinearLayout jmo;
    public LinearLayout jmq;
    public com.baidu.tieba.play.c jmr;
    public g jms;
    private h jmt;
    private o jmu;
    private o jmv;
    private boolean jmw;
    private boolean jmx;
    private Animation jmy;
    private ScaleAnimation jmz;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.jmw = true;
        this.jmA = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jmb = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jmc = (FrameLayout) view.findViewById(R.id.video_container);
        this.jmr = new com.baidu.tieba.play.c(tbPageContext, this.jmc, false);
        this.jmr.setStageType("2005");
        this.jmd = (TextView) view.findViewById(R.id.title);
        this.jme = (TextView) view.findViewById(R.id.duration);
        this.jmf = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.jmg = (TextView) view.findViewById(R.id.mobile_network_text);
        this.jmh = (TextView) view.findViewById(R.id.mobile_network_play);
        this.jmi = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ala = (TextView) view.findViewById(R.id.user_name);
        this.jmj = (TextView) view.findViewById(R.id.attention);
        this.jmo = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.jmq = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.jmk = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jml = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.jmm = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jmn = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.jmo.setOnClickListener(this);
        this.jmq.setOnClickListener(this);
        this.jmd.setOnClickListener(this);
        this.jmi.setOnClickListener(this);
        this.ala.setOnClickListener(this);
        this.jmj.setOnClickListener(this);
        view.setOnClickListener(this);
        this.jmh.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jmb.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jmb.setLayoutParams(layoutParams);
        this.jmi.setIsRound(true);
        this.jmt = new h(this.mPageContext, this);
        this.jmy = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.ciB = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ao.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.jms != null && this.jms.jmR != null) {
                if (this.jms.jmR.hasFocus) {
                    ao.setViewTextColor(this.jmj, R.color.CAM_X0109);
                    this.jmj.setCompoundDrawables(null, null, null, null);
                } else {
                    ao.setViewTextColor(this.jmj, R.color.CAM_X0302);
                    Drawable drawable = ao.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.jmj.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.jms != null) {
                if (this.jms.hasAgree) {
                    this.jmn.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                    ao.setViewTextColor(this.jml, R.color.CAM_X0301);
                } else {
                    this.jmn.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                    ao.setViewTextColor(this.jml, R.color.CAM_X0106);
                }
            }
            ao.setViewTextColor(this.jmk, R.color.CAM_X0106);
            this.jmm.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.jmS != null) {
            this.jms = gVar;
            this.eZA = this.jms.autoPlay;
            this.jmd.setVisibility(0);
            this.jmd.setText(gVar.title);
            this.jme.setVisibility(0);
            this.jme.setText(at.stringForVideoTime(gVar.jmS.videoDuration * 1000));
            if (gVar.jmS.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), KM(String.format("%.1f", Float.valueOf(((float) gVar.jmS.videoSize) / 1048576.0f))));
            }
            this.jmg.setText(format);
            this.jmf.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.jmS != null) {
            this.jmr.stopPlay();
            this.jmr.wY(true);
            this.jmr.wU(false);
            this.jmr.a(new c.InterfaceC0862c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0862c
                public void rl() {
                    if (b.this.jmr.rn()) {
                        b.this.jme.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0862c
                public void rm() {
                    if (b.this.jmr.rn()) {
                        b.this.jme.setVisibility(8);
                    }
                    if (b.this.jmx) {
                        b.this.jmr.stopPlay();
                    }
                }
            });
            this.jmr.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cHU() {
                    b.this.jmx = false;
                    b.this.jme.setVisibility(8);
                    b.this.KL(b.this.eZA ? "1" : "2");
                    b.this.onClick(b.this.jmc);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cHV() {
                    b.this.jme.setVisibility(8);
                    b.this.onClick(b.this.jmb);
                }
            });
            this.jmr.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void qR(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.jmg.getText().toString());
                        b.this.jmr.fY(b.this.jms.jmS.videoUrl, b.this.jms.threadId);
                        b.this.jme.setVisibility(8);
                        b.this.KL("2");
                    } else {
                        b.this.jmf.setVisibility(0);
                    }
                    b.this.onClick(b.this.jmc);
                }
            });
            this.jmr.wQ(false);
            this.jmu = new o();
            this.jmu.anD = gVar.threadId;
            this.jmu.fPy = gVar.forumId;
            this.jmu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jmv = new o();
            this.jmv.anD = gVar.threadId;
            this.jmv.fPy = gVar.forumId;
            this.jmv.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.jmA) {
                aq aqVar = new aq("c12590");
                aqVar.dX("tid", gVar.threadId);
                aqVar.dX(IntentConfig.NID, gVar.nid);
                aqVar.an("obj_param5", gVar.getVideoType());
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dX("fid", gVar.forumId);
                aqVar.an("obj_locate", i);
                aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.jmu.mDG = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jmu.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.jmu.mDI = "1";
                this.jmv.mDG = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jmv.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jmv.mDI = "1";
            } else {
                this.jmu.mDI = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jmu.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.jmv.mDI = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jmv.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.jmS != null) {
                this.jmu.mDL = gVar.jmS.videoMd5;
                this.jmv.mDL = gVar.jmS.videoMd5;
            }
            this.jmr.getVideoView().setVideoStatData(this.jmu);
            this.jmr.dei();
            this.jmr.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void qS(boolean z) {
                    if (!b.this.jmr.rn()) {
                        b.this.jmd.setVisibility(0);
                    } else if (z) {
                        if (b.this.jmd.getVisibility() == 0) {
                            b.this.jmd.setVisibility(8);
                            b.this.jmd.startAnimation(b.this.jmy);
                        }
                    } else if (b.this.jmd.getVisibility() == 8) {
                        b.this.jmd.setVisibility(0);
                        b.this.jmd.startAnimation(b.this.ciB);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cHW() {
                    if (!b.this.jmr.rn()) {
                        b.this.jmd.setVisibility(0);
                    } else if (b.this.jmd.getVisibility() == 0) {
                        b.this.jmd.setVisibility(8);
                        b.this.jmd.startAnimation(b.this.jmy);
                    }
                }
            });
            this.jmr.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.jmx = true;
                        b.this.jmw = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.AA(i);
                        b.this.jmr.cUw();
                    }
                }
            });
            this.jmr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.jms != null && b.this.jms.jmS != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.jms.jmS.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.jmr.setThumbnail(gVar.jmS.thumbnailUrl);
            this.jmr.setVideoUrl(gVar.jmS.videoUrl, gVar.threadId);
            this.jmr.QS(gVar.title);
            this.jmr.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cHX() {
                    b.this.jme.setVisibility(8);
                }
            });
            this.jmr.cUw();
            this.jmr.show();
            if (gVar.autoPlay) {
                onClick(this.jmc);
                this.jmx = false;
                this.jmr.a(gVar.jmS.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.jmx = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KL(String str) {
        if (this.jms != null && this.jms.jmS != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jms.jmS.videoMd5, "", str, this.jmv, this.jmr.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.jmr.rn();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jmr.aUD();
        }
    }

    public boolean AB(int i) {
        return this.jmr.Iz(i);
    }

    public void stopVideo() {
        this.jmf.setVisibility(8);
        this.jmr.stopPlay();
        if (this.jmd != null) {
            this.jmd.setVisibility(0);
        }
        if (this.jme != null) {
            this.jme.setVisibility(0);
        }
    }

    public void cHS() {
        if (this.jmr != null) {
            this.jmr.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cHS();
        if (this.jmt != null) {
            this.jmt.cIc();
        }
    }

    public String KM(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.jmR != null) {
            this.ala.setText(TextUtils.isEmpty(gVar.jmR.userNickname) ? gVar.jmR.userName : gVar.jmR.userNickname);
            this.jmi.startLoad(gVar.jmR.portrait, 12, false);
            this.jmi.setShowV(gVar.jmR.isGod);
            this.jmi.setIsBigV(gVar.jmR.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.jmR != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.jmR.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.jmR.userId)) {
                this.jmj.setVisibility(8);
            } else {
                this.jmj.setVisibility(0);
            }
            if (gVar.jmR.hasFocus) {
                ao.setViewTextColor(this.jmj, R.color.CAM_X0109);
                this.jmj.setCompoundDrawables(null, null, null, null);
                this.jmj.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ao.setViewTextColor(this.jmj, R.color.CAM_X0302);
            Drawable drawable = ao.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.jmj.setCompoundDrawables(drawable, null, null, null);
            this.jmj.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.jmn.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                ao.setViewTextColor(this.jml, R.color.CAM_X0301);
            } else {
                this.jmn.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                ao.setViewTextColor(this.jml, R.color.CAM_X0106);
            }
            this.jml.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ao.setViewTextColor(this.jmk, R.color.CAM_X0106);
            this.jmm.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
            this.jmk.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jmr != null && this.jmc != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jmw) {
                this.jmr.dBn();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.jmc.getParent() != null) {
                    if (this.jmc.getParent() == frameLayout) {
                        frameLayout.removeView(this.jmc);
                    } else if (this.jmc.getParent() == this.jmb) {
                        this.jmb.removeView(this.jmc);
                    }
                }
                if (this.jmc.getParent() == null) {
                    frameLayout.addView(this.jmc);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jmc.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.jmc.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.jmc.getParent() != null) {
                    if (this.jmc.getParent() == frameLayout) {
                        frameLayout.removeView(this.jmc);
                    } else if (this.jmc.getParent() == this.jmb) {
                        this.jmb.removeView(this.jmc);
                    }
                }
                if (this.jmc.getParent() == null) {
                    this.jmb.addView(this.jmc, 0);
                    this.jmc.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.jmr.dei();
                    this.jmw = true;
                } else {
                    return;
                }
            }
            this.jmr.a(this.mPageContext, configuration);
            this.jme.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuD() != null) {
            view.setTag(this);
            cuD().a(view, this.jms);
        }
        if (view == this.jmi || view == this.ala) {
            boolean z = false;
            if (this.jms != null && this.jms.jmR != null && !TextUtils.isEmpty(this.jms.jmR.userId)) {
                if (TbadkCoreApplication.isLogin() && this.jms.jmR.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jms.jmR.userId, 0L), z, this.jms.jmR.isGod)));
            }
        } else if (view == this.jmo || view == this.jmd || view == getView()) {
            if (this.jms != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jms.threadId, null, null);
                if (!this.jmA) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jmh) {
            if (this.jms != null && this.jms.jmS != null) {
                this.jmf.setVisibility(8);
                this.jmr.dBq();
                this.jmr.fY(this.jms.jmS.videoUrl, this.jms.threadId);
                KL("2");
            }
        } else if (view == this.jmj) {
            if (!this.jms.jmR.hasFocus) {
                this.jmt.f(this.jms);
            }
        } else if (view == this.jmq) {
            com.baidu.tbadk.pageExtra.c ft = com.baidu.tbadk.pageExtra.d.ft(getContext());
            if (ft != null) {
                this.jms.objSource = ft.getCurrentPageKey();
            }
            this.jmt.g(this.jms);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qQ(boolean z) {
        if (this.jms != null && this.jms.jmR != null) {
            this.jms.jmR.hasFocus = z;
            c(this.jms);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cHT() {
        if (this.jms != null) {
            this.jms.hasAgree = !this.jms.hasAgree;
            if (this.jms.hasAgree) {
                this.jms.agreeNum++;
            } else {
                this.jms.agreeNum--;
            }
            if (this.jmn != null) {
                this.jmn.startAnimation(getScaleAnimation());
            }
            d(this.jms);
        }
    }

    private Animation getScaleAnimation() {
        if (this.jmz == null) {
            this.jmz = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.jmz.setDuration(200L);
        }
        return this.jmz;
    }
}
