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
/* loaded from: classes7.dex */
public class d extends i {
    private final k fJp;
    private final List<g> fJs;
    private final k.c fJx;
    private ViewEventCenter fQN;
    private com.baidu.tieba.enterForum.data.f fXV;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.fJx = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.fQN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.fXV, null, null));
                } else if (i == 1) {
                    d.this.fQN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.fXV, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fQN = viewEventCenter;
        this.fJs = new ArrayList();
        this.fJp = new k(this.mContext);
        this.fJp.a(this.fJx);
        a(this.fJp);
    }

    public void onChangeSkinType() {
        if (this.fJp != null) {
            this.fJp.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.fXV != null && this.fJs != null && this.fJp != null) {
            this.fJs.clear();
            this.fJs.add(new g(1, getString(this.fXV.bwl() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.fJp));
            this.fJs.add(new g(2, getString(R.string.delete, new Object[0]), this.fJp));
            this.fJp.az(this.fJs);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.fXV = fVar;
        createView();
    }
}
