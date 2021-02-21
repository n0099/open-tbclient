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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView ajY;
    private Animation chW;
    private boolean eXf;
    private boolean isFullScreen;
    public TextView jnA;
    public ImageView jnB;
    public ImageView jnC;
    public LinearLayout jnD;
    public LinearLayout jnE;
    public com.baidu.tieba.play.c jnF;
    public g jnG;
    private h jnH;
    private o jnI;
    private o jnJ;
    private boolean jnK;
    private boolean jnL;
    private Animation jnM;
    private ScaleAnimation jnN;
    private boolean jnO;
    public FrameLayout jnq;
    public FrameLayout jnr;
    public TextView jns;
    public TextView jnt;
    public FrameLayout jnu;
    public TextView jnv;
    public TextView jnw;
    public HeadImageView jnx;
    public TextView jny;
    public TextView jnz;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.jnK = true;
        this.jnO = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jnq = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jnr = (FrameLayout) view.findViewById(R.id.video_container);
        this.jnF = new com.baidu.tieba.play.c(tbPageContext, this.jnr, false);
        this.jnF.setStageType("2005");
        this.jns = (TextView) view.findViewById(R.id.title);
        this.jnt = (TextView) view.findViewById(R.id.duration);
        this.jnu = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.jnv = (TextView) view.findViewById(R.id.mobile_network_text);
        this.jnw = (TextView) view.findViewById(R.id.mobile_network_play);
        this.jnx = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajY = (TextView) view.findViewById(R.id.user_name);
        this.jny = (TextView) view.findViewById(R.id.attention);
        this.jnD = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.jnE = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.jnz = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jnA = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.jnB = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jnC = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.jnD.setOnClickListener(this);
        this.jnE.setOnClickListener(this);
        this.jns.setOnClickListener(this);
        this.jnx.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.jny.setOnClickListener(this);
        view.setOnClickListener(this);
        this.jnw.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jnq.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jnq.setLayoutParams(layoutParams);
        this.jnx.setIsRound(true);
        this.jnH = new h(this.mPageContext, this);
        this.jnM = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.chW = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.jnG != null && this.jnG.jof != null) {
                if (this.jnG.jof.hasFocus) {
                    ap.setViewTextColor(this.jny, R.color.CAM_X0109);
                    this.jny.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.jny, R.color.CAM_X0302);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.jny.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.jnG != null) {
                if (this.jnG.hasAgree) {
                    this.jnC.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.jnA, R.color.CAM_X0301);
                } else {
                    this.jnC.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.jnA, R.color.CAM_X0106);
                }
            }
            ap.setViewTextColor(this.jnz, R.color.CAM_X0106);
            this.jnB.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.jog != null) {
            this.jnG = gVar;
            this.eXf = this.jnG.autoPlay;
            this.jns.setVisibility(0);
            this.jns.setText(gVar.title);
            this.jnt.setVisibility(0);
            this.jnt.setText(au.stringForVideoTime(gVar.jog.videoDuration * 1000));
            if (gVar.jog.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Ko(String.format("%.1f", Float.valueOf(((float) gVar.jog.videoSize) / 1048576.0f))));
            }
            this.jnv.setText(format);
            this.jnu.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.jog != null) {
            this.jnF.stopPlay();
            this.jnF.xm(true);
            this.jnF.xi(false);
            this.jnF.a(new c.InterfaceC0849c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rj() {
                    if (b.this.jnF.rl()) {
                        b.this.jnt.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rk() {
                    if (b.this.jnF.rl()) {
                        b.this.jnt.setVisibility(8);
                    }
                    if (b.this.jnL) {
                        b.this.jnF.stopPlay();
                    }
                }
            });
            this.jnF.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cFv() {
                    b.this.jnL = false;
                    b.this.jnt.setVisibility(8);
                    b.this.Kn(b.this.eXf ? "1" : "2");
                    b.this.onClick(b.this.jnr);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFw() {
                    b.this.jnt.setVisibility(8);
                    b.this.onClick(b.this.jnq);
                }
            });
            this.jnF.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.jnv.getText().toString());
                        b.this.jnF.fX(b.this.jnG.jog.videoUrl, b.this.jnG.threadId);
                        b.this.jnt.setVisibility(8);
                        b.this.Kn("2");
                    } else {
                        b.this.jnu.setVisibility(0);
                    }
                    b.this.onClick(b.this.jnr);
                }
            });
            this.jnF.xd(false);
            this.jnI = new o();
            this.jnI.amC = gVar.threadId;
            this.jnI.fNd = gVar.forumId;
            this.jnI.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jnJ = new o();
            this.jnJ.amC = gVar.threadId;
            this.jnJ.fNd = gVar.forumId;
            this.jnJ.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.jnO) {
                ar arVar = new ar("c12590");
                arVar.dR("tid", gVar.threadId);
                arVar.dR(IntentConfig.NID, gVar.nid);
                arVar.ap("obj_param5", gVar.getVideoType());
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("fid", gVar.forumId);
                arVar.ap("obj_locate", i);
                arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(arVar);
                this.jnI.mIv = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jnI.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.jnI.mIx = "1";
                this.jnJ.mIv = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jnJ.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jnJ.mIx = "1";
            } else {
                this.jnI.mIx = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jnI.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.jnJ.mIx = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jnJ.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.jog != null) {
                this.jnI.mIA = gVar.jog.videoMd5;
                this.jnJ.mIA = gVar.jog.videoMd5;
            }
            this.jnF.getVideoView().setVideoStatData(this.jnI);
            this.jnF.dcv();
            this.jnF.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void qY(boolean z) {
                    if (!b.this.jnF.rl()) {
                        b.this.jns.setVisibility(0);
                    } else if (z) {
                        if (b.this.jns.getVisibility() == 0) {
                            b.this.jns.setVisibility(8);
                            b.this.jns.startAnimation(b.this.jnM);
                        }
                    } else if (b.this.jns.getVisibility() == 8) {
                        b.this.jns.setVisibility(0);
                        b.this.jns.startAnimation(b.this.chW);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFx() {
                    if (!b.this.jnF.rl()) {
                        b.this.jns.setVisibility(0);
                    } else if (b.this.jns.getVisibility() == 0) {
                        b.this.jns.setVisibility(8);
                        b.this.jns.startAnimation(b.this.jnM);
                    }
                }
            });
            this.jnF.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.jnL = true;
                        b.this.jnK = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.ze(i);
                        b.this.jnF.cSK();
                    }
                }
            });
            this.jnF.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.jnG != null && b.this.jnG.jog != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.jnG.jog.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.jnF.setThumbnail(gVar.jog.thumbnailUrl);
            this.jnF.setVideoUrl(gVar.jog.videoUrl, gVar.threadId);
            this.jnF.QD(gVar.title);
            this.jnF.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cFy() {
                    b.this.jnt.setVisibility(8);
                }
            });
            this.jnF.cSK();
            this.jnF.show();
            if (gVar.autoPlay) {
                onClick(this.jnr);
                this.jnL = false;
                this.jnF.a(gVar.jog.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.jnL = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn(String str) {
        if (this.jnG != null && this.jnG.jog != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jnG.jog.videoMd5, "", str, this.jnJ, this.jnF.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.jnF.rl();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jnF.pausePlay();
        }
    }

    public boolean zf(int i) {
        return this.jnF.Hl(i);
    }

    public void stopVideo() {
        this.jnu.setVisibility(8);
        this.jnF.stopPlay();
        if (this.jns != null) {
            this.jns.setVisibility(0);
        }
        if (this.jnt != null) {
            this.jnt.setVisibility(0);
        }
    }

    public void cFt() {
        if (this.jnF != null) {
            this.jnF.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cFt();
        if (this.jnH != null) {
            this.jnH.cFE();
        }
    }

    public String Ko(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.jof != null) {
            this.ajY.setText(TextUtils.isEmpty(gVar.jof.userNickname) ? gVar.jof.userName : gVar.jof.userNickname);
            this.jnx.startLoad(gVar.jof.portrait, 12, false);
            this.jnx.setShowV(gVar.jof.isGod);
            this.jnx.setIsBigV(gVar.jof.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.jof != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.jof.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.jof.userId)) {
                this.jny.setVisibility(8);
            } else {
                this.jny.setVisibility(0);
            }
            if (gVar.jof.hasFocus) {
                ap.setViewTextColor(this.jny, R.color.CAM_X0109);
                this.jny.setCompoundDrawables(null, null, null, null);
                this.jny.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.jny, R.color.CAM_X0302);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.jny.setCompoundDrawables(drawable, null, null, null);
            this.jny.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.jnC.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.jnA, R.color.CAM_X0301);
            } else {
                this.jnC.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.jnA, R.color.CAM_X0106);
            }
            this.jnA.setText(au.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.jnz, R.color.CAM_X0106);
            this.jnB.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.jnz.setText(au.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jnF != null && this.jnr != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jnK) {
                this.jnF.dzL();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.jnr.getParent() != null) {
                    if (this.jnr.getParent() == frameLayout) {
                        frameLayout.removeView(this.jnr);
                    } else if (this.jnr.getParent() == this.jnq) {
                        this.jnq.removeView(this.jnr);
                    }
                }
                if (this.jnr.getParent() == null) {
                    frameLayout.addView(this.jnr);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jnr.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.jnr.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.jnr.getParent() != null) {
                    if (this.jnr.getParent() == frameLayout) {
                        frameLayout.removeView(this.jnr);
                    } else if (this.jnr.getParent() == this.jnq) {
                        this.jnq.removeView(this.jnr);
                    }
                }
                if (this.jnr.getParent() == null) {
                    this.jnq.addView(this.jnr, 0);
                    this.jnr.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.jnF.dcv();
                    this.jnK = true;
                } else {
                    return;
                }
            }
            this.jnF.a(this.mPageContext, configuration);
            this.jnt.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            view.setTag(this);
            csc().a(view, this.jnG);
        }
        if (view == this.jnx || view == this.ajY) {
            boolean z = false;
            if (this.jnG != null && this.jnG.jof != null && !TextUtils.isEmpty(this.jnG.jof.userId)) {
                if (TbadkCoreApplication.isLogin() && this.jnG.jof.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jnG.jof.userId, 0L), z, this.jnG.jof.isGod)));
            }
        } else if (view == this.jnD || view == this.jns || view == getView()) {
            if (this.jnG != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jnG.threadId, null, null);
                if (!this.jnO) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jnw) {
            if (this.jnG != null && this.jnG.jog != null) {
                this.jnu.setVisibility(8);
                this.jnF.dzO();
                this.jnF.fX(this.jnG.jog.videoUrl, this.jnG.threadId);
                Kn("2");
            }
        } else if (view == this.jny) {
            if (!this.jnG.jof.hasFocus) {
                this.jnH.g(this.jnG);
            }
        } else if (view == this.jnE) {
            com.baidu.tbadk.pageExtra.c fq = com.baidu.tbadk.pageExtra.d.fq(getContext());
            if (fq != null) {
                this.jnG.objSource = fq.getCurrentPageKey();
            }
            this.jnH.h(this.jnG);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qW(boolean z) {
        if (this.jnG != null && this.jnG.jof != null) {
            this.jnG.jof.hasFocus = z;
            c(this.jnG);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cFu() {
        if (this.jnG != null) {
            this.jnG.hasAgree = !this.jnG.hasAgree;
            if (this.jnG.hasAgree) {
                this.jnG.agreeNum++;
            } else {
                this.jnG.agreeNum--;
            }
            if (this.jnC != null) {
                this.jnC.startAnimation(getScaleAnimation());
            }
            d(this.jnG);
        }
    }

    private Animation getScaleAnimation() {
        if (this.jnN == null) {
            this.jnN = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.jnN.setDuration(200L);
        }
        return this.jnN;
    }
}
