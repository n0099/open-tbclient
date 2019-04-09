package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.f;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends g {
    private ViewEventCenter eAL;
    private com.baidu.tieba.enterForum.data.d eGU;
    private final i eka;
    private final List<f> ekd;
    private final i.c eki;
    private Context mContext;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.eki = new i.c() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                d.this.dismiss();
                if (!j.kY()) {
                    l.showToast(d.this.mContext, d.j.network_not_available);
                } else if (i == 2) {
                    d.this.eAL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, d.this.eGU, null, null));
                } else if (i == 1) {
                    d.this.eAL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, d.this.eGU, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eAL = viewEventCenter;
        this.ekd = new ArrayList();
        this.eka = new i(this.mContext);
        this.eka.a(this.eki);
        setContentView(this.eka.abh());
    }

    public void onChangeSkinType() {
        if (this.eka != null) {
            this.eka.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.eGU != null && this.ekd != null && this.eka != null) {
            this.ekd.clear();
            this.ekd.add(new f(1, getString(this.eGU.aWi() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.eka));
            this.ekd.add(new f(2, getString(d.j.delete, new Object[0]), this.eka));
            this.eka.P(this.ekd);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void c(com.baidu.tieba.enterForum.data.d dVar) {
        this.eGU = dVar;
        createView();
    }
}
