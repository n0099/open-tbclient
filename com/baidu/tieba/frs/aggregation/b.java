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
    private Animation aLx;
    private boolean cWl;
    private n ekZ;
    public TextView fdb;
    public FrameLayout gtK;
    public FrameLayout gtL;
    public TextView gtM;
    public TextView gtN;
    public FrameLayout gtO;
    public TextView gtP;
    public TextView gtQ;
    public HeadImageView gtR;
    public TextView gtS;
    public TextView gtT;
    public ImageView gtU;
    public ImageView gtV;
    public LinearLayout gtW;
    public LinearLayout gtX;
    public com.baidu.tieba.play.c gtY;
    public g gtZ;
    private h gua;
    private y gub;
    private y guc;
    private boolean gud;
    private boolean gue;
    private Animation guf;
    private ScaleAnimation gug;
    private boolean guh;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gud = true;
        this.guh = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gtK = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gtL = (FrameLayout) view.findViewById(R.id.video_container);
        this.gtY = new com.baidu.tieba.play.c(tbPageContext, this.gtL, false);
        this.gtM = (TextView) view.findViewById(R.id.title);
        this.gtN = (TextView) view.findViewById(R.id.duration);
        this.gtO = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.gtP = (TextView) view.findViewById(R.id.mobile_network_text);
        this.gtQ = (TextView) view.findViewById(R.id.mobile_network_play);
        this.gtR = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nl = (TextView) view.findViewById(R.id.user_name);
        this.fdb = (TextView) view.findViewById(R.id.attention);
        this.gtW = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.gtX = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.gtS = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.gtT = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.gtU = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.gtV = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.gtW.setOnClickListener(this);
        this.gtX.setOnClickListener(this);
        this.gtM.setOnClickListener(this);
        this.gtR.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.fdb.setOnClickListener(this);
        view.setOnClickListener(this);
        this.gtQ.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtK.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtK.setLayoutParams(layoutParams);
        this.gtR.setIsRound(true);
        this.ekZ = new n(tbPageContext.getPageActivity());
        this.gua = new h(this.mPageContext, this);
        this.guf = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.aLx = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.gtZ != null && this.gtZ.guy != null) {
                if (this.gtZ.guy.hasFocus) {
                    am.setViewTextColor(this.fdb, (int) R.color.cp_cont_d);
                    this.fdb.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fdb, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fdb.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.gtZ != null) {
                if (this.gtZ.hasAgree) {
                    this.gtV.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.gtT, (int) R.color.cp_cont_h);
                } else {
                    this.gtV.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.gtT, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.gtS, (int) R.color.cp_cont_f);
            this.gtU.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.guz != null) {
            this.gtZ = gVar;
            this.cWl = this.gtZ.autoPlay;
            this.gtM.setVisibility(0);
            this.gtM.setText(gVar.title);
            this.gtN.setVisibility(0);
            this.gtN.setText(aq.stringForVideoTime(gVar.guz.videoDuration * 1000));
            if (gVar.guz.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Bj(String.format("%.1f", Float.valueOf(((float) gVar.guz.videoSize) / 1048576.0f))));
            }
            this.gtP.setText(format);
            this.gtO.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.guz != null) {
            this.gtY.stopPlay();
            this.gtY.setIsNeedRecoveryVideoPlayer(true);
            this.gtY.rL(true);
            this.gtY.rH(false);
            this.gtY.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    if (b.this.gtY.le()) {
                        b.this.gtN.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    if (b.this.gtY.le()) {
                        b.this.gtN.setVisibility(8);
                    }
                    if (b.this.gue) {
                        b.this.gtY.stopPlay();
                    }
                }
            });
            this.gtY.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bGn() {
                    b.this.gue = false;
                    b.this.gtN.setVisibility(8);
                    b.this.Bi(b.this.cWl ? "1" : "2");
                    b.this.onClick(b.this.gtL);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGo() {
                    b.this.gtN.setVisibility(8);
                    b.this.onClick(b.this.gtK);
                }
            });
            this.gtY.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.gtP.getText().toString());
                        b.this.gtY.ei(b.this.gtZ.guz.videoUrl, b.this.gtZ.threadId);
                        b.this.gtN.setVisibility(8);
                        b.this.Bi("2");
                    } else {
                        b.this.gtO.setVisibility(0);
                    }
                    b.this.onClick(b.this.gtL);
                }
            });
            this.gtY.rD(false);
            this.gub = new y();
            this.gub.Pj = gVar.threadId;
            this.gub.emb = gVar.forumId;
            this.gub.mUid = TbadkCoreApplication.getCurrentAccount();
            this.guc = new y();
            this.guc.Pj = gVar.threadId;
            this.guc.emb = gVar.forumId;
            this.guc.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.guh) {
                an anVar = new an("c12590");
                anVar.cy("tid", gVar.threadId);
                anVar.X("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cy("fid", gVar.forumId);
                anVar.X("obj_locate", i);
                anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.gub.jwG = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.gub.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.gub.jwI = "1";
                this.guc.jwG = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.guc.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.guc.jwI = "1";
            } else {
                this.gub.jwI = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.gub.mLocate = "12";
                this.guc.jwI = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.guc.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.guz != null) {
                this.gub.jwK = gVar.guz.videoMd5;
                this.guc.jwK = gVar.guz.videoMd5;
            }
            this.ekZ.setVideoStatsData(this.gub);
            this.gtY.getVideoView().setBusiness(this.ekZ);
            this.gtY.ccG();
            this.gtY.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void lI(boolean z) {
                    if (!b.this.gtY.le()) {
                        b.this.gtM.setVisibility(0);
                    } else if (z) {
                        if (b.this.gtM.getVisibility() == 0) {
                            b.this.gtM.setVisibility(8);
                            b.this.gtM.startAnimation(b.this.guf);
                        }
                    } else if (b.this.gtM.getVisibility() == 8) {
                        b.this.gtM.setVisibility(0);
                        b.this.gtM.startAnimation(b.this.aLx);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGp() {
                    if (!b.this.gtY.le()) {
                        b.this.gtM.setVisibility(0);
                    } else if (b.this.gtM.getVisibility() == 0) {
                        b.this.gtM.setVisibility(8);
                        b.this.gtM.startAnimation(b.this.guf);
                    }
                }
            });
            this.gtY.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.gue = true;
                        b.this.gud = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.te(i);
                        b.this.gtY.bPO();
                    }
                }
            });
            this.gtY.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.gtZ != null && b.this.gtZ.guz != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.gtZ.guz.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.gtY.setThumbnail(gVar.guz.thumbnailUrl);
            this.gtY.setVideoUrl(gVar.guz.videoUrl, gVar.threadId);
            this.gtY.GX(gVar.title);
            this.gtY.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bGq() {
                    b.this.gtN.setVisibility(8);
                }
            });
            this.gtY.bPO();
            this.gtY.show();
            if (gVar.autoPlay) {
                onClick(this.gtL);
                this.gue = false;
                this.gtY.a(gVar.guz.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.gue = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(String str) {
        if (this.gtZ != null && this.gtZ.guz != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gtZ.guz.videoMd5, "", str, this.guc);
            }
        }
    }

    public boolean isPlaying() {
        return this.gtY.le();
    }

    public void bGj() {
        if (isPlaying()) {
            this.gtY.pausePlay();
        }
    }

    public boolean tf(int i) {
        return this.gtY.Am(i);
    }

    public void bGk() {
        this.gtO.setVisibility(8);
        this.gtY.stopPlay();
        if (this.gtM != null) {
            this.gtM.setVisibility(0);
        }
        if (this.gtN != null) {
            this.gtN.setVisibility(0);
        }
    }

    public void bGl() {
        if (this.gtY != null) {
            this.gtY.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGl();
        if (this.gua != null) {
            this.gua.bGv();
        }
    }

    public String Bj(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.guy != null) {
            this.Nl.setText(TextUtils.isEmpty(gVar.guy.userNickname) ? gVar.guy.userName : gVar.guy.userNickname);
            this.gtR.startLoad(gVar.guy.portrait, 12, false);
            this.gtR.setShowV(gVar.guy.isGod);
            this.gtR.setIsBigV(gVar.guy.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.guy != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.guy.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.guy.userId)) {
                this.fdb.setVisibility(8);
            } else {
                this.fdb.setVisibility(0);
            }
            if (gVar.guy.hasFocus) {
                am.setViewTextColor(this.fdb, (int) R.color.cp_cont_d);
                this.fdb.setCompoundDrawables(null, null, null, null);
                this.fdb.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fdb, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fdb.setCompoundDrawables(drawable, null, null, null);
            this.fdb.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.gtV.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.gtT, (int) R.color.cp_cont_h);
            } else {
                this.gtV.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.gtT, (int) R.color.cp_cont_f);
            }
            this.gtT.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.gtS, (int) R.color.cp_cont_f);
            this.gtU.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.gtS.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gtY != null && this.gtL != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gud) {
                this.gtY.cyg();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.gtL.getParent() != null) {
                    if (this.gtL.getParent() == frameLayout) {
                        frameLayout.removeView(this.gtL);
                    } else if (this.gtL.getParent() == this.gtK) {
                        this.gtK.removeView(this.gtL);
                    }
                }
                if (this.gtL.getParent() == null) {
                    frameLayout.addView(this.gtL);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gtL.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.gtL.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.gtL.getParent() != null) {
                    if (this.gtL.getParent() == frameLayout) {
                        frameLayout.removeView(this.gtL);
                    } else if (this.gtL.getParent() == this.gtK) {
                        this.gtK.removeView(this.gtL);
                    }
                }
                if (this.gtL.getParent() == null) {
                    this.gtK.addView(this.gtL, 0);
                    this.gtL.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.gtY.ccG();
                    this.gud = true;
                } else {
                    return;
                }
            }
            this.gtY.a(this.mPageContext, configuration);
            this.gtN.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buG() != null) {
            view.setTag(this);
            buG().a(view, this.gtZ);
        }
        if (view == this.gtR || view == this.Nl) {
            boolean z = false;
            if (this.gtZ != null && this.gtZ.guy != null && !TextUtils.isEmpty(this.gtZ.guy.userId)) {
                if (TbadkCoreApplication.isLogin() && this.gtZ.guy.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gtZ.guy.userId, 0L), z, this.gtZ.guy.isGod)));
            }
        } else if (view == this.gtW || view == this.gtM || view == getView()) {
            if (this.gtZ != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.gtZ.threadId, null, null);
                if (!this.guh) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.gtQ) {
            if (this.gtZ != null && this.gtZ.guz != null) {
                this.gtO.setVisibility(8);
                this.gtY.cyj();
                this.gtY.ei(this.gtZ.guz.videoUrl, this.gtZ.threadId);
                Bi("2");
            }
        } else if (view == this.fdb) {
            if (!this.gtZ.guy.hasFocus) {
                this.gua.f(this.gtZ);
            }
        } else if (view == this.gtX) {
            this.gua.g(this.gtZ);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lG(boolean z) {
        if (this.gtZ != null && this.gtZ.guy != null) {
            this.gtZ.guy.hasFocus = z;
            c(this.gtZ);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGm() {
        if (this.gtZ != null) {
            this.gtZ.hasAgree = !this.gtZ.hasAgree;
            if (this.gtZ.hasAgree) {
                this.gtZ.agreeNum++;
            } else {
                this.gtZ.agreeNum--;
            }
            if (this.gtV != null) {
                this.gtV.startAnimation(getScaleAnimation());
            }
            d(this.gtZ);
        }
    }

    private Animation getScaleAnimation() {
        if (this.gug == null) {
            this.gug = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.gug.setDuration(200L);
        }
        return this.gug;
    }
}
