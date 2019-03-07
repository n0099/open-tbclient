package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.f;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends g {
    private ViewEventCenter eBd;
    private com.baidu.tieba.enterForum.data.d eHl;
    private final i ekr;
    private final List<f> eku;
    private final i.c ekz;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.ekz = new i.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                d.this.dismiss();
                if (!j.kY()) {
                    l.showToast(d.this.mContext, d.j.network_not_available);
                } else if (i == 2) {
                    d.this.eBd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.eHl, null, null));
                } else if (i == 1) {
                    d.this.eBd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.eHl, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eBd = viewEventCenter;
        this.eku = new ArrayList();
        this.ekr = new i(this.mContext);
        this.ekr.a(this.ekz);
        setContentView(this.ekr.abk());
    }

    public void onChangeSkinType() {
        if (this.ekr != null) {
            this.ekr.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.eHl != null && this.eku != null && this.ekr != null) {
            this.eku.clear();
            this.eku.add(new f(1, getString(this.eHl.aWk() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ekr));
            this.eku.add(new f(2, getString(d.j.delete, new Object[0]), this.ekr));
            this.ekr.P(this.eku);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.d dVar) {
        this.eHl = dVar;
        createView();
    }
}
