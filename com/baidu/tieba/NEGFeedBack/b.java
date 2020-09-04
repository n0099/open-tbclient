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
/* loaded from: classes15.dex */
public class b {
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> flB;
    private String[] flx;
    private LinearLayout fly;
    private CompoundButton.OnCheckedChangeListener flz;
    private int mMarginBottom;
    private TbPageContext mPageContext;
    private boolean flu = false;
    private SparseArray<String> flv = null;
    private SparseArray<String> flw = null;
    private boolean flC = false;
    private CompoundButton.OnCheckedChangeListener flA = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.flB != null && !b.this.flB.isEmpty()) {
                if (z && b.this.flC) {
                    for (Map.Entry entry : b.this.flB.entrySet()) {
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
                if (b.this.flz != null) {
                    b.this.flz.onCheckedChanged(compoundButton, z);
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
            this.flv = arVar.getFeedBackReasonMap();
            this.flw = arVar.dZb;
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.flx = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.flu = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.flz = onCheckedChangeListener;
    }

    public View getView() {
        if (this.fly == null) {
            this.fly = new LinearLayout(this.mPageContext.getPageActivity());
            this.fly.setOrientation(1);
        }
        List<List<a>> bAf = bAf();
        if (y.isEmpty(bAf)) {
            return null;
        }
        int size = bAf.size();
        if (this.flB == null) {
            this.flB = new HashMap<>();
        } else {
            this.flB.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(bAf.get(i), i == size + (-1), this.fly.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.fly.addView(a2);
            }
            i++;
        }
        if (this.fly.getChildCount() > size) {
            this.fly.removeViews(size, this.fly.getChildCount() - size);
        }
        return this.fly;
    }

    private List<List<a>> bAf() {
        int i;
        int i2;
        int i3 = -1;
        if (this.flv == null || this.flv.size() == 0) {
            return bAg();
        }
        int size = this.flv.size();
        int i4 = this.flu ? 0 : -1;
        int i5 = this.flu ? size - 1 : size;
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
            a aVar = new a(i6, this.flv.keyAt(i6), this.flv.valueAt(i6));
            if (this.flw != null && !StringUtils.isNull(this.flw.get(this.flv.keyAt(i6)))) {
                aVar.extra = this.flw.get(this.flv.keyAt(i6));
            }
            arrayList2.add(aVar);
            if (i > i6 && i < size) {
                a aVar2 = new a(i, this.flv.keyAt(i), this.flv.valueAt(i));
                if (this.flw != null && !StringUtils.isNull(this.flw.get(this.flv.keyAt(i6)))) {
                    aVar2.extra = this.flw.get(this.flv.keyAt(i));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> bAg() {
        if (this.flx == null || this.flx.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.flx.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.flx[i])) {
                arrayList2.add(new a(i, 0, this.flx[i]));
            }
            if (i + 1 < this.flx.length && !StringUtils.isNull(this.flx[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.flx[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fly, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bkF();
        nEGFeedBackReasonCheckBox2.bkF();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.flB.put(nEGFeedBackReasonCheckBox, false);
        this.flB.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.flA);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.flA);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes15.dex */
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.fly, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
        nEGFeedBackReasonCheckBox.bkF();
        nEGFeedBackReasonCheckBox2.bkF();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.flB.put(nEGFeedBackReasonCheckBox, false);
        this.flB.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.flA);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.flA);
        int i = z ? 0 : this.mMarginBottom;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.fly == null) {
            this.fly = new LinearLayout(this.mPageContext.getPageActivity());
            this.fly.setOrientation(1);
        }
        List<List<a>> bAi = bAi();
        if (y.isEmpty(bAi)) {
            return null;
        }
        int size = bAi.size();
        if (this.flB == null) {
            this.flB = new HashMap<>();
        } else {
            this.flB.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(bAi.get(i), i == size + (-1), this.fly.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.fly.addView(b);
            }
            i++;
        }
        if (this.fly.getChildCount() > size) {
            this.fly.removeViews(size, this.fly.getChildCount() - size);
        }
        return this.fly;
    }

    private List<List<a>> bAh() {
        if (this.flx == null || this.flx.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.flx.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.flx[i])) {
                arrayList2.add(new a(i, i + 1, this.flx[i]));
            }
            if (i + 1 < this.flx.length && !StringUtils.isNull(this.flx[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.flx[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> bAi() {
        if (this.flv == null || this.flv.size() == 0) {
            return bAh();
        }
        int size = this.flv.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            a aVar = new a(i, this.flv.keyAt(i), this.flv.valueAt(i));
            if (this.flw != null && !StringUtils.isNull(this.flw.get(this.flv.keyAt(i)))) {
                aVar.extra = this.flw.get(this.flv.keyAt(i));
            }
            arrayList2.add(aVar);
            if (i2 > i && i2 < size) {
                a aVar2 = new a(i2, this.flv.keyAt(i2), this.flv.valueAt(i2));
                if (this.flw != null && !StringUtils.isNull(this.flw.get(this.flv.keyAt(i)))) {
                    aVar2.extra = this.flw.get(this.flv.keyAt(i2));
                }
                arrayList2.add(aVar2);
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void kj(boolean z) {
        this.flC = z;
    }
}
