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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private String[] eJj;
    private LinearLayout eJk;
    private CompoundButton.OnCheckedChangeListener eJl;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> eJn;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean eJh = false;
    private SparseArray<String> eJi = null;
    private boolean eJo = false;
    private CompoundButton.OnCheckedChangeListener eJm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.eJn != null && !b.this.eJn.isEmpty()) {
                if (z && b.this.eJo) {
                    for (Map.Entry entry : b.this.eJn.entrySet()) {
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
                if (b.this.eJl != null) {
                    b.this.eJl.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(ak akVar) {
        if (akVar != null) {
            this.eJi = akVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eJj = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.eJh = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.eJl = onCheckedChangeListener;
    }

    public View getView() {
        if (this.eJk == null) {
            this.eJk = new LinearLayout(this.mPageContext.getPageActivity());
            this.eJk.setOrientation(1);
        }
        List<List<a>> bkK = bkK();
        if (v.isEmpty(bkK)) {
            return null;
        }
        int size = bkK.size();
        if (this.eJn == null) {
            this.eJn = new HashMap<>();
        } else {
            this.eJn.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bkK.get(i), i == size + (-1), this.eJk.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.eJk.addView(a2);
            }
            i++;
        }
        if (this.eJk.getChildCount() > size) {
            this.eJk.removeViews(size, this.eJk.getChildCount() - size);
        }
        return this.eJk;
    }

    private List<List<a>> bkK() {
        int i;
        int i2;
        int i3 = -1;
        if (this.eJi == null || this.eJi.size() == 0) {
            return bkL();
        }
        int size = this.eJi.size();
        int i4 = this.eJh ? 0 : -1;
        int i5 = this.eJh ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.eJi.keyAt(i6), this.eJi.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.eJi.keyAt(i), this.eJi.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bkL() {
        if (this.eJj == null || this.eJj.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.eJj.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.eJj[i])) {
                arrayList2.add(new a(i, 0, this.eJj[i]));
            }
            if (i + 1 < this.eJj.length && !StringUtils.isNull(this.eJj[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.eJj[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.eJk, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aWq();
        nEGFeedBackReasonCheckBox2.aWq();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.eJn.put(nEGFeedBackReasonCheckBox, false);
        this.eJn.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.eJm);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.eJm);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.eJk, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aWq();
        nEGFeedBackReasonCheckBox2.aWq();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.eJn.put(nEGFeedBackReasonCheckBox, false);
        this.eJn.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.eJm);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.eJm);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.eJk == null) {
            this.eJk = new LinearLayout(this.mPageContext.getPageActivity());
            this.eJk.setOrientation(1);
        }
        List<List<a>> bkN = bkN();
        if (v.isEmpty(bkN)) {
            return null;
        }
        int size = bkN.size();
        if (this.eJn == null) {
            this.eJn = new HashMap<>();
        } else {
            this.eJn.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bkN.get(i), i == size + (-1), this.eJk.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.eJk.addView(b);
            }
            i++;
        }
        if (this.eJk.getChildCount() > size) {
            this.eJk.removeViews(size, this.eJk.getChildCount() - size);
        }
        return this.eJk;
    }

    private List<List<a>> bkM() {
        if (this.eJj == null || this.eJj.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.eJj.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.eJj[i])) {
                arrayList2.add(new a(i, i + 1, this.eJj[i]));
            }
            if (i + 1 < this.eJj.length && !StringUtils.isNull(this.eJj[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.eJj[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bkN() {
        if (this.eJi == null || this.eJi.size() == 0) {
            return bkM();
        }
        int size = this.eJi.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.eJi.keyAt(i), this.eJi.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.eJi.keyAt(i2), this.eJi.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void iS(boolean z) {
        this.eJo = z;
    }
}
