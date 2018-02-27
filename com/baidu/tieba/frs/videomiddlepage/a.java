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
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.d;
import com.baidu.tieba.frs.aggregation.h;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.f> implements com.baidu.tieba.frs.aggregation.b {
    private String aMq;
    private TextView bcZ;
    private ScaleAnimation bdI;
    public TextView bdM;
    private ImageView bda;
    private View bdb;
    private TextView bdc;
    private ImageView bdd;
    private View bde;
    private TextView bdf;
    private ImageView bdg;
    private View bdh;
    public HeadImageView cFY;
    private Animation caB;
    private n caO;
    public TextView cuu;
    public FrameLayout dHQ;
    public FrameLayout dHR;
    public TextView dHS;
    public com.baidu.tieba.play.c dId;
    public com.baidu.tieba.frs.aggregation.f dIe;
    private h dIf;
    private aa dIg;
    private aa dIh;
    private boolean dIi;
    private boolean dIj;
    private Animation dIl;
    private boolean dIm;
    private boolean dIn;
    private View dVS;
    private View dVT;
    private ImageView dVU;
    private FrameLayout dVV;
    private TextView dVW;
    private boolean dVX;
    private boolean dVY;
    private View dVZ;
    private View dWa;
    private View dWb;
    private View dWc;
    private InterfaceC0159a dWd;
    public com.baidu.tieba.frs.videomiddlepage.a.a dWe;
    private Animation.AnimationListener dWf;
    private Animation.AnimationListener dWg;
    private Runnable dWh;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0159a {
        void nZ(int i);
    }

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dIi = true;
        this.dIn = true;
        this.dVX = false;
        this.dVY = false;
        this.dWf = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dVZ != null) {
                    a.this.dVZ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dVZ != null) {
                    a.this.dVZ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWg = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dVZ != null) {
                    a.this.dVZ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dVZ != null) {
                    a.this.dVZ.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWh = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dVV.getVisibility() == 0) {
                    a.this.dVV.setVisibility(8);
                }
            }
        };
        this.dIn = z;
        this.mFrom = str;
        this.aMq = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dHQ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dVS = view.findViewById(d.g.card_container);
        this.dHR = (FrameLayout) view.findViewById(d.g.video_container);
        this.dId = new com.baidu.tieba.play.c(tbPageContext, this.dHR, false);
        this.dId.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dWe != null && a.this.dIe.dIF.videoDuration > 8) {
                    a.this.dWe.J(a.this.mPosition, a.this.dIe.dIF.videoUrl);
                }
            }
        });
        this.dHS = (TextView) view.findViewById(d.g.title);
        this.cFY = (HeadImageView) view.findViewById(d.g.user_icon);
        this.bdM = (TextView) view.findViewById(d.g.user_name);
        this.cuu = (TextView) view.findViewById(d.g.attention);
        this.bcZ = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.bda = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.bdb = view.findViewById(d.g.agree_view_container);
        this.bdc = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.bdd = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.bde = view.findViewById(d.g.thread_info_commont_container);
        this.bdf = (TextView) view.findViewById(d.g.share_num);
        this.bdg = (ImageView) view.findViewById(d.g.share_num_img);
        this.bdh = view.findViewById(d.g.share_num_container);
        this.dVV = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.dVW = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.dVV.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dVW.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dVW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    aw.Dt().a((TbPageContext) i.ak(a.this.akN().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dVT = view.findViewById(d.g.attention_container);
        this.dVU = (ImageView) view.findViewById(d.g.attention_img);
        this.dVZ = view.findViewById(d.g.video_agg_container_foreground);
        this.dWa = view.findViewById(d.g.user_container_foreground);
        this.dWb = view.findViewById(d.g.title_foreground);
        this.dWc = view.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dWa.setOnClickListener(this);
        this.dWb.setOnClickListener(this);
        this.dWc.setOnClickListener(this);
        this.dVZ.setOnClickListener(this);
        this.bdb.setOnClickListener(this);
        this.bde.setOnClickListener(this);
        this.bdh.setOnClickListener(this);
        this.dHS.setOnClickListener(this);
        this.cFY.setOnClickListener(this);
        this.bdM.setOnClickListener(this);
        this.dVT.setOnClickListener(this);
        this.dVS.setOnClickListener(this);
        this.mWidth = l.ao(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dHQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dHQ.setLayoutParams(layoutParams);
        this.cFY.setIsRound(true);
        this.caO = new n(tbPageContext.getPageActivity());
        this.dIf = new h(this.mPageContext, this);
        this.dIl = new AlphaAnimation(0.0f, 0.7f);
        this.dIl.setDuration(500L);
        this.dIl.setAnimationListener(this.dWg);
        this.caB = new AlphaAnimation(0.7f, 0.0f);
        this.caB.setDuration(500L);
        this.caB.setAnimationListener(this.dWf);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dIe != null && this.dIe.dIE != null) {
            if (this.dIe.dIE.hasFocus) {
                this.cuu.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_d));
                this.dVT.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.cuu.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            }
        }
        if (this.dIe != null) {
            if (this.dIe.hasAgree) {
                this.bda.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.icon_home_card_like_s));
                this.bcZ.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
            } else {
                this.bda.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_like_selector));
                this.bcZ.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
            }
        }
        this.bdc.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.bdd.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_commnet_selector));
        this.bdf.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.bdg.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_share_selector));
        this.dHS.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.aggregation.f fVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.f fVar, int i, d.a aVar) {
        if (fVar != null && fVar.dIF != null) {
            this.dIe = fVar;
            this.dIm = this.dIe.autoPlay;
            this.dVY = false;
            gv(false);
            this.dHS.setVisibility(0);
            this.dHS.setText(fVar.title);
            aAz();
            b(fVar, i, aVar);
            h(fVar);
            i(fVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private boolean aAy() {
        try {
            int parseInt = Integer.parseInt(this.dIe.dIF.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dIe.dIF.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aAz() {
        if (!aAy()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dHQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dHQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dHQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dHQ.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.f fVar, final int i, final d.a aVar) {
        if (fVar != null && fVar.dIF != null) {
            this.dId.stopPlay();
            this.dId.lI(true);
            this.dId.lL(true);
            this.dId.lJ(false);
            this.dId.lM(true);
            this.dId.Q(false, false);
            this.dId.tR(i);
            this.dId.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void awA() {
                    a.this.aAA();
                }

                @Override // com.baidu.tieba.play.c.b
                public void awB() {
                    a.this.aAB();
                    if (a.this.dId.bkV()) {
                    }
                    if (a.this.dIj) {
                        a.this.dId.stopPlay();
                    }
                }
            });
            this.dId.a(new c.j() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.j
                public void awC() {
                    if (a.this.dIe != null && a.this.dIe.dIF != null && com.baidu.adp.lib.g.b.h(a.this.dIe.dIF.videoHeight, 0) > com.baidu.adp.lib.g.b.h(a.this.dIe.dIF.videoWidth, 0)) {
                        a.this.dId.Q(false, false);
                    } else {
                        a.this.dId.Q(true, false);
                    }
                    a.this.dIj = false;
                    a.this.lL(a.this.dIm ? "1" : "2");
                    a.this.onClick(a.this.dHR);
                }

                @Override // com.baidu.tieba.play.c.j
                public void awD() {
                    a.this.onClick(a.this.dHQ);
                }
            });
            this.dId.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void gb(boolean z) {
                    a.this.dId.bL(a.this.dIe.dIF.videoUrl, a.this.dIe.threadId);
                    a.this.lL("2");
                    a.this.onClick(a.this.dHR);
                }
            });
            this.dId.lG(false);
            this.dIg = new aa();
            this.dIg.bCS = fVar.threadId;
            this.dIg.cZI = fVar.forumId;
            this.dIg.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dIh = new aa();
            this.dIh.bCS = fVar.threadId;
            this.dIh.cZI = fVar.forumId;
            this.dIh.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dIn) {
                ak akVar = new ak("c12590");
                akVar.ab("tid", fVar.threadId);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                akVar.s("obj_locate", i);
                akVar.s("obj_param2", 1);
                akVar.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                akVar.ab("obj_param1", fVar.weight);
                akVar.ab("extra", fVar.extra);
                akVar.ab("obj_id", this.aMq);
                akVar.ab("ab_tag", fVar.abtest_tag);
                akVar.ab("obj_type", this.mFrom);
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dIe.source);
                TiebaStatic.log(akVar);
                this.dIg.gvL = this.mFrom;
                this.dIg.mSource = fVar.source;
                this.dIg.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dIg.gvN = this.mFrom;
                this.dIh.gvL = "auto_midpage";
                this.dIh.mLocate = "auto_midpage";
                this.dIh.gvN = this.mFrom;
                this.dIh.mSource = fVar.source;
            }
            if (fVar.dIF != null) {
                this.dIg.gvP = fVar.dIF.videoMd5;
                this.dIh.gvP = fVar.dIF.videoMd5;
            }
            this.caO.setVideoStatsData(this.dIg);
            this.dId.getVideoView().setBusiness(this.caO);
            this.dId.aQy();
            this.dId.b(new c.InterfaceC0219c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void gc(boolean z) {
                    if (!a.this.dId.bkV()) {
                        a.this.nY(0);
                        a.this.dWc.setVisibility(0);
                        a.this.dWb.setVisibility(0);
                        a.this.dWa.setVisibility(0);
                    } else if (z) {
                        if (a.this.dWc.getVisibility() == 8) {
                            a.this.dWc.setVisibility(0);
                            a.this.gv(true);
                        }
                        if (a.this.dWb.getVisibility() == 8) {
                            a.this.dWb.setVisibility(0);
                        }
                        if (a.this.dWa.getVisibility() == 8) {
                            a.this.dWa.setVisibility(0);
                        }
                        a.this.nY(1);
                    } else {
                        if (a.this.dWc.getVisibility() == 0) {
                            a.this.dWc.setVisibility(8);
                            a.this.gv(false);
                        }
                        if (a.this.dWb.getVisibility() == 0) {
                            a.this.dWb.setVisibility(8);
                        }
                        if (a.this.dWa.getVisibility() == 0) {
                            a.this.dWa.setVisibility(8);
                        }
                        a.this.nY(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void awE() {
                    a.this.nY(1);
                    if (!a.this.dId.bkV()) {
                        a.this.dWc.setVisibility(0);
                        a.this.dWb.setVisibility(0);
                        a.this.dWa.setVisibility(0);
                        return;
                    }
                    if (a.this.dWc.getVisibility() == 8) {
                        a.this.dWc.setVisibility(0);
                    }
                    if (a.this.dWb.getVisibility() == 8) {
                        a.this.dWb.setVisibility(0);
                    }
                    if (a.this.dWa.getVisibility() == 8) {
                        a.this.dWa.setVisibility(0);
                    }
                }
            });
            this.dId.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    if (a.this.isFullScreen) {
                        a.this.dIj = true;
                        a.this.dIi = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.nd(i);
                        a.this.dId.aDB();
                    }
                }
            });
            this.dId.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (a.this.dIe != null && a.this.dIe.dIF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dIe.dIF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dId.ov(fVar.dIF.thumbnailUrl);
            this.dId.bK(fVar.dIF.videoUrl, fVar.threadId);
            this.dId.a(new c.g() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.g
                public void awF() {
                }
            });
            this.dId.aDB();
            this.dId.show();
            if (fVar.autoPlay) {
                onClick(this.dHR);
                this.dIj = false;
                this.dId.a(fVar.dIF.videoUrl, fVar.threadId, null, new Object[0]);
                if (i == 0) {
                    this.dVZ.setVisibility(8);
                } else {
                    this.dVZ.startAnimation(this.caB);
                }
                this.dWb.setVisibility(8);
                this.dWc.setVisibility(8);
                gv(false);
                this.dWa.setVisibility(8);
            } else if (j.oL() && fVar.waitConfirm) {
                this.dVZ.startAnimation(this.caB);
                this.dWb.setVisibility(8);
                this.dWc.setVisibility(8);
                gv(false);
                this.dWa.setVisibility(8);
            } else {
                this.dWb.setVisibility(0);
                this.dWc.setVisibility(0);
                this.dWa.setVisibility(0);
                this.dVZ.setVisibility(0);
            }
            this.dIj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY(int i) {
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
    public void lL(String str) {
        if (this.dIe != null && this.dIe.dIF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dIe.dIF.videoMd5, "", str, this.dIh);
            }
        }
    }

    public boolean isPlaying() {
        return this.dId.bkV();
    }

    public void aww() {
        if (isPlaying()) {
            this.dId.pausePlay();
        }
    }

    public boolean nc(int i) {
        return this.dId.tQ(i);
    }

    public void awx() {
        this.dVY = false;
        this.dId.stopPlay();
        if (this.dHS != null) {
            this.dHS.setVisibility(0);
        }
        gv(false);
        this.dVX = true;
    }

    public void awy() {
        if (this.dId != null) {
            this.dId.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awy();
        if (this.dIf != null) {
            this.dIf.awO();
        }
        if (this.dVZ != null) {
            this.dVZ.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null && fVar.dIE != null) {
            this.bdM.setText(TextUtils.isEmpty(fVar.dIE.userNickname) ? fVar.dIE.userName : fVar.dIE.userNickname);
            this.cFY.startLoad(fVar.dIE.portrait, 12, false);
            if (fVar.dIE.isBigV) {
                this.cFY.setShowV(fVar.dIE.isBigV);
                this.cFY.setIsBigV(fVar.dIE.isBigV);
            } else if (fVar.dIE.isGod) {
                this.cFY.setShowV(fVar.dIE.isGod);
                this.cFY.setIsBigV(fVar.dIE.isGod);
            } else {
                this.cFY.setShowV(fVar.dIE.isGod);
                this.cFY.setIsBigV(fVar.dIE.isGod);
            }
            c(fVar);
            d(fVar);
            e(fVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null && fVar.dIE != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(fVar.dIE.userId) && TbadkCoreApplication.getCurrentAccount().equals(fVar.dIE.userId)) {
                this.dVT.setVisibility(8);
            } else {
                this.dVT.setVisibility(0);
            }
            if (fVar.dIE.hasFocus) {
                this.cuu.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_d));
                this.cuu.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                this.dVT.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dVU.setVisibility(8);
                return;
            }
            this.cuu.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            this.cuu.setText(this.mPageContext.getString(d.j.attention));
            this.dVU.setVisibility(0);
            this.dVT.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null) {
            if (fVar.hasAgree) {
                this.bda.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_like_s));
                this.bcZ.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_h_1));
            } else {
                this.bda.setImageDrawable(getContext().getResources().getDrawable(d.f.card_like_selector));
                this.bcZ.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_i));
            }
            if (fVar.agreeNum > 0) {
                this.bcZ.setText(am.J(fVar.agreeNum));
            } else {
                this.bcZ.setText(d.j.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null) {
            this.bdc.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.bdd.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (fVar.postNum > 0) {
                this.bdc.setText(am.J(fVar.postNum));
            } else {
                this.bdc.setText(this.mContext.getString(d.j.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.f fVar) {
        if (this.bdh != null && this.bdf != null && fVar != null) {
            long j = fVar.shareNum;
            String string = this.mContext.getString(d.j.share);
            if (j > 0) {
                string = am.J(j);
            }
            this.bdf.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dId != null && this.dHR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dIi) {
                this.dId.bkU();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aAA();
            } else {
                configuration.orientation = 1;
                aAB();
                this.dIi = true;
            }
            this.dId.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAA() {
        if (this.dId != null && this.dHR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dHR.getParent() != null) {
                if (this.dHR.getParent() == frameLayout) {
                    frameLayout.removeView(this.dHR);
                } else if (this.dHR.getParent() == this.dHQ) {
                    this.dHQ.removeView(this.dHR);
                }
            }
            if (this.dHR.getParent() == null) {
                frameLayout.addView(this.dHR);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dHR.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dHR.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAB() {
        if (this.dId != null && this.dHR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dHR.getParent() != null) {
                if (this.dHR.getParent() == frameLayout) {
                    frameLayout.removeView(this.dHR);
                } else if (this.dHR.getParent() == this.dHQ) {
                    this.dHQ.removeView(this.dHR);
                }
            }
            if (this.dHR.getParent() == null) {
                this.dHQ.addView(this.dHR, 0);
                aAC();
                this.dId.aQy();
            }
        }
    }

    private void aAC() {
        int i;
        if (!aAy()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dHR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (akO() != null) {
            view.setTag(this);
            akO().a(view, this.dIe);
        }
        if (view == this.cFY || view == this.bdM) {
            if (this.dIe != null && this.dIe.dIE != null && !TextUtils.isEmpty(this.dIe.dIE.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dIe.dIE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dIe.dIE.userId, 0L), z, this.dIe.dIE.isGod)));
            }
        } else if (view == this.bde || view == this.dHS || view == this.dVS) {
            if (this.dIe != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dIe.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dVT) {
            if (!this.dIe.dIE.hasFocus) {
                this.dIf.f(this.dIe);
            }
        } else if (view == this.bdb) {
            this.dIf.g(this.dIe);
        } else if (view == this.bdh) {
            Er();
        } else if (view == this.dVZ && this.dVZ.getVisibility() == 0) {
            if (this.dWd != null) {
                this.dWd.nZ(this.mPosition);
            }
        } else if (view == this.dWb || view == this.dWc || view == this.dWa) {
            if (this.dVZ.getVisibility() == 0) {
                if (this.dWd != null) {
                    this.dWd.nZ(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dWc.getVisibility() == 0) {
                this.dWc.setVisibility(8);
                gv(false);
            }
            if (this.dWb.getVisibility() == 0) {
                this.dWb.setVisibility(8);
            }
            if (this.dWa.getVisibility() == 0) {
                this.dWa.setVisibility(8);
            }
            nY(0);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void ga(boolean z) {
        if (this.dIe != null && this.dIe.dIE != null) {
            this.dIe.dIE.hasFocus = z;
            c(this.dIe);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void awz() {
        if (this.dIe != null) {
            this.dIe.hasAgree = !this.dIe.hasAgree;
            if (this.dIe.hasAgree) {
                this.dIe.agreeNum++;
            } else {
                this.dIe.agreeNum--;
            }
            if (this.bda != null) {
                this.bda.startAnimation(getScaleAnimation());
            }
            d(this.dIe);
        }
    }

    private Animation getScaleAnimation() {
        if (this.bdI == null) {
            this.bdI = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdI.setDuration(200L);
        }
        return this.bdI;
    }

    public void gu(boolean z) {
        if (this.dHQ != null) {
            this.dHQ.setVisibility(z ? 0 : 4);
        }
    }

    public void a(InterfaceC0159a interfaceC0159a) {
        this.dWd = interfaceC0159a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gv(boolean z) {
        this.dVX = this.mPosition == (this.dWe == null ? -1 : this.dWe.aAJ());
        if (this.dVX && z && isPlaying() && this.dIm && !this.dVY) {
            this.dVV.setVisibility(0);
            this.dVY = true;
            this.dVV.postDelayed(this.dWh, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dWe != null) {
                this.dWe.bH(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dVV.setVisibility(8);
        if (this.dWh != null) {
            this.dVV.removeCallbacks(this.dWh);
        }
    }

    private void Er() {
        if (this.dIe != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dIe.forumId);
            String str = this.dIe.title;
            String str2 = this.dIe.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dIe.dIF.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dIe.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.blr = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.blu = 3;
            dVar.fid = valueOf;
            dVar.blm = "";
            dVar.tid = str2;
            dVar.blj = true;
            dVar.blt = 0;
            dVar.blv = 2;
            if (parse != null) {
                dVar.blo = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blu);
            bundle.putInt("obj_type", dVar.blv);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQs);
            dVar.i(bundle);
            com.baidu.tieba.d.d.ani().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }
}
