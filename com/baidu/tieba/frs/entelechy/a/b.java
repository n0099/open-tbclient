package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.dk;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends bj<az, a> {
    private TbPageContext<?> Ea;
    private boolean mIsFromCDN;
    private int mSkinType;

    public b(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.Ea = baseActivity.getPageContext();
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
    /* renamed from: y */
    public a a(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.card.d(this.Ea));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, az azVar, a aVar) {
        int i2;
        String str;
        if (this.bkc == null || !(azVar instanceof com.baidu.tbadk.core.data.b)) {
            return null;
        }
        if (!(azVar instanceof com.baidu.tbadk.core.data.b)) {
            i2 = 0;
            str = "";
        } else {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) azVar;
            if (this.bkc == null || !(this.bkc instanceof FrsActivity)) {
                i2 = 0;
                str = "";
            } else {
                str = ((FrsActivity) this.bkc).getForumId();
                i2 = ((FrsActivity) this.bkc).getPn();
            }
            if (this.bkc != null && (this.bkc instanceof FrsActivity)) {
                ((FrsActivity) this.bkc).VG().WZ();
            }
            if (this.bkc != null && (this.bkc instanceof dk)) {
                ((dk) this.bkc).WZ();
            }
            if (!bVar.MX && this.bkc != null) {
                bVar.MX = true;
                if (this.bkc instanceof FrsActivity) {
                    ((FrsActivity) this.bkc).a(bVar, "show");
                    ((FrsActivity) this.bkc).b(bVar, "show");
                }
                if (this.bkc instanceof dk) {
                    ((dk) this.bkc).a(bVar, "show");
                    ((dk) this.bkc).b(bVar, "show");
                }
            }
        }
        this.Ea.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Ea.getLayoutMode().w(aVar.getView());
        av.k(aVar.getView(), u.f.addresslist_item_bg);
        com.baidu.tieba.card.a.d dVar = new com.baidu.tieba.card.a.d((com.baidu.tbadk.core.data.b) azVar);
        dVar.aIZ = str;
        dVar.mPn = i2;
        aVar.bIC.setFromCDN(this.mIsFromCDN);
        aVar.bIC.d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.bIC.a(dVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public com.baidu.tieba.card.d bIC;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.bIC = dVar;
        }
    }
}
