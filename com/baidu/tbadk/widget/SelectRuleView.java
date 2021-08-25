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
/* loaded from: classes6.dex */
public class SelectRuleView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_TEXT_AND_IMAGE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48465e;

    /* renamed from: f  reason: collision with root package name */
    public int f48466f;

    /* renamed from: g  reason: collision with root package name */
    public int f48467g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f48468h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f48469i;

    /* renamed from: j  reason: collision with root package name */
    public List<String> f48470j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectRuleView(Context context) {
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

    public final List<String> a(List<String> list, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, list, i2, i3)) == null) {
            if (ListUtils.isEmpty(list) || i2 > list.size() || i2 < 0) {
                return null;
            }
            if (list.size() >= i3) {
                return list.subList(i2, i3);
            }
            ArrayList arrayList = new ArrayList(list.subList(i2, list.size()));
            for (int i4 = 0; i4 < i3 - list.size(); i4++) {
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

    public void onSkinTypeChange(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f48467g == i2) {
            return;
        }
        int i3 = this.f48465e;
        if (i3 == 0) {
            setData(this.f48468h, this.f48469i);
        } else if (i3 == 1) {
            setData(this.f48470j, this.f48468h, this.f48469i);
        }
    }

    public void setColumn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f48466f = i2;
        }
    }

    public void setData(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, list, list2) != null) {
            return;
        }
        if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
            return;
        }
        b();
        this.f48468h = list;
        this.f48469i = list2;
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        List<String> arrayList2 = new ArrayList<>();
        arrayList2.addAll(list2);
        int size = arrayList.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
        while (arrayList2.size() < size) {
            arrayList2.add("");
        }
        while (arrayList.size() < size) {
            arrayList.add("");
        }
        int i2 = 0;
        while (true) {
            int i3 = this.f48466f;
            if (i2 >= ((size + i3) - 1) / i3) {
                return;
            }
            SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
            selectRuleRowItem.setType(this.f48465e);
            int i4 = this.f48466f;
            int i5 = i2 * i4;
            i2++;
            int i6 = i4 * i2;
            selectRuleRowItem.setData(a(arrayList, i5, i6), a(arrayList2, i5, i6));
            addView(selectRuleRowItem);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f48465e = i2;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f48465e = 0;
        this.f48466f = 2;
        this.f48467g = 3;
        c();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048582, this, list, list2, list3) != null) {
            return;
        }
        if (ListUtils.isEmpty(list2) && ListUtils.isEmpty(list3) && ListUtils.isEmpty(list)) {
            return;
        }
        b();
        this.f48468h = list2;
        this.f48469i = list3;
        this.f48470j = list;
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(list2);
        List<String> arrayList2 = new ArrayList<>();
        arrayList2.addAll(list3);
        List<String> arrayList3 = new ArrayList<>();
        arrayList3.addAll(list);
        int size = list2.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
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
        int i2 = 0;
        while (true) {
            int i3 = this.f48466f;
            if (i2 >= ((size + i3) - 1) / i3) {
                return;
            }
            SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
            selectRuleRowItem.setType(this.f48465e);
            int i4 = this.f48466f;
            int i5 = i2 * i4;
            i2++;
            int i6 = i4 * i2;
            selectRuleRowItem.setData(a(arrayList3, i5, i6), a(arrayList, i5, i6), a(arrayList2, i5, i6));
            addView(selectRuleRowItem);
        }
    }
}
