package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.nu;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hu extends os<fw4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public OriginalThreadCardView i;
    public fw4 j;
    public boolean k;
    public OriginalThreadCardView.b l;

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hu a;

        public a(hu huVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = huVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) && this.a.j != null && this.a.j.getThreadData() != null) {
                if (this.a.d() != null) {
                    this.a.d().a(this.a.i, this.a.j);
                }
                String id = this.a.j.getThreadData().getId();
                xl6.a(id);
                this.a.x(id);
                this.a.a.q(new nu.a(1));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306752, "Lcom/baidu/tieba/hu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306752, "Lcom/baidu/tieba/hu;");
                return;
            }
        }
        m = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hu(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = new a(this);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().p != null && TbadkCoreApplication.getInst().getPersonalizeViewData().p.getParent() == null) {
            this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().p;
        } else {
            this.f = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        }
        this.g = (TextView) this.f.findViewById(R.id.thread_card_title);
        this.h = (TextView) this.f.findViewById(R.id.thread_card_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) this.f.findViewById(R.id.original_thread_view);
        this.i = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.l);
    }

    @Override // com.baidu.tieba.os
    public void n(mm6<fw4> mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mm6Var) == null) {
            super.n(mm6Var);
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            xl6.l(this.g, str, R.color.CAM_X0105, R.color.CAM_X0109);
            xl6.l(this.h, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.i.setReadState(xl6.k(str));
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.k = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i.m = i;
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.i.s();
        }
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: u */
    public void onBindDataToView(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, fw4Var) == null) && fw4Var != null && fw4Var.getThreadData() != null) {
            this.j = fw4Var;
            ThreadCardUtils.setTitle(this.g, fw4Var.getThreadData(), this.k);
            ThreadCardUtils.setAbstract(this.h, this.g, fw4Var.getThreadData(), m, this.k);
            this.i.i(fw4Var.getThreadData().originalThreadData);
        }
    }
}
