package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.view.TopCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ap7 extends ab7<TopCardView, l57> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ki7 b;

    /* loaded from: classes5.dex */
    public class a implements TopCardView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l57 a;
        public final /* synthetic */ ap7 b;

        public a(ap7 ap7Var, l57 l57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap7Var, l57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ap7Var;
            this.a = l57Var;
        }

        @Override // com.baidu.tieba.forum.view.TopCardView.a
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                l57 l57Var = this.a;
                int i2 = 2;
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                l57Var.p(i);
                ki7 ki7Var = this.b.b;
                if (!z) {
                    i2 = 1;
                }
                ki7Var.A(i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap7() {
        super("feed_top_card");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ab7, com.baidu.tieba.qb7
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            TopCardView topCardView = new TopCardView(viewGroup.getContext());
            jd7.i(topCardView, Integer.valueOf(jd7.e() * 2));
            return topCardView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qb7
    /* renamed from: f */
    public void b(@NonNull TopCardView topCardView, @NonNull l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, topCardView, l57Var) == null) {
            if (topCardView.getContext() instanceof FragmentActivity) {
                ki7 D = bi7.m((FragmentActivity) topCardView.getContext()).D();
                this.b = D;
                D.y();
            }
            this.b.A(l57Var.l());
            this.b.x(topCardView, l57Var);
            topCardView.setUpdateFoldingListener(new a(this, l57Var));
            topCardView.f();
        }
    }
}
