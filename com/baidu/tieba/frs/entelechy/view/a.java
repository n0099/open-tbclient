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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ai;
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
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private TbCyberVideoView ZH;
    private bw agf;
    private String ahc;
    private final View.OnClickListener ajn;
    private Animation bDF;
    private CyberPlayerManager.OnPreparedListener dNO;
    private CyberPlayerManager.OnErrorListener dNP;
    private CyberPlayerManager.OnCompletionListener dNQ;
    private CyberPlayerManager.OnInfoListener dNR;
    private String efl;
    private TbPageContext<?> ehG;
    private final View.OnClickListener ewh;
    private f fHc;
    public FrameLayout feS;
    private TextView feT;
    private TbImageView feU;
    private ImageView feV;
    private TextView feW;
    private View feX;
    private m feY;
    private View feZ;
    private TextView ffa;
    private int ffb;
    private TbImageView.a ffc;
    private ViewTreeObserver.OnGlobalLayoutListener ffd;
    private Runnable ffe;
    private Runnable fff;
    private TbCyberVideoView.a ffg;
    private View fpN;
    public LinearLayout fxB;
    protected ThreadSourceShareAndPraiseLayout gmX;
    private RelativeLayout gmj;
    public ThreadUserInfoLayout gmk;
    public ThreadCommentAndPraiseInfoLayout gml;
    public View gmm;
    public ThreadSkinView gni;
    private TextView hqC;
    private Handler hqD;
    private VideoLoadingProgressView.a hqE;
    private f.a hqJ;
    private Animation.AnimationListener hqK;
    private ThreadGodReplyLayout hqs;
    private HeadPendantClickableView hqt;
    private int hqw;
    private boolean hqx;
    private TbImageView hsD;
    private LinearLayout hsc;
    public TextView imh;
    public LinearLayout imi;
    private i imj;
    public boolean imk;
    public int iml;
    private View.OnClickListener imm;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        if (this.ZH != null && this.hqx) {
            try {
                this.ZH.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hqD.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hqw = 0;
        this.ffb = 1;
        this.hqx = false;
        this.hqD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.ceZ();
                        return;
                    case 203:
                        a.this.cfa();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.ZH != null) {
                    a.this.ZH.setVolume(0.0f, 0.0f);
                }
                a.this.ceU();
            }
        };
        this.dNR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.ZH.start();
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cfb();
                a.this.v(true, 4);
                a.this.hqx = false;
                return true;
            }
        };
        this.hqE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.ceU();
            }
        };
        this.ffc = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.feU != null) {
                    a.this.feU.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.ffd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.feS != null && a.this.feS.getLayoutParams() != null && a.this.feS.getVisibility() != 8) {
                    a.this.feS.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.feS.getLayoutParams();
                    if (a.this.feS.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.feS.getWidth() * 0.5625d);
                        a.this.feS.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.ffe = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ZH != null && !a.this.ZH.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.fff = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cfb();
                a.this.v(true, 4);
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.imm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agf != null && !StringUtils.isNull(a.this.agf.bfC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.ehG.getPageActivity()).createNormalCfg(a.this.agf.bfC(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.ewh != null) {
                        a.this.ewh.onClick(view);
                    }
                }
            }
        };
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ceP() != null) {
                    a.this.ceP().a(view, a.this.agf);
                }
            }
        };
        this.ewh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agf != null && a.this.ceP() != null) {
                    a.this.ceP().a(view, a.this.agf);
                }
            }
        };
        this.hqJ = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                a.this.ceV();
            }
        };
        this.hqK = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ffb == 3 && a.this.feU != null) {
                    a.this.feU.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.ehG = tbPageContext;
        View view = getView();
        this.fpN = view.findViewById(R.id.divider_line);
        this.gmj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hsD = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.imi = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gmj.setOnClickListener(this);
        this.hqt = (HeadPendantClickableView) this.gmj.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hqt.getHeadView() != null) {
            this.hqt.getHeadView().setIsRound(true);
            this.hqt.getHeadView().setDrawBorder(false);
            this.hqt.getHeadView().setDefaultResource(17170445);
            this.hqt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hqt.getHeadView().setRadius(l.getDimens(this.ehG.getPageActivity(), R.dimen.ds70));
        }
        this.hqt.setHasPendantStyle();
        if (this.hqt.getPendantView() != null) {
            this.hqt.getPendantView().setIsRound(true);
            this.hqt.getPendantView().setDrawBorder(false);
        }
        this.imh = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.imh.setVisibility(8);
        this.imh.setOnClickListener(this.imm);
        this.feY = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.feY.setLoadingAnimationListener(this.hqE);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gml.setForumAfterClickListener(this.ewh);
        this.gmk = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gmk.setFrom(3);
        this.gmm = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.gml.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gml.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gml.setLayoutParams(layoutParams);
        }
        this.gml.setOnClickListener(this);
        this.gml.setReplyTimeVisible(false);
        this.gml.setShowPraiseNum(true);
        this.gml.setNeedAddPraiseIcon(true);
        this.gml.setNeedAddReplyIcon(true);
        this.gml.setIsBarViewVisible(false);
        this.gml.setShareVisible(true);
        this.gml.setShareReportFrom(1);
        this.gml.setStType("frs_page");
        this.gml.setFrom(2);
        this.gml.ewe = 3;
        this.gmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gmX.exc.setOnClickListener(this);
        this.gmX.setFrom(2);
        this.gmX.setShareReportFrom(1);
        this.gmX.setSourceFromForPb(3);
        this.gmX.setStType("frs_page");
        this.gmX.setHideBarName(true);
        this.feS = (FrameLayout) view.findViewById(R.id.frame_video);
        this.feS.setOnClickListener(this);
        this.feS.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.feS != null) {
                    a.this.feS.getViewTreeObserver().addOnGlobalLayoutListener(a.this.ffd);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.feS != null) {
                    a.this.feS.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.ffd);
                }
            }
        });
        this.feU = (TbImageView) view.findViewById(R.id.image_video);
        this.feU.setPageId(getTag());
        this.feU.setDefaultErrorResource(0);
        this.feU.setDrawCorner(true);
        this.feU.setPlaceHolder(3);
        this.feU.setEvent(this.ffc);
        this.feU.setGifIconSupport(false);
        this.feV = (ImageView) view.findViewById(R.id.image_video_play);
        this.ZH = new TbCyberVideoView(getContext());
        this.ZH.setStageType("2003");
        byp();
        this.ZH.setContinuePlayEnable(true);
        this.ZH.setOnPreparedListener(this.dNO);
        this.ZH.setOnCompletionListener(this.dNQ);
        this.ZH.setOnErrorListener(this.dNP);
        this.ZH.setOnInfoListener(this.dNR);
        this.ZH.setOnSurfaceDestroyedListener(this.ffg);
        this.fHc = new f();
        this.fHc.setPlayer(this.ZH);
        this.fHc.a(this.hqJ);
        this.feZ = view.findViewById(R.id.auto_video_black_mask);
        this.feW = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.feX = view.findViewById(R.id.auto_video_error_background);
        this.fxB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gni = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bDF = AnimationUtils.loadAnimation(this.ehG.getPageActivity(), R.anim.fade_out_video_cover);
        this.bDF.setAnimationListener(this.hqK);
        this.feT = (TextView) view.findViewById(R.id.text_video_duration);
        this.ffa = (TextView) view.findViewById(R.id.text_video_play_count);
        this.hsc = (LinearLayout) view.findViewById(R.id.duration_container);
        this.imj = new i(tbPageContext, this.gmj);
        this.imj.setUniqueId(getTag());
        this.hqs = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hqs.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gml != null) {
                    a.this.gml.changeSelectStatus();
                }
            }
        });
        this.gml.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iy(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.hqC = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void byp() {
        if (this.ZH != null && this.ZH.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.feS.addView(this.ZH.getView(), 0);
            this.ZH.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gmj || view == this.gml.getCommentNumView() || view == this.imi) {
            cg(this.gmj);
        } else if (view == this.feS) {
            if (this.agf != null && this.agf.bfQ() != null) {
                z = this.agf.bfQ().is_vertical.intValue() == 1;
            }
            if (z) {
                ce(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cq(this.feS);
            } else {
                cg(this.feS);
            }
        } else if (view == this.hqs) {
            cg(this.hqs);
        }
        if (this.agf != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.agf));
        }
    }

    private void ce(View view) {
        if (ceP() != null) {
            ceP().a(view, this.agf);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.ehG.getPageActivity(), R.string.no_network_guide);
        } else {
            ceW();
        }
    }

    private void ceW() {
        if (this.agf != null) {
            String str = "frs";
            if (this.iml == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.agf);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.agf.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.agf.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cq(View view) {
        if (this.agf != null) {
            aq aqVar = new aq("c11100");
            aqVar.dF("tid", this.agf.getId());
            aqVar.dF("fid", this.agf.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (ceP() != null) {
            ceP().a(view, this.agf);
        }
        if (view == this.feS) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.ehG.getPageActivity(), R.string.no_network_guide);
            } else {
                ceX();
            }
        }
    }

    private void ceX() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.agf);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fxB.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fxB.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.iml == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.ehG.getPageActivity(), str, this.agf.getTid(), com.baidu.tieba.card.m.bfk(), "", videoSerializeVideoThreadInfo);
        if (this.agf.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.agf.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void cg(View view) {
        String str;
        String str2;
        if (this.agf != null) {
            if (this.agf.bgH()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dF("fid", String.valueOf(this.agf.getFid())).ai("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dF("tid", this.agf.getId());
                aqVar.dF("fid", this.agf.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.agf.bfy() != null && this.agf.bfy().getGodUserData() != null && this.agf.bfy().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").ai("obj_locate", 3).dF("tid", this.agf.getId()));
            }
        }
        if (ceP() != null) {
            ceP().a(view, this.agf);
        }
        if (this.agf != null) {
            com.baidu.tieba.card.m.Hw(this.agf.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ac.Dh(this.agf.getId());
            String valueOf = String.valueOf(this.agf.getFid());
            if (this.agf.egd == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.agf.egd.id;
                str2 = valueOf;
            }
            if (this.agf.bfV() > 0 && com.baidu.tieba.tbadkCore.util.e.dBJ()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ehG.getPageActivity()).createHistoryCfg(this.agf.getTid(), String.valueOf(this.agf.bfV()), false, true, "frs_page");
                String str3 = "frs";
                if (this.iml == 501) {
                    str3 = "frs_tab";
                } else if (this.agf.bgH()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.agf.bgN());
                createHistoryCfg.setSmartFrsPosition(this.agf.bgT());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.hqs) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ehG.getPageActivity()).createFromThreadCfg(this.agf, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.iml == 501) {
                str4 = "frs_tab";
            } else if (this.agf.bgH()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.agf.bgN());
            createFromThreadCfg.setSmartFrsPosition(this.agf.bgT());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.hqs) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.agf = bwVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceZ() {
        this.hqD.removeMessages(202);
        if (this.ZH.getCurrentPosition() > 0) {
            v(false, 3);
            this.hqD.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hqD.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hqD.removeMessages(203);
        int currentPosition = this.ZH.getCurrentPosition();
        if (currentPosition != this.hqw) {
            this.hqw = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.hqD.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.feV != null && this.feU != null && this.feZ != null && this.feY != null && this.feX != null && this.feW != null) {
            if (z || this.ffb != i) {
                this.ffb = i;
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fff);
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ffe);
                if (i == 2) {
                    this.feV.setVisibility(8);
                    this.bDF.cancel();
                    this.feU.clearAnimation();
                    this.feU.setVisibility(0);
                    this.feZ.setVisibility(0);
                    this.hsc.setVisibility(0);
                    this.feY.startLoading();
                    this.feX.setVisibility(8);
                    this.feW.setVisibility(8);
                    com.baidu.adp.lib.f.e.mX().postDelayed(this.fff, 60000L);
                } else if (i == 3) {
                    this.feV.setVisibility(8);
                    this.feU.startAnimation(this.bDF);
                    this.feZ.setVisibility(8);
                    this.hsc.setVisibility(8);
                    this.feY.dnI();
                    this.feX.setVisibility(8);
                    this.feW.setVisibility(8);
                    if (this.agf != null && this.agf.bfQ() != null) {
                        this.agf.bfQ().video_length.intValue();
                        this.agf.bfQ().video_duration.intValue();
                        this.agf.getTid();
                    }
                } else if (i == 4) {
                    this.feV.setVisibility(8);
                    this.feU.startAnimation(this.bDF);
                    this.feZ.setVisibility(8);
                    this.feY.dnJ();
                    this.feX.setVisibility(0);
                    this.feW.setVisibility(0);
                    com.baidu.adp.lib.f.e.mX().postDelayed(this.ffe, 2000L);
                } else {
                    this.feV.setVisibility(0);
                    this.hsc.setVisibility(0);
                    this.bDF.cancel();
                    this.feU.clearAnimation();
                    this.feU.setVisibility(0);
                    this.feZ.setVisibility(0);
                    this.feY.dnJ();
                    this.feX.setVisibility(8);
                    this.feW.setVisibility(8);
                }
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hsD != null) {
            if (bwVar == null) {
                this.hsD.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.efT)) {
                if (this.imj != null && this.imj.cwX() && (this.hsD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsD.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.ehG.getContext(), R.dimen.tbds106);
                    this.hsD.setLayoutParams(layoutParams);
                }
                this.hsD.setVisibility(0);
                this.hsD.setImageDrawable(null);
                this.hsD.startLoad(bwVar.efT, 10, false);
                this.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.ehG != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bwVar.efU, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hsD.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.agf == null || this.agf.bfy() == null) {
            this.gmj.setVisibility(8);
            return;
        }
        this.gmj.setVisibility(0);
        this.gmj.setOnClickListener(this);
        cfc();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.efl)) {
            this.agf.du(this.mUrl, this.efl);
        }
        this.agf.z(false, true);
        SpannableStringBuilder bgi = this.agf.bgi();
        if (this.agf.bgo() && !StringUtils.isNull(this.agf.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bjf().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.agf.getTid();
            bgi.append((CharSequence) this.agf.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dF("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(bgi));
        this.mTextTitle.setText(bgi);
        this.imj.ay(this.agf);
        Y(this.agf);
        this.gmk.setData(this.agf);
        if (this.gmk.getHeaderImg() != null) {
            if (this.gmk.getIsSimpleThread()) {
                this.gmk.getHeaderImg().setVisibility(8);
                this.hqt.setVisibility(8);
            } else if (this.agf.bfy() == null || this.agf.bfy().getPendantData() == null || StringUtils.isNull(this.agf.bfy().getPendantData().bdu())) {
                this.hqt.setVisibility(8);
                this.gmk.getHeaderImg().setVisibility(0);
                this.gmk.getHeaderImg().setData(this.agf);
            } else {
                this.gmk.getHeaderImg().setVisibility(4);
                this.hqt.setVisibility(0);
                this.hqt.setData(this.agf);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gml.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.gml.setLayoutParams(layoutParams);
        this.gmk.setUserAfterClickListener(this.ajn);
        tU(sq(1));
        this.feT.setText(at.stringForVideoTime(this.agf.bfQ().video_duration.intValue() * 1000));
        this.ffa.setText(String.format(this.ehG.getResources().getString(R.string.play_count), at.numFormatOverWan(this.agf.bfQ().play_count.intValue())));
        this.hqs.setData(this.agf.bhb());
        this.hqs.onChangeSkinType();
        if (com.baidu.tieba.card.m.Hx(this.agf.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.hqs.getGodReplyContent(), this.agf.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.agf == null || this.agf.bfQ() == null) {
            z = false;
        } else {
            z = this.agf.bfQ().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hqC.setVisibility(0);
        } else {
            this.hqC.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) && this.gml.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agf.bhj() || this.agf.bhk() || this.agf.bhl()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfb() {
        this.hqD.removeMessages(202);
        this.hqD.removeMessages(203);
    }

    private void byq() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ffe);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fff);
    }

    private void cfc() {
        byq();
        cfb();
        if (this.feU != null && this.feS != null && this.ZH != null) {
            if (k.bcG().isShowImages() && this.agf != null && this.agf.bfQ() != null) {
                this.feS.setVisibility(0);
                this.feU.setPlaceHolder(3);
                this.feU.startLoad(this.agf.bfQ().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.agf.bfQ().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new aq("c12026").dF("tid", this.agf.getId()));
                }
                this.ZH.setThreadDataForStatistic(this.agf);
                return;
            }
            this.feS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gmj, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.feV, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.feW, R.color.cp_cont_a);
            ap.setViewTextColor(this.feT, R.color.cp_cont_a);
            ap.setViewTextColor(this.ffa, R.color.cp_cont_a);
            ap.setBackgroundColor(this.feX, R.color.common_color_10014);
            ap.setBackgroundColor(this.fpN, R.color.cp_bg_line_c);
            if (this.feW != null) {
                this.feW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.gmX != null && this.gmX.getVisibility() == 0) {
                this.gmX.onChangeSkinType();
            }
            this.gml.onChangeSkinType();
            this.mSkinType = i;
            this.gmk.onChangeSkinType();
            if (this.hqt != null && this.hqt.getHeadView() != null && (this.hqt.getHeadView() instanceof TbImageView)) {
                this.hqt.getHeadView().setPlaceHolder(1);
            }
            this.feU.setPlaceHolder(3);
            this.imj.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.currentPageType = i;
        if (this.gml != null) {
            this.gml.ewe = i;
            this.gml.setFrom(2);
        }
        if (this.gmk != null) {
            this.gmk.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.hqx;
    }

    public boolean isPlaying() {
        if (this.ZH == null) {
            return false;
        }
        return this.ZH.isPlaying();
    }

    public void startPlay() {
        if (!this.hqx && this.agf != null && this.agf.bfQ() != null && this.ZH != null) {
            this.ZH.stopPlayback();
            if (ai.bwZ()) {
                if (this.imk || com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dF("obj_locate", "frs").dF("tid", this.agf.getId()));
                        this.mVideoUrl = this.agf.bfQ().video_url;
                    }
                    this.hqx = true;
                    this.ZH.setVideoPath(this.mVideoUrl, this.agf.getId());
                    if (this.fHc != null) {
                        this.fHc.start();
                    }
                    ceV();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceV() {
        if (this.agf != null && this.agf.bfQ() != null) {
            String str = this.agf.bgH() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.iml == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.alA = this.agf.getTid();
            oVar.eYo = this.agf.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.agf.mRecomSource;
            oVar.lCj = this.agf.mRecomAbTag;
            oVar.lCf = this.agf.mRecomAbTag;
            oVar.lCg = this.agf.mRecomWeight;
            oVar.lCh = "";
            oVar.lCk = this.agf.bfQ().video_md5;
            h.a(this.agf.bfQ().video_md5, "", "1", oVar, this.ZH.getPcdnState());
        }
    }

    public void stopPlay() {
        byq();
        cfb();
        v(true, 1);
        if (this.ZH != null) {
            this.ZH.stopPlayback();
            if (this.fHc != null) {
                this.fHc.stop();
            }
        }
        this.hqx = false;
    }

    public View getVideoContainer() {
        return this.feS;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZH == null) {
            return 0;
        }
        return this.ZH.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.ZH != null) {
            this.ZH.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gml != null && this.gmk != null) {
            this.gmk.setPageUniqueId(bdUniqueId);
        }
    }

    public void tU(int i) {
        if (this.agf != null) {
            if (i == 1) {
                this.gml.setVisibility(8);
                this.gmX.setData(this.agf);
                this.gmm.setVisibility(8);
                return;
            }
            this.gml.setData(this.agf);
            this.gmm.setVisibility(8);
            this.gmX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public int sq(int i) {
        return com.baidu.tieba.a.d.bBN().au(this.ahc, i);
    }
}
