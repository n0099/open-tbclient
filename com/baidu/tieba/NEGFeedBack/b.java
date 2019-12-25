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
/* loaded from: classes5.dex */
public class b {
    private String[] dPJ;
    private LinearLayout dPK;
    private CompoundButton.OnCheckedChangeListener dPL;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> dPN;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean dPH = false;
    private SparseArray<String> dPI = null;
    private boolean dPO = false;
    private CompoundButton.OnCheckedChangeListener dPM = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.dPN != null && !b.this.dPN.isEmpty()) {
                if (z && b.this.dPO) {
                    for (Map.Entry entry : b.this.dPN.entrySet()) {
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
                if (b.this.dPL != null) {
                    b.this.dPL.onCheckedChanged(compoundButton, z);
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
            this.dPI = alVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dPJ = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dPH = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.dPL = onCheckedChangeListener;
    }

    public View getView() {
        if (this.dPK == null) {
            this.dPK = new LinearLayout(this.mPageContext.getPageActivity());
            this.dPK.setOrientation(1);
        }
        List<List<a>> aTx = aTx();
        if (v.isEmpty(aTx)) {
            return null;
        }
        int size = aTx.size();
        if (this.dPN == null) {
            this.dPN = new HashMap<>();
        } else {
            this.dPN.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(aTx.get(i), i == size + (-1), this.dPK.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.dPK.addView(a2);
            }
            i++;
        }
        if (this.dPK.getChildCount() > size) {
            this.dPK.removeViews(size, this.dPK.getChildCount() - size);
        }
        return this.dPK;
    }

    private List<List<a>> aTx() {
        int i;
        int i2;
        int i3 = -1;
        if (this.dPI == null || this.dPI.size() == 0) {
            return aTy();
        }
        int size = this.dPI.size();
        int i4 = this.dPH ? 0 : -1;
        int i5 = this.dPH ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.dPI.keyAt(i6), this.dPI.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.dPI.keyAt(i), this.dPI.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> aTy() {
        if (this.dPJ == null || this.dPJ.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dPJ.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dPJ[i])) {
                arrayList2.add(new a(i, 0, this.dPJ[i]));
            }
            if (i + 1 < this.dPJ.length && !StringUtils.isNull(this.dPJ[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.dPJ[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dPK, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aFd();
        nEGFeedBackReasonCheckBox2.aFd();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dPN.put(nEGFeedBackReasonCheckBox, false);
        this.dPN.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dPM);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dPM);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes5.dex */
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dPK, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aFd();
        nEGFeedBackReasonCheckBox2.aFd();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dPN.put(nEGFeedBackReasonCheckBox, false);
        this.dPN.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dPM);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dPM);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.dPK == null) {
            this.dPK = new LinearLayout(this.mPageContext.getPageActivity());
            this.dPK.setOrientation(1);
        }
        List<List<a>> aTA = aTA();
        if (v.isEmpty(aTA)) {
            return null;
        }
        int size = aTA.size();
        if (this.dPN == null) {
            this.dPN = new HashMap<>();
        } else {
            this.dPN.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(aTA.get(i), i == size + (-1), this.dPK.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.dPK.addView(b);
            }
            i++;
        }
        if (this.dPK.getChildCount() > size) {
            this.dPK.removeViews(size, this.dPK.getChildCount() - size);
        }
        return this.dPK;
    }

    private List<List<a>> aTz() {
        if (this.dPJ == null || this.dPJ.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dPJ.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dPJ[i])) {
                arrayList2.add(new a(i, i + 1, this.dPJ[i]));
            }
            if (i + 1 < this.dPJ.length && !StringUtils.isNull(this.dPJ[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.dPJ[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> aTA() {
        if (this.dPI == null || this.dPI.size() == 0) {
            return aTz();
        }
        int size = this.dPI.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.dPI.keyAt(i), this.dPI.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.dPI.keyAt(i2), this.dPI.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void hk(boolean z) {
        this.dPO = z;
    }
}
