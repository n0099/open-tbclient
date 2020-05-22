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
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView agw;
    private Animation boW;
    private boolean dJS;
    public TextView fVX;
    private n fbO;
    public FrameLayout hsF;
    public FrameLayout hsG;
    public TextView hsH;
    public TextView hsI;
    public FrameLayout hsJ;
    public TextView hsK;
    public TextView hsL;
    public HeadImageView hsM;
    public TextView hsN;
    public TextView hsO;
    public ImageView hsP;
    public ImageView hsQ;
    public LinearLayout hsR;
    public LinearLayout hsS;
    public com.baidu.tieba.play.c hsT;
    public g hsU;
    private h hsV;
    private y hsW;
    private y hsX;
    private boolean hsY;
    private boolean hsZ;
    private Animation hta;
    private ScaleAnimation htb;
    private boolean htc;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.hsY = true;
        this.htc = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hsF = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hsG = (FrameLayout) view.findViewById(R.id.video_container);
        this.hsT = new com.baidu.tieba.play.c(tbPageContext, this.hsG, false);
        this.hsH = (TextView) view.findViewById(R.id.title);
        this.hsI = (TextView) view.findViewById(R.id.duration);
        this.hsJ = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hsK = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hsL = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hsM = (HeadImageView) view.findViewById(R.id.user_icon);
        this.agw = (TextView) view.findViewById(R.id.user_name);
        this.fVX = (TextView) view.findViewById(R.id.attention);
        this.hsR = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.hsS = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hsN = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hsO = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hsP = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.hsQ = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.hsR.setOnClickListener(this);
        this.hsS.setOnClickListener(this);
        this.hsH.setOnClickListener(this);
        this.hsM.setOnClickListener(this);
        this.agw.setOnClickListener(this);
        this.fVX.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hsL.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hsF.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hsF.setLayoutParams(layoutParams);
        this.hsM.setIsRound(true);
        this.fbO = new n(tbPageContext.getPageActivity());
        this.hsV = new h(this.mPageContext, this);
        this.hta = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.boW = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.hsU != null && this.hsU.htt != null) {
                if (this.hsU.htt.hasFocus) {
                    am.setViewTextColor(this.fVX, (int) R.color.cp_cont_d);
                    this.fVX.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fVX, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fVX.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.hsU != null) {
                if (this.hsU.hasAgree) {
                    this.hsQ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.hsO, (int) R.color.cp_cont_h);
                } else {
                    this.hsQ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.hsO, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.hsN, (int) R.color.cp_cont_f);
            this.hsP.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.htu != null) {
            this.hsU = gVar;
            this.dJS = this.hsU.autoPlay;
            this.hsH.setVisibility(0);
            this.hsH.setText(gVar.title);
            this.hsI.setVisibility(0);
            this.hsI.setText(aq.stringForVideoTime(gVar.htu.videoDuration * 1000));
            if (gVar.htu.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), EH(String.format("%.1f", Float.valueOf(((float) gVar.htu.videoSize) / 1048576.0f))));
            }
            this.hsK.setText(format);
            this.hsJ.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.htu != null) {
            this.hsT.stopPlay();
            this.hsT.setIsNeedRecoveryVideoPlayer(true);
            this.hsT.tt(true);
            this.hsT.tp(false);
            this.hsT.a(new c.InterfaceC0703c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pM() {
                    if (b.this.hsT.pO()) {
                        b.this.hsI.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pN() {
                    if (b.this.hsT.pO()) {
                        b.this.hsI.setVisibility(8);
                    }
                    if (b.this.hsZ) {
                        b.this.hsT.stopPlay();
                    }
                }
            });
            this.hsT.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bXw() {
                    b.this.hsZ = false;
                    b.this.hsI.setVisibility(8);
                    b.this.EG(b.this.dJS ? "1" : "2");
                    b.this.onClick(b.this.hsG);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bXx() {
                    b.this.hsI.setVisibility(8);
                    b.this.onClick(b.this.hsF);
                }
            });
            this.hsT.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void nl(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hsK.getText().toString());
                        b.this.hsT.eW(b.this.hsU.htu.videoUrl, b.this.hsU.threadId);
                        b.this.hsI.setVisibility(8);
                        b.this.EG("2");
                    } else {
                        b.this.hsJ.setVisibility(0);
                    }
                    b.this.onClick(b.this.hsG);
                }
            });
            this.hsT.tl(false);
            this.hsW = new y();
            this.hsW.ais = gVar.threadId;
            this.hsW.evm = gVar.forumId;
            this.hsW.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hsX = new y();
            this.hsX.ais = gVar.threadId;
            this.hsX.evm = gVar.forumId;
            this.hsX.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.htc) {
                an anVar = new an("c12590");
                anVar.dh("tid", gVar.threadId);
                anVar.dh("nid", gVar.nid);
                anVar.ag("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.dh("fid", gVar.forumId);
                anVar.ag("obj_locate", i);
                anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.hsW.kAl = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hsW.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.hsW.kAn = "1";
                this.hsX.kAl = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hsX.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hsX.kAn = "1";
            } else {
                this.hsW.kAn = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hsW.mLocate = "12";
                this.hsX.kAn = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hsX.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.htu != null) {
                this.hsW.kAq = gVar.htu.videoMd5;
                this.hsX.kAq = gVar.htu.videoMd5;
            }
            this.fbO.setVideoStatsData(this.hsW);
            this.hsT.getVideoView().setBusiness(this.fbO);
            this.hsT.cub();
            this.hsT.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void nm(boolean z) {
                    if (!b.this.hsT.pO()) {
                        b.this.hsH.setVisibility(0);
                    } else if (z) {
                        if (b.this.hsH.getVisibility() == 0) {
                            b.this.hsH.setVisibility(8);
                            b.this.hsH.startAnimation(b.this.hta);
                        }
                    } else if (b.this.hsH.getVisibility() == 8) {
                        b.this.hsH.setVisibility(0);
                        b.this.hsH.startAnimation(b.this.boW);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bXy() {
                    if (!b.this.hsT.pO()) {
                        b.this.hsH.setVisibility(0);
                    } else if (b.this.hsH.getVisibility() == 0) {
                        b.this.hsH.setVisibility(8);
                        b.this.hsH.startAnimation(b.this.hta);
                    }
                }
            });
            this.hsT.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.hsZ = true;
                        b.this.hsY = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.uj(i);
                        b.this.hsT.chf();
                    }
                }
            });
            this.hsT.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.hsU != null && b.this.hsU.htu != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.hsU.htu.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hsT.setThumbnail(gVar.htu.thumbnailUrl);
            this.hsT.setVideoUrl(gVar.htu.videoUrl, gVar.threadId);
            this.hsT.Ku(gVar.title);
            this.hsT.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bXz() {
                    b.this.hsI.setVisibility(8);
                }
            });
            this.hsT.chf();
            this.hsT.show();
            if (gVar.autoPlay) {
                onClick(this.hsG);
                this.hsZ = false;
                this.hsT.a(gVar.htu.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.hsZ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(String str) {
        if (this.hsU != null && this.hsU.htu != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hsU.htu.videoMd5, "", str, this.hsX);
            }
        }
    }

    public boolean isPlaying() {
        return this.hsT.pO();
    }

    public void bXs() {
        if (isPlaying()) {
            this.hsT.avT();
        }
    }

    public boolean uk(int i) {
        return this.hsT.BE(i);
    }

    public void bXt() {
        this.hsJ.setVisibility(8);
        this.hsT.stopPlay();
        if (this.hsH != null) {
            this.hsH.setVisibility(0);
        }
        if (this.hsI != null) {
            this.hsI.setVisibility(0);
        }
    }

    public void bXu() {
        if (this.hsT != null) {
            this.hsT.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        bXu();
        if (this.hsV != null) {
            this.hsV.bXE();
        }
    }

    public String EH(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.htt != null) {
            this.agw.setText(TextUtils.isEmpty(gVar.htt.userNickname) ? gVar.htt.userName : gVar.htt.userNickname);
            this.hsM.startLoad(gVar.htt.portrait, 12, false);
            this.hsM.setShowV(gVar.htt.isGod);
            this.hsM.setIsBigV(gVar.htt.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.htt != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.htt.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.htt.userId)) {
                this.fVX.setVisibility(8);
            } else {
                this.fVX.setVisibility(0);
            }
            if (gVar.htt.hasFocus) {
                am.setViewTextColor(this.fVX, (int) R.color.cp_cont_d);
                this.fVX.setCompoundDrawables(null, null, null, null);
                this.fVX.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fVX, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fVX.setCompoundDrawables(drawable, null, null, null);
            this.fVX.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.hsQ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.hsO, (int) R.color.cp_cont_h);
            } else {
                this.hsQ.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.hsO, (int) R.color.cp_cont_f);
            }
            this.hsO.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.hsN, (int) R.color.cp_cont_f);
            this.hsP.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.hsN.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hsT != null && this.hsG != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hsY) {
                this.hsT.cQc();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hsG.getParent() != null) {
                    if (this.hsG.getParent() == frameLayout) {
                        frameLayout.removeView(this.hsG);
                    } else if (this.hsG.getParent() == this.hsF) {
                        this.hsF.removeView(this.hsG);
                    }
                }
                if (this.hsG.getParent() == null) {
                    frameLayout.addView(this.hsG);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hsG.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hsG.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hsG.getParent() != null) {
                    if (this.hsG.getParent() == frameLayout) {
                        frameLayout.removeView(this.hsG);
                    } else if (this.hsG.getParent() == this.hsF) {
                        this.hsF.removeView(this.hsG);
                    }
                }
                if (this.hsG.getParent() == null) {
                    this.hsF.addView(this.hsG, 0);
                    this.hsG.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hsT.cub();
                    this.hsY = true;
                } else {
                    return;
                }
            }
            this.hsT.a(this.mPageContext, configuration);
            this.hsI.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            view.setTag(this);
            bKS().a(view, this.hsU);
        }
        if (view == this.hsM || view == this.agw) {
            boolean z = false;
            if (this.hsU != null && this.hsU.htt != null && !TextUtils.isEmpty(this.hsU.htt.userId)) {
                if (TbadkCoreApplication.isLogin() && this.hsU.htt.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hsU.htt.userId, 0L), z, this.hsU.htt.isGod)));
            }
        } else if (view == this.hsR || view == this.hsH || view == getView()) {
            if (this.hsU != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hsU.threadId, null, null);
                if (!this.htc) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hsL) {
            if (this.hsU != null && this.hsU.htu != null) {
                this.hsJ.setVisibility(8);
                this.hsT.cQf();
                this.hsT.eW(this.hsU.htu.videoUrl, this.hsU.threadId);
                EG("2");
            }
        } else if (view == this.fVX) {
            if (!this.hsU.htt.hasFocus) {
                this.hsV.f(this.hsU);
            }
        } else if (view == this.hsS) {
            this.hsV.g(this.hsU);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void nk(boolean z) {
        if (this.hsU != null && this.hsU.htt != null) {
            this.hsU.htt.hasFocus = z;
            c(this.hsU);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bXv() {
        if (this.hsU != null) {
            this.hsU.hasAgree = !this.hsU.hasAgree;
            if (this.hsU.hasAgree) {
                this.hsU.agreeNum++;
            } else {
                this.hsU.agreeNum--;
            }
            if (this.hsQ != null) {
                this.hsQ.startAnimation(getScaleAnimation());
            }
            d(this.hsU);
        }
    }

    private Animation getScaleAnimation() {
        if (this.htb == null) {
            this.htb = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.htb.setDuration(200L);
        }
        return this.htb;
    }
}
