package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.a.d.f.p.l;
import c.a.r0.d1.d1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ItemPlot;
/* loaded from: classes10.dex */
public class ItemTableView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final int f44854k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemTableRowView f44855e;

    /* renamed from: f  reason: collision with root package name */
    public ItemTableRowView f44856f;

    /* renamed from: g  reason: collision with root package name */
    public ItemTableRowView f44857g;

    /* renamed from: h  reason: collision with root package name */
    public ItemTableRowView f44858h;

    /* renamed from: i  reason: collision with root package name */
    public ItemTableRowView f44859i;

    /* renamed from: j  reason: collision with root package name */
    public SparseArray<ItemTableRowView> f44860j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-114015025, "Lcom/baidu/tieba/frs/view/ItemTableView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-114015025, "Lcom/baidu/tieba/frs/view/ItemTableView;");
                return;
            }
        }
        f44854k = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemTableView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            this.f44859i = b(context, 0, 0);
            this.f44858h = b(context, 1, f44854k);
            this.f44857g = b(context, 2, f44854k);
            this.f44856f = b(context, 3, f44854k);
            this.f44855e = b(context, 4, f44854k);
            SparseArray<ItemTableRowView> sparseArray = new SparseArray<>();
            this.f44860j = sparseArray;
            sparseArray.put(5, this.f44859i);
            this.f44860j.put(4, this.f44858h);
            this.f44860j.put(3, this.f44857g);
            this.f44860j.put(2, this.f44856f);
            this.f44860j.put(1, this.f44855e);
        }
    }

    public final ItemTableRowView b(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, i3)) == null) {
            ItemTableRowView itemTableRowView = new ItemTableRowView(context);
            itemTableRowView.setEmptyStartCount(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = i3;
            addView(itemTableRowView, layoutParams);
            return itemTableRowView;
        }
        return (ItemTableRowView) invokeLII.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f44855e.clear();
            this.f44856f.clear();
            this.f44857g.clear();
            this.f44858h.clear();
            this.f44859i.clear();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f44855e.onChangeSkinType();
            this.f44856f.onChangeSkinType();
            this.f44857g.onChangeSkinType();
            this.f44858h.onChangeSkinType();
            this.f44859i.onChangeSkinType();
        }
    }

    public void setData(List<ItemPlot> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, list, i2) == null) {
            clear();
            if (list == null) {
                return;
            }
            for (ItemPlot itemPlot : list) {
                if (itemPlot != null) {
                    int intValue = itemPlot.level.intValue();
                    float intValue2 = (itemPlot.num.intValue() * 1.0f) / i2;
                    ItemTableRowView itemTableRowView = this.f44860j.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemTableView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemTableView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a(context);
    }
}
