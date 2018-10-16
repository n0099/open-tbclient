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
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> bsA;
    private String[] bsw;
    private LinearLayout bsx;
    private CompoundButton.OnCheckedChangeListener bsy;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean bsu = false;
    private SparseArray<String> bsv = null;
    private boolean bsB = false;
    private CompoundButton.OnCheckedChangeListener bsz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.bsA != null && !b.this.bsA.isEmpty()) {
                if (z && b.this.bsB) {
                    for (Map.Entry entry : b.this.bsA.entrySet()) {
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
                if (b.this.bsy != null) {
                    b.this.bsy.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bsv = ahVar.xt();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bsw = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bsu = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bsy = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bsx == null) {
            this.bsx = new LinearLayout(this.mPageContext.getPageActivity());
            this.bsx.setOrientation(1);
        }
        List<List<a>> Tf = Tf();
        if (v.J(Tf)) {
            return null;
        }
        int size = Tf.size();
        if (this.bsA == null) {
            this.bsA = new HashMap<>();
        } else {
            this.bsA.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(Tf.get(i), i == size + (-1), this.bsx.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bsx.addView(a2);
            }
            i++;
        }
        if (this.bsx.getChildCount() > size) {
            this.bsx.removeViews(size, this.bsx.getChildCount() - size);
        }
        return this.bsx;
    }

    private List<List<a>> Tf() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bsv == null || this.bsv.size() == 0) {
            return Tg();
        }
        int size = this.bsv.size();
        int i4 = this.bsu ? 0 : -1;
        int i5 = this.bsu ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bsv.keyAt(i6), this.bsv.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bsv.keyAt(i), this.bsv.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Tg() {
        if (this.bsw == null || this.bsw.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bsw.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bsw[i])) {
                arrayList2.add(new a(i, 0, this.bsw[i]));
            }
            if (i + 1 < this.bsw.length && !StringUtils.isNull(this.bsw[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bsw[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.J(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bsx, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.DV();
        nEGFeedBackReasonCheckBox2.DV();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bsA.put(nEGFeedBackReasonCheckBox, false);
        this.bsA.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bsz);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bsz);
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
        if (v.J(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bsx, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.DV();
        nEGFeedBackReasonCheckBox2.DV();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.bsA.put(nEGFeedBackReasonCheckBox, false);
        this.bsA.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bsz);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bsz);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.bsx == null) {
            this.bsx = new LinearLayout(this.mPageContext.getPageActivity());
            this.bsx.setOrientation(1);
        }
        List<List<a>> Ti = Ti();
        if (v.J(Ti)) {
            return null;
        }
        int size = Ti.size();
        if (this.bsA == null) {
            this.bsA = new HashMap<>();
        } else {
            this.bsA.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Ti.get(i), i == size + (-1), this.bsx.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.bsx.addView(b);
            }
            i++;
        }
        if (this.bsx.getChildCount() > size) {
            this.bsx.removeViews(size, this.bsx.getChildCount() - size);
        }
        return this.bsx;
    }

    private List<List<a>> Th() {
        if (this.bsw == null || this.bsw.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bsw.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bsw[i])) {
                arrayList2.add(new a(i, i + 1, this.bsw[i]));
            }
            if (i + 1 < this.bsw.length && !StringUtils.isNull(this.bsw[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bsw[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Ti() {
        if (this.bsv == null || this.bsv.size() == 0) {
            return Th();
        }
        int size = this.bsv.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bsv.keyAt(i), this.bsv.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bsv.keyAt(i2), this.bsv.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void cS(boolean z) {
        this.bsB = z;
    }
}
