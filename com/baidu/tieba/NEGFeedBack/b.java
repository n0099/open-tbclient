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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private LinearLayout aYA;
    private CompoundButton.OnCheckedChangeListener aYB;
    private int aYC;
    private boolean aYx = false;
    private SparseArray<String> aYy = null;
    private String[] aYz;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aYC = l.f(this.mPageContext.getPageActivity(), d.e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.aYy = ahVar.ql();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aYz = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aYx = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.aYB = onCheckedChangeListener;
    }

    public View getView() {
        if (this.aYA == null) {
            this.aYA = new LinearLayout(this.mPageContext.getPageActivity());
            this.aYA.setOrientation(1);
        }
        List<List<a>> La = La();
        if (v.w(La)) {
            return null;
        }
        int size = La.size();
        int i = 0;
        while (i < size) {
            View a2 = a(La.get(i), i == size + (-1), this.aYA.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.aYA.addView(a2);
            }
            i++;
        }
        if (this.aYA.getChildCount() > size) {
            this.aYA.removeViews(size, this.aYA.getChildCount() - size);
        }
        return this.aYA;
    }

    private List<List<a>> La() {
        int i;
        int i2;
        int i3 = -1;
        if (this.aYy == null || this.aYy.size() == 0) {
            return Lb();
        }
        int size = this.aYy.size();
        int i4 = this.aYx ? 0 : -1;
        int i5 = this.aYx ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.aYy.keyAt(i6), this.aYy.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.aYy.keyAt(i), this.aYy.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> Lb() {
        if (this.aYz == null || this.aYz.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.aYz.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.aYz[i])) {
                arrayList2.add(new a(i, 0, this.aYz[i]));
            }
            if (i + 1 < this.aYz.length && !StringUtils.isNull(this.aYz[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.aYz[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.w(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.aYA, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.wC();
        nEGFeedBackReasonCheckBox2.wC();
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aYB);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aYB);
        int i = z ? 0 : this.aYC;
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
