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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView akj;
    private Animation cdO;
    private boolean eUP;
    private boolean isFullScreen;
    public TextView jhA;
    public HeadImageView jhB;
    public TextView jhC;
    public TextView jhD;
    public TextView jhE;
    public ImageView jhF;
    public ImageView jhG;
    public LinearLayout jhH;
    public LinearLayout jhI;
    public com.baidu.tieba.play.c jhJ;
    public g jhK;
    private h jhL;
    private o jhM;
    private o jhN;
    private boolean jhO;
    private boolean jhP;
    private Animation jhQ;
    private ScaleAnimation jhR;
    private boolean jhS;
    public FrameLayout jhu;
    public FrameLayout jhv;
    public TextView jhw;
    public TextView jhx;
    public FrameLayout jhy;
    public TextView jhz;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.jhO = true;
        this.jhS = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jhu = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jhv = (FrameLayout) view.findViewById(R.id.video_container);
        this.jhJ = new com.baidu.tieba.play.c(tbPageContext, this.jhv, false);
        this.jhJ.setStageType("2005");
        this.jhw = (TextView) view.findViewById(R.id.title);
        this.jhx = (TextView) view.findViewById(R.id.duration);
        this.jhy = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.jhz = (TextView) view.findViewById(R.id.mobile_network_text);
        this.jhA = (TextView) view.findViewById(R.id.mobile_network_play);
        this.jhB = (HeadImageView) view.findViewById(R.id.user_icon);
        this.akj = (TextView) view.findViewById(R.id.user_name);
        this.jhC = (TextView) view.findViewById(R.id.attention);
        this.jhH = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.jhI = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.jhD = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jhE = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.jhF = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jhG = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.jhH.setOnClickListener(this);
        this.jhI.setOnClickListener(this);
        this.jhw.setOnClickListener(this);
        this.jhB.setOnClickListener(this);
        this.akj.setOnClickListener(this);
        this.jhC.setOnClickListener(this);
        view.setOnClickListener(this);
        this.jhA.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jhu.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jhu.setLayoutParams(layoutParams);
        this.jhB.setIsRound(true);
        this.jhL = new h(this.mPageContext, this);
        this.jhQ = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.cdO = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ao.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.jhK != null && this.jhK.jik != null) {
                if (this.jhK.jik.hasFocus) {
                    ao.setViewTextColor(this.jhC, R.color.CAM_X0109);
                    this.jhC.setCompoundDrawables(null, null, null, null);
                } else {
                    ao.setViewTextColor(this.jhC, R.color.CAM_X0302);
                    Drawable drawable = ao.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.jhC.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.jhK != null) {
                if (this.jhK.hasAgree) {
                    this.jhG.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                    ao.setViewTextColor(this.jhE, R.color.CAM_X0301);
                } else {
                    this.jhG.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                    ao.setViewTextColor(this.jhE, R.color.CAM_X0106);
                }
            }
            ao.setViewTextColor(this.jhD, R.color.CAM_X0106);
            this.jhF.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.jil != null) {
            this.jhK = gVar;
            this.eUP = this.jhK.autoPlay;
            this.jhw.setVisibility(0);
            this.jhw.setText(gVar.title);
            this.jhx.setVisibility(0);
            this.jhx.setText(at.stringForVideoTime(gVar.jil.videoDuration * 1000));
            if (gVar.jil.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), JC(String.format("%.1f", Float.valueOf(((float) gVar.jil.videoSize) / 1048576.0f))));
            }
            this.jhz.setText(format);
            this.jhy.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.jil != null) {
            this.jhJ.stopPlay();
            this.jhJ.wU(true);
            this.jhJ.wQ(false);
            this.jhJ.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rl() {
                    if (b.this.jhJ.rn()) {
                        b.this.jhx.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rm() {
                    if (b.this.jhJ.rn()) {
                        b.this.jhx.setVisibility(8);
                    }
                    if (b.this.jhP) {
                        b.this.jhJ.stopPlay();
                    }
                }
            });
            this.jhJ.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cEc() {
                    b.this.jhP = false;
                    b.this.jhx.setVisibility(8);
                    b.this.JB(b.this.eUP ? "1" : "2");
                    b.this.onClick(b.this.jhv);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cEd() {
                    b.this.jhx.setVisibility(8);
                    b.this.onClick(b.this.jhu);
                }
            });
            this.jhJ.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void qN(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.jhz.getText().toString());
                        b.this.jhJ.fX(b.this.jhK.jil.videoUrl, b.this.jhK.threadId);
                        b.this.jhx.setVisibility(8);
                        b.this.JB("2");
                    } else {
                        b.this.jhy.setVisibility(0);
                    }
                    b.this.onClick(b.this.jhv);
                }
            });
            this.jhJ.wM(false);
            this.jhM = new o();
            this.jhM.amM = gVar.threadId;
            this.jhM.fKR = gVar.forumId;
            this.jhM.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jhN = new o();
            this.jhN.amM = gVar.threadId;
            this.jhN.fKR = gVar.forumId;
            this.jhN.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.jhS) {
                aq aqVar = new aq("c12590");
                aqVar.dW("tid", gVar.threadId);
                aqVar.dW(IntentConfig.NID, gVar.nid);
                aqVar.an("obj_param5", gVar.getVideoType());
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dW("fid", gVar.forumId);
                aqVar.an("obj_locate", i);
                aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.jhM.myX = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jhM.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.jhM.myZ = "1";
                this.jhN.myX = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jhN.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jhN.myZ = "1";
            } else {
                this.jhM.myZ = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jhM.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.jhN.myZ = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jhN.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.jil != null) {
                this.jhM.mzc = gVar.jil.videoMd5;
                this.jhN.mzc = gVar.jil.videoMd5;
            }
            this.jhJ.getVideoView().setVideoStatData(this.jhM);
            this.jhJ.daq();
            this.jhJ.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void qO(boolean z) {
                    if (!b.this.jhJ.rn()) {
                        b.this.jhw.setVisibility(0);
                    } else if (z) {
                        if (b.this.jhw.getVisibility() == 0) {
                            b.this.jhw.setVisibility(8);
                            b.this.jhw.startAnimation(b.this.jhQ);
                        }
                    } else if (b.this.jhw.getVisibility() == 8) {
                        b.this.jhw.setVisibility(0);
                        b.this.jhw.startAnimation(b.this.cdO);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cEe() {
                    if (!b.this.jhJ.rn()) {
                        b.this.jhw.setVisibility(0);
                    } else if (b.this.jhw.getVisibility() == 0) {
                        b.this.jhw.setVisibility(8);
                        b.this.jhw.startAnimation(b.this.jhQ);
                    }
                }
            });
            this.jhJ.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.jhP = true;
                        b.this.jhO = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.yU(i);
                        b.this.jhJ.cQE();
                    }
                }
            });
            this.jhJ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.jhK != null && b.this.jhK.jil != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.jhK.jil.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.jhJ.setThumbnail(gVar.jil.thumbnailUrl);
            this.jhJ.setVideoUrl(gVar.jil.videoUrl, gVar.threadId);
            this.jhJ.PK(gVar.title);
            this.jhJ.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cEf() {
                    b.this.jhx.setVisibility(8);
                }
            });
            this.jhJ.cQE();
            this.jhJ.show();
            if (gVar.autoPlay) {
                onClick(this.jhv);
                this.jhP = false;
                this.jhJ.a(gVar.jil.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.jhP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB(String str) {
        if (this.jhK != null && this.jhK.jil != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jhK.jil.videoMd5, "", str, this.jhN, this.jhJ.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.jhJ.rn();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jhJ.aQJ();
        }
    }

    public boolean yV(int i) {
        return this.jhJ.GS(i);
    }

    public void stopVideo() {
        this.jhy.setVisibility(8);
        this.jhJ.stopPlay();
        if (this.jhw != null) {
            this.jhw.setVisibility(0);
        }
        if (this.jhx != null) {
            this.jhx.setVisibility(0);
        }
    }

    public void cEa() {
        if (this.jhJ != null) {
            this.jhJ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cEa();
        if (this.jhL != null) {
            this.jhL.cEk();
        }
    }

    public String JC(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.jik != null) {
            this.akj.setText(TextUtils.isEmpty(gVar.jik.userNickname) ? gVar.jik.userName : gVar.jik.userNickname);
            this.jhB.startLoad(gVar.jik.portrait, 12, false);
            this.jhB.setShowV(gVar.jik.isGod);
            this.jhB.setIsBigV(gVar.jik.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.jik != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.jik.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.jik.userId)) {
                this.jhC.setVisibility(8);
            } else {
                this.jhC.setVisibility(0);
            }
            if (gVar.jik.hasFocus) {
                ao.setViewTextColor(this.jhC, R.color.CAM_X0109);
                this.jhC.setCompoundDrawables(null, null, null, null);
                this.jhC.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ao.setViewTextColor(this.jhC, R.color.CAM_X0302);
            Drawable drawable = ao.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.jhC.setCompoundDrawables(drawable, null, null, null);
            this.jhC.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.jhG.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                ao.setViewTextColor(this.jhE, R.color.CAM_X0301);
            } else {
                this.jhG.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                ao.setViewTextColor(this.jhE, R.color.CAM_X0106);
            }
            this.jhE.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ao.setViewTextColor(this.jhD, R.color.CAM_X0106);
            this.jhF.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
            this.jhD.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jhJ != null && this.jhv != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jhO) {
                this.jhJ.dxv();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.jhv.getParent() != null) {
                    if (this.jhv.getParent() == frameLayout) {
                        frameLayout.removeView(this.jhv);
                    } else if (this.jhv.getParent() == this.jhu) {
                        this.jhu.removeView(this.jhv);
                    }
                }
                if (this.jhv.getParent() == null) {
                    frameLayout.addView(this.jhv);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jhv.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.jhv.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.jhv.getParent() != null) {
                    if (this.jhv.getParent() == frameLayout) {
                        frameLayout.removeView(this.jhv);
                    } else if (this.jhv.getParent() == this.jhu) {
                        this.jhu.removeView(this.jhv);
                    }
                }
                if (this.jhv.getParent() == null) {
                    this.jhu.addView(this.jhv, 0);
                    this.jhv.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.jhJ.daq();
                    this.jhO = true;
                } else {
                    return;
                }
            }
            this.jhJ.a(this.mPageContext, configuration);
            this.jhx.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            view.setTag(this);
            cqL().a(view, this.jhK);
        }
        if (view == this.jhB || view == this.akj) {
            boolean z = false;
            if (this.jhK != null && this.jhK.jik != null && !TextUtils.isEmpty(this.jhK.jik.userId)) {
                if (TbadkCoreApplication.isLogin() && this.jhK.jik.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jhK.jik.userId, 0L), z, this.jhK.jik.isGod)));
            }
        } else if (view == this.jhH || view == this.jhw || view == getView()) {
            if (this.jhK != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jhK.threadId, null, null);
                if (!this.jhS) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jhA) {
            if (this.jhK != null && this.jhK.jil != null) {
                this.jhy.setVisibility(8);
                this.jhJ.dxy();
                this.jhJ.fX(this.jhK.jil.videoUrl, this.jhK.threadId);
                JB("2");
            }
        } else if (view == this.jhC) {
            if (!this.jhK.jik.hasFocus) {
                this.jhL.f(this.jhK);
            }
        } else if (view == this.jhI) {
            com.baidu.tbadk.pageExtra.c fr = com.baidu.tbadk.pageExtra.d.fr(getContext());
            if (fr != null) {
                this.jhK.objSource = fr.getCurrentPageKey();
            }
            this.jhL.g(this.jhK);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qM(boolean z) {
        if (this.jhK != null && this.jhK.jik != null) {
            this.jhK.jik.hasFocus = z;
            c(this.jhK);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cEb() {
        if (this.jhK != null) {
            this.jhK.hasAgree = !this.jhK.hasAgree;
            if (this.jhK.hasAgree) {
                this.jhK.agreeNum++;
            } else {
                this.jhK.agreeNum--;
            }
            if (this.jhG != null) {
                this.jhG.startAnimation(getScaleAnimation());
            }
            d(this.jhK);
        }
    }

    private Animation getScaleAnimation() {
        if (this.jhR == null) {
            this.jhR = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.jhR.setDuration(200L);
        }
        return this.jhR;
    }
}
