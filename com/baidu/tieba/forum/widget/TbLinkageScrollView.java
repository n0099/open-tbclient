package com.baidu.tieba.forum.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hp7;
import com.baidu.tieba.ij;
import com.baidu.tieba.mp7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010!J\u001f\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010%J\u001f\u0010'\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010%J \u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012R$\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000f¨\u0006."}, d2 = {"Lcom/baidu/tieba/forum/widget/TbLinkageScrollView;", "Lcom/baidu/tieba/forum/widget/TbNestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomScrollTarget", "Lkotlin/Function0;", "Landroid/view/View;", "getBottomScrollTarget", "()Lkotlin/jvm/functions/Function0;", "setBottomScrollTarget", "(Lkotlin/jvm/functions/Function0;)V", "dispatchTouchEventHooks", "Ljava/util/ArrayList;", "Lcom/baidu/tieba/forum/widget/ILinkageTouchDispatchEvent;", "Lkotlin/collections/ArrayList;", "topScrollTarget", "getTopScrollTarget", "setTopScrollTarget", "addDispatchTouchEventHook", "", "hook", "handleDispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "handleDrag", "scroll", "(I)Ljava/lang/Boolean;", "handleFling", "handleNestedPreScrollFirst", "type", "(II)Ljava/lang/Boolean;", "handleNestedScrollFirst", "handleScrollSelf", "onNestedPreFling", "target", "velocityX", "", "velocityY", "removeDispatchTouchEventHook", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TbLinkageScrollView extends TbNestedScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Function0<? extends View> A;
    public final ArrayList<hp7> B;
    public Function0<? extends View> z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbLinkageScrollView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbLinkageScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbLinkageScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.B = new ArrayList<>();
    }

    public /* synthetic */ TbLinkageScrollView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void H(hp7 hook) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hook) == null) {
            Intrinsics.checkNotNullParameter(hook, "hook");
            if (this.B.contains(hook)) {
                return;
            }
            this.B.add(hook);
        }
    }

    public final Boolean I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (getScrollY() <= 0) {
                i /= 2;
            }
            scrollBy(0, i);
            return Boolean.TRUE;
        }
        return (Boolean) invokeI.objValue;
    }

    public final void K(hp7 hook) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hook) == null) {
            Intrinsics.checkNotNullParameter(hook, "hook");
            this.B.remove(hook);
        }
    }

    public final void setBottomScrollTarget(Function0<? extends View> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, function0) == null) {
            this.A = function0;
        }
    }

    public final void setTopScrollTarget(Function0<? extends View> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, function0) == null) {
            this.z = function0;
        }
    }

    public final Boolean J(int i) {
        InterceptResult invokeI;
        ij ijVar;
        View nestedScrollTarget;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View nestedScrollTarget2 = getNestedScrollTarget();
            View view2 = null;
            if (nestedScrollTarget2 instanceof ij) {
                ijVar = (ij) nestedScrollTarget2;
            } else {
                ijVar = null;
            }
            if (ijVar == null || (nestedScrollTarget = ijVar.getTarget()) == null) {
                nestedScrollTarget = getNestedScrollTarget();
            }
            if (mp7.a(this)) {
                boolean z = true;
                if ((nestedScrollTarget == null || !nestedScrollTarget.canScrollVertically(i)) ? false : false) {
                    nestedScrollTarget.scrollBy(0, i);
                    return Boolean.TRUE;
                }
            }
            if (canScrollVertically(i)) {
                return null;
            }
            if (i < 0) {
                Function0<? extends View> function0 = this.z;
                if (function0 != null) {
                    view2 = function0.invoke();
                }
            } else {
                Function0<? extends View> function02 = this.A;
                if (function02 != null) {
                    view2 = function02.invoke();
                }
            }
            if (view2 != null && view2.canScrollVertically(i)) {
                view2.scrollBy(0, i);
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeI.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function0<? extends android.view.View>, kotlin.jvm.functions.Function0<android.view.View> */
    public final Function0<View> getBottomScrollTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.A;
        }
        return (Function0) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function0<? extends android.view.View>, kotlin.jvm.functions.Function0<android.view.View> */
    public final Function0<View> getTopScrollTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.z;
        }
        return (Function0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{target, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            TbNestedScrollView.n(this, f2, null, 2, null);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean s(MotionEvent e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e)) == null) {
            Intrinsics.checkNotNullParameter(e, "e");
            Boolean bool = null;
            for (hp7 hp7Var : this.B) {
                if (Intrinsics.areEqual(hp7Var.a(e), Boolean.TRUE)) {
                    bool = Boolean.TRUE;
                }
            }
            if (bool == null) {
                return super.s(e);
            }
            return bool;
        }
        return (Boolean) invokeL.objValue;
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean u(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i, i2)) == null) {
            if (mp7.a(this)) {
                return null;
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeII.objValue;
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean x(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            return Boolean.TRUE;
        }
        return (Boolean) invokeII.objValue;
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean y(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            if (i2 == 0) {
                return I(i);
            }
            return J(i);
        }
        return (Boolean) invokeII.objValue;
    }
}
