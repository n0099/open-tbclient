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
    public TextView alr;
    private Animation cjx;
    private boolean eYE;
    private boolean isFullScreen;
    public FrameLayout joZ;
    public FrameLayout jpa;
    public TextView jpb;
    public TextView jpc;
    public FrameLayout jpd;
    public TextView jpe;
    public TextView jpf;
    public HeadImageView jpg;
    public TextView jph;
    public TextView jpi;
    public TextView jpj;
    public ImageView jpk;
    public ImageView jpl;
    public LinearLayout jpm;
    public LinearLayout jpn;
    public com.baidu.tieba.play.c jpo;
    public g jpp;
    private h jpq;
    private o jpr;
    private o jps;
    private boolean jpt;
    private boolean jpu;
    private Animation jpv;
    private ScaleAnimation jpw;
    private boolean jpx;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.jpt = true;
        this.jpx = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.joZ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jpa = (FrameLayout) view.findViewById(R.id.video_container);
        this.jpo = new com.baidu.tieba.play.c(tbPageContext, this.jpa, false);
        this.jpo.setStageType("2005");
        this.jpb = (TextView) view.findViewById(R.id.title);
        this.jpc = (TextView) view.findViewById(R.id.duration);
        this.jpd = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.jpe = (TextView) view.findViewById(R.id.mobile_network_text);
        this.jpf = (TextView) view.findViewById(R.id.mobile_network_play);
        this.jpg = (HeadImageView) view.findViewById(R.id.user_icon);
        this.alr = (TextView) view.findViewById(R.id.user_name);
        this.jph = (TextView) view.findViewById(R.id.attention);
        this.jpm = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.jpn = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.jpi = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jpj = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.jpk = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jpl = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.jpm.setOnClickListener(this);
        this.jpn.setOnClickListener(this);
        this.jpb.setOnClickListener(this);
        this.jpg.setOnClickListener(this);
        this.alr.setOnClickListener(this);
        this.jph.setOnClickListener(this);
        view.setOnClickListener(this);
        this.jpf.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.joZ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.joZ.setLayoutParams(layoutParams);
        this.jpg.setIsRound(true);
        this.jpq = new h(this.mPageContext, this);
        this.jpv = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.cjx = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.jpp != null && this.jpp.jpO != null) {
                if (this.jpp.jpO.hasFocus) {
                    ap.setViewTextColor(this.jph, R.color.CAM_X0109);
                    this.jph.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.jph, R.color.CAM_X0302);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.jph.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.jpp != null) {
                if (this.jpp.hasAgree) {
                    this.jpl.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.jpj, R.color.CAM_X0301);
                } else {
                    this.jpl.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.jpj, R.color.CAM_X0106);
                }
            }
            ap.setViewTextColor(this.jpi, R.color.CAM_X0106);
            this.jpk.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.jpP != null) {
            this.jpp = gVar;
            this.eYE = this.jpp.autoPlay;
            this.jpb.setVisibility(0);
            this.jpb.setText(gVar.title);
            this.jpc.setVisibility(0);
            this.jpc.setText(au.stringForVideoTime(gVar.jpP.videoDuration * 1000));
            if (gVar.jpP.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Kx(String.format("%.1f", Float.valueOf(((float) gVar.jpP.videoSize) / 1048576.0f))));
            }
            this.jpe.setText(format);
            this.jpd.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.jpP != null) {
            this.jpo.stopPlay();
            this.jpo.xm(true);
            this.jpo.xi(false);
            this.jpo.a(new c.InterfaceC0855c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rj() {
                    if (b.this.jpo.rl()) {
                        b.this.jpc.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rk() {
                    if (b.this.jpo.rl()) {
                        b.this.jpc.setVisibility(8);
                    }
                    if (b.this.jpu) {
                        b.this.jpo.stopPlay();
                    }
                }
            });
            this.jpo.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cFB() {
                    b.this.jpu = false;
                    b.this.jpc.setVisibility(8);
                    b.this.Kw(b.this.eYE ? "1" : "2");
                    b.this.onClick(b.this.jpa);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFC() {
                    b.this.jpc.setVisibility(8);
                    b.this.onClick(b.this.joZ);
                }
            });
            this.jpo.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.jpe.getText().toString());
                        b.this.jpo.fX(b.this.jpp.jpP.videoUrl, b.this.jpp.threadId);
                        b.this.jpc.setVisibility(8);
                        b.this.Kw("2");
                    } else {
                        b.this.jpd.setVisibility(0);
                    }
                    b.this.onClick(b.this.jpa);
                }
            });
            this.jpo.xd(false);
            this.jpr = new o();
            this.jpr.anU = gVar.threadId;
            this.jpr.fOD = gVar.forumId;
            this.jpr.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jps = new o();
            this.jps.anU = gVar.threadId;
            this.jps.fOD = gVar.forumId;
            this.jps.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.jpx) {
                ar arVar = new ar("c12590");
                arVar.dR("tid", gVar.threadId);
                arVar.dR(IntentConfig.NID, gVar.nid);
                arVar.aq("obj_param5", gVar.getVideoType());
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("fid", gVar.forumId);
                arVar.aq("obj_locate", i);
                arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(arVar);
                this.jpr.mKz = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jpr.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.jpr.mKB = "1";
                this.jps.mKz = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jps.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jps.mKB = "1";
            } else {
                this.jpr.mKB = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jpr.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.jps.mKB = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jps.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.jpP != null) {
                this.jpr.mKE = gVar.jpP.videoMd5;
                this.jps.mKE = gVar.jpP.videoMd5;
            }
            this.jpo.getVideoView().setVideoStatData(this.jpr);
            this.jpo.dcE();
            this.jpo.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void qY(boolean z) {
                    if (!b.this.jpo.rl()) {
                        b.this.jpb.setVisibility(0);
                    } else if (z) {
                        if (b.this.jpb.getVisibility() == 0) {
                            b.this.jpb.setVisibility(8);
                            b.this.jpb.startAnimation(b.this.jpv);
                        }
                    } else if (b.this.jpb.getVisibility() == 8) {
                        b.this.jpb.setVisibility(0);
                        b.this.jpb.startAnimation(b.this.cjx);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFD() {
                    if (!b.this.jpo.rl()) {
                        b.this.jpb.setVisibility(0);
                    } else if (b.this.jpb.getVisibility() == 0) {
                        b.this.jpb.setVisibility(8);
                        b.this.jpb.startAnimation(b.this.jpv);
                    }
                }
            });
            this.jpo.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.jpu = true;
                        b.this.jpt = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.zf(i);
                        b.this.jpo.cSR();
                    }
                }
            });
            this.jpo.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.jpp != null && b.this.jpp.jpP != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.jpp.jpP.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.jpo.setThumbnail(gVar.jpP.thumbnailUrl);
            this.jpo.setVideoUrl(gVar.jpP.videoUrl, gVar.threadId);
            this.jpo.QJ(gVar.title);
            this.jpo.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cFE() {
                    b.this.jpc.setVisibility(8);
                }
            });
            this.jpo.cSR();
            this.jpo.show();
            if (gVar.autoPlay) {
                onClick(this.jpa);
                this.jpu = false;
                this.jpo.a(gVar.jpP.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.jpu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kw(String str) {
        if (this.jpp != null && this.jpp.jpP != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jpp.jpP.videoMd5, "", str, this.jps, this.jpo.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.jpo.rl();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jpo.pausePlay();
        }
    }

    public boolean zg(int i) {
        return this.jpo.Ho(i);
    }

    public void stopVideo() {
        this.jpd.setVisibility(8);
        this.jpo.stopPlay();
        if (this.jpb != null) {
            this.jpb.setVisibility(0);
        }
        if (this.jpc != null) {
            this.jpc.setVisibility(0);
        }
    }

    public void cFz() {
        if (this.jpo != null) {
            this.jpo.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cFz();
        if (this.jpq != null) {
            this.jpq.cFK();
        }
    }

    public String Kx(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.jpO != null) {
            this.alr.setText(TextUtils.isEmpty(gVar.jpO.userNickname) ? gVar.jpO.userName : gVar.jpO.userNickname);
            this.jpg.startLoad(gVar.jpO.portrait, 12, false);
            this.jpg.setShowV(gVar.jpO.isGod);
            this.jpg.setIsBigV(gVar.jpO.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.jpO != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.jpO.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.jpO.userId)) {
                this.jph.setVisibility(8);
            } else {
                this.jph.setVisibility(0);
            }
            if (gVar.jpO.hasFocus) {
                ap.setViewTextColor(this.jph, R.color.CAM_X0109);
                this.jph.setCompoundDrawables(null, null, null, null);
                this.jph.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.jph, R.color.CAM_X0302);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.jph.setCompoundDrawables(drawable, null, null, null);
            this.jph.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.jpl.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.jpj, R.color.CAM_X0301);
            } else {
                this.jpl.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.jpj, R.color.CAM_X0106);
            }
            this.jpj.setText(au.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.jpi, R.color.CAM_X0106);
            this.jpk.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.jpi.setText(au.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jpo != null && this.jpa != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jpt) {
                this.jpo.dzU();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.jpa.getParent() != null) {
                    if (this.jpa.getParent() == frameLayout) {
                        frameLayout.removeView(this.jpa);
                    } else if (this.jpa.getParent() == this.joZ) {
                        this.joZ.removeView(this.jpa);
                    }
                }
                if (this.jpa.getParent() == null) {
                    frameLayout.addView(this.jpa);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jpa.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.jpa.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.jpa.getParent() != null) {
                    if (this.jpa.getParent() == frameLayout) {
                        frameLayout.removeView(this.jpa);
                    } else if (this.jpa.getParent() == this.joZ) {
                        this.joZ.removeView(this.jpa);
                    }
                }
                if (this.jpa.getParent() == null) {
                    this.joZ.addView(this.jpa, 0);
                    this.jpa.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.jpo.dcE();
                    this.jpt = true;
                } else {
                    return;
                }
            }
            this.jpo.a(this.mPageContext, configuration);
            this.jpc.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            view.setTag(this);
            csi().a(view, this.jpp);
        }
        if (view == this.jpg || view == this.alr) {
            boolean z = false;
            if (this.jpp != null && this.jpp.jpO != null && !TextUtils.isEmpty(this.jpp.jpO.userId)) {
                if (TbadkCoreApplication.isLogin() && this.jpp.jpO.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jpp.jpO.userId, 0L), z, this.jpp.jpO.isGod)));
            }
        } else if (view == this.jpm || view == this.jpb || view == getView()) {
            if (this.jpp != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jpp.threadId, null, null);
                if (!this.jpx) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jpf) {
            if (this.jpp != null && this.jpp.jpP != null) {
                this.jpd.setVisibility(8);
                this.jpo.dzX();
                this.jpo.fX(this.jpp.jpP.videoUrl, this.jpp.threadId);
                Kw("2");
            }
        } else if (view == this.jph) {
            if (!this.jpp.jpO.hasFocus) {
                this.jpq.g(this.jpp);
            }
        } else if (view == this.jpn) {
            com.baidu.tbadk.pageExtra.c fp = com.baidu.tbadk.pageExtra.d.fp(getContext());
            if (fp != null) {
                this.jpp.objSource = fp.getCurrentPageKey();
            }
            this.jpq.h(this.jpp);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qW(boolean z) {
        if (this.jpp != null && this.jpp.jpO != null) {
            this.jpp.jpO.hasFocus = z;
            c(this.jpp);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cFA() {
        if (this.jpp != null) {
            this.jpp.hasAgree = !this.jpp.hasAgree;
            if (this.jpp.hasAgree) {
                this.jpp.agreeNum++;
            } else {
                this.jpp.agreeNum--;
            }
            if (this.jpl != null) {
                this.jpl.startAnimation(getScaleAnimation());
            }
            d(this.jpp);
        }
    }

    private Animation getScaleAnimation() {
        if (this.jpw == null) {
            this.jpw = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.jpw.setDuration(200L);
        }
        return this.jpw;
    }
}
