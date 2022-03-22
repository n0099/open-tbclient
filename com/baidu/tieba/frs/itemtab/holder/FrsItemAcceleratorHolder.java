package com.baidu.tieba.frs.itemtab.holder;

import android.view.View;
import c.a.o0.r.l0.p.b;
import c.a.p0.f1.d2.g.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.itemtab.holder.FrsItemAcceleratorHolder;
import com.baidu.tieba.frs.itemtab.view.FrsItemAcceleratorView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsItemAcceleratorHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemAcceleratorView a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f32764b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsItemAcceleratorHolder(View view, BdUniqueId bdUniqueId) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (view instanceof FrsItemAcceleratorView) {
            this.a = (FrsItemAcceleratorView) view;
        }
        this.f32764b = bdUniqueId;
    }

    public void c(a aVar) {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.setBtnColor(aVar.b());
        this.a.setBtnImgClickListener(new View.OnClickListener() { // from class: c.a.p0.f1.d2.i.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    FrsItemAcceleratorHolder.this.g(view);
                }
            }
        });
        this.a.setBtnDescClickListener(new View.OnClickListener() { // from class: c.a.p0.f1.d2.i.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    FrsItemAcceleratorHolder.this.h(view);
                }
            }
        });
    }

    public void d() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.a();
    }

    public void e() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.b();
    }

    public void f() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.c();
    }

    public /* synthetic */ void g(View view) {
        i(2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(19)));
    }

    public /* synthetic */ void h(View view) {
        i(1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(18)));
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.p0.f1.g1.b.a(i));
            CustomMessage customMessage = new CustomMessage(2921662);
            customMessage.setTag(this.f32764b);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
