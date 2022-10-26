package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.dz6;
import com.baidu.tieba.ey4;
import com.baidu.tieba.ez6;
import com.baidu.tieba.iz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public lz6 b;
    public iz6 c;
    public int d;
    public dz6 e;
    public ez6 f;
    public BdUniqueId g;
    public CustomMessageListener h;
    public NEGFeedBackView.b i;
    public final View.OnClickListener j;
    public ey4.g k;
    public BdListView.p l;
    public iz6.e m;
    public View.OnClickListener n;
    public ez6.f o;
    public dz6.b p;

    /* loaded from: classes4.dex */
    public class f implements iz6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.t();
                }
            }
        }

        public f(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // com.baidu.tieba.iz6.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.b.B();
                this.a.b.C();
                if (!z && !z2) {
                    this.a.b.p0(this.a.q(i));
                } else {
                    this.a.b.p0(null);
                }
                if (this.a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.a.c.m()) && !StringUtils.isNull(ux4.k().q("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.a.b.T(this.a.f.i());
                    this.a.b.g0();
                    this.a.f.l(this.a.c.m());
                }
                if (i != 0) {
                    this.a.b.U(this.a.c.l());
                    this.a.b.d0(this.a.n);
                } else if (ListUtils.isEmpty(this.a.b.x())) {
                    this.a.b.k0();
                } else if (z) {
                    this.a.b.l0();
                }
            }
        }

        @Override // com.baidu.tieba.iz6.e
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.b.p0(null);
                this.a.b.B();
                this.a.b.C();
                if (ListUtils.isEmpty(this.a.b.x())) {
                    this.a.b.j0(new a(this));
                    return;
                }
                if (z) {
                    this.a.b.d0(this.a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f07cd);
                } else {
                    this.a.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fz6 fz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p(customResponsedMessage);
                if (this.a.b != null) {
                    this.a.b.N();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(xs4 xs4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xs4Var, compoundButton, z) == null) {
            }
        }

        public b(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList arrayList, String str, xs4 xs4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, xs4Var) == null) && arrayList != null && xs4Var != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2));
                    sb.append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                int i3 = xs4Var.n;
                if (i3 == 0) {
                    i = 1;
                } else if (i3 == 40) {
                    i = 2;
                } else if (i3 == 49) {
                    i = 3;
                }
                if (this.a.b != null) {
                    this.a.b.P();
                }
                TiebaStatic.log(new StatisticItem("c13500").param("tid", xs4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", xs4Var.c()).param("obj_param1", xs4Var.k).param("obj_source", xs4Var.l).param("obj_id", xs4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(xs4 xs4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xs4Var) != null) || xs4Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", xs4Var.c()).param("tid", xs4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", xs4Var.c()).param("tid", xs4Var.f()).param("obj_type", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        public c(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.b.F()) {
                return;
            }
            this.a.b.S(true);
            if (this.a.f.i()) {
                this.a.f.e();
                this.a.b.e0();
                SkinManager.setBackgroundResource(this.a.b.y(), R.color.CAM_X0207);
                return;
            }
            this.a.f.n(this.a.b.y());
            this.a.b.f0();
            SkinManager.setBackgroundResource(this.a.b.y(), R.color.CAM_X0201);
            if (this.a.c != null && !ListUtils.isEmpty(this.a.c.m())) {
                TiebaStatic.log("c13490");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ey4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        public d(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // com.baidu.tieba.ey4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.c.q(this.a.d);
                    this.a.u();
                    this.a.b.Z(false);
                    return;
                }
                this.a.b.p0(null);
                this.a.a.showToast(R.string.im_error_default);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        public e(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.h0();
                this.a.c.r(this.a.d);
                this.a.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        public g(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.c != null) {
                this.a.b.h0();
                this.a.c.r(this.a.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ez6.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        public h(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // com.baidu.tieba.ez6.f
        public void a(gz6 gz6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, gz6Var) != null) || gz6Var == null) {
                return;
            }
            this.a.d = gz6Var.a;
            this.a.m(gz6Var.a);
            if (this.a.b != null) {
                this.a.b.W(gz6Var.a);
                this.a.b.T(false);
                this.a.b.V(gz6Var.b);
            }
        }

        @Override // com.baidu.tieba.ez6.f
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null) {
                this.a.b.T(false);
                this.a.b.J(false);
            }
        }

        @Override // com.baidu.tieba.ez6.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.b.J(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements dz6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        public i(fz6 fz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz6Var;
        }

        @Override // com.baidu.tieba.dz6.b
        public void a(gz6 gz6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, gz6Var) != null) || gz6Var == null) {
                return;
            }
            this.a.d = gz6Var.a;
            this.a.m(gz6Var.a);
            if (this.a.b != null) {
                this.a.b.W(gz6Var.a);
                this.a.b.T(false);
                this.a.b.V(gz6Var.b);
            }
        }
    }

    public fz6(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2016488);
        this.i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.a = tbPageContext;
        this.g = bdUniqueId;
        this.b = new lz6(baseFragment, tbPageContext, bdUniqueId, this.i);
        this.c = new iz6(this.a, this.m);
        ez6 ez6Var = new ez6(tbPageContext, this.g);
        this.f = ez6Var;
        ez6Var.m(this.o);
        dz6 dz6Var = new dz6(tbPageContext, this.g);
        this.e = dz6Var;
        dz6Var.i(this.p);
        this.b.Y(this.j);
        int l = ux4.k().l("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.d = l;
        this.b.W(l);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ez6 ez6Var = this.f;
            if (ez6Var != null) {
                ez6Var.p(i2);
            }
            iz6 iz6Var = this.c;
            if (iz6Var != null) {
                iz6Var.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lz6 lz6Var = this.b;
            if (lz6Var != null) {
                lz6Var.s();
            }
            ez6 ez6Var = this.f;
            if (ez6Var != null) {
                ez6Var.j();
            }
            dz6 dz6Var = this.e;
            if (dz6Var != null) {
                dz6Var.f();
            }
            if (this.f.i()) {
                SkinManager.setBackgroundResource(this.b.y(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.b.y(), R.color.CAM_X0207);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            lz6 lz6Var = this.b;
            if (lz6Var != null) {
                lz6Var.X(null);
                this.b.a0(null);
                this.b.K();
            }
            ez6 ez6Var = this.f;
            if (ez6Var != null) {
                ez6Var.k();
            }
            dz6 dz6Var = this.e;
            if (dz6Var != null) {
                dz6Var.g();
            }
            iz6 iz6Var = this.c;
            if (iz6Var != null) {
                iz6Var.t();
            }
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        dz6 dz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            iz6 iz6Var = this.c;
            if (iz6Var != null && !ListUtils.isEmpty(iz6Var.m())) {
                if ((this.c.o() || this.d == 0) && (dz6Var = this.e) != null) {
                    dz6Var.h(this.c.m());
                    this.e.c((ViewGroup) this.b.z());
                    ux4.k().D("key_game_video_tab_has_choosed_sub_class_id");
                    ux4.k().D("key_game_video_tab_has_choosed_sub_class_name");
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage customResponsedMessage) {
        iz6 iz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (iz6Var = this.c) != null && !ListUtils.isEmpty(iz6Var.l())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.c.w(optString);
            this.c.v(optString);
            lz6 lz6Var = this.b;
            if (lz6Var != null) {
                lz6Var.R(optString);
            }
        }
    }

    public final ey4.i q(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07cb);
            } else {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07cc, Integer.valueOf(i2));
            }
            return new ey4.i(string, 1000);
        }
        return (ey4.i) invokeI.objValue;
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.d));
                if (!this.f.i()) {
                    this.b.c0();
                    return;
                }
                return;
            }
            ez6 ez6Var = this.f;
            if (ez6Var != null) {
                ez6Var.f();
            }
            this.b.M();
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            lz6 lz6Var = this.b;
            if (lz6Var != null) {
                return lz6Var.z();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.u();
            this.b.D();
            this.b.X(this.k);
            this.b.a0(this.l);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            lz6 lz6Var = this.b;
            if (lz6Var != null) {
                lz6Var.t();
                this.b.i0();
            }
            iz6 iz6Var = this.c;
            if (iz6Var != null) {
                iz6Var.q(this.d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.d));
        }
    }

    public void v() {
        lz6 lz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (lz6Var = this.b) != null) {
            lz6Var.I();
        }
    }

    public void x() {
        lz6 lz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (lz6Var = this.b) != null) {
            lz6Var.L();
            this.b.M();
            this.b.b0(true);
        }
    }

    public void y() {
        lz6 lz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (lz6Var = this.b) != null) {
            lz6Var.H();
            this.b.n0();
            this.b.Z(false);
            this.b.o0();
        }
    }
}
