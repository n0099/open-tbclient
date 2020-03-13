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
    private Animation aLy;
    private boolean cWm;
    private n elm;
    public TextView fdo;
    public FrameLayout gtW;
    public FrameLayout gtX;
    public TextView gtY;
    public TextView gtZ;
    public FrameLayout gua;
    public TextView gub;
    public TextView guc;
    public HeadImageView gud;
    public TextView gue;
    public TextView guf;
    public ImageView gug;
    public ImageView guh;
    public LinearLayout gui;
    public LinearLayout guj;
    public com.baidu.tieba.play.c guk;
    public g gul;
    private h gum;
    private y gun;
    private y guo;
    private boolean gup;
    private boolean guq;
    private Animation gur;
    private ScaleAnimation gus;
    private boolean gut;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gup = true;
        this.gut = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gtW = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.gtX = (FrameLayout) view.findViewById(R.id.video_container);
        this.guk = new com.baidu.tieba.play.c(tbPageContext, this.gtX, false);
        this.gtY = (TextView) view.findViewById(R.id.title);
        this.gtZ = (TextView) view.findViewById(R.id.duration);
        this.gua = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.gub = (TextView) view.findViewById(R.id.mobile_network_text);
        this.guc = (TextView) view.findViewById(R.id.mobile_network_play);
        this.gud = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nl = (TextView) view.findViewById(R.id.user_name);
        this.fdo = (TextView) view.findViewById(R.id.attention);
        this.gui = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.guj = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.gue = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.guf = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.gug = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.guh = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.gui.setOnClickListener(this);
        this.guj.setOnClickListener(this);
        this.gtY.setOnClickListener(this);
        this.gud.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.fdo.setOnClickListener(this);
        view.setOnClickListener(this);
        this.guc.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtW.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.gtW.setLayoutParams(layoutParams);
        this.gud.setIsRound(true);
        this.elm = new n(tbPageContext.getPageActivity());
        this.gum = new h(this.mPageContext, this);
        this.gur = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.aLy = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.gul != null && this.gul.guK != null) {
                if (this.gul.guK.hasFocus) {
                    am.setViewTextColor(this.fdo, (int) R.color.cp_cont_d);
                    this.fdo.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fdo, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fdo.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.gul != null) {
                if (this.gul.hasAgree) {
                    this.guh.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.guf, (int) R.color.cp_cont_h);
                } else {
                    this.guh.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.guf, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.gue, (int) R.color.cp_cont_f);
            this.gug.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.guL != null) {
            this.gul = gVar;
            this.cWm = this.gul.autoPlay;
            this.gtY.setVisibility(0);
            this.gtY.setText(gVar.title);
            this.gtZ.setVisibility(0);
            this.gtZ.setText(aq.stringForVideoTime(gVar.guL.videoDuration * 1000));
            if (gVar.guL.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Bk(String.format("%.1f", Float.valueOf(((float) gVar.guL.videoSize) / 1048576.0f))));
            }
            this.gub.setText(format);
            this.gua.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.guL != null) {
            this.guk.stopPlay();
            this.guk.setIsNeedRecoveryVideoPlayer(true);
            this.guk.rL(true);
            this.guk.rH(false);
            this.guk.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    if (b.this.guk.le()) {
                        b.this.gtZ.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    if (b.this.guk.le()) {
                        b.this.gtZ.setVisibility(8);
                    }
                    if (b.this.guq) {
                        b.this.guk.stopPlay();
                    }
                }
            });
            this.guk.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bGo() {
                    b.this.guq = false;
                    b.this.gtZ.setVisibility(8);
                    b.this.Bj(b.this.cWm ? "1" : "2");
                    b.this.onClick(b.this.gtX);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGp() {
                    b.this.gtZ.setVisibility(8);
                    b.this.onClick(b.this.gtW);
                }
            });
            this.guk.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void lH(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.gub.getText().toString());
                        b.this.guk.ei(b.this.gul.guL.videoUrl, b.this.gul.threadId);
                        b.this.gtZ.setVisibility(8);
                        b.this.Bj("2");
                    } else {
                        b.this.gua.setVisibility(0);
                    }
                    b.this.onClick(b.this.gtX);
                }
            });
            this.guk.rD(false);
            this.gun = new y();
            this.gun.Pj = gVar.threadId;
            this.gun.emo = gVar.forumId;
            this.gun.mUid = TbadkCoreApplication.getCurrentAccount();
            this.guo = new y();
            this.guo.Pj = gVar.threadId;
            this.guo.emo = gVar.forumId;
            this.guo.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.gut) {
                an anVar = new an("c12590");
                anVar.cy("tid", gVar.threadId);
                anVar.X("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cy("fid", gVar.forumId);
                anVar.X("obj_locate", i);
                anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.gun.jwS = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.gun.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.gun.jwU = "1";
                this.guo.jwS = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.guo.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.guo.jwU = "1";
            } else {
                this.gun.jwU = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.gun.mLocate = "12";
                this.guo.jwU = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.guo.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.guL != null) {
                this.gun.jwW = gVar.guL.videoMd5;
                this.guo.jwW = gVar.guL.videoMd5;
            }
            this.elm.setVideoStatsData(this.gun);
            this.guk.getVideoView().setBusiness(this.elm);
            this.guk.ccH();
            this.guk.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void lI(boolean z) {
                    if (!b.this.guk.le()) {
                        b.this.gtY.setVisibility(0);
                    } else if (z) {
                        if (b.this.gtY.getVisibility() == 0) {
                            b.this.gtY.setVisibility(8);
                            b.this.gtY.startAnimation(b.this.gur);
                        }
                    } else if (b.this.gtY.getVisibility() == 8) {
                        b.this.gtY.setVisibility(0);
                        b.this.gtY.startAnimation(b.this.aLy);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGq() {
                    if (!b.this.guk.le()) {
                        b.this.gtY.setVisibility(0);
                    } else if (b.this.gtY.getVisibility() == 0) {
                        b.this.gtY.setVisibility(8);
                        b.this.gtY.startAnimation(b.this.gur);
                    }
                }
            });
            this.guk.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.guq = true;
                        b.this.gup = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.te(i);
                        b.this.guk.bPP();
                    }
                }
            });
            this.guk.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.gul != null && b.this.gul.guL != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.gul.guL.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.guk.setThumbnail(gVar.guL.thumbnailUrl);
            this.guk.setVideoUrl(gVar.guL.videoUrl, gVar.threadId);
            this.guk.GY(gVar.title);
            this.guk.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bGr() {
                    b.this.gtZ.setVisibility(8);
                }
            });
            this.guk.bPP();
            this.guk.show();
            if (gVar.autoPlay) {
                onClick(this.gtX);
                this.guq = false;
                this.guk.a(gVar.guL.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.guq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(String str) {
        if (this.gul != null && this.gul.guL != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gul.guL.videoMd5, "", str, this.guo);
            }
        }
    }

    public boolean isPlaying() {
        return this.guk.le();
    }

    public void bGk() {
        if (isPlaying()) {
            this.guk.pausePlay();
        }
    }

    public boolean tf(int i) {
        return this.guk.Am(i);
    }

    public void bGl() {
        this.gua.setVisibility(8);
        this.guk.stopPlay();
        if (this.gtY != null) {
            this.gtY.setVisibility(0);
        }
        if (this.gtZ != null) {
            this.gtZ.setVisibility(0);
        }
    }

    public void bGm() {
        if (this.guk != null) {
            this.guk.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGm();
        if (this.gum != null) {
            this.gum.bGw();
        }
    }

    public String Bk(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.guK != null) {
            this.Nl.setText(TextUtils.isEmpty(gVar.guK.userNickname) ? gVar.guK.userName : gVar.guK.userNickname);
            this.gud.startLoad(gVar.guK.portrait, 12, false);
            this.gud.setShowV(gVar.guK.isGod);
            this.gud.setIsBigV(gVar.guK.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.guK != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.guK.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.guK.userId)) {
                this.fdo.setVisibility(8);
            } else {
                this.fdo.setVisibility(0);
            }
            if (gVar.guK.hasFocus) {
                am.setViewTextColor(this.fdo, (int) R.color.cp_cont_d);
                this.fdo.setCompoundDrawables(null, null, null, null);
                this.fdo.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fdo, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fdo.setCompoundDrawables(drawable, null, null, null);
            this.fdo.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.guh.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.guf, (int) R.color.cp_cont_h);
            } else {
                this.guh.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.guf, (int) R.color.cp_cont_f);
            }
            this.guf.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.gue, (int) R.color.cp_cont_f);
            this.gug.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.gue.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.guk != null && this.gtX != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.gup) {
                this.guk.cyh();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.gtX.getParent() != null) {
                    if (this.gtX.getParent() == frameLayout) {
                        frameLayout.removeView(this.gtX);
                    } else if (this.gtX.getParent() == this.gtW) {
                        this.gtW.removeView(this.gtX);
                    }
                }
                if (this.gtX.getParent() == null) {
                    frameLayout.addView(this.gtX);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gtX.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.gtX.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.gtX.getParent() != null) {
                    if (this.gtX.getParent() == frameLayout) {
                        frameLayout.removeView(this.gtX);
                    } else if (this.gtX.getParent() == this.gtW) {
                        this.gtW.removeView(this.gtX);
                    }
                }
                if (this.gtX.getParent() == null) {
                    this.gtW.addView(this.gtX, 0);
                    this.gtX.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.guk.ccH();
                    this.gup = true;
                } else {
                    return;
                }
            }
            this.guk.a(this.mPageContext, configuration);
            this.gtZ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            view.setTag(this);
            buH().a(view, this.gul);
        }
        if (view == this.gud || view == this.Nl) {
            boolean z = false;
            if (this.gul != null && this.gul.guK != null && !TextUtils.isEmpty(this.gul.guK.userId)) {
                if (TbadkCoreApplication.isLogin() && this.gul.guK.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gul.guK.userId, 0L), z, this.gul.guK.isGod)));
            }
        } else if (view == this.gui || view == this.gtY || view == getView()) {
            if (this.gul != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.gul.threadId, null, null);
                if (!this.gut) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.guc) {
            if (this.gul != null && this.gul.guL != null) {
                this.gua.setVisibility(8);
                this.guk.cyk();
                this.guk.ei(this.gul.guL.videoUrl, this.gul.threadId);
                Bj("2");
            }
        } else if (view == this.fdo) {
            if (!this.gul.guK.hasFocus) {
                this.gum.f(this.gul);
            }
        } else if (view == this.guj) {
            this.gum.g(this.gul);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lG(boolean z) {
        if (this.gul != null && this.gul.guK != null) {
            this.gul.guK.hasFocus = z;
            c(this.gul);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGn() {
        if (this.gul != null) {
            this.gul.hasAgree = !this.gul.hasAgree;
            if (this.gul.hasAgree) {
                this.gul.agreeNum++;
            } else {
                this.gul.agreeNum--;
            }
            if (this.guh != null) {
                this.guh.startAnimation(getScaleAnimation());
            }
            d(this.gul);
        }
    }

    private Animation getScaleAnimation() {
        if (this.gus == null) {
            this.gus = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.gus.setDuration(200L);
        }
        return this.gus;
    }
}
