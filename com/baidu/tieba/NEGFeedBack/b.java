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
    private String[] gbg;
    private LinearLayout gbh;
    private CompoundButton.OnCheckedChangeListener gbi;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> gbk;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean gbd = false;
    private SparseArray<String> gbe = null;
    private SparseArray<String> gbf = null;
    private boolean gbl = false;
    private boolean gbm = true;
    private int gbn = -1;
    private CompoundButton.OnCheckedChangeListener gbj = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            if (compoundButton != null && b.this.gbk != null && !b.this.gbk.isEmpty()) {
                if (z && b.this.gbl) {
                    for (Map.Entry entry : b.this.gbk.entrySet()) {
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
                if (b.this.gbl && !z && !b.this.gbm) {
                    Iterator it = b.this.gbk.entrySet().iterator();
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
                        for (Map.Entry entry3 : b.this.gbk.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(true);
                                return;
                            }
                        }
                    }
                }
                if (b.this.gbi != null) {
                    b.this.gbi.onCheckedChanged(compoundButton, z);
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
            this.gbe = atVar.getFeedBackReasonMap();
            this.gbf = atVar.eMc;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gbg = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gbd = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.gbi = onCheckedChangeListener;
    }

    public View getView() {
        if (this.gbh == null) {
            this.gbh = new LinearLayout(this.mPageContext.getPageActivity());
            this.gbh.setOrientation(1);
        }
        List<List<a>> bJN = bJN();
        if (x.isEmpty(bJN)) {
            return null;
        }
        int size = bJN.size();
        if (this.gbk == null) {
            this.gbk = new HashMap<>();
        } else {
            this.gbk.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bJN.get(i), i == size + (-1), this.gbh.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.gbh.addView(a2);
            }
            i++;
        }
        if (this.gbh.getChildCount() > size) {
            this.gbh.removeViews(size, this.gbh.getChildCount() - size);
        }
        return this.gbh;
    }

    private List<List<a>> bJN() {
        int i;
        int i2;
        int i3 = -1;
        if (this.gbe == null || this.gbe.size() == 0) {
            return bJO();
        }
        int size = this.gbe.size();
        int i4 = this.gbd ? 0 : -1;
        int i5 = this.gbd ? size - 1 : size;
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
            a aVar = new a(i6, this.gbe.keyAt(i6), this.gbe.valueAt(i6));
            if (this.gbf != null && !StringUtils.isNull(this.gbf.get(this.gbe.keyAt(i6)))) {
                aVar.extra = this.gbf.get(this.gbe.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.gbe.keyAt(i), this.gbe.valueAt(i));
                if (this.gbf != null && !StringUtils.isNull(this.gbf.get(this.gbe.keyAt(i6)))) {
                    aVar2.extra = this.gbf.get(this.gbe.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bJO() {
        if (this.gbg == null || this.gbg.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gbg.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gbg[i])) {
                arrayList2.add(new a(i, 0, this.gbg[i]));
            }
            if (i + 1 < this.gbg.length && !StringUtils.isNull(this.gbg[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.gbg[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gbh, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.btV();
        nEGFeedBackReasonCheckBox2.btV();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gbk.put(nEGFeedBackReasonCheckBox, false);
        this.gbk.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gbj);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gbj);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gbh, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.btV();
        nEGFeedBackReasonCheckBox2.btV();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gbk.put(nEGFeedBackReasonCheckBox, false);
        this.gbk.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
            if (aVar.index == this.gbn) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
            if (aVar2.index == this.gbn) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gbj);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gbj);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.gbh == null) {
            this.gbh = new LinearLayout(this.mPageContext.getPageActivity());
            this.gbh.setOrientation(1);
        }
        List<List<a>> bJQ = bJQ();
        if (x.isEmpty(bJQ)) {
            return null;
        }
        int size = bJQ.size();
        if (this.gbk == null) {
            this.gbk = new HashMap<>();
        } else {
            this.gbk.clear();
        }
        int i = 0;
        while (i < size) {
            View b2 = b(bJQ.get(i), i == size + (-1), this.gbh.getChildAt(i));
            if (b2 != null && b2.getParent() == null) {
                this.gbh.addView(b2);
            }
            i++;
        }
        if (this.gbh.getChildCount() > size) {
            this.gbh.removeViews(size, this.gbh.getChildCount() - size);
        }
        return this.gbh;
    }

    private List<List<a>> bJP() {
        if (this.gbg == null || this.gbg.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gbg.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gbg[i])) {
                arrayList2.add(new a(i, i + 1, this.gbg[i]));
            }
            if (i + 1 < this.gbg.length && !StringUtils.isNull(this.gbg[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.gbg[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bJQ() {
        if (this.gbe == null || this.gbe.size() == 0) {
            return bJP();
        }
        int size = this.gbe.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.gbe.keyAt(i), this.gbe.valueAt(i));
            if (this.gbf != null && !StringUtils.isNull(this.gbf.get(this.gbe.keyAt(i)))) {
                aVar.extra = this.gbf.get(this.gbe.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.gbe.keyAt(i2), this.gbe.valueAt(i2));
                if (this.gbf != null && !StringUtils.isNull(this.gbf.get(this.gbe.keyAt(i)))) {
                    aVar2.extra = this.gbf.get(this.gbe.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lS(boolean z) {
        this.gbl = z;
    }

    public void lT(boolean z) {
        this.gbm = z;
    }

    public void sN(int i) {
        this.gbn = i;
    }
}
