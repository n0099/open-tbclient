package com.baidu.tieba.ala.alasquare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NestScrollingTypedListView extends BdTypeListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NestedScrollingChildHelper J;
    public int[] K;
    public int[] L;
    public int[] M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public int R;

    public final boolean H(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            if (i <= 0 || i2 >= 0) {
                return i < 0 && i2 > 0;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestScrollingTypedListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = new int[2];
        this.L = new int[2];
        this.M = new int[2];
        this.Q = true;
        G();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestScrollingTypedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.K = new int[2];
        this.L = new int[2];
        this.M = new int[2];
        this.Q = true;
        G();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestScrollingTypedListView(Context context, AttributeSet attributeSet, int i) {
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
        this.K = new int[2];
        this.L = new int[2];
        this.M = new int[2];
        this.Q = true;
        G();
    }

    private void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.J = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.J.hasNestedScrollingParent();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.J.isNestedScrollingEnabled();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.J.stopNestedScroll();
        }
    }

    public final void I(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            this.R = 0;
            int[] iArr = this.K;
            iArr[1] = 0;
            iArr[0] = 0;
            this.N = MotionEventCompat.getPointerId(motionEvent, 0);
            this.O = (int) (motionEvent.getX() + 0.5f);
            this.P = (int) (motionEvent.getY() + 0.5f);
            startNestedScroll(2);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            return this.J.dispatchNestedFling(f, f2, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return this.J.dispatchNestedPreFling(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) {
            return this.J.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            return this.J.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                int[] iArr = this.K;
                iArr[1] = 0;
                iArr[0] = 0;
            }
            int[] iArr2 = this.K;
            obtain.offsetLocation(iArr2[0], iArr2[1]);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked == 5) {
                            this.N = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                            this.O = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                            this.P = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                        }
                    } else {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.N);
                        if (findPointerIndex < 0) {
                            Log.e("NestedListView", "Error processing scroll; pointer index for id " + this.N + " not found. Did any MotionEvents get skipped?");
                            return false;
                        }
                        int x = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
                        int y = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
                        int i = this.O - x;
                        int i2 = this.P - y;
                        if (this.Q) {
                            Log.i("pyt", "FIRST");
                            this.Q = false;
                            I(motionEvent);
                            return true;
                        } else if (!H(this.R, i2)) {
                            this.R = i2;
                            Log.i("pyt", "move lastY" + this.P + ",y=" + y + ",dy=" + i2);
                            if (dispatchNestedPreScroll(i, i2, this.L, this.M)) {
                                int[] iArr3 = this.M;
                                obtain.offsetLocation(iArr3[0], iArr3[1]);
                                int[] iArr4 = this.K;
                                int i3 = iArr4[0];
                                int[] iArr5 = this.M;
                                iArr4[0] = i3 + iArr5[0];
                                iArr4[1] = iArr4[1] + iArr5[1];
                            }
                            int[] iArr6 = this.M;
                            this.O = x - iArr6[0];
                            this.P = y - iArr6[1];
                        }
                    }
                } else {
                    stopNestedScroll();
                    this.Q = true;
                }
            } else {
                I(motionEvent);
            }
            super.onTouchEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.J.setNestedScrollingEnabled(z);
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return this.J.startNestedScroll(i);
        }
        return invokeI.booleanValue;
    }
}
