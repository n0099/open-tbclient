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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private String[] bou;
    private LinearLayout bov;
    private CompoundButton.OnCheckedChangeListener bow;
    private HashMap<NEGFeedBackReasonCheckBox, Boolean> boy;
    private int boz;
    private TbPageContext mPageContext;
    private boolean bos = false;
    private SparseArray<String> bot = null;
    private boolean boA = false;
    private CompoundButton.OnCheckedChangeListener box = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.b.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != null && b.this.boy != null && !b.this.boy.isEmpty()) {
                if (z && b.this.boA) {
                    for (Map.Entry entry : b.this.boy.entrySet()) {
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
                if (b.this.bow != null) {
                    b.this.bow.onCheckedChanged(compoundButton, z);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.boz = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bot = ahVar.vk();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bou = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bos = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bow = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bov == null) {
            this.bov = new LinearLayout(this.mPageContext.getPageActivity());
            this.bov.setOrientation(1);
        }
        List<List<a>> Rj = Rj();
        if (v.z(Rj)) {
            return null;
        }
        int size = Rj.size();
        if (this.boy == null) {
            this.boy = new HashMap<>();
        } else {
            this.boy.clear();
        }
        int i = 0;
        while (i < size) {
            View a2 = a(Rj.get(i), i == size + (-1), this.bov.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bov.addView(a2);
            }
            i++;
        }
        if (this.bov.getChildCount() > size) {
            this.bov.removeViews(size, this.bov.getChildCount() - size);
        }
        return this.bov;
    }

    private List<List<a>> Rj() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bot == null || this.bot.size() == 0) {
            return Rk();
        }
        int size = this.bot.size();
        int i4 = this.bos ? 0 : -1;
        int i5 = this.bos ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bot.keyAt(i6), this.bot.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bot.keyAt(i), this.bot.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Rk() {
        if (this.bou == null || this.bou.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bou.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bou[i])) {
                arrayList2.add(new a(i, 0, this.bou[i]));
            }
            if (i + 1 < this.bou.length && !StringUtils.isNull(this.bou[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bou[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.z(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bov, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.BQ();
        nEGFeedBackReasonCheckBox2.BQ();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.boy.put(nEGFeedBackReasonCheckBox, false);
        this.boy.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.box);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.box);
        int i = z ? 0 : this.boz;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes2.dex */
    public class a {
        public int id;
        public int index;
        public String reason;

        public a(int i, int i2, String str) {
            this.id = i2;
            this.reason = str;
            this.index = i;
        }
    }

    private View b(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.z(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.neg_feedback_reason_item, (ViewGroup) this.bov, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(e.g.right_reason);
        nEGFeedBackReasonCheckBox.BQ();
        nEGFeedBackReasonCheckBox2.BQ();
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        this.boy.put(nEGFeedBackReasonCheckBox, false);
        this.boy.put(nEGFeedBackReasonCheckBox2, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.box);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.box);
        int i = z ? 0 : this.boz;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    public View getRootView() {
        if (this.bov == null) {
            this.bov = new LinearLayout(this.mPageContext.getPageActivity());
            this.bov.setOrientation(1);
        }
        List<List<a>> Rm = Rm();
        if (v.z(Rm)) {
            return null;
        }
        int size = Rm.size();
        if (this.boy == null) {
            this.boy = new HashMap<>();
        } else {
            this.boy.clear();
        }
        int i = 0;
        while (i < size) {
            View b = b(Rm.get(i), i == size + (-1), this.bov.getChildAt(i));
            if (b != null && b.getParent() == null) {
                this.bov.addView(b);
            }
            i++;
        }
        if (this.bov.getChildCount() > size) {
            this.bov.removeViews(size, this.bov.getChildCount() - size);
        }
        return this.bov;
    }

    private List<List<a>> Rl() {
        if (this.bou == null || this.bou.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bou.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bou[i])) {
                arrayList2.add(new a(i, i + 1, this.bou[i]));
            }
            if (i + 1 < this.bou.length && !StringUtils.isNull(this.bou[i + 1])) {
                arrayList2.add(new a(i + 1, i + 2, this.bou[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private List<List<a>> Rm() {
        if (this.bot == null || this.bot.size() == 0) {
            return Rl();
        }
        int size = this.bot.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i + 2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i, this.bot.keyAt(i), this.bot.valueAt(i)));
            if (i2 > i && i2 < size) {
                arrayList2.add(new a(i2, this.bot.keyAt(i2), this.bot.valueAt(i2)));
            }
            arrayList.add(arrayList2);
            i = i3;
        }
        return arrayList;
    }

    public void cJ(boolean z) {
        this.boA = z;
    }
}
