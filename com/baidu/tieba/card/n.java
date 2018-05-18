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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
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
    private g.f aZp;
    private g.b aZq;
    private final View.OnClickListener aoY;
    private String baJ;
    private View ban;
    private ImageView bkP;
    private Animation bkT;
    private com.baidu.tieba.play.j blf;
    private com.baidu.tieba.play.n blg;
    private QuickVideoView.b bln;
    private String bwO;
    private RelativeLayout bwZ;
    private HeadPendantClickableView bxM;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    private NEGFeedBackView bxn;
    protected LinearLayout byb;
    public ThreadGodReplyLayout cnh;
    private View cpA;
    private com.baidu.tieba.play.w cpB;
    private com.baidu.tieba.card.data.l cpC;
    private View cpD;
    private int cpE;
    private int cpF;
    private boolean cpG;
    private boolean cpH;
    private boolean cpI;
    private TextView cpJ;
    private TextView cpK;
    private Handler cpL;
    private VideoLoadingProgressView.a cpM;
    private TbImageView.a cpN;
    private Runnable cpO;
    private Runnable cpP;
    private final View.OnClickListener cpQ;
    private final View.OnClickListener cpR;
    private CustomMessageListener cpS;
    private j.a cpT;
    private Animation.AnimationListener cpU;
    private TbImageView cpm;
    private TextView cpn;
    private View cpo;
    public FrameLayout cpt;
    private QuickVideoView cpv;
    private com.baidu.tieba.play.g cpw;
    private TextView cpx;
    private LinearLayout cpy;
    private TextView cpz;
    private TbPageContext<?> mContext;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.cpw != null) {
            try {
                this.cpv.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cpL.sendEmptyMessageDelayed(202, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.cpC != null && this.cpC.bjy != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.cpC.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aNv = this.cpC.bjy.getTid();
            yVar.csP = this.cpC.bjy.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cpC.bjy.mRecomSource;
            yVar.fRP = this.cpC.bjy.mRecomAbTag;
            yVar.fRQ = this.cpC.bjy.mRecomWeight;
            yVar.fRR = "";
            yVar.XN = this.cpC.getExtra();
            if (this.cpC.bjy.sg() != null) {
                yVar.fRT = this.cpC.bjy.sg().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cpC.bjy.sg().video_md5, "", "1", yVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bxn = null;
        this.mSkinType = 3;
        this.cpE = 0;
        this.cpF = 1;
        this.cpG = false;
        this.cpH = true;
        this.cpI = false;
        this.cpL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.afl();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        n.this.afm();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cpw = gVar;
                if (n.this.cpw != null) {
                    n.this.cpw.setVolume(0.0f, 0.0f);
                }
                n.this.cpB.bgV();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                return true;
            }
        };
        this.cpM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.afh();
            }
        };
        this.cpN = new TbImageView.a() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && n.this.cpm != null) {
                    n.this.cpm.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cpO = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.cpv != null && !n.this.cpv.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.cpP = new Runnable() { // from class: com.baidu.tieba.card.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cpQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.aeZ() != null) {
                    n.this.aeZ().a(view2, n.this.cpC);
                }
            }
        };
        this.cpR = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.aeZ() != null) {
                    n.this.aeZ().a(view2, n.this.cpC);
                }
            }
        };
        this.cpS = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cpI = false;
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cpC != null) {
                    if (n.this.aeZ() != null) {
                        n.this.aeZ().a(view2, n.this.cpC);
                    }
                    if (n.this.cpC.bjy != null && view2 != n.this.bxQ.apF) {
                        o.ky(n.this.cpC.bjy.getId());
                        if (!n.this.afd()) {
                            o.a(n.this.mTextTitle, n.this.cpC.bjy.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                            o.a(n.this.cnh.getGodReplyContent(), n.this.cpC.Pb().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cpT = new j.a() { // from class: com.baidu.tieba.card.n.9
            @Override // com.baidu.tieba.play.j.a
            public void afo() {
                if (n.this.cpC != null && n.this.cpC.bjy != null && n.this.cpC.bjy.sg() != null) {
                    n.this.afi();
                }
            }
        };
        this.cpU = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.cpm != null) {
                    n.this.cpm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view2 = getView();
        this.bwZ = (RelativeLayout) view2.findViewById(d.g.layout_root);
        this.bxM = (HeadPendantClickableView) this.bwZ.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.cpB = new com.baidu.tieba.play.w((ViewGroup) view2.findViewById(d.g.auto_video_loading_container));
        this.cpB.setLoadingAnimationListener(this.cpM);
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bxn = new NEGFeedBackView(aeY());
        int e = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16);
        this.bxn.a(this.bwZ, e, 0);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.setShareReportFrom(3);
        this.bxb.setForumAfterClickListener(this.aoY);
        this.bxb.setFrom(1);
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.text_bottom_threaad);
        this.bxQ.apG.setOnClickListener(this);
        this.bxQ.setFrom(1);
        this.bxQ.setShareReportFrom(3);
        this.bxQ.setForumAfterClickListener(this.aoY);
        this.cpo = view2.findViewById(d.g.divider_below_reply_number_layout);
        this.cpt = (FrameLayout) view2.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cpt.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cpt.setLayoutParams(layoutParams2);
        this.cpm = (TbImageView) view2.findViewById(d.g.image_video);
        this.cpm.setDefaultErrorResource(0);
        this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cpm.setGifIconSupport(false);
        this.cpm.setEvent(this.cpN);
        this.bkP = (ImageView) view2.findViewById(d.g.image_video_play);
        this.bwZ.setOnClickListener(this);
        this.cpv = (QuickVideoView) view2.findViewById(d.g.texture_video_view);
        this.blg = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.cpv.setBusiness(this.blg);
        this.cpv.setOnPreparedListener(this.aZp);
        this.cpv.setOnErrorListener(this.aZq);
        this.cpv.setOnSurfaceDestroyedListener(this.bln);
        this.blf = new com.baidu.tieba.play.j();
        this.blf.setPlayer(this.cpv);
        this.blf.a(this.cpT);
        this.cpx = (TextView) view2.findViewById(d.g.text_video_duration);
        this.cpy = (LinearLayout) view2.findViewById(d.g.duration_container);
        this.cpn = (TextView) view2.findViewById(d.g.text_video_play_count);
        this.cpD = view2.findViewById(d.g.auto_video_black_mask);
        this.cpz = (TextView) view2.findViewById(d.g.auto_video_error_tips);
        this.cpA = view2.findViewById(d.g.auto_video_error_background);
        this.byb = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bkT = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bkT.setAnimationListener(this.cpU);
        this.cnh = (ThreadGodReplyLayout) view2.findViewById(d.g.card_god_reply_layout);
        this.cnh.setOnClickListener(this);
        this.ban = view2.findViewById(d.g.divider_line);
        this.cpJ = (TextView) view2.findViewById(d.g.txt_video_num_during_playing);
        this.cpv.setOnClickListener(this);
        this.cpK = (TextView) view2.findViewById(d.g.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z = false;
        if (this.cpC != null && this.cpC.bjy != null && this.cpC.bjy.abK > 0) {
            if (aeZ() != null) {
                aeZ().a(view2, this.cpC);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cpC.bjy.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.rF(), this.cpC.afJ())));
            return;
        }
        if (view2 == this.bwZ || view2 == this.cnh) {
            ah(view2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view2 == this.cpv) {
            if (this.cpC != null && this.cpC.bjy != null && this.cpC.bjy.sg() != null) {
                z = this.cpC.bjy.sg().is_vertical.intValue() == 1;
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

    private void af(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cpC);
        }
        if (!com.baidu.adp.lib.util.j.gP()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else {
            afj();
        }
    }

    private void ag(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cpC);
        }
        if (!com.baidu.adp.lib.util.j.gP()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.gQ() && !com.baidu.tieba.video.f.bvU().bvV()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    com.baidu.tbadk.browser.a.a(true, (Context) n.this.mContext.getPageActivity(), n.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.card.n.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    n.this.afk();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.card.n.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cc(1);
            aVar.cb(d.C0126d.cp_cont_b);
            aVar.ar(true);
            aVar.b(this.mTbPageContext).tC();
        } else {
            afk();
        }
    }

    private void afj() {
        if (this.cpC != null && this.cpC.bjy != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cpC.bjy);
            videoItemData.mRecomExtra = this.cpC.getExtra();
            videoItemData.mRecomAbTag = this.cpC.afK();
            videoItemData.mRecomSource = this.cpC.getSource();
            videoItemData.mRecomWeight = this.cpC.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cpC.afJ())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        if (this.cpC != null && this.cpC.bjy != null && this.cpC.bjy.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cpC.bjy);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.byb.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.byb.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "index", this.cpC.bjy.getTid(), o.rF(), this.cpC.afJ(), videoSerializeVideoThreadInfo)));
        }
    }

    private void ah(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cpC);
        }
        if (this.cpC != null && this.cpC.bjy != null) {
            if (!afd()) {
                o.ky(this.cpC.bjy.getId());
                o.a(this.mTextTitle, this.cpC.bjy.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cpC.bjy, null, o.rF(), 18003, true, false, false).addLocateParam(this.cpC.afJ());
            addLocateParam.setVideo_source(this.cpC.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cpC.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cpC.bjy.getFid()));
            addLocateParam.setForumName(this.cpC.bjy.rU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view2 == this.cnh) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afd() {
        return this.cpC.cth && !this.cpC.ctr;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cpC = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        this.cpL.removeMessages(202);
        if (this.cpv.getCurrentPosition() > 0) {
            e(true, 3);
            this.cpL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cpL.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cpL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cpv.getCurrentPosition();
        if (currentPosition != this.cpE) {
            this.cpE = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cpL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bkP != null && this.cpm != null && this.cpD != null && this.cpB != null && this.cpA != null && this.cpz != null) {
            if (z || this.cpF != i) {
                this.cpF = i;
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpP);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpO);
                if (i == 2) {
                    this.bkP.setVisibility(8);
                    this.bkT.cancel();
                    this.cpm.clearAnimation();
                    this.cpm.setVisibility(0);
                    this.cpD.setVisibility(0);
                    this.cpy.setVisibility(0);
                    this.cpJ.setVisibility(8);
                    this.cpB.startLoading();
                    this.cpA.setVisibility(8);
                    this.cpz.setVisibility(8);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.cpP, 60000L);
                } else if (i == 3) {
                    this.bkP.setVisibility(8);
                    this.cpm.startAnimation(this.bkT);
                    this.cpD.setVisibility(8);
                    this.cpy.setVisibility(8);
                    if (this.cpC != null && this.cpC.Pb() != null && this.cpC.Pb().abK > 0) {
                        this.cpJ.setVisibility(0);
                    }
                    this.cpB.bgW();
                    this.cpA.setVisibility(8);
                    this.cpz.setVisibility(8);
                } else if (i == 4) {
                    this.bkP.setVisibility(8);
                    this.cpm.startAnimation(this.bkT);
                    this.cpD.setVisibility(8);
                    this.cpB.bgX();
                    this.cpA.setVisibility(0);
                    this.cpz.setVisibility(0);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.cpO, 2000L);
                } else {
                    this.bkP.setVisibility(0);
                    this.bkT.cancel();
                    this.cpm.clearAnimation();
                    this.cpm.setVisibility(0);
                    this.cpD.setVisibility(0);
                    this.cpy.setVisibility(0);
                    this.cpB.bgX();
                    this.cpA.setVisibility(8);
                    this.cpz.setVisibility(8);
                }
                if (this.cpC != null && this.cpC.Pb() != null && this.cpC.Pb().abK > 0) {
                    this.cpy.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cpC == null || this.cpC.bjy == null || this.cpC.bjy.rP() == null) {
            this.bwZ.setVisibility(8);
            return;
        }
        this.bwZ.setVisibility(0);
        afn();
        if (!afd() && o.kz(this.cpC.bjy.getId())) {
            o.a(this.mTextTitle, this.cpC.bjy.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cnh.getGodReplyContent(), this.cpC.Pb().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        this.cpC.Pb().sw();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cpC.Pb().sn());
        if (this.cpC.Pb().st() && !StringUtils.isNull(this.cpC.Pb().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cpC.Pb().getTid();
            spannableStringBuilder.append((CharSequence) this.cpC.Pb().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.18
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new al("c12841").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0126d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.j(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.bxa.setData(this.cpC.Pb());
        this.bxa.setUserAfterClickListener(this.cpQ);
        if (this.bxa.getHeaderImg() != null) {
            this.bxa.getHeaderImg().setAfterClickListener(this.cpR);
            if (this.bxa.getIsSimpleThread()) {
                this.bxa.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (this.cpC.Pb() == null || this.cpC.Pb().rP() == null || this.cpC.Pb().rP().getPendantData() == null || StringUtils.isNull(this.cpC.Pb().rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.bxa.getHeaderImg().setVisibility(0);
                if (this.cpC.Pb().abK > 0 && this.cpC.Pb().abL == 0) {
                    this.cpC.Pb().rP().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bxa.getHeaderImg().setData(this.cpC.Pb(), false);
                } else {
                    this.bxa.getHeaderImg().setData(this.cpC.Pb());
                    this.bxa.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(this.cpC.Pb());
            }
        }
        this.cpx.setText(an.cV(this.cpC.bjy.sg().video_duration.intValue() * 1000));
        this.cpn.setText(String.format(this.mContext.getResources().getString(d.k.play_count), an.B(this.cpC.bjy.sg().play_count.intValue())));
        if (this.bxn != null && this.cpC.Pb() != null) {
            ai aiVar = new ai();
            aiVar.cJ(this.cpC.Pb().getTid());
            aiVar.setFid(this.cpC.Pb().getFid());
            aiVar.a(this.cpC.YI);
            this.bxn.setData(aiVar);
            this.bxn.setFirstRowSingleColumn(true);
            this.bxn.setVisibility(this.cpH ? 0 : 8);
        }
        this.cnh.setData(this.cpC.Pb().tb());
        hc(gn(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kz(this.cpC.bjy.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        if (this.cpC == null || this.cpC.bjy == null || this.cpC.bjy.sg() == null) {
            z = false;
        } else {
            z = this.cpC.bjy.sg().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cpK.setVisibility(0);
        } else {
            this.cpK.setVisibility(8);
        }
    }

    private void aeJ() {
        this.cpL.removeMessages(202);
        this.cpL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aeP() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpO);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpP);
    }

    private void afn() {
        aeP();
        aeJ();
        if (this.cpm != null && this.cpt != null && this.cpv != null) {
            if (com.baidu.tbadk.core.i.pX().qd() && this.cpC != null && this.cpC.bjy != null && this.cpC.bjy.sg() != null) {
                this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cpm.startLoad(this.cpC.bjy.sg().thumbnail_url, 10, false);
                this.cpt.setVisibility(0);
                stopPlay();
                this.baJ = this.cpC.bjy.sg().video_url;
                if (StringUtils.isNull(this.cpC.bjy.sg().video_url)) {
                    e(true, 4);
                }
                if (this.blg != null && this.blg.bgF() != null) {
                    this.blg.bgF().d(this.cpC.bjy.sg());
                    return;
                }
                return;
            }
            this.cpt.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.bwZ, d.f.addresslist_item_bg);
            ak.c(this.bkP, d.f.btn_icon_play_video_n);
            ak.h(this.cpz, d.C0126d.cp_cont_i);
            ak.h(this.cpx, d.C0126d.cp_cont_i);
            ak.h(this.cpn, d.C0126d.cp_cont_i);
            ak.h(this.cpJ, d.C0126d.cp_cont_i);
            ak.j(this.cpA, d.C0126d.common_color_10014);
            ak.j(this.ban, d.C0126d.cp_bg_line_e);
            if (this.cpK != null) {
                ak.h(this.cpK, d.C0126d.cp_cont_i);
                ak.i(this.cpK, d.f.video_play_count_bg);
            }
            if (this.cpz != null) {
                this.cpz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cnh.onChangeSkinType();
            if (this.bxn != null) {
                this.bxn.onChangeSkinType();
            }
            this.bxa.onChangeSkinType();
            this.bxb.onChangeSkinType();
            this.bxQ.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cpS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cpS);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bxa != null) {
            this.bxa.setPageUniqueId(bdUniqueId);
        }
        if (this.cpm != null) {
            this.cpm.setPageId(bdUniqueId);
        }
        if (this.bxn != null) {
            this.bxn.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cpG;
    }

    public boolean isPlaying() {
        if (this.cpv == null) {
            return false;
        }
        return this.cpv.isPlaying();
    }

    public void startPlay() {
        if (!this.cpG && this.cpC != null && this.cpC.bjy != null && this.cpC.bjy.sg() != null && this.cpv != null && com.baidu.tbadk.util.y.o(1, this.baJ)) {
            e(true, 2);
            if (StringUtils.isNull(this.baJ)) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "index").ac("tid", this.cpC.tid));
                this.baJ = this.cpC.bjy.sg().video_url;
            }
            this.cpv.setVideoPath(this.baJ, this.cpC.tid);
            this.cpv.setLooping(true);
            if (this.blf != null) {
                this.blf.start();
            }
            this.cpG = true;
            afi();
        }
    }

    public void stopPlay() {
        aeP();
        aeJ();
        e(true, 1);
        if (this.cpv != null) {
            this.cpv.stopPlayback();
            if (this.blf != null) {
                this.blf.stop();
            }
        }
        this.cpG = false;
    }

    public View getVideoContainer() {
        return this.cpt;
    }

    public String getPlayUrl() {
        return this.baJ;
    }

    public int getCurrentPosition() {
        if (this.cpv == null) {
            return 0;
        }
        return this.cpv.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.blg != null) {
            this.blg.setVideoStatsData(yVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bxn != null) {
            this.bxn.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bxa != null) {
            return this.bxa.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bxa != null) {
            return this.bxa.apg;
        }
        return null;
    }

    public void ep(boolean z) {
        this.cpH = z;
    }

    public void hc(int i) {
        if (this.cpC != null && this.cpC.bjy != null) {
            if (i == 1) {
                if (this.cpC.bjy.abK > 0) {
                    this.bxQ.apG.setShowPraiseNum(false);
                    this.bxQ.apG.setShareVisible(false);
                    this.cpJ.setText(an.B(this.cpC.bjy.abK));
                    this.cpJ.setVisibility(0);
                } else {
                    this.bxQ.apG.setShowPraiseNum(true);
                    this.bxQ.apG.setShareVisible(true);
                    this.cpJ.setVisibility(8);
                }
                this.bxQ.setData(this.cpC.bjy);
                this.bxb.setVisibility(8);
                this.bxa.showForumNameView(false);
                return;
            }
            this.bxQ.setVisibility(8);
            this.bxa.showForumNameView(true);
            if (this.cpC.bjy.abK > 0) {
                this.bxb.setShowPraiseNum(false);
                this.bxb.setShareVisible(false);
                this.cpJ.setText(an.B(this.cpC.bjy.abK));
                this.cpJ.setVisibility(0);
            } else {
                this.bxb.setShowPraiseNum(true);
                this.bxb.setShareVisible(true);
                this.cpJ.setVisibility(8);
            }
            if (this.bxb.setData(this.cpC.bjy)) {
                this.cpo.setVisibility(8);
            } else {
                this.cpo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
