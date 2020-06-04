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
    private final k.c gGE;
    private final k gGw;
    private final List<g> gGz;
    private ViewEventCenter gNP;
    private h gYc;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.gGE = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.gNP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.gYc, null, null));
                } else if (i == 1) {
                    d.this.gNP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.gYc, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gNP = viewEventCenter;
        this.gGz = new ArrayList();
        this.gGw = new k(this.mContext);
        this.gGw.a(this.gGE);
        a(this.gGw);
    }

    public void onChangeSkinType() {
        if (this.gGw != null) {
            this.gGw.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.gYc != null && this.gGz != null && this.gGw != null) {
            this.gGz.clear();
            this.gGz.add(new g(1, getString(this.gYc.bOe() == 1 ? R.string.cancel_top : R.string.f1281top, new Object[0]), this.gGw));
            this.gGz.add(new g(2, getString(R.string.delete, new Object[0]), this.gGw));
            this.gGw.aD(this.gGz);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(h hVar) {
        this.gYc = hVar;
        createView();
    }
}
