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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private QuickVideoView Dn;
    private bj Kn;
    private String Lg;
    private final View.OnClickListener MX;
    private Animation aHs;
    private String cPg;
    private TbPageContext<?> cRe;
    private View caf;
    public FrameLayout dHP;
    private TextView dHQ;
    private TbImageView dHR;
    private ImageView dHS;
    private TextView dHT;
    private View dHU;
    private w dHV;
    private View dHW;
    private TextView dHX;
    private int dHY;
    private TbImageView.a dHZ;
    private g.b dIa;
    private ViewTreeObserver.OnGlobalLayoutListener dIb;
    private Runnable dIc;
    private Runnable dId;
    private QuickVideoView.b dIe;
    private g.a dQW;
    private g.f dQX;
    private g.e dQZ;
    private final View.OnClickListener ddE;
    private RelativeLayout eJp;
    public ThreadUserInfoLayout eJq;
    public ThreadCommentAndPraiseInfoLayout eJr;
    public View eJs;
    protected ThreadSourceShareAndPraiseLayout eKe;
    public ThreadSkinView eKp;
    private g eaK;
    public LinearLayout ecC;
    private j egT;
    private ThreadGodReplyLayout fGP;
    private HeadPendantClickableView fGQ;
    private int fGU;
    private boolean fGV;
    private TextView fHa;
    private Handler fHb;
    private VideoLoadingProgressView.a fHc;
    private j.a fHh;
    private Animation.AnimationListener fHi;
    private TbImageView fIY;
    private LinearLayout fIx;
    private n fJK;
    public TextView gwf;
    public LinearLayout gwg;
    private i gwh;
    public boolean gwi;
    public int gwj;
    private View.OnClickListener gwk;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bth() {
        if (this.eaK != null && this.fGV) {
            try {
                this.Dn.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fHb.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fGU = 0;
        this.dHY = 1;
        this.fGV = false;
        this.fHb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.btm();
                        return;
                    case 203:
                        a.this.btn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.eaK = gVar;
                if (a.this.eaK != null) {
                    a.this.eaK.setVolume(0.0f, 0.0f);
                }
                a.this.bth();
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.o(false, 3);
                }
                return false;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Dn.start();
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bto();
                a.this.o(true, 4);
                a.this.fGV = false;
                return true;
            }
        };
        this.fHc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bth();
            }
        };
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dHR != null) {
                    a.this.dHR.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dIb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.dHP != null && a.this.dHP.getLayoutParams() != null && a.this.dHP.getVisibility() != 8) {
                    a.this.dHP.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.dHP.getLayoutParams();
                    if (a.this.dHP.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.dHP.getWidth() * 0.5625d);
                        a.this.dHP.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dIc = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Dn != null && !a.this.Dn.isPlaying()) {
                    a.this.o(true, 1);
                }
            }
        };
        this.dId = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bto();
                a.this.o(true, 4);
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.gwk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Kn != null && !StringUtils.isNull(a.this.Kn.aAc())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cRe.getPageActivity()).createNormalCfg(a.this.Kn.aAc(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.ddE != null) {
                        a.this.ddE.onClick(view);
                    }
                }
            }
        };
        this.MX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view, a.this.Kn);
                }
            }
        };
        this.ddE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Kn != null && a.this.bta() != null) {
                    a.this.bta().a(view, a.this.Kn);
                }
            }
        };
        this.fHh = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void lh() {
                a.this.bti();
            }
        };
        this.fHi = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dHY == 3 && a.this.dHR != null) {
                    a.this.dHR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.cRe = tbPageContext;
        View view = getView();
        this.caf = view.findViewById(R.id.divider_line);
        this.eJp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fIY = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.gwg = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eJp.setOnClickListener(this);
        this.fGQ = (HeadPendantClickableView) this.eJp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fGQ.getHeadView() != null) {
            this.fGQ.getHeadView().setIsRound(true);
            this.fGQ.getHeadView().setDrawBorder(false);
            this.fGQ.getHeadView().setDefaultResource(17170445);
            this.fGQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fGQ.getHeadView().setRadius(l.getDimens(this.cRe.getPageActivity(), R.dimen.ds70));
        }
        this.fGQ.setHasPendantStyle();
        if (this.fGQ.getPendantView() != null) {
            this.fGQ.getPendantView().setIsRound(true);
            this.fGQ.getPendantView().setDrawBorder(false);
        }
        this.gwf = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.gwf.setVisibility(8);
        this.gwf.setOnClickListener(this.gwk);
        this.dHV = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dHV.setLoadingAnimationListener(this.fHc);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eJr.setForumAfterClickListener(this.ddE);
        this.eJq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eJq.setFrom(3);
        this.eJs = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.eJr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eJr.setLayoutParams(layoutParams);
        }
        this.eJr.setOnClickListener(this);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setIsBarViewVisible(false);
        this.eJr.setShareVisible(true);
        this.eJr.setShareReportFrom(1);
        this.eJr.setStType("frs_page");
        this.eJr.setFrom(2);
        this.eJr.ddB = 3;
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eKe.deA.setOnClickListener(this);
        this.eKe.setFrom(2);
        this.eKe.setShareReportFrom(1);
        this.eKe.setSourceFromForPb(3);
        this.eKe.setStType("frs_page");
        this.eKe.setHideBarName(true);
        this.dHP = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dHP.setOnClickListener(this);
        this.dHP.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.dHP != null) {
                    a.this.dHP.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dIb);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.dHP != null) {
                    a.this.dHP.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dIb);
                }
            }
        });
        this.dHR = (TbImageView) view.findViewById(R.id.image_video);
        this.dHR.setPageId(getTag());
        this.dHR.setDefaultErrorResource(0);
        this.dHR.setDrawCorner(true);
        this.dHR.setPlaceHolder(3);
        this.dHR.setEvent(this.dHZ);
        this.dHR.setGifIconSupport(false);
        this.dHS = (ImageView) view.findViewById(R.id.image_video_play);
        this.Dn = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.fJK = new n(this.cRe.getPageActivity());
        this.Dn.setPlayerReuseEnable(true);
        this.Dn.setContinuePlayEnable(true);
        this.Dn.setBusiness(this.fJK);
        this.Dn.setOnPreparedListener(this.dQX);
        this.Dn.setOnCompletionListener(this.dQW);
        this.Dn.setOnErrorListener(this.dIa);
        this.Dn.setOnOutInfoListener(this.dQZ);
        this.Dn.setOnSurfaceDestroyedListener(this.dIe);
        this.Dn.setPageTypeForPerfStat("frs");
        this.egT = new j();
        this.egT.setPlayer(this.Dn);
        this.egT.a(this.fHh);
        this.dHW = view.findViewById(R.id.auto_video_black_mask);
        this.dHT = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dHU = view.findViewById(R.id.auto_video_error_background);
        this.ecC = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eKp = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.aHs = AnimationUtils.loadAnimation(this.cRe.getPageActivity(), R.anim.fade_out_video_cover);
        this.aHs.setAnimationListener(this.fHi);
        this.dHQ = (TextView) view.findViewById(R.id.text_video_duration);
        this.dHX = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fIx = (LinearLayout) view.findViewById(R.id.duration_container);
        this.gwh = new i(tbPageContext, this.eJp);
        this.gwh.setUniqueId(getTag());
        this.fGP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fGP.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eJr != null) {
                    a.this.eJr.changeSelectStatus();
                }
            }
        });
        this.eJr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fM(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.fHa = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eJp || view == this.eJr.getCommentNumView() || view == this.gwg) {
            bH(this.eJp);
        } else if (view == this.dHP) {
            if (this.Kn != null && this.Kn.aAo() != null) {
                z = this.Kn.aAo().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bQ(this.dHP);
                } else {
                    bH(this.dHP);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bQ(this.dHP);
            } else {
                bH(this.dHP);
            }
        } else if (view == this.fGP) {
            bH(this.fGP);
        }
        if (this.Kn != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.Kn));
        }
    }

    private void bF(View view) {
        if (bta() != null) {
            bta().a(view, this.Kn);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.cRe.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            btj();
        }
    }

    private void btj() {
        if (this.Kn != null) {
            String str = "frs";
            if (this.gwj == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.Kn);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.Kn.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.Kn.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (this.Kn != null) {
            an anVar = new an("c11100");
            anVar.cp("tid", this.Kn.getId());
            anVar.cp("fid", this.Kn.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (bta() != null) {
            bta().a(view, this.Kn);
        }
        if (view == this.dHP) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                btk();
            }
        }
    }

    private void btk() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.Kn);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.ecC.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.ecC.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.gwj == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cRe.getPageActivity(), str, this.Kn.getTid(), com.baidu.tieba.card.l.azJ(), "", videoSerializeVideoThreadInfo);
        if (this.Kn.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.Kn.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bH(View view) {
        String str;
        String str2;
        if (this.Kn != null) {
            if (this.Kn.aBe()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cp("fid", String.valueOf(this.Kn.getFid())).Z("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cp("tid", this.Kn.getId());
                anVar.cp("fid", this.Kn.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.Kn.azX() != null && this.Kn.azX().getGodUserData() != null && this.Kn.azX().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").Z("obj_locate", 3).cp("tid", this.Kn.getId()));
            }
        }
        if (bta() != null) {
            bta().a(view, this.Kn);
        }
        if (this.Kn != null) {
            com.baidu.tieba.card.l.zC(this.Kn.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.vC(this.Kn.getId());
            String valueOf = String.valueOf(this.Kn.getFid());
            if (this.Kn.cPX == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.Kn.cPX.id;
                str2 = valueOf;
            }
            if (this.Kn.aAt() > 0 && com.baidu.tieba.tbadkCore.util.e.cKA()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.cRe.getPageActivity()).createHistoryCfg(this.Kn.getTid(), String.valueOf(this.Kn.aAt()), false, true, "frs_page");
                String str3 = "frs";
                if (this.gwj == 501) {
                    str3 = "frs_tab";
                } else if (this.Kn.aBe()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.Kn.aBk());
                createHistoryCfg.setSmartFrsPosition(this.Kn.aBp());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.fGP) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.cRe.getPageActivity()).createFromThreadCfg(this.Kn, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.gwj == 501) {
                str4 = "frs_tab";
            } else if (this.Kn.aBe()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.Kn.aBk());
            createFromThreadCfg.setSmartFrsPosition(this.Kn.aBp());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.fGP) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.Kn = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btm() {
        this.fHb.removeMessages(202);
        if (this.Dn.getCurrentPosition() > 0) {
            o(false, 3);
            this.fHb.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fHb.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fHb.removeMessages(203);
        int currentPosition = this.Dn.getCurrentPosition();
        if (currentPosition != this.fGU) {
            this.fGU = currentPosition;
            o(false, 3);
        } else {
            o(false, 2);
        }
        this.fHb.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dHS != null && this.dHR != null && this.dHW != null && this.dHV != null && this.dHU != null && this.dHT != null) {
            if (z || this.dHY != i) {
                this.dHY = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dId);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dIc);
                if (i == 2) {
                    this.dHS.setVisibility(8);
                    this.aHs.cancel();
                    this.dHR.clearAnimation();
                    this.dHR.setVisibility(0);
                    this.dHW.setVisibility(0);
                    this.fIx.setVisibility(0);
                    this.dHV.startLoading();
                    this.dHU.setVisibility(8);
                    this.dHT.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dId, 60000L);
                } else if (i == 3) {
                    this.dHS.setVisibility(8);
                    this.dHR.startAnimation(this.aHs);
                    this.dHW.setVisibility(8);
                    this.fIx.setVisibility(8);
                    this.dHV.cxQ();
                    this.dHU.setVisibility(8);
                    this.dHT.setVisibility(8);
                    if (this.Kn != null && this.Kn.aAo() != null) {
                        this.Kn.aAo().video_length.intValue();
                        this.Kn.aAo().video_duration.intValue();
                        this.Kn.getTid();
                    }
                } else if (i == 4) {
                    this.dHS.setVisibility(8);
                    this.dHR.startAnimation(this.aHs);
                    this.dHW.setVisibility(8);
                    this.dHV.cxR();
                    this.dHU.setVisibility(0);
                    this.dHT.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dIc, 2000L);
                } else {
                    this.dHS.setVisibility(0);
                    this.fIx.setVisibility(0);
                    this.aHs.cancel();
                    this.dHR.clearAnimation();
                    this.dHR.setVisibility(0);
                    this.dHW.setVisibility(0);
                    this.dHV.cxR();
                    this.dHU.setVisibility(8);
                    this.dHT.setVisibility(8);
                }
            }
        }
    }

    private void W(final bj bjVar) {
        if (this.fIY != null) {
            if (bjVar == null) {
                this.fIY.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cPO)) {
                if (this.gwh != null && this.gwh.bJm() && (this.fIY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fIY.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.cRe.getContext(), R.dimen.tbds106);
                    this.fIY.setLayoutParams(layoutParams);
                }
                this.fIY.setVisibility(0);
                this.fIY.setImageDrawable(null);
                this.fIY.startLoad(bjVar.cPO, 10, false);
                this.fIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.cRe != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.cPP, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fIY.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.Kn == null || this.Kn.azX() == null) {
            this.eJp.setVisibility(8);
            return;
        }
        this.eJp.setVisibility(0);
        this.eJp.setOnClickListener(this);
        btp();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cPg)) {
            this.Kn.cg(this.mUrl, this.cPg);
        }
        this.Kn.p(false, true);
        SpannableStringBuilder aAE = this.Kn.aAE();
        if (this.Kn.aAK() && !StringUtils.isNull(this.Kn.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.Kn.getTid();
            aAE.append((CharSequence) this.Kn.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cp("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aAE));
        this.mTextTitle.setText(aAE);
        this.gwh.at(this.Kn);
        W(this.Kn);
        this.eJq.setData(this.Kn);
        if (this.eJq.getHeaderImg() != null) {
            if (this.eJq.getIsSimpleThread()) {
                this.eJq.getHeaderImg().setVisibility(8);
                this.fGQ.setVisibility(8);
            } else if (this.Kn.azX() == null || this.Kn.azX().getPendantData() == null || StringUtils.isNull(this.Kn.azX().getPendantData().ayq())) {
                this.fGQ.setVisibility(8);
                this.eJq.getHeaderImg().setVisibility(0);
                this.eJq.getHeaderImg().setData(this.Kn);
            } else {
                this.eJq.getHeaderImg().setVisibility(4);
                this.fGQ.setVisibility(0);
                this.fGQ.setData(this.Kn);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJr.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.eJr.setLayoutParams(layoutParams);
        this.eJq.setUserAfterClickListener(this.MX);
        pq(nL(1));
        this.dHQ.setText(aq.stringForVideoTime(this.Kn.aAo().video_duration.intValue() * 1000));
        this.dHX.setText(String.format(this.cRe.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.Kn.aAo().play_count.intValue())));
        this.fGP.setData(this.Kn.aBx());
        this.fGP.onChangeSkinType();
        if (com.baidu.tieba.card.l.zD(this.Kn.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.fGP.getGodReplyContent(), this.Kn.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.Kn == null || this.Kn.aAo() == null) {
            z = false;
        } else {
            z = this.Kn.aAo().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fHa.setVisibility(0);
        } else {
            this.fHa.setVisibility(8);
        }
        if (this.eJr.isInFrsAllThread() && com.baidu.tieba.frs.a.bBr().bBs()) {
            this.mMaskView.setVisibility(0);
            if (this.Kn.aBG() || this.Kn.aBH()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bto() {
        this.fHb.removeMessages(202);
        this.fHb.removeMessages(203);
    }

    private void aRj() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dIc);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dId);
    }

    private void btp() {
        aRj();
        bto();
        if (this.dHR != null && this.dHP != null && this.Dn != null) {
            if (com.baidu.tbadk.core.i.axy().isShowImages() && this.Kn != null && this.Kn.aAo() != null) {
                this.dHP.setVisibility(0);
                this.dHR.setPlaceHolder(3);
                this.dHR.startLoad(this.Kn.aAo().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.Kn.aAo().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    o(true, 4);
                    TiebaStatic.log(new an("c12026").cp("tid", this.Kn.getId()));
                }
                if (this.fJK != null && this.fJK.cxB() != null) {
                    this.fJK.cxB().ai(this.Kn);
                    return;
                }
                return;
            }
            this.dHP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHS, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dHT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHQ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHX, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dHU, R.color.common_color_10014);
            am.setBackgroundColor(this.caf, R.color.cp_bg_line_c);
            if (this.dHT != null) {
                this.dHT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.eKe != null && this.eKe.getVisibility() == 0) {
                this.eKe.onChangeSkinType();
            }
            this.eJr.onChangeSkinType();
            this.mSkinType = i;
            this.eJq.onChangeSkinType();
            if (this.fGQ != null && this.fGQ.getHeadView() != null && (this.fGQ.getHeadView() instanceof TbImageView)) {
                this.fGQ.getHeadView().setPlaceHolder(1);
            }
            this.dHR.setPlaceHolder(3);
            this.gwh.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
        this.currentPageType = i;
        if (this.eJr != null) {
            this.eJr.ddB = i;
            if (i == 15) {
                this.eJr.setFrom(10);
            } else {
                this.eJr.setFrom(2);
            }
        }
        if (this.eJq != null) {
            if (i == 15) {
                this.eJq.setFrom(5);
            } else {
                this.eJq.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.fGV;
    }

    public boolean isPlaying() {
        if (this.Dn == null) {
            return false;
        }
        return this.Dn.isPlaying();
    }

    public void startPlay() {
        if (!this.fGV && this.Kn != null && this.Kn.aAo() != null && this.Dn != null) {
            this.Dn.stopPlayback();
            if (af.aQd()) {
                if (this.gwi || com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    o(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cp("obj_locate", "frs").cp("tid", this.Kn.getId()));
                        this.mVideoUrl = this.Kn.aAo().video_url;
                    }
                    this.fGV = true;
                    this.Dn.setVideoPath(this.mVideoUrl, this.Kn.getId());
                    if (this.egT != null) {
                        this.egT.start();
                    }
                    bti();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        if (this.Kn != null && this.Kn.aAo() != null) {
            String str = this.Kn.aBe() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.Kn.aAb()) {
                str = "frs_mcn";
            }
            if (this.gwj == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.OG = this.Kn.getTid();
            yVar.fKa = this.Kn.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.Kn.mRecomSource;
            yVar.mAbTag = this.Kn.mRecomAbTag;
            yVar.jvJ = this.Kn.mRecomAbTag;
            yVar.jvK = this.Kn.mRecomWeight;
            yVar.jvL = "";
            yVar.jvN = this.Kn.aAo().video_md5;
            com.baidu.tieba.play.l.a(this.Kn.aAo().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aRj();
        bto();
        o(true, 1);
        if (this.Dn != null) {
            this.Dn.stopPlayback();
            if (this.egT != null) {
                this.egT.stop();
            }
        }
        this.fGV = false;
    }

    public View getVideoContainer() {
        return this.dHP;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Dn == null) {
            return 0;
        }
        return this.Dn.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.fJK != null) {
            this.fJK.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eJr != null && this.eJq != null) {
            this.eJq.setPageUniqueId(bdUniqueId);
        }
    }

    public void pq(int i) {
        if (this.Kn != null) {
            if (i == 1) {
                this.eJr.setVisibility(8);
                this.eKe.setData(this.Kn);
                this.eJs.setVisibility(8);
                return;
            }
            this.eJr.setData(this.Kn);
            this.eJs.setVisibility(8);
            this.eKe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dHR.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dHR.setOnDrawListener(null);
        }
    }
}
