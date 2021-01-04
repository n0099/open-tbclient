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
/* loaded from: classes2.dex */
public class d extends i {
    private ViewEventCenter iFJ;
    private com.baidu.tieba.enterForum.data.f iPQ;
    private final k iyk;
    private final List<g> iyn;
    private final k.c iys;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.iys = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.iFJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.iPQ, null, null));
                } else if (i == 1) {
                    d.this.iFJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.iPQ, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.iFJ = viewEventCenter;
        this.iyn = new ArrayList();
        this.iyk = new k(this.mContext);
        this.iyk.a(this.iys);
        a(this.iyk);
    }

    public void onChangeSkinType() {
        if (this.iyk != null) {
            this.iyk.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.iPQ != null && this.iyn != null && this.iyk != null) {
            this.iyn.clear();
            this.iyn.add(new g(1, getString(this.iPQ.cxN() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.iyk));
            this.iyn.add(new g(2, getString(R.string.delete, new Object[0]), this.iyk));
            this.iyk.bB(this.iyn);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.iPQ = fVar;
        createView();
    }
}
