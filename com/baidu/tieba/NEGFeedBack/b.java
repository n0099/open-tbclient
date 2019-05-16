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
    private String[] cQM;
    private LinearLayout cQN;
    private CompoundButton.OnCheckedChangeListener cQO;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> cQQ;
    private TbPageContext mPageContext;
    private boolean cQK = false;
    private SparseArray<String> cQL = null;
    private boolean cQR = false;
    private CompoundButton.OnCheckedChangeListener cQP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.cQQ != null && !b.this.cQQ.isEmpty()) {
                if (z && b.this.cQR) {
                    for (Map.Entry entry : b.this.cQQ.entrySet()) {
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
                if (b.this.cQO != null) {
                    b.this.cQO.onCheckedChanged(compoundButton, z);
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
            this.cQL = ajVar.ace();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cQM = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cQK = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.cQO = onCheckedChangeListener;
    }

    public View getView() {
        if (this.cQN == null) {
            this.cQN = new LinearLayout(this.mPageContext.getPageActivity());
            this.cQN.setOrientation(1);
        }
        List<List<a>> azS = azS();
        if (v.aa(azS)) {
            return null;
        }
        int size = azS.size();
        if (this.cQQ == null) {
            this.cQQ = new HashMap<>();
        } else {
            this.cQQ.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(azS.get(i), i == size + (-1), this.cQN.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.cQN.addView(a2);
            }
            i++;
        }
        if (this.cQN.getChildCount() > size) {
            this.cQN.removeViews(size, this.cQN.getChildCount() - size);
        }
        return this.cQN;
    }

    private List<List<a>> azS() {
        int i;
        int i2;
        int i3 = -1;
        if (this.cQL == null || this.cQL.size() == 0) {
            return azT();
        }
        int size = this.cQL.size();
        int i4 = this.cQK ? 0 : -1;
        int i5 = this.cQK ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.cQL.keyAt(i6), this.cQL.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.cQL.keyAt(i), this.cQL.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> azT() {
        if (this.cQM == null || this.cQM.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cQM.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cQM[i])) {
                arrayList2.add(new a(i, 0, this.cQM[i]));
            }
            if (i + 1 < this.cQM.length && !StringUtils.isNull(this.cQM[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.cQM[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.cQN, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.ajG();
        nEGFeedBackReasonCheckBox2.ajG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cQQ.put(nEGFeedBackReasonCheckBox, false);
        this.cQQ.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cQP);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cQP);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.cQN, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.ajG();
        nEGFeedBackReasonCheckBox2.ajG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cQQ.put(nEGFeedBackReasonCheckBox, false);
        this.cQQ.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cQP);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cQP);
        int i = z ? 0 : this.bnH;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.cQN == null) {
            this.cQN = new LinearLayout(this.mPageContext.getPageActivity());
            this.cQN.setOrientation(1);
        }
        List<List<a>> azV = azV();
        if (v.aa(azV)) {
            return null;
        }
        int size = azV.size();
        if (this.cQQ == null) {
            this.cQQ = new HashMap<>();
        } else {
            this.cQQ.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(azV.get(i), i == size + (-1), this.cQN.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.cQN.addView(b);
            }
            i++;
        }
        if (this.cQN.getChildCount() > size) {
            this.cQN.removeViews(size, this.cQN.getChildCount() - size);
        }
        return this.cQN;
    }

    private List<List<a>> azU() {
        if (this.cQM == null || this.cQM.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cQM.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cQM[i])) {
                arrayList2.add(new a(i, i + 1, this.cQM[i]));
            }
            if (i + 1 < this.cQM.length && !StringUtils.isNull(this.cQM[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.cQM[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> azV() {
        if (this.cQL == null || this.cQL.size() == 0) {
            return azU();
        }
        int size = this.cQL.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.cQL.keyAt(i), this.cQL.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.cQL.keyAt(i2), this.cQL.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void ga(boolean z) {
        this.cQR = z;
    }
}
