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
/* loaded from: classes9.dex */
public class d extends i {
    private final k.c gTE;
    private final k gTw;
    private final List<g> gTz;
    private ViewEventCenter haL;
    private com.baidu.tieba.enterForum.data.f hkS;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.gTE = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.haL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.hkS, null, null));
                } else if (i == 1) {
                    d.this.haL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.hkS, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.haL = viewEventCenter;
        this.gTz = new ArrayList();
        this.gTw = new k(this.mContext);
        this.gTw.a(this.gTE);
        a(this.gTw);
    }

    public void onChangeSkinType() {
        if (this.gTw != null) {
            this.gTw.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.hkS != null && this.gTz != null && this.gTw != null) {
            this.gTz.clear();
            this.gTz.add(new g(1, getString(this.hkS.bRl() == 1 ? R.string.cancel_top : R.string.f1303top, new Object[0]), this.gTw));
            this.gTz.add(new g(2, getString(R.string.delete, new Object[0]), this.gTw));
            this.gTw.aL(this.gTz);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.hkS = fVar;
        createView();
    }
}
