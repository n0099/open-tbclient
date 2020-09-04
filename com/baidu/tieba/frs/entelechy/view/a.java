package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private TbCyberVideoView Zp;
    private bw afL;
    private String agJ;
    private final View.OnClickListener aiT;
    private Animation bAi;
    private CyberPlayerManager.OnPreparedListener dLL;
    private CyberPlayerManager.OnErrorListener dLM;
    private CyberPlayerManager.OnCompletionListener dLN;
    private CyberPlayerManager.OnInfoListener dLO;
    private String edb;
    private TbPageContext<?> efr;
    private final View.OnClickListener eud;
    private f fDQ;
    public FrameLayout fbZ;
    private TextView fca;
    private TbImageView fcb;
    private ImageView fcc;
    private TextView fcd;
    private View fce;
    private m fcf;
    private View fcg;
    private TextView fch;
    private int fci;
    private TbImageView.a fcj;
    private ViewTreeObserver.OnGlobalLayoutListener fck;
    private Runnable fcl;
    private Runnable fcm;
    private TbCyberVideoView.a fcn;
    private View fmI;
    public LinearLayout fuq;
    protected ThreadSourceShareAndPraiseLayout gjQ;
    private RelativeLayout gjc;
    public ThreadUserInfoLayout gjd;
    public ThreadCommentAndPraiseInfoLayout gje;
    public View gjf;
    public ThreadSkinView gkb;
    private Handler hjA;
    private VideoLoadingProgressView.a hjB;
    private f.a hjG;
    private Animation.AnimationListener hjH;
    private ThreadGodReplyLayout hjp;
    private HeadPendantClickableView hjq;
    private int hjt;
    private boolean hju;
    private TextView hjz;
    private LinearLayout hkZ;
    private TbImageView hlA;
    public TextView ifg;
    public LinearLayout ifh;
    private i ifi;
    public boolean ifj;
    public int ifk;
    private View.OnClickListener ifl;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.Zp != null && this.hju) {
            try {
                this.Zp.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hjA.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hjt = 0;
        this.fci = 1;
        this.hju = false;
        this.hjA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.cbK();
                        return;
                    case 203:
                        a.this.cbL();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.Zp != null) {
                    a.this.Zp.setVolume(0.0f, 0.0f);
                }
                a.this.cbF();
            }
        };
        this.dLO = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.Zp.start();
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cbM();
                a.this.v(true, 4);
                a.this.hju = false;
                return true;
            }
        };
        this.hjB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.cbF();
            }
        };
        this.fcj = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.fcb != null) {
                    a.this.fcb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fck = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fbZ != null && a.this.fbZ.getLayoutParams() != null && a.this.fbZ.getVisibility() != 8) {
                    a.this.fbZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fbZ.getLayoutParams();
                    if (a.this.fbZ.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fbZ.getWidth() * 0.5625d);
                        a.this.fbZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fcl = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Zp != null && !a.this.Zp.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.fcm = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cbM();
                a.this.v(true, 4);
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.ifl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.afL != null && !StringUtils.isNull(a.this.afL.beI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.efr.getPageActivity()).createNormalCfg(a.this.afL.beI(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.eud != null) {
                        a.this.eud.onClick(view);
                    }
                }
            }
        };
        this.aiT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cbA() != null) {
                    a.this.cbA().a(view, a.this.afL);
                }
            }
        };
        this.eud = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.afL != null && a.this.cbA() != null) {
                    a.this.cbA().a(view, a.this.afL);
                }
            }
        };
        this.hjG = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void rX() {
                a.this.cbG();
            }
        };
        this.hjH = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fci == 3 && a.this.fcb != null) {
                    a.this.fcb.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.efr = tbPageContext;
        View view = getView();
        this.fmI = view.findViewById(R.id.divider_line);
        this.gjc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hlA = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.ifh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gjc.setOnClickListener(this);
        this.hjq = (HeadPendantClickableView) this.gjc.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hjq.getHeadView() != null) {
            this.hjq.getHeadView().setIsRound(true);
            this.hjq.getHeadView().setDrawBorder(false);
            this.hjq.getHeadView().setDefaultResource(17170445);
            this.hjq.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjq.getHeadView().setRadius(l.getDimens(this.efr.getPageActivity(), R.dimen.ds70));
        }
        this.hjq.setHasPendantStyle();
        if (this.hjq.getPendantView() != null) {
            this.hjq.getPendantView().setIsRound(true);
            this.hjq.getPendantView().setDrawBorder(false);
        }
        this.ifg = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.ifg.setVisibility(8);
        this.ifg.setOnClickListener(this.ifl);
        this.fcf = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fcf.setLoadingAnimationListener(this.hjB);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gje.setForumAfterClickListener(this.eud);
        this.gjd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gjd.setFrom(3);
        this.gjf = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.gje.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gje.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gje.setLayoutParams(layoutParams);
        }
        this.gje.setOnClickListener(this);
        this.gje.setReplyTimeVisible(false);
        this.gje.setShowPraiseNum(true);
        this.gje.setNeedAddPraiseIcon(true);
        this.gje.setNeedAddReplyIcon(true);
        this.gje.setIsBarViewVisible(false);
        this.gje.setShareVisible(true);
        this.gje.setShareReportFrom(1);
        this.gje.setStType("frs_page");
        this.gje.setFrom(2);
        this.gje.eua = 3;
        this.gjQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gjQ.euY.setOnClickListener(this);
        this.gjQ.setFrom(2);
        this.gjQ.setShareReportFrom(1);
        this.gjQ.setSourceFromForPb(3);
        this.gjQ.setStType("frs_page");
        this.gjQ.setHideBarName(true);
        this.fbZ = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fbZ.setOnClickListener(this);
        this.fbZ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fbZ != null) {
                    a.this.fbZ.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fck);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fbZ != null) {
                    a.this.fbZ.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fck);
                }
            }
        });
        this.fcb = (TbImageView) view.findViewById(R.id.image_video);
        this.fcb.setPageId(getTag());
        this.fcb.setDefaultErrorResource(0);
        this.fcb.setDrawCorner(true);
        this.fcb.setPlaceHolder(3);
        this.fcb.setEvent(this.fcj);
        this.fcb.setGifIconSupport(false);
        this.fcc = (ImageView) view.findViewById(R.id.image_video_play);
        this.Zp = new TbCyberVideoView(getContext());
        this.Zp.setStageType("2003");
        bxg();
        this.Zp.setContinuePlayEnable(true);
        this.Zp.setOnPreparedListener(this.dLL);
        this.Zp.setOnCompletionListener(this.dLN);
        this.Zp.setOnErrorListener(this.dLM);
        this.Zp.setOnInfoListener(this.dLO);
        this.Zp.setOnSurfaceDestroyedListener(this.fcn);
        this.fDQ = new f();
        this.fDQ.setPlayer(this.Zp);
        this.fDQ.a(this.hjG);
        this.fcg = view.findViewById(R.id.auto_video_black_mask);
        this.fcd = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fce = view.findViewById(R.id.auto_video_error_background);
        this.fuq = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gkb = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bAi = AnimationUtils.loadAnimation(this.efr.getPageActivity(), R.anim.fade_out_video_cover);
        this.bAi.setAnimationListener(this.hjH);
        this.fca = (TextView) view.findViewById(R.id.text_video_duration);
        this.fch = (TextView) view.findViewById(R.id.text_video_play_count);
        this.hkZ = (LinearLayout) view.findViewById(R.id.duration_container);
        this.ifi = new i(tbPageContext, this.gjc);
        this.ifi.setUniqueId(getTag());
        this.hjp = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hjp.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gje != null) {
                    a.this.gje.changeSelectStatus();
                }
            }
        });
        this.gje.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iB(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.hjz = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bxg() {
        if (this.Zp != null && this.Zp.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fbZ.addView(this.Zp.getView(), 0);
            this.Zp.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gjc || view == this.gje.getCommentNumView() || view == this.ifh) {
            bX(this.gjc);
        } else if (view == this.fbZ) {
            if (this.afL != null && this.afL.beW() != null) {
                z = this.afL.beW().is_vertical.intValue() == 1;
            }
            if (z) {
                bV(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ch(this.fbZ);
            } else {
                bX(this.fbZ);
            }
        } else if (view == this.hjp) {
            bX(this.hjp);
        }
        if (this.afL != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.afL));
        }
    }

    private void bV(View view) {
        if (cbA() != null) {
            cbA().a(view, this.afL);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.efr.getPageActivity(), R.string.no_network_guide);
        } else {
            cbH();
        }
    }

    private void cbH() {
        if (this.afL != null) {
            String str = "frs";
            if (this.ifk == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.afL);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.afL.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.afL.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void ch(View view) {
        if (this.afL != null) {
            aq aqVar = new aq("c11100");
            aqVar.dD("tid", this.afL.getId());
            aqVar.dD("fid", this.afL.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (cbA() != null) {
            cbA().a(view, this.afL);
        }
        if (view == this.fbZ) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.efr.getPageActivity(), R.string.no_network_guide);
            } else {
                cbI();
            }
        }
    }

    private void cbI() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.afL);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fuq.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fuq.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.ifk == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.efr.getPageActivity(), str, this.afL.getTid(), com.baidu.tieba.card.m.beq(), "", videoSerializeVideoThreadInfo);
        if (this.afL.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.afL.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bX(View view) {
        String str;
        String str2;
        if (this.afL != null) {
            if (this.afL.bfN()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dD("fid", String.valueOf(this.afL.getFid())).ai("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dD("tid", this.afL.getId());
                aqVar.dD("fid", this.afL.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.afL.beE() != null && this.afL.beE().getGodUserData() != null && this.afL.beE().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").ai("obj_locate", 3).dD("tid", this.afL.getId()));
            }
        }
        if (cbA() != null) {
            cbA().a(view, this.afL);
        }
        if (this.afL != null) {
            com.baidu.tieba.card.m.GZ(this.afL.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ab.CL(this.afL.getId());
            String valueOf = String.valueOf(this.afL.getFid());
            if (this.afL.edT == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.afL.edT.id;
                str2 = valueOf;
            }
            if (this.afL.bfb() > 0 && com.baidu.tieba.tbadkCore.util.e.dxQ()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.efr.getPageActivity()).createHistoryCfg(this.afL.getTid(), String.valueOf(this.afL.bfb()), false, true, "frs_page");
                String str3 = "frs";
                if (this.ifk == 501) {
                    str3 = "frs_tab";
                } else if (this.afL.bfN()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.afL.bfT());
                createHistoryCfg.setSmartFrsPosition(this.afL.bfZ());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.hjp) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.efr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.efr.getPageActivity()).createFromThreadCfg(this.afL, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.ifk == 501) {
                str4 = "frs_tab";
            } else if (this.afL.bfN()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.afL.bfT());
            createFromThreadCfg.setSmartFrsPosition(this.afL.bfZ());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.hjp) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.efr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.afL = bwVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbK() {
        this.hjA.removeMessages(202);
        if (this.Zp.getCurrentPosition() > 0) {
            v(false, 3);
            this.hjA.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hjA.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbL() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hjA.removeMessages(203);
        int currentPosition = this.Zp.getCurrentPosition();
        if (currentPosition != this.hjt) {
            this.hjt = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.hjA.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fcc != null && this.fcb != null && this.fcg != null && this.fcf != null && this.fce != null && this.fcd != null) {
            if (z || this.fci != i) {
                this.fci = i;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcm);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcl);
                if (i == 2) {
                    this.fcc.setVisibility(8);
                    this.bAi.cancel();
                    this.fcb.clearAnimation();
                    this.fcb.setVisibility(0);
                    this.fcg.setVisibility(0);
                    this.hkZ.setVisibility(0);
                    this.fcf.startLoading();
                    this.fce.setVisibility(8);
                    this.fcd.setVisibility(8);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fcm, 60000L);
                } else if (i == 3) {
                    this.fcc.setVisibility(8);
                    this.fcb.startAnimation(this.bAi);
                    this.fcg.setVisibility(8);
                    this.hkZ.setVisibility(8);
                    this.fcf.dkc();
                    this.fce.setVisibility(8);
                    this.fcd.setVisibility(8);
                    if (this.afL != null && this.afL.beW() != null) {
                        this.afL.beW().video_length.intValue();
                        this.afL.beW().video_duration.intValue();
                        this.afL.getTid();
                    }
                } else if (i == 4) {
                    this.fcc.setVisibility(8);
                    this.fcb.startAnimation(this.bAi);
                    this.fcg.setVisibility(8);
                    this.fcf.dkd();
                    this.fce.setVisibility(0);
                    this.fcd.setVisibility(0);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fcl, 2000L);
                } else {
                    this.fcc.setVisibility(0);
                    this.hkZ.setVisibility(0);
                    this.bAi.cancel();
                    this.fcb.clearAnimation();
                    this.fcb.setVisibility(0);
                    this.fcg.setVisibility(0);
                    this.fcf.dkd();
                    this.fce.setVisibility(8);
                    this.fcd.setVisibility(8);
                }
            }
        }
    }

    private void X(final bw bwVar) {
        if (this.hlA != null) {
            if (bwVar == null) {
                this.hlA.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.edJ)) {
                if (this.ifi != null && this.ifi.ctF() && (this.hlA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlA.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.efr.getContext(), R.dimen.tbds106);
                    this.hlA.setLayoutParams(layoutParams);
                }
                this.hlA.setVisibility(0);
                this.hlA.setImageDrawable(null);
                this.hlA.startLoad(bwVar.edJ, 10, false);
                this.hlA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.efr != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bwVar.edK, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hlA.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.afL == null || this.afL.beE() == null) {
            this.gjc.setVisibility(8);
            return;
        }
        this.gjc.setVisibility(0);
        this.gjc.setOnClickListener(this);
        cbN();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.edb)) {
            this.afL.du(this.mUrl, this.edb);
        }
        this.afL.z(false, true);
        SpannableStringBuilder bfo = this.afL.bfo();
        if (this.afL.bfu() && !StringUtils.isNull(this.afL.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.afL.getTid();
            bfo.append((CharSequence) this.afL.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dD("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(bfo));
        this.mTextTitle.setText(bfo);
        this.ifi.ax(this.afL);
        X(this.afL);
        this.gjd.setData(this.afL);
        if (this.gjd.getHeaderImg() != null) {
            if (this.gjd.getIsSimpleThread()) {
                this.gjd.getHeaderImg().setVisibility(8);
                this.hjq.setVisibility(8);
            } else if (this.afL.beE() == null || this.afL.beE().getPendantData() == null || StringUtils.isNull(this.afL.beE().getPendantData().bcA())) {
                this.hjq.setVisibility(8);
                this.gjd.getHeaderImg().setVisibility(0);
                this.gjd.getHeaderImg().setData(this.afL);
            } else {
                this.gjd.getHeaderImg().setVisibility(4);
                this.hjq.setVisibility(0);
                this.hjq.setData(this.afL);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gje.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.gje.setLayoutParams(layoutParams);
        this.gjd.setUserAfterClickListener(this.aiT);
        tB(rY(1));
        this.fca.setText(at.stringForVideoTime(this.afL.beW().video_duration.intValue() * 1000));
        this.fch.setText(String.format(this.efr.getResources().getString(R.string.play_count), at.numFormatOverWan(this.afL.beW().play_count.intValue())));
        this.hjp.setData(this.afL.bgh());
        this.hjp.onChangeSkinType();
        if (com.baidu.tieba.card.m.Ha(this.afL.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.hjp.getGodReplyContent(), this.afL.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.afL == null || this.afL.beW() == null) {
            z = false;
        } else {
            z = this.afL.beW().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hjz.setVisibility(0);
        } else {
            this.hjz.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) && this.gje.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.afL.bgp() || this.afL.bgq() || this.afL.bgr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbM() {
        this.hjA.removeMessages(202);
        this.hjA.removeMessages(203);
    }

    private void bxh() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcl);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcm);
    }

    private void cbN() {
        bxh();
        cbM();
        if (this.fcb != null && this.fbZ != null && this.Zp != null) {
            if (k.bbM().isShowImages() && this.afL != null && this.afL.beW() != null) {
                this.fbZ.setVisibility(0);
                this.fcb.setPlaceHolder(3);
                this.fcb.startLoad(this.afL.beW().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.afL.beW().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new aq("c12026").dD("tid", this.afL.getId()));
                }
                this.Zp.setThreadDataForStatistic(this.afL);
                return;
            }
            this.fbZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gjc, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fcc, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
            ap.setViewTextColor(this.fca, R.color.cp_cont_a);
            ap.setViewTextColor(this.fch, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fce, R.color.common_color_10014);
            ap.setBackgroundColor(this.fmI, R.color.cp_bg_line_c);
            if (this.fcd != null) {
                this.fcd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.gjQ != null && this.gjQ.getVisibility() == 0) {
                this.gjQ.onChangeSkinType();
            }
            this.gje.onChangeSkinType();
            this.mSkinType = i;
            this.gjd.onChangeSkinType();
            if (this.hjq != null && this.hjq.getHeadView() != null && (this.hjq.getHeadView() instanceof TbImageView)) {
                this.hjq.getHeadView().setPlaceHolder(1);
            }
            this.fcb.setPlaceHolder(3);
            this.ifi.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.currentPageType = i;
        if (this.gje != null) {
            this.gje.eua = i;
            this.gje.setFrom(2);
        }
        if (this.gjd != null) {
            this.gjd.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.hju;
    }

    public boolean isPlaying() {
        if (this.Zp == null) {
            return false;
        }
        return this.Zp.isPlaying();
    }

    public void startPlay() {
        if (!this.hju && this.afL != null && this.afL.beW() != null && this.Zp != null) {
            this.Zp.stopPlayback();
            if (ah.bvQ()) {
                if (this.ifj || com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dD("obj_locate", "frs").dD("tid", this.afL.getId()));
                        this.mVideoUrl = this.afL.beW().video_url;
                    }
                    this.hju = true;
                    this.Zp.setVideoPath(this.mVideoUrl, this.afL.getId());
                    if (this.fDQ != null) {
                        this.fDQ.start();
                    }
                    cbG();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbG() {
        if (this.afL != null && this.afL.beW() != null) {
            String str = this.afL.bfN() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.ifk == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.ala = this.afL.getTid();
            oVar.eVx = this.afL.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.afL.mRecomSource;
            oVar.lts = this.afL.mRecomAbTag;
            oVar.ltn = this.afL.mRecomAbTag;
            oVar.lto = this.afL.mRecomWeight;
            oVar.ltp = "";
            oVar.ltt = this.afL.beW().video_md5;
            h.a(this.afL.beW().video_md5, "", "1", oVar, this.Zp.getPcdnState());
        }
    }

    public void stopPlay() {
        bxh();
        cbM();
        v(true, 1);
        if (this.Zp != null) {
            this.Zp.stopPlayback();
            if (this.fDQ != null) {
                this.fDQ.stop();
            }
        }
        this.hju = false;
    }

    public View getVideoContainer() {
        return this.fbZ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Zp == null) {
            return 0;
        }
        return this.Zp.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.Zp != null) {
            this.Zp.setVideoStatData(oVar);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gje != null && this.gjd != null) {
            this.gjd.setPageUniqueId(bdUniqueId);
        }
    }

    public void tB(int i) {
        if (this.afL != null) {
            if (i == 1) {
                this.gje.setVisibility(8);
                this.gjQ.setData(this.afL);
                this.gjf.setVisibility(8);
                return;
            }
            this.gje.setData(this.afL);
            this.gjf.setVisibility(8);
            this.gjQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAB().au(this.agJ, i);
    }
}
