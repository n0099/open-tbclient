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
    public FrameLayout iZP;
    public FrameLayout iZQ;
    public TextView iZR;
    public TextView iZS;
    public FrameLayout iZT;
    public TextView iZU;
    public TextView iZV;
    public HeadImageView iZW;
    public TextView iZX;
    public TextView iZY;
    public TextView iZZ;
    private boolean isFullScreen;
    public ImageView jaa;
    public ImageView jab;
    public LinearLayout jac;
    public LinearLayout jad;
    public com.baidu.tieba.play.c jae;
    public g jaf;
    private h jag;
    private o jah;
    private o jai;
    private boolean jaj;
    private boolean jak;
    private Animation jal;
    private ScaleAnimation jam;
    private boolean jan;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.jaj = true;
        this.jan = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iZP = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.iZQ = (FrameLayout) view.findViewById(R.id.video_container);
        this.jae = new com.baidu.tieba.play.c(tbPageContext, this.iZQ, false);
        this.jae.setStageType("2005");
        this.iZR = (TextView) view.findViewById(R.id.title);
        this.iZS = (TextView) view.findViewById(R.id.duration);
        this.iZT = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.iZU = (TextView) view.findViewById(R.id.mobile_network_text);
        this.iZV = (TextView) view.findViewById(R.id.mobile_network_play);
        this.iZW = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aky = (TextView) view.findViewById(R.id.user_name);
        this.iZX = (TextView) view.findViewById(R.id.attention);
        this.jac = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.jad = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.iZY = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.iZZ = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.jaa = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jab = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.jac.setOnClickListener(this);
        this.jad.setOnClickListener(this);
        this.iZR.setOnClickListener(this);
        this.iZW.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.iZX.setOnClickListener(this);
        view.setOnClickListener(this);
        this.iZV.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iZP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iZP.setLayoutParams(layoutParams);
        this.iZW.setIsRound(true);
        this.jag = new h(this.mPageContext, this);
        this.jal = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.cbQ = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.jaf != null && this.jaf.jaE != null) {
                if (this.jaf.jaE.hasFocus) {
                    ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0109);
                    this.iZX.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0302);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.iZX.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.jaf != null) {
                if (this.jaf.hasAgree) {
                    this.jab.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.iZZ, (int) R.color.CAM_X0301);
                } else {
                    this.jab.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.iZZ, (int) R.color.CAM_X0106);
                }
            }
            ap.setViewTextColor(this.iZY, (int) R.color.CAM_X0106);
            this.jaa.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.jaF != null) {
            this.jaf = gVar;
            this.ePB = this.jaf.autoPlay;
            this.iZR.setVisibility(0);
            this.iZR.setText(gVar.title);
            this.iZS.setVisibility(0);
            this.iZS.setText(au.stringForVideoTime(gVar.jaF.videoDuration * 1000));
            if (gVar.jaF.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), KO(String.format("%.1f", Float.valueOf(((float) gVar.jaF.videoSize) / 1048576.0f))));
            }
            this.iZU.setText(format);
            this.iZT.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.jaF != null) {
            this.jae.stopPlay();
            this.jae.wX(true);
            this.jae.wT(false);
            this.jae.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                    if (b.this.jae.rM()) {
                        b.this.iZS.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                    if (b.this.jae.rM()) {
                        b.this.iZS.setVisibility(8);
                    }
                    if (b.this.jak) {
                        b.this.jae.stopPlay();
                    }
                }
            });
            this.jae.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cEZ() {
                    b.this.jak = false;
                    b.this.iZS.setVisibility(8);
                    b.this.KN(b.this.ePB ? "1" : "2");
                    b.this.onClick(b.this.iZQ);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFa() {
                    b.this.iZS.setVisibility(8);
                    b.this.onClick(b.this.iZP);
                }
            });
            this.jae.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void qt(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.iZU.getText().toString());
                        b.this.jae.gb(b.this.jaf.jaF.videoUrl, b.this.jaf.threadId);
                        b.this.iZS.setVisibility(8);
                        b.this.KN("2");
                    } else {
                        b.this.iZT.setVisibility(0);
                    }
                    b.this.onClick(b.this.iZQ);
                }
            });
            this.jae.wP(false);
            this.jah = new o();
            this.jah.amY = gVar.threadId;
            this.jah.fFV = gVar.forumId;
            this.jah.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jai = new o();
            this.jai.amY = gVar.threadId;
            this.jai.fFV = gVar.forumId;
            this.jai.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.jan) {
                ar arVar = new ar("c12590");
                arVar.dY("tid", gVar.threadId);
                arVar.dY("nid", gVar.nid);
                arVar.al("obj_param5", gVar.getVideoType());
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dY("fid", gVar.forumId);
                arVar.al("obj_locate", i);
                arVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(arVar);
                this.jah.myq = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jah.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.jah.mys = "1";
                this.jai.myq = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jai.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jai.mys = "1";
            } else {
                this.jah.mys = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jah.mLocate = "12";
                this.jai.mys = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jai.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.jaF != null) {
                this.jah.myv = gVar.jaF.videoMd5;
                this.jai.myv = gVar.jaF.videoMd5;
            }
            this.jae.getVideoView().setVideoStatData(this.jah);
            this.jae.dew();
            this.jae.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void qu(boolean z) {
                    if (!b.this.jae.rM()) {
                        b.this.iZR.setVisibility(0);
                    } else if (z) {
                        if (b.this.iZR.getVisibility() == 0) {
                            b.this.iZR.setVisibility(8);
                            b.this.iZR.startAnimation(b.this.jal);
                        }
                    } else if (b.this.iZR.getVisibility() == 8) {
                        b.this.iZR.setVisibility(0);
                        b.this.iZR.startAnimation(b.this.cbQ);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFb() {
                    if (!b.this.jae.rM()) {
                        b.this.iZR.setVisibility(0);
                    } else if (b.this.iZR.getVisibility() == 0) {
                        b.this.iZR.setVisibility(8);
                        b.this.iZR.startAnimation(b.this.jal);
                    }
                }
            });
            this.jae.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.jak = true;
                        b.this.jaj = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.Ao(i);
                        b.this.jae.cRp();
                    }
                }
            });
            this.jae.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.jaf != null && b.this.jaf.jaF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.jaf.jaF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.jae.setThumbnail(gVar.jaF.thumbnailUrl);
            this.jae.setVideoUrl(gVar.jaF.videoUrl, gVar.threadId);
            this.jae.Rn(gVar.title);
            this.jae.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cFc() {
                    b.this.iZS.setVisibility(8);
                }
            });
            this.jae.cRp();
            this.jae.show();
            if (gVar.autoPlay) {
                onClick(this.iZQ);
                this.jak = false;
                this.jae.a(gVar.jaF.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.jak = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN(String str) {
        if (this.jaf != null && this.jaf.jaF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jaf.jaF.videoMd5, "", str, this.jai, this.jae.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.jae.rM();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jae.aSi();
        }
    }

    public boolean Ap(int i) {
        return this.jae.IF(i);
    }

    public void cEW() {
        this.iZT.setVisibility(8);
        this.jae.stopPlay();
        if (this.iZR != null) {
            this.iZR.setVisibility(0);
        }
        if (this.iZS != null) {
            this.iZS.setVisibility(0);
        }
    }

    public void cEX() {
        if (this.jae != null) {
            this.jae.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cEX();
        if (this.jag != null) {
            this.jag.cFh();
        }
    }

    public String KO(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.jaE != null) {
            this.aky.setText(TextUtils.isEmpty(gVar.jaE.userNickname) ? gVar.jaE.userName : gVar.jaE.userNickname);
            this.iZW.startLoad(gVar.jaE.portrait, 12, false);
            this.iZW.setShowV(gVar.jaE.isGod);
            this.iZW.setIsBigV(gVar.jaE.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.jaE != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.jaE.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.jaE.userId)) {
                this.iZX.setVisibility(8);
            } else {
                this.iZX.setVisibility(0);
            }
            if (gVar.jaE.hasFocus) {
                ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0109);
                this.iZX.setCompoundDrawables(null, null, null, null);
                this.iZX.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.iZX, (int) R.color.CAM_X0302);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.iZX.setCompoundDrawables(drawable, null, null, null);
            this.iZX.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.jab.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.iZZ, (int) R.color.CAM_X0301);
            } else {
                this.jab.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.iZZ, (int) R.color.CAM_X0106);
            }
            this.iZZ.setText(au.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.iZY, (int) R.color.CAM_X0106);
            this.jaa.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.iZY.setText(au.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jae != null && this.iZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jaj) {
                this.jae.dBx();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.iZQ.getParent() != null) {
                    if (this.iZQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.iZQ);
                    } else if (this.iZQ.getParent() == this.iZP) {
                        this.iZP.removeView(this.iZQ);
                    }
                }
                if (this.iZQ.getParent() == null) {
                    frameLayout.addView(this.iZQ);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iZQ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.iZQ.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.iZQ.getParent() != null) {
                    if (this.iZQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.iZQ);
                    } else if (this.iZQ.getParent() == this.iZP) {
                        this.iZP.removeView(this.iZQ);
                    }
                }
                if (this.iZQ.getParent() == null) {
                    this.iZP.addView(this.iZQ, 0);
                    this.iZQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.jae.dew();
                    this.jaj = true;
                } else {
                    return;
                }
            }
            this.jae.a(this.mPageContext, configuration);
            this.iZS.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            view.setTag(this);
            crJ().a(view, this.jaf);
        }
        if (view == this.iZW || view == this.aky) {
            boolean z = false;
            if (this.jaf != null && this.jaf.jaE != null && !TextUtils.isEmpty(this.jaf.jaE.userId)) {
                if (TbadkCoreApplication.isLogin() && this.jaf.jaE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jaf.jaE.userId, 0L), z, this.jaf.jaE.isGod)));
            }
        } else if (view == this.jac || view == this.iZR || view == getView()) {
            if (this.jaf != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jaf.threadId, null, null);
                if (!this.jan) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.iZV) {
            if (this.jaf != null && this.jaf.jaF != null) {
                this.iZT.setVisibility(8);
                this.jae.dBA();
                this.jae.gb(this.jaf.jaF.videoUrl, this.jaf.threadId);
                KN("2");
            }
        } else if (view == this.iZX) {
            if (!this.jaf.jaE.hasFocus) {
                this.jag.f(this.jaf);
            }
        } else if (view == this.jad) {
            com.baidu.tbadk.pageExtra.c eX = com.baidu.tbadk.pageExtra.d.eX(getContext());
            if (eX != null) {
                this.jaf.objSource = eX.getCurrentPageKey();
            }
            this.jag.g(this.jaf);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qs(boolean z) {
        if (this.jaf != null && this.jaf.jaE != null) {
            this.jaf.jaE.hasFocus = z;
            c(this.jaf);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cEY() {
        if (this.jaf != null) {
            this.jaf.hasAgree = !this.jaf.hasAgree;
            if (this.jaf.hasAgree) {
                this.jaf.agreeNum++;
            } else {
                this.jaf.agreeNum--;
            }
            if (this.jab != null) {
                this.jab.startAnimation(getScaleAnimation());
            }
            d(this.jaf);
        }
    }

    private Animation getScaleAnimation() {
        if (this.jam == null) {
            this.jam = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.jam.setDuration(200L);
        }
        return this.jam;
    }
}
