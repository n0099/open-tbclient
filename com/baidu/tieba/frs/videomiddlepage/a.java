package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.h;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i, j {
    private com.baidu.tieba.lego.card.view.f Pp;
    private String afx;
    private TextView awQ;
    private ImageView awR;
    private View awS;
    private TextView awT;
    private ImageView awU;
    private View awV;
    private TextView awW;
    private ImageView awX;
    private View awY;
    private ScaleAnimation axD;
    public TextView axL;
    private Animation bve;
    private n bvr;
    public HeadImageView ciQ;
    private View dHA;
    private View dHB;
    private View dHC;
    private b dHD;
    public com.baidu.tieba.frs.videomiddlepage.a.a dHE;
    private Animation.AnimationListener dHF;
    private Animation.AnimationListener dHG;
    private Runnable dHH;
    private View dHs;
    private View dHt;
    private ImageView dHu;
    private FrameLayout dHv;
    private TextView dHw;
    private boolean dHx;
    private boolean dHy;
    private View dHz;
    public FrameLayout dqJ;
    public FrameLayout dqK;
    public TextView dqL;
    public TextView dqQ;
    public com.baidu.tieba.play.c dqX;
    public com.baidu.tieba.frs.aggregation.g dqY;
    private h dqZ;
    private y dra;
    private y drb;
    private boolean drc;
    private boolean drd;
    private Animation drf;
    private boolean drg;
    private boolean drh;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.drc = true;
        this.drh = true;
        this.dHx = false;
        this.dHy = false;
        this.dHF = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dHz != null) {
                    a.this.dHz.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dHz != null) {
                    a.this.dHz.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dHG = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dHz != null) {
                    a.this.dHz.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dHz != null) {
                    a.this.dHz.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dHH = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dHv.getVisibility() == 0) {
                    a.this.dHv.setVisibility(8);
                }
            }
        };
        this.drh = z;
        this.mFrom = str;
        this.afx = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dqJ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dHs = view.findViewById(d.g.card_container);
        this.dqK = (FrameLayout) view.findViewById(d.g.video_container);
        this.dqX = new com.baidu.tieba.play.c(tbPageContext, this.dqK, false);
        this.dqX.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dHE != null && a.this.dqY.dry.videoDuration > 8) {
                    a.this.dHE.R(a.this.mPosition, a.this.dqY.dry.videoUrl);
                }
            }
        });
        this.dqL = (TextView) view.findViewById(d.g.title);
        this.ciQ = (HeadImageView) view.findViewById(d.g.user_icon);
        this.axL = (TextView) view.findViewById(d.g.user_name);
        this.dqQ = (TextView) view.findViewById(d.g.attention);
        this.awQ = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.awR = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.awS = view.findViewById(d.g.agree_view_container);
        this.awT = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.awU = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.awV = view.findViewById(d.g.thread_info_commont_container);
        this.awW = (TextView) view.findViewById(d.g.share_num);
        this.awX = (ImageView) view.findViewById(d.g.share_num_img);
        this.awY = view.findViewById(d.g.share_num_container);
        this.dHv = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.dHw = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.dHv.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dHw.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dHw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.zK().a((TbPageContext) com.baidu.adp.base.i.ad(a.this.aiy().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dHt = view.findViewById(d.g.attention_container);
        this.dHu = (ImageView) view.findViewById(d.g.attention_img);
        this.dHz = view.findViewById(d.g.video_agg_container_foreground);
        this.dHA = view.findViewById(d.g.user_container_foreground);
        this.dHB = view.findViewById(d.g.title_foreground);
        this.dHC = view.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dHA.setOnClickListener(this);
        this.dHB.setOnClickListener(this);
        this.dHC.setOnClickListener(this);
        this.dHz.setOnClickListener(this);
        this.awS.setOnClickListener(this);
        this.awV.setOnClickListener(this);
        this.awY.setOnClickListener(this);
        this.dqL.setOnClickListener(this);
        this.ciQ.setOnClickListener(this);
        this.axL.setOnClickListener(this);
        this.dHt.setOnClickListener(this);
        this.dHs.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqJ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dqJ.setLayoutParams(layoutParams);
        this.ciQ.setIsRound(true);
        this.bvr = new n(tbPageContext.getPageActivity());
        this.dqZ = new h(this.mPageContext, this);
        this.drf = new AlphaAnimation(0.0f, 0.7f);
        this.drf.setDuration(500L);
        this.drf.setAnimationListener(this.dHG);
        this.bve = new AlphaAnimation(0.7f, 0.0f);
        this.bve.setDuration(500L);
        this.bve.setAnimationListener(this.dHF);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dqY != null && this.dqY.drx != null) {
            if (this.dqY.drx.hasFocus) {
                this.dqQ.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_d));
                this.dHt.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.dqQ.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_link_tip_a));
            }
        }
        if (this.dqY != null) {
            if (this.dqY.hasAgree) {
                this.awR.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.icon_home_card_like_s));
                this.awQ.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
            } else {
                this.awR.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_like_selector));
                this.awQ.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
            }
        }
        this.awT.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
        this.awU.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_commnet_selector));
        this.awW.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
        this.awX.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_share_selector));
        this.dqL.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dry != null) {
            this.dqY = gVar;
            this.drg = this.dqY.autoPlay;
            this.dHy = false;
            gr(false);
            this.dqL.setVisibility(0);
            this.dqL.setText(gVar.title);
            aAT();
            b(gVar, i, aVar);
            h(gVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aAS() {
        try {
            int parseInt = Integer.parseInt(this.dqY.dry.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dqY.dry.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aAT() {
        if (!aAS()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqJ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dqJ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dqJ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dqJ.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dry != null) {
            this.dqX.stopPlay();
            this.dqX.setIsNeedRecoveryVideoPlayer(true);
            this.dqX.ls(true);
            this.dqX.lq(true);
            this.dqX.lt(true);
            this.dqX.N(false, false);
            this.dqX.rF(i);
            this.dqX.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                    a.this.aAU();
                }

                @Override // com.baidu.tieba.play.c.b
                public void awj() {
                    a.this.aAV();
                    if (a.this.dqX.bjU()) {
                    }
                    if (a.this.drd) {
                        a.this.dqX.stopPlay();
                    }
                }
            });
            this.dqX.a(new c.k() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.k
                public void awk() {
                    if (a.this.dqY != null && a.this.dqY.dry != null && com.baidu.adp.lib.g.b.g(a.this.dqY.dry.videoHeight, 0) > com.baidu.adp.lib.g.b.g(a.this.dqY.dry.videoWidth, 0)) {
                        a.this.dqX.N(false, false);
                    } else {
                        a.this.dqX.N(true, false);
                    }
                    a.this.drd = false;
                    a.this.mx(a.this.drg ? "1" : "2");
                    a.this.onClick(a.this.dqK);
                    if (a.this.Pp != null) {
                        a.this.Pp.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.k
                public void awl() {
                    a.this.onClick(a.this.dqJ);
                }
            });
            this.dqX.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void fT(boolean z) {
                    a.this.dqX.bS(a.this.dqY.dry.videoUrl, a.this.dqY.threadId);
                    a.this.mx("2");
                    a.this.onClick(a.this.dqK);
                }
            });
            this.dqX.lo(false);
            this.dra = new y();
            this.dra.aWq = gVar.threadId;
            this.dra.cBU = gVar.forumId;
            this.dra.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dra.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dra.mSource = gVar.source;
            this.dra.ghC = gVar.weight;
            this.dra.ghE = this.mFrom;
            this.dra.ghF = gVar.abtest_tag;
            this.dra.afx = this.afx;
            this.dra.cBQ = gVar.extra;
            this.dra.ghI = "0";
            this.drb = new y();
            this.drb.aWq = gVar.threadId;
            this.drb.cBU = gVar.forumId;
            this.drb.mUid = TbadkCoreApplication.getCurrentAccount();
            this.drb.ghC = "auto_midpage";
            this.drb.mLocate = "auto_midpage";
            this.drb.ghE = this.mFrom;
            this.drb.mSource = gVar.source;
            this.drb.ghI = "0";
            if (gVar.dry != null) {
                this.dra.ghG = gVar.dry.videoMd5;
                this.drb.ghG = gVar.dry.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.af("tid", gVar.threadId);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.r("obj_locate", i);
            anVar.r("obj_param2", 1);
            anVar.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
            anVar.af("obj_param1", gVar.weight);
            anVar.af("extra", gVar.extra);
            anVar.af(VideoPlayActivityConfig.OBJ_ID, this.afx);
            anVar.af("ab_tag", gVar.abtest_tag);
            anVar.af("obj_type", this.mFrom);
            anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dqY.source);
            anVar.r("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.bvr.setVideoStatsData(this.dra);
            this.dqX.getVideoView().setBusiness(this.bvr);
            this.bvr.a(gVar);
            this.dqX.aSc();
            this.dqX.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (!a.this.dqX.bjU()) {
                        a.this.lU(0);
                        a.this.dHC.setVisibility(0);
                        a.this.dHB.setVisibility(0);
                        a.this.dHA.setVisibility(0);
                    } else if (z) {
                        if (a.this.dHC.getVisibility() == 8) {
                            a.this.dHC.setVisibility(0);
                            a.this.gr(true);
                        }
                        if (a.this.dHB.getVisibility() == 8) {
                            a.this.dHB.setVisibility(0);
                        }
                        if (a.this.dHA.getVisibility() == 8) {
                            a.this.dHA.setVisibility(0);
                        }
                        a.this.lU(1);
                    } else {
                        if (a.this.dHC.getVisibility() == 0) {
                            a.this.dHC.setVisibility(8);
                            a.this.gr(false);
                        }
                        if (a.this.dHB.getVisibility() == 0) {
                            a.this.dHB.setVisibility(8);
                        }
                        if (a.this.dHA.getVisibility() == 0) {
                            a.this.dHA.setVisibility(8);
                        }
                        a.this.lU(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awm() {
                    a.this.lU(1);
                    if (!a.this.dqX.bjU()) {
                        a.this.dHC.setVisibility(0);
                        a.this.dHB.setVisibility(0);
                        a.this.dHA.setVisibility(0);
                        return;
                    }
                    if (a.this.dHC.getVisibility() == 8) {
                        a.this.dHC.setVisibility(0);
                    }
                    if (a.this.dHB.getVisibility() == 8) {
                        a.this.dHB.setVisibility(0);
                    }
                    if (a.this.dHA.getVisibility() == 8) {
                        a.this.dHA.setVisibility(0);
                    }
                }
            });
            this.dqX.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.drd = true;
                        a.this.drc = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.kL(i);
                        a.this.dqX.aFd();
                    }
                }
            });
            this.dqX.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.dqY != null && a.this.dqY.dry != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dqY.dry.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dqX.setThumbnail(gVar.dry.thumbnailUrl);
            this.dqX.setVideoUrl(gVar.dry.videoUrl, gVar.threadId);
            this.dqX.a(new c.h() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.h
                public void awn() {
                }
            });
            this.dqX.aFd();
            this.dqX.show();
            if (gVar.autoPlay) {
                onClick(this.dqK);
                this.drd = false;
                this.dqX.a(gVar.dry.videoUrl, gVar.threadId, (c.d) null, new Object[0]);
                if (i == 0) {
                    this.dHz.setVisibility(8);
                } else {
                    this.dHz.startAnimation(this.bve);
                }
                this.dHB.setVisibility(8);
                this.dHC.setVisibility(8);
                gr(false);
                this.dHA.setVisibility(8);
            } else if (com.baidu.adp.lib.util.j.jG() && gVar.waitConfirm) {
                this.dHz.startAnimation(this.bve);
                this.dHB.setVisibility(8);
                this.dHC.setVisibility(8);
                gr(false);
                this.dHA.setVisibility(8);
            } else {
                this.dHB.setVisibility(0);
                this.dHC.setVisibility(0);
                this.dHA.setVisibility(0);
                this.dHz.setVisibility(0);
            }
            this.drd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (i == 1) {
            customMessage.setExtra("low");
        } else if (i == 0) {
            customMessage.setExtra("high");
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(String str) {
        if (this.dqY != null && this.dqY.dry != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dqY.dry.videoMd5, "", str, this.drb);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.dqX.bjU();
    }

    public void awe() {
        if (isPlaying()) {
            this.dqX.pausePlay();
        }
    }

    public boolean kM(int i) {
        return this.dqX.rE(i);
    }

    public void awf() {
        this.dHy = false;
        this.dqX.stopPlay();
        if (this.dqL != null) {
            this.dqL.setVisibility(0);
        }
        gr(false);
        this.dHx = true;
    }

    public void awg() {
        if (this.dqX != null) {
            this.dqX.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awg();
        if (this.dqZ != null) {
            this.dqZ.aws();
        }
        if (this.dHz != null) {
            this.dHz.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.drx != null) {
            this.axL.setText(TextUtils.isEmpty(gVar.drx.userNickname) ? gVar.drx.userName : gVar.drx.userNickname);
            if (!StringUtils.isNull(gVar.drx.portrait) && gVar.drx.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.ciQ.startLoad(gVar.drx.portrait, 10, false);
            } else {
                this.ciQ.startLoad(gVar.drx.portrait, 12, false);
            }
            if (gVar.drx.isBigV) {
                this.ciQ.setShowV(gVar.drx.isBigV);
                this.ciQ.setIsBigV(gVar.drx.isBigV);
            } else if (gVar.drx.isGod) {
                this.ciQ.setShowV(gVar.drx.isGod);
                this.ciQ.setIsBigV(gVar.drx.isGod);
            } else {
                this.ciQ.setShowV(gVar.drx.isGod);
                this.ciQ.setIsBigV(gVar.drx.isGod);
            }
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.drx != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.drx.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.drx.userId)) {
                this.dHt.setVisibility(8);
            } else {
                this.dHt.setVisibility(0);
            }
            if (gVar.drx.hasFocus) {
                this.dqQ.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_d));
                this.dqQ.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                this.dHt.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dHu.setVisibility(8);
                return;
            }
            this.dqQ.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_link_tip_a));
            this.dqQ.setText(this.mPageContext.getString(d.j.attention));
            this.dHu.setVisibility(0);
            this.dHt.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.awR.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_like_s));
                this.awQ.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_h_1));
            } else {
                this.awR.setImageDrawable(getContext().getResources().getDrawable(d.f.card_like_selector));
                this.awQ.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_i));
            }
            if (gVar.agreeNum > 0) {
                this.awQ.setText(ap.H(gVar.agreeNum));
            } else {
                this.awQ.setText(d.j.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.awT.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.awU.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.awT.setText(ap.H(gVar.postNum));
            } else {
                this.awT.setText(this.mContext.getString(d.j.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (this.awY != null && this.awW != null && gVar != null) {
            long j = gVar.shareNum;
            String string = this.mContext.getString(d.j.share);
            if (j > 0) {
                string = ap.H(j);
            }
            this.awW.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dqX != null && this.dqK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.drc) {
                this.dqX.bjT();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aAU();
            } else {
                configuration.orientation = 1;
                aAV();
                this.drc = true;
            }
            this.dqX.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAU() {
        if (this.dqX != null && this.dqK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dqK.getParent() != null) {
                if (this.dqK.getParent() == frameLayout) {
                    frameLayout.removeView(this.dqK);
                } else if (this.dqK.getParent() == this.dqJ) {
                    this.dqJ.removeView(this.dqK);
                }
            }
            if (this.dqK.getParent() == null) {
                frameLayout.addView(this.dqK);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dqK.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dqK.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAV() {
        if (this.dqX != null && this.dqK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dqK.getParent() != null) {
                if (this.dqK.getParent() == frameLayout) {
                    frameLayout.removeView(this.dqK);
                } else if (this.dqK.getParent() == this.dqJ) {
                    this.dqJ.removeView(this.dqK);
                }
            }
            if (this.dqK.getParent() == null) {
                this.dqJ.addView(this.dqK, 0);
                aAW();
                this.dqX.aSc();
            }
        }
    }

    private void aAW() {
        int i;
        if (!aAS()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dqK.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (aiz() != null) {
            view.setTag(this);
            aiz().a(view, this.dqY);
        }
        if (view == this.ciQ || view == this.axL) {
            if (this.dqY != null && this.dqY.drx != null && !TextUtils.isEmpty(this.dqY.drx.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dqY.drx.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dqY.drx.userId, 0L), z, this.dqY.drx.isGod)));
            }
        } else if (view == this.awV || view == this.dqL || view == this.dHs) {
            if (this.dqY != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dqY.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dHt) {
            if (!this.dqY.drx.hasFocus) {
                this.dqZ.f(this.dqY);
            }
        } else if (view == this.awS) {
            this.dqZ.g(this.dqY);
        } else if (view == this.awY) {
            AM();
        } else if (view == this.dHz && this.dHz.getVisibility() == 0) {
            if (this.dHD != null) {
                this.dHD.lV(this.mPosition);
            }
        } else if (view == this.dHB || view == this.dHC || view == this.dHA) {
            if (this.dHz.getVisibility() == 0) {
                if (this.dHD != null) {
                    this.dHD.lV(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dHC.getVisibility() == 0) {
                this.dHC.setVisibility(8);
                gr(false);
            }
            if (this.dHB.getVisibility() == 0) {
                this.dHB.setVisibility(8);
            }
            if (this.dHA.getVisibility() == 0) {
                this.dHA.setVisibility(8);
            }
            lU(0);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fS(boolean z) {
        if (this.dqY != null && this.dqY.drx != null) {
            this.dqY.drx.hasFocus = z;
            c(this.dqY);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void awh() {
        if (this.dqY != null) {
            this.dqY.hasAgree = !this.dqY.hasAgree;
            if (this.dqY.hasAgree) {
                this.dqY.agreeNum++;
            } else {
                this.dqY.agreeNum--;
            }
            if (this.awR != null) {
                this.awR.startAnimation(getScaleAnimation());
            }
            d(this.dqY);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axD == null) {
            this.axD = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axD.setDuration(200L);
        }
        return this.axD;
    }

    public void gq(boolean z) {
        if (this.dqJ != null) {
            this.dqJ.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dHD = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Pp = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gr(boolean z) {
        this.dHx = this.mPosition == (this.dHE == null ? -1 : this.dHE.aBf());
        if (this.dHx && z && isPlaying() && this.drg && !this.dHy) {
            this.dHv.setVisibility(0);
            this.dHy = true;
            this.dHv.postDelayed(this.dHH, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dHE != null) {
                this.dHE.bK(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dHv.setVisibility(8);
        if (this.dHH != null) {
            this.dHv.removeCallbacks(this.dHH);
        }
    }

    private void AM() {
        if (this.dqY != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dqY.forumId);
            String str = this.dqY.title;
            String str2 = this.dqY.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dqY.dry.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dqY.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aGf = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aGi = 3;
            dVar.fid = valueOf;
            dVar.aGb = "";
            dVar.tid = str2;
            dVar.aFX = true;
            dVar.aGh = 0;
            dVar.aGj = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            com.baidu.tieba.c.e.akO().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        awf();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        awe();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public List<String> getMediaIDs() {
        if (this.dqX != null) {
            return this.dqX.getMediaIDs();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public String getMediaId() {
        return this.dqX != null ? this.dqX.getMediaId() : "";
    }
}
