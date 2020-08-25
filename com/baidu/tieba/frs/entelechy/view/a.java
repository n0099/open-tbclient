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
    private TbCyberVideoView Zn;
    private bw afJ;
    private String agH;
    private final View.OnClickListener aiR;
    private Animation bAf;
    private CyberPlayerManager.OnPreparedListener dLH;
    private CyberPlayerManager.OnErrorListener dLI;
    private CyberPlayerManager.OnCompletionListener dLJ;
    private CyberPlayerManager.OnInfoListener dLK;
    private String ecX;
    private TbPageContext<?> efn;
    private final View.OnClickListener etZ;
    private f fDM;
    public FrameLayout fbV;
    private TextView fbW;
    private TbImageView fbX;
    private ImageView fbY;
    private TextView fbZ;
    private View fca;
    private m fcb;
    private View fcc;
    private TextView fcd;
    private int fce;
    private TbImageView.a fcf;
    private ViewTreeObserver.OnGlobalLayoutListener fcg;
    private Runnable fch;
    private Runnable fci;
    private TbCyberVideoView.a fcj;
    private View fmE;
    public LinearLayout fum;
    private RelativeLayout giY;
    public ThreadUserInfoLayout giZ;
    protected ThreadSourceShareAndPraiseLayout gjM;
    public ThreadSkinView gjX;
    public ThreadCommentAndPraiseInfoLayout gja;
    public View gjb;
    private f.a hjC;
    private Animation.AnimationListener hjD;
    private ThreadGodReplyLayout hjl;
    private HeadPendantClickableView hjm;
    private int hjp;
    private boolean hjq;
    private TextView hjv;
    private Handler hjw;
    private VideoLoadingProgressView.a hjx;
    private LinearLayout hkV;
    private TbImageView hlw;
    public TextView ifa;
    public LinearLayout ifb;
    private i ifc;
    public boolean ifd;
    public int ife;
    private View.OnClickListener iff;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        if (this.Zn != null && this.hjq) {
            try {
                this.Zn.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hjw.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hjp = 0;
        this.fce = 1;
        this.hjq = false;
        this.hjw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.cbJ();
                        return;
                    case 203:
                        a.this.cbK();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.Zn != null) {
                    a.this.Zn.setVolume(0.0f, 0.0f);
                }
                a.this.cbE();
            }
        };
        this.dLK = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.Zn.start();
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cbL();
                a.this.v(true, 4);
                a.this.hjq = false;
                return true;
            }
        };
        this.hjx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.cbE();
            }
        };
        this.fcf = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.fbX != null) {
                    a.this.fbX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fcg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fbV != null && a.this.fbV.getLayoutParams() != null && a.this.fbV.getVisibility() != 8) {
                    a.this.fbV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fbV.getLayoutParams();
                    if (a.this.fbV.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fbV.getWidth() * 0.5625d);
                        a.this.fbV.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fch = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Zn != null && !a.this.Zn.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.fci = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cbL();
                a.this.v(true, 4);
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.iff = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.afJ != null && !StringUtils.isNull(a.this.afJ.beI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.efn.getPageActivity()).createNormalCfg(a.this.afJ.beI(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.etZ != null) {
                        a.this.etZ.onClick(view);
                    }
                }
            }
        };
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cbz() != null) {
                    a.this.cbz().a(view, a.this.afJ);
                }
            }
        };
        this.etZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.afJ != null && a.this.cbz() != null) {
                    a.this.cbz().a(view, a.this.afJ);
                }
            }
        };
        this.hjC = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void rX() {
                a.this.cbF();
            }
        };
        this.hjD = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fce == 3 && a.this.fbX != null) {
                    a.this.fbX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.efn = tbPageContext;
        View view = getView();
        this.fmE = view.findViewById(R.id.divider_line);
        this.giY = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hlw = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.ifb = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.giY.setOnClickListener(this);
        this.hjm = (HeadPendantClickableView) this.giY.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hjm.getHeadView() != null) {
            this.hjm.getHeadView().setIsRound(true);
            this.hjm.getHeadView().setDrawBorder(false);
            this.hjm.getHeadView().setDefaultResource(17170445);
            this.hjm.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjm.getHeadView().setRadius(l.getDimens(this.efn.getPageActivity(), R.dimen.ds70));
        }
        this.hjm.setHasPendantStyle();
        if (this.hjm.getPendantView() != null) {
            this.hjm.getPendantView().setIsRound(true);
            this.hjm.getPendantView().setDrawBorder(false);
        }
        this.ifa = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.ifa.setVisibility(8);
        this.ifa.setOnClickListener(this.iff);
        this.fcb = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fcb.setLoadingAnimationListener(this.hjx);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gja.setForumAfterClickListener(this.etZ);
        this.giZ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.giZ.setFrom(3);
        this.gjb = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.gja.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gja.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gja.setLayoutParams(layoutParams);
        }
        this.gja.setOnClickListener(this);
        this.gja.setReplyTimeVisible(false);
        this.gja.setShowPraiseNum(true);
        this.gja.setNeedAddPraiseIcon(true);
        this.gja.setNeedAddReplyIcon(true);
        this.gja.setIsBarViewVisible(false);
        this.gja.setShareVisible(true);
        this.gja.setShareReportFrom(1);
        this.gja.setStType("frs_page");
        this.gja.setFrom(2);
        this.gja.etW = 3;
        this.gjM = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gjM.euU.setOnClickListener(this);
        this.gjM.setFrom(2);
        this.gjM.setShareReportFrom(1);
        this.gjM.setSourceFromForPb(3);
        this.gjM.setStType("frs_page");
        this.gjM.setHideBarName(true);
        this.fbV = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fbV.setOnClickListener(this);
        this.fbV.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fbV != null) {
                    a.this.fbV.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fcg);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fbV != null) {
                    a.this.fbV.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fcg);
                }
            }
        });
        this.fbX = (TbImageView) view.findViewById(R.id.image_video);
        this.fbX.setPageId(getTag());
        this.fbX.setDefaultErrorResource(0);
        this.fbX.setDrawCorner(true);
        this.fbX.setPlaceHolder(3);
        this.fbX.setEvent(this.fcf);
        this.fbX.setGifIconSupport(false);
        this.fbY = (ImageView) view.findViewById(R.id.image_video_play);
        this.Zn = new TbCyberVideoView(getContext());
        this.Zn.setStageType("2003");
        bxf();
        this.Zn.setContinuePlayEnable(true);
        this.Zn.setOnPreparedListener(this.dLH);
        this.Zn.setOnCompletionListener(this.dLJ);
        this.Zn.setOnErrorListener(this.dLI);
        this.Zn.setOnInfoListener(this.dLK);
        this.Zn.setOnSurfaceDestroyedListener(this.fcj);
        this.fDM = new f();
        this.fDM.setPlayer(this.Zn);
        this.fDM.a(this.hjC);
        this.fcc = view.findViewById(R.id.auto_video_black_mask);
        this.fbZ = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fca = view.findViewById(R.id.auto_video_error_background);
        this.fum = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gjX = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bAf = AnimationUtils.loadAnimation(this.efn.getPageActivity(), R.anim.fade_out_video_cover);
        this.bAf.setAnimationListener(this.hjD);
        this.fbW = (TextView) view.findViewById(R.id.text_video_duration);
        this.fcd = (TextView) view.findViewById(R.id.text_video_play_count);
        this.hkV = (LinearLayout) view.findViewById(R.id.duration_container);
        this.ifc = new i(tbPageContext, this.giY);
        this.ifc.setUniqueId(getTag());
        this.hjl = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hjl.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gja != null) {
                    a.this.gja.changeSelectStatus();
                }
            }
        });
        this.gja.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iA(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.hjv = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bxf() {
        if (this.Zn != null && this.Zn.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fbV.addView(this.Zn.getView(), 0);
            this.Zn.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.giY || view == this.gja.getCommentNumView() || view == this.ifb) {
            bX(this.giY);
        } else if (view == this.fbV) {
            if (this.afJ != null && this.afJ.beW() != null) {
                z = this.afJ.beW().is_vertical.intValue() == 1;
            }
            if (z) {
                bV(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ch(this.fbV);
            } else {
                bX(this.fbV);
            }
        } else if (view == this.hjl) {
            bX(this.hjl);
        }
        if (this.afJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.afJ));
        }
    }

    private void bV(View view) {
        if (cbz() != null) {
            cbz().a(view, this.afJ);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.efn.getPageActivity(), R.string.no_network_guide);
        } else {
            cbG();
        }
    }

    private void cbG() {
        if (this.afJ != null) {
            String str = "frs";
            if (this.ife == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.afJ);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.afJ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.afJ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void ch(View view) {
        if (this.afJ != null) {
            aq aqVar = new aq("c11100");
            aqVar.dD("tid", this.afJ.getId());
            aqVar.dD("fid", this.afJ.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (cbz() != null) {
            cbz().a(view, this.afJ);
        }
        if (view == this.fbV) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.efn.getPageActivity(), R.string.no_network_guide);
            } else {
                cbH();
            }
        }
    }

    private void cbH() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.afJ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fum.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fum.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.ife == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.efn.getPageActivity(), str, this.afJ.getTid(), com.baidu.tieba.card.m.beq(), "", videoSerializeVideoThreadInfo);
        if (this.afJ.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.afJ.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bX(View view) {
        String str;
        String str2;
        if (this.afJ != null) {
            if (this.afJ.bfN()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dD("fid", String.valueOf(this.afJ.getFid())).ai("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dD("tid", this.afJ.getId());
                aqVar.dD("fid", this.afJ.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.afJ.beE() != null && this.afJ.beE().getGodUserData() != null && this.afJ.beE().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").ai("obj_locate", 3).dD("tid", this.afJ.getId()));
            }
        }
        if (cbz() != null) {
            cbz().a(view, this.afJ);
        }
        if (this.afJ != null) {
            com.baidu.tieba.card.m.GY(this.afJ.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ab.CK(this.afJ.getId());
            String valueOf = String.valueOf(this.afJ.getFid());
            if (this.afJ.edP == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.afJ.edP.id;
                str2 = valueOf;
            }
            if (this.afJ.bfb() > 0 && com.baidu.tieba.tbadkCore.util.e.dxL()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.efn.getPageActivity()).createHistoryCfg(this.afJ.getTid(), String.valueOf(this.afJ.bfb()), false, true, "frs_page");
                String str3 = "frs";
                if (this.ife == 501) {
                    str3 = "frs_tab";
                } else if (this.afJ.bfN()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.afJ.bfT());
                createHistoryCfg.setSmartFrsPosition(this.afJ.bfZ());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.hjl) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.efn.getPageActivity()).createFromThreadCfg(this.afJ, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.ife == 501) {
                str4 = "frs_tab";
            } else if (this.afJ.bfN()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.afJ.bfT());
            createFromThreadCfg.setSmartFrsPosition(this.afJ.bfZ());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.hjl) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.afJ = bwVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbJ() {
        this.hjw.removeMessages(202);
        if (this.Zn.getCurrentPosition() > 0) {
            v(false, 3);
            this.hjw.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hjw.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbK() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hjw.removeMessages(203);
        int currentPosition = this.Zn.getCurrentPosition();
        if (currentPosition != this.hjp) {
            this.hjp = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.hjw.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fbY != null && this.fbX != null && this.fcc != null && this.fcb != null && this.fca != null && this.fbZ != null) {
            if (z || this.fce != i) {
                this.fce = i;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fci);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fch);
                if (i == 2) {
                    this.fbY.setVisibility(8);
                    this.bAf.cancel();
                    this.fbX.clearAnimation();
                    this.fbX.setVisibility(0);
                    this.fcc.setVisibility(0);
                    this.hkV.setVisibility(0);
                    this.fcb.startLoading();
                    this.fca.setVisibility(8);
                    this.fbZ.setVisibility(8);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fci, 60000L);
                } else if (i == 3) {
                    this.fbY.setVisibility(8);
                    this.fbX.startAnimation(this.bAf);
                    this.fcc.setVisibility(8);
                    this.hkV.setVisibility(8);
                    this.fcb.djZ();
                    this.fca.setVisibility(8);
                    this.fbZ.setVisibility(8);
                    if (this.afJ != null && this.afJ.beW() != null) {
                        this.afJ.beW().video_length.intValue();
                        this.afJ.beW().video_duration.intValue();
                        this.afJ.getTid();
                    }
                } else if (i == 4) {
                    this.fbY.setVisibility(8);
                    this.fbX.startAnimation(this.bAf);
                    this.fcc.setVisibility(8);
                    this.fcb.dka();
                    this.fca.setVisibility(0);
                    this.fbZ.setVisibility(0);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fch, 2000L);
                } else {
                    this.fbY.setVisibility(0);
                    this.hkV.setVisibility(0);
                    this.bAf.cancel();
                    this.fbX.clearAnimation();
                    this.fbX.setVisibility(0);
                    this.fcc.setVisibility(0);
                    this.fcb.dka();
                    this.fca.setVisibility(8);
                    this.fbZ.setVisibility(8);
                }
            }
        }
    }

    private void X(final bw bwVar) {
        if (this.hlw != null) {
            if (bwVar == null) {
                this.hlw.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.edF)) {
                if (this.ifc != null && this.ifc.ctE() && (this.hlw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlw.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.efn.getContext(), R.dimen.tbds106);
                    this.hlw.setLayoutParams(layoutParams);
                }
                this.hlw.setVisibility(0);
                this.hlw.setImageDrawable(null);
                this.hlw.startLoad(bwVar.edF, 10, false);
                this.hlw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.efn != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bwVar.edG, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hlw.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.afJ == null || this.afJ.beE() == null) {
            this.giY.setVisibility(8);
            return;
        }
        this.giY.setVisibility(0);
        this.giY.setOnClickListener(this);
        cbM();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ecX)) {
            this.afJ.du(this.mUrl, this.ecX);
        }
        this.afJ.z(false, true);
        SpannableStringBuilder bfo = this.afJ.bfo();
        if (this.afJ.bfu() && !StringUtils.isNull(this.afJ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.afJ.getTid();
            bfo.append((CharSequence) this.afJ.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.ifc.ax(this.afJ);
        X(this.afJ);
        this.giZ.setData(this.afJ);
        if (this.giZ.getHeaderImg() != null) {
            if (this.giZ.getIsSimpleThread()) {
                this.giZ.getHeaderImg().setVisibility(8);
                this.hjm.setVisibility(8);
            } else if (this.afJ.beE() == null || this.afJ.beE().getPendantData() == null || StringUtils.isNull(this.afJ.beE().getPendantData().bcA())) {
                this.hjm.setVisibility(8);
                this.giZ.getHeaderImg().setVisibility(0);
                this.giZ.getHeaderImg().setData(this.afJ);
            } else {
                this.giZ.getHeaderImg().setVisibility(4);
                this.hjm.setVisibility(0);
                this.hjm.setData(this.afJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gja.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.gja.setLayoutParams(layoutParams);
        this.giZ.setUserAfterClickListener(this.aiR);
        tB(rY(1));
        this.fbW.setText(at.stringForVideoTime(this.afJ.beW().video_duration.intValue() * 1000));
        this.fcd.setText(String.format(this.efn.getResources().getString(R.string.play_count), at.numFormatOverWan(this.afJ.beW().play_count.intValue())));
        this.hjl.setData(this.afJ.bgh());
        this.hjl.onChangeSkinType();
        if (com.baidu.tieba.card.m.GZ(this.afJ.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.hjl.getGodReplyContent(), this.afJ.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.afJ == null || this.afJ.beW() == null) {
            z = false;
        } else {
            z = this.afJ.beW().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hjv.setVisibility(0);
        } else {
            this.hjv.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) && this.gja.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.afJ.bgp() || this.afJ.bgq() || this.afJ.bgr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbL() {
        this.hjw.removeMessages(202);
        this.hjw.removeMessages(203);
    }

    private void bxg() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fch);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fci);
    }

    private void cbM() {
        bxg();
        cbL();
        if (this.fbX != null && this.fbV != null && this.Zn != null) {
            if (k.bbM().isShowImages() && this.afJ != null && this.afJ.beW() != null) {
                this.fbV.setVisibility(0);
                this.fbX.setPlaceHolder(3);
                this.fbX.startLoad(this.afJ.beW().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.afJ.beW().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new aq("c12026").dD("tid", this.afJ.getId()));
                }
                this.Zn.setThreadDataForStatistic(this.afJ);
                return;
            }
            this.fbV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.giY, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fbY, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fbZ, R.color.cp_cont_a);
            ap.setViewTextColor(this.fbW, R.color.cp_cont_a);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fca, R.color.common_color_10014);
            ap.setBackgroundColor(this.fmE, R.color.cp_bg_line_c);
            if (this.fbZ != null) {
                this.fbZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.gjM != null && this.gjM.getVisibility() == 0) {
                this.gjM.onChangeSkinType();
            }
            this.gja.onChangeSkinType();
            this.mSkinType = i;
            this.giZ.onChangeSkinType();
            if (this.hjm != null && this.hjm.getHeadView() != null && (this.hjm.getHeadView() instanceof TbImageView)) {
                this.hjm.getHeadView().setPlaceHolder(1);
            }
            this.fbX.setPlaceHolder(3);
            this.ifc.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.currentPageType = i;
        if (this.gja != null) {
            this.gja.etW = i;
            this.gja.setFrom(2);
        }
        if (this.giZ != null) {
            this.giZ.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.hjq;
    }

    public boolean isPlaying() {
        if (this.Zn == null) {
            return false;
        }
        return this.Zn.isPlaying();
    }

    public void startPlay() {
        if (!this.hjq && this.afJ != null && this.afJ.beW() != null && this.Zn != null) {
            this.Zn.stopPlayback();
            if (ah.bvP()) {
                if (this.ifd || com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dD("obj_locate", "frs").dD("tid", this.afJ.getId()));
                        this.mVideoUrl = this.afJ.beW().video_url;
                    }
                    this.hjq = true;
                    this.Zn.setVideoPath(this.mVideoUrl, this.afJ.getId());
                    if (this.fDM != null) {
                        this.fDM.start();
                    }
                    cbF();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.afJ != null && this.afJ.beW() != null) {
            String str = this.afJ.bfN() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.ife == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.akY = this.afJ.getTid();
            oVar.eVt = this.afJ.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.afJ.mRecomSource;
            oVar.ltg = this.afJ.mRecomAbTag;
            oVar.ltc = this.afJ.mRecomAbTag;
            oVar.ltd = this.afJ.mRecomWeight;
            oVar.lte = "";
            oVar.lth = this.afJ.beW().video_md5;
            h.a(this.afJ.beW().video_md5, "", "1", oVar, this.Zn.getPcdnState());
        }
    }

    public void stopPlay() {
        bxg();
        cbL();
        v(true, 1);
        if (this.Zn != null) {
            this.Zn.stopPlayback();
            if (this.fDM != null) {
                this.fDM.stop();
            }
        }
        this.hjq = false;
    }

    public View getVideoContainer() {
        return this.fbV;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Zn == null) {
            return 0;
        }
        return this.Zn.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.Zn != null) {
            this.Zn.setVideoStatData(oVar);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gja != null && this.giZ != null) {
            this.giZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void tB(int i) {
        if (this.afJ != null) {
            if (i == 1) {
                this.gja.setVisibility(8);
                this.gjM.setData(this.afJ);
                this.gjb.setVisibility(8);
                return;
            }
            this.gja.setData(this.afJ);
            this.gjb.setVisibility(8);
            this.gjM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAA().au(this.agH, i);
    }
}
