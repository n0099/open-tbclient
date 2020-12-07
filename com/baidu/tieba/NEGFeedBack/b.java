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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class b {
    private String[] fWh;
    private LinearLayout fWi;
    private CompoundButton.OnCheckedChangeListener fWj;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> fWl;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean fWe = false;
    private SparseArray<String> fWf = null;
    private SparseArray<String> fWg = null;
    private boolean fWm = false;
    private boolean fWn = true;
    private int fWo = -1;
    private CompoundButton.OnCheckedChangeListener fWk = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            if (compoundButton != null && b.this.fWl != null && !b.this.fWl.isEmpty()) {
                if (z && b.this.fWm) {
                    for (Map.Entry entry : b.this.fWl.entrySet()) {
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
                if (b.this.fWm && !z && !b.this.fWn) {
                    Iterator it = b.this.fWl.entrySet().iterator();
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
                        for (Map.Entry entry3 : b.this.fWl.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(true);
                                return;
                            }
                        }
                    }
                }
                if (b.this.fWj != null) {
                    b.this.fWj.onCheckedChanged(compoundButton, z);
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
            this.fWf = atVar.getFeedBackReasonMap();
            this.fWg = atVar.eGW;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWh = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fWe = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.fWj = onCheckedChangeListener;
    }

    public View getView() {
        if (this.fWi == null) {
            this.fWi = new LinearLayout(this.mPageContext.getPageActivity());
            this.fWi.setOrientation(1);
        }
        List<List<a>> bLl = bLl();
        if (y.isEmpty(bLl)) {
            return null;
        }
        int size = bLl.size();
        if (this.fWl == null) {
            this.fWl = new HashMap<>();
        } else {
            this.fWl.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bLl.get(i), i == size + (-1), this.fWi.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.fWi.addView(a2);
            }
            i++;
        }
        if (this.fWi.getChildCount() > size) {
            this.fWi.removeViews(size, this.fWi.getChildCount() - size);
        }
        return this.fWi;
    }

    private List<List<a>> bLl() {
        int i;
        int i2;
        int i3 = -1;
        if (this.fWf == null || this.fWf.size() == 0) {
            return bLm();
        }
        int size = this.fWf.size();
        int i4 = this.fWe ? 0 : -1;
        int i5 = this.fWe ? size - 1 : size;
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
            a aVar = new a(i6, this.fWf.keyAt(i6), this.fWf.valueAt(i6));
            if (this.fWg != null && !StringUtils.isNull(this.fWg.get(this.fWf.keyAt(i6)))) {
                aVar.extra = this.fWg.get(this.fWf.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.fWf.keyAt(i), this.fWf.valueAt(i));
                if (this.fWg != null && !StringUtils.isNull(this.fWg.get(this.fWf.keyAt(i6)))) {
                    aVar2.extra = this.fWg.get(this.fWf.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bLm() {
        if (this.fWh == null || this.fWh.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fWh.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fWh[i])) {
                arrayList2.add(new a(i, 0, this.fWh[i]));
            }
            if (i + 1 < this.fWh.length && !StringUtils.isNull(this.fWh[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.fWh[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (y.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fWi, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bvt();
        nEGFeedBackReasonCheckBox2.bvt();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fWl.put(nEGFeedBackReasonCheckBox, false);
        this.fWl.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fWk);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fWk);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes21.dex */
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
        if (y.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fWi, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bvt();
        nEGFeedBackReasonCheckBox2.bvt();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fWl.put(nEGFeedBackReasonCheckBox, false);
        this.fWl.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
            if (aVar.index == this.fWo) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
            if (aVar2.index == this.fWo) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fWk);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fWk);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.fWi == null) {
            this.fWi = new LinearLayout(this.mPageContext.getPageActivity());
            this.fWi.setOrientation(1);
        }
        List<List<a>> bLo = bLo();
        if (y.isEmpty(bLo)) {
            return null;
        }
        int size = bLo.size();
        if (this.fWl == null) {
            this.fWl = new HashMap<>();
        } else {
            this.fWl.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bLo.get(i), i == size + (-1), this.fWi.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.fWi.addView(b);
            }
            i++;
        }
        if (this.fWi.getChildCount() > size) {
            this.fWi.removeViews(size, this.fWi.getChildCount() - size);
        }
        return this.fWi;
    }

    private List<List<a>> bLn() {
        if (this.fWh == null || this.fWh.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fWh.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fWh[i])) {
                arrayList2.add(new a(i, i + 1, this.fWh[i]));
            }
            if (i + 1 < this.fWh.length && !StringUtils.isNull(this.fWh[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.fWh[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bLo() {
        if (this.fWf == null || this.fWf.size() == 0) {
            return bLn();
        }
        int size = this.fWf.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.fWf.keyAt(i), this.fWf.valueAt(i));
            if (this.fWg != null && !StringUtils.isNull(this.fWg.get(this.fWf.keyAt(i)))) {
                aVar.extra = this.fWg.get(this.fWf.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.fWf.keyAt(i2), this.fWf.valueAt(i2));
                if (this.fWg != null && !StringUtils.isNull(this.fWg.get(this.fWf.keyAt(i)))) {
                    aVar2.extra = this.fWg.get(this.fWf.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lz(boolean z) {
        this.fWm = z;
    }

    public void lA(boolean z) {
        this.fWn = z;
    }

    public void uh(int i) {
        this.fWo = i;
    }
}
