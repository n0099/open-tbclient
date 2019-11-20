package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.k;
/* loaded from: classes6.dex */
public class j {
    private a dMq;
    private boolean dMr;
    private k dMs;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.dMq = aVar;
    }

    public void release() {
        this.dMr = false;
        aAk();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.g gVar, final int i) {
        if (!this.dMr && TbadkCoreApplication.isLogin() && this.dMq != null && this.dMs == null) {
            this.dMs = new k(this.mPageContext.getPageActivity());
            this.dMs.show();
            this.dMs.a(new k.a() { // from class: com.baidu.tieba.ala.guardclub.j.1
                @Override // com.baidu.tieba.ala.guardclub.k.a
                public void onConfirm() {
                    if (j.this.dMq != null) {
                        j.this.dMq.c(gVar, i);
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

    private void aAk() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.dMs != null) {
            this.dMs.dismiss();
            this.dMs = null;
        }
    }
}
