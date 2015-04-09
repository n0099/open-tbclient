package com.baidu.tieba.discover.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private u aCj;
    private List<com.baidu.tieba.discover.data.c> mData;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    public void setOnHeaderItemClickListener(u uVar) {
        this.aCj = uVar;
    }

    public void s(String str, boolean z) {
        if (str != null && this.mData != null && !this.mData.isEmpty()) {
            int size = this.mData.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = this.mData.get(i);
                if (cVar != null && str.equals(cVar.Gm())) {
                    cVar.bu(z);
                    if (i < getChildCount() && (getChildAt(i) instanceof a)) {
                        ((a) getChildAt(i)).bv(z);
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
            aVar.am(cVar.getIcon_url(), cVar.Gm());
            aVar.setTitle(cVar.getTitle());
            aVar.bv(cVar.Go());
            aVar.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (i2 > 1) {
                if (i == 0) {
                    aVar.setPadding(n.d(TbadkApplication.getInst(), t.ds30), 0, 0, 0);
                } else if (i == i2 - 1) {
                    aVar.setPadding(0, 0, n.d(TbadkApplication.getInst(), t.ds30), 0);
                } else {
                    aVar.setPadding(0, 0, 0, 0);
                }
            }
            addView(aVar);
            aVar.setOnClickListener(new c(this, cVar));
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                ((a) childAt).f(tbPageContext);
            }
        }
    }
}
