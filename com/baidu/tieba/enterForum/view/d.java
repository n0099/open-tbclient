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
/* loaded from: classes6.dex */
public class d extends i {
    private final k fGf;
    private final List<g> fGi;
    private final k.c fGn;
    private ViewEventCenter fNE;
    private com.baidu.tieba.enterForum.data.f fUM;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.fGn = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.fNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.fUM, null, null));
                } else if (i == 1) {
                    d.this.fNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.fUM, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fNE = viewEventCenter;
        this.fGi = new ArrayList();
        this.fGf = new k(this.mContext);
        this.fGf.a(this.fGn);
        a(this.fGf);
    }

    public void onChangeSkinType() {
        if (this.fGf != null) {
            this.fGf.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.fUM != null && this.fGi != null && this.fGf != null) {
            this.fGi.clear();
            this.fGi.add(new g(1, getString(this.fUM.bvj() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.fGf));
            this.fGi.add(new g(2, getString(R.string.delete, new Object[0]), this.fGf));
            this.fGf.aA(this.fGi);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.fUM = fVar;
        createView();
    }
}
