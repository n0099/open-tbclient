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
    private final k fMb;
    private final List<g> fMe;
    private final k.c fMj;
    private ViewEventCenter fTx;
    private com.baidu.tieba.enterForum.data.f gak;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.fMj = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, (int) R.string.network_not_available);
                } else if (i == 2) {
                    d.this.fTx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.gak, null, null));
                } else if (i == 1) {
                    d.this.fTx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.gak, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fTx = viewEventCenter;
        this.fMe = new ArrayList();
        this.fMb = new k(this.mContext);
        this.fMb.a(this.fMj);
        a(this.fMb);
    }

    public void onChangeSkinType() {
        if (this.fMb != null) {
            this.fMb.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.gak != null && this.fMe != null && this.fMb != null) {
            this.fMe.clear();
            this.fMe.add(new g(1, getString(this.gak.bxR() == 1 ? R.string.cancel_top : R.string.f1281top, new Object[0]), this.fMb));
            this.fMe.add(new g(2, getString(R.string.delete, new Object[0]), this.fMb));
            this.fMb.az(this.fMe);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.gak = fVar;
        createView();
    }
}
