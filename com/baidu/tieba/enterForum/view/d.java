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
    private final k.c hUA;
    private final k hUs;
    private final List<g> hUv;
    private ViewEventCenter ibM;
    private com.baidu.tieba.enterForum.data.f ilX;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.hUA = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.ibM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.ilX, null, null));
                } else if (i == 1) {
                    d.this.ibM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.ilX, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ibM = viewEventCenter;
        this.hUv = new ArrayList();
        this.hUs = new k(this.mContext);
        this.hUs.a(this.hUA);
        a(this.hUs);
    }

    public void onChangeSkinType() {
        if (this.hUs != null) {
            this.hUs.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.ilX != null && this.hUv != null && this.hUs != null) {
            this.hUv.clear();
            this.hUv.add(new g(1, getString(this.ilX.coB() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.hUs));
            this.hUv.add(new g(2, getString(R.string.delete, new Object[0]), this.hUs));
            this.hUs.bk(this.hUv);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.ilX = fVar;
        createView();
    }
}
