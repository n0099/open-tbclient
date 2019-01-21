package com.baidu.tieba.NEGFeedBack;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private LinearLayout bxA;
    private CompoundButton.OnCheckedChangeListener bxB;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> bxD;
    private String[] bxz;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean bxx = false;
    private SparseArray<String> bxy = null;
    private boolean bxE = false;
    private CompoundButton.OnCheckedChangeListener bxC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.bxD != null && !b.this.bxD.isEmpty()) {
                if (z && b.this.bxE) {
                    for (Map.Entry entry : b.this.bxD.entrySet()) {
                        if (entry != null) {
                            if (entry.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry.getKey()).setChecked(true);
                                entry.setValue(true);
                            } else {
                                ((NEGFeedBackReasonCheckBox) entry.getKey()).setChecked(false);
                                entry.setValue(false);
                            }
                        }
                    }
                }
                if (b.this.bxB != null) {
                    b.this.bxB.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bxy = ahVar.yS();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bxz = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bxx = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bxB = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bxA == null) {
            this.bxA = new LinearLayout(this.mPageContext.getPageActivity());
            this.bxA.setOrientation(1);
        }
        List<List<a>> US = US();
        if (v.I(US)) {
            return null;
        }
        int size = US.size();
        if (this.bxD == null) {
            this.bxD = new HashMap<>();
        } else {
            this.bxD.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(US.get(i), i == size + (-1), this.bxA.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bxA.addView(a2);
            }
            i++;
        }
        if (this.bxA.getChildCount() > size) {
            this.bxA.removeViews(size, this.bxA.getChildCount() - size);
        }
        return this.bxA;
    }

    private List<List<a>> US() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bxy == null || this.bxy.size() == 0) {
            return UT();
        }
        int size = this.bxy.size();
        int i4 = this.bxx ? 0 : -1;
        int i5 = this.bxx ? size - 1 : size;
        if (i5 > 1 && i5 % 2 == 1) {
            i3 = i4 + 1;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < size) {
            if (i6 == i4 || i6 == i3) {
                i = i6;
                i2 = i6 + 1;
            } else {
                i2 = i6 + 2;
                i = i6 + 1;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i6, this.bxy.keyAt(i6), this.bxy.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bxy.keyAt(i), this.bxy.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> UT() {
        if (this.bxz == null || this.bxz.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bxz.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bxz[i])) {
                arrayList2.add(new a(i, 0, this.bxz[i]));
            }
            if (i + 1 < this.bxz.length && !StringUtils.isNull(this.bxz[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bxz[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.I(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bxA, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fw();
        nEGFeedBackReasonCheckBox2.Fw();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bxD.put(nEGFeedBackReasonCheckBox, false);
        this.bxD.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(8);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bxC);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bxC);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes6.dex */
    public class a {
        public int id;
        public int index;
        public String reason;

        public a(int i, int i2, String str) {
            this.id = i2;
            this.reason = str;
            this.index = i;
        }
    }

    private View b(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.I(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bxA, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fw();
        nEGFeedBackReasonCheckBox2.Fw();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bxD.put(nEGFeedBackReasonCheckBox, false);
        this.bxD.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bxC);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bxC);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.bxA == null) {
            this.bxA = new LinearLayout(this.mPageContext.getPageActivity());
            this.bxA.setOrientation(1);
        }
        List<List<a>> UV = UV();
        if (v.I(UV)) {
            return null;
        }
        int size = UV.size();
        if (this.bxD == null) {
            this.bxD = new HashMap<>();
        } else {
            this.bxD.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(UV.get(i), i == size + (-1), this.bxA.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.bxA.addView(b);
            }
            i++;
        }
        if (this.bxA.getChildCount() > size) {
            this.bxA.removeViews(size, this.bxA.getChildCount() - size);
        }
        return this.bxA;
    }

    private List<List<a>> UU() {
        if (this.bxz == null || this.bxz.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bxz.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bxz[i])) {
                arrayList2.add(new a(i, i + 1, this.bxz[i]));
            }
            if (i + 1 < this.bxz.length && !StringUtils.isNull(this.bxz[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bxz[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> UV() {
        if (this.bxy == null || this.bxy.size() == 0) {
            return UU();
        }
        int size = this.bxy.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bxy.keyAt(i), this.bxy.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bxy.keyAt(i2), this.bxy.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void dn(boolean z) {
        this.bxE = z;
    }
}
