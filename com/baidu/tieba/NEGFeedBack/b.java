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
    private String[] fWj;
    private LinearLayout fWk;
    private CompoundButton.OnCheckedChangeListener fWl;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> fWn;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean fWg = false;
    private SparseArray<String> fWh = null;
    private SparseArray<String> fWi = null;
    private boolean fWo = false;
    private boolean fWp = true;
    private int fWq = -1;
    private CompoundButton.OnCheckedChangeListener fWm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            if (compoundButton != null && b.this.fWn != null && !b.this.fWn.isEmpty()) {
                if (z && b.this.fWo) {
                    for (Map.Entry entry : b.this.fWn.entrySet()) {
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
                if (b.this.fWo && !z && !b.this.fWp) {
                    Iterator it = b.this.fWn.entrySet().iterator();
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
                        for (Map.Entry entry3 : b.this.fWn.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(true);
                                return;
                            }
                        }
                    }
                }
                if (b.this.fWl != null) {
                    b.this.fWl.onCheckedChanged(compoundButton, z);
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
            this.fWh = atVar.getFeedBackReasonMap();
            this.fWi = atVar.eGW;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWj = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fWg = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.fWl = onCheckedChangeListener;
    }

    public View getView() {
        if (this.fWk == null) {
            this.fWk = new LinearLayout(this.mPageContext.getPageActivity());
            this.fWk.setOrientation(1);
        }
        List<List<a>> bLm = bLm();
        if (y.isEmpty(bLm)) {
            return null;
        }
        int size = bLm.size();
        if (this.fWn == null) {
            this.fWn = new HashMap<>();
        } else {
            this.fWn.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bLm.get(i), i == size + (-1), this.fWk.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.fWk.addView(a2);
            }
            i++;
        }
        if (this.fWk.getChildCount() > size) {
            this.fWk.removeViews(size, this.fWk.getChildCount() - size);
        }
        return this.fWk;
    }

    private List<List<a>> bLm() {
        int i;
        int i2;
        int i3 = -1;
        if (this.fWh == null || this.fWh.size() == 0) {
            return bLn();
        }
        int size = this.fWh.size();
        int i4 = this.fWg ? 0 : -1;
        int i5 = this.fWg ? size - 1 : size;
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
            a aVar = new a(i6, this.fWh.keyAt(i6), this.fWh.valueAt(i6));
            if (this.fWi != null && !StringUtils.isNull(this.fWi.get(this.fWh.keyAt(i6)))) {
                aVar.extra = this.fWi.get(this.fWh.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.fWh.keyAt(i), this.fWh.valueAt(i));
                if (this.fWi != null && !StringUtils.isNull(this.fWi.get(this.fWh.keyAt(i6)))) {
                    aVar2.extra = this.fWi.get(this.fWh.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bLn() {
        if (this.fWj == null || this.fWj.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fWj.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fWj[i])) {
                arrayList2.add(new a(i, 0, this.fWj[i]));
            }
            if (i + 1 < this.fWj.length && !StringUtils.isNull(this.fWj[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.fWj[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fWk, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bvt();
        nEGFeedBackReasonCheckBox2.bvt();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fWn.put(nEGFeedBackReasonCheckBox, false);
        this.fWn.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fWm);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fWm);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fWk, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bvt();
        nEGFeedBackReasonCheckBox2.bvt();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fWn.put(nEGFeedBackReasonCheckBox, false);
        this.fWn.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
            if (aVar.index == this.fWq) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
            if (aVar2.index == this.fWq) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fWm);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fWm);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.fWk == null) {
            this.fWk = new LinearLayout(this.mPageContext.getPageActivity());
            this.fWk.setOrientation(1);
        }
        List<List<a>> bLp = bLp();
        if (y.isEmpty(bLp)) {
            return null;
        }
        int size = bLp.size();
        if (this.fWn == null) {
            this.fWn = new HashMap<>();
        } else {
            this.fWn.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bLp.get(i), i == size + (-1), this.fWk.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.fWk.addView(b);
            }
            i++;
        }
        if (this.fWk.getChildCount() > size) {
            this.fWk.removeViews(size, this.fWk.getChildCount() - size);
        }
        return this.fWk;
    }

    private List<List<a>> bLo() {
        if (this.fWj == null || this.fWj.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fWj.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fWj[i])) {
                arrayList2.add(new a(i, i + 1, this.fWj[i]));
            }
            if (i + 1 < this.fWj.length && !StringUtils.isNull(this.fWj[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.fWj[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bLp() {
        if (this.fWh == null || this.fWh.size() == 0) {
            return bLo();
        }
        int size = this.fWh.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.fWh.keyAt(i), this.fWh.valueAt(i));
            if (this.fWi != null && !StringUtils.isNull(this.fWi.get(this.fWh.keyAt(i)))) {
                aVar.extra = this.fWi.get(this.fWh.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.fWh.keyAt(i2), this.fWh.valueAt(i2));
                if (this.fWi != null && !StringUtils.isNull(this.fWi.get(this.fWh.keyAt(i)))) {
                    aVar2.extra = this.fWi.get(this.fWh.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lz(boolean z) {
        this.fWo = z;
    }

    public void lA(boolean z) {
        this.fWp = z;
    }

    public void uh(int i) {
        this.fWq = i;
    }
}
