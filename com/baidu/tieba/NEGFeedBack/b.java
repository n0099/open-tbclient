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
    private int bhx;
    private String[] cID;
    private LinearLayout cIE;
    private CompoundButton.OnCheckedChangeListener cIF;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> cIH;
    private TbPageContext mPageContext;
    private boolean cIB = false;
    private SparseArray<String> cIC = null;
    private boolean cII = false;
    private CompoundButton.OnCheckedChangeListener cIG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.cIH != null && !b.this.cIH.isEmpty()) {
                if (z && b.this.cII) {
                    for (Map.Entry entry : b.this.cIH.entrySet()) {
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
                if (b.this.cIF != null) {
                    b.this.cIF.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bhx = l.h(this.mPageContext.getPageActivity(), d.e.tbds20);
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cIC = ajVar.XA();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cID = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cIB = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.cIF = onCheckedChangeListener;
    }

    public View getView() {
        if (this.cIE == null) {
            this.cIE = new LinearLayout(this.mPageContext.getPageActivity());
            this.cIE.setOrientation(1);
        }
        List<List<a>> auQ = auQ();
        if (v.T(auQ)) {
            return null;
        }
        int size = auQ.size();
        if (this.cIH == null) {
            this.cIH = new HashMap<>();
        } else {
            this.cIH.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(auQ.get(i), i == size + (-1), this.cIE.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.cIE.addView(a2);
            }
            i++;
        }
        if (this.cIE.getChildCount() > size) {
            this.cIE.removeViews(size, this.cIE.getChildCount() - size);
        }
        return this.cIE;
    }

    private List<List<a>> auQ() {
        int i;
        int i2;
        int i3 = -1;
        if (this.cIC == null || this.cIC.size() == 0) {
            return auR();
        }
        int size = this.cIC.size();
        int i4 = this.cIB ? 0 : -1;
        int i5 = this.cIB ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.cIC.keyAt(i6), this.cIC.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.cIC.keyAt(i), this.cIC.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> auR() {
        if (this.cID == null || this.cID.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cID.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cID[i])) {
                arrayList2.add(new a(i, 0, this.cID[i]));
            }
            if (i + 1 < this.cID.length && !StringUtils.isNull(this.cID[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.cID[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.cIE, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.aeK();
        nEGFeedBackReasonCheckBox2.aeK();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cIH.put(nEGFeedBackReasonCheckBox, false);
        this.cIH.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cIG);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cIG);
        int i = z ? 0 : this.bhx;
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.cIE, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.aeK();
        nEGFeedBackReasonCheckBox2.aeK();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cIH.put(nEGFeedBackReasonCheckBox, false);
        this.cIH.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cIG);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cIG);
        int i = z ? 0 : this.bhx;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.cIE == null) {
            this.cIE = new LinearLayout(this.mPageContext.getPageActivity());
            this.cIE.setOrientation(1);
        }
        List<List<a>> auT = auT();
        if (v.T(auT)) {
            return null;
        }
        int size = auT.size();
        if (this.cIH == null) {
            this.cIH = new HashMap<>();
        } else {
            this.cIH.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(auT.get(i), i == size + (-1), this.cIE.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.cIE.addView(b);
            }
            i++;
        }
        if (this.cIE.getChildCount() > size) {
            this.cIE.removeViews(size, this.cIE.getChildCount() - size);
        }
        return this.cIE;
    }

    private List<List<a>> auS() {
        if (this.cID == null || this.cID.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cID.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cID[i])) {
                arrayList2.add(new a(i, i + 1, this.cID[i]));
            }
            if (i + 1 < this.cID.length && !StringUtils.isNull(this.cID[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.cID[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> auT() {
        if (this.cIC == null || this.cIC.size() == 0) {
            return auS();
        }
        int size = this.cIC.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.cIC.keyAt(i), this.cIC.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.cIC.keyAt(i2), this.cIC.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void fD(boolean z) {
        this.cII = z;
    }
}
