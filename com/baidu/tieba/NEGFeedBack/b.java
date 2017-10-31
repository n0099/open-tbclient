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
    private boolean aVm = false;
    private SparseArray<String> aVn = null;
    private String[] aVo;
    private LinearLayout aVp;
    private CompoundButton.OnCheckedChangeListener aVq;
    private int aVr;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aVr = l.f(this.mPageContext.getPageActivity(), d.e.ds16);
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.aVn = alVar.qk();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVo = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVm = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.aVq = onCheckedChangeListener;
    }

    public View getView() {
        if (this.aVp == null) {
            this.aVp = new LinearLayout(this.mPageContext.getPageActivity());
            this.aVp.setOrientation(1);
        }
        List<List<a>> Ks = Ks();
        if (v.v(Ks)) {
            return null;
        }
        int size = Ks.size();
        int i = 0;
        while (i < size) {
            View a2 = a(Ks.get(i), i == size + (-1), this.aVp.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.aVp.addView(a2);
            }
            i++;
        }
        if (this.aVp.getChildCount() > size) {
            this.aVp.removeViews(size, this.aVp.getChildCount() - size);
        }
        return this.aVp;
    }

    private List<List<a>> Ks() {
        int i;
        int i2;
        int i3 = -1;
        if (this.aVn == null || this.aVn.size() == 0) {
            return Kt();
        }
        int size = this.aVn.size();
        int i4 = this.aVm ? 0 : -1;
        int i5 = this.aVm ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.aVn.keyAt(i6), this.aVn.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.aVn.keyAt(i), this.aVn.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Kt() {
        if (this.aVo == null || this.aVo.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.aVo.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.aVo[i])) {
                arrayList2.add(new a(i, 0, this.aVo[i]));
            }
            if (i + 1 < this.aVo.length && !StringUtils.isNull(this.aVo[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.aVo[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.v(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.aVp, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.wB();
        nEGFeedBackReasonCheckBox2.wB();
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aVq);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aVq);
        int i = z ? 0 : this.aVr;
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
