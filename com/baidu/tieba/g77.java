package com.baidu.tieba;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class g77 extends LinkMovementMethod {
    public static /* synthetic */ Interceptable $ic;
    public static final g77 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746914, "Lcom/baidu/tieba/g77;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746914, "Lcom/baidu/tieba/g77;");
                return;
            }
        }
        a = new g77();
    }

    public g77() {
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

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, widget, buffer, event)) == null) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (action == 0 || action == 1) {
                int x = ((int) event.getX()) - widget.getTotalPaddingLeft();
                int y = ((int) event.getY()) - widget.getTotalPaddingTop();
                int scrollX = x + widget.getScrollX();
                int scrollY = y + widget.getScrollY();
                Layout layout = widget.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                ClickableSpan[] links = (ClickableSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                Intrinsics.checkNotNullExpressionValue(links, "links");
                if (links.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    ClickableSpan clickableSpan = links[0];
                    if (action == 1 && clickableSpan != null) {
                        clickableSpan.onClick(widget);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
