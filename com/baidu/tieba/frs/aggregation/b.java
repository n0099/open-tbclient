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
    public TextView afW;
    private Animation bht;
    private boolean dvK;
    private n ePc;
    public TextView fHW;
    public FrameLayout hdL;
    public FrameLayout hdM;
    public TextView hdN;
    public TextView hdO;
    public FrameLayout hdP;
    public TextView hdQ;
    public TextView hdR;
    public HeadImageView hdS;
    public TextView hdT;
    public TextView hdU;
    public ImageView hdV;
    public ImageView hdW;
    public LinearLayout hdX;
    public LinearLayout hdY;
    public com.baidu.tieba.play.c hdZ;
    public g hea;
    private h heb;
    private y hec;
    private y hed;
    private boolean hee;
    private boolean hef;
    private Animation heg;
    private ScaleAnimation heh;
    private boolean hei;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.hee = true;
        this.hei = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hdL = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hdM = (FrameLayout) view.findViewById(R.id.video_container);
        this.hdZ = new com.baidu.tieba.play.c(tbPageContext, this.hdM, false);
        this.hdN = (TextView) view.findViewById(R.id.title);
        this.hdO = (TextView) view.findViewById(R.id.duration);
        this.hdP = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hdQ = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hdR = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hdS = (HeadImageView) view.findViewById(R.id.user_icon);
        this.afW = (TextView) view.findViewById(R.id.user_name);
        this.fHW = (TextView) view.findViewById(R.id.attention);
        this.hdX = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.hdY = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hdT = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hdU = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hdV = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.hdW = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.hdX.setOnClickListener(this);
        this.hdY.setOnClickListener(this);
        this.hdN.setOnClickListener(this);
        this.hdS.setOnClickListener(this);
        this.afW.setOnClickListener(this);
        this.fHW.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hdR.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdL.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hdL.setLayoutParams(layoutParams);
        this.hdS.setIsRound(true);
        this.ePc = new n(tbPageContext.getPageActivity());
        this.heb = new h(this.mPageContext, this);
        this.heg = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bht = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.hea != null && this.hea.hez != null) {
                if (this.hea.hez.hasFocus) {
                    am.setViewTextColor(this.fHW, (int) R.color.cp_cont_d);
                    this.fHW.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fHW, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fHW.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.hea != null) {
                if (this.hea.hasAgree) {
                    this.hdW.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.hdU, (int) R.color.cp_cont_h);
                } else {
                    this.hdW.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.hdU, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.hdT, (int) R.color.cp_cont_f);
            this.hdV.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.heA != null) {
            this.hea = gVar;
            this.dvK = this.hea.autoPlay;
            this.hdN.setVisibility(0);
            this.hdN.setText(gVar.title);
            this.hdO.setVisibility(0);
            this.hdO.setText(aq.stringForVideoTime(gVar.heA.videoDuration * 1000));
            if (gVar.heA.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), CV(String.format("%.1f", Float.valueOf(((float) gVar.heA.videoSize) / 1048576.0f))));
            }
            this.hdQ.setText(format);
            this.hdP.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.heA != null) {
            this.hdZ.stopPlay();
            this.hdZ.setIsNeedRecoveryVideoPlayer(true);
            this.hdZ.sV(true);
            this.hdZ.sR(false);
            this.hdZ.a(new c.InterfaceC0629c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pG() {
                    if (b.this.hdZ.pI()) {
                        b.this.hdO.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pH() {
                    if (b.this.hdZ.pI()) {
                        b.this.hdO.setVisibility(8);
                    }
                    if (b.this.hef) {
                        b.this.hdZ.stopPlay();
                    }
                }
            });
            this.hdZ.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bRb() {
                    b.this.hef = false;
                    b.this.hdO.setVisibility(8);
                    b.this.CU(b.this.dvK ? "1" : "2");
                    b.this.onClick(b.this.hdM);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bRc() {
                    b.this.hdO.setVisibility(8);
                    b.this.onClick(b.this.hdL);
                }
            });
            this.hdZ.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void mQ(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hdQ.getText().toString());
                        b.this.hdZ.ev(b.this.hea.heA.videoUrl, b.this.hea.threadId);
                        b.this.hdO.setVisibility(8);
                        b.this.CU("2");
                    } else {
                        b.this.hdP.setVisibility(0);
                    }
                    b.this.onClick(b.this.hdM);
                }
            });
            this.hdZ.sN(false);
            this.hec = new y();
            this.hec.ahL = gVar.threadId;
            this.hec.eQf = gVar.forumId;
            this.hec.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hed = new y();
            this.hed.ahL = gVar.threadId;
            this.hed.eQf = gVar.forumId;
            this.hed.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.hei) {
                an anVar = new an("c12590");
                anVar.cI("tid", gVar.threadId);
                anVar.af("obj_param5", gVar.getVideoType());
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cI("fid", gVar.forumId);
                anVar.af("obj_locate", i);
                anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.hec.kin = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hec.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.hec.kip = "1";
                this.hed.kin = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hed.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hed.kip = "1";
            } else {
                this.hec.kip = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hec.mLocate = "12";
                this.hed.kip = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hed.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.heA != null) {
                this.hec.kis = gVar.heA.videoMd5;
                this.hed.kis = gVar.heA.videoMd5;
            }
            this.ePc.setVideoStatsData(this.hec);
            this.hdZ.getVideoView().setBusiness(this.ePc);
            this.hdZ.cnB();
            this.hdZ.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void mR(boolean z) {
                    if (!b.this.hdZ.pI()) {
                        b.this.hdN.setVisibility(0);
                    } else if (z) {
                        if (b.this.hdN.getVisibility() == 0) {
                            b.this.hdN.setVisibility(8);
                            b.this.hdN.startAnimation(b.this.heg);
                        }
                    } else if (b.this.hdN.getVisibility() == 8) {
                        b.this.hdN.setVisibility(0);
                        b.this.hdN.startAnimation(b.this.bht);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bRd() {
                    if (!b.this.hdZ.pI()) {
                        b.this.hdN.setVisibility(0);
                    } else if (b.this.hdN.getVisibility() == 0) {
                        b.this.hdN.setVisibility(8);
                        b.this.hdN.startAnimation(b.this.heg);
                    }
                }
            });
            this.hdZ.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.hef = true;
                        b.this.hee = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.tE(i);
                        b.this.hdZ.caH();
                    }
                }
            });
            this.hdZ.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.hea != null && b.this.hea.heA != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.hea.heA.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hdZ.setThumbnail(gVar.heA.thumbnailUrl);
            this.hdZ.setVideoUrl(gVar.heA.videoUrl, gVar.threadId);
            this.hdZ.IF(gVar.title);
            this.hdZ.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bRe() {
                    b.this.hdO.setVisibility(8);
                }
            });
            this.hdZ.caH();
            this.hdZ.show();
            if (gVar.autoPlay) {
                onClick(this.hdM);
                this.hef = false;
                this.hdZ.a(gVar.heA.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.hef = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU(String str) {
        if (this.hea != null && this.hea.heA != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hea.heA.videoMd5, "", str, this.hed);
            }
        }
    }

    public boolean isPlaying() {
        return this.hdZ.pI();
    }

    public void bQX() {
        if (isPlaying()) {
            this.hdZ.asn();
        }
    }

    public boolean tF(int i) {
        return this.hdZ.AU(i);
    }

    public void bQY() {
        this.hdP.setVisibility(8);
        this.hdZ.stopPlay();
        if (this.hdN != null) {
            this.hdN.setVisibility(0);
        }
        if (this.hdO != null) {
            this.hdO.setVisibility(0);
        }
    }

    public void bQZ() {
        if (this.hdZ != null) {
            this.hdZ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bQZ();
        if (this.heb != null) {
            this.heb.bRj();
        }
    }

    public String CV(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.hez != null) {
            this.afW.setText(TextUtils.isEmpty(gVar.hez.userNickname) ? gVar.hez.userName : gVar.hez.userNickname);
            this.hdS.startLoad(gVar.hez.portrait, 12, false);
            this.hdS.setShowV(gVar.hez.isGod);
            this.hdS.setIsBigV(gVar.hez.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.hez != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.hez.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.hez.userId)) {
                this.fHW.setVisibility(8);
            } else {
                this.fHW.setVisibility(0);
            }
            if (gVar.hez.hasFocus) {
                am.setViewTextColor(this.fHW, (int) R.color.cp_cont_d);
                this.fHW.setCompoundDrawables(null, null, null, null);
                this.fHW.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fHW, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fHW.setCompoundDrawables(drawable, null, null, null);
            this.fHW.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.hdW.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.hdU, (int) R.color.cp_cont_h);
            } else {
                this.hdW.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.hdU, (int) R.color.cp_cont_f);
            }
            this.hdU.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.hdT, (int) R.color.cp_cont_f);
            this.hdV.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.hdT.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hdZ != null && this.hdM != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hee) {
                this.hdZ.cJf();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hdM.getParent() != null) {
                    if (this.hdM.getParent() == frameLayout) {
                        frameLayout.removeView(this.hdM);
                    } else if (this.hdM.getParent() == this.hdL) {
                        this.hdL.removeView(this.hdM);
                    }
                }
                if (this.hdM.getParent() == null) {
                    frameLayout.addView(this.hdM);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdM.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hdM.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hdM.getParent() != null) {
                    if (this.hdM.getParent() == frameLayout) {
                        frameLayout.removeView(this.hdM);
                    } else if (this.hdM.getParent() == this.hdL) {
                        this.hdL.removeView(this.hdM);
                    }
                }
                if (this.hdM.getParent() == null) {
                    this.hdL.addView(this.hdM, 0);
                    this.hdM.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hdZ.cnB();
                    this.hee = true;
                } else {
                    return;
                }
            }
            this.hdZ.a(this.mPageContext, configuration);
            this.hdO.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEy() != null) {
            view.setTag(this);
            bEy().a(view, this.hea);
        }
        if (view == this.hdS || view == this.afW) {
            boolean z = false;
            if (this.hea != null && this.hea.hez != null && !TextUtils.isEmpty(this.hea.hez.userId)) {
                if (TbadkCoreApplication.isLogin() && this.hea.hez.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hea.hez.userId, 0L), z, this.hea.hez.isGod)));
            }
        } else if (view == this.hdX || view == this.hdN || view == getView()) {
            if (this.hea != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hea.threadId, null, null);
                if (!this.hei) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hdR) {
            if (this.hea != null && this.hea.heA != null) {
                this.hdP.setVisibility(8);
                this.hdZ.cJi();
                this.hdZ.ev(this.hea.heA.videoUrl, this.hea.threadId);
                CU("2");
            }
        } else if (view == this.fHW) {
            if (!this.hea.hez.hasFocus) {
                this.heb.f(this.hea);
            }
        } else if (view == this.hdY) {
            this.heb.g(this.hea);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void mP(boolean z) {
        if (this.hea != null && this.hea.hez != null) {
            this.hea.hez.hasFocus = z;
            c(this.hea);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bRa() {
        if (this.hea != null) {
            this.hea.hasAgree = !this.hea.hasAgree;
            if (this.hea.hasAgree) {
                this.hea.agreeNum++;
            } else {
                this.hea.agreeNum--;
            }
            if (this.hdW != null) {
                this.hdW.startAnimation(getScaleAnimation());
            }
            d(this.hea);
        }
    }

    private Animation getScaleAnimation() {
        if (this.heh == null) {
            this.heh = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.heh.setDuration(200L);
        }
        return this.heh;
    }
}
