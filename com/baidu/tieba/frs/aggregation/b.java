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
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView ajb;
    private Animation bDE;
    private boolean eiU;
    public FrameLayout igT;
    public FrameLayout igU;
    public TextView igV;
    public TextView igW;
    public FrameLayout igX;
    public TextView igY;
    public TextView igZ;
    public HeadImageView iha;
    public TextView ihb;
    public TextView ihc;
    public TextView ihd;
    public ImageView ihe;
    public ImageView ihf;
    public LinearLayout ihg;
    public LinearLayout ihh;
    public com.baidu.tieba.play.c ihi;
    public g ihj;
    private h ihk;
    private o ihl;
    private o ihm;
    private boolean ihn;
    private boolean iho;
    private Animation ihp;
    private ScaleAnimation ihq;
    private boolean ihr;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.ihn = true;
        this.ihr = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.igT = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.igU = (FrameLayout) view.findViewById(R.id.video_container);
        this.ihi = new com.baidu.tieba.play.c(tbPageContext, this.igU, false);
        this.ihi.setStageType("2005");
        this.igV = (TextView) view.findViewById(R.id.title);
        this.igW = (TextView) view.findViewById(R.id.duration);
        this.igX = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.igY = (TextView) view.findViewById(R.id.mobile_network_text);
        this.igZ = (TextView) view.findViewById(R.id.mobile_network_play);
        this.iha = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajb = (TextView) view.findViewById(R.id.user_name);
        this.ihb = (TextView) view.findViewById(R.id.attention);
        this.ihg = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.ihh = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.ihc = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.ihd = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.ihe = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.ihf = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.ihg.setOnClickListener(this);
        this.ihh.setOnClickListener(this);
        this.igV.setOnClickListener(this);
        this.iha.setOnClickListener(this);
        this.ajb.setOnClickListener(this);
        this.ihb.setOnClickListener(this);
        view.setOnClickListener(this);
        this.igZ.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.igT.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.igT.setLayoutParams(layoutParams);
        this.iha.setIsRound(true);
        this.ihk = new h(this.mPageContext, this);
        this.ihp = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bDE = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.ihj != null && this.ihj.ihI != null) {
                if (this.ihj.ihI.hasFocus) {
                    ap.setViewTextColor(this.ihb, (int) R.color.cp_cont_d);
                    this.ihb.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.ihb, (int) R.color.cp_link_tip_a);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.ihb.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.ihj != null) {
                if (this.ihj.hasAgree) {
                    this.ihf.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.ihd, (int) R.color.cp_cont_h);
                } else {
                    this.ihf.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.ihd, (int) R.color.cp_cont_f);
                }
            }
            ap.setViewTextColor(this.ihc, (int) R.color.cp_cont_f);
            this.ihe.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.ihJ != null) {
            this.ihj = gVar;
            this.eiU = this.ihj.autoPlay;
            this.igV.setVisibility(0);
            this.igV.setText(gVar.title);
            this.igW.setVisibility(0);
            this.igW.setText(at.stringForVideoTime(gVar.ihJ.videoDuration * 1000));
            if (gVar.ihJ.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), IT(String.format("%.1f", Float.valueOf(((float) gVar.ihJ.videoSize) / 1048576.0f))));
            }
            this.igY.setText(format);
            this.igX.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.ihJ != null) {
            this.ihi.stopPlay();
            this.ihi.vj(true);
            this.ihi.vf(false);
            this.ihi.a(new c.InterfaceC0779c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rI() {
                    if (b.this.ihi.rK()) {
                        b.this.igW.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rJ() {
                    if (b.this.ihi.rK()) {
                        b.this.igW.setVisibility(8);
                    }
                    if (b.this.iho) {
                        b.this.ihi.stopPlay();
                    }
                }
            });
            this.ihi.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void csa() {
                    b.this.iho = false;
                    b.this.igW.setVisibility(8);
                    b.this.IS(b.this.eiU ? "1" : "2");
                    b.this.onClick(b.this.igU);
                }

                @Override // com.baidu.tieba.play.c.l
                public void csb() {
                    b.this.igW.setVisibility(8);
                    b.this.onClick(b.this.igT);
                }
            });
            this.ihi.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void oN(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.igY.getText().toString());
                        b.this.ihi.fK(b.this.ihj.ihJ.videoUrl, b.this.ihj.threadId);
                        b.this.igW.setVisibility(8);
                        b.this.IS("2");
                    } else {
                        b.this.igX.setVisibility(0);
                    }
                    b.this.onClick(b.this.igU);
                }
            });
            this.ihi.vb(false);
            this.ihl = new o();
            this.ihl.alA = gVar.threadId;
            this.ihl.eYo = gVar.forumId;
            this.ihl.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ihm = new o();
            this.ihm.alA = gVar.threadId;
            this.ihm.eYo = gVar.forumId;
            this.ihm.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.ihr) {
                aq aqVar = new aq("c12590");
                aqVar.dF("tid", gVar.threadId);
                aqVar.dF("nid", gVar.nid);
                aqVar.ai("obj_param5", gVar.getVideoType());
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dF("fid", gVar.forumId);
                aqVar.ai("obj_locate", i);
                aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.ihl.lCf = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.ihl.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.ihl.lCh = "1";
                this.ihm.lCf = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.ihm.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.ihm.lCh = "1";
            } else {
                this.ihl.lCh = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.ihl.mLocate = "12";
                this.ihm.lCh = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.ihm.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.ihJ != null) {
                this.ihl.lCk = gVar.ihJ.videoMd5;
                this.ihm.lCk = gVar.ihJ.videoMd5;
            }
            this.ihi.getVideoView().setVideoStatData(this.ihl);
            this.ihi.cQw();
            this.ihi.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void oO(boolean z) {
                    if (!b.this.ihi.rK()) {
                        b.this.igV.setVisibility(0);
                    } else if (z) {
                        if (b.this.igV.getVisibility() == 0) {
                            b.this.igV.setVisibility(8);
                            b.this.igV.startAnimation(b.this.ihp);
                        }
                    } else if (b.this.igV.getVisibility() == 8) {
                        b.this.igV.setVisibility(0);
                        b.this.igV.startAnimation(b.this.bDE);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void csc() {
                    if (!b.this.ihi.rK()) {
                        b.this.igV.setVisibility(0);
                    } else if (b.this.igV.getVisibility() == 0) {
                        b.this.igV.setVisibility(8);
                        b.this.igV.startAnimation(b.this.ihp);
                    }
                }
            });
            this.ihi.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.iho = true;
                        b.this.ihn = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.xZ(i);
                        b.this.ihi.cDc();
                    }
                }
            });
            this.ihi.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.ihj != null && b.this.ihj.ihJ != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.ihj.ihJ.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.ihi.setThumbnail(gVar.ihJ.thumbnailUrl);
            this.ihi.setVideoUrl(gVar.ihJ.videoUrl, gVar.threadId);
            this.ihi.Pf(gVar.title);
            this.ihi.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void csd() {
                    b.this.igW.setVisibility(8);
                }
            });
            this.ihi.cDc();
            this.ihi.show();
            if (gVar.autoPlay) {
                onClick(this.igU);
                this.iho = false;
                this.ihi.a(gVar.ihJ.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.iho = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IS(String str) {
        if (this.ihj != null && this.ihj.ihJ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.ihj.ihJ.videoMd5, "", str, this.ihm, this.ihi.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.ihi.rK();
    }

    public void crW() {
        if (isPlaying()) {
            this.ihi.aII();
        }
    }

    public boolean ya(int i) {
        return this.ihi.Ge(i);
    }

    public void crX() {
        this.igX.setVisibility(8);
        this.ihi.stopPlay();
        if (this.igV != null) {
            this.igV.setVisibility(0);
        }
        if (this.igW != null) {
            this.igW.setVisibility(0);
        }
    }

    public void crY() {
        if (this.ihi != null) {
            this.ihi.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        crY();
        if (this.ihk != null) {
            this.ihk.csi();
        }
    }

    public String IT(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.ihI != null) {
            this.ajb.setText(TextUtils.isEmpty(gVar.ihI.userNickname) ? gVar.ihI.userName : gVar.ihI.userNickname);
            this.iha.startLoad(gVar.ihI.portrait, 12, false);
            this.iha.setShowV(gVar.ihI.isGod);
            this.iha.setIsBigV(gVar.ihI.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.ihI != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.ihI.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.ihI.userId)) {
                this.ihb.setVisibility(8);
            } else {
                this.ihb.setVisibility(0);
            }
            if (gVar.ihI.hasFocus) {
                ap.setViewTextColor(this.ihb, (int) R.color.cp_cont_d);
                this.ihb.setCompoundDrawables(null, null, null, null);
                this.ihb.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.ihb, (int) R.color.cp_link_tip_a);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.ihb.setCompoundDrawables(drawable, null, null, null);
            this.ihb.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.ihf.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.ihd, (int) R.color.cp_cont_h);
            } else {
                this.ihf.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.ihd, (int) R.color.cp_cont_f);
            }
            this.ihd.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.ihc, (int) R.color.cp_cont_f);
            this.ihe.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.ihc.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.ihi != null && this.igU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.ihn) {
                this.ihi.dnj();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.igU.getParent() != null) {
                    if (this.igU.getParent() == frameLayout) {
                        frameLayout.removeView(this.igU);
                    } else if (this.igU.getParent() == this.igT) {
                        this.igT.removeView(this.igU);
                    }
                }
                if (this.igU.getParent() == null) {
                    frameLayout.addView(this.igU);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igU.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.igU.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.igU.getParent() != null) {
                    if (this.igU.getParent() == frameLayout) {
                        frameLayout.removeView(this.igU);
                    } else if (this.igU.getParent() == this.igT) {
                        this.igT.removeView(this.igU);
                    }
                }
                if (this.igU.getParent() == null) {
                    this.igT.addView(this.igU, 0);
                    this.igU.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.ihi.cQw();
                    this.ihn = true;
                } else {
                    return;
                }
            }
            this.ihi.a(this.mPageContext, configuration);
            this.igW.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ceP() != null) {
            view.setTag(this);
            ceP().a(view, this.ihj);
        }
        if (view == this.iha || view == this.ajb) {
            boolean z = false;
            if (this.ihj != null && this.ihj.ihI != null && !TextUtils.isEmpty(this.ihj.ihI.userId)) {
                if (TbadkCoreApplication.isLogin() && this.ihj.ihI.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.ihj.ihI.userId, 0L), z, this.ihj.ihI.isGod)));
            }
        } else if (view == this.ihg || view == this.igV || view == getView()) {
            if (this.ihj != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.ihj.threadId, null, null);
                if (!this.ihr) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.igZ) {
            if (this.ihj != null && this.ihj.ihJ != null) {
                this.igX.setVisibility(8);
                this.ihi.dnm();
                this.ihi.fK(this.ihj.ihJ.videoUrl, this.ihj.threadId);
                IS("2");
            }
        } else if (view == this.ihb) {
            if (!this.ihj.ihI.hasFocus) {
                this.ihk.f(this.ihj);
            }
        } else if (view == this.ihh) {
            this.ihk.g(this.ihj);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oM(boolean z) {
        if (this.ihj != null && this.ihj.ihI != null) {
            this.ihj.ihI.hasFocus = z;
            c(this.ihj);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void crZ() {
        if (this.ihj != null) {
            this.ihj.hasAgree = !this.ihj.hasAgree;
            if (this.ihj.hasAgree) {
                this.ihj.agreeNum++;
            } else {
                this.ihj.agreeNum--;
            }
            if (this.ihf != null) {
                this.ihf.startAnimation(getScaleAnimation());
            }
            d(this.ihj);
        }
    }

    private Animation getScaleAnimation() {
        if (this.ihq == null) {
            this.ihq = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ihq.setDuration(200L);
        }
        return this.ihq;
    }
}
