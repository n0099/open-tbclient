package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ha7 {
    public static /* synthetic */ Interceptable $ic;
    public static final ha7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947817067, "Lcom/baidu/tieba/ha7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947817067, "Lcom/baidu/tieba/ha7;");
                return;
            }
        }
        a = new ha7();
    }

    public ha7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final void b(AutoDegradeTagView.a aVar, u57 data, FrameLayout frame, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, aVar, data, frame, view2) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(frame, "$frame");
            if (aVar != null) {
                aVar.a(data, frame);
            }
        }
    }

    public final void a(Context context, LinearLayout container, final u57 data, final AutoDegradeTagView.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, container, data, aVar) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!data.g()) {
                return;
            }
            final FrameLayout frameLayout = new FrameLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = u57.m.a();
            layoutParams.gravity = 16;
            container.addView(frameLayout, layoutParams);
            String G = data.G();
            if (G != null && G.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                frameLayout.setClickable(false);
                frameLayout.setOnClickListener(null);
            } else {
                frameLayout.setClickable(true);
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.y97
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            ha7.b(AutoDegradeTagView.a.this, data, frameLayout, view2);
                        }
                    }
                });
            }
            if (data.j()) {
                ImageView imageView = new ImageView(context);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(data.l(u57.m.b(), u57.m.e()), u57.m.e());
                layoutParams2.gravity = 16;
                imageView.setBackgroundResource(dx5.a.b(data.h(), Boolean.FALSE));
                frameLayout.addView(imageView, layoutParams2);
                return;
            }
            TextView textView = new TextView(context);
            EMManager.from(textView).setTextSize(R.dimen.T_X10).setTextStyle(R.string.F_X02).setTextColor(dx5.a.c(data.h()));
            textView.setBackgroundResource(dx5.a.b(data.h(), Boolean.TRUE));
            textView.setText(data.i());
            textView.setGravity(16);
            textView.setPadding(u57.m.c(), 0, u57.m.d(), 0);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, u57.m.e());
            layoutParams3.gravity = 16;
            layoutParams3.rightMargin = u57.m.a();
            frameLayout.addView(textView);
        }
    }
}
