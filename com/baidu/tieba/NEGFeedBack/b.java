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
    private String[] dUC;
    private LinearLayout dUD;
    private CompoundButton.OnCheckedChangeListener dUE;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> dUG;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean dUA = false;
    private SparseArray<String> dUB = null;
    private boolean dUH = false;
    private CompoundButton.OnCheckedChangeListener dUF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.dUG != null && !b.this.dUG.isEmpty()) {
                if (z && b.this.dUH) {
                    for (Map.Entry entry : b.this.dUG.entrySet()) {
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
                if (b.this.dUE != null) {
                    b.this.dUE.onCheckedChanged(compoundButton, z);
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
            this.dUB = alVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUC = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dUA = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.dUE = onCheckedChangeListener;
    }

    public View getView() {
        if (this.dUD == null) {
            this.dUD = new LinearLayout(this.mPageContext.getPageActivity());
            this.dUD.setOrientation(1);
        }
        List<List<a>> aWo = aWo();
        if (v.isEmpty(aWo)) {
            return null;
        }
        int size = aWo.size();
        if (this.dUG == null) {
            this.dUG = new HashMap<>();
        } else {
            this.dUG.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(aWo.get(i), i == size + (-1), this.dUD.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.dUD.addView(a2);
            }
            i++;
        }
        if (this.dUD.getChildCount() > size) {
            this.dUD.removeViews(size, this.dUD.getChildCount() - size);
        }
        return this.dUD;
    }

    private List<List<a>> aWo() {
        int i;
        int i2;
        int i3 = -1;
        if (this.dUB == null || this.dUB.size() == 0) {
            return aWp();
        }
        int size = this.dUB.size();
        int i4 = this.dUA ? 0 : -1;
        int i5 = this.dUA ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.dUB.keyAt(i6), this.dUB.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.dUB.keyAt(i), this.dUB.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> aWp() {
        if (this.dUC == null || this.dUC.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dUC.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dUC[i])) {
                arrayList2.add(new a(i, 0, this.dUC[i]));
            }
            if (i + 1 < this.dUC.length && !StringUtils.isNull(this.dUC[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.dUC[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dUD, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aHS();
        nEGFeedBackReasonCheckBox2.aHS();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dUG.put(nEGFeedBackReasonCheckBox, false);
        this.dUG.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dUF);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dUF);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dUD, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aHS();
        nEGFeedBackReasonCheckBox2.aHS();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dUG.put(nEGFeedBackReasonCheckBox, false);
        this.dUG.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dUF);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dUF);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.dUD == null) {
            this.dUD = new LinearLayout(this.mPageContext.getPageActivity());
            this.dUD.setOrientation(1);
        }
        List<List<a>> aWr = aWr();
        if (v.isEmpty(aWr)) {
            return null;
        }
        int size = aWr.size();
        if (this.dUG == null) {
            this.dUG = new HashMap<>();
        } else {
            this.dUG.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(aWr.get(i), i == size + (-1), this.dUD.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.dUD.addView(b);
            }
            i++;
        }
        if (this.dUD.getChildCount() > size) {
            this.dUD.removeViews(size, this.dUD.getChildCount() - size);
        }
        return this.dUD;
    }

    private List<List<a>> aWq() {
        if (this.dUC == null || this.dUC.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dUC.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dUC[i])) {
                arrayList2.add(new a(i, i + 1, this.dUC[i]));
            }
            if (i + 1 < this.dUC.length && !StringUtils.isNull(this.dUC[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.dUC[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> aWr() {
        if (this.dUB == null || this.dUB.size() == 0) {
            return aWq();
        }
        int size = this.dUB.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.dUB.keyAt(i), this.dUB.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.dUB.keyAt(i2), this.dUB.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void hx(boolean z) {
        this.dUH = z;
    }
}
