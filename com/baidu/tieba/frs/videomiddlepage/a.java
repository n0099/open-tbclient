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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
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
    private boolean alU;
    private TextView awN;
    private ImageView awO;
    private View awP;
    private TextView awQ;
    private ImageView awR;
    private View awS;
    private TextView awT;
    private ImageView awU;
    private View awV;
    private ScaleAnimation axA;
    public TextView axI;
    private Animation bvg;
    private n bvt;
    public HeadImageView ciN;
    public com.baidu.tieba.frs.videomiddlepage.a.a dHA;
    private Animation.AnimationListener dHB;
    private Animation.AnimationListener dHC;
    private Runnable dHD;
    private View dHo;
    private View dHp;
    private ImageView dHq;
    private FrameLayout dHr;
    private TextView dHs;
    private boolean dHt;
    private boolean dHu;
    private View dHv;
    private View dHw;
    private View dHx;
    private View dHy;
    private b dHz;
    public FrameLayout dqH;
    public FrameLayout dqI;
    public TextView dqJ;
    public TextView dqO;
    public com.baidu.tieba.play.c dqV;
    public com.baidu.tieba.frs.aggregation.g dqW;
    private h dqX;
    private y dqY;
    private y dqZ;
    private boolean dra;
    private boolean drb;
    private Animation drd;
    private boolean dre;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dra = true;
        this.dre = true;
        this.dHt = false;
        this.dHu = false;
        this.dHB = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dHv != null) {
                    a.this.dHv.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dHv != null) {
                    a.this.dHv.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dHC = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dHv != null) {
                    a.this.dHv.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dHv != null) {
                    a.this.dHv.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dHD = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dHr.getVisibility() == 0) {
                    a.this.dHr.setVisibility(8);
                }
            }
        };
        this.dre = z;
        this.mFrom = str;
        this.afx = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dqH = (FrameLayout) view.findViewById(f.g.video_agg_container);
        this.dHo = view.findViewById(f.g.card_container);
        this.dqI = (FrameLayout) view.findViewById(f.g.video_container);
        this.dqV = new com.baidu.tieba.play.c(tbPageContext, this.dqI, false);
        this.dqV.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dHA != null && a.this.dqW.drv.videoDuration > 8) {
                    a.this.dHA.R(a.this.mPosition, a.this.dqW.drv.videoUrl);
                }
            }
        });
        this.dqJ = (TextView) view.findViewById(f.g.title);
        this.ciN = (HeadImageView) view.findViewById(f.g.user_icon);
        this.axI = (TextView) view.findViewById(f.g.user_name);
        this.dqO = (TextView) view.findViewById(f.g.attention);
        this.awN = (TextView) view.findViewById(f.g.thread_info_praise_num);
        this.awO = (ImageView) view.findViewById(f.g.thread_info_praise_img);
        this.awP = view.findViewById(f.g.agree_view_container);
        this.awQ = (TextView) view.findViewById(f.g.thread_info_commont_num);
        this.awR = (ImageView) view.findViewById(f.g.thread_info_commont_img);
        this.awS = view.findViewById(f.g.thread_info_commont_container);
        this.awT = (TextView) view.findViewById(f.g.share_num);
        this.awU = (ImageView) view.findViewById(f.g.share_num_img);
        this.awV = view.findViewById(f.g.share_num_container);
        this.dHr = (FrameLayout) view.findViewById(f.g.download_nani_guide_container);
        this.dHs = (TextView) view.findViewById(f.g.download_nani_guide_txt);
        this.dHr.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dHs.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dHs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    az.zI().a((TbPageContext) com.baidu.adp.base.i.ad(a.this.aiB().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dHp = view.findViewById(f.g.attention_container);
        this.dHq = (ImageView) view.findViewById(f.g.attention_img);
        this.dHv = view.findViewById(f.g.video_agg_container_foreground);
        this.dHw = view.findViewById(f.g.user_container_foreground);
        this.dHx = view.findViewById(f.g.title_foreground);
        this.dHy = view.findViewById(f.g.comment_and_priase_layout_foreground);
        this.dHw.setOnClickListener(this);
        this.dHx.setOnClickListener(this);
        this.dHy.setOnClickListener(this);
        this.dHv.setOnClickListener(this);
        this.awP.setOnClickListener(this);
        this.awS.setOnClickListener(this);
        this.awV.setOnClickListener(this);
        this.dqJ.setOnClickListener(this);
        this.ciN.setOnClickListener(this);
        this.axI.setOnClickListener(this);
        this.dHp.setOnClickListener(this);
        this.dHo.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dqH.setLayoutParams(layoutParams);
        this.ciN.setIsRound(true);
        this.bvt = new n(tbPageContext.getPageActivity());
        this.dqX = new h(this.mPageContext, this);
        this.drd = new AlphaAnimation(0.0f, 0.7f);
        this.drd.setDuration(500L);
        this.drd.setAnimationListener(this.dHC);
        this.bvg = new AlphaAnimation(0.7f, 0.0f);
        this.bvg.setDuration(500L);
        this.bvg.setAnimationListener(this.dHB);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dqW != null && this.dqW.dru != null) {
            if (this.dqW.dru.hasFocus) {
                this.dqO.setTextColor(tbPageContext.getResources().getColor(f.d.cp_cont_d));
                this.dHp.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.transparent_bg));
            } else {
                this.dqO.setTextColor(tbPageContext.getResources().getColor(f.d.cp_link_tip_a));
            }
        }
        if (this.dqW != null) {
            if (this.dqW.hasAgree) {
                this.awO.setImageDrawable(tbPageContext.getResources().getDrawable(f.C0146f.icon_home_card_like_s));
                this.awN.setTextColor(tbPageContext.getResources().getColor(f.d.cp_cont_i));
            } else {
                this.awO.setImageDrawable(tbPageContext.getResources().getDrawable(f.C0146f.card_like_selector));
                this.awN.setTextColor(tbPageContext.getResources().getColor(f.d.cp_cont_i));
            }
        }
        this.awQ.setTextColor(tbPageContext.getResources().getColor(f.d.cp_cont_i));
        this.awR.setImageDrawable(tbPageContext.getResources().getDrawable(f.C0146f.card_commnet_selector));
        this.awT.setTextColor(tbPageContext.getResources().getColor(f.d.cp_cont_i));
        this.awU.setImageDrawable(tbPageContext.getResources().getDrawable(f.C0146f.card_share_selector));
        this.dqJ.setTextColor(tbPageContext.getResources().getColor(f.d.cp_cont_i));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.drv != null) {
            this.dqW = gVar;
            this.alU = this.dqW.autoPlay;
            this.dHu = false;
            gr(false);
            this.dqJ.setVisibility(0);
            this.dqJ.setText(gVar.title);
            aAQ();
            b(gVar, i, aVar);
            h(gVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean aAP() {
        try {
            int parseInt = Integer.parseInt(this.dqW.drv.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dqW.drv.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aAQ() {
        if (!aAP()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dqH.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dqH.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.drv != null) {
            this.dqV.stopPlay();
            this.dqV.setIsNeedRecoveryVideoPlayer(true);
            this.dqV.ls(true);
            this.dqV.lq(true);
            this.dqV.lt(true);
            this.dqV.N(false, false);
            this.dqV.rF(i);
            this.dqV.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void awh() {
                    a.this.aAR();
                }

                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                    a.this.aAS();
                    if (a.this.dqV.bjR()) {
                    }
                    if (a.this.drb) {
                        a.this.dqV.stopPlay();
                    }
                }
            });
            this.dqV.a(new c.k() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.k
                public void awj() {
                    if (a.this.dqW != null && a.this.dqW.drv != null && com.baidu.adp.lib.g.b.g(a.this.dqW.drv.videoHeight, 0) > com.baidu.adp.lib.g.b.g(a.this.dqW.drv.videoWidth, 0)) {
                        a.this.dqV.N(false, false);
                    } else {
                        a.this.dqV.N(true, false);
                    }
                    a.this.drb = false;
                    a.this.mz(a.this.alU ? "1" : "2");
                    a.this.onClick(a.this.dqI);
                    if (a.this.Pp != null) {
                        a.this.Pp.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.k
                public void awk() {
                    a.this.onClick(a.this.dqH);
                }
            });
            this.dqV.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void fT(boolean z) {
                    a.this.dqV.bS(a.this.dqW.drv.videoUrl, a.this.dqW.threadId);
                    a.this.mz("2");
                    a.this.onClick(a.this.dqI);
                }
            });
            this.dqV.lo(false);
            this.dqY = new y();
            this.dqY.aWq = gVar.threadId;
            this.dqY.cBR = gVar.forumId;
            this.dqY.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dqY.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dqY.mSource = gVar.source;
            this.dqY.ghB = gVar.weight;
            this.dqY.ghD = this.mFrom;
            this.dqY.ghE = gVar.abtest_tag;
            this.dqY.afx = this.afx;
            this.dqY.cBN = gVar.extra;
            this.dqY.ghH = "0";
            this.dqZ = new y();
            this.dqZ.aWq = gVar.threadId;
            this.dqZ.cBR = gVar.forumId;
            this.dqZ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dqZ.ghB = "auto_midpage";
            this.dqZ.mLocate = "auto_midpage";
            this.dqZ.ghD = this.mFrom;
            this.dqZ.mSource = gVar.source;
            this.dqZ.ghH = "0";
            if (gVar.drv != null) {
                this.dqY.ghF = gVar.drv.videoMd5;
                this.dqZ.ghF = gVar.drv.videoMd5;
            }
            an anVar = new an("c12590");
            anVar.ae("tid", gVar.threadId);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.r("obj_locate", i);
            anVar.r("obj_param2", 1);
            anVar.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
            anVar.ae("obj_param1", gVar.weight);
            anVar.ae("extra", gVar.extra);
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, this.afx);
            anVar.ae("ab_tag", gVar.abtest_tag);
            anVar.ae("obj_type", this.mFrom);
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dqW.source);
            anVar.r("is_vertical", 0);
            TiebaStatic.log(anVar);
            this.bvt.setVideoStatsData(this.dqY);
            this.dqV.getVideoView().setBusiness(this.bvt);
            this.bvt.a(gVar);
            this.dqV.aRZ();
            this.dqV.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (!a.this.dqV.bjR()) {
                        a.this.lU(0);
                        a.this.dHy.setVisibility(0);
                        a.this.dHx.setVisibility(0);
                        a.this.dHw.setVisibility(0);
                    } else if (z) {
                        if (a.this.dHy.getVisibility() == 8) {
                            a.this.dHy.setVisibility(0);
                            a.this.gr(true);
                        }
                        if (a.this.dHx.getVisibility() == 8) {
                            a.this.dHx.setVisibility(0);
                        }
                        if (a.this.dHw.getVisibility() == 8) {
                            a.this.dHw.setVisibility(0);
                        }
                        a.this.lU(1);
                    } else {
                        if (a.this.dHy.getVisibility() == 0) {
                            a.this.dHy.setVisibility(8);
                            a.this.gr(false);
                        }
                        if (a.this.dHx.getVisibility() == 0) {
                            a.this.dHx.setVisibility(8);
                        }
                        if (a.this.dHw.getVisibility() == 0) {
                            a.this.dHw.setVisibility(8);
                        }
                        a.this.lU(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awl() {
                    a.this.lU(1);
                    if (!a.this.dqV.bjR()) {
                        a.this.dHy.setVisibility(0);
                        a.this.dHx.setVisibility(0);
                        a.this.dHw.setVisibility(0);
                        return;
                    }
                    if (a.this.dHy.getVisibility() == 8) {
                        a.this.dHy.setVisibility(0);
                    }
                    if (a.this.dHx.getVisibility() == 8) {
                        a.this.dHx.setVisibility(0);
                    }
                    if (a.this.dHw.getVisibility() == 8) {
                        a.this.dHw.setVisibility(0);
                    }
                }
            });
            this.dqV.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.drb = true;
                        a.this.dra = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.kK(i);
                        a.this.dqV.aFa();
                    }
                }
            });
            this.dqV.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.dqW != null && a.this.dqW.drv != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dqW.drv.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dqV.setThumbnail(gVar.drv.thumbnailUrl);
            this.dqV.setVideoUrl(gVar.drv.videoUrl, gVar.threadId);
            this.dqV.a(new c.h() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.h
                public void awm() {
                }
            });
            this.dqV.aFa();
            this.dqV.show();
            if (gVar.autoPlay) {
                onClick(this.dqI);
                this.drb = false;
                this.dqV.a(gVar.drv.videoUrl, gVar.threadId, (c.d) null, new Object[0]);
                if (i == 0) {
                    this.dHv.setVisibility(8);
                } else {
                    this.dHv.startAnimation(this.bvg);
                }
                this.dHx.setVisibility(8);
                this.dHy.setVisibility(8);
                gr(false);
                this.dHw.setVisibility(8);
            } else if (com.baidu.adp.lib.util.j.jG() && gVar.waitConfirm) {
                this.dHv.startAnimation(this.bvg);
                this.dHx.setVisibility(8);
                this.dHy.setVisibility(8);
                gr(false);
                this.dHw.setVisibility(8);
            } else {
                this.dHx.setVisibility(0);
                this.dHy.setVisibility(0);
                this.dHw.setVisibility(0);
                this.dHv.setVisibility(0);
            }
            this.drb = false;
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
    public void mz(String str) {
        if (this.dqW != null && this.dqW.drv != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dqW.drv.videoMd5, "", str, this.dqZ);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.dqV.bjR();
    }

    public void awd() {
        if (isPlaying()) {
            this.dqV.pausePlay();
        }
    }

    public boolean kL(int i) {
        return this.dqV.rE(i);
    }

    public void awe() {
        this.dHu = false;
        this.dqV.stopPlay();
        if (this.dqJ != null) {
            this.dqJ.setVisibility(0);
        }
        gr(false);
        this.dHt = true;
    }

    public void awf() {
        if (this.dqV != null) {
            this.dqV.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awf();
        if (this.dqX != null) {
            this.dqX.awr();
        }
        if (this.dHv != null) {
            this.dHv.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dru != null) {
            this.axI.setText(TextUtils.isEmpty(gVar.dru.userNickname) ? gVar.dru.userName : gVar.dru.userNickname);
            if (!StringUtils.isNull(gVar.dru.portrait) && gVar.dru.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.ciN.startLoad(gVar.dru.portrait, 10, false);
            } else {
                this.ciN.startLoad(gVar.dru.portrait, 12, false);
            }
            if (gVar.dru.isBigV) {
                this.ciN.setShowV(gVar.dru.isBigV);
                this.ciN.setIsBigV(gVar.dru.isBigV);
            } else if (gVar.dru.isGod) {
                this.ciN.setShowV(gVar.dru.isGod);
                this.ciN.setIsBigV(gVar.dru.isGod);
            } else {
                this.ciN.setShowV(gVar.dru.isGod);
                this.ciN.setIsBigV(gVar.dru.isGod);
            }
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dru != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dru.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dru.userId)) {
                this.dHp.setVisibility(8);
            } else {
                this.dHp.setVisibility(0);
            }
            if (gVar.dru.hasFocus) {
                this.dqO.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_d));
                this.dqO.setText(this.mPageContext.getString(f.j.relate_forum_is_followed));
                this.dHp.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.transparent_bg));
                this.dHq.setVisibility(8);
                return;
            }
            this.dqO.setTextColor(this.mContext.getResources().getColor(f.d.cp_link_tip_a));
            this.dqO.setText(this.mPageContext.getString(f.j.attention));
            this.dHq.setVisibility(0);
            this.dHp.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.awO.setImageDrawable(getContext().getResources().getDrawable(f.C0146f.icon_home_card_like_s));
                this.awN.setTextColor(getContext().getResources().getColor(f.d.cp_cont_h_1));
            } else {
                this.awO.setImageDrawable(getContext().getResources().getDrawable(f.C0146f.card_like_selector));
                this.awN.setTextColor(getContext().getResources().getColor(f.d.cp_cont_i));
            }
            if (gVar.agreeNum > 0) {
                this.awN.setText(ap.H(gVar.agreeNum));
            } else {
                this.awN.setText(f.j.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.awQ.setTextColor(getContext().getResources().getColor(f.d.cp_cont_f));
            this.awR.setImageDrawable(getContext().getResources().getDrawable(f.C0146f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.awQ.setText(ap.H(gVar.postNum));
            } else {
                this.awQ.setText(this.mContext.getString(f.j.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (this.awV != null && this.awT != null && gVar != null) {
            long j = gVar.shareNum;
            String string = this.mContext.getString(f.j.share);
            if (j > 0) {
                string = ap.H(j);
            }
            this.awT.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dqV != null && this.dqI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dra) {
                this.dqV.bjQ();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aAR();
            } else {
                configuration.orientation = 1;
                aAS();
                this.dra = true;
            }
            this.dqV.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAR() {
        if (this.dqV != null && this.dqI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dqI.getParent() != null) {
                if (this.dqI.getParent() == frameLayout) {
                    frameLayout.removeView(this.dqI);
                } else if (this.dqI.getParent() == this.dqH) {
                    this.dqH.removeView(this.dqI);
                }
            }
            if (this.dqI.getParent() == null) {
                frameLayout.addView(this.dqI);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dqI.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dqI.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAS() {
        if (this.dqV != null && this.dqI != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dqI.getParent() != null) {
                if (this.dqI.getParent() == frameLayout) {
                    frameLayout.removeView(this.dqI);
                } else if (this.dqI.getParent() == this.dqH) {
                    this.dqH.removeView(this.dqI);
                }
            }
            if (this.dqI.getParent() == null) {
                this.dqH.addView(this.dqI, 0);
                aAT();
                this.dqV.aRZ();
            }
        }
    }

    private void aAT() {
        int i;
        if (!aAP()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dqI.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (aiC() != null) {
            view.setTag(this);
            aiC().a(view, this.dqW);
        }
        if (view == this.ciN || view == this.axI) {
            if (this.dqW != null && this.dqW.dru != null && !TextUtils.isEmpty(this.dqW.dru.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dqW.dru.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dqW.dru.userId, 0L), z, this.dqW.dru.isGod)));
            }
        } else if (view == this.awS || view == this.dqJ || view == this.dHo) {
            if (this.dqW != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dqW.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dHp) {
            if (!this.dqW.dru.hasFocus) {
                this.dqX.f(this.dqW);
            }
        } else if (view == this.awP) {
            this.dqX.g(this.dqW);
        } else if (view == this.awV) {
            AJ();
        } else if (view == this.dHv && this.dHv.getVisibility() == 0) {
            if (this.dHz != null) {
                this.dHz.lV(this.mPosition);
            }
        } else if (view == this.dHx || view == this.dHy || view == this.dHw) {
            if (this.dHv.getVisibility() == 0) {
                if (this.dHz != null) {
                    this.dHz.lV(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dHy.getVisibility() == 0) {
                this.dHy.setVisibility(8);
                gr(false);
            }
            if (this.dHx.getVisibility() == 0) {
                this.dHx.setVisibility(8);
            }
            if (this.dHw.getVisibility() == 0) {
                this.dHw.setVisibility(8);
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
        if (this.dqW != null && this.dqW.dru != null) {
            this.dqW.dru.hasFocus = z;
            c(this.dqW);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void awg() {
        if (this.dqW != null) {
            this.dqW.hasAgree = !this.dqW.hasAgree;
            if (this.dqW.hasAgree) {
                this.dqW.agreeNum++;
            } else {
                this.dqW.agreeNum--;
            }
            if (this.awO != null) {
                this.awO.startAnimation(getScaleAnimation());
            }
            d(this.dqW);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axA == null) {
            this.axA = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axA.setDuration(200L);
        }
        return this.axA;
    }

    public void gq(boolean z) {
        if (this.dqH != null) {
            this.dqH.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dHz = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Pp = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gr(boolean z) {
        this.dHt = this.mPosition == (this.dHA == null ? -1 : this.dHA.aBc());
        if (this.dHt && z && isPlaying() && this.alU && !this.dHu) {
            this.dHr.setVisibility(0);
            this.dHu = true;
            this.dHr.postDelayed(this.dHD, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dHA != null) {
                this.dHA.bK(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dHr.setVisibility(8);
        if (this.dHD != null) {
            this.dHr.removeCallbacks(this.dHD);
        }
    }

    private void AJ() {
        if (this.dqW != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dqW.forumId);
            String str = this.dqW.title;
            String str2 = this.dqW.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dqW.drv.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dqW.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(f.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aGe = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aGh = 3;
            dVar.fid = valueOf;
            dVar.aGa = "";
            dVar.tid = str2;
            dVar.aFW = true;
            dVar.aGg = 0;
            dVar.aGi = 2;
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
            bundle.putInt("obj_param1", dVar.aGh);
            bundle.putInt("obj_type", dVar.aGi);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            com.baidu.tieba.c.e.akQ().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        awe();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void pausePlay() {
        awd();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public List<String> getMediaIDs() {
        if (this.dqV != null) {
            return this.dqV.getMediaIDs();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public String getMediaId() {
        return this.dqV != null ? this.dqV.getMediaId() : "";
    }
}
