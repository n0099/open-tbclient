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
    private h gJf;
    private final k.c grE;
    private final k grw;
    private final List<g> grz;
    private ViewEventCenter gyU;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.grE = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.gyU.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.gJf, null, null));
                } else if (i == 1) {
                    d.this.gyU.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.gJf, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gyU = viewEventCenter;
        this.grz = new ArrayList();
        this.grw = new k(this.mContext);
        this.grw.a(this.grE);
        a(this.grw);
    }

    public void onChangeSkinType() {
        if (this.grw != null) {
            this.grw.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.gJf != null && this.grz != null && this.grw != null) {
            this.grz.clear();
            this.grz.add(new g(1, getString(this.gJf.bHI() == 1 ? R.string.cancel_top : R.string.f1279top, new Object[0]), this.grw));
            this.grz.add(new g(2, getString(R.string.delete, new Object[0]), this.grw));
            this.grw.aI(this.grz);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(h hVar) {
        this.gJf = hVar;
        createView();
    }
}
