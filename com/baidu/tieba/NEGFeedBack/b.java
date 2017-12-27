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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private boolean bMp = false;
    private SparseArray<String> bMq = null;
    private String[] bMr;
    private LinearLayout bMs;
    private CompoundButton.OnCheckedChangeListener bMt;
    private int bMu;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bMu = l.s(this.mPageContext.getPageActivity(), d.e.ds16);
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.bMq = aiVar.xO();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bMr = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bMp = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bMt = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bMs == null) {
            this.bMs = new LinearLayout(this.mPageContext.getPageActivity());
            this.bMs.setOrientation(1);
        }
        List<List<a>> Sz = Sz();
        if (v.G(Sz)) {
            return null;
        }
        int size = Sz.size();
        int i = 0;
        while (i < size) {
            View a2 = a(Sz.get(i), i == size + (-1), this.bMs.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bMs.addView(a2);
            }
            i++;
        }
        if (this.bMs.getChildCount() > size) {
            this.bMs.removeViews(size, this.bMs.getChildCount() - size);
        }
        return this.bMs;
    }

    private List<List<a>> Sz() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bMq == null || this.bMq.size() == 0) {
            return SA();
        }
        int size = this.bMq.size();
        int i4 = this.bMp ? 0 : -1;
        int i5 = this.bMp ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bMq.keyAt(i6), this.bMq.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bMq.keyAt(i), this.bMq.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> SA() {
        if (this.bMr == null || this.bMr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bMr.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bMr[i])) {
                arrayList2.add(new a(i, 0, this.bMr[i]));
            }
            if (i + 1 < this.bMr.length && !StringUtils.isNull(this.bMr[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bMr[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.G(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.bMs, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.Ea();
        nEGFeedBackReasonCheckBox2.Ea();
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bMt);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bMt);
        int i = z ? 0 : this.bMu;
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
