package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class FeedBackReasonView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public SparseArray<String> b;
    public SparseArray<String> c;
    public String[] d;
    public CompoundButton.OnCheckedChangeListener e;
    public CompoundButton.OnCheckedChangeListener f;
    public HashMap<FeedBackReasonCheckBox, Boolean> g;
    public int h;
    public boolean i;

    /* loaded from: classes5.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedBackReasonView a;

        public a(FeedBackReasonView feedBackReasonView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedBackReasonView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedBackReasonView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && compoundButton != null && this.a.g != null && !this.a.g.isEmpty()) {
                boolean z2 = false;
                if (z) {
                    for (Map.Entry entry2 : this.a.g.entrySet()) {
                        if (entry2 != null) {
                            if (entry2.getKey() == compoundButton) {
                                ((FeedBackReasonCheckBox) entry2.getKey()).setChecked(true);
                                entry2.setValue(Boolean.TRUE);
                            } else {
                                ((FeedBackReasonCheckBox) entry2.getKey()).setChecked(false);
                                entry2.setValue(Boolean.FALSE);
                            }
                        }
                    }
                }
                if (!z && !this.a.i) {
                    Iterator it = this.a.g.entrySet().iterator();
                    while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((FeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                    }
                    if (!z2) {
                        for (Map.Entry entry3 : this.a.g.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((FeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(Boolean.TRUE);
                                return;
                            }
                        }
                    }
                }
                if (this.a.e != null) {
                    this.a.e.onCheckedChanged(compoundButton, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public b(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.a = split[0];
                if (split.length > 1) {
                    String str2 = split[1];
                    return;
                }
                return;
            }
            this.a = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackReasonView(Context context) {
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
        this.a = false;
        this.b = null;
        this.c = null;
        this.i = true;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackReasonView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = false;
        this.b = null;
        this.c = null;
        this.i = true;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackReasonView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = false;
        this.b = null;
        this.c = null;
        this.i = true;
        f();
    }

    public void setCanUnCheckedInSingleBox(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i = z;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, strArr) == null) {
            this.d = strArr;
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
        }
    }

    public void setOnCheckedChangedListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onCheckedChangeListener) == null) {
            this.e = onCheckedChangeListener;
        }
    }

    public final void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeAllViews();
            List<List<b>> h = h();
            if (ListUtils.isEmpty(h)) {
                return;
            }
            int size = h.size();
            HashMap<FeedBackReasonCheckBox, Boolean> hashMap = this.g;
            if (hashMap == null) {
                this.g = new HashMap<>();
            } else {
                hashMap.clear();
            }
            for (int i = 0; i < size; i++) {
                List<b> list = h.get(i);
                if (i == size - 1) {
                    z = true;
                } else {
                    z = false;
                }
                View e = e(list, z, getChildAt(i));
                if (e != null && e.getParent() == null) {
                    addView(e);
                }
            }
            if (getChildCount() > size) {
                removeViews(size, getChildCount() - size);
            }
        }
    }

    public final List<List<b>> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String[] strArr = this.d;
            if (strArr != null && strArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.d.length; i += 2) {
                    ArrayList arrayList2 = new ArrayList();
                    if (!StringUtils.isNull(this.d[i])) {
                        arrayList2.add(new b(i, 0, this.d[i]));
                    }
                    int i2 = i + 1;
                    String[] strArr2 = this.d;
                    if (i2 < strArr2.length && !StringUtils.isNull(strArr2[i2])) {
                        arrayList2.add(new b(i2, 0, this.d[i2]));
                    }
                    if (arrayList2.size() > 0) {
                        arrayList.add(arrayList2);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final View e(List<b> list, boolean z, View view2) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), view2})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                linearLayout = (LinearLayout) view2;
            } else {
                linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                FeedBackReasonCheckBox feedBackReasonCheckBox = new FeedBackReasonCheckBox(getContext());
                feedBackReasonCheckBox.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                feedBackReasonCheckBox.setSingleLine();
                feedBackReasonCheckBox.setButtonDrawable((Drawable) null);
                feedBackReasonCheckBox.setTextSize(0, xi.g(getContext(), R.dimen.T_X08));
                feedBackReasonCheckBox.setId(R.id.left_reason);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, xi.g(getContext(), R.dimen.tbds96));
                layoutParams.weight = 1.0f;
                layoutParams.gravity = 17;
                linearLayout.addView(feedBackReasonCheckBox, layoutParams);
                FeedBackReasonCheckBox feedBackReasonCheckBox2 = new FeedBackReasonCheckBox(getContext());
                feedBackReasonCheckBox2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                feedBackReasonCheckBox2.setSingleLine();
                feedBackReasonCheckBox2.setButtonDrawable((Drawable) null);
                feedBackReasonCheckBox2.setTextSize(0, xi.g(getContext(), R.dimen.T_X08));
                feedBackReasonCheckBox2.setId(R.id.right_reason);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, xi.g(getContext(), R.dimen.tbds96));
                layoutParams2.weight = 1.0f;
                layoutParams2.gravity = 17;
                layoutParams2.setMargins(xi.g(getContext(), R.dimen.tbds20), 0, 0, 0);
                linearLayout.addView(feedBackReasonCheckBox2, layoutParams2);
            }
            FeedBackReasonCheckBox feedBackReasonCheckBox3 = (FeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            FeedBackReasonCheckBox feedBackReasonCheckBox4 = (FeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            feedBackReasonCheckBox3.a();
            feedBackReasonCheckBox4.a();
            feedBackReasonCheckBox3.setChecked(false);
            feedBackReasonCheckBox4.setChecked(false);
            this.g.put(feedBackReasonCheckBox3, Boolean.FALSE);
            this.g.put(feedBackReasonCheckBox4, Boolean.FALSE);
            b bVar = list.get(0);
            if (bVar != null) {
                feedBackReasonCheckBox3.setText(bVar.a);
                feedBackReasonCheckBox3.setTag(bVar);
            }
            if (list.size() > 1 && list.get(1) != null) {
                b bVar2 = list.get(1);
                feedBackReasonCheckBox4.setText(bVar2.a);
                feedBackReasonCheckBox4.setVisibility(0);
                feedBackReasonCheckBox4.setTag(bVar2);
            } else {
                feedBackReasonCheckBox4.setVisibility(8);
            }
            feedBackReasonCheckBox3.setOnCheckedChangeListener(this.f);
            feedBackReasonCheckBox4.setOnCheckedChangeListener(this.f);
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = this.h;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                marginLayoutParams.bottomMargin = this.h;
                linearLayout.setLayoutParams(marginLayoutParams);
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOrientation(1);
            this.h = xi.g(getContext(), R.dimen.M_H_X003);
            this.f = new a(this);
        }
    }

    public final List<List<b>> h() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SparseArray<String> sparseArray = this.b;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.b.size();
                int i5 = 0;
                int i6 = -1;
                if (this.a) {
                    i = 0;
                } else {
                    i = -1;
                }
                if (this.a) {
                    i2 = size - 1;
                } else {
                    i2 = size;
                }
                if (i2 > 1 && i2 % 2 == 1) {
                    i6 = i + 1;
                }
                ArrayList arrayList = new ArrayList();
                while (i5 < size) {
                    if (i5 != i && i5 != i6) {
                        i4 = i5 + 1;
                        i3 = i5 + 2;
                    } else {
                        i3 = i5 + 1;
                        i4 = i5;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    b bVar = new b(i5, this.b.keyAt(i5), this.b.valueAt(i5));
                    SparseArray<String> sparseArray2 = this.c;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.b.keyAt(i5)))) {
                        this.c.get(this.b.keyAt(i5));
                    }
                    arrayList2.add(bVar);
                    if (i4 > i5 && i4 < size) {
                        b bVar2 = new b(i4, this.b.keyAt(i4), this.b.valueAt(i4));
                        SparseArray<String> sparseArray3 = this.c;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.b.keyAt(i5)))) {
                            this.c.get(this.b.keyAt(i4));
                        }
                        arrayList2.add(bVar2);
                    }
                    arrayList.add(arrayList2);
                    i5 = i3;
                }
                return arrayList;
            }
            return g();
        }
        return (List) invokeV.objValue;
    }

    public void setData(@Nullable SparseArray<String> sparseArray, @Nullable SparseArray<String> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, sparseArray, sparseArray2) == null) {
            this.b = sparseArray;
            this.c = sparseArray2;
            d();
        }
    }
}
