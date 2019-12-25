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
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView ME;
    private Animation aGz;
    private boolean cRY;
    public TextView eXo;
    private n egK;
    public TextView goA;
    public TextView goB;
    public FrameLayout goC;
    public TextView goD;
    public TextView goE;
    public HeadImageView goF;
    public TextView goG;
    public TextView goH;
    public ImageView goI;
    public ImageView goJ;
    public LinearLayout goK;
    public LinearLayout goL;
    public com.baidu.tieba.play.c goM;
    public g goN;
    private h goO;
    private y goP;
    private y goQ;
    private boolean goR;
    private boolean goS;
    private Animation goT;
    private ScaleAnimation goU;
    private boolean goV;
    public FrameLayout goy;
    public FrameLayout goz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.goR = true;
        this.goV = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.goy = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.goz = (FrameLayout) view.findViewById(R.id.video_container);
        this.goM = new com.baidu.tieba.play.c(tbPageContext, this.goz, false);
        this.goA = (TextView) view.findViewById(R.id.title);
        this.goB = (TextView) view.findViewById(R.id.duration);
        this.goC = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.goD = (TextView) view.findViewById(R.id.mobile_network_text);
        this.goE = (TextView) view.findViewById(R.id.mobile_network_play);
        this.goF = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ME = (TextView) view.findViewById(R.id.user_name);
        this.eXo = (TextView) view.findViewById(R.id.attention);
        this.goK = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.goL = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.goG = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.goH = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.goI = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.goJ = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.goK.setOnClickListener(this);
        this.goL.setOnClickListener(this);
        this.goA.setOnClickListener(this);
        this.goF.setOnClickListener(this);
        this.ME.setOnClickListener(this);
        this.eXo.setOnClickListener(this);
        view.setOnClickListener(this);
        this.goE.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.goy.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.goy.setLayoutParams(layoutParams);
        this.goF.setIsRound(true);
        this.egK = new n(tbPageContext.getPageActivity());
        this.goO = new h(this.mPageContext, this);
        this.goT = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.aGz = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.goN != null && this.goN.gpm != null) {
                if (this.goN.gpm.hasFocus) {
                    am.setViewTextColor(this.eXo, (int) R.color.cp_cont_d);
                    this.eXo.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.eXo, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.eXo.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.goN != null) {
                if (this.goN.hasAgree) {
                    this.goJ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.goH, (int) R.color.cp_cont_h);
                } else {
                    this.goJ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.goH, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.goG, (int) R.color.cp_cont_f);
            this.goI.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.gpn != null) {
            this.goN = gVar;
            this.cRY = this.goN.autoPlay;
            this.goA.setVisibility(0);
            this.goA.setText(gVar.title);
            this.goB.setVisibility(0);
            this.goB.setText(aq.stringForVideoTime(gVar.gpn.videoDuration * 1000));
            if (gVar.gpn.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), AJ(String.format("%.1f", Float.valueOf(((float) gVar.gpn.videoSize) / 1048576.0f))));
            }
            this.goD.setText(format);
            this.goC.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.gpn != null) {
            this.goM.stopPlay();
            this.goM.setIsNeedRecoveryVideoPlayer(true);
            this.goM.rv(true);
            this.goM.rr(false);
            this.goM.a(new c.InterfaceC0576c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kM() {
                    if (b.this.goM.kO()) {
                        b.this.goB.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kN() {
                    if (b.this.goM.kO()) {
                        b.this.goB.setVisibility(8);
                    }
                    if (b.this.goS) {
                        b.this.goM.stopPlay();
                    }
                }
            });
            this.goM.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bDH() {
                    b.this.goS = false;
                    b.this.goB.setVisibility(8);
                    b.this.AI(b.this.cRY ? "1" : "2");
                    b.this.onClick(b.this.goz);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bDI() {
                    b.this.goB.setVisibility(8);
                    b.this.onClick(b.this.goy);
                }
            });
            this.goM.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void lt(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.goD.getText().toString());
                        b.this.goM.dX(b.this.goN.gpn.videoUrl, b.this.goN.threadId);
                        b.this.goB.setVisibility(8);
                        b.this.AI("2");
                    } else {
                        b.this.goC.setVisibility(0);
                    }
                    b.this.onClick(b.this.goz);
                }
            });
            this.goM.rn(false);
            this.goP = new y();
            this.goP.OC = gVar.threadId;
            this.goP.fGQ = gVar.forumId;
            this.goP.mUid = TbadkCoreApplication.getCurrentAccount();
            this.goQ = new y();
            this.goQ.OC = gVar.threadId;
            this.goQ.fGQ = gVar.forumId;
            this.goQ.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.goV) {
                an anVar = new an("c12590");
                anVar.cp("tid", gVar.threadId);
                anVar.Z("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cp("fid", gVar.forumId);
                anVar.Z("obj_locate", i);
                anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.goP.jsi = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.goP.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.goP.jsk = "1";
                this.goQ.jsi = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.goQ.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.goQ.jsk = "1";
            } else {
                this.goP.jsk = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.goP.mLocate = "12";
                this.goQ.jsk = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.goQ.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.gpn != null) {
                this.goP.jsl = gVar.gpn.videoMd5;
                this.goQ.jsl = gVar.gpn.videoMd5;
            }
            this.egK.setVideoStatsData(this.goP);
            this.goM.getVideoView().setBusiness(this.egK);
            this.goM.bZU();
            this.goM.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void lu(boolean z) {
                    if (!b.this.goM.kO()) {
                        b.this.goA.setVisibility(0);
                    } else if (z) {
                        if (b.this.goA.getVisibility() == 0) {
                            b.this.goA.setVisibility(8);
                            b.this.goA.startAnimation(b.this.goT);
                        }
                    } else if (b.this.goA.getVisibility() == 8) {
                        b.this.goA.setVisibility(0);
                        b.this.goA.startAnimation(b.this.aGz);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bDJ() {
                    if (!b.this.goM.kO()) {
                        b.this.goA.setVisibility(0);
                    } else if (b.this.goA.getVisibility() == 0) {
                        b.this.goA.setVisibility(8);
                        b.this.goA.startAnimation(b.this.goT);
                    }
                }
            });
            this.goM.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.goS = true;
                        b.this.goR = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.sT(i);
                        b.this.goM.bNb();
                    }
                }
            });
            this.goM.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.goN != null && b.this.goN.gpn != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.goN.gpn.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.goM.setThumbnail(gVar.gpn.thumbnailUrl);
            this.goM.setVideoUrl(gVar.gpn.videoUrl, gVar.threadId);
            this.goM.Gz(gVar.title);
            this.goM.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bDK() {
                    b.this.goB.setVisibility(8);
                }
            });
            this.goM.bNb();
            this.goM.show();
            if (gVar.autoPlay) {
                onClick(this.goz);
                this.goS = false;
                this.goM.a(gVar.gpn.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.goS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AI(String str) {
        if (this.goN != null && this.goN.gpn != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.goN.gpn.videoMd5, "", str, this.goQ);
            }
        }
    }

    public boolean isPlaying() {
        return this.goM.kO();
    }

    public void bDD() {
        if (isPlaying()) {
            this.goM.pausePlay();
        }
    }

    public boolean sU(int i) {
        return this.goM.zY(i);
    }

    public void bDE() {
        this.goC.setVisibility(8);
        this.goM.stopPlay();
        if (this.goA != null) {
            this.goA.setVisibility(0);
        }
        if (this.goB != null) {
            this.goB.setVisibility(0);
        }
    }

    public void bDF() {
        if (this.goM != null) {
            this.goM.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bDF();
        if (this.goO != null) {
            this.goO.bDP();
        }
    }

    public String AJ(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.gpm != null) {
            this.ME.setText(TextUtils.isEmpty(gVar.gpm.userNickname) ? gVar.gpm.userName : gVar.gpm.userNickname);
            this.goF.startLoad(gVar.gpm.portrait, 12, false);
            this.goF.setShowV(gVar.gpm.isGod);
            this.goF.setIsBigV(gVar.gpm.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.gpm != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.gpm.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.gpm.userId)) {
                this.eXo.setVisibility(8);
            } else {
                this.eXo.setVisibility(0);
            }
            if (gVar.gpm.hasFocus) {
                am.setViewTextColor(this.eXo, (int) R.color.cp_cont_d);
                this.eXo.setCompoundDrawables(null, null, null, null);
                this.eXo.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.eXo, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.eXo.setCompoundDrawables(drawable, null, null, null);
            this.eXo.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.goJ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.goH, (int) R.color.cp_cont_h);
            } else {
                this.goJ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.goH, (int) R.color.cp_cont_f);
            }
            this.goH.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.goG, (int) R.color.cp_cont_f);
            this.goI.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.goG.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.goM != null && this.goz != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.goR) {
                this.goM.cvC();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.goz.getParent() != null) {
                    if (this.goz.getParent() == frameLayout) {
                        frameLayout.removeView(this.goz);
                    } else if (this.goz.getParent() == this.goy) {
                        this.goy.removeView(this.goz);
                    }
                }
                if (this.goz.getParent() == null) {
                    frameLayout.addView(this.goz);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.goz.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.goz.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.goz.getParent() != null) {
                    if (this.goz.getParent() == frameLayout) {
                        frameLayout.removeView(this.goz);
                    } else if (this.goz.getParent() == this.goy) {
                        this.goy.removeView(this.goz);
                    }
                }
                if (this.goz.getParent() == null) {
                    this.goy.addView(this.goz, 0);
                    this.goz.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.goM.bZU();
                    this.goR = true;
                } else {
                    return;
                }
            }
            this.goM.a(this.mPageContext, configuration);
            this.goB.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            view.setTag(this);
            brY().a(view, this.goN);
        }
        if (view == this.goF || view == this.ME) {
            boolean z = false;
            if (this.goN != null && this.goN.gpm != null && !TextUtils.isEmpty(this.goN.gpm.userId)) {
                if (TbadkCoreApplication.isLogin() && this.goN.gpm.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.goN.gpm.userId, 0L), z, this.goN.gpm.isGod)));
            }
        } else if (view == this.goK || view == this.goA || view == getView()) {
            if (this.goN != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.goN.threadId, null, null);
                if (!this.goV) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.goE) {
            if (this.goN != null && this.goN.gpn != null) {
                this.goC.setVisibility(8);
                this.goM.cvF();
                this.goM.dX(this.goN.gpn.videoUrl, this.goN.threadId);
                AI("2");
            }
        } else if (view == this.eXo) {
            if (!this.goN.gpm.hasFocus) {
                this.goO.f(this.goN);
            }
        } else if (view == this.goL) {
            this.goO.g(this.goN);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ls(boolean z) {
        if (this.goN != null && this.goN.gpm != null) {
            this.goN.gpm.hasFocus = z;
            c(this.goN);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bDG() {
        if (this.goN != null) {
            this.goN.hasAgree = !this.goN.hasAgree;
            if (this.goN.hasAgree) {
                this.goN.agreeNum++;
            } else {
                this.goN.agreeNum--;
            }
            if (this.goJ != null) {
                this.goJ.startAnimation(getScaleAnimation());
            }
            d(this.goN);
        }
    }

    private Animation getScaleAnimation() {
        if (this.goU == null) {
            this.goU = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.goU.setDuration(200L);
        }
        return this.goU;
    }
}
