package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.List;
/* loaded from: classes.dex */
public class SelectRuleRowItem extends AdapterLinearLayout {
    private a ewx;
    private int mType;

    public SelectRuleRowItem(Context context) {
        this(context, null);
    }

    public SelectRuleRowItem(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectRuleRowItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 0;
        initUI();
    }

    private void initUI() {
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ewx = new a(getContext());
        setAdapter(this.ewx);
    }

    public void setData(List<String> list, List<String> list2) {
        this.ewx.setData(list, list2);
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.ewx.setData(list, list2, list3);
    }

    public void setType(int i) {
        this.mType = i;
        this.ewx.setType(i);
    }
}
