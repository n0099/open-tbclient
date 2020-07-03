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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView ahA;
    private Animation btW;
    private boolean dQI;
    private n fnj;
    public TextView gjf;
    public FrameLayout hFG;
    public FrameLayout hFH;
    public TextView hFI;
    public TextView hFJ;
    public FrameLayout hFK;
    public TextView hFL;
    public TextView hFM;
    public HeadImageView hFN;
    public TextView hFO;
    public TextView hFP;
    public ImageView hFQ;
    public ImageView hFR;
    public LinearLayout hFS;
    public LinearLayout hFT;
    public com.baidu.tieba.play.c hFU;
    public g hFV;
    private h hFW;
    private y hFX;
    private y hFY;
    private boolean hFZ;
    private boolean hGa;
    private Animation hGb;
    private ScaleAnimation hGc;
    private boolean hGd;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.hFZ = true;
        this.hGd = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hFG = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hFH = (FrameLayout) view.findViewById(R.id.video_container);
        this.hFU = new com.baidu.tieba.play.c(tbPageContext, this.hFH, false);
        this.hFI = (TextView) view.findViewById(R.id.title);
        this.hFJ = (TextView) view.findViewById(R.id.duration);
        this.hFK = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hFL = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hFM = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hFN = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ahA = (TextView) view.findViewById(R.id.user_name);
        this.gjf = (TextView) view.findViewById(R.id.attention);
        this.hFS = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.hFT = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hFO = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hFP = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hFQ = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.hFR = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.hFS.setOnClickListener(this);
        this.hFT.setOnClickListener(this);
        this.hFI.setOnClickListener(this);
        this.hFN.setOnClickListener(this);
        this.ahA.setOnClickListener(this);
        this.gjf.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hFM.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hFG.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hFG.setLayoutParams(layoutParams);
        this.hFN.setIsRound(true);
        this.fnj = new n(tbPageContext.getPageActivity());
        this.hFW = new h(this.mPageContext, this);
        this.hGb = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.btW = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            an.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.hFV != null && this.hFV.hGu != null) {
                if (this.hFV.hGu.hasFocus) {
                    an.setViewTextColor(this.gjf, (int) R.color.cp_cont_d);
                    this.gjf.setCompoundDrawables(null, null, null, null);
                } else {
                    an.setViewTextColor(this.gjf, (int) R.color.cp_link_tip_a);
                    Drawable drawable = an.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.gjf.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.hFV != null) {
                if (this.hFV.hasAgree) {
                    this.hFR.setImageDrawable(an.getDrawable(R.drawable.icon_home_card_like_s));
                    an.setViewTextColor(this.hFP, (int) R.color.cp_cont_h);
                } else {
                    this.hFR.setImageDrawable(an.getDrawable(R.drawable.icon_home_card_like_n));
                    an.setViewTextColor(this.hFP, (int) R.color.cp_cont_f);
                }
            }
            an.setViewTextColor(this.hFO, (int) R.color.cp_cont_f);
            this.hFQ.setImageDrawable(an.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.hGv != null) {
            this.hFV = gVar;
            this.dQI = this.hFV.autoPlay;
            this.hFI.setVisibility(0);
            this.hFI.setText(gVar.title);
            this.hFJ.setVisibility(0);
            this.hFJ.setText(ar.stringForVideoTime(gVar.hGv.videoDuration * 1000));
            if (gVar.hGv.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Fi(String.format("%.1f", Float.valueOf(((float) gVar.hGv.videoSize) / 1048576.0f))));
            }
            this.hFL.setText(format);
            this.hFK.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.hGv != null) {
            this.hFU.stopPlay();
            this.hFU.setIsNeedRecoveryVideoPlayer(true);
            this.hFU.tH(true);
            this.hFU.tD(false);
            this.hFU.a(new c.InterfaceC0720c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qd() {
                    if (b.this.hFU.qf()) {
                        b.this.hFJ.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qe() {
                    if (b.this.hFU.qf()) {
                        b.this.hFJ.setVisibility(8);
                    }
                    if (b.this.hGa) {
                        b.this.hFU.stopPlay();
                    }
                }
            });
            this.hFU.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void caJ() {
                    b.this.hGa = false;
                    b.this.hFJ.setVisibility(8);
                    b.this.Fh(b.this.dQI ? "1" : "2");
                    b.this.onClick(b.this.hFH);
                }

                @Override // com.baidu.tieba.play.c.l
                public void caK() {
                    b.this.hFJ.setVisibility(8);
                    b.this.onClick(b.this.hFG);
                }
            });
            this.hFU.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void nw(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hFL.getText().toString());
                        b.this.hFU.fd(b.this.hFV.hGv.videoUrl, b.this.hFV.threadId);
                        b.this.hFJ.setVisibility(8);
                        b.this.Fh("2");
                    } else {
                        b.this.hFK.setVisibility(0);
                    }
                    b.this.onClick(b.this.hFH);
                }
            });
            this.hFU.tz(false);
            this.hFX = new y();
            this.hFX.ajO = gVar.threadId;
            this.hFX.eEs = gVar.forumId;
            this.hFX.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hFY = new y();
            this.hFY.ajO = gVar.threadId;
            this.hFY.eEs = gVar.forumId;
            this.hFY.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.hGd) {
                ao aoVar = new ao("c12590");
                aoVar.dk("tid", gVar.threadId);
                aoVar.dk("nid", gVar.nid);
                aoVar.ag("obj_param5", gVar.getVideoType());
                aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                aoVar.dk("fid", gVar.forumId);
                aoVar.ag("obj_locate", i);
                aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aoVar);
                this.hFX.kVo = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hFX.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.hFX.kVq = "1";
                this.hFY.kVo = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hFY.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hFY.kVq = "1";
            } else {
                this.hFX.kVq = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hFX.mLocate = "12";
                this.hFY.kVq = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hFY.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.hGv != null) {
                this.hFX.kVt = gVar.hGv.videoMd5;
                this.hFY.kVt = gVar.hGv.videoMd5;
            }
            this.fnj.setVideoStatsData(this.hFX);
            this.hFU.getVideoView().setBusiness(this.fnj);
            this.hFU.cxZ();
            this.hFU.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void nx(boolean z) {
                    if (!b.this.hFU.qf()) {
                        b.this.hFI.setVisibility(0);
                    } else if (z) {
                        if (b.this.hFI.getVisibility() == 0) {
                            b.this.hFI.setVisibility(8);
                            b.this.hFI.startAnimation(b.this.hGb);
                        }
                    } else if (b.this.hFI.getVisibility() == 8) {
                        b.this.hFI.setVisibility(0);
                        b.this.hFI.startAnimation(b.this.btW);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void caL() {
                    if (!b.this.hFU.qf()) {
                        b.this.hFI.setVisibility(0);
                    } else if (b.this.hFI.getVisibility() == 0) {
                        b.this.hFI.setVisibility(8);
                        b.this.hFI.startAnimation(b.this.hGb);
                    }
                }
            });
            this.hFU.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.hGa = true;
                        b.this.hFZ = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.uQ(i);
                        b.this.hFU.cla();
                    }
                }
            });
            this.hFU.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.hFV != null && b.this.hFV.hGv != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.hFV.hGv.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hFU.setThumbnail(gVar.hGv.thumbnailUrl);
            this.hFU.setVideoUrl(gVar.hGv.videoUrl, gVar.threadId);
            this.hFU.KW(gVar.title);
            this.hFU.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void caM() {
                    b.this.hFJ.setVisibility(8);
                }
            });
            this.hFU.cla();
            this.hFU.show();
            if (gVar.autoPlay) {
                onClick(this.hFH);
                this.hGa = false;
                this.hFU.a(gVar.hGv.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.hGa = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(String str) {
        if (this.hFV != null && this.hFV.hGv != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hFV.hGv.videoMd5, "", str, this.hFY, this.hFU.cUD().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.hFU.qf();
    }

    public void caF() {
        if (isPlaying()) {
            this.hFU.awZ();
        }
    }

    public boolean uR(int i) {
        return this.hFU.CI(i);
    }

    public void caG() {
        this.hFK.setVisibility(8);
        this.hFU.stopPlay();
        if (this.hFI != null) {
            this.hFI.setVisibility(0);
        }
        if (this.hFJ != null) {
            this.hFJ.setVisibility(0);
        }
    }

    public void caH() {
        if (this.hFU != null) {
            this.hFU.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        caH();
        if (this.hFW != null) {
            this.hFW.caR();
        }
    }

    public String Fi(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.hGu != null) {
            this.ahA.setText(TextUtils.isEmpty(gVar.hGu.userNickname) ? gVar.hGu.userName : gVar.hGu.userNickname);
            this.hFN.startLoad(gVar.hGu.portrait, 12, false);
            this.hFN.setShowV(gVar.hGu.isGod);
            this.hFN.setIsBigV(gVar.hGu.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.hGu != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.hGu.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.hGu.userId)) {
                this.gjf.setVisibility(8);
            } else {
                this.gjf.setVisibility(0);
            }
            if (gVar.hGu.hasFocus) {
                an.setViewTextColor(this.gjf, (int) R.color.cp_cont_d);
                this.gjf.setCompoundDrawables(null, null, null, null);
                this.gjf.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            an.setViewTextColor(this.gjf, (int) R.color.cp_link_tip_a);
            Drawable drawable = an.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.gjf.setCompoundDrawables(drawable, null, null, null);
            this.gjf.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.hFR.setImageDrawable(an.getDrawable(R.drawable.icon_home_card_like_s));
                an.setViewTextColor(this.hFP, (int) R.color.cp_cont_h);
            } else {
                this.hFR.setImageDrawable(an.getDrawable(R.drawable.icon_home_card_like_n));
                an.setViewTextColor(this.hFP, (int) R.color.cp_cont_f);
            }
            this.hFP.setText(ar.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            an.setViewTextColor(this.hFO, (int) R.color.cp_cont_f);
            this.hFQ.setImageDrawable(an.getDrawable(R.drawable.icon_home_card_comment));
            this.hFO.setText(ar.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hFU != null && this.hFH != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hFZ) {
                this.hFU.cUJ();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hFH.getParent() != null) {
                    if (this.hFH.getParent() == frameLayout) {
                        frameLayout.removeView(this.hFH);
                    } else if (this.hFH.getParent() == this.hFG) {
                        this.hFG.removeView(this.hFH);
                    }
                }
                if (this.hFH.getParent() == null) {
                    frameLayout.addView(this.hFH);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hFH.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hFH.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hFH.getParent() != null) {
                    if (this.hFH.getParent() == frameLayout) {
                        frameLayout.removeView(this.hFH);
                    } else if (this.hFH.getParent() == this.hFG) {
                        this.hFG.removeView(this.hFH);
                    }
                }
                if (this.hFH.getParent() == null) {
                    this.hFG.addView(this.hFH, 0);
                    this.hFH.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hFU.cxZ();
                    this.hFZ = true;
                } else {
                    return;
                }
            }
            this.hFU.a(this.mPageContext, configuration);
            this.hFJ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOc() != null) {
            view.setTag(this);
            bOc().a(view, this.hFV);
        }
        if (view == this.hFN || view == this.ahA) {
            boolean z = false;
            if (this.hFV != null && this.hFV.hGu != null && !TextUtils.isEmpty(this.hFV.hGu.userId)) {
                if (TbadkCoreApplication.isLogin() && this.hFV.hGu.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hFV.hGu.userId, 0L), z, this.hFV.hGu.isGod)));
            }
        } else if (view == this.hFS || view == this.hFI || view == getView()) {
            if (this.hFV != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hFV.threadId, null, null);
                if (!this.hGd) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hFM) {
            if (this.hFV != null && this.hFV.hGv != null) {
                this.hFK.setVisibility(8);
                this.hFU.cUM();
                this.hFU.fd(this.hFV.hGv.videoUrl, this.hFV.threadId);
                Fh("2");
            }
        } else if (view == this.gjf) {
            if (!this.hFV.hGu.hasFocus) {
                this.hFW.f(this.hFV);
            }
        } else if (view == this.hFT) {
            this.hFW.g(this.hFV);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void nv(boolean z) {
        if (this.hFV != null && this.hFV.hGu != null) {
            this.hFV.hGu.hasFocus = z;
            c(this.hFV);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void caI() {
        if (this.hFV != null) {
            this.hFV.hasAgree = !this.hFV.hasAgree;
            if (this.hFV.hasAgree) {
                this.hFV.agreeNum++;
            } else {
                this.hFV.agreeNum--;
            }
            if (this.hFR != null) {
                this.hFR.startAnimation(getScaleAnimation());
            }
            d(this.hFV);
        }
    }

    private Animation getScaleAnimation() {
        if (this.hGc == null) {
            this.hGc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.hGc.setDuration(200L);
        }
        return this.hGc;
    }
}
