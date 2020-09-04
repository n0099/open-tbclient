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
    public TextView aiH;
    private Animation bAh;
    private boolean egF;
    public TextView gAY;
    public FrameLayout hZP;
    public FrameLayout hZQ;
    public TextView hZR;
    public TextView hZS;
    public FrameLayout hZT;
    public TextView hZU;
    public TextView hZV;
    public HeadImageView hZW;
    public TextView hZX;
    public TextView hZY;
    public ImageView hZZ;
    public ImageView iaa;
    public LinearLayout iab;
    public LinearLayout iac;
    public com.baidu.tieba.play.c iad;
    public g iae;
    private h iaf;
    private o iag;
    private o iah;
    private boolean iai;
    private boolean iaj;
    private Animation iak;
    private ScaleAnimation ial;
    private boolean iam;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.iai = true;
        this.iam = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hZP = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hZQ = (FrameLayout) view.findViewById(R.id.video_container);
        this.iad = new com.baidu.tieba.play.c(tbPageContext, this.hZQ, false);
        this.iad.setStageType("2005");
        this.hZR = (TextView) view.findViewById(R.id.title);
        this.hZS = (TextView) view.findViewById(R.id.duration);
        this.hZT = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hZU = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hZV = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hZW = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aiH = (TextView) view.findViewById(R.id.user_name);
        this.gAY = (TextView) view.findViewById(R.id.attention);
        this.iab = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.iac = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hZX = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hZY = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hZZ = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.iaa = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.iab.setOnClickListener(this);
        this.iac.setOnClickListener(this);
        this.hZR.setOnClickListener(this);
        this.hZW.setOnClickListener(this);
        this.aiH.setOnClickListener(this);
        this.gAY.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hZV.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hZP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hZP.setLayoutParams(layoutParams);
        this.hZW.setIsRound(true);
        this.iaf = new h(this.mPageContext, this);
        this.iak = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bAh = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.iae != null && this.iae.iaD != null) {
                if (this.iae.iaD.hasFocus) {
                    ap.setViewTextColor(this.gAY, (int) R.color.cp_cont_d);
                    this.gAY.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.gAY, (int) R.color.cp_link_tip_a);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.gAY.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.iae != null) {
                if (this.iae.hasAgree) {
                    this.iaa.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.hZY, (int) R.color.cp_cont_h);
                } else {
                    this.iaa.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.hZY, (int) R.color.cp_cont_f);
                }
            }
            ap.setViewTextColor(this.hZX, (int) R.color.cp_cont_f);
            this.hZZ.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.iaE != null) {
            this.iae = gVar;
            this.egF = this.iae.autoPlay;
            this.hZR.setVisibility(0);
            this.hZR.setText(gVar.title);
            this.hZS.setVisibility(0);
            this.hZS.setText(at.stringForVideoTime(gVar.iaE.videoDuration * 1000));
            if (gVar.iaE.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Iw(String.format("%.1f", Float.valueOf(((float) gVar.iaE.videoSize) / 1048576.0f))));
            }
            this.hZU.setText(format);
            this.hZT.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.iaE != null) {
            this.iad.stopPlay();
            this.iad.vb(true);
            this.iad.uX(false);
            this.iad.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                    if (b.this.iad.rF()) {
                        b.this.hZS.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                    if (b.this.iad.rF()) {
                        b.this.hZS.setVisibility(8);
                    }
                    if (b.this.iaj) {
                        b.this.iad.stopPlay();
                    }
                }
            });
            this.iad.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void coN() {
                    b.this.iaj = false;
                    b.this.hZS.setVisibility(8);
                    b.this.Iv(b.this.egF ? "1" : "2");
                    b.this.onClick(b.this.hZQ);
                }

                @Override // com.baidu.tieba.play.c.l
                public void coO() {
                    b.this.hZS.setVisibility(8);
                    b.this.onClick(b.this.hZP);
                }
            });
            this.iad.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void oH(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hZU.getText().toString());
                        b.this.iad.fx(b.this.iae.iaE.videoUrl, b.this.iae.threadId);
                        b.this.hZS.setVisibility(8);
                        b.this.Iv("2");
                    } else {
                        b.this.hZT.setVisibility(0);
                    }
                    b.this.onClick(b.this.hZQ);
                }
            });
            this.iad.uT(false);
            this.iag = new o();
            this.iag.ala = gVar.threadId;
            this.iag.eVx = gVar.forumId;
            this.iag.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iah = new o();
            this.iah.ala = gVar.threadId;
            this.iah.eVx = gVar.forumId;
            this.iah.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.iam) {
                aq aqVar = new aq("c12590");
                aqVar.dD("tid", gVar.threadId);
                aqVar.dD("nid", gVar.nid);
                aqVar.ai("obj_param5", gVar.getVideoType());
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dD("fid", gVar.forumId);
                aqVar.ai("obj_locate", i);
                aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.iag.ltn = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iag.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.iag.ltp = "1";
                this.iah.ltn = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iah.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iah.ltp = "1";
            } else {
                this.iag.ltp = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iag.mLocate = "12";
                this.iah.ltp = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iah.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.iaE != null) {
                this.iag.ltt = gVar.iaE.videoMd5;
                this.iah.ltt = gVar.iaE.videoMd5;
            }
            this.iad.getVideoView().setVideoStatData(this.iag);
            this.iad.cMR();
            this.iad.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void oI(boolean z) {
                    if (!b.this.iad.rF()) {
                        b.this.hZR.setVisibility(0);
                    } else if (z) {
                        if (b.this.hZR.getVisibility() == 0) {
                            b.this.hZR.setVisibility(8);
                            b.this.hZR.startAnimation(b.this.iak);
                        }
                    } else if (b.this.hZR.getVisibility() == 8) {
                        b.this.hZR.setVisibility(0);
                        b.this.hZR.startAnimation(b.this.bAh);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void coP() {
                    if (!b.this.iad.rF()) {
                        b.this.hZR.setVisibility(0);
                    } else if (b.this.hZR.getVisibility() == 0) {
                        b.this.hZR.setVisibility(8);
                        b.this.hZR.startAnimation(b.this.iak);
                    }
                }
            });
            this.iad.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.iaj = true;
                        b.this.iai = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.xA(i);
                        b.this.iad.czv();
                    }
                }
            });
            this.iad.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.iae != null && b.this.iae.iaE != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.iae.iaE.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.iad.setThumbnail(gVar.iaE.thumbnailUrl);
            this.iad.setVideoUrl(gVar.iaE.videoUrl, gVar.threadId);
            this.iad.OE(gVar.title);
            this.iad.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void coQ() {
                    b.this.hZS.setVisibility(8);
                }
            });
            this.iad.czv();
            this.iad.show();
            if (gVar.autoPlay) {
                onClick(this.hZQ);
                this.iaj = false;
                this.iad.a(gVar.iaE.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.iaj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv(String str) {
        if (this.iae != null && this.iae.iaE != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iae.iaE.videoMd5, "", str, this.iah, this.iad.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.iad.rF();
    }

    public void coJ() {
        if (isPlaying()) {
            this.iad.aHX();
        }
    }

    public boolean xB(int i) {
        return this.iad.FD(i);
    }

    public void coK() {
        this.hZT.setVisibility(8);
        this.iad.stopPlay();
        if (this.hZR != null) {
            this.hZR.setVisibility(0);
        }
        if (this.hZS != null) {
            this.hZS.setVisibility(0);
        }
    }

    public void coL() {
        if (this.iad != null) {
            this.iad.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        coL();
        if (this.iaf != null) {
            this.iaf.coV();
        }
    }

    public String Iw(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.iaD != null) {
            this.aiH.setText(TextUtils.isEmpty(gVar.iaD.userNickname) ? gVar.iaD.userName : gVar.iaD.userNickname);
            this.hZW.startLoad(gVar.iaD.portrait, 12, false);
            this.hZW.setShowV(gVar.iaD.isGod);
            this.hZW.setIsBigV(gVar.iaD.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.iaD != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.iaD.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.iaD.userId)) {
                this.gAY.setVisibility(8);
            } else {
                this.gAY.setVisibility(0);
            }
            if (gVar.iaD.hasFocus) {
                ap.setViewTextColor(this.gAY, (int) R.color.cp_cont_d);
                this.gAY.setCompoundDrawables(null, null, null, null);
                this.gAY.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.gAY, (int) R.color.cp_link_tip_a);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.gAY.setCompoundDrawables(drawable, null, null, null);
            this.gAY.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.iaa.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.hZY, (int) R.color.cp_cont_h);
            } else {
                this.iaa.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.hZY, (int) R.color.cp_cont_f);
            }
            this.hZY.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.hZX, (int) R.color.cp_cont_f);
            this.hZZ.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.hZX.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iad != null && this.hZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iai) {
                this.iad.djE();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hZQ.getParent() != null) {
                    if (this.hZQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.hZQ);
                    } else if (this.hZQ.getParent() == this.hZP) {
                        this.hZP.removeView(this.hZQ);
                    }
                }
                if (this.hZQ.getParent() == null) {
                    frameLayout.addView(this.hZQ);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZQ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hZQ.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hZQ.getParent() != null) {
                    if (this.hZQ.getParent() == frameLayout) {
                        frameLayout.removeView(this.hZQ);
                    } else if (this.hZQ.getParent() == this.hZP) {
                        this.hZP.removeView(this.hZQ);
                    }
                }
                if (this.hZQ.getParent() == null) {
                    this.hZP.addView(this.hZQ, 0);
                    this.hZQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.iad.cMR();
                    this.iai = true;
                } else {
                    return;
                }
            }
            this.iad.a(this.mPageContext, configuration);
            this.hZS.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            view.setTag(this);
            cbA().a(view, this.iae);
        }
        if (view == this.hZW || view == this.aiH) {
            boolean z = false;
            if (this.iae != null && this.iae.iaD != null && !TextUtils.isEmpty(this.iae.iaD.userId)) {
                if (TbadkCoreApplication.isLogin() && this.iae.iaD.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iae.iaD.userId, 0L), z, this.iae.iaD.isGod)));
            }
        } else if (view == this.iab || view == this.hZR || view == getView()) {
            if (this.iae != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iae.threadId, null, null);
                if (!this.iam) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hZV) {
            if (this.iae != null && this.iae.iaE != null) {
                this.hZT.setVisibility(8);
                this.iad.djH();
                this.iad.fx(this.iae.iaE.videoUrl, this.iae.threadId);
                Iv("2");
            }
        } else if (view == this.gAY) {
            if (!this.iae.iaD.hasFocus) {
                this.iaf.f(this.iae);
            }
        } else if (view == this.iac) {
            this.iaf.g(this.iae);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oG(boolean z) {
        if (this.iae != null && this.iae.iaD != null) {
            this.iae.iaD.hasFocus = z;
            c(this.iae);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void coM() {
        if (this.iae != null) {
            this.iae.hasAgree = !this.iae.hasAgree;
            if (this.iae.hasAgree) {
                this.iae.agreeNum++;
            } else {
                this.iae.agreeNum--;
            }
            if (this.iaa != null) {
                this.iaa.startAnimation(getScaleAnimation());
            }
            d(this.iae);
        }
    }

    private Animation getScaleAnimation() {
        if (this.ial == null) {
            this.ial = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ial.setDuration(200L);
        }
        return this.ial;
    }
}
