package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.i;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.n> {
    private f.a aUs;
    private f.e aUt;
    private f.b aUu;
    private String aVD;
    private TbPageContext<?> aby;
    private final View.OnClickListener aoc;
    public FrameLayout bIu;
    private TbImageView bIv;
    private ImageView bIw;
    private TbImageView.a bIy;
    private HeadPendantClickableView bKh;
    private ThreadGodReplyLayout bKi;
    private View bKj;
    private com.baidu.tbadk.core.view.h bKk;
    private QuickVideoView.b bLA;
    private final View.OnClickListener bLB;
    private final View.OnClickListener bLC;
    private CustomMessageListener bLD;
    private i.a bLE;
    private Animation.AnimationListener bLF;
    private QuickVideoView bLh;
    private com.baidu.tieba.play.m bLi;
    private TextView bLj;
    private TextView bLk;
    private View bLl;
    private AudioAnimationView bLm;
    private ProgressBar bLn;
    private ImageView bLo;
    private com.baidu.tieba.card.data.n bLp;
    private View bLq;
    private int bLr;
    private int bLs;
    private boolean bLt;
    private boolean bLu;
    private com.baidu.tieba.play.i bLv;
    private Animation bLw;
    private Handler bLx;
    private Runnable bLy;
    private Runnable bLz;
    private View bhm;
    protected LinearLayout blC;
    private RelativeLayout bll;
    public ThreadUserInfoLayout blu;
    public ThreadCommentAndPraiseInfoLayout bly;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void XT() {
        if (this.bLp != null && this.bLp.bcG != null) {
            com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
            wVar.mLocate = this.bLp.sourceType == 0 ? "index" : "hot_juhe";
            wVar.bHy = this.bLp.bcG.getTid();
            wVar.azL = this.bLp.bcG.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.bLp.bcG.ZH;
            wVar.fBN = this.bLp.bcG.ZJ;
            wVar.fBO = this.bLp.bcG.ZI;
            wVar.fBP = "";
            if (this.bLp.bcG.sF() != null && this.bLp.bcG.sF().channelId > 0) {
                wVar.VU = this.bLp.bcG.sF().channelId + "";
            } else {
                wVar.VU = "0";
            }
            if (this.bLp.bcG.rS() != null) {
                wVar.fBR = this.bLp.bcG.rS().video_md5;
            }
            com.baidu.tieba.play.k.a(this.bLp.bcG.rS().video_md5, "", "1", wVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bKk = null;
        this.mSkinType = 3;
        this.bLr = 0;
        this.bLs = 1;
        this.bLt = false;
        this.bLu = false;
        this.bLx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.XU();
                        return;
                    case 203:
                        j.this.XV();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUt = new f.e() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bLx.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aUu = new f.b() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                j.this.g(true, 4);
                return true;
            }
        };
        this.aUs = new f.a() { // from class: com.baidu.tieba.card.j.9
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(com.baidu.tieba.play.f fVar) {
                if (fVar != null && fVar.isLooping()) {
                    j.this.XT();
                }
            }
        };
        this.bIy = new TbImageView.a() { // from class: com.baidu.tieba.card.j.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && j.this.bIv != null) {
                    j.this.bIv.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bLy = new Runnable() { // from class: com.baidu.tieba.card.j.11
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bLh != null && !j.this.bLh.isPlaying()) {
                    j.this.g(true, 1);
                }
            }
        };
        this.bLz = new Runnable() { // from class: com.baidu.tieba.card.j.12
            @Override // java.lang.Runnable
            public void run() {
                j.this.g(true, 4);
            }
        };
        this.bLA = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bLB = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XL() != null) {
                    j.this.XL().a(view, j.this.bLp);
                }
            }
        };
        this.bLC = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XL() != null) {
                    j.this.XL().a(view, j.this.bLp);
                }
            }
        };
        this.bLD = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bLu = false;
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bLp != null && j.this.XL() != null) {
                    j.this.XL().a(view, j.this.bLp);
                }
            }
        };
        this.bLE = new i.a() { // from class: com.baidu.tieba.card.j.5
            @Override // com.baidu.tieba.play.i.a
            public void XZ() {
                if (j.this.bLp != null && j.this.bLp.bcG != null && j.this.bLp.bcG.rS() != null) {
                    j.this.XT();
                }
            }
        };
        this.bLF = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bIv != null) {
                    j.this.bIv.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aby = tbPageContext;
        View view = getView();
        this.bll = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bKh = (HeadPendantClickableView) this.bll.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.aby.getPageActivity(), d.f.ds70));
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.bLn = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bLo = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.blu = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bKk = new com.baidu.tbadk.core.view.h(this.aby);
        this.bKk.wI();
        this.bKk.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blu.addView(this.bKk);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setShareVisible(true);
        this.bly.setShareReportFrom(3);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setForumAfterClickListener(this.aoc);
        this.bly.setFrom(1);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bIu = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bIu.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.ae(this.aby.getPageActivity()) - com.baidu.adp.lib.util.k.f(this.aby.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bIu.setLayoutParams(layoutParams2);
        this.bIv = (TbImageView) view.findViewById(d.h.image_video);
        this.bIv.setDefaultErrorResource(0);
        this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bIv.setGifIconSupport(false);
        this.bIv.setEvent(this.bIy);
        this.bIw = (ImageView) view.findViewById(d.h.image_video_play);
        this.bLm = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bLm.setCertainColumnCount(4);
        this.bLm.setColumnColor(d.e.cp_cont_i);
        this.bll.setOnClickListener(this);
        this.bLh = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bLi = new com.baidu.tieba.play.m(this.aby.getPageActivity());
        this.bLh.setBusiness(this.bLi);
        this.bLh.setOnPreparedListener(this.aUt);
        this.bLh.setOnErrorListener(this.aUu);
        this.bLh.setOnSurfaceDestroyedListener(this.bLA);
        this.bLh.setOnCompletionListener(this.aUs);
        this.bLv = new com.baidu.tieba.play.i();
        this.bLv.setPlayer(this.bLh);
        this.bLv.a(this.bLE);
        this.bLj = (TextView) view.findViewById(d.h.text_video_duration);
        this.bLq = view.findViewById(d.h.auto_video_black_mask);
        this.bLk = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bLl = view.findViewById(d.h.auto_video_error_background);
        this.blC = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bLw = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bLw.setAnimationListener(this.bLF);
        this.bhm = view.findViewById(d.h.divider_line);
        this.bKi = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bKi.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bll || view == this.bKi) {
            ae(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void ae(View view) {
        if (XL() != null) {
            XL().a(view, this.bLp);
        }
        if (this.bLp != null && this.bLp.bcG != null) {
            if (!XP()) {
                m.ju(this.bLp.bcG.getId());
                m.a(this.mTextTitle, this.bLp.bcG.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aby.getPageActivity()).createFromThreadCfg(this.bLp.bcG, null, m.rs(), 18003, true, false, false).addLocateParam(this.bLp.Yn());
            addLocateParam.setVideo_source(this.bLp.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bLp.bcG.getFid()));
            addLocateParam.setForumName(this.bLp.bcG.rG());
            if (this.bLp.bNJ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bLp.bNJ);
            }
            if (view == this.bKi) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XP() {
        return this.bLp.bOb && !this.bLp.bOp;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bLp = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XU() {
        this.bLx.removeMessages(202);
        if (this.bLh.getCurrentPosition() > 0) {
            g(true, 3);
            this.bLx.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bLx.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XV() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bLx.removeMessages(203);
        int currentPosition = this.bLh.getCurrentPosition();
        if (currentPosition != this.bLr) {
            this.bLr = currentPosition;
            g(false, 3);
        } else {
            g(false, 2);
        }
        this.bLx.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bIw != null && this.bIv != null && this.bLq != null && this.bLm != null && this.bLn != null && this.bLo != null && this.bLl != null && this.bLk != null) {
            if (z || this.bLs != i) {
                this.bLs = i;
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLz);
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLy);
                if (i == 2) {
                    this.bIw.setVisibility(8);
                    this.bLw.cancel();
                    this.bIv.clearAnimation();
                    this.bIv.setVisibility(0);
                    this.bLq.setVisibility(0);
                    this.bLj.setVisibility(0);
                    this.bLn.setVisibility(0);
                    this.bLo.setVisibility(0);
                    this.bLl.setVisibility(8);
                    this.bLk.setVisibility(8);
                    this.bLm.setVisibility(8);
                    this.bLm.bwE();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bLz, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bIw.setVisibility(8);
                    this.bIv.startAnimation(this.bLw);
                    this.bLq.setVisibility(8);
                    this.bLj.setVisibility(8);
                    this.bLn.setVisibility(8);
                    this.bLo.setVisibility(8);
                    this.bLl.setVisibility(8);
                    this.bLk.setVisibility(8);
                    this.bLm.setVisibility(0);
                    this.bLm.start();
                } else if (i == 4) {
                    this.bIw.setVisibility(8);
                    this.bIv.startAnimation(this.bLw);
                    this.bLq.setVisibility(8);
                    this.bLn.setVisibility(8);
                    this.bLo.setVisibility(8);
                    this.bLl.setVisibility(0);
                    this.bLk.setVisibility(0);
                    this.bLm.setVisibility(8);
                    this.bLm.bwE();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bLy, 2000L);
                } else {
                    this.bIw.setVisibility(0);
                    this.bLw.cancel();
                    this.bIv.clearAnimation();
                    this.bIv.setVisibility(0);
                    this.bLq.setVisibility(0);
                    this.bLj.setVisibility(0);
                    this.bLn.setVisibility(8);
                    this.bLo.setVisibility(8);
                    this.bLl.setVisibility(8);
                    this.bLk.setVisibility(8);
                    this.bLm.setVisibility(8);
                    this.bLm.bwE();
                }
            }
        }
    }

    private void refreshView() {
        String string;
        if (this.bLp == null || this.bLp.bcG == null || this.bLp.bcG.getAuthor() == null) {
            this.bll.setVisibility(8);
            return;
        }
        this.bll.setVisibility(0);
        XY();
        if (!XP() && m.jv(this.bLp.bcG.getId())) {
            m.a(this.mTextTitle, this.bLp.bcG.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bKi.getGodReplyContent(), this.bLp.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getPraiseNum(), this.bLp.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bLp.MR().sj();
        if (this.bLp.bcG.sF() != null && this.bLp.bcG.sF().channelId > 0) {
            string = this.aby.getResources().getString(d.l.channel_title_prefix);
        } else if (this.bLp.bcG.getThreadType() == 50) {
            string = this.aby.getResources().getString(d.l.ala_record_title_prefix);
        } else {
            string = this.aby.getResources().getString(d.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bLp.MR().sb()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.blu.c(this.bLp.MR());
        this.blu.setUserAfterClickListener(this.bLB);
        if (this.blu.getHeaderImg() != null) {
            this.blu.getHeaderImg().setAfterClickListener(this.bLC);
            if (this.blu.getIsSimpleThread()) {
                this.blu.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (this.bLp.MR() == null || this.bLp.MR().getAuthor() == null || this.bLp.MR().getAuthor().getPendantData() == null || StringUtils.isNull(this.bLp.MR().getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.blu.getHeaderImg().setVisibility(0);
                this.blu.getHeaderImg().setData(this.bLp.MR());
            } else {
                this.blu.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(this.bLp.MR());
            }
        }
        if (this.bly.c(this.bLp.bcG)) {
            this.bKj.setVisibility(8);
        } else {
            this.bKj.setVisibility(0);
        }
        this.bLj.setText(am.da(this.bLp.bcG.rS().video_duration.intValue() * 1000));
        if (this.bKk != null && this.bLp.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bLp.MR().getTid());
            anVar.setFid(this.bLp.MR().getFid());
            anVar.a(this.bLp.Xf);
            this.bKk.setData(anVar);
            this.bKk.setFirstRowSingleColumn(true);
        }
        this.bKi.setData(this.bLp.MR().sR());
        this.bKi.onChangeSkinType();
        if (this.bKi.getVisibility() == 0) {
            this.bKj.setVisibility(0);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
        if (m.jv(this.bLp.bcG.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void XW() {
        this.bLx.removeMessages(202);
        this.bLx.removeMessages(203);
    }

    private void XX() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLy);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLz);
    }

    private void XY() {
        XX();
        XW();
        if (this.bIv != null && this.bIu != null && this.bLh != null) {
            if (com.baidu.tbadk.core.h.oS().oY() && this.bLp != null && this.bLp.bcG != null && this.bLp.bcG.rS() != null) {
                this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bIv.c(this.bLp.bcG.rS().thumbnail_url, 10, false);
                this.bIu.setVisibility(0);
                stopPlay();
                this.aVD = this.bLp.bcG.rS().video_url;
                if (StringUtils.isNull(this.bLp.bcG.rS().video_url)) {
                    g(true, 4);
                }
                if (this.bLi != null && this.bLi.bfQ() != null) {
                    this.bLi.bfQ().d(this.bLp.bcG.rS());
                    return;
                }
                return;
            }
            this.bIu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bll, d.g.addresslist_item_bg);
            aj.c(this.bIw, d.g.home_ic_video);
            aj.i(this.bLk, d.e.cp_cont_i);
            aj.i(this.bLj, d.e.cp_cont_i);
            aj.k(this.bLl, d.e.common_color_10014);
            if (this.bLk != null) {
                this.bLk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            aj.j(this.bhm, d.e.cp_bg_line_c);
            if (this.bKk != null) {
                this.bKk.onChangeSkinType();
            }
            this.blu.onChangeSkinType();
            this.bly.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bLD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bLD);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.blu != null) {
            this.blu.setPageUniqueId(bdUniqueId);
        }
        if (this.bIv != null) {
            this.bIv.setPageId(bdUniqueId);
        }
        if (this.bKk != null) {
            this.bKk.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bLt;
    }

    public boolean isPlaying() {
        if (this.bLh == null) {
            return false;
        }
        return this.bLh.isPlaying();
    }

    public void startPlay() {
        if (!this.bLt && this.bLp != null && this.bLp.bcG != null && this.bLp.bcG.rS() != null && this.bLh != null && com.baidu.tbadk.util.x.q(1, this.aVD)) {
            g(true, 2);
            this.bLh.setVideoPath(this.aVD);
            this.bLh.start();
            this.bLh.setLooping(true);
            if (this.bLv != null) {
                this.bLv.start();
            }
            this.bLt = true;
            XT();
        }
    }

    public void stopPlay() {
        XX();
        XW();
        g(true, 1);
        if (this.bLh != null) {
            this.bLh.stopPlayback();
            if (this.bLv != null) {
                this.bLv.stop();
            }
        }
        this.bLt = false;
    }

    public View getVideoContainer() {
        return this.bIu;
    }

    public String getPlayUrl() {
        return this.aVD;
    }

    public int getCurrentPosition() {
        if (this.bLh == null) {
            return 0;
        }
        return this.bLh.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.w wVar) {
        if (this.bLi != null) {
            this.bLi.setVideoStatsData(wVar);
        }
    }

    public void a(h.a aVar) {
        if (this.bKk != null) {
            this.bKk.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.blu != null) {
            return this.blu.aop;
        }
        return null;
    }

    public View XO() {
        if (this.blu != null) {
            return this.blu.aoq;
        }
        return null;
    }
}
