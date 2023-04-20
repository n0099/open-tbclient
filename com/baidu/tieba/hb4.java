package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hb4 extends cb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int j;
    public ib4 k;
    public ib4 l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb4 a;

        public a(hb4 hb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c == null || this.a.j < -1) {
                return;
            }
            if (this.a.j == -1) {
                this.a.c.o();
            } else {
                this.a.c.u(this.a.j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb4 a;

        public b(hb4 hb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb4Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                hb4 hb4Var = this.a;
                RecommendItemModel y = hb4Var.y(hb4Var.j);
                this.a.k.b.setImageURI(y.iconUrl);
                this.a.k.c.setText(y.appName);
                this.a.k.a.setAlpha(1.0f);
                hb4 hb4Var2 = this.a;
                RecommendItemModel y2 = this.a.y(hb4Var2.x(hb4Var2.j));
                this.a.l.b.setImageURI(y2.iconUrl);
                this.a.l.c.setText(y2.appName);
                this.a.l.a.setAlpha(0.0f);
                hb4.super.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb4(@NonNull Context context, @NonNull fb4 fb4Var) {
        super(context, fb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (fb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = -2;
    }

    @Override // com.baidu.tieba.cb4, com.baidu.tieba.db4
    public void d(kb4 kb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kb4Var) == null) {
            super.d(kb4Var);
            if (z(kb4Var)) {
                return;
            }
            this.j = -2;
            this.l.b.setImageURI(kb4Var.a.iconUrl);
            this.l.c.setText(kb4Var.a.appName);
        }
    }

    public final int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int i2 = i + 1;
            if (i2 == this.b.b.size()) {
                return -1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final RecommendItemModel y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == -1) {
                return this.b.a;
            }
            return this.b.b.get(i);
        }
        return (RecommendItemModel) invokeI.objValue;
    }

    public final boolean z(kb4 kb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kb4Var)) == null) {
            if (kb4Var != null && kb4Var.b != null && kb4Var.a != null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cb4
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a);
            ib4 ib4Var = new ib4(this.a);
            this.l = ib4Var;
            ib4Var.a.setAlpha(0.0f);
            frameLayout.addView(this.l.a);
            ib4 ib4Var2 = new ib4(this.a);
            this.k = ib4Var2;
            ib4Var2.a.setAlpha(0.0f);
            this.k.b.setActualImageResource(17170445);
            this.k.c.setText((CharSequence) null);
            frameLayout.addView(this.k.a);
            this.k.a.setOnClickListener(new a(this));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb4
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (z(this.b)) {
                this.k.a.setAlpha(1.0f);
                this.k.b.setActualImageResource(R.drawable.obfuscated_res_0x7f08016a);
                this.k.c.setText(R.string.obfuscated_res_0x7f0f1427);
                super.k();
                return;
            }
            this.j = x(this.j);
            this.l.a.animate().setDuration(160L).alpha(1.0f);
            this.k.a.animate().setDuration(160L).alpha(0.0f).setListener(new b(this));
        }
    }
}
