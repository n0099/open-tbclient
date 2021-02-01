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
    public static final a jOP = new a(null);
    private boolean amB;
    private final VideoMiddlePageViewModel jNW;
    private final int jNZ;
    private final int jOA;
    private final ImageView jOB;
    private final RelativeLayout jOC;
    private final TextView jOD;
    private final View.OnClickListener jOE;
    private final FrameLayout jOF;
    private final TextView jOG;
    private String jOH;
    private String jOI;
    private SpannableString jOJ;
    private final View.OnClickListener jOK;
    private final ThreadCardBottomOpSegmentLayout jOL;
    private final c.p jOM;
    private final c.InterfaceC0848c jON;
    private final c.o jOO;
    private final int jOa;
    private com.baidu.tieba.frs.aggregation.g jOb;
    private cb jOc;
    private int jOd;
    private int jOe;
    private final View.OnClickListener jOf;
    private final RelativeLayout jOg;
    private final BarImageView jOh;
    private final SingleLineEllipsizeTextView jOi;
    private final TextView jOj;
    private final TextView jOk;
    private final View.OnClickListener jOl;
    private final RelativeLayout jOm;
    private final HeadImageView jOn;
    private final EMTextView jOo;
    private final TextView jOp;
    private final View.OnClickListener jOq;
    private final FrameLayout jOr;
    private final FrameLayout jOs;
    private final com.baidu.tieba.play.c jOt;
    private final OperableVideoNetworkStateTipView jOu;
    private final RelativeLayout jOv;
    private final TextView jOw;
    private int jOx;
    private final int jOy;
    private final int jOz;

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
        this.jNW = videoMiddlePageViewModel;
        this.jNZ = (int) (l.getEquipmentWidth(tbPageContext.getPageActivity()) * 0.5625d);
        this.jOa = (int) (l.getEquipmentWidth(tbPageContext.getPageActivity()) * 1.0d);
        this.jOe = 1;
        this.jOf = new b(tbPageContext);
        View findViewById = getView().findViewById(R.id.forum_info_layout);
        p.n(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.jOg = (RelativeLayout) findViewById;
        View findViewById2 = getView().findViewById(R.id.forum_info_image);
        p.n(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.jOh = (BarImageView) findViewById2;
        View findViewById3 = getView().findViewById(R.id.forum_info_barname);
        p.n(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.jOi = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = getView().findViewById(R.id.forum_info_author);
        p.n(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.jOj = (TextView) findViewById4;
        View findViewById5 = getView().findViewById(R.id.forum_info_reply_time);
        p.n(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.jOk = (TextView) findViewById5;
        this.jOl = new View$OnClickListenerC0738c(tbPageContext);
        View findViewById6 = getView().findViewById(R.id.user_info_layout);
        p.n(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.jOm = (RelativeLayout) findViewById6;
        View findViewById7 = getView().findViewById(R.id.user_info_avatar);
        p.n(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.jOn = (HeadImageView) findViewById7;
        View findViewById8 = getView().findViewById(R.id.user_info_name);
        p.n(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.jOo = (EMTextView) findViewById8;
        View findViewById9 = getView().findViewById(R.id.user_info_reply_time);
        p.n(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.jOp = (TextView) findViewById9;
        this.jOq = new g(tbPageContext);
        View findViewById10 = getView().findViewById(R.id.video_layout);
        p.n(findViewById10, "view.findViewById(R.id.video_layout)");
        this.jOr = (FrameLayout) findViewById10;
        View findViewById11 = getView().findViewById(R.id.video_container);
        p.n(findViewById11, "view.findViewById(R.id.video_container)");
        this.jOs = (FrameLayout) findViewById11;
        this.jOt = new com.baidu.tieba.play.c(tbPageContext, this.jOs, false);
        View findViewById12 = getView().findViewById(R.id.video_network_state_tip);
        p.n(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.jOu = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = getView().findViewById(R.id.video_info_layout);
        p.n(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.jOv = (RelativeLayout) findViewById13;
        View findViewById14 = getView().findViewById(R.id.video_info_title);
        p.n(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.jOw = (TextView) findViewById14;
        this.jOy = 1;
        this.jOz = 3;
        this.jOA = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jOv.getPaddingLeft()) - this.jOv.getPaddingRight();
        View findViewById15 = getView().findViewById(R.id.video_info_expand_title_btn);
        p.n(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.jOB = (ImageView) findViewById15;
        View findViewById16 = getView().findViewById(R.id.video_info_expand_title_btn_wrapper);
        p.n(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.jOC = (RelativeLayout) findViewById16;
        View findViewById17 = getView().findViewById(R.id.video_info_play_count);
        p.n(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.jOD = (TextView) findViewById17;
        this.jOE = new f();
        View findViewById18 = getView().findViewById(R.id.reply_layout);
        p.n(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.jOF = (FrameLayout) findViewById18;
        View findViewById19 = getView().findViewById(R.id.reply_content);
        p.n(findViewById19, "view.findViewById(R.id.reply_content)");
        this.jOG = (TextView) findViewById19;
        this.jOH = "";
        this.jOI = "";
        this.jOK = new e(tbPageContext);
        View findViewById20 = getView().findViewById(R.id.op_layout);
        p.n(findViewById20, "view.findViewById(R.id.op_layout)");
        this.jOL = (ThreadCardBottomOpSegmentLayout) findViewById20;
        this.jOM = new i();
        this.jON = new d(tbPageContext);
        this.jOO = new h();
        this.jOg.setOnClickListener(this.jOl);
        this.jOh.setShowOval(true);
        this.jOh.setAutoChangeStyle(true);
        this.jOh.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.jOh.setStrokeColorResId(R.color.CAM_X0401);
        this.jOh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jOh.setPlaceHolder(1);
        this.jOh.setOnClickListener(this.jOl);
        SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.jOi;
        View view = getView();
        p.n(view, "view");
        singleLineEllipsizeTextView.setEllipsisSuffix(view.getResources().getString(R.string.ellipsis_suffix_bar));
        this.jOi.setOnClickListener(this.jOl);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.jOi.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        this.jOm.setOnClickListener(this.jOq);
        this.jOn.setIsRound(true);
        this.jOn.setPlaceHolder(1);
        this.jOn.setOnClickListener(this.jOq);
        this.jOo.setOnClickListener(this.jOq);
        this.jOt.setStageType("2005");
        this.jOt.xe(true);
        this.jOt.xf(true);
        this.jOt.xm(true);
        this.jOt.xi(true);
        this.jOt.xn(true);
        this.jOt.xf(true);
        this.jOt.ax(false, false);
        this.jOt.xd(false);
        this.jOt.a(this.jON);
        this.jOt.a(this.jOM);
        this.jOt.a(this.jOO);
        this.jOu.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepagelight.c.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.c cVar;
                c.this.cMB().setVisibility(8);
                c.this.cMB().setHasAgreeToPlay(true);
                c.this.cMA().stopPlay();
                c.this.cMA().xl(false);
                com.baidu.tieba.frs.aggregation.g cMw = c.this.cMw();
                if ((cMw != null ? cMw.jnS : null) != null) {
                    com.baidu.tieba.play.c cMA = c.this.cMA();
                    com.baidu.tieba.frs.aggregation.g cMw2 = c.this.cMw();
                    String str = (cMw2 == null || (cVar = cMw2.jnS) == null) ? null : cVar.videoUrl;
                    com.baidu.tieba.frs.aggregation.g cMw3 = c.this.cMw();
                    cMA.fX(str, cMw3 != null ? cMw3.threadId : null);
                }
            }
        });
        MutableLiveData<Configuration> cMP = this.jNW.cMP();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        cMP.observe((LifecycleOwner) pageActivity, new Observer<Configuration>() { // from class: com.baidu.tieba.frs.videomiddlepagelight.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: d */
            public final void onChanged(Configuration configuration) {
                Integer value = c.this.cMu().cMO().getValue();
                int cMy = c.this.cMy();
                if (value != null && value.intValue() == cMy && c.this.cMz() != configuration.orientation) {
                    if (configuration.orientation == 2) {
                        c.this.u(tbPageContext);
                    } else {
                        c.this.v(tbPageContext);
                    }
                    c.this.cMA().a(tbPageContext, configuration);
                    c.this.AW(configuration.orientation);
                }
            }
        });
        this.jOv.setOnClickListener(this.jOf);
        this.jOC.setOnClickListener(this.jOE);
        this.jOF.setOnClickListener(this.jOK);
        this.jOL.setReplyTimeVisible(false);
        this.jOL.setShowPraiseNum(true);
        this.jOL.setNeedAddPraiseIcon(true);
        this.jOL.setNeedAddReplyIcon(true);
        this.jOL.setShareVisible(true);
        this.jOL.hideDisagree();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        p.n(inst, "TbadkCoreApplication.getInst()");
        onChangeSkinType(tbPageContext, inst.getSkinType());
    }

    public final VideoMiddlePageViewModel cMu() {
        return this.jNW;
    }

    public final com.baidu.tieba.frs.aggregation.g cMw() {
        return this.jOb;
    }

    public final cb cMx() {
        return this.jOc;
    }

    public final int cMy() {
        return this.jOd;
    }

    public final void AW(int i2) {
        this.jOe = i2;
    }

    public final int cMz() {
        return this.jOe;
    }

    public final boolean cFv() {
        return this.amB;
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        final /* synthetic */ TbPageContext jOR;

        b(TbPageContext tbPageContext) {
            this.jOR = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.cMw() != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mContext);
                com.baidu.tieba.frs.aggregation.g cMw = c.this.cMw();
                pbActivityConfig.createNormalCfg(cMw != null ? cMw.threadId : null, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                com.baidu.tieba.frs.aggregation.g cMw2 = c.this.cMw();
                pbActivityConfig.setBjhData(cMw2 != null ? cMw2.mBaijiahao : null);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                cb cMx = c.this.cMx();
                com.baidu.tieba.frs.aggregation.g cMw3 = c.this.cMw();
                com.baidu.tieba.s.c.dMr().b(this.jOR.getUniqueId(), com.baidu.tieba.s.a.a(cMx, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, cMw3 != null ? cMw3.iAe : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* renamed from: com.baidu.tieba.frs.videomiddlepagelight.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class View$OnClickListenerC0738c implements View.OnClickListener {
        final /* synthetic */ TbPageContext jOR;

        View$OnClickListenerC0738c(TbPageContext tbPageContext) {
            this.jOR = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            bx bxVar;
            String str;
            bx bxVar2;
            com.baidu.tieba.frs.aggregation.g cMw = c.this.cMw();
            if (cMw == null || (bxVar = cMw.eRo) == null || (str = bxVar.forumName) == null) {
                return;
            }
            if (str.length() > 0) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(c.this.getContext());
                com.baidu.tieba.frs.aggregation.g cMw2 = c.this.cMw();
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg((cMw2 == null || (bxVar2 = cMw2.eRo) == null) ? null : bxVar2.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                cb cMx = c.this.cMx();
                com.baidu.tieba.frs.aggregation.g cMw3 = c.this.cMw();
                com.baidu.tieba.s.c.dMr().b(this.jOR.getUniqueId(), com.baidu.tieba.s.a.a(cMx, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 9, cMw3 != null ? cMw3.iAe : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class g implements View.OnClickListener {
        final /* synthetic */ TbPageContext jOR;

        g(TbPageContext tbPageContext) {
            this.jOR = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.b bVar;
            g.b bVar2;
            g.b bVar3;
            com.baidu.tieba.frs.aggregation.g cMw = c.this.cMw();
            String str = (cMw == null || (bVar3 = cMw.jnR) == null) ? null : bVar3.userId;
            com.baidu.tieba.frs.aggregation.g cMw2 = c.this.cMw();
            String str2 = (cMw2 == null || (bVar2 = cMw2.jnR) == null) ? null : bVar2.userNickname;
            if (str2 == null || kotlin.text.l.isBlank(str2)) {
                com.baidu.tieba.frs.aggregation.g cMw3 = c.this.cMw();
                str2 = (cMw3 == null || (bVar = cMw3.jnR) == null) ? null : bVar.userName;
            }
            if (str != null) {
                if ((!kotlin.text.l.isBlank(str)) && str2 != null) {
                    if (!kotlin.text.l.isBlank(str2)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.getContext(), str, str2)));
                    }
                }
            }
            cb cMx = c.this.cMx();
            com.baidu.tieba.frs.aggregation.g cMw4 = c.this.cMw();
            com.baidu.tieba.s.c.dMr().b(this.jOR.getUniqueId(), com.baidu.tieba.s.a.a(cMx, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, cMw4 != null ? cMw4.iAe : 0, false, (String) null, (String) null));
        }
    }

    public final com.baidu.tieba.play.c cMA() {
        return this.jOt;
    }

    public final OperableVideoNetworkStateTipView cMB() {
        return this.jOu;
    }

    public final int cMC() {
        return this.jOx;
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.cMC() == 1) {
                c.this.AX(2);
            } else if (c.this.cMC() == 2) {
                c.this.AX(1);
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class e implements View.OnClickListener {
        final /* synthetic */ TbPageContext jOR;

        e(TbPageContext tbPageContext) {
            this.jOR = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List<com.baidu.tieba.tbadkCore.data.p> list;
            com.baidu.tieba.tbadkCore.data.p pVar;
            bx bxVar;
            List<com.baidu.tieba.tbadkCore.data.p> list2;
            com.baidu.tieba.tbadkCore.data.p pVar2;
            if (c.this.cMw() != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mContext);
                com.baidu.tieba.frs.aggregation.g cMw = c.this.cMw();
                String str = cMw != null ? cMw.threadId : null;
                com.baidu.tieba.frs.aggregation.g cMw2 = c.this.cMw();
                PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str, (cMw2 == null || (list2 = cMw2.postList) == null || (pVar2 = list2.get(0)) == null || (r0 = pVar2.id) == null) ? "" : "", null);
                createNormalCfg.setStartFrom(24);
                com.baidu.tieba.frs.aggregation.g cMw3 = c.this.cMw();
                createNormalCfg.setForumId(cMw3 != null ? cMw3.forumId : null);
                com.baidu.tieba.frs.aggregation.g cMw4 = c.this.cMw();
                createNormalCfg.setForumName((cMw4 == null || (bxVar = cMw4.eRo) == null) ? null : bxVar.forumName);
                com.baidu.tieba.frs.aggregation.g cMw5 = c.this.cMw();
                createNormalCfg.setHighLightPostId((cMw5 == null || (list = cMw5.postList) == null || (pVar = list.get(0)) == null) ? null : pVar.id);
                createNormalCfg.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                cb cMx = c.this.cMx();
                com.baidu.tieba.frs.aggregation.g cMw6 = c.this.cMw();
                com.baidu.tieba.s.c.dMr().b(this.jOR.getUniqueId(), com.baidu.tieba.s.a.a(cMx, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, cMw6 != null ? cMw6.iAe : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class i implements c.p {
        i() {
        }

        @Override // com.baidu.tieba.play.c.p
        public final void cMJ() {
            int cMy = c.this.cMy();
            Integer value = c.this.cMu().cMO().getValue();
            if (value == null || cMy != value.intValue()) {
                c.this.cMu().AZ(c.this.cMy());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    public static final class d implements c.InterfaceC0848c {
        final /* synthetic */ TbPageContext jOR;

        d(TbPageContext tbPageContext) {
            this.jOR = tbPageContext;
        }

        @Override // com.baidu.tieba.play.c.InterfaceC0848c
        public void rj() {
            if (c.this.cFv()) {
                c.this.u(this.jOR);
            }
        }

        @Override // com.baidu.tieba.play.c.InterfaceC0848c
        public void rk() {
            if (c.this.cFv()) {
                c.this.v(this.jOR);
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
            if (c.this.cMz() == 1 && !c.this.cMA().isFullScreen()) {
                c.this.cMu().cMS();
            }
        }

        @Override // com.baidu.tieba.play.c.o
        public void cMH() {
        }

        @Override // com.baidu.tieba.play.c.o
        public void AY(int i) {
        }

        @Override // com.baidu.tieba.play.c.o
        public void cMI() {
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
        this.jOi.setCompoundDrawables(null, null, a2, null);
        this.jOi.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
        ap.setViewTextColor(this.jOi, R.color.CAM_X0105);
        ap.setViewTextColor(this.jOj, R.color.CAM_X0109);
        ap.setViewTextColor(this.jOk, R.color.CAM_X0109);
        ap.setViewTextColor(this.jOo, R.color.CAM_X0105);
        ap.setViewTextColor(this.jOp, R.color.CAM_X0109);
        this.jOw.setTextColor(ap.getColor(R.color.CAM_X0105));
        AX(this.jOx);
        this.jOD.setTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.br(this.jOF).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        cMD();
        this.jOL.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        this.jOt.destroy();
    }

    public final void b(com.baidu.tieba.frs.aggregation.g gVar, int i2) {
        if (gVar != null) {
            this.jOb = gVar;
            this.jOc = com.baidu.tieba.frs.aggregation.g.f(gVar);
            this.jOd = i2;
            this.amB = gVar.cFv();
            r(gVar);
            a(i2, gVar);
            p(gVar);
            o(gVar);
            a(gVar, this.jOc);
        }
    }

    private final boolean a(com.baidu.tieba.frs.aggregation.g gVar, cb cbVar) {
        return this.jOL.setData(cbVar);
    }

    private final void o(com.baidu.tieba.frs.aggregation.g gVar) {
        String string;
        List<com.baidu.tieba.tbadkCore.data.p> list = gVar.postList;
        if (list != null && !list.isEmpty()) {
            this.jOF.setVisibility(0);
            com.baidu.tieba.tbadkCore.data.p pVar = gVar.postList.get(0);
            MetaData metaData = pVar.nxH;
            if (metaData == null || (string = metaData.getName_show()) == null) {
                string = TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
                p.n(string, "TbadkCoreApplication.get…ng.user_name_default_txt)");
            }
            this.jOH = string;
            this.jOI = (char) 65306 + dG(pVar.eOu);
            this.jOJ = new SpannableString(this.jOH + this.jOI);
            cMD();
            return;
        }
        this.jOF.setVisibility(8);
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

    private final void cMD() {
        SpannableString spannableString;
        if (!kotlin.text.l.isBlank(this.jOH)) {
            if (!(this.jOI.length() > 0) || (spannableString = this.jOJ) == null) {
                return;
            }
            if (spannableString.length() > 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0108));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0106));
                SpannableString spannableString2 = this.jOJ;
                if (spannableString2 != null) {
                    spannableString2.setSpan(foregroundColorSpan, 0, this.jOH.length(), 33);
                }
                SpannableString spannableString3 = this.jOJ;
                if (spannableString3 != null) {
                    spannableString3.setSpan(foregroundColorSpan2, this.jOH.length(), this.jOH.length() + this.jOI.length(), 33);
                }
                this.jOG.setText(this.jOJ);
            }
        }
    }

    private final void p(com.baidu.tieba.frs.aggregation.g gVar) {
        int i2 = 1;
        String str = gVar.title;
        if (str == null) {
            str = TbadkCoreApplication.getInst().getString(R.string.video_title_str);
        }
        if (this.jOw.getPaint().measureText(str, 0, str.length()) + (this.jOw.getTextSize() * this.jOy) <= this.jOA * this.jOy) {
            i2 = 0;
        } else if (this.jOx == 1 || this.jOx == 2) {
            i2 = this.jOx;
        }
        AX(i2);
        this.jOw.setText(str);
        this.jOD.setText(au.numberUniformFormatExtra(gVar.playCount) + TbadkCoreApplication.getInst().getString(R.string.play));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00fc, code lost:
        if (r0.dRY() != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(int i2, com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jnS != null) {
            ViewGroup.LayoutParams layoutParams = this.jOr.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.amB ? this.jOa : this.jNZ;
            this.jOr.setLayoutParams(layoutParams2);
            this.jOt.Hm(i2);
            this.jOt.setThumbnail(gVar.jnS.thumbnailUrl);
            this.jOt.Hj(3);
            this.jOt.Hk(gVar.jnS.videoDuration);
            this.jOt.setVideoUrl(gVar.jnS.videoUrl, gVar.threadId);
            this.jOt.setFid(gVar.forumId);
            this.jOt.getVideoView().setVideoStatData(q(gVar));
            this.jOt.cSD();
            this.jOt.show();
            this.jOu.setVideoLength(gVar.jnS.videoSize);
            this.jOu.setVideoDuration(gVar.jnS.videoDuration);
            this.jOu.setTid(gVar.threadId);
            if (gVar.autoPlay) {
                this.jOt.xk(false);
                if (this.jOu.dvu()) {
                    this.jOu.au(this.amB, this.jOt.isFullScreen());
                    this.jOu.setVisibility(0);
                    this.jOt.xl(true);
                    return;
                }
                this.jOu.setVisibility(8);
                this.jOt.xl(false);
                this.jOt.fX(gVar.jnS.videoUrl, gVar.threadId);
                return;
            }
            this.jOu.setVisibility(8);
            if (this.jOt.rl()) {
                this.jOt.stopPlay();
            } else {
                if (!j.isWifiNet()) {
                    com.baidu.tieba.video.f dRX = com.baidu.tieba.video.f.dRX();
                    p.n(dRX, "VideoHolyCardManager.getInstance()");
                }
                this.jOt.dzR();
                this.jOt.stopPlay();
            }
            this.jOt.xk(true);
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
        oVar.mIe = gVar.weight;
        oVar.mIg = this.jNW.getFrom();
        oVar.mIi = gVar.abtest_tag;
        oVar.eNE = this.jNW.cMR();
        oVar.mExtra = gVar.extra;
        oVar.mIl = this.amB ? "1" : "0";
        oVar.mIh = gVar.getVideoType();
        return oVar;
    }

    private final void r(com.baidu.tieba.frs.aggregation.g gVar) {
        String str;
        String str2;
        String str3 = null;
        if (gVar.getVideoType() == 1 && gVar.eRo != null && (str2 = gVar.eRo.forumName) != null) {
            if (!kotlin.text.l.isBlank(str2)) {
                this.jOg.setVisibility(0);
                this.jOm.setVisibility(8);
                BarImageView barImageView = this.jOh;
                bx bxVar = gVar.eRo;
                barImageView.startLoad(bxVar != null ? bxVar.avatar : null, 10, false);
                SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.jOi;
                String string = getContext().getString(R.string.chosen_pb_original_bar);
                Object[] objArr = new Object[1];
                bx bxVar2 = gVar.eRo;
                objArr[0] = bxVar2 != null ? bxVar2.forumName : null;
                singleLineEllipsizeTextView.setText(String.format(string, objArr));
                TextView textView = this.jOj;
                StringBuilder sb = new StringBuilder();
                g.b bVar = gVar.jnR;
                if (TextUtils.isEmpty(bVar != null ? bVar.userNickname : null)) {
                    g.b bVar2 = gVar.jnR;
                    if (bVar2 != null) {
                        str3 = bVar2.userName;
                    }
                } else {
                    g.b bVar3 = gVar.jnR;
                    if (bVar3 != null) {
                        str3 = bVar3.userNickname;
                    }
                }
                textView.setText(sb.append(str3).append(TbadkCoreApplication.getInst().getString(R.string.home_publish)).toString());
                if (gVar.lastReplyTime > 0) {
                    this.jOk.setVisibility(0);
                    this.jOk.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + au.dZ(gVar.lastReplyTime * 1000));
                    return;
                }
                this.jOk.setVisibility(8);
                return;
            }
        }
        this.jOm.setVisibility(0);
        this.jOg.setVisibility(8);
        g.b bVar4 = gVar.jnR;
        p.n(bVar4, "data.author");
        a(bVar4);
        EMTextView eMTextView = this.jOo;
        g.b bVar5 = gVar.jnR;
        if (TextUtils.isEmpty(bVar5 != null ? bVar5.userNickname : null)) {
            g.b bVar6 = gVar.jnR;
            str = bVar6 != null ? bVar6.userName : null;
        } else {
            g.b bVar7 = gVar.jnR;
            str = bVar7 != null ? bVar7.userNickname : null;
        }
        eMTextView.setText(str);
        if (gVar.lastReplyTime > 0) {
            this.jOp.setVisibility(0);
            this.jOp.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + au.dZ(gVar.lastReplyTime * 1000));
            return;
        }
        this.jOp.setVisibility(8);
    }

    private final void a(g.b bVar) {
        if (bVar != null) {
            if (bVar.job != null && !TextUtils.isEmpty(bVar.job.avatar)) {
                this.jOn.startLoad(bVar.job.avatar, 12, false);
            } else {
                if (!StringUtils.isNull(bVar.portrait)) {
                    String str = bVar.portrait;
                    p.n(str, "data.portrait");
                    if (kotlin.text.l.a(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, (Object) null)) {
                        this.jOn.startLoad(bVar.portrait, 10, false);
                    }
                }
                this.jOn.startLoad(bVar.portrait, 12, false);
            }
            if (bVar.job != null && p.compare(bVar.job.auth_id.intValue(), 0) > 0) {
                Integer num = bVar.job.auth_id;
                p.n(num, "data.baijiahaoData.auth_id");
                this.jOn.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(num.intValue(), 1));
                this.jOn.setShowV(true);
                this.jOn.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jOn.setBjhAuthIconRes(0);
            if (bVar.isBigV) {
                this.jOn.setShowV(bVar.isBigV);
                this.jOn.setIsBigV(bVar.isBigV);
            } else if (bVar.isGod) {
                this.jOn.setShowV(bVar.isGod);
                this.jOn.setIsBigV(bVar.isGod);
            } else {
                this.jOn.setShowV(bVar.isGod);
                this.jOn.setIsBigV(bVar.isGod);
            }
            this.jOn.setGodIconWidth(R.dimen.tbds31);
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
        if (this.jOs.getParent() != null) {
            if (this.jOs.getParent() == frameLayout) {
                frameLayout.removeView(this.jOs);
            } else if (this.jOs.getParent() == this.jOr) {
                this.jOr.removeView(this.jOs);
            }
        }
        if (this.jOs.getParent() == null) {
            frameLayout.addView(this.jOs);
            ViewGroup.LayoutParams layoutParams = this.jOs.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = -1;
            this.jOs.setLayoutParams(layoutParams2);
            this.jOt.dco();
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
        if (this.jOs.getParent() != null) {
            if (this.jOs.getParent() == frameLayout) {
                frameLayout.removeView(this.jOs);
            } else if (this.jOs.getParent() == this.jOr) {
                this.jOr.removeView(this.jOs);
            }
        }
        if (this.jOs.getParent() == null) {
            this.jOr.addView(this.jOs, 0);
            ViewGroup.LayoutParams layoutParams = this.jOs.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.amB ? this.jOa : this.jNZ;
            this.jOs.setLayoutParams(layoutParams2);
            this.jOt.dco();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void AX(int i2) {
        this.jOx = i2;
        switch (i2) {
            case 0:
                cME();
                return;
            case 1:
                cMF();
                return;
            case 2:
                cMG();
                return;
            default:
                return;
        }
    }

    private final void cME() {
        this.jOC.setVisibility(8);
        this.jOw.setEllipsize(null);
        this.jOw.setMaxLines(this.jOy);
    }

    private final void cMF() {
        this.jOC.setVisibility(0);
        SvgManager.bsR().a(this.jOB, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.jOw.setEllipsize(TextUtils.TruncateAt.END);
        this.jOw.setMaxLines(this.jOy);
    }

    private final void cMG() {
        this.jOC.setVisibility(0);
        SvgManager.bsR().a(this.jOB, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.jOw.setEllipsize(null);
        this.jOw.setMaxLines(this.jOz);
    }
}
