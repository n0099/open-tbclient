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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40015e;

    /* renamed from: f  reason: collision with root package name */
    public int f40016f;

    /* renamed from: g  reason: collision with root package name */
    public int f40017g;

    /* renamed from: h  reason: collision with root package name */
    public int f40018h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40019i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40020j;
    public int k;
    public int l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            this.l = this.f40015e;
            this.k = this.f40016f;
            int childCount = getChildCount();
            int childCount2 = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt == null || childAt.getVisibility() == 8) {
                    childCount2--;
                }
            }
            int i4 = this.l;
            if (i4 <= 0 || (i2 = this.k) <= 0) {
                int i5 = this.l;
                if (i5 > 0) {
                    if (childCount % i5 == 0) {
                        this.k = childCount / i5;
                    } else {
                        this.k = (childCount / i5) + 1;
                    }
                } else {
                    int i6 = this.k;
                    if (i6 > 0) {
                        if (childCount % i6 == 0) {
                            this.l = childCount / i6;
                        } else {
                            this.l = (childCount / i6) + 1;
                        }
                    } else if (this.f40019i) {
                        this.l = childCount;
                        this.k = 1;
                    } else {
                        this.l = 1;
                        this.k = childCount;
                    }
                }
            } else {
                childCount = i4 * i2;
            }
            int min = Math.min(childCount, childCount2);
            View[] viewArr = new View[min];
            int i7 = 0;
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                View childAt2 = getChildAt(i8);
                if (childAt2 != null && childAt2.getVisibility() != 8 && i7 < min) {
                    viewArr[i7] = childAt2;
                    i7++;
                }
            }
            return viewArr;
        }
        return (View[]) invokeV.objValue;
    }

    public final void a(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.column_count, R.attr.gridHorizontalNum, R.attr.gridHorizontalSpacing, R.attr.gridMainOrientation, R.attr.gridVerticalNum, R.attr.gridVerticalSpacing, R.attr.horizontal_spacing, R.attr.vertical_spacing});
            try {
                this.f40017g = obtainStyledAttributes.getDimensionPixelSize(2, 0);
                this.f40018h = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                this.f40015e = obtainStyledAttributes.getInteger(1, -1);
                this.f40016f = obtainStyledAttributes.getInteger(4, -1);
                this.f40019i = obtainStyledAttributes.getInteger(3, 0) == 0;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    public int getHorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40015e : invokeV.intValue;
    }

    public int getHorSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40017g : invokeV.intValue;
    }

    public int getVerNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40016f : invokeV.intValue;
    }

    public int getVerSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f40018h : invokeV.intValue;
    }

    public boolean isMeasureAllChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f40020j : invokeV.booleanValue;
    }

    public boolean isOrientionHor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40019i : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            View[] needLayoutChild = getNeedLayoutChild();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int i11 = this.f40015e;
            int i12 = this.f40017g;
            int i13 = (measuredWidth - (i11 * i12)) + i12;
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int i14 = this.f40016f;
            int i15 = this.f40018h;
            int i16 = i13 / this.f40015e;
            int i17 = ((measuredHeight - (i14 * i15)) + i15) / i14;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i18 = 0;
            while (i18 < needLayoutChild.length) {
                View view = needLayoutChild[i18];
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                int i19 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                int i20 = ((FrameLayout.LayoutParams) layoutParams).topMargin;
                int i21 = ((FrameLayout.LayoutParams) layoutParams).gravity & 7;
                if (i21 == 1) {
                    i6 = (i16 - measuredWidth2) / 2;
                } else if (i21 != 5) {
                    i7 = i19 + 0;
                    i8 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
                    if (i8 != 16) {
                        i9 = (i17 - measuredHeight2) / 2;
                    } else if (i8 != 80) {
                        i10 = i20 + 0;
                        view.layout(paddingLeft + i7, paddingTop + i10, measuredWidth2 + paddingLeft + i7, measuredHeight2 + paddingTop + i10);
                        paddingLeft += this.f40017g + i16;
                        i18++;
                        if (i18 % this.l == 0 || i18 == needLayoutChild.length) {
                            paddingLeft = getPaddingLeft();
                            paddingTop += this.f40018h + i17;
                        }
                    } else {
                        i9 = i17 - measuredHeight2;
                    }
                    i10 = i20 + i9;
                    view.layout(paddingLeft + i7, paddingTop + i10, measuredWidth2 + paddingLeft + i7, measuredHeight2 + paddingTop + i10);
                    paddingLeft += this.f40017g + i16;
                    i18++;
                    if (i18 % this.l == 0) {
                    }
                    paddingLeft = getPaddingLeft();
                    paddingTop += this.f40018h + i17;
                } else {
                    i6 = i16 - measuredWidth2;
                }
                i7 = i19 + i6;
                i8 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
                if (i8 != 16) {
                }
                i10 = i20 + i9;
                view.layout(paddingLeft + i7, paddingTop + i10, measuredWidth2 + paddingLeft + i7, measuredHeight2 + paddingTop + i10);
                paddingLeft += this.f40017g + i16;
                i18++;
                if (i18 % this.l == 0) {
                }
                paddingLeft = getPaddingLeft();
                paddingTop += this.f40018h + i17;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i2);
            View.MeasureSpec.getSize(i3);
            View[] needLayoutChild = getNeedLayoutChild();
            if (this.f40020j) {
                for (int i5 = 0; i5 < getChildCount(); i5++) {
                    measureChild(getChildAt(i5), i2, i3);
                }
            } else {
                for (View view : needLayoutChild) {
                    measureChild(view, i2, i3);
                }
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (mode != 0 && mode != Integer.MIN_VALUE) {
                i4 = getMeasuredWidth();
            } else {
                int i6 = paddingLeft;
                int i7 = 0;
                while (i7 < needLayoutChild.length) {
                    View view2 = needLayoutChild[i7];
                    LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                    paddingLeft = paddingLeft + this.f40017g + view2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams).leftMargin + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    i7++;
                    if (i7 % this.l == 0 || i7 == needLayoutChild.length) {
                        i6 = Math.max(getMeasuredWidth(), paddingLeft);
                        paddingLeft = getPaddingLeft() + getPaddingRight();
                    }
                }
                i4 = i6;
            }
            if (mode2 != 0 && mode2 != Integer.MIN_VALUE) {
                paddingTop = getMeasuredHeight();
            } else {
                int i8 = 0;
                int i9 = 0;
                while (i8 < needLayoutChild.length) {
                    View view3 = needLayoutChild[i8];
                    LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                    i9 = Math.max(i9, view3.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin);
                    i8++;
                    if (i8 % this.l == 0 || i8 == needLayoutChild.length) {
                        paddingTop += i9;
                        i9 = getPaddingTop() + getPaddingBottom();
                    }
                }
            }
            setMeasuredDimension(i4, paddingTop);
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int i10 = this.f40015e;
            int i11 = this.f40017g;
            int i12 = (measuredWidth - (i10 * i11)) + i11;
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int i13 = this.f40016f;
            int i14 = this.f40018h;
            int i15 = i12 / this.f40015e;
            int i16 = ((measuredHeight - (i13 * i14)) + i14) / i13;
            for (View view4 : needLayoutChild) {
                LayoutParams layoutParams3 = (LayoutParams) view4.getLayoutParams();
                int measuredWidth2 = view4.getMeasuredWidth();
                int measuredHeight2 = view4.getMeasuredHeight();
                if (((FrameLayout.LayoutParams) layoutParams3).width == -1) {
                    measuredWidth2 = (i15 - ((FrameLayout.LayoutParams) layoutParams3).leftMargin) - ((FrameLayout.LayoutParams) layoutParams3).rightMargin;
                }
                if (((FrameLayout.LayoutParams) layoutParams3).height == -1) {
                    measuredHeight2 = (i16 - ((FrameLayout.LayoutParams) layoutParams3).topMargin) - ((FrameLayout.LayoutParams) layoutParams3).bottomMargin;
                }
                view4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public void setHorNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            boolean z = this.f40015e != i2;
            this.f40015e = i2;
            if (z) {
                forceLayout();
            }
        }
    }

    public void setHorSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            boolean z = this.f40017g != i2;
            this.f40017g = i2;
            if (z) {
                forceLayout();
            }
        }
    }

    public void setMeasureAllChild(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f40020j = z;
        }
    }

    public void setOrientionHor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f40019i = z;
        }
    }

    public void setVerNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            boolean z = this.f40016f != i2;
            this.f40016f = i2;
            if (z) {
                forceLayout();
            }
        }
    }

    public void setVerSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            boolean z = this.f40018h != i2;
            this.f40018h = i2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            ((FrameLayout.LayoutParams) this).gravity = 17;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new LayoutParams(-1, -1) : (LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f40015e = -1;
        this.f40016f = -1;
        this.f40017g = 0;
        this.f40018h = 0;
        this.f40019i = true;
        this.f40020j = false;
        a(context, attributeSet, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (LayoutParams) invokeL.objValue;
    }
}
