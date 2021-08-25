package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.v0.b0;
import c.a.q0.v0.d1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50788e;

    /* renamed from: f  reason: collision with root package name */
    public int f50789f;

    /* renamed from: g  reason: collision with root package name */
    public int f50790g;

    /* renamed from: h  reason: collision with root package name */
    public int f50791h;

    /* renamed from: i  reason: collision with root package name */
    public c f50792i;

    /* renamed from: j  reason: collision with root package name */
    public List<d1> f50793j;
    public c.a.e.e.k.b<TextView> k;
    public Context l;
    public d1 m;

    /* loaded from: classes7.dex */
    public class a implements c.a.e.e.k.c<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabMenuPopView f50794a;

        public a(TabMenuPopView tabMenuPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabMenuPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50794a = tabMenuPopView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TextView c(TextView textView) {
            TextView textView2 = textView;
            h(textView2);
            return textView2;
        }

        public TextView e(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, textView)) == null) {
                if (textView != null) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
                }
                return textView;
            }
            return (TextView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(TextView textView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, textView) == null) || textView == null) {
                return;
            }
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TextView textView = new TextView(this.f50794a.l);
                textView.setTextSize(0, l.g(this.f50794a.l, R.dimen.fontsize28));
                SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
                textView.setGravity(17);
                textView.setOnClickListener(this.f50794a);
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public TextView h(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, textView)) == null) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
                return textView;
            }
            return (TextView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabMenuPopView f50795e;

        public b(TabMenuPopView tabMenuPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabMenuPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50795e = tabMenuPopView;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof TextView)) {
                this.f50795e.k.e((TextView) view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(View view, d1 d1Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50788e = 2;
        this.f50789f = 2;
        this.f50790g = 4;
        this.f50791h = 5;
        setOrientation(1);
        this.l = context;
        this.f50789f = l.g(context, R.dimen.ds20);
        this.k = new c.a.e.e.k.b<>(new a(this), 17, 0);
        setOnHierarchyChangeListener(new b(this));
    }

    private void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, list) == null) || list == null) {
            return;
        }
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
        if (this.m != null) {
            if (e(list)) {
                this.m.f25913c = false;
            } else {
                this.m.f25913c = true;
            }
            this.f50791h = ((int) Math.ceil(list.size() / this.f50790g)) + 1;
            c(this.m, layoutParams);
        } else {
            this.f50791h = (int) Math.ceil(list.size() / this.f50790g);
        }
        this.f50793j = list;
        for (int i2 = 0; i2 < list.size(); i2++) {
            c(list.get(i2), layoutParams);
        }
    }

    public final void c(d1 d1Var, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d1Var, layoutParams) == null) || d1Var == null || layoutParams == null) {
            return;
        }
        TextView b2 = this.k.b();
        b2.setText(d1Var.f25911a);
        b2.setSelected(d1Var.f25913c);
        b2.setTag(d1Var);
        addView(b2, layoutParams);
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
                }
            }
        }
    }

    public final int d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    return i2;
                }
            } else if (size > i2) {
                return i2;
            }
            return size;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final boolean e(List<d1> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).f25913c) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && (view.getTag() instanceof d1)) {
            resetSelectState();
            d1 d1Var = (d1) view.getTag();
            setItemSelectState(d1Var, true);
            view.setSelected(true);
            c cVar = this.f50792i;
            if (cVar != null) {
                cVar.a(view, d1Var);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = getChildAt(0).getMeasuredWidth();
        int i10 = this.f50790g;
        int i11 = 1;
        if (i10 > 1) {
            this.f50788e = (measuredWidth - (measuredWidth2 * i10)) / (i10 - 1);
        }
        int[] iArr = new int[this.f50791h + 1];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            int measuredWidth3 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i15 = i13 + measuredWidth3;
            int i16 = i14 + measuredHeight;
            if (this.m != null && i12 == 0) {
                i9 = (this.f50789f * 2) + i16;
                if (measuredHeight > iArr[i11]) {
                    iArr[i11] = measuredHeight;
                }
                i6 = i14;
                i7 = i11 + 1;
                i8 = i13;
                i13 = 0;
            } else if (i15 > i4) {
                if (measuredHeight > iArr[i11]) {
                    iArr[i11] = measuredHeight;
                }
                int i17 = i14 + iArr[i11] + this.f50789f;
                i15 = measuredWidth3 + 0;
                i16 = i17 + measuredHeight;
                i13 = this.f50788e + i15;
                i9 = i17;
                i6 = i9;
                i7 = i11 + 1;
                i8 = 0;
            } else {
                if (measuredHeight > iArr[i11]) {
                    iArr[i11] = measuredHeight;
                }
                i6 = i14;
                i7 = i11;
                i8 = i13;
                i13 = this.f50788e + i15;
                i9 = i6;
            }
            if (i15 > i4) {
                i15 = i4;
            }
            childAt.layout(i8, i6, i15, i16);
            i12++;
            i11 = i7;
            i14 = i9;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getChildCount() > 0) {
                int measuredHeight = getChildAt(0).getMeasuredHeight();
                int i4 = this.f50791h;
                int i5 = this.f50789f;
                setMeasuredDimension(getMeasuredWidth(), d((measuredHeight * i4) + ((i4 - 1) * i5) + (i5 * 2), i3));
            }
        }
    }

    public void resetSelectState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f50793j == null || getChildCount() <= 0) {
            return;
        }
        d1 d1Var = this.m;
        if (d1Var != null) {
            d1Var.f25913c = false;
        }
        for (d1 d1Var2 : this.f50793j) {
            d1Var2.f25913c = false;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setSelected(false);
        }
    }

    public void setItemSelectState(d1 d1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, d1Var, z) == null) || d1Var == null || this.f50793j == null) {
            return;
        }
        d1 d1Var2 = this.m;
        if (d1Var2 != null && d1Var2.f25912b == d1Var.f25912b) {
            d1Var2.f25913c = z;
            return;
        }
        for (d1 d1Var3 : this.f50793j) {
            if (d1Var.f25912b == d1Var3.f25912b) {
                d1Var.f25913c = z;
                return;
            }
        }
    }

    public void setOnItemClickCallBack(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f50792i = cVar;
        }
    }

    public void setPerLineViewNum(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f50790g = i2;
    }

    public void setViewVerticalMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f50789f = i2;
        }
    }

    public void setData(List<b0> list, b0 b0Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, list, b0Var, i2) == null) || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) != null) {
                d1 d1Var = new d1();
                d1Var.f25912b = list.get(i3).f25867b;
                d1Var.f25911a = list.get(i3).f25866a;
                if (i2 == list.get(i3).f25867b) {
                    d1Var.f25913c = true;
                }
                arrayList.add(d1Var);
            }
        }
        d1 d1Var2 = null;
        if (b0Var != null) {
            d1Var2 = new d1();
            int i4 = b0Var.f25867b;
            d1Var2.f25912b = i4;
            d1Var2.f25911a = b0Var.f25866a;
            if (i2 == i4) {
                d1Var2.f25913c = true;
            }
        }
        setData(arrayList, d1Var2);
    }

    public void setData(List<d1> list, d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, list, d1Var) == null) {
            this.m = d1Var;
            setData(list);
        }
    }
}
