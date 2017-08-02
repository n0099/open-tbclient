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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
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
    private f.d aTA;
    private f.b aTB;
    private TbPageContext<?> aaS;
    private final View.OnClickListener ann;
    public FrameLayout bCP;
    private TbImageView bCQ;
    private ImageView bCR;
    private TbImageView.a bCT;
    private HeadPendantClickableView bEC;
    private ThreadGodReplyLayout bED;
    private View bEE;
    private com.baidu.tbadk.core.view.h bEF;
    private QuickVideoView bFC;
    private com.baidu.tieba.play.m bFD;
    private TextView bFE;
    private TextView bFF;
    private View bFG;
    private AudioAnimationView bFH;
    private ProgressBar bFI;
    private ImageView bFJ;
    private com.baidu.tieba.card.data.n bFK;
    private View bFL;
    private int bFM;
    private int bFN;
    private boolean bFO;
    private boolean bFP;
    private com.baidu.tieba.play.i bFQ;
    private Animation bFR;
    private Handler bFS;
    private Runnable bFT;
    private Runnable bFU;
    private QuickVideoView.b bFV;
    private final View.OnClickListener bFW;
    private final View.OnClickListener bFX;
    private CustomMessageListener bFY;
    private i.a bFZ;
    private Animation.AnimationListener bGa;
    private View bfY;
    private RelativeLayout bjC;
    public ThreadUserInfoLayout bjL;
    public ThreadCommentAndPraiseInfoLayout bjP;
    protected LinearLayout bjT;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEF = null;
        this.mSkinType = 3;
        this.bFM = 0;
        this.bFN = 1;
        this.bFO = false;
        this.bFP = false;
        this.bFS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.Wh();
                        return;
                    case 203:
                        j.this.Wi();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aTA = new f.d() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bFS.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aTB = new f.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.bCT = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && j.this.bCQ != null) {
                    j.this.bCQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bFT = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bFC != null && !j.this.bFC.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.bFU = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.bFV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bFW = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.VZ() != null) {
                    j.this.VZ().a(view, j.this.bFK);
                }
            }
        };
        this.bFX = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.VZ() != null) {
                    j.this.VZ().a(view, j.this.bFK);
                }
            }
        };
        this.bFY = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bFP = false;
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bFK != null && j.this.VZ() != null) {
                    j.this.VZ().a(view, j.this.bFK);
                }
            }
        };
        this.bFZ = new i.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.i.a
            public void Wm() {
                if (j.this.bFK != null && j.this.bFK.bbB != null && j.this.bFK.bbB.rM() != null) {
                    com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
                    wVar.mLocate = j.this.bFK.sourceType == 0 ? "index" : "hot_juhe";
                    wVar.bBT = j.this.bFK.bbB.getTid();
                    wVar.azk = j.this.bFK.bbB.getFid() + "";
                    wVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    wVar.mSource = j.this.bFK.bbB.Ze;
                    wVar.fzl = j.this.bFK.bbB.Zg;
                    wVar.fzm = j.this.bFK.bbB.Zf;
                    wVar.fzn = "";
                    if (j.this.bFK.bbB.sz() != null && j.this.bFK.bbB.sz().channelId > 0) {
                        wVar.Vm = j.this.bFK.bbB.sz().channelId + "";
                    } else {
                        wVar.Vm = "0";
                    }
                    com.baidu.tieba.play.k.a(j.this.bFK.bbB.rM().video_md5, "", "1", wVar);
                }
            }
        };
        this.bGa = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bCQ != null) {
                    j.this.bCQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aaS = tbPageContext;
        View view = getView();
        this.bjC = (RelativeLayout) view.findViewById(d.h.layout_root);
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
        this.bFI = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bFJ = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bjL = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bEF = new com.baidu.tbadk.core.view.h(this.aaS);
        this.bEF.wA();
        this.bEF.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bjL.addView(this.bEF);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
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
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bjP.setForumAfterClickListener(this.ann);
        this.bjP.setFrom(1);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bCP = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCP.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.af(this.aaS.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aaS.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bCP.setLayoutParams(layoutParams2);
        this.bCQ = (TbImageView) view.findViewById(d.h.image_video);
        this.bCQ.setDefaultErrorResource(0);
        this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bCQ.setGifIconSupport(false);
        this.bCQ.setEvent(this.bCT);
        this.bCR = (ImageView) view.findViewById(d.h.image_video_play);
        this.bFH = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bFH.setCertainColumnCount(4);
        this.bFH.setColumnColor(d.e.cp_cont_i);
        this.bjC.setOnClickListener(this);
        this.bFC = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bFD = new com.baidu.tieba.play.m(this.aaS.getPageActivity());
        this.bFC.setBusiness(this.bFD);
        this.bFC.setOnPreparedListener(this.aTA);
        this.bFC.setOnErrorListener(this.aTB);
        this.bFC.setOnSurfaceDestroyedListener(this.bFV);
        this.bFQ = new com.baidu.tieba.play.i();
        this.bFQ.setPlayer(this.bFC);
        this.bFQ.a(this.bFZ);
        this.bFE = (TextView) view.findViewById(d.h.text_video_duration);
        this.bFL = view.findViewById(d.h.auto_video_black_mask);
        this.bFF = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bFG = view.findViewById(d.h.auto_video_error_background);
        this.bjT = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bFR = AnimationUtils.loadAnimation(this.aaS.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bFR.setAnimationListener(this.bGa);
        this.bfY = view.findViewById(d.h.divider_line);
        this.bED = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bED.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjC || view == this.bED) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void X(View view) {
        if (VZ() != null) {
            VZ().a(view, this.bFK);
        }
        if (this.bFK != null && this.bFK.bbB != null) {
            if (!Wd()) {
                m.iY(this.bFK.bbB.getId());
                m.a(this.mTextTitle, this.bFK.bbB.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aaS.getPageActivity()).createFromThreadCfg(this.bFK.bbB, null, m.rm(), 18003, true, false, false).addLocateParam(this.bFK.WB());
            addLocateParam.setVideo_source(this.bFK.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bFK.bbB.getFid()));
            addLocateParam.setForumName(this.bFK.bbB.rA());
            if (this.bFK.bIg == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bFK.bIg);
            }
            if (view == this.bED) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aaS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wd() {
        return this.bFK.bIy && !this.bFK.bIM;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bFK = nVar;
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
        this.bFS.sendEmptyMessageDelayed(202, 300L);
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
                    this.bFR.cancel();
                    this.bCQ.clearAnimation();
                    this.bCQ.setVisibility(0);
                    this.bFL.setVisibility(0);
                    this.bFE.setVisibility(0);
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
        String string;
        if (this.bFK == null || this.bFK.bbB == null || this.bFK.bbB.getAuthor() == null) {
            this.bjC.setVisibility(8);
            return;
        }
        this.bjC.setVisibility(0);
        Wl();
        if (!Wd() && m.iZ(this.bFK.bbB.getId())) {
            m.a(this.mTextTitle, this.bFK.bbB.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bED.getGodReplyContent(), this.bFK.MA().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getPraiseNum(), this.bFK.MA().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bFK.MA().sd();
        if (this.bFK.bbB.sz() != null && this.bFK.bbB.sz().channelId > 0) {
            string = this.aaS.getResources().getString(d.l.channel_title_prefix);
        } else if (this.bFK.bbB.getThreadType() == 50) {
            string = this.aaS.getResources().getString(d.l.ala_record_title_prefix);
        } else {
            string = this.aaS.getResources().getString(d.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bFK.MA().rV()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.bjL.a(this.bFK.MA());
        this.bjL.setUserAfterClickListener(this.bFW);
        if (this.bjL.getHeaderImg() != null) {
            this.bjL.getHeaderImg().setAfterClickListener(this.bFX);
            if (this.bjL.getIsSimpleThread()) {
                this.bjL.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (this.bFK.MA() == null || this.bFK.MA().getAuthor() == null || this.bFK.MA().getAuthor().getPendantData() == null || StringUtils.isNull(this.bFK.MA().getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.bjL.getHeaderImg().setVisibility(0);
                this.bjL.getHeaderImg().setData(this.bFK.MA());
            } else {
                this.bjL.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(this.bFK.MA());
            }
        }
        if (this.bjP.a(this.bFK.bbB)) {
            this.bEE.setVisibility(8);
        } else {
            this.bEE.setVisibility(0);
        }
        this.bFE.setText(al.cX(this.bFK.bbB.rM().video_duration.intValue() * 1000));
        if (this.bEF != null && this.bFK.MA() != null) {
            an anVar = new an();
            anVar.cz(this.bFK.MA().getTid());
            anVar.setFid(this.bFK.MA().getFid());
            anVar.a(this.bFK.Wx);
            this.bEF.setData(anVar);
            this.bEF.setFirstRowSingleColumn(true);
        }
        this.bED.setData(this.bFK.MA().sK());
        this.bED.onChangeSkinType();
        if (this.bED.getVisibility() == 0) {
            this.bEE.setVisibility(0);
        }
        d(this.aaS, TbadkCoreApplication.getInst().getSkinType());
        if (m.iZ(this.bFK.bbB.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void Wj() {
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
            if (com.baidu.tbadk.core.h.oN().oT() && this.bFK != null && this.bFK.bbB != null && this.bFK.bbB.rM() != null) {
                this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bCQ.c(this.bFK.bbB.rM().thumbnail_url, 10, false);
                this.bCP.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bFK.bbB.rM().video_url;
                if (StringUtils.isNull(this.bFK.bbB.rM().video_url)) {
                    f(true, 4);
                }
                if (this.bFD != null && this.bFD.bfE() != null) {
                    this.bFD.bfE().d(this.bFK.bbB.rM());
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
            ai.c(this.bCR, d.g.home_ic_video);
            ai.i(this.bFF, d.e.cp_cont_i);
            ai.i(this.bFE, d.e.cp_cont_i);
            ai.k(this.bFG, d.e.common_color_10014);
            if (this.bFF != null) {
                this.bFF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            ai.j(this.bfY, d.e.cp_bg_line_c);
            if (this.bEF != null) {
                this.bEF.onChangeSkinType();
            }
            this.bjL.onChangeSkinType();
            this.bjP.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bFY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bFY);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bjL != null) {
            this.bjL.setPageUniqueId(bdUniqueId);
        }
        if (this.bCQ != null) {
            this.bCQ.setPageId(bdUniqueId);
        }
        if (this.bEF != null) {
            this.bEF.setUniqueId(bdUniqueId);
        }
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
        if (!this.bFO && this.bFK != null && this.bFK.bbB != null && this.bFK.bbB.rM() != null && this.bFC != null && com.baidu.tbadk.util.x.r(1, this.mVideoUrl)) {
            f(true, 2);
            this.bFC.setVideoPath(this.mVideoUrl);
            this.bFC.start();
            this.bFC.setLooping(true);
            if (this.bFQ != null) {
                this.bFQ.start();
            }
            this.bFO = true;
            com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
            wVar.mLocate = this.bFK.sourceType == 0 ? "index" : "hot_juhe";
            wVar.bBT = this.bFK.bbB.getTid();
            wVar.azk = this.bFK.bbB.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.bFK.bbB.Ze;
            wVar.fzl = this.bFK.bbB.Zg;
            wVar.fzm = this.bFK.bbB.Zf;
            wVar.fzn = "";
            if (this.bFK.bbB.sz() != null && this.bFK.bbB.sz().channelId > 0) {
                wVar.Vm = this.bFK.bbB.sz().channelId + "";
            } else {
                wVar.Vm = "0";
            }
            com.baidu.tieba.play.k.a(this.bFK.bbB.rM().video_md5, "", "1", wVar);
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

    public void setVideoStatsData(com.baidu.tieba.play.w wVar) {
        if (this.bFD != null) {
            this.bFD.setVideoStatsData(wVar);
        }
    }

    public void a(h.a aVar) {
        if (this.bEF != null) {
            this.bEF.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bjL != null) {
            return this.bjL.any;
        }
        return null;
    }

    public View Wc() {
        if (this.bjL != null) {
            return this.bjL.anz;
        }
        return null;
    }
}
