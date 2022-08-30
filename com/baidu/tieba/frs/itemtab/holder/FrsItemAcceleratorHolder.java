package com.baidu.tieba.frs.itemtab.holder;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bw4;
import com.baidu.tieba.fh6;
import com.baidu.tieba.frs.itemtab.holder.FrsItemAcceleratorHolder;
import com.baidu.tieba.frs.itemtab.view.FrsItemAcceleratorView;
import com.baidu.tieba.sn6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsItemAcceleratorHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemAcceleratorView a;
    public BdUniqueId b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsItemAcceleratorHolder(View view2, BdUniqueId bdUniqueId) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, bdUniqueId};
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
        if (view2 instanceof FrsItemAcceleratorView) {
            this.a = (FrsItemAcceleratorView) view2;
        }
        this.b = bdUniqueId;
    }

    public void a(sn6 sn6Var) {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, sn6Var) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.setBtnColor(sn6Var.b());
        this.a.setBtnImgClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.co6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    FrsItemAcceleratorHolder.this.e(view2);
                }
            }
        });
        this.a.setBtnDescClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.bo6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    FrsItemAcceleratorHolder.this.f(view2);
                }
            }
        });
    }

    public void b() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.a();
    }

    public void c() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.b();
    }

    public void d() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frsItemAcceleratorView = this.a) == null) {
            return;
        }
        frsItemAcceleratorView.c();
    }

    public /* synthetic */ void e(View view2) {
        g(2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new bw4(19)));
    }

    public /* synthetic */ void f(View view2) {
        g(1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new bw4(18)));
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new fh6(i));
            CustomMessage customMessage = new CustomMessage(2921662);
            customMessage.setTag(this.b);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
