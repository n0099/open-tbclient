package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AutoLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f30367b;

    /* renamed from: c  reason: collision with root package name */
    public int f30368c;

    /* renamed from: d  reason: collision with root package name */
    public int f30369d;

    /* renamed from: e  reason: collision with root package name */
    public int f30370e;

    /* renamed from: f  reason: collision with root package name */
    public int f30371f;

    /* renamed from: g  reason: collision with root package name */
    public int f30372g;

    /* renamed from: h  reason: collision with root package name */
    public int f30373h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoLinearLayout(Context context) {
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
        this.f30367b = 0;
        this.f30368c = 0;
        this.f30369d = 0;
        this.f30371f = 0;
        this.f30372g = 0;
        this.f30373h = 0;
        this.a = context;
        setOrientation(0);
        this.f30368c = n.f(context, R.dimen.obfuscated_res_0x7f0701e8);
        this.f30369d = n.f(context, R.dimen.obfuscated_res_0x7f0701d5);
        this.f30372g = n.f(context, R.dimen.obfuscated_res_0x7f070207);
        this.f30370e = n.k(this.a) - (this.f30372g * 2);
        this.f30373h = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070253);
    }

    private int getCulumnsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f30373h, 1073741824);
            int childCount = getChildCount();
            int i = this.f30370e;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (i < measuredWidth) {
                        i2++;
                        if (i2 == 1) {
                            this.f30371f = i4;
                        }
                        i3 = measuredWidth + this.f30369d + 0;
                    } else {
                        i3 += measuredWidth + this.f30369d;
                    }
                    i = this.f30370e - i3;
                }
            }
            return i2 + 1;
        }
        return invokeV.intValue;
    }

    public final void a(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (i2 = this.f30371f) > i) {
            return;
        }
        removeViews(i2, i - i2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            int dimension = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701e8);
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt != null) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (i5 != 0 && i6 < measuredWidth) {
                        dimension += this.f30368c + measuredHeight;
                        i5 = 0;
                    }
                    childAt.layout(i5, dimension, i5 + measuredWidth, measuredHeight + dimension);
                    int i8 = this.f30369d;
                    i6 = (((i3 - i) - i5) - measuredWidth) - i8;
                    i5 += measuredWidth + i8;
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f30373h, 1073741824);
            int childCount = getChildCount();
            int culumnsCount = getCulumnsCount();
            if (this.f30367b != 0 && this.f30371f != 0) {
                a(childCount);
            }
            if (this.f30367b != 0) {
                for (int i3 = 0; i3 < this.f30371f; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt != null) {
                        childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                }
                this.f30371f = 0;
            } else {
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = getChildAt(i4);
                    if (childAt2 != null) {
                        childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                }
            }
            if (this.f30367b != 0) {
                setMeasuredDimension(LinearLayout.resolveSize(0, i), LinearLayout.resolveSize((this.f30373h * this.f30367b) + this.f30368c, i2));
            } else {
                setMeasuredDimension(LinearLayout.resolveSize(0, i), LinearLayout.resolveSize((this.f30373h * culumnsCount) + (culumnsCount * this.f30368c), i2));
            }
        }
    }

    public void setCellHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f30373h = i;
        }
    }

    public void setMarginRight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f30369d = i;
        }
    }

    public void setParentWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f30370e = i;
        }
    }

    public void setShowColumns(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f30367b = i;
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
        this.f30367b = 0;
        this.f30368c = 0;
        this.f30369d = 0;
        this.f30371f = 0;
        this.f30372g = 0;
        this.f30373h = 0;
        this.a = context;
        setOrientation(0);
        this.f30368c = n.f(context, R.dimen.obfuscated_res_0x7f0701e8);
        this.f30369d = n.f(context, R.dimen.obfuscated_res_0x7f0701d5);
        this.f30372g = n.f(context, R.dimen.obfuscated_res_0x7f070207);
        this.f30370e = n.k(this.a) - (this.f30372g * 2);
        this.f30373h = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070253);
    }
}
