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
    private boolean bOM = false;
    private SparseArray<String> bON = null;
    private String[] bOO;
    private LinearLayout bOP;
    private CompoundButton.OnCheckedChangeListener bOQ;
    private int bOR;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bOR = l.t(this.mPageContext.getPageActivity(), d.e.ds16);
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bON = ahVar.yo();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bOO = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bOM = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bOQ = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bOP == null) {
            this.bOP = new LinearLayout(this.mPageContext.getPageActivity());
            this.bOP.setOrientation(1);
        }
        List<List<a>> SW = SW();
        if (v.E(SW)) {
            return null;
        }
        int size = SW.size();
        int i = 0;
        while (i < size) {
            View a2 = a(SW.get(i), i == size + (-1), this.bOP.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bOP.addView(a2);
            }
            i++;
        }
        if (this.bOP.getChildCount() > size) {
            this.bOP.removeViews(size, this.bOP.getChildCount() - size);
        }
        return this.bOP;
    }

    private List<List<a>> SW() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bON == null || this.bON.size() == 0) {
            return SX();
        }
        int size = this.bON.size();
        int i4 = this.bOM ? 0 : -1;
        int i5 = this.bOM ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bON.keyAt(i6), this.bON.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bON.keyAt(i), this.bON.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> SX() {
        if (this.bOO == null || this.bOO.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bOO.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bOO[i])) {
                arrayList2.add(new a(i, 0, this.bOO[i]));
            }
            if (i + 1 < this.bOO.length && !StringUtils.isNull(this.bOO[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bOO[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.E(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.neg_feedback_reason_item, (ViewGroup) this.bOP, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.En();
        nEGFeedBackReasonCheckBox2.En();
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bOQ);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bOQ);
        int i = z ? 0 : this.bOR;
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
