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
    private String[] cQN;
    private LinearLayout cQO;
    private CompoundButton.OnCheckedChangeListener cQP;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> cQR;
    private TbPageContext mPageContext;
    private boolean cQL = false;
    private SparseArray<String> cQM = null;
    private boolean cQS = false;
    private CompoundButton.OnCheckedChangeListener cQQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.cQR != null && !b.this.cQR.isEmpty()) {
                if (z && b.this.cQS) {
                    for (Map.Entry entry : b.this.cQR.entrySet()) {
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
                if (b.this.cQP != null) {
                    b.this.cQP.onCheckedChanged(compoundButton, z);
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
            this.cQM = ajVar.ace();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cQN = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cQL = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.cQP = onCheckedChangeListener;
    }

    public View getView() {
        if (this.cQO == null) {
            this.cQO = new LinearLayout(this.mPageContext.getPageActivity());
            this.cQO.setOrientation(1);
        }
        List<List<a>> azV = azV();
        if (v.aa(azV)) {
            return null;
        }
        int size = azV.size();
        if (this.cQR == null) {
            this.cQR = new HashMap<>();
        } else {
            this.cQR.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(azV.get(i), i == size + (-1), this.cQO.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.cQO.addView(a2);
            }
            i++;
        }
        if (this.cQO.getChildCount() > size) {
            this.cQO.removeViews(size, this.cQO.getChildCount() - size);
        }
        return this.cQO;
    }

    private List<List<a>> azV() {
        int i;
        int i2;
        int i3 = -1;
        if (this.cQM == null || this.cQM.size() == 0) {
            return azW();
        }
        int size = this.cQM.size();
        int i4 = this.cQL ? 0 : -1;
        int i5 = this.cQL ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.cQM.keyAt(i6), this.cQM.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.cQM.keyAt(i), this.cQM.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> azW() {
        if (this.cQN == null || this.cQN.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cQN.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cQN[i])) {
                arrayList2.add(new a(i, 0, this.cQN[i]));
            }
            if (i + 1 < this.cQN.length && !StringUtils.isNull(this.cQN[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.cQN[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.cQO, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.ajG();
        nEGFeedBackReasonCheckBox2.ajG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cQR.put(nEGFeedBackReasonCheckBox, false);
        this.cQR.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cQQ);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cQQ);
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.cQO, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.ajG();
        nEGFeedBackReasonCheckBox2.ajG();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.cQR.put(nEGFeedBackReasonCheckBox, false);
        this.cQR.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.cQQ);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.cQQ);
        int i = z ? 0 : this.bnH;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.cQO == null) {
            this.cQO = new LinearLayout(this.mPageContext.getPageActivity());
            this.cQO.setOrientation(1);
        }
        List<List<a>> azY = azY();
        if (v.aa(azY)) {
            return null;
        }
        int size = azY.size();
        if (this.cQR == null) {
            this.cQR = new HashMap<>();
        } else {
            this.cQR.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(azY.get(i), i == size + (-1), this.cQO.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.cQO.addView(b);
            }
            i++;
        }
        if (this.cQO.getChildCount() > size) {
            this.cQO.removeViews(size, this.cQO.getChildCount() - size);
        }
        return this.cQO;
    }

    private List<List<a>> azX() {
        if (this.cQN == null || this.cQN.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cQN.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.cQN[i])) {
                arrayList2.add(new a(i, i + 1, this.cQN[i]));
            }
            if (i + 1 < this.cQN.length && !StringUtils.isNull(this.cQN[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.cQN[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> azY() {
        if (this.cQM == null || this.cQM.size() == 0) {
            return azX();
        }
        int size = this.cQM.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.cQM.keyAt(i), this.cQM.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.cQM.keyAt(i2), this.cQM.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void ga(boolean z) {
        this.cQS = z;
    }
}
