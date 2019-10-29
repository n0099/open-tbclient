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
    private int bHE;
    private String[] dcF;
    private LinearLayout dcG;
    private CompoundButton.OnCheckedChangeListener dcH;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> dcJ;
    private TbPageContext mPageContext;
    private boolean dcD = false;
    private SparseArray<String> dcE = null;
    private boolean dcK = false;
    private CompoundButton.OnCheckedChangeListener dcI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.dcJ != null && !b.this.dcJ.isEmpty()) {
                if (z && b.this.dcK) {
                    for (Map.Entry entry : b.this.dcJ.entrySet()) {
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
                if (b.this.dcH != null) {
                    b.this.dcH.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bHE = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20);
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.dcE = ajVar.getFeedBackReasonMap();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dcF = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dcD = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.dcH = onCheckedChangeListener;
    }

    public View getView() {
        if (this.dcG == null) {
            this.dcG = new LinearLayout(this.mPageContext.getPageActivity());
            this.dcG.setOrientation(1);
        }
        List<List<a>> aBK = aBK();
        if (v.isEmpty(aBK)) {
            return null;
        }
        int size = aBK.size();
        if (this.dcJ == null) {
            this.dcJ = new HashMap<>();
        } else {
            this.dcJ.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(aBK.get(i), i == size + (-1), this.dcG.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.dcG.addView(a2);
            }
            i++;
        }
        if (this.dcG.getChildCount() > size) {
            this.dcG.removeViews(size, this.dcG.getChildCount() - size);
        }
        return this.dcG;
    }

    private List<List<a>> aBK() {
        int i;
        int i2;
        int i3 = -1;
        if (this.dcE == null || this.dcE.size() == 0) {
            return aBL();
        }
        int size = this.dcE.size();
        int i4 = this.dcD ? 0 : -1;
        int i5 = this.dcD ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.dcE.keyAt(i6), this.dcE.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.dcE.keyAt(i), this.dcE.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> aBL() {
        if (this.dcF == null || this.dcF.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dcF.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dcF[i])) {
                arrayList2.add(new a(i, 0, this.dcF[i]));
            }
            if (i + 1 < this.dcF.length && !StringUtils.isNull(this.dcF[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.dcF[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dcG, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.anO();
        nEGFeedBackReasonCheckBox2.anO();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dcJ.put(nEGFeedBackReasonCheckBox, false);
        this.dcJ.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dcI);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dcI);
        int i = z ? 0 : this.bHE;
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.dcG, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.anO();
        nEGFeedBackReasonCheckBox2.anO();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.dcJ.put(nEGFeedBackReasonCheckBox, false);
        this.dcJ.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.dcI);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.dcI);
        int i = z ? 0 : this.bHE;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.dcG == null) {
            this.dcG = new LinearLayout(this.mPageContext.getPageActivity());
            this.dcG.setOrientation(1);
        }
        List<List<a>> aBN = aBN();
        if (v.isEmpty(aBN)) {
            return null;
        }
        int size = aBN.size();
        if (this.dcJ == null) {
            this.dcJ = new HashMap<>();
        } else {
            this.dcJ.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(aBN.get(i), i == size + (-1), this.dcG.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.dcG.addView(b);
            }
            i++;
        }
        if (this.dcG.getChildCount() > size) {
            this.dcG.removeViews(size, this.dcG.getChildCount() - size);
        }
        return this.dcG;
    }

    private List<List<a>> aBM() {
        if (this.dcF == null || this.dcF.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dcF.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.dcF[i])) {
                arrayList2.add(new a(i, i + 1, this.dcF[i]));
            }
            if (i + 1 < this.dcF.length && !StringUtils.isNull(this.dcF[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.dcF[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> aBN() {
        if (this.dcE == null || this.dcE.size() == 0) {
            return aBM();
        }
        int size = this.dcE.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.dcE.keyAt(i), this.dcE.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.dcE.keyAt(i2), this.dcE.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void fW(boolean z) {
        this.dcK = z;
    }
}
