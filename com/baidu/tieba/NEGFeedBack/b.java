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
    private int bnH;
    private String[] cQO;
    private LinearLayout cQP;
    private CompoundButton.OnCheckedChangeListener cQQ;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> cQS;
    private TbPageContext mPageContext;
    private boolean cQM = false;
    private SparseArray<String> cQN = null;
    private boolean cQT = false;
    private CompoundButton.OnCheckedChangeListener cQR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.cQS != null && !b.this.cQS.isEmpty()) {
                if (z && b.this.cQT) {
                    for (Map.Entry entry : b.this.cQS.entrySet()) {
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
                if (b.this.cQQ != null) {
                    b.this.cQQ.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bnH = l.g(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cQN = ajVar.ace();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cQO = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cQM = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.cQQ = onCheckedChangeListener;
    }

    public View getView() {
        if (this.cQP == null) {
            this.cQP = new LinearLayout(this.mPageContext.getPageActivity());
            this.cQP.setOrientation(1);
        }
        List<List<a>> azV = azV();
        if (v.aa(azV)) {
            return null;
        }
        int size = azV.size();
        if (this.cQS == null) {
            this.cQS = new HashMap<>();
        } else {
            this.cQS.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(azV.get(i), i == size + (-1), this.cQP.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.cQP.addView(a2);
            }
            i++;
        }
        if (this.cQP.getChildCount() > size) {
            this.cQP.removeViews(size, this.cQP.getChildCount() - size);
        }
        return this.cQP;
    }

    private List<List<a>> azV() {
        int i;
        int i2;
        int i3 = -1;
        if (this.cQN == null || this.cQN.size() == 0) {
            return azW();
        }
        int size = this.cQN.size();
        int i4 = this.cQM ? 0 : -1;
        int i5 = this.cQM ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.cQN.keyAt(i6), this.cQN.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.cQN.keyAt(i), this.cQN.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> azW() {
        if (this.cQO == null || this.cQO.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cQO.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cQO[i])) {
                arrayList2.add(new a(i, 0, this.cQO[i]));
            }
            if (i + 1 < this.cQO.length && !StringUtils.isNull(this.cQO[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.cQO[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.aa(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.cQP, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.ajG();
        nEGFeedBackReasonCheckBox2.ajG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cQS.put(nEGFeedBackReasonCheckBox, false);
        this.cQS.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cQR);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cQR);
        int i = z ? 0 : this.bnH;
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
        if (v.aa(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.cQP, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.ajG();
        nEGFeedBackReasonCheckBox2.ajG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cQS.put(nEGFeedBackReasonCheckBox, false);
        this.cQS.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cQR);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cQR);
        int i = z ? 0 : this.bnH;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.cQP == null) {
            this.cQP = new LinearLayout(this.mPageContext.getPageActivity());
            this.cQP.setOrientation(1);
        }
        List<List<a>> azY = azY();
        if (v.aa(azY)) {
            return null;
        }
        int size = azY.size();
        if (this.cQS == null) {
            this.cQS = new HashMap<>();
        } else {
            this.cQS.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(azY.get(i), i == size + (-1), this.cQP.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.cQP.addView(b);
            }
            i++;
        }
        if (this.cQP.getChildCount() > size) {
            this.cQP.removeViews(size, this.cQP.getChildCount() - size);
        }
        return this.cQP;
    }

    private List<List<a>> azX() {
        if (this.cQO == null || this.cQO.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cQO.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cQO[i])) {
                arrayList2.add(new a(i, i + 1, this.cQO[i]));
            }
            if (i + 1 < this.cQO.length && !StringUtils.isNull(this.cQO[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.cQO[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> azY() {
        if (this.cQN == null || this.cQN.size() == 0) {
            return azX();
        }
        int size = this.cQN.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.cQN.keyAt(i), this.cQN.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.cQN.keyAt(i2), this.cQN.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void ga(boolean z) {
        this.cQT = z;
    }
}
