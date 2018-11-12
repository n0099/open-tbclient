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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private String[] bti;
    private LinearLayout btj;
    private CompoundButton.OnCheckedChangeListener btk;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> btm;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean btg = false;
    private SparseArray<String> bth = null;
    private boolean bto = false;
    private CompoundButton.OnCheckedChangeListener btl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.btm != null && !b.this.btm.isEmpty()) {
                if (z && b.this.bto) {
                    for (Map.Entry entry : b.this.btm.entrySet()) {
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
                if (b.this.btk != null) {
                    b.this.btk.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.h(this.mPageContext.getPageActivity(), e.C0200e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bth = ahVar.xB();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bti = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.btg = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.btk = onCheckedChangeListener;
    }

    public View getView() {
        if (this.btj == null) {
            this.btj = new LinearLayout(this.mPageContext.getPageActivity());
            this.btj.setOrientation(1);
        }
        List<List<a>> To = To();
        if (v.I(To)) {
            return null;
        }
        int size = To.size();
        if (this.btm == null) {
            this.btm = new HashMap<>();
        } else {
            this.btm.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(To.get(i), i == size + (-1), this.btj.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.btj.addView(a2);
            }
            i++;
        }
        if (this.btj.getChildCount() > size) {
            this.btj.removeViews(size, this.btj.getChildCount() - size);
        }
        return this.btj;
    }

    private List<List<a>> To() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bth == null || this.bth.size() == 0) {
            return Tp();
        }
        int size = this.bth.size();
        int i4 = this.btg ? 0 : -1;
        int i5 = this.btg ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bth.keyAt(i6), this.bth.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bth.keyAt(i), this.bth.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Tp() {
        if (this.bti == null || this.bti.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bti.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bti[i])) {
                arrayList2.add(new a(i, 0, this.bti[i]));
            }
            if (i + 1 < this.bti.length && !StringUtils.isNull(this.bti[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bti[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.I(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.btj, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Ef();
        nEGFeedBackReasonCheckBox2.Ef();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.btm.put(nEGFeedBackReasonCheckBox, false);
        this.btm.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.btl);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.btl);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes6.dex */
    public class a {
        public int id;
        public int index;
        public String reason;

        public a(int i, int i2, String str) {
            this.id = i2;
            this.reason = str;
            this.index = i;
        }
    }

    private View b(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.I(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.btj, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.Ef();
        nEGFeedBackReasonCheckBox2.Ef();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.btm.put(nEGFeedBackReasonCheckBox, false);
        this.btm.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.btl);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.btl);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.btj == null) {
            this.btj = new LinearLayout(this.mPageContext.getPageActivity());
            this.btj.setOrientation(1);
        }
        List<List<a>> Tr = Tr();
        if (v.I(Tr)) {
            return null;
        }
        int size = Tr.size();
        if (this.btm == null) {
            this.btm = new HashMap<>();
        } else {
            this.btm.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Tr.get(i), i == size + (-1), this.btj.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.btj.addView(b);
            }
            i++;
        }
        if (this.btj.getChildCount() > size) {
            this.btj.removeViews(size, this.btj.getChildCount() - size);
        }
        return this.btj;
    }

    private List<List<a>> Tq() {
        if (this.bti == null || this.bti.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bti.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bti[i])) {
                arrayList2.add(new a(i, i + 1, this.bti[i]));
            }
            if (i + 1 < this.bti.length && !StringUtils.isNull(this.bti[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bti[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Tr() {
        if (this.bth == null || this.bth.size() == 0) {
            return Tq();
        }
        int size = this.bth.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bth.keyAt(i), this.bth.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bth.keyAt(i2), this.bth.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void dj(boolean z) {
        this.bto = z;
    }
}
