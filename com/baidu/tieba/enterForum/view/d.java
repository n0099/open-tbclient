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
    private ViewEventCenter eAK;
    private com.baidu.tieba.enterForum.data.d eGT;
    private final i ejZ;
    private final List<f> ekc;
    private final i.c ekh;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.ekh = new i.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                d.this.dismiss();
                if (!j.kY()) {
                    l.showToast(d.this.mContext, d.j.network_not_available);
                } else if (i == 2) {
                    d.this.eAK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.eGT, null, null));
                } else if (i == 1) {
                    d.this.eAK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.eGT, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eAK = viewEventCenter;
        this.ekc = new ArrayList();
        this.ejZ = new i(this.mContext);
        this.ejZ.a(this.ekh);
        setContentView(this.ejZ.abh());
    }

    public void onChangeSkinType() {
        if (this.ejZ != null) {
            this.ejZ.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.eGT != null && this.ekc != null && this.ejZ != null) {
            this.ekc.clear();
            this.ekc.add(new f(1, getString(this.eGT.aWi() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ejZ));
            this.ekc.add(new f(2, getString(d.j.delete, new Object[0]), this.ejZ));
            this.ejZ.P(this.ekc);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.d dVar) {
        this.eGT = dVar;
        createView();
    }
}
