package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GridLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f30835b;

    /* renamed from: c  reason: collision with root package name */
    public int f30836c;

    /* renamed from: d  reason: collision with root package name */
    public int f30837d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30838e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30839f;

    /* renamed from: g  reason: collision with root package name */
    public int f30840g;

    /* renamed from: h  reason: collision with root package name */
    public int f30841h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private View[] getNeedLayoutChild() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            this.f30841h = this.a;
            this.f30840g = this.f30835b;
            int childCount = getChildCount();
            int childCount2 = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.getVisibility() == 8) {
                    childCount2--;
                }
            }
            int i3 = this.f30841h;
            if (i3 <= 0 || (i = this.f30840g) <= 0) {
                int i4 = this.f30841h;
                if (i4 > 0) {
                    if (childCount % i4 == 0) {
                        this.f30840g = childCount / i4;
                    } else {
                        this.f30840g = (childCount / i4) + 1;
                    }
                } else {
                    int i5 = this.f30840g;
                    if (i5 > 0) {
                        if (childCount % i5 == 0) {
                            this.f30841h = childCount / i5;
                        } else {
                            this.f30841h = (childCount / i5) + 1;
                        }
                    } else if (this.f30838e) {
                        this.f30841h = childCount;
                        this.f30840g = 1;
                    } else {
                        this.f30841h = 1;
                        this.f30840g = childCount;
                    }
                }
            } else {
                childCount = i3 * i;
            }
            int min = Math.min(childCount, childCount2);
            View[] viewArr = new View[min];
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt2 = getChildAt(i7);
                if (childAt2 != null && childAt2.getVisibility() != 8 && i6 < min) {
                    viewArr[i6] = childAt2;
                    i6++;
                }
            }
            return viewArr;
        }
        return (View[]) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LayoutParams(-1, -1) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    public final void d(Context context, AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040261, R.attr.obfuscated_res_0x7f040263, R.attr.obfuscated_res_0x7f040265, R.attr.obfuscated_res_0x7f040268, R.attr.obfuscated_res_0x7f04026a});
            boolean z = true;
            try {
                this.f30836c = obtainStyledAttributes.getDimensionPixelSize(1, 0);
                this.f30837d = obtainStyledAttributes.getDimensionPixelSize(4, 0);
                this.a = obtainStyledAttributes.getInteger(0, -1);
                this.f30835b = obtainStyledAttributes.getInteger(3, -1);
                if (obtainStyledAttributes.getInteger(2, 0) != 0) {
                    z = false;
                }
                this.f30838e = z;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public int getHorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.intValue;
    }

    public int getHorSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30836c : invokeV.intValue;
    }

    public int getVerNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30835b : invokeV.intValue;
    }

    public int getVerSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30837d : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            View[] needLayoutChild = getNeedLayoutChild();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int i10 = this.a;
            int i11 = this.f30836c;
            int i12 = (measuredWidth - (i10 * i11)) + i11;
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int i13 = this.f30835b;
            int i14 = this.f30837d;
            int i15 = i12 / this.a;
            int i16 = ((measuredHeight - (i13 * i14)) + i14) / i13;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i17 = 0;
            while (i17 < needLayoutChild.length) {
                View view = needLayoutChild[i17];
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                int i18 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                int i19 = ((FrameLayout.LayoutParams) layoutParams).topMargin;
                int i20 = ((FrameLayout.LayoutParams) layoutParams).gravity & 7;
                if (i20 == 1) {
                    i5 = (i15 - measuredWidth2) / 2;
                } else if (i20 != 5) {
                    i6 = i18 + 0;
                    i7 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
                    if (i7 != 16) {
                        i8 = (i16 - measuredHeight2) / 2;
                    } else if (i7 != 80) {
                        i9 = i19 + 0;
                        view.layout(paddingLeft + i6, paddingTop + i9, measuredWidth2 + paddingLeft + i6, measuredHeight2 + paddingTop + i9);
                        paddingLeft += this.f30836c + i15;
                        i17++;
                        if (i17 % this.f30841h == 0 || i17 == needLayoutChild.length) {
                            paddingLeft = getPaddingLeft();
                            paddingTop += this.f30837d + i16;
                        }
                    } else {
                        i8 = i16 - measuredHeight2;
                    }
                    i9 = i19 + i8;
                    view.layout(paddingLeft + i6, paddingTop + i9, measuredWidth2 + paddingLeft + i6, measuredHeight2 + paddingTop + i9);
                    paddingLeft += this.f30836c + i15;
                    i17++;
                    if (i17 % this.f30841h == 0) {
                    }
                    paddingLeft = getPaddingLeft();
                    paddingTop += this.f30837d + i16;
                } else {
                    i5 = i15 - measuredWidth2;
                }
                i6 = i18 + i5;
                i7 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
                if (i7 != 16) {
                }
                i9 = i19 + i8;
                view.layout(paddingLeft + i6, paddingTop + i9, measuredWidth2 + paddingLeft + i6, measuredHeight2 + paddingTop + i9);
                paddingLeft += this.f30836c + i15;
                i17++;
                if (i17 % this.f30841h == 0) {
                }
                paddingLeft = getPaddingLeft();
                paddingTop += this.f30837d + i16;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i);
            View.MeasureSpec.getSize(i2);
            View[] needLayoutChild = getNeedLayoutChild();
            if (this.f30839f) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    measureChild(getChildAt(i4), i, i2);
                }
            } else {
                for (View view : needLayoutChild) {
                    measureChild(view, i, i2);
                }
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (mode != 0 && mode != Integer.MIN_VALUE) {
                i3 = getMeasuredWidth();
            } else {
                int i5 = paddingLeft;
                int i6 = 0;
                while (i6 < needLayoutChild.length) {
                    View view2 = needLayoutChild[i6];
                    LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                    paddingLeft = paddingLeft + this.f30836c + view2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams).leftMargin + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    i6++;
                    if (i6 % this.f30841h == 0 || i6 == needLayoutChild.length) {
                        i5 = Math.max(getMeasuredWidth(), paddingLeft);
                        paddingLeft = getPaddingLeft() + getPaddingRight();
                    }
                }
                i3 = i5;
            }
            if (mode2 != 0 && mode2 != Integer.MIN_VALUE) {
                paddingTop = getMeasuredHeight();
            } else {
                int i7 = 0;
                int i8 = 0;
                while (i7 < needLayoutChild.length) {
                    View view3 = needLayoutChild[i7];
                    LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                    i8 = Math.max(i8, view3.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin);
                    i7++;
                    if (i7 % this.f30841h == 0 || i7 == needLayoutChild.length) {
                        paddingTop += i8;
                        i8 = getPaddingTop() + getPaddingBottom();
                    }
                }
            }
            setMeasuredDimension(i3, paddingTop);
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int i9 = this.a;
            int i10 = this.f30836c;
            int i11 = (measuredWidth - (i9 * i10)) + i10;
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int i12 = this.f30835b;
            int i13 = this.f30837d;
            int i14 = i11 / this.a;
            int i15 = ((measuredHeight - (i12 * i13)) + i13) / i12;
            for (View view4 : needLayoutChild) {
                LayoutParams layoutParams3 = (LayoutParams) view4.getLayoutParams();
                int measuredWidth2 = view4.getMeasuredWidth();
                int measuredHeight2 = view4.getMeasuredHeight();
                if (((FrameLayout.LayoutParams) layoutParams3).width == -1) {
                    measuredWidth2 = (i14 - ((FrameLayout.LayoutParams) layoutParams3).leftMargin) - ((FrameLayout.LayoutParams) layoutParams3).rightMargin;
                }
                if (((FrameLayout.LayoutParams) layoutParams3).height == -1) {
                    measuredHeight2 = (i15 - ((FrameLayout.LayoutParams) layoutParams3).topMargin) - ((FrameLayout.LayoutParams) layoutParams3).bottomMargin;
                }
                view4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public void setHorNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            boolean z = this.a != i;
            this.a = i;
            if (z) {
                forceLayout();
            }
        }
    }

    public void setHorSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            boolean z = this.f30836c != i;
            this.f30836c = i;
            if (z) {
                forceLayout();
            }
        }
    }

    public void setMeasureAllChild(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f30839f = z;
        }
    }

    public void setOrientionHor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f30838e = z;
        }
    }

    public void setVerNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            boolean z = this.f30835b != i;
            this.f30835b = i;
            if (z) {
                forceLayout();
            }
        }
    }

    public void setVerSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            boolean z = this.f30837d != i;
            this.f30837d = i;
            if (z) {
                forceLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            ((FrameLayout.LayoutParams) this).gravity = 17;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ((FrameLayout.LayoutParams) this).gravity = 17;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            ((FrameLayout.LayoutParams) this).gravity = 17;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.a = -1;
        this.f30835b = -1;
        this.f30836c = 0;
        this.f30837d = 0;
        this.f30838e = true;
        this.f30839f = false;
        d(context, attributeSet, i);
    }
}
