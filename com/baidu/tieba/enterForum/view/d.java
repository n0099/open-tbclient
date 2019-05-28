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
    private ViewEventCenter eQo;
    private com.baidu.tieba.enterForum.data.f eXc;
    private final k ezP;
    private final List<g> ezS;
    private final k.c ezX;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.ezX = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.jS()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.eQo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.eXc, null, null));
                } else if (i == 1) {
                    d.this.eQo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.eXc, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eQo = viewEventCenter;
        this.ezS = new ArrayList();
        this.ezP = new k(this.mContext);
        this.ezP.a(this.ezX);
        setContentView(this.ezP.afZ());
    }

    public void onChangeSkinType() {
        if (this.ezP != null) {
            this.ezP.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.eXc != null && this.ezS != null && this.ezP != null) {
            this.ezS.clear();
            this.ezS.add(new g(1, getString(this.eXc.bdn() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.ezP));
            this.ezS.add(new g(2, getString(R.string.delete, new Object[0]), this.ezP));
            this.ezP.W(this.ezS);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.eXc = fVar;
        createView();
    }
}
