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
import com.baidu.android.imsdk.internal.DefaultConfig;
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
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView HE;
    private Animation azf;
    private boolean cgq;
    private n dwz;
    public TextView ehT;
    public FrameLayout fAT;
    public FrameLayout fAU;
    public TextView fAV;
    public TextView fAW;
    public FrameLayout fAX;
    public TextView fAY;
    public TextView fAZ;
    public HeadImageView fBa;
    public TextView fBb;
    public TextView fBc;
    public ImageView fBd;
    public ImageView fBe;
    public LinearLayout fBf;
    public LinearLayout fBg;
    public com.baidu.tieba.play.c fBh;
    public g fBi;
    private h fBj;
    private z fBk;
    private z fBl;
    private boolean fBm;
    private boolean fBn;
    private Animation fBo;
    private ScaleAnimation fBp;
    private boolean fBq;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fBm = true;
        this.fBq = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fAT = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fAU = (FrameLayout) view.findViewById(R.id.video_container);
        this.fBh = new com.baidu.tieba.play.c(tbPageContext, (View) this.fAU, false);
        this.fAV = (TextView) view.findViewById(R.id.title);
        this.fAW = (TextView) view.findViewById(R.id.duration);
        this.fAX = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.fAY = (TextView) view.findViewById(R.id.mobile_network_text);
        this.fAZ = (TextView) view.findViewById(R.id.mobile_network_play);
        this.fBa = (HeadImageView) view.findViewById(R.id.user_icon);
        this.HE = (TextView) view.findViewById(R.id.user_name);
        this.ehT = (TextView) view.findViewById(R.id.attention);
        this.fBf = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.fBg = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.fBb = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fBc = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.fBd = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fBe = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.fBf.setOnClickListener(this);
        this.fBg.setOnClickListener(this);
        this.fAV.setOnClickListener(this);
        this.fBa.setOnClickListener(this);
        this.HE.setOnClickListener(this);
        this.ehT.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fAZ.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fAT.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fAT.setLayoutParams(layoutParams);
        this.fBa.setIsRound(true);
        this.dwz = new n(tbPageContext.getPageActivity());
        this.fBj = new h(this.mPageContext, this);
        this.fBo = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.azf = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.fBi != null && this.fBi.fBH != null) {
                if (this.fBi.fBH.hasFocus) {
                    am.setViewTextColor(this.ehT, (int) R.color.cp_cont_d);
                    this.ehT.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.ehT, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.ehT.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fBi != null) {
                if (this.fBi.hasAgree) {
                    this.fBe.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.fBc, (int) R.color.cp_cont_h);
                } else {
                    this.fBe.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.fBc, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.fBb, (int) R.color.cp_cont_f);
            this.fBd.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.fBI != null) {
            this.fBi = gVar;
            this.cgq = this.fBi.autoPlay;
            this.fAV.setVisibility(0);
            this.fAV.setText(gVar.title);
            this.fAW.setVisibility(0);
            this.fAW.setText(aq.stringForVideoTime(gVar.fBI.videoDuration * 1000));
            if (gVar.fBI.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), vS(String.format("%.1f", Float.valueOf(((float) gVar.fBI.videoSize) / 1048576.0f))));
            }
            this.fAY.setText(format);
            this.fAX.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.fBI != null) {
            this.fBh.stopPlay();
            this.fBh.setIsNeedRecoveryVideoPlayer(true);
            this.fBh.pN(true);
            this.fBh.pJ(false);
            this.fBh.a(new c.InterfaceC0497c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kv() {
                    if (b.this.fBh.kx()) {
                        b.this.fAW.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kw() {
                    if (b.this.fBh.kx()) {
                        b.this.fAW.setVisibility(8);
                    }
                    if (b.this.fBn) {
                        b.this.fBh.stopPlay();
                    }
                }
            });
            this.fBh.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bmm() {
                    b.this.fBn = false;
                    b.this.fAW.setVisibility(8);
                    b.this.vR(b.this.cgq ? "1" : "2");
                    b.this.onClick(b.this.fAU);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bmn() {
                    b.this.fAW.setVisibility(8);
                    b.this.onClick(b.this.fAT);
                }
            });
            this.fBh.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fAY.getText().toString());
                        b.this.fBh.cm(b.this.fBi.fBI.videoUrl, b.this.fBi.threadId);
                        b.this.fAW.setVisibility(8);
                        b.this.vR("2");
                    } else {
                        b.this.fAX.setVisibility(0);
                    }
                    b.this.onClick(b.this.fAU);
                }
            });
            this.fBh.pF(false);
            this.fBk = new z();
            this.fBk.cmS = gVar.threadId;
            this.fBk.ePT = gVar.forumId;
            this.fBk.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fBl = new z();
            this.fBl.cmS = gVar.threadId;
            this.fBl.ePT = gVar.forumId;
            this.fBl.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fBq) {
                an anVar = new an("c12590");
                anVar.bS("tid", gVar.threadId);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bS("fid", gVar.forumId);
                anVar.O("obj_locate", i);
                anVar.O(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.fBk.iza = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.fBk.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.fBk.izc = "1";
                this.fBl.iza = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.fBl.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.fBl.izc = "1";
            } else {
                this.fBk.izc = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.fBk.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fBl.izc = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.fBl.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.fBI != null) {
                this.fBk.ize = gVar.fBI.videoMd5;
                this.fBl.ize = gVar.fBI.videoMd5;
            }
            this.dwz.setVideoStatsData(this.fBk);
            this.fBh.getVideoView().setBusiness(this.dwz);
            this.fBh.bII();
            this.fBh.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (!b.this.fBh.kx()) {
                        b.this.fAV.setVisibility(0);
                    } else if (z) {
                        if (b.this.fAV.getVisibility() == 0) {
                            b.this.fAV.setVisibility(8);
                            b.this.fAV.startAnimation(b.this.fBo);
                        }
                    } else if (b.this.fAV.getVisibility() == 8) {
                        b.this.fAV.setVisibility(0);
                        b.this.fAV.startAnimation(b.this.azf);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmo() {
                    if (!b.this.fBh.kx()) {
                        b.this.fAV.setVisibility(0);
                    } else if (b.this.fAV.getVisibility() == 0) {
                        b.this.fAV.setVisibility(8);
                        b.this.fAV.startAnimation(b.this.fBo);
                    }
                }
            });
            this.fBh.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fBn = true;
                        b.this.fBm = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.qO(i);
                        b.this.fBh.bvM();
                    }
                }
            });
            this.fBh.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fBi != null && b.this.fBi.fBI != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fBi.fBI.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fBh.setThumbnail(gVar.fBI.thumbnailUrl);
            this.fBh.setVideoUrl(gVar.fBI.videoUrl, gVar.threadId);
            this.fBh.BN(gVar.title);
            this.fBh.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bmp() {
                    b.this.fAW.setVisibility(8);
                }
            });
            this.fBh.bvM();
            this.fBh.show();
            if (gVar.autoPlay) {
                onClick(this.fAU);
                this.fBn = false;
                this.fBh.a(gVar.fBI.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fBn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(String str) {
        if (this.fBi != null && this.fBi.fBI != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fBi.fBI.videoMd5, "", str, this.fBl);
            }
        }
    }

    public boolean isPlaying() {
        return this.fBh.kx();
    }

    public void bmi() {
        if (isPlaying()) {
            this.fBh.pausePlay();
        }
    }

    public boolean qP(int i) {
        return this.fBh.xD(i);
    }

    public void bmj() {
        this.fAX.setVisibility(8);
        this.fBh.stopPlay();
        if (this.fAV != null) {
            this.fAV.setVisibility(0);
        }
        if (this.fAW != null) {
            this.fAW.setVisibility(0);
        }
    }

    public void bmk() {
        if (this.fBh != null) {
            this.fBh.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmk();
        if (this.fBj != null) {
            this.fBj.bmv();
        }
    }

    public String vS(String str) {
        if (str.indexOf(DefaultConfig.TOKEN_SEPARATOR) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.fBH != null) {
            this.HE.setText(TextUtils.isEmpty(gVar.fBH.userNickname) ? gVar.fBH.userName : gVar.fBH.userNickname);
            this.fBa.startLoad(gVar.fBH.portrait, 12, false);
            this.fBa.setShowV(gVar.fBH.isGod);
            this.fBa.setIsBigV(gVar.fBH.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.fBH != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.fBH.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.fBH.userId)) {
                this.ehT.setVisibility(8);
            } else {
                this.ehT.setVisibility(0);
            }
            if (gVar.fBH.hasFocus) {
                am.setViewTextColor(this.ehT, (int) R.color.cp_cont_d);
                this.ehT.setCompoundDrawables(null, null, null, null);
                this.ehT.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.ehT, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.ehT.setCompoundDrawables(drawable, null, null, null);
            this.ehT.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.fBe.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.fBc, (int) R.color.cp_cont_h);
            } else {
                this.fBe.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.fBc, (int) R.color.cp_cont_f);
            }
            this.fBc.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.fBb, (int) R.color.cp_cont_f);
            this.fBd.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.fBb.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fBh != null && this.fAU != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fBm) {
                this.fBh.cbM();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fAU.getParent() != null) {
                    if (this.fAU.getParent() == frameLayout) {
                        frameLayout.removeView(this.fAU);
                    } else if (this.fAU.getParent() == this.fAT) {
                        this.fAT.removeView(this.fAU);
                    }
                }
                if (this.fAU.getParent() == null) {
                    frameLayout.addView(this.fAU);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fAU.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fAU.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fAU.getParent() != null) {
                    if (this.fAU.getParent() == frameLayout) {
                        frameLayout.removeView(this.fAU);
                    } else if (this.fAU.getParent() == this.fAT) {
                        this.fAT.removeView(this.fAU);
                    }
                }
                if (this.fAU.getParent() == null) {
                    this.fAT.addView(this.fAU, 0);
                    this.fAU.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fBh.bII();
                    this.fBm = true;
                } else {
                    return;
                }
            }
            this.fBh.a(this.mPageContext, configuration);
            this.fAW.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            view.setTag(this);
            aZX().a(view, this.fBi);
        }
        if (view == this.fBa || view == this.HE) {
            boolean z = false;
            if (this.fBi != null && this.fBi.fBH != null && !TextUtils.isEmpty(this.fBi.fBH.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fBi.fBH.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(this.fBi.fBH.userId, 0L), z, this.fBi.fBH.isGod)));
            }
        } else if (view == this.fBf || view == this.fAV || view == getView()) {
            if (this.fBi != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fBi.threadId, null, null);
                if (!this.fBq) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.fAZ) {
            if (this.fBi != null && this.fBi.fBI != null) {
                this.fAX.setVisibility(8);
                this.fBh.cbP();
                this.fBh.cm(this.fBi.fBI.videoUrl, this.fBi.threadId);
                vR("2");
            }
        } else if (view == this.ehT) {
            if (!this.fBi.fBH.hasFocus) {
                this.fBj.f(this.fBi);
            }
        } else if (view == this.fBg) {
            this.fBj.g(this.fBi);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fBi != null && this.fBi.fBH != null) {
            this.fBi.fBH.hasFocus = z;
            c(this.fBi);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bml() {
        if (this.fBi != null) {
            this.fBi.hasAgree = !this.fBi.hasAgree;
            if (this.fBi.hasAgree) {
                this.fBi.agreeNum++;
            } else {
                this.fBi.agreeNum--;
            }
            if (this.fBe != null) {
                this.fBe.startAnimation(getScaleAnimation());
            }
            d(this.fBi);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fBp == null) {
            this.fBp = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fBp.setDuration(200L);
        }
        return this.fBp;
    }
}
