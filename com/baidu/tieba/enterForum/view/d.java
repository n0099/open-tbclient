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
    private final k fMJ;
    private final List<g> fMM;
    private final k.c fMR;
    private ViewEventCenter fUg;
    private com.baidu.tieba.enterForum.data.f gaS;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.fMR = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.fUg.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.gaS, null, null));
                } else if (i == 1) {
                    d.this.fUg.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.gaS, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fUg = viewEventCenter;
        this.fMM = new ArrayList();
        this.fMJ = new k(this.mContext);
        this.fMJ.a(this.fMR);
        a(this.fMJ);
    }

    public void onChangeSkinType() {
        if (this.fMJ != null) {
            this.fMJ.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.gaS != null && this.fMM != null && this.fMJ != null) {
            this.fMM.clear();
            this.fMM.add(new g(1, getString(this.gaS.bxW() == 1 ? R.string.cancel_top : R.string.f1281top, new Object[0]), this.fMJ));
            this.fMM.add(new g(2, getString(R.string.delete, new Object[0]), this.fMJ));
            this.fMJ.az(this.fMM);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.gaS = fVar;
        createView();
    }
}
