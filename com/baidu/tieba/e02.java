package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class e02 extends tz1<CanvasView, bz1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public CanvasView i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CanvasView.c a;

        public a(e02 e02Var, CanvasView.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e02Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cVar = this.a) != null) {
                cVar.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends kj3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e02 e02Var, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e02Var, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = z;
        }

        @Override // com.baidu.tieba.kj3, android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.j && super.onTouch(view2, motionEvent)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e02(@NonNull Context context, @NonNull bz1 bz1Var) {
        super(context, bz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (uz1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CanvasView canvasView = new CanvasView(context);
        this.i = canvasView;
        canvasView.setInterceptTouchEvent(bz1Var.j);
        this.i.setHide(bz1Var.f);
        this.i.setGesture(bz1Var.g);
        if (bz1Var.g) {
            this.i.setInterceptTouchEvent(false);
        }
    }

    public boolean F(bz1 bz1Var, CanvasView.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bz1Var, cVar)) == null) {
            if (bz1Var != null && (bz1Var instanceof cz1)) {
                bz1 n = n();
                if (!TextUtils.equals(n.b, bz1Var.b) || !TextUtils.equals(n.c, bz1Var.c)) {
                    x02.a("Component-Canvas", "drawCanvas with illegal ids!");
                }
                cz1 cz1Var = (cz1) bz1Var;
                this.i.c(cz1Var.h(), cz1Var.i());
                this.i.postInvalidate();
                this.i.post(new a(this, cVar));
                return true;
            }
            e12.c("Component-Canvas", "some params is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tz1
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: G */
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull bz1 bz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, bz1Var) == null) {
            swanAppComponentContainerView.setOnTouchListener(new b(this, bz1Var.c, bz1Var.b, bz1Var.a, bz1Var.g));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tz1
    @NonNull
    /* renamed from: H */
    public CanvasView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            return this.i;
        }
        return (CanvasView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tz1
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.z();
            this.i.f();
        }
    }
}
