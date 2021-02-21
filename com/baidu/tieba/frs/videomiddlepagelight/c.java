package com.baidu.tieba.frs.videomiddlepagelight;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import org.apache.http.HttpHost;
@kotlin.e
/* loaded from: classes2.dex */
public final class c extends com.baidu.tieba.card.b<com.baidu.tieba.frs.aggregation.g> {
    public static final a jPd = new a(null);
    private boolean amB;
    private final RelativeLayout jOA;
    private final HeadImageView jOB;
    private final EMTextView jOC;
    private final TextView jOD;
    private final View.OnClickListener jOE;
    private final FrameLayout jOF;
    private final FrameLayout jOG;
    private final com.baidu.tieba.play.c jOH;
    private final OperableVideoNetworkStateTipView jOI;
    private final RelativeLayout jOJ;
    private final TextView jOK;
    private int jOL;
    private final int jOM;
    private final int jON;
    private final int jOO;
    private final ImageView jOP;
    private final RelativeLayout jOQ;
    private final TextView jOR;
    private final View.OnClickListener jOS;
    private final FrameLayout jOT;
    private final TextView jOU;
    private String jOV;
    private String jOW;
    private SpannableString jOX;
    private final View.OnClickListener jOY;
    private final ThreadCardBottomOpSegmentLayout jOZ;
    private final VideoMiddlePageViewModel jOk;
    private final int jOn;
    private final int jOo;
    private com.baidu.tieba.frs.aggregation.g jOp;
    private cb jOq;
    private int jOr;
    private int jOs;
    private final View.OnClickListener jOt;
    private final RelativeLayout jOu;
    private final BarImageView jOv;
    private final SingleLineEllipsizeTextView jOw;
    private final TextView jOx;
    private final TextView jOy;
    private final View.OnClickListener jOz;
    private final c.p jPa;
    private final c.InterfaceC0849c jPb;
    private final c.o jPc;

