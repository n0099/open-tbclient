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
    private String[] euH;
    private LinearLayout euI;
    private CompoundButton.OnCheckedChangeListener euJ;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> euL;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean euF = false;
    private SparseArray<String> euG = null;
    private boolean euM = false;
    private CompoundButton.OnCheckedChangeListener euK = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.euL != null && !b.this.euL.isEmpty()) {
                if (z && b.this.euM) {
                    for (Map.Entry entry : b.this.euL.entrySet()) {
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
                if (b.this.euJ != null) {
                    b.this.euJ.onCheckedChanged(compoundButton, z);
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
            this.euG = alVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.euH = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.euF = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.euJ = onCheckedChangeListener;
    }

    public View getView() {
        if (this.euI == null) {
            this.euI = new LinearLayout(this.mPageContext.getPageActivity());
            this.euI.setOrientation(1);
        }
        List<List<a>> bex = bex();
        if (v.isEmpty(bex)) {
            return null;
        }
        int size = bex.size();
        if (this.euL == null) {
            this.euL = new HashMap<>();
        } else {
            this.euL.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bex.get(i), i == size + (-1), this.euI.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.euI.addView(a2);
            }
            i++;
        }
        if (this.euI.getChildCount() > size) {
            this.euI.removeViews(size, this.euI.getChildCount() - size);
        }
        return this.euI;
    }

    private List<List<a>> bex() {
        int i;
        int i2;
        int i3 = -1;
        if (this.euG == null || this.euG.size() == 0) {
            return bey();
        }
        int size = this.euG.size();
        int i4 = this.euF ? 0 : -1;
        int i5 = this.euF ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.euG.keyAt(i6), this.euG.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.euG.keyAt(i), this.euG.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bey() {
        if (this.euH == null || this.euH.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.euH.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.euH[i])) {
                arrayList2.add(new a(i, 0, this.euH[i]));
            }
            if (i + 1 < this.euH.length && !StringUtils.isNull(this.euH[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.euH[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.euI, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aQm();
        nEGFeedBackReasonCheckBox2.aQm();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.euL.put(nEGFeedBackReasonCheckBox, false);
        this.euL.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.euK);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.euK);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.euI, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.aQm();
        nEGFeedBackReasonCheckBox2.aQm();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.euL.put(nEGFeedBackReasonCheckBox, false);
        this.euL.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.euK);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.euK);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.euI == null) {
            this.euI = new LinearLayout(this.mPageContext.getPageActivity());
            this.euI.setOrientation(1);
        }
        List<List<a>> beA = beA();
        if (v.isEmpty(beA)) {
            return null;
        }
        int size = beA.size();
        if (this.euL == null) {
            this.euL = new HashMap<>();
        } else {
            this.euL.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(beA.get(i), i == size + (-1), this.euI.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.euI.addView(b);
            }
            i++;
        }
        if (this.euI.getChildCount() > size) {
            this.euI.removeViews(size, this.euI.getChildCount() - size);
        }
        return this.euI;
    }

    private List<List<a>> bez() {
        if (this.euH == null || this.euH.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.euH.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.euH[i])) {
                arrayList2.add(new a(i, i + 1, this.euH[i]));
            }
            if (i + 1 < this.euH.length && !StringUtils.isNull(this.euH[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.euH[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> beA() {
        if (this.euG == null || this.euG.size() == 0) {
            return bez();
        }
        int size = this.euG.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.euG.keyAt(i), this.euG.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.euG.keyAt(i2), this.euG.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void iv(boolean z) {
        this.euM = z;
    }
}
