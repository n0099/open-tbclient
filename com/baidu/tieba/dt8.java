package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.BackgroundSetHttpResponseMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetSocketResponseMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class dt8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewActivity a;
    public View b;
    public View c;
    public NavigationBar d;
    public ct8 e;
    public BdExpandListView f;
    public at8 g;
    public SkinProgressView h;
    public DressItemData i;
    public xs8 j;
    public View.OnClickListener k;
    public pb l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dt8 a;

        public a(dt8 dt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dt8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.a.i == null || this.a.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.a.i.getInUse()) {
                jx4.e(this.a.a.getPageContext().getPageActivity(), 8);
            } else {
                this.a.j.e(this.a.i, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dt8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dt8 dt8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt8Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dt8Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.a.i.getPropsId()).param("obj_type", this.a.i.getFreeUserLevel()));
                    this.a.i.setInUse(true);
                    this.a.m();
                    ox4 k = ox4.k();
                    k.w("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.a.i.getPropsId());
                    return;
                }
                int i = ps8.b;
                if (responsedMessage.getError() == ps8.c) {
                    i = ps8.a;
                }
                this.a.j.d(i, responsedMessage.getErrorString(), this.a.i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716193, "Lcom/baidu/tieba/dt8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716193, "Lcom/baidu/tieba/dt8;");
                return;
            }
        }
        m = ej.f(TbadkApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07029e);
    }

    public dt8(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0130, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.c = this.b.findViewById(R.id.obfuscated_res_0x7f0903b7);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f0925c5);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.showBottomLine(false);
        this.f = (BdExpandListView) this.a.findViewById(R.id.obfuscated_res_0x7f0919b3);
        this.h = (SkinProgressView) this.b.findViewById(R.id.obfuscated_res_0x7f0925a8);
        xs8 xs8Var = new xs8(backgroundPreviewActivity.getPageContext(), this.a.getUniqueId());
        this.j = xs8Var;
        xs8Var.c(this.a.A1());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.b);
            this.c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void g() {
        at8 at8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ge5.a(this.a.getPageContext(), this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (at8Var = this.g) == null) {
                return;
            }
            at8Var.notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sm8.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            sm8.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setVisibility(8);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c73);
            this.a.setNetRefreshViewTopMargin(m);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.e == null) {
                ct8 ct8Var = new ct8(this.a);
                this.e = ct8Var;
                ct8Var.e(dressItemData);
                this.f.addHeaderView(this.e.b());
                this.e.d();
                this.f.setExpandView(this.e.b(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
                at8 at8Var = new at8(this.a.getPageContext(), dressItemData);
                this.g = at8Var;
                this.f.setAdapter((ListAdapter) at8Var);
                i();
                this.a.registerListener(this.l);
            }
            this.h.setDressData(this.i);
            this.h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.i.getActivityFinish();
        this.h.setFontSize(ej.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b7));
        if (inUse) {
            this.h.b(0, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.h.b(9, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
