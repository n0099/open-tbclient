package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.k;
/* loaded from: classes6.dex */
public class j {
    private a dNh;
    private boolean dNi;
    private k dNj;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.dNh = aVar;
    }

    public void release() {
        this.dNi = false;
        aAm();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.g gVar, final int i) {
        if (!this.dNi && TbadkCoreApplication.isLogin() && this.dNh != null && this.dNj == null) {
            this.dNj = new k(this.mPageContext.getPageActivity());
            this.dNj.show();
            this.dNj.a(new k.a() { // from class: com.baidu.tieba.ala.guardclub.j.1
                @Override // com.baidu.tieba.ala.guardclub.k.a
                public void onConfirm() {
                    if (j.this.dNh != null) {
                        j.this.dNh.c(gVar, i);
                    }
                    j.this.release();
                }

                @Override // com.baidu.tieba.ala.guardclub.k.a
                public void onCancel() {
                    j.this.release();
                }
            });
        }
    }

    private void aAm() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.dNj != null) {
            this.dNj.dismiss();
            this.dNj = null;
        }
    }
}
