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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private String[] eTG;
    private LinearLayout eTH;
    private CompoundButton.OnCheckedChangeListener eTI;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> eTK;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean eTE = false;
    private SparseArray<String> eTF = null;
    private boolean eTL = false;
    private CompoundButton.OnCheckedChangeListener eTJ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.eTK != null && !b.this.eTK.isEmpty()) {
                if (z && b.this.eTL) {
                    for (Map.Entry entry : b.this.eTK.entrySet()) {
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
                if (b.this.eTI != null) {
                    b.this.eTI.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(ap apVar) {
        if (apVar != null) {
            this.eTF = apVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eTG = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.eTE = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.eTI = onCheckedChangeListener;
    }

    public View getView() {
        if (this.eTH == null) {
            this.eTH = new LinearLayout(this.mPageContext.getPageActivity());
            this.eTH.setOrientation(1);
        }
        List<List<a>> bnl = bnl();
        if (w.isEmpty(bnl)) {
            return null;
        }
        int size = bnl.size();
        if (this.eTK == null) {
            this.eTK = new HashMap<>();
        } else {
            this.eTK.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bnl.get(i), i == size + (-1), this.eTH.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.eTH.addView(a2);
            }
            i++;
        }
        if (this.eTH.getChildCount() > size) {
            this.eTH.removeViews(size, this.eTH.getChildCount() - size);
        }
        return this.eTH;
    }

    private List<List<a>> bnl() {
        int i;
        int i2;
        int i3 = -1;
        if (this.eTF == null || this.eTF.size() == 0) {
            return bnm();
        }
        int size = this.eTF.size();
        int i4 = this.eTE ? 0 : -1;
        int i5 = this.eTE ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.eTF.keyAt(i6), this.eTF.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.eTF.keyAt(i), this.eTF.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bnm() {
        if (this.eTG == null || this.eTG.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.eTG.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.eTG[i])) {
                arrayList2.add(new a(i, 0, this.eTG[i]));
            }
            if (i + 1 < this.eTG.length && !StringUtils.isNull(this.eTG[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.eTG[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (w.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.eTH, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aYj();
        nEGFeedBackReasonCheckBox2.aYj();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.eTK.put(nEGFeedBackReasonCheckBox, false);
        this.eTK.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.eTJ);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.eTJ);
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
        if (w.isEmpty(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.eTH, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aYj();
        nEGFeedBackReasonCheckBox2.aYj();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.eTK.put(nEGFeedBackReasonCheckBox, false);
        this.eTK.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.eTJ);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.eTJ);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.eTH == null) {
            this.eTH = new LinearLayout(this.mPageContext.getPageActivity());
            this.eTH.setOrientation(1);
        }
        List<List<a>> bno = bno();
        if (w.isEmpty(bno)) {
            return null;
        }
        int size = bno.size();
        if (this.eTK == null) {
            this.eTK = new HashMap<>();
        } else {
            this.eTK.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bno.get(i), i == size + (-1), this.eTH.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.eTH.addView(b);
            }
            i++;
        }
        if (this.eTH.getChildCount() > size) {
            this.eTH.removeViews(size, this.eTH.getChildCount() - size);
        }
        return this.eTH;
    }

    private List<List<a>> bnn() {
        if (this.eTG == null || this.eTG.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.eTG.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.eTG[i])) {
                arrayList2.add(new a(i, i + 1, this.eTG[i]));
            }
            if (i + 1 < this.eTG.length && !StringUtils.isNull(this.eTG[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.eTG[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bno() {
        if (this.eTF == null || this.eTF.size() == 0) {
            return bnn();
        }
        int size = this.eTF.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.eTF.keyAt(i), this.eTF.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.eTF.keyAt(i2), this.eTF.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void je(boolean z) {
        this.eTL = z;
    }
}
