package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class n extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private final View.OnClickListener axg;
    private String bER;
    private HeadPendantClickableView bFP;
    public ThreadSourceShareAndPraiseLayout bFT;
    private RelativeLayout bFc;
    public ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    private NEGFeedBackView bFq;
    protected LinearLayout bGe;
    private g.b bhA;
    private g.f bhz;
    private String biU;
    private View biz;
    private ImageView bsT;
    private Animation bsX;
    private com.baidu.tieba.play.j btj;
    private com.baidu.tieba.play.n btk;
    private QuickVideoView.b bts;
    public ThreadGodReplyLayout cvM;
    private TbImageView cxQ;
    private TextView cxR;
    private View cxS;
    public FrameLayout cxX;
    private QuickVideoView cxY;
    private com.baidu.tieba.play.g cxZ;
    private TextView cya;
    private LinearLayout cyb;
    private TextView cyc;
    private View cyd;
    private com.baidu.tieba.play.w cye;
    private com.baidu.tieba.card.data.l cyf;
    private View cyg;
    private int cyh;
    private int cyi;
    private boolean cyj;
    private boolean cyk;
    private boolean cyl;
    private TextView cym;
    private TextView cyn;
    private Handler cyo;
    private VideoLoadingProgressView.a cyp;
    private TbImageView.a cyq;
    private Runnable cyr;
    private Runnable cys;
    private final View.OnClickListener cyt;
    private final View.OnClickListener cyu;
    private CustomMessageListener cyv;
    private j.a cyw;
    private Animation.AnimationListener cyx;
    private TbPageContext<?> mContext;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        if (this.cxZ != null) {
            try {
                this.cxY.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cyo.sendEmptyMessageDelayed(202, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiR() {
        if (this.cyf != null && this.cyf.brC != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.cyf.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aVt = this.cyf.brC.getTid();
            yVar.cBu = this.cyf.brC.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cyf.brC.mRecomSource;
            yVar.gdb = this.cyf.brC.mRecomAbTag;
            yVar.gdc = this.cyf.brC.mRecomWeight;
            yVar.gdd = "";
            yVar.afO = this.cyf.getExtra();
            if (this.cyf.brC.vD() != null) {
                yVar.gdf = this.cyf.brC.vD().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cyf.brC.vD().video_md5, "", "1", yVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFq = null;
        this.mSkinType = 3;
        this.cyh = 0;
        this.cyi = 1;
        this.cyj = false;
        this.cyk = true;
        this.cyl = false;
        this.cyo = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aiU();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        n.this.aiV();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bhz = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cxZ = gVar;
                if (n.this.cxZ != null) {
                    n.this.cxZ.setVolume(0.0f, 0.0f);
                }
                n.this.cye.blT();
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                return true;
            }
        };
        this.cyp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aiQ();
            }
        };
        this.cyq = new TbImageView.a() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && n.this.cxQ != null) {
                    n.this.cxQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cyr = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.cxY != null && !n.this.cxY.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.cys = new Runnable() { // from class: com.baidu.tieba.card.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cyt = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyf == null) {
                    if (n.this.aiI() != null) {
                        n.this.aiI().a(view, n.this.cyf);
                        return;
                    }
                    return;
                }
                if (view == n.this.bFd.getUserName()) {
                    n.this.cyf.cBp = 3;
                } else if (view == n.this.bFd.getHeaderImg()) {
                    n.this.cyf.cBp = 4;
                } else {
                    n.this.cyf.cBp = 1;
                }
                if (n.this.aiI() != null) {
                    n.this.aiI().a(view, n.this.cyf);
                }
            }
        };
        this.cyu = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyf != null) {
                    n.this.cyf.cBp = 4;
                }
                if (n.this.aiI() != null) {
                    n.this.aiI().a(view, n.this.cyf);
                }
            }
        };
        this.cyv = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cyl = false;
                }
            }
        };
        this.axg = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyf != null) {
                    if (n.this.aiI() != null) {
                        n.this.aiI().a(view, n.this.cyf);
                    }
                    if (n.this.cyf.brC != null && view != n.this.bFT.axM) {
                        o.lb(n.this.cyf.brC.getId());
                        if (!n.this.aiM()) {
                            o.a(n.this.mTextTitle, n.this.cyf.brC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                            o.a(n.this.cvM.getGodReplyContent(), n.this.cyf.Sz().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cyw = new j.a() { // from class: com.baidu.tieba.card.n.9
            @Override // com.baidu.tieba.play.j.a
            public void aiX() {
                if (n.this.cyf != null && n.this.cyf.brC != null && n.this.cyf.brC.vD() != null) {
                    n.this.aiR();
                }
            }
        };
        this.cyx = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.cxQ != null) {
                    n.this.cxQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.bFc = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bFP = (HeadPendantClickableView) this.bFc.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.cye = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cye.setLoadingAnimationListener(this.cyp);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bFq = new NEGFeedBackView(aiH());
        int e = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16);
        this.bFq.a(this.bFc, e, 0);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.setShareReportFrom(3);
        this.bFe.setForumAfterClickListener(this.axg);
        this.bFe.setFrom(1);
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.bFT.axN.setOnClickListener(this);
        this.bFT.setFrom(1);
        this.bFT.setShareReportFrom(3);
        this.bFT.setForumAfterClickListener(this.axg);
        this.cxS = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cxX = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cxX.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cxX.setLayoutParams(layoutParams2);
        this.cxQ = (TbImageView) view.findViewById(d.g.image_video);
        this.cxQ.setDefaultErrorResource(0);
        this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cxQ.setGifIconSupport(false);
        this.cxQ.setEvent(this.cyq);
        this.bsT = (ImageView) view.findViewById(d.g.image_video_play);
        this.bFc.setOnClickListener(this);
        this.cxY = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.btk = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.cxY.setBusiness(this.btk);
        this.cxY.setOnPreparedListener(this.bhz);
        this.cxY.setOnErrorListener(this.bhA);
        this.cxY.setOnSurfaceDestroyedListener(this.bts);
        this.btj = new com.baidu.tieba.play.j();
        this.btj.setPlayer(this.cxY);
        this.btj.a(this.cyw);
        this.cya = (TextView) view.findViewById(d.g.text_video_duration);
        this.cyb = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cxR = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cyg = view.findViewById(d.g.auto_video_black_mask);
        this.cyc = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cyd = view.findViewById(d.g.auto_video_error_background);
        this.bGe = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bsX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bsX.setAnimationListener(this.cyx);
        this.cvM = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cvM.setOnClickListener(this);
        this.biz = view.findViewById(d.g.divider_line);
        this.cym = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.cxY.setOnClickListener(this);
        this.cyn = (TextView) view.findViewById(d.g.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cyf != null && this.cyf.brC != null && this.cyf.brC.ajN > 0) {
            if (aiI() != null) {
                aiI().a(view, this.cyf);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cyf.brC.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.vb(), this.cyf.ajq())));
            return;
        }
        if (view == this.bFc || view == this.cvM) {
            ah(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cxY) {
            if (this.cyf != null) {
                this.cyf.cBp = 5;
            }
            if (this.cyf != null && this.cyf.brC != null && this.cyf.brC.vD() != null) {
                z = this.cyf.brC.vD().is_vertical.intValue() == 1;
            }
            if (z) {
                af(getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ag(getView());
            } else {
                ah(getView());
            }
        }
    }

    private void af(View view) {
        if (aiI() != null) {
            aiI().a(view, this.cyf);
        }
        if (!com.baidu.adp.lib.util.j.jD()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else {
            aiS();
        }
    }

    private void ag(View view) {
        if (aiI() != null) {
            aiI().a(view, this.cyf);
        }
        if (!com.baidu.adp.lib.util.j.jD()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.jE() && !com.baidu.tieba.video.f.bBb().bBc()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) n.this.mContext.getPageActivity(), n.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.card.n.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    n.this.aiT();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.card.n.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ce(1);
            aVar.cd(d.C0141d.cp_cont_b);
            aVar.au(true);
            aVar.b(this.mTbPageContext).xa();
        } else {
            aiT();
        }
    }

    private void aiS() {
        if (this.cyf != null && this.cyf.brC != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cyf.brC);
            videoItemData.mRecomExtra = this.cyf.getExtra();
            videoItemData.mRecomAbTag = this.cyf.ajr();
            videoItemData.mRecomSource = this.cyf.getSource();
            videoItemData.mRecomWeight = this.cyf.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cyf.ajq())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiT() {
        if (this.cyf != null && this.cyf.brC != null && this.cyf.brC.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cyf.brC);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.bGe.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bGe.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "index", this.cyf.brC.getTid(), o.vb(), this.cyf.ajq(), videoSerializeVideoThreadInfo)));
        }
    }

    private void ah(View view) {
        if (this.cyf != null) {
            this.cyf.cBp = 1;
        }
        if (aiI() != null) {
            aiI().a(view, this.cyf);
        }
        if (this.cyf != null && this.cyf.brC != null) {
            if (!aiM()) {
                o.lb(this.cyf.brC.getId());
                o.a(this.mTextTitle, this.cyf.brC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cyf.brC, null, o.vb(), 18003, true, false, false).addLocateParam(this.cyf.ajq());
            addLocateParam.setVideo_source(this.cyf.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cyf.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cyf.brC.getFid()));
            addLocateParam.setForumName(this.cyf.brC.vr());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cvM) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiM() {
        return this.cyf.cBM && !this.cyf.cBW;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cyf = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiU() {
        this.cyo.removeMessages(202);
        if (this.cxY.getCurrentPosition() > 0) {
            e(true, 3);
            this.cyo.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cyo.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiV() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cyo.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cxY.getCurrentPosition();
        if (currentPosition != this.cyh) {
            this.cyh = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cyo.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bsT != null && this.cxQ != null && this.cyg != null && this.cye != null && this.cyd != null && this.cyc != null) {
            if (z || this.cyi != i) {
                this.cyi = i;
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.cys);
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.cyr);
                if (i == 2) {
                    this.bsT.setVisibility(8);
                    this.bsX.cancel();
                    this.cxQ.clearAnimation();
                    this.cxQ.setVisibility(0);
                    this.cyg.setVisibility(0);
                    this.cyb.setVisibility(0);
                    this.cym.setVisibility(8);
                    this.cye.startLoading();
                    this.cyd.setVisibility(8);
                    this.cyc.setVisibility(8);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.cys, 60000L);
                } else if (i == 3) {
                    this.bsT.setVisibility(8);
                    this.cxQ.startAnimation(this.bsX);
                    this.cyg.setVisibility(8);
                    this.cyb.setVisibility(8);
                    if (this.cyf != null && this.cyf.Sz() != null && this.cyf.Sz().ajN > 0) {
                        this.cym.setVisibility(0);
                    }
                    this.cye.blU();
                    this.cyd.setVisibility(8);
                    this.cyc.setVisibility(8);
                } else if (i == 4) {
                    this.bsT.setVisibility(8);
                    this.cxQ.startAnimation(this.bsX);
                    this.cyg.setVisibility(8);
                    this.cye.blV();
                    this.cyd.setVisibility(0);
                    this.cyc.setVisibility(0);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.cyr, 2000L);
                } else {
                    this.bsT.setVisibility(0);
                    this.bsX.cancel();
                    this.cxQ.clearAnimation();
                    this.cxQ.setVisibility(0);
                    this.cyg.setVisibility(0);
                    this.cyb.setVisibility(0);
                    this.cye.blV();
                    this.cyd.setVisibility(8);
                    this.cyc.setVisibility(8);
                }
                if (this.cyf != null && this.cyf.Sz() != null && this.cyf.Sz().ajN > 0) {
                    this.cyb.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cyf == null || this.cyf.brC == null || this.cyf.brC.vm() == null) {
            this.bFc.setVisibility(8);
            return;
        }
        this.bFc.setVisibility(0);
        aiW();
        if (!aiM() && o.lc(this.cyf.brC.getId())) {
            o.a(this.mTextTitle, this.cyf.brC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            o.a(this.cvM.getGodReplyContent(), this.cyf.Sz().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.cyf.Sz().vT();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cyf.Sz().vK());
        if (this.cyf.Sz().vQ() && !StringUtils.isNull(this.cyf.Sz().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cyf.Sz().getTid();
            spannableStringBuilder.append((CharSequence) this.cyf.Sz().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.18
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.bFd.setData(this.cyf.Sz());
        this.bFd.setUserAfterClickListener(this.cyt);
        if (this.bFd.getHeaderImg() != null) {
            this.bFd.getHeaderImg().setAfterClickListener(this.cyu);
            if (this.bFd.getIsSimpleThread()) {
                this.bFd.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (this.cyf.Sz() == null || this.cyf.Sz().vm() == null || this.cyf.Sz().vm().getPendantData() == null || StringUtils.isNull(this.cyf.Sz().vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.bFd.getHeaderImg().setVisibility(0);
                if (this.cyf.Sz().ajN > 0 && this.cyf.Sz().ajO == 0) {
                    this.cyf.Sz().vm().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bFd.getHeaderImg().setData(this.cyf.Sz(), false);
                } else {
                    this.bFd.getHeaderImg().setData(this.cyf.Sz());
                    this.bFd.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bFd.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(this.cyf.Sz());
            }
        }
        this.cya.setText(ao.cX(this.cyf.brC.vD().video_duration.intValue() * 1000));
        this.cxR.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ao.E(this.cyf.brC.vD().play_count.intValue())));
        if (this.bFq != null && this.cyf.Sz() != null) {
            ai aiVar = new ai();
            aiVar.dh(this.cyf.Sz().getTid());
            aiVar.setFid(this.cyf.Sz().getFid());
            aiVar.a(this.cyf.agK);
            this.bFq.setData(aiVar);
            this.bFq.setFirstRowSingleColumn(true);
            this.bFq.setVisibility(this.cyk ? 0 : 8);
        }
        this.cvM.setData(this.cyf.Sz().wy());
        hd(go(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lc(this.cyf.brC.getId())) {
            al.c(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        if (this.cyf == null || this.cyf.brC == null || this.cyf.brC.vD() == null) {
            z = false;
        } else {
            z = this.cyf.brC.vD().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cyn.setVisibility(0);
        } else {
            this.cyn.setVisibility(8);
        }
    }

    private void aig() {
        this.cyo.removeMessages(202);
        this.cyo.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aiA() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cyr);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cys);
    }

    private void aiW() {
        aiA();
        aig();
        if (this.cxQ != null && this.cxX != null && this.cxY != null) {
            if (com.baidu.tbadk.core.i.tt().tz() && this.cyf != null && this.cyf.brC != null && this.cyf.brC.vD() != null) {
                this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cxQ.startLoad(this.cyf.brC.vD().thumbnail_url, 10, false);
                this.cxX.setVisibility(0);
                stopPlay();
                this.biU = this.cyf.brC.vD().video_url;
                if (StringUtils.isNull(this.cyf.brC.vD().video_url)) {
                    e(true, 4);
                }
                if (this.btk != null && this.btk.blD() != null) {
                    this.btk.blD().d(this.cyf.brC.vD());
                    return;
                }
                return;
            }
            this.cxX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bFc, d.f.addresslist_item_bg);
            al.c(this.bsT, d.f.btn_icon_play_video_n);
            al.h(this.cyc, d.C0141d.cp_cont_i);
            al.h(this.cya, d.C0141d.cp_cont_i);
            al.h(this.cxR, d.C0141d.cp_cont_i);
            al.h(this.cym, d.C0141d.cp_cont_i);
            al.j(this.cyd, d.C0141d.common_color_10014);
            al.j(this.biz, d.C0141d.cp_bg_line_e);
            if (this.cyn != null) {
                al.h(this.cyn, d.C0141d.cp_cont_i);
                al.i(this.cyn, d.f.video_play_count_bg);
            }
            if (this.cyc != null) {
                this.cyc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cvM.onChangeSkinType();
            if (this.bFq != null) {
                this.bFq.onChangeSkinType();
            }
            this.bFd.onChangeSkinType();
            this.bFe.onChangeSkinType();
            this.bFT.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cyv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyv);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bFd != null) {
            this.bFd.setPageUniqueId(bdUniqueId);
        }
        if (this.cxQ != null) {
            this.cxQ.setPageId(bdUniqueId);
        }
        if (this.bFq != null) {
            this.bFq.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cyj;
    }

    public boolean isPlaying() {
        if (this.cxY == null) {
            return false;
        }
        return this.cxY.isPlaying();
    }

    public void startPlay() {
        if (!this.cyj && this.cyf != null && this.cyf.brC != null && this.cyf.brC.vD() != null && this.cxY != null && com.baidu.tbadk.util.z.o(1, this.biU)) {
            e(true, 2);
            if (StringUtils.isNull(this.biU)) {
                TiebaStatic.log(new am("c12619").ah("obj_locate", "index").ah("tid", this.cyf.tid));
                this.biU = this.cyf.brC.vD().video_url;
            }
            this.cxY.setVideoPath(this.biU, this.cyf.tid);
            this.cxY.setLooping(true);
            if (this.btj != null) {
                this.btj.start();
            }
            this.cyj = true;
            aiR();
        }
    }

    public void stopPlay() {
        aiA();
        aig();
        e(true, 1);
        if (this.cxY != null) {
            this.cxY.stopPlayback();
            if (this.btj != null) {
                this.btj.stop();
            }
        }
        this.cyj = false;
    }

    public View getVideoContainer() {
        return this.cxX;
    }

    public String getPlayUrl() {
        return this.biU;
    }

    public int getCurrentPosition() {
        if (this.cxY == null) {
            return 0;
        }
        return this.cxY.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.btk != null) {
            this.btk.setVideoStatsData(yVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bFq != null) {
            this.bFq.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bFd != null) {
            return this.bFd.axn;
        }
        return null;
    }

    public View aiL() {
        if (this.bFd != null) {
            return this.bFd.axo;
        }
        return null;
    }

    public void et(boolean z) {
        this.cyk = z;
    }

    public void hd(int i) {
        if (this.cyf != null && this.cyf.brC != null) {
            if (i == 1) {
                if (this.cyf.brC.ajN > 0) {
                    this.bFT.axN.setShowPraiseNum(false);
                    this.bFT.axN.setShareVisible(false);
                    this.cym.setText(ao.E(this.cyf.brC.ajN));
                    this.cym.setVisibility(0);
                } else {
                    this.bFT.axN.setShowPraiseNum(true);
                    this.bFT.axN.setShareVisible(true);
                    this.cym.setVisibility(8);
                }
                this.bFT.setData(this.cyf.brC);
                this.bFe.setVisibility(8);
                this.bFd.showForumNameView(false);
                return;
            }
            this.bFT.setVisibility(8);
            this.bFd.showForumNameView(true);
            if (this.cyf.brC.ajN > 0) {
                this.bFe.setShowPraiseNum(false);
                this.bFe.setShareVisible(false);
                this.cym.setText(ao.E(this.cyf.brC.ajN));
                this.cym.setVisibility(0);
            } else {
                this.bFe.setShowPraiseNum(true);
                this.bFe.setShareVisible(true);
                this.cym.setVisibility(8);
            }
            if (this.bFe.setData(this.cyf.brC)) {
                this.cxS.setVisibility(8);
            } else {
                this.cxS.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
