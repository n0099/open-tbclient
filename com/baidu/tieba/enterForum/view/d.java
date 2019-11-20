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
    private final k eOr;
    private final List<g> eOu;
    private final k.c eOz;
    private ViewEventCenter eYW;
    private com.baidu.tieba.enterForum.data.f fgi;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.eOz = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.eYW.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.fgi, null, null));
                } else if (i == 1) {
                    d.this.eYW.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.fgi, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eYW = viewEventCenter;
        this.eOu = new ArrayList();
        this.eOr = new k(this.mContext);
        this.eOr.a(this.eOz);
        a(this.eOr);
    }

    public void onChangeSkinType() {
        if (this.eOr != null) {
            this.eOr.onChangeSkinType();
        }
    }

    private void nw() {
        if (this.fgi != null && this.eOu != null && this.eOr != null) {
            this.eOu.clear();
            this.eOu.add(new g(1, getString(this.fgi.bdN() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.eOr));
            this.eOu.add(new g(2, getString(R.string.delete, new Object[0]), this.eOr));
            this.eOr.at(this.eOu);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.fgi = fVar;
        nw();
    }
}
