package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.r0.d1.c0;
import c.a.r0.d1.e1;
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
/* loaded from: classes5.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f41806e;

    /* renamed from: f  reason: collision with root package name */
    public int f41807f;

    /* renamed from: g  reason: collision with root package name */
    public int f41808g;

    /* renamed from: h  reason: collision with root package name */
    public int f41809h;

    /* renamed from: i  reason: collision with root package name */
    public c f41810i;

    /* renamed from: j  reason: collision with root package name */
    public List<e1> f41811j;
    public c.a.d.f.k.b<TextView> k;
    public Context l;
    public e1 m;

    /* loaded from: classes5.dex */
    public class a implements c.a.d.f.k.c<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabMenuPopView a;

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
            this.a = tabMenuPopView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TextView textView = new TextView(this.a.l);
                textView.setTextSize(0, n.f(this.a.l, R.dimen.fontsize28));
                SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
                textView.setGravity(17);
                textView.setOnClickListener(this.a);
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

    /* loaded from: classes5.dex */
    public class b implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabMenuPopView f41812e;

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
            this.f41812e = tabMenuPopView;
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
                this.f41812e.k.e((TextView) view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view, e1 e1Var);
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
        this.f41806e = 2;
        this.f41807f = 2;
        this.f41808g = 4;
        this.f41809h = 5;
        setOrientation(1);
        this.l = context;
        this.f41807f = n.f(context, R.dimen.ds20);
        this.k = new c.a.d.f.k.b<>(new a(this), 17, 0);
        setOnHierarchyChangeListener(new b(this));
    }

    private void setData(List<e1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, list) == null) || list == null) {
            return;
        }
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
        if (this.m != null) {
            if (e(list)) {
                this.m.f15467c = false;
            } else {
                this.m.f15467c = true;
            }
            this.f41809h = ((int) Math.ceil(list.size() / this.f41808g)) + 1;
            c(this.m, layoutParams);
        } else {
            this.f41809h = (int) Math.ceil(list.size() / this.f41808g);
        }
        this.f41811j = list;
        for (int i2 = 0; i2 < list.size(); i2++) {
            c(list.get(i2), layoutParams);
        }
    }

    public final void c(e1 e1Var, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, e1Var, layoutParams) == null) || e1Var == null || layoutParams == null) {
            return;
        }
        TextView b2 = this.k.b();
        b2.setText(e1Var.a);
        b2.setSelected(e1Var.f15467c);
        b2.setTag(e1Var);
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

    public final boolean e(List<e1> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).f15467c) {
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
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && (view.getTag() instanceof e1)) {
            resetSelectState();
            e1 e1Var = (e1) view.getTag();
            setItemSelectState(e1Var, true);
            view.setSelected(true);
            c cVar = this.f41810i;
            if (cVar != null) {
                cVar.a(view, e1Var);
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
        int i10 = this.f41808g;
        int i11 = 1;
        if (i10 > 1) {
            this.f41806e = (measuredWidth - (measuredWidth2 * i10)) / (i10 - 1);
        }
        int[] iArr = new int[this.f41809h + 1];
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
                i9 = (this.f41807f * 2) + i16;
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
                int i17 = i14 + iArr[i11] + this.f41807f;
                i15 = measuredWidth3 + 0;
                i16 = i17 + measuredHeight;
                i13 = this.f41806e + i15;
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
                i13 = this.f41806e + i15;
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
                int i4 = this.f41809h;
                int i5 = this.f41807f;
                setMeasuredDimension(getMeasuredWidth(), d((measuredHeight * i4) + ((i4 - 1) * i5) + (i5 * 2), i3));
            }
        }
    }

    public void resetSelectState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f41811j == null || getChildCount() <= 0) {
            return;
        }
        e1 e1Var = this.m;
        if (e1Var != null) {
            e1Var.f15467c = false;
        }
        for (e1 e1Var2 : this.f41811j) {
            e1Var2.f15467c = false;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setSelected(false);
        }
    }

    public void setItemSelectState(e1 e1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, e1Var, z) == null) || e1Var == null || this.f41811j == null) {
            return;
        }
        e1 e1Var2 = this.m;
        if (e1Var2 != null && e1Var2.f15466b == e1Var.f15466b) {
            e1Var2.f15467c = z;
            return;
        }
        for (e1 e1Var3 : this.f41811j) {
            if (e1Var.f15466b == e1Var3.f15466b) {
                e1Var.f15467c = z;
                return;
            }
        }
    }

    public void setOnItemClickCallBack(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f41810i = cVar;
        }
    }

    public void setPerLineViewNum(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f41808g = i2;
    }

    public void setViewVerticalMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f41807f = i2;
        }
    }

    public void setData(List<c0> list, c0 c0Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, list, c0Var, i2) == null) || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) != null) {
                e1 e1Var = new e1();
                e1Var.f15466b = list.get(i3).f15366b;
                e1Var.a = list.get(i3).a;
                if (i2 == list.get(i3).f15366b) {
                    e1Var.f15467c = true;
                }
                arrayList.add(e1Var);
            }
        }
        e1 e1Var2 = null;
        if (c0Var != null) {
            e1Var2 = new e1();
            int i4 = c0Var.f15366b;
            e1Var2.f15466b = i4;
            e1Var2.a = c0Var.a;
            if (i2 == i4) {
                e1Var2.f15467c = true;
            }
        }
        setData(arrayList, e1Var2);
    }

    public void setData(List<e1> list, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, list, e1Var) == null) {
            this.m = e1Var;
            setData(list);
        }
    }
}
