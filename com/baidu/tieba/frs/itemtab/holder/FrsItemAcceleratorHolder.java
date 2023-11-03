package com.baidu.tieba.frs.itemtab.holder;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b65;
import com.baidu.tieba.frs.itemtab.view.FrsItemAcceleratorView;
import com.baidu.tieba.qy7;
import com.baidu.tieba.ur7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FrsItemAcceleratorHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemAcceleratorView a;
    public BdUniqueId b;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemAcceleratorHolder a;

        public a(FrsItemAcceleratorHolder frsItemAcceleratorHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemAcceleratorHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsItemAcceleratorHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.f(2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b65(19)));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemAcceleratorHolder a;

        public b(FrsItemAcceleratorHolder frsItemAcceleratorHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemAcceleratorHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsItemAcceleratorHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.f(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b65(18)));
        }
    }

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

    public void b(qy7 qy7Var) {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, qy7Var) == null) && (frsItemAcceleratorView = this.a) != null) {
            frsItemAcceleratorView.setBtnColor(qy7Var.b());
            this.a.setBtnImgClickListener(new a(this));
            this.a.setBtnDescClickListener(new b(this));
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new ur7(i));
            CustomMessage customMessage = new CustomMessage(2921662);
            customMessage.setTag(this.b);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void c() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (frsItemAcceleratorView = this.a) != null) {
            frsItemAcceleratorView.a();
        }
    }

    public void d() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (frsItemAcceleratorView = this.a) != null) {
            frsItemAcceleratorView.b();
        }
    }

    public void e() {
        FrsItemAcceleratorView frsItemAcceleratorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (frsItemAcceleratorView = this.a) != null) {
            frsItemAcceleratorView.c();
        }
    }
}
