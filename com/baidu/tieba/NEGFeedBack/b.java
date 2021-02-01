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
    private String[] gdv;
    private LinearLayout gdw;
    private CompoundButton.OnCheckedChangeListener gdx;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> gdz;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean gds = false;
    private SparseArray<String> gdt = null;
    private SparseArray<String> gdu = null;
    private boolean gdA = false;
    private boolean gdB = true;
    private int gdC = -1;
    private CompoundButton.OnCheckedChangeListener gdy = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            if (compoundButton != null && b.this.gdz != null && !b.this.gdz.isEmpty()) {
                if (z && b.this.gdA) {
                    for (Map.Entry entry : b.this.gdz.entrySet()) {
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
                if (b.this.gdA && !z && !b.this.gdB) {
                    Iterator it = b.this.gdz.entrySet().iterator();
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
                        for (Map.Entry entry3 : b.this.gdz.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(true);
                                return;
                            }
                        }
                    }
                }
                if (b.this.gdx != null) {
                    b.this.gdx.onCheckedChanged(compoundButton, z);
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
            this.gdt = avVar.getFeedBackReasonMap();
            this.gdu = avVar.eOo;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdv = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gds = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.gdx = onCheckedChangeListener;
    }

    public View getView() {
        if (this.gdw == null) {
            this.gdw = new LinearLayout(this.mPageContext.getPageActivity());
            this.gdw.setOrientation(1);
        }
        List<List<a>> bKh = bKh();
        if (y.isEmpty(bKh)) {
            return null;
        }
        int size = bKh.size();
        if (this.gdz == null) {
            this.gdz = new HashMap<>();
        } else {
            this.gdz.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bKh.get(i), i == size + (-1), this.gdw.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.gdw.addView(a2);
            }
            i++;
        }
        if (this.gdw.getChildCount() > size) {
            this.gdw.removeViews(size, this.gdw.getChildCount() - size);
        }
        return this.gdw;
    }

    private List<List<a>> bKh() {
        int i;
        int i2;
        int i3 = -1;
        if (this.gdt == null || this.gdt.size() == 0) {
            return bKi();
        }
        int size = this.gdt.size();
        int i4 = this.gds ? 0 : -1;
        int i5 = this.gds ? size - 1 : size;
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
            a aVar = new a(i6, this.gdt.keyAt(i6), this.gdt.valueAt(i6));
            if (this.gdu != null && !StringUtils.isNull(this.gdu.get(this.gdt.keyAt(i6)))) {
                aVar.extra = this.gdu.get(this.gdt.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.gdt.keyAt(i), this.gdt.valueAt(i));
                if (this.gdu != null && !StringUtils.isNull(this.gdu.get(this.gdt.keyAt(i6)))) {
                    aVar2.extra = this.gdu.get(this.gdt.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bKi() {
        if (this.gdv == null || this.gdv.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gdv.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gdv[i])) {
                arrayList2.add(new a(i, 0, this.gdv[i]));
            }
            if (i + 1 < this.gdv.length && !StringUtils.isNull(this.gdv[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.gdv[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gdw, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bup();
        nEGFeedBackReasonCheckBox2.bup();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gdz.put(nEGFeedBackReasonCheckBox, false);
        this.gdz.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gdy);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gdy);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gdw, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bup();
        nEGFeedBackReasonCheckBox2.bup();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gdz.put(nEGFeedBackReasonCheckBox, false);
        this.gdz.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
            if (aVar.index == this.gdC) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
            if (aVar2.index == this.gdC) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gdy);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gdy);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.gdw == null) {
            this.gdw = new LinearLayout(this.mPageContext.getPageActivity());
            this.gdw.setOrientation(1);
        }
        List<List<a>> bKk = bKk();
        if (y.isEmpty(bKk)) {
            return null;
        }
        int size = bKk.size();
        if (this.gdz == null) {
            this.gdz = new HashMap<>();
        } else {
            this.gdz.clear();
        }
        int i = 0;
        while (i < size) {
            View b2 = b(bKk.get(i), i == size + (-1), this.gdw.getChildAt(i));
            if (b2 != null && b2.getParent() == null) {
                this.gdw.addView(b2);
            }
            i++;
        }
        if (this.gdw.getChildCount() > size) {
            this.gdw.removeViews(size, this.gdw.getChildCount() - size);
        }
        return this.gdw;
    }

    private List<List<a>> bKj() {
        if (this.gdv == null || this.gdv.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gdv.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gdv[i])) {
                arrayList2.add(new a(i, i + 1, this.gdv[i]));
            }
            if (i + 1 < this.gdv.length && !StringUtils.isNull(this.gdv[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.gdv[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bKk() {
        if (this.gdt == null || this.gdt.size() == 0) {
            return bKj();
        }
        int size = this.gdt.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.gdt.keyAt(i), this.gdt.valueAt(i));
            if (this.gdu != null && !StringUtils.isNull(this.gdu.get(this.gdt.keyAt(i)))) {
                aVar.extra = this.gdu.get(this.gdt.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.gdt.keyAt(i2), this.gdt.valueAt(i2));
                if (this.gdu != null && !StringUtils.isNull(this.gdu.get(this.gdt.keyAt(i)))) {
                    aVar2.extra = this.gdu.get(this.gdt.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lW(boolean z) {
        this.gdA = z;
    }

    public void lX(boolean z) {
        this.gdB = z;
    }

    public void sS(int i) {
        this.gdC = i;
    }
}
