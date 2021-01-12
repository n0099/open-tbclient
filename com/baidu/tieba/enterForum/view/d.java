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
    private ViewEventCenter iBc;
    private com.baidu.tieba.enterForum.data.f iLj;
    private final k itD;
    private final List<g> itG;
    private final k.c itL;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.itL = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.iBc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.iLj, null, null));
                } else if (i == 1) {
                    d.this.iBc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.iLj, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.iBc = viewEventCenter;
        this.itG = new ArrayList();
        this.itD = new k(this.mContext);
        this.itD.a(this.itL);
        a(this.itD);
    }

    public void onChangeSkinType() {
        if (this.itD != null) {
            this.itD.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.iLj != null && this.itG != null && this.itD != null) {
            this.itG.clear();
            this.itG.add(new g(1, getString(this.iLj.ctW() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.itD));
            this.itG.add(new g(2, getString(R.string.delete, new Object[0]), this.itD));
            this.itD.bB(this.itG);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.iLj = fVar;
        createView();
    }
}
