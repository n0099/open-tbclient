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
    private ViewEventCenter eAZ;
    private com.baidu.tieba.enterForum.data.d eHh;
    private final i ekn;
    private final List<f> ekq;
    private final i.c ekv;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.ekv = new i.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                d.this.dismiss();
                if (!j.kY()) {
                    l.showToast(d.this.mContext, d.j.network_not_available);
                } else if (i == 2) {
                    d.this.eAZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.eHh, null, null));
                } else if (i == 1) {
                    d.this.eAZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.eHh, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eAZ = viewEventCenter;
        this.ekq = new ArrayList();
        this.ekn = new i(this.mContext);
        this.ekn.a(this.ekv);
        setContentView(this.ekn.abk());
    }

    public void onChangeSkinType() {
        if (this.ekn != null) {
            this.ekn.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.eHh != null && this.ekq != null && this.ekn != null) {
            this.ekq.clear();
            this.ekq.add(new f(1, getString(this.eHh.aWk() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ekn));
            this.ekq.add(new f(2, getString(d.j.delete, new Object[0]), this.ekn));
            this.ekn.P(this.ekq);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.d dVar) {
        this.eHh = dVar;
        createView();
    }
}
