package com.baidu.tieba.frs.itemtab.holder;

import android.view.View;
import c.a.s0.s.j0.p.b;
import c.a.t0.d1.n2.g.a;
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
/* loaded from: classes12.dex */
public class FrsItemAcceleratorHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemAcceleratorView a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f43636b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsItemAcceleratorHolder(View view, BdUniqueId bdUniqueId) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (view instanceof FrsItemAcceleratorView) {
            this.a = (FrsItemAcceleratorView) view;
        }
        this.f43636b = bdUniqueId;
    }

    public /* synthetic */ void a(View view) {
        c(2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(19)));
    }

    public /* synthetic */ void b(View view) {
        c(1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(18)));
    }

    public void bindData(a aVar) {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.setBtnColor(aVar.d());
        this.a.setBtnImgClickListener(new View.OnClickListener() { // from class: c.a.t0.d1.n2.i.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    FrsItemAcceleratorHolder.this.a(view);
                }
            }
        });
        this.a.setBtnDescClickListener(new View.OnClickListener() { // from class: c.a.t0.d1.n2.i.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    FrsItemAcceleratorHolder.this.b(view);
                }
            }
        });
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.t0.d1.q1.b.a(i2));
            CustomMessage customMessage = new CustomMessage(2921662);
            customMessage.setTag(this.f43636b);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void changeAcceleratorStartBtnTDescDoing() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.changeBtnDescDoing();
    }

    public void changeAcceleratorStartBtnTDescNormal() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.changeBtnDescNormal();
    }

    public void changeSkin() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.changeSkin();
    }
}
