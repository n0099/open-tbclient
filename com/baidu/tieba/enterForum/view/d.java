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
    private com.baidu.tieba.enterForum.data.f iDC;
    private final k ilN;
    private final List<g> ilQ;
    private final k.c ilV;
    private ViewEventCenter itu;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.ilV = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.itu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.iDC, null, null));
                } else if (i == 1) {
                    d.this.itu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.iDC, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.itu = viewEventCenter;
        this.ilQ = new ArrayList();
        this.ilN = new k(this.mContext);
        this.ilN.a(this.ilV);
        a(this.ilN);
    }

    public void onChangeSkinType() {
        if (this.ilN != null) {
            this.ilN.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.iDC != null && this.ilQ != null && this.ilN != null) {
            this.ilQ.clear();
            this.ilQ.add(new g(1, getString(this.iDC.cuT() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.ilN));
            this.ilQ.add(new g(2, getString(R.string.delete, new Object[0]), this.ilN));
            this.ilN.bu(this.ilQ);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.iDC = fVar;
        createView();
    }
}
