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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private String[] biK;
    private LinearLayout biL;
    private CompoundButton.OnCheckedChangeListener biM;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> biO;
    private int biP;
    private TbPageContext mPageContext;
    private boolean biI = false;
    private SparseArray<String> biJ = null;
    private boolean biQ = false;
    private CompoundButton.OnCheckedChangeListener biN = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.biO != null && !b.this.biO.isEmpty()) {
                if (z && b.this.biQ) {
                    for (Map.Entry entry : b.this.biO.entrySet()) {
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
                if (b.this.biM != null) {
                    b.this.biM.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.biP = l.f(this.mPageContext.getPageActivity(), f.e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.biJ = ahVar.uh();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.biK = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.biI = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.biM = onCheckedChangeListener;
    }

    public View getView() {
        if (this.biL == null) {
            this.biL = new LinearLayout(this.mPageContext.getPageActivity());
            this.biL.setOrientation(1);
        }
        List<List<a>> Pw = Pw();
        if (w.z(Pw)) {
            return null;
        }
        int size = Pw.size();
        if (this.biO == null) {
            this.biO = new HashMap<>();
        } else {
            this.biO.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(Pw.get(i), i == size + (-1), this.biL.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.biL.addView(a2);
            }
            i++;
        }
        if (this.biL.getChildCount() > size) {
            this.biL.removeViews(size, this.biL.getChildCount() - size);
        }
        return this.biL;
    }

    private List<List<a>> Pw() {
        int i;
        int i2;
        int i3 = -1;
        if (this.biJ == null || this.biJ.size() == 0) {
            return Px();
        }
        int size = this.biJ.size();
        int i4 = this.biI ? 0 : -1;
        int i5 = this.biI ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.biJ.keyAt(i6), this.biJ.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.biJ.keyAt(i), this.biJ.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Px() {
        if (this.biK == null || this.biK.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.biK.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.biK[i])) {
                arrayList2.add(new a(i, 0, this.biK[i]));
            }
            if (i + 1 < this.biK.length && !StringUtils.isNull(this.biK[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.biK[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.neg_feedback_reason_item, (ViewGroup) this.biL, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(f.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(f.g.right_reason);
        nEGFeedBackReasonCheckBox.AD();
        nEGFeedBackReasonCheckBox2.AD();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.biO.put(nEGFeedBackReasonCheckBox, false);
        this.biO.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.biN);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.biN);
        int i = z ? 0 : this.biP;
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.neg_feedback_reason_item, (ViewGroup) this.biL, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(f.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(f.g.right_reason);
        nEGFeedBackReasonCheckBox.AD();
        nEGFeedBackReasonCheckBox2.AD();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.biO.put(nEGFeedBackReasonCheckBox, false);
        this.biO.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.biN);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.biN);
        int i = z ? 0 : this.biP;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.biL == null) {
            this.biL = new LinearLayout(this.mPageContext.getPageActivity());
            this.biL.setOrientation(1);
        }
        List<List<a>> Pz = Pz();
        if (w.z(Pz)) {
            return null;
        }
        int size = Pz.size();
        if (this.biO == null) {
            this.biO = new HashMap<>();
        } else {
            this.biO.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Pz.get(i), i == size + (-1), this.biL.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.biL.addView(b);
            }
            i++;
        }
        if (this.biL.getChildCount() > size) {
            this.biL.removeViews(size, this.biL.getChildCount() - size);
        }
        return this.biL;
    }

    private List<List<a>> Py() {
        if (this.biK == null || this.biK.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.biK.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.biK[i])) {
                arrayList2.add(new a(i, i + 1, this.biK[i]));
            }
            if (i + 1 < this.biK.length && !StringUtils.isNull(this.biK[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.biK[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Pz() {
        if (this.biJ == null || this.biJ.size() == 0) {
            return Py();
        }
        int size = this.biJ.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.biJ.keyAt(i), this.biJ.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.biJ.keyAt(i2), this.biJ.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void cs(boolean z) {
        this.biQ = z;
    }
}
