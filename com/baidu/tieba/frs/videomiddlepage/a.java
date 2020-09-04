package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.afd.videopaster.d;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> implements com.baidu.tieba.frs.aggregation.c, com.baidu.tieba.lego.card.view.h, j {
    private com.baidu.tieba.lego.card.view.f Yv;
    public TextView aiH;
    private Animation bAh;
    private Animation bAi;
    private TextView dTJ;
    private String dYs;
    private boolean egF;
    protected AgreeView etA;
    private ImageView etB;
    private View etC;
    private TextView etD;
    private ImageView etE;
    private View etF;
    public FrameLayout hZP;
    public FrameLayout hZQ;
    public HeadImageView hZW;
    private com.baidu.afd.videopaster.d hjn;
    private int hzR;
    public com.baidu.tieba.play.c iad;
    public com.baidu.tieba.frs.aggregation.g iae;
    private com.baidu.tieba.frs.aggregation.h iaf;
    private o iag;
    private o iah;
    private boolean iai;
    private boolean iaj;
    private boolean iam;
    private boolean isFullScreen;
    public ExpandableTextView ivQ;
    private View ivR;
    private FrameLayout ivS;
    private TextView ivT;
    private boolean ivU;
    private boolean ivV;
    private boolean ivW;
    private View ivX;
    private View ivY;
    private c ivZ;
    public com.baidu.tieba.frs.videomiddlepage.a.a iwa;
    private C0691a iwb;
    private VideoNetworkStateTipView iwc;
    private b iwd;
    private com.baidu.mcn.c iwe;
    private com.baidu.tieba.lego.card.view.g iwf;
    private boolean iwg;
    private boolean iwh;
    private boolean iwi;
    private Animation.AnimationListener iwj;
    private Animation.AnimationListener iwk;
    private Runnable iwl;
    private Runnable iwm;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.iai = true;
        this.iam = true;
        this.ivV = false;
        this.ivW = false;
        this.iwg = false;
        this.iwh = false;
        this.iwi = false;
        this.startPosition = -1L;
        this.hzR = 0;
        this.iwj = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ivX != null) {
                    a.this.ivX.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ivX != null) {
                    a.this.ivX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iwk = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ivX != null) {
                    a.this.ivX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ivX != null) {
                    a.this.ivX.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iwl = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ivS.getVisibility() == 0) {
                    a.this.ivS.setVisibility(8);
                }
            }
        };
        this.iwm = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iad != null) {
                    a.this.iad.stopPlay();
                }
            }
        };
        this.iam = z;
        this.mFrom = str;
        this.dYs = str2;
        this.iwd = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hZP = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.ivR = view.findViewById(R.id.card_container);
        this.hZQ = (FrameLayout) view.findViewById(R.id.video_container);
        this.iad = new com.baidu.tieba.play.c(tbPageContext, this.hZQ, false);
        this.iad.setStageType("2005");
        this.iad.uU(z);
        this.iad.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.iwa != null && a.this.iae.iaE.videoDuration > 8) {
                    a.this.iwa.bc(a.this.mPosition, a.this.iae.iaE.videoUrl);
                }
            }
        });
        this.iad.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void pn(boolean z2) {
                if (a.this.iwb != null) {
                    if (z2) {
                        a.this.iwb.yY(0);
                    } else {
                        a.this.iwb.yY(1);
                    }
                }
            }
        });
        this.iad.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.ivQ = (ExpandableTextView) view.findViewById(R.id.title);
        this.hZW = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aiH = (TextView) view.findViewById(R.id.user_name);
        this.etA = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWP = 2;
        cVar.dWU = 6;
        this.etA.setStatisticData(cVar);
        this.dTJ = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.etB = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.etC = view.findViewById(R.id.thread_info_commont_container);
        this.etD = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.etE = (ImageView) view.findViewById(R.id.share_num_img);
        this.etF = view.findViewById(R.id.share_num_container);
        this.ivS = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.ivT = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.ivS.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ivT.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_download_link_url", null);
        this.ivT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bju().a((TbPageContext) i.I(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.iwc = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.iwc.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.iwc.setHasAgreeToPlay(true);
                a.this.iad.va(false);
                a.this.iwc.dEx();
                if (a.this.hjn.rv()) {
                    a.this.hjn.resume();
                } else if (a.this.iae != null && a.this.iae.iaE != null) {
                    a.this.iad.fx(a.this.iae.iaE.videoUrl, a.this.iae.threadId);
                }
            }
        });
        this.ivX = view.findViewById(R.id.video_agg_container_foreground);
        this.ivY = view.findViewById(R.id.title_and_comment_container_foreground);
        this.ivX.setOnClickListener(this);
        this.etC.setOnClickListener(this);
        this.etF.setOnClickListener(this);
        this.ivQ.setOnClickListener(this);
        this.hZW.setOnClickListener(this);
        this.aiH.setOnClickListener(this);
        this.ivR.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.hzR = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZP.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hZP.setLayoutParams(layoutParams);
        this.hZW.setIsRound(true);
        this.hZW.setPlaceHolder(1);
        this.iaf = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bAh = new AlphaAnimation(0.0f, 0.7f);
        this.bAh.setDuration(500L);
        this.bAh.setAnimationListener(this.iwk);
        this.bAi = new AlphaAnimation(0.7f, 0.0f);
        this.bAi.setDuration(500L);
        this.bAi.setAnimationListener(this.iwj);
        this.iwb = new C0691a();
        this.hjn = new com.baidu.afd.videopaster.d(getContext(), this.hZQ);
        this.iwe = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.etA.onChangeSkinType(i);
        this.dTJ.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.etD.setTextColor(ap.getColor(R.color.cp_cont_d));
        SvgManager.bjq().a(this.etB, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.etE, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ivQ.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    public void a(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.iaE != null) {
            boolean z = this.iae == gVar;
            this.iae = gVar;
            this.egF = this.iae.autoPlay;
            this.ivW = false;
            pl(false);
            this.ivQ.setVisibility(0);
            this.ivQ.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.ivQ.setTextColor(R.color.cp_cont_a);
            this.ivQ.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.iaE != null && !StringUtils.isNull(gVar.iaE.mcnLeadPage)) {
                this.ivQ.setTextMaxLine(2);
                this.ivQ.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.ivQ.getContentView(), gVar.title, gVar.iaE.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ivQ.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ivQ.setExpandable(true);
                this.ivQ.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void po(boolean z2) {
                        a.this.iae.isTitleExpanded = z2;
                    }
                });
                this.ivQ.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.hzR) {
                this.iad.djQ();
                this.hzR = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hZQ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hZQ.setLayoutParams(layoutParams);
            }
            cug();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.iae = gVar;
        this.egF = this.iae.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cuf() {
        try {
            int parseInt = Integer.parseInt(this.iae.iaE.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.iae.iaE.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cug() {
        if (!cuf()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZP.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hZP.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hZP.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hZP.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.iaE != null) {
            this.iad.stopPlay();
            this.iad.vb(true);
            this.iad.uX(true);
            this.iad.vc(true);
            this.iad.au(false, false);
            this.iad.FE(i);
            this.iad.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                    a.this.cuk();
                    if (a.this.hjn != null) {
                        a.this.hjn.rD();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                    a.this.cul();
                    if (a.this.iad.rF()) {
                    }
                    if (a.this.iaj || (a.this.hjn != null && a.this.hjn.rv())) {
                        com.baidu.adp.lib.f.e.mS().removeCallbacks(a.this.iwm);
                        com.baidu.adp.lib.f.e.mS().post(a.this.iwm);
                    }
                    if (a.this.hjn != null) {
                        a.this.hjn.rE();
                    }
                }
            });
            this.iad.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void coN() {
                    if (a.this.iae != null && a.this.iae.iaE != null && com.baidu.adp.lib.f.b.toInt(a.this.iae.iaE.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.iae.iaE.videoWidth, 0)) {
                        a.this.iad.au(false, false);
                    } else {
                        a.this.iad.au(true, false);
                    }
                    a.this.iaj = false;
                    a.this.Iv(a.this.egF ? "1" : "2");
                    a.this.onClick(a.this.hZQ);
                    if (a.this.Yv != null) {
                        a.this.Yv.a(a.this);
                    }
                    if (a.this.iwf != null) {
                        a.this.iwf.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void coO() {
                    a.this.onClick(a.this.hZP);
                }
            });
            this.iad.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void oH(boolean z2) {
                    a.this.iad.fx(a.this.iae.iaE.videoUrl, a.this.iae.threadId);
                    a.this.Iv("2");
                    a.this.onClick(a.this.hZQ);
                }
            });
            this.iad.uT(false);
            if (this.iwe != null) {
                this.iwe.reset();
            }
            this.startPosition = -1L;
            if (this.iad.getVideoView() != null && this.iad.getVideoView().getMediaProgressObserver() != null) {
                this.iad.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bX(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.iae.iaE.iaO;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.hjn.a(a.this.isFullScreen, a.this.iad != null && a.this.iad.djx(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.hjn.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.iad.djx() && !com.baidu.mcn.b.SM().hJ(aVar2.YK)) {
                            boolean z3 = a.this.startPosition >= (aVar2.iaG * 1000) + 1000;
                            if (i3 < aVar2.iaG * 1000 || i3 >= aVar2.iaH * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.iwe.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bzU = aVar2.iaJ;
                                    aVar3.bzV = aVar2.iaK;
                                    aVar3.bzW = aVar2.YK;
                                    aVar3.bzT = aVar2.iaI;
                                    aVar3.fid = a.this.iae != null ? a.this.iae.forumId : null;
                                    aVar3.tid = a.this.iae != null ? a.this.iae.threadId : null;
                                    aVar3.bzX = 3;
                                    if (z3) {
                                        a.this.iwe.b(aVar3, (ViewGroup) a.this.iad.djP());
                                    } else {
                                        a.this.iwe.a(aVar3, (ViewGroup) a.this.iad.djP());
                                    }
                                }
                            } else if (a.this.iwe.isShowing()) {
                                a.this.iwe.dismiss();
                            }
                        }
                    }
                });
            }
            this.iag = new o();
            this.iag.ala = gVar.threadId;
            this.iag.mNid = gVar.nid;
            this.iag.eVx = gVar.forumId;
            this.iag.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iag.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.iag.mSource = gVar.source;
            this.iag.ltn = gVar.weight;
            this.iag.ltp = this.mFrom;
            this.iag.lts = gVar.abtest_tag;
            this.iag.dYs = this.dYs;
            this.iag.mExtra = gVar.extra;
            this.iag.ltv = "0";
            this.iag.ltq = gVar.getVideoType();
            this.iah = new o();
            this.iah.ala = gVar.threadId;
            this.iah.eVx = gVar.forumId;
            this.iah.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iah.ltn = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iah.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iah.ltp = this.mFrom;
            this.iah.mSource = gVar.source;
            this.iah.ltv = "0";
            if (gVar.iaE != null) {
                this.iag.ltt = gVar.iaE.videoMd5;
                this.iah.ltt = gVar.iaE.videoMd5;
            }
            aq aqVar = new aq("c12590");
            aqVar.dD("tid", gVar.threadId);
            aqVar.dD("nid", gVar.nid);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", i);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dD("fid", gVar.forumId);
            aqVar.dD("obj_param1", at.isEmpty(gVar.weight) ? "0" : gVar.weight);
            aqVar.dD("extra", at.isEmpty(gVar.extra) ? "0" : gVar.extra);
            aqVar.dD("obj_id", this.dYs);
            aqVar.dD("ab_tag", at.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
            aqVar.dD("obj_type", this.mFrom);
            aqVar.ai("obj_param5", gVar.getVideoType());
            aqVar.dD("obj_source", at.isEmpty(gVar.source) ? "0" : gVar.source);
            aqVar.ai("is_vertical", 0);
            if (gVar.mBaijiahao != null) {
                aqVar.dD("obj_param4", gVar.mBaijiahao.oriUgcNid);
                aqVar.dD("obj_param6", gVar.mBaijiahao.oriUgcVid);
            }
            TiebaStatic.log(aqVar);
            this.iad.getVideoView().setVideoStatData(this.iag);
            this.iad.cMR();
            this.iad.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.hjn.a(a.this.isFullScreen, a.this.iad != null && a.this.iad.djx(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.iaj = true;
                            a.this.ivU = true;
                            a.this.iai = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.xA(i);
                            a.this.iad.czv();
                        }
                    }
                }
            });
            this.iad.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.iae != null && a.this.iae.iaE != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.iae.iaE.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.hjn.reset();
            }
            this.hjn.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rM() {
                    a.this.ivU = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rL() {
                    if (a.this.isFullScreen) {
                        a.this.iaj = true;
                        a.this.ivU = true;
                        a.this.iai = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.xA(i);
                        a.this.iad.czv();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rK() {
                    if (a.this.iad != null) {
                        a.this.iad.FD(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rN() {
                    return a.this.cuj();
                }
            });
            this.iad.setThumbnail(gVar.iaE.thumbnailUrl);
            this.iad.FC(gVar.iaE.videoDuration);
            this.iad.setVideoUrl(gVar.iaE.videoUrl, gVar.threadId);
            this.iad.setFid(gVar.forumId);
            this.iad.czv();
            this.iad.show();
            pl(false);
            if (gVar.autoPlay) {
                onClick(this.hZQ);
                if (this.iwc.dft()) {
                    this.iad.uZ(false);
                    this.iwc.dEw();
                    this.iad.va(true);
                    this.iad.fw(gVar.iaE.videoUrl, gVar.threadId);
                    if (this.hjn.rv()) {
                        this.hjn.stop();
                        this.hjn.rA();
                    }
                } else {
                    this.iad.va(false);
                    this.iad.uZ(false);
                    this.iwc.hide();
                    if (this.hjn == null || (this.hjn != null && !this.hjn.rv())) {
                        this.iad.a(gVar.iaE.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.iaF) {
                    this.ivX.setVisibility(8);
                    this.iwb.yY(3);
                } else {
                    if (this.ivX.getVisibility() == 0) {
                        this.ivX.startAnimation(this.bAi);
                    }
                    this.iwb.yY(0);
                }
                gVar.iaF = false;
            } else {
                this.ivX.setVisibility(0);
                this.iwc.hide();
                this.iad.uZ(true);
                this.iwb.yY(3);
                this.iad.fw(gVar.iaE.videoUrl, gVar.threadId);
            }
            this.iaj = false;
            this.ivU = false;
            if (!z && this.hjn.rv()) {
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
        com.baidu.afd.videopaster.data.b Jc = this.iwd != null ? this.iwd.Jc(gVar.getThreadId()) : null;
        if (Jc == null) {
            return null;
        }
        int rR = Jc.rR();
        int rS = Jc.rS();
        int rQ = Jc.rQ();
        if (rQ != -1) {
            i = rR != -1 ? (rQ - rR) - 1 : -1;
            if (rS != -1) {
                i4 = (rS - rQ) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.iaE != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.iaE.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.iaE.videoHeight, 0);
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
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546857125210", rQ + 1, i3, i2);
        a.u(hashMap);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv(String str) {
        if (this.iae != null && this.iae.iaE != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.iae.iaE.videoMd5, "", str, this.iah, this.iad.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.iad.rF();
    }

    public boolean cuh() {
        return this.hjn.rv();
    }

    public void coJ() {
        if (isPlaying()) {
            this.iad.aHX();
        }
    }

    public boolean xB(int i) {
        if (i == 4 && this.hjn != null && ((this.hjn.rv() || this.ivU) && this.iad != null)) {
            this.hjn.aV(i);
            if (this.isFullScreen) {
                if (this.hjn.ru()) {
                    this.iad.djy();
                } else {
                    this.iad.Oh();
                }
                return true;
            }
        }
        return this.iad.FD(i);
    }

    public void coK() {
        this.ivW = false;
        this.iad.stopPlay();
        if (this.ivQ != null) {
            this.ivQ.setVisibility(0);
        }
        if (this.iwb != null) {
            this.iwb.yY(2);
        }
        pl(false);
        this.ivV = true;
        if (this.hjn != null && this.hjn.rv()) {
            this.hjn.stop();
        }
    }

    public void cui() {
        this.hjn.stop();
    }

    public void coL() {
        if (this.iad != null) {
            this.iad.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        coL();
        if (this.iaf != null) {
            this.iaf.coV();
        }
        if (this.ivX != null) {
            this.ivX.clearAnimation();
        }
        this.hjn.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.iaD != null) {
            this.aiH.setText(TextUtils.isEmpty(gVar.iaD.userNickname) ? gVar.iaD.userName : gVar.iaD.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.iaD != null) {
            if (gVar.iaD.iaN != null && !TextUtils.isEmpty(gVar.iaD.iaN.avatar)) {
                this.hZW.startLoad(gVar.iaD.iaN.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.iaD.portrait) && gVar.iaD.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hZW.startLoad(gVar.iaD.portrait, 10, false);
            } else {
                this.hZW.startLoad(gVar.iaD.portrait, 12, false);
            }
            if (gVar.iaD.iaN != null && gVar.iaD.iaN.auth_id.intValue() > 0) {
                this.hZW.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.iaD.iaN.auth_id.intValue(), 1));
                this.hZW.setShowV(true);
                this.hZW.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hZW.setBjhAuthIconRes(0);
            if (gVar.iaD.isBigV) {
                this.hZW.setShowV(gVar.iaD.isBigV);
                this.hZW.setIsBigV(gVar.iaD.isBigV);
            } else if (gVar.iaD.isGod) {
                this.hZW.setShowV(gVar.iaD.isGod);
                this.hZW.setIsBigV(gVar.iaD.isGod);
            } else {
                this.hZW.setShowV(gVar.iaD.isGod);
                this.hZW.setIsBigV(gVar.iaD.isGod);
            }
            this.hZW.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bgv() != null) {
                gVar.bgv().isInThread = true;
                gVar.bgv().nid = gVar.nid;
                if (this.iae.getVideoType() == 1) {
                    gVar.bgv().cardType = 2;
                } else if (this.iae.getVideoType() == 2) {
                    gVar.bgv().cardType = 8;
                } else if (this.iae.getVideoType() == 3) {
                    gVar.bgv().cardType = 6;
                }
                gVar.bgv().baijiahaoData = gVar.mBaijiahao;
                gVar.bgv().recomSource = gVar.source;
                gVar.bgv().recomWeight = gVar.weight;
                gVar.bgv().recomAbTag = gVar.abtest_tag;
                gVar.bgv().recomExtra = gVar.extra;
            }
            if (this.iae.mBaijiahao != null) {
                this.etA.setAgreeAlone(true);
            }
            this.etA.setIsFromMiddlePage(true);
            this.etA.setData(gVar.bgv());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dTJ.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bjq().a(this.etB, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dTJ.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.dTJ.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.etD.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bjq().a(this.etE, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.etD.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.etD.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iad != null && this.hZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iai) {
                this.iad.djE();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cuk();
            } else {
                configuration.orientation = 1;
                cul();
                this.iai = true;
            }
            this.iad.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuj() {
        if (this.iad != null && this.hZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hZQ.getParent() != null) {
                if (this.hZQ.getParent() == frameLayout) {
                    if (this.iwg) {
                        this.iwg = false;
                        return true;
                    } else if (!this.iwh) {
                        this.iwh = true;
                        return true;
                    }
                } else if (this.hZQ.getParent() == this.hZP) {
                    if (this.iwh) {
                        this.iwh = false;
                        this.iwi = true;
                        return true;
                    } else if (!this.iwg && this.iwi) {
                        this.iwg = true;
                        this.iwi = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuk() {
        if (this.iad != null && this.hZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hZQ.getParent() != null) {
                if (this.hZQ.getParent() == frameLayout) {
                    frameLayout.removeView(this.hZQ);
                } else if (this.hZQ.getParent() == this.hZP) {
                    this.hZP.removeView(this.hZQ);
                }
            }
            if (this.hZQ.getParent() == null) {
                frameLayout.addView(this.hZQ);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZQ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hZQ.setLayoutParams(layoutParams);
                if (this.iwe != null && this.iwe.isShowing()) {
                    this.iwe.dismiss();
                }
                com.baidu.tbadk.util.e.bvk().jK(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cul() {
        if (this.iad != null && this.hZQ != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hZQ.getParent() != null) {
                if (this.hZQ.getParent() == frameLayout) {
                    cum();
                    frameLayout.removeView(this.hZQ);
                } else if (this.hZQ.getParent() == this.hZP) {
                    cum();
                    this.hZP.removeView(this.hZQ);
                }
            }
            if (this.hZQ.getParent() == null) {
                this.hZP.addView(this.hZQ, 0);
                cun();
                this.iad.cMR();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bvk().jK(false);
            }
        }
    }

    private void cum() {
        if (this.hjn != null && this.hjn.rv()) {
            this.hjn.aB(true);
        }
    }

    private void cun() {
        int i;
        if (!cuf()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hZQ.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cbA() != null) {
            view.setTag(this);
            cbA().a(view, this.iae);
        }
        if (view == this.hZW || view == this.aiH) {
            if (this.iae != null && this.iae.iaD != null && !TextUtils.isEmpty(this.iae.iaD.userId)) {
                this.iwb.yY(0);
                if (!TbadkCoreApplication.isLogin() || !this.iae.iaD.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iae.iaD.userId, 0L), z, this.iae.iaD.isGod)));
            }
        } else if (view == this.etC) {
            if (this.iae != null) {
                this.iwb.yY(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.iae.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.iae.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.ivQ || view == this.ivR) {
            if (this.iae != null) {
                if (this.iwb.getCurrentState() != 2 && this.iwb.getCurrentState() != 3) {
                    z = false;
                }
                this.iwb.yY(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.iae.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.iae.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.etF) {
            this.iwb.yY(0);
            bkV();
        } else if (view == this.ivX && this.ivX.getVisibility() == 0 && this.ivZ != null) {
            this.ivZ.zc(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oG(boolean z) {
        if (this.iae != null && this.iae.iaD != null) {
            this.iae.iaD.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void coM() {
        if (this.iae != null) {
            this.etA.bkg();
        }
    }

    public void pk(boolean z) {
        if (this.hZP != null) {
            this.hZP.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.iwf = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.ivZ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Yv = fVar;
    }

    private void pl(boolean z) {
        this.ivV = this.mPosition == (this.iwa == null ? -1 : this.iwa.cuz());
        if (this.ivV && z && isPlaying() && this.egF && !this.ivW) {
            this.ivS.setVisibility(0);
            this.ivW = true;
            this.ivS.postDelayed(this.iwl, 5000L);
            if (this.iwa != null) {
                this.iwa.eK(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ivS.setVisibility(8);
        if (this.iwl != null) {
            this.ivS.removeCallbacks(this.iwl);
        }
    }

    private void bkV() {
        String str;
        String str2;
        if (this.iae != null && this.mContext != null) {
            String valueOf = String.valueOf(this.iae.forumId);
            String str3 = this.iae.title;
            if (this.iae.mBaijiahao != null) {
                str = this.iae.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.iae.mBaijiahao.oriUgcType + "&dvid=" + this.iae.mBaijiahao.oriUgcVid + "&nid=" + this.iae.mBaijiahao.oriUgcNid;
            } else {
                str = this.iae.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.iae.iaE.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.iae.title;
            String format = (this.iae.mBaijiahao == null || this.iae.iaD == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.iae.iaD.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.iae.mBaijiahao != null) {
                shareItem.eEu = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.eEu = str6;
                shareItem.readCount = this.iae.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.eEx = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.eEj = true;
            shareItem.eEw = 11;
            if (this.iae.getVideoType() == 1) {
                shareItem.eEB = 2;
            } else if (this.iae.getVideoType() == 2) {
                shareItem.eEB = 8;
            } else if (this.iae.getVideoType() == 3) {
                shareItem.eEB = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.iae.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.iae.mBaijiahao;
            shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dD("tid", str);
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.ai("obj_locate", 12);
            aqVar.dD("nid", this.iae.nid);
            if (this.iae.mBaijiahao != null && !at.isEmpty(this.iae.mBaijiahao.oriUgcVid)) {
                aqVar.dD("obj_param6", this.iae.mBaijiahao.oriUgcVid);
            }
            if (this.iae.getVideoType() == 1) {
                aqVar.ai(IntentConfig.CARD_TYPE, 2);
            } else if (this.iae.getVideoType() == 2) {
                aqVar.ai(IntentConfig.CARD_TYPE, 8);
            } else if (this.iae.getVideoType() == 3) {
                aqVar.ai(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dD(IntentConfig.RECOM_SOURCE, this.iae.source);
            aqVar.dD("ab_tag", this.iae.abtest_tag);
            aqVar.dD("weight", this.iae.weight);
            aqVar.dD("extra", this.iae.extra);
            aqVar.dD("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEx);
            bundle.putInt("obj_type", shareItem.eEB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeF);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.cdc().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        coK();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aHX() {
        coJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pm(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void cuo() {
        this.hjn.resume();
    }

    public boolean cup() {
        if (this.iwb != null) {
            return this.iwb.getCurrentState() == 2 || this.iwb.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0691a {
        private int bMf;
        private Runnable iwq;

        private C0691a() {
            this.bMf = -1;
            this.iwq = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(C0691a.this.iwq);
                    C0691a.this.yY(2);
                }
            };
        }

        public void yY(int i) {
            switch (i) {
                case 0:
                    this.bMf = yZ(i);
                    cuq();
                    return;
                case 1:
                    this.bMf = yZ(i);
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iwq);
                    return;
                case 2:
                    this.bMf = za(i);
                    return;
                case 3:
                    this.bMf = zb(i);
                    cuq();
                    return;
                default:
                    this.bMf = za(i);
                    return;
            }
        }

        private void cuq() {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iwq);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.iwq, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.bMf;
        }

        private int yZ(int i) {
            if (i != this.bMf) {
                a.this.ivY.setVisibility(8);
                a.this.pm(true);
                return i;
            }
            return this.bMf;
        }

        private int za(int i) {
            int i2 = this.bMf;
            if (i != this.bMf) {
                a.this.ivY.setVisibility(0);
                if (i2 != 3 || a.this.iae.autoPlay) {
                    a.this.pm(false);
                    return i;
                }
                return i;
            }
            return this.bMf;
        }

        private int zb(int i) {
            if (i != this.bMf) {
                a.this.ivY.setVisibility(0);
                a.this.pm(true);
                return i;
            }
            return this.bMf;
        }
    }
}
