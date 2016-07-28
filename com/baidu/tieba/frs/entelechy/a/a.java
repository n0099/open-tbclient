package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.dk;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends bj<be, C0057a> {
    private TbPageContext<?> EA;
    private boolean mIsFromCDN;
    private int mSkinType;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.EA = baseActivity.getPageContext();
    }

    public void n(View.OnClickListener onClickListener) {
    }

    public void m(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.frs.bj
    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public C0057a a(ViewGroup viewGroup) {
        try {
            return new C0057a(new com.baidu.tieba.card.c(this.EA));
        } catch (VerifyError e) {
            BdLog.e(e.toString());
            return new C0057a(new View(this.EA.getPageActivity()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, be beVar, C0057a c0057a) {
        int i2;
        String str;
        if (this.bem == null || !(beVar instanceof com.baidu.tbadk.core.data.b)) {
            return null;
        }
        if (c0057a.bKf == null) {
            return c0057a.getView();
        }
        if (!(beVar instanceof com.baidu.tbadk.core.data.b)) {
            i2 = 0;
            str = "";
        } else {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) beVar;
            if (this.bem == null || !(this.bem instanceof FrsActivity)) {
                i2 = 0;
                str = "";
            } else {
                str = ((FrsActivity) this.bem).getForumId();
                i2 = ((FrsActivity) this.bem).getPn();
            }
            if (this.bem != null && (this.bem instanceof FrsActivity)) {
                ((FrsActivity) this.bem).VY().Xr();
            }
            if (this.bem != null && (this.bem instanceof dk)) {
                ((dk) this.bem).Xr();
            }
            if (!bVar.MV && this.bem != null) {
                bVar.MV = true;
                if (this.bem instanceof FrsActivity) {
                    ((FrsActivity) this.bem).a(bVar, "show");
                    ((FrsActivity) this.bem).b(bVar, "show");
                }
                if (this.bem instanceof dk) {
                    ((dk) this.bem).a(bVar, "show");
                    ((dk) this.bem).b(bVar, "show");
                }
            }
        }
        this.EA.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
        this.EA.getLayoutMode().w(c0057a.getView());
        av.k(c0057a.getView(), u.f.addresslist_item_bg);
        com.baidu.tieba.card.a.d dVar = new com.baidu.tieba.card.a.d((com.baidu.tbadk.core.data.b) beVar);
        dVar.aeq = str;
        dVar.mPn = i2;
        c0057a.bKf.setFromCDN(this.mIsFromCDN);
        c0057a.bKf.d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        c0057a.bKf.a(dVar);
        return c0057a.getView();
    }

    /* renamed from: com.baidu.tieba.frs.entelechy.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a extends y.a {
        public com.baidu.tieba.card.c bKf;

        public C0057a(com.baidu.tieba.card.c cVar) {
            super(cVar.getView());
            this.bKf = cVar;
        }

        public C0057a(View view) {
            super(view);
        }
    }
}
