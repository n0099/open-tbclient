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
    public TextView Nm;
    private Animation aLM;
    private boolean cWz;
    private n elC;
    public TextView fdM;
    public FrameLayout guA;
    public FrameLayout guB;
    public TextView guC;
    public TextView guD;
    public FrameLayout guE;
    public TextView guF;
    public TextView guG;
    public HeadImageView guH;
    public TextView guI;
    public TextView guJ;
    public ImageView guK;
    public ImageView guL;
    public LinearLayout guM;
    public LinearLayout guN;
    public com.baidu.tieba.play.c guO;
    public g guP;
    private h guQ;
    private y guR;
    private y guS;
    private boolean guT;
    private boolean guU;
    private Animation guV;
    private ScaleAnimation guW;
    private boolean guX;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.guT = true;
        this.guX = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.guA = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.guB = (FrameLayout) view.findViewById(R.id.video_container);
        this.guO = new com.baidu.tieba.play.c(tbPageContext, this.guB, false);
        this.guC = (TextView) view.findViewById(R.id.title);
        this.guD = (TextView) view.findViewById(R.id.duration);
        this.guE = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.guF = (TextView) view.findViewById(R.id.mobile_network_text);
        this.guG = (TextView) view.findViewById(R.id.mobile_network_play);
        this.guH = (HeadImageView) view.findViewById(R.id.user_icon);
        this.Nm = (TextView) view.findViewById(R.id.user_name);
        this.fdM = (TextView) view.findViewById(R.id.attention);
        this.guM = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.guN = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.guI = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.guJ = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.guK = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.guL = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.guM.setOnClickListener(this);
        this.guN.setOnClickListener(this);
        this.guC.setOnClickListener(this);
        this.guH.setOnClickListener(this);
        this.Nm.setOnClickListener(this);
        this.fdM.setOnClickListener(this);
        view.setOnClickListener(this);
        this.guG.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.guA.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.guA.setLayoutParams(layoutParams);
        this.guH.setIsRound(true);
        this.elC = new n(tbPageContext.getPageActivity());
        this.guQ = new h(this.mPageContext, this);
        this.guV = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.aLM = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.guP != null && this.guP.gvo != null) {
                if (this.guP.gvo.hasFocus) {
                    am.setViewTextColor(this.fdM, (int) R.color.cp_cont_d);
                    this.fdM.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fdM, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fdM.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.guP != null) {
                if (this.guP.hasAgree) {
                    this.guL.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.guJ, (int) R.color.cp_cont_h);
                } else {
                    this.guL.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.guJ, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.guI, (int) R.color.cp_cont_f);
            this.guK.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.gvp != null) {
            this.guP = gVar;
            this.cWz = this.guP.autoPlay;
            this.guC.setVisibility(0);
            this.guC.setText(gVar.title);
            this.guD.setVisibility(0);
            this.guD.setText(aq.stringForVideoTime(gVar.gvp.videoDuration * 1000));
            if (gVar.gvp.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Bl(String.format("%.1f", Float.valueOf(((float) gVar.gvp.videoSize) / 1048576.0f))));
            }
            this.guF.setText(format);
            this.guE.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.gvp != null) {
            this.guO.stopPlay();
            this.guO.setIsNeedRecoveryVideoPlayer(true);
            this.guO.rR(true);
            this.guO.rN(false);
            this.guO.a(new c.InterfaceC0590c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void lc() {
                    if (b.this.guO.le()) {
                        b.this.guD.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void ld() {
                    if (b.this.guO.le()) {
                        b.this.guD.setVisibility(8);
                    }
                    if (b.this.guU) {
                        b.this.guO.stopPlay();
                    }
                }
            });
            this.guO.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bGA() {
                    b.this.guU = false;
                    b.this.guD.setVisibility(8);
                    b.this.Bk(b.this.cWz ? "1" : "2");
                    b.this.onClick(b.this.guB);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bGB() {
                    b.this.guD.setVisibility(8);
                    b.this.onClick(b.this.guA);
                }
            });
            this.guO.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void lM(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.guF.getText().toString());
                        b.this.guO.eg(b.this.guP.gvp.videoUrl, b.this.guP.threadId);
                        b.this.guD.setVisibility(8);
                        b.this.Bk("2");
                    } else {
                        b.this.guE.setVisibility(0);
                    }
                    b.this.onClick(b.this.guB);
                }
            });
            this.guO.rJ(false);
            this.guR = new y();
            this.guR.Pk = gVar.threadId;
            this.guR.emF = gVar.forumId;
            this.guR.mUid = TbadkCoreApplication.getCurrentAccount();
            this.guS = new y();
            this.guS.Pk = gVar.threadId;
            this.guS.emF = gVar.forumId;
            this.guS.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.guX) {
                an anVar = new an("c12590");
                anVar.cx("tid", gVar.threadId);
                anVar.X("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cx("fid", gVar.forumId);
                anVar.X("obj_locate", i);
                anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.guR.jyr = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.guR.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.guR.jyt = "1";
                this.guS.jyr = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.guS.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.guS.jyt = "1";
            } else {
                this.guR.jyt = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.guR.mLocate = "12";
                this.guS.jyt = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.guS.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.gvp != null) {
                this.guR.jyv = gVar.gvp.videoMd5;
                this.guS.jyv = gVar.gvp.videoMd5;
            }
            this.elC.setVideoStatsData(this.guR);
            this.guO.getVideoView().setBusiness(this.elC);
            this.guO.cda();
            this.guO.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void lN(boolean z) {
                    if (!b.this.guO.le()) {
                        b.this.guC.setVisibility(0);
                    } else if (z) {
                        if (b.this.guC.getVisibility() == 0) {
                            b.this.guC.setVisibility(8);
                            b.this.guC.startAnimation(b.this.guV);
                        }
                    } else if (b.this.guC.getVisibility() == 8) {
                        b.this.guC.setVisibility(0);
                        b.this.guC.startAnimation(b.this.aLM);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGC() {
                    if (!b.this.guO.le()) {
                        b.this.guC.setVisibility(0);
                    } else if (b.this.guC.getVisibility() == 0) {
                        b.this.guC.setVisibility(8);
                        b.this.guC.startAnimation(b.this.guV);
                    }
                }
            });
            this.guO.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.guU = true;
                        b.this.guT = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.tg(i);
                        b.this.guO.bQh();
                    }
                }
            });
            this.guO.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.guP != null && b.this.guP.gvp != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.guP.gvp.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.guO.setThumbnail(gVar.gvp.thumbnailUrl);
            this.guO.setVideoUrl(gVar.gvp.videoUrl, gVar.threadId);
            this.guO.GY(gVar.title);
            this.guO.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bGD() {
                    b.this.guD.setVisibility(8);
                }
            });
            this.guO.bQh();
            this.guO.show();
            if (gVar.autoPlay) {
                onClick(this.guB);
                this.guU = false;
                this.guO.a(gVar.gvp.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.guU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk(String str) {
        if (this.guP != null && this.guP.gvp != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.guP.gvp.videoMd5, "", str, this.guS);
            }
        }
    }

    public boolean isPlaying() {
        return this.guO.le();
    }

    public void bGw() {
        if (isPlaying()) {
            this.guO.pausePlay();
        }
    }

    public boolean th(int i) {
        return this.guO.Au(i);
    }

    public void bGx() {
        this.guE.setVisibility(8);
        this.guO.stopPlay();
        if (this.guC != null) {
            this.guC.setVisibility(0);
        }
        if (this.guD != null) {
            this.guD.setVisibility(0);
        }
    }

    public void bGy() {
        if (this.guO != null) {
            this.guO.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bGy();
        if (this.guQ != null) {
            this.guQ.bGI();
        }
    }

    public String Bl(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.gvo != null) {
            this.Nm.setText(TextUtils.isEmpty(gVar.gvo.userNickname) ? gVar.gvo.userName : gVar.gvo.userNickname);
            this.guH.startLoad(gVar.gvo.portrait, 12, false);
            this.guH.setShowV(gVar.gvo.isGod);
            this.guH.setIsBigV(gVar.gvo.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.gvo != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.gvo.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.gvo.userId)) {
                this.fdM.setVisibility(8);
            } else {
                this.fdM.setVisibility(0);
            }
            if (gVar.gvo.hasFocus) {
                am.setViewTextColor(this.fdM, (int) R.color.cp_cont_d);
                this.fdM.setCompoundDrawables(null, null, null, null);
                this.fdM.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fdM, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fdM.setCompoundDrawables(drawable, null, null, null);
            this.fdM.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.guL.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.guJ, (int) R.color.cp_cont_h);
            } else {
                this.guL.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.guJ, (int) R.color.cp_cont_f);
            }
            this.guJ.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.guI, (int) R.color.cp_cont_f);
            this.guK.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.guI.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.guO != null && this.guB != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.guT) {
                this.guO.cyA();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.guB.getParent() != null) {
                    if (this.guB.getParent() == frameLayout) {
                        frameLayout.removeView(this.guB);
                    } else if (this.guB.getParent() == this.guA) {
                        this.guA.removeView(this.guB);
                    }
                }
                if (this.guB.getParent() == null) {
                    frameLayout.addView(this.guB);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.guB.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.guB.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.guB.getParent() != null) {
                    if (this.guB.getParent() == frameLayout) {
                        frameLayout.removeView(this.guB);
                    } else if (this.guB.getParent() == this.guA) {
                        this.guA.removeView(this.guB);
                    }
                }
                if (this.guB.getParent() == null) {
                    this.guA.addView(this.guB, 0);
                    this.guB.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.guO.cda();
                    this.guT = true;
                } else {
                    return;
                }
            }
            this.guO.a(this.mPageContext, configuration);
            this.guD.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buM() != null) {
            view.setTag(this);
            buM().a(view, this.guP);
        }
        if (view == this.guH || view == this.Nm) {
            boolean z = false;
            if (this.guP != null && this.guP.gvo != null && !TextUtils.isEmpty(this.guP.gvo.userId)) {
                if (TbadkCoreApplication.isLogin() && this.guP.gvo.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.guP.gvo.userId, 0L), z, this.guP.gvo.isGod)));
            }
        } else if (view == this.guM || view == this.guC || view == getView()) {
            if (this.guP != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.guP.threadId, null, null);
                if (!this.guX) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.guG) {
            if (this.guP != null && this.guP.gvp != null) {
                this.guE.setVisibility(8);
                this.guO.cyD();
                this.guO.eg(this.guP.gvp.videoUrl, this.guP.threadId);
                Bk("2");
            }
        } else if (view == this.fdM) {
            if (!this.guP.gvo.hasFocus) {
                this.guQ.f(this.guP);
            }
        } else if (view == this.guN) {
            this.guQ.g(this.guP);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void lL(boolean z) {
        if (this.guP != null && this.guP.gvo != null) {
            this.guP.gvo.hasFocus = z;
            c(this.guP);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bGz() {
        if (this.guP != null) {
            this.guP.hasAgree = !this.guP.hasAgree;
            if (this.guP.hasAgree) {
                this.guP.agreeNum++;
            } else {
                this.guP.agreeNum--;
            }
            if (this.guL != null) {
                this.guL.startAnimation(getScaleAnimation());
            }
            d(this.guP);
        }
    }

    private Animation getScaleAnimation() {
        if (this.guW == null) {
            this.guW = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.guW.setDuration(200L);
        }
        return this.guW;
    }
}
