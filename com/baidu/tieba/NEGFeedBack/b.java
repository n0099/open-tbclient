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
    private boolean aVc = false;
    private SparseArray<String> aVd = null;
    private String[] aVe;
    private LinearLayout aVf;
    private CompoundButton.OnCheckedChangeListener aVg;
    private int aVh;
    private TbPageContext mH;

    public b(TbPageContext tbPageContext) {
        this.mH = tbPageContext;
        this.aVh = l.f(this.mH.getPageActivity(), d.f.ds16);
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.aVd = alVar.qf();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVe = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVc = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.aVg = onCheckedChangeListener;
    }

    public View getView() {
        if (this.aVf == null) {
            this.aVf = new LinearLayout(this.mH.getPageActivity());
            this.aVf.setOrientation(1);
        }
        List<List<a>> Kj = Kj();
        if (v.u(Kj)) {
            return null;
        }
        int size = Kj.size();
        int i = 0;
        while (i < size) {
            View a2 = a(Kj.get(i), i == size + (-1), this.aVf.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.aVf.addView(a2);
            }
            i++;
        }
        if (this.aVf.getChildCount() > size) {
            this.aVf.removeViews(size, this.aVf.getChildCount() - size);
        }
        return this.aVf;
    }

    private List<List<a>> Kj() {
        int i;
        int i2;
        int i3 = -1;
        if (this.aVd == null || this.aVd.size() == 0) {
            return Kk();
        }
        int size = this.aVd.size();
        int i4 = this.aVc ? 0 : -1;
        int i5 = this.aVc ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.aVd.keyAt(i6), this.aVd.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.aVd.keyAt(i), this.aVd.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Kk() {
        if (this.aVe == null || this.aVe.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.aVe.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.aVe[i])) {
                arrayList2.add(new a(i, 0, this.aVe[i]));
            }
            if (i + 1 < this.aVe.length && !StringUtils.isNull(this.aVe[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.aVe[i + 1]));
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
            linearLayout = (LinearLayout) LayoutInflater.from(this.mH.getPageActivity()).inflate(d.j.neg_feedback_reason_item, (ViewGroup) this.aVf, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aVg);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aVg);
        int i = z ? 0 : this.aVh;
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
