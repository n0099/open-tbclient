package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ag;
import com.baidu.tieba.bg;
import com.baidu.tieba.rh7;
import com.baidu.tieba.wi7;
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
    public int a;
    public int b;
    public int c;
    public int d;
    public c e;
    public List<wi7> f;
    public ag<TextView> g;
    public Context h;
    public wi7 i;

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view2, wi7 wi7Var);
    }

    /* loaded from: classes5.dex */
    public class a implements bg<TextView> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tabMenuPopView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
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
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(TextView textView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, textView) == null) && textView != null) {
                textView.setText("");
                textView.setTag(null);
                textView.setSelected(false);
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TextView textView = new TextView(this.a.h);
                textView.setTextSize(0, BdUtilHelper.getDimens(this.a.h, R.dimen.obfuscated_res_0x7f0702b5));
                SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
                textView.setGravity(17);
                textView.setOnClickListener(this.a);
                return textView;
            }
            return (TextView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabMenuPopView a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        public b(TabMenuPopView tabMenuPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabMenuPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tabMenuPopView;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) && (view3 instanceof TextView)) {
                this.a.g.e((TextView) view3);
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 2;
        this.b = 2;
        this.c = 4;
        this.d = 5;
        setOrientation(1);
        this.h = context;
        this.b = BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701d5);
        this.g = new ag<>(new a(this), 17, 0);
        setOnHierarchyChangeListener(new b(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean f(List<wi7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).c) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && (view2.getTag() instanceof wi7)) {
            g();
            wi7 wi7Var = (wi7) view2.getTag();
            setItemSelectState(wi7Var, true);
            view2.setSelected(true);
            c cVar = this.e;
            if (cVar != null) {
                cVar.a(view2, wi7Var);
            }
        }
    }

    public void setOnItemClickCallBack(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.e = cVar;
        }
    }

    private void setData(List<wi7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, list) != null) || list == null) {
            return;
        }
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070375), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253));
        if (this.i != null) {
            if (f(list)) {
                this.i.c = false;
            } else {
                this.i.c = true;
            }
            this.d = ((int) Math.ceil(list.size() / this.c)) + 1;
            c(this.i, layoutParams);
        } else {
            this.d = (int) Math.ceil(list.size() / this.c);
        }
        this.f = list;
        for (int i = 0; i < list.size(); i++) {
            c(list.get(i), layoutParams);
        }
    }

    public final void c(wi7 wi7Var, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, wi7Var, layoutParams) == null) && wi7Var != null && layoutParams != null) {
            TextView b2 = this.g.b();
            b2.setText(wi7Var.a);
            b2.setSelected(wi7Var.c);
            b2.setTag(wi7Var);
            addView(b2, layoutParams);
        }
    }

    public final int e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    return i;
                }
            } else if (size > i) {
                return i;
            }
            return size;
        }
        return invokeII.intValue;
    }

    public void setData(List<wi7> list, wi7 wi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, list, wi7Var) == null) {
            this.i = wi7Var;
            setData(list);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i);
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f != null && getChildCount() > 0) {
            wi7 wi7Var = this.i;
            if (wi7Var != null) {
                wi7Var.c = false;
            }
            for (wi7 wi7Var2 : this.f) {
                wi7Var2.c = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = getChildAt(0).getMeasuredWidth();
        int i9 = this.c;
        int i10 = 1;
        if (i9 > 1) {
            this.a = (measuredWidth - (measuredWidth2 * i9)) / (i9 - 1);
        }
        int[] iArr = new int[this.d + 1];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            int measuredWidth3 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i14 = i12 + measuredWidth3;
            int i15 = i13 + measuredHeight;
            if (this.i != null && i11 == 0) {
                i8 = (this.b * 2) + i15;
                if (measuredHeight > iArr[i10]) {
                    iArr[i10] = measuredHeight;
                }
                i5 = i13;
                i6 = i10 + 1;
                i7 = i12;
                i12 = 0;
            } else if (i14 > i3) {
                if (measuredHeight > iArr[i10]) {
                    iArr[i10] = measuredHeight;
                }
                int i16 = i13 + iArr[i10] + this.b;
                i14 = measuredWidth3 + 0;
                i15 = i16 + measuredHeight;
                i12 = this.a + i14;
                i8 = i16;
                i5 = i8;
                i6 = i10 + 1;
                i7 = 0;
            } else {
                if (measuredHeight > iArr[i10]) {
                    iArr[i10] = measuredHeight;
                }
                i5 = i13;
                i6 = i10;
                i7 = i12;
                i12 = this.a + i14;
                i8 = i5;
            }
            if (i14 > i3) {
                i14 = i3;
            }
            childAt.layout(i7, i5, i14, i15);
            i11++;
            i10 = i6;
            i13 = i8;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (getChildCount() > 0) {
                int measuredHeight = getChildAt(0).getMeasuredHeight();
                int i3 = this.d;
                int i4 = this.b;
                setMeasuredDimension(getMeasuredWidth(), e((measuredHeight * i3) + ((i3 - 1) * i4) + (i4 * 2), i2));
            }
        }
    }

    public void setItemSelectState(wi7 wi7Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, wi7Var, z) == null) && wi7Var != null && this.f != null) {
            wi7 wi7Var2 = this.i;
            if (wi7Var2 != null && wi7Var2.b == wi7Var.b) {
                wi7Var2.c = z;
                return;
            }
            for (wi7 wi7Var3 : this.f) {
                if (wi7Var.b == wi7Var3.b) {
                    wi7Var.c = z;
                    return;
                }
            }
        }
    }

    public void setData(List<rh7> list, rh7 rh7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048585, this, list, rh7Var, i) != null) || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) != null) {
                wi7 wi7Var = new wi7();
                wi7Var.b = list.get(i2).b;
                wi7Var.a = list.get(i2).a;
                if (i == list.get(i2).b) {
                    wi7Var.c = true;
                }
                arrayList.add(wi7Var);
            }
        }
        wi7 wi7Var2 = null;
        if (rh7Var != null) {
            wi7Var2 = new wi7();
            int i3 = rh7Var.b;
            wi7Var2.b = i3;
            wi7Var2.a = rh7Var.a;
            if (i == i3) {
                wi7Var2.c = true;
            }
        }
        setData(arrayList, wi7Var2);
    }
}
