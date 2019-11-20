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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private int bGN;
    private String[] dbN;
    private LinearLayout dbO;
    private CompoundButton.OnCheckedChangeListener dbP;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> dbR;
    private TbPageContext mPageContext;
    private boolean dbL = false;
    private SparseArray<String> dbM = null;
    private boolean dbS = false;
    private CompoundButton.OnCheckedChangeListener dbQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.dbR != null && !b.this.dbR.isEmpty()) {
                if (z && b.this.dbS) {
                    for (Map.Entry entry : b.this.dbR.entrySet()) {
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
                if (b.this.dbP != null) {
                    b.this.dbP.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bGN = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.dbM = ajVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dbN = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dbL = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.dbP = onCheckedChangeListener;
    }

    public View getView() {
        if (this.dbO == null) {
            this.dbO = new LinearLayout(this.mPageContext.getPageActivity());
            this.dbO.setOrientation(1);
        }
        List<List<a>> aBI = aBI();
        if (v.isEmpty(aBI)) {
            return null;
        }
        int size = aBI.size();
        if (this.dbR == null) {
            this.dbR = new HashMap<>();
        } else {
            this.dbR.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(aBI.get(i), i == size + (-1), this.dbO.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.dbO.addView(a2);
            }
            i++;
        }
        if (this.dbO.getChildCount() > size) {
            this.dbO.removeViews(size, this.dbO.getChildCount() - size);
        }
        return this.dbO;
    }

    private List<List<a>> aBI() {
        int i;
        int i2;
        int i3 = -1;
        if (this.dbM == null || this.dbM.size() == 0) {
            return aBJ();
        }
        int size = this.dbM.size();
        int i4 = this.dbL ? 0 : -1;
        int i5 = this.dbL ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.dbM.keyAt(i6), this.dbM.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.dbM.keyAt(i), this.dbM.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> aBJ() {
        if (this.dbN == null || this.dbN.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dbN.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dbN[i])) {
                arrayList2.add(new a(i, 0, this.dbN[i]));
            }
            if (i + 1 < this.dbN.length && !StringUtils.isNull(this.dbN[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.dbN[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dbO, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.anM();
        nEGFeedBackReasonCheckBox2.anM();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dbR.put(nEGFeedBackReasonCheckBox, false);
        this.dbR.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dbQ);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dbQ);
        int i = z ? 0 : this.bGN;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes3.dex */
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dbO, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.anM();
        nEGFeedBackReasonCheckBox2.anM();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dbR.put(nEGFeedBackReasonCheckBox, false);
        this.dbR.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dbQ);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dbQ);
        int i = z ? 0 : this.bGN;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.dbO == null) {
            this.dbO = new LinearLayout(this.mPageContext.getPageActivity());
            this.dbO.setOrientation(1);
        }
        List<List<a>> aBL = aBL();
        if (v.isEmpty(aBL)) {
            return null;
        }
        int size = aBL.size();
        if (this.dbR == null) {
            this.dbR = new HashMap<>();
        } else {
            this.dbR.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(aBL.get(i), i == size + (-1), this.dbO.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.dbO.addView(b);
            }
            i++;
        }
        if (this.dbO.getChildCount() > size) {
            this.dbO.removeViews(size, this.dbO.getChildCount() - size);
        }
        return this.dbO;
    }

    private List<List<a>> aBK() {
        if (this.dbN == null || this.dbN.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dbN.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dbN[i])) {
                arrayList2.add(new a(i, i + 1, this.dbN[i]));
            }
            if (i + 1 < this.dbN.length && !StringUtils.isNull(this.dbN[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.dbN[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> aBL() {
        if (this.dbM == null || this.dbM.size() == 0) {
            return aBK();
        }
        int size = this.dbM.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.dbM.keyAt(i), this.dbM.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.dbM.keyAt(i2), this.dbM.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void fW(boolean z) {
        this.dbS = z;
    }
}
