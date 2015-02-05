package com.baidu.tieba.discover.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.discover.p;
import com.baidu.tieba.discover.z;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class DiscoverHeaderView extends LinearLayout {
    private z awo;
    private List<com.baidu.tieba.discover.data.c> mData;

    public DiscoverHeaderView(Context context) {
        this(context, null);
    }

    public DiscoverHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    public void setOnHeaderItemClickListener(z zVar) {
        this.awo = zVar;
    }

    public void r(String str, boolean z) {
        if (str != null && this.mData != null && !this.mData.isEmpty()) {
            int size = this.mData.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = this.mData.get(i);
                if (cVar != null && str.equals(cVar.Dl())) {
                    cVar.bv(z);
                    if (i < getChildCount() && (getChildAt(i) instanceof a)) {
                        ((a) getChildAt(i)).bw(z);
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
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                aVar.fg(cVar.getIcon_url());
            } else {
                aVar.ex(p.fd(cVar.Dl()));
            }
            aVar.setTitle(cVar.getTitle());
            aVar.bw(cVar.Dn());
            aVar.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (i2 > 1) {
                if (i == 0) {
                    aVar.setPadding(l.d(TbadkApplication.getInst(), u.ds30), 0, 0, 0);
                } else if (i == i2 - 1) {
                    aVar.setPadding(0, 0, l.d(TbadkApplication.getInst(), u.ds30), 0);
                } else {
                    aVar.setPadding(0, 0, 0, 0);
                }
            }
            addView(aVar);
            aVar.setOnClickListener(new b(this, cVar));
        }
    }

    public void c(TbPageContext<?> tbPageContext) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                ((a) childAt).c(tbPageContext);
            }
        }
    }
}
