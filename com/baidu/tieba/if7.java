package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AcceleratorActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.accelerator.AcceleratorData;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel;
import com.baidu.tieba.n55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class if7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AcceleratorNetModel b;
    public dea c;
    public cea d;
    public AcceleratorNetModel.b e;
    public jf7 f;
    public n55.f g;
    public AcceleratorData h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a implements cea {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        /* renamed from: com.baidu.tieba.if7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0345a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0345a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.c.b(this.a.a.d);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.f != null) {
                    this.a.a.f.b();
                }
            }
        }

        public a(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.cea
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (1 == this.a.j || 3 == this.a.j) {
                    this.a.A();
                } else if (2 == this.a.j) {
                    this.a.z();
                }
            }
        }

        @Override // com.baidu.tieba.cea
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                gr7.h(this.a.a.getActivity(), new View$OnClickListenerC0345a(this), new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AcceleratorNetModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public b(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void a(AcceleratorData acceleratorData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, acceleratorData) == null) {
                this.a.s();
                this.a.h = acceleratorData;
                if (this.a.a != null && this.a.h != null && this.a.h.getTokenInfo() != null && StringUtils.isNull(this.a.h.getTokenInfo().getToken())) {
                    BdToast.b(this.a.a.getContext(), this.a.h.getTokenInfo().getFailContent()).o();
                } else if (2 == this.a.j && this.a.a != null && this.a.h != null && !ListUtils.isEmpty(this.a.h.getAvailableTornadoNodeInfoList())) {
                    this.a.x();
                    if7 if7Var = this.a;
                    if7Var.f = jf7.c(if7Var.a.getPageContext());
                    String[] b = lf7.b(this.a.h.getAvailableTornadoNodeInfoList(), this.a.h.getAvailableNodesNum());
                    String str = b[0];
                    if (this.a.h.getItemData() != null) {
                        String acceleratorServer = TbSingleton.getInstance().getAcceleratorServer(String.valueOf(this.a.h.getItemData().itemId));
                        if (!StringUtils.isNull(acceleratorServer)) {
                            str = acceleratorServer;
                        }
                    }
                    this.a.f.d(str);
                    jf7 jf7Var = this.a.f;
                    jf7Var.e(this.a.g);
                    jf7Var.f(b);
                    jf7Var.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0064));
                    jf7Var.h();
                } else if (3 == this.a.j || 1 == this.a.j) {
                    this.a.z();
                }
            }
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.s();
                if (this.a.a != null) {
                    BdToast.b(this.a.a.getContext(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0063)).o();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements n55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public c(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.n55.f
        public void M0(n55 n55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, n55Var, i, view2) != null) {
                return;
            }
            this.a.i = i;
            this.a.B();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public d(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.k = true;
            this.a.u();
        }
    }

    public if7(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.a = frsFragment;
        this.b = new AcceleratorNetModel();
        this.c = dea.c(this.a);
        w();
        y();
    }

    public final void A() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frsFragment = this.a) != null && frsFragment.c1() != null && this.a.c1().itemInfo != null) {
            C();
            this.b.W(this.a.c1().itemInfo.id.intValue());
        }
    }

    public final void C() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).showLoadingDialog(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0062));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.b(this.d);
        }
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.j;
            if (i == 2 || i == 1) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void s() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).closeLoadingDialog();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AcceleratorNetModel acceleratorNetModel = this.b;
            if (acceleratorNetModel != null) {
                acceleratorNetModel.destroy();
            }
            jf7 jf7Var = this.f;
            if (jf7Var != null) {
                jf7Var.b();
            }
            if (this.a != null) {
                this.a = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.j;
            if (1 != i && 3 != i) {
                if (2 == i) {
                    A();
                    return;
                }
                return;
            }
            B();
        }
    }

    public dea v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (dea) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b bVar = new b(this);
            this.e = bVar;
            this.b.X(bVar);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = new c(this);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d = new a(this);
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.j = i;
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.c1() != null && this.a.c1().itemInfo != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    BdToast.b(this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0065)).o();
                } else if (TbSingleton.getInstance().acceleratorItemId != this.a.c1().itemInfo.id.intValue() && TbSingleton.getInstance().acceleratorItemId != -1) {
                    gr7.e(this.a.getActivity(), new d(this));
                } else if (TbSingleton.getInstance().acceleratorItemId == this.a.c1().itemInfo.id.intValue()) {
                    this.k = false;
                    u();
                } else if (TbSingleton.getInstance().acceleratorItemId == -1) {
                    this.k = true;
                    u();
                }
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            jf7 jf7Var = this.f;
            if (jf7Var != null) {
                jf7Var.b();
            }
            PkgNameAndNodeInfoData pkgNameAndNodeInfoData = lf7.a(this.h.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(this.i));
            if (this.j == 2 && pkgNameAndNodeInfoData != null && !pkgNameAndNodeInfoData.compare(TbSingleton.getInstance().acceleratorData)) {
                this.k = true;
            }
            if (!this.k) {
                pkgNameAndNodeInfoData = TbSingleton.getInstance().acceleratorData;
            }
            if (pkgNameAndNodeInfoData == null) {
                return;
            }
            AcceleratorActivityConfig acceleratorActivityConfig = new AcceleratorActivityConfig(this.a.getContext());
            acceleratorActivityConfig.setAcceleratorData(this.h).setCurrentNodeInfo(pkgNameAndNodeInfoData).setFid(this.a.l).setSource(r()).setIsNewItem(this.k);
            acceleratorActivityConfig.start();
        }
    }
}
