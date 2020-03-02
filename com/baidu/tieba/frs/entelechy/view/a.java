package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Canvas;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.play.y;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private QuickVideoView DI;
    private bj KJ;
    private String LC;
    private final View.OnClickListener Nw;
    private Animation aLy;
    private String cTj;
    private TbPageContext<?> cVh;
    private View cem;
    public FrameLayout dLV;
    private TextView dLW;
    private TbImageView dLX;
    private ImageView dLY;
    private TextView dLZ;
    private View dMa;
    private w dMb;
    private View dMc;
    private TextView dMd;
    private int dMe;
    private TbImageView.a dMf;
    private g.b dMg;
    private ViewTreeObserver.OnGlobalLayoutListener dMh;
    private Runnable dMi;
    private Runnable dMj;
    private QuickVideoView.b dMk;
    private g.a dVc;
    private g.f dVd;
    private g.e dVf;
    private final View.OnClickListener dhJ;
    protected ThreadSourceShareAndPraiseLayout eNY;
    private RelativeLayout eNk;
    public ThreadUserInfoLayout eNl;
    public ThreadCommentAndPraiseInfoLayout eNm;
    public View eNn;
    public ThreadSkinView eOj;
    private g eeO;
    public LinearLayout egG;
    private j ekY;
    private Handler fJA;
    private VideoLoadingProgressView.a fJB;
    private j.a fJG;
    private Animation.AnimationListener fJH;
    private ThreadGodReplyLayout fJo;
    private HeadPendantClickableView fJp;
    private int fJt;
    private boolean fJu;
    private TextView fJz;
    private LinearLayout fKW;
    private TbImageView fLx;
    private n fMj;
    public TextView gyi;
    public LinearLayout gyj;
    private i gyk;
    public boolean gyl;
    public int gym;
    private View.OnClickListener gyn;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buN() {
        if (this.eeO != null && this.fJu) {
            try {
                this.DI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fJA.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fJt = 0;
        this.dMe = 1;
        this.fJu = false;
        this.fJA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.buS();
                        return;
                    case 203:
                        a.this.buT();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.eeO = gVar;
                if (a.this.eeO != null) {
                    a.this.eeO.setVolume(0.0f, 0.0f);
                }
                a.this.buN();
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVc = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.DI.start();
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.buU();
                a.this.p(true, 4);
                a.this.fJu = false;
                return true;
            }
        };
        this.fJB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.buN();
            }
        };
        this.dMf = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dLX != null) {
                    a.this.dLX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.dLV != null && a.this.dLV.getLayoutParams() != null && a.this.dLV.getVisibility() != 8) {
                    a.this.dLV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.dLV.getLayoutParams();
                    if (a.this.dLV.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.dLV.getWidth() * 0.5625d);
                        a.this.dLV.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.DI != null && !a.this.DI.isPlaying()) {
                    a.this.p(true, 1);
                }
            }
        };
        this.dMj = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.buU();
                a.this.p(true, 4);
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.gyn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && !StringUtils.isNull(a.this.KJ.aCt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVh.getPageActivity()).createNormalCfg(a.this.KJ.aCt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.dhJ != null) {
                        a.this.dhJ.onClick(view);
                    }
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buG() != null) {
                    a.this.buG().a(view, a.this.KJ);
                }
            }
        };
        this.dhJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && a.this.buG() != null) {
                    a.this.buG().a(view, a.this.KJ);
                }
            }
        };
        this.fJG = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                a.this.buO();
            }
        };
        this.fJH = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dMe == 3 && a.this.dLX != null) {
                    a.this.dLX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.cVh = tbPageContext;
        View view = getView();
        this.cem = view.findViewById(R.id.divider_line);
        this.eNk = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fLx = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.gyj = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNk.setOnClickListener(this);
        this.fJp = (HeadPendantClickableView) this.eNk.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJp.getHeadView() != null) {
            this.fJp.getHeadView().setIsRound(true);
            this.fJp.getHeadView().setDrawBorder(false);
            this.fJp.getHeadView().setDefaultResource(17170445);
            this.fJp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJp.getHeadView().setRadius(l.getDimens(this.cVh.getPageActivity(), R.dimen.ds70));
        }
        this.fJp.setHasPendantStyle();
        if (this.fJp.getPendantView() != null) {
            this.fJp.getPendantView().setIsRound(true);
            this.fJp.getPendantView().setDrawBorder(false);
        }
        this.gyi = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.gyi.setVisibility(8);
        this.gyi.setOnClickListener(this.gyn);
        this.dMb = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dMb.setLoadingAnimationListener(this.fJB);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNm.setForumAfterClickListener(this.dhJ);
        this.eNl = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eNl.setFrom(3);
        this.eNn = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.eNm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNm.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNm.setLayoutParams(layoutParams);
        }
        this.eNm.setOnClickListener(this);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setIsBarViewVisible(false);
        this.eNm.setShareVisible(true);
        this.eNm.setShareReportFrom(1);
        this.eNm.setStType("frs_page");
        this.eNm.setFrom(2);
        this.eNm.dhG = 3;
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eNY.diH.setOnClickListener(this);
        this.eNY.setFrom(2);
        this.eNY.setShareReportFrom(1);
        this.eNY.setSourceFromForPb(3);
        this.eNY.setStType("frs_page");
        this.eNY.setHideBarName(true);
        this.dLV = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dLV.setOnClickListener(this);
        this.dLV.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.dLV != null) {
                    a.this.dLV.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dMh);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.dLV != null) {
                    a.this.dLV.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dMh);
                }
            }
        });
        this.dLX = (TbImageView) view.findViewById(R.id.image_video);
        this.dLX.setPageId(getTag());
        this.dLX.setDefaultErrorResource(0);
        this.dLX.setDrawCorner(true);
        this.dLX.setPlaceHolder(3);
        this.dLX.setEvent(this.dMf);
        this.dLX.setGifIconSupport(false);
        this.dLY = (ImageView) view.findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.fMj = new n(this.cVh.getPageActivity());
        this.DI.setPlayerReuseEnable(true);
        this.DI.setContinuePlayEnable(true);
        this.DI.setBusiness(this.fMj);
        this.DI.setOnPreparedListener(this.dVd);
        this.DI.setOnCompletionListener(this.dVc);
        this.DI.setOnErrorListener(this.dMg);
        this.DI.setOnOutInfoListener(this.dVf);
        this.DI.setOnSurfaceDestroyedListener(this.dMk);
        this.ekY = new j();
        this.ekY.setPlayer(this.DI);
        this.ekY.a(this.fJG);
        this.dMc = view.findViewById(R.id.auto_video_black_mask);
        this.dLZ = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dMa = view.findViewById(R.id.auto_video_error_background);
        this.egG = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eOj = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.aLy = AnimationUtils.loadAnimation(this.cVh.getPageActivity(), R.anim.fade_out_video_cover);
        this.aLy.setAnimationListener(this.fJH);
        this.dLW = (TextView) view.findViewById(R.id.text_video_duration);
        this.dMd = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fKW = (LinearLayout) view.findViewById(R.id.duration_container);
        this.gyk = new i(tbPageContext, this.eNk);
        this.gyk.setUniqueId(getTag());
        this.fJo = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJo.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eNm != null) {
                    a.this.eNm.changeSelectStatus();
                }
            }
        });
        this.eNm.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.fJz = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNk || view == this.eNm.getCommentNumView() || view == this.gyj) {
            bH(this.eNk);
        } else if (view == this.dLV) {
            if (this.KJ != null && this.KJ.aCF() != null) {
                z = this.KJ.aCF().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bQ(this.dLV);
                } else {
                    bH(this.dLV);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bQ(this.dLV);
            } else {
                bH(this.dLV);
            }
        } else if (view == this.fJo) {
            bH(this.fJo);
        }
        if (this.KJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.KJ));
        }
    }

    private void bF(View view) {
        if (buG() != null) {
            buG().a(view, this.KJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.cVh.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buP();
        }
    }

    private void buP() {
        if (this.KJ != null) {
            String str = "frs";
            if (this.gym == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.KJ);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.KJ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.KJ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (this.KJ != null) {
            an anVar = new an("c11100");
            anVar.cy("tid", this.KJ.getId());
            anVar.cy("fid", this.KJ.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (buG() != null) {
            buG().a(view, this.KJ);
        }
        if (view == this.dLV) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                buQ();
            }
        }
    }

    private void buQ() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.KJ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.egG.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.egG.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.gym == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVh.getPageActivity(), str, this.KJ.getTid(), com.baidu.tieba.card.l.aCa(), "", videoSerializeVideoThreadInfo);
        if (this.KJ.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.KJ.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bH(View view) {
        String str;
        String str2;
        if (this.KJ != null) {
            if (this.KJ.aDt()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cy("fid", String.valueOf(this.KJ.getFid())).X("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cy("tid", this.KJ.getId());
                anVar.cy("fid", this.KJ.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.KJ.aCo() != null && this.KJ.aCo().getGodUserData() != null && this.KJ.aCo().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").X("obj_locate", 3).cy("tid", this.KJ.getId()));
            }
        }
        if (buG() != null) {
            buG().a(view, this.KJ);
        }
        if (this.KJ != null) {
            com.baidu.tieba.card.l.zS(this.KJ.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.vW(this.KJ.getId());
            String valueOf = String.valueOf(this.KJ.getFid());
            if (this.KJ.cUa == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.KJ.cUa.id;
                str2 = valueOf;
            }
            if (this.KJ.aCK() > 0 && com.baidu.tieba.tbadkCore.util.e.cMc()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.cVh.getPageActivity()).createHistoryCfg(this.KJ.getTid(), String.valueOf(this.KJ.aCK()), false, true, "frs_page");
                String str3 = "frs";
                if (this.gym == 501) {
                    str3 = "frs_tab";
                } else if (this.KJ.aDt()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.KJ.aDz());
                createHistoryCfg.setSmartFrsPosition(this.KJ.aDE());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.fJo) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.cVh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.cVh.getPageActivity()).createFromThreadCfg(this.KJ, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.gym == 501) {
                str4 = "frs_tab";
            } else if (this.KJ.aDt()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.KJ.aDz());
            createFromThreadCfg.setSmartFrsPosition(this.KJ.aDE());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.fJo) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.cVh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.KJ = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buS() {
        this.fJA.removeMessages(202);
        if (this.DI.getCurrentPosition() > 0) {
            p(false, 3);
            this.fJA.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fJA.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fJA.removeMessages(203);
        int currentPosition = this.DI.getCurrentPosition();
        if (currentPosition != this.fJt) {
            this.fJt = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fJA.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dLY != null && this.dLX != null && this.dMc != null && this.dMb != null && this.dMa != null && this.dLZ != null) {
            if (z || this.dMe != i) {
                this.dMe = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMj);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
                if (i == 2) {
                    this.dLY.setVisibility(8);
                    this.aLy.cancel();
                    this.dLX.clearAnimation();
                    this.dLX.setVisibility(0);
                    this.dMc.setVisibility(0);
                    this.fKW.setVisibility(0);
                    this.dMb.startLoading();
                    this.dMa.setVisibility(8);
                    this.dLZ.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMj, 60000L);
                } else if (i == 3) {
                    this.dLY.setVisibility(8);
                    this.dLX.startAnimation(this.aLy);
                    this.dMc.setVisibility(8);
                    this.fKW.setVisibility(8);
                    this.dMb.czo();
                    this.dMa.setVisibility(8);
                    this.dLZ.setVisibility(8);
                    if (this.KJ != null && this.KJ.aCF() != null) {
                        this.KJ.aCF().video_length.intValue();
                        this.KJ.aCF().video_duration.intValue();
                        this.KJ.getTid();
                    }
                } else if (i == 4) {
                    this.dLY.setVisibility(8);
                    this.dLX.startAnimation(this.aLy);
                    this.dMc.setVisibility(8);
                    this.dMb.czp();
                    this.dMa.setVisibility(0);
                    this.dLZ.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMi, 2000L);
                } else {
                    this.dLY.setVisibility(0);
                    this.fKW.setVisibility(0);
                    this.aLy.cancel();
                    this.dLX.clearAnimation();
                    this.dLX.setVisibility(0);
                    this.dMc.setVisibility(0);
                    this.dMb.czp();
                    this.dMa.setVisibility(8);
                    this.dLZ.setVisibility(8);
                }
            }
        }
    }

    private void X(final bj bjVar) {
        if (this.fLx != null) {
            if (bjVar == null) {
                this.fLx.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTR)) {
                if (this.gyk != null && this.gyk.bKP() && (this.fLx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLx.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.cVh.getContext(), R.dimen.tbds106);
                    this.fLx.setLayoutParams(layoutParams);
                }
                this.fLx.setVisibility(0);
                this.fLx.setImageDrawable(null);
                this.fLx.startLoad(bjVar.cTR, 10, false);
                this.fLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.cVh != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.cTS, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLx.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.KJ == null || this.KJ.aCo() == null) {
            this.eNk.setVisibility(8);
            return;
        }
        this.eNk.setVisibility(0);
        this.eNk.setOnClickListener(this);
        buV();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTj)) {
            this.KJ.cp(this.mUrl, this.cTj);
        }
        this.KJ.s(false, true);
        SpannableStringBuilder aCV = this.KJ.aCV();
        if (this.KJ.aDb() && !StringUtils.isNull(this.KJ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.KJ.getTid();
            aCV.append((CharSequence) this.KJ.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cy("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aCV));
        this.mTextTitle.setText(aCV);
        this.gyk.ax(this.KJ);
        X(this.KJ);
        this.eNl.setData(this.KJ);
        if (this.eNl.getHeaderImg() != null) {
            if (this.eNl.getIsSimpleThread()) {
                this.eNl.getHeaderImg().setVisibility(8);
                this.fJp.setVisibility(8);
            } else if (this.KJ.aCo() == null || this.KJ.aCo().getPendantData() == null || StringUtils.isNull(this.KJ.aCo().getPendantData().aAG())) {
                this.fJp.setVisibility(8);
                this.eNl.getHeaderImg().setVisibility(0);
                this.eNl.getHeaderImg().setData(this.KJ);
            } else {
                this.eNl.getHeaderImg().setVisibility(4);
                this.fJp.setVisibility(0);
                this.fJp.setData(this.KJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNm.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.eNm.setLayoutParams(layoutParams);
        this.eNl.setUserAfterClickListener(this.Nw);
        pB(oc(1));
        this.dLW.setText(aq.stringForVideoTime(this.KJ.aCF().video_duration.intValue() * 1000));
        this.dMd.setText(String.format(this.cVh.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.KJ.aCF().play_count.intValue())));
        this.fJo.setData(this.KJ.aDM());
        this.fJo.onChangeSkinType();
        if (com.baidu.tieba.card.l.zT(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.fJo.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.KJ == null || this.KJ.aCF() == null) {
            z = false;
        } else {
            z = this.KJ.aCF().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fJz.setVisibility(0);
        } else {
            this.fJz.setVisibility(8);
        }
        if (this.eNm.isInFrsAllThread() && com.baidu.tieba.frs.a.bCV().bCW()) {
            this.mMaskView.setVisibility(0);
            if (this.KJ.aDV() || this.KJ.aDW()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        this.fJA.removeMessages(202);
        this.fJA.removeMessages(203);
    }

    private void aTC() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMj);
    }

    private void buV() {
        aTC();
        buU();
        if (this.dLX != null && this.dLV != null && this.DI != null) {
            if (com.baidu.tbadk.core.i.azO().isShowImages() && this.KJ != null && this.KJ.aCF() != null) {
                this.dLV.setVisibility(0);
                this.dLX.setPlaceHolder(3);
                this.dLX.startLoad(this.KJ.aCF().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.KJ.aCF().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                    TiebaStatic.log(new an("c12026").cy("tid", this.KJ.getId()));
                }
                if (this.fMj != null && this.fMj.cyZ() != null) {
                    this.fMj.cyZ().aj(this.KJ);
                    return;
                }
                return;
            }
            this.dLV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNk, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLY, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dLZ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dLW, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMd, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMa, R.color.common_color_10014);
            am.setBackgroundColor(this.cem, R.color.cp_bg_line_c);
            if (this.dLZ != null) {
                this.dLZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.eNY != null && this.eNY.getVisibility() == 0) {
                this.eNY.onChangeSkinType();
            }
            this.eNm.onChangeSkinType();
            this.mSkinType = i;
            this.eNl.onChangeSkinType();
            if (this.fJp != null && this.fJp.getHeadView() != null && (this.fJp.getHeadView() instanceof TbImageView)) {
                this.fJp.getHeadView().setPlaceHolder(1);
            }
            this.dLX.setPlaceHolder(3);
            this.gyk.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.currentPageType = i;
        if (this.eNm != null) {
            this.eNm.dhG = i;
            this.eNm.setFrom(2);
        }
        if (this.eNl != null) {
            this.eNl.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.fJu;
    }

    public boolean isPlaying() {
        if (this.DI == null) {
            return false;
        }
        return this.DI.isPlaying();
    }

    public void startPlay() {
        if (!this.fJu && this.KJ != null && this.KJ.aCF() != null && this.DI != null) {
            this.DI.stopPlayback();
            if (af.aSw()) {
                if (this.gyl || com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    p(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cy("obj_locate", "frs").cy("tid", this.KJ.getId()));
                        this.mVideoUrl = this.KJ.aCF().video_url;
                    }
                    this.fJu = true;
                    this.DI.setVideoPath(this.mVideoUrl, this.KJ.getId());
                    if (this.ekY != null) {
                        this.ekY.start();
                    }
                    buO();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.KJ != null && this.KJ.aCF() != null) {
            String str = this.KJ.aDt() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.KJ.aCs()) {
                str = "frs_mcn";
            }
            if (this.gym == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.Pj = this.KJ.getTid();
            yVar.emb = this.KJ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.KJ.mRecomSource;
            yVar.mAbTag = this.KJ.mRecomAbTag;
            yVar.jwG = this.KJ.mRecomAbTag;
            yVar.jwH = this.KJ.mRecomWeight;
            yVar.jwI = "";
            yVar.jwK = this.KJ.aCF().video_md5;
            com.baidu.tieba.play.l.a(this.KJ.aCF().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aTC();
        buU();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
            if (this.ekY != null) {
                this.ekY.stop();
            }
        }
        this.fJu = false;
    }

    public View getVideoContainer() {
        return this.dLV;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.DI == null) {
            return 0;
        }
        return this.DI.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.fMj != null) {
            this.fMj.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNm != null && this.eNl != null) {
            this.eNl.setPageUniqueId(bdUniqueId);
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNm.setVisibility(8);
                this.eNY.setData(this.KJ);
                this.eNn.setVisibility(8);
                return;
            }
            this.eNm.setData(this.KJ);
            this.eNn.setVisibility(8);
            this.eNY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dLX.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dLX.setOnDrawListener(null);
        }
    }
}
