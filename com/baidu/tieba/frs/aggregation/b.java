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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView ajt;
    private Animation bKg;
    private boolean evc;
    private boolean isFullScreen;
    public FrameLayout ivQ;
    public FrameLayout ivR;
    public TextView ivS;
    public TextView ivT;
    public FrameLayout ivU;
    public TextView ivV;
    public TextView ivW;
    public HeadImageView ivX;
    public TextView ivY;
    public TextView ivZ;
    public TextView iwa;
    public ImageView iwb;
    public ImageView iwc;
    public LinearLayout iwd;
    public LinearLayout iwe;
    public com.baidu.tieba.play.c iwf;
    public g iwg;
    private h iwh;
    private o iwi;
    private o iwj;
    private boolean iwk;
    private boolean iwl;
    private Animation iwm;
    private ScaleAnimation iwn;
    private boolean iwo;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.iwk = true;
        this.iwo = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.ivQ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.ivR = (FrameLayout) view.findViewById(R.id.video_container);
        this.iwf = new com.baidu.tieba.play.c(tbPageContext, this.ivR, false);
        this.iwf.setStageType("2005");
        this.ivS = (TextView) view.findViewById(R.id.title);
        this.ivT = (TextView) view.findViewById(R.id.duration);
        this.ivU = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.ivV = (TextView) view.findViewById(R.id.mobile_network_text);
        this.ivW = (TextView) view.findViewById(R.id.mobile_network_play);
        this.ivX = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajt = (TextView) view.findViewById(R.id.user_name);
        this.ivY = (TextView) view.findViewById(R.id.attention);
        this.iwd = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.iwe = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.ivZ = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.iwa = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.iwb = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.iwc = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.iwd.setOnClickListener(this);
        this.iwe.setOnClickListener(this);
        this.ivS.setOnClickListener(this);
        this.ivX.setOnClickListener(this);
        this.ajt.setOnClickListener(this);
        this.ivY.setOnClickListener(this);
        view.setOnClickListener(this);
        this.ivW.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ivQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.ivQ.setLayoutParams(layoutParams);
        this.ivX.setIsRound(true);
        this.iwh = new h(this.mPageContext, this);
        this.iwm = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bKg = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.iwg != null && this.iwg.iwF != null) {
                if (this.iwg.iwF.hasFocus) {
                    ap.setViewTextColor(this.ivY, (int) R.color.cp_cont_d);
                    this.ivY.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.ivY, (int) R.color.cp_link_tip_a);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.ivY.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.iwg != null) {
                if (this.iwg.hasAgree) {
                    this.iwc.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.iwa, (int) R.color.cp_cont_h);
                } else {
                    this.iwc.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.iwa, (int) R.color.cp_cont_f);
                }
            }
            ap.setViewTextColor(this.ivZ, (int) R.color.cp_cont_f);
            this.iwb.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.iwG != null) {
            this.iwg = gVar;
            this.evc = this.iwg.autoPlay;
            this.ivS.setVisibility(0);
            this.ivS.setText(gVar.title);
            this.ivT.setVisibility(0);
            this.ivT.setText(at.stringForVideoTime(gVar.iwG.videoDuration * 1000));
            if (gVar.iwG.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), JG(String.format("%.1f", Float.valueOf(((float) gVar.iwG.videoSize) / 1048576.0f))));
            }
            this.ivV.setText(format);
            this.ivU.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.iwG != null) {
            this.iwf.stopPlay();
            this.iwf.vQ(true);
            this.iwf.vM(false);
            this.iwf.a(new c.InterfaceC0797c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rI() {
                    if (b.this.iwf.rK()) {
                        b.this.ivT.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rJ() {
                    if (b.this.iwf.rK()) {
                        b.this.ivT.setVisibility(8);
                    }
                    if (b.this.iwl) {
                        b.this.iwf.stopPlay();
                    }
                }
            });
            this.iwf.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cvx() {
                    b.this.iwl = false;
                    b.this.ivT.setVisibility(8);
                    b.this.JF(b.this.evc ? "1" : "2");
                    b.this.onClick(b.this.ivR);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cvy() {
                    b.this.ivT.setVisibility(8);
                    b.this.onClick(b.this.ivQ);
                }
            });
            this.iwf.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void ps(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.ivV.getText().toString());
                        b.this.iwf.fR(b.this.iwg.iwG.videoUrl, b.this.iwg.threadId);
                        b.this.ivT.setVisibility(8);
                        b.this.JF("2");
                    } else {
                        b.this.ivU.setVisibility(0);
                    }
                    b.this.onClick(b.this.ivR);
                }
            });
            this.iwf.vI(false);
            this.iwi = new o();
            this.iwi.alS = gVar.threadId;
            this.iwi.fkA = gVar.forumId;
            this.iwi.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iwj = new o();
            this.iwj.alS = gVar.threadId;
            this.iwj.fkA = gVar.forumId;
            this.iwj.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.iwo) {
                aq aqVar = new aq("c12590");
                aqVar.dK("tid", gVar.threadId);
                aqVar.dK("nid", gVar.nid);
                aqVar.aj("obj_param5", gVar.getVideoType());
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dK("fid", gVar.forumId);
                aqVar.aj("obj_locate", i);
                aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.iwi.lRu = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iwi.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.iwi.lRw = "1";
                this.iwj.lRu = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iwj.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iwj.lRw = "1";
            } else {
                this.iwi.lRw = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iwi.mLocate = "12";
                this.iwj.lRw = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iwj.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.iwG != null) {
                this.iwi.lRz = gVar.iwG.videoMd5;
                this.iwj.lRz = gVar.iwG.videoMd5;
            }
            this.iwf.getVideoView().setVideoStatData(this.iwi);
            this.iwf.cUg();
            this.iwf.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void pt(boolean z) {
                    if (!b.this.iwf.rK()) {
                        b.this.ivS.setVisibility(0);
                    } else if (z) {
                        if (b.this.ivS.getVisibility() == 0) {
                            b.this.ivS.setVisibility(8);
                            b.this.ivS.startAnimation(b.this.iwm);
                        }
                    } else if (b.this.ivS.getVisibility() == 8) {
                        b.this.ivS.setVisibility(0);
                        b.this.ivS.startAnimation(b.this.bKg);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cvz() {
                    if (!b.this.iwf.rK()) {
                        b.this.ivS.setVisibility(0);
                    } else if (b.this.ivS.getVisibility() == 0) {
                        b.this.ivS.setVisibility(8);
                        b.this.ivS.startAnimation(b.this.iwm);
                    }
                }
            });
            this.iwf.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.iwl = true;
                        b.this.iwk = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.yF(i);
                        b.this.iwf.cGL();
                    }
                }
            });
            this.iwf.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.iwg != null && b.this.iwg.iwG != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.iwg.iwG.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.iwf.setThumbnail(gVar.iwG.thumbnailUrl);
            this.iwf.setVideoUrl(gVar.iwG.videoUrl, gVar.threadId);
            this.iwf.PU(gVar.title);
            this.iwf.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cvA() {
                    b.this.ivT.setVisibility(8);
                }
            });
            this.iwf.cGL();
            this.iwf.show();
            if (gVar.autoPlay) {
                onClick(this.ivR);
                this.iwl = false;
                this.iwf.a(gVar.iwG.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.iwl = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JF(String str) {
        if (this.iwg != null && this.iwg.iwG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iwg.iwG.videoMd5, "", str, this.iwj, this.iwf.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.iwf.rK();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iwf.aLr();
        }
    }

    public boolean yG(int i) {
        return this.iwf.GK(i);
    }

    public void cvu() {
        this.ivU.setVisibility(8);
        this.iwf.stopPlay();
        if (this.ivS != null) {
            this.ivS.setVisibility(0);
        }
        if (this.ivT != null) {
            this.ivT.setVisibility(0);
        }
    }

    public void cvv() {
        if (this.iwf != null) {
            this.iwf.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cvv();
        if (this.iwh != null) {
            this.iwh.cvF();
        }
    }

    public String JG(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.iwF != null) {
            this.ajt.setText(TextUtils.isEmpty(gVar.iwF.userNickname) ? gVar.iwF.userName : gVar.iwF.userNickname);
            this.ivX.startLoad(gVar.iwF.portrait, 12, false);
            this.ivX.setShowV(gVar.iwF.isGod);
            this.ivX.setIsBigV(gVar.iwF.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.iwF != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.iwF.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.iwF.userId)) {
                this.ivY.setVisibility(8);
            } else {
                this.ivY.setVisibility(0);
            }
            if (gVar.iwF.hasFocus) {
                ap.setViewTextColor(this.ivY, (int) R.color.cp_cont_d);
                this.ivY.setCompoundDrawables(null, null, null, null);
                this.ivY.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.ivY, (int) R.color.cp_link_tip_a);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.ivY.setCompoundDrawables(drawable, null, null, null);
            this.ivY.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.iwc.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.iwa, (int) R.color.cp_cont_h);
            } else {
                this.iwc.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.iwa, (int) R.color.cp_cont_f);
            }
            this.iwa.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.ivZ, (int) R.color.cp_cont_f);
            this.iwb.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.ivZ.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iwf != null && this.ivR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iwk) {
                this.iwf.dqV();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.ivR.getParent() != null) {
                    if (this.ivR.getParent() == frameLayout) {
                        frameLayout.removeView(this.ivR);
                    } else if (this.ivR.getParent() == this.ivQ) {
                        this.ivQ.removeView(this.ivR);
                    }
                }
                if (this.ivR.getParent() == null) {
                    frameLayout.addView(this.ivR);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivR.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.ivR.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.ivR.getParent() != null) {
                    if (this.ivR.getParent() == frameLayout) {
                        frameLayout.removeView(this.ivR);
                    } else if (this.ivR.getParent() == this.ivQ) {
                        this.ivQ.removeView(this.ivR);
                    }
                }
                if (this.ivR.getParent() == null) {
                    this.ivQ.addView(this.ivR, 0);
                    this.ivR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.iwf.cUg();
                    this.iwk = true;
                } else {
                    return;
                }
            }
            this.iwf.a(this.mPageContext, configuration);
            this.ivT.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            view.setTag(this);
            cil().a(view, this.iwg);
        }
        if (view == this.ivX || view == this.ajt) {
            boolean z = false;
            if (this.iwg != null && this.iwg.iwF != null && !TextUtils.isEmpty(this.iwg.iwF.userId)) {
                if (TbadkCoreApplication.isLogin() && this.iwg.iwF.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iwg.iwF.userId, 0L), z, this.iwg.iwF.isGod)));
            }
        } else if (view == this.iwd || view == this.ivS || view == getView()) {
            if (this.iwg != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iwg.threadId, null, null);
                if (!this.iwo) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.ivW) {
            if (this.iwg != null && this.iwg.iwG != null) {
                this.ivU.setVisibility(8);
                this.iwf.dqY();
                this.iwf.fR(this.iwg.iwG.videoUrl, this.iwg.threadId);
                JF("2");
            }
        } else if (view == this.ivY) {
            if (!this.iwg.iwF.hasFocus) {
                this.iwh.f(this.iwg);
            }
        } else if (view == this.iwe) {
            this.iwh.g(this.iwg);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pr(boolean z) {
        if (this.iwg != null && this.iwg.iwF != null) {
            this.iwg.iwF.hasFocus = z;
            c(this.iwg);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cvw() {
        if (this.iwg != null) {
            this.iwg.hasAgree = !this.iwg.hasAgree;
            if (this.iwg.hasAgree) {
                this.iwg.agreeNum++;
            } else {
                this.iwg.agreeNum--;
            }
            if (this.iwc != null) {
                this.iwc.startAnimation(getScaleAnimation());
            }
            d(this.iwg);
        }
    }

    private Animation getScaleAnimation() {
        if (this.iwn == null) {
            this.iwn = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.iwn.setDuration(200L);
        }
        return this.iwn;
    }
}
