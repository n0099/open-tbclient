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
    private com.baidu.tieba.enterForum.data.f hDA;
    private final k hlY;
    private final List<g> hmb;
    private final k.c hmg;
    private ViewEventCenter htp;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.hmg = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.htp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.hDA, null, null));
                } else if (i == 1) {
                    d.this.htp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.hDA, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.htp = viewEventCenter;
        this.hmb = new ArrayList();
        this.hlY = new k(this.mContext);
        this.hlY.a(this.hmg);
        a(this.hlY);
    }

    public void onChangeSkinType() {
        if (this.hlY != null) {
            this.hlY.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.hDA != null && this.hmb != null && this.hlY != null) {
            this.hmb.clear();
            this.hmb.add(new g(1, getString(this.hDA.ceJ() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.hlY));
            this.hmb.add(new g(2, getString(R.string.delete, new Object[0]), this.hlY));
            this.hlY.aT(this.hmb);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.hDA = fVar;
        createView();
    }
}
