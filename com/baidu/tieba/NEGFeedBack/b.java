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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private String[] biE;
    private LinearLayout biF;
    private CompoundButton.OnCheckedChangeListener biG;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> biI;
    private int biJ;
    private TbPageContext mPageContext;
    private boolean biC = false;
    private SparseArray<String> biD = null;
    private boolean biK = false;
    private CompoundButton.OnCheckedChangeListener biH = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.biI != null && !b.this.biI.isEmpty()) {
                if (z && b.this.biK) {
                    for (Map.Entry entry : b.this.biI.entrySet()) {
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
                if (b.this.biG != null) {
                    b.this.biG.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.biJ = l.f(this.mPageContext.getPageActivity(), d.e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.biD = ahVar.ui();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.biE = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.biC = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.biG = onCheckedChangeListener;
    }

    public View getView() {
        if (this.biF == null) {
            this.biF = new LinearLayout(this.mPageContext.getPageActivity());
            this.biF.setOrientation(1);
        }
        List<List<a>> Pq = Pq();
        if (w.z(Pq)) {
            return null;
        }
        int size = Pq.size();
        if (this.biI == null) {
            this.biI = new HashMap<>();
        } else {
            this.biI.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(Pq.get(i), i == size + (-1), this.biF.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.biF.addView(a2);
            }
            i++;
        }
        if (this.biF.getChildCount() > size) {
            this.biF.removeViews(size, this.biF.getChildCount() - size);
        }
        return this.biF;
    }

    private List<List<a>> Pq() {
        int i;
        int i2;
        int i3 = -1;
        if (this.biD == null || this.biD.size() == 0) {
            return Pr();
        }
        int size = this.biD.size();
        int i4 = this.biC ? 0 : -1;
        int i5 = this.biC ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.biD.keyAt(i6), this.biD.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.biD.keyAt(i), this.biD.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Pr() {
        if (this.biE == null || this.biE.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.biE.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.biE[i])) {
                arrayList2.add(new a(i, 0, this.biE[i]));
            }
            if (i + 1 < this.biE.length && !StringUtils.isNull(this.biE[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.biE[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (w.z(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.biF, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.AG();
        nEGFeedBackReasonCheckBox2.AG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.biI.put(nEGFeedBackReasonCheckBox, false);
        this.biI.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.biH);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.biH);
        int i = z ? 0 : this.biJ;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes2.dex */
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
        if (w.z(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.biF, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.AG();
        nEGFeedBackReasonCheckBox2.AG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.biI.put(nEGFeedBackReasonCheckBox, false);
        this.biI.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.biH);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.biH);
        int i = z ? 0 : this.biJ;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.biF == null) {
            this.biF = new LinearLayout(this.mPageContext.getPageActivity());
            this.biF.setOrientation(1);
        }
        List<List<a>> Pt = Pt();
        if (w.z(Pt)) {
            return null;
        }
        int size = Pt.size();
        if (this.biI == null) {
            this.biI = new HashMap<>();
        } else {
            this.biI.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Pt.get(i), i == size + (-1), this.biF.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.biF.addView(b);
            }
            i++;
        }
        if (this.biF.getChildCount() > size) {
            this.biF.removeViews(size, this.biF.getChildCount() - size);
        }
        return this.biF;
    }

    private List<List<a>> Ps() {
        if (this.biE == null || this.biE.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.biE.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.biE[i])) {
                arrayList2.add(new a(i, i + 1, this.biE[i]));
            }
            if (i + 1 < this.biE.length && !StringUtils.isNull(this.biE[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.biE[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Pt() {
        if (this.biD == null || this.biD.size() == 0) {
            return Ps();
        }
        int size = this.biD.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.biD.keyAt(i), this.biD.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.biD.keyAt(i2), this.biD.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void cr(boolean z) {
        this.biK = z;
    }
}
