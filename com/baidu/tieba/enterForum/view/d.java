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
    private final k iBk;
    private final List<g> iBn;
    private final k.c iBs;
    private ViewEventCenter iIJ;
    private com.baidu.tieba.enterForum.data.f iSO;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.iBs = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.iIJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.iSO, null, null));
                } else if (i == 1) {
                    d.this.iIJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.iSO, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.iIJ = viewEventCenter;
        this.iBn = new ArrayList();
        this.iBk = new k(this.mContext);
        this.iBk.a(this.iBs);
        a(this.iBk);
    }

    public void onChangeSkinType() {
        if (this.iBk != null) {
            this.iBk.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.iSO != null && this.iBn != null && this.iBk != null) {
            this.iBn.clear();
            this.iBn.add(new g(1, getString(this.iSO.cvv() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.iBk));
            this.iBn.add(new g(2, getString(R.string.delete, new Object[0]), this.iBk));
            this.iBk.bw(this.iBn);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.iSO = fVar;
        createView();
    }
}
