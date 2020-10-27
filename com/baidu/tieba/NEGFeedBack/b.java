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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class b {
    private String[] fIZ;
    private LinearLayout fJa;
    private CompoundButton.OnCheckedChangeListener fJb;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> fJd;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean fIW = false;
    private SparseArray<String> fIX = null;
    private SparseArray<String> fIY = null;
    private boolean fJe = false;
    private CompoundButton.OnCheckedChangeListener fJc = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.fJd != null && !b.this.fJd.isEmpty()) {
                if (z && b.this.fJe) {
                    for (Map.Entry entry : b.this.fJd.entrySet()) {
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
                if (b.this.fJb != null) {
                    b.this.fJb.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mMarginBottom = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.fIX = arVar.getFeedBackReasonMap();
            this.fIY = arVar.evN;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fIZ = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fIW = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.fJb = onCheckedChangeListener;
    }

    public View getView() {
        if (this.fJa == null) {
            this.fJa = new LinearLayout(this.mPageContext.getPageActivity());
            this.fJa.setOrientation(1);
        }
        List<List<a>> bFT = bFT();
        if (y.isEmpty(bFT)) {
            return null;
        }
        int size = bFT.size();
        if (this.fJd == null) {
            this.fJd = new HashMap<>();
        } else {
            this.fJd.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bFT.get(i), i == size + (-1), this.fJa.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.fJa.addView(a2);
            }
            i++;
        }
        if (this.fJa.getChildCount() > size) {
            this.fJa.removeViews(size, this.fJa.getChildCount() - size);
        }
        return this.fJa;
    }

    private List<List<a>> bFT() {
        int i;
        int i2;
        int i3 = -1;
        if (this.fIX == null || this.fIX.size() == 0) {
            return bFU();
        }
        int size = this.fIX.size();
        int i4 = this.fIW ? 0 : -1;
        int i5 = this.fIW ? size - 1 : size;
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
            a aVar = new a(i6, this.fIX.keyAt(i6), this.fIX.valueAt(i6));
            if (this.fIY != null && !StringUtils.isNull(this.fIY.get(this.fIX.keyAt(i6)))) {
                aVar.extra = this.fIY.get(this.fIX.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.fIX.keyAt(i), this.fIX.valueAt(i));
                if (this.fIY != null && !StringUtils.isNull(this.fIY.get(this.fIX.keyAt(i6)))) {
                    aVar2.extra = this.fIY.get(this.fIX.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bFU() {
        if (this.fIZ == null || this.fIZ.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fIZ.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fIZ[i])) {
                arrayList2.add(new a(i, 0, this.fIZ[i]));
            }
            if (i + 1 < this.fIZ.length && !StringUtils.isNull(this.fIZ[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.fIZ[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fJa, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bqd();
        nEGFeedBackReasonCheckBox2.bqd();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fJd.put(nEGFeedBackReasonCheckBox, false);
        this.fJd.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fJc);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fJc);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes21.dex */
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fJa, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bqd();
        nEGFeedBackReasonCheckBox2.bqd();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fJd.put(nEGFeedBackReasonCheckBox, false);
        this.fJd.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fJc);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fJc);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.fJa == null) {
            this.fJa = new LinearLayout(this.mPageContext.getPageActivity());
            this.fJa.setOrientation(1);
        }
        List<List<a>> bFW = bFW();
        if (y.isEmpty(bFW)) {
            return null;
        }
        int size = bFW.size();
        if (this.fJd == null) {
            this.fJd = new HashMap<>();
        } else {
            this.fJd.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bFW.get(i), i == size + (-1), this.fJa.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.fJa.addView(b);
            }
            i++;
        }
        if (this.fJa.getChildCount() > size) {
            this.fJa.removeViews(size, this.fJa.getChildCount() - size);
        }
        return this.fJa;
    }

    private List<List<a>> bFV() {
        if (this.fIZ == null || this.fIZ.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fIZ.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fIZ[i])) {
                arrayList2.add(new a(i, i + 1, this.fIZ[i]));
            }
            if (i + 1 < this.fIZ.length && !StringUtils.isNull(this.fIZ[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.fIZ[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bFW() {
        if (this.fIX == null || this.fIX.size() == 0) {
            return bFV();
        }
        int size = this.fIX.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.fIX.keyAt(i), this.fIX.valueAt(i));
            if (this.fIY != null && !StringUtils.isNull(this.fIY.get(this.fIX.keyAt(i)))) {
                aVar.extra = this.fIY.get(this.fIX.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.fIX.keyAt(i2), this.fIX.valueAt(i2));
                if (this.fIY != null && !StringUtils.isNull(this.fIY.get(this.fIX.keyAt(i)))) {
                    aVar2.extra = this.fIY.get(this.fIX.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void kV(boolean z) {
        this.fJe = z;
    }
}
