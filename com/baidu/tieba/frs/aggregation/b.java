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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView Nl;
    private Animation aLw;
    private boolean cWk;
    private n ekY;
    public TextView fda;
    public FrameLayout gtI;
    public FrameLayout gtJ;
    public TextView gtK;
    public TextView gtL;
    public FrameLayout gtM;
    public TextView gtN;
    public TextView gtO;
    public HeadImageView gtP;
    public TextView gtQ;
    public TextView gtR;
    public ImageView gtS;
    public ImageView gtT;
    public LinearLayout gtU;
    public LinearLayout gtV;
    public com.baidu.tieba.play.c gtW;
    public g gtX;
    private h gtY;
    private y gtZ;
    private y gua;
    private boolean gub;
    private boolean guc;
    private Animation gud;
    private ScaleAnimation gue;
    private boolean guf;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gub = true;
        this.guf = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gtI = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gtJ = (FrameLayout) view.findViewById(R.id.video_container);
        this.gtW = new com.baidu.tieba.play.c(tbPageContext, this.gtJ, false);
        this.gtK = (TextView) view.findViewById(R.id.title);
        this.gtL = (TextView) view.findViewById(R.id.duration);
        this.gtM = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.gtN = (TextView) view.findViewById(R.id.mobile_network_text);
        this.gtO = (TextView) view.findViewById(R.id.mobile_network_play);
        this.gtP = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nl = (TextView) view.findViewById(R.id.user_name);
        this.fda = (TextView) view.findViewById(R.id.attention);
        this.gtU = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.gtV = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.gtQ = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.gtR = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.gtS = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.gtT = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.gtU.setOnClickListener(this);
        this.gtV.setOnClickListener(this);
        this.gtK.setOnClickListener(this);
        this.gtP.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.fda.setOnClickListener(this);
        view.setOnClickListener(this);
        this.gtO.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtI.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtI.setLayoutParams(layoutParams);
        this.gtP.setIsRound(true);
        this.ekY = new n(tbPageContext.getPageActivity());
        this.gtY = new h(this.mPageContext, this);
        this.gud = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.aLw = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.gtX != null && this.gtX.guw != null) {
                if (this.gtX.guw.hasFocus) {
                    am.setViewTextColor(this.fda, (int) R.color.cp_cont_d);
                    this.fda.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fda, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fda.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.gtX != null) {
                if (this.gtX.hasAgree) {
                    this.gtT.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.gtR, (int) R.color.cp_cont_h);
                } else {
                    this.gtT.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.gtR, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.gtQ, (int) R.color.cp_cont_f);
            this.gtS.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.gux != null) {
            this.gtX = gVar;
            this.cWk = this.gtX.autoPlay;
            this.gtK.setVisibility(0);
            this.gtK.setText(gVar.title);
            this.gtL.setVisibility(0);
            this.gtL.setText(aq.stringForVideoTime(gVar.gux.videoDuration * 1000));
            if (gVar.gux.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Bj(String.format("%.1f", Float.valueOf(((float) gVar.gux.videoSize) / 1048576.0f))));
            }
            this.gtN.setText(format);
            this.gtM.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.gux != null) {
            this.gtW.stopPlay();
            this.gtW.setIsNeedRecoveryVideoPlayer(true);
            this.gtW.rL(true);
            this.gtW.rH(false);
            this.gtW.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    if (b.this.gtW.le()) {
                        b.this.gtL.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    if (b.this.gtW.le()) {
                        b.this.gtL.setVisibility(8);
                    }
                    if (b.this.guc) {
                        b.this.gtW.stopPlay();
                    }
                }
            });
            this.gtW.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bGl() {
                    b.this.guc = false;
                    b.this.gtL.setVisibility(8);
                    b.this.Bi(b.this.cWk ? "1" : "2");
                    b.this.onClick(b.this.gtJ);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGm() {
                    b.this.gtL.setVisibility(8);
                    b.this.onClick(b.this.gtI);
                }
            });
            this.gtW.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.gtN.getText().toString());
                        b.this.gtW.ei(b.this.gtX.gux.videoUrl, b.this.gtX.threadId);
                        b.this.gtL.setVisibility(8);
                        b.this.Bi("2");
                    } else {
                        b.this.gtM.setVisibility(0);
                    }
                    b.this.onClick(b.this.gtJ);
                }
            });
            this.gtW.rD(false);
            this.gtZ = new y();
            this.gtZ.Pj = gVar.threadId;
            this.gtZ.ema = gVar.forumId;
            this.gtZ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gua = new y();
            this.gua.Pj = gVar.threadId;
            this.gua.ema = gVar.forumId;
            this.gua.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.guf) {
                an anVar = new an("c12590");
                anVar.cy("tid", gVar.threadId);
                anVar.X("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cy("fid", gVar.forumId);
                anVar.X("obj_locate", i);
                anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.gtZ.jwE = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.gtZ.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.gtZ.jwG = "1";
                this.gua.jwE = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.gua.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.gua.jwG = "1";
            } else {
                this.gtZ.jwG = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.gtZ.mLocate = "12";
                this.gua.jwG = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.gua.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.gux != null) {
                this.gtZ.jwI = gVar.gux.videoMd5;
                this.gua.jwI = gVar.gux.videoMd5;
            }
            this.ekY.setVideoStatsData(this.gtZ);
            this.gtW.getVideoView().setBusiness(this.ekY);
            this.gtW.ccE();
            this.gtW.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void lI(boolean z) {
                    if (!b.this.gtW.le()) {
                        b.this.gtK.setVisibility(0);
                    } else if (z) {
                        if (b.this.gtK.getVisibility() == 0) {
                            b.this.gtK.setVisibility(8);
                            b.this.gtK.startAnimation(b.this.gud);
                        }
                    } else if (b.this.gtK.getVisibility() == 8) {
                        b.this.gtK.setVisibility(0);
                        b.this.gtK.startAnimation(b.this.aLw);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGn() {
                    if (!b.this.gtW.le()) {
                        b.this.gtK.setVisibility(0);
                    } else if (b.this.gtK.getVisibility() == 0) {
                        b.this.gtK.setVisibility(8);
                        b.this.gtK.startAnimation(b.this.gud);
                    }
                }
            });
            this.gtW.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.guc = true;
                        b.this.gub = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.te(i);
                        b.this.gtW.bPM();
                    }
                }
            });
            this.gtW.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.gtX != null && b.this.gtX.gux != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.gtX.gux.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.gtW.setThumbnail(gVar.gux.thumbnailUrl);
            this.gtW.setVideoUrl(gVar.gux.videoUrl, gVar.threadId);
            this.gtW.GX(gVar.title);
            this.gtW.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bGo() {
                    b.this.gtL.setVisibility(8);
                }
            });
            this.gtW.bPM();
            this.gtW.show();
            if (gVar.autoPlay) {
                onClick(this.gtJ);
                this.guc = false;
                this.gtW.a(gVar.gux.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.guc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(String str) {
        if (this.gtX != null && this.gtX.gux != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gtX.gux.videoMd5, "", str, this.gua);
            }
        }
    }

    public boolean isPlaying() {
        return this.gtW.le();
    }

    public void bGh() {
        if (isPlaying()) {
            this.gtW.pausePlay();
        }
    }

    public boolean tf(int i) {
        return this.gtW.Am(i);
    }

    public void bGi() {
        this.gtM.setVisibility(8);
        this.gtW.stopPlay();
        if (this.gtK != null) {
            this.gtK.setVisibility(0);
        }
        if (this.gtL != null) {
            this.gtL.setVisibility(0);
        }
    }

    public void bGj() {
        if (this.gtW != null) {
            this.gtW.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGj();
        if (this.gtY != null) {
            this.gtY.bGt();
        }
    }

    public String Bj(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.guw != null) {
            this.Nl.setText(TextUtils.isEmpty(gVar.guw.userNickname) ? gVar.guw.userName : gVar.guw.userNickname);
            this.gtP.startLoad(gVar.guw.portrait, 12, false);
            this.gtP.setShowV(gVar.guw.isGod);
            this.gtP.setIsBigV(gVar.guw.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.guw != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.guw.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.guw.userId)) {
                this.fda.setVisibility(8);
            } else {
                this.fda.setVisibility(0);
            }
            if (gVar.guw.hasFocus) {
                am.setViewTextColor(this.fda, (int) R.color.cp_cont_d);
                this.fda.setCompoundDrawables(null, null, null, null);
                this.fda.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fda, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fda.setCompoundDrawables(drawable, null, null, null);
            this.fda.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.gtT.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.gtR, (int) R.color.cp_cont_h);
            } else {
                this.gtT.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.gtR, (int) R.color.cp_cont_f);
            }
            this.gtR.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.gtQ, (int) R.color.cp_cont_f);
            this.gtS.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.gtQ.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gtW != null && this.gtJ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gub) {
                this.gtW.cye();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.gtJ.getParent() != null) {
                    if (this.gtJ.getParent() == frameLayout) {
                        frameLayout.removeView(this.gtJ);
                    } else if (this.gtJ.getParent() == this.gtI) {
                        this.gtI.removeView(this.gtJ);
                    }
                }
                if (this.gtJ.getParent() == null) {
                    frameLayout.addView(this.gtJ);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gtJ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.gtJ.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.gtJ.getParent() != null) {
                    if (this.gtJ.getParent() == frameLayout) {
                        frameLayout.removeView(this.gtJ);
                    } else if (this.gtJ.getParent() == this.gtI) {
                        this.gtI.removeView(this.gtJ);
                    }
                }
                if (this.gtJ.getParent() == null) {
                    this.gtI.addView(this.gtJ, 0);
                    this.gtJ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.gtW.ccE();
                    this.gub = true;
                } else {
                    return;
                }
            }
            this.gtW.a(this.mPageContext, configuration);
            this.gtL.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buE() != null) {
            view.setTag(this);
            buE().a(view, this.gtX);
        }
        if (view == this.gtP || view == this.Nl) {
            boolean z = false;
            if (this.gtX != null && this.gtX.guw != null && !TextUtils.isEmpty(this.gtX.guw.userId)) {
                if (TbadkCoreApplication.isLogin() && this.gtX.guw.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gtX.guw.userId, 0L), z, this.gtX.guw.isGod)));
            }
        } else if (view == this.gtU || view == this.gtK || view == getView()) {
            if (this.gtX != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.gtX.threadId, null, null);
                if (!this.guf) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gtO) {
            if (this.gtX != null && this.gtX.gux != null) {
                this.gtM.setVisibility(8);
                this.gtW.cyh();
                this.gtW.ei(this.gtX.gux.videoUrl, this.gtX.threadId);
                Bi("2");
            }
        } else if (view == this.fda) {
            if (!this.gtX.guw.hasFocus) {
                this.gtY.f(this.gtX);
            }
        } else if (view == this.gtV) {
            this.gtY.g(this.gtX);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lG(boolean z) {
        if (this.gtX != null && this.gtX.guw != null) {
            this.gtX.guw.hasFocus = z;
            c(this.gtX);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGk() {
        if (this.gtX != null) {
            this.gtX.hasAgree = !this.gtX.hasAgree;
            if (this.gtX.hasAgree) {
                this.gtX.agreeNum++;
            } else {
                this.gtX.agreeNum--;
            }
            if (this.gtT != null) {
                this.gtT.startAnimation(getScaleAnimation());
            }
            d(this.gtX);
        }
    }

    private Animation getScaleAnimation() {
        if (this.gue == null) {
            this.gue = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.gue.setDuration(200L);
        }
        return this.gue;
    }
}
