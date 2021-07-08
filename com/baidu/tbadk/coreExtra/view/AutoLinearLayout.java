package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class AutoLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12854e;

    /* renamed from: f  reason: collision with root package name */
    public int f12855f;

    /* renamed from: g  reason: collision with root package name */
    public int f12856g;

    /* renamed from: h  reason: collision with root package name */
    public int f12857h;

    /* renamed from: i  reason: collision with root package name */
    public int f12858i;
    public int j;
    public int k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoLinearLayout(Context context) {
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
        this.f12855f = 0;
        this.f12856g = 0;
        this.f12857h = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f12854e = context;
        setOrientation(0);
        this.f12856g = l.g(context, R.dimen.ds24);
        this.f12857h = l.g(context, R.dimen.ds20);
        this.k = l.g(context, R.dimen.ds32);
        this.f12858i = l.k(this.f12854e) - (this.k * 2);
        this.l = (int) this.f12854e.getResources().getDimension(R.dimen.ds60);
    }

    private int getCulumnsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
            int childCount = getChildCount();
            int i2 = this.f12858i;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (i2 < measuredWidth) {
                        i3++;
                        if (i3 == 1) {
                            this.j = i5;
                        }
                        i4 = measuredWidth + this.f12857h + 0;
                    } else {
                        i4 += measuredWidth + this.f12857h;
                    }
                    i2 = this.f12858i - i4;
                }
            }
            return i3 + 1;
        }
        return invokeV.intValue;
    }

    public final void a(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (i3 = this.j) > i2) {
            return;
        }
        removeViews(i3, i2 - i3);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            int dimension = (int) this.f12854e.getResources().getDimension(R.dimen.ds24);
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt != null) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (i6 != 0 && i7 < measuredWidth) {
                        dimension += this.f12856g + measuredHeight;
                        i6 = 0;
                    }
                    childAt.layout(i6, dimension, i6 + measuredWidth, measuredHeight + dimension);
                    int i9 = this.f12857h;
                    i7 = (((i4 - i2) - i6) - measuredWidth) - i9;
                    i6 += measuredWidth + i9;
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
            int childCount = getChildCount();
            int culumnsCount = getCulumnsCount();
            if (this.f12855f != 0 && this.j != 0) {
                a(childCount);
            }
            if (this.f12855f != 0) {
                for (int i4 = 0; i4 < this.j; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt != null) {
                        childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                }
                this.j = 0;
            } else {
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt2 = getChildAt(i5);
                    if (childAt2 != null) {
                        childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                }
            }
            if (this.f12855f != 0) {
                setMeasuredDimension(LinearLayout.resolveSize(0, i2), LinearLayout.resolveSize((this.l * this.f12855f) + this.f12856g, i3));
            } else {
                setMeasuredDimension(LinearLayout.resolveSize(0, i2), LinearLayout.resolveSize((this.l * culumnsCount) + (culumnsCount * this.f12856g), i3));
            }
        }
    }

    public void setCellHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setMarginRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f12857h = i2;
        }
    }

    public void setParentWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f12858i = i2;
        }
    }

    public void setShowColumns(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f12855f = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
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
        this.f12855f = 0;
        this.f12856g = 0;
        this.f12857h = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f12854e = context;
        setOrientation(0);
        this.f12856g = l.g(context, R.dimen.ds24);
        this.f12857h = l.g(context, R.dimen.ds20);
        this.k = l.g(context, R.dimen.ds32);
        this.f12858i = l.k(this.f12854e) - (this.k * 2);
        this.l = (int) this.f12854e.getResources().getDimension(R.dimen.ds60);
    }
}
