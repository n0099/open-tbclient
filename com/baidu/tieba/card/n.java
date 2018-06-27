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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
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
    private final View.OnClickListener axT;
    private String bGM;
    private RelativeLayout bGX;
    public ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    public ThreadSourceShareAndPraiseLayout bHN;
    protected LinearLayout bHY;
    private NEGFeedBackView bHl;
    public FrameLayout bcH;
    private TextView bcI;
    private TbImageView bcJ;
    private ImageView bcK;
    private QuickVideoView bcL;
    private TextView bcM;
    private View bcN;
    private com.baidu.tieba.play.w bcO;
    private View bcP;
    private TextView bcQ;
    private int bcR;
    private String bcS;
    private TbImageView.a bcT;
    private g.b bcU;
    private Runnable bcW;
    private Runnable bcX;
    private QuickVideoView.b bcY;
    private View bjZ;
    private g.f bjc;
    private com.baidu.tieba.play.j buK;
    private com.baidu.tieba.play.n buL;
    private Animation buy;
    public ThreadGodReplyLayout ctS;
    private View cvX;
    private com.baidu.tieba.play.g cwc;
    private LinearLayout cwd;
    private com.baidu.tieba.card.data.l cwe;
    private int cwf;
    private boolean cwg;
    private boolean cwh;
    private boolean cwi;
    private TextView cwj;
    private TextView cwk;
    private Handler cwl;
    private VideoLoadingProgressView.a cwm;
    private final View.OnClickListener cwn;
    private final View.OnClickListener cwo;
    private CustomMessageListener cwp;
    private j.a cwq;
    private Animation.AnimationListener cwr;
    private TbPageContext<?> mContext;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aii() {
        if (this.cwc != null) {
            try {
                this.bcL.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cwl.sendEmptyMessageDelayed(202, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (this.cwe != null && this.cwe.btc != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.cwe.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aWo = this.cwe.btc.getTid();
            yVar.czo = this.cwe.btc.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cwe.btc.mRecomSource;
            yVar.ghc = this.cwe.btc.mRecomAbTag;
            yVar.ghd = this.cwe.btc.mRecomWeight;
            yVar.ghe = "";
            yVar.agd = this.cwe.getExtra();
            if (this.cwe.btc.vN() != null) {
                yVar.ghg = this.cwe.btc.vN().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cwe.btc.vN().video_md5, "", "1", yVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHl = null;
        this.mSkinType = 3;
        this.cwf = 0;
        this.bcR = 1;
        this.cwg = false;
        this.cwh = true;
        this.cwi = false;
        this.cwl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aim();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        n.this.ain();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bjc = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cwc = gVar;
                if (n.this.cwc != null) {
                    n.this.cwc.setVolume(0.0f, 0.0f);
                }
                n.this.bcO.bmx();
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                return true;
            }
        };
        this.cwm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aii();
            }
        };
        this.bcT = new TbImageView.a() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && n.this.bcJ != null) {
                    n.this.bcJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bcW = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.bcL != null && !n.this.bcL.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.bcX = new Runnable() { // from class: com.baidu.tieba.card.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cwn = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cwe == null) {
                    if (n.this.aia() != null) {
                        n.this.aia().a(view, n.this.cwe);
                        return;
                    }
                    return;
                }
                if (view == n.this.bGY.getUserName()) {
                    n.this.cwe.czj = 3;
                } else if (view == n.this.bGY.getHeaderImg()) {
                    n.this.cwe.czj = 4;
                } else {
                    n.this.cwe.czj = 1;
                }
                if (n.this.aia() != null) {
                    n.this.aia().a(view, n.this.cwe);
                }
            }
        };
        this.cwo = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cwe != null) {
                    n.this.cwe.czj = 4;
                }
                if (n.this.aia() != null) {
                    n.this.aia().a(view, n.this.cwe);
                }
            }
        };
        this.cwp = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cwi = false;
                }
            }
        };
        this.axT = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cwe != null) {
                    if (n.this.aia() != null) {
                        n.this.aia().a(view, n.this.cwe);
                    }
                    if (n.this.cwe.btc != null && view != n.this.bHN.ayD) {
                        o.kY(n.this.cwe.btc.getId());
                        if (!n.this.aie()) {
                            o.a(n.this.mTextTitle, n.this.cwe.btc.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                            o.a(n.this.ctS.getGodReplyContent(), n.this.cwe.SV().getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cwq = new j.a() { // from class: com.baidu.tieba.card.n.9
            @Override // com.baidu.tieba.play.j.a
            public void aip() {
                if (n.this.cwe != null && n.this.cwe.btc != null && n.this.cwe.btc.vN() != null) {
                    n.this.aij();
                }
            }
        };
        this.cwr = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.bcJ != null) {
                    n.this.bcJ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.bGX = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bHK = (HeadPendantClickableView) this.bGX.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bHK.setHasPendantStyle();
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.bcO = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.bcO.setLoadingAnimationListener(this.cwm);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bHl = new NEGFeedBackView(ahZ());
        int e = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16);
        this.bHl.a(this.bGX, e, 0);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.setShareReportFrom(3);
        this.bGZ.setForumAfterClickListener(this.axT);
        this.bGZ.setFrom(1);
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.bHN.ayE.setOnClickListener(this);
        this.bHN.setFrom(1);
        this.bHN.setShareReportFrom(3);
        this.bHN.setForumAfterClickListener(this.axT);
        this.cvX = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bcH = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bcH.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bcH.setLayoutParams(layoutParams2);
        this.bcJ = (TbImageView) view.findViewById(d.g.image_video);
        this.bcJ.setDefaultErrorResource(0);
        this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcJ.setGifIconSupport(false);
        this.bcJ.setEvent(this.bcT);
        this.bcK = (ImageView) view.findViewById(d.g.image_video_play);
        this.bGX.setOnClickListener(this);
        this.bcL = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.buL = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.bcL.setBusiness(this.buL);
        this.bcL.setOnPreparedListener(this.bjc);
        this.bcL.setOnErrorListener(this.bcU);
        this.bcL.setOnSurfaceDestroyedListener(this.bcY);
        this.buK = new com.baidu.tieba.play.j();
        this.buK.setPlayer(this.bcL);
        this.buK.a(this.cwq);
        this.bcI = (TextView) view.findViewById(d.g.text_video_duration);
        this.cwd = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bcQ = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bcP = view.findViewById(d.g.auto_video_black_mask);
        this.bcM = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bcN = view.findViewById(d.g.auto_video_error_background);
        this.bHY = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.buy = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.buy.setAnimationListener(this.cwr);
        this.ctS = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ctS.setOnClickListener(this);
        this.bjZ = view.findViewById(d.g.divider_line);
        this.cwj = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.bcL.setOnClickListener(this);
        this.cwk = (TextView) view.findViewById(d.g.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cwe != null && this.cwe.btc != null && this.cwe.btc.aki > 0) {
            if (aia() != null) {
                aia().a(view, this.cwe);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cwe.btc.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.vk(), this.cwe.aiK())));
            return;
        }
        if (view == this.bGX || view == this.ctS) {
            aj(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcL) {
            if (this.cwe != null) {
                this.cwe.czj = 5;
            }
            if (this.cwe != null && this.cwe.btc != null && this.cwe.btc.vN() != null) {
                z = this.cwe.btc.vN().is_vertical.intValue() == 1;
            }
            if (z) {
                ah(getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ai(getView());
            } else {
                aj(getView());
            }
        }
    }

    private void ah(View view) {
        if (aia() != null) {
            aia().a(view, this.cwe);
        }
        if (!com.baidu.adp.lib.util.j.jD()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else {
            aik();
        }
    }

    private void ai(View view) {
        if (aia() != null) {
            aia().a(view, this.cwe);
        }
        if (!com.baidu.adp.lib.util.j.jD()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.jE() && !com.baidu.tieba.video.f.bBB().bBC()) {
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
                    n.this.ail();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.card.n.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cf(1);
            aVar.ce(d.C0142d.cp_cont_b);
            aVar.aw(true);
            aVar.b(this.mTbPageContext).xn();
        } else {
            ail();
        }
    }

    private void aik() {
        if (this.cwe != null && this.cwe.btc != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cwe.btc);
            videoItemData.mRecomExtra = this.cwe.getExtra();
            videoItemData.mRecomAbTag = this.cwe.aiL();
            videoItemData.mRecomSource = this.cwe.getSource();
            videoItemData.mRecomWeight = this.cwe.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cwe.aiK(), VideoPlayActivityConfig.FROM_MAINTAB_RECOMMEND)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ail() {
        if (this.cwe != null && this.cwe.btc != null && this.cwe.btc.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cwe.btc);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.bHY.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bHY.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "index", this.cwe.btc.getTid(), o.vk(), this.cwe.aiK(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aj(View view) {
        if (this.cwe != null) {
            this.cwe.czj = 1;
        }
        if (aia() != null) {
            aia().a(view, this.cwe);
        }
        if (this.cwe != null && this.cwe.btc != null) {
            if (!aie()) {
                o.kY(this.cwe.btc.getId());
                o.a(this.mTextTitle, this.cwe.btc.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cwe.btc, null, o.vk(), 18003, true, false, false).addLocateParam(this.cwe.aiK());
            addLocateParam.setVideo_source(this.cwe.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cwe.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cwe.btc.getFid()));
            addLocateParam.setForumName(this.cwe.btc.vB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ctS) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aie() {
        return this.cwe.czG && !this.cwe.czQ;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cwe = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aim() {
        this.cwl.removeMessages(202);
        if (this.bcL.getCurrentPosition() > 0) {
            e(true, 3);
            this.cwl.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cwl.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ain() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cwl.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bcL.getCurrentPosition();
        if (currentPosition != this.cwf) {
            this.cwf = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cwl.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bcK != null && this.bcJ != null && this.bcP != null && this.bcO != null && this.bcN != null && this.bcM != null) {
            if (z || this.bcR != i) {
                this.bcR = i;
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcX);
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcW);
                if (i == 2) {
                    this.bcK.setVisibility(8);
                    this.buy.cancel();
                    this.bcJ.clearAnimation();
                    this.bcJ.setVisibility(0);
                    this.bcP.setVisibility(0);
                    this.cwd.setVisibility(0);
                    this.cwj.setVisibility(8);
                    this.bcO.startLoading();
                    this.bcN.setVisibility(8);
                    this.bcM.setVisibility(8);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.bcX, 60000L);
                } else if (i == 3) {
                    this.bcK.setVisibility(8);
                    this.bcJ.startAnimation(this.buy);
                    this.bcP.setVisibility(8);
                    this.cwd.setVisibility(8);
                    if (this.cwe != null && this.cwe.SV() != null && this.cwe.SV().aki > 0) {
                        this.cwj.setVisibility(0);
                    }
                    this.bcO.bmy();
                    this.bcN.setVisibility(8);
                    this.bcM.setVisibility(8);
                } else if (i == 4) {
                    this.bcK.setVisibility(8);
                    this.bcJ.startAnimation(this.buy);
                    this.bcP.setVisibility(8);
                    this.bcO.bmz();
                    this.bcN.setVisibility(0);
                    this.bcM.setVisibility(0);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.bcW, 2000L);
                } else {
                    this.bcK.setVisibility(0);
                    this.buy.cancel();
                    this.bcJ.clearAnimation();
                    this.bcJ.setVisibility(0);
                    this.bcP.setVisibility(0);
                    this.cwd.setVisibility(0);
                    this.bcO.bmz();
                    this.bcN.setVisibility(8);
                    this.bcM.setVisibility(8);
                }
                if (this.cwe != null && this.cwe.SV() != null && this.cwe.SV().aki > 0) {
                    this.cwd.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cwe == null || this.cwe.btc == null || this.cwe.btc.vw() == null) {
            this.bGX.setVisibility(8);
            return;
        }
        this.bGX.setVisibility(0);
        aio();
        if (!aie() && o.kZ(this.cwe.btc.getId())) {
            o.a(this.mTextTitle, this.cwe.btc.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            o.a(this.ctS.getGodReplyContent(), this.cwe.SV().getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
        }
        this.cwe.SV().wd();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cwe.SV().vU());
        if (this.cwe.SV().wa() && !StringUtils.isNull(this.cwe.SV().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cwe.SV().getTid();
            spannableStringBuilder.append((CharSequence) this.cwe.SV().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.18
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0142d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.bGY.setData(this.cwe.SV());
        this.bGY.setUserAfterClickListener(this.cwn);
        if (this.bGY.getHeaderImg() != null) {
            this.bGY.getHeaderImg().setAfterClickListener(this.cwo);
            if (this.bGY.getIsSimpleThread()) {
                this.bGY.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (this.cwe.SV() == null || this.cwe.SV().vw() == null || this.cwe.SV().vw().getPendantData() == null || StringUtils.isNull(this.cwe.SV().vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.bGY.getHeaderImg().setVisibility(0);
                if (this.cwe.SV().aki > 0 && this.cwe.SV().akj == 0) {
                    this.cwe.SV().vw().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bGY.getHeaderImg().setData(this.cwe.SV(), false);
                } else {
                    this.bGY.getHeaderImg().setData(this.cwe.SV());
                    this.bGY.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(this.cwe.SV());
            }
        }
        this.bcI.setText(ap.cY(this.cwe.btc.vN().video_duration.intValue() * 1000));
        this.bcQ.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ap.F(this.cwe.btc.vN().play_count.intValue())));
        if (this.bHl != null && this.cwe.SV() != null) {
            ai aiVar = new ai();
            aiVar.dk(this.cwe.SV().getTid());
            aiVar.setFid(this.cwe.SV().getFid());
            aiVar.a(this.cwe.agZ);
            this.bHl.setData(aiVar);
            this.bHl.setFirstRowSingleColumn(true);
            this.bHl.setVisibility(this.cwh ? 0 : 8);
        }
        this.ctS.setData(this.cwe.SV().wI());
        hh(gp(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cwe.btc.getId())) {
            am.c(this.mTextTitle, d.C0142d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, d.C0142d.cp_cont_b, 1);
        }
        if (this.cwe == null || this.cwe.btc == null || this.cwe.btc.vN() == null) {
            z = false;
        } else {
            z = this.cwe.btc.vN().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cwk.setVisibility(0);
        } else {
            this.cwk.setVisibility(8);
        }
    }

    private void ahz() {
        this.cwl.removeMessages(202);
        this.cwl.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Ng() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcW);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcX);
    }

    private void aio() {
        Ng();
        ahz();
        if (this.bcJ != null && this.bcH != null && this.bcL != null) {
            if (com.baidu.tbadk.core.i.tt().tz() && this.cwe != null && this.cwe.btc != null && this.cwe.btc.vN() != null) {
                this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcJ.startLoad(this.cwe.btc.vN().thumbnail_url, 10, false);
                this.bcH.setVisibility(0);
                stopPlay();
                this.bcS = this.cwe.btc.vN().video_url;
                if (StringUtils.isNull(this.cwe.btc.vN().video_url)) {
                    e(true, 4);
                }
                if (this.buL != null && this.buL.bmh() != null) {
                    this.buL.bmh().g(this.cwe.btc.vN());
                    return;
                }
                return;
            }
            this.bcH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bGX, d.f.addresslist_item_bg);
            am.c(this.bcK, d.f.btn_icon_play_video_n);
            am.h(this.bcM, d.C0142d.cp_cont_i);
            am.h(this.bcI, d.C0142d.cp_cont_i);
            am.h(this.bcQ, d.C0142d.cp_cont_i);
            am.h(this.cwj, d.C0142d.cp_cont_i);
            am.j(this.bcN, d.C0142d.common_color_10014);
            am.j(this.bjZ, d.C0142d.cp_bg_line_e);
            if (this.cwk != null) {
                am.h(this.cwk, d.C0142d.cp_cont_i);
                am.i(this.cwk, d.f.video_play_count_bg);
            }
            if (this.bcM != null) {
                this.bcM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ctS.onChangeSkinType();
            if (this.bHl != null) {
                this.bHl.onChangeSkinType();
            }
            this.bGY.onChangeSkinType();
            this.bGZ.onChangeSkinType();
            this.bHN.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cwp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cwp);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bGY != null) {
            this.bGY.setPageUniqueId(bdUniqueId);
        }
        if (this.bcJ != null) {
            this.bcJ.setPageId(bdUniqueId);
        }
        if (this.bHl != null) {
            this.bHl.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cwg;
    }

    public boolean isPlaying() {
        if (this.bcL == null) {
            return false;
        }
        return this.bcL.isPlaying();
    }

    public void startPlay() {
        if (!this.cwg && this.cwe != null && this.cwe.btc != null && this.cwe.btc.vN() != null && this.bcL != null && com.baidu.tbadk.util.z.o(1, this.bcS)) {
            e(true, 2);
            if (StringUtils.isNull(this.bcS)) {
                TiebaStatic.log(new an("c12619").ah("obj_locate", "index").ah("tid", this.cwe.tid));
                this.bcS = this.cwe.btc.vN().video_url;
            }
            this.bcL.setVideoPath(this.bcS, this.cwe.tid);
            this.bcL.setLooping(true);
            if (this.buK != null) {
                this.buK.start();
            }
            this.cwg = true;
            aij();
        }
    }

    public void stopPlay() {
        Ng();
        ahz();
        e(true, 1);
        if (this.bcL != null) {
            this.bcL.stopPlayback();
            if (this.buK != null) {
                this.buK.stop();
            }
        }
        this.cwg = false;
    }

    public View getVideoContainer() {
        return this.bcH;
    }

    public String getPlayUrl() {
        return this.bcS;
    }

    public int getCurrentPosition() {
        if (this.bcL == null) {
            return 0;
        }
        return this.bcL.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.buL != null) {
            this.buL.setVideoStatsData(yVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bHl != null) {
            this.bHl.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bGY != null) {
            return this.bGY.aye;
        }
        return null;
    }

    public View aid() {
        if (this.bGY != null) {
            return this.bGY.ayf;
        }
        return null;
    }

    public void es(boolean z) {
        this.cwh = z;
    }

    public void hh(int i) {
        if (this.cwe != null && this.cwe.btc != null) {
            if (i == 1) {
                if (this.cwe.btc.aki > 0) {
                    this.bHN.ayE.setShowPraiseNum(false);
                    this.bHN.ayE.setShareVisible(false);
                    this.cwj.setText(ap.F(this.cwe.btc.aki));
                    this.cwj.setVisibility(0);
                } else {
                    this.bHN.ayE.setShowPraiseNum(true);
                    this.bHN.ayE.setShareVisible(true);
                    this.cwj.setVisibility(8);
                }
                this.bHN.setData(this.cwe.btc);
                this.bGZ.setVisibility(8);
                this.bGY.showForumNameView(false);
                return;
            }
            this.bHN.setVisibility(8);
            this.bGY.showForumNameView(true);
            if (this.cwe.btc.aki > 0) {
                this.bGZ.setShowPraiseNum(false);
                this.bGZ.setShareVisible(false);
                this.cwj.setText(ap.F(this.cwe.btc.aki));
                this.cwj.setVisibility(0);
            } else {
                this.bGZ.setShowPraiseNum(true);
                this.bGZ.setShareVisible(true);
                this.cwj.setVisibility(8);
            }
            if (this.bGZ.setData(this.cwe.btc)) {
                this.cvX.setVisibility(8);
            } else {
                this.cvX.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
