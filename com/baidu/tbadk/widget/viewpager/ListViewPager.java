package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ListViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f49087e;

    /* renamed from: f  reason: collision with root package name */
    public float f49088f;

    /* renamed from: g  reason: collision with root package name */
    public float f49089g;

    /* renamed from: h  reason: collision with root package name */
    public float f49090h;

    /* renamed from: i  reason: collision with root package name */
    public GestureDetector f49091i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49092j;
    public SwipeBackLayout.c k;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ListViewPager f49093e;

        public b(ListViewPager listViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49093e = listViewPager;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f49093e.k != null) {
                    this.f49093e.k.enableSwipeBack();
                }
                return Math.abs(f2) > Math.abs(f3);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ b(ListViewPager listViewPager, a aVar) {
            this(listViewPager);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewPager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49092j = false;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f49091i = new GestureDetector((Context) null, new b(this, null));
        }
    }

    public final boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = (motionEvent.getAction() & 65280) >> 8;
            return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (c(motionEvent)) {
                return true;
            }
            if (this.f49092j) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                try {
                    return super.onInterceptTouchEvent(motionEvent);
                } catch (Exception unused) {
                    return false;
                }
            }
            if (getCurrentItem() != 0 && this.f49091i.onTouchEvent(motionEvent)) {
                requestParentInterceptTouchEvent(true);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception unused2) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
        if (r0 != 6) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        if (this.f49092j) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    SwipeBackLayout.c cVar = this.k;
                    if (cVar != null) {
                        cVar.enableSwipeBack();
                    }
                    this.f49089g = motionEvent.getX() - this.f49087e;
                    this.f49090h = motionEvent.getY() - this.f49088f;
                    this.f49087e = motionEvent.getX();
                    this.f49088f = motionEvent.getY();
                    if (getCurrentItem() != 0 && Math.abs(this.f49089g) > Math.abs(this.f49090h)) {
                        requestParentInterceptTouchEvent(true);
                    }
                } else if (action != 3) {
                    if (action != 5) {
                    }
                }
                if (c(motionEvent)) {
                    return true;
                }
                try {
                    return super.onTouchEvent(motionEvent);
                } catch (IllegalArgumentException unused2) {
                    return true;
                }
            }
            SwipeBackLayout.c cVar2 = this.k;
            if (cVar2 != null) {
                cVar2.enableSwipeBack();
            }
            this.f49087e = 0.0f;
            this.f49088f = 0.0f;
            this.f49089g = 0.0f;
            this.f49090h = 0.0f;
            if (c(motionEvent)) {
            }
        }
        SwipeBackLayout.c cVar3 = this.k;
        if (cVar3 != null) {
            cVar3.enableSwipeBack();
        }
        this.f49087e = motionEvent.getX();
        this.f49088f = motionEvent.getY();
        if (c(motionEvent)) {
        }
    }

    public final void requestParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void setDisableParentEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f49092j = z;
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.k = cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewPager(Context context, AttributeSet attributeSet) {
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
        this.f49092j = false;
        b();
    }
}
