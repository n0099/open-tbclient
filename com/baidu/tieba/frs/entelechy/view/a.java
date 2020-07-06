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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<bu> implements com.baidu.tieba.a.e, y {
    private QuickVideoView XX;
    private bu aeK;
    private String afG;
    private final View.OnClickListener ahM;
    private Animation btX;
    private String dNq;
    private TbPageContext<?> dPv;
    public FrameLayout eKT;
    private TextView eKU;
    private TbImageView eKV;
    private ImageView eKW;
    private TextView eKX;
    private View eKY;
    private w eKZ;
    private View eLa;
    private TextView eLb;
    private int eLc;
    private TbImageView.a eLd;
    private g.b eLe;
    private ViewTreeObserver.OnGlobalLayoutListener eLf;
    private Runnable eLg;
    private Runnable eLh;
    private QuickVideoView.b eLi;
    private g.a eUI;
    private g.f eUJ;
    private g.e eUL;
    private View eVD;
    private final View.OnClickListener edU;
    private RelativeLayout fRG;
    public ThreadUserInfoLayout fRH;
    public ThreadCommentAndPraiseInfoLayout fRI;
    public View fRJ;
    public ThreadSkinView fSF;
    protected ThreadSourceShareAndPraiseLayout fSu;
    public LinearLayout fdX;
    private j fni;
    private ThreadGodReplyLayout gQM;
    private HeadPendantClickableView gQN;
    private int gQR;
    private boolean gQS;
    private TextView gQX;
    private Handler gQY;
    private VideoLoadingProgressView.a gQZ;
    private j.a gRe;
    private Animation.AnimationListener gRf;
    private TbImageView gSY;
    private LinearLayout gSx;
    private n gTR;
    public TextView hKP;
    public LinearLayout hKQ;
    private g hKR;
    private i hKS;
    public boolean hKT;
    public int hKU;
    private View.OnClickListener hKV;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bOi() {
        if (this.hKR != null && this.gQS) {
            try {
                this.XX.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gQY.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gQR = 0;
        this.eLc = 1;
        this.gQS = false;
        this.gQY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bOn();
                        return;
                    case 203:
                        a.this.bOo();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.hKR = gVar;
                if (a.this.hKR != null) {
                    a.this.hKR.setVolume(0.0f, 0.0f);
                }
                a.this.bOi();
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.XX.start();
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bOp();
                a.this.v(true, 4);
                a.this.gQS = false;
                return true;
            }
        };
        this.gQZ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bOi();
            }
        };
        this.eLd = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.eKV != null) {
                    a.this.eKV.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eLf = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.eKT != null && a.this.eKT.getLayoutParams() != null && a.this.eKT.getVisibility() != 8) {
                    a.this.eKT.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.eKT.getLayoutParams();
                    if (a.this.eKT.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.eKT.getWidth() * 0.5625d);
                        a.this.eKT.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eLg = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.XX != null && !a.this.XX.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.eLh = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bOp();
                a.this.v(true, 4);
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.hKV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aeK != null && !StringUtils.isNull(a.this.aeK.aSt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dPv.getPageActivity()).createNormalCfg(a.this.aeK.aSt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.edU != null) {
                        a.this.edU.onClick(view);
                    }
                }
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bOd() != null) {
                    a.this.bOd().a(view, a.this.aeK);
                }
            }
        };
        this.edU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aeK != null && a.this.bOd() != null) {
                    a.this.bOd().a(view, a.this.aeK);
                }
            }
        };
        this.gRe = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qx() {
                a.this.bOj();
            }
        };
        this.gRf = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.eLc == 3 && a.this.eKV != null) {
                    a.this.eKV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.dPv = tbPageContext;
        View view = getView();
        this.eVD = view.findViewById(R.id.divider_line);
        this.fRG = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gSY = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.hKQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fRG.setOnClickListener(this);
        this.gQN = (HeadPendantClickableView) this.fRG.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gQN.getHeadView() != null) {
            this.gQN.getHeadView().setIsRound(true);
            this.gQN.getHeadView().setDrawBorder(false);
            this.gQN.getHeadView().setDefaultResource(17170445);
            this.gQN.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gQN.getHeadView().setRadius(l.getDimens(this.dPv.getPageActivity(), R.dimen.ds70));
        }
        this.gQN.setHasPendantStyle();
        if (this.gQN.getPendantView() != null) {
            this.gQN.getPendantView().setIsRound(true);
            this.gQN.getPendantView().setDrawBorder(false);
        }
        this.hKP = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.hKP.setVisibility(8);
        this.hKP.setOnClickListener(this.hKV);
        this.eKZ = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eKZ.setLoadingAnimationListener(this.gQZ);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fRI.setForumAfterClickListener(this.edU);
        this.fRH = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fRH.setFrom(3);
        this.fRJ = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.fRI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fRI.setLayoutParams(layoutParams);
        }
        this.fRI.setOnClickListener(this);
        this.fRI.setReplyTimeVisible(false);
        this.fRI.setShowPraiseNum(true);
        this.fRI.setNeedAddPraiseIcon(true);
        this.fRI.setNeedAddReplyIcon(true);
        this.fRI.setIsBarViewVisible(false);
        this.fRI.setShareVisible(true);
        this.fRI.setShareReportFrom(1);
        this.fRI.setStType("frs_page");
        this.fRI.setFrom(2);
        this.fRI.edR = 3;
        this.fSu = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fSu.eeP.setOnClickListener(this);
        this.fSu.setFrom(2);
        this.fSu.setShareReportFrom(1);
        this.fSu.setSourceFromForPb(3);
        this.fSu.setStType("frs_page");
        this.fSu.setHideBarName(true);
        this.eKT = (FrameLayout) view.findViewById(R.id.frame_video);
        this.eKT.setOnClickListener(this);
        this.eKT.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.eKT != null) {
                    a.this.eKT.getViewTreeObserver().addOnGlobalLayoutListener(a.this.eLf);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.eKT != null) {
                    a.this.eKT.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.eLf);
                }
            }
        });
        this.eKV = (TbImageView) view.findViewById(R.id.image_video);
        this.eKV.setPageId(getTag());
        this.eKV.setDefaultErrorResource(0);
        this.eKV.setDrawCorner(true);
        this.eKV.setPlaceHolder(3);
        this.eKV.setEvent(this.eLd);
        this.eKV.setGifIconSupport(false);
        this.eKW = (ImageView) view.findViewById(R.id.image_video_play);
        this.XX = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.gTR = new n(this.dPv.getPageActivity());
        this.XX.setContinuePlayEnable(true);
        this.XX.setBusiness(this.gTR);
        this.XX.setOnPreparedListener(this.eUJ);
        this.XX.setOnCompletionListener(this.eUI);
        this.XX.setOnErrorListener(this.eLe);
        this.XX.setOnOutInfoListener(this.eUL);
        this.XX.setOnSurfaceDestroyedListener(this.eLi);
        this.fni = new j();
        this.fni.setPlayer(this.XX);
        this.fni.a(this.gRe);
        this.eLa = view.findViewById(R.id.auto_video_black_mask);
        this.eKX = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eKY = view.findViewById(R.id.auto_video_error_background);
        this.fdX = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fSF = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.btX = AnimationUtils.loadAnimation(this.dPv.getPageActivity(), R.anim.fade_out_video_cover);
        this.btX.setAnimationListener(this.gRf);
        this.eKU = (TextView) view.findViewById(R.id.text_video_duration);
        this.eLb = (TextView) view.findViewById(R.id.text_video_play_count);
        this.gSx = (LinearLayout) view.findViewById(R.id.duration_container);
        this.hKS = new i(tbPageContext, this.fRG);
        this.hKS.setUniqueId(getTag());
        this.gQM = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gQM.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.fRI != null) {
                    a.this.fRI.changeSelectStatus();
                }
            }
        });
        this.fRI.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hy(boolean z) {
                if (a.this.mMaskView != null) {
                    an.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.gQX = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fRG || view == this.fRI.getCommentNumView() || view == this.hKQ) {
            bP(this.fRG);
        } else if (view == this.eKT) {
            if (this.aeK != null && this.aeK.aSH() != null) {
                z = this.aeK.aSH().is_vertical.intValue() == 1;
            }
            if (z) {
                bN(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bZ(this.eKT);
            } else {
                bP(this.eKT);
            }
        } else if (view == this.gQM) {
            bP(this.gQM);
        }
        if (this.aeK != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aeK));
        }
    }

    private void bN(View view) {
        if (bOd() != null) {
            bOd().a(view, this.aeK);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.dPv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bOk();
        }
    }

    private void bOk() {
        if (this.aeK != null) {
            String str = "frs";
            if (this.hKU == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aeK);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.aeK.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.aeK.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bZ(View view) {
        if (this.aeK != null) {
            ao aoVar = new ao("c11100");
            aoVar.dk("tid", this.aeK.getId());
            aoVar.dk("fid", this.aeK.getFid() + "");
            TiebaStatic.log(aoVar);
        }
        if (bOd() != null) {
            bOd().a(view, this.aeK);
        }
        if (view == this.eKT) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bOl();
            }
        }
    }

    private void bOl() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aeK);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fdX.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fdX.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.hKU == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.dPv.getPageActivity(), str, this.aeK.getTid(), m.aSb(), "", videoSerializeVideoThreadInfo);
        if (this.aeK.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.aeK.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bP(View view) {
        String str;
        String str2;
        if (this.aeK != null) {
            if (this.aeK.aTy()) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dk("fid", String.valueOf(this.aeK.getFid())).ag("obj_type", 2));
            } else {
                ao aoVar = new ao("c11100");
                aoVar.dk("tid", this.aeK.getId());
                aoVar.dk("fid", this.aeK.getFid() + "");
                TiebaStatic.log(aoVar);
            }
            if (this.aeK.aSp() != null && this.aeK.aSp().getGodUserData() != null && this.aeK.aSp().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ao("c10806").ag("obj_locate", 3).dk("tid", this.aeK.getId()));
            }
        }
        if (bOd() != null) {
            bOd().a(view, this.aeK);
        }
        if (this.aeK != null) {
            m.DO(this.aeK.getId());
            an.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ab.zm(this.aeK.getId());
            String valueOf = String.valueOf(this.aeK.getFid());
            if (this.aeK.dOi == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aeK.dOi.id;
                str2 = valueOf;
            }
            if (this.aeK.aSM() > 0 && com.baidu.tieba.tbadkCore.util.e.djh()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.dPv.getPageActivity()).createHistoryCfg(this.aeK.getTid(), String.valueOf(this.aeK.aSM()), false, true, "frs_page");
                String str3 = "frs";
                if (this.hKU == 501) {
                    str3 = "frs_tab";
                } else if (this.aeK.aTy()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aeK.aTE());
                createHistoryCfg.setSmartFrsPosition(this.aeK.aTK());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.gQM) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.dPv.getPageActivity()).createFromThreadCfg(this.aeK, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.hKU == 501) {
                str4 = "frs_tab";
            } else if (this.aeK.aTy()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aeK.aTE());
            createFromThreadCfg.setSmartFrsPosition(this.aeK.aTK());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.gQM) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bu buVar) {
        this.aeK = buVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOn() {
        this.gQY.removeMessages(202);
        if (this.XX.getCurrentPosition() > 0) {
            v(false, 3);
            this.gQY.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gQY.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOo() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gQY.removeMessages(203);
        int currentPosition = this.XX.getCurrentPosition();
        if (currentPosition != this.gQR) {
            this.gQR = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.gQY.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.eKW != null && this.eKV != null && this.eLa != null && this.eKZ != null && this.eKY != null && this.eKX != null) {
            if (z || this.eLc != i) {
                this.eLc = i;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLh);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLg);
                if (i == 2) {
                    this.eKW.setVisibility(8);
                    this.btX.cancel();
                    this.eKV.clearAnimation();
                    this.eKV.setVisibility(0);
                    this.eLa.setVisibility(0);
                    this.gSx.setVisibility(0);
                    this.eKZ.startLoading();
                    this.eKY.setVisibility(8);
                    this.eKX.setVisibility(8);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eLh, 60000L);
                } else if (i == 3) {
                    this.eKW.setVisibility(8);
                    this.eKV.startAnimation(this.btX);
                    this.eLa.setVisibility(8);
                    this.gSx.setVisibility(8);
                    this.eKZ.cVS();
                    this.eKY.setVisibility(8);
                    this.eKX.setVisibility(8);
                    if (this.aeK != null && this.aeK.aSH() != null) {
                        this.aeK.aSH().video_length.intValue();
                        this.aeK.aSH().video_duration.intValue();
                        this.aeK.getTid();
                    }
                } else if (i == 4) {
                    this.eKW.setVisibility(8);
                    this.eKV.startAnimation(this.btX);
                    this.eLa.setVisibility(8);
                    this.eKZ.cVT();
                    this.eKY.setVisibility(0);
                    this.eKX.setVisibility(0);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eLg, 2000L);
                } else {
                    this.eKW.setVisibility(0);
                    this.gSx.setVisibility(0);
                    this.btX.cancel();
                    this.eKV.clearAnimation();
                    this.eKV.setVisibility(0);
                    this.eLa.setVisibility(0);
                    this.eKZ.cVT();
                    this.eKY.setVisibility(8);
                    this.eKX.setVisibility(8);
                }
            }
        }
    }

    private void aa(final bu buVar) {
        if (this.gSY != null) {
            if (buVar == null) {
                this.gSY.setVisibility(8);
            } else if (!StringUtils.isNull(buVar.dNY)) {
                if (this.hKS != null && this.hKS.cfB() && (this.gSY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSY.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.dPv.getContext(), R.dimen.tbds106);
                    this.gSY.setLayoutParams(layoutParams);
                }
                this.gSY.setVisibility(0);
                this.gSY.setImageDrawable(null);
                this.gSY.startLoad(buVar.dNY, 10, false);
                this.gSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.dPv != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", buVar.dNZ, true)));
                        }
                        TiebaStatic.log(new ao(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gSY.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aeK == null || this.aeK.aSp() == null) {
            this.fRG.setVisibility(8);
            return;
        }
        this.fRG.setVisibility(0);
        this.fRG.setOnClickListener(this);
        bOq();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dNq)) {
            this.aeK.db(this.mUrl, this.dNq);
        }
        this.aeK.v(false, true);
        SpannableStringBuilder aSZ = this.aeK.aSZ();
        if (this.aeK.aTf() && !StringUtils.isNull(this.aeK.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aeK.getTid();
            aSZ.append((CharSequence) this.aeK.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ao("c12841").dk("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(aSZ));
        this.mTextTitle.setText(aSZ);
        this.hKS.aA(this.aeK);
        aa(this.aeK);
        this.fRH.setData(this.aeK);
        if (this.fRH.getHeaderImg() != null) {
            if (this.fRH.getIsSimpleThread()) {
                this.fRH.getHeaderImg().setVisibility(8);
                this.gQN.setVisibility(8);
            } else if (this.aeK.aSp() == null || this.aeK.aSp().getPendantData() == null || StringUtils.isNull(this.aeK.aSp().getPendantData().aQl())) {
                this.gQN.setVisibility(8);
                this.fRH.getHeaderImg().setVisibility(0);
                this.fRH.getHeaderImg().setData(this.aeK);
            } else {
                this.fRH.getHeaderImg().setVisibility(4);
                this.gQN.setVisibility(0);
                this.gQN.setData(this.aeK);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRI.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.fRI.setLayoutParams(layoutParams);
        this.fRH.setUserAfterClickListener(this.ahM);
        qZ(pz(1));
        this.eKU.setText(ar.stringForVideoTime(this.aeK.aSH().video_duration.intValue() * 1000));
        this.eLb.setText(String.format(this.dPv.getResources().getString(R.string.play_count), ar.numFormatOverWan(this.aeK.aSH().play_count.intValue())));
        this.gQM.setData(this.aeK.aTS());
        this.gQM.onChangeSkinType();
        if (m.DP(this.aeK.getId())) {
            an.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            m.a(this.gQM.getGodReplyContent(), this.aeK.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            an.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.aeK == null || this.aeK.aSH() == null) {
            z = false;
        } else {
            z = this.aeK.aSH().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gQX.setVisibility(0);
        } else {
            this.gQX.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) && this.fRI.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aeK.aUa() || this.aeK.aUb() || this.aeK.aUc()) {
                an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOp() {
        this.gQY.removeMessages(202);
        this.gQY.removeMessages(203);
    }

    private void bkz() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLg);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLh);
    }

    private void bOq() {
        bkz();
        bOp();
        if (this.eKV != null && this.eKT != null && this.XX != null) {
            if (k.aPA().isShowImages() && this.aeK != null && this.aeK.aSH() != null) {
                this.eKT.setVisibility(0);
                this.eKV.setPlaceHolder(3);
                this.eKV.startLoad(this.aeK.aSH().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aeK.aSH().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new ao("c12026").dk("tid", this.aeK.getId()));
                }
                if (this.gTR != null && this.gTR.cVD() != null) {
                    this.gTR.cVD().an(this.aeK);
                    return;
                }
                return;
            }
            this.eKT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fRG, R.drawable.addresslist_item_bg);
            an.setImageResource(this.eKW, R.drawable.btn_icon_play_video_n);
            an.setViewTextColor(this.eKX, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.eKU, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.eLb, (int) R.color.cp_cont_a);
            an.setBackgroundColor(this.eKY, R.color.common_color_10014);
            an.setBackgroundColor(this.eVD, R.color.cp_bg_line_c);
            if (this.eKX != null) {
                this.eKX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.fSu != null && this.fSu.getVisibility() == 0) {
                this.fSu.onChangeSkinType();
            }
            this.fRI.onChangeSkinType();
            this.mSkinType = i;
            this.fRH.onChangeSkinType();
            if (this.gQN != null && this.gQN.getHeadView() != null && (this.gQN.getHeadView() instanceof TbImageView)) {
                this.gQN.getHeadView().setPlaceHolder(1);
            }
            this.eKV.setPlaceHolder(3);
            this.hKS.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.currentPageType = i;
        if (this.fRI != null) {
            this.fRI.edR = i;
            this.fRI.setFrom(2);
        }
        if (this.fRH != null) {
            this.fRH.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.gQS;
    }

    public boolean isPlaying() {
        if (this.XX == null) {
            return false;
        }
        return this.XX.isPlaying();
    }

    public void startPlay() {
        if (!this.gQS && this.aeK != null && this.aeK.aSH() != null && this.XX != null) {
            this.XX.stopPlayback();
            if (ag.bji()) {
                if (this.hKT || com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new ao("c12619").dk("obj_locate", "frs").dk("tid", this.aeK.getId()));
                        this.mVideoUrl = this.aeK.aSH().video_url;
                    }
                    this.gQS = true;
                    this.XX.setVideoPath(this.mVideoUrl, this.aeK.getId());
                    if (this.fni != null) {
                        this.fni.start();
                    }
                    bOj();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOj() {
        if (this.aeK != null && this.aeK.aSH() != null) {
            String str = this.aeK.aTy() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.hKU == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.ajO = this.aeK.getTid();
            yVar.eEs = this.aeK.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.aeK.mRecomSource;
            yVar.kVs = this.aeK.mRecomAbTag;
            yVar.kVo = this.aeK.mRecomAbTag;
            yVar.kVp = this.aeK.mRecomWeight;
            yVar.kVq = "";
            yVar.kVt = this.aeK.aSH().video_md5;
            com.baidu.tieba.play.l.a(this.aeK.aSH().video_md5, "", "1", yVar, this.XX.getPcdnState());
        }
    }

    public void stopPlay() {
        bkz();
        bOp();
        v(true, 1);
        if (this.XX != null) {
            this.XX.stopPlayback();
            if (this.fni != null) {
                this.fni.stop();
            }
        }
        this.gQS = false;
    }

    public View getVideoContainer() {
        return this.eKT;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.XX == null) {
            return 0;
        }
        return this.XX.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.gTR != null) {
            this.gTR.setVideoStatsData(yVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fRI != null && this.fRH != null) {
            this.fRH.setPageUniqueId(bdUniqueId);
        }
    }

    public void qZ(int i) {
        if (this.aeK != null) {
            if (i == 1) {
                this.fRI.setVisibility(8);
                this.fSu.setData(this.aeK);
                this.fRJ.setVisibility(8);
                return;
            }
            this.fRI.setData(this.aeK);
            this.fRJ.setVisibility(8);
            this.fSu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public int pz(int i) {
        return com.baidu.tieba.a.d.boB().as(this.afG, i);
    }
}
