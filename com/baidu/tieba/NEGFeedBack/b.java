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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private String[] gfP;
    private LinearLayout gfQ;
    private CompoundButton.OnCheckedChangeListener gfR;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> gfT;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean gfM = false;
    private SparseArray<String> gfN = null;
    private SparseArray<String> gfO = null;
    private boolean gfU = false;
    private boolean gfV = true;
    private int gfW = -1;
    private CompoundButton.OnCheckedChangeListener gfS = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            if (compoundButton != null && b.this.gfT != null && !b.this.gfT.isEmpty()) {
                if (z && b.this.gfU) {
                    for (Map.Entry entry : b.this.gfT.entrySet()) {
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
                if (b.this.gfU && !z && !b.this.gfV) {
                    Iterator it = b.this.gfT.entrySet().iterator();
                    boolean z3 = false;
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = z3;
                            break;
                        }
                        Map.Entry entry2 = (Map.Entry) it.next();
                        if (entry2 != null && entry2.getKey() != null) {
                            z2 = ((NEGFeedBackReasonCheckBox) entry2.getKey()).isChecked();
                            if (z2) {
                                break;
                            }
                            z3 = z2;
                        }
                    }
                    if (!z2) {
                        for (Map.Entry entry3 : b.this.gfT.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(true);
                                return;
                            }
                        }
                    }
                }
                if (b.this.gfR != null) {
                    b.this.gfR.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.M_H_X003);
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.gfN = atVar.getFeedBackReasonMap();
            this.gfO = atVar.eQN;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gfP = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gfM = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.gfR = onCheckedChangeListener;
    }

    public View getView() {
        if (this.gfQ == null) {
            this.gfQ = new LinearLayout(this.mPageContext.getPageActivity());
            this.gfQ.setOrientation(1);
        }
        List<List<a>> bNE = bNE();
        if (x.isEmpty(bNE)) {
            return null;
        }
        int size = bNE.size();
        if (this.gfT == null) {
            this.gfT = new HashMap<>();
        } else {
            this.gfT.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bNE.get(i), i == size + (-1), this.gfQ.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.gfQ.addView(a2);
            }
            i++;
        }
        if (this.gfQ.getChildCount() > size) {
            this.gfQ.removeViews(size, this.gfQ.getChildCount() - size);
        }
        return this.gfQ;
    }

    private List<List<a>> bNE() {
        int i;
        int i2;
        int i3 = -1;
        if (this.gfN == null || this.gfN.size() == 0) {
            return bNF();
        }
        int size = this.gfN.size();
        int i4 = this.gfM ? 0 : -1;
        int i5 = this.gfM ? size - 1 : size;
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
            a aVar = new a(i6, this.gfN.keyAt(i6), this.gfN.valueAt(i6));
            if (this.gfO != null && !StringUtils.isNull(this.gfO.get(this.gfN.keyAt(i6)))) {
                aVar.extra = this.gfO.get(this.gfN.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.gfN.keyAt(i), this.gfN.valueAt(i));
                if (this.gfO != null && !StringUtils.isNull(this.gfO.get(this.gfN.keyAt(i6)))) {
                    aVar2.extra = this.gfO.get(this.gfN.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bNF() {
        if (this.gfP == null || this.gfP.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gfP.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gfP[i])) {
                arrayList2.add(new a(i, 0, this.gfP[i]));
            }
            if (i + 1 < this.gfP.length && !StringUtils.isNull(this.gfP[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.gfP[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (x.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gfQ, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bxO();
        nEGFeedBackReasonCheckBox2.bxO();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gfT.put(nEGFeedBackReasonCheckBox, false);
        this.gfT.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gfS);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gfS);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes.dex */
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
        if (x.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gfQ, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bxO();
        nEGFeedBackReasonCheckBox2.bxO();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gfT.put(nEGFeedBackReasonCheckBox, false);
        this.gfT.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
            if (aVar.index == this.gfW) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
            if (aVar2.index == this.gfW) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gfS);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gfS);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.gfQ == null) {
            this.gfQ = new LinearLayout(this.mPageContext.getPageActivity());
            this.gfQ.setOrientation(1);
        }
        List<List<a>> bNH = bNH();
        if (x.isEmpty(bNH)) {
            return null;
        }
        int size = bNH.size();
        if (this.gfT == null) {
            this.gfT = new HashMap<>();
        } else {
            this.gfT.clear();
        }
        int i = 0;
        while (i < size) {
            View b2 = b(bNH.get(i), i == size + (-1), this.gfQ.getChildAt(i));
            if (b2 != null && b2.getParent() == null) {
                this.gfQ.addView(b2);
            }
            i++;
        }
        if (this.gfQ.getChildCount() > size) {
            this.gfQ.removeViews(size, this.gfQ.getChildCount() - size);
        }
        return this.gfQ;
    }

    private List<List<a>> bNG() {
        if (this.gfP == null || this.gfP.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gfP.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gfP[i])) {
                arrayList2.add(new a(i, i + 1, this.gfP[i]));
            }
            if (i + 1 < this.gfP.length && !StringUtils.isNull(this.gfP[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.gfP[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bNH() {
        if (this.gfN == null || this.gfN.size() == 0) {
            return bNG();
        }
        int size = this.gfN.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.gfN.keyAt(i), this.gfN.valueAt(i));
            if (this.gfO != null && !StringUtils.isNull(this.gfO.get(this.gfN.keyAt(i)))) {
                aVar.extra = this.gfO.get(this.gfN.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.gfN.keyAt(i2), this.gfN.valueAt(i2));
                if (this.gfO != null && !StringUtils.isNull(this.gfO.get(this.gfN.keyAt(i)))) {
                    aVar2.extra = this.gfO.get(this.gfN.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lW(boolean z) {
        this.gfU = z;
    }

    public void lX(boolean z) {
        this.gfV = z;
    }

    public void ut(int i) {
        this.gfW = i;
    }
}
