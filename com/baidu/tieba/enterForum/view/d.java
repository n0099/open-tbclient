package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends i {
    private final k hHV;
    private final List<g> hHY;
    private final k.c hId;
    private ViewEventCenter hPp;
    private com.baidu.tieba.enterForum.data.f hZx;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.hId = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.hPp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.hZx, null, null));
                } else if (i == 1) {
                    d.this.hPp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.hZx, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hPp = viewEventCenter;
        this.hHY = new ArrayList();
        this.hHV = new k(this.mContext);
        this.hHV.a(this.hId);
        a(this.hHV);
    }

    public void onChangeSkinType() {
        if (this.hHV != null) {
            this.hHV.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.hZx != null && this.hHY != null && this.hHV != null) {
            this.hHY.clear();
            this.hHY.add(new g(1, getString(this.hZx.clu() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.hHV));
            this.hHY.add(new g(2, getString(R.string.delete, new Object[0]), this.hHV));
            this.hHV.ba(this.hHY);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.hZx = fVar;
        createView();
    }
}
