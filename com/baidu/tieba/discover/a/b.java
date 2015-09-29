package com.baidu.tieba.discover.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.discover.y;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private y aKQ;
    private List<com.baidu.tieba.discover.data.c> mData;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    public void setOnHeaderItemClickListener(y yVar) {
        this.aKQ = yVar;
    }

    public void v(String str, boolean z) {
        if (str != null && this.mData != null && !this.mData.isEmpty()) {
            int size = this.mData.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = this.mData.get(i);
                if (cVar != null && str.equals(cVar.HN())) {
                    cVar.bH(z);
                    if (i < getChildCount() && (getChildAt(i) instanceof a)) {
                        ((a) getChildAt(i)).bJ(z);
                        return;
                    }
                }
            }
        }
    }

    public void setData(List<com.baidu.tieba.discover.data.c> list) {
        this.mData = list;
        removeAllViews();
        if (this.mData != null) {
            int size = this.mData.size();
            for (int i = 0; i < size; i++) {
                a(this.mData.get(i), i, size);
            }
        }
    }

    private void a(com.baidu.tieba.discover.data.c cVar, int i, int i2) {
        if (cVar != null) {
            a aVar = new a(getContext());
            aVar.ar(cVar.getIcon_url(), cVar.HN());
            aVar.setTitle(cVar.getTitle());
            aVar.bJ(cVar.HP());
            aVar.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (i2 > 1) {
                if (i == 0) {
                    aVar.setPadding(k.d(TbadkApplication.getInst(), i.d.ds30), 0, 0, 0);
                } else if (i == i2 - 1) {
                    aVar.setPadding(0, 0, k.d(TbadkApplication.getInst(), i.d.ds30), 0);
                } else {
                    aVar.setPadding(0, 0, 0, 0);
                }
            }
            addView(aVar);
            aVar.setOnClickListener(new c(this, cVar));
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                ((a) childAt).e(tbPageContext);
            }
        }
    }
}
