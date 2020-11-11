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
    private String[] fOP;
    private LinearLayout fOQ;
    private CompoundButton.OnCheckedChangeListener fOR;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> fOT;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean fOM = false;
    private SparseArray<String> fON = null;
    private SparseArray<String> fOO = null;
    private boolean fOU = false;
    private CompoundButton.OnCheckedChangeListener fOS = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.fOT != null && !b.this.fOT.isEmpty()) {
                if (z && b.this.fOU) {
                    for (Map.Entry entry : b.this.fOT.entrySet()) {
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
                if (b.this.fOR != null) {
                    b.this.fOR.onCheckedChanged(compoundButton, z);
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
            this.fON = arVar.getFeedBackReasonMap();
            this.fOO = arVar.eBG;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fOP = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fOM = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.fOR = onCheckedChangeListener;
    }

    public View getView() {
        if (this.fOQ == null) {
            this.fOQ = new LinearLayout(this.mPageContext.getPageActivity());
            this.fOQ.setOrientation(1);
        }
        List<List<a>> bIs = bIs();
        if (y.isEmpty(bIs)) {
            return null;
        }
        int size = bIs.size();
        if (this.fOT == null) {
            this.fOT = new HashMap<>();
        } else {
            this.fOT.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bIs.get(i), i == size + (-1), this.fOQ.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.fOQ.addView(a2);
            }
            i++;
        }
        if (this.fOQ.getChildCount() > size) {
            this.fOQ.removeViews(size, this.fOQ.getChildCount() - size);
        }
        return this.fOQ;
    }

    private List<List<a>> bIs() {
        int i;
        int i2;
        int i3 = -1;
        if (this.fON == null || this.fON.size() == 0) {
            return bIt();
        }
        int size = this.fON.size();
        int i4 = this.fOM ? 0 : -1;
        int i5 = this.fOM ? size - 1 : size;
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
            a aVar = new a(i6, this.fON.keyAt(i6), this.fON.valueAt(i6));
            if (this.fOO != null && !StringUtils.isNull(this.fOO.get(this.fON.keyAt(i6)))) {
                aVar.extra = this.fOO.get(this.fON.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.fON.keyAt(i), this.fON.valueAt(i));
                if (this.fOO != null && !StringUtils.isNull(this.fOO.get(this.fON.keyAt(i6)))) {
                    aVar2.extra = this.fOO.get(this.fON.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bIt() {
        if (this.fOP == null || this.fOP.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fOP.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fOP[i])) {
                arrayList2.add(new a(i, 0, this.fOP[i]));
            }
            if (i + 1 < this.fOP.length && !StringUtils.isNull(this.fOP[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.fOP[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fOQ, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bsD();
        nEGFeedBackReasonCheckBox2.bsD();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fOT.put(nEGFeedBackReasonCheckBox, false);
        this.fOT.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fOS);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fOS);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fOQ, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bsD();
        nEGFeedBackReasonCheckBox2.bsD();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.fOT.put(nEGFeedBackReasonCheckBox, false);
        this.fOT.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.fOS);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.fOS);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.fOQ == null) {
            this.fOQ = new LinearLayout(this.mPageContext.getPageActivity());
            this.fOQ.setOrientation(1);
        }
        List<List<a>> bIv = bIv();
        if (y.isEmpty(bIv)) {
            return null;
        }
        int size = bIv.size();
        if (this.fOT == null) {
            this.fOT = new HashMap<>();
        } else {
            this.fOT.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bIv.get(i), i == size + (-1), this.fOQ.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.fOQ.addView(b);
            }
            i++;
        }
        if (this.fOQ.getChildCount() > size) {
            this.fOQ.removeViews(size, this.fOQ.getChildCount() - size);
        }
        return this.fOQ;
    }

    private List<List<a>> bIu() {
        if (this.fOP == null || this.fOP.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.fOP.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.fOP[i])) {
                arrayList2.add(new a(i, i + 1, this.fOP[i]));
            }
            if (i + 1 < this.fOP.length && !StringUtils.isNull(this.fOP[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.fOP[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bIv() {
        if (this.fON == null || this.fON.size() == 0) {
            return bIu();
        }
        int size = this.fON.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.fON.keyAt(i), this.fON.valueAt(i));
            if (this.fOO != null && !StringUtils.isNull(this.fOO.get(this.fON.keyAt(i)))) {
                aVar.extra = this.fOO.get(this.fON.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.fON.keyAt(i2), this.fON.valueAt(i2));
                if (this.fOO != null && !StringUtils.isNull(this.fOO.get(this.fON.keyAt(i)))) {
                    aVar2.extra = this.fOO.get(this.fON.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void le(boolean z) {
        this.fOU = z;
    }
}
