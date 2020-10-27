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
    private Animation bSB;
    private boolean eDB;
    public LinearLayout iIA;
    public com.baidu.tieba.play.c iIB;
    public g iIC;
    private h iID;
    private o iIE;
    private o iIF;
    private boolean iIG;
    private boolean iIH;
    private Animation iII;
    private ScaleAnimation iIJ;
    private boolean iIK;
    public FrameLayout iIm;
    public FrameLayout iIn;
    public TextView iIo;
    public TextView iIp;
    public FrameLayout iIq;
    public TextView iIr;
    public TextView iIs;
    public HeadImageView iIt;
    public TextView iIu;
    public TextView iIv;
    public TextView iIw;
    public ImageView iIx;
    public ImageView iIy;
    public LinearLayout iIz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.iIG = true;
        this.iIK = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iIm = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.iIn = (FrameLayout) view.findViewById(R.id.video_container);
        this.iIB = new com.baidu.tieba.play.c(tbPageContext, this.iIn, false);
        this.iIB.setStageType("2005");
        this.iIo = (TextView) view.findViewById(R.id.title);
        this.iIp = (TextView) view.findViewById(R.id.duration);
        this.iIq = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.iIr = (TextView) view.findViewById(R.id.mobile_network_text);
        this.iIs = (TextView) view.findViewById(R.id.mobile_network_play);
        this.iIt = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aju = (TextView) view.findViewById(R.id.user_name);
        this.iIu = (TextView) view.findViewById(R.id.attention);
        this.iIz = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.iIA = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.iIv = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.iIw = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.iIx = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.iIy = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.iIz.setOnClickListener(this);
        this.iIA.setOnClickListener(this);
        this.iIo.setOnClickListener(this);
        this.iIt.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.iIu.setOnClickListener(this);
        view.setOnClickListener(this);
        this.iIs.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iIm.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.iIm.setLayoutParams(layoutParams);
        this.iIt.setIsRound(true);
        this.iID = new h(this.mPageContext, this);
        this.iII = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.bSB = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.iIC != null && this.iIC.iJb != null) {
                if (this.iIC.iJb.hasFocus) {
                    ap.setViewTextColor(this.iIu, (int) R.color.cp_cont_d);
                    this.iIu.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.iIu, (int) R.color.cp_link_tip_a);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.iIu.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.iIC != null) {
                if (this.iIC.hasAgree) {
                    this.iIy.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.iIw, (int) R.color.cp_cont_h);
                } else {
                    this.iIy.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.iIw, (int) R.color.cp_cont_f);
                }
            }
            ap.setViewTextColor(this.iIv, (int) R.color.cp_cont_f);
            this.iIx.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.iJc != null) {
            this.iIC = gVar;
            this.eDB = this.iIC.autoPlay;
            this.iIo.setVisibility(0);
            this.iIo.setText(gVar.title);
            this.iIp.setVisibility(0);
            this.iIp.setText(at.stringForVideoTime(gVar.iJc.videoDuration * 1000));
            if (gVar.iJc.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Kf(String.format("%.1f", Float.valueOf(((float) gVar.iJc.videoSize) / 1048576.0f))));
            }
            this.iIr.setText(format);
            this.iIq.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.iJc != null) {
            this.iIB.stopPlay();
            this.iIB.wh(true);
            this.iIB.wd(false);
            this.iIB.a(new c.InterfaceC0812c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rI() {
                    if (b.this.iIB.rK()) {
                        b.this.iIp.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rJ() {
                    if (b.this.iIB.rK()) {
                        b.this.iIp.setVisibility(8);
                    }
                    if (b.this.iIH) {
                        b.this.iIB.stopPlay();
                    }
                }
            });
            this.iIB.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cyE() {
                    b.this.iIH = false;
                    b.this.iIp.setVisibility(8);
                    b.this.Ke(b.this.eDB ? "1" : "2");
                    b.this.onClick(b.this.iIn);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cyF() {
                    b.this.iIp.setVisibility(8);
                    b.this.onClick(b.this.iIm);
                }
            });
            this.iIB.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void pK(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.iIr.getText().toString());
                        b.this.iIB.fW(b.this.iIC.iJc.videoUrl, b.this.iIC.threadId);
                        b.this.iIp.setVisibility(8);
                        b.this.Ke("2");
                    } else {
                        b.this.iIq.setVisibility(0);
                    }
                    b.this.onClick(b.this.iIn);
                }
            });
            this.iIB.vZ(false);
            this.iIE = new o();
            this.iIE.alT = gVar.threadId;
            this.iIE.fsZ = gVar.forumId;
            this.iIE.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iIF = new o();
            this.iIF.alT = gVar.threadId;
            this.iIF.fsZ = gVar.forumId;
            this.iIF.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.iIK) {
                aq aqVar = new aq("c12590");
                aqVar.dR("tid", gVar.threadId);
                aqVar.dR("nid", gVar.nid);
                aqVar.aj("obj_param5", gVar.getVideoType());
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dR("fid", gVar.forumId);
                aqVar.aj("obj_locate", i);
                aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(aqVar);
                this.iIE.mdS = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iIE.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.iIE.mdU = "1";
                this.iIF.mdS = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iIF.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.iIF.mdU = "1";
            } else {
                this.iIE.mdU = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iIE.mLocate = "12";
                this.iIF.mdU = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.iIF.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.iJc != null) {
                this.iIE.mdX = gVar.iJc.videoMd5;
                this.iIF.mdX = gVar.iJc.videoMd5;
            }
            this.iIB.getVideoView().setVideoStatData(this.iIE);
            this.iIB.cXn();
            this.iIB.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void pL(boolean z) {
                    if (!b.this.iIB.rK()) {
                        b.this.iIo.setVisibility(0);
                    } else if (z) {
                        if (b.this.iIo.getVisibility() == 0) {
                            b.this.iIo.setVisibility(8);
                            b.this.iIo.startAnimation(b.this.iII);
                        }
                    } else if (b.this.iIo.getVisibility() == 8) {
                        b.this.iIo.setVisibility(0);
                        b.this.iIo.startAnimation(b.this.bSB);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cyG() {
                    if (!b.this.iIB.rK()) {
                        b.this.iIo.setVisibility(0);
                    } else if (b.this.iIo.getVisibility() == 0) {
                        b.this.iIo.setVisibility(8);
                        b.this.iIo.startAnimation(b.this.iII);
                    }
                }
            });
            this.iIB.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.iIH = true;
                        b.this.iIG = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.yY(i);
                        b.this.iIB.cJS();
                    }
                }
            });
            this.iIB.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.iIC != null && b.this.iIC.iJc != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.iIC.iJc.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.iIB.setThumbnail(gVar.iJc.thumbnailUrl);
            this.iIB.setVideoUrl(gVar.iJc.videoUrl, gVar.threadId);
            this.iIB.Qs(gVar.title);
            this.iIB.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cyH() {
                    b.this.iIp.setVisibility(8);
                }
            });
            this.iIB.cJS();
            this.iIB.show();
            if (gVar.autoPlay) {
                onClick(this.iIn);
                this.iIH = false;
                this.iIB.a(gVar.iJc.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.iIH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke(String str) {
        if (this.iIC != null && this.iIC.iJc != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iIC.iJc.videoMd5, "", str, this.iIF, this.iIB.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.iIB.rK();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.iIB.aNl();
        }
    }

    public boolean yZ(int i) {
        return this.iIB.Hd(i);
    }

    public void cyB() {
        this.iIq.setVisibility(8);
        this.iIB.stopPlay();
        if (this.iIo != null) {
            this.iIo.setVisibility(0);
        }
        if (this.iIp != null) {
            this.iIp.setVisibility(0);
        }
    }

    public void cyC() {
        if (this.iIB != null) {
            this.iIB.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cyC();
        if (this.iID != null) {
            this.iID.cyM();
        }
    }

    public String Kf(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.iJb != null) {
            this.aju.setText(TextUtils.isEmpty(gVar.iJb.userNickname) ? gVar.iJb.userName : gVar.iJb.userNickname);
            this.iIt.startLoad(gVar.iJb.portrait, 12, false);
            this.iIt.setShowV(gVar.iJb.isGod);
            this.iIt.setIsBigV(gVar.iJb.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.iJb != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.iJb.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.iJb.userId)) {
                this.iIu.setVisibility(8);
            } else {
                this.iIu.setVisibility(0);
            }
            if (gVar.iJb.hasFocus) {
                ap.setViewTextColor(this.iIu, (int) R.color.cp_cont_d);
                this.iIu.setCompoundDrawables(null, null, null, null);
                this.iIu.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.iIu, (int) R.color.cp_link_tip_a);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.iIu.setCompoundDrawables(drawable, null, null, null);
            this.iIu.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.iIy.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.iIw, (int) R.color.cp_cont_h);
            } else {
                this.iIy.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.iIw, (int) R.color.cp_cont_f);
            }
            this.iIw.setText(at.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.iIv, (int) R.color.cp_cont_f);
            this.iIx.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.iIv.setText(at.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iIB != null && this.iIn != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iIG) {
                this.iIB.duc();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.iIn.getParent() != null) {
                    if (this.iIn.getParent() == frameLayout) {
                        frameLayout.removeView(this.iIn);
                    } else if (this.iIn.getParent() == this.iIm) {
                        this.iIm.removeView(this.iIn);
                    }
                }
                if (this.iIn.getParent() == null) {
                    frameLayout.addView(this.iIn);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iIn.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.iIn.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.iIn.getParent() != null) {
                    if (this.iIn.getParent() == frameLayout) {
                        frameLayout.removeView(this.iIn);
                    } else if (this.iIn.getParent() == this.iIm) {
                        this.iIm.removeView(this.iIn);
                    }
                }
                if (this.iIn.getParent() == null) {
                    this.iIm.addView(this.iIn, 0);
                    this.iIn.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.iIB.cXn();
                    this.iIG = true;
                } else {
                    return;
                }
            }
            this.iIB.a(this.mPageContext, configuration);
            this.iIp.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            view.setTag(this);
            cls().a(view, this.iIC);
        }
        if (view == this.iIt || view == this.aju) {
            boolean z = false;
            if (this.iIC != null && this.iIC.iJb != null && !TextUtils.isEmpty(this.iIC.iJb.userId)) {
                if (TbadkCoreApplication.isLogin() && this.iIC.iJb.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iIC.iJb.userId, 0L), z, this.iIC.iJb.isGod)));
            }
        } else if (view == this.iIz || view == this.iIo || view == getView()) {
            if (this.iIC != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iIC.threadId, null, null);
                if (!this.iIK) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.iIs) {
            if (this.iIC != null && this.iIC.iJc != null) {
                this.iIq.setVisibility(8);
                this.iIB.duf();
                this.iIB.fW(this.iIC.iJc.videoUrl, this.iIC.threadId);
                Ke("2");
            }
        } else if (view == this.iIu) {
            if (!this.iIC.iJb.hasFocus) {
                this.iID.f(this.iIC);
            }
        } else if (view == this.iIA) {
            this.iID.g(this.iIC);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void pJ(boolean z) {
        if (this.iIC != null && this.iIC.iJb != null) {
            this.iIC.iJb.hasFocus = z;
            c(this.iIC);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cyD() {
        if (this.iIC != null) {
            this.iIC.hasAgree = !this.iIC.hasAgree;
            if (this.iIC.hasAgree) {
                this.iIC.agreeNum++;
            } else {
                this.iIC.agreeNum--;
            }
            if (this.iIy != null) {
                this.iIy.startAnimation(getScaleAnimation());
            }
            d(this.iIC);
        }
    }

    private Animation getScaleAnimation() {
        if (this.iIJ == null) {
            this.iIJ = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.iIJ.setDuration(200L);
        }
        return this.iIJ;
    }
}
