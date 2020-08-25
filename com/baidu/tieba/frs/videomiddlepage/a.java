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
    private com.baidu.tieba.lego.card.view.f Yt;
    public TextView aiF;
    private Animation bAe;
    private Animation bAf;
    private TextView dTF;
    private String dYo;
    private boolean egB;
    private ImageView etA;
    private View etB;
    protected AgreeView etw;
    private ImageView etx;
    private View ety;
    private TextView etz;
    public FrameLayout hZJ;
    public FrameLayout hZK;
    public HeadImageView hZQ;
    public com.baidu.tieba.play.c hZX;
    public com.baidu.tieba.frs.aggregation.g hZY;
    private com.baidu.tieba.frs.aggregation.h hZZ;
    private com.baidu.afd.videopaster.d hjj;
    private int hzL;
    private o iaa;
    private o iab;
    private boolean iac;
    private boolean iad;
    private boolean iag;
    private boolean isFullScreen;
    public ExpandableTextView ivK;
    private View ivL;
    private FrameLayout ivM;
    private TextView ivN;
    private boolean ivO;
    private boolean ivP;
    private boolean ivQ;
    private View ivR;
    private View ivS;
    private c ivT;
    public com.baidu.tieba.frs.videomiddlepage.a.a ivU;
    private C0691a ivV;
    private VideoNetworkStateTipView ivW;
    private b ivX;
    private com.baidu.mcn.c ivY;
    private com.baidu.tieba.lego.card.view.g ivZ;
    private boolean iwa;
    private boolean iwb;
    private boolean iwc;
    private Animation.AnimationListener iwd;
    private Animation.AnimationListener iwe;
    private Runnable iwf;
    private Runnable iwg;
    private String mFrom;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;
    private long startPosition;

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, b bVar) {
        super(tbPageContext);
        this.iac = true;
        this.iag = true;
        this.ivP = false;
        this.ivQ = false;
        this.iwa = false;
        this.iwb = false;
        this.iwc = false;
        this.startPosition = -1L;
        this.hzL = 0;
        this.iwd = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ivR != null) {
                    a.this.ivR.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ivR != null) {
                    a.this.ivR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iwe = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (a.this.ivR != null) {
                    a.this.ivR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.ivR != null) {
                    a.this.ivR.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.iwf = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ivM.getVisibility() == 0) {
                    a.this.ivM.setVisibility(8);
                }
            }
        };
        this.iwg = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hZX != null) {
                    a.this.hZX.stopPlay();
                }
            }
        };
        this.iag = z;
        this.mFrom = str;
        this.dYo = str2;
        this.ivX = bVar;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hZJ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.ivL = view.findViewById(R.id.card_container);
        this.hZK = (FrameLayout) view.findViewById(R.id.video_container);
        this.hZX = new com.baidu.tieba.play.c(tbPageContext, this.hZK, false);
        this.hZX.setStageType("2005");
        this.hZX.uS(z);
        this.hZX.a(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.ivU != null && a.this.hZY.iay.videoDuration > 8) {
                    a.this.ivU.bd(a.this.mPosition, a.this.hZY.iay.videoUrl);
                }
            }
        });
        this.hZX.a(new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.10
            @Override // com.baidu.tieba.play.c.a
            public void pl(boolean z2) {
                if (a.this.ivV != null) {
                    if (z2) {
                        a.this.ivV.yY(0);
                    } else {
                        a.this.ivV.yY(1);
                    }
                }
            }
        });
        this.hZX.a(new c.n() { // from class: com.baidu.tieba.frs.videomiddlepage.a.11
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                a.this.startPosition = -1L;
            }
        });
        this.ivK = (ExpandableTextView) view.findViewById(R.id.title);
        this.hZQ = (HeadImageView) view.findViewById(R.id.user_icon);
        this.aiF = (TextView) view.findViewById(R.id.user_name);
        this.etw = (AgreeView) view.findViewById(R.id.agree_view);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWL = 2;
        cVar.dWQ = 6;
        this.etw.setStatisticData(cVar);
        this.dTF = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.etx = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.ety = view.findViewById(R.id.thread_info_commont_container);
        this.etz = (TextView) view.findViewById(R.id.thread_info_share_num);
        this.etA = (ImageView) view.findViewById(R.id.share_num_img);
        this.etB = view.findViewById(R.id.share_num_container);
        this.ivM = (FrameLayout) view.findViewById(R.id.download_nani_guide_container);
        this.ivN = (TextView) view.findViewById(R.id.download_nani_guide_txt);
        this.ivM.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.ivN.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_download_link_url", null);
        this.ivN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bju().a((TbPageContext) i.I(a.this.getTbPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        this.ivW = (VideoNetworkStateTipView) view.findViewById(R.id.network_state_tip);
        this.ivW.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13257"));
                a.this.ivW.setHasAgreeToPlay(true);
                a.this.hZX.uY(false);
                a.this.ivW.dEo();
                if (a.this.hjj.rv()) {
                    a.this.hjj.resume();
                } else if (a.this.hZY != null && a.this.hZY.iay != null) {
                    a.this.hZX.fw(a.this.hZY.iay.videoUrl, a.this.hZY.threadId);
                }
            }
        });
        this.ivR = view.findViewById(R.id.video_agg_container_foreground);
        this.ivS = view.findViewById(R.id.title_and_comment_container_foreground);
        this.ivR.setOnClickListener(this);
        this.ety.setOnClickListener(this);
        this.etB.setOnClickListener(this);
        this.ivK.setOnClickListener(this);
        this.hZQ.setOnClickListener(this);
        this.aiF.setOnClickListener(this);
        this.ivL.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.hzL = this.mWidth;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZJ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hZJ.setLayoutParams(layoutParams);
        this.hZQ.setIsRound(true);
        this.hZQ.setPlaceHolder(1);
        this.hZZ = new com.baidu.tieba.frs.aggregation.h(this.mPageContext, this);
        this.bAe = new AlphaAnimation(0.0f, 0.7f);
        this.bAe.setDuration(500L);
        this.bAe.setAnimationListener(this.iwe);
        this.bAf = new AlphaAnimation(0.7f, 0.0f);
        this.bAf.setDuration(500L);
        this.bAf.setAnimationListener(this.iwd);
        this.ivV = new C0691a();
        this.hjj = new com.baidu.afd.videopaster.d(getContext(), this.hZK);
        this.ivY = new com.baidu.mcn.c(this.mContext);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.etw.onChangeSkinType(i);
        this.dTF.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.etz.setTextColor(ap.getColor(R.color.cp_cont_d));
        SvgManager.bjq().a(this.etx, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.etA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ivK.onChangeSkinType();
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
        if (gVar != null && gVar.iay != null) {
            boolean z = this.hZY == gVar;
            this.hZY = gVar;
            this.egB = this.hZY.autoPlay;
            this.ivQ = false;
            pj(false);
            this.ivK.setVisibility(0);
            this.ivK.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
            this.ivK.setTextColor(R.color.cp_cont_a);
            this.ivK.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
            if (gVar.iay != null && !StringUtils.isNull(gVar.iay.mcnLeadPage)) {
                this.ivK.setTextMaxLine(2);
                this.ivK.setExpandable(false);
                com.baidu.tieba.frs.videomiddlepage.b.a.a(this.mContext, this.ivK.getContentView(), gVar.title, gVar.iay.mcnLeadPage, gVar.getThreadId());
            } else {
                this.ivK.setTextMaxLine(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ivK.setExpandable(true);
                this.ivK.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.14
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void pm(boolean z2) {
                        a.this.hZY.isTitleExpanded = z2;
                    }
                });
                this.ivK.setData(gVar.title, gVar.isTitleExpanded);
            }
            this.mWidth = l.getEquipmentWidth(this.mContext);
            if (this.mWidth != this.hzL) {
                this.hZX.djN();
                this.hzL = this.mWidth;
                ViewGroup.LayoutParams layoutParams = this.hZK.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hZK.setLayoutParams(layoutParams);
            }
            cuf();
            a(gVar, i, aVar, z);
            i(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        this.hZY = gVar;
        this.egB = this.hZY.autoPlay;
        a(gVar, i, aVar, false);
    }

    private boolean cue() {
        try {
            int parseInt = Integer.parseInt(this.hZY.iay.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.hZY.iay.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void cuf() {
        if (!cue()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZJ.getLayoutParams();
            layoutParams.height = (int) (0.875f * this.mWidth);
            this.hZJ.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hZJ.getLayoutParams();
        layoutParams2.height = (int) (0.5625f * this.mWidth);
        this.hZJ.setLayoutParams(layoutParams2);
    }

    private void a(final com.baidu.tieba.frs.aggregation.g gVar, final int i, final com.baidu.tieba.frs.aggregation.a aVar, boolean z) {
        if (gVar != null && gVar.iay != null) {
            this.hZX.stopPlay();
            this.hZX.uZ(true);
            this.hZX.uV(true);
            this.hZX.va(true);
            this.hZX.au(false, false);
            this.hZX.FE(i);
            this.hZX.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.frs.videomiddlepage.a.15
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                    a.this.cuj();
                    if (a.this.hjj != null) {
                        a.this.hjj.rD();
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                    a.this.cuk();
                    if (a.this.hZX.rF()) {
                    }
                    if (a.this.iad || (a.this.hjj != null && a.this.hjj.rv())) {
                        com.baidu.adp.lib.f.e.mS().removeCallbacks(a.this.iwg);
                        com.baidu.adp.lib.f.e.mS().post(a.this.iwg);
                    }
                    if (a.this.hjj != null) {
                        a.this.hjj.rE();
                    }
                }
            });
            this.hZX.a(new c.l() { // from class: com.baidu.tieba.frs.videomiddlepage.a.16
                @Override // com.baidu.tieba.play.c.l
                public void coM() {
                    if (a.this.hZY != null && a.this.hZY.iay != null && com.baidu.adp.lib.f.b.toInt(a.this.hZY.iay.videoHeight, 0) > com.baidu.adp.lib.f.b.toInt(a.this.hZY.iay.videoWidth, 0)) {
                        a.this.hZX.au(false, false);
                    } else {
                        a.this.hZX.au(true, false);
                    }
                    a.this.iad = false;
                    a.this.Iu(a.this.egB ? "1" : "2");
                    a.this.onClick(a.this.hZK);
                    if (a.this.Yt != null) {
                        a.this.Yt.a(a.this);
                    }
                    if (a.this.ivZ != null) {
                        a.this.ivZ.a(a.this);
                    }
                }

                @Override // com.baidu.tieba.play.c.l
                public void coN() {
                    a.this.onClick(a.this.hZJ);
                }
            });
            this.hZX.a(new c.f() { // from class: com.baidu.tieba.frs.videomiddlepage.a.17
                @Override // com.baidu.tieba.play.c.f
                public void oF(boolean z2) {
                    a.this.hZX.fw(a.this.hZY.iay.videoUrl, a.this.hZY.threadId);
                    a.this.Iu("2");
                    a.this.onClick(a.this.hZK);
                }
            });
            this.hZX.uR(false);
            if (this.ivY != null) {
                this.ivY.reset();
            }
            this.startPosition = -1L;
            if (this.hZX.getVideoView() != null && this.hZX.getVideoView().getMediaProgressObserver() != null) {
                this.hZX.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.frs.videomiddlepage.a.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bX(int i2, int i3) {
                        boolean z2 = true;
                        if (a.this.startPosition <= 0) {
                            a.this.startPosition = i3;
                        }
                        g.a aVar2 = a.this.hZY.iay.iaI;
                        if (aVar2 == null) {
                            if (i3 >= i2) {
                                if (a.this.hjj.a(a.this.isFullScreen, a.this.hZX != null && a.this.hZX.dju(), "VIDEO_LIST")) {
                                }
                            } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                                a.this.hjj.a(a.this.h(gVar));
                            }
                        }
                        if (aVar2 != null && !a.this.isFullScreen && !a.this.hZX.dju() && !com.baidu.mcn.b.SM().hI(aVar2.YI)) {
                            boolean z3 = a.this.startPosition >= (aVar2.iaA * 1000) + 1000;
                            if (i3 < aVar2.iaA * 1000 || i3 >= aVar2.iaB * 1000) {
                                z2 = false;
                            }
                            if (z2) {
                                if (!a.this.ivY.isShowing()) {
                                    com.baidu.mcn.a aVar3 = new com.baidu.mcn.a();
                                    aVar3.bzR = aVar2.iaD;
                                    aVar3.bzS = aVar2.iaE;
                                    aVar3.bzT = aVar2.YI;
                                    aVar3.bzQ = aVar2.iaC;
                                    aVar3.fid = a.this.hZY != null ? a.this.hZY.forumId : null;
                                    aVar3.tid = a.this.hZY != null ? a.this.hZY.threadId : null;
                                    aVar3.bzU = 3;
                                    if (z3) {
                                        a.this.ivY.b(aVar3, (ViewGroup) a.this.hZX.djM());
                                    } else {
                                        a.this.ivY.a(aVar3, (ViewGroup) a.this.hZX.djM());
                                    }
                                }
                            } else if (a.this.ivY.isShowing()) {
                                a.this.ivY.dismiss();
                            }
                        }
                    }
                });
            }
            this.iaa = new o();
            this.iaa.akY = gVar.threadId;
            this.iaa.mNid = gVar.nid;
            this.iaa.eVt = gVar.forumId;
            this.iaa.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iaa.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            this.iaa.mSource = gVar.source;
            this.iaa.ltc = gVar.weight;
            this.iaa.lte = this.mFrom;
            this.iaa.ltg = gVar.abtest_tag;
            this.iaa.dYo = this.dYo;
            this.iaa.mExtra = gVar.extra;
            this.iaa.ltj = "0";
            this.iaa.ltf = gVar.getVideoType();
            this.iab = new o();
            this.iab.akY = gVar.threadId;
            this.iab.eVt = gVar.forumId;
            this.iab.mUid = TbadkCoreApplication.getCurrentAccount();
            this.iab.ltc = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iab.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
            this.iab.lte = this.mFrom;
            this.iab.mSource = gVar.source;
            this.iab.ltj = "0";
            if (gVar.iay != null) {
                this.iaa.lth = gVar.iay.videoMd5;
                this.iab.lth = gVar.iay.videoMd5;
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
            aqVar.dD("obj_id", this.dYo);
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
            this.hZX.getVideoView().setVideoStatData(this.iaa);
            this.hZX.cMQ();
            this.hZX.a(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.3
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    if (!a.this.hjj.a(a.this.isFullScreen, a.this.hZX != null && a.this.hZX.dju(), "VIDEO_LIST")) {
                        if (a.this.isFullScreen) {
                            a.this.iad = true;
                            a.this.ivO = true;
                            a.this.iac = false;
                        }
                        if (aVar != null && !a.this.isFullScreen) {
                            aVar.xA(i);
                            a.this.hZX.czu();
                        }
                    }
                }
            });
            this.hZX.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i2, int i3, Object obj) {
                    if (a.this.hZY != null && a.this.hZY.iay != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.hZY.iay.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            if (!z || !gVar.autoPlay) {
                this.hjj.reset();
            }
            this.hjj.a(new d.a() { // from class: com.baidu.tieba.frs.videomiddlepage.a.5
                @Override // com.baidu.afd.videopaster.d.a
                public void rM() {
                    a.this.ivO = false;
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rL() {
                    if (a.this.isFullScreen) {
                        a.this.iad = true;
                        a.this.ivO = true;
                        a.this.iac = false;
                    }
                    if (aVar != null && !a.this.isFullScreen) {
                        aVar.xA(i);
                        a.this.hZX.czu();
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public void rK() {
                    if (a.this.hZX != null) {
                        a.this.hZX.FD(4);
                    }
                }

                @Override // com.baidu.afd.videopaster.d.a
                public boolean rN() {
                    return a.this.cui();
                }
            });
            this.hZX.setThumbnail(gVar.iay.thumbnailUrl);
            this.hZX.FC(gVar.iay.videoDuration);
            this.hZX.setVideoUrl(gVar.iay.videoUrl, gVar.threadId);
            this.hZX.setFid(gVar.forumId);
            this.hZX.czu();
            this.hZX.show();
            pj(false);
            if (gVar.autoPlay) {
                onClick(this.hZK);
                if (this.ivW.dfs()) {
                    this.hZX.uX(false);
                    this.ivW.dEn();
                    this.hZX.uY(true);
                    this.hZX.fv(gVar.iay.videoUrl, gVar.threadId);
                    if (this.hjj.rv()) {
                        this.hjj.stop();
                        this.hjj.rA();
                    }
                } else {
                    this.hZX.uY(false);
                    this.hZX.uX(false);
                    this.ivW.hide();
                    if (this.hjj == null || (this.hjj != null && !this.hjj.rv())) {
                        this.hZX.a(gVar.iay.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
                    }
                }
                if (i == 0 && gVar.iaz) {
                    this.ivR.setVisibility(8);
                    this.ivV.yY(3);
                } else {
                    if (this.ivR.getVisibility() == 0) {
                        this.ivR.startAnimation(this.bAf);
                    }
                    this.ivV.yY(0);
                }
                gVar.iaz = false;
            } else {
                this.ivR.setVisibility(0);
                this.ivW.hide();
                this.hZX.uX(true);
                this.ivV.yY(3);
                this.hZX.fv(gVar.iay.videoUrl, gVar.threadId);
            }
            this.iad = false;
            this.ivO = false;
            if (!z && this.hjj.rv()) {
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
        com.baidu.afd.videopaster.data.b Jb = this.ivX != null ? this.ivX.Jb(gVar.getThreadId()) : null;
        if (Jb == null) {
            return null;
        }
        int rR = Jb.rR();
        int rS = Jb.rS();
        int rQ = Jb.rQ();
        if (rQ != -1) {
            i = rR != -1 ? (rQ - rR) - 1 : -1;
            if (rS != -1) {
                i4 = (rS - rQ) - 1;
            }
        } else {
            i = -1;
        }
        if (gVar.iay != null) {
            i3 = com.baidu.adp.lib.f.b.toInt(gVar.iay.videoWidth, 0);
            i2 = com.baidu.adp.lib.f.b.toInt(gVar.iay.videoHeight, 0);
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
    public void Iu(String str) {
        if (this.hZY != null && this.hZY.iay != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.hZY.iay.videoMd5, "", str, this.iab, this.hZX.getVideoView().getPcdnState());
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public boolean isPlaying() {
        return this.hZX.rF();
    }

    public boolean cug() {
        return this.hjj.rv();
    }

    public void coI() {
        if (isPlaying()) {
            this.hZX.aHX();
        }
    }

    public boolean xB(int i) {
        if (i == 4 && this.hjj != null && ((this.hjj.rv() || this.ivO) && this.hZX != null)) {
            this.hjj.aV(i);
            if (this.isFullScreen) {
                if (this.hjj.ru()) {
                    this.hZX.djv();
                } else {
                    this.hZX.Oh();
                }
                return true;
            }
        }
        return this.hZX.FD(i);
    }

    public void coJ() {
        this.ivQ = false;
        this.hZX.stopPlay();
        if (this.ivK != null) {
            this.ivK.setVisibility(0);
        }
        if (this.ivV != null) {
            this.ivV.yY(2);
        }
        pj(false);
        this.ivP = true;
        if (this.hjj != null && this.hjj.rv()) {
            this.hjj.stop();
        }
    }

    public void cuh() {
        this.hjj.stop();
    }

    public void coK() {
        if (this.hZX != null) {
            this.hZX.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        coK();
        if (this.hZZ != null) {
            this.hZZ.coU();
        }
        if (this.ivR != null) {
            this.ivR.clearAnimation();
        }
        this.hjj.onDestroy();
    }

    public void i(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && gVar.iax != null) {
            this.aiF.setText(TextUtils.isEmpty(gVar.iax.userNickname) ? gVar.iax.userName : gVar.iax.userNickname);
            j(gVar);
            d(gVar);
            e(gVar);
            k(gVar);
        }
    }

    private void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.iax != null) {
            if (gVar.iax.iaH != null && !TextUtils.isEmpty(gVar.iax.iaH.avatar)) {
                this.hZQ.startLoad(gVar.iax.iaH.avatar, 12, false);
            } else if (!StringUtils.isNull(gVar.iax.portrait) && gVar.iax.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.hZQ.startLoad(gVar.iax.portrait, 10, false);
            } else {
                this.hZQ.startLoad(gVar.iax.portrait, 12, false);
            }
            if (gVar.iax.iaH != null && gVar.iax.iaH.auth_id.intValue() > 0) {
                this.hZQ.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.iax.iaH.auth_id.intValue(), 1));
                this.hZQ.setShowV(true);
                this.hZQ.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.hZQ.setBjhAuthIconRes(0);
            if (gVar.iax.isBigV) {
                this.hZQ.setShowV(gVar.iax.isBigV);
                this.hZQ.setIsBigV(gVar.iax.isBigV);
            } else if (gVar.iax.isGod) {
                this.hZQ.setShowV(gVar.iax.isGod);
                this.hZQ.setIsBigV(gVar.iax.isGod);
            } else {
                this.hZQ.setShowV(gVar.iax.isGod);
                this.hZQ.setIsBigV(gVar.iax.isGod);
            }
            this.hZQ.setGodIconWidth(R.dimen.tbds31);
        }
    }

    public void d(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            if (gVar.bgv() != null) {
                gVar.bgv().isInThread = true;
                gVar.bgv().nid = gVar.nid;
                if (this.hZY.getVideoType() == 1) {
                    gVar.bgv().cardType = 2;
                } else if (this.hZY.getVideoType() == 2) {
                    gVar.bgv().cardType = 8;
                } else if (this.hZY.getVideoType() == 3) {
                    gVar.bgv().cardType = 6;
                }
                gVar.bgv().baijiahaoData = gVar.mBaijiahao;
                gVar.bgv().recomSource = gVar.source;
                gVar.bgv().recomWeight = gVar.weight;
                gVar.bgv().recomAbTag = gVar.abtest_tag;
                gVar.bgv().recomExtra = gVar.extra;
            }
            if (this.hZY.mBaijiahao != null) {
                this.etw.setAgreeAlone(true);
            }
            this.etw.setIsFromMiddlePage(true);
            this.etw.setData(gVar.bgv());
        }
    }

    public void e(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.dTF.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bjq().a(this.etx, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.postNum > 0) {
                this.dTF.setText(at.numFormatOverWan(gVar.postNum));
            } else {
                this.dTF.setText(this.mContext.getString(R.string.reply));
            }
        }
    }

    public void k(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null) {
            this.etz.setTextColor(ap.getColor(R.color.cp_cont_d));
            SvgManager.bjq().a(this.etA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (gVar.shareNum > 0) {
                this.etz.setText(at.numFormatOverWan(gVar.shareNum));
            } else {
                this.etz.setText(this.mContext.getString(R.string.share));
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hZX != null && this.hZK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iac) {
                this.hZX.djB();
            }
            if (configuration.orientation == 2) {
                configuration.orientation = 2;
                cuj();
            } else {
                configuration.orientation = 1;
                cuk();
                this.iac = true;
            }
            this.hZX.a(this.mPageContext, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cui() {
        if (this.hZX != null && this.hZK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.hZK.getParent() != null) {
                if (this.hZK.getParent() == frameLayout) {
                    if (this.iwa) {
                        this.iwa = false;
                        return true;
                    } else if (!this.iwb) {
                        this.iwb = true;
                        return true;
                    }
                } else if (this.hZK.getParent() == this.hZJ) {
                    if (this.iwb) {
                        this.iwb = false;
                        this.iwc = true;
                        return true;
                    } else if (!this.iwa && this.iwc) {
                        this.iwa = true;
                        this.iwc = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuj() {
        if (this.hZX != null && this.hZK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = true;
            if (this.hZK.getParent() != null) {
                if (this.hZK.getParent() == frameLayout) {
                    frameLayout.removeView(this.hZK);
                } else if (this.hZK.getParent() == this.hZJ) {
                    this.hZJ.removeView(this.hZK);
                }
            }
            if (this.hZK.getParent() == null) {
                frameLayout.addView(this.hZK);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZK.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hZK.setLayoutParams(layoutParams);
                if (this.ivY != null && this.ivY.isShowing()) {
                    this.ivY.dismiss();
                }
                com.baidu.tbadk.util.e.bvj().jI(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuk() {
        if (this.hZX != null && this.hZK != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            this.isFullScreen = false;
            if (this.hZK.getParent() != null) {
                if (this.hZK.getParent() == frameLayout) {
                    cul();
                    frameLayout.removeView(this.hZK);
                } else if (this.hZK.getParent() == this.hZJ) {
                    cul();
                    this.hZJ.removeView(this.hZK);
                }
            }
            if (this.hZK.getParent() == null) {
                this.hZJ.addView(this.hZK, 0);
                cum();
                this.hZX.cMQ();
                this.startPosition = -1L;
                com.baidu.tbadk.util.e.bvj().jI(false);
            }
        }
    }

    private void cul() {
        if (this.hjj != null && this.hjj.rv()) {
            this.hjj.aB(true);
        }
    }

    private void cum() {
        int i;
        if (!cue()) {
            i = (int) (0.875f * this.mWidth);
        } else {
            i = (int) (0.5625f * this.mWidth);
        }
        if (i > 0) {
            this.hZK.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (cbz() != null) {
            view.setTag(this);
            cbz().a(view, this.hZY);
        }
        if (view == this.hZQ || view == this.aiF) {
            if (this.hZY != null && this.hZY.iax != null && !TextUtils.isEmpty(this.hZY.iax.userId)) {
                this.ivV.yY(0);
                if (!TbadkCoreApplication.isLogin() || !this.hZY.iax.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hZY.iax.userId, 0L), z, this.hZY.iax.isGod)));
            }
        } else if (view == this.ety) {
            if (this.hZY != null) {
                this.ivV.yY(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.hZY.threadId, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                pbActivityConfig.setBjhData(this.hZY.mBaijiahao);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.ivK || view == this.ivL) {
            if (this.hZY != null) {
                if (this.ivV.getCurrentState() != 2 && this.ivV.getCurrentState() != 3) {
                    z = false;
                }
                this.ivV.yY(0);
                if (!z) {
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.mContext);
                    pbActivityConfig2.createNormalCfg(this.hZY.threadId, null, null);
                    pbActivityConfig2.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                    pbActivityConfig2.setBjhData(this.hZY.mBaijiahao);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig2));
                }
            }
        } else if (view == this.etB) {
            this.ivV.yY(0);
            bkV();
        } else if (view == this.ivR && this.ivR.getVisibility() == 0 && this.ivT != null) {
            this.ivT.zc(this.mPosition);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void oE(boolean z) {
        if (this.hZY != null && this.hZY.iax != null) {
            this.hZY.iax.hasFocus = z;
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void coL() {
        if (this.hZY != null) {
            this.etw.bkg();
        }
    }

    public void pi(boolean z) {
        if (this.hZJ != null) {
            this.hZJ.setVisibility(z ? 0 : 4);
        }
    }

    public void a(com.baidu.tieba.lego.card.view.g gVar) {
        this.ivZ = gVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlayCallBack(com.baidu.tieba.frs.aggregation.a aVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setOnVideoContainerForegroundClickListener(c cVar) {
        this.ivT = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setCurrentPlayCallBack(com.baidu.tieba.lego.card.view.f fVar) {
        this.Yt = fVar;
    }

    private void pj(boolean z) {
        this.ivP = this.mPosition == (this.ivU == null ? -1 : this.ivU.cuy());
        if (this.ivP && z && isPlaying() && this.egB && !this.ivQ) {
            this.ivM.setVisibility(0);
            this.ivQ = true;
            this.ivM.postDelayed(this.iwf, 5000L);
            if (this.ivU != null) {
                this.ivU.eK(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.ivM.setVisibility(8);
        if (this.iwf != null) {
            this.ivM.removeCallbacks(this.iwf);
        }
    }

    private void bkV() {
        String str;
        String str2;
        if (this.hZY != null && this.mContext != null) {
            String valueOf = String.valueOf(this.hZY.forumId);
            String str3 = this.hZY.title;
            if (this.hZY.mBaijiahao != null) {
                str = this.hZY.mBaijiahao.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.hZY.mBaijiahao.oriUgcType + "&dvid=" + this.hZY.mBaijiahao.oriUgcVid + "&nid=" + this.hZY.mBaijiahao.oriUgcNid;
            } else {
                str = this.hZY.threadId;
                str2 = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + str + str2;
            String str5 = this.hZY.iay.thumbnailUrl;
            Uri parse = str5 == null ? null : Uri.parse(str5);
            String str6 = this.hZY.title;
            String format = (this.hZY.mBaijiahao == null || this.hZY.iax == null) ? MessageFormat.format(this.mContext.getResources().getString(R.string.share_content_tpl), str3, str6) : MessageFormat.format(this.mContext.getResources().getString(R.string.default_share_content_tpl), this.hZY.iax.userNickname, this.mContext.getResources().getString(R.string.default_share_content_tpl_suffix));
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            if (this.hZY.mBaijiahao != null) {
                shareItem.eEq = format;
                shareItem.readCount = -1L;
            } else {
                shareItem.eEq = str6;
                shareItem.readCount = this.hZY.playCount;
            }
            shareItem.linkUrl = str4;
            shareItem.extData = str;
            shareItem.eEt = 3;
            shareItem.fid = valueOf;
            shareItem.fName = "";
            shareItem.tid = str;
            shareItem.eEf = true;
            shareItem.eEs = 11;
            if (this.hZY.getVideoType() == 1) {
                shareItem.eEx = 2;
            } else if (this.hZY.getVideoType() == 2) {
                shareItem.eEx = 8;
            } else if (this.hZY.getVideoType() == 3) {
                shareItem.eEx = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.hZY.mBaijiahao != null) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = str5;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = str3;
            originalThreadInfo.threadId = str;
            originalThreadInfo.oriUgcInfo = this.hZY.mBaijiahao;
            shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            aqVar.dD("tid", str);
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.ai("obj_locate", 12);
            aqVar.dD("nid", this.hZY.nid);
            if (this.hZY.mBaijiahao != null && !at.isEmpty(this.hZY.mBaijiahao.oriUgcVid)) {
                aqVar.dD("obj_param6", this.hZY.mBaijiahao.oriUgcVid);
            }
            if (this.hZY.getVideoType() == 1) {
                aqVar.ai(IntentConfig.CARD_TYPE, 2);
            } else if (this.hZY.getVideoType() == 2) {
                aqVar.ai(IntentConfig.CARD_TYPE, 8);
            } else if (this.hZY.getVideoType() == 3) {
                aqVar.ai(IntentConfig.CARD_TYPE, 6);
            }
            aqVar.dD(IntentConfig.RECOM_SOURCE, this.hZY.source);
            aqVar.dD("ab_tag", this.hZY.abtest_tag);
            aqVar.dD("weight", this.hZY.weight);
            aqVar.dD("extra", this.hZY.extra);
            aqVar.dD("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                aqVar.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            TiebaStatic.log(aqVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEt);
            bundle.putInt("obj_type", shareItem.eEx);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeB);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
            com.baidu.tieba.c.f.cdb().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void stopPlay() {
        coJ();
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void aHX() {
        coI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(boolean z) {
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

    public void cun() {
        this.hjj.resume();
    }

    public boolean cuo() {
        if (this.ivV != null) {
            return this.ivV.getCurrentState() == 2 || this.ivV.getCurrentState() == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0691a {
        private int bMb;
        private Runnable iwk;

        private C0691a() {
            this.bMb = -1;
            this.iwk = new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(C0691a.this.iwk);
                    C0691a.this.yY(2);
                }
            };
        }

        public void yY(int i) {
            switch (i) {
                case 0:
                    this.bMb = yZ(i);
                    cup();
                    return;
                case 1:
                    this.bMb = yZ(i);
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iwk);
                    return;
                case 2:
                    this.bMb = za(i);
                    return;
                case 3:
                    this.bMb = zb(i);
                    cup();
                    return;
                default:
                    this.bMb = za(i);
                    return;
            }
        }

        private void cup() {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iwk);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.iwk, IMConnection.RETRY_DELAY_TIMES);
        }

        public int getCurrentState() {
            return this.bMb;
        }

        private int yZ(int i) {
            if (i != this.bMb) {
                a.this.ivS.setVisibility(8);
                a.this.pk(true);
                return i;
            }
            return this.bMb;
        }

        private int za(int i) {
            int i2 = this.bMb;
            if (i != this.bMb) {
                a.this.ivS.setVisibility(0);
                if (i2 != 3 || a.this.hZY.autoPlay) {
                    a.this.pk(false);
                    return i;
                }
                return i;
            }
            return this.bMb;
        }

        private int zb(int i) {
            if (i != this.bMb) {
                a.this.ivS.setVisibility(0);
                a.this.pk(true);
                return i;
            }
            return this.bMb;
        }
    }
}
