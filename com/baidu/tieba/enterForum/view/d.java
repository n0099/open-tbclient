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
    private final k fLM;
    private final List<g> fLP;
    private final k.c fLU;
    private ViewEventCenter fTi;
    private com.baidu.tieba.enterForum.data.f fZV;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.fLU = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.fTi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.fZV, null, null));
                } else if (i == 1) {
                    d.this.fTi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.fZV, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fTi = viewEventCenter;
        this.fLP = new ArrayList();
        this.fLM = new k(this.mContext);
        this.fLM.a(this.fLU);
        a(this.fLM);
    }

    public void onChangeSkinType() {
        if (this.fLM != null) {
            this.fLM.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.fZV != null && this.fLP != null && this.fLM != null) {
            this.fLP.clear();
            this.fLP.add(new g(1, getString(this.fZV.bxO() == 1 ? R.string.cancel_top : R.string.f1282top, new Object[0]), this.fLM));
            this.fLP.add(new g(2, getString(R.string.delete, new Object[0]), this.fLM));
            this.fLM.az(this.fLP);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.fZV = fVar;
        createView();
    }
}
