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
/* loaded from: classes21.dex */
public class d extends i {
    private final k iaR;
    private final List<g> iaU;
    private final k.c iaZ;
    private ViewEventCenter iiB;
    private com.baidu.tieba.enterForum.data.f isK;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.iaZ = new k.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                d.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.network_not_available);
                } else if (i == 2) {
                    d.this.iiB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.isK, null, null));
                } else if (i == 1) {
                    d.this.iiB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.isK, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.iiB = viewEventCenter;
        this.iaU = new ArrayList();
        this.iaR = new k(this.mContext);
        this.iaR.a(this.iaZ);
        a(this.iaR);
    }

    public void onChangeSkinType() {
        if (this.iaR != null) {
            this.iaR.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.isK != null && this.iaU != null && this.iaR != null) {
            this.iaU.clear();
            this.iaU.add(new g(1, getString(this.isK.cqF() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.iaR));
            this.iaU.add(new g(2, getString(R.string.delete, new Object[0]), this.iaR));
            this.iaR.br(this.iaU);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.f fVar) {
        this.isK = fVar;
        createView();
    }
}
