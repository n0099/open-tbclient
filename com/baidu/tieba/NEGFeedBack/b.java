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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private String[] gfe;
    private LinearLayout gff;
    private CompoundButton.OnCheckedChangeListener gfg;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> gfi;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean gfb = false;
    private SparseArray<String> gfc = null;
    private SparseArray<String> gfd = null;
    private boolean gfj = false;
    private boolean gfk = true;
    private int gfl = -1;
    private CompoundButton.OnCheckedChangeListener gfh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            if (compoundButton != null && b.this.gfi != null && !b.this.gfi.isEmpty()) {
                if (z && b.this.gfj) {
                    for (Map.Entry entry : b.this.gfi.entrySet()) {
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
                if (b.this.gfj && !z && !b.this.gfk) {
                    Iterator it = b.this.gfi.entrySet().iterator();
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
                        for (Map.Entry entry3 : b.this.gfi.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(true);
                                return;
                            }
                        }
                    }
                }
                if (b.this.gfg != null) {
                    b.this.gfg.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.M_H_X003);
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gfc = avVar.getFeedBackReasonMap();
            this.gfd = avVar.ePP;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gfe = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gfb = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.gfg = onCheckedChangeListener;
    }

    public View getView() {
        if (this.gff == null) {
            this.gff = new LinearLayout(this.mPageContext.getPageActivity());
            this.gff.setOrientation(1);
        }
        List<List<a>> bKq = bKq();
        if (y.isEmpty(bKq)) {
            return null;
        }
        int size = bKq.size();
        if (this.gfi == null) {
            this.gfi = new HashMap<>();
        } else {
            this.gfi.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bKq.get(i), i == size + (-1), this.gff.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.gff.addView(a2);
            }
            i++;
        }
        if (this.gff.getChildCount() > size) {
            this.gff.removeViews(size, this.gff.getChildCount() - size);
        }
        return this.gff;
    }

    private List<List<a>> bKq() {
        int i;
        int i2;
        int i3 = -1;
        if (this.gfc == null || this.gfc.size() == 0) {
            return bKr();
        }
        int size = this.gfc.size();
        int i4 = this.gfb ? 0 : -1;
        int i5 = this.gfb ? size - 1 : size;
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
            a aVar = new a(i6, this.gfc.keyAt(i6), this.gfc.valueAt(i6));
            if (this.gfd != null && !StringUtils.isNull(this.gfd.get(this.gfc.keyAt(i6)))) {
                aVar.extra = this.gfd.get(this.gfc.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.gfc.keyAt(i), this.gfc.valueAt(i));
                if (this.gfd != null && !StringUtils.isNull(this.gfd.get(this.gfc.keyAt(i6)))) {
                    aVar2.extra = this.gfd.get(this.gfc.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bKr() {
        if (this.gfe == null || this.gfe.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gfe.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gfe[i])) {
                arrayList2.add(new a(i, 0, this.gfe[i]));
            }
            if (i + 1 < this.gfe.length && !StringUtils.isNull(this.gfe[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.gfe[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gff, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bus();
        nEGFeedBackReasonCheckBox2.bus();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gfi.put(nEGFeedBackReasonCheckBox, false);
        this.gfi.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gfh);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gfh);
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
        if (y.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gff, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bus();
        nEGFeedBackReasonCheckBox2.bus();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gfi.put(nEGFeedBackReasonCheckBox, false);
        this.gfi.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
            if (aVar.index == this.gfl) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
            if (aVar2.index == this.gfl) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gfh);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gfh);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.gff == null) {
            this.gff = new LinearLayout(this.mPageContext.getPageActivity());
            this.gff.setOrientation(1);
        }
        List<List<a>> bKt = bKt();
        if (y.isEmpty(bKt)) {
            return null;
        }
        int size = bKt.size();
        if (this.gfi == null) {
            this.gfi = new HashMap<>();
        } else {
            this.gfi.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bKt.get(i), i == size + (-1), this.gff.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.gff.addView(b);
            }
            i++;
        }
        if (this.gff.getChildCount() > size) {
            this.gff.removeViews(size, this.gff.getChildCount() - size);
        }
        return this.gff;
    }

    private List<List<a>> bKs() {
        if (this.gfe == null || this.gfe.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gfe.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gfe[i])) {
                arrayList2.add(new a(i, i + 1, this.gfe[i]));
            }
            if (i + 1 < this.gfe.length && !StringUtils.isNull(this.gfe[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.gfe[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bKt() {
        if (this.gfc == null || this.gfc.size() == 0) {
            return bKs();
        }
        int size = this.gfc.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.gfc.keyAt(i), this.gfc.valueAt(i));
            if (this.gfd != null && !StringUtils.isNull(this.gfd.get(this.gfc.keyAt(i)))) {
                aVar.extra = this.gfd.get(this.gfc.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.gfc.keyAt(i2), this.gfc.valueAt(i2));
                if (this.gfd != null && !StringUtils.isNull(this.gfd.get(this.gfc.keyAt(i)))) {
                    aVar2.extra = this.gfd.get(this.gfc.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lW(boolean z) {
        this.gfj = z;
    }

    public void lX(boolean z) {
        this.gfk = z;
    }

    public void sU(int i) {
        this.gfl = i;
    }
}
