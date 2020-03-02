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
    private final k fLO;
    private final List<g> fLR;
    private final k.c fLW;
    private ViewEventCenter fTk;
    private com.baidu.tieba.enterForum.data.f fZX;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.fLW = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.fTk.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.fZX, null, null));
                } else if (i == 1) {
                    d.this.fTk.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.fZX, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fTk = viewEventCenter;
        this.fLR = new ArrayList();
        this.fLO = new k(this.mContext);
        this.fLO.a(this.fLW);
        a(this.fLO);
    }

    public void onChangeSkinType() {
        if (this.fLO != null) {
            this.fLO.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.fZX != null && this.fLR != null && this.fLO != null) {
            this.fLR.clear();
            this.fLR.add(new g(1, getString(this.fZX.bxQ() == 1 ? R.string.cancel_top : R.string.f1281top, new Object[0]), this.fLO));
            this.fLR.add(new g(2, getString(R.string.delete, new Object[0]), this.fLO));
            this.fLO.az(this.fLR);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.fZX = fVar;
        createView();
    }
}
