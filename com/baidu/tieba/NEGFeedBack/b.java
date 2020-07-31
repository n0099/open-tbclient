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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes15.dex */
public class b {
    private String[] fab;
    private LinearLayout fac;
    private CompoundButton.OnCheckedChangeListener fad;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> faf;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean eZY = false;
    private SparseArray<String> eZZ = null;
    private SparseArray<String> faa = null;
    private boolean fag = false;
    private CompoundButton.OnCheckedChangeListener fae = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.faf != null && !b.this.faf.isEmpty()) {
                if (z && b.this.fag) {
                    for (Map.Entry entry : b.this.faf.entrySet()) {
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
                if (b.this.fad != null) {
                    b.this.fad.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(aq aqVar) {
        if (aqVar != null) {
            this.eZZ = aqVar.getFeedBackReasonMap();
            this.faa = aqVar.dPE;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fab = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.eZY = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.fad = onCheckedChangeListener;
    }

    public View getView() {
        if (this.fac == null) {
            this.fac = new LinearLayout(this.mPageContext.getPageActivity());
            this.fac.setOrientation(1);
        }
        List<List<a>> brh = brh();
        if (x.isEmpty(brh)) {
            return null;
        }
        int size = brh.size();
        if (this.faf == null) {
            this.faf = new HashMap<>();
        } else {
            this.faf.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(brh.get(i), i == size + (-1), this.fac.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.fac.addView(a2);
            }
            i++;
        }
        if (this.fac.getChildCount() > size) {
            this.fac.removeViews(size, this.fac.getChildCount() - size);
        }
        return this.fac;
    }

    private List<List<a>> brh() {
        int i;
        int i2;
        int i3 = -1;
        if (this.eZZ == null || this.eZZ.size() == 0) {
            return bri();
        }
        int size = this.eZZ.size();
        int i4 = this.eZY ? 0 : -1;
        int i5 = this.eZY ? size - 1 : size;
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
            a aVar = new a(i6, this.eZZ.keyAt(i6), this.eZZ.valueAt(i6));
            if (this.faa != null && !StringUtils.isNull(this.faa.get(this.eZZ.keyAt(i6)))) {
                aVar.extra = this.faa.get(this.eZZ.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.eZZ.keyAt(i), this.eZZ.valueAt(i));
                if (this.faa != null && !StringUtils.isNull(this.faa.get(this.eZZ.keyAt(i6)))) {
                    aVar2.extra = this.faa.get(this.eZZ.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bri() {
        if (this.fab == null || this.fab.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fab.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fab[i])) {
                arrayList2.add(new a(i, 0, this.fab[i]));
            }
            if (i + 1 < this.fab.length && !StringUtils.isNull(this.fab[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.fab[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fac, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bci();
        nEGFeedBackReasonCheckBox2.bci();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.faf.put(nEGFeedBackReasonCheckBox, false);
        this.faf.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fae);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fae);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes15.dex */
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fac, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bci();
        nEGFeedBackReasonCheckBox2.bci();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.faf.put(nEGFeedBackReasonCheckBox, false);
        this.faf.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fae);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fae);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.fac == null) {
            this.fac = new LinearLayout(this.mPageContext.getPageActivity());
            this.fac.setOrientation(1);
        }
        List<List<a>> brk = brk();
        if (x.isEmpty(brk)) {
            return null;
        }
        int size = brk.size();
        if (this.faf == null) {
            this.faf = new HashMap<>();
        } else {
            this.faf.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(brk.get(i), i == size + (-1), this.fac.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.fac.addView(b);
            }
            i++;
        }
        if (this.fac.getChildCount() > size) {
            this.fac.removeViews(size, this.fac.getChildCount() - size);
        }
        return this.fac;
    }

    private List<List<a>> brj() {
        if (this.fab == null || this.fab.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fab.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fab[i])) {
                arrayList2.add(new a(i, i + 1, this.fab[i]));
            }
            if (i + 1 < this.fab.length && !StringUtils.isNull(this.fab[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.fab[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> brk() {
        if (this.eZZ == null || this.eZZ.size() == 0) {
            return brj();
        }
        int size = this.eZZ.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.eZZ.keyAt(i), this.eZZ.valueAt(i));
            if (this.faa != null && !StringUtils.isNull(this.faa.get(this.eZZ.keyAt(i)))) {
                aVar.extra = this.faa.get(this.eZZ.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.eZZ.keyAt(i2), this.eZZ.valueAt(i2));
                if (this.faa != null && !StringUtils.isNull(this.faa.get(this.eZZ.keyAt(i)))) {
                    aVar2.extra = this.faa.get(this.eZZ.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void jJ(boolean z) {
        this.fag = z;
    }
}
