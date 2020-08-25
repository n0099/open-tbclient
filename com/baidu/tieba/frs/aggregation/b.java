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
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView aiF;
    private Animation bAe;
    private boolean egB;
    public TextView gAU;
    public FrameLayout hZJ;
    public FrameLayout hZK;
    public TextView hZL;
    public TextView hZM;
    public FrameLayout hZN;
    public TextView hZO;
    public TextView hZP;
    public HeadImageView hZQ;
    public TextView hZR;
    public TextView hZS;
    public ImageView hZT;
    public ImageView hZU;
    public LinearLayout hZV;
    public LinearLayout hZW;
    public com.baidu.tieba.play.c hZX;
    public g hZY;
    private h hZZ;
    private o iaa;
    private o iab;
    private boolean iac;
    private boolean iad;
    private Animation iae;
    private ScaleAnimation iaf;
    private boolean iag;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.iac = true;
        this.iag = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hZJ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hZK = (FrameLayout) view.findViewById(R.id.video_container);
        this.hZX = new com.baidu.tieba.play.c(tbPageContext, this.hZK, false);
        this.hZX.setStageType("2005");
        this.hZL = (TextView) view.findViewById(R.id.title);
        this.hZM = (TextView) view.findViewById(R.id.duration);
        this.hZN = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hZO = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hZP = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hZQ = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aiF = (TextView) view.findViewById(R.id.user_name);
        this.gAU = (TextView) view.findViewById(R.id.attention);
        this.hZV = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.hZW = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hZR = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hZS = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hZT = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.hZU = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.hZV.setOnClickListener(this);
        this.hZW.setOnClickListener(this);
        this.hZL.setOnClickListener(this);
        this.hZQ.setOnClickListener(this);
        this.aiF.setOnClickListener(this);
        this.gAU.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hZP.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hZJ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hZJ.setLayoutParams(layoutParams);
        this.hZQ.setIsRound(true);
        this.hZZ = new h(this.mPageContext, this);
        this.iae = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bAe = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.hZY != null && this.hZY.iax != null) {
                if (this.hZY.iax.hasFocus) {
                    ap.setViewTextColor(this.gAU, (int) R.color.cp_cont_d);
                    this.gAU.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.gAU, (int) R.color.cp_link_tip_a);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.gAU.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.hZY != null) {
                if (this.hZY.hasAgree) {
                    this.hZU.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.hZS, (int) R.color.cp_cont_h);
                } else {
                    this.hZU.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.hZS, (int) R.color.cp_cont_f);
                }
            }
            ap.setViewTextColor(this.hZR, (int) R.color.cp_cont_f);
            this.hZT.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.iay != null) {
            this.hZY = gVar;
            this.egB = this.hZY.autoPlay;
            this.hZL.setVisibility(0);
            this.hZL.setText(gVar.title);
            this.hZM.setVisibility(0);
            this.hZM.setText(at.stringForVideoTime(gVar.iay.videoDuration * 1000));
            if (gVar.iay.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Iv(String.format("%.1f", Float.valueOf(((float) gVar.iay.videoSize) / 1048576.0f))));
            }
            this.hZO.setText(format);
            this.hZN.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.iay != null) {
            this.hZX.stopPlay();
            this.hZX.uZ(true);
            this.hZX.uV(false);
            this.hZX.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                    if (b.this.hZX.rF()) {
                        b.this.hZM.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                    if (b.this.hZX.rF()) {
                        b.this.hZM.setVisibility(8);
                    }
                    if (b.this.iad) {
                        b.this.hZX.stopPlay();
                    }
                }
            });
            this.hZX.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void coM() {
                    b.this.iad = false;
                    b.this.hZM.setVisibility(8);
                    b.this.Iu(b.this.egB ? "1" : "2");
                    b.this.onClick(b.this.hZK);
                }

                @Override // com.baidu.tieba.play.c.l
                public void coN() {
                    b.this.hZM.setVisibility(8);
                    b.this.onClick(b.this.hZJ);
                }
            });
            this.hZX.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void oF(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hZO.getText().toString());
                        b.this.hZX.fw(b.this.hZY.iay.videoUrl, b.this.hZY.threadId);
                        b.this.hZM.setVisibility(8);
                        b.this.Iu("2");
                    } else {
                        b.this.hZN.setVisibility(0);
                    }
                    b.this.onClick(b.this.hZK);
                }
            });
            this.hZX.uR(false);
            this.iaa = new o();
            this.iaa.akY = gVar.threadId;
            this.iaa.eVt = gVar.forumId;
            this.iaa.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iab = new o();
            this.iab.akY = gVar.threadId;
            this.iab.eVt = gVar.forumId;
            this.iab.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.iag) {
                aq aqVar = new aq("c12590");
                aqVar.dD("tid", gVar.threadId);
                aqVar.dD("nid", gVar.nid);
                aqVar.ai("obj_param5", gVar.getVideoType());
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dD("fid", gVar.forumId);
                aqVar.ai("obj_locate", i);
                aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.iaa.ltc = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iaa.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.iaa.lte = "1";
                this.iab.ltc = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iab.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iab.lte = "1";
            } else {
                this.iaa.lte = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iaa.mLocate = "12";
                this.iab.lte = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iab.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.iay != null) {
                this.iaa.lth = gVar.iay.videoMd5;
                this.iab.lth = gVar.iay.videoMd5;
            }
            this.hZX.getVideoView().setVideoStatData(this.iaa);
            this.hZX.cMQ();
            this.hZX.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void oG(boolean z) {
                    if (!b.this.hZX.rF()) {
                        b.this.hZL.setVisibility(0);
                    } else if (z) {
                        if (b.this.hZL.getVisibility() == 0) {
                            b.this.hZL.setVisibility(8);
                            b.this.hZL.startAnimation(b.this.iae);
                        }
                    } else if (b.this.hZL.getVisibility() == 8) {
                        b.this.hZL.setVisibility(0);
                        b.this.hZL.startAnimation(b.this.bAe);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void coO() {
                    if (!b.this.hZX.rF()) {
                        b.this.hZL.setVisibility(0);
                    } else if (b.this.hZL.getVisibility() == 0) {
                        b.this.hZL.setVisibility(8);
                        b.this.hZL.startAnimation(b.this.iae);
                    }
                }
            });
            this.hZX.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.iad = true;
                        b.this.iac = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.xA(i);
                        b.this.hZX.czu();
                    }
                }
            });
            this.hZX.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.hZY != null && b.this.hZY.iay != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.hZY.iay.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hZX.setThumbnail(gVar.iay.thumbnailUrl);
            this.hZX.setVideoUrl(gVar.iay.videoUrl, gVar.threadId);
            this.hZX.OD(gVar.title);
            this.hZX.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void coP() {
                    b.this.hZM.setVisibility(8);
                }
            });
            this.hZX.czu();
            this.hZX.show();
            if (gVar.autoPlay) {
                onClick(this.hZK);
                this.iad = false;
                this.hZX.a(gVar.iay.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.iad = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu(String str) {
        if (this.hZY != null && this.hZY.iay != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.hZY.iay.videoMd5, "", str, this.iab, this.hZX.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.hZX.rF();
    }

    public void coI() {
        if (isPlaying()) {
            this.hZX.aHX();
        }
    }

    public boolean xB(int i) {
        return this.hZX.FD(i);
    }

    public void coJ() {
        this.hZN.setVisibility(8);
        this.hZX.stopPlay();
        if (this.hZL != null) {
            this.hZL.setVisibility(0);
        }
        if (this.hZM != null) {
            this.hZM.setVisibility(0);
        }
    }

    public void coK() {
        if (this.hZX != null) {
            this.hZX.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        coK();
        if (this.hZZ != null) {
            this.hZZ.coU();
        }
    }

    public String Iv(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.iax != null) {
            this.aiF.setText(TextUtils.isEmpty(gVar.iax.userNickname) ? gVar.iax.userName : gVar.iax.userNickname);
            this.hZQ.startLoad(gVar.iax.portrait, 12, false);
            this.hZQ.setShowV(gVar.iax.isGod);
            this.hZQ.setIsBigV(gVar.iax.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.iax != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.iax.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.iax.userId)) {
                this.gAU.setVisibility(8);
            } else {
                this.gAU.setVisibility(0);
            }
            if (gVar.iax.hasFocus) {
                ap.setViewTextColor(this.gAU, (int) R.color.cp_cont_d);
                this.gAU.setCompoundDrawables(null, null, null, null);
                this.gAU.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.gAU, (int) R.color.cp_link_tip_a);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.gAU.setCompoundDrawables(drawable, null, null, null);
            this.gAU.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.hZU.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.hZS, (int) R.color.cp_cont_h);
            } else {
                this.hZU.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.hZS, (int) R.color.cp_cont_f);
            }
            this.hZS.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.hZR, (int) R.color.cp_cont_f);
            this.hZT.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.hZR.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hZX != null && this.hZK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iac) {
                this.hZX.djB();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hZK.getParent() != null) {
                    if (this.hZK.getParent() == frameLayout) {
                        frameLayout.removeView(this.hZK);
                    } else if (this.hZK.getParent() == this.hZJ) {
                        this.hZJ.removeView(this.hZK);
                    }
                }
                if (this.hZK.getParent() == null) {
                    frameLayout.addView(this.hZK);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZK.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hZK.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hZK.getParent() != null) {
                    if (this.hZK.getParent() == frameLayout) {
                        frameLayout.removeView(this.hZK);
                    } else if (this.hZK.getParent() == this.hZJ) {
                        this.hZJ.removeView(this.hZK);
                    }
                }
                if (this.hZK.getParent() == null) {
                    this.hZJ.addView(this.hZK, 0);
                    this.hZK.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hZX.cMQ();
                    this.iac = true;
                } else {
                    return;
                }
            }
            this.hZX.a(this.mPageContext, configuration);
            this.hZM.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            view.setTag(this);
            cbz().a(view, this.hZY);
        }
        if (view == this.hZQ || view == this.aiF) {
            boolean z = false;
            if (this.hZY != null && this.hZY.iax != null && !TextUtils.isEmpty(this.hZY.iax.userId)) {
                if (TbadkCoreApplication.isLogin() && this.hZY.iax.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hZY.iax.userId, 0L), z, this.hZY.iax.isGod)));
            }
        } else if (view == this.hZV || view == this.hZL || view == getView()) {
            if (this.hZY != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hZY.threadId, null, null);
                if (!this.iag) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hZP) {
            if (this.hZY != null && this.hZY.iay != null) {
                this.hZN.setVisibility(8);
                this.hZX.djE();
                this.hZX.fw(this.hZY.iay.videoUrl, this.hZY.threadId);
                Iu("2");
            }
        } else if (view == this.gAU) {
            if (!this.hZY.iax.hasFocus) {
                this.hZZ.f(this.hZY);
            }
        } else if (view == this.hZW) {
            this.hZZ.g(this.hZY);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oE(boolean z) {
        if (this.hZY != null && this.hZY.iax != null) {
            this.hZY.iax.hasFocus = z;
            c(this.hZY);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void coL() {
        if (this.hZY != null) {
            this.hZY.hasAgree = !this.hZY.hasAgree;
            if (this.hZY.hasAgree) {
                this.hZY.agreeNum++;
            } else {
                this.hZY.agreeNum--;
            }
            if (this.hZU != null) {
                this.hZU.startAnimation(getScaleAnimation());
            }
            d(this.hZY);
        }
    }

    private Animation getScaleAnimation() {
        if (this.iaf == null) {
            this.iaf = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.iaf.setDuration(200L);
        }
        return this.iaf;
    }
}
