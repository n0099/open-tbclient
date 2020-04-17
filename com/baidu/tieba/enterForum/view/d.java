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
import com.baidu.tieba.enterForum.data.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends i {
    private h gIZ;
    private final k grq;
    private final List<g> grt;
    private final k.c gry;
    private ViewEventCenter gyO;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.gry = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.gyO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.gIZ, null, null));
                } else if (i == 1) {
                    d.this.gyO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.gIZ, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gyO = viewEventCenter;
        this.grt = new ArrayList();
        this.grq = new k(this.mContext);
        this.grq.a(this.gry);
        a(this.grq);
    }

    public void onChangeSkinType() {
        if (this.grq != null) {
            this.grq.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.gIZ != null && this.grt != null && this.grq != null) {
            this.grt.clear();
            this.grt.add(new g(1, getString(this.gIZ.bHK() == 1 ? R.string.cancel_top : R.string.f1287top, new Object[0]), this.grq));
            this.grt.add(new g(2, getString(R.string.delete, new Object[0]), this.grq));
            this.grq.aI(this.grt);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(h hVar) {
        this.gIZ = hVar;
        createView();
    }
}
