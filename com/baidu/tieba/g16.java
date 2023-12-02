package com.baidu.tieba;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox;
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
/* loaded from: classes6.dex */
public class g16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Context b;
    public SparseArray<String> c;
    public SparseArray<String> d;
    public String[] e;
    public LinearLayout f;
    public CompoundButton.OnCheckedChangeListener g;
    public CompoundButton.OnCheckedChangeListener h;
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes6.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g16 a;

        public a(g16 g16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g16Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && compoundButton != null && this.a.i != null && !this.a.i.isEmpty()) {
                boolean z2 = false;
                if (z && this.a.k) {
                    for (Map.Entry entry2 : this.a.i.entrySet()) {
                        if (entry2 != null) {
                            if (entry2.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(true);
                                entry2.setValue(Boolean.TRUE);
                            } else {
                                ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(false);
                                entry2.setValue(Boolean.FALSE);
                            }
                        }
                    }
                }
                if (this.a.k && !z && !this.a.l) {
                    Iterator it = this.a.i.entrySet().iterator();
                    while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                    }
                    if (!z2) {
                        for (Map.Entry entry3 : this.a.i.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(Boolean.TRUE);
                                return;
                            }
                        }
                    }
                }
                if (this.a.g != null) {
                    this.a.g.onCheckedChanged(compoundButton, z);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public String c;
        public String d;

        public b(g16 g16Var, int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g16Var, Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i2;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.c = split[0];
                if (split.length > 1) {
                    this.d = split[1];
                }
            } else {
                this.c = str;
            }
            this.a = i;
        }
    }

    public g16(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = null;
        this.d = null;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.b = context;
        this.j = BdUtilHelper.getDimens(context, R.dimen.M_H_X003);
        this.h = new a(this);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    public void j(NegativeFeedBackData negativeFeedBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, negativeFeedBackData) != null) || negativeFeedBackData == null) {
            return;
        }
        this.c = negativeFeedBackData.getFeedBackReasonMap();
        this.d = negativeFeedBackData.feedBackExtraMap;
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
            this.e = strArr;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onCheckedChangeListener) == null) {
            this.g = onCheckedChangeListener;
        }
    }

    public final View e(List<b> list, boolean z, View view2) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), view2})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int i = 0;
            if (view2 instanceof LinearLayout) {
                linearLayout = (LinearLayout) view2;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            b bVar = list.get(0);
            if (bVar != null) {
                nEGFeedBackReasonCheckBox.setText(bVar.c);
                nEGFeedBackReasonCheckBox.setTag(bVar);
                if (bVar.a == this.m) {
                    nEGFeedBackReasonCheckBox.setEnabled(false);
                }
            }
            if (list.size() > 1 && list.get(1) != null) {
                b bVar2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(bVar2.c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(bVar2);
                if (bVar2.a == this.m) {
                    nEGFeedBackReasonCheckBox2.setEnabled(false);
                }
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(4);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.h);
            if (!z) {
                i = this.j;
            }
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public final View f(List<b> list, boolean z, View view2) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), view2})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int i = 0;
            if (view2 instanceof LinearLayout) {
                linearLayout = (LinearLayout) view2;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            b bVar = list.get(0);
            if (bVar != null) {
                nEGFeedBackReasonCheckBox.setText(bVar.c);
                nEGFeedBackReasonCheckBox.setTag(bVar);
            }
            if (list.size() > 1 && list.get(1) != null) {
                b bVar2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(bVar2.c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(bVar2);
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(8);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.h);
            if (!z) {
                i = this.j;
            }
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f == null) {
                LinearLayout linearLayout = new LinearLayout(this.b);
                this.f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<b>> p = p();
            if (ListUtils.isEmpty(p)) {
                return null;
            }
            int size = p.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.i;
            if (hashMap == null) {
                this.i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            for (int i = 0; i < size; i++) {
                List<b> list = p.get(i);
                if (i == size - 1) {
                    z = true;
                } else {
                    z = false;
                }
                View e = e(list, z, this.f.getChildAt(i));
                if (e != null && e.getParent() == null) {
                    this.f.addView(e);
                }
            }
            if (this.f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f == null) {
                LinearLayout linearLayout = new LinearLayout(this.b);
                this.f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<b>> s = s();
            if (ListUtils.isEmpty(s)) {
                return null;
            }
            int size = s.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.i;
            if (hashMap == null) {
                this.i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            for (int i = 0; i < size; i++) {
                List<b> list = s.get(i);
                if (i == size - 1) {
                    z = true;
                } else {
                    z = false;
                }
                View f = f(list, z, this.f.getChildAt(i));
                if (f != null && f.getParent() == null) {
                    this.f.addView(f);
                }
            }
            if (this.f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final List<List<b>> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String[] strArr = this.e;
            if (strArr != null && strArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.e.length; i += 2) {
                    ArrayList arrayList2 = new ArrayList();
                    if (!StringUtils.isNull(this.e[i])) {
                        arrayList2.add(new b(this, i, i + 1, this.e[i]));
                    }
                    int i2 = i + 1;
                    String[] strArr2 = this.e;
                    if (i2 < strArr2.length && !StringUtils.isNull(strArr2[i2])) {
                        arrayList2.add(new b(this, i2, i + 2, this.e[i2]));
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

    public final List<List<b>> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String[] strArr = this.e;
            if (strArr != null && strArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.e.length; i += 2) {
                    ArrayList arrayList2 = new ArrayList();
                    if (!StringUtils.isNull(this.e[i])) {
                        arrayList2.add(new b(this, i, 0, this.e[i]));
                    }
                    int i2 = i + 1;
                    String[] strArr2 = this.e;
                    if (i2 < strArr2.length && !StringUtils.isNull(strArr2[i2])) {
                        arrayList2.add(new b(this, i2, 0, this.e[i2]));
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

    public final List<List<b>> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SparseArray<String> sparseArray = this.c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.c.size();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < size) {
                    int i2 = i + 1;
                    int i3 = i + 2;
                    ArrayList arrayList2 = new ArrayList();
                    b bVar = new b(this, i, this.c.keyAt(i), this.c.valueAt(i));
                    SparseArray<String> sparseArray2 = this.d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.c.keyAt(i)))) {
                        bVar.d = this.d.get(this.c.keyAt(i));
                    }
                    arrayList2.add(bVar);
                    if (i2 > i && i2 < size) {
                        b bVar2 = new b(this, i2, this.c.keyAt(i2), this.c.valueAt(i2));
                        SparseArray<String> sparseArray3 = this.d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.c.keyAt(i)))) {
                            bVar2.d = this.d.get(this.c.keyAt(i2));
                        }
                        arrayList2.add(bVar2);
                    }
                    arrayList.add(arrayList2);
                    i = i3;
                }
                return arrayList;
            }
            return q();
        }
        return (List) invokeV.objValue;
    }

    public final List<List<b>> s() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SparseArray<String> sparseArray = this.c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.c.size();
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
                    b bVar = new b(this, i5, this.c.keyAt(i5), this.c.valueAt(i5));
                    SparseArray<String> sparseArray2 = this.d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.c.keyAt(i5)))) {
                        bVar.d = this.d.get(this.c.keyAt(i5));
                    }
                    arrayList2.add(bVar);
                    if (i4 > i5 && i4 < size) {
                        b bVar2 = new b(this, i4, this.c.keyAt(i4), this.c.valueAt(i4));
                        SparseArray<String> sparseArray3 = this.d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.c.keyAt(i5)))) {
                            bVar2.d = this.d.get(this.c.keyAt(i4));
                        }
                        arrayList2.add(bVar2);
                    }
                    arrayList.add(arrayList2);
                    i5 = i3;
                }
                return arrayList;
            }
            return r();
        }
        return (List) invokeV.objValue;
    }
}
