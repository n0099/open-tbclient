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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private boolean aVp = false;
    private SparseArray<String> aVq = null;
    private String[] aVr;
    private LinearLayout aVs;
    private CompoundButton.OnCheckedChangeListener aVt;
    private int aVu;
    private TbPageContext mG;

    public b(TbPageContext tbPageContext) {
        this.mG = tbPageContext;
        this.aVu = l.f(this.mG.getPageActivity(), d.f.ds16);
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.aVq = alVar.qm();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVr = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVp = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.aVt = onCheckedChangeListener;
    }

    public View getView() {
        if (this.aVs == null) {
            this.aVs = new LinearLayout(this.mG.getPageActivity());
            this.aVs.setOrientation(1);
        }
        List<List<a>> Kp = Kp();
        if (v.u(Kp)) {
            return null;
        }
        int size = Kp.size();
        int i = 0;
        while (i < size) {
            View a2 = a(Kp.get(i), i == size + (-1), this.aVs.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.aVs.addView(a2);
            }
            i++;
        }
        if (this.aVs.getChildCount() > size) {
            this.aVs.removeViews(size, this.aVs.getChildCount() - size);
        }
        return this.aVs;
    }

    private List<List<a>> Kp() {
        int i;
        int i2;
        int i3 = -1;
        if (this.aVq == null || this.aVq.size() == 0) {
            return Kq();
        }
        int size = this.aVq.size();
        int i4 = this.aVp ? 0 : -1;
        int i5 = this.aVp ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.aVq.keyAt(i6), this.aVq.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.aVq.keyAt(i), this.aVq.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Kq() {
        if (this.aVr == null || this.aVr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.aVr.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.aVr[i])) {
                arrayList2.add(new a(i, 0, this.aVr[i]));
            }
            if (i + 1 < this.aVr.length && !StringUtils.isNull(this.aVr[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.aVr[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.u(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mG.getPageActivity()).inflate(d.j.neg_feedback_reason_item, (ViewGroup) this.aVs, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.h.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.h.right_reason);
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aVt);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aVt);
        int i = z ? 0 : this.aVu;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes.dex */
    public class a {
        public int id;
        public String reason;

        public a(int i, int i2, String str) {
            this.id = i2;
            this.reason = str;
        }
    }
}
