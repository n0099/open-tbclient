package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
import com.baidu.tieba.j.k;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.play.x;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private String aiZ;
    private bb atE;
    private View axB;
    private final View.OnClickListener axL;
    private final View.OnClickListener axw;
    private String bHB;
    private RelativeLayout bHM;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public View bHP;
    protected ThreadSourceShareAndPraiseLayout bIC;
    public LinearLayout bIN;
    public ThreadSkinView bIO;
    private HeadPendantClickableView bIz;
    public FrameLayout bcQ;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private QuickVideoView bcU;
    private TextView bcV;
    private View bcW;
    private w bcX;
    private View bcY;
    private TextView bcZ;
    private int bda;
    private String bdb;
    private TbImageView.a bdc;
    private g.b bdd;
    private ViewTreeObserver.OnGlobalLayoutListener bde;
    private Runnable bdf;
    private Runnable bdg;
    private QuickVideoView.b bdh;
    private g.a bjM;
    private g.f bjN;
    private View bkJ;
    private Animation bvg;
    private com.baidu.tieba.play.j bvs;
    private TbImageView cAJ;
    private LinearLayout cAg;
    private n cBx;
    private ThreadGodReplyLayout cws;
    private com.baidu.tieba.play.g cyB;
    private k cyD;
    private int cyF;
    private boolean cyG;
    private TextView cyK;
    private Handler cyL;
    private VideoLoadingProgressView.a cyM;
    private j.a cyQ;
    private Animation.AnimationListener cyR;
    private View.OnClickListener cyz;
    public TextView duS;
    public LinearLayout duT;
    private com.baidu.tieba.frs.vc.g duU;
    public boolean duV;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.cyB != null) {
            try {
                this.bcU.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int sh = x.bkT().sh(this.bdb);
            if (sh != 0) {
                if (this.bcU != null) {
                    this.bcU.rH(sh);
                } else {
                    this.cyB.seekTo(sh);
                }
            }
            this.cyL.sendEmptyMessageDelayed(202, 40L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cyF = 0;
        this.bda = 1;
        this.cyG = false;
        this.cyL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aiO();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.aiP();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bjN = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cyB = gVar;
                if (a.this.cyB != null) {
                    a.this.cyB.setVolume(0.0f, 0.0f);
                }
                a.this.cyD.aVV();
                a.this.aiK();
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                x.bkT().remove(a.this.bdb);
                a.this.bcU.start();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.aib();
                a.this.e(true, 4);
                return true;
            }
        };
        this.cyM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aiK();
            }
        };
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.23
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && a.this.bcS != null) {
                    a.this.bcS.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bde = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bcQ != null && a.this.bcQ.getLayoutParams() != null && a.this.bcQ.getVisibility() != 8) {
                    a.this.bcQ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bcQ.getLayoutParams();
                    if (a.this.bcQ.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bcQ.getWidth() * 0.5625d);
                        a.this.bcQ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bcU != null && !a.this.bcU.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bdg = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // java.lang.Runnable
            public void run() {
                a.this.aib();
                a.this.e(true, 4);
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cyz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atE != null && !StringUtils.isNull(a.this.atE.vp())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.atE.vp(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.axw != null) {
                        a.this.axw.onClick(view);
                    }
                }
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.atE);
                }
            }
        };
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atE != null && a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.atE);
                }
            }
        };
        this.cyQ = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.j.a
            public void aiR() {
                a.this.aiL();
            }
        };
        this.cyR = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bda == 3 && a.this.bcS != null) {
                    a.this.bcS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mContext = tbPageContext;
        View view = getView();
        this.bkJ = view.findViewById(f.g.divider_line);
        this.bHM = (RelativeLayout) view.findViewById(f.g.layout_root);
        this.cAJ = (TbImageView) view.findViewById(f.g.frs_normal_item_star_view);
        this.duT = (LinearLayout) view.findViewById(f.g.video_card_content_layout);
        this.bHM.setOnClickListener(this);
        this.bIz = (HeadPendantClickableView) this.bHM.findViewById(f.g.card_home_page_video_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mContext.getPageActivity(), f.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.duS = (TextView) view.findViewById(f.g.thread_info_bar_name);
        this.duS.setVisibility(8);
        this.duS.setOnClickListener(this.cyz);
        this.bcX = new w((ViewGroup) view.findViewById(f.g.auto_video_loading_container));
        this.bcX.setLoadingAnimationListener(this.cyM);
        this.mTextTitle = (TextView) view.findViewById(f.g.text_title);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.text_bottom);
        this.bHO.setForumAfterClickListener(this.axw);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_home_page_auto_video_user_info_layout);
        this.bHN.setFrom(3);
        this.bHP = view.findViewById(f.g.divider_below_reply_number_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShareVisible(true);
        this.bHO.setShareReportFrom(1);
        this.bHO.setStType("frs_page");
        this.bHO.setFrom(2);
        this.bHO.ajY = 3;
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.text_bottom_threaad);
        this.bIC.ayo.setOnClickListener(this);
        this.bIC.setFrom(2);
        this.bIC.setShareReportFrom(1);
        this.bIC.setSourceFromForPb(3);
        this.bIC.setStType("frs_page");
        this.bIC.setHideBarName(true);
        this.bcQ = (FrameLayout) view.findViewById(f.g.frame_video);
        this.bcQ.setOnClickListener(this);
        this.bcQ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bcQ != null) {
                    a.this.bcQ.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bde);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bcQ != null) {
                    a.this.bcQ.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bde);
                }
            }
        });
        this.bcS = (TbImageView) view.findViewById(f.g.image_video);
        this.bcS.setPageId(getTag());
        this.bcS.setDefaultErrorResource(0);
        this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.bcS.setEvent(this.bdc);
        this.bcS.setGifIconSupport(false);
        this.bcT = (ImageView) view.findViewById(f.g.image_video_play);
        this.bcU = (QuickVideoView) view.findViewById(f.g.texture_video_view);
        this.cBx = new n(this.mContext.getPageActivity());
        this.bcU.setBusiness(this.cBx);
        this.bcU.setOnPreparedListener(this.bjN);
        this.bcU.setOnCompletionListener(this.bjM);
        this.bcU.setOnErrorListener(this.bdd);
        this.bcU.setOnSurfaceDestroyedListener(this.bdh);
        this.bvs = new com.baidu.tieba.play.j();
        this.bvs.setPlayer(this.bcU);
        this.bvs.a(this.cyQ);
        this.bcY = view.findViewById(f.g.auto_video_black_mask);
        this.bcV = (TextView) view.findViewById(f.g.auto_video_error_tips);
        this.bcW = view.findViewById(f.g.auto_video_error_background);
        this.bIN = (LinearLayout) view.findViewById(f.g.video_card_content_layout);
        this.bIO = (ThreadSkinView) view.findViewById(f.g.frs_thread_skin);
        this.bvg = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.fade_out_video_cover);
        this.bvg.setAnimationListener(this.cyR);
        this.bcR = (TextView) view.findViewById(f.g.text_video_duration);
        this.bcZ = (TextView) view.findViewById(f.g.text_video_play_count);
        this.cAg = (LinearLayout) view.findViewById(f.g.duration_container);
        this.duU = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bHM);
        this.duU.setUniqueId(getTag());
        this.cws = (ThreadGodReplyLayout) view.findViewById(f.g.card_god_reply_layout);
        this.cws.setOnClickListener(this);
        this.axB = view.findViewById(f.g.thread_multi_del_mask_view);
        this.axB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bHO != null) {
                    a.this.bHO.changeSelectStatus();
                }
            }
        });
        this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aV(boolean z) {
                if (a.this.axB != null) {
                    am.j(a.this.axB, z ? f.d.cp_bg_line_d : f.d.transparent);
                }
            }
        });
        this.cyK = (TextView) view.findViewById(f.g.nani_video_icon);
        this.cyD = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bHM || view == this.bHO.getCommentNumView() || view == this.duT) {
            am(this.bHM);
        } else if (view == this.bcQ) {
            if (this.atE != null && this.atE.vB() != null) {
                z = this.atE.vB().is_vertical.intValue() == 1;
            }
            if (z) {
                ak(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ax(this.bcQ);
            } else {
                am(this.bcQ);
            }
        } else if (view == this.cws) {
            am(this.cws);
        }
        if (this.atE != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atE));
        }
    }

    private void ak(View view) {
        if (aiC() != null) {
            aiC().a(view, this.atE);
        }
        if (!com.baidu.adp.lib.util.j.jE()) {
            l.showToast(this.mContext.getPageActivity(), f.j.no_network_guide);
        } else {
            aiM();
        }
    }

    private void aiM() {
        if (this.atE != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.atE);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs")));
        }
    }

    private void ax(View view) {
        if (this.atE != null) {
            an anVar = new an("c11100");
            anVar.ae("tid", this.atE.getId());
            anVar.ae(ImageViewerConfig.FORUM_ID, this.atE.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aiC() != null) {
            aiC().a(view, this.atE);
        }
        if (view == this.bcQ) {
            if (!com.baidu.adp.lib.util.j.jE()) {
                l.showToast(this.mContext.getPageActivity(), f.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.jF() && !com.baidu.tieba.video.g.bAk().bAl()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(f.g.tv_title)).setText(f.j.confirm_title);
                ((TextView) inflate.findViewById(f.g.tv_msg)).setText(f.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(f.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.tbadk.browser.a.a(true, a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(f.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                aVar.w(inflate);
                aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.aiN();
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.ch(1);
                aVar.cg(f.d.cp_cont_b);
                aVar.av(true);
                aVar.b(this.mTbPageContext).xe();
            } else {
                aiN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiN() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.atE);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bIN.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bIN.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "frs", this.atE.getTid(), o.uX(), "", videoSerializeVideoThreadInfo)));
    }

    private void am(View view) {
        String str;
        String str2;
        if (this.atE != null) {
            if (this.atE.wa()) {
                TiebaStatic.log(new an("c10242").ae(ImageViewerConfig.FORUM_ID, String.valueOf(this.atE.getFid())).r("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.ae("tid", this.atE.getId());
                anVar.ae(ImageViewerConfig.FORUM_ID, this.atE.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.atE.vj() != null && this.atE.vj().getGodUserData() != null && this.atE.vj().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").r("obj_locate", 3).ae("tid", this.atE.getId()));
            }
        }
        if (aiC() != null) {
            aiC().a(view, this.atE);
        }
        if (this.atE != null) {
            o.kY(this.atE.getId());
            am.c(this.mTextTitle, f.d.cp_cont_d, 1);
            t.hG(this.atE.getId());
            String valueOf = String.valueOf(this.atE.getFid());
            if (this.atE.ajQ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.atE.ajQ.id;
                str2 = valueOf;
            }
            if (this.atE.vF() > 0 && com.baidu.tieba.tbadkCore.util.e.bxi()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.atE.getTid(), String.valueOf(this.atE.vF()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.atE.wa() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.atE.wj());
                createHistoryCfg.setSmartFrsPosition(this.atE.wq());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cws) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.atE, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.atE.wa() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.atE.wj());
            createFromThreadCfg.setSmartFrsPosition(this.atE.wq());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cws) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        this.atE = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiO() {
        this.cyL.removeMessages(202);
        if (this.bcU.getCurrentPosition() > 0) {
            e(true, 3);
            this.cyL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            if (this.atE != null && this.atE.vB() != null) {
                this.cyD.a(this.atE.getTid(), this.atE.vB().video_length.intValue(), this.atE.vB().video_duration.intValue(), "frs");
                return;
            }
            return;
        }
        this.cyL.sendEmptyMessageDelayed(202, 40L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiP() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cyL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bcU.getCurrentPosition();
        if (currentPosition != this.cyF) {
            this.cyF = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cyL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bcT != null && this.bcS != null && this.bcY != null && this.bcX != null && this.bcW != null && this.bcV != null) {
            if (z || this.bda != i) {
                this.bda = i;
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
                if (i == 2) {
                    this.bcT.setVisibility(8);
                    this.bvg.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.cAg.setVisibility(0);
                    this.bcX.startLoading();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdg, 60000L);
                } else if (i == 3) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bvg);
                    this.bcY.setVisibility(8);
                    this.cAg.setVisibility(8);
                    this.bcX.bkO();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                } else if (i == 4) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bvg);
                    this.bcY.setVisibility(8);
                    this.bcX.bkP();
                    this.bcW.setVisibility(0);
                    this.bcV.setVisibility(0);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdf, 2000L);
                } else {
                    this.bcT.setVisibility(0);
                    this.cAg.setVisibility(0);
                    this.bvg.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.bcX.bkP();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                }
            }
        }
    }

    private void M(final bb bbVar) {
        if (this.cAJ != null) {
            if (bbVar == null) {
                this.cAJ.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI)) {
                if (this.duU != null && this.duU.aAJ() && (this.cAJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAJ.getLayoutParams();
                    layoutParams.rightMargin = l.f(this.mContext.getContext(), f.e.tbds106);
                    this.cAJ.setLayoutParams(layoutParams);
                }
                this.cAJ.setVisibility(0);
                this.cAJ.setImageDrawable(null);
                this.cAJ.startLoad(bbVar.ajI, 10, false);
                this.cAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAJ.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.atE == null || this.atE.vj() == null) {
            this.bHM.setVisibility(8);
            return;
        }
        this.bHM.setVisibility(0);
        this.bHM.setOnClickListener(this);
        aiQ();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.aiZ)) {
            this.atE.O(this.mUrl, this.aiZ);
        }
        this.atE.e(false, true);
        SpannableStringBuilder vI = this.atE.vI();
        if (this.atE.vO() && !StringUtils.isNull(this.atE.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.atE.getTid();
            vI.append((CharSequence) this.atE.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.7
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(f.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(vI));
        this.mTextTitle.setText(vI);
        this.duU.ae(this.atE);
        M(this.atE);
        this.bHN.setData(this.atE);
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (this.atE.vj() == null || this.atE.vj().getPendantData() == null || StringUtils.isNull(this.atE.vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(this.atE);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(this.atE);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bHO.setLayoutParams(layoutParams);
        this.bHN.setUserAfterClickListener(this.axL);
        hm(gt(1));
        this.bcR.setText(ap.da(this.atE.vB().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(f.j.play_count), ap.H(this.atE.vB().play_count.intValue())));
        this.cws.setData(this.atE.ww());
        this.cws.onChangeSkinType();
        if (o.kZ(this.atE.getId())) {
            am.c(this.mTextTitle, f.d.cp_cont_d, 1);
            o.a(this.cws.getGodReplyContent(), this.atE.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
        } else {
            am.c(this.mTextTitle, f.d.cp_cont_b, 1);
        }
        if (this.atE == null || this.atE.vB() == null) {
            z = false;
        } else {
            z = this.atE.vB().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cyK.setVisibility(0);
        } else {
            this.cyK.setVisibility(8);
        }
        if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atC().atD()) {
            this.axB.setVisibility(0);
            if (this.atE.wG() || this.atE.wH()) {
                am.j(this.axB, f.d.cp_bg_line_d);
            } else {
                this.axB.setBackgroundResource(f.d.transparent);
            }
        } else {
            this.axB.setVisibility(8);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aib() {
        this.cyL.removeMessages(202);
        this.cyL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Ng() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
    }

    private void aiQ() {
        Ng();
        aib();
        if (this.bcS != null && this.bcQ != null && this.bcU != null) {
            if (com.baidu.tbadk.core.i.td().tj() && this.atE != null && this.atE.vB() != null) {
                this.bcQ.setVisibility(0);
                this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                this.bcS.startLoad(this.atE.vB().thumbnail_url, 10, false);
                stopPlay();
                this.bdb = this.atE.vB().video_url;
                if (StringUtils.isNull(this.bdb)) {
                    e(true, 4);
                    TiebaStatic.log(new an("c12026").ae("tid", this.atE.getId()));
                }
                if (this.cBx != null && this.cBx.bkx() != null) {
                    this.cBx.bkx().g(this.atE.vB());
                    return;
                }
                return;
            }
            this.bcQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bHM, f.C0146f.addresslist_item_bg);
            am.c(this.bcT, f.C0146f.btn_icon_play_video_n);
            am.h(this.bcV, f.d.cp_cont_i);
            am.h(this.bcR, f.d.cp_cont_i);
            am.h(this.bcZ, f.d.cp_cont_i);
            am.j(this.bcW, f.d.common_color_10014);
            am.j(this.bkJ, f.d.cp_bg_line_e);
            if (this.bcV != null) {
                this.bcV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bIC != null && this.bIC.getVisibility() == 0) {
                this.bIC.onChangeSkinType();
            }
            this.bHO.onChangeSkinType();
            this.mSkinType = i;
            this.bHN.onChangeSkinType();
            this.duU.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.currentPageType = i;
        if (this.bHO != null) {
            this.bHO.ajY = i;
            if (i == 15) {
                this.bHO.setFrom(10);
            } else {
                this.bHO.setFrom(2);
            }
        }
        if (this.bHN != null) {
            if (i == 15) {
                this.bHN.setFrom(5);
            } else {
                this.bHN.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cyG;
    }

    public boolean isPlaying() {
        if (this.bcU == null) {
            return false;
        }
        return this.bcU.isPlaying();
    }

    public void startPlay() {
        if (!this.cyG && this.atE != null && this.atE.vB() != null && this.bcU != null && y.LI()) {
            if (this.duV || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                this.cyD.aVU();
                e(true, 2);
                if (StringUtils.isNull(this.bdb)) {
                    TiebaStatic.log(new an("c12619").ae("obj_locate", "frs").ae("tid", this.atE.getId()));
                    this.bdb = this.atE.vB().video_url;
                }
                this.bcU.setVideoPath(this.bdb, this.atE.getId());
                if (this.bvs != null) {
                    this.bvs.start();
                }
                this.cyG = true;
                aiL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiL() {
        if (this.atE != null && this.atE.vB() != null) {
            String str = this.atE.wa() ? "floor5" : "frs";
            if (this.atE.vo()) {
                str = "frs_mcn";
            }
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.aWq = this.atE.getTid();
            yVar.cBR = this.atE.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.atE.mRecomSource;
            yVar.ghB = this.atE.mRecomAbTag;
            yVar.ghC = this.atE.mRecomWeight;
            yVar.ghD = "";
            yVar.ghF = this.atE.vB().video_md5;
            com.baidu.tieba.play.l.a(this.atE.vB().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        Ng();
        aib();
        e(true, 1);
        if (this.bcU != null) {
            if (this.bcU.isPlaying()) {
                x.bkT().aD(this.bdb, this.bcU.getCurrentPosition());
            }
            this.bcU.stopPlayback();
            if (this.bvs != null) {
                this.bvs.stop();
            }
        }
        this.cyG = false;
    }

    public ThreadCommentAndPraiseInfoLayout VD() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VE() {
        return this.bIC.ayo;
    }

    public View getVideoContainer() {
        return this.bcQ;
    }

    public String getPlayUrl() {
        return this.bdb;
    }

    public int getCurrentPosition() {
        if (this.bcU == null) {
            return 0;
        }
        return this.bcU.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.cBx != null) {
            this.cBx.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHO != null && this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
    }

    public void hm(int i) {
        if (this.atE != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.atE);
                this.bHP.setVisibility(8);
                return;
            }
            this.bHP.setVisibility(this.bHO.setData(this.atE) ? 0 : 8);
            this.bIC.setVisibility(8);
        }
    }

    public void O(String str, String str2) {
        this.mUrl = str;
        this.aiZ = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
