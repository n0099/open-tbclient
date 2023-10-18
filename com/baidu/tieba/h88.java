package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g88;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h88 extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public boolean c;
    public a d;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b(int i);
    }

    public h88(Context context, final View anchorView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, anchorView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        this.a = context;
        View view2 = new View(this.a);
        setContentView(view2);
        setWidth(0);
        setHeight(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setSoftInputMode(16);
        setInputMethodMode(1);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this);
        anchorView.post(new Runnable() { // from class: com.baidu.tieba.c88
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h88.a(h88.this, anchorView);
                }
            }
        });
    }

    public static final void a(h88 this$0, View anchorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, anchorView) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(anchorView, "$anchorView");
            this$0.showAtLocation(anchorView, 0, 0, 0);
        }
    }

    public final void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.d = aVar;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Rect rect = new Rect();
            getContentView().getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            if (i > this.b) {
                this.b = i;
            }
            int b = e88.b(this.a);
            int i2 = this.b - rect.bottom;
            if (i2 > b / 4) {
                z = true;
            } else {
                z = false;
            }
            if (!this.c && z) {
                this.c = true;
                a aVar = this.d;
                if (aVar != null) {
                    aVar.b(i2);
                }
                g88.a aVar2 = g88.k;
                g88.l = i2;
            } else if (this.c && !z) {
                this.c = false;
                a aVar3 = this.d;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
        }
    }
}
