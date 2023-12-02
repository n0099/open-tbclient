package com.baidu.tieba.im.biz.aibot.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.es8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/view/PersonChatCustomLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "event", "Lcom/baidu/tieba/im/biz/aibot/view/Event;", "eventCallback", "Lcom/baidu/tieba/im/biz/aibot/view/EventCallback;", "firstX", "", "firstY", "isNeedIntercept", "", "lastX", "lastY", "orientation", "", "getOrientation$annotations", "()V", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "setEventCallback", "", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonChatCustomLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public static final int i;
    public static final double j;
    public transient /* synthetic */ FieldHolder $fh;
    public Event a;
    public int b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public es8 g;

    public static /* synthetic */ void getOrientation$annotations() {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1787285518, "Lcom/baidu/tieba/im/biz/aibot/view/PersonChatCustomLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1787285518, "Lcom/baidu/tieba/im/biz/aibot/view/PersonChatCustomLayout;");
                return;
            }
        }
        h = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds600);
        i = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds30);
        j = Math.tan(0.5235987755982988d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonChatCustomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNull(context);
        this.a = Event.ETC;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        InterceptResult invokeL;
        es8 es8Var;
        es8 es8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            float x = event.getX();
            float y = event.getY();
            boolean z = true;
            int i2 = 0;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        this.a = Event.ETC;
                        this.b = 0;
                        es8 es8Var3 = this.g;
                        if (es8Var3 != null) {
                            es8Var3.c();
                        }
                        this.f = false;
                    } else {
                        float abs = Math.abs(x - this.d);
                        float abs2 = Math.abs(y - this.e);
                        float f = x - this.c;
                        if (this.a == Event.DOWN) {
                            int i3 = i;
                            if (abs > i3 || abs2 > i3) {
                                double d = abs2 / abs;
                                if (d <= j && this.f) {
                                    i2 = 1;
                                } else if (d > j) {
                                    i2 = 2;
                                }
                                this.b = i2;
                                this.a = Event.MOVE;
                                es8 es8Var4 = this.g;
                                if (es8Var4 != null) {
                                    es8Var4.d(i2);
                                }
                            }
                        }
                        if (this.f && this.b == 1 && (es8Var2 = this.g) != null) {
                            es8Var2.b(f);
                        }
                        this.c = event.getX();
                        event.getY();
                    }
                } else {
                    this.a = Event.UP;
                    this.b = 0;
                    es8 es8Var5 = this.g;
                    if (es8Var5 != null) {
                        es8Var5.c();
                    }
                    this.f = false;
                }
            } else {
                z = (y <= ((float) h) || y > ((float) getBottom())) ? false : false;
                this.f = z;
                this.d = x;
                this.e = y;
                this.c = x;
                this.a = Event.DOWN;
                if (z && (es8Var = this.g) != null) {
                    es8Var.a();
                }
            }
            return super.dispatchTouchEvent(event);
        }
        return invokeL.booleanValue;
    }

    public final void setEventCallback(es8 es8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, es8Var) == null) {
            this.g = es8Var;
        }
    }
}
