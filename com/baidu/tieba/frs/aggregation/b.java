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
    private boolean jnA;
    public FrameLayout jnc;
    public FrameLayout jnd;
    public TextView jne;
    public TextView jnf;
    public FrameLayout jng;
    public TextView jnh;
    public TextView jni;
    public HeadImageView jnj;
    public TextView jnk;
    public TextView jnl;
    public TextView jnm;
    public ImageView jnn;
    public ImageView jno;
    public LinearLayout jnp;
    public LinearLayout jnq;
    public com.baidu.tieba.play.c jnr;
    public g jns;
    private h jnt;
    private o jnu;
    private o jnv;
    private boolean jnw;
    private boolean jnx;
    private Animation jny;
    private ScaleAnimation jnz;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.jnw = true;
        this.jnA = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.jnc = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.jnd = (FrameLayout) view.findViewById(R.id.video_container);
        this.jnr = new com.baidu.tieba.play.c(tbPageContext, this.jnd, false);
        this.jnr.setStageType("2005");
        this.jne = (TextView) view.findViewById(R.id.title);
        this.jnf = (TextView) view.findViewById(R.id.duration);
        this.jng = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.jnh = (TextView) view.findViewById(R.id.mobile_network_text);
        this.jni = (TextView) view.findViewById(R.id.mobile_network_play);
        this.jnj = (HeadImageView) view.findViewById(R.id.user_icon);
        this.ajY = (TextView) view.findViewById(R.id.user_name);
        this.jnk = (TextView) view.findViewById(R.id.attention);
        this.jnp = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.jnq = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.jnl = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jnm = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.jnn = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jno = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.jnp.setOnClickListener(this);
        this.jnq.setOnClickListener(this);
        this.jne.setOnClickListener(this);
        this.jnj.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.jnk.setOnClickListener(this);
        view.setOnClickListener(this);
        this.jni.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jnc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.jnc.setLayoutParams(layoutParams);
        this.jnj.setIsRound(true);
        this.jnt = new h(this.mPageContext, this);
        this.jny = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.chW = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            if (this.jns != null && this.jns.jnR != null) {
                if (this.jns.jnR.hasFocus) {
                    ap.setViewTextColor(this.jnk, R.color.CAM_X0109);
                    this.jnk.setCompoundDrawables(null, null, null, null);
                } else {
                    ap.setViewTextColor(this.jnk, R.color.CAM_X0302);
                    Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.jnk.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.jns != null) {
                if (this.jns.hasAgree) {
                    this.jno.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                    ap.setViewTextColor(this.jnm, R.color.CAM_X0301);
                } else {
                    this.jno.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                    ap.setViewTextColor(this.jnm, R.color.CAM_X0106);
                }
            }
            ap.setViewTextColor(this.jnl, R.color.CAM_X0106);
            this.jnn.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
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
        if (gVar != null && gVar.jnS != null) {
            this.jns = gVar;
            this.eXf = this.jns.autoPlay;
            this.jne.setVisibility(0);
            this.jne.setText(gVar.title);
            this.jnf.setVisibility(0);
            this.jnf.setText(au.stringForVideoTime(gVar.jnS.videoDuration * 1000));
            if (gVar.jnS.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), Kn(String.format("%.1f", Float.valueOf(((float) gVar.jnS.videoSize) / 1048576.0f))));
            }
            this.jnh.setText(format);
            this.jng.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.jnS != null) {
            this.jnr.stopPlay();
            this.jnr.xm(true);
            this.jnr.xi(false);
            this.jnr.a(new c.InterfaceC0848c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rj() {
                    if (b.this.jnr.rl()) {
                        b.this.jnf.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rk() {
                    if (b.this.jnr.rl()) {
                        b.this.jnf.setVisibility(8);
                    }
                    if (b.this.jnx) {
                        b.this.jnr.stopPlay();
                    }
                }
            });
            this.jnr.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void cFo() {
                    b.this.jnx = false;
                    b.this.jnf.setVisibility(8);
                    b.this.Km(b.this.eXf ? "1" : "2");
                    b.this.onClick(b.this.jnd);
                }

                @Override // com.baidu.tieba.play.c.l
                public void cFp() {
                    b.this.jnf.setVisibility(8);
                    b.this.onClick(b.this.jnc);
                }
            });
            this.jnr.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void qX(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.jnh.getText().toString());
                        b.this.jnr.fX(b.this.jns.jnS.videoUrl, b.this.jns.threadId);
                        b.this.jnf.setVisibility(8);
                        b.this.Km("2");
                    } else {
                        b.this.jng.setVisibility(0);
                    }
                    b.this.onClick(b.this.jnd);
                }
            });
            this.jnr.xd(false);
            this.jnu = new o();
            this.jnu.amC = gVar.threadId;
            this.jnu.fNd = gVar.forumId;
            this.jnu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.jnv = new o();
            this.jnv.amC = gVar.threadId;
            this.jnv.fNd = gVar.forumId;
            this.jnv.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.jnA) {
                ar arVar = new ar("c12590");
                arVar.dR("tid", gVar.threadId);
                arVar.dR(IntentConfig.NID, gVar.nid);
                arVar.ap("obj_param5", gVar.getVideoType());
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("fid", gVar.forumId);
                arVar.ap("obj_locate", i);
                arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(arVar);
                this.jnu.mIe = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jnu.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.jnu.mIg = "1";
                this.jnv.mIe = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jnv.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.jnv.mIg = "1";
            } else {
                this.jnu.mIg = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jnu.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.jnv.mIg = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.jnv.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.jnS != null) {
                this.jnu.mIj = gVar.jnS.videoMd5;
                this.jnv.mIj = gVar.jnS.videoMd5;
            }
            this.jnr.getVideoView().setVideoStatData(this.jnu);
            this.jnr.dco();
            this.jnr.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void qY(boolean z) {
                    if (!b.this.jnr.rl()) {
                        b.this.jne.setVisibility(0);
                    } else if (z) {
                        if (b.this.jne.getVisibility() == 0) {
                            b.this.jne.setVisibility(8);
                            b.this.jne.startAnimation(b.this.jny);
                        }
                    } else if (b.this.jne.getVisibility() == 8) {
                        b.this.jne.setVisibility(0);
                        b.this.jne.startAnimation(b.this.chW);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFq() {
                    if (!b.this.jnr.rl()) {
                        b.this.jne.setVisibility(0);
                    } else if (b.this.jne.getVisibility() == 0) {
                        b.this.jne.setVisibility(8);
                        b.this.jne.startAnimation(b.this.jny);
                    }
                }
            });
            this.jnr.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (b.this.isFullScreen) {
                        b.this.jnx = true;
                        b.this.jnw = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.ze(i);
                        b.this.jnr.cSD();
                    }
                }
            });
            this.jnr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (b.this.jns != null && b.this.jns.jnS != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.jns.jnS.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.jnr.setThumbnail(gVar.jnS.thumbnailUrl);
            this.jnr.setVideoUrl(gVar.jnS.videoUrl, gVar.threadId);
            this.jnr.QC(gVar.title);
            this.jnr.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void cFr() {
                    b.this.jnf.setVisibility(8);
                }
            });
            this.jnr.cSD();
            this.jnr.show();
            if (gVar.autoPlay) {
                onClick(this.jnd);
                this.jnx = false;
                this.jnr.a(gVar.jnS.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.jnx = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km(String str) {
        if (this.jns != null && this.jns.jnS != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.jns.jnS.videoMd5, "", str, this.jnv, this.jnr.getVideoView().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.jnr.rl();
    }

    public void pauseVideo() {
        if (isPlaying()) {
            this.jnr.pausePlay();
        }
    }

    public boolean zf(int i) {
        return this.jnr.Hl(i);
    }

    public void stopVideo() {
        this.jng.setVisibility(8);
        this.jnr.stopPlay();
        if (this.jne != null) {
            this.jne.setVisibility(0);
        }
        if (this.jnf != null) {
            this.jnf.setVisibility(0);
        }
    }

    public void cFm() {
        if (this.jnr != null) {
            this.jnr.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        cFm();
        if (this.jnt != null) {
            this.jnt.cFx();
        }
    }

    public String Kn(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.jnR != null) {
            this.ajY.setText(TextUtils.isEmpty(gVar.jnR.userNickname) ? gVar.jnR.userName : gVar.jnR.userNickname);
            this.jnj.startLoad(gVar.jnR.portrait, 12, false);
            this.jnj.setShowV(gVar.jnR.isGod);
            this.jnj.setIsBigV(gVar.jnR.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.jnR != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.jnR.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.jnR.userId)) {
                this.jnk.setVisibility(8);
            } else {
                this.jnk.setVisibility(0);
            }
            if (gVar.jnR.hasFocus) {
                ap.setViewTextColor(this.jnk, R.color.CAM_X0109);
                this.jnk.setCompoundDrawables(null, null, null, null);
                this.jnk.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            ap.setViewTextColor(this.jnk, R.color.CAM_X0302);
            Drawable drawable = ap.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.jnk.setCompoundDrawables(drawable, null, null, null);
            this.jnk.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.jno.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_s));
                ap.setViewTextColor(this.jnm, R.color.CAM_X0301);
            } else {
                this.jno.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_like_n));
                ap.setViewTextColor(this.jnm, R.color.CAM_X0106);
            }
            this.jnm.setText(au.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            ap.setViewTextColor(this.jnl, R.color.CAM_X0106);
            this.jnn.setImageDrawable(ap.getDrawable(R.drawable.icon_home_card_comment));
            this.jnl.setText(au.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jnr != null && this.jnd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.jnw) {
                this.jnr.dzE();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.jnd.getParent() != null) {
                    if (this.jnd.getParent() == frameLayout) {
                        frameLayout.removeView(this.jnd);
                    } else if (this.jnd.getParent() == this.jnc) {
                        this.jnc.removeView(this.jnd);
                    }
                }
                if (this.jnd.getParent() == null) {
                    frameLayout.addView(this.jnd);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jnd.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.jnd.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.jnd.getParent() != null) {
                    if (this.jnd.getParent() == frameLayout) {
                        frameLayout.removeView(this.jnd);
                    } else if (this.jnd.getParent() == this.jnc) {
                        this.jnc.removeView(this.jnd);
                    }
                }
                if (this.jnd.getParent() == null) {
                    this.jnc.addView(this.jnd, 0);
                    this.jnd.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.jnr.dco();
                    this.jnw = true;
                } else {
                    return;
                }
            }
            this.jnr.a(this.mPageContext, configuration);
            this.jnf.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crV() != null) {
            view.setTag(this);
            crV().a(view, this.jns);
        }
        if (view == this.jnj || view == this.ajY) {
            boolean z = false;
            if (this.jns != null && this.jns.jnR != null && !TextUtils.isEmpty(this.jns.jnR.userId)) {
                if (TbadkCoreApplication.isLogin() && this.jns.jnR.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jns.jnR.userId, 0L), z, this.jns.jnR.isGod)));
            }
        } else if (view == this.jnp || view == this.jne || view == getView()) {
            if (this.jns != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.jns.threadId, null, null);
                if (!this.jnA) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.jni) {
            if (this.jns != null && this.jns.jnS != null) {
                this.jng.setVisibility(8);
                this.jnr.dzH();
                this.jnr.fX(this.jns.jnS.videoUrl, this.jns.threadId);
                Km("2");
            }
        } else if (view == this.jnk) {
            if (!this.jns.jnR.hasFocus) {
                this.jnt.g(this.jns);
            }
        } else if (view == this.jnq) {
            com.baidu.tbadk.pageExtra.c fq = com.baidu.tbadk.pageExtra.d.fq(getContext());
            if (fq != null) {
                this.jns.objSource = fq.getCurrentPageKey();
            }
            this.jnt.h(this.jns);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void qW(boolean z) {
        if (this.jns != null && this.jns.jnR != null) {
            this.jns.jnR.hasFocus = z;
            c(this.jns);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void cFn() {
        if (this.jns != null) {
            this.jns.hasAgree = !this.jns.hasAgree;
            if (this.jns.hasAgree) {
                this.jns.agreeNum++;
            } else {
                this.jns.agreeNum--;
            }
            if (this.jno != null) {
                this.jno.startAnimation(getScaleAnimation());
            }
            d(this.jns);
        }
    }

    private Animation getScaleAnimation() {
        if (this.jnz == null) {
            this.jnz = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.jnz.setDuration(200L);
        }
        return this.jnz;
    }
}
