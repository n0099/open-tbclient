package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SelectRuleView extends LinearLayout {
    List<String> eWN;
    private int eWT;
    List<String> eWU;
    List<String> eWV;
    private int mSkinType;
    private int mType;

    public SelectRuleView(Context context) {
        this(context, null);
    }

    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 0;
        this.eWT = 2;
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        setGravity(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setData(List<String> list, List<String> list2) {
        if (!y.isEmpty(list) || !y.isEmpty(list2)) {
            bwf();
            this.eWU = list;
            this.eWV = list2;
            List<String> arrayList = new ArrayList<>();
            arrayList.addAll(list);
            List<String> arrayList2 = new ArrayList<>();
            arrayList2.addAll(list2);
            int size = arrayList.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
            while (arrayList2.size() < size) {
                arrayList2.add("");
            }
            while (arrayList.size() < size) {
                arrayList.add("");
            }
            for (int i = 0; i < ((this.eWT + size) - 1) / this.eWT; i++) {
                SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
                selectRuleRowItem.setType(this.mType);
                int i2 = this.eWT * i;
                int i3 = (i + 1) * this.eWT;
                selectRuleRowItem.setData(d(arrayList, i2, i3), d(arrayList2, i2, i3));
                addView(selectRuleRowItem);
            }
        }
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        if (!y.isEmpty(list2) || !y.isEmpty(list3) || !y.isEmpty(list)) {
            bwf();
            this.eWU = list2;
            this.eWV = list3;
            this.eWN = list;
            List<String> arrayList = new ArrayList<>();
            arrayList.addAll(list2);
            List<String> arrayList2 = new ArrayList<>();
            arrayList2.addAll(list3);
            List<String> arrayList3 = new ArrayList<>();
            arrayList3.addAll(list);
            int size = list2.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
            if (size <= arrayList3.size()) {
                size = arrayList3.size();
            }
            while (arrayList2.size() < size) {
                arrayList2.add("");
            }
            while (arrayList.size() < size) {
                arrayList.add("");
            }
            while (arrayList3.size() < size) {
                arrayList3.add("");
            }
            for (int i = 0; i < ((this.eWT + size) - 1) / this.eWT; i++) {
                SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
                selectRuleRowItem.setType(this.mType);
                int i2 = this.eWT * i;
                int i3 = (i + 1) * this.eWT;
                selectRuleRowItem.setData(d(arrayList3, i2, i3), d(arrayList, i2, i3), d(arrayList2, i2, i3));
                addView(selectRuleRowItem);
            }
        }
    }

    public void setColumn(int i) {
        this.eWT = i;
    }

    public void setType(int i) {
        this.mType = i;
    }

    private List<String> d(List<String> list, int i, int i2) {
        if (y.isEmpty(list) || i > list.size() || i < 0) {
            return null;
        }
        if (list.size() >= i2) {
            return list.subList(i, i2);
        }
        ArrayList arrayList = new ArrayList(list.subList(i, list.size()));
        for (int i3 = 0; i3 < i2 - list.size(); i3++) {
            arrayList.add("");
        }
        return arrayList;
    }

    private void bwf() {
        removeAllViews();
    }

    public void qM(int i) {
        if (this.mSkinType != i) {
            if (this.mType == 0) {
                setData(this.eWU, this.eWV);
            } else if (this.mType == 1) {
                setData(this.eWN, this.eWU, this.eWV);
            }
        }
    }
}
