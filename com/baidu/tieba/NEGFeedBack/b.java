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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private String[] dUm;
    private LinearLayout dUn;
    private CompoundButton.OnCheckedChangeListener dUo;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> dUq;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean dUk = false;
    private SparseArray<String> dUl = null;
    private boolean dUr = false;
    private CompoundButton.OnCheckedChangeListener dUp = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.dUq != null && !b.this.dUq.isEmpty()) {
                if (z && b.this.dUr) {
                    for (Map.Entry entry : b.this.dUq.entrySet()) {
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
                if (b.this.dUo != null) {
                    b.this.dUo.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dUl = alVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUm = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dUk = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.dUo = onCheckedChangeListener;
    }

    public View getView() {
        if (this.dUn == null) {
            this.dUn = new LinearLayout(this.mPageContext.getPageActivity());
            this.dUn.setOrientation(1);
        }
        List<List<a>> aWk = aWk();
        if (v.isEmpty(aWk)) {
            return null;
        }
        int size = aWk.size();
        if (this.dUq == null) {
            this.dUq = new HashMap<>();
        } else {
            this.dUq.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(aWk.get(i), i == size + (-1), this.dUn.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.dUn.addView(a2);
            }
            i++;
        }
        if (this.dUn.getChildCount() > size) {
            this.dUn.removeViews(size, this.dUn.getChildCount() - size);
        }
        return this.dUn;
    }

    private List<List<a>> aWk() {
        int i;
        int i2;
        int i3 = -1;
        if (this.dUl == null || this.dUl.size() == 0) {
            return aWl();
        }
        int size = this.dUl.size();
        int i4 = this.dUk ? 0 : -1;
        int i5 = this.dUk ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.dUl.keyAt(i6), this.dUl.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.dUl.keyAt(i), this.dUl.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> aWl() {
        if (this.dUm == null || this.dUm.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dUm.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dUm[i])) {
                arrayList2.add(new a(i, 0, this.dUm[i]));
            }
            if (i + 1 < this.dUm.length && !StringUtils.isNull(this.dUm[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.dUm[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dUn, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aHO();
        nEGFeedBackReasonCheckBox2.aHO();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dUq.put(nEGFeedBackReasonCheckBox, false);
        this.dUq.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dUp);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dUp);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes8.dex */
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
        if (v.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dUn, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aHO();
        nEGFeedBackReasonCheckBox2.aHO();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dUq.put(nEGFeedBackReasonCheckBox, false);
        this.dUq.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dUp);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dUp);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.dUn == null) {
            this.dUn = new LinearLayout(this.mPageContext.getPageActivity());
            this.dUn.setOrientation(1);
        }
        List<List<a>> aWn = aWn();
        if (v.isEmpty(aWn)) {
            return null;
        }
        int size = aWn.size();
        if (this.dUq == null) {
            this.dUq = new HashMap<>();
        } else {
            this.dUq.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(aWn.get(i), i == size + (-1), this.dUn.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.dUn.addView(b);
            }
            i++;
        }
        if (this.dUn.getChildCount() > size) {
            this.dUn.removeViews(size, this.dUn.getChildCount() - size);
        }
        return this.dUn;
    }

    private List<List<a>> aWm() {
        if (this.dUm == null || this.dUm.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dUm.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dUm[i])) {
                arrayList2.add(new a(i, i + 1, this.dUm[i]));
            }
            if (i + 1 < this.dUm.length && !StringUtils.isNull(this.dUm[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.dUm[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> aWn() {
        if (this.dUl == null || this.dUl.size() == 0) {
            return aWm();
        }
        int size = this.dUl.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.dUl.keyAt(i), this.dUl.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.dUl.keyAt(i2), this.dUl.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void hw(boolean z) {
        this.dUr = z;
    }
}
