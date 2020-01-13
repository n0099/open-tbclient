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
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView MK;
    private Animation aHr;
    private boolean cSi;
    public TextView eZN;
    private n egU;
    public FrameLayout grH;
    public FrameLayout grI;
    public TextView grJ;
    public TextView grK;
    public FrameLayout grL;
    public TextView grM;
    public TextView grN;
    public HeadImageView grO;
    public TextView grP;
    public TextView grQ;
    public ImageView grR;
    public ImageView grS;
    public LinearLayout grT;
    public LinearLayout grU;
    public com.baidu.tieba.play.c grV;
    public g grW;
    private h grX;
    private y grY;
    private y grZ;
    private boolean gsa;
    private boolean gsb;
    private Animation gsc;
    private ScaleAnimation gsd;
    private boolean gse;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gsa = true;
        this.gse = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.grH = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.grI = (FrameLayout) view.findViewById(R.id.video_container);
        this.grV = new com.baidu.tieba.play.c(tbPageContext, this.grI, false);
        this.grJ = (TextView) view.findViewById(R.id.title);
        this.grK = (TextView) view.findViewById(R.id.duration);
        this.grL = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.grM = (TextView) view.findViewById(R.id.mobile_network_text);
        this.grN = (TextView) view.findViewById(R.id.mobile_network_play);
        this.grO = (HeadImageView) view.findViewById(R.id.user_icon);
        this.MK = (TextView) view.findViewById(R.id.user_name);
        this.eZN = (TextView) view.findViewById(R.id.attention);
        this.grT = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.grU = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.grP = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.grQ = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.grR = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.grS = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.grT.setOnClickListener(this);
        this.grU.setOnClickListener(this);
        this.grJ.setOnClickListener(this);
        this.grO.setOnClickListener(this);
        this.MK.setOnClickListener(this);
        this.eZN.setOnClickListener(this);
        view.setOnClickListener(this);
        this.grN.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grH.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.grH.setLayoutParams(layoutParams);
        this.grO.setIsRound(true);
        this.egU = new n(tbPageContext.getPageActivity());
        this.grX = new h(this.mPageContext, this);
        this.gsc = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.aHr = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.grW != null && this.grW.gsv != null) {
                if (this.grW.gsv.hasFocus) {
                    am.setViewTextColor(this.eZN, (int) R.color.cp_cont_d);
                    this.eZN.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.eZN, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.eZN.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.grW != null) {
                if (this.grW.hasAgree) {
                    this.grS.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.grQ, (int) R.color.cp_cont_h);
                } else {
                    this.grS.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.grQ, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.grP, (int) R.color.cp_cont_f);
            this.grR.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.gsw != null) {
            this.grW = gVar;
            this.cSi = this.grW.autoPlay;
            this.grJ.setVisibility(0);
            this.grJ.setText(gVar.title);
            this.grK.setVisibility(0);
            this.grK.setText(aq.stringForVideoTime(gVar.gsw.videoDuration * 1000));
            if (gVar.gsw.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), AT(String.format("%.1f", Float.valueOf(((float) gVar.gsw.videoSize) / 1048576.0f))));
            }
            this.grM.setText(format);
            this.grL.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.gsw != null) {
            this.grV.stopPlay();
            this.grV.setIsNeedRecoveryVideoPlayer(true);
            this.grV.rI(true);
            this.grV.rE(false);
            this.grV.a(new c.InterfaceC0581c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kN() {
                    if (b.this.grV.kP()) {
                        b.this.grK.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kO() {
                    if (b.this.grV.kP()) {
                        b.this.grK.setVisibility(8);
                    }
                    if (b.this.gsb) {
                        b.this.grV.stopPlay();
                    }
                }
            });
            this.grV.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bEJ() {
                    b.this.gsb = false;
                    b.this.grK.setVisibility(8);
                    b.this.AS(b.this.cSi ? "1" : "2");
                    b.this.onClick(b.this.grI);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bEK() {
                    b.this.grK.setVisibility(8);
                    b.this.onClick(b.this.grH);
                }
            });
            this.grV.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void lE(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.grM.getText().toString());
                        b.this.grV.dZ(b.this.grW.gsw.videoUrl, b.this.grW.threadId);
                        b.this.grK.setVisibility(8);
                        b.this.AS("2");
                    } else {
                        b.this.grL.setVisibility(0);
                    }
                    b.this.onClick(b.this.grI);
                }
            });
            this.grV.rA(false);
            this.grY = new y();
            this.grY.OG = gVar.threadId;
            this.grY.fKa = gVar.forumId;
            this.grY.mUid = TbadkCoreApplication.getCurrentAccount();
            this.grZ = new y();
            this.grZ.OG = gVar.threadId;
            this.grZ.fKa = gVar.forumId;
            this.grZ.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.gse) {
                an anVar = new an("c12590");
                anVar.cp("tid", gVar.threadId);
                anVar.Z("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cp("fid", gVar.forumId);
                anVar.Z("obj_locate", i);
                anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.grY.jvJ = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.grY.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.grY.jvL = "1";
                this.grZ.jvJ = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.grZ.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.grZ.jvL = "1";
            } else {
                this.grY.jvL = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.grY.mLocate = "12";
                this.grZ.jvL = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.grZ.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.gsw != null) {
                this.grY.jvN = gVar.gsw.videoMd5;
                this.grZ.jvN = gVar.gsw.videoMd5;
            }
            this.egU.setVideoStatsData(this.grY);
            this.grV.getVideoView().setBusiness(this.egU);
            this.grV.cbd();
            this.grV.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void lF(boolean z) {
                    if (!b.this.grV.kP()) {
                        b.this.grJ.setVisibility(0);
                    } else if (z) {
                        if (b.this.grJ.getVisibility() == 0) {
                            b.this.grJ.setVisibility(8);
                            b.this.grJ.startAnimation(b.this.gsc);
                        }
                    } else if (b.this.grJ.getVisibility() == 8) {
                        b.this.grJ.setVisibility(0);
                        b.this.grJ.startAnimation(b.this.aHr);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bEL() {
                    if (!b.this.grV.kP()) {
                        b.this.grJ.setVisibility(0);
                    } else if (b.this.grJ.getVisibility() == 0) {
                        b.this.grJ.setVisibility(8);
                        b.this.grJ.startAnimation(b.this.gsc);
                    }
                }
            });
            this.grV.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.gsb = true;
                        b.this.gsa = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.sY(i);
                        b.this.grV.bOk();
                    }
                }
            });
            this.grV.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.grW != null && b.this.grW.gsw != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.grW.gsw.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.grV.setThumbnail(gVar.gsw.thumbnailUrl);
            this.grV.setVideoUrl(gVar.gsw.videoUrl, gVar.threadId);
            this.grV.GJ(gVar.title);
            this.grV.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bEM() {
                    b.this.grK.setVisibility(8);
                }
            });
            this.grV.bOk();
            this.grV.show();
            if (gVar.autoPlay) {
                onClick(this.grI);
                this.gsb = false;
                this.grV.a(gVar.gsw.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.gsb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS(String str) {
        if (this.grW != null && this.grW.gsw != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.grW.gsw.videoMd5, "", str, this.grZ);
            }
        }
    }

    public boolean isPlaying() {
        return this.grV.kP();
    }

    public void bEF() {
        if (isPlaying()) {
            this.grV.pausePlay();
        }
    }

    public boolean sZ(int i) {
        return this.grV.Ad(i);
    }

    public void bEG() {
        this.grL.setVisibility(8);
        this.grV.stopPlay();
        if (this.grJ != null) {
            this.grJ.setVisibility(0);
        }
        if (this.grK != null) {
            this.grK.setVisibility(0);
        }
    }

    public void bEH() {
        if (this.grV != null) {
            this.grV.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bEH();
        if (this.grX != null) {
            this.grX.bER();
        }
    }

    public String AT(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.gsv != null) {
            this.MK.setText(TextUtils.isEmpty(gVar.gsv.userNickname) ? gVar.gsv.userName : gVar.gsv.userNickname);
            this.grO.startLoad(gVar.gsv.portrait, 12, false);
            this.grO.setShowV(gVar.gsv.isGod);
            this.grO.setIsBigV(gVar.gsv.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.gsv != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.gsv.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.gsv.userId)) {
                this.eZN.setVisibility(8);
            } else {
                this.eZN.setVisibility(0);
            }
            if (gVar.gsv.hasFocus) {
                am.setViewTextColor(this.eZN, (int) R.color.cp_cont_d);
                this.eZN.setCompoundDrawables(null, null, null, null);
                this.eZN.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.eZN, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.eZN.setCompoundDrawables(drawable, null, null, null);
            this.eZN.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.grS.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.grQ, (int) R.color.cp_cont_h);
            } else {
                this.grS.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.grQ, (int) R.color.cp_cont_f);
            }
            this.grQ.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.grP, (int) R.color.cp_cont_f);
            this.grR.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.grP.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.grV != null && this.grI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gsa) {
                this.grV.cwJ();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.grI.getParent() != null) {
                    if (this.grI.getParent() == frameLayout) {
                        frameLayout.removeView(this.grI);
                    } else if (this.grI.getParent() == this.grH) {
                        this.grH.removeView(this.grI);
                    }
                }
                if (this.grI.getParent() == null) {
                    frameLayout.addView(this.grI);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.grI.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.grI.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.grI.getParent() != null) {
                    if (this.grI.getParent() == frameLayout) {
                        frameLayout.removeView(this.grI);
                    } else if (this.grI.getParent() == this.grH) {
                        this.grH.removeView(this.grI);
                    }
                }
                if (this.grI.getParent() == null) {
                    this.grH.addView(this.grI, 0);
                    this.grI.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.grV.cbd();
                    this.gsa = true;
                } else {
                    return;
                }
            }
            this.grV.a(this.mPageContext, configuration);
            this.grK.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            view.setTag(this);
            bta().a(view, this.grW);
        }
        if (view == this.grO || view == this.MK) {
            boolean z = false;
            if (this.grW != null && this.grW.gsv != null && !TextUtils.isEmpty(this.grW.gsv.userId)) {
                if (TbadkCoreApplication.isLogin() && this.grW.gsv.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.grW.gsv.userId, 0L), z, this.grW.gsv.isGod)));
            }
        } else if (view == this.grT || view == this.grJ || view == getView()) {
            if (this.grW != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.grW.threadId, null, null);
                if (!this.gse) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.grN) {
            if (this.grW != null && this.grW.gsw != null) {
                this.grL.setVisibility(8);
                this.grV.cwM();
                this.grV.dZ(this.grW.gsw.videoUrl, this.grW.threadId);
                AS("2");
            }
        } else if (view == this.eZN) {
            if (!this.grW.gsv.hasFocus) {
                this.grX.f(this.grW);
            }
        } else if (view == this.grU) {
            this.grX.g(this.grW);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lD(boolean z) {
        if (this.grW != null && this.grW.gsv != null) {
            this.grW.gsv.hasFocus = z;
            c(this.grW);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bEI() {
        if (this.grW != null) {
            this.grW.hasAgree = !this.grW.hasAgree;
            if (this.grW.hasAgree) {
                this.grW.agreeNum++;
            } else {
                this.grW.agreeNum--;
            }
            if (this.grS != null) {
                this.grS.startAnimation(getScaleAnimation());
            }
            d(this.grW);
        }
    }

    private Animation getScaleAnimation() {
        if (this.gsd == null) {
            this.gsd = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.gsd.setDuration(200L);
        }
        return this.gsd;
    }
}
