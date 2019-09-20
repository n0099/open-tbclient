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
/* loaded from: classes4.dex */
public class d extends i {
    private final k eGB;
    private final List<g> eGE;
    private final k.c eGJ;
    private ViewEventCenter eXb;
    private com.baidu.tieba.enterForum.data.f fep;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.eGJ = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.kc()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.fep, null, null));
                } else if (i == 1) {
                    d.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.fep, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eXb = viewEventCenter;
        this.eGE = new ArrayList();
        this.eGB = new k(this.mContext);
        this.eGB.a(this.eGJ);
        a(this.eGB);
    }

    public void onChangeSkinType() {
        if (this.eGB != null) {
            this.eGB.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.fep != null && this.eGE != null && this.eGB != null) {
            this.eGE.clear();
            this.eGE.add(new g(1, getString(this.fep.bfV() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.eGB));
            this.eGE.add(new g(2, getString(R.string.delete, new Object[0]), this.eGB));
            this.eGB.W(this.eGE);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.fep = fVar;
        createView();
    }
}
