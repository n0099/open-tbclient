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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private boolean bgI = false;
    private SparseArray<String> bgJ = null;
    private String[] bgK;
    private LinearLayout bgL;
    private CompoundButton.OnCheckedChangeListener bgM;
    private int bgN;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bgN = l.e(this.mPageContext.getPageActivity(), d.e.ds16);
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.bgJ = aiVar.up();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bgK = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bgI = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.bgM = onCheckedChangeListener;
    }

    public View getView() {
        if (this.bgL == null) {
            this.bgL = new LinearLayout(this.mPageContext.getPageActivity());
            this.bgL.setOrientation(1);
        }
        List<List<a>> OR = OR();
        if (w.z(OR)) {
            return null;
        }
        int size = OR.size();
        int i = 0;
        while (i < size) {
            View a2 = a(OR.get(i), i == size + (-1), this.bgL.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.bgL.addView(a2);
            }
            i++;
        }
        if (this.bgL.getChildCount() > size) {
            this.bgL.removeViews(size, this.bgL.getChildCount() - size);
        }
        return this.bgL;
    }

    private List<List<a>> OR() {
        int i;
        int i2;
        int i3 = -1;
        if (this.bgJ == null || this.bgJ.size() == 0) {
            return OS();
        }
        int size = this.bgJ.size();
        int i4 = this.bgI ? 0 : -1;
        int i5 = this.bgI ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.bgJ.keyAt(i6), this.bgJ.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.bgJ.keyAt(i), this.bgJ.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> OS() {
        if (this.bgK == null || this.bgK.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bgK.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.bgK[i])) {
                arrayList2.add(new a(i, 0, this.bgK[i]));
            }
            if (i + 1 < this.bgK.length && !StringUtils.isNull(this.bgK[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.bgK[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (w.z(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.neg_feedback_reason_item, (ViewGroup) this.bgL, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.g.right_reason);
        nEGFeedBackReasonCheckBox.Ay();
        nEGFeedBackReasonCheckBox2.Ay();
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.bgM);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.bgM);
        int i = z ? 0 : this.bgN;
        if (linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes2.dex */
    public class a {
        public int id;
        public String reason;

        public a(int i, int i2, String str) {
            this.id = i2;
            this.reason = str;
        }
    }
}
