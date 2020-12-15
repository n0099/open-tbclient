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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
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
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<by> implements com.baidu.tieba.a.e, z {
    private TbCyberVideoView aaZ;
    private by ahA;
    private String aiw;
    private final View.OnClickListener akI;
    private Animation cbR;
    private String eLa;
    private TbPageContext<?> eNx;
    private CyberPlayerManager.OnCompletionListener etA;
    private CyberPlayerManager.OnInfoListener etB;
    private CyberPlayerManager.OnPreparedListener ety;
    private CyberPlayerManager.OnErrorListener etz;
    public FrameLayout fMI;
    private TextView fMJ;
    private TbImageView fMK;
    private ImageView fML;
    private TextView fMM;
    private View fMN;
    private m fMO;
    private View fMP;
    private TextView fMQ;
    private int fMR;
    private TbImageView.a fMS;
    private ViewTreeObserver.OnGlobalLayoutListener fMT;
    private Runnable fMU;
    private Runnable fMV;
    private TbCyberVideoView.a fMW;
    private View fYf;
    private final View.OnClickListener fdj;
    public LinearLayout gfP;
    private f gqW;
    private RelativeLayout hbL;
    public ThreadUserInfoLayout hbM;
    public ThreadCommentAndPraiseInfoLayout hbN;
    public View hbO;
    public ThreadSkinView hcK;
    protected ThreadSourceShareAndPraiseLayout hcz;
    private ThreadGodReplyLayout ijf;
    private HeadPendantClickableView ijg;
    private int ijj;
    private boolean ijk;
    private TextView ijp;
    private Handler ijq;
    private VideoLoadingProgressView.a ijr;
    private f.a ijw;
    private Animation.AnimationListener ijx;
    private LinearLayout ikO;
    private TbImageView ilq;
    public TextView jfe;
    public LinearLayout jff;
    private i jfg;
    public boolean jfh;
    public int jfi;
    private View.OnClickListener jfj;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        if (this.aaZ != null && this.ijk) {
            try {
                this.aaZ.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ijq.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ijj = 0;
        this.fMR = 1;
        this.ijk = false;
        this.ijq = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.crT();
                        return;
                    case 203:
                        a.this.crU();
                        return;
                    default:
                        return;
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.aaZ != null) {
                    a.this.aaZ.setVolume(0.0f, 0.0f);
                }
                a.this.crO();
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.w(false, 3);
                }
                return false;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.aaZ.start();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.crV();
                a.this.w(true, 4);
                a.this.ijk = false;
                return true;
            }
        };
        this.ijr = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.crO();
            }
        };
        this.fMS = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.fMK != null) {
                    a.this.fMK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fMT = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fMI != null && a.this.fMI.getLayoutParams() != null && a.this.fMI.getVisibility() != 8) {
                    a.this.fMI.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fMI.getLayoutParams();
                    if (a.this.fMI.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fMI.getWidth() * 0.5625d);
                        a.this.fMI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aaZ != null && !a.this.aaZ.isPlaying()) {
                    a.this.w(true, 1);
                }
            }
        };
        this.fMV = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.crV();
                a.this.w(true, 4);
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.jfj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ahA != null && !StringUtils.isNull(a.this.ahA.boT())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eNx.getPageActivity()).createNormalCfg(a.this.ahA.boT(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.fdj != null) {
                        a.this.fdj.onClick(view);
                    }
                }
            }
        };
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.crJ() != null) {
                    a.this.crJ().a(view, a.this.ahA);
                }
            }
        };
        this.fdj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ahA != null && a.this.crJ() != null) {
                    a.this.crJ().a(view, a.this.ahA);
                }
            }
        };
        this.ijw = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void se() {
                a.this.crP();
            }
        };
        this.ijx = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fMR == 3 && a.this.fMK != null) {
                    a.this.fMK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eNx = tbPageContext;
        View view = getView();
        this.fYf = view.findViewById(R.id.divider_line);
        this.hbL = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ilq = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.jff = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hbL.setOnClickListener(this);
        this.ijg = (HeadPendantClickableView) this.hbL.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.ijg.getHeadView() != null) {
            this.ijg.getHeadView().setIsRound(true);
            this.ijg.getHeadView().setDrawBorder(false);
            this.ijg.getHeadView().setDefaultResource(17170445);
            this.ijg.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ijg.getHeadView().setRadius(l.getDimens(this.eNx.getPageActivity(), R.dimen.ds70));
        }
        this.ijg.setHasPendantStyle();
        if (this.ijg.getPendantView() != null) {
            this.ijg.getPendantView().setIsRound(true);
            this.ijg.getPendantView().setDrawBorder(false);
        }
        this.jfe = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.jfe.setVisibility(8);
        this.jfe.setOnClickListener(this.jfj);
        this.fMO = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fMO.setLoadingAnimationListener(this.ijr);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hbN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.hbN.setForumAfterClickListener(this.fdj);
        this.hbM = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hbM.setFrom(3);
        this.hbO = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.hbN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbN.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hbN.setLayoutParams(layoutParams);
        }
        this.hbN.setOnClickListener(this);
        this.hbN.setReplyTimeVisible(false);
        this.hbN.setShowPraiseNum(true);
        this.hbN.setNeedAddPraiseIcon(true);
        this.hbN.setNeedAddReplyIcon(true);
        this.hbN.setIsBarViewVisible(false);
        this.hbN.setShareVisible(true);
        this.hbN.setShareReportFrom(1);
        this.hbN.setStType("frs_page");
        this.hbN.setFrom(2);
        this.hbN.fdg = 3;
        this.hcz = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hcz.feb.setOnClickListener(this);
        this.hcz.setFrom(2);
        this.hcz.setShareReportFrom(1);
        this.hcz.setSourceFromForPb(3);
        this.hcz.setStType("frs_page");
        this.hcz.setHideBarName(true);
        this.fMI = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fMI.setOnClickListener(this);
        this.fMI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fMI != null) {
                    a.this.fMI.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fMT);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fMI != null) {
                    a.this.fMI.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fMT);
                }
            }
        });
        this.fMK = (TbImageView) view.findViewById(R.id.image_video);
        this.fMK.setPageId(getTag());
        this.fMK.setDefaultErrorResource(0);
        this.fMK.setDrawCorner(true);
        this.fMK.setPlaceHolder(3);
        this.fMK.setEvent(this.fMS);
        this.fMK.setGifIconSupport(false);
        this.fML = (ImageView) view.findViewById(R.id.image_video_play);
        this.aaZ = new TbCyberVideoView(getContext());
        this.aaZ.setStageType("2003");
        bIl();
        this.aaZ.setContinuePlayEnable(true);
        this.aaZ.setOnPreparedListener(this.ety);
        this.aaZ.setOnCompletionListener(this.etA);
        this.aaZ.setOnErrorListener(this.etz);
        this.aaZ.setOnInfoListener(this.etB);
        this.aaZ.setOnSurfaceDestroyedListener(this.fMW);
        this.gqW = new f();
        this.gqW.setPlayer(this.aaZ);
        this.gqW.a(this.ijw);
        this.fMP = view.findViewById(R.id.auto_video_black_mask);
        this.fMM = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fMN = view.findViewById(R.id.auto_video_error_background);
        this.gfP = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hcK = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.cbR = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.fade_out_video_cover);
        this.cbR.setAnimationListener(this.ijx);
        this.fMJ = (TextView) view.findViewById(R.id.text_video_duration);
        this.fMQ = (TextView) view.findViewById(R.id.text_video_play_count);
        this.ikO = (LinearLayout) view.findViewById(R.id.duration_container);
        this.jfg = new i(tbPageContext, this.hbL);
        this.jfg.setUniqueId(getTag());
        this.ijf = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.ijf.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.hbN != null) {
                    a.this.hbN.changeSelectStatus();
                }
            }
        });
        this.hbN.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jJ(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
                }
            }
        });
        this.ijp = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bIl() {
        if (this.aaZ != null && this.aaZ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fMI.addView(this.aaZ.getView(), 0);
            this.aaZ.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.hbL || view == this.hbN.getCommentNumView() || view == this.jff) {
            cE(this.hbL);
        } else if (view == this.fMI) {
            if (this.ahA != null && this.ahA.bph() != null) {
                z = this.ahA.bph().is_vertical.intValue() == 1;
            }
            if (z) {
                cC(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cO(this.fMI);
            } else {
                cE(this.fMI);
            }
        } else if (view == this.ijf) {
            cE(this.ijf);
        }
        if (this.ahA != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ahA));
        }
    }

    private void cC(View view) {
        if (crJ() != null) {
            crJ().a(view, this.ahA);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eNx.getPageActivity(), R.string.no_network_guide);
        } else {
            crQ();
        }
    }

    private void crQ() {
        if (this.ahA != null) {
            String str = "frs";
            if (this.jfi == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ahA);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.ahA.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.ahA.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cO(View view) {
        if (this.ahA != null) {
            ar arVar = new ar("c11100");
            arVar.dY("tid", this.ahA.getId());
            arVar.dY("fid", this.ahA.getFid() + "");
            TiebaStatic.log(arVar);
        }
        if (crJ() != null) {
            crJ().a(view, this.ahA);
        }
        if (view == this.fMI) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eNx.getPageActivity(), R.string.no_network_guide);
            } else {
                crR();
            }
        }
    }

    private void crR() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ahA);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.gfP.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.gfP.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.jfi == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eNx.getPageActivity(), str, this.ahA.getTid(), n.boB(), "", videoSerializeVideoThreadInfo);
        if (this.ahA.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.ahA.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void cE(View view) {
        String str;
        String str2;
        if (this.ahA != null) {
            if (this.ahA.bqa()) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dY("fid", String.valueOf(this.ahA.getFid())).al("obj_type", 2));
            } else {
                ar arVar = new ar("c11100");
                arVar.dY("tid", this.ahA.getId());
                arVar.dY("fid", this.ahA.getFid() + "");
                TiebaStatic.log(arVar);
            }
            if (this.ahA.boP() != null && this.ahA.boP().getGodUserData() != null && this.ahA.boP().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ar("c10806").al("obj_locate", 3).dY("tid", this.ahA.getId()));
            }
        }
        if (crJ() != null) {
            crJ().a(view, this.ahA);
        }
        if (this.ahA != null) {
            n.Jq(this.ahA.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            aa.EM(this.ahA.getId());
            String valueOf = String.valueOf(this.ahA.getFid());
            if (this.ahA.eLS == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.ahA.eLS.id;
                str2 = valueOf;
            }
            if (this.ahA.bpm() > 0 && com.baidu.tieba.tbadkCore.util.e.dQx()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eNx.getPageActivity()).createHistoryCfg(this.ahA.getTid(), String.valueOf(this.ahA.bpm()), false, true, "frs_page");
                String str3 = "frs";
                if (this.jfi == 501) {
                    str3 = "frs_tab";
                } else if (this.ahA.bqa()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.ahA.bqg());
                createHistoryCfg.setSmartFrsPosition(this.ahA.bqm());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.ijf) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eNx.getPageActivity()).createFromThreadCfg(this.ahA, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.jfi == 501) {
                str4 = "frs_tab";
            } else if (this.ahA.bqa()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.ahA.bqg());
            createFromThreadCfg.setSmartFrsPosition(this.ahA.bqm());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.ijf) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(by byVar) {
        this.ahA = byVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crT() {
        this.ijq.removeMessages(202);
        if (this.aaZ.getCurrentPosition() > 0) {
            w(false, 3);
            this.ijq.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.ijq.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crU() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ijq.removeMessages(203);
        int currentPosition = this.aaZ.getCurrentPosition();
        if (currentPosition != this.ijj) {
            this.ijj = currentPosition;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.ijq.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fML != null && this.fMK != null && this.fMP != null && this.fMO != null && this.fMN != null && this.fMM != null) {
            if (z || this.fMR != i) {
                this.fMR = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMV);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
                if (i == 2) {
                    this.fML.setVisibility(8);
                    this.cbR.cancel();
                    this.fMK.clearAnimation();
                    this.fMK.setVisibility(0);
                    this.fMP.setVisibility(0);
                    this.ikO.setVisibility(0);
                    this.fMO.startLoading();
                    this.fMN.setVisibility(8);
                    this.fMM.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fMV, 60000L);
                } else if (i == 3) {
                    this.fML.setVisibility(8);
                    this.fMK.startAnimation(this.cbR);
                    this.fMP.setVisibility(8);
                    this.ikO.setVisibility(8);
                    this.fMO.dBV();
                    this.fMN.setVisibility(8);
                    this.fMM.setVisibility(8);
                    if (this.ahA != null && this.ahA.bph() != null) {
                        this.ahA.bph().video_length.intValue();
                        this.ahA.bph().video_duration.intValue();
                        this.ahA.getTid();
                    }
                } else if (i == 4) {
                    this.fML.setVisibility(8);
                    this.fMK.startAnimation(this.cbR);
                    this.fMP.setVisibility(8);
                    this.fMO.dBW();
                    this.fMN.setVisibility(0);
                    this.fMM.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fMU, 2000L);
                } else {
                    this.fML.setVisibility(0);
                    this.ikO.setVisibility(0);
                    this.cbR.cancel();
                    this.fMK.clearAnimation();
                    this.fMK.setVisibility(0);
                    this.fMP.setVisibility(0);
                    this.fMO.dBW();
                    this.fMN.setVisibility(8);
                    this.fMM.setVisibility(8);
                }
            }
        }
    }

    private void aa(final by byVar) {
        if (this.ilq != null) {
            if (byVar == null) {
                this.ilq.setVisibility(8);
            } else if (!StringUtils.isNull(byVar.eLI)) {
                if (this.jfg != null && this.jfg.cKX() && (this.ilq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilq.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eNx.getContext(), R.dimen.tbds106);
                    this.ilq.setLayoutParams(layoutParams);
                }
                this.ilq.setVisibility(0);
                this.ilq.setImageDrawable(null);
                this.ilq.startLoad(byVar.eLI, 10, false);
                this.ilq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eNx != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", byVar.eLJ, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ilq.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ahA == null || this.ahA.boP() == null) {
            this.hbL.setVisibility(8);
            return;
        }
        this.hbL.setVisibility(0);
        this.hbL.setOnClickListener(this);
        crW();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eLa)) {
            this.ahA.dL(this.mUrl, this.eLa);
        }
        this.ahA.z(false, true);
        SpannableStringBuilder bpz = this.ahA.bpz();
        if (this.ahA.bpF() && !StringUtils.isNull(this.ahA.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ahA.getTid();
            bpz.append((CharSequence) this.ahA.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ar("c12841").dY("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(bpz));
        this.mTextTitle.setText(bpz);
        this.jfg.aA(this.ahA);
        aa(this.ahA);
        this.hbM.setData(this.ahA);
        if (this.hbM.getHeaderImg() != null) {
            if (this.hbM.getIsSimpleThread()) {
                this.hbM.getHeaderImg().setVisibility(8);
                this.ijg.setVisibility(8);
            } else if (this.ahA.boP() == null || this.ahA.boP().getPendantData() == null || StringUtils.isNull(this.ahA.boP().getPendantData().bmL())) {
                this.ijg.setVisibility(8);
                this.hbM.getHeaderImg().setVisibility(0);
                this.hbM.getHeaderImg().setData(this.ahA);
            } else {
                this.hbM.getHeaderImg().setVisibility(4);
                this.ijg.setVisibility(0);
                this.ijg.setData(this.ahA);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbN.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.hbN.setLayoutParams(layoutParams);
        this.hbM.setUserAfterClickListener(this.akI);
        wk(ul(1));
        this.fMJ.setText(au.stringForVideoTime(this.ahA.bph().video_duration.intValue() * 1000));
        this.fMQ.setText(String.format(this.eNx.getResources().getString(R.string.play_count), au.numFormatOverWan(this.ahA.bph().play_count.intValue())));
        this.ijf.setData(this.ahA.bqu());
        this.ijf.onChangeSkinType();
        if (n.Jr(this.ahA.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            n.a(this.ijf.getGodReplyContent(), this.ahA.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.ahA == null || this.ahA.bph() == null) {
            z = false;
        } else {
            z = this.ahA.bph().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ijp.setVisibility(0);
        } else {
            this.ijp.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) && this.hbN.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.ahA.bqC() || this.ahA.bqD() || this.ahA.bqE()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crV() {
        this.ijq.removeMessages(202);
        this.ijq.removeMessages(203);
    }

    private void bIm() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMV);
    }

    private void crW() {
        bIm();
        crV();
        if (this.fMK != null && this.fMI != null && this.aaZ != null) {
            if (k.blV().isShowImages() && this.ahA != null && this.ahA.bph() != null) {
                this.fMI.setVisibility(0);
                this.fMK.setPlaceHolder(3);
                this.fMK.startLoad(this.ahA.bph().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.ahA.bph().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                    TiebaStatic.log(new ar("c12026").dY("tid", this.ahA.getId()));
                }
                this.aaZ.setThreadDataForStatistic(this.ahA);
                return;
            }
            this.fMI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hbL, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fML, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fMM, R.color.CAM_X0101);
            ap.setViewTextColor(this.fMJ, R.color.CAM_X0101);
            ap.setViewTextColor(this.fMQ, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fMN, R.color.common_color_10014);
            ap.setBackgroundColor(this.fYf, R.color.CAM_X0204);
            if (this.fMM != null) {
                this.fMM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.hcz != null && this.hcz.getVisibility() == 0) {
                this.hcz.onChangeSkinType();
            }
            this.hbN.onChangeSkinType();
            this.mSkinType = i;
            this.hbM.onChangeSkinType();
            if (this.ijg != null && this.ijg.getHeadView() != null && (this.ijg.getHeadView() instanceof TbImageView)) {
                this.ijg.getHeadView().setPlaceHolder(1);
            }
            this.fMK.setPlaceHolder(3);
            this.jfg.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.currentPageType = i;
        if (this.hbN != null) {
            this.hbN.fdg = i;
            this.hbN.setFrom(2);
        }
        if (this.hbM != null) {
            this.hbM.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.ijk;
    }

    public boolean isPlaying() {
        if (this.aaZ == null) {
            return false;
        }
        return this.aaZ.isPlaying();
    }

    public void startPlay() {
        if (!this.ijk && this.ahA != null && this.ahA.bph() != null && this.aaZ != null) {
            this.aaZ.stopPlayback();
            if (ai.bGV()) {
                if (this.jfh || com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    w(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new ar("c12619").dY("obj_locate", "frs").dY("tid", this.ahA.getId()));
                        this.mVideoUrl = this.ahA.bph().video_url;
                    }
                    this.ijk = true;
                    this.aaZ.setVideoPath(this.mVideoUrl, this.ahA.getId());
                    if (this.gqW != null) {
                        this.gqW.start();
                    }
                    crP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crP() {
        if (this.ahA != null && this.ahA.bph() != null) {
            String str = this.ahA.bqa() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.jfi == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.amY = this.ahA.getTid();
            oVar.fFV = this.ahA.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.ahA.mRecomSource;
            oVar.myu = this.ahA.mRecomAbTag;
            oVar.myq = this.ahA.mRecomAbTag;
            oVar.myr = this.ahA.mRecomWeight;
            oVar.mys = "";
            oVar.myv = this.ahA.bph().video_md5;
            h.a(this.ahA.bph().video_md5, "", "1", oVar, this.aaZ.getPcdnState());
        }
    }

    public void stopPlay() {
        bIm();
        crV();
        w(true, 1);
        if (this.aaZ != null) {
            this.aaZ.stopPlayback();
            if (this.gqW != null) {
                this.gqW.stop();
            }
        }
        this.ijk = false;
    }

    public View getVideoContainer() {
        return this.fMI;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.aaZ == null) {
            return 0;
        }
        return this.aaZ.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.aaZ != null) {
            this.aaZ.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbN != null && this.hbM != null) {
            this.hbM.setPageUniqueId(bdUniqueId);
        }
    }

    public void wk(int i) {
        if (this.ahA != null) {
            if (i == 1) {
                this.hbN.setVisibility(8);
                this.hcz.setData(this.ahA);
                this.hbO.setVisibility(8);
                return;
            }
            this.hbN.setData(this.ahA);
            this.hbO.setVisibility(8);
            this.hcz.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLU().ax(this.aiw, i);
    }
}
