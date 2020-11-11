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
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView aju;
    private Animation bYl;
    private boolean eJq;
    private h iOA;
    private o iOB;
    private o iOC;
    private boolean iOD;
    private boolean iOE;
    private Animation iOF;
    private ScaleAnimation iOG;
    private boolean iOH;
    public FrameLayout iOj;
    public FrameLayout iOk;
    public TextView iOl;
    public TextView iOm;
    public FrameLayout iOn;
    public TextView iOo;
    public TextView iOp;
    public HeadImageView iOq;
    public TextView iOr;
    public TextView iOs;
    public TextView iOt;
    public ImageView iOu;
    public ImageView iOv;
    public LinearLayout iOw;
    public LinearLayout iOx;
    public com.baidu.tieba.play.c iOy;
    public g iOz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.iOD = true;
        this.iOH = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iOj = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.iOk = (FrameLayout) view.findViewById(R.id.video_container);
        this.iOy = new com.baidu.tieba.play.c(tbPageContext, this.iOk, false);
        this.iOy.setStageType("2005");
        this.iOl = (TextView) view.findViewById(R.id.title);
        this.iOm = (TextView) view.findViewById(R.id.duration);
        this.iOn = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.iOo = (TextView) view.findViewById(R.id.mobile_network_text);
        this.iOp = (TextView) view.findViewById(R.id.mobile_network_play);
        this.iOq = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aju = (TextView) view.findViewById(R.id.user_name);
        this.iOr = (TextView) view.findViewById(R.id.attention);
        this.iOw = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.iOx = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.iOs = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.iOt = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.iOu = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.iOv = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.iOw.setOnClickListener(this);
        this.iOx.setOnClickListener(this);
        this.iOl.setOnClickListener(this);
        this.iOq.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.iOr.setOnClickListener(this);
        view.setOnClickListener(this);
        this.iOp.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iOj.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iOj.setLayoutParams(layoutParams);
        this.iOq.setIsRound(true);
        this.iOA = new h(this.mPageContext, this);
        this.iOF = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bYl = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.iOz != null && this.iOz.iOY != null) {
                if (this.iOz.iOY.hasFocus) {
                    ap.setViewTextColor(this.iOr, (int) R.color.cp_cont_d);
                    this.iOr.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.iOr, (int) R.color.cp_link_tip_a);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.iOr.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.iOz != null) {
                if (this.iOz.hasAgree) {
                    this.iOv.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.iOt, (int) R.color.cp_cont_h);
                } else {
                    this.iOv.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.iOt, (int) R.color.cp_cont_f);
                }
            }
            ap.setViewTextColor(this.iOs, (int) R.color.cp_cont_f);
            this.iOu.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.iOZ != null) {
            this.iOz = gVar;
            this.eJq = this.iOz.autoPlay;
            this.iOl.setVisibility(0);
            this.iOl.setText(gVar.title);
            this.iOm.setVisibility(0);
            this.iOm.setText(at.stringForVideoTime(gVar.iOZ.videoDuration * 1000));
            if (gVar.iOZ.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Kw(String.format("%.1f", Float.valueOf(((float) gVar.iOZ.videoSize) / 1048576.0f))));
            }
            this.iOo.setText(format);
            this.iOn.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.iOZ != null) {
            this.iOy.stopPlay();
            this.iOy.wq(true);
            this.iOy.wm(false);
            this.iOy.a(new c.InterfaceC0827c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rI() {
                    if (b.this.iOy.rK()) {
                        b.this.iOm.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rJ() {
                    if (b.this.iOy.rK()) {
                        b.this.iOm.setVisibility(8);
                    }
                    if (b.this.iOE) {
                        b.this.iOy.stopPlay();
                    }
                }
            });
            this.iOy.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cBf() {
                    b.this.iOE = false;
                    b.this.iOm.setVisibility(8);
                    b.this.Kv(b.this.eJq ? "1" : "2");
                    b.this.onClick(b.this.iOk);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cBg() {
                    b.this.iOm.setVisibility(8);
                    b.this.onClick(b.this.iOj);
                }
            });
            this.iOy.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void pT(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.iOo.getText().toString());
                        b.this.iOy.fW(b.this.iOz.iOZ.videoUrl, b.this.iOz.threadId);
                        b.this.iOm.setVisibility(8);
                        b.this.Kv("2");
                    } else {
                        b.this.iOn.setVisibility(0);
                    }
                    b.this.onClick(b.this.iOk);
                }
            });
            this.iOy.wi(false);
            this.iOB = new o();
            this.iOB.alT = gVar.threadId;
            this.iOB.fyR = gVar.forumId;
            this.iOB.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iOC = new o();
            this.iOC.alT = gVar.threadId;
            this.iOC.fyR = gVar.forumId;
            this.iOC.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.iOH) {
                aq aqVar = new aq("c12590");
                aqVar.dR("tid", gVar.threadId);
                aqVar.dR("nid", gVar.nid);
                aqVar.al("obj_param5", gVar.getVideoType());
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dR("fid", gVar.forumId);
                aqVar.al("obj_locate", i);
                aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.iOB.mjR = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iOB.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.iOB.mjT = "1";
                this.iOC.mjR = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iOC.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iOC.mjT = "1";
            } else {
                this.iOB.mjT = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iOB.mLocate = "12";
                this.iOC.mjT = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iOC.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.iOZ != null) {
                this.iOB.mjW = gVar.iOZ.videoMd5;
                this.iOC.mjW = gVar.iOZ.videoMd5;
            }
            this.iOy.getVideoView().setVideoStatData(this.iOB);
            this.iOy.cZO();
            this.iOy.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void pU(boolean z) {
                    if (!b.this.iOy.rK()) {
                        b.this.iOl.setVisibility(0);
                    } else if (z) {
                        if (b.this.iOl.getVisibility() == 0) {
                            b.this.iOl.setVisibility(8);
                            b.this.iOl.startAnimation(b.this.iOF);
                        }
                    } else if (b.this.iOl.getVisibility() == 8) {
                        b.this.iOl.setVisibility(0);
                        b.this.iOl.startAnimation(b.this.bYl);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cBh() {
                    if (!b.this.iOy.rK()) {
                        b.this.iOl.setVisibility(0);
                    } else if (b.this.iOl.getVisibility() == 0) {
                        b.this.iOl.setVisibility(8);
                        b.this.iOl.startAnimation(b.this.iOF);
                    }
                }
            });
            this.iOy.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.iOE = true;
                        b.this.iOD = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.zl(i);
                        b.this.iOy.cMt();
                    }
                }
            });
            this.iOy.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.iOz != null && b.this.iOz.iOZ != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.iOz.iOZ.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.iOy.setThumbnail(gVar.iOZ.thumbnailUrl);
            this.iOy.setVideoUrl(gVar.iOZ.videoUrl, gVar.threadId);
            this.iOy.QJ(gVar.title);
            this.iOy.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cBi() {
                    b.this.iOm.setVisibility(8);
                }
            });
            this.iOy.cMt();
            this.iOy.show();
            if (gVar.autoPlay) {
                onClick(this.iOk);
                this.iOE = false;
                this.iOy.a(gVar.iOZ.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.iOE = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv(String str) {
        if (this.iOz != null && this.iOz.iOZ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iOz.iOZ.videoMd5, "", str, this.iOC, this.iOy.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.iOy.rK();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iOy.aPL();
        }
    }

    public boolean zm(int i) {
        return this.iOy.Hq(i);
    }

    public void cBc() {
        this.iOn.setVisibility(8);
        this.iOy.stopPlay();
        if (this.iOl != null) {
            this.iOl.setVisibility(0);
        }
        if (this.iOm != null) {
            this.iOm.setVisibility(0);
        }
    }

    public void cBd() {
        if (this.iOy != null) {
            this.iOy.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cBd();
        if (this.iOA != null) {
            this.iOA.cBn();
        }
    }

    public String Kw(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.iOY != null) {
            this.aju.setText(TextUtils.isEmpty(gVar.iOY.userNickname) ? gVar.iOY.userName : gVar.iOY.userNickname);
            this.iOq.startLoad(gVar.iOY.portrait, 12, false);
            this.iOq.setShowV(gVar.iOY.isGod);
            this.iOq.setIsBigV(gVar.iOY.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.iOY != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.iOY.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.iOY.userId)) {
                this.iOr.setVisibility(8);
            } else {
                this.iOr.setVisibility(0);
            }
            if (gVar.iOY.hasFocus) {
                ap.setViewTextColor(this.iOr, (int) R.color.cp_cont_d);
                this.iOr.setCompoundDrawables(null, null, null, null);
                this.iOr.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.iOr, (int) R.color.cp_link_tip_a);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.iOr.setCompoundDrawables(drawable, null, null, null);
            this.iOr.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.iOv.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.iOt, (int) R.color.cp_cont_h);
            } else {
                this.iOv.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.iOt, (int) R.color.cp_cont_f);
            }
            this.iOt.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.iOs, (int) R.color.cp_cont_f);
            this.iOu.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.iOs.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iOy != null && this.iOk != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iOD) {
                this.iOy.dwE();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.iOk.getParent() != null) {
                    if (this.iOk.getParent() == frameLayout) {
                        frameLayout.removeView(this.iOk);
                    } else if (this.iOk.getParent() == this.iOj) {
                        this.iOj.removeView(this.iOk);
                    }
                }
                if (this.iOk.getParent() == null) {
                    frameLayout.addView(this.iOk);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iOk.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.iOk.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.iOk.getParent() != null) {
                    if (this.iOk.getParent() == frameLayout) {
                        frameLayout.removeView(this.iOk);
                    } else if (this.iOk.getParent() == this.iOj) {
                        this.iOj.removeView(this.iOk);
                    }
                }
                if (this.iOk.getParent() == null) {
                    this.iOj.addView(this.iOk, 0);
                    this.iOk.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.iOy.cZO();
                    this.iOD = true;
                } else {
                    return;
                }
            }
            this.iOy.a(this.mPageContext, configuration);
            this.iOm.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnT() != null) {
            view.setTag(this);
            cnT().a(view, this.iOz);
        }
        if (view == this.iOq || view == this.aju) {
            boolean z = false;
            if (this.iOz != null && this.iOz.iOY != null && !TextUtils.isEmpty(this.iOz.iOY.userId)) {
                if (TbadkCoreApplication.isLogin() && this.iOz.iOY.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iOz.iOY.userId, 0L), z, this.iOz.iOY.isGod)));
            }
        } else if (view == this.iOw || view == this.iOl || view == getView()) {
            if (this.iOz != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iOz.threadId, null, null);
                if (!this.iOH) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.iOp) {
            if (this.iOz != null && this.iOz.iOZ != null) {
                this.iOn.setVisibility(8);
                this.iOy.dwH();
                this.iOy.fW(this.iOz.iOZ.videoUrl, this.iOz.threadId);
                Kv("2");
            }
        } else if (view == this.iOr) {
            if (!this.iOz.iOY.hasFocus) {
                this.iOA.f(this.iOz);
            }
        } else if (view == this.iOx) {
            this.iOA.g(this.iOz);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pS(boolean z) {
        if (this.iOz != null && this.iOz.iOY != null) {
            this.iOz.iOY.hasFocus = z;
            c(this.iOz);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cBe() {
        if (this.iOz != null) {
            this.iOz.hasAgree = !this.iOz.hasAgree;
            if (this.iOz.hasAgree) {
                this.iOz.agreeNum++;
            } else {
                this.iOz.agreeNum--;
            }
            if (this.iOv != null) {
                this.iOv.startAnimation(getScaleAnimation());
            }
            d(this.iOz);
        }
    }

    private Animation getScaleAnimation() {
        if (this.iOG == null) {
            this.iOG = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.iOG.setDuration(200L);
        }
        return this.iOG;
    }
}
