package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectRuleView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public List<String> d;
    public List<String> e;
    public List<String> f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectRuleView(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet) {
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
    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 0;
        this.b = 2;
        this.c = 3;
        c();
    }

    public final List<String> a(List<String> list, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, list, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || i > list.size() || i < 0) {
                return null;
            }
            if (list.size() >= i2) {
                return list.subList(i, i2);
            }
            ArrayList arrayList = new ArrayList(list.subList(i, list.size()));
            for (int i3 = 0; i3 < i2 - list.size(); i3++) {
                arrayList.add("");
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            removeAllViews();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOrientation(1);
            setGravity(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.c == i) {
            return;
        }
        int i2 = this.a;
        if (i2 == 0) {
            setData(this.d, this.e);
        } else if (i2 == 1) {
            setData(this.f, this.d, this.e);
        }
    }

    public void setColumn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }

    public void setData(List<String> list, List<String> list2) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, list2) == null) {
            if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                return;
            }
            b();
            this.d = list;
            this.e = list2;
            List<String> arrayList = new ArrayList<>();
            arrayList.addAll(list);
            List<String> arrayList2 = new ArrayList<>();
            arrayList2.addAll(list2);
            if (arrayList.size() > arrayList2.size()) {
                size = arrayList.size();
            } else {
                size = arrayList2.size();
            }
            while (arrayList2.size() < size) {
                arrayList2.add("");
            }
            while (arrayList.size() < size) {
                arrayList.add("");
            }
            int i = 0;
            while (true) {
                int i2 = this.b;
                if (i < ((size + i2) - 1) / i2) {
                    SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
                    selectRuleRowItem.setType(this.a);
                    int i3 = this.b;
                    int i4 = i * i3;
                    i++;
                    int i5 = i3 * i;
                    selectRuleRowItem.setData(a(arrayList, i4, i5), a(arrayList2, i4, i5));
                    addView(selectRuleRowItem);
                } else {
                    return;
                }
            }
        }
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, list, list2, list3) == null) {
            if (ListUtils.isEmpty(list2) && ListUtils.isEmpty(list3) && ListUtils.isEmpty(list)) {
                return;
            }
            b();
            this.d = list2;
            this.e = list3;
            this.f = list;
            List<String> arrayList = new ArrayList<>();
            arrayList.addAll(list2);
            List<String> arrayList2 = new ArrayList<>();
            arrayList2.addAll(list3);
            List<String> arrayList3 = new ArrayList<>();
            arrayList3.addAll(list);
            if (list2.size() > arrayList2.size()) {
                size = arrayList.size();
            } else {
                size = arrayList2.size();
            }
            if (size <= arrayList3.size()) {
                size = arrayList3.size();
            }
            while (arrayList2.size() < size) {
                arrayList2.add("");
            }
            while (arrayList.size() < size) {
                arrayList.add("");
            }
            while (arrayList3.size() < size) {
                arrayList3.add("");
            }
            int i = 0;
            while (true) {
                int i2 = this.b;
                if (i < ((size + i2) - 1) / i2) {
                    SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
                    selectRuleRowItem.setType(this.a);
                    int i3 = this.b;
                    int i4 = i * i3;
                    i++;
                    int i5 = i3 * i;
                    selectRuleRowItem.setData(a(arrayList3, i4, i5), a(arrayList, i4, i5), a(arrayList2, i4, i5));
                    addView(selectRuleRowItem);
                } else {
                    return;
                }
            }
        }
    }
}
