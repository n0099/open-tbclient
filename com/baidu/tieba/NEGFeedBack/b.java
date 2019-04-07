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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private int bhB;
    private String[] cIC;
    private LinearLayout cID;
    private CompoundButton.OnCheckedChangeListener cIE;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> cIG;
    private TbPageContext mPageContext;
    private boolean cIA = false;
    private SparseArray<String> cIB = null;
    private boolean cIH = false;
    private CompoundButton.OnCheckedChangeListener cIF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.cIG != null && !b.this.cIG.isEmpty()) {
                if (z && b.this.cIH) {
                    for (Map.Entry entry : b.this.cIG.entrySet()) {
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
                if (b.this.cIE != null) {
                    b.this.cIE.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bhB = l.h(this.mPageContext.getPageActivity(), d.e.tbds20);
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cIB = ajVar.Xx();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cIC = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cIA = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.cIE = onCheckedChangeListener;
    }

    public View getView() {
        if (this.cID == null) {
            this.cID = new LinearLayout(this.mPageContext.getPageActivity());
            this.cID.setOrientation(1);
        }
        List<List<a>> auN = auN();
        if (v.T(auN)) {
            return null;
        }
        int size = auN.size();
        if (this.cIG == null) {
            this.cIG = new HashMap<>();
        } else {
            this.cIG.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(auN.get(i), i == size + (-1), this.cID.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.cID.addView(a2);
            }
            i++;
        }
        if (this.cID.getChildCount() > size) {
            this.cID.removeViews(size, this.cID.getChildCount() - size);
        }
        return this.cID;
    }

    private List<List<a>> auN() {
        int i;
        int i2;
        int i3 = -1;
        if (this.cIB == null || this.cIB.size() == 0) {
            return auO();
        }
        int size = this.cIB.size();
        int i4 = this.cIA ? 0 : -1;
        int i5 = this.cIA ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.cIB.keyAt(i6), this.cIB.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.cIB.keyAt(i), this.cIB.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> auO() {
        if (this.cIC == null || this.cIC.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cIC.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cIC[i])) {
                arrayList2.add(new a(i, 0, this.cIC[i]));
            }
            if (i + 1 < this.cIC.length && !StringUtils.isNull(this.cIC[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.cIC[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.T(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.cID, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.aeH();
        nEGFeedBackReasonCheckBox2.aeH();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cIG.put(nEGFeedBackReasonCheckBox, false);
        this.cIG.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cIF);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cIF);
        int i = z ? 0 : this.bhB;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes3.dex */
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
        if (v.T(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.cID, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.aeH();
        nEGFeedBackReasonCheckBox2.aeH();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cIG.put(nEGFeedBackReasonCheckBox, false);
        this.cIG.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cIF);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cIF);
        int i = z ? 0 : this.bhB;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.cID == null) {
            this.cID = new LinearLayout(this.mPageContext.getPageActivity());
            this.cID.setOrientation(1);
        }
        List<List<a>> auQ = auQ();
        if (v.T(auQ)) {
            return null;
        }
        int size = auQ.size();
        if (this.cIG == null) {
            this.cIG = new HashMap<>();
        } else {
            this.cIG.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(auQ.get(i), i == size + (-1), this.cID.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.cID.addView(b);
            }
            i++;
        }
        if (this.cID.getChildCount() > size) {
            this.cID.removeViews(size, this.cID.getChildCount() - size);
        }
        return this.cID;
    }

    private List<List<a>> auP() {
        if (this.cIC == null || this.cIC.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cIC.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cIC[i])) {
                arrayList2.add(new a(i, i + 1, this.cIC[i]));
            }
            if (i + 1 < this.cIC.length && !StringUtils.isNull(this.cIC[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.cIC[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> auQ() {
        if (this.cIB == null || this.cIB.size() == 0) {
            return auP();
        }
        int size = this.cIB.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.cIB.keyAt(i), this.cIB.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.cIB.keyAt(i2), this.cIB.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void fD(boolean z) {
        this.cIH = z;
    }
}
