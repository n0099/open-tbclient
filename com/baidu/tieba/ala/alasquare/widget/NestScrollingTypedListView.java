package com.baidu.tieba.ala.alasquare.widget;

import android.content.Context;
import android.util.AttributeSet;
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
/* loaded from: classes5.dex */
public class NestScrollingTypedListView extends BdTypeListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NestedScrollingChildHelper N;
    public int[] O;
    public int[] P;
    public int[] Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public int V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestScrollingTypedListView(Context context) {
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
        this.O = new int[2];
        this.P = new int[2];
        this.Q = new int[2];
        this.U = true;
        x();
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.N = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.N.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.N.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.N.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.N.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.N.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.N.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                int[] iArr = this.O;
                iArr[1] = 0;
                iArr[0] = 0;
            }
            int[] iArr2 = this.O;
            obtain.offsetLocation(iArr2[0], iArr2[1]);
            if (actionMasked == 0) {
                z(motionEvent);
            } else if (actionMasked == 1) {
                stopNestedScroll();
                this.U = true;
            } else if (actionMasked == 2) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.R);
                if (findPointerIndex < 0) {
                    String str = "Error processing scroll; pointer index for id " + this.R + " not found. Did any MotionEvents get skipped?";
                    return false;
                }
                int x = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
                int y = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
                int i2 = this.S - x;
                int i3 = this.T - y;
                if (this.U) {
                    this.U = false;
                    z(motionEvent);
                    return true;
                } else if (!y(this.V, i3)) {
                    this.V = i3;
                    String str2 = "move lastY" + this.T + ",y=" + y + ",dy=" + i3;
                    if (dispatchNestedPreScroll(i2, i3, this.P, this.Q)) {
                        int[] iArr3 = this.Q;
                        obtain.offsetLocation(iArr3[0], iArr3[1]);
                        int[] iArr4 = this.O;
                        int i4 = iArr4[0];
                        int[] iArr5 = this.Q;
                        iArr4[0] = i4 + iArr5[0];
                        iArr4[1] = iArr4[1] + iArr5[1];
                    }
                    int[] iArr6 = this.Q;
                    this.S = x - iArr6[0];
                    this.T = y - iArr6[1];
                }
            } else if (actionMasked == 5) {
                this.R = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.S = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                this.T = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
            }
            super.onTouchEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.N.setNestedScrollingEnabled(z);
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? this.N.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.N.stopNestedScroll();
        }
    }

    public final boolean y(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            if (i2 <= 0 || i3 >= 0) {
                return i2 < 0 && i3 > 0;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public final void z(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, motionEvent) == null) {
            this.V = 0;
            int[] iArr = this.O;
            iArr[1] = 0;
            iArr[0] = 0;
            this.R = MotionEventCompat.getPointerId(motionEvent, 0);
            this.S = (int) (motionEvent.getX() + 0.5f);
            this.T = (int) (motionEvent.getY() + 0.5f);
            startNestedScroll(2);
        }
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
        this.O = new int[2];
        this.P = new int[2];
        this.Q = new int[2];
        this.U = true;
        x();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestScrollingTypedListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.O = new int[2];
        this.P = new int[2];
        this.Q = new int[2];
        this.U = true;
        x();
    }
}
