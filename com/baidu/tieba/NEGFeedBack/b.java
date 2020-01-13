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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private String[] dPS;
    private LinearLayout dPT;
    private CompoundButton.OnCheckedChangeListener dPU;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> dPW;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean dPQ = false;
    private SparseArray<String> dPR = null;
    private boolean dPX = false;
    private CompoundButton.OnCheckedChangeListener dPV = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.dPW != null && !b.this.dPW.isEmpty()) {
                if (z && b.this.dPX) {
                    for (Map.Entry entry : b.this.dPW.entrySet()) {
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
                if (b.this.dPU != null) {
                    b.this.dPU.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dPR = alVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dPS = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dPQ = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.dPU = onCheckedChangeListener;
    }

    public View getView() {
        if (this.dPT == null) {
            this.dPT = new LinearLayout(this.mPageContext.getPageActivity());
            this.dPT.setOrientation(1);
        }
        List<List<a>> aTR = aTR();
        if (v.isEmpty(aTR)) {
            return null;
        }
        int size = aTR.size();
        if (this.dPW == null) {
            this.dPW = new HashMap<>();
        } else {
            this.dPW.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(aTR.get(i), i == size + (-1), this.dPT.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.dPT.addView(a2);
            }
            i++;
        }
        if (this.dPT.getChildCount() > size) {
            this.dPT.removeViews(size, this.dPT.getChildCount() - size);
        }
        return this.dPT;
    }

    private List<List<a>> aTR() {
        int i;
        int i2;
        int i3 = -1;
        if (this.dPR == null || this.dPR.size() == 0) {
            return aTS();
        }
        int size = this.dPR.size();
        int i4 = this.dPQ ? 0 : -1;
        int i5 = this.dPQ ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.dPR.keyAt(i6), this.dPR.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.dPR.keyAt(i), this.dPR.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> aTS() {
        if (this.dPS == null || this.dPS.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dPS.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dPS[i])) {
                arrayList2.add(new a(i, 0, this.dPS[i]));
            }
            if (i + 1 < this.dPS.length && !StringUtils.isNull(this.dPS[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.dPS[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dPT, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aFw();
        nEGFeedBackReasonCheckBox2.aFw();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dPW.put(nEGFeedBackReasonCheckBox, false);
        this.dPW.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dPV);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dPV);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes6.dex */
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
        if (v.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dPT, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aFw();
        nEGFeedBackReasonCheckBox2.aFw();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dPW.put(nEGFeedBackReasonCheckBox, false);
        this.dPW.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dPV);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dPV);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.dPT == null) {
            this.dPT = new LinearLayout(this.mPageContext.getPageActivity());
            this.dPT.setOrientation(1);
        }
        List<List<a>> aTU = aTU();
        if (v.isEmpty(aTU)) {
            return null;
        }
        int size = aTU.size();
        if (this.dPW == null) {
            this.dPW = new HashMap<>();
        } else {
            this.dPW.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(aTU.get(i), i == size + (-1), this.dPT.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.dPT.addView(b);
            }
            i++;
        }
        if (this.dPT.getChildCount() > size) {
            this.dPT.removeViews(size, this.dPT.getChildCount() - size);
        }
        return this.dPT;
    }

    private List<List<a>> aTT() {
        if (this.dPS == null || this.dPS.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dPS.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dPS[i])) {
                arrayList2.add(new a(i, i + 1, this.dPS[i]));
            }
            if (i + 1 < this.dPS.length && !StringUtils.isNull(this.dPS[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.dPS[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> aTU() {
        if (this.dPR == null || this.dPR.size() == 0) {
            return aTT();
        }
        int size = this.dPR.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.dPR.keyAt(i), this.dPR.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.dPR.keyAt(i2), this.dPR.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void hp(boolean z) {
        this.dPX = z;
    }
}
