package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.constant.FeedPicDecorationDirection;
import com.baidu.tieba.feed.constant.FeedPicDecorationLocation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ba7 {
    public static /* synthetic */ Interceptable $ic;
    public static final ba7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638321, "Lcom/baidu/tieba/ba7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638321, "Lcom/baidu/tieba/ba7;");
                return;
            }
        }
        a = new ba7();
    }

    public ba7() {
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

    public final void a(Context context, g77 decorationData, ViewGroup container) {
        jd7 jd7Var;
        View a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, decorationData, container) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(decorationData, "decorationData");
            Intrinsics.checkNotNullParameter(container, "container");
            if (Intrinsics.areEqual(decorationData.c(), "live_lottie")) {
                jd7Var = new jd7();
            } else {
                jd7Var = null;
            }
            if (jd7Var != null && (a2 = jd7Var.a(context, decorationData.a())) != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                FeedPicDecorationLocation d = a.d(decorationData.b());
                layoutParams.gravity = d.getLocationGravity();
                layoutParams.setMargins(a.c(d, FeedPicDecorationDirection.LEFT), a.c(d, FeedPicDecorationDirection.TOP), a.c(d, FeedPicDecorationDirection.RIGHT), a.c(d, FeedPicDecorationDirection.BOTTOM));
                a2.setTag("decoration_view");
                container.addView(a2, layoutParams);
            }
        }
    }

    public final void b(FrameLayout container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            ArrayList<View> arrayList = new ArrayList();
            int childCount = container.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = container.getChildAt(i);
                if (Intrinsics.areEqual(child.getTag(), "decoration_view")) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    arrayList.add(child);
                }
            }
            for (View view2 : arrayList) {
                container.removeView(view2);
            }
        }
    }

    public final int c(FeedPicDecorationLocation feedPicDecorationLocation, FeedPicDecorationDirection feedPicDecorationDirection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, feedPicDecorationLocation, feedPicDecorationDirection)) == null) {
            if ((feedPicDecorationLocation.getLocationCode() & feedPicDecorationDirection.getDirection()) != 0) {
                return feedPicDecorationDirection.getMarginValue();
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public final FeedPicDecorationLocation d(String str) {
        InterceptResult invokeL;
        FeedPicDecorationLocation[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            for (FeedPicDecorationLocation feedPicDecorationLocation : FeedPicDecorationLocation.values()) {
                if (Intrinsics.areEqual(feedPicDecorationLocation.getLocationText(), str)) {
                    return feedPicDecorationLocation;
                }
            }
            return FeedPicDecorationLocation.LEFT_TOP;
        }
        return (FeedPicDecorationLocation) invokeL.objValue;
    }
}
