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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.y;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bd> implements t {
    private TbPageContext<?> aRR;
    private bd aZM;
    private g.f bPD;
    private g.b bPE;
    private View bQA;
    private String bQV;
    private final View.OnClickListener bdQ;
    private final View.OnClickListener bec;
    private ThreadGodReplyLayout cVG;
    private TextView cWB;
    private View cWC;
    private y cWD;
    private View cWF;
    private int cWG;
    private int cWH;
    private boolean cWI;
    private Handler cWM;
    private VideoLoadingProgressView.a cWN;
    private TbImageView.a cWO;
    private Runnable cWP;
    private Runnable cWQ;
    private j.a cWU;
    private Animation.AnimationListener cWV;
    private TbImageView cWp;
    private TextView cWq;
    private View.OnClickListener cWu;
    public FrameLayout cWw;
    private QuickVideoView cWx;
    private com.baidu.tieba.play.g cWy;
    private TextView cWz;
    private TbImageView cYY;
    private LinearLayout cYw;
    private com.baidu.tieba.play.n cZD;
    private ImageView caJ;
    private Animation caN;
    private com.baidu.tieba.play.j caZ;
    private QuickVideoView.b cbh;
    private HeadPendantClickableView cmU;
    protected ThreadSourceShareAndPraiseLayout cmX;
    private RelativeLayout cmi;
    public ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    public View cml;
    public LinearLayout cnj;
    public ThreadSkinView cnk;
    public TextView dLH;
    public LinearLayout dLI;
    private com.baidu.tieba.frs.g.g dLJ;
    private ViewTreeObserver.OnGlobalLayoutListener dLK;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.cWy != null) {
            try {
                this.cWx.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cWM.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWG = 0;
        this.cWH = 1;
        this.cWI = false;
        this.cWM = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.ala();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.alb();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPD = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cWy = gVar;
                a.this.cWy.setVolume(0.0f, 0.0f);
                a.this.cWD.blP();
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.alc();
                a.this.i(true, 4);
                return true;
            }
        };
        this.cWN = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.akX();
            }
        };
        this.cWO = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && a.this.cWp != null) {
                    a.this.cWp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dLK = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cWw != null && a.this.cWw.getLayoutParams() != null && a.this.cWw.getVisibility() != 8) {
                    a.this.cWw.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cWw.getLayoutParams();
                    if (a.this.cWw.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cWw.getWidth() * 0.5625d);
                        a.this.cWw.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cWP = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cWx != null && !a.this.cWx.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cWQ = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.alc();
                a.this.i(true, 4);
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cWu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZM != null && !StringUtils.isNull(a.this.aZM.zt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.aRR.getPageActivity()).createNormalCfg(a.this.aZM.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bdQ != null) {
                        a.this.bdQ.onClick(view);
                    }
                }
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.aZM);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZM != null && a.this.akP() != null) {
                    a.this.akP().a(view, a.this.aZM);
                }
            }
        };
        this.cWU = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.j.a
            public void alf() {
                a.this.akY();
            }
        };
        this.cWV = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cWH == 3 && a.this.cWp != null) {
                    a.this.cWp.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.aRR = tbPageContext;
        View view = getView();
        this.bQA = view.findViewById(d.g.divider_line);
        this.cmi = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cYY = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.dLI = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cmi.setOnClickListener(this);
        this.cmU = (HeadPendantClickableView) this.cmi.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.ds70));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.dLH = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.dLH.setVisibility(8);
        this.dLH.setOnClickListener(this.cWu);
        this.cWD = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cWD.setLoadingAnimationListener(this.cWN);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.cmk.setForumAfterClickListener(this.bdQ);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.cmj.setFrom(3);
        this.cml = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setShareVisible(true);
        this.cmk.setShareReportFrom(1);
        this.cmk.setStType("frs_page");
        this.cmk.setFrom(2);
        this.cmk.aQE = 3;
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cmX.bez.setOnClickListener(this);
        this.cmX.setFrom(2);
        this.cmX.setShareReportFrom(1);
        this.cmX.setSourceFromForPb(3);
        this.cmX.setStType("frs_page");
        this.cmX.setHideBarName(true);
        this.cWw = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cWw.setOnClickListener(this);
        this.cWw.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cWw != null) {
                    a.this.cWw.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dLK);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cWw != null) {
                    a.this.cWw.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dLK);
                }
            }
        });
        this.cWp = (TbImageView) view.findViewById(d.g.image_video);
        this.cWp.setPageId(getTag());
        this.cWp.setDefaultErrorResource(0);
        this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWp.setEvent(this.cWO);
        this.cWp.setGifIconSupport(false);
        this.caJ = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWx = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cZD = new com.baidu.tieba.play.n(this.aRR.getPageActivity());
        this.cWx.setBusiness(this.cZD);
        this.cWx.setOnPreparedListener(this.bPD);
        this.cWx.setOnErrorListener(this.bPE);
        this.cWx.setOnSurfaceDestroyedListener(this.cbh);
        this.caZ = new com.baidu.tieba.play.j();
        this.caZ.setPlayer(this.cWx);
        this.caZ.a(this.cWU);
        this.cWF = view.findViewById(d.g.auto_video_black_mask);
        this.cWB = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cWC = view.findViewById(d.g.auto_video_error_background);
        this.cnj = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cnk = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.caN = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.fade_out_video_cover);
        this.caN.setAnimationListener(this.cWV);
        this.cWz = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWq = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cYw = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dLJ = new com.baidu.tieba.frs.g.g(tbPageContext, this.cmi);
        this.dLJ.setUniqueId(getTag());
        this.cVG = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVG.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cmi || view == this.cmk.getCommentNumView() || view == this.dLI) {
            bC(this.cmi);
        } else if (view == this.cWw) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bN(this.cWw);
            } else {
                bC(this.cWw);
            }
        } else if (view == this.cVG) {
            bC(this.cVG);
        }
        if (this.aZM != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aZM));
        }
    }

    private void bN(View view) {
        if (this.aZM != null) {
            ak akVar = new ak("c11100");
            akVar.ab("tid", this.aZM.getId());
            akVar.ab(ImageViewerConfig.FORUM_ID, this.aZM.getFid() + "");
            TiebaStatic.log(akVar);
        }
        if (akP() != null) {
            akP().a(view, this.aZM);
        }
        if (view == this.cWw) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.aRR.getPageActivity(), d.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.oK()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
                aVar.dk(this.aRR.getString(d.j.enter_video_center_page_no_wifi_tip));
                aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.akZ();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.aZ(true);
                aVar.b(this.mTbPageContext).AU();
            } else {
                akZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aZM);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.cnj.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.cnj.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRR.getPageActivity(), "frs", this.aZM.getTid(), com.baidu.tieba.card.j.zd(), "", videoSerializeVideoThreadInfo)));
    }

    private void bC(View view) {
        if (this.aZM != null) {
            if (this.aZM.Ae()) {
                TiebaStatic.log(new ak("c10242").ab(ImageViewerConfig.FORUM_ID, String.valueOf(this.aZM.getFid())).s("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ab("tid", this.aZM.getId());
                akVar.ab(ImageViewerConfig.FORUM_ID, this.aZM.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.aZM.zn() != null && this.aZM.zn().getGodUserData() != null && this.aZM.zn().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", this.aZM.getId()));
            }
        }
        if (akP() != null) {
            akP().a(view, this.aZM);
        }
        if (this.aZM != null) {
            com.baidu.tieba.card.j.kr(this.aZM.getId());
            aj.e(this.mTextTitle, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.util.t.hr(this.aZM.getId());
            if (this.aZM.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxT()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aRR.getPageActivity()).createHistoryCfg(this.aZM.getTid(), String.valueOf(this.aZM.zK()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.aZM.Ae() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aZM.An());
                createHistoryCfg.setSmartFrsPosition(this.aZM.Au());
                createHistoryCfg.setForumId(String.valueOf(this.aZM.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cVG) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aRR.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aRR.getPageActivity()).createFromThreadCfg(this.aZM, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aZM.Ae() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aZM.An());
            createFromThreadCfg.setSmartFrsPosition(this.aZM.Au());
            createFromThreadCfg.setForumId(String.valueOf(this.aZM.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cVG) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aRR.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        this.aZM = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        this.cWM.removeMessages(202);
        if (this.cWx.getCurrentPosition() > 0) {
            i(true, 3);
            this.cWM.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cWM.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cWM.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cWx.getCurrentPosition();
        if (currentPosition != this.cWG) {
            this.cWG = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cWM.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.caJ != null && this.cWp != null && this.cWF != null && this.cWD != null && this.cWC != null && this.cWB != null) {
            if (z || this.cWH != i) {
                this.cWH = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWQ);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWP);
                if (i == 2) {
                    this.caJ.setVisibility(8);
                    this.caN.cancel();
                    this.cWp.clearAnimation();
                    this.cWp.setVisibility(0);
                    this.cWF.setVisibility(0);
                    this.cYw.setVisibility(0);
                    this.cWD.startLoading();
                    this.cWC.setVisibility(8);
                    this.cWB.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWQ, 60000L);
                } else if (i == 3) {
                    this.caJ.setVisibility(8);
                    this.cWp.startAnimation(this.caN);
                    this.cWF.setVisibility(8);
                    this.cYw.setVisibility(8);
                    this.cWD.blQ();
                    this.cWC.setVisibility(8);
                    this.cWB.setVisibility(8);
                } else if (i == 4) {
                    this.caJ.setVisibility(8);
                    this.cWp.startAnimation(this.caN);
                    this.cWF.setVisibility(8);
                    this.cWD.blR();
                    this.cWC.setVisibility(0);
                    this.cWB.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWP, 2000L);
                } else {
                    this.caJ.setVisibility(0);
                    this.cYw.setVisibility(0);
                    this.caN.cancel();
                    this.cWp.clearAnimation();
                    this.cWp.setVisibility(0);
                    this.cWF.setVisibility(0);
                    this.cWD.blR();
                    this.cWC.setVisibility(8);
                    this.cWB.setVisibility(8);
                }
            }
        }
    }

    private void H(final bd bdVar) {
        if (this.cYY != null) {
            if (bdVar == null) {
                this.cYY.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQx)) {
                if (this.dLJ != null && this.dLJ.aAu() && (this.cYY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYY.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.aRR.getContext(), d.e.tbds106);
                    this.cYY.setLayoutParams(layoutParams);
                }
                this.cYY.setVisibility(0);
                this.cYY.setImageDrawable(null);
                this.cYY.startLoad(bdVar.aQx, 10, false);
                this.cYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.aRR != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bdVar.aQy, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYY.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        if (this.aZM == null || this.aZM.zn() == null) {
            this.cmi.setVisibility(8);
            return;
        }
        this.cmi.setVisibility(0);
        ale();
        this.aZM.h(false, true);
        SpannableStringBuilder zN = this.aZM.zN();
        if (this.aZM.zT() && !StringUtils.isNull(this.aZM.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aZM.getTid();
            zN.append((CharSequence) this.aZM.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.b.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(zN));
        this.mTextTitle.setText(zN);
        this.dLJ.W(this.aZM);
        H(this.aZM);
        this.cmj.setData(this.aZM);
        if (this.cmj.getHeaderImg() != null) {
            if (this.cmj.getIsSimpleThread()) {
                this.cmj.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (this.aZM.zn() == null || this.aZM.zn().getPendantData() == null || StringUtils.isNull(this.aZM.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.cmj.getHeaderImg().setVisibility(0);
                this.cmj.getHeaderImg().setData(this.aZM);
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(this.aZM);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.cmk.setLayoutParams(layoutParams);
        this.cmj.setUserAfterClickListener(this.bec);
        jX(this.aZM.aQz);
        this.cWz.setText(am.fV(this.aZM.zF().video_duration.intValue() * 1000));
        this.cWq.setText(String.format(this.aRR.getResources().getString(d.j.play_count), am.J(this.aZM.zF().play_count.intValue())));
        this.cVG.setData(this.aZM.AA());
        this.cVG.onChangeSkinType();
        if (com.baidu.tieba.card.j.ks(this.aZM.getId())) {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_d, 1);
            com.baidu.tieba.card.j.a(this.cVG.getGodReplyContent(), this.aZM.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        } else {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
        d(this.aRR, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alc() {
        this.cWM.removeMessages(202);
        this.cWM.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void ald() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWP);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWQ);
    }

    private void ale() {
        ald();
        alc();
        if (this.cWp != null && this.cWw != null && this.cWx != null) {
            if (com.baidu.tbadk.core.i.xo().xu() && this.aZM != null && this.aZM.zF() != null) {
                this.cWw.setVisibility(0);
                this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWp.startLoad(this.aZM.zF().thumbnail_url, 10, false);
                stopPlay();
                this.bQV = this.aZM.zF().video_url;
                if (StringUtils.isNull(this.bQV)) {
                    i(true, 4);
                    TiebaStatic.log(new ak("c12026").ab("tid", this.aZM.getId()));
                }
                if (this.cZD != null && this.cZD.blz() != null) {
                    this.cZD.blz().d(this.aZM.zF());
                    return;
                }
                return;
            }
            this.cWw.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cmi, d.f.addresslist_item_bg);
            aj.c(this.caJ, d.f.btn_icon_play_video_n);
            aj.r(this.cWB, d.C0140d.cp_cont_i);
            aj.r(this.cWz, d.C0140d.cp_cont_i);
            aj.r(this.cWq, d.C0140d.cp_cont_i);
            aj.t(this.cWC, d.C0140d.common_color_10014);
            aj.t(this.bQA, d.C0140d.cp_bg_line_e);
            if (this.cWB != null) {
                this.cWB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.cmX != null && this.cmX.getVisibility() == 0) {
                this.cmX.onChangeSkinType();
            }
            this.cmk.onChangeSkinType();
            this.mSkinType = i;
            this.cmj.onChangeSkinType();
            this.dLJ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cWI;
    }

    public boolean isPlaying() {
        if (this.cWx == null) {
            return false;
        }
        return this.cWx.isPlaying();
    }

    public void startPlay() {
        if (!this.cWI && this.aZM != null && this.aZM.zF() != null && this.cWx != null && com.baidu.tbadk.util.y.p(2, this.bQV)) {
            i(true, 2);
            if (StringUtils.isNull(this.bQV)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "frs").ab("tid", this.aZM.getId()));
                this.bQV = this.aZM.zF().video_url;
            }
            this.cWx.bN(this.bQV, this.aZM.getId());
            this.cWx.setLooping(true);
            if (this.caZ != null) {
                this.caZ.start();
            }
            this.cWI = true;
            akY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.aZM != null && this.aZM.zF() != null) {
            String str = this.aZM.Ae() ? "floor5" : "frs";
            aa aaVar = new aa();
            aaVar.mLocate = str;
            aaVar.bDf = this.aZM.getTid();
            aaVar.cZU = this.aZM.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.aZM.mRecomSource;
            aaVar.gvW = this.aZM.mRecomAbTag;
            aaVar.gvX = this.aZM.mRecomWeight;
            aaVar.gvY = "";
            aaVar.gwa = this.aZM.zF().video_md5;
            com.baidu.tieba.play.l.a(this.aZM.zF().video_md5, "", "1", aaVar);
        }
    }

    public void stopPlay() {
        ald();
        alc();
        i(true, 1);
        if (this.cWx != null) {
            this.cWx.stopPlayback();
            if (this.caZ != null) {
                this.caZ.stop();
            }
        }
        this.cWI = false;
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmk;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmX.bez;
    }

    public View getVideoContainer() {
        return this.cWw;
    }

    public String getPlayUrl() {
        return this.bQV;
    }

    public int getCurrentPosition() {
        if (this.cWx == null) {
            return 0;
        }
        return this.cWx.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cZD != null) {
            this.cZD.setVideoStatsData(aaVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cmk != null && this.cmj != null) {
            this.cmj.setPageUniqueId(bdUniqueId);
        }
    }

    public void jX(int i) {
        if (this.aZM != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setData(this.aZM);
                this.cml.setVisibility(8);
                return;
            }
            this.cml.setVisibility(this.cmk.setData(this.aZM) ? 0 : 8);
            this.cmX.setVisibility(8);
        }
    }
}
