package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.y;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.m> implements View.OnClickListener {
    private TbPageContext<?> aRG;
    private g.f bPq;
    private g.b bPr;
    private String bQI;
    private View bQn;
    private final View.OnClickListener bdE;
    public ThreadGodReplyLayout cVu;
    private Handler cWA;
    private VideoLoadingProgressView.a cWB;
    private TbImageView.a cWC;
    private Runnable cWD;
    private Runnable cWE;
    private final View.OnClickListener cWF;
    private final View.OnClickListener cWG;
    private CustomMessageListener cWH;
    private j.a cWI;
    private Animation.AnimationListener cWJ;
    private TbImageView cWd;
    private TextView cWe;
    private View cWf;
    public FrameLayout cWk;
    private QuickVideoView cWl;
    private com.baidu.tieba.play.g cWm;
    private TextView cWn;
    private LinearLayout cWo;
    private TextView cWp;
    private View cWq;
    private y cWr;
    private com.baidu.tieba.card.data.m cWs;
    private View cWt;
    private int cWu;
    private int cWv;
    private boolean cWw;
    private boolean cWx;
    private boolean cWy;
    private TextView cWz;
    private Animation caB;
    private com.baidu.tieba.play.j caN;
    private com.baidu.tieba.play.n caO;
    private QuickVideoView.b caV;
    private ImageView cax;
    private RelativeLayout clV;
    public ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    public ThreadSourceShareAndPraiseLayout cmL;
    protected LinearLayout cmX;
    private com.baidu.tieba.NEGFeedBack.c cmj;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akW() {
        if (this.cWm != null) {
            try {
                this.cWl.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cWA.sendEmptyMessageDelayed(202, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.cWs != null && this.cWs.bZf != null) {
            aa aaVar = new aa();
            aaVar.mLocate = this.cWs.sourceType == 0 ? "index" : "hot_juhe";
            aaVar.bCS = this.cWs.bZf.getTid();
            aaVar.cZI = this.cWs.bZf.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.cWs.bZf.mRecomSource;
            aaVar.gvL = this.cWs.bZf.mRecomAbTag;
            aaVar.gvM = this.cWs.bZf.mRecomWeight;
            aaVar.gvN = "";
            aaVar.aMq = this.cWs.getExtra();
            if (this.cWs.bZf.zF() != null) {
                aaVar.gvP = this.cWs.bZf.zF().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cWs.bZf.zF().video_md5, "", "1", aaVar);
        }
    }

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmj = null;
        this.mSkinType = 3;
        this.cWu = 0;
        this.cWv = 1;
        this.cWw = false;
        this.cWx = true;
        this.cWy = false;
        this.cWA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        i.this.akZ();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        i.this.ala();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPq = new g.f() { // from class: com.baidu.tieba.card.i.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                i.this.cWm = gVar;
                if (i.this.cWm != null) {
                    i.this.cWm.setVolume(0.0f, 0.0f);
                }
                i.this.cWr.blO();
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.card.i.11
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                i.this.i(true, 4);
                return true;
            }
        };
        this.cWB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.i.12
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                i.this.akW();
            }
        };
        this.cWC = new TbImageView.a() { // from class: com.baidu.tieba.card.i.13
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && i.this.cWd != null) {
                    i.this.cWd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cWD = new Runnable() { // from class: com.baidu.tieba.card.i.17
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.cWl != null && !i.this.cWl.isPlaying()) {
                    i.this.i(true, 1);
                }
            }
        };
        this.cWE = new Runnable() { // from class: com.baidu.tieba.card.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.i(true, 4);
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.i.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                i.this.stopPlay();
            }
        };
        this.cWF = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akO() != null) {
                    i.this.akO().a(view, i.this.cWs);
                }
            }
        };
        this.cWG = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akO() != null) {
                    i.this.akO().a(view, i.this.cWs);
                }
            }
        };
        this.cWH = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.i.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    i.this.cWy = false;
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.cWs != null) {
                    if (i.this.akO() != null) {
                        i.this.akO().a(view, i.this.cWs);
                    }
                    if (i.this.cWs.bZf != null && view != i.this.cmL.bel) {
                        j.kr(i.this.cWs.bZf.getId());
                        if (!i.this.akS()) {
                            j.a(i.this.mTextTitle, i.this.cWs.bZf.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                            j.a(i.this.cVu.getGodReplyContent(), i.this.cWs.WD().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cWI = new j.a() { // from class: com.baidu.tieba.card.i.8
            @Override // com.baidu.tieba.play.j.a
            public void ale() {
                if (i.this.cWs != null && i.this.cWs.bZf != null && i.this.cWs.bZf.zF() != null) {
                    i.this.akX();
                }
            }
        };
        this.cWJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.i.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (i.this.cWd != null) {
                    i.this.cWd.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aRG = tbPageContext;
        View view = getView();
        this.clV = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cmI = (HeadPendantClickableView) this.clV.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.ds70));
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.cWr = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cWr.setLoadingAnimationListener(this.cWB);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.cmj = new com.baidu.tieba.NEGFeedBack.c(akN());
        int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16);
        this.cmj.a(this.clV, t, 0);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.setShareReportFrom(3);
        this.clX.setForumAfterClickListener(this.bdE);
        this.clX.setFrom(1);
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cmL.bem.setOnClickListener(this);
        this.cmL.setFrom(1);
        this.cmL.setShareReportFrom(3);
        this.cmL.setForumAfterClickListener(this.bdE);
        this.cWf = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cWk = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWk.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ao(this.aRG.getPageActivity()) - com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cWk.setLayoutParams(layoutParams2);
        this.cWd = (TbImageView) view.findViewById(d.g.image_video);
        this.cWd.setDefaultErrorResource(0);
        this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWd.setGifIconSupport(false);
        this.cWd.setEvent(this.cWC);
        this.cax = (ImageView) view.findViewById(d.g.image_video_play);
        this.clV.setOnClickListener(this);
        this.cWl = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.caO = new com.baidu.tieba.play.n(this.aRG.getPageActivity());
        this.cWl.setBusiness(this.caO);
        this.cWl.setOnPreparedListener(this.bPq);
        this.cWl.setOnErrorListener(this.bPr);
        this.cWl.setOnSurfaceDestroyedListener(this.caV);
        this.caN = new com.baidu.tieba.play.j();
        this.caN.setPlayer(this.cWl);
        this.caN.a(this.cWI);
        this.cWn = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWo = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cWe = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cWt = view.findViewById(d.g.auto_video_black_mask);
        this.cWp = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cWq = view.findViewById(d.g.auto_video_error_background);
        this.cmX = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.caB = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.caB.setAnimationListener(this.cWJ);
        this.cVu = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVu.setOnClickListener(this);
        this.bQn = view.findViewById(d.g.divider_line);
        this.cWz = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.cWl.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cWs != null && this.cWs.bZf != null && this.cWs.bZf.aQj > 0) {
            if (akO() != null) {
                akO().a(view, this.cWs);
            }
            this.aRG.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.aRG.getPageActivity(), this.cWs.bZf.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, j.zd(), this.cWs.alB())));
            return;
        }
        if (view == this.clV || view == this.cVu) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cWl) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bB(getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bB(View view) {
        if (akO() != null) {
            akO().a(view, this.cWs);
        }
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.showToast(this.aRG.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
            aVar.dk(this.aRG.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.i.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    i.this.akY();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.i.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aZ(true);
            aVar.b(this.mTbPageContext).AU();
        } else {
            akY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.cWs != null && this.cWs.bZf != null && this.cWs.bZf.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cWs.bZf);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.cmX.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cmX.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRG.getPageActivity(), "index", this.cWs.bZf.getTid(), j.zd(), this.cWs.alB(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bC(View view) {
        if (akO() != null) {
            akO().a(view, this.cWs);
        }
        if (this.cWs != null && this.cWs.bZf != null) {
            if (!akS()) {
                j.kr(this.cWs.bZf.getId());
                j.a(this.mTextTitle, this.cWs.bZf.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aRG.getPageActivity()).createFromThreadCfg(this.cWs.bZf, null, j.zd(), 18003, true, false, false).addLocateParam(this.cWs.alB());
            addLocateParam.setVideo_source(this.cWs.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cWs.bZf.getFid()));
            addLocateParam.setForumName(this.cWs.bZf.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVu) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aRG.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akS() {
        return this.cWs.cZZ && !this.cWs.dan;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.cWs = mVar;
        refreshView();
        if (mVar != null && mVar.bZf != null) {
            int i = mVar.bZf.aQo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        this.cWA.removeMessages(202);
        if (this.cWl.getCurrentPosition() > 0) {
            i(true, 3);
            this.cWA.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cWA.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cWA.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cWl.getCurrentPosition();
        if (currentPosition != this.cWu) {
            this.cWu = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cWA.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cax != null && this.cWd != null && this.cWt != null && this.cWr != null && this.cWq != null && this.cWp != null) {
            if (z || this.cWv != i) {
                this.cWv = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWE);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWD);
                if (i == 2) {
                    this.cax.setVisibility(8);
                    this.caB.cancel();
                    this.cWd.clearAnimation();
                    this.cWd.setVisibility(0);
                    this.cWt.setVisibility(0);
                    this.cWo.setVisibility(0);
                    this.cWz.setVisibility(8);
                    this.cWr.startLoading();
                    this.cWq.setVisibility(8);
                    this.cWp.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWE, 60000L);
                } else if (i == 3) {
                    this.cax.setVisibility(8);
                    this.cWd.startAnimation(this.caB);
                    this.cWt.setVisibility(8);
                    this.cWo.setVisibility(8);
                    if (this.cWs != null && this.cWs.WD() != null && this.cWs.WD().aQj > 0) {
                        this.cWz.setVisibility(0);
                    }
                    this.cWr.blP();
                    this.cWq.setVisibility(8);
                    this.cWp.setVisibility(8);
                } else if (i == 4) {
                    this.cax.setVisibility(8);
                    this.cWd.startAnimation(this.caB);
                    this.cWt.setVisibility(8);
                    this.cWr.blQ();
                    this.cWq.setVisibility(0);
                    this.cWp.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWD, 2000L);
                } else {
                    this.cax.setVisibility(0);
                    this.caB.cancel();
                    this.cWd.clearAnimation();
                    this.cWd.setVisibility(0);
                    this.cWt.setVisibility(0);
                    this.cWo.setVisibility(0);
                    this.cWr.blQ();
                    this.cWq.setVisibility(8);
                    this.cWp.setVisibility(8);
                }
                if (this.cWs != null && this.cWs.WD() != null && this.cWs.WD().aQj > 0) {
                    this.cWo.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cWs == null || this.cWs.bZf == null || this.cWs.bZf.zn() == null) {
            this.clV.setVisibility(8);
            return;
        }
        this.clV.setVisibility(0);
        ald();
        if (!akS() && j.ks(this.cWs.bZf.getId())) {
            j.a(this.mTextTitle, this.cWs.bZf.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cVu.getGodReplyContent(), this.cWs.WD().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.cWs.WD().zW();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cWs.WD().zN());
        if (this.cWs.WD().zT() && !StringUtils.isNull(this.cWs.WD().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cWs.WD().getTid();
            spannableStringBuilder.append((CharSequence) this.cWs.WD().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.i.16
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.b.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.clW.setData(this.cWs.WD());
        this.clW.setUserAfterClickListener(this.cWF);
        if (this.clW.getHeaderImg() != null) {
            this.clW.getHeaderImg().setAfterClickListener(this.cWG);
            if (this.clW.getIsSimpleThread()) {
                this.clW.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (this.cWs.WD() == null || this.cWs.WD().zn() == null || this.cWs.WD().zn().getPendantData() == null || StringUtils.isNull(this.cWs.WD().zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.clW.getHeaderImg().setVisibility(0);
                if (this.cWs.WD().aQj > 0 && this.cWs.WD().aQk == 0) {
                    this.cWs.WD().zn().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.clW.getHeaderImg().a(this.cWs.WD(), false);
                } else {
                    this.clW.getHeaderImg().setData(this.cWs.WD());
                    this.clW.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.clW.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(this.cWs.WD());
            }
        }
        this.cWn.setText(am.fV(this.cWs.bZf.zF().video_duration.intValue() * 1000));
        this.cWe.setText(String.format(this.aRG.getResources().getString(d.j.play_count), am.J(this.cWs.bZf.zF().play_count.intValue())));
        if (this.cmj != null && this.cWs.WD() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cWs.WD().getTid());
            ahVar.setFid(this.cWs.WD().getFid());
            ahVar.a(this.cWs.aNg);
            this.cmj.setData(ahVar);
            this.cmj.setFirstRowSingleColumn(true);
            this.cmj.setVisibility(this.cWx ? 0 : 8);
        }
        this.cVu.setData(this.cWs.WD().AA());
        jX(this.cWs.WD().aQo);
        d(this.aRG, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWs.bZf.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
    }

    private void alb() {
        this.cWA.removeMessages(202);
        this.cWA.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void alc() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWD);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWE);
    }

    private void ald() {
        alc();
        alb();
        if (this.cWd != null && this.cWk != null && this.cWl != null) {
            if (com.baidu.tbadk.core.i.xo().xu() && this.cWs != null && this.cWs.bZf != null && this.cWs.bZf.zF() != null) {
                this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWd.startLoad(this.cWs.bZf.zF().thumbnail_url, 10, false);
                this.cWk.setVisibility(0);
                stopPlay();
                this.bQI = this.cWs.bZf.zF().video_url;
                if (StringUtils.isNull(this.cWs.bZf.zF().video_url)) {
                    i(true, 4);
                }
                if (this.caO != null && this.caO.bly() != null) {
                    this.caO.bly().d(this.cWs.bZf.zF());
                    return;
                }
                return;
            }
            this.cWk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.clV, d.f.addresslist_item_bg);
            aj.c(this.cax, d.f.btn_icon_play_video_n);
            aj.r(this.cWp, d.C0141d.cp_cont_i);
            aj.r(this.cWn, d.C0141d.cp_cont_i);
            aj.r(this.cWe, d.C0141d.cp_cont_i);
            aj.r(this.cWz, d.C0141d.cp_cont_i);
            aj.t(this.cWq, d.C0141d.common_color_10014);
            aj.t(this.bQn, d.C0141d.cp_bg_line_e);
            if (this.cWp != null) {
                this.cWp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cVu.onChangeSkinType();
            if (this.cmj != null) {
                this.cmj.onChangeSkinType();
            }
            this.clW.onChangeSkinType();
            this.clX.onChangeSkinType();
            this.cmL.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cWH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWH);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.clW != null) {
            this.clW.setPageUniqueId(bdUniqueId);
        }
        if (this.cWd != null) {
            this.cWd.setPageId(bdUniqueId);
        }
        if (this.cmj != null) {
            this.cmj.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cWw;
    }

    public boolean isPlaying() {
        if (this.cWl == null) {
            return false;
        }
        return this.cWl.isPlaying();
    }

    public void startPlay() {
        if (!this.cWw && this.cWs != null && this.cWs.bZf != null && this.cWs.bZf.zF() != null && this.cWl != null && com.baidu.tbadk.util.y.p(1, this.bQI)) {
            i(true, 2);
            if (StringUtils.isNull(this.bQI)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "index").ab("tid", this.cWs.tid));
                this.bQI = this.cWs.bZf.zF().video_url;
            }
            this.cWl.bN(this.bQI, this.cWs.tid);
            this.cWl.setLooping(true);
            if (this.caN != null) {
                this.caN.start();
            }
            this.cWw = true;
            akX();
        }
    }

    public void stopPlay() {
        alc();
        alb();
        i(true, 1);
        if (this.cWl != null) {
            this.cWl.stopPlayback();
            if (this.caN != null) {
                this.caN.stop();
            }
        }
        this.cWw = false;
    }

    public View getVideoContainer() {
        return this.cWk;
    }

    public String getPlayUrl() {
        return this.bQI;
    }

    public int getCurrentPosition() {
        if (this.cWl == null) {
            return 0;
        }
        return this.cWl.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.caO != null) {
            this.caO.setVideoStatsData(aaVar);
        }
    }

    public void a(c.a aVar) {
        if (this.cmj != null) {
            this.cmj.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clW != null) {
            return this.clW.bdL;
        }
        return null;
    }

    public View akR() {
        if (this.clW != null) {
            return this.clW.bdM;
        }
        return null;
    }

    public void eJ(boolean z) {
        this.cWx = z;
    }

    public void jX(int i) {
        if (this.cWs != null && this.cWs.bZf != null) {
            if (i == 1) {
                if (this.cWs.bZf.aQj > 0) {
                    this.cmL.bem.setShowPraiseNum(false);
                    this.cmL.bem.setShareVisible(false);
                    this.cWz.setText(am.J(this.cWs.bZf.aQj));
                    this.cWz.setVisibility(0);
                } else {
                    this.cmL.bem.setShowPraiseNum(true);
                    this.cmL.bem.setShareVisible(true);
                    this.cWz.setVisibility(8);
                }
                this.cmL.setData(this.cWs.bZf);
                this.clX.setVisibility(8);
                this.clW.showForumNameView(false);
                return;
            }
            this.cmL.setVisibility(8);
            this.clW.showForumNameView(true);
            if (this.cWs.bZf.aQj > 0) {
                this.clX.setShowPraiseNum(false);
                this.clX.setShareVisible(false);
                this.cWz.setText(am.J(this.cWs.bZf.aQj));
                this.cWz.setVisibility(0);
            } else {
                this.clX.setShowPraiseNum(true);
                this.clX.setShareVisible(true);
                this.cWz.setVisibility(8);
            }
            if (this.clX.setData(this.cWs.bZf)) {
                this.cWf.setVisibility(8);
            } else {
                this.cWf.setVisibility(0);
            }
        }
    }
}
