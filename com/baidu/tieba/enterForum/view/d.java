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
    private final k iap;
    private final List<g> ias;
    private final k.c iax;
    private ViewEventCenter ihN;
    private com.baidu.tieba.enterForum.data.f irW;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.iax = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.ihN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.irW, null, null));
                } else if (i == 1) {
                    d.this.ihN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.irW, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ihN = viewEventCenter;
        this.ias = new ArrayList();
        this.iap = new k(this.mContext);
        this.iap.a(this.iax);
        a(this.iap);
    }

    public void onChangeSkinType() {
        if (this.iap != null) {
            this.iap.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.irW != null && this.ias != null && this.iap != null) {
            this.ias.clear();
            this.ias.add(new g(1, getString(this.irW.crc() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.iap));
            this.ias.add(new g(2, getString(R.string.delete, new Object[0]), this.iap));
            this.iap.br(this.ias);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.irW = fVar;
        createView();
    }
}
