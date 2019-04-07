package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.afd.videopaster.d;
import com.baidu.mobstat.Config;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.frs.view.SpannableClickTextView;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.g, i {
    private com.baidu.tieba.lego.card.view.f TB;
    public TextView Zy;
    private Animation afd;
    private Animation afe;
    private boolean bGe;
    protected AgreeView bSf;
    private TextView bSg;
    private ImageView bSh;
    private View bSi;
    private ImageView bSk;
    private View bSl;
    private String byD;
    public HeadImageView dQJ;
    private n dbh;
    private com.baidu.afd.videopaster.d ehu;
    public FrameLayout fdQ;
    public FrameLayout fdR;
    public com.baidu.tieba.play.c fee;
    public com.baidu.tieba.frs.aggregation.g fef;
    private com.baidu.tieba.frs.aggregation.h feg;
    private z feh;
    private z fei;
    private boolean fej;
    private boolean fek;
    private boolean fen;
    public SpannableClickTextView fwD;
    private View fwE;
    private FrameLayout fwF;
    private TextView fwG;
    private boolean fwH;
    private boolean fwI;
    private boolean fwJ;
    private View fwK;
    private View fwL;
    private c fwM;
    public com.baidu.tieba.frs.videomiddlepage.a.a fwN;
    private C0298a fwO;
    private VideoNetworkStateTipView fwP;
    private b fwQ;
    private com.baidu.mcn.c fwR;
    private boolean fwS;
    private boolean fwT;
    private boolean fwU;
    private Animation.AnimationListener fwV;
    private Animation.AnimationListener fwW;
    private Runnable fwX;
    private Runnable fwY;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.fej = true;
        this.fen = true;
        this.fwI = false;
        this.fwJ = false;
        this.fwS = false;
        this.fwT = false;
        this.fwU = false;
        this.startPosition = -1L;
        this.fwV = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fwK != null) {
                    a.this.fwK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fwK != null) {
                    a.this.fwK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fwW = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.fwK != null) {
                    a.this.fwK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fwK != null) {
                    a.this.fwK.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.fwX = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fwF.getVisibility() == 0) {
                    a.this.fwF.setVisibility(8);
                }
            }
        };
        this.fwY = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fee != null) {
                    a.this.fee.stopPlay();
                }
            }
        };
        this.fen = z;
        this.mFrom = str;
        this.byD = str2;
        this.fwQ = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fdQ = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.fwE = view.findViewById(d.g.card_container);
        this.fdR = (FrameLayout) view.findViewById(d.g.video_container);
        this.fee = new com.baidu.tieba.play.c(tbPageContext, (View) this.fdR, false);
        this.fee.oQ(z);
        this.fee.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.fwN != null && a.this.fef.feF.videoDuration > 8) {
                    a.this.fwN.ai(a.this.mPosition, a.this.fef.feF.videoUrl);
                }
            }
        });
        this.fee.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // com.baidu.tieba.play.c.a
            public void jV(boolean z2) {
                if (a.this.fwO != null) {
                    if (z2) {
                        a.this.fwO.rC(0);
                    } else {
                        a.this.fwO.rC(1);
                    }
                }
            }
        });
        this.fee.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.fwD = (SpannableClickTextView) view.findViewById(d.g.title);
        this.dQJ = (HeadImageView) view.findViewById(d.g.user_icon);
        this.Zy = (TextView) view.findViewById(d.g.user_name);
        this.bSf = (AgreeView) view.findViewById(d.g.agree_view);
        this.bSf.setAgreeAnimationResource(d.i.agree);
        this.bSf.setDisagreeAnimationResource(d.i.disagree);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxn = 2;
        dVar.bxr = 6;
        this.bSf.setStatisticData(dVar);
        this.bSg = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.bSh = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.bSi = view.findViewById(d.g.thread_info_commont_container);
        this.bSk = (ImageView) view.findViewById(d.g.share_num_img);
        this.bSl = view.findViewById(d.g.share_num_container);
        this.fwF = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.fwG = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.fwF.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.fwG.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.fwG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.adA().a((TbPageContext) com.baidu.adp.base.i.aK(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.fwP = (VideoNetworkStateTipView) view.findViewById(d.g.network_state_tip);
        this.fwP.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c13257"));
                a.this.fwP.setHasAgreeToPlay(true);
                a.this.fee.oW(false);
                a.this.fwP.cmo();
                if (a.this.ehu.qb()) {
                    a.this.ehu.resume();
                } else if (a.this.fef != null && a.this.fef.feF != null) {
                    a.this.fee.cf(a.this.fef.feF.videoUrl, a.this.fef.threadId);
                }
            }
        });
        this.fwK = view.findViewById(d.g.video_agg_container_foreground);
        this.fwL = view.findViewById(d.g.title_and_comment_container_foreground);
        this.fwK.setOnClickListener(this);
        this.bSi.setOnClickListener(this);
        this.bSl.setOnClickListener(this);
        this.fwD.setOnClickListener(this);
        this.dQJ.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.fwE.setOnClickListener(this);
        this.mWidth = l.aO(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fdQ.setLayoutParams(layoutParams);
        this.dQJ.setIsRound(true);
        this.dbh = new n(tbPageContext.getPageActivity());
        this.feg = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.afd = new AlphaAnimation(0.0f, 0.7f);
        this.afd.setDuration(500L);
        this.afd.setAnimationListener(this.fwW);
        this.afe = new AlphaAnimation(0.7f, 0.0f);
        this.afe.setDuration(500L);
        this.afe.setAnimationListener(this.fwV);
        this.fwO = new C0298a();
        this.ehu = new com.baidu.afd.videopaster.d(getContext(), this.fdR);
        this.fwR = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.bSf.onChangeSkinType(i);
        this.bSg.setTextColor(tbPageContext.getResources().getColor(d.C0277d.cp_cont_d));
        this.bSh.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.video_comment_background));
        this.bSk.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.video_share_background));
        this.fwD.setTextColor(tbPageContext.getResources().getColor(d.C0277d.cp_btn_a));
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
        if (gVar != null && gVar.feF != null) {
            boolean z = this.fef == gVar;
            this.fef = gVar;
            this.bGe = this.fef.autoPlay;
            this.fwJ = false;
            jT(false);
            this.fwD.setVisibility(0);
            if (gVar.feF != null && !StringUtils.isNull(gVar.feF.mcnLeadPage)) {
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.fwD, gVar.title, gVar.feF.mcnLeadPage, gVar.getThreadId());
            } else {
                this.fwD.setText(gVar.title);
            }
            bjC();
            a(gVar, i, aVar, z);
            i(gVar);
            if (gVar.aaE() != null) {
                gVar.aaE().isInThread = true;
            }
            this.bSf.setIsFromMiddlePage(true);
            this.bSf.setData(gVar.aaE());
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        a(gVar, i, aVar, false);
    }

    private boolean bjB() {
        try {
            int parseInt = Integer.parseInt(this.fef.feF.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.fef.feF.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void bjC() {
        if (!bjB()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdQ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.fdQ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fdQ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.fdQ.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.feF != null) {
            this.fee.stopPlay();
            this.fee.setIsNeedRecoveryVideoPlayer(true);
            this.fee.oX(true);
            this.fee.oT(true);
            this.fee.oY(true);
            this.fee.ac(false, false);
            this.fee.xi(i);
            this.fee.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                    a.this.bjG();
                    if (a.this.ehu != null) {
                        a.this.ehu.qj();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                    a.this.bjH();
                    if (a.this.fee.ql()) {
                    }
                    if (a.this.fek || (a.this.ehu != null && a.this.ehu.qb())) {
                        com.baidu.adp.lib.g.e.jH().removeCallbacks(a.this.fwY);
                        com.baidu.adp.lib.g.e.jH().post(a.this.fwY);
                    }
                    if (a.this.ehu != null) {
                        a.this.ehu.qk();
                    }
                }
            });
            this.fee.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                @Override // com.baidu.tieba.play.c.l
                public void beN() {
                    if (a.this.fef != null && a.this.fef.feF != null && com.baidu.adp.lib.g.b.l(a.this.fef.feF.videoHeight, 0) > com.baidu.adp.lib.g.b.l(a.this.fef.feF.videoWidth, 0)) {
                        a.this.fee.ac(false, false);
                    } else {
                        a.this.fee.ac(true, false);
                    }
                    a.this.fek = false;
                    a.this.vb(a.this.bGe ? "1" : "2");
                    a.this.onClick(a.this.fdR);
                    if (a.this.TB != null) {
                        a.this.TB.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void beO() {
                    a.this.onClick(a.this.fdQ);
                }
            });
            this.fee.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.f
                public void jx(boolean z2) {
                    a.this.fee.cf(a.this.fef.feF.videoUrl, a.this.fef.threadId);
                    a.this.vb("2");
                    a.this.onClick(a.this.fdR);
                }
            });
            this.fee.oP(false);
            if (this.fwR != null) {
                this.fwR.reset();
            }
            this.startPosition = -1L;
            this.dbh.a(new j.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i2, int i3) {
                    boolean z2 = true;
                    if (a.this.startPosition <= 0) {
                        a.this.startPosition = i3;
                    }
                    g.a aVar2 = a.this.fef.feF.feP;
                    if (aVar2 == null) {
                        if (i3 >= i2) {
                            if (a.this.ehu.a(a.this.isFullScreen, a.this.fee != null && a.this.fee.bSC(), "VIDEO_LIST")) {
                            }
                        } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                            a.this.ehu.a(a.this.h(gVar));
                        }
                    }
                    if (aVar2 != null && !a.this.isFullScreen && !a.this.fee.bSC() && !com.baidu.mcn.b.sX().cT(aVar2.TW)) {
                        boolean z3 = a.this.startPosition >= (aVar2.feI * 1000) + 1000;
                        if (i3 < aVar2.feI * 1000 || i3 >= aVar2.feJ * 1000) {
                            z2 = false;
                        }
                        if (z2) {
                            if (!a.this.fwR.isShowing()) {
                                com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                aVar3.aeP = aVar2.feL;
                                aVar3.aeQ = aVar2.feM;
                                aVar3.aeR = aVar2.TW;
                                aVar3.aeO = aVar2.feK;
                                aVar3.fid = a.this.fef != null ? a.this.fef.forumId : null;
                                aVar3.tid = a.this.fef != null ? a.this.fef.threadId : null;
                                aVar3.aeS = 3;
                                if (z3) {
                                    a.this.fwR.b(aVar3, (ViewGroup) a.this.fee.bSV());
                                } else {
                                    a.this.fwR.a(aVar3, (ViewGroup) a.this.fee.bSV());
                                }
                            }
                        } else if (a.this.fwR.isShowing()) {
                            a.this.fwR.dismiss();
                        }
                    }
                }
            });
            this.feh = new z();
            this.feh.ctw = gVar.threadId;
            this.feh.ekM = gVar.forumId;
            this.feh.mUid = TbadkCoreApplication.getCurrentAccount();
            this.feh.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.feh.mSource = gVar.source;
            this.feh.hYx = gVar.weight;
            this.feh.hYz = this.mFrom;
            this.feh.hYA = gVar.abtest_tag;
            this.feh.byD = this.byD;
            this.feh.ekI = gVar.extra;
            this.feh.hYD = "0";
            this.fei = new z();
            this.fei.ctw = gVar.threadId;
            this.fei.ekM = gVar.forumId;
            this.fei.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fei.hYx = "auto_midpage";
            this.fei.mLocate = "auto_midpage";
            this.fei.hYz = this.mFrom;
            this.fei.mSource = gVar.source;
            this.fei.hYD = "0";
            if (gVar.feF != null) {
                this.feh.hYB = gVar.feF.videoMd5;
                this.fei.hYB = gVar.feF.videoMd5;
            }
            am amVar = new am("c12590");
            amVar.bJ("tid", gVar.threadId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.T("obj_locate", i);
            amVar.T("obj_param2", 1);
            amVar.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
            amVar.bJ("obj_param1", ap.isEmpty(gVar.weight) ? "0" : gVar.weight);
            amVar.bJ("extra", ap.isEmpty(gVar.extra) ? "0" : gVar.extra);
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byD);
            amVar.bJ("ab_tag", ap.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            amVar.bJ("obj_type", this.mFrom);
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.fef.source) ? "0" : this.fef.source);
            amVar.T("is_vertical", 0);
            TiebaStatic.log(amVar);
            this.dbh.setVideoStatsData(this.feh);
            this.fee.getVideoView().setBusiness(this.dbh);
            this.dbh.a(gVar);
            this.fee.bAD();
            this.fee.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (!a.this.ehu.a(a.this.isFullScreen, a.this.fee != null && a.this.fee.bSC(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.fek = true;
                            a.this.fwH = true;
                            a.this.fej = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.qr(i);
                            a.this.fee.bnN();
                        }
                    }
                }
            });
            this.fee.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (a.this.fef != null && a.this.fef.feF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.fef.feF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.ehu.reset();
            }
            this.ehu.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.afd.videopaster.d.a
                public void qs() {
                    a.this.fwH = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void qr() {
                    if (a.this.isFullScreen) {
                        a.this.fek = true;
                        a.this.fwH = true;
                        a.this.fej = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.qr(i);
                        a.this.fee.bnN();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void qq() {
                    if (a.this.fee != null) {
                        a.this.fee.xh(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean qt() {
                    return a.this.bjF();
                }
            });
            this.fee.setThumbnail(gVar.feF.thumbnailUrl);
            this.fee.setVideoUrl(gVar.feF.videoUrl, gVar.threadId);
            this.fee.setFid(gVar.forumId);
            this.fee.bnN();
            this.fee.show();
            jT(false);
            if (gVar.autoPlay) {
                onClick(this.fdR);
                if (this.fwP.bUk()) {
                    this.fee.oV(false);
                    this.fwP.cmn();
                    this.fee.oW(true);
                    this.fee.dD(gVar.feF.videoUrl, gVar.threadId);
                    if (this.ehu.qb()) {
                        this.ehu.stop();
                        this.ehu.qg();
                    }
                } else {
                    this.fee.oW(false);
                    this.fee.oV(false);
                    this.fwP.hide();
                    if (this.ehu == null || (this.ehu != null && !this.ehu.qb())) {
                        this.fee.a(gVar.feF.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.feG) {
                    this.fwK.setVisibility(8);
                    this.fwO.rC(3);
                } else {
                    if (this.fwK.getVisibility() == 0) {
                        this.fwK.startAnimation(this.afe);
                    }
                    this.fwO.rC(0);
                }
                gVar.feG = false;
            } else {
                this.fwK.setVisibility(0);
                this.fwP.hide();
                this.fee.oV(true);
                this.fwO.rC(3);
                this.fee.dD(gVar.feF.videoUrl, gVar.threadId);
            }
            this.fek = false;
            this.fwH = false;
            if (!z && this.ehu.qb()) {
                stopPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a h(com.baidu.tieba.frs.aggregation.g gVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (gVar == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b vO = this.fwQ != null ? this.fwQ.vO(gVar.getThreadId()) : null;
        if (vO == null) {
            return null;
        }
        int qx = vO.qx();
        int qy = vO.qy();
        int qw = vO.qw();
        if (qw != -1) {
            i = qx != -1 ? (qw - qx) - 1 : -1;
            if (qy != -1) {
                i4 = (qy - qw) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.feF != null) {
            i3 = com.baidu.adp.lib.g.b.l(gVar.feF.videoWidth, 0);
            i2 = com.baidu.adp.lib.g.b.l(gVar.feF.videoHeight, 0);
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", gVar.threadId);
        hashMap.put("video_title", gVar.title);
        hashMap.put("forum_id", gVar.forumId);
        hashMap.put("forum_name", "");
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", qw + 1, i3, i2);
        a.l(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(String str) {
        if (this.fef != null && this.fef.feF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fef.feF.videoMd5, "", str, this.fei);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public boolean isPlaying() {
        return this.fee.ql();
    }

    public boolean bjD() {
        return this.ehu.qb();
    }

    public void beJ() {
        if (isPlaying()) {
            this.fee.pausePlay();
        }
    }

    public boolean qs(int i) {
        if (i == 4 && this.ehu != null && ((this.ehu.qb() || this.fwH) && this.fee != null)) {
            this.ehu.bj(i);
            if (this.isFullScreen) {
                if (this.ehu.qa()) {
                    this.fee.bSD();
                } else {
                    this.fee.bAy();
                }
                return true;
            }
        }
        return this.fee.xh(i);
    }

    public void beK() {
        this.fwJ = false;
        this.fee.stopPlay();
        if (this.fwD != null) {
            this.fwD.setVisibility(0);
        }
        if (this.fwO != null) {
            this.fwO.rC(2);
        }
        jT(false);
        this.fwI = true;
        if (this.ehu != null && this.ehu.qb()) {
            this.ehu.stop();
        }
    }

    public void bjE() {
        this.ehu.stop();
    }

    public void beL() {
        if (this.fee != null) {
            this.fee.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        beL();
        if (this.feg != null) {
            this.feg.beW();
        }
        if (this.fwK != null) {
            this.fwK.clearAnimation();
        }
        this.ehu.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.feE != null) {
            this.Zy.setText(TextUtils.isEmpty(gVar.feE.userNickname) ? gVar.feE.userName : gVar.feE.userNickname);
            if (!StringUtils.isNull(gVar.feE.portrait) && gVar.feE.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.dQJ.startLoad(gVar.feE.portrait, 10, false);
            } else {
                this.dQJ.startLoad(gVar.feE.portrait, 12, false);
            }
            if (gVar.feE.isBigV) {
                this.dQJ.setShowV(gVar.feE.isBigV);
                this.dQJ.setIsBigV(gVar.feE.isBigV);
            } else if (gVar.feE.isGod) {
                this.dQJ.setShowV(gVar.feE.isGod);
                this.dQJ.setIsBigV(gVar.feE.isGod);
            } else {
                this.dQJ.setShowV(gVar.feE.isGod);
                this.dQJ.setIsBigV(gVar.feE.isGod);
            }
            d(gVar);
            e(gVar);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.bSf.setData(gVar.aaE());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.bSg.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_d));
            this.bSh.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (gVar.postNum > 0) {
                this.bSg.setText(ap.az(gVar.postNum));
            } else {
                this.bSg.setText(this.mContext.getString(d.j.reply));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fee != null && this.fdR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fej) {
                this.fee.bSJ();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                bjG();
            } else {
                configuration.orientation = 1;
                bjH();
                this.fej = true;
            }
            this.fee.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjF() {
        if (this.fee != null && this.fdR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fdR.getParent() != null) {
                if (this.fdR.getParent() == frameLayout) {
                    if (this.fwS) {
                        this.fwS = false;
                        return true;
                    } else if (!this.fwT) {
                        this.fwT = true;
                        return true;
                    }
                } else if (this.fdR.getParent() == this.fdQ) {
                    if (this.fwT) {
                        this.fwT = false;
                        this.fwU = true;
                        return true;
                    } else if (!this.fwS && this.fwU) {
                        this.fwS = true;
                        this.fwU = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjG() {
        if (this.fee != null && this.fdR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.fdR.getParent() != null) {
                if (this.fdR.getParent() == frameLayout) {
                    frameLayout.removeView(this.fdR);
                } else if (this.fdR.getParent() == this.fdQ) {
                    this.fdQ.removeView(this.fdR);
                }
            }
            if (this.fdR.getParent() == null) {
                frameLayout.addView(this.fdR);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdR.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fdR.setLayoutParams(layoutParams);
                if (this.fwR != null && this.fwR.isShowing()) {
                    this.fwR.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjH() {
        if (this.fee != null && this.fdR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.fdR.getParent() != null) {
                if (this.fdR.getParent() == frameLayout) {
                    bjI();
                    frameLayout.removeView(this.fdR);
                } else if (this.fdR.getParent() == this.fdQ) {
                    bjI();
                    this.fdQ.removeView(this.fdR);
                }
            }
            if (this.fdR.getParent() == null) {
                this.fdQ.addView(this.fdR, 0);
                bjJ();
                this.fee.bAD();
                this.startPosition = -1L;
            }
        }
    }

    private void bjI() {
        if (this.ehu != null && this.ehu.qb()) {
            this.ehu.aC(true);
        }
    }

    private void bjJ() {
        int i;
        if (!bjB()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.fdR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (aQf() != null) {
            view.setTag(this);
            aQf().a(view, this.fef);
        }
        if (view == this.dQJ || view == this.Zy) {
            if (this.fef != null && this.fef.feE != null && !TextUtils.isEmpty(this.fef.feE.userId)) {
                this.fwO.rC(0);
                if (!TbadkCoreApplication.isLogin() || !this.fef.feE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.fef.feE.userId, 0L), z, this.fef.feE.isGod)));
            }
        } else if (view == this.bSi) {
            if (this.fef != null) {
                this.fwO.rC(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fef.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.fwD || view == this.fwE) {
            if (this.fef != null) {
                if (this.fwO.getCurrentState() != 2 && this.fwO.getCurrentState() != 3) {
                    z = false;
                }
                this.fwO.rC(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.fef.threadId, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                }
            }
        } else if (view == this.bSl) {
            this.fwO.rC(0);
            aeU();
        } else if (view == this.fwK && this.fwK.getVisibility() == 0 && this.fwM != null) {
            this.fwM.rG(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void jw(boolean z) {
        if (this.fef != null && this.fef.feE != null) {
            this.fef.feE.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void beM() {
        if (this.fef != null) {
            this.bSf.aeb();
        }
    }

    public void jS(boolean z) {
        if (this.fdQ != null) {
            this.fdQ.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.fwM = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.TB = fVar;
    }

    private void jT(boolean z) {
        this.fwI = this.mPosition == (this.fwN == null ? -1 : this.fwN.bjU());
        if (this.fwI && z && isPlaying() && this.bGe && !this.fwJ) {
            this.fwF.setVisibility(0);
            this.fwJ = true;
            this.fwF.postDelayed(this.fwX, 5000L);
            if (this.fwN != null) {
                this.fwN.cH(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.fwF.setVisibility(8);
        if (this.fwX != null) {
            this.fwF.removeCallbacks(this.fwX);
        }
    }

    private void aeU() {
        if (this.fef != null && this.mContext != null) {
            String valueOf = String.valueOf(this.fef.forumId);
            String str = this.fef.title;
            String str2 = this.fef.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.fef.feF.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.fef.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.cbA = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.cbD = 3;
            dVar.fid = valueOf;
            dVar.cbu = "";
            dVar.tid = str2;
            dVar.cbo = true;
            dVar.cbC = 0;
            dVar.cbH = 2;
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
            bundle.putInt("obj_param1", dVar.cbD);
            bundle.putInt("obj_type", dVar.cbH);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDY);
            dVar.D(bundle);
            com.baidu.tieba.c.e.aSr().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void stopPlay() {
        beK();
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void pausePlay() {
        beJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jU(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void bjK() {
        this.ehu.resume();
    }

    public boolean bjL() {
        if (this.fwO != null) {
            return this.fwO.getCurrentState() == 2 || this.fwO.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0298a {
        private Runnable fxc;
        private int mCurrentState;

        private C0298a() {
            this.mCurrentState = -1;
            this.fxc = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(C0298a.this.fxc);
                    C0298a.this.rC(2);
                }
            };
        }

        public void rC(int i) {
            switch (i) {
                case 0:
                    this.mCurrentState = rD(i);
                    bjM();
                    return;
                case 1:
                    this.mCurrentState = rD(i);
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fxc);
                    return;
                case 2:
                    this.mCurrentState = rE(i);
                    return;
                case 3:
                    this.mCurrentState = rF(i);
                    bjM();
                    return;
                default:
                    this.mCurrentState = rE(i);
                    return;
            }
        }

        private void bjM() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fxc);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fxc, 3000L);
        }

        public int getCurrentState() {
            return this.mCurrentState;
        }

        private int rD(int i) {
            if (i != this.mCurrentState) {
                a.this.fwL.setVisibility(8);
                a.this.jU(true);
                return i;
            }
            return this.mCurrentState;
        }

        private int rE(int i) {
            int i2 = this.mCurrentState;
            if (i != this.mCurrentState) {
                a.this.fwL.setVisibility(0);
                if (i2 != 3 || a.this.fef.autoPlay) {
                    a.this.jU(false);
                    return i;
                }
                return i;
            }
            return this.mCurrentState;
        }

        private int rF(int i) {
            if (i != this.mCurrentState) {
                a.this.fwL.setVisibility(0);
                a.this.jU(true);
                return i;
            }
            return this.mCurrentState;
        }
    }
}
