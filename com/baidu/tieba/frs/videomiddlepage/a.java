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
    private String aMB;
    private ScaleAnimation bdU;
    public TextView bdY;
    private TextView bdl;
    private ImageView bdm;
    private View bdn;
    private TextView bdo;
    private ImageView bdp;
    private View bdq;
    private TextView bdr;
    private ImageView bds;
    private View bdt;
    public HeadImageView cGk;
    private Animation caN;
    private n cba;
    public TextView cuG;
    public FrameLayout dIc;
    public FrameLayout dId;
    public TextView dIe;
    public com.baidu.tieba.play.c dIp;
    public com.baidu.tieba.frs.aggregation.f dIq;
    private h dIr;
    private aa dIs;
    private aa dIt;
    private boolean dIu;
    private boolean dIv;
    private Animation dIx;
    private boolean dIy;
    private boolean dIz;
    private View dWe;
    private View dWf;
    private ImageView dWg;
    private FrameLayout dWh;
    private TextView dWi;
    private boolean dWj;
    private boolean dWk;
    private View dWl;
    private View dWm;
    private View dWn;
    private View dWo;
    private InterfaceC0158a dWp;
    public com.baidu.tieba.frs.videomiddlepage.a.a dWq;
    private Animation.AnimationListener dWr;
    private Animation.AnimationListener dWs;
    private Runnable dWt;
    private boolean isFullScreen;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0158a {
        void nZ(int i);
    }

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2) {
        super(tbPageContext);
        this.dIu = true;
        this.dIz = true;
        this.dWj = false;
        this.dWk = false;
        this.dWr = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dWl != null) {
                    a.this.dWl.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dWl != null) {
                    a.this.dWl.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWs = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.dWl != null) {
                    a.this.dWl.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dWl != null) {
                    a.this.dWl.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dWt = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dWh.getVisibility() == 0) {
                    a.this.dWh.setVisibility(8);
                }
            }
        };
        this.dIz = z;
        this.mFrom = str;
        this.aMB = str2;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dIc = (FrameLayout) view.findViewById(d.g.video_agg_container);
        this.dWe = view.findViewById(d.g.card_container);
        this.dId = (FrameLayout) view.findViewById(d.g.video_container);
        this.dIp = new com.baidu.tieba.play.c(tbPageContext, this.dId, false);
        this.dIp.a(new g.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (a.this.dWq != null && a.this.dIq.dIR.videoDuration > 8) {
                    a.this.dWq.J(a.this.mPosition, a.this.dIq.dIR.videoUrl);
                }
            }
        });
        this.dIe = (TextView) view.findViewById(d.g.title);
        this.cGk = (HeadImageView) view.findViewById(d.g.user_icon);
        this.bdY = (TextView) view.findViewById(d.g.user_name);
        this.cuG = (TextView) view.findViewById(d.g.attention);
        this.bdl = (TextView) view.findViewById(d.g.thread_info_praise_num);
        this.bdm = (ImageView) view.findViewById(d.g.thread_info_praise_img);
        this.bdn = view.findViewById(d.g.agree_view_container);
        this.bdo = (TextView) view.findViewById(d.g.thread_info_commont_num);
        this.bdp = (ImageView) view.findViewById(d.g.thread_info_commont_img);
        this.bdq = view.findViewById(d.g.thread_info_commont_container);
        this.bdr = (TextView) view.findViewById(d.g.share_num);
        this.bds = (ImageView) view.findViewById(d.g.share_num_img);
        this.bdt = view.findViewById(d.g.share_num_container);
        this.dWh = (FrameLayout) view.findViewById(d.g.download_nani_guide_container);
        this.dWi = (TextView) view.findViewById(d.g.download_nani_guide_txt);
        this.dWh.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.dWi.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.dWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    aw.Du().a((TbPageContext) i.ak(a.this.akO().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.dWf = view.findViewById(d.g.attention_container);
        this.dWg = (ImageView) view.findViewById(d.g.attention_img);
        this.dWl = view.findViewById(d.g.video_agg_container_foreground);
        this.dWm = view.findViewById(d.g.user_container_foreground);
        this.dWn = view.findViewById(d.g.title_foreground);
        this.dWo = view.findViewById(d.g.comment_and_priase_layout_foreground);
        this.dWm.setOnClickListener(this);
        this.dWn.setOnClickListener(this);
        this.dWo.setOnClickListener(this);
        this.dWl.setOnClickListener(this);
        this.bdn.setOnClickListener(this);
        this.bdq.setOnClickListener(this);
        this.bdt.setOnClickListener(this);
        this.dIe.setOnClickListener(this);
        this.cGk.setOnClickListener(this);
        this.bdY.setOnClickListener(this);
        this.dWf.setOnClickListener(this);
        this.dWe.setOnClickListener(this);
        this.mWidth = l.ao(tbPageContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.dIc.setLayoutParams(layoutParams);
        this.cGk.setIsRound(true);
        this.cba = new n(tbPageContext.getPageActivity());
        this.dIr = new h(this.mPageContext, this);
        this.dIx = new AlphaAnimation(0.0f, 0.7f);
        this.dIx.setDuration(500L);
        this.dIx.setAnimationListener(this.dWs);
        this.caN = new AlphaAnimation(0.7f, 0.0f);
        this.caN.setDuration(500L);
        this.caN.setAnimationListener(this.dWr);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dIq != null && this.dIq.dIQ != null) {
            if (this.dIq.dIQ.hasFocus) {
                this.cuG.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_d));
                this.dWf.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
            } else {
                this.cuG.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_link_tip_a));
            }
        }
        if (this.dIq != null) {
            if (this.dIq.hasAgree) {
                this.bdm.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.icon_home_card_like_s));
                this.bdl.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
            } else {
                this.bdm.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_like_selector));
                this.bdl.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
            }
        }
        this.bdo.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
        this.bdp.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_commnet_selector));
        this.bdr.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
        this.bds.setImageDrawable(tbPageContext.getResources().getDrawable(d.f.card_share_selector));
        this.dIe.setTextColor(tbPageContext.getResources().getColor(d.C0140d.cp_cont_i));
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
        if (fVar != null && fVar.dIR != null) {
            this.dIq = fVar;
            this.dIy = this.dIq.autoPlay;
            this.dWk = false;
            gv(false);
            this.dIe.setVisibility(0);
            this.dIe.setText(fVar.title);
            aAA();
            b(fVar, i, aVar);
            h(fVar);
            i(fVar);
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private boolean aAz() {
        try {
            int parseInt = Integer.parseInt(this.dIq.dIR.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dIq.dIR.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void aAA() {
        if (!aAz()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIc.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.dIc.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dIc.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.dIc.setLayoutParams(layoutParams2);
    }

    private void b(com.baidu.tieba.frs.aggregation.f fVar, final int i, final d.a aVar) {
        if (fVar != null && fVar.dIR != null) {
            this.dIp.stopPlay();
            this.dIp.lI(true);
            this.dIp.lL(true);
            this.dIp.lJ(false);
            this.dIp.lM(true);
            this.dIp.Q(false, false);
            this.dIp.tQ(i);
            this.dIp.a(new c.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
                @Override // com.baidu.tieba.play.c.b
                public void awB() {
                    a.this.aAB();
                }

                @Override // com.baidu.tieba.play.c.b
                public void awC() {
                    a.this.aAC();
                    if (a.this.dIp.bkW()) {
                    }
                    if (a.this.dIv) {
                        a.this.dIp.stopPlay();
                    }
                }
            });
            this.dIp.a(new c.j() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
                @Override // com.baidu.tieba.play.c.j
                public void awD() {
                    if (a.this.dIq != null && a.this.dIq.dIR != null && com.baidu.adp.lib.g.b.h(a.this.dIq.dIR.videoHeight, 0) > com.baidu.adp.lib.g.b.h(a.this.dIq.dIR.videoWidth, 0)) {
                        a.this.dIp.Q(false, false);
                    } else {
                        a.this.dIp.Q(true, false);
                    }
                    a.this.dIv = false;
                    a.this.lL(a.this.dIy ? "1" : "2");
                    a.this.onClick(a.this.dId);
                }

                @Override // com.baidu.tieba.play.c.j
                public void awE() {
                    a.this.onClick(a.this.dIc);
                }
            });
            this.dIp.a(new c.e() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
                @Override // com.baidu.tieba.play.c.e
                public void gb(boolean z) {
                    a.this.dIp.bL(a.this.dIq.dIR.videoUrl, a.this.dIq.threadId);
                    a.this.lL("2");
                    a.this.onClick(a.this.dId);
                }
            });
            this.dIp.lG(false);
            this.dIs = new aa();
            this.dIs.bDf = fVar.threadId;
            this.dIs.cZU = fVar.forumId;
            this.dIs.mUid = TbadkCoreApplication.getCurrentAccount();
            this.dIt = new aa();
            this.dIt.bDf = fVar.threadId;
            this.dIt.cZU = fVar.forumId;
            this.dIt.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.dIz) {
                ak akVar = new ak("c12590");
                akVar.ab("tid", fVar.threadId);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                akVar.s("obj_locate", i);
                akVar.s("obj_param2", 1);
                akVar.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                akVar.ab("obj_param1", fVar.weight);
                akVar.ab("extra", fVar.extra);
                akVar.ab("obj_id", this.aMB);
                akVar.ab("ab_tag", fVar.abtest_tag);
                akVar.ab("obj_type", this.mFrom);
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dIq.source);
                TiebaStatic.log(akVar);
                this.dIs.gvW = this.mFrom;
                this.dIs.mSource = fVar.source;
                this.dIs.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.dIs.gvY = this.mFrom;
                this.dIt.gvW = "auto_midpage";
                this.dIt.mLocate = "auto_midpage";
                this.dIt.gvY = this.mFrom;
                this.dIt.mSource = fVar.source;
            }
            if (fVar.dIR != null) {
                this.dIs.gwa = fVar.dIR.videoMd5;
                this.dIt.gwa = fVar.dIR.videoMd5;
            }
            this.cba.setVideoStatsData(this.dIs);
            this.dIp.getVideoView().setBusiness(this.cba);
            this.dIp.aQz();
            this.dIp.b(new c.InterfaceC0218c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void gc(boolean z) {
                    if (!a.this.dIp.bkW()) {
                        a.this.nY(0);
                        a.this.dWo.setVisibility(0);
                        a.this.dWn.setVisibility(0);
                        a.this.dWm.setVisibility(0);
                    } else if (z) {
                        if (a.this.dWo.getVisibility() == 8) {
                            a.this.dWo.setVisibility(0);
                            a.this.gv(true);
                        }
                        if (a.this.dWn.getVisibility() == 8) {
                            a.this.dWn.setVisibility(0);
                        }
                        if (a.this.dWm.getVisibility() == 8) {
                            a.this.dWm.setVisibility(0);
                        }
                        a.this.nY(1);
                    } else {
                        if (a.this.dWo.getVisibility() == 0) {
                            a.this.dWo.setVisibility(8);
                            a.this.gv(false);
                        }
                        if (a.this.dWn.getVisibility() == 0) {
                            a.this.dWn.setVisibility(8);
                        }
                        if (a.this.dWm.getVisibility() == 0) {
                            a.this.dWm.setVisibility(8);
                        }
                        a.this.nY(0);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awF() {
                    a.this.nY(1);
                    if (!a.this.dIp.bkW()) {
                        a.this.dWo.setVisibility(0);
                        a.this.dWn.setVisibility(0);
                        a.this.dWm.setVisibility(0);
                        return;
                    }
                    if (a.this.dWo.getVisibility() == 8) {
                        a.this.dWo.setVisibility(0);
                    }
                    if (a.this.dWn.getVisibility() == 8) {
                        a.this.dWn.setVisibility(0);
                    }
                    if (a.this.dWm.getVisibility() == 8) {
                        a.this.dWm.setVisibility(0);
                    }
                }
            });
            this.dIp.a(new g.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar) {
                    if (a.this.isFullScreen) {
                        a.this.dIv = true;
                        a.this.dIu = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.nd(i);
                        a.this.dIp.aDC();
                    }
                }
            });
            this.dIp.a(new g.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                    if (a.this.dIq != null && a.this.dIq.dIR != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.dIq.dIR.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.dIp.ov(fVar.dIR.thumbnailUrl);
            this.dIp.bK(fVar.dIR.videoUrl, fVar.threadId);
            this.dIp.a(new c.g() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
                @Override // com.baidu.tieba.play.c.g
                public void awG() {
                }
            });
            this.dIp.aDC();
            this.dIp.show();
            if (fVar.autoPlay) {
                onClick(this.dId);
                this.dIv = false;
                this.dIp.a(fVar.dIR.videoUrl, fVar.threadId, null, new Object[0]);
                if (i == 0) {
                    this.dWl.setVisibility(8);
                } else {
                    this.dWl.startAnimation(this.caN);
                }
                this.dWn.setVisibility(8);
                this.dWo.setVisibility(8);
                gv(false);
                this.dWm.setVisibility(8);
            } else if (j.oL() && fVar.waitConfirm) {
                this.dWl.startAnimation(this.caN);
                this.dWn.setVisibility(8);
                this.dWo.setVisibility(8);
                gv(false);
                this.dWm.setVisibility(8);
            } else {
                this.dWn.setVisibility(0);
                this.dWo.setVisibility(0);
                this.dWm.setVisibility(0);
                this.dWl.setVisibility(0);
            }
            this.dIv = false;
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
        if (this.dIq != null && this.dIq.dIR != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.dIq.dIR.videoMd5, "", str, this.dIt);
            }
        }
    }

    public boolean isPlaying() {
        return this.dIp.bkW();
    }

    public void awx() {
        if (isPlaying()) {
            this.dIp.pausePlay();
        }
    }

    public boolean nc(int i) {
        return this.dIp.tP(i);
    }

    public void awy() {
        this.dWk = false;
        this.dIp.stopPlay();
        if (this.dIe != null) {
            this.dIe.setVisibility(0);
        }
        gv(false);
        this.dWj = true;
    }

    public void awz() {
        if (this.dIp != null) {
            this.dIp.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        awz();
        if (this.dIr != null) {
            this.dIr.awP();
        }
        if (this.dWl != null) {
            this.dWl.clearAnimation();
        }
    }

    public void h(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null && fVar.dIQ != null) {
            this.bdY.setText(TextUtils.isEmpty(fVar.dIQ.userNickname) ? fVar.dIQ.userName : fVar.dIQ.userNickname);
            this.cGk.startLoad(fVar.dIQ.portrait, 12, false);
            if (fVar.dIQ.isBigV) {
                this.cGk.setShowV(fVar.dIQ.isBigV);
                this.cGk.setIsBigV(fVar.dIQ.isBigV);
            } else if (fVar.dIQ.isGod) {
                this.cGk.setShowV(fVar.dIQ.isGod);
                this.cGk.setIsBigV(fVar.dIQ.isGod);
            } else {
                this.cGk.setShowV(fVar.dIQ.isGod);
                this.cGk.setIsBigV(fVar.dIQ.isGod);
            }
            c(fVar);
            d(fVar);
            e(fVar);
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null && fVar.dIQ != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(fVar.dIQ.userId) && TbadkCoreApplication.getCurrentAccount().equals(fVar.dIQ.userId)) {
                this.dWf.setVisibility(8);
            } else {
                this.dWf.setVisibility(0);
            }
            if (fVar.dIQ.hasFocus) {
                this.cuG.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_d));
                this.cuG.setText(this.mPageContext.getString(d.j.relate_forum_is_followed));
                this.dWf.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.transparent_bg));
                this.dWg.setVisibility(8);
                return;
            }
            this.cuG.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_link_tip_a));
            this.cuG.setText(this.mPageContext.getString(d.j.attention));
            this.dWg.setVisibility(0);
            this.dWf.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_attention_btn));
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null) {
            if (fVar.hasAgree) {
                this.bdm.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_like_s));
                this.bdl.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_h_1));
            } else {
                this.bdm.setImageDrawable(getContext().getResources().getDrawable(d.f.card_like_selector));
                this.bdl.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_i));
            }
            if (fVar.agreeNum > 0) {
                this.bdl.setText(am.J(fVar.agreeNum));
            } else {
                this.bdl.setText(d.j.action_praise_default);
            }
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.f fVar) {
        if (fVar != null) {
            this.bdo.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.bdp.setImageDrawable(getContext().getResources().getDrawable(d.f.icon_home_card_comment));
            if (fVar.postNum > 0) {
                this.bdo.setText(am.J(fVar.postNum));
            } else {
                this.bdo.setText(this.mContext.getString(d.j.reply));
            }
        }
    }

    public void i(com.baidu.tieba.frs.aggregation.f fVar) {
        if (this.bdt != null && this.bdr != null && fVar != null) {
            long j = fVar.shareNum;
            String string = this.mContext.getString(d.j.share);
            if (j > 0) {
                string = am.J(j);
            }
            this.bdr.setText(string);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dIp != null && this.dId != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.dIu) {
                this.dIp.bkV();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                aAB();
            } else {
                configuration.orientation = 1;
                aAC();
                this.dIu = true;
            }
            this.dIp.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAB() {
        if (this.dIp != null && this.dId != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.dId.getParent() != null) {
                if (this.dId.getParent() == frameLayout) {
                    frameLayout.removeView(this.dId);
                } else if (this.dId.getParent() == this.dIc) {
                    this.dIc.removeView(this.dId);
                }
            }
            if (this.dId.getParent() == null) {
                frameLayout.addView(this.dId);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dId.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.dId.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAC() {
        if (this.dIp != null && this.dId != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.dId.getParent() != null) {
                if (this.dId.getParent() == frameLayout) {
                    frameLayout.removeView(this.dId);
                } else if (this.dId.getParent() == this.dIc) {
                    this.dIc.removeView(this.dId);
                }
            }
            if (this.dId.getParent() == null) {
                this.dIc.addView(this.dId, 0);
                aAD();
                this.dIp.aQz();
            }
        }
    }

    private void aAD() {
        int i;
        if (!aAz()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.dId.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (akP() != null) {
            view.setTag(this);
            akP().a(view, this.dIq);
        }
        if (view == this.cGk || view == this.bdY) {
            if (this.dIq != null && this.dIq.dIQ != null && !TextUtils.isEmpty(this.dIq.dIQ.userId)) {
                if (TbadkCoreApplication.isLogin() && this.dIq.dIQ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.dIq.dIQ.userId, 0L), z, this.dIq.dIQ.isGod)));
            }
        } else if (view == this.bdq || view == this.dIe || view == this.dWe) {
            if (this.dIq != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.dIq.threadId, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        } else if (view == this.dWf) {
            if (!this.dIq.dIQ.hasFocus) {
                this.dIr.f(this.dIq);
            }
        } else if (view == this.bdn) {
            this.dIr.g(this.dIq);
        } else if (view == this.bdt) {
            Es();
        } else if (view == this.dWl && this.dWl.getVisibility() == 0) {
            if (this.dWp != null) {
                this.dWp.nZ(this.mPosition);
            }
        } else if (view == this.dWn || view == this.dWo || view == this.dWm) {
            if (this.dWl.getVisibility() == 0) {
                if (this.dWp != null) {
                    this.dWp.nZ(this.mPosition);
                    return;
                }
                return;
            }
            if (this.dWo.getVisibility() == 0) {
                this.dWo.setVisibility(8);
                gv(false);
            }
            if (this.dWn.getVisibility() == 0) {
                this.dWn.setVisibility(8);
            }
            if (this.dWm.getVisibility() == 0) {
                this.dWm.setVisibility(8);
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
        if (this.dIq != null && this.dIq.dIQ != null) {
            this.dIq.dIQ.hasFocus = z;
            c(this.dIq);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.b
    public void awA() {
        if (this.dIq != null) {
            this.dIq.hasAgree = !this.dIq.hasAgree;
            if (this.dIq.hasAgree) {
                this.dIq.agreeNum++;
            } else {
                this.dIq.agreeNum--;
            }
            if (this.bdm != null) {
                this.bdm.startAnimation(getScaleAnimation());
            }
            d(this.dIq);
        }
    }

    private Animation getScaleAnimation() {
        if (this.bdU == null) {
            this.bdU = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdU.setDuration(200L);
        }
        return this.bdU;
    }

    public void gu(boolean z) {
        if (this.dIc != null) {
            this.dIc.setVisibility(z ? 0 : 4);
        }
    }

    public void a(InterfaceC0158a interfaceC0158a) {
        this.dWp = interfaceC0158a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gv(boolean z) {
        this.dWj = this.mPosition == (this.dWq == null ? -1 : this.dWq.aAK());
        if (this.dWj && z && isPlaying() && this.dIy && !this.dWk) {
            this.dWh.setVisibility(0);
            this.dWk = true;
            this.dWh.postDelayed(this.dWt, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.dWq != null) {
                this.dWq.bH(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.dWh.setVisibility(8);
        if (this.dWt != null) {
            this.dWh.removeCallbacks(this.dWt);
        }
    }

    private void Es() {
        if (this.dIq != null && this.mContext != null) {
            String valueOf = String.valueOf(this.dIq.forumId);
            String str = this.dIq.title;
            String str2 = this.dIq.threadId;
            String str3 = "http://tieba.baidu.com/p/" + str2 + "?share=9105&fr=share";
            String str4 = this.dIq.dIR.thumbnailUrl;
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = this.dIq.title;
            String format = MessageFormat.format(this.mContext.getResources().getString(d.j.share_content_tpl), str, str5);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = format;
            dVar.blE = str5;
            dVar.linkUrl = str3;
            dVar.extData = str2;
            dVar.blH = 3;
            dVar.fid = valueOf;
            dVar.blz = "";
            dVar.tid = str2;
            dVar.blw = true;
            dVar.blG = 0;
            dVar.blI = 2;
            if (parse != null) {
                dVar.blB = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str4;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str;
            originalThreadInfo.threadId = str2;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blH);
            bundle.putInt("obj_type", dVar.blI);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQD);
            dVar.i(bundle);
            com.baidu.tieba.d.d.anj().a(new ShareDialogConfig(this.mContext, dVar, true, true));
        }
    }
}
