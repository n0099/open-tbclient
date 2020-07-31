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
/* loaded from: classes16.dex */
public class d extends i {
    private final k gZb;
    private final List<g> gZe;
    private final k.c gZj;
    private ViewEventCenter hgq;
    private com.baidu.tieba.enterForum.data.f hqD;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.gZj = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.hgq.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.hqD, null, null));
                } else if (i == 1) {
                    d.this.hgq.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.hqD, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hgq = viewEventCenter;
        this.gZe = new ArrayList();
        this.gZb = new k(this.mContext);
        this.gZb.a(this.gZj);
        a(this.gZb);
    }

    public void onChangeSkinType() {
        if (this.gZb != null) {
            this.gZb.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.hqD != null && this.gZe != null && this.gZb != null) {
            this.gZe.clear();
            this.gZe.add(new g(1, getString(this.hqD.bUx() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.gZb));
            this.gZe.add(new g(2, getString(R.string.delete, new Object[0]), this.gZb));
            this.gZb.aS(this.gZe);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.hqD = fVar;
        createView();
    }
}
