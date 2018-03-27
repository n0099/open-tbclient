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
    private String aMr;
    private ScaleAnimation bdK;
    public TextView bdP;
    private TextView bdb;
    private ImageView bdc;
    private View bdd;
    private TextView bde;
    private ImageView bdf;
    private View bdg;
    private TextView bdh;
    private ImageView bdi;
    private View bdj;
    public HeadImageView cGb;
    private Animation caE;
    private n caR;
    public TextView cux;
    public FrameLayout dHV;
    public FrameLayout dHW;
    public TextView dHX;
    public com.baidu.tieba.play.c dIi;
    public com.baidu.tieba.frs.aggregation.f dIj;
    private h dIk;
    private aa dIl;
    private aa dIm;
    private boolean dIn;
    private boolean dIo;
    private Animation dIq;
    private boolean dIr;
    private boolean dIs;
    private View dVY;
    private View dVZ;
    private ImageView dWa;
    private FrameLayout dWb;
    private TextView dWc;
    private boolean dWd;
    private boolean dWe;
    private View dWf;
    private View dWg;
    private View dWh;
    private View dWi;
    private InterfaceC0159a dWj;
    public com.baidu.tieba.frs.videomiddlepage.a.a dWk;
    private Animation.AnimationListener dWl;
    private Animation.AnimationListener dWm;
    private Runnable dWn;
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
        this.dIn = true;
        this.dIs = true;
        this.dWd = false;
        this.dWe = false;
        this.dWl = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dWf != null) {
                    a.this.dWf.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dWf != null) {
                    a.this.dWf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWm = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dWf != null) {
                    a.this.dWf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dWf != null) {
                    a.this.dWf.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWn = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dWb.getVisibility() == 0) {
                    a.this.dWb.setVisibility(8);
                }
            }
        };
        this.dIs = z;
        this.mFrom = str;
        this.aMr = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dHV = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dVY = view.findViewById(d.g.card_container);
        this.dHW = (FrameLayout) view.findViewById(d.g.video_container);
        this.dIi = new com.baidu.tieba.play.c(tbPageContext, this.dHW, false);
        this.dIi.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dWk != null && a.this.dIj.dIK.videoDuration > 8) {
                    a.this.dWk.J(a.this.mPosition, a.this.dIj.dIK.videoUrl);
                }
            }
        });
        this.dHX = (TextView) view.findViewById(d.g.title);
        this.cGb = (HeadImageView) view.findViewById(d.g.user_icon);
        this.bdP = (TextView) view.findViewById(d.g.user_name);
        this.cux = (TextView) view.findViewById(d.g.attention);
        this.bdb = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.bdc = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.bdd = view.findViewById(d.g.agree_view_container);
        this.bde = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.bdf = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.bdg = view.findViewById(d.g.thread_info_commont_container);
        this.bdh = (TextView) view.findViewById(d.g.share_num);
        this.bdi = (ImageView) view.findViewById(d.g.share_num_img);
        this.bdj = view.findViewById(d.g.share_num_container);
        this.dWb = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.dWc = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.dWb.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dWc.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    aw.Du().a((TbPageContext) i.ak(a.this.akO().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dVZ = view.findViewById(d.g.attention_container);
        this.dWa = (ImageView) view.findViewById(d.g.attention_img);
        this.dWf = view.findViewById(d.g.video_agg_container_foreground);
        this.dWg = view.findViewById(d.g.user_container_foreground);
        this.dWh = view.findViewById(d.g.title_foreground);
        this.dWi = view.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dWg.setOnClickListener(this);
        this.dWh.setOnClickListener(this);
        this.dWi.setOnClickListener(this);
        this.dWf.setOnClickListener(this);
        this.bdd.setOnClickListener(this);
        this.bdg.setOnClickListener(this);
        this.bdj.setOnClickListener(this);
        this.dHX.setOnClickListener(this);
        this.cGb.setOnClickListener(this);
        this.bdP.setOnClickListener(this);
        this.dVZ.setOnClickListener(this);
        this.dVY.setOnClickListener(this);
        this.mWidth = l.ao(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dHV.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dHV.setLayoutParams(layoutParams);
        this.cGb.setIsRound(true);
        this.caR = new n(tbPageContext.getPageActivity());
        this.dIk = new h(this.mPageContext, this);
        this.dIq = new AlphaAnimation(0.0f, 0.7f);
        this.dIq.setDuration(500L);
        this.dIq.setAnimationListener(this.dWm);
        this.caE = new AlphaAnimation(0.7f, 0.0f);
        this.caE.setDuration(500L);
        this.caE.setAnimationListener(this.dWl);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dIj != null && this.dIj.dIJ != null) {
            if (this.dIj.dIJ.hasFocus) {
                this.cux.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_d));
                this.dVZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.cux.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            }
        }
        if (this.dIj != null) {
            if (this.dIj.hasAgree) {
                this.bdc.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.icon_home_card_like_s));
                this.bdb.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
            } else {
                this.bdc.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_like_selector));
                this.bdb.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
            }
        }
        this.bde.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.bdf.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_commnet_selector));
        this.bdh.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
        this.bdi.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_share_selector));
        this.dHX.setTextColor(tbPageContext.getResources().getColor(d.C0141d.cp_cont_i));
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
        if (fVar != null && fVar.dIK != null) {
            this.dIj = fVar;
            this.dIr = this.dIj.autoPlay;
            this.dWe = false;
            gx(false);
            this.dHX.setVisibility(0);
            this.dHX.setText(fVar.title);
            aAB();
            b(fVar, i, aVar);
            h(fVar);
            i(fVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private boolean aAA() {
        try {
            int parseInt = Integer.parseInt(this.dIj.dIK.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dIj.dIK.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aAB() {
        if (!aAA()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dHV.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dHV.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dHV.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dHV.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.f fVar, final int i, final d.a aVar) {
        if (fVar != null && fVar.dIK != null) {
            this.dIi.stopPlay();
            this.dIi.lN(true);
            this.dIi.lQ(true);
            this.dIi.lO(false);
            this.dIi.lR(true);
            this.dIi.Q(false, false);
            this.dIi.tR(i);
            this.dIi.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void awC() {
                    a.this.aAC();
                }

                @Override // com.baidu.tieba.play.c.b
                public void awD() {
                    a.this.aAD();
                    if (a.this.dIi.bkW()) {
                    }
                    if (a.this.dIo) {
                        a.this.dIi.stopPlay();
                    }
                }
            });
            this.dIi.a(new c.j() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.j
                public void awE() {
                    if (a.this.dIj != null && a.this.dIj.dIK != null && com.baidu.adp.lib.g.b.h(a.this.dIj.dIK.videoHeight, 0) > com.baidu.adp.lib.g.b.h(a.this.dIj.dIK.videoWidth, 0)) {
                        a.this.dIi.Q(false, false);
                    } else {
                        a.this.dIi.Q(true, false);
                    }
                    a.this.dIo = false;
                    a.this.lL(a.this.dIr ? "1" : "2");
                    a.this.onClick(a.this.dHW);
                }

                @Override // com.baidu.tieba.play.c.j
                public void awF() {
                    a.this.onClick(a.this.dHV);
                }
            });
            this.dIi.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void gb(boolean z) {
                    a.this.dIi.bL(a.this.dIj.dIK.videoUrl, a.this.dIj.threadId);
                    a.this.lL("2");
                    a.this.onClick(a.this.dHW);
                }
            });
            this.dIi.lL(false);
            this.dIl = new aa();
            this.dIl.bCV = fVar.threadId;
            this.dIl.cZL = fVar.forumId;
            this.dIl.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dIm = new aa();
            this.dIm.bCV = fVar.threadId;
            this.dIm.cZL = fVar.forumId;
            this.dIm.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dIs) {
                ak akVar = new ak("c12590");
                akVar.ab("tid", fVar.threadId);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                akVar.s("obj_locate", i);
                akVar.s("obj_param2", 1);
                akVar.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                akVar.ab("obj_param1", fVar.weight);
                akVar.ab("extra", fVar.extra);
                akVar.ab("obj_id", this.aMr);
                akVar.ab("ab_tag", fVar.abtest_tag);
                akVar.ab("obj_type", this.mFrom);
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dIj.source);
                TiebaStatic.log(akVar);
                this.dIl.gwb = this.mFrom;
                this.dIl.mSource = fVar.source;
                this.dIl.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dIl.gwd = this.mFrom;
                this.dIm.gwb = "auto_midpage";
                this.dIm.mLocate = "auto_midpage";
                this.dIm.gwd = this.mFrom;
                this.dIm.mSource = fVar.source;
            }
            if (fVar.dIK != null) {
                this.dIl.gwf = fVar.dIK.videoMd5;
                this.dIm.gwf = fVar.dIK.videoMd5;
            }
            this.caR.setVideoStatsData(this.dIl);
            this.dIi.getVideoView().setBusiness(this.caR);
            this.dIi.aQz();
            this.dIi.b(new c.InterfaceC0219c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void gc(boolean z) {
                    if (!a.this.dIi.bkW()) {
                        a.this.nY(0);
                        a.this.dWi.setVisibility(0);
                        a.this.dWh.setVisibility(0);
                        a.this.dWg.setVisibility(0);
                    } else if (z) {
                        if (a.this.dWi.getVisibility() == 8) {
                            a.this.dWi.setVisibility(0);
                            a.this.gx(true);
                        }
                        if (a.this.dWh.getVisibility() == 8) {
                            a.this.dWh.setVisibility(0);
                        }
                        if (a.this.dWg.getVisibility() == 8) {
                            a.this.dWg.setVisibility(0);
                        }
                        a.this.nY(1);
                    } else {
                        if (a.this.dWi.getVisibility() == 0) {
                            a.this.dWi.setVisibility(8);
                            a.this.gx(false);
                        }
                        if (a.this.dWh.getVisibility() == 0) {
                            a.this.dWh.setVisibility(8);
                        }
                        if (a.this.dWg.getVisibility() == 0) {
                            a.this.dWg.setVisibility(8);
                        }
                        a.this.nY(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void awG() {
                    a.this.nY(1);
                    if (!a.this.dIi.bkW()) {
                        a.this.dWi.setVisibility(0);
                        a.this.dWh.setVisibility(0);
                        a.this.dWg.setVisibility(0);
                        return;
                    }
                    if (a.this.dWi.getVisibility() == 8) {
                        a.this.dWi.setVisibility(0);
                    }
                    if (a.this.dWh.getVisibility() == 8) {
                        a.this.dWh.setVisibility(0);
                    }
                    if (a.this.dWg.getVisibility() == 8) {
                        a.this.dWg.setVisibility(0);
                    }
                }
            });
            this.dIi.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    if (a.this.isFullScreen) {
                        a.this.dIo = true;
                        a.this.dIn = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.nd(i);
                        a.this.dIi.aDC();
                    }
                }
            });
            this.dIi.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (a.this.dIj != null && a.this.dIj.dIK != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dIj.dIK.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dIi.ov(fVar.dIK.thumbnailUrl);
            this.dIi.bK(fVar.dIK.videoUrl, fVar.threadId);
            this.dIi.a(new c.g() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.g
                public void awH() {
                }
            });
            this.dIi.aDC();
            this.dIi.show();
            if (fVar.autoPlay) {
                onClick(this.dHW);
                this.dIo = false;
                this.dIi.a(fVar.dIK.videoUrl, fVar.threadId, null, new Object[0]);
                if (i == 0) {
                    this.dWf.setVisibility(8);
                } else {
                    this.dWf.startAnimation(this.caE);
                }
                this.dWh.setVisibility(8);
                this.dWi.setVisibility(8);
                gx(false);
                this.dWg.setVisibility(8);
            } else if (j.oL() && fVar.waitConfirm) {
                this.dWf.startAnimation(this.caE);
                this.dWh.setVisibility(8);
                this.dWi.setVisibility(8);
                gx(false);
                this.dWg.setVisibility(8);
            } else {
                this.dWh.setVisibility(0);
                this.dWi.setVisibility(0);
                this.dWg.setVisibility(0);
                this.dWf.setVisibility(0);
            }
            this.dIo = false;
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
        if (this.dIj != null && this.dIj.dIK != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dIj.dIK.videoMd5, "", str, this.dIm);
            }
        }
    }

    public boolean isPlaying() {
        return this.dIi.bkW();
    }

    public void awy() {
        if (isPlaying()) {
            this.dIi.pausePlay();
        }
    }

    public boolean nc(int i) {
        return this.dIi.tQ(i);
    }

    public void awz() {
        this.dWe = false;
        this.dIi.stopPlay();
        if (this.dHX != null) {
            this.dHX.setVisibility(0);
        }
        gx(false);
        this.dWd = true;
    }

    public void awA() {
        if (this.dIi != null) {
            this.dIi.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awA();
        if (this.dIk != null) {
            this.dIk.awQ();
        }
        if (this.dWf != null) {
            this.dWf.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null && fVar.dIJ != null) {
            this.bdP.setText(TextUtils.isEmpty(fVar.dIJ.userNickname) ? fVar.dIJ.userName : fVar.dIJ.userNickname);
            this.cGb.startLoad(fVar.dIJ.portrait, 12, false);
            if (fVar.dIJ.isBigV) {
                this.cGb.setShowV(fVar.dIJ.isBigV);
                this.cGb.setIsBigV(fVar.dIJ.isBigV);
            } else if (fVar.dIJ.isGod) {
                this.cGb.setShowV(fVar.dIJ.isGod);
                this.cGb.setIsBigV(fVar.dIJ.isGod);
            } else {
                this.cGb.setShowV(fVar.dIJ.isGod);
                this.cGb.setIsBigV(fVar.dIJ.isGod);
            }
            c(fVar);
            d(fVar);
            e(fVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null && fVar.dIJ != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(fVar.dIJ.userId) && TbadkCoreApplication.getCurrentAccount().equals(fVar.dIJ.userId)) {
                this.dVZ.setVisibility(8);
            } else {
                this.dVZ.setVisibility(0);
            }
            if (fVar.dIJ.hasFocus) {
                this.cux.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_d));
                this.cux.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                this.dVZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dWa.setVisibility(8);
                return;
            }
            this.cux.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            this.cux.setText(this.mPageContext.getString(d.j.attention));
            this.dWa.setVisibility(0);
            this.dVZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null) {
            if (fVar.hasAgree) {
                this.bdc.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_like_s));
                this.bdb.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_h_1));
            } else {
                this.bdc.setImageDrawable(getContext().getResources().getDrawable(d.f.card_like_selector));
                this.bdb.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_i));
            }
            if (fVar.agreeNum > 0) {
                this.bdb.setText(am.J(fVar.agreeNum));
            } else {
                this.bdb.setText(d.j.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null) {
            this.bde.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.bdf.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (fVar.postNum > 0) {
                this.bde.setText(am.J(fVar.postNum));
            } else {
                this.bde.setText(this.mContext.getString(d.j.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.f fVar) {
        if (this.bdj != null && this.bdh != null && fVar != null) {
            long j = fVar.shareNum;
            String string = this.mContext.getString(d.j.share);
            if (j > 0) {
                string = am.J(j);
            }
            this.bdh.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dIi != null && this.dHW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dIn) {
                this.dIi.bkV();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aAC();
            } else {
                configuration.orientation = 1;
                aAD();
                this.dIn = true;
            }
            this.dIi.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAC() {
        if (this.dIi != null && this.dHW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dHW.getParent() != null) {
                if (this.dHW.getParent() == frameLayout) {
                    frameLayout.removeView(this.dHW);
                } else if (this.dHW.getParent() == this.dHV) {
                    this.dHV.removeView(this.dHW);
                }
            }
            if (this.dHW.getParent() == null) {
                frameLayout.addView(this.dHW);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dHW.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dHW.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAD() {
        if (this.dIi != null && this.dHW != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dHW.getParent() != null) {
                if (this.dHW.getParent() == frameLayout) {
                    frameLayout.removeView(this.dHW);
                } else if (this.dHW.getParent() == this.dHV) {
                    this.dHV.removeView(this.dHW);
                }
            }
            if (this.dHW.getParent() == null) {
                this.dHV.addView(this.dHW, 0);
                aAE();
                this.dIi.aQz();
            }
        }
    }

    private void aAE() {
        int i;
        if (!aAA()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dHW.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (akP() != null) {
            view.setTag(this);
            akP().a(view, this.dIj);
        }
        if (view == this.cGb || view == this.bdP) {
            if (this.dIj != null && this.dIj.dIJ != null && !TextUtils.isEmpty(this.dIj.dIJ.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dIj.dIJ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dIj.dIJ.userId, 0L), z, this.dIj.dIJ.isGod)));
            }
        } else if (view == this.bdg || view == this.dHX || view == this.dVY) {
            if (this.dIj != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dIj.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dVZ) {
            if (!this.dIj.dIJ.hasFocus) {
                this.dIk.f(this.dIj);
            }
        } else if (view == this.bdd) {
            this.dIk.g(this.dIj);
        } else if (view == this.bdj) {
            Es();
        } else if (view == this.dWf && this.dWf.getVisibility() == 0) {
            if (this.dWj != null) {
                this.dWj.nZ(this.mPosition);
            }
        } else if (view == this.dWh || view == this.dWi || view == this.dWg) {
            if (this.dWf.getVisibility() == 0) {
                if (this.dWj != null) {
                    this.dWj.nZ(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dWi.getVisibility() == 0) {
                this.dWi.setVisibility(8);
                gx(false);
            }
            if (this.dWh.getVisibility() == 0) {
                this.dWh.setVisibility(8);
            }
            if (this.dWg.getVisibility() == 0) {
                this.dWg.setVisibility(8);
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
        if (this.dIj != null && this.dIj.dIJ != null) {
            this.dIj.dIJ.hasFocus = z;
            c(this.dIj);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void awB() {
        if (this.dIj != null) {
            this.dIj.hasAgree = !this.dIj.hasAgree;
            if (this.dIj.hasAgree) {
                this.dIj.agreeNum++;
            } else {
                this.dIj.agreeNum--;
            }
            if (this.bdc != null) {
                this.bdc.startAnimation(getScaleAnimation());
            }
            d(this.dIj);
        }
    }

    private Animation getScaleAnimation() {
        if (this.bdK == null) {
            this.bdK = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdK.setDuration(200L);
        }
        return this.bdK;
    }

    public void gw(boolean z) {
        if (this.dHV != null) {
            this.dHV.setVisibility(z ? 0 : 4);
        }
    }

    public void a(InterfaceC0159a interfaceC0159a) {
        this.dWj = interfaceC0159a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        this.dWd = this.mPosition == (this.dWk == null ? -1 : this.dWk.aAL());
        if (this.dWd && z && isPlaying() && this.dIr && !this.dWe) {
            this.dWb.setVisibility(0);
            this.dWe = true;
            this.dWb.postDelayed(this.dWn, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dWk != null) {
                this.dWk.bH(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dWb.setVisibility(8);
        if (this.dWn != null) {
            this.dWb.removeCallbacks(this.dWn);
        }
    }

    private void Es() {
        if (this.dIj != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dIj.forumId);
            String str = this.dIj.title;
            String str2 = this.dIj.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dIj.dIK.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dIj.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.blu = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.blx = 3;
            dVar.fid = valueOf;
            dVar.blp = "";
            dVar.tid = str2;
            dVar.blm = true;
            dVar.blw = 0;
            dVar.bly = 2;
            if (parse != null) {
                dVar.blr = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blx);
            bundle.putInt("obj_type", dVar.bly);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQu);
            dVar.i(bundle);
            com.baidu.tieba.d.d.anj().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }
}
