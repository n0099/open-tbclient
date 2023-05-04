package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class hs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Activity a;
    @NonNull
    public final ViewGroup b;
    @NonNull
    public int[] c;
    @Nullable
    public c d;
    @Nullable
    public d e;

    /* loaded from: classes4.dex */
    public interface c {
        void a(@NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a();
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs5 a;

        public a(hs5 hs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<Rect> a;
        public final /* synthetic */ hs5 b;

        public b(hs5 hs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hs5Var;
            this.a = new ArrayList();
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.b.e != null && !this.b.e.a()) {
                    return false;
                }
                this.a.clear();
                int[] iArr = new int[2];
                int[] iArr2 = this.b.c;
                int length = iArr2.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        break;
                    }
                    View findViewById = this.b.a.findViewById(iArr2[i]);
                    if (findViewById != null) {
                        findViewById.getLocationOnScreen(iArr);
                        this.a.add(new Rect(iArr[0], iArr[1], iArr[0] + findViewById.getWidth(), iArr[1] + findViewById.getHeight()));
                    }
                    i++;
                }
                if (motionEvent.getAction() == 0) {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    Iterator<Rect> it = this.a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().contains(rawX, rawY)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z && this.b.d != null) {
                        this.b.d.a(motionEvent);
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public hs5(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new int[0];
        this.a = activity;
        this.b = (ViewGroup) activity.findViewById(16908290);
    }

    public static hs5 g(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) {
            return new hs5(activity);
        }
        return (hs5) invokeL.objValue;
    }

    @NonNull
    public hs5 i(@Nullable c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            this.d = cVar;
            return this;
        }
        return (hs5) invokeL.objValue;
    }

    @NonNull
    public hs5 j(@IdRes int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iArr)) == null) {
            this.c = iArr;
            return this;
        }
        return (hs5) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.post(new a(this));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View view2 = new View(this.a);
            view2.setOnTouchListener(new b(this));
            this.b.addView(view2, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
