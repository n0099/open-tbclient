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
    public TextView afZ;
    private Animation bhy;
    private boolean dvO;
    private n ePh;
    public TextView fIb;
    public FrameLayout hdR;
    public FrameLayout hdS;
    public TextView hdT;
    public TextView hdU;
    public FrameLayout hdV;
    public TextView hdW;
    public TextView hdX;
    public HeadImageView hdY;
    public TextView hdZ;
    public TextView hea;
    public ImageView heb;
    public ImageView hec;
    public LinearLayout hed;
    public LinearLayout hee;
    public com.baidu.tieba.play.c hef;
    public g heg;
    private h heh;
    private y hei;
    private y hej;
    private boolean hek;
    private boolean hel;
    private Animation hem;
    private ScaleAnimation hen;
    private boolean heo;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.hek = true;
        this.heo = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hdR = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hdS = (FrameLayout) view.findViewById(R.id.video_container);
        this.hef = new com.baidu.tieba.play.c(tbPageContext, this.hdS, false);
        this.hdT = (TextView) view.findViewById(R.id.title);
        this.hdU = (TextView) view.findViewById(R.id.duration);
        this.hdV = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hdW = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hdX = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hdY = (HeadImageView) view.findViewById(R.id.user_icon);
        this.afZ = (TextView) view.findViewById(R.id.user_name);
        this.fIb = (TextView) view.findViewById(R.id.attention);
        this.hed = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.hee = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hdZ = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hea = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.heb = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.hec = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.hed.setOnClickListener(this);
        this.hee.setOnClickListener(this);
        this.hdT.setOnClickListener(this);
        this.hdY.setOnClickListener(this);
        this.afZ.setOnClickListener(this);
        this.fIb.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hdX.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdR.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hdR.setLayoutParams(layoutParams);
        this.hdY.setIsRound(true);
        this.ePh = new n(tbPageContext.getPageActivity());
        this.heh = new h(this.mPageContext, this);
        this.hem = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bhy = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.heg != null && this.heg.heF != null) {
                if (this.heg.heF.hasFocus) {
                    am.setViewTextColor(this.fIb, (int) R.color.cp_cont_d);
                    this.fIb.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fIb, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fIb.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.heg != null) {
                if (this.heg.hasAgree) {
                    this.hec.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.hea, (int) R.color.cp_cont_h);
                } else {
                    this.hec.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.hea, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.hdZ, (int) R.color.cp_cont_f);
            this.heb.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.heG != null) {
            this.heg = gVar;
            this.dvO = this.heg.autoPlay;
            this.hdT.setVisibility(0);
            this.hdT.setText(gVar.title);
            this.hdU.setVisibility(0);
            this.hdU.setText(aq.stringForVideoTime(gVar.heG.videoDuration * 1000));
            if (gVar.heG.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), CY(String.format("%.1f", Float.valueOf(((float) gVar.heG.videoSize) / 1048576.0f))));
            }
            this.hdW.setText(format);
            this.hdV.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.heG != null) {
            this.hef.stopPlay();
            this.hef.setIsNeedRecoveryVideoPlayer(true);
            this.hef.sV(true);
            this.hef.sR(false);
            this.hef.a(new c.InterfaceC0650c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pG() {
                    if (b.this.hef.pI()) {
                        b.this.hdU.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pH() {
                    if (b.this.hef.pI()) {
                        b.this.hdU.setVisibility(8);
                    }
                    if (b.this.hel) {
                        b.this.hef.stopPlay();
                    }
                }
            });
            this.hef.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bQZ() {
                    b.this.hel = false;
                    b.this.hdU.setVisibility(8);
                    b.this.CX(b.this.dvO ? "1" : "2");
                    b.this.onClick(b.this.hdS);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bRa() {
                    b.this.hdU.setVisibility(8);
                    b.this.onClick(b.this.hdR);
                }
            });
            this.hef.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void mQ(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hdW.getText().toString());
                        b.this.hef.ev(b.this.heg.heG.videoUrl, b.this.heg.threadId);
                        b.this.hdU.setVisibility(8);
                        b.this.CX("2");
                    } else {
                        b.this.hdV.setVisibility(0);
                    }
                    b.this.onClick(b.this.hdS);
                }
            });
            this.hef.sN(false);
            this.hei = new y();
            this.hei.ahO = gVar.threadId;
            this.hei.eQk = gVar.forumId;
            this.hei.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hej = new y();
            this.hej.ahO = gVar.threadId;
            this.hej.eQk = gVar.forumId;
            this.hej.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.heo) {
                an anVar = new an("c12590");
                anVar.cI("tid", gVar.threadId);
                anVar.af("obj_param5", gVar.getVideoType());
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cI("fid", gVar.forumId);
                anVar.af("obj_locate", i);
                anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.hei.kir = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hei.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.hei.kit = "1";
                this.hej.kir = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hej.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hej.kit = "1";
            } else {
                this.hei.kit = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hei.mLocate = "12";
                this.hej.kit = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hej.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.heG != null) {
                this.hei.kiw = gVar.heG.videoMd5;
                this.hej.kiw = gVar.heG.videoMd5;
            }
            this.ePh.setVideoStatsData(this.hei);
            this.hef.getVideoView().setBusiness(this.ePh);
            this.hef.cny();
            this.hef.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void mR(boolean z) {
                    if (!b.this.hef.pI()) {
                        b.this.hdT.setVisibility(0);
                    } else if (z) {
                        if (b.this.hdT.getVisibility() == 0) {
                            b.this.hdT.setVisibility(8);
                            b.this.hdT.startAnimation(b.this.hem);
                        }
                    } else if (b.this.hdT.getVisibility() == 8) {
                        b.this.hdT.setVisibility(0);
                        b.this.hdT.startAnimation(b.this.bhy);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bRb() {
                    if (!b.this.hef.pI()) {
                        b.this.hdT.setVisibility(0);
                    } else if (b.this.hdT.getVisibility() == 0) {
                        b.this.hdT.setVisibility(8);
                        b.this.hdT.startAnimation(b.this.hem);
                    }
                }
            });
            this.hef.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.hel = true;
                        b.this.hek = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.tE(i);
                        b.this.hef.caF();
                    }
                }
            });
            this.hef.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.heg != null && b.this.heg.heG != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.heg.heG.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hef.setThumbnail(gVar.heG.thumbnailUrl);
            this.hef.setVideoUrl(gVar.heG.videoUrl, gVar.threadId);
            this.hef.II(gVar.title);
            this.hef.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bRc() {
                    b.this.hdU.setVisibility(8);
                }
            });
            this.hef.caF();
            this.hef.show();
            if (gVar.autoPlay) {
                onClick(this.hdS);
                this.hel = false;
                this.hef.a(gVar.heG.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.hel = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CX(String str) {
        if (this.heg != null && this.heg.heG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.heg.heG.videoMd5, "", str, this.hej);
            }
        }
    }

    public boolean isPlaying() {
        return this.hef.pI();
    }

    public void bQV() {
        if (isPlaying()) {
            this.hef.asl();
        }
    }

    public boolean tF(int i) {
        return this.hef.AU(i);
    }

    public void bQW() {
        this.hdV.setVisibility(8);
        this.hef.stopPlay();
        if (this.hdT != null) {
            this.hdT.setVisibility(0);
        }
        if (this.hdU != null) {
            this.hdU.setVisibility(0);
        }
    }

    public void bQX() {
        if (this.hef != null) {
            this.hef.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bQX();
        if (this.heh != null) {
            this.heh.bRh();
        }
    }

    public String CY(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.heF != null) {
            this.afZ.setText(TextUtils.isEmpty(gVar.heF.userNickname) ? gVar.heF.userName : gVar.heF.userNickname);
            this.hdY.startLoad(gVar.heF.portrait, 12, false);
            this.hdY.setShowV(gVar.heF.isGod);
            this.hdY.setIsBigV(gVar.heF.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.heF != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.heF.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.heF.userId)) {
                this.fIb.setVisibility(8);
            } else {
                this.fIb.setVisibility(0);
            }
            if (gVar.heF.hasFocus) {
                am.setViewTextColor(this.fIb, (int) R.color.cp_cont_d);
                this.fIb.setCompoundDrawables(null, null, null, null);
                this.fIb.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fIb, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fIb.setCompoundDrawables(drawable, null, null, null);
            this.fIb.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.hec.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.hea, (int) R.color.cp_cont_h);
            } else {
                this.hec.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.hea, (int) R.color.cp_cont_f);
            }
            this.hea.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.hdZ, (int) R.color.cp_cont_f);
            this.heb.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.hdZ.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hef != null && this.hdS != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hek) {
                this.hef.cJc();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hdS.getParent() != null) {
                    if (this.hdS.getParent() == frameLayout) {
                        frameLayout.removeView(this.hdS);
                    } else if (this.hdS.getParent() == this.hdR) {
                        this.hdR.removeView(this.hdS);
                    }
                }
                if (this.hdS.getParent() == null) {
                    frameLayout.addView(this.hdS);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdS.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hdS.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hdS.getParent() != null) {
                    if (this.hdS.getParent() == frameLayout) {
                        frameLayout.removeView(this.hdS);
                    } else if (this.hdS.getParent() == this.hdR) {
                        this.hdR.removeView(this.hdS);
                    }
                }
                if (this.hdS.getParent() == null) {
                    this.hdR.addView(this.hdS, 0);
                    this.hdS.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hef.cny();
                    this.hek = true;
                } else {
                    return;
                }
            }
            this.hef.a(this.mPageContext, configuration);
            this.hdU.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEw() != null) {
            view.setTag(this);
            bEw().a(view, this.heg);
        }
        if (view == this.hdY || view == this.afZ) {
            boolean z = false;
            if (this.heg != null && this.heg.heF != null && !TextUtils.isEmpty(this.heg.heF.userId)) {
                if (TbadkCoreApplication.isLogin() && this.heg.heF.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.heg.heF.userId, 0L), z, this.heg.heF.isGod)));
            }
        } else if (view == this.hed || view == this.hdT || view == getView()) {
            if (this.heg != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.heg.threadId, null, null);
                if (!this.heo) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hdX) {
            if (this.heg != null && this.heg.heG != null) {
                this.hdV.setVisibility(8);
                this.hef.cJf();
                this.hef.ev(this.heg.heG.videoUrl, this.heg.threadId);
                CX("2");
            }
        } else if (view == this.fIb) {
            if (!this.heg.heF.hasFocus) {
                this.heh.f(this.heg);
            }
        } else if (view == this.hee) {
            this.heh.g(this.heg);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void mP(boolean z) {
        if (this.heg != null && this.heg.heF != null) {
            this.heg.heF.hasFocus = z;
            c(this.heg);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bQY() {
        if (this.heg != null) {
            this.heg.hasAgree = !this.heg.hasAgree;
            if (this.heg.hasAgree) {
                this.heg.agreeNum++;
            } else {
                this.heg.agreeNum--;
            }
            if (this.hec != null) {
                this.hec.startAnimation(getScaleAnimation());
            }
            d(this.heg);
        }
    }

    private Animation getScaleAnimation() {
        if (this.hen == null) {
            this.hen = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.hen.setDuration(200L);
        }
        return this.hen;
    }
}
