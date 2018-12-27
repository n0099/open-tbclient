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
    private String[] bwK;
    private LinearLayout bwL;
    private CompoundButton.OnCheckedChangeListener bwM;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> bwO;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean bwI = false;
    private SparseArray<String> bwJ = null;
    private boolean bwP = false;
    private CompoundButton.OnCheckedChangeListener bwN = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.bwO != null && !b.this.bwO.isEmpty()) {
                if (z && b.this.bwP) {
                    for (Map.Entry entry : b.this.bwO.entrySet()) {
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
                if (b.this.bwM != null) {
                    b.this.bwM.onCheckedChanged(compoundButton, z);
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
            this.bwJ = ahVar.yF();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bwK = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bwI = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bwM = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bwL == null) {
            this.bwL = new LinearLayout(this.mPageContext.getPageActivity());
            this.bwL.setOrientation(1);
        }
        List<List<a>> Uw = Uw();
        if (v.I(Uw)) {
            return null;
        }
        int size = Uw.size();
        if (this.bwO == null) {
            this.bwO = new HashMap<>();
        } else {
            this.bwO.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(Uw.get(i), i == size + (-1), this.bwL.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bwL.addView(a2);
            }
            i++;
        }
        if (this.bwL.getChildCount() > size) {
            this.bwL.removeViews(size, this.bwL.getChildCount() - size);
        }
        return this.bwL;
    }

    private List<List<a>> Uw() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bwJ == null || this.bwJ.size() == 0) {
            return Ux();
        }
        int size = this.bwJ.size();
        int i4 = this.bwI ? 0 : -1;
        int i5 = this.bwI ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bwJ.keyAt(i6), this.bwJ.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bwJ.keyAt(i), this.bwJ.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Ux() {
        if (this.bwK == null || this.bwK.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bwK.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bwK[i])) {
                arrayList2.add(new a(i, 0, this.bwK[i]));
            }
            if (i + 1 < this.bwK.length && !StringUtils.isNull(this.bwK[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bwK[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bwL, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fj();
        nEGFeedBackReasonCheckBox2.Fj();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bwO.put(nEGFeedBackReasonCheckBox, false);
        this.bwO.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bwN);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bwN);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bwL, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fj();
        nEGFeedBackReasonCheckBox2.Fj();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bwO.put(nEGFeedBackReasonCheckBox, false);
        this.bwO.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bwN);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bwN);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.bwL == null) {
            this.bwL = new LinearLayout(this.mPageContext.getPageActivity());
            this.bwL.setOrientation(1);
        }
        List<List<a>> Uz = Uz();
        if (v.I(Uz)) {
            return null;
        }
        int size = Uz.size();
        if (this.bwO == null) {
            this.bwO = new HashMap<>();
        } else {
            this.bwO.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Uz.get(i), i == size + (-1), this.bwL.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.bwL.addView(b);
            }
            i++;
        }
        if (this.bwL.getChildCount() > size) {
            this.bwL.removeViews(size, this.bwL.getChildCount() - size);
        }
        return this.bwL;
    }

    private List<List<a>> Uy() {
        if (this.bwK == null || this.bwK.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bwK.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bwK[i])) {
                arrayList2.add(new a(i, i + 1, this.bwK[i]));
            }
            if (i + 1 < this.bwK.length && !StringUtils.isNull(this.bwK[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bwK[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Uz() {
        if (this.bwJ == null || this.bwJ.size() == 0) {
            return Uy();
        }
        int size = this.bwJ.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bwJ.keyAt(i), this.bwJ.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bwJ.keyAt(i2), this.bwJ.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void dk(boolean z) {
        this.bwP = z;
    }
}
