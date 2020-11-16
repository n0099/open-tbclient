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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class b {
    private String[] fOv;
    private LinearLayout fOw;
    private CompoundButton.OnCheckedChangeListener fOx;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> fOz;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean fOs = false;
    private SparseArray<String> fOt = null;
    private SparseArray<String> fOu = null;
    private boolean fOA = false;
    private CompoundButton.OnCheckedChangeListener fOy = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.fOz != null && !b.this.fOz.isEmpty()) {
                if (z && b.this.fOA) {
                    for (Map.Entry entry : b.this.fOz.entrySet()) {
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
                if (b.this.fOx != null) {
                    b.this.fOx.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.M_H_X003);
    }

    public void setData(as asVar) {
        if (asVar != null) {
            this.fOt = asVar.getFeedBackReasonMap();
            this.fOu = asVar.ezX;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fOv = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fOs = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.fOx = onCheckedChangeListener;
    }

    public View getView() {
        if (this.fOw == null) {
            this.fOw = new LinearLayout(this.mPageContext.getPageActivity());
            this.fOw.setOrientation(1);
        }
        List<List<a>> bHL = bHL();
        if (y.isEmpty(bHL)) {
            return null;
        }
        int size = bHL.size();
        if (this.fOz == null) {
            this.fOz = new HashMap<>();
        } else {
            this.fOz.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bHL.get(i), i == size + (-1), this.fOw.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.fOw.addView(a2);
            }
            i++;
        }
        if (this.fOw.getChildCount() > size) {
            this.fOw.removeViews(size, this.fOw.getChildCount() - size);
        }
        return this.fOw;
    }

    private List<List<a>> bHL() {
        int i;
        int i2;
        int i3 = -1;
        if (this.fOt == null || this.fOt.size() == 0) {
            return bHM();
        }
        int size = this.fOt.size();
        int i4 = this.fOs ? 0 : -1;
        int i5 = this.fOs ? size - 1 : size;
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
            a aVar = new a(i6, this.fOt.keyAt(i6), this.fOt.valueAt(i6));
            if (this.fOu != null && !StringUtils.isNull(this.fOu.get(this.fOt.keyAt(i6)))) {
                aVar.extra = this.fOu.get(this.fOt.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.fOt.keyAt(i), this.fOt.valueAt(i));
                if (this.fOu != null && !StringUtils.isNull(this.fOu.get(this.fOt.keyAt(i6)))) {
                    aVar2.extra = this.fOu.get(this.fOt.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bHM() {
        if (this.fOv == null || this.fOv.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fOv.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fOv[i])) {
                arrayList2.add(new a(i, 0, this.fOv[i]));
            }
            if (i + 1 < this.fOv.length && !StringUtils.isNull(this.fOv[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.fOv[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (y.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fOw, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.brT();
        nEGFeedBackReasonCheckBox2.brT();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fOz.put(nEGFeedBackReasonCheckBox, false);
        this.fOz.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fOy);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fOy);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes20.dex */
    public class a {
        public String extra;
        public int id;
        public int index;
        public String reason;

        public a(int i, int i2, String str) {
            this.id = i2;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.reason = split[0];
                if (split.length > 1) {
                    this.extra = split[1];
                }
            } else {
                this.reason = str;
            }
            this.index = i;
        }
    }

    private View b(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (y.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fOw, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.brT();
        nEGFeedBackReasonCheckBox2.brT();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fOz.put(nEGFeedBackReasonCheckBox, false);
        this.fOz.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fOy);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fOy);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.fOw == null) {
            this.fOw = new LinearLayout(this.mPageContext.getPageActivity());
            this.fOw.setOrientation(1);
        }
        List<List<a>> bHO = bHO();
        if (y.isEmpty(bHO)) {
            return null;
        }
        int size = bHO.size();
        if (this.fOz == null) {
            this.fOz = new HashMap<>();
        } else {
            this.fOz.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bHO.get(i), i == size + (-1), this.fOw.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.fOw.addView(b);
            }
            i++;
        }
        if (this.fOw.getChildCount() > size) {
            this.fOw.removeViews(size, this.fOw.getChildCount() - size);
        }
        return this.fOw;
    }

    private List<List<a>> bHN() {
        if (this.fOv == null || this.fOv.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fOv.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fOv[i])) {
                arrayList2.add(new a(i, i + 1, this.fOv[i]));
            }
            if (i + 1 < this.fOv.length && !StringUtils.isNull(this.fOv[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.fOv[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bHO() {
        if (this.fOt == null || this.fOt.size() == 0) {
            return bHN();
        }
        int size = this.fOt.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.fOt.keyAt(i), this.fOt.valueAt(i));
            if (this.fOu != null && !StringUtils.isNull(this.fOu.get(this.fOt.keyAt(i)))) {
                aVar.extra = this.fOu.get(this.fOt.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.fOt.keyAt(i2), this.fOt.valueAt(i2));
                if (this.fOu != null && !StringUtils.isNull(this.fOu.get(this.fOt.keyAt(i)))) {
                    aVar2.extra = this.fOu.get(this.fOt.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lf(boolean z) {
        this.fOA = z;
    }
}
