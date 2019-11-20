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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private QuickVideoView AC;
    private bh Fs;
    private String Gc;
    private final View.OnClickListener Ho;
    private Animation ayO;
    private Runnable cTA;
    private Runnable cTB;
    private QuickVideoView.b cTC;
    public FrameLayout cTn;
    private TextView cTo;
    private TbImageView cTp;
    private ImageView cTq;
    private TextView cTr;
    private View cTs;
    private x cTt;
    private View cTu;
    private TextView cTv;
    private int cTw;
    private TbImageView.a cTx;
    private g.b cTy;
    private ViewTreeObserver.OnGlobalLayoutListener cTz;
    private String ccw;
    private TbPageContext<?> ceu;
    private String cln;
    private final View.OnClickListener coV;
    public ThreadCommentAndPraiseInfoLayout dSA;
    public View dSB;
    private RelativeLayout dSy;
    public ThreadUserInfoLayout dSz;
    public ThreadSkinView dTA;
    protected ThreadSourceShareAndPraiseLayout dTo;
    public LinearLayout dTz;
    private g.a dcS;
    private g.f dcT;
    private g.e dcV;
    private View ddZ;
    private g dqC;
    private j dvH;
    private ThreadGodReplyLayout eLP;
    private HeadPendantClickableView eLQ;
    private int eLU;
    private boolean eLV;
    private TextView eMa;
    private Handler eMb;
    private VideoLoadingProgressView.a eMc;
    private j.a eMh;
    private Animation.AnimationListener eMi;
    private LinearLayout eNy;
    private n eOM;
    private TbImageView eOb;
    public TextView fED;
    public LinearLayout fEE;
    private com.baidu.tieba.frs.vc.g fEF;
    public boolean fEG;
    public int fEH;
    private View.OnClickListener fEI;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.dqC != null && this.eLV) {
            try {
                this.AC.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eMb.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eLU = 0;
        this.cTw = 1;
        this.eLV = false;
        this.eMb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bag();
                        return;
                    case 203:
                        a.this.bah();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.dqC = gVar;
                if (a.this.dqC != null) {
                    a.this.dqC.setVolume(0.0f, 0.0f);
                }
                a.this.bab();
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.j(false, 3);
                }
                return false;
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.AC.start();
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bai();
                a.this.j(true, 4);
                a.this.eLV = false;
                return true;
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bab();
            }
        };
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.cTp != null) {
                    a.this.cTp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cTz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cTn != null && a.this.cTn.getLayoutParams() != null && a.this.cTn.getVisibility() != 8) {
                    a.this.cTn.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cTn.getLayoutParams();
                    if (a.this.cTn.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cTn.getWidth() * 0.5625d);
                        a.this.cTn.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cTA = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.AC != null && !a.this.AC.isPlaying()) {
                    a.this.j(true, 1);
                }
            }
        };
        this.cTB = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bai();
                a.this.j(true, 4);
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fEI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Fs != null && !StringUtils.isNull(a.this.Fs.aiJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.ceu.getPageActivity()).createNormalCfg(a.this.Fs.aiJ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.coV != null) {
                        a.this.coV.onClick(view);
                    }
                }
            }
        };
        this.Ho = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.Fs);
                }
            }
        };
        this.coV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Fs != null && a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.Fs);
                }
            }
        };
        this.eMh = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void kP() {
                a.this.bac();
            }
        };
        this.eMi = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cTw == 3 && a.this.cTp != null) {
                    a.this.cTp.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.ceu = tbPageContext;
        View view = getView();
        this.ddZ = view.findViewById(R.id.divider_line);
        this.dSy = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eOb = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.fEE = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dSy.setOnClickListener(this);
        this.eLQ = (HeadPendantClickableView) this.dSy.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eLQ.getHeadView() != null) {
            this.eLQ.getHeadView().setIsRound(true);
            this.eLQ.getHeadView().setDrawBorder(false);
            this.eLQ.getHeadView().setDefaultResource(17170445);
            this.eLQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eLQ.getHeadView().setRadius(l.getDimens(this.ceu.getPageActivity(), R.dimen.ds70));
        }
        this.eLQ.setHasPendantStyle();
        if (this.eLQ.getPendantView() != null) {
            this.eLQ.getPendantView().setIsRound(true);
            this.eLQ.getPendantView().setDrawBorder(false);
        }
        this.fED = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fED.setVisibility(8);
        this.fED.setOnClickListener(this.fEI);
        this.cTt = new x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cTt.setLoadingAnimationListener(this.eMc);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dSA.setForumAfterClickListener(this.coV);
        this.dSz = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dSz.setFrom(3);
        this.dSB = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.dSA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dSA.setLayoutParams(layoutParams);
        }
        this.dSA.setOnClickListener(this);
        this.dSA.setReplyTimeVisible(false);
        this.dSA.setShowPraiseNum(true);
        this.dSA.setNeedAddPraiseIcon(true);
        this.dSA.setNeedAddReplyIcon(true);
        this.dSA.setIsBarViewVisible(false);
        this.dSA.setShareVisible(true);
        this.dSA.setShareReportFrom(1);
        this.dSA.setStType("frs_page");
        this.dSA.setFrom(2);
        this.dSA.setDisPraiseFrom(2);
        this.dSA.cqc = 3;
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dTo.cqW.setOnClickListener(this);
        this.dTo.setFrom(2);
        this.dTo.setShareReportFrom(1);
        this.dTo.setSourceFromForPb(3);
        this.dTo.setStType("frs_page");
        this.dTo.setHideBarName(true);
        this.cTn = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cTn.setOnClickListener(this);
        this.cTn.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cTn != null) {
                    a.this.cTn.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cTz);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cTn != null) {
                    a.this.cTn.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cTz);
                }
            }
        });
        this.cTp = (TbImageView) view.findViewById(R.id.image_video);
        this.cTp.setPageId(getTag());
        this.cTp.setDefaultErrorResource(0);
        this.cTp.setDrawCorner(true);
        this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        this.cTp.setEvent(this.cTx);
        this.cTp.setGifIconSupport(false);
        this.cTq = (ImageView) view.findViewById(R.id.image_video_play);
        this.AC = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.eOM = new n(this.ceu.getPageActivity());
        this.AC.setPlayerReuseEnable(true);
        this.AC.setContinuePlayEnable(true);
        this.AC.setBusiness(this.eOM);
        this.AC.setOnPreparedListener(this.dcT);
        this.AC.setOnCompletionListener(this.dcS);
        this.AC.setOnErrorListener(this.cTy);
        this.AC.setOnOutInfoListener(this.dcV);
        this.AC.setOnSurfaceDestroyedListener(this.cTC);
        this.AC.setPageTypeForPerfStat("frs");
        this.dvH = new j();
        this.dvH.setPlayer(this.AC);
        this.dvH.a(this.eMh);
        this.cTu = view.findViewById(R.id.auto_video_black_mask);
        this.cTr = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cTs = view.findViewById(R.id.auto_video_error_background);
        this.dTz = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dTA = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.ayO = AnimationUtils.loadAnimation(this.ceu.getPageActivity(), R.anim.fade_out_video_cover);
        this.ayO.setAnimationListener(this.eMi);
        this.cTo = (TextView) view.findViewById(R.id.text_video_duration);
        this.cTv = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eNy = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fEF = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dSy);
        this.fEF.setUniqueId(getTag());
        this.eLP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eLP.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dSA != null) {
                    a.this.dSA.changeSelectStatus();
                }
            }
        });
        this.dSA.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ev(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.eMa = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dSy || view == this.dSA.getCommentNumView() || view == this.fEE) {
            bF(this.dSy);
        } else if (view == this.cTn) {
            if (this.Fs != null && this.Fs.aiV() != null) {
                z = this.Fs.aiV().is_vertical.intValue() == 1;
            }
            if (z) {
                bD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bQ(this.cTn);
            } else {
                bF(this.cTn);
            }
        } else if (view == this.eLP) {
            bF(this.eLP);
        }
        if (this.Fs != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.Fs));
        }
    }

    private void bD(View view) {
        if (aZV() != null) {
            aZV().a(view, this.Fs);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.ceu.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bad();
        }
    }

    private void bad() {
        if (this.Fs != null) {
            String str = "frs";
            if (this.fEH == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.Fs);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bQ(View view) {
        if (this.Fs != null) {
            an anVar = new an("c11100");
            anVar.bS("tid", this.Fs.getId());
            anVar.bS("fid", this.Fs.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aZV() != null) {
            aZV().a(view, this.Fs);
        }
        if (view == this.cTn) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bae();
            }
        }
    }

    private void bae() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.Fs);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.dTz.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.dTz.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fEH == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.ceu.getPageActivity(), str, this.Fs.getTid(), com.baidu.tieba.card.n.air(), "", videoSerializeVideoThreadInfo)));
    }

    private void bF(View view) {
        String str;
        String str2;
        if (this.Fs != null) {
            if (this.Fs.ajF()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).bS("fid", String.valueOf(this.Fs.getFid())).O("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.bS("tid", this.Fs.getId());
                anVar.bS("fid", this.Fs.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.Fs.aiE() != null && this.Fs.aiE().getGodUserData() != null && this.Fs.aiE().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").O("obj_locate", 3).bS("tid", this.Fs.getId()));
            }
        }
        if (aZV() != null) {
            aZV().a(view, this.Fs);
        }
        if (this.Fs != null) {
            com.baidu.tieba.card.n.uz(this.Fs.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tbadk.util.x.qr(this.Fs.getId());
            String valueOf = String.valueOf(this.Fs.getFid());
            if (this.Fs.cdv == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.Fs.cdv.id;
                str2 = valueOf;
            }
            if (this.Fs.aja() > 0 && com.baidu.tieba.tbadkCore.util.e.cpq()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ceu.getPageActivity()).createHistoryCfg(this.Fs.getTid(), String.valueOf(this.Fs.aja()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fEH == 501) {
                    str3 = "frs_tab";
                } else if (this.Fs.ajF()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.Fs.ajM());
                createHistoryCfg.setSmartFrsPosition(this.Fs.ajT());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.eLP) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.ceu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ceu.getPageActivity()).createFromThreadCfg(this.Fs, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.fEH == 501) {
                str4 = "frs_tab";
            } else if (this.Fs.ajF()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.Fs.ajM());
            createFromThreadCfg.setSmartFrsPosition(this.Fs.ajT());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.eLP) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.ceu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        this.Fs = bhVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bag() {
        this.eMb.removeMessages(202);
        if (this.AC.getCurrentPosition() > 0) {
            j(false, 3);
            this.eMb.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eMb.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bah() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eMb.removeMessages(203);
        int currentPosition = this.AC.getCurrentPosition();
        if (currentPosition != this.eLU) {
            this.eLU = currentPosition;
            j(false, 3);
        } else {
            j(false, 2);
        }
        this.eMb.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.cTq != null && this.cTp != null && this.cTu != null && this.cTt != null && this.cTs != null && this.cTr != null) {
            if (z || this.cTw != i) {
                this.cTw = i;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTB);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTA);
                if (i == 2) {
                    this.cTq.setVisibility(8);
                    this.ayO.cancel();
                    this.cTp.clearAnimation();
                    this.cTp.setVisibility(0);
                    this.cTu.setVisibility(0);
                    this.eNy.setVisibility(0);
                    this.cTt.startLoading();
                    this.cTs.setVisibility(8);
                    this.cTr.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cTB, 60000L);
                } else if (i == 3) {
                    this.cTq.setVisibility(8);
                    this.cTp.startAnimation(this.ayO);
                    this.cTu.setVisibility(8);
                    this.eNy.setVisibility(8);
                    this.cTt.ccM();
                    this.cTs.setVisibility(8);
                    this.cTr.setVisibility(8);
                    if (this.Fs != null && this.Fs.aiV() != null) {
                        this.Fs.aiV().video_length.intValue();
                        this.Fs.aiV().video_duration.intValue();
                        this.Fs.getTid();
                    }
                } else if (i == 4) {
                    this.cTq.setVisibility(8);
                    this.cTp.startAnimation(this.ayO);
                    this.cTu.setVisibility(8);
                    this.cTt.ccN();
                    this.cTs.setVisibility(0);
                    this.cTr.setVisibility(0);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cTA, 2000L);
                } else {
                    this.cTq.setVisibility(0);
                    this.eNy.setVisibility(0);
                    this.ayO.cancel();
                    this.cTp.clearAnimation();
                    this.cTp.setVisibility(0);
                    this.cTu.setVisibility(0);
                    this.cTt.ccN();
                    this.cTs.setVisibility(8);
                    this.cTr.setVisibility(8);
                }
            }
        }
    }

    private void R(final bh bhVar) {
        if (this.eOb != null) {
            if (bhVar == null) {
                this.eOb.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.cdm)) {
                if (this.fEF != null && this.fEF.bqJ() && (this.eOb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eOb.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.ceu.getContext(), R.dimen.tbds106);
                    this.eOb.setLayoutParams(layoutParams);
                }
                this.eOb.setVisibility(0);
                this.eOb.setImageDrawable(null);
                this.eOb.startLoad(bhVar.cdm, 10, false);
                this.eOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.ceu != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bhVar.cdn, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.eOb.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.Fs == null || this.Fs.aiE() == null) {
            this.dSy.setVisibility(8);
            return;
        }
        this.dSy.setVisibility(0);
        this.dSy.setOnClickListener(this);
        baj();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ccw)) {
            this.Fs.bI(this.mUrl, this.ccw);
        }
        this.Fs.q(false, true);
        SpannableStringBuilder ajk = this.Fs.ajk();
        if (this.Fs.ajr() && !StringUtils.isNull(this.Fs.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.Fs.getTid();
            ajk.append((CharSequence) this.Fs.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bS("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(ajk));
        this.mTextTitle.setText(ajk);
        this.fEF.am(this.Fs);
        R(this.Fs);
        this.dSz.setData(this.Fs);
        if (this.dSz.getHeaderImg() != null) {
            if (this.dSz.getIsSimpleThread()) {
                this.dSz.getHeaderImg().setVisibility(8);
                this.eLQ.setVisibility(8);
            } else if (this.Fs.aiE() == null || this.Fs.aiE().getPendantData() == null || StringUtils.isNull(this.Fs.aiE().getPendantData().ahd())) {
                this.eLQ.setVisibility(8);
                this.dSz.getHeaderImg().setVisibility(0);
                this.dSz.getHeaderImg().setData(this.Fs);
            } else {
                this.dSz.getHeaderImg().setVisibility(4);
                this.eLQ.setVisibility(0);
                this.eLQ.setData(this.Fs);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dSA.setLayoutParams(layoutParams);
        this.dSz.setUserAfterClickListener(this.Ho);
        mY(lx(1));
        this.cTo.setText(aq.stringForVideoTime(this.Fs.aiV().video_duration.intValue() * 1000));
        this.cTv.setText(String.format(this.ceu.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.Fs.aiV().play_count.intValue())));
        this.eLP.setData(this.Fs.akb());
        this.eLP.onChangeSkinType();
        if (com.baidu.tieba.card.n.uA(this.Fs.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.eLP.getGodReplyContent(), this.Fs.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.Fs == null || this.Fs.aiV() == null) {
            z = false;
        } else {
            z = this.Fs.aiV().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eMa.setVisibility(0);
        } else {
            this.eMa.setVisibility(8);
        }
        if (this.dSA.isInFrsAllThread() && com.baidu.tieba.frs.a.biU().biV()) {
            this.mMaskView.setVisibility(0);
            if (this.Fs.akm() || this.Fs.akn()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        this.eMb.removeMessages(202);
        this.eMb.removeMessages(203);
    }

    private void ayQ() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTA);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTB);
    }

    private void baj() {
        ayQ();
        bai();
        if (this.cTp != null && this.cTn != null && this.AC != null) {
            if (i.ago().isShowImages() && this.Fs != null && this.Fs.aiV() != null) {
                this.cTn.setVisibility(0);
                this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
                this.cTp.startLoad(this.Fs.aiV().thumbnail_url, 10, false);
                stopPlay();
                this.cln = this.Fs.aiV().video_url;
                if (StringUtils.isNull(this.cln)) {
                    j(true, 4);
                    TiebaStatic.log(new an("c12026").bS("tid", this.Fs.getId()));
                }
                if (this.eOM != null && this.eOM.ccw() != null) {
                    this.eOM.ccw().g(this.Fs.aiV());
                    return;
                }
                return;
            }
            this.cTn.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dSy, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cTq, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.cTr, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTv, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.cTs, R.color.common_color_10014);
            am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c);
            if (this.cTr != null) {
                this.cTr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dTo != null && this.dTo.getVisibility() == 0) {
                this.dTo.onChangeSkinType();
            }
            this.dSA.onChangeSkinType();
            this.mSkinType = i;
            this.dSz.onChangeSkinType();
            if (this.eLQ != null && this.eLQ.getHeadView() != null && (this.eLQ.getHeadView() instanceof TbImageView)) {
                this.eLQ.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            }
            this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.fEF.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
        this.currentPageType = i;
        if (this.dSA != null) {
            this.dSA.cqc = i;
            if (i == 15) {
                this.dSA.setFrom(10);
            } else {
                this.dSA.setFrom(2);
                this.dSA.setDisPraiseFrom(2);
            }
        }
        if (this.dSz != null) {
            if (i == 15) {
                this.dSz.setFrom(5);
            } else {
                this.dSz.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.eLV;
    }

    public boolean isPlaying() {
        if (this.AC == null) {
            return false;
        }
        return this.AC.isPlaying();
    }

    public void startPlay() {
        if (!this.eLV && this.Fs != null && this.Fs.aiV() != null && this.AC != null) {
            this.AC.stopPlayback();
            if (ac.axT()) {
                if (this.fEG || com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    j(true, 2);
                    if (StringUtils.isNull(this.cln)) {
                        TiebaStatic.log(new an("c12619").bS("obj_locate", "frs").bS("tid", this.Fs.getId()));
                        this.cln = this.Fs.aiV().video_url;
                    }
                    this.eLV = true;
                    this.AC.setVideoPath(this.cln, this.Fs.getId());
                    if (this.dvH != null) {
                        this.dvH.start();
                    }
                    bac();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bac() {
        if (this.Fs != null && this.Fs.aiV() != null) {
            String str = this.Fs.ajF() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.Fs.aiI()) {
                str = "frs_mcn";
            }
            if (this.fEH == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.cma = this.Fs.getTid();
            zVar.ePc = this.Fs.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.Fs.mRecomSource;
            zVar.iyj = this.Fs.mRecomAbTag;
            zVar.iyk = this.Fs.mRecomWeight;
            zVar.iyl = "";
            zVar.iyn = this.Fs.aiV().video_md5;
            com.baidu.tieba.play.l.a(this.Fs.aiV().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        ayQ();
        bai();
        j(true, 1);
        if (this.AC != null) {
            this.AC.stopPlayback();
            if (this.dvH != null) {
                this.dvH.stop();
            }
        }
        this.eLV = false;
    }

    public View getVideoContainer() {
        return this.cTn;
    }

    public String getPlayUrl() {
        return this.cln;
    }

    public int getCurrentPosition() {
        if (this.AC == null) {
            return 0;
        }
        return this.AC.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.eOM != null) {
            this.eOM.setVideoStatsData(zVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dSA != null && this.dSz != null) {
            this.dSz.setPageUniqueId(bdUniqueId);
        }
    }

    public void mY(int i) {
        if (this.Fs != null) {
            if (i == 1) {
                this.dSA.setVisibility(8);
                this.dTo.setData(this.Fs);
                this.dSB.setVisibility(8);
                return;
            }
            this.dSA.setData(this.Fs);
            this.dSB.setVisibility(8);
            this.dTo.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cTp.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cTp.setOnDrawListener(null);
        }
    }
}
