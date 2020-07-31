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
    public FrameLayout hLC;
    public FrameLayout hLD;
    public TextView hLE;
    public TextView hLF;
    public FrameLayout hLG;
    public TextView hLH;
    public TextView hLI;
    public HeadImageView hLJ;
    public TextView hLK;
    public TextView hLL;
    public ImageView hLM;
    public ImageView hLN;
    public LinearLayout hLO;
    public LinearLayout hLP;
    public com.baidu.tieba.play.c hLQ;
    public g hLR;
    private h hLS;
    private o hLT;
    private o hLU;
    private boolean hLV;
    private boolean hLW;
    private Animation hLX;
    private ScaleAnimation hLY;
    private boolean hLZ;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.hLV = true;
        this.hLZ = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hLC = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hLD = (FrameLayout) view.findViewById(R.id.video_container);
        this.hLQ = new com.baidu.tieba.play.c(tbPageContext, this.hLD, false);
        this.hLE = (TextView) view.findViewById(R.id.title);
        this.hLF = (TextView) view.findViewById(R.id.duration);
        this.hLG = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hLH = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hLI = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hLJ = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ahr = (TextView) view.findViewById(R.id.user_name);
        this.goe = (TextView) view.findViewById(R.id.attention);
        this.hLO = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.hLP = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hLK = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hLL = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hLM = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.hLN = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.hLO.setOnClickListener(this);
        this.hLP.setOnClickListener(this);
        this.hLE.setOnClickListener(this);
        this.hLJ.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.goe.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hLI.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hLC.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hLC.setLayoutParams(layoutParams);
        this.hLJ.setIsRound(true);
        this.hLS = new h(this.mPageContext, this);
        this.hLX = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.but = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ao.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.hLR != null && this.hLR.hMq != null) {
                if (this.hLR.hMq.hasFocus) {
                    ao.setViewTextColor(this.goe, R.color.cp_cont_d);
                    this.goe.setCompoundDrawables(null, null, null, null);
                } else {
                    ao.setViewTextColor(this.goe, R.color.cp_link_tip_a);
                    Drawable drawable = ao.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.goe.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.hLR != null) {
                if (this.hLR.hasAgree) {
                    this.hLN.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                    ao.setViewTextColor(this.hLL, R.color.cp_cont_h);
                } else {
                    this.hLN.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                    ao.setViewTextColor(this.hLL, R.color.cp_cont_f);
                }
            }
            ao.setViewTextColor(this.hLK, R.color.cp_cont_f);
            this.hLM.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.hMr != null) {
            this.hLR = gVar;
            this.dXa = this.hLR.autoPlay;
            this.hLE.setVisibility(0);
            this.hLE.setText(gVar.title);
            this.hLF.setVisibility(0);
            this.hLF.setText(as.stringForVideoTime(gVar.hMr.videoDuration * 1000));
            if (gVar.hMr.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), FT(String.format("%.1f", Float.valueOf(((float) gVar.hMr.videoSize) / 1048576.0f))));
            }
            this.hLH.setText(format);
            this.hLG.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.hMr != null) {
            this.hLQ.stopPlay();
            this.hLQ.un(true);
            this.hLQ.uj(false);
            this.hLQ.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qe() {
                    if (b.this.hLQ.qg()) {
                        b.this.hLF.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qf() {
                    if (b.this.hLQ.qg()) {
                        b.this.hLF.setVisibility(8);
                    }
                    if (b.this.hLW) {
                        b.this.hLQ.stopPlay();
                    }
                }
            });
            this.hLQ.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cei() {
                    b.this.hLW = false;
                    b.this.hLF.setVisibility(8);
                    b.this.FS(b.this.dXa ? "1" : "2");
                    b.this.onClick(b.this.hLD);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cej() {
                    b.this.hLF.setVisibility(8);
                    b.this.onClick(b.this.hLC);
                }
            });
            this.hLQ.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void ob(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hLH.getText().toString());
                        b.this.hLQ.ff(b.this.hLR.hMr.videoUrl, b.this.hLR.threadId);
                        b.this.hLF.setVisibility(8);
                        b.this.FS("2");
                    } else {
                        b.this.hLG.setVisibility(0);
                    }
                    b.this.onClick(b.this.hLD);
                }
            });
            this.hLQ.uf(false);
            this.hLT = new o();
            this.hLT.ajJ = gVar.threadId;
            this.hLT.eKO = gVar.forumId;
            this.hLT.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hLU = new o();
            this.hLU.ajJ = gVar.threadId;
            this.hLU.eKO = gVar.forumId;
            this.hLU.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.hLZ) {
                ap apVar = new ap("c12590");
                apVar.dn("tid", gVar.threadId);
                apVar.dn("nid", gVar.nid);
                apVar.ah("obj_param5", gVar.getVideoType());
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.dn("fid", gVar.forumId);
                apVar.ah("obj_locate", i);
                apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(apVar);
                this.hLT.lcH = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hLT.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.hLT.lcJ = "1";
                this.hLU.lcH = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hLU.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hLU.lcJ = "1";
            } else {
                this.hLT.lcJ = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hLT.mLocate = "12";
                this.hLU.lcJ = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hLU.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.hMr != null) {
                this.hLT.lcM = gVar.hMr.videoMd5;
                this.hLU.lcM = gVar.hMr.videoMd5;
            }
            this.hLQ.getVideoView().setVideoStatData(this.hLT);
            this.hLQ.cBY();
            this.hLQ.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void oc(boolean z) {
                    if (!b.this.hLQ.qg()) {
                        b.this.hLE.setVisibility(0);
                    } else if (z) {
                        if (b.this.hLE.getVisibility() == 0) {
                            b.this.hLE.setVisibility(8);
                            b.this.hLE.startAnimation(b.this.hLX);
                        }
                    } else if (b.this.hLE.getVisibility() == 8) {
                        b.this.hLE.setVisibility(0);
                        b.this.hLE.startAnimation(b.this.but);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cek() {
                    if (!b.this.hLQ.qg()) {
                        b.this.hLE.setVisibility(0);
                    } else if (b.this.hLE.getVisibility() == 0) {
                        b.this.hLE.setVisibility(8);
                        b.this.hLE.startAnimation(b.this.hLX);
                    }
                }
            });
            this.hLQ.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.hLW = true;
                        b.this.hLV = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.vi(i);
                        b.this.hLQ.coB();
                    }
                }
            });
            this.hLQ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.hLR != null && b.this.hLR.hMr != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.hLR.hMr.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hLQ.setThumbnail(gVar.hMr.thumbnailUrl);
            this.hLQ.setVideoUrl(gVar.hMr.videoUrl, gVar.threadId);
            this.hLQ.LK(gVar.title);
            this.hLQ.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cel() {
                    b.this.hLF.setVisibility(8);
                }
            });
            this.hLQ.coB();
            this.hLQ.show();
            if (gVar.autoPlay) {
                onClick(this.hLD);
                this.hLW = false;
                this.hLQ.a(gVar.hMr.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.hLW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(String str) {
        if (this.hLR != null && this.hLR.hMr != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.hLR.hMr.videoMd5, "", str, this.hLU, this.hLQ.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.hLQ.qg();
    }

    public void cee() {
        if (isPlaying()) {
            this.hLQ.azN();
        }
    }

    public boolean vj(int i) {
        return this.hLQ.Di(i);
    }

    public void cef() {
        this.hLG.setVisibility(8);
        this.hLQ.stopPlay();
        if (this.hLE != null) {
            this.hLE.setVisibility(0);
        }
        if (this.hLF != null) {
            this.hLF.setVisibility(0);
        }
    }

    public void ceg() {
        if (this.hLQ != null) {
            this.hLQ.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        ceg();
        if (this.hLS != null) {
            this.hLS.ceq();
        }
    }

    public String FT(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.hMq != null) {
            this.ahr.setText(TextUtils.isEmpty(gVar.hMq.userNickname) ? gVar.hMq.userName : gVar.hMq.userNickname);
            this.hLJ.startLoad(gVar.hMq.portrait, 12, false);
            this.hLJ.setShowV(gVar.hMq.isGod);
            this.hLJ.setIsBigV(gVar.hMq.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.hMq != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.hMq.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.hMq.userId)) {
                this.goe.setVisibility(8);
            } else {
                this.goe.setVisibility(0);
            }
            if (gVar.hMq.hasFocus) {
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
                this.hLN.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_s));
                ao.setViewTextColor(this.hLL, R.color.cp_cont_h);
            } else {
                this.hLN.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_like_n));
                ao.setViewTextColor(this.hLL, R.color.cp_cont_f);
            }
            this.hLL.setText(as.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ao.setViewTextColor(this.hLK, R.color.cp_cont_f);
            this.hLM.setImageDrawable(ao.getDrawable(R.drawable.icon_home_card_comment));
            this.hLK.setText(as.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hLQ != null && this.hLD != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hLV) {
                this.hLQ.cYy();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hLD.getParent() != null) {
                    if (this.hLD.getParent() == frameLayout) {
                        frameLayout.removeView(this.hLD);
                    } else if (this.hLD.getParent() == this.hLC) {
                        this.hLC.removeView(this.hLD);
                    }
                }
                if (this.hLD.getParent() == null) {
                    frameLayout.addView(this.hLD);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hLD.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hLD.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hLD.getParent() != null) {
                    if (this.hLD.getParent() == frameLayout) {
                        frameLayout.removeView(this.hLD);
                    } else if (this.hLD.getParent() == this.hLC) {
                        this.hLC.removeView(this.hLD);
                    }
                }
                if (this.hLD.getParent() == null) {
                    this.hLC.addView(this.hLD, 0);
                    this.hLD.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hLQ.cBY();
                    this.hLV = true;
                } else {
                    return;
                }
            }
            this.hLQ.a(this.mPageContext, configuration);
            this.hLF.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            view.setTag(this);
            bRn().a(view, this.hLR);
        }
        if (view == this.hLJ || view == this.ahr) {
            boolean z = false;
            if (this.hLR != null && this.hLR.hMq != null && !TextUtils.isEmpty(this.hLR.hMq.userId)) {
                if (TbadkCoreApplication.isLogin() && this.hLR.hMq.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hLR.hMq.userId, 0L), z, this.hLR.hMq.isGod)));
            }
        } else if (view == this.hLO || view == this.hLE || view == getView()) {
            if (this.hLR != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hLR.threadId, null, null);
                if (!this.hLZ) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hLI) {
            if (this.hLR != null && this.hLR.hMr != null) {
                this.hLG.setVisibility(8);
                this.hLQ.cYB();
                this.hLQ.ff(this.hLR.hMr.videoUrl, this.hLR.threadId);
                FS("2");
            }
        } else if (view == this.goe) {
            if (!this.hLR.hMq.hasFocus) {
                this.hLS.f(this.hLR);
            }
        } else if (view == this.hLP) {
            this.hLS.g(this.hLR);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oa(boolean z) {
        if (this.hLR != null && this.hLR.hMq != null) {
            this.hLR.hMq.hasFocus = z;
            c(this.hLR);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void ceh() {
        if (this.hLR != null) {
            this.hLR.hasAgree = !this.hLR.hasAgree;
            if (this.hLR.hasAgree) {
                this.hLR.agreeNum++;
            } else {
                this.hLR.agreeNum--;
            }
            if (this.hLN != null) {
                this.hLN.startAnimation(getScaleAnimation());
            }
            d(this.hLR);
        }
    }

    private Animation getScaleAnimation() {
        if (this.hLY == null) {
            this.hLY = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.hLY.setDuration(200L);
        }
        return this.hLY;
    }
}
