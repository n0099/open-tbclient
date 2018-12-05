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
    private String[] bwH;
    private LinearLayout bwI;
    private CompoundButton.OnCheckedChangeListener bwJ;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> bwL;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean bwF = false;
    private SparseArray<String> bwG = null;
    private boolean bwM = false;
    private CompoundButton.OnCheckedChangeListener bwK = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.bwL != null && !b.this.bwL.isEmpty()) {
                if (z && b.this.bwM) {
                    for (Map.Entry entry : b.this.bwL.entrySet()) {
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
                if (b.this.bwJ != null) {
                    b.this.bwJ.onCheckedChanged(compoundButton, z);
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
            this.bwG = ahVar.yF();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bwH = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bwF = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bwJ = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bwI == null) {
            this.bwI = new LinearLayout(this.mPageContext.getPageActivity());
            this.bwI.setOrientation(1);
        }
        List<List<a>> Uu = Uu();
        if (v.I(Uu)) {
            return null;
        }
        int size = Uu.size();
        if (this.bwL == null) {
            this.bwL = new HashMap<>();
        } else {
            this.bwL.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(Uu.get(i), i == size + (-1), this.bwI.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bwI.addView(a2);
            }
            i++;
        }
        if (this.bwI.getChildCount() > size) {
            this.bwI.removeViews(size, this.bwI.getChildCount() - size);
        }
        return this.bwI;
    }

    private List<List<a>> Uu() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bwG == null || this.bwG.size() == 0) {
            return Uv();
        }
        int size = this.bwG.size();
        int i4 = this.bwF ? 0 : -1;
        int i5 = this.bwF ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bwG.keyAt(i6), this.bwG.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bwG.keyAt(i), this.bwG.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Uv() {
        if (this.bwH == null || this.bwH.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bwH.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bwH[i])) {
                arrayList2.add(new a(i, 0, this.bwH[i]));
            }
            if (i + 1 < this.bwH.length && !StringUtils.isNull(this.bwH[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bwH[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bwI, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fj();
        nEGFeedBackReasonCheckBox2.Fj();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bwL.put(nEGFeedBackReasonCheckBox, false);
        this.bwL.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bwK);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bwK);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bwI, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Fj();
        nEGFeedBackReasonCheckBox2.Fj();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bwL.put(nEGFeedBackReasonCheckBox, false);
        this.bwL.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bwK);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bwK);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.bwI == null) {
            this.bwI = new LinearLayout(this.mPageContext.getPageActivity());
            this.bwI.setOrientation(1);
        }
        List<List<a>> Ux = Ux();
        if (v.I(Ux)) {
            return null;
        }
        int size = Ux.size();
        if (this.bwL == null) {
            this.bwL = new HashMap<>();
        } else {
            this.bwL.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Ux.get(i), i == size + (-1), this.bwI.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.bwI.addView(b);
            }
            i++;
        }
        if (this.bwI.getChildCount() > size) {
            this.bwI.removeViews(size, this.bwI.getChildCount() - size);
        }
        return this.bwI;
    }

    private List<List<a>> Uw() {
        if (this.bwH == null || this.bwH.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bwH.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bwH[i])) {
                arrayList2.add(new a(i, i + 1, this.bwH[i]));
            }
            if (i + 1 < this.bwH.length && !StringUtils.isNull(this.bwH[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bwH[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Ux() {
        if (this.bwG == null || this.bwG.size() == 0) {
            return Uw();
        }
        int size = this.bwG.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bwG.keyAt(i), this.bwG.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bwG.keyAt(i2), this.bwG.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void dk(boolean z) {
        this.bwM = z;
    }
}
