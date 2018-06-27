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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private String[] bhX;
    private LinearLayout bhY;
    private CompoundButton.OnCheckedChangeListener bhZ;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> bib;
    private int bic;
    private TbPageContext mPageContext;
    private boolean bhV = false;
    private SparseArray<String> bhW = null;
    private boolean bie = false;
    private CompoundButton.OnCheckedChangeListener bia = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.bib != null && !b.this.bib.isEmpty()) {
                if (z && b.this.bie) {
                    for (Map.Entry entry : b.this.bib.entrySet()) {
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
                if (b.this.bhZ != null) {
                    b.this.bhZ.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bic = l.e(this.mPageContext.getPageActivity(), d.e.ds16);
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.bhW = aiVar.uv();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bhX = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bhV = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bhZ = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bhY == null) {
            this.bhY = new LinearLayout(this.mPageContext.getPageActivity());
            this.bhY.setOrientation(1);
        }
        List<List<a>> Pk = Pk();
        if (w.A(Pk)) {
            return null;
        }
        int size = Pk.size();
        if (this.bib == null) {
            this.bib = new HashMap<>();
        } else {
            this.bib.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(Pk.get(i), i == size + (-1), this.bhY.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bhY.addView(a2);
            }
            i++;
        }
        if (this.bhY.getChildCount() > size) {
            this.bhY.removeViews(size, this.bhY.getChildCount() - size);
        }
        return this.bhY;
    }

    private List<List<a>> Pk() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bhW == null || this.bhW.size() == 0) {
            return Pl();
        }
        int size = this.bhW.size();
        int i4 = this.bhV ? 0 : -1;
        int i5 = this.bhV ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bhW.keyAt(i6), this.bhW.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bhW.keyAt(i), this.bhW.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Pl() {
        if (this.bhX == null || this.bhX.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bhX.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bhX[i])) {
                arrayList2.add(new a(i, 0, this.bhX[i]));
            }
            if (i + 1 < this.bhX.length && !StringUtils.isNull(this.bhX[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bhX[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (w.A(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.neg_feedback_reason_item, (ViewGroup) this.bhY, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.AP();
        nEGFeedBackReasonCheckBox2.AP();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bib.put(nEGFeedBackReasonCheckBox, false);
        this.bib.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bia);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bia);
        int i = z ? 0 : this.bic;
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
        if (w.A(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.neg_feedback_reason_item, (ViewGroup) this.bhY, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.AP();
        nEGFeedBackReasonCheckBox2.AP();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bib.put(nEGFeedBackReasonCheckBox, false);
        this.bib.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bia);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bia);
        int i = z ? 0 : this.bic;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.bhY == null) {
            this.bhY = new LinearLayout(this.mPageContext.getPageActivity());
            this.bhY.setOrientation(1);
        }
        List<List<a>> Pn = Pn();
        if (w.A(Pn)) {
            return null;
        }
        int size = Pn.size();
        if (this.bib == null) {
            this.bib = new HashMap<>();
        } else {
            this.bib.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Pn.get(i), i == size + (-1), this.bhY.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.bhY.addView(b);
            }
            i++;
        }
        if (this.bhY.getChildCount() > size) {
            this.bhY.removeViews(size, this.bhY.getChildCount() - size);
        }
        return this.bhY;
    }

    private List<List<a>> Pm() {
        if (this.bhX == null || this.bhX.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bhX.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bhX[i])) {
                arrayList2.add(new a(i, i + 1, this.bhX[i]));
            }
            if (i + 1 < this.bhX.length && !StringUtils.isNull(this.bhX[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bhX[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Pn() {
        if (this.bhW == null || this.bhW.size() == 0) {
            return Pm();
        }
        int size = this.bhW.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bhW.keyAt(i), this.bhW.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bhW.keyAt(i2), this.bhW.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void cr(boolean z) {
        this.bie = z;
    }
}
