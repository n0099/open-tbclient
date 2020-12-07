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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView aky;
    private Animation cbQ;
    private boolean ePB;
    public FrameLayout iZN;
    public FrameLayout iZO;
    public TextView iZP;
    public TextView iZQ;
    public FrameLayout iZR;
    public TextView iZS;
    public TextView iZT;
    public HeadImageView iZU;
    public TextView iZV;
    public TextView iZW;
    public TextView iZX;
    public ImageView iZY;
    public ImageView iZZ;
    private boolean isFullScreen;
    public LinearLayout jaa;
    public LinearLayout jab;
    public com.baidu.tieba.play.c jac;
    public g jad;
    private h jae;
    private o jaf;
    private o jag;
    private boolean jah;
    private boolean jai;
    private Animation jaj;
    private ScaleAnimation jak;
    private boolean jal;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.jah = true;
        this.jal = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iZN = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.iZO = (FrameLayout) view.findViewById(R.id.video_container);
        this.jac = new com.baidu.tieba.play.c(tbPageContext, this.iZO, false);
        this.jac.setStageType("2005");
        this.iZP = (TextView) view.findViewById(R.id.title);
        this.iZQ = (TextView) view.findViewById(R.id.duration);
        this.iZR = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.iZS = (TextView) view.findViewById(R.id.mobile_network_text);
        this.iZT = (TextView) view.findViewById(R.id.mobile_network_play);
        this.iZU = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aky = (TextView) view.findViewById(R.id.user_name);
        this.iZV = (TextView) view.findViewById(R.id.attention);
        this.jaa = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.jab = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.iZW = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.iZX = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.iZY = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.iZZ = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.jaa.setOnClickListener(this);
        this.jab.setOnClickListener(this);
        this.iZP.setOnClickListener(this);
        this.iZU.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.iZV.setOnClickListener(this);
        view.setOnClickListener(this);
        this.iZT.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iZN.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iZN.setLayoutParams(layoutParams);
        this.iZU.setIsRound(true);
        this.jae = new h(this.mPageContext, this);
        this.jaj = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.cbQ = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.jad != null && this.jad.jaC != null) {
                if (this.jad.jaC.hasFocus) {
                    ap.setViewTextColor(this.iZV, (int) R.color.CAM_X0109);
                    this.iZV.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.iZV, (int) R.color.CAM_X0302);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.iZV.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.jad != null) {
                if (this.jad.hasAgree) {
                    this.iZZ.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0301);
                } else {
                    this.iZZ.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0106);
                }
            }
            ap.setViewTextColor(this.iZW, (int) R.color.CAM_X0106);
            this.iZY.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.jaD != null) {
            this.jad = gVar;
            this.ePB = this.jad.autoPlay;
            this.iZP.setVisibility(0);
            this.iZP.setText(gVar.title);
            this.iZQ.setVisibility(0);
            this.iZQ.setText(au.stringForVideoTime(gVar.jaD.videoDuration * 1000));
            if (gVar.jaD.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), KO(String.format("%.1f", Float.valueOf(((float) gVar.jaD.videoSize) / 1048576.0f))));
            }
            this.iZS.setText(format);
            this.iZR.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.jaD != null) {
            this.jac.stopPlay();
            this.jac.wX(true);
            this.jac.wT(false);
            this.jac.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                    if (b.this.jac.rM()) {
                        b.this.iZQ.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                    if (b.this.jac.rM()) {
                        b.this.iZQ.setVisibility(8);
                    }
                    if (b.this.jai) {
                        b.this.jac.stopPlay();
                    }
                }
            });
            this.jac.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cEY() {
                    b.this.jai = false;
                    b.this.iZQ.setVisibility(8);
                    b.this.KN(b.this.ePB ? "1" : "2");
                    b.this.onClick(b.this.iZO);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cEZ() {
                    b.this.iZQ.setVisibility(8);
                    b.this.onClick(b.this.iZN);
                }
            });
            this.jac.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void qt(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.iZS.getText().toString());
                        b.this.jac.gb(b.this.jad.jaD.videoUrl, b.this.jad.threadId);
                        b.this.iZQ.setVisibility(8);
                        b.this.KN("2");
                    } else {
                        b.this.iZR.setVisibility(0);
                    }
                    b.this.onClick(b.this.iZO);
                }
            });
            this.jac.wP(false);
            this.jaf = new o();
            this.jaf.amY = gVar.threadId;
            this.jaf.fFV = gVar.forumId;
            this.jaf.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jag = new o();
            this.jag.amY = gVar.threadId;
            this.jag.fFV = gVar.forumId;
            this.jag.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.jal) {
                ar arVar = new ar("c12590");
                arVar.dY("tid", gVar.threadId);
                arVar.dY("nid", gVar.nid);
                arVar.al("obj_param5", gVar.getVideoType());
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dY("fid", gVar.forumId);
                arVar.al("obj_locate", i);
                arVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(arVar);
                this.jaf.myo = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jaf.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.jaf.myq = "1";
                this.jag.myo = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jag.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jag.myq = "1";
            } else {
                this.jaf.myq = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jaf.mLocate = "12";
                this.jag.myq = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jag.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.jaD != null) {
                this.jaf.myt = gVar.jaD.videoMd5;
                this.jag.myt = gVar.jaD.videoMd5;
            }
            this.jac.getVideoView().setVideoStatData(this.jaf);
            this.jac.dev();
            this.jac.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void qu(boolean z) {
                    if (!b.this.jac.rM()) {
                        b.this.iZP.setVisibility(0);
                    } else if (z) {
                        if (b.this.iZP.getVisibility() == 0) {
                            b.this.iZP.setVisibility(8);
                            b.this.iZP.startAnimation(b.this.jaj);
                        }
                    } else if (b.this.iZP.getVisibility() == 8) {
                        b.this.iZP.setVisibility(0);
                        b.this.iZP.startAnimation(b.this.cbQ);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFa() {
                    if (!b.this.jac.rM()) {
                        b.this.iZP.setVisibility(0);
                    } else if (b.this.iZP.getVisibility() == 0) {
                        b.this.iZP.setVisibility(8);
                        b.this.iZP.startAnimation(b.this.jaj);
                    }
                }
            });
            this.jac.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.jai = true;
                        b.this.jah = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.Ao(i);
                        b.this.jac.cRo();
                    }
                }
            });
            this.jac.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.jad != null && b.this.jad.jaD != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.jad.jaD.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.jac.setThumbnail(gVar.jaD.thumbnailUrl);
            this.jac.setVideoUrl(gVar.jaD.videoUrl, gVar.threadId);
            this.jac.Rn(gVar.title);
            this.jac.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cFb() {
                    b.this.iZQ.setVisibility(8);
                }
            });
            this.jac.cRo();
            this.jac.show();
            if (gVar.autoPlay) {
                onClick(this.iZO);
                this.jai = false;
                this.jac.a(gVar.jaD.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.jai = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN(String str) {
        if (this.jad != null && this.jad.jaD != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jad.jaD.videoMd5, "", str, this.jag, this.jac.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.jac.rM();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jac.aSi();
        }
    }

    public boolean Ap(int i) {
        return this.jac.IF(i);
    }

    public void cEV() {
        this.iZR.setVisibility(8);
        this.jac.stopPlay();
        if (this.iZP != null) {
            this.iZP.setVisibility(0);
        }
        if (this.iZQ != null) {
            this.iZQ.setVisibility(0);
        }
    }

    public void cEW() {
        if (this.jac != null) {
            this.jac.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cEW();
        if (this.jae != null) {
            this.jae.cFg();
        }
    }

    public String KO(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.jaC != null) {
            this.aky.setText(TextUtils.isEmpty(gVar.jaC.userNickname) ? gVar.jaC.userName : gVar.jaC.userNickname);
            this.iZU.startLoad(gVar.jaC.portrait, 12, false);
            this.iZU.setShowV(gVar.jaC.isGod);
            this.iZU.setIsBigV(gVar.jaC.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.jaC != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.jaC.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.jaC.userId)) {
                this.iZV.setVisibility(8);
            } else {
                this.iZV.setVisibility(0);
            }
            if (gVar.jaC.hasFocus) {
                ap.setViewTextColor(this.iZV, (int) R.color.CAM_X0109);
                this.iZV.setCompoundDrawables(null, null, null, null);
                this.iZV.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.iZV, (int) R.color.CAM_X0302);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.iZV.setCompoundDrawables(drawable, null, null, null);
            this.iZV.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.iZZ.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0301);
            } else {
                this.iZZ.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0106);
            }
            this.iZX.setText(au.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.iZW, (int) R.color.CAM_X0106);
            this.iZY.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.iZW.setText(au.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jac != null && this.iZO != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jah) {
                this.jac.dBw();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.iZO.getParent() != null) {
                    if (this.iZO.getParent() == frameLayout) {
                        frameLayout.removeView(this.iZO);
                    } else if (this.iZO.getParent() == this.iZN) {
                        this.iZN.removeView(this.iZO);
                    }
                }
                if (this.iZO.getParent() == null) {
                    frameLayout.addView(this.iZO);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iZO.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.iZO.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.iZO.getParent() != null) {
                    if (this.iZO.getParent() == frameLayout) {
                        frameLayout.removeView(this.iZO);
                    } else if (this.iZO.getParent() == this.iZN) {
                        this.iZN.removeView(this.iZO);
                    }
                }
                if (this.iZO.getParent() == null) {
                    this.iZN.addView(this.iZO, 0);
                    this.iZO.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.jac.dev();
                    this.jah = true;
                } else {
                    return;
                }
            }
            this.jac.a(this.mPageContext, configuration);
            this.iZQ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            view.setTag(this);
            crI().a(view, this.jad);
        }
        if (view == this.iZU || view == this.aky) {
            boolean z = false;
            if (this.jad != null && this.jad.jaC != null && !TextUtils.isEmpty(this.jad.jaC.userId)) {
                if (TbadkCoreApplication.isLogin() && this.jad.jaC.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jad.jaC.userId, 0L), z, this.jad.jaC.isGod)));
            }
        } else if (view == this.jaa || view == this.iZP || view == getView()) {
            if (this.jad != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jad.threadId, null, null);
                if (!this.jal) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.iZT) {
            if (this.jad != null && this.jad.jaD != null) {
                this.iZR.setVisibility(8);
                this.jac.dBz();
                this.jac.gb(this.jad.jaD.videoUrl, this.jad.threadId);
                KN("2");
            }
        } else if (view == this.iZV) {
            if (!this.jad.jaC.hasFocus) {
                this.jae.f(this.jad);
            }
        } else if (view == this.jab) {
            com.baidu.tbadk.pageExtra.c eX = com.baidu.tbadk.pageExtra.d.eX(getContext());
            if (eX != null) {
                this.jad.objSource = eX.getCurrentPageKey();
            }
            this.jae.g(this.jad);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qs(boolean z) {
        if (this.jad != null && this.jad.jaC != null) {
            this.jad.jaC.hasFocus = z;
            c(this.jad);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cEX() {
        if (this.jad != null) {
            this.jad.hasAgree = !this.jad.hasAgree;
            if (this.jad.hasAgree) {
                this.jad.agreeNum++;
            } else {
                this.jad.agreeNum--;
            }
            if (this.iZZ != null) {
                this.iZZ.startAnimation(getScaleAnimation());
            }
            d(this.jad);
        }
    }

    private Animation getScaleAnimation() {
        if (this.jak == null) {
            this.jak = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.jak.setDuration(200L);
        }
        return this.jak;
    }
}
