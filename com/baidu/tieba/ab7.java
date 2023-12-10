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
/* loaded from: classes5.dex */
public final class ab7 {
    public static /* synthetic */ Interceptable $ic;
    public static final ab7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947609491, "Lcom/baidu/tieba/ab7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947609491, "Lcom/baidu/tieba/ab7;");
                return;
            }
        }
        a = new ab7();
    }

    public ab7() {
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

    public static final void b(AutoDegradeTagView.a aVar, m67 data, FrameLayout frame, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, aVar, data, frame, view2) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(frame, "$frame");
            if (aVar != null) {
                aVar.a(data, frame);
            }
        }
    }

    public final void a(Context context, LinearLayout container, final m67 data, final AutoDegradeTagView.a aVar, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, container, data, aVar, Integer.valueOf(i)}) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!data.f()) {
                return;
            }
            final FrameLayout frameLayout = new FrameLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = i;
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
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qa7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            ab7.b(AutoDegradeTagView.a.this, data, frameLayout, view2);
                        }
                    }
                });
            }
            if (data.i()) {
                ImageView imageView = new ImageView(context);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(data.k(m67.m.a(), m67.m.d()), m67.m.d());
                layoutParams2.gravity = 16;
                imageView.setBackgroundResource(px5.a.b(data.g(), Boolean.FALSE));
                frameLayout.addView(imageView, layoutParams2);
                return;
            }
            TextView textView = new TextView(context);
            EMManager.from(textView).setTextSize(R.dimen.T_X10).setTextStyle(R.string.F_X02).setTextColor(px5.a.c(data.g()));
            textView.setBackgroundResource(px5.a.b(data.g(), Boolean.TRUE));
            textView.setText(data.h());
            textView.setGravity(16);
            textView.setPadding(m67.m.b(), 0, m67.m.c(), 0);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, m67.m.d());
            layoutParams3.gravity = 16;
            layoutParams3.rightMargin = i;
            frameLayout.addView(textView);
        }
    }
}
