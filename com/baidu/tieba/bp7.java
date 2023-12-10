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
public class bp7 extends bb7<TopCardView, l57> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public li7 b;

    /* loaded from: classes5.dex */
    public class a implements TopCardView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l57 a;
        public final /* synthetic */ bp7 b;

        public a(bp7 bp7Var, l57 l57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp7Var, l57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bp7Var;
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
                li7 li7Var = this.b.b;
                if (!z) {
                    i2 = 1;
                }
                li7Var.A(i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp7() {
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

    @Override // com.baidu.tieba.bb7, com.baidu.tieba.rb7
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            TopCardView topCardView = new TopCardView(viewGroup.getContext());
            kd7.i(topCardView, Integer.valueOf(kd7.e() * 2));
            return topCardView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rb7
    /* renamed from: f */
    public void b(@NonNull TopCardView topCardView, @NonNull l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, topCardView, l57Var) == null) {
            if (topCardView.getContext() instanceof FragmentActivity) {
                li7 D = ci7.m((FragmentActivity) topCardView.getContext()).D();
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
