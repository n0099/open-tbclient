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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView ahr;
    private Animation but;
    private boolean dXa;
    public TextView goe;
    public FrameLayout hLE;
    public FrameLayout hLF;
    public TextView hLG;
    public TextView hLH;
    public FrameLayout hLI;
    public TextView hLJ;
    public TextView hLK;
    public HeadImageView hLL;
    public TextView hLM;
    public TextView hLN;
    public ImageView hLO;
    public ImageView hLP;
    public LinearLayout hLQ;
    public LinearLayout hLR;
    public com.baidu.tieba.play.c hLS;
    public g hLT;
    private h hLU;
    private o hLV;
    private o hLW;
    private boolean hLX;
    private boolean hLY;
    private Animation hLZ;
    private ScaleAnimation hMa;
    private boolean hMb;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.hLX = true;
        this.hMb = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hLE = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hLF = (FrameLayout) view.findViewById(R.id.video_container);
        this.hLS = new com.baidu.tieba.play.c(tbPageContext, this.hLF, false);
        this.hLG = (TextView) view.findViewById(R.id.title);
        this.hLH = (TextView) view.findViewById(R.id.duration);
        this.hLI = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hLJ = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hLK = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hLL = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ahr = (TextView) view.findViewById(R.id.user_name);
        this.goe = (TextView) view.findViewById(R.id.attention);
        this.hLQ = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.hLR = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hLM = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hLN = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hLO = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.hLP = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.hLQ.setOnClickListener(this);
        this.hLR.setOnClickListener(this);
        this.hLG.setOnClickListener(this);
        this.hLL.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.goe.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hLK.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hLE.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hLE.setLayoutParams(layoutParams);
        this.hLL.setIsRound(true);
        this.hLU = new h(this.mPageContext, this);
        this.hLZ = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.but = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ao.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.hLT != null && this.hLT.hMs != null) {
                if (this.hLT.hMs.hasFocus) {
                    ao.setViewTextColor(this.goe, R.color.cp_cont_d);
                    this.goe.setCompoundDrawables(null, null, null, null);
                } else {
                    ao.setViewTextColor(this.goe, R.color.cp_link_tip_a);
                    Drawable drawable = ao.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.goe.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.hLT != null) {
                if (this.hLT.hasAgree) {
                    this.hLP.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                    ao.setViewTextColor(this.hLN, R.color.cp_cont_h);
                } else {
                    this.hLP.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                    ao.setViewTextColor(this.hLN, R.color.cp_cont_f);
                }
            }
            ao.setViewTextColor(this.hLM, R.color.cp_cont_f);
            this.hLO.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.hMt != null) {
            this.hLT = gVar;
            this.dXa = this.hLT.autoPlay;
            this.hLG.setVisibility(0);
            this.hLG.setText(gVar.title);
            this.hLH.setVisibility(0);
            this.hLH.setText(as.stringForVideoTime(gVar.hMt.videoDuration * 1000));
            if (gVar.hMt.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), FT(String.format("%.1f", Float.valueOf(((float) gVar.hMt.videoSize) / 1048576.0f))));
            }
            this.hLJ.setText(format);
            this.hLI.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.hMt != null) {
            this.hLS.stopPlay();
            this.hLS.un(true);
            this.hLS.uj(false);
            this.hLS.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qe() {
                    if (b.this.hLS.qg()) {
                        b.this.hLH.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qf() {
                    if (b.this.hLS.qg()) {
                        b.this.hLH.setVisibility(8);
                    }
                    if (b.this.hLY) {
                        b.this.hLS.stopPlay();
                    }
                }
            });
            this.hLS.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cei() {
                    b.this.hLY = false;
                    b.this.hLH.setVisibility(8);
                    b.this.FS(b.this.dXa ? "1" : "2");
                    b.this.onClick(b.this.hLF);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cej() {
                    b.this.hLH.setVisibility(8);
                    b.this.onClick(b.this.hLE);
                }
            });
            this.hLS.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void ob(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hLJ.getText().toString());
                        b.this.hLS.ff(b.this.hLT.hMt.videoUrl, b.this.hLT.threadId);
                        b.this.hLH.setVisibility(8);
                        b.this.FS("2");
                    } else {
                        b.this.hLI.setVisibility(0);
                    }
                    b.this.onClick(b.this.hLF);
                }
            });
            this.hLS.uf(false);
            this.hLV = new o();
            this.hLV.ajJ = gVar.threadId;
            this.hLV.eKO = gVar.forumId;
            this.hLV.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hLW = new o();
            this.hLW.ajJ = gVar.threadId;
            this.hLW.eKO = gVar.forumId;
            this.hLW.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.hMb) {
                ap apVar = new ap("c12590");
                apVar.dn("tid", gVar.threadId);
                apVar.dn("nid", gVar.nid);
                apVar.ah("obj_param5", gVar.getVideoType());
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.dn("fid", gVar.forumId);
                apVar.ah("obj_locate", i);
                apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(apVar);
                this.hLV.lcJ = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hLV.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.hLV.lcL = "1";
                this.hLW.lcJ = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hLW.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hLW.lcL = "1";
            } else {
                this.hLV.lcL = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hLV.mLocate = "12";
                this.hLW.lcL = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hLW.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.hMt != null) {
                this.hLV.lcO = gVar.hMt.videoMd5;
                this.hLW.lcO = gVar.hMt.videoMd5;
            }
            this.hLS.getVideoView().setVideoStatData(this.hLV);
            this.hLS.cBY();
            this.hLS.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void oc(boolean z) {
                    if (!b.this.hLS.qg()) {
                        b.this.hLG.setVisibility(0);
                    } else if (z) {
                        if (b.this.hLG.getVisibility() == 0) {
                            b.this.hLG.setVisibility(8);
                            b.this.hLG.startAnimation(b.this.hLZ);
                        }
                    } else if (b.this.hLG.getVisibility() == 8) {
                        b.this.hLG.setVisibility(0);
                        b.this.hLG.startAnimation(b.this.but);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cek() {
                    if (!b.this.hLS.qg()) {
                        b.this.hLG.setVisibility(0);
                    } else if (b.this.hLG.getVisibility() == 0) {
                        b.this.hLG.setVisibility(8);
                        b.this.hLG.startAnimation(b.this.hLZ);
                    }
                }
            });
            this.hLS.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.hLY = true;
                        b.this.hLX = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.vi(i);
                        b.this.hLS.coB();
                    }
                }
            });
            this.hLS.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.hLT != null && b.this.hLT.hMt != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.hLT.hMt.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hLS.setThumbnail(gVar.hMt.thumbnailUrl);
            this.hLS.setVideoUrl(gVar.hMt.videoUrl, gVar.threadId);
            this.hLS.LK(gVar.title);
            this.hLS.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cel() {
                    b.this.hLH.setVisibility(8);
                }
            });
            this.hLS.coB();
            this.hLS.show();
            if (gVar.autoPlay) {
                onClick(this.hLF);
                this.hLY = false;
                this.hLS.a(gVar.hMt.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.hLY = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(String str) {
        if (this.hLT != null && this.hLT.hMt != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.hLT.hMt.videoMd5, "", str, this.hLW, this.hLS.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.hLS.qg();
    }

    public void cee() {
        if (isPlaying()) {
            this.hLS.azN();
        }
    }

    public boolean vj(int i) {
        return this.hLS.Di(i);
    }

    public void cef() {
        this.hLI.setVisibility(8);
        this.hLS.stopPlay();
        if (this.hLG != null) {
            this.hLG.setVisibility(0);
        }
        if (this.hLH != null) {
            this.hLH.setVisibility(0);
        }
    }

    public void ceg() {
        if (this.hLS != null) {
            this.hLS.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        ceg();
        if (this.hLU != null) {
            this.hLU.ceq();
        }
    }

    public String FT(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.hMs != null) {
            this.ahr.setText(TextUtils.isEmpty(gVar.hMs.userNickname) ? gVar.hMs.userName : gVar.hMs.userNickname);
            this.hLL.startLoad(gVar.hMs.portrait, 12, false);
            this.hLL.setShowV(gVar.hMs.isGod);
            this.hLL.setIsBigV(gVar.hMs.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.hMs != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.hMs.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.hMs.userId)) {
                this.goe.setVisibility(8);
            } else {
                this.goe.setVisibility(0);
            }
            if (gVar.hMs.hasFocus) {
                ao.setViewTextColor(this.goe, R.color.cp_cont_d);
                this.goe.setCompoundDrawables(null, null, null, null);
                this.goe.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ao.setViewTextColor(this.goe, R.color.cp_link_tip_a);
            Drawable drawable = ao.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.goe.setCompoundDrawables(drawable, null, null, null);
            this.goe.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.hLP.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                ao.setViewTextColor(this.hLN, R.color.cp_cont_h);
            } else {
                this.hLP.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                ao.setViewTextColor(this.hLN, R.color.cp_cont_f);
            }
            this.hLN.setText(as.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ao.setViewTextColor(this.hLM, R.color.cp_cont_f);
            this.hLO.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
            this.hLM.setText(as.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hLS != null && this.hLF != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hLX) {
                this.hLS.cYy();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hLF.getParent() != null) {
                    if (this.hLF.getParent() == frameLayout) {
                        frameLayout.removeView(this.hLF);
                    } else if (this.hLF.getParent() == this.hLE) {
                        this.hLE.removeView(this.hLF);
                    }
                }
                if (this.hLF.getParent() == null) {
                    frameLayout.addView(this.hLF);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hLF.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hLF.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hLF.getParent() != null) {
                    if (this.hLF.getParent() == frameLayout) {
                        frameLayout.removeView(this.hLF);
                    } else if (this.hLF.getParent() == this.hLE) {
                        this.hLE.removeView(this.hLF);
                    }
                }
                if (this.hLF.getParent() == null) {
                    this.hLE.addView(this.hLF, 0);
                    this.hLF.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hLS.cBY();
                    this.hLX = true;
                } else {
                    return;
                }
            }
            this.hLS.a(this.mPageContext, configuration);
            this.hLH.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            view.setTag(this);
            bRn().a(view, this.hLT);
        }
        if (view == this.hLL || view == this.ahr) {
            boolean z = false;
            if (this.hLT != null && this.hLT.hMs != null && !TextUtils.isEmpty(this.hLT.hMs.userId)) {
                if (TbadkCoreApplication.isLogin() && this.hLT.hMs.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hLT.hMs.userId, 0L), z, this.hLT.hMs.isGod)));
            }
        } else if (view == this.hLQ || view == this.hLG || view == getView()) {
            if (this.hLT != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hLT.threadId, null, null);
                if (!this.hMb) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hLK) {
            if (this.hLT != null && this.hLT.hMt != null) {
                this.hLI.setVisibility(8);
                this.hLS.cYB();
                this.hLS.ff(this.hLT.hMt.videoUrl, this.hLT.threadId);
                FS("2");
            }
        } else if (view == this.goe) {
            if (!this.hLT.hMs.hasFocus) {
                this.hLU.f(this.hLT);
            }
        } else if (view == this.hLR) {
            this.hLU.g(this.hLT);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oa(boolean z) {
        if (this.hLT != null && this.hLT.hMs != null) {
            this.hLT.hMs.hasFocus = z;
            c(this.hLT);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ceh() {
        if (this.hLT != null) {
            this.hLT.hasAgree = !this.hLT.hasAgree;
            if (this.hLT.hasAgree) {
                this.hLT.agreeNum++;
            } else {
                this.hLT.agreeNum--;
            }
            if (this.hLP != null) {
                this.hLP.startAnimation(getScaleAnimation());
            }
            d(this.hLT);
        }
    }

    private Animation getScaleAnimation() {
        if (this.hMa == null) {
            this.hMa = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.hMa.setDuration(200L);
        }
        return this.hMa;
    }
}
