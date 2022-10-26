package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.model.InterestSelectionStyleAModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class et7 implements ot7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterestSelectionStyleAModel a;
    public xs7 b;
    public BaseInterestSelectionFragment c;

    public et7(BaseInterestSelectionFragment baseInterestSelectionFragment, xs7 xs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestSelectionFragment, xs7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = baseInterestSelectionFragment;
        this.b = xs7Var;
        this.a = new InterestSelectionStyleAModel(xs7Var, this);
    }

    @Override // com.baidu.tieba.ot7
    public void a(Object obj) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (baseInterestSelectionFragment = this.c) != null) {
            baseInterestSelectionFragment.r1();
        }
    }

    public void b() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (interestSelectionStyleAModel = this.a) != null) {
            interestSelectionStyleAModel.onDestroy();
        }
    }

    public void c() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (interestSelectionStyleAModel = this.a) != null) {
            interestSelectionStyleAModel.E();
        }
    }

    @Override // com.baidu.tieba.ot7
    public void onError(int i, String str) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (baseInterestSelectionFragment = this.c) != null) {
            baseInterestSelectionFragment.s1(str);
        }
    }
}
