package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.i;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.w;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bl> implements v {
    private f.d aTA;
    private f.b aTB;
    private View aUp;
    private TbPageContext<?> aaS;
    private bl aiQ;
    private final View.OnClickListener anD;
    private final View.OnClickListener ann;
    private View.OnClickListener ant;
    public FrameLayout bCP;
    private TbImageView bCQ;
    private ImageView bCR;
    private TbImageView.a bCT;
    private HeadPendantClickableView bEC;
    private ThreadGodReplyLayout bED;
    private QuickVideoView bFC;
    private TextView bFE;
    private TextView bFF;
    private View bFG;
    private AudioAnimationView bFH;
    private ProgressBar bFI;
    private ImageView bFJ;
    private View bFL;
    private int bFM;
    private int bFN;
    private boolean bFO;
    private com.baidu.tieba.play.i bFQ;
    private Animation bFR;
    private Handler bFS;
    private Runnable bFT;
    private Runnable bFU;
    private QuickVideoView.b bFV;
    private i.a bFZ;
    private Animation.AnimationListener bGa;
    private m bHT;
    private View bfY;
    private RelativeLayout bjC;
    public ThreadUserInfoLayout bjL;
    public ThreadCommentAndPraiseInfoLayout bjP;
    public View bjQ;
    public LinearLayout bjT;
    public ThreadSkinView bjU;
    public TextView cnu;
    public LinearLayout cnv;
    private com.baidu.tieba.frs.h.g cnw;
    private ViewTreeObserver.OnGlobalLayoutListener cnx;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bFM = 0;
        this.bFN = 1;
        this.bFO = false;
        this.bFS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.Wh();
                        return;
                    case 203:
                        a.this.Wi();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aTA = new f.d() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bFS.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aTB = new f.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                a.this.Wj();
                a.this.f(true, 4);
                return true;
            }
        };
        this.bCT = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && a.this.bCQ != null) {
                    a.this.bCQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cnx = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bCP != null && a.this.bCP.getLayoutParams() != null && a.this.bCP.getVisibility() != 8) {
                    a.this.bCP.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bCP.getLayoutParams();
                    if (a.this.bCP.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bCP.getWidth() * 0.5625d);
                        a.this.bCP.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bFT = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bFC != null && !a.this.bFC.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.bFU = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.Wj();
                a.this.f(true, 4);
            }
        };
        this.bFV = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.ant = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiQ != null && !StringUtils.isNull(a.this.aiQ.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.aaS.getPageActivity()).createNormalCfg(a.this.aiQ.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.ann != null) {
                        a.this.ann.onClick(view);
                    }
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.VZ() != null) {
                    a.this.VZ().a(view, a.this.aiQ);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiQ != null && a.this.VZ() != null) {
                    a.this.VZ().a(view, a.this.aiQ);
                }
            }
        };
        this.bFZ = new i.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.i.a
            public void Wm() {
                a.this.Wz();
            }
        };
        this.bGa = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bFN == 3 && a.this.bCQ != null) {
                    a.this.bCQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.aaS = tbPageContext;
        View view = getView();
        this.aUp = view.findViewById(d.h.divider_line);
        this.bjC = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.cnv = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bjC.setOnClickListener(this);
        this.bEC = (HeadPendantClickableView) this.bjC.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aaS.getPageActivity(), d.f.ds70));
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.cnu = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.cnu.setVisibility(8);
        this.cnu.setOnClickListener(this.ant);
        this.bFI = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bFJ = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bjL = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bjL.setFrom(3);
        this.bjQ = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bjP.setOnClickListener(this);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(true);
        this.bjP.setIsBarViewVisible(false);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bCP = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bCP.setOnClickListener(this);
        this.bCP.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bCP != null) {
                    a.this.bCP.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cnx);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bCP != null) {
                    a.this.bCP.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cnx);
                }
            }
        });
        this.bCQ = (TbImageView) view.findViewById(d.h.image_video);
        this.bCQ.setPageId(getTag());
        this.bCQ.setDefaultErrorResource(0);
        this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bCQ.setEvent(this.bCT);
        this.bCQ.setGifIconSupport(false);
        this.bCR = (ImageView) view.findViewById(d.h.image_video_play);
        this.bFH = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bFH.setCertainColumnCount(4);
        this.bFH.setColumnColor(d.e.cp_cont_i);
        this.bFC = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bHT = new m(this.aaS.getPageActivity());
        this.bFC.setBusiness(this.bHT);
        this.bFC.setOnPreparedListener(this.aTA);
        this.bFC.setOnErrorListener(this.aTB);
        this.bFC.setOnSurfaceDestroyedListener(this.bFV);
        this.bFQ = new com.baidu.tieba.play.i();
        this.bFQ.setPlayer(this.bFC);
        this.bFQ.a(this.bFZ);
        this.bFL = view.findViewById(d.h.auto_video_black_mask);
        this.bFF = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bFG = view.findViewById(d.h.auto_video_error_background);
        this.bjT = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bjU = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bFR = AnimationUtils.loadAnimation(this.aaS.getPageActivity(), d.a.fade_out_video_cover);
        this.bFR.setAnimationListener(this.bGa);
        this.bFE = (TextView) view.findViewById(d.h.text_video_duration);
        this.cnw = new com.baidu.tieba.frs.h.g(tbPageContext, this.bjL);
        this.cnw.setUniqueId(getTag());
        this.bfY = view.findViewById(d.h.divider_line);
        this.bED = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bED.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjC || view == this.bjP.getCommentNumView() || view == this.cnv) {
            X(this.bjC);
        } else if (view == this.bCP) {
            X(this.bCP);
        } else if (view == this.bED) {
            X(this.bED);
        }
        if (this.aiQ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiQ));
        }
    }

    private void X(View view) {
        if (this.aiQ != null) {
            if (this.aiQ.sp()) {
                TiebaStatic.log(new aj("c10242").aa("fid", String.valueOf(this.aiQ.getFid())).r("obj_type", 2));
            } else {
                aj ajVar = new aj("c11100");
                ajVar.aa("tid", this.aiQ.getId());
                ajVar.aa("fid", this.aiQ.getFid() + "");
                TiebaStatic.log(ajVar);
            }
            if (this.aiQ.getAuthor() != null && this.aiQ.getAuthor().getGodUserData() != null && this.aiQ.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", this.aiQ.getId()));
            }
        }
        if (VZ() != null) {
            VZ().a(view, this.aiQ);
        }
        if (this.aiQ != null) {
            com.baidu.tieba.card.m.iY(this.aiQ.getId());
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            s.gN(this.aiQ.getId());
            if (this.aiQ.rR() > 0 && com.baidu.tieba.tbadkCore.util.g.btp()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aaS.getPageActivity()).createHistoryCfg(this.aiQ.getTid(), String.valueOf(this.aiQ.rR()), false, true, com.baidu.tieba.card.m.rm());
                createHistoryCfg.setVideo_source(this.aiQ.sp() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aiQ.sy());
                createHistoryCfg.setSmartFrsPosition(this.aiQ.sF());
                createHistoryCfg.setForumId(String.valueOf(this.aiQ.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bED) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aaS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aaS.getPageActivity()).createFromThreadCfg(this.aiQ, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aiQ.sp() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aiQ.sy());
            createFromThreadCfg.setSmartFrsPosition(this.aiQ.sF());
            createFromThreadCfg.setForumId(String.valueOf(this.aiQ.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bED) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aaS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        this.aiQ = blVar;
        Ot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        this.bFS.removeMessages(202);
        if (this.bFC.getCurrentPosition() > 0) {
            f(true, 3);
            this.bFS.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bFS.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bFS.removeMessages(203);
        int currentPosition = this.bFC.getCurrentPosition();
        if (currentPosition != this.bFM) {
            this.bFM = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bFS.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bCR != null && this.bCQ != null && this.bFL != null && this.bFH != null && this.bFI != null && this.bFJ != null && this.bFG != null && this.bFF != null) {
            if (z || this.bFN != i) {
                this.bFN = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bFU);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bFT);
                if (i == 2) {
                    this.bCR.setVisibility(8);
                    this.bFR.cancel();
                    this.bCQ.clearAnimation();
                    this.bCQ.setVisibility(0);
                    this.bFL.setVisibility(0);
                    this.bFE.setVisibility(0);
                    this.bFI.setVisibility(0);
                    this.bFJ.setVisibility(0);
                    this.bFG.setVisibility(8);
                    this.bFF.setVisibility(8);
                    this.bFH.setVisibility(8);
                    this.bFH.bwv();
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bFU, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bCR.setVisibility(8);
                    this.bCQ.startAnimation(this.bFR);
                    this.bFL.setVisibility(8);
                    this.bFE.setVisibility(8);
                    this.bFI.setVisibility(8);
                    this.bFJ.setVisibility(8);
                    this.bFG.setVisibility(8);
                    this.bFF.setVisibility(8);
                    this.bFH.setVisibility(0);
                    this.bFH.start();
                } else if (i == 4) {
                    this.bCR.setVisibility(8);
                    this.bCQ.startAnimation(this.bFR);
                    this.bFL.setVisibility(8);
                    this.bFI.setVisibility(8);
                    this.bFJ.setVisibility(8);
                    this.bFG.setVisibility(0);
                    this.bFF.setVisibility(0);
                    this.bFH.setVisibility(8);
                    this.bFH.bwv();
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bFT, 2000L);
                } else {
                    this.bCR.setVisibility(0);
                    this.bFE.setVisibility(0);
                    this.bFR.cancel();
                    this.bCQ.clearAnimation();
                    this.bCQ.setVisibility(0);
                    this.bFL.setVisibility(0);
                    this.bFI.setVisibility(8);
                    this.bFJ.setVisibility(8);
                    this.bFG.setVisibility(8);
                    this.bFF.setVisibility(8);
                    this.bFH.setVisibility(8);
                    this.bFH.bwv();
                }
            }
        }
    }

    private void Ot() {
        if (this.aiQ == null || this.aiQ.getAuthor() == null) {
            this.bjC.setVisibility(8);
            return;
        }
        this.bjC.setVisibility(0);
        Wl();
        this.aiQ.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.aiQ.rV()));
        this.mTextTitle.setText(this.aiQ.rV());
        this.cnw.P(this.aiQ);
        this.bjL.a(this.aiQ);
        if (this.bjL.getHeaderImg() != null) {
            if (this.bjL.getIsSimpleThread()) {
                this.bjL.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (this.aiQ.getAuthor() == null || this.aiQ.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiQ.getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.bjL.getHeaderImg().setVisibility(0);
                this.bjL.getHeaderImg().setData(this.aiQ);
            } else {
                this.bjL.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(this.aiQ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bjP.setLayoutParams(layoutParams);
        this.bjL.setUserAfterClickListener(this.anD);
        if (this.bjP.a(this.aiQ)) {
            this.bjQ.setVisibility(8);
        } else {
            this.bjQ.setVisibility(0);
        }
        this.bFE.setText(al.cX(this.aiQ.rM().video_duration.intValue() * 1000));
        this.bjP.setCommentNumClickListener(this);
        this.bED.setData(this.aiQ.sK());
        this.bED.onChangeSkinType();
        if (this.bED.getVisibility() == 0) {
            this.bjQ.setVisibility(0);
        }
        if (com.baidu.tieba.card.m.iZ(this.aiQ.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.bED.getGodReplyContent(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            com.baidu.tieba.card.m.a(this.bED.getPraiseNum(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.aaS, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wj() {
        this.bFS.removeMessages(202);
        this.bFS.removeMessages(203);
    }

    private void Wk() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bFT);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bFU);
    }

    private void Wl() {
        Wk();
        Wj();
        if (this.bCQ != null && this.bCP != null && this.bFC != null) {
            if (com.baidu.tbadk.core.h.oN().oT() && this.aiQ != null && this.aiQ.rM() != null) {
                this.bCP.setVisibility(0);
                this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bCQ.c(this.aiQ.rM().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aiQ.rM().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.bHT != null && this.bHT.bfE() != null) {
                    this.bHT.bfE().d(this.aiQ.rM());
                    return;
                }
                return;
            }
            this.bCP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bjC, d.g.addresslist_item_bg);
            ai.c(this.bCR, d.g.btn_icon_play_video_n);
            ai.i(this.bFF, d.e.cp_cont_i);
            ai.i(this.bFE, d.e.cp_cont_g);
            ai.k(this.bFG, d.e.common_color_10014);
            ai.k(this.aUp, d.e.cp_bg_line_c);
            if (this.bFF != null) {
                this.bFF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bjP.onChangeSkinType();
            this.mSkinType = i;
            this.bjL.onChangeSkinType();
            this.cnw.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bFO;
    }

    public boolean isPlaying() {
        if (this.bFC == null) {
            return false;
        }
        return this.bFC.isPlaying();
    }

    public void startPlay() {
        if (!this.bFO && this.aiQ != null && this.aiQ.rM() != null && this.bFC != null && x.r(2, this.mVideoUrl)) {
            f(true, 2);
            this.bFC.setVideoPath(this.mVideoUrl);
            this.bFC.start();
            this.bFC.setLooping(true);
            if (this.bFQ != null) {
                this.bFQ.start();
            }
            this.bFO = true;
            Wz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wz() {
        if (this.aiQ != null && this.aiQ.rM() != null) {
            String str = this.aiQ.sp() ? "floor5" : "frs";
            w wVar = new w();
            wVar.mLocate = str;
            wVar.bBT = this.aiQ.getTid();
            wVar.azk = this.aiQ.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.aiQ.Ze;
            wVar.fzl = this.aiQ.Zg;
            wVar.fzm = this.aiQ.Zf;
            wVar.fzn = "";
            if (this.aiQ.sz() != null && this.aiQ.sz().channelId > 0) {
                wVar.Vm = this.aiQ.sz().channelId + "";
            } else {
                wVar.Vm = "0";
            }
            com.baidu.tieba.play.k.a(this.aiQ.rM().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        Wk();
        Wj();
        f(true, 1);
        if (this.bFC != null) {
            this.bFC.stopPlayback();
            if (this.bFQ != null) {
                this.bFQ.stop();
            }
        }
        this.bFO = false;
    }

    public View getVideoContainer() {
        return this.bCP;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bFC == null) {
            return 0;
        }
        return this.bFC.getCurrentPosition();
    }

    public void setVideoStatsData(w wVar) {
        if (this.bHT != null) {
            this.bHT.setVideoStatsData(wVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bjP != null && this.bjL != null) {
            this.bjL.setPageUniqueId(bdUniqueId);
        }
    }
}
