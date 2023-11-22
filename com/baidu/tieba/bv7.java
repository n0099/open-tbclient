package com.baidu.tieba;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class bv7 extends zk6<ThreadData> implements wl6, Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View B;
    public TbImageView C;
    public String D;
    public o48 E;
    public View F;
    public AppletsCellView G;
    public View.OnClickListener H;
    public final View.OnClickListener I;
    public final View.OnClickListener J;
    public HeadPendantClickableView i;
    public PlayVoiceBntNew j;
    public ThreadCommentAndPraiseInfoLayout k;
    public ThreadSourceShareAndPraiseLayout l;
    public ThreadGodReplyLayout m;
    public ThreadUserInfoLayout n;
    public RelativeLayout o;
    public View p;
    public TbImageView q;
    public LinearLayout r;
    public String s;
    public String t;
    public int u;
    public ThreadData v;
    public TbPageContext<?> w;
    public TextView x;
    public TextView y;
    public ConstrainImageGroup z;

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void B(boolean z);

    @Override // com.baidu.tieba.wl6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv7 a;

        public a(bv7 bv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (threadCommentAndPraiseInfoLayout = this.a.k) != null) {
                threadCommentAndPraiseInfoLayout.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ThreadCommentAndPraiseInfoLayout.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv7 a;

        public b(bv7 bv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv7Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.o
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || this.a.F == null) {
                return;
            }
            View view2 = this.a.F;
            if (z) {
                i = R.color.CAM_X0201;
            } else {
                i = R.color.transparent;
            }
            view2.setBackgroundColor(SkinManager.getColor(i));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bx5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ ThreadData b;
        public final /* synthetic */ bv7 c;

        public c(bv7 bv7Var, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bv7Var;
            this.a = linkedList;
            this.b = threadData;
        }

        @Override // com.baidu.tieba.bx5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                yl6<ThreadData> f = this.c.f();
                if (z) {
                    if (f != null) {
                        view2.setTag("1");
                        f.a = Boolean.TRUE;
                        f.a(view2, this.c.v);
                    }
                    this.c.B(false);
                    return;
                }
                if (f != null) {
                    view2.setTag("1");
                    f.a = Boolean.FALSE;
                    f.a(view2, this.c.v);
                }
                this.c.N(view2, this.a, i, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ bv7 b;

        public d(bv7 bv7Var, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bv7Var;
            this.a = threadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bv7 bv7Var = this.b;
                if (bv7Var.w != null) {
                    BrowserHelper.startWebActivity(bv7Var.b.getContext(), "", this.a.iconLink, true);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThemeCardInUserData a;
        public final /* synthetic */ bv7 b;

        public e(bv7 bv7Var, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bv7Var;
            this.a = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.b.w.getPageActivity(), this.a.getCardId())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv7 a;

        public f(bv7 bv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!hp7.f().i() && !gp7.h().j()) {
                    if (this.a.f() != null) {
                        this.a.f().a(view2, this.a.v);
                    }
                    bv7 bv7Var = this.a;
                    if (view2 == bv7Var.m) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bv7Var.B(z);
                    return;
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a.k;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.changeSelectStatus();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv7 a;

        public g(bv7 bv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            yl6<ThreadData> f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (f = this.a.f()) != null) {
                view2.setTag("2");
                f.a(view2, this.a.v);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv7 a;

        public h(bv7 bv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f() != null) {
                this.a.f().a(view2, this.a.v);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.A = true;
        this.H = new f(this);
        this.I = new g(this);
        this.J = new h(this);
        View i3 = i();
        n(bdUniqueId);
        this.w = tbPageContext;
        this.h = 3;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) i3.findViewById(R.id.obfuscated_res_0x7f09062f);
        this.i = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.i.getHeadView().setIsRound(true);
            this.i.getHeadView().setDrawBorder(false);
            this.i.getHeadView().setDefaultResource(17170445);
            this.i.getHeadView().setRadius(BdUtilHelper.getDimens(this.w.getPageActivity(), R.dimen.obfuscated_res_0x7f070266));
        }
        this.i.setHasPendantStyle();
        if (this.i.getPendantView() != null) {
            this.i.getPendantView().setIsRound(true);
            this.i.getPendantView().setDrawBorder(false);
        }
        this.i.setAfterClickListener(this.J);
        this.p = i3.findViewById(R.id.obfuscated_res_0x7f090939);
        this.x = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090627);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) i3.findViewById(R.id.obfuscated_res_0x7f09061f);
        this.j = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.I);
        TextView textView = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09061e);
        this.y = textView;
        textView.setVisibility(8);
        this.B = i3.findViewById(R.id.divider_line_above_praise);
        this.z = (ConstrainImageGroup) i3.findViewById(R.id.obfuscated_res_0x7f090622);
        this.z.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.z.setChildClickListener(this.H);
        dx5 dx5Var = new dx5(3);
        dx5Var.d(1.0d);
        this.z.setImageProcessor(dx5Var);
        this.k = (ThreadCommentAndPraiseInfoLayout) i3.findViewById(R.id.obfuscated_res_0x7f090623);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) i3.findViewById(R.id.obfuscated_res_0x7f09062d);
        this.n = threadUserInfoLayout;
        threadUserInfoLayout.setUserAfterClickListener(this.J);
        this.n.setFrom(3);
        this.k.setOnClickListener(this.H);
        this.k.setForumAfterClickListener(this.J);
        this.k.setReplyTimeVisible(false);
        this.k.setShowPraiseNum(true);
        this.k.setNeedAddPraiseIcon(true);
        this.k.setNeedAddReplyIcon(true);
        this.k.setIsBarViewVisible(false);
        this.k.setShareVisible(true);
        this.k.setShareReportFrom(1);
        this.k.setStType("frs_page");
        this.k.setFrom(2);
        this.k.S = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) i3.findViewById(R.id.obfuscated_res_0x7f090630);
        this.l = threadSourceShareAndPraiseLayout;
        if (threadSourceShareAndPraiseLayout != null) {
            threadSourceShareAndPraiseLayout.b.setOnClickListener(this.H);
            this.l.setFrom(2);
            this.l.setShareReportFrom(1);
            this.l.setSourceFromForPb(3);
            this.l.setStType("frs_page");
            this.l.setHideBarName(true);
            this.l.b.setNeedAddReplyIcon(true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) i3.findViewById(R.id.obfuscated_res_0x7f090624);
        this.o = relativeLayout;
        o48 o48Var = new o48(this.w, relativeLayout);
        this.E = o48Var;
        o48Var.d(g());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) i3.findViewById(R.id.obfuscated_res_0x7f09060a);
        this.m = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.H);
        TbImageView tbImageView = (TbImageView) i3.findViewById(R.id.obfuscated_res_0x7f090d87);
        this.q = tbImageView;
        tbImageView.setPageId(g());
        TbImageView tbImageView2 = (TbImageView) i3.findViewById(R.id.frs_normal_item_star_view);
        this.C = tbImageView2;
        if (tbImageView2 != null) {
            tbImageView2.setPageId(g());
        }
        View findViewById = i3.findViewById(R.id.thread_multi_del_mask_view);
        this.F = findViewById;
        findViewById.setOnClickListener(new a(this));
        this.k.setOnSelectStatusChangeListener(new b(this));
        this.r = (LinearLayout) i3.findViewById(R.id.obfuscated_res_0x7f090620);
        this.G = (AppletsCellView) i3.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) && bdUniqueId != null && this.k != null) {
            I(bdUniqueId);
        }
    }

    public void F(ob<TbImageView> obVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, obVar) == null) && (constrainImageGroup = this.z) != null) {
            constrainImageGroup.setImageViewPool(obVar);
        }
    }

    public void G(ob<ConstrainImageLayout> obVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obVar) == null) && (constrainImageGroup = this.z) != null) {
            constrainImageGroup.setConstrainLayoutPool(obVar);
        }
    }

    public final void I(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            ConstrainImageGroup constrainImageGroup = this.z;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void J(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) && (constrainImageGroup = this.z) != null) {
            constrainImageGroup.setSingleImageRatio(d2);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.D = str;
        }
    }

    @Override // com.baidu.tieba.wl6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.h = i;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.k;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.S = i;
                threadCommentAndPraiseInfoLayout.setFrom(2);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setFrom(3);
            }
        }
    }

    public int y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            return r16.c().b(this.D, i);
        }
        return invokeI.intValue;
    }

    public void C(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            if (threadData == null) {
                if (i() != null) {
                    i().setVisibility(8);
                    return;
                }
                return;
            }
            this.v = threadData;
            if (i() != null) {
                i().setVisibility(0);
                i().setOnClickListener(this.H);
            }
            this.m.m();
            if (!A() && jl6.k(this.v.getId())) {
                jl6.l(this.x, this.v.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                jl6.l(this.y, this.v.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                jl6.l(this.m.getGodReplyContent(), this.v.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            }
            z(threadData);
            this.E.a(this.v);
            M(threadData);
            this.n.j(this.v);
            this.m.setFromCDN(this.A);
            this.m.setData(this.v.getTopAgreePost());
            this.n.setUserAfterClickListener(this.J);
            L(y(1));
            if (this.n.getHeaderImg() != null) {
                if (this.n.getIsSimpleThread()) {
                    this.n.getHeaderImg().setVisibility(8);
                    this.i.setVisibility(8);
                } else if (threadData.getAuthor() != null && threadData.getAuthor().getPendantData() != null && !StringUtils.isNull(threadData.getAuthor().getPendantData().getImgUrl())) {
                    this.n.getHeaderImg().setVisibility(4);
                    this.i.setVisibility(0);
                    this.i.setData(threadData);
                } else {
                    this.i.setVisibility(8);
                    this.n.getHeaderImg().setVisibility(0);
                    this.n.getHeaderImg().setData(threadData);
                }
            }
            K(threadData);
            E(threadData);
            this.G.setData(threadData.getSmartApp());
            this.G.setForumId(String.valueOf(threadData.getFid()));
            this.G.setFrom("frs_card");
            ArrayList<VoiceData.VoiceModel> voice = threadData.getVoice();
            if (ListUtils.isEmpty(voice)) {
                this.j.setVisibility(8);
            } else {
                this.j.m();
                this.j.setVisibility(0);
                VoiceData.VoiceModel voiceModel = voice.get(0);
                this.j.setVoiceModel(voiceModel);
                this.j.setTag(voiceModel);
                this.j.b();
                if (voiceModel != null) {
                    this.j.k(voiceModel.voice_status.intValue());
                }
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            if (lv4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.z.setVisibility(0);
                    this.z.setFromCDN(this.A);
                    this.z.setImageClickListener(new c(this, linkedList, threadData));
                    this.z.setImageMediaList(linkedList);
                } else {
                    this.z.setVisibility(8);
                }
            } else {
                this.z.setVisibility(8);
            }
            P();
            H();
            O();
            if ((hp7.f().i() || gp7.h().j()) && this.k.isInFrsAllThread()) {
                this.F.setVisibility(0);
                if (!this.v.isMarkToDel() && !this.v.isMarkToMove() && !this.v.isTransportThread()) {
                    this.F.setBackgroundResource(R.color.transparent);
                } else {
                    SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                }
            } else {
                this.F.setVisibility(8);
            }
            l(this.w, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            if (threadData != null && y(2) == 1) {
                if (!StringUtils.isNull(this.s) && !StringUtils.isNull(this.t)) {
                    threadData.setSpecUrl(this.s, this.t);
                }
                SpannableString parseAbstract = threadData.parseAbstract();
                if (parseAbstract != null && !qd.isEmpty(parseAbstract.toString())) {
                    this.y.setVisibility(0);
                    this.y.setOnTouchListener(new h5b(parseAbstract));
                    this.y.setText(parseAbstract);
                    jl6.l(this.y, threadData.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                    return;
                }
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public final boolean K(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) {
            if (!StringUtils.isNull(this.s) && !StringUtils.isNull(this.t)) {
                threadData.setSpecUrl(this.s, this.t);
            }
            SpannableStringBuilder parseTitleOrAbstractForFrsNew = threadData.parseTitleOrAbstractForFrsNew(false, true);
            if (parseTitleOrAbstractForFrsNew != null && !StringUtils.isNull(parseTitleOrAbstractForFrsNew.toString())) {
                this.x.setVisibility(0);
                this.x.setOnTouchListener(new h5b(parseTitleOrAbstractForFrsNew));
                this.x.setText(parseTitleOrAbstractForFrsNew);
                jl6.l(this.x, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            } else {
                this.x.setVisibility(8);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, threadData) != null) || this.C == null) {
            return;
        }
        if (this.q != null && threadData != null) {
            if (!StringUtils.isNull(threadData.iconPicUrl) && this.q.getVisibility() != 0) {
                o48 o48Var = this.E;
                if (o48Var != null && o48Var.b() && (this.C.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
                    layoutParams.rightMargin = BdUtilHelper.getDimens(this.w.getPageActivity(), R.dimen.tbds106);
                    this.C.setLayoutParams(layoutParams);
                }
                this.C.setVisibility(0);
                this.C.setImageDrawable(null);
                this.C.startLoad(threadData.iconPicUrl, 10, false);
                this.C.setOnClickListener(new d(this, threadData));
                return;
            }
            this.C.setVisibility(8);
            return;
        }
        this.C.setVisibility(8);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.setClickable(true);
            int childCount = this.z.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.z.getChildAt(i);
                if (childAt != null) {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void L(int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || (threadData = this.v) == null) {
            return;
        }
        if (i == 1) {
            this.k.setVisibility(8);
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.l;
            if (threadSourceShareAndPraiseLayout != null) {
                threadSourceShareAndPraiseLayout.g(this.v);
                return;
            }
            return;
        }
        this.k.setData(threadData);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.l;
        if (threadSourceShareAndPraiseLayout2 != null) {
            threadSourceShareAndPraiseLayout2.setVisibility(8);
        }
    }

    public final void N(View view2, List<MediaData> list, int i, ThreadData threadData) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048589, this, view2, list, i, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                BdUtilHelper.showToast(this.w.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                String str2 = null;
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    str2 = mediaData.getSrc_pic();
                } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    str2 = mediaData.getPicUrl();
                }
                if (!StringUtils.isNull(str2)) {
                    arrayList.add(str2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    if (this.A) {
                        i2 = 13;
                    } else {
                        i2 = 14;
                    }
                    imageUrlData.urlType = i2;
                    String thumbnailsUrl = ThreadCardUtils.getThumbnailsUrl(mediaData);
                    imageUrlData.imageUrl = thumbnailsUrl;
                    imageUrlData.urlThumbType = imageUrlData.urlType;
                    imageUrlData.imageThumbUrl = thumbnailsUrl;
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = JavaTypesHelper.toLong(threadData.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(str2, imageUrlData);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            ImageViewerConfig.Builder isCDN = builder.setData(arrayList).setIndex(i).setForumName(threadData.getForum_name()).setPostId(threadData.getFirst_post_id()).setForumId(String.valueOf(threadData.getFid())).setThreadId(threadData.getTid()).setIsCDN(this.A);
            if (arrayList.size() > 0) {
                str = arrayList.get(0);
            } else {
                str = "";
            }
            isCDN.setLastId(str).setIsReserve(true).setAssistUrls(concurrentHashMap).setIsShowAd(true).setThreadData(threadData).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
            ImageViewerConfig bulid = builder.bulid(this.w.getPageActivity());
            bulid.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, bulid));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.w;
            historyMessage.threadId = threadData.getId();
            historyMessage.threadName = threadData.getTitle();
            historyMessage.forumName = threadData.getForum_name();
            historyMessage.postID = threadData.getFirstPostId();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void O() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (textView = this.x) != null && this.j != null && this.z != null && this.c != null && textView.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.topMargin = this.c.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.j.setLayoutParams(layoutParams);
            if (this.j.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                layoutParams2.topMargin = this.c.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.z.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void P() {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.B != null && (constrainImageGroup = this.z) != null && this.m != null) {
            if (constrainImageGroup.getVisibility() == 8 && this.m.getVisibility() == 8 && this.G.getVisibility() == 8) {
                this.B.setVisibility(0);
            } else {
                this.B.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.zk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, tbPageContext, i) == null) {
            if (this.u != i) {
                SkinManager.setBackgroundResource(i(), R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
                this.z.b();
                this.k.onChangeSkinType();
                this.n.h();
                AppletsCellView appletsCellView = this.G;
                if (appletsCellView != null) {
                    appletsCellView.c();
                }
                this.E.c();
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.l;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.l.f();
                }
                HeadPendantClickableView headPendantClickableView = this.i;
                if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.i.getHeadView() instanceof TbImageView)) {
                    this.i.getHeadView().setPlaceHolder(1);
                }
            }
            this.u = i;
        }
    }

    public void z(ThreadData threadData) {
        MetaData author;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, threadData) != null) || threadData == null || this.q == null || (author = threadData.getAuthor()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = author.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.q.setVisibility(0);
            this.q.setImageDrawable(null);
            this.q.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.q.setOnClickListener(new e(this, themeCard));
            return;
        }
        this.q.setVisibility(8);
    }
}
