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
    private com.baidu.tieba.enterForum.data.f iDE;
    private final k ilP;
    private final List<g> ilS;
    private final k.c ilX;
    private ViewEventCenter itw;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.ilX = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.itw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.iDE, null, null));
                } else if (i == 1) {
                    d.this.itw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.iDE, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.itw = viewEventCenter;
        this.ilS = new ArrayList();
        this.ilP = new k(this.mContext);
        this.ilP.a(this.ilX);
        a(this.ilP);
    }

    public void onChangeSkinType() {
        if (this.ilP != null) {
            this.ilP.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.iDE != null && this.ilS != null && this.ilP != null) {
            this.ilS.clear();
            this.ilS.add(new g(1, getString(this.iDE.cuU() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.ilP));
            this.ilS.add(new g(2, getString(R.string.delete, new Object[0]), this.ilP));
            this.ilP.bu(this.ilS);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.iDE = fVar;
        createView();
    }
}
