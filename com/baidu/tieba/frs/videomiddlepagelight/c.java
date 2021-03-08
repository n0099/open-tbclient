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
    public static final a jQM = new a(null);
    private boolean anT;
    private final VideoMiddlePageViewModel jPT;
    private final int jPW;
    private final int jPX;
    private com.baidu.tieba.frs.aggregation.g jPY;
    private cb jPZ;
    private final TextView jQA;
    private final View.OnClickListener jQB;
    private final FrameLayout jQC;
    private final TextView jQD;
    private String jQE;
    private String jQF;
    private SpannableString jQG;
    private final View.OnClickListener jQH;
    private final ThreadCardBottomOpSegmentLayout jQI;
    private final c.p jQJ;
    private final c.InterfaceC0855c jQK;
    private final c.o jQL;
    private int jQa;
    private int jQb;
    private final View.OnClickListener jQc;
    private final RelativeLayout jQd;
    private final BarImageView jQe;
    private final SingleLineEllipsizeTextView jQf;
    private final TextView jQg;
    private final TextView jQh;
    private final View.OnClickListener jQi;
    private final RelativeLayout jQj;
    private final HeadImageView jQk;
    private final EMTextView jQl;
    private final TextView jQm;
    private final View.OnClickListener jQn;
    private final FrameLayout jQo;
    private final FrameLayout jQp;
    private final com.baidu.tieba.play.c jQq;
    private final OperableVideoNetworkStateTipView jQr;
    private final RelativeLayout jQs;
    private final TextView jQt;
    private int jQu;
    private final int jQv;
    private final int jQw;
    private final int jQx;
    private final ImageView jQy;
    private final RelativeLayout jQz;

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
        p.p(tbPageContext, "pageContext");
        p.p(videoMiddlePageViewModel, "viewModel");
        this.jPT = videoMiddlePageViewModel;
        this.jPW = (int) (l.getEquipmentWidth(tbPageContext.getPageActivity()) * 0.5625d);
        this.jPX = (int) (l.getEquipmentWidth(tbPageContext.getPageActivity()) * 1.0d);
        this.jQb = 1;
        this.jQc = new b(tbPageContext);
        View findViewById = getView().findViewById(R.id.forum_info_layout);
        p.o(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.jQd = (RelativeLayout) findViewById;
        View findViewById2 = getView().findViewById(R.id.forum_info_image);
        p.o(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.jQe = (BarImageView) findViewById2;
        View findViewById3 = getView().findViewById(R.id.forum_info_barname);
        p.o(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.jQf = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = getView().findViewById(R.id.forum_info_author);
        p.o(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.jQg = (TextView) findViewById4;
        View findViewById5 = getView().findViewById(R.id.forum_info_reply_time);
        p.o(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.jQh = (TextView) findViewById5;
        this.jQi = new View$OnClickListenerC0745c(tbPageContext);
        View findViewById6 = getView().findViewById(R.id.user_info_layout);
        p.o(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.jQj = (RelativeLayout) findViewById6;
        View findViewById7 = getView().findViewById(R.id.user_info_avatar);
        p.o(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.jQk = (HeadImageView) findViewById7;
        View findViewById8 = getView().findViewById(R.id.user_info_name);
        p.o(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.jQl = (EMTextView) findViewById8;
        View findViewById9 = getView().findViewById(R.id.user_info_reply_time);
        p.o(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.jQm = (TextView) findViewById9;
        this.jQn = new g(tbPageContext);
        View findViewById10 = getView().findViewById(R.id.video_layout);
        p.o(findViewById10, "view.findViewById(R.id.video_layout)");
        this.jQo = (FrameLayout) findViewById10;
        View findViewById11 = getView().findViewById(R.id.video_container);
        p.o(findViewById11, "view.findViewById(R.id.video_container)");
        this.jQp = (FrameLayout) findViewById11;
        this.jQq = new com.baidu.tieba.play.c(tbPageContext, this.jQp, false);
        View findViewById12 = getView().findViewById(R.id.video_network_state_tip);
        p.o(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.jQr = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = getView().findViewById(R.id.video_info_layout);
        p.o(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.jQs = (RelativeLayout) findViewById13;
        View findViewById14 = getView().findViewById(R.id.video_info_title);
        p.o(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.jQt = (TextView) findViewById14;
        this.jQv = 1;
        this.jQw = 3;
        this.jQx = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.jQs.getPaddingLeft()) - this.jQs.getPaddingRight();
        View findViewById15 = getView().findViewById(R.id.video_info_expand_title_btn);
        p.o(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.jQy = (ImageView) findViewById15;
        View findViewById16 = getView().findViewById(R.id.video_info_expand_title_btn_wrapper);
        p.o(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.jQz = (RelativeLayout) findViewById16;
        View findViewById17 = getView().findViewById(R.id.video_info_play_count);
        p.o(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.jQA = (TextView) findViewById17;
        this.jQB = new f();
        View findViewById18 = getView().findViewById(R.id.reply_layout);
        p.o(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.jQC = (FrameLayout) findViewById18;
        View findViewById19 = getView().findViewById(R.id.reply_content);
        p.o(findViewById19, "view.findViewById(R.id.reply_content)");
        this.jQD = (TextView) findViewById19;
        this.jQE = "";
        this.jQF = "";
        this.jQH = new e(tbPageContext);
        View findViewById20 = getView().findViewById(R.id.op_layout);
        p.o(findViewById20, "view.findViewById(R.id.op_layout)");
        this.jQI = (ThreadCardBottomOpSegmentLayout) findViewById20;
        this.jQJ = new i();
        this.jQK = new d(tbPageContext);
        this.jQL = new h();
        this.jQd.setOnClickListener(this.jQi);
        this.jQe.setShowOval(true);
        this.jQe.setAutoChangeStyle(true);
        this.jQe.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.jQe.setStrokeColorResId(R.color.CAM_X0401);
        this.jQe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jQe.setPlaceHolder(1);
        this.jQe.setOnClickListener(this.jQi);
        SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.jQf;
        View view = getView();
        p.o(view, "view");
        singleLineEllipsizeTextView.setEllipsisSuffix(view.getResources().getString(R.string.ellipsis_suffix_bar));
        this.jQf.setOnClickListener(this.jQi);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.jQf.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        this.jQj.setOnClickListener(this.jQn);
        this.jQk.setIsRound(true);
        this.jQk.setPlaceHolder(1);
        this.jQk.setOnClickListener(this.jQn);
        this.jQl.setOnClickListener(this.jQn);
        this.jQq.setStageType("2005");
        this.jQq.xe(true);
        this.jQq.xf(true);
        this.jQq.xm(true);
        this.jQq.xi(true);
        this.jQq.xn(true);
        this.jQq.xf(true);
        this.jQq.ax(false, false);
        this.jQq.xd(false);
        this.jQq.a(this.jQK);
        this.jQq.a(this.jQJ);
        this.jQq.a(this.jQL);
        this.jQr.setPlayViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepagelight.c.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.c cVar;
                c.this.cMO().setVisibility(8);
                c.this.cMO().setHasAgreeToPlay(true);
                c.this.cMN().stopPlay();
                c.this.cMN().xl(false);
                com.baidu.tieba.frs.aggregation.g cMJ = c.this.cMJ();
                if ((cMJ != null ? cMJ.jpP : null) != null) {
                    com.baidu.tieba.play.c cMN = c.this.cMN();
                    com.baidu.tieba.frs.aggregation.g cMJ2 = c.this.cMJ();
                    String str = (cMJ2 == null || (cVar = cMJ2.jpP) == null) ? null : cVar.videoUrl;
                    com.baidu.tieba.frs.aggregation.g cMJ3 = c.this.cMJ();
                    cMN.fX(str, cMJ3 != null ? cMJ3.threadId : null);
                }
            }
        });
        MutableLiveData<Configuration> cNc = this.jPT.cNc();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        cNc.observe((LifecycleOwner) pageActivity, new Observer<Configuration>() { // from class: com.baidu.tieba.frs.videomiddlepagelight.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: d */
            public final void onChanged(Configuration configuration) {
                Integer value = c.this.cMH().cNb().getValue();
                int cML = c.this.cML();
                if (value != null && value.intValue() == cML && c.this.cMM() != configuration.orientation) {
                    if (configuration.orientation == 2) {
                        c.this.u(tbPageContext);
                    } else {
                        c.this.v(tbPageContext);
                    }
                    c.this.cMN().a(tbPageContext, configuration);
                    c.this.AX(configuration.orientation);
                }
            }
        });
        this.jQs.setOnClickListener(this.jQc);
        this.jQz.setOnClickListener(this.jQB);
        this.jQC.setOnClickListener(this.jQH);
        this.jQI.setReplyTimeVisible(false);
        this.jQI.setShowPraiseNum(true);
        this.jQI.setNeedAddPraiseIcon(true);
        this.jQI.setNeedAddReplyIcon(true);
        this.jQI.setShareVisible(true);
        this.jQI.hideDisagree();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        p.o(inst, "TbadkCoreApplication.getInst()");
        onChangeSkinType(tbPageContext, inst.getSkinType());
    }

    public final VideoMiddlePageViewModel cMH() {
        return this.jPT;
    }

    public final com.baidu.tieba.frs.aggregation.g cMJ() {
        return this.jPY;
    }

    public final cb cMK() {
        return this.jPZ;
    }

    public final int cML() {
        return this.jQa;
    }

    public final void AX(int i2) {
        this.jQb = i2;
    }

    public final int cMM() {
        return this.jQb;
    }

    public final boolean cFI() {
        return this.anT;
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        final /* synthetic */ TbPageContext jQO;

        b(TbPageContext tbPageContext) {
            this.jQO = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.cMJ() != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mContext);
                com.baidu.tieba.frs.aggregation.g cMJ = c.this.cMJ();
                pbActivityConfig.createNormalCfg(cMJ != null ? cMJ.threadId : null, null, null);
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                com.baidu.tieba.frs.aggregation.g cMJ2 = c.this.cMJ();
                pbActivityConfig.setBjhData(cMJ2 != null ? cMJ2.mBaijiahao : null);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                cb cMK = c.this.cMK();
                com.baidu.tieba.frs.aggregation.g cMJ3 = c.this.cMJ();
                com.baidu.tieba.s.c.dMH().b(this.jQO.getUniqueId(), com.baidu.tieba.s.a.a(cMK, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, cMJ3 != null ? cMJ3.iCb : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* renamed from: com.baidu.tieba.frs.videomiddlepagelight.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class View$OnClickListenerC0745c implements View.OnClickListener {
        final /* synthetic */ TbPageContext jQO;

        View$OnClickListenerC0745c(TbPageContext tbPageContext) {
            this.jQO = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            bx bxVar;
            String str;
            bx bxVar2;
            com.baidu.tieba.frs.aggregation.g cMJ = c.this.cMJ();
            if (cMJ == null || (bxVar = cMJ.eSP) == null || (str = bxVar.forumName) == null) {
                return;
            }
            if (str.length() > 0) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(c.this.getContext());
                com.baidu.tieba.frs.aggregation.g cMJ2 = c.this.cMJ();
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg((cMJ2 == null || (bxVar2 = cMJ2.eSP) == null) ? null : bxVar2.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                cb cMK = c.this.cMK();
                com.baidu.tieba.frs.aggregation.g cMJ3 = c.this.cMJ();
                com.baidu.tieba.s.c.dMH().b(this.jQO.getUniqueId(), com.baidu.tieba.s.a.a(cMK, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 9, cMJ3 != null ? cMJ3.iCb : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class g implements View.OnClickListener {
        final /* synthetic */ TbPageContext jQO;

        g(TbPageContext tbPageContext) {
            this.jQO = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.b bVar;
            g.b bVar2;
            g.b bVar3;
            com.baidu.tieba.frs.aggregation.g cMJ = c.this.cMJ();
            String str = (cMJ == null || (bVar3 = cMJ.jpO) == null) ? null : bVar3.userId;
            com.baidu.tieba.frs.aggregation.g cMJ2 = c.this.cMJ();
            String str2 = (cMJ2 == null || (bVar2 = cMJ2.jpO) == null) ? null : bVar2.userNickname;
            if (str2 == null || kotlin.text.l.isBlank(str2)) {
                com.baidu.tieba.frs.aggregation.g cMJ3 = c.this.cMJ();
                str2 = (cMJ3 == null || (bVar = cMJ3.jpO) == null) ? null : bVar.userName;
            }
            if (str != null) {
                if ((!kotlin.text.l.isBlank(str)) && str2 != null) {
                    if (!kotlin.text.l.isBlank(str2)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.getContext(), str, str2)));
                    }
                }
            }
            cb cMK = c.this.cMK();
            com.baidu.tieba.frs.aggregation.g cMJ4 = c.this.cMJ();
            com.baidu.tieba.s.c.dMH().b(this.jQO.getUniqueId(), com.baidu.tieba.s.a.a(cMK, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, cMJ4 != null ? cMJ4.iCb : 0, false, (String) null, (String) null));
        }
    }

    public final com.baidu.tieba.play.c cMN() {
        return this.jQq;
    }

    public final OperableVideoNetworkStateTipView cMO() {
        return this.jQr;
    }

    public final int cMP() {
        return this.jQu;
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.cMP() == 1) {
                c.this.AY(2);
            } else if (c.this.cMP() == 2) {
                c.this.AY(1);
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class e implements View.OnClickListener {
        final /* synthetic */ TbPageContext jQO;

        e(TbPageContext tbPageContext) {
            this.jQO = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List<com.baidu.tieba.tbadkCore.data.p> list;
            com.baidu.tieba.tbadkCore.data.p pVar;
            bx bxVar;
            List<com.baidu.tieba.tbadkCore.data.p> list2;
            com.baidu.tieba.tbadkCore.data.p pVar2;
            if (c.this.cMJ() != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mContext);
                com.baidu.tieba.frs.aggregation.g cMJ = c.this.cMJ();
                String str = cMJ != null ? cMJ.threadId : null;
                com.baidu.tieba.frs.aggregation.g cMJ2 = c.this.cMJ();
                PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str, (cMJ2 == null || (list2 = cMJ2.postList) == null || (pVar2 = list2.get(0)) == null || (r0 = pVar2.id) == null) ? "" : "", null);
                createNormalCfg.setStartFrom(24);
                com.baidu.tieba.frs.aggregation.g cMJ3 = c.this.cMJ();
                createNormalCfg.setForumId(cMJ3 != null ? cMJ3.forumId : null);
                com.baidu.tieba.frs.aggregation.g cMJ4 = c.this.cMJ();
                createNormalCfg.setForumName((cMJ4 == null || (bxVar = cMJ4.eSP) == null) ? null : bxVar.forumName);
                com.baidu.tieba.frs.aggregation.g cMJ5 = c.this.cMJ();
                createNormalCfg.setHighLightPostId((cMJ5 == null || (list = cMJ5.postList) == null || (pVar = list.get(0)) == null) ? null : pVar.id);
                createNormalCfg.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                cb cMK = c.this.cMK();
                com.baidu.tieba.frs.aggregation.g cMJ6 = c.this.cMJ();
                com.baidu.tieba.s.c.dMH().b(this.jQO.getUniqueId(), com.baidu.tieba.s.a.a(cMK, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, cMJ6 != null ? cMJ6.iCb : 0, false, (String) null, (String) null));
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    static final class i implements c.p {
        i() {
        }

        @Override // com.baidu.tieba.play.c.p
        public final void cMW() {
            int cML = c.this.cML();
            Integer value = c.this.cMH().cNb().getValue();
            if (value == null || cML != value.intValue()) {
                c.this.cMH().Ba(c.this.cML());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes2.dex */
    public static final class d implements c.InterfaceC0855c {
        final /* synthetic */ TbPageContext jQO;

        d(TbPageContext tbPageContext) {
            this.jQO = tbPageContext;
        }

        @Override // com.baidu.tieba.play.c.InterfaceC0855c
        public void rj() {
            if (c.this.cFI()) {
                c.this.u(this.jQO);
            }
        }

        @Override // com.baidu.tieba.play.c.InterfaceC0855c
        public void rk() {
            if (c.this.cFI()) {
                c.this.v(this.jQO);
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
        public void GP() {
            if (c.this.cMM() == 1 && !c.this.cMN().isFullScreen()) {
                c.this.cMH().cNf();
            }
        }

        @Override // com.baidu.tieba.play.c.o
        public void cMU() {
        }

        @Override // com.baidu.tieba.play.c.o
        public void AZ(int i) {
        }

        @Override // com.baidu.tieba.play.c.o
        public void cMV() {
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
        p.p(tbPageContext, "pageContext");
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ap.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
        int dimens = l.getDimens(getContext(), R.dimen.tbds42);
        a2.setBounds(0, 0, dimens, dimens);
        this.jQf.setCompoundDrawables(null, null, a2, null);
        this.jQf.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
        ap.setViewTextColor(this.jQf, R.color.CAM_X0105);
        ap.setViewTextColor(this.jQg, R.color.CAM_X0109);
        ap.setViewTextColor(this.jQh, R.color.CAM_X0109);
        ap.setViewTextColor(this.jQl, R.color.CAM_X0105);
        ap.setViewTextColor(this.jQm, R.color.CAM_X0109);
        this.jQt.setTextColor(ap.getColor(R.color.CAM_X0105));
        AY(this.jQu);
        this.jQA.setTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.br(this.jQC).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        cMQ();
        this.jQI.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        this.jQq.destroy();
    }

    public final void b(com.baidu.tieba.frs.aggregation.g gVar, int i2) {
        if (gVar != null) {
            this.jPY = gVar;
            this.jPZ = com.baidu.tieba.frs.aggregation.g.f(gVar);
            this.jQa = i2;
            this.anT = gVar.cFI();
            r(gVar);
            a(i2, gVar);
            p(gVar);
            o(gVar);
            a(gVar, this.jPZ);
        }
    }

    private final boolean a(com.baidu.tieba.frs.aggregation.g gVar, cb cbVar) {
        return this.jQI.setData(cbVar);
    }

    private final void o(com.baidu.tieba.frs.aggregation.g gVar) {
        String string;
        List<com.baidu.tieba.tbadkCore.data.p> list = gVar.postList;
        if (list != null && !list.isEmpty()) {
            this.jQC.setVisibility(0);
            com.baidu.tieba.tbadkCore.data.p pVar = gVar.postList.get(0);
            MetaData metaData = pVar.nAm;
            if (metaData == null || (string = metaData.getName_show()) == null) {
                string = TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
                p.o(string, "TbadkCoreApplication.get…ng.user_name_default_txt)");
            }
            this.jQE = string;
            this.jQF = (char) 65306 + dG(pVar.ePV);
            this.jQG = new SpannableString(this.jQE + this.jQF);
            cMQ();
            return;
        }
        this.jQC.setVisibility(8);
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
        p.o(sb2, "postContent.toString()");
        return sb2;
    }

    private final void cMQ() {
        SpannableString spannableString;
        if (!kotlin.text.l.isBlank(this.jQE)) {
            if (!(this.jQF.length() > 0) || (spannableString = this.jQG) == null) {
                return;
            }
            if (spannableString.length() > 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0108));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0106));
                SpannableString spannableString2 = this.jQG;
                if (spannableString2 != null) {
                    spannableString2.setSpan(foregroundColorSpan, 0, this.jQE.length(), 33);
                }
                SpannableString spannableString3 = this.jQG;
                if (spannableString3 != null) {
                    spannableString3.setSpan(foregroundColorSpan2, this.jQE.length(), this.jQE.length() + this.jQF.length(), 33);
                }
                this.jQD.setText(this.jQG);
            }
        }
    }

    private final void p(com.baidu.tieba.frs.aggregation.g gVar) {
        int i2 = 1;
        String str = gVar.title;
        if (str == null) {
            str = TbadkCoreApplication.getInst().getString(R.string.video_title_str);
        }
        if (this.jQt.getPaint().measureText(str, 0, str.length()) + (this.jQt.getTextSize() * this.jQv) <= this.jQx * this.jQv) {
            i2 = 0;
        } else if (this.jQu == 1 || this.jQu == 2) {
            i2 = this.jQu;
        }
        AY(i2);
        this.jQt.setText(str);
        this.jQA.setText(au.numberUniformFormatExtra(gVar.playCount) + TbadkCoreApplication.getInst().getString(R.string.play));
    }

    private final void a(int i2, com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar.jpP != null) {
            ViewGroup.LayoutParams layoutParams = this.jQo.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.anT ? this.jPX : this.jPW;
            this.jQo.setLayoutParams(layoutParams2);
            this.jQq.Hp(i2);
            this.jQq.setThumbnail(gVar.jpP.thumbnailUrl);
            this.jQq.Hm(3);
            this.jQq.Hn(gVar.jpP.videoDuration);
            this.jQq.setVideoUrl(gVar.jpP.videoUrl, gVar.threadId);
            this.jQq.setFid(gVar.forumId);
            this.jQq.getVideoView().setVideoStatData(q(gVar));
            this.jQq.cSR();
            this.jQq.show();
            this.jQr.setVideoLength(gVar.jpP.videoSize);
            this.jQr.setVideoDuration(gVar.jpP.videoDuration);
            this.jQr.setTid(gVar.threadId);
            if (gVar.autoPlay) {
                this.jQq.xk(false);
                if (this.jQr.dvK()) {
                    this.jQr.au(this.anT, this.jQq.isFullScreen());
                    this.jQr.setVisibility(0);
                    this.jQq.xl(true);
                    return;
                }
                this.jQr.setVisibility(8);
                this.jQq.xl(false);
                this.jQq.fX(gVar.jpP.videoUrl, gVar.threadId);
                return;
            }
            this.jQr.setVisibility(8);
            this.jQq.stopPlay();
            this.jQq.xk(true);
        }
    }

    private final com.baidu.tieba.play.o q(com.baidu.tieba.frs.aggregation.g gVar) {
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.anU = gVar.threadId;
        oVar.eVa = gVar.nid;
        oVar.fOD = gVar.forumId;
        oVar.mUid = TbadkCoreApplication.getCurrentAccount();
        oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        oVar.mSource = gVar.source;
        oVar.mKz = gVar.weight;
        oVar.mKB = this.jPT.getFrom();
        oVar.mKD = gVar.abtest_tag;
        oVar.ePf = this.jPT.cNe();
        oVar.mExtra = gVar.extra;
        oVar.mKG = this.anT ? "1" : "0";
        oVar.mKC = gVar.getVideoType();
        return oVar;
    }

    private final void r(com.baidu.tieba.frs.aggregation.g gVar) {
        String str;
        String str2;
        String str3 = null;
        if (gVar.getVideoType() == 1 && gVar.eSP != null && (str2 = gVar.eSP.forumName) != null) {
            if (!kotlin.text.l.isBlank(str2)) {
                this.jQd.setVisibility(0);
                this.jQj.setVisibility(8);
                BarImageView barImageView = this.jQe;
                bx bxVar = gVar.eSP;
                barImageView.startLoad(bxVar != null ? bxVar.avatar : null, 10, false);
                SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.jQf;
                String string = getContext().getString(R.string.chosen_pb_original_bar);
                Object[] objArr = new Object[1];
                bx bxVar2 = gVar.eSP;
                objArr[0] = bxVar2 != null ? bxVar2.forumName : null;
                singleLineEllipsizeTextView.setText(String.format(string, objArr));
                TextView textView = this.jQg;
                StringBuilder sb = new StringBuilder();
                g.b bVar = gVar.jpO;
                if (TextUtils.isEmpty(bVar != null ? bVar.userNickname : null)) {
                    g.b bVar2 = gVar.jpO;
                    if (bVar2 != null) {
                        str3 = bVar2.userName;
                    }
                } else {
                    g.b bVar3 = gVar.jpO;
                    if (bVar3 != null) {
                        str3 = bVar3.userNickname;
                    }
                }
                textView.setText(sb.append(str3).append(TbadkCoreApplication.getInst().getString(R.string.home_publish)).toString());
                if (gVar.lastReplyTime > 0) {
                    this.jQh.setVisibility(0);
                    this.jQh.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + au.dZ(gVar.lastReplyTime * 1000));
                    return;
                }
                this.jQh.setVisibility(8);
                return;
            }
        }
        this.jQj.setVisibility(0);
        this.jQd.setVisibility(8);
        g.b bVar4 = gVar.jpO;
        p.o(bVar4, "data.author");
        a(bVar4);
        EMTextView eMTextView = this.jQl;
        g.b bVar5 = gVar.jpO;
        if (TextUtils.isEmpty(bVar5 != null ? bVar5.userNickname : null)) {
            g.b bVar6 = gVar.jpO;
            str = bVar6 != null ? bVar6.userName : null;
        } else {
            g.b bVar7 = gVar.jpO;
            str = bVar7 != null ? bVar7.userNickname : null;
        }
        eMTextView.setText(str);
        if (gVar.lastReplyTime > 0) {
            this.jQm.setVisibility(0);
            this.jQm.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + au.dZ(gVar.lastReplyTime * 1000));
            return;
        }
        this.jQm.setVisibility(8);
    }

    private final void a(g.b bVar) {
        if (bVar != null) {
            if (bVar.jpY != null && !TextUtils.isEmpty(bVar.jpY.avatar)) {
                this.jQk.startLoad(bVar.jpY.avatar, 12, false);
            } else {
                if (!StringUtils.isNull(bVar.portrait)) {
                    String str = bVar.portrait;
                    p.o(str, "data.portrait");
                    if (kotlin.text.l.a(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, (Object) null)) {
                        this.jQk.startLoad(bVar.portrait, 10, false);
                    }
                }
                this.jQk.startLoad(bVar.portrait, 12, false);
            }
            if (bVar.jpY != null && p.compare(bVar.jpY.auth_id.intValue(), 0) > 0) {
                Integer num = bVar.jpY.auth_id;
                p.o(num, "data.baijiahaoData.auth_id");
                this.jQk.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(num.intValue(), 1));
                this.jQk.setShowV(true);
                this.jQk.setGodIconWidth(R.dimen.tbds31);
                return;
            }
            this.jQk.setBjhAuthIconRes(0);
            if (bVar.isBigV) {
                this.jQk.setShowV(bVar.isBigV);
                this.jQk.setIsBigV(bVar.isBigV);
            } else if (bVar.isGod) {
                this.jQk.setShowV(bVar.isGod);
                this.jQk.setIsBigV(bVar.isGod);
            } else {
                this.jQk.setShowV(bVar.isGod);
                this.jQk.setIsBigV(bVar.isGod);
            }
            this.jQk.setGodIconWidth(R.dimen.tbds31);
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
        if (this.jQp.getParent() != null) {
            if (this.jQp.getParent() == frameLayout) {
                frameLayout.removeView(this.jQp);
            } else if (this.jQp.getParent() == this.jQo) {
                this.jQo.removeView(this.jQp);
            }
        }
        if (this.jQp.getParent() == null) {
            frameLayout.addView(this.jQp);
            ViewGroup.LayoutParams layoutParams = this.jQp.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = -1;
            this.jQp.setLayoutParams(layoutParams2);
            this.jQq.dcE();
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
        if (this.jQp.getParent() != null) {
            if (this.jQp.getParent() == frameLayout) {
                frameLayout.removeView(this.jQp);
            } else if (this.jQp.getParent() == this.jQo) {
                this.jQo.removeView(this.jQp);
            }
        }
        if (this.jQp.getParent() == null) {
            this.jQo.addView(this.jQp, 0);
            ViewGroup.LayoutParams layoutParams = this.jQp.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.anT ? this.jPX : this.jPW;
            this.jQp.setLayoutParams(layoutParams2);
            this.jQq.dcE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void AY(int i2) {
        this.jQu = i2;
        switch (i2) {
            case 0:
                cMR();
                return;
            case 1:
                cMS();
                return;
            case 2:
                cMT();
                return;
            default:
                return;
        }
    }

    private final void cMR() {
        this.jQz.setVisibility(8);
        this.jQt.setEllipsize(null);
        this.jQt.setMaxLines(this.jQv);
    }

    private final void cMS() {
        this.jQz.setVisibility(0);
        SvgManager.bsU().a(this.jQy, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.jQt.setEllipsize(TextUtils.TruncateAt.END);
        this.jQt.setMaxLines(this.jQv);
    }

    private final void cMT() {
        this.jQz.setVisibility(0);
        SvgManager.bsU().a(this.jQy, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.jQt.setEllipsize(null);
        this.jQt.setMaxLines(this.jQw);
    }
}
