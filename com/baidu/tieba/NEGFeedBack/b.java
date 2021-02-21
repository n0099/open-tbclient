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
    private String[] gdA;
    private LinearLayout gdB;
    private CompoundButton.OnCheckedChangeListener gdC;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> gdE;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean gdx = false;
    private SparseArray<String> gdy = null;
    private SparseArray<String> gdz = null;
    private boolean gdF = false;
    private boolean gdG = true;
    private int gdH = -1;
    private CompoundButton.OnCheckedChangeListener gdD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            if (compoundButton != null && b.this.gdE != null && !b.this.gdE.isEmpty()) {
                if (z && b.this.gdF) {
                    for (Map.Entry entry : b.this.gdE.entrySet()) {
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
                if (b.this.gdF && !z && !b.this.gdG) {
                    Iterator it = b.this.gdE.entrySet().iterator();
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
                        for (Map.Entry entry3 : b.this.gdE.entrySet()) {
                            if (entry3 != null && entry3.getKey() == compoundButton) {
                                ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                                entry3.setValue(true);
                                return;
                            }
                        }
                    }
                }
                if (b.this.gdC != null) {
                    b.this.gdC.onCheckedChanged(compoundButton, z);
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
            this.gdy = avVar.getFeedBackReasonMap();
            this.gdz = avVar.eOo;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdA = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gdx = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.gdC = onCheckedChangeListener;
    }

    public View getView() {
        if (this.gdB == null) {
            this.gdB = new LinearLayout(this.mPageContext.getPageActivity());
            this.gdB.setOrientation(1);
        }
        List<List<a>> bKm = bKm();
        if (y.isEmpty(bKm)) {
            return null;
        }
        int size = bKm.size();
        if (this.gdE == null) {
            this.gdE = new HashMap<>();
        } else {
            this.gdE.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bKm.get(i), i == size + (-1), this.gdB.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.gdB.addView(a2);
            }
            i++;
        }
        if (this.gdB.getChildCount() > size) {
            this.gdB.removeViews(size, this.gdB.getChildCount() - size);
        }
        return this.gdB;
    }

    private List<List<a>> bKm() {
        int i;
        int i2;
        int i3 = -1;
        if (this.gdy == null || this.gdy.size() == 0) {
            return bKn();
        }
        int size = this.gdy.size();
        int i4 = this.gdx ? 0 : -1;
        int i5 = this.gdx ? size - 1 : size;
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
            a aVar = new a(i6, this.gdy.keyAt(i6), this.gdy.valueAt(i6));
            if (this.gdz != null && !StringUtils.isNull(this.gdz.get(this.gdy.keyAt(i6)))) {
                aVar.extra = this.gdz.get(this.gdy.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.gdy.keyAt(i), this.gdy.valueAt(i));
                if (this.gdz != null && !StringUtils.isNull(this.gdz.get(this.gdy.keyAt(i6)))) {
                    aVar2.extra = this.gdz.get(this.gdy.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bKn() {
        if (this.gdA == null || this.gdA.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gdA.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gdA[i])) {
                arrayList2.add(new a(i, 0, this.gdA[i]));
            }
            if (i + 1 < this.gdA.length && !StringUtils.isNull(this.gdA[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.gdA[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gdB, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bup();
        nEGFeedBackReasonCheckBox2.bup();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gdE.put(nEGFeedBackReasonCheckBox, false);
        this.gdE.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gdD);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gdD);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.gdB, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bup();
        nEGFeedBackReasonCheckBox2.bup();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.gdE.put(nEGFeedBackReasonCheckBox, false);
        this.gdE.put(nEGFeedBackReasonCheckBox2, false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
            if (aVar.index == this.gdH) {
                nEGFeedBackReasonCheckBox.setEnabled(false);
            }
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
            if (aVar2.index == this.gdH) {
                nEGFeedBackReasonCheckBox2.setEnabled(false);
            }
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(4);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.gdD);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.gdD);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.gdB == null) {
            this.gdB = new LinearLayout(this.mPageContext.getPageActivity());
            this.gdB.setOrientation(1);
        }
        List<List<a>> bKp = bKp();
        if (y.isEmpty(bKp)) {
            return null;
        }
        int size = bKp.size();
        if (this.gdE == null) {
            this.gdE = new HashMap<>();
        } else {
            this.gdE.clear();
        }
        int i = 0;
        while (i < size) {
            View b2 = b(bKp.get(i), i == size + (-1), this.gdB.getChildAt(i));
            if (b2 != null && b2.getParent() == null) {
                this.gdB.addView(b2);
            }
            i++;
        }
        if (this.gdB.getChildCount() > size) {
            this.gdB.removeViews(size, this.gdB.getChildCount() - size);
        }
        return this.gdB;
    }

    private List<List<a>> bKo() {
        if (this.gdA == null || this.gdA.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gdA.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.gdA[i])) {
                arrayList2.add(new a(i, i + 1, this.gdA[i]));
            }
            if (i + 1 < this.gdA.length && !StringUtils.isNull(this.gdA[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.gdA[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bKp() {
        if (this.gdy == null || this.gdy.size() == 0) {
            return bKo();
        }
        int size = this.gdy.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.gdy.keyAt(i), this.gdy.valueAt(i));
            if (this.gdz != null && !StringUtils.isNull(this.gdz.get(this.gdy.keyAt(i)))) {
                aVar.extra = this.gdz.get(this.gdy.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.gdy.keyAt(i2), this.gdy.valueAt(i2));
                if (this.gdz != null && !StringUtils.isNull(this.gdz.get(this.gdy.keyAt(i)))) {
                    aVar2.extra = this.gdz.get(this.gdy.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void lW(boolean z) {
        this.gdF = z;
    }

    public void lX(boolean z) {
        this.gdG = z;
    }

    public void sS(int i) {
        this.gdH = i;
    }
}
