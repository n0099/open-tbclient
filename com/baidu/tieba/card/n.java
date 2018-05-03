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
    private g.f aZo;
    private g.b aZp;
    private TbPageContext<?> adf;
    private final View.OnClickListener aoY;
    private String baI;
    private View bam;
    private ImageView bkA;
    private Animation bkE;
    private com.baidu.tieba.play.j bkQ;
    private com.baidu.tieba.play.n bkR;
    private QuickVideoView.b bkY;
    private String bvX;
    private HeadPendantClickableView bwV;
    public ThreadSourceShareAndPraiseLayout bwZ;
    private RelativeLayout bwi;
    public ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    private NEGFeedBackView bww;
    protected LinearLayout bxk;
    public ThreadGodReplyLayout clX;
    private TextView coA;
    private Handler coB;
    private VideoLoadingProgressView.a coC;
    private TbImageView.a coD;
    private Runnable coE;
    private Runnable coF;
    private final View.OnClickListener coG;
    private final View.OnClickListener coH;
    private CustomMessageListener coI;
    private j.a coJ;
    private Animation.AnimationListener coK;
    private TbImageView cod;
    private TextView coe;
    private View cof;
    public FrameLayout cok;
    private QuickVideoView col;

    /* renamed from: com  reason: collision with root package name */
    private com.baidu.tieba.play.g f10com;
    private TextView con;
    private LinearLayout coo;
    private TextView cop;
    private View coq;
    private com.baidu.tieba.play.w cor;
    private com.baidu.tieba.card.data.l cos;
    private View cot;
    private int cou;
    private int cov;
    private boolean cow;
    private boolean cox;
    private boolean coy;
    private TextView coz;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.f10com != null) {
            try {
                this.col.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.coB.sendEmptyMessageDelayed(202, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.cos != null && this.cos.bji != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.cos.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aNu = this.cos.bji.getTid();
            yVar.crG = this.cos.bji.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cos.bji.mRecomSource;
            yVar.fQJ = this.cos.bji.mRecomAbTag;
            yVar.fQK = this.cos.bji.mRecomWeight;
            yVar.fQL = "";
            yVar.XM = this.cos.getExtra();
            if (this.cos.bji.sh() != null) {
                yVar.fQN = this.cos.bji.sh().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cos.bji.sh().video_md5, "", "1", yVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bww = null;
        this.mSkinType = 3;
        this.cou = 0;
        this.cov = 1;
        this.cow = false;
        this.cox = true;
        this.coy = false;
        this.coB = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
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
        this.aZo = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.f10com = gVar;
                if (n.this.f10com != null) {
                    n.this.f10com.setVolume(0.0f, 0.0f);
                }
                n.this.cor.bgV();
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                return true;
            }
        };
        this.coC = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.afh();
            }
        };
        this.coD = new TbImageView.a() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && n.this.cod != null) {
                    n.this.cod.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.coE = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.col != null && !n.this.col.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.coF = new Runnable() { // from class: com.baidu.tieba.card.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.coG = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.aeZ() != null) {
                    n.this.aeZ().a(view2, n.this.cos);
                }
            }
        };
        this.coH = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.aeZ() != null) {
                    n.this.aeZ().a(view2, n.this.cos);
                }
            }
        };
        this.coI = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.coy = false;
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cos != null) {
                    if (n.this.aeZ() != null) {
                        n.this.aeZ().a(view2, n.this.cos);
                    }
                    if (n.this.cos.bji != null && view2 != n.this.bwZ.apF) {
                        o.kv(n.this.cos.bji.getId());
                        if (!n.this.afd()) {
                            o.a(n.this.mTextTitle, n.this.cos.bji.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                            o.a(n.this.clX.getGodReplyContent(), n.this.cos.Pe().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.coJ = new j.a() { // from class: com.baidu.tieba.card.n.9
            @Override // com.baidu.tieba.play.j.a
            public void afo() {
                if (n.this.cos != null && n.this.cos.bji != null && n.this.cos.bji.sh() != null) {
                    n.this.afi();
                }
            }
        };
        this.coK = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.cod != null) {
                    n.this.cod.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.adf = tbPageContext;
        View view2 = getView();
        this.bwi = (RelativeLayout) view2.findViewById(d.g.layout_root);
        this.bwV = (HeadPendantClickableView) this.bwi.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.ds70));
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.cor = new com.baidu.tieba.play.w((ViewGroup) view2.findViewById(d.g.auto_video_loading_container));
        this.cor.setLoadingAnimationListener(this.coC);
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bww = new NEGFeedBackView(aeY());
        int e = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16);
        this.bww.a(this.bwi, e, 0);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.setShareReportFrom(3);
        this.bwk.setForumAfterClickListener(this.aoY);
        this.bwk.setFrom(1);
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.text_bottom_threaad);
        this.bwZ.apG.setOnClickListener(this);
        this.bwZ.setFrom(1);
        this.bwZ.setShareReportFrom(3);
        this.bwZ.setForumAfterClickListener(this.aoY);
        this.cof = view2.findViewById(d.g.divider_below_reply_number_layout);
        this.cok = (FrameLayout) view2.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cok.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cok.setLayoutParams(layoutParams2);
        this.cod = (TbImageView) view2.findViewById(d.g.image_video);
        this.cod.setDefaultErrorResource(0);
        this.cod.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cod.setGifIconSupport(false);
        this.cod.setEvent(this.coD);
        this.bkA = (ImageView) view2.findViewById(d.g.image_video_play);
        this.bwi.setOnClickListener(this);
        this.col = (QuickVideoView) view2.findViewById(d.g.texture_video_view);
        this.bkR = new com.baidu.tieba.play.n(this.adf.getPageActivity());
        this.col.setBusiness(this.bkR);
        this.col.setOnPreparedListener(this.aZo);
        this.col.setOnErrorListener(this.aZp);
        this.col.setOnSurfaceDestroyedListener(this.bkY);
        this.bkQ = new com.baidu.tieba.play.j();
        this.bkQ.setPlayer(this.col);
        this.bkQ.a(this.coJ);
        this.con = (TextView) view2.findViewById(d.g.text_video_duration);
        this.coo = (LinearLayout) view2.findViewById(d.g.duration_container);
        this.coe = (TextView) view2.findViewById(d.g.text_video_play_count);
        this.cot = view2.findViewById(d.g.auto_video_black_mask);
        this.cop = (TextView) view2.findViewById(d.g.auto_video_error_tips);
        this.coq = view2.findViewById(d.g.auto_video_error_background);
        this.bxk = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bkE = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bkE.setAnimationListener(this.coK);
        this.clX = (ThreadGodReplyLayout) view2.findViewById(d.g.card_god_reply_layout);
        this.clX.setOnClickListener(this);
        this.bam = view2.findViewById(d.g.divider_line);
        this.coz = (TextView) view2.findViewById(d.g.txt_video_num_during_playing);
        this.col.setOnClickListener(this);
        this.coA = (TextView) view2.findViewById(d.g.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z = false;
        if (this.cos != null && this.cos.bji != null && this.cos.bji.abJ > 0) {
            if (aeZ() != null) {
                aeZ().a(view2, this.cos);
            }
            this.adf.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.adf.getPageActivity(), this.cos.bji.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.rG(), this.cos.afJ())));
            return;
        }
        if (view2 == this.bwi || view2 == this.clX) {
            ah(view2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view2 == this.col) {
            if (this.cos != null && this.cos.bji != null && this.cos.bji.sh() != null) {
                z = this.cos.bji.sh().is_vertical.intValue() == 1;
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
            aeZ().a(view2, this.cos);
        }
        if (!com.baidu.adp.lib.util.j.gP()) {
            com.baidu.adp.lib.util.l.showToast(this.adf.getPageActivity(), d.k.no_network_guide);
        } else {
            afj();
        }
    }

    private void ag(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cos);
        }
        if (!com.baidu.adp.lib.util.j.gP()) {
            com.baidu.adp.lib.util.l.showToast(this.adf.getPageActivity(), d.k.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.gQ() && !com.baidu.tieba.video.f.bvW().bvX()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
            View inflate = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    com.baidu.tbadk.browser.a.a(true, (Context) n.this.adf.getPageActivity(), n.this.adf.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
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
            aVar.cb(1);
            aVar.ca(d.C0126d.cp_cont_b);
            aVar.ar(true);
            aVar.b(this.mTbPageContext).tD();
        } else {
            afk();
        }
    }

    private void afj() {
        if (this.cos != null && this.cos.bji != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cos.bji);
            videoItemData.mRecomExtra = this.cos.getExtra();
            videoItemData.mRecomAbTag = this.cos.afK();
            videoItemData.mRecomSource = this.cos.getSource();
            videoItemData.mRecomWeight = this.cos.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cos.afJ())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        if (this.cos != null && this.cos.bji != null && this.cos.bji.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cos.bji);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.bxk.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bxk.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.adf.getPageActivity(), "index", this.cos.bji.getTid(), o.rG(), this.cos.afJ(), videoSerializeVideoThreadInfo)));
        }
    }

    private void ah(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cos);
        }
        if (this.cos != null && this.cos.bji != null) {
            if (!afd()) {
                o.kv(this.cos.bji.getId());
                o.a(this.mTextTitle, this.cos.bji.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.adf.getPageActivity()).createFromThreadCfg(this.cos.bji, null, o.rG(), 18003, true, false, false).addLocateParam(this.cos.afJ());
            addLocateParam.setVideo_source(this.cos.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cos.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cos.bji.getFid()));
            addLocateParam.setForumName(this.cos.bji.rV());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view2 == this.clX) {
                addLocateParam.setJumpGodReply(true);
            }
            this.adf.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afd() {
        return this.cos.crY && !this.cos.csi;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cos = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        this.coB.removeMessages(202);
        if (this.col.getCurrentPosition() > 0) {
            e(true, 3);
            this.coB.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.coB.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.coB.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.col.getCurrentPosition();
        if (currentPosition != this.cou) {
            this.cou = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.coB.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bkA != null && this.cod != null && this.cot != null && this.cor != null && this.coq != null && this.cop != null) {
            if (z || this.cov != i) {
                this.cov = i;
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coF);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coE);
                if (i == 2) {
                    this.bkA.setVisibility(8);
                    this.bkE.cancel();
                    this.cod.clearAnimation();
                    this.cod.setVisibility(0);
                    this.cot.setVisibility(0);
                    this.coo.setVisibility(0);
                    this.coz.setVisibility(8);
                    this.cor.startLoading();
                    this.coq.setVisibility(8);
                    this.cop.setVisibility(8);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.coF, 60000L);
                } else if (i == 3) {
                    this.bkA.setVisibility(8);
                    this.cod.startAnimation(this.bkE);
                    this.cot.setVisibility(8);
                    this.coo.setVisibility(8);
                    if (this.cos != null && this.cos.Pe() != null && this.cos.Pe().abJ > 0) {
                        this.coz.setVisibility(0);
                    }
                    this.cor.bgW();
                    this.coq.setVisibility(8);
                    this.cop.setVisibility(8);
                } else if (i == 4) {
                    this.bkA.setVisibility(8);
                    this.cod.startAnimation(this.bkE);
                    this.cot.setVisibility(8);
                    this.cor.bgX();
                    this.coq.setVisibility(0);
                    this.cop.setVisibility(0);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.coE, 2000L);
                } else {
                    this.bkA.setVisibility(0);
                    this.bkE.cancel();
                    this.cod.clearAnimation();
                    this.cod.setVisibility(0);
                    this.cot.setVisibility(0);
                    this.coo.setVisibility(0);
                    this.cor.bgX();
                    this.coq.setVisibility(8);
                    this.cop.setVisibility(8);
                }
                if (this.cos != null && this.cos.Pe() != null && this.cos.Pe().abJ > 0) {
                    this.coo.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cos == null || this.cos.bji == null || this.cos.bji.rQ() == null) {
            this.bwi.setVisibility(8);
            return;
        }
        this.bwi.setVisibility(0);
        afn();
        if (!afd() && o.kw(this.cos.bji.getId())) {
            o.a(this.mTextTitle, this.cos.bji.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.clX.getGodReplyContent(), this.cos.Pe().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        this.cos.Pe().sx();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cos.Pe().so());
        if (this.cos.Pe().su() && !StringUtils.isNull(this.cos.Pe().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cos.Pe().getTid();
            spannableStringBuilder.append((CharSequence) this.cos.Pe().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.18
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
        this.bwj.setData(this.cos.Pe());
        this.bwj.setUserAfterClickListener(this.coG);
        if (this.bwj.getHeaderImg() != null) {
            this.bwj.getHeaderImg().setAfterClickListener(this.coH);
            if (this.bwj.getIsSimpleThread()) {
                this.bwj.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (this.cos.Pe() == null || this.cos.Pe().rQ() == null || this.cos.Pe().rQ().getPendantData() == null || StringUtils.isNull(this.cos.Pe().rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.bwj.getHeaderImg().setVisibility(0);
                if (this.cos.Pe().abJ > 0 && this.cos.Pe().abK == 0) {
                    this.cos.Pe().rQ().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bwj.getHeaderImg().setData(this.cos.Pe(), false);
                } else {
                    this.bwj.getHeaderImg().setData(this.cos.Pe());
                    this.bwj.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(this.cos.Pe());
            }
        }
        this.con.setText(an.cU(this.cos.bji.sh().video_duration.intValue() * 1000));
        this.coe.setText(String.format(this.adf.getResources().getString(d.k.play_count), an.B(this.cos.bji.sh().play_count.intValue())));
        if (this.bww != null && this.cos.Pe() != null) {
            ai aiVar = new ai();
            aiVar.cJ(this.cos.Pe().getTid());
            aiVar.setFid(this.cos.Pe().getFid());
            aiVar.a(this.cos.YI);
            this.bww.setData(aiVar);
            this.bww.setFirstRowSingleColumn(true);
            this.bww.setVisibility(this.cox ? 0 : 8);
        }
        this.clX.setData(this.cos.Pe().tc());
        hb(gm(1));
        d(this.adf, TbadkCoreApplication.getInst().getSkinType());
        if (o.kw(this.cos.bji.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        if (this.cos == null || this.cos.bji == null || this.cos.bji.sh() == null) {
            z = false;
        } else {
            z = this.cos.bji.sh().is_vertical.intValue() == 1;
        }
        if (z) {
            this.coA.setVisibility(0);
        } else {
            this.coA.setVisibility(8);
        }
    }

    private void aeJ() {
        this.coB.removeMessages(202);
        this.coB.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aeP() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coE);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coF);
    }

    private void afn() {
        aeP();
        aeJ();
        if (this.cod != null && this.cok != null && this.col != null) {
            if (com.baidu.tbadk.core.i.pY().qe() && this.cos != null && this.cos.bji != null && this.cos.bji.sh() != null) {
                this.cod.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cod.startLoad(this.cos.bji.sh().thumbnail_url, 10, false);
                this.cok.setVisibility(0);
                stopPlay();
                this.baI = this.cos.bji.sh().video_url;
                if (StringUtils.isNull(this.cos.bji.sh().video_url)) {
                    e(true, 4);
                }
                if (this.bkR != null && this.bkR.bgF() != null) {
                    this.bkR.bgF().d(this.cos.bji.sh());
                    return;
                }
                return;
            }
            this.cok.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.bwi, d.f.addresslist_item_bg);
            ak.c(this.bkA, d.f.btn_icon_play_video_n);
            ak.h(this.cop, d.C0126d.cp_cont_i);
            ak.h(this.con, d.C0126d.cp_cont_i);
            ak.h(this.coe, d.C0126d.cp_cont_i);
            ak.h(this.coz, d.C0126d.cp_cont_i);
            ak.j(this.coq, d.C0126d.common_color_10014);
            ak.j(this.bam, d.C0126d.cp_bg_line_e);
            if (this.coA != null) {
                ak.h(this.coA, d.C0126d.cp_cont_i);
                ak.i(this.coA, d.f.video_play_count_bg);
            }
            if (this.cop != null) {
                this.cop.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.clX.onChangeSkinType();
            if (this.bww != null) {
                this.bww.onChangeSkinType();
            }
            this.bwj.onChangeSkinType();
            this.bwk.onChangeSkinType();
            this.bwZ.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.coI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.coI);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
        if (this.cod != null) {
            this.cod.setPageId(bdUniqueId);
        }
        if (this.bww != null) {
            this.bww.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cow;
    }

    public boolean isPlaying() {
        if (this.col == null) {
            return false;
        }
        return this.col.isPlaying();
    }

    public void startPlay() {
        if (!this.cow && this.cos != null && this.cos.bji != null && this.cos.bji.sh() != null && this.col != null && com.baidu.tbadk.util.y.o(1, this.baI)) {
            e(true, 2);
            if (StringUtils.isNull(this.baI)) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "index").ac("tid", this.cos.tid));
                this.baI = this.cos.bji.sh().video_url;
            }
            this.col.setVideoPath(this.baI, this.cos.tid);
            this.col.setLooping(true);
            if (this.bkQ != null) {
                this.bkQ.start();
            }
            this.cow = true;
            afi();
        }
    }

    public void stopPlay() {
        aeP();
        aeJ();
        e(true, 1);
        if (this.col != null) {
            this.col.stopPlayback();
            if (this.bkQ != null) {
                this.bkQ.stop();
            }
        }
        this.cow = false;
    }

    public View getVideoContainer() {
        return this.cok;
    }

    public String getPlayUrl() {
        return this.baI;
    }

    public int getCurrentPosition() {
        if (this.col == null) {
            return 0;
        }
        return this.col.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.bkR != null) {
            this.bkR.setVideoStatsData(yVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bww != null) {
            this.bww.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bwj != null) {
            return this.bwj.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bwj != null) {
            return this.bwj.apg;
        }
        return null;
    }

    public void eo(boolean z) {
        this.cox = z;
    }

    public void hb(int i) {
        if (this.cos != null && this.cos.bji != null) {
            if (i == 1) {
                if (this.cos.bji.abJ > 0) {
                    this.bwZ.apG.setShowPraiseNum(false);
                    this.bwZ.apG.setShareVisible(false);
                    this.coz.setText(an.B(this.cos.bji.abJ));
                    this.coz.setVisibility(0);
                } else {
                    this.bwZ.apG.setShowPraiseNum(true);
                    this.bwZ.apG.setShareVisible(true);
                    this.coz.setVisibility(8);
                }
                this.bwZ.setData(this.cos.bji);
                this.bwk.setVisibility(8);
                this.bwj.showForumNameView(false);
                return;
            }
            this.bwZ.setVisibility(8);
            this.bwj.showForumNameView(true);
            if (this.cos.bji.abJ > 0) {
                this.bwk.setShowPraiseNum(false);
                this.bwk.setShareVisible(false);
                this.coz.setText(an.B(this.cos.bji.abJ));
                this.coz.setVisibility(0);
            } else {
                this.bwk.setShowPraiseNum(true);
                this.bwk.setShareVisible(true);
                this.coz.setVisibility(8);
            }
            if (this.bwk.setData(this.cos.bji)) {
                this.cof.setVisibility(8);
            } else {
                this.cof.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