    @kotlin.e
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(final TbPageContext<?> tbPageContext, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(tbPageContext);
        p.o(tbPageContext, "pageContext");
        p.o(videoMiddlePageViewModel, "viewModel");
        this.jOk = videoMiddlePageViewModel;
        this.jOn = (int) (l.getEquipmentWidth(tbPageContext.getPageActivity()) * 0.5625d);
        this.jOo = (int) (l.getEquipmentWidth(tbPageContext.getPageActivity()) * 1.0d);
        this.jOs = 1;
        this.jOt = new b(tbPageContext);
        View findViewById = getView().findViewById(R.id.forum_info_layout);
        p.n(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.jOu = (RelativeLayout) findViewById;
        View findViewById2 = getView().findViewById(R.id.forum_info_image);
        p.n(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.jOv = (BarImageView) findViewById2;
        View findViewById3 = getView().findViewById(R.id.forum_info_barname);
        p.n(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.jOw = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = getView().findViewById(R.id.forum_info_author);
        p.n(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.jOx = (TextView) findViewById4;
        View findViewById5 = getView().findViewById(R.id.forum_info_reply_time);
        p.n(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.jOy = (TextView) findViewById5;
        this.jOz = new View$OnClickListenerC0739c(tbPageContext);
        View findViewById6 = getView().findViewById(R.id.user_info_layout);
        p.n(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.jOA = (RelativeLayout) findViewById6;
        View findViewById7 = getView().findViewById(R.id.user_info_avatar);
        p.n(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.jOB = (HeadImageView) findViewById7;
        View findViewById8 = getView().findViewById(R.id.user_info_name);
        p.n(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.jOC = (EMTextView) findViewById8;
        View findViewById9 = getView().findViewById(R.id.user_info_reply_time);
        p.n(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.jOD = (TextView) findViewById9;
        this.jOE = new g(tbPageContext);
        View findViewById10 = getView().findViewById(R.id.video_layout);
        p.n(findViewById10, "view.findViewById(R.id.video_layout)");
        this.jOF = (FrameLayout) findViewById10;
        View findViewById11 = getView().findViewById(R.id.video_container);
        p.n(findViewById11, "view.findViewById(R.id.video_container)");
        this.jOG = (FrameLayout) findViewById11;
        this.jOH = new com.baidu.tieba.play.c(tbPageContext, this.jOG, false);
        View findViewById12 = getView().findViewById(R.id.video_network_state_tip);
        p.n(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.jOI = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = getView().findViewById(R.id.video_info_layout);
        p.n(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.jOJ = (RelativeLayout) findViewById13;
        View findViewById14 = getView().findViewById(R.id.video_info_title);
        p.n(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.jOK = (TextView) findViewById14;
        this.jOM = 1;
        this.jON = 3;
        this.jOO = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jOJ.getPaddingLeft()) - this.jOJ.getPaddingRight();
        View findViewById15 = getView().findViewById(R.id.video_info_expand_title_btn);
        p.n(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.jOP = (ImageView) findViewById15;
        View findViewById16 = getView().findViewById(R.id.video_info_expand_title_btn_wrapper);
        p.n(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.jOQ = (RelativeLayout) findViewById16;
        View findViewById17 = getView().findViewById(R.id.video_info_play_count);
        p.n(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.jOR = (TextView) findViewById17;
        this.jOS = new f();
        View findViewById18 = getView().findViewById(R.id.reply_layout);
        p.n(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.jOT = (FrameLayout) findViewById18;
        View findViewById19 = getView().findViewById(R.id.reply_content);
        p.n(findViewById19, "view.findViewById(R.id.reply_content)");
        this.jOU = (TextView) findViewById19;
        this.jOV = "";
        this.jOW = "";
        this.jOY = new e(tbPageContext);
        View findViewById20 = getView().findViewById(R.id.op_layout);
        p.n(findViewById20, "view.findViewById(R.id.op_layout)");
        this.jOZ = (ThreadCardBottomOpSegmentLayout) findViewById20;
        this.jPa = new i();
        this.jPb = new d(tbPageContext);
        this.jPc = new h();
        this.jOu.setOnClickListener(this.jOz);
        this.jOv.setShowOval(true);
        this.jOv.setAutoChangeStyle(true);
        this.jOv.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.jOv.setStrokeColorResId(R.color.CAM_X0401);
        this.jOv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jOv.setPlaceHolder(1);
        this.jOv.setOnClickListener(this.jOz);
        SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.jOw;
        View view = getView();
        p.n(view, "view");
        singleLineEllipsizeTextView.setEllipsisSuffix(view.getResources().getString(R.string.ellipsis_suffix_bar));
        this.jOw.setOnClickListener(this.jOz);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.jOw.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        this.jOA.setOnClickListener(this.jOE);
        this.jOB.setIsRound(true);
        this.jOB.setPlaceHolder(1);
        this.jOB.setOnClickListener(this.jOE);
        this.jOC.setOnClickListener(this.jOE);
        this.jOH.setStageType("2005");
        this.jOH.xe(true);
        this.jOH.xf(true);
        this.jOH.xm(true);
        this.jOH.xi(true);
        this.jOH.xn(true);
        this.jOH.xf(true);
        this.jOH.ax(false, false);
        this.jOH.xd(false);
        this.jOH.a(this.jPb);
        this.jOH.a(this.jPa);
        this.jOH.a(this.jPc);
        this.jOI.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepagelight.c.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.c cVar;
                c.this.cMI().setVisibility(8);
                c.this.cMI().setHasAgreeToPlay(true);
                c.this.cMH().stopPlay();
                c.this.cMH().xl(false);
                com.baidu.tieba.frs.aggregation.g cMD = c.this.cMD();
                if ((cMD != null ? cMD.jog : null) != null) {
                    com.baidu.tieba.play.c cMH = c.this.cMH();
                    com.baidu.tieba.frs.aggregation.g cMD2 = c.this.cMD();
                    String str = (cMD2 == null || (cVar = cMD2.jog) == null) ? null : cVar.videoUrl;
                    com.baidu.tieba.frs.aggregation.g cMD3 = c.this.cMD();
                    cMH.fX(str, cMD3 != null ? cMD3.threadId : null);
                }
            }
        });
        MutableLiveData<Configuration> cMW = this.jOk.cMW();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        cMW.observe((LifecycleOwner) pageActivity, new Observer<Configuration>() { // from class: com.baidu.tieba.frs.videomiddlepagelight.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: d */
            public final void onChanged(Configuration configuration) {
                Integer value = c.this.cMB().cMV().getValue();
                int cMF = c.this.cMF();
                if (value != null && value.intValue() == cMF && c.this.cMG() != configuration.orientation) {
                    if (configuration.orientation == 2) {
                        c.this.u(tbPageContext);
                    } else {
                        c.this.v(tbPageContext);
                    }
                    c.this.cMH().a(tbPageContext, configuration);
                    c.this.AW(configuration.orientation);
                }
            }
        });
        this.jOJ.setOnClickListener(this.jOt);
        this.jOQ.setOnClickListener(this.jOS);
        this.jOT.setOnClickListener(this.jOY);
        this.jOZ.setReplyTimeVisible(false);
        this.jOZ.setShowPraiseNum(true);
        this.jOZ.setNeedAddPraiseIcon(true);
        this.jOZ.setNeedAddReplyIcon(true);
        this.jOZ.setShareVisible(true);
        this.jOZ.hideDisagree();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        p.n(inst, "TbadkCoreApplication.getInst()");
        onChangeSkinType(tbPageContext, inst.getSkinType());
    }

    public final VideoMiddlePageViewModel cMB() {
        return this.jOk;
    }

    public final com.baidu.tieba.frs.aggregation.g cMD() {
        return this.jOp;
    }

    public final cb cME() {
        return this.jOq;
    }

    public final int cMF() {
        return this.jOr;
    }

    public final void AW(int i2) {
        this.jOs = i2;
    }

    public final int cMG() {
        return this.jOs;
    }

    public final boolean cFC() {
        return this.amB;
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        final /* synthetic */ TbPageContext jPf;

        b(TbPageContext tbPageContext) {
            this.jPf = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.cMD() != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mContext);
                com.baidu.tieba.frs.aggregation.g cMD = c.this.cMD();
                pbActivityConfig.createNormalCfg(cMD != null ? cMD.threadId : null, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                com.baidu.tieba.frs.aggregation.g cMD2 = c.this.cMD();
                pbActivityConfig.setBjhData(cMD2 != null ? cMD2.mBaijiahao : null);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                cb cME = c.this.cME();
                com.baidu.tieba.frs.aggregation.g cMD3 = c.this.cMD();
                com.baidu.tieba.s.c.dMz().b(this.jPf.getUniqueId(), com.baidu.tieba.s.a.a(cME, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, cMD3 != null ? cMD3.iAs : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* renamed from: com.baidu.tieba.frs.videomiddlepagelight.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class View$OnClickListenerC0739c implements View.OnClickListener {
        final /* synthetic */ TbPageContext jPf;

        View$OnClickListenerC0739c(TbPageContext tbPageContext) {
            this.jPf = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            bx bxVar;
            String str;
            bx bxVar2;
            com.baidu.tieba.frs.aggregation.g cMD = c.this.cMD();
            if (cMD == null || (bxVar = cMD.eRo) == null || (str = bxVar.forumName) == null) {
                return;
            }
            if (str.length() > 0) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(c.this.getContext());
                com.baidu.tieba.frs.aggregation.g cMD2 = c.this.cMD();
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg((cMD2 == null || (bxVar2 = cMD2.eRo) == null) ? null : bxVar2.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                cb cME = c.this.cME();
                com.baidu.tieba.frs.aggregation.g cMD3 = c.this.cMD();
                com.baidu.tieba.s.c.dMz().b(this.jPf.getUniqueId(), com.baidu.tieba.s.a.a(cME, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 9, cMD3 != null ? cMD3.iAs : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class g implements View.OnClickListener {
        final /* synthetic */ TbPageContext jPf;

        g(TbPageContext tbPageContext) {
            this.jPf = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.b bVar;
            g.b bVar2;
            g.b bVar3;
            com.baidu.tieba.frs.aggregation.g cMD = c.this.cMD();
            String str = (cMD == null || (bVar3 = cMD.jof) == null) ? null : bVar3.userId;
            com.baidu.tieba.frs.aggregation.g cMD2 = c.this.cMD();
            String str2 = (cMD2 == null || (bVar2 = cMD2.jof) == null) ? null : bVar2.userNickname;
            if (str2 == null || kotlin.text.l.isBlank(str2)) {
                com.baidu.tieba.frs.aggregation.g cMD3 = c.this.cMD();
                str2 = (cMD3 == null || (bVar = cMD3.jof) == null) ? null : bVar.userName;
            }
            if (str != null) {
                if ((!kotlin.text.l.isBlank(str)) && str2 != null) {
                    if (!kotlin.text.l.isBlank(str2)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.getContext(), str, str2)));
                    }
                }
            }
            cb cME = c.this.cME();
            com.baidu.tieba.frs.aggregation.g cMD4 = c.this.cMD();
            com.baidu.tieba.s.c.dMz().b(this.jPf.getUniqueId(), com.baidu.tieba.s.a.a(cME, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, cMD4 != null ? cMD4.iAs : 0, false, (String) null, (String) null));
        }
    }

    public final com.baidu.tieba.play.c cMH() {
        return this.jOH;
    }

    public final OperableVideoNetworkStateTipView cMI() {
        return this.jOI;
    }

    public final int cMJ() {
        return this.jOL;
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.cMJ() == 1) {
                c.this.AX(2);
            } else if (c.this.cMJ() == 2) {
                c.this.AX(1);
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class e implements View.OnClickListener {
        final /* synthetic */ TbPageContext jPf;

        e(TbPageContext tbPageContext) {
            this.jPf = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List<com.baidu.tieba.tbadkCore.data.p> list;
            com.baidu.tieba.tbadkCore.data.p pVar;
            bx bxVar;
            List<com.baidu.tieba.tbadkCore.data.p> list2;
            com.baidu.tieba.tbadkCore.data.p pVar2;
            if (c.this.cMD() != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mContext);
                com.baidu.tieba.frs.aggregation.g cMD = c.this.cMD();
                String str = cMD != null ? cMD.threadId : null;
                com.baidu.tieba.frs.aggregation.g cMD2 = c.this.cMD();
                PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str, (cMD2 == null || (list2 = cMD2.postList) == null || (pVar2 = list2.get(0)) == null || (r0 = pVar2.id) == null) ? "" : "", null);
                createNormalCfg.setStartFrom(24);
                com.baidu.tieba.frs.aggregation.g cMD3 = c.this.cMD();
                createNormalCfg.setForumId(cMD3 != null ? cMD3.forumId : null);
                com.baidu.tieba.frs.aggregation.g cMD4 = c.this.cMD();
                createNormalCfg.setForumName((cMD4 == null || (bxVar = cMD4.eRo) == null) ? null : bxVar.forumName);
                com.baidu.tieba.frs.aggregation.g cMD5 = c.this.cMD();
                createNormalCfg.setHighLightPostId((cMD5 == null || (list = cMD5.postList) == null || (pVar = list.get(0)) == null) ? null : pVar.id);
                createNormalCfg.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                cb cME = c.this.cME();
                com.baidu.tieba.frs.aggregation.g cMD6 = c.this.cMD();
                com.baidu.tieba.s.c.dMz().b(this.jPf.getUniqueId(), com.baidu.tieba.s.a.a(cME, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, cMD6 != null ? cMD6.iAs : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class i implements c.p {
        i() {
        }

        @Override // com.baidu.tieba.play.c.p
        public final void cMQ() {
            int cMF = c.this.cMF();
            Integer value = c.this.cMB().cMV().getValue();
            if (value == null || cMF != value.intValue()) {
                c.this.cMB().AZ(c.this.cMF());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    public static final class d implements c.InterfaceC0849c {
        final /* synthetic */ TbPageContext jPf;

        d(TbPageContext tbPageContext) {
            this.jPf = tbPageContext;
        }

        @Override // com.baidu.tieba.play.c.InterfaceC0849c
        public void rj() {
            if (c.this.cFC()) {
                c.this.u(this.jPf);
            }
        }

        @Override // com.baidu.tieba.play.c.InterfaceC0849c
        public void rk() {
            if (c.this.cFC()) {
                c.this.v(this.jPf);
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    public static final class h implements c.o {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        h() {
        }

        @Override // com.baidu.tieba.play.c.o
        public void onStarted() {
        }

        @Override // com.baidu.tieba.play.c.o
        public void onPrepared() {
        }

        @Override // com.baidu.tieba.play.c.o
        public void onPaused() {
        }

        @Override // com.baidu.tieba.play.c.o
        public void GM() {
            if (c.this.cMG() == 1 && !c.this.cMH().isFullScreen()) {
                c.this.cMB().cMZ();
            }
        }

        @Override // com.baidu.tieba.play.c.o
        public void cMO() {
        }

        @Override // com.baidu.tieba.play.c.o
        public void AY(int i) {
        }

        @Override // com.baidu.tieba.play.c.o
        public void cMP() {
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_video_middle_page_light_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        p.o(tbPageContext, "pageContext");
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ap.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
        int dimens = l.getDimens(getContext(), R.dimen.tbds42);
        a2.setBounds(0, 0, dimens, dimens);
        this.jOw.setCompoundDrawables(null, null, a2, null);
        this.jOw.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
        ap.setViewTextColor(this.jOw, R.color.CAM_X0105);
        ap.setViewTextColor(this.jOx, R.color.CAM_X0109);
        ap.setViewTextColor(this.jOy, R.color.CAM_X0109);
        ap.setViewTextColor(this.jOC, R.color.CAM_X0105);
        ap.setViewTextColor(this.jOD, R.color.CAM_X0109);
        this.jOK.setTextColor(ap.getColor(R.color.CAM_X0105));
        AX(this.jOL);
        this.jOR.setTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.br(this.jOT).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        cMK();
        this.jOZ.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        this.jOH.destroy();
    }

    public final void b(com.baidu.tieba.frs.aggregation.g gVar, int i2) {
        if (gVar != null) {
            this.jOp = gVar;
            this.jOq = com.baidu.tieba.frs.aggregation.g.f(gVar);
            this.jOr = i2;
            this.amB = gVar.cFC();
            r(gVar);
            a(i2, gVar);
            p(gVar);
            o(gVar);
            a(gVar, this.jOq);
        }
    }

    private final boolean a(com.baidu.tieba.frs.aggregation.g gVar, cb cbVar) {
        return this.jOZ.setData(cbVar);
    }

    private final void o(com.baidu.tieba.frs.aggregation.g gVar) {
        String string;
        List<com.baidu.tieba.tbadkCore.data.p> list = gVar.postList;
        if (list != null && !list.isEmpty()) {
            this.jOT.setVisibility(0);
            com.baidu.tieba.tbadkCore.data.p pVar = gVar.postList.get(0);
            MetaData metaData = pVar.nyh;
            if (metaData == null || (string = metaData.getName_show()) == null) {
                string = TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
                p.n(string, "TbadkCoreApplication.get…ng.user_name_default_txt)");
            }
            this.jOV = string;
            this.jOW = (char) 65306 + dG(pVar.eOu);
            this.jOX = new SpannableString(this.jOV + this.jOW);
            cMK();
            return;
        }
        this.jOT.setVisibility(8);
    }

    private final String dG(List<? extends AbstractData> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        VideoMiddlePageLightCardView$getPostContent$1 videoMiddlePageLightCardView$getPostContent$1 = VideoMiddlePageLightCardView$getPostContent$1.INSTANCE;
        for (AbstractData abstractData : list) {
            sb.append(VideoMiddlePageLightCardView$getPostContent$1.INSTANCE.invoke(abstractData));
        }
        String sb2 = sb.toString();
        p.n(sb2, "postContent.toString()");
        return sb2;
    }

    private final void cMK() {
        SpannableString spannableString;
        if (!kotlin.text.l.isBlank(this.jOV)) {
            if (!(this.jOW.length() > 0) || (spannableString = this.jOX) == null) {
                return;
            }
            if (spannableString.length() > 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0108));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0106));
                SpannableString spannableString2 = this.jOX;
                if (spannableString2 != null) {
                    spannableString2.setSpan(foregroundColorSpan, 0, this.jOV.length(), 33);
                }
                SpannableString spannableString3 = this.jOX;
                if (spannableString3 != null) {
                    spannableString3.setSpan(foregroundColorSpan2, this.jOV.length(), this.jOV.length() + this.jOW.length(), 33);
                }
                this.jOU.setText(this.jOX);
            }
        }
    }

    private final void p(com.baidu.tieba.frs.aggregation.g gVar) {
        int i2 = 1;
        String str = gVar.title;
        if (str == null) {
            str = TbadkCoreApplication.getInst().getString(R.string.video_title_str);
        }
        if (this.jOK.getPaint().measureText(str, 0, str.length()) + (this.jOK.getTextSize() * this.jOM) <= this.jOO * this.jOM) {
            i2 = 0;
        } else if (this.jOL == 1 || this.jOL == 2) {
            i2 = this.jOL;
        }
        AX(i2);
        this.jOK.setText(str);
        this.jOR.setText(au.numberUniformFormatExtra(gVar.playCount) + TbadkCoreApplication.getInst().getString(R.string.play));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00fc, code lost:
        if (r0.dSg() != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(int i2, com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jog != null) {
            ViewGroup.LayoutParams layoutParams = this.jOF.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.amB ? this.jOo : this.jOn;
            this.jOF.setLayoutParams(layoutParams2);
            this.jOH.Hm(i2);
            this.jOH.setThumbnail(gVar.jog.thumbnailUrl);
            this.jOH.Hj(3);
            this.jOH.Hk(gVar.jog.videoDuration);
            this.jOH.setVideoUrl(gVar.jog.videoUrl, gVar.threadId);
            this.jOH.setFid(gVar.forumId);
            this.jOH.getVideoView().setVideoStatData(q(gVar));
            this.jOH.cSK();
            this.jOH.show();
            this.jOI.setVideoLength(gVar.jog.videoSize);
            this.jOI.setVideoDuration(gVar.jog.videoDuration);
            this.jOI.setTid(gVar.threadId);
            if (gVar.autoPlay) {
                this.jOH.xk(false);
                if (this.jOI.dvB()) {
                    this.jOI.au(this.amB, this.jOH.isFullScreen());
                    this.jOI.setVisibility(0);
                    this.jOH.xl(true);
                    return;
                }
                this.jOI.setVisibility(8);
                this.jOH.xl(false);
                this.jOH.fX(gVar.jog.videoUrl, gVar.threadId);
                return;
            }
            this.jOI.setVisibility(8);
            if (this.jOH.rl()) {
                this.jOH.stopPlay();
            } else {
                if (!j.isWifiNet()) {
                    com.baidu.tieba.video.f dSf = com.baidu.tieba.video.f.dSf();
                    p.n(dSf, "VideoHolyCardManager.getInstance()");
                }
                this.jOH.dzY();
                this.jOH.stopPlay();
            }
            this.jOH.xk(true);
        }
    }

    private final com.baidu.tieba.play.o q(com.baidu.tieba.frs.aggregation.g gVar) {
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.amC = gVar.threadId;
        oVar.eTz = gVar.nid;
        oVar.fNd = gVar.forumId;
        oVar.mUid = TbadkCoreApplication.getCurrentAccount();
        oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        oVar.mSource = gVar.source;
        oVar.mIv = gVar.weight;
        oVar.mIx = this.jOk.getFrom();
        oVar.mIz = gVar.abtest_tag;
        oVar.eNE = this.jOk.cMY();
        oVar.mExtra = gVar.extra;
        oVar.mIC = this.amB ? "1" : "0";
        oVar.mIy = gVar.getVideoType();
        return oVar;
    }

    private final void r(com.baidu.tieba.frs.aggregation.g gVar) {
        String str;
        String str2;
        String str3 = null;
        if (gVar.getVideoType() == 1 && gVar.eRo != null && (str2 = gVar.eRo.forumName) != null) {
            if (!kotlin.text.l.isBlank(str2)) {
                this.jOu.setVisibility(0);
                this.jOA.setVisibility(8);
                BarImageView barImageView = this.jOv;
                bx bxVar = gVar.eRo;
                barImageView.startLoad(bxVar != null ? bxVar.avatar : null, 10, false);
                SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.jOw;
                String string = getContext().getString(R.string.chosen_pb_original_bar);
                Object[] objArr = new Object[1];
                bx bxVar2 = gVar.eRo;
                objArr[0] = bxVar2 != null ? bxVar2.forumName : null;
                singleLineEllipsizeTextView.setText(String.format(string, objArr));
                TextView textView = this.jOx;
                StringBuilder sb = new StringBuilder();
                g.b bVar = gVar.jof;
                if (TextUtils.isEmpty(bVar != null ? bVar.userNickname : null)) {
                    g.b bVar2 = gVar.jof;
                    if (bVar2 != null) {
                        str3 = bVar2.userName;
                    }
                } else {
                    g.b bVar3 = gVar.jof;
                    if (bVar3 != null) {
                        str3 = bVar3.userNickname;
                    }
                }
                textView.setText(sb.append(str3).append(TbadkCoreApplication.getInst().getString(R.string.home_publish)).toString());
                if (gVar.lastReplyTime > 0) {
                    this.jOy.setVisibility(0);
                    this.jOy.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + au.dZ(gVar.lastReplyTime * 1000));
                    return;
                }
                this.jOy.setVisibility(8);
                return;
            }
        }
        this.jOA.setVisibility(0);
        this.jOu.setVisibility(8);
        g.b bVar4 = gVar.jof;
        p.n(bVar4, "data.author");
        a(bVar4);
        EMTextView eMTextView = this.jOC;
        g.b bVar5 = gVar.jof;
        if (TextUtils.isEmpty(bVar5 != null ? bVar5.userNickname : null)) {
            g.b bVar6 = gVar.jof;
            str = bVar6 != null ? bVar6.userName : null;
        } else {
            g.b bVar7 = gVar.jof;
            str = bVar7 != null ? bVar7.userNickname : null;
        }
        eMTextView.setText(str);
        if (gVar.lastReplyTime > 0) {
            this.jOD.setVisibility(0);
            this.jOD.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + au.dZ(gVar.lastReplyTime * 1000));
            return;
        }
        this.jOD.setVisibility(8);
    }

    private final void a(g.b bVar) {
        if (bVar != null) {
            if (bVar.jop != null && !TextUtils.isEmpty(bVar.jop.avatar)) {
                this.jOB.startLoad(bVar.jop.avatar, 12, false);
            } else {
                if (!StringUtils.isNull(bVar.portrait)) {
                    String str = bVar.portrait;
                    p.n(str, "data.portrait");
                    if (kotlin.text.l.a(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, (Object) null)) {
                        this.jOB.startLoad(bVar.portrait, 10, false);
                    }
                }
                this.jOB.startLoad(bVar.portrait, 12, false);
            }
            if (bVar.jop != null && p.compare(bVar.jop.auth_id.intValue(), 0) > 0) {
                Integer num = bVar.jop.auth_id;
                p.n(num, "data.baijiahaoData.auth_id");
                this.jOB.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(num.intValue(), 1));
                this.jOB.setShowV(true);
                this.jOB.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jOB.setBjhAuthIconRes(0);
            if (bVar.isBigV) {
                this.jOB.setShowV(bVar.isBigV);
                this.jOB.setIsBigV(bVar.isBigV);
            } else if (bVar.isGod) {
                this.jOB.setShowV(bVar.isGod);
                this.jOB.setIsBigV(bVar.isGod);
            } else {
                this.jOB.setShowV(bVar.isGod);
                this.jOB.setIsBigV(bVar.isGod);
            }
            this.jOB.setGodIconWidth(R.dimen.tbds31);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(TbPageContext<?> tbPageContext) {
        Window window;
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
        ((BaseFragmentActivity) pageActivity).setSwipeBackEnabled(false);
        Activity pageActivity2 = tbPageContext.getPageActivity();
        View decorView = (pageActivity2 == null || (window = pageActivity2.getWindow()) == null) ? null : window.getDecorView();
        if (decorView == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        FrameLayout frameLayout = (FrameLayout) decorView;
        if (this.jOG.getParent() != null) {
            if (this.jOG.getParent() == frameLayout) {
                frameLayout.removeView(this.jOG);
            } else if (this.jOG.getParent() == this.jOF) {
                this.jOF.removeView(this.jOG);
            }
        }
        if (this.jOG.getParent() == null) {
            frameLayout.addView(this.jOG);
            ViewGroup.LayoutParams layoutParams = this.jOG.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = -1;
            this.jOG.setLayoutParams(layoutParams2);
            this.jOH.dcv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(TbPageContext<?> tbPageContext) {
        Window window;
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
        ((BaseFragmentActivity) pageActivity).setSwipeBackEnabled(true);
        Activity pageActivity2 = tbPageContext.getPageActivity();
        View decorView = (pageActivity2 == null || (window = pageActivity2.getWindow()) == null) ? null : window.getDecorView();
        if (decorView == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        FrameLayout frameLayout = (FrameLayout) decorView;
        if (this.jOG.getParent() != null) {
            if (this.jOG.getParent() == frameLayout) {
                frameLayout.removeView(this.jOG);
            } else if (this.jOG.getParent() == this.jOF) {
                this.jOF.removeView(this.jOG);
            }
        }
        if (this.jOG.getParent() == null) {
            this.jOF.addView(this.jOG, 0);
            ViewGroup.LayoutParams layoutParams = this.jOG.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.amB ? this.jOo : this.jOn;
            this.jOG.setLayoutParams(layoutParams2);
            this.jOH.dcv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void AX(int i2) {
        this.jOL = i2;
        switch (i2) {
            case 0:
                cML();
                return;
            case 1:
                cMM();
                return;
            case 2:
                cMN();
                return;
            default:
                return;
        }
    }

    private final void cML() {
        this.jOQ.setVisibility(8);
        this.jOK.setEllipsize(null);
        this.jOK.setMaxLines(this.jOM);
    }

    private final void cMM() {
        this.jOQ.setVisibility(0);
        SvgManager.bsR().a(this.jOP, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.jOK.setEllipsize(TextUtils.TruncateAt.END);
        this.jOK.setMaxLines(this.jOM);
    }

    private final void cMN() {
        this.jOQ.setVisibility(0);
        SvgManager.bsR().a(this.jOP, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.jOK.setEllipsize(null);
        this.jOK.setMaxLines(this.jON);
    }
}
