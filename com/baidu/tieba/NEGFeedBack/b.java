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
    private CompoundButton.OnCheckedChangeListener bxA;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> bxC;
    private String[] bxy;
    private LinearLayout bxz;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean bxw = false;
    private SparseArray<String> bxx = null;
    private boolean bxD = false;
    private CompoundButton.OnCheckedChangeListener bxB = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.bxC != null && !b.this.bxC.isEmpty()) {
                if (z && b.this.bxD) {
                    for (Map.Entry entry : b.this.bxC.entrySet()) {
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
                if (b.this.bxA != null) {
                    b.this.bxA.onCheckedChanged(compoundButton, z);
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
            this.bxx = ahVar.yS();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bxy = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bxw = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bxA = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bxz == null) {
            this.bxz = new LinearLayout(this.mPageContext.getPageActivity());
            this.bxz.setOrientation(1);
        }
        List<List<a>> US = US();
        if (v.I(US)) {
            return null;
        }
        int size = US.size();
        if (this.bxC == null) {
            this.bxC = new HashMap<>();
        } else {
            this.bxC.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(US.get(i), i == size + (-1), this.bxz.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bxz.addView(a2);
            }
            i++;
        }
        if (this.bxz.getChildCount() > size) {
            this.bxz.removeViews(size, this.bxz.getChildCount() - size);
        }
        return this.bxz;
    }

    private List<List<a>> US() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bxx == null || this.bxx.size() == 0) {
            return UT();
        }
        int size = this.bxx.size();
        int i4 = this.bxw ? 0 : -1;
        int i5 = this.bxw ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bxx.keyAt(i6), this.bxx.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bxx.keyAt(i), this.bxx.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> UT() {
        if (this.bxy == null || this.bxy.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bxy.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bxy[i])) {
                arrayList2.add(new a(i, 0, this.bxy[i]));
            }
            if (i + 1 < this.bxy.length && !StringUtils.isNull(this.bxy[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bxy[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bxz, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fw();
        nEGFeedBackReasonCheckBox2.Fw();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bxC.put(nEGFeedBackReasonCheckBox, false);
        this.bxC.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bxB);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bxB);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bxz, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fw();
        nEGFeedBackReasonCheckBox2.Fw();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bxC.put(nEGFeedBackReasonCheckBox, false);
        this.bxC.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bxB);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bxB);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.bxz == null) {
            this.bxz = new LinearLayout(this.mPageContext.getPageActivity());
            this.bxz.setOrientation(1);
        }
        List<List<a>> UV = UV();
        if (v.I(UV)) {
            return null;
        }
        int size = UV.size();
        if (this.bxC == null) {
            this.bxC = new HashMap<>();
        } else {
            this.bxC.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(UV.get(i), i == size + (-1), this.bxz.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.bxz.addView(b);
            }
            i++;
        }
        if (this.bxz.getChildCount() > size) {
            this.bxz.removeViews(size, this.bxz.getChildCount() - size);
        }
        return this.bxz;
    }

    private List<List<a>> UU() {
        if (this.bxy == null || this.bxy.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bxy.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bxy[i])) {
                arrayList2.add(new a(i, i + 1, this.bxy[i]));
            }
            if (i + 1 < this.bxy.length && !StringUtils.isNull(this.bxy[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bxy[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> UV() {
        if (this.bxx == null || this.bxx.size() == 0) {
            return UU();
        }
        int size = this.bxx.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bxx.keyAt(i), this.bxx.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bxx.keyAt(i2), this.bxx.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void dn(boolean z) {
        this.bxD = z;
    }
}
