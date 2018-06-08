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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.h;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i {
    private com.baidu.tieba.lego.card.view.f Pq;
    private String afO;
    private TextView awB;
    private ImageView awC;
    private View awD;
    private TextView awE;
    private ImageView awF;
    private View awG;
    private TextView awH;
    private ImageView awI;
    private View awJ;
    private ScaleAnimation axk;
    public TextView axo;
    public TextView bTp;
    private Animation bsX;
    private n btk;
    public HeadImageView ceW;
    private View dBA;
    private View dBB;
    private b dBC;
    public com.baidu.tieba.frs.videomiddlepage.a.a dBD;
    private Animation.AnimationListener dBE;
    private Animation.AnimationListener dBF;
    private Runnable dBG;
    private View dBr;
    private View dBs;
    private ImageView dBt;
    private FrameLayout dBu;
    private TextView dBv;
    private boolean dBw;
    private boolean dBx;
    private View dBy;
    private View dBz;
    private Animation dlA;
    private boolean dlB;
    private boolean dlC;
    public FrameLayout dlf;
    public FrameLayout dlg;
    public TextView dlh;
    public com.baidu.tieba.play.c dls;
    public com.baidu.tieba.frs.aggregation.g dlt;
    private h dlu;
    private y dlv;
    private y dlw;
    private boolean dlx;
    private boolean dly;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dlx = true;
        this.dlC = true;
        this.dBw = false;
        this.dBx = false;
        this.dBE = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dBy != null) {
                    a.this.dBy.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dBy != null) {
                    a.this.dBy.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dBF = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dBy != null) {
                    a.this.dBy.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dBy != null) {
                    a.this.dBy.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dBG = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBu.getVisibility() == 0) {
                    a.this.dBu.setVisibility(8);
                }
            }
        };
        this.dlC = z;
        this.mFrom = str;
        this.afO = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dlf = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dBr = view.findViewById(d.g.card_container);
        this.dlg = (FrameLayout) view.findViewById(d.g.video_container);
        this.dls = new com.baidu.tieba.play.c(tbPageContext, this.dlg, false);
        this.dls.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dBD != null && a.this.dlt.dlT.videoDuration > 8) {
                    a.this.dBD.S(a.this.mPosition, a.this.dlt.dlT.videoUrl);
                }
            }
        });
        this.dlh = (TextView) view.findViewById(d.g.title);
        this.ceW = (HeadImageView) view.findViewById(d.g.user_icon);
        this.axo = (TextView) view.findViewById(d.g.user_name);
        this.bTp = (TextView) view.findViewById(d.g.attention);
        this.awB = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.awC = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.awD = view.findViewById(d.g.agree_view_container);
        this.awE = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.awF = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.awG = view.findViewById(d.g.thread_info_commont_container);
        this.awH = (TextView) view.findViewById(d.g.share_num);
        this.awI = (ImageView) view.findViewById(d.g.share_num_img);
        this.awJ = view.findViewById(d.g.share_num_container);
        this.dBu = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.dBv = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.dBu.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dBv.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dBv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.zG().a((TbPageContext) com.baidu.adp.base.i.ad(a.this.aiH().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dBs = view.findViewById(d.g.attention_container);
        this.dBt = (ImageView) view.findViewById(d.g.attention_img);
        this.dBy = view.findViewById(d.g.video_agg_container_foreground);
        this.dBz = view.findViewById(d.g.user_container_foreground);
        this.dBA = view.findViewById(d.g.title_foreground);
        this.dBB = view.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dBz.setOnClickListener(this);
        this.dBA.setOnClickListener(this);
        this.dBB.setOnClickListener(this);
        this.dBy.setOnClickListener(this);
        this.awD.setOnClickListener(this);
        this.awG.setOnClickListener(this);
        this.awJ.setOnClickListener(this);
        this.dlh.setOnClickListener(this);
        this.ceW.setOnClickListener(this);
        this.axo.setOnClickListener(this);
        this.dBs.setOnClickListener(this);
        this.dBr.setOnClickListener(this);
        this.mWidth = l.ah(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dlf.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dlf.setLayoutParams(layoutParams);
        this.ceW.setIsRound(true);
        this.btk = new n(tbPageContext.getPageActivity());
        this.dlu = new h(this.mPageContext, this);
        this.dlA = new AlphaAnimation(0.0f, 0.7f);
        this.dlA.setDuration(500L);
        this.dlA.setAnimationListener(this.dBF);
        this.bsX = new AlphaAnimation(0.7f, 0.0f);
        this.bsX.setDuration(500L);
        this.bsX.setAnimationListener(this.dBE);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dlt != null && this.dlt.dlS != null) {
            if (this.dlt.dlS.hasFocus) {
                this.bTp.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_d));
                this.dBs.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.bTp.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            }
        }
        if (this.dlt != null) {
            if (this.dlt.hasAgree) {
                this.awC.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.icon_home_card_like_s));
                this.awB.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
            } else {
                this.awC.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_like_selector));
                this.awB.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
            }
        }
        this.awE.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.awF.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_commnet_selector));
        this.awH.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.awI.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_share_selector));
        this.dlh.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dlT != null) {
            this.dlt = gVar;
            this.dlB = this.dlt.autoPlay;
            this.dBx = false;
            gf(false);
            this.dlh.setVisibility(0);
            this.dlh.setText(gVar.title);
            azF();
            b(gVar, i, aVar);
            h(gVar);
            i(gVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        b(gVar, i, aVar);
    }

    private boolean azE() {
        try {
            int parseInt = Integer.parseInt(this.dlt.dlT.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dlt.dlT.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void azF() {
        if (!azE()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dlf.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dlf.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dlf.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dlf.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dlT != null) {
            this.dls.stopPlay();
            this.dls.lu(true);
            this.dls.lx(true);
            this.dls.lv(false);
            this.dls.ly(true);
            this.dls.K(false, false);
            this.dls.rz(i);
            this.dls.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void auZ() {
                    a.this.azG();
                }

                @Override // com.baidu.tieba.play.c.b
                public void ava() {
                    a.this.azH();
                    if (a.this.dls.bkY()) {
                    }
                    if (a.this.dly) {
                        a.this.dls.stopPlay();
                    }
                }
            });
            this.dls.a(new c.k() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.k
                public void avb() {
                    if (a.this.dlt != null && a.this.dlt.dlT != null && com.baidu.adp.lib.g.b.g(a.this.dlt.dlT.videoHeight, 0) > com.baidu.adp.lib.g.b.g(a.this.dlt.dlT.videoWidth, 0)) {
                        a.this.dls.K(false, false);
                    } else {
                        a.this.dls.K(true, false);
                    }
                    a.this.dly = false;
                    a.this.my(a.this.dlB ? "1" : "2");
                    a.this.onClick(a.this.dlg);
                    if (a.this.Pq != null) {
                        a.this.Pq.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.k
                public void avc() {
                    a.this.onClick(a.this.dlf);
                }
            });
            this.dls.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void fL(boolean z) {
                    a.this.dls.bT(a.this.dlt.dlT.videoUrl, a.this.dlt.threadId);
                    a.this.my("2");
                    a.this.onClick(a.this.dlg);
                }
            });
            this.dls.ls(false);
            this.dlv = new y();
            this.dlv.aVt = gVar.threadId;
            this.dlv.cBu = gVar.forumId;
            this.dlv.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dlv.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.dlv.mSource = gVar.source;
            this.dlv.gdb = gVar.weight;
            this.dlv.gdd = this.mFrom;
            this.dlv.gde = gVar.abtest_tag;
            this.dlv.afO = this.afO;
            this.dlv.mExtra = gVar.extra;
            this.dlv.gdh = "0";
            this.dlw = new y();
            this.dlw.aVt = gVar.threadId;
            this.dlw.cBu = gVar.forumId;
            this.dlw.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dlw.gdb = "auto_midpage";
            this.dlw.mLocate = "auto_midpage";
            this.dlw.gdd = this.mFrom;
            this.dlw.mSource = gVar.source;
            this.dlw.gdh = "0";
            if (gVar.dlT != null) {
                this.dlv.gdf = gVar.dlT.videoMd5;
                this.dlw.gdf = gVar.dlT.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.ah("tid", gVar.threadId);
            amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.r("obj_locate", i);
            amVar.r("obj_param2", 1);
            amVar.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.ah("obj_param1", gVar.weight);
            amVar.ah("extra", gVar.extra);
            amVar.ah(VideoPlayActivityConfig.OBJ_ID, this.afO);
            amVar.ah("ab_tag", gVar.abtest_tag);
            amVar.ah("obj_type", this.mFrom);
            amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dlt.source);
            amVar.r("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.btk.setVideoStatsData(this.dlv);
            this.dls.getVideoView().setBusiness(this.btk);
            this.dls.aQu();
            this.dls.b(new c.InterfaceC0217c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void fM(boolean z) {
                    if (!a.this.dls.bkY()) {
                        a.this.lC(0);
                        a.this.dBB.setVisibility(0);
                        a.this.dBA.setVisibility(0);
                        a.this.dBz.setVisibility(0);
                    } else if (z) {
                        if (a.this.dBB.getVisibility() == 8) {
                            a.this.dBB.setVisibility(0);
                            a.this.gf(true);
                        }
                        if (a.this.dBA.getVisibility() == 8) {
                            a.this.dBA.setVisibility(0);
                        }
                        if (a.this.dBz.getVisibility() == 8) {
                            a.this.dBz.setVisibility(0);
                        }
                        a.this.lC(1);
                    } else {
                        if (a.this.dBB.getVisibility() == 0) {
                            a.this.dBB.setVisibility(8);
                            a.this.gf(false);
                        }
                        if (a.this.dBA.getVisibility() == 0) {
                            a.this.dBA.setVisibility(8);
                        }
                        if (a.this.dBz.getVisibility() == 0) {
                            a.this.dBz.setVisibility(8);
                        }
                        a.this.lC(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void avd() {
                    a.this.lC(1);
                    if (!a.this.dls.bkY()) {
                        a.this.dBB.setVisibility(0);
                        a.this.dBA.setVisibility(0);
                        a.this.dBz.setVisibility(0);
                        return;
                    }
                    if (a.this.dBB.getVisibility() == 8) {
                        a.this.dBB.setVisibility(0);
                    }
                    if (a.this.dBA.getVisibility() == 8) {
                        a.this.dBA.setVisibility(0);
                    }
                    if (a.this.dBz.getVisibility() == 8) {
                        a.this.dBz.setVisibility(0);
                    }
                }
            });
            this.dls.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (a.this.isFullScreen) {
                        a.this.dly = true;
                        a.this.dlx = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.kt(i);
                        a.this.dls.aDt();
                    }
                }
            });
            this.dls.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.dlt != null && a.this.dlt.dlT != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dlt.dlT.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dls.pq(gVar.dlT.thumbnailUrl);
            this.dls.bS(gVar.dlT.videoUrl, gVar.threadId);
            this.dls.a(new c.h() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.h
                public void ave() {
                }
            });
            this.dls.aDt();
            this.dls.show();
            if (gVar.autoPlay) {
                onClick(this.dlg);
                this.dly = false;
                this.dls.a(gVar.dlT.videoUrl, gVar.threadId, null, new Object[0]);
                if (i == 0) {
                    this.dBy.setVisibility(8);
                } else {
                    this.dBy.startAnimation(this.bsX);
                }
                this.dBA.setVisibility(8);
                this.dBB.setVisibility(8);
                gf(false);
                this.dBz.setVisibility(8);
            } else if (j.jF() && gVar.waitConfirm) {
                this.dBy.startAnimation(this.bsX);
                this.dBA.setVisibility(8);
                this.dBB.setVisibility(8);
                gf(false);
                this.dBz.setVisibility(8);
            } else {
                this.dBA.setVisibility(0);
                this.dBB.setVisibility(0);
                this.dBz.setVisibility(0);
                this.dBy.setVisibility(0);
            }
            this.dly = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC(int i) {
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
    public void my(String str) {
        if (this.dlt != null && this.dlt.dlT != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dlt.dlT.videoMd5, "", str, this.dlw);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.dls.bkY();
    }

    public void auV() {
        if (isPlaying()) {
            this.dls.pausePlay();
        }
    }

    public boolean ku(int i) {
        return this.dls.ry(i);
    }

    public void auW() {
        this.dBx = false;
        this.dls.stopPlay();
        if (this.dlh != null) {
            this.dlh.setVisibility(0);
        }
        gf(false);
        this.dBw = true;
    }

    public void auX() {
        if (this.dls != null) {
            this.dls.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        auX();
        if (this.dlu != null) {
            this.dlu.avk();
        }
        if (this.dBy != null) {
            this.dBy.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dlS != null) {
            this.axo.setText(TextUtils.isEmpty(gVar.dlS.userNickname) ? gVar.dlS.userName : gVar.dlS.userNickname);
            if (!StringUtils.isNull(gVar.dlS.portrait) && gVar.dlS.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.ceW.startLoad(gVar.dlS.portrait, 10, false);
            } else {
                this.ceW.startLoad(gVar.dlS.portrait, 12, false);
            }
            if (gVar.dlS.isBigV) {
                this.ceW.setShowV(gVar.dlS.isBigV);
                this.ceW.setIsBigV(gVar.dlS.isBigV);
            } else if (gVar.dlS.isGod) {
                this.ceW.setShowV(gVar.dlS.isGod);
                this.ceW.setIsBigV(gVar.dlS.isGod);
            } else {
                this.ceW.setShowV(gVar.dlS.isGod);
                this.ceW.setIsBigV(gVar.dlS.isGod);
            }
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.dlS != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.dlS.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.dlS.userId)) {
                this.dBs.setVisibility(8);
            } else {
                this.dBs.setVisibility(0);
            }
            if (gVar.dlS.hasFocus) {
                this.bTp.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_d));
                this.bTp.setText(this.mPageContext.getString(d.k.relate_forum_is_followed));
                this.dBs.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dBt.setVisibility(8);
                return;
            }
            this.bTp.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            this.bTp.setText(this.mPageContext.getString(d.k.attention));
            this.dBt.setVisibility(0);
            this.dBs.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.awC.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_like_s));
                this.awB.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_h_1));
            } else {
                this.awC.setImageDrawable(getContext().getResources().getDrawable(d.f.card_like_selector));
                this.awB.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_i));
            }
            if (gVar.agreeNum > 0) {
                this.awB.setText(ao.E(gVar.agreeNum));
            } else {
                this.awB.setText(d.k.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.awE.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.awF.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.awE.setText(ao.E(gVar.postNum));
            } else {
                this.awE.setText(this.mContext.getString(d.k.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (this.awJ != null && this.awH != null && gVar != null) {
            long j = gVar.shareNum;
            String string = this.mContext.getString(d.k.share);
            if (j > 0) {
                string = ao.E(j);
            }
            this.awH.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dls != null && this.dlg != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dlx) {
                this.dls.bkX();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                azG();
            } else {
                configuration.orientation = 1;
                azH();
                this.dlx = true;
            }
            this.dls.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azG() {
        if (this.dls != null && this.dlg != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dlg.getParent() != null) {
                if (this.dlg.getParent() == frameLayout) {
                    frameLayout.removeView(this.dlg);
                } else if (this.dlg.getParent() == this.dlf) {
                    this.dlf.removeView(this.dlg);
                }
            }
            if (this.dlg.getParent() == null) {
                frameLayout.addView(this.dlg);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dlg.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dlg.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azH() {
        if (this.dls != null && this.dlg != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dlg.getParent() != null) {
                if (this.dlg.getParent() == frameLayout) {
                    frameLayout.removeView(this.dlg);
                } else if (this.dlg.getParent() == this.dlf) {
                    this.dlf.removeView(this.dlg);
                }
            }
            if (this.dlg.getParent() == null) {
                this.dlf.addView(this.dlg, 0);
                azI();
                this.dls.aQu();
            }
        }
    }

    private void azI() {
        int i;
        if (!azE()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dlg.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (aiI() != null) {
            view.setTag(this);
            aiI().a(view, this.dlt);
        }
        if (view == this.ceW || view == this.axo) {
            if (this.dlt != null && this.dlt.dlS != null && !TextUtils.isEmpty(this.dlt.dlS.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dlt.dlS.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dlt.dlS.userId, 0L), z, this.dlt.dlS.isGod)));
            }
        } else if (view == this.awG || view == this.dlh || view == this.dBr) {
            if (this.dlt != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dlt.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dBs) {
            if (!this.dlt.dlS.hasFocus) {
                this.dlu.f(this.dlt);
            }
        } else if (view == this.awD) {
            this.dlu.g(this.dlt);
        } else if (view == this.awJ) {
            AD();
        } else if (view == this.dBy && this.dBy.getVisibility() == 0) {
            if (this.dBC != null) {
                this.dBC.lD(this.mPosition);
            }
        } else if (view == this.dBA || view == this.dBB || view == this.dBz) {
            if (this.dBy.getVisibility() == 0) {
                if (this.dBC != null) {
                    this.dBC.lD(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dBB.getVisibility() == 0) {
                this.dBB.setVisibility(8);
                gf(false);
            }
            if (this.dBA.getVisibility() == 0) {
                this.dBA.setVisibility(8);
            }
            if (this.dBz.getVisibility() == 0) {
                this.dBz.setVisibility(8);
            }
            lC(0);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void fK(boolean z) {
        if (this.dlt != null && this.dlt.dlS != null) {
            this.dlt.dlS.hasFocus = z;
            c(this.dlt);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void auY() {
        if (this.dlt != null) {
            this.dlt.hasAgree = !this.dlt.hasAgree;
            if (this.dlt.hasAgree) {
                this.dlt.agreeNum++;
            } else {
                this.dlt.agreeNum--;
            }
            if (this.awC != null) {
                this.awC.startAnimation(getScaleAnimation());
            }
            d(this.dlt);
        }
    }

    private Animation getScaleAnimation() {
        if (this.axk == null) {
            this.axk = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axk.setDuration(200L);
        }
        return this.axk;
    }

    public void ge(boolean z) {
        if (this.dlf != null) {
            this.dlf.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(b bVar) {
        this.dBC = bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Pq = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gf(boolean z) {
        this.dBw = this.mPosition == (this.dBD == null ? -1 : this.dBD.azP());
        if (this.dBw && z && isPlaying() && this.dlB && !this.dBx) {
            this.dBu.setVisibility(0);
            this.dBx = true;
            this.dBu.postDelayed(this.dBG, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dBD != null) {
                this.dBD.bJ(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dBu.setVisibility(8);
        if (this.dBG != null) {
            this.dBu.removeCallbacks(this.dBG);
        }
    }

    private void AD() {
        if (this.dlt != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dlt.forumId);
            String str = this.dlt.title;
            String str2 = this.dlt.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dlt.dlT.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dlt.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.k.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.aFm = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.aFp = 3;
            dVar.fid = valueOf;
            dVar.aFh = "";
            dVar.tid = str2;
            dVar.aFd = true;
            dVar.aFo = 0;
            dVar.aFq = 2;
            if (parse != null) {
                dVar.aFj = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aFp);
            bundle.putInt("obj_type", dVar.aFq);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajZ);
            dVar.f(bundle);
            com.baidu.tieba.c.e.akV().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        auW();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        auV();
    }
}
