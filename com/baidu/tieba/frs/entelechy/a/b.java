package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends bw<ax, a> {
    private TbPageContext<?> DV;
    private boolean mIsFromCDN;
    private int mSkinType;

    public b(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.DV = baseActivity.getPageContext();
    }

    public void m(View.OnClickListener onClickListener) {
    }

    public void l(View.OnClickListener onClickListener) {
    }

    public void n(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.frs.bw
    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public a b(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.card.d(this.DV));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        int i2;
        String str;
        if (this.bek == null || !(axVar instanceof com.baidu.tbadk.core.data.c)) {
            return null;
        }
        if (!(axVar instanceof com.baidu.tbadk.core.data.c)) {
            i2 = 0;
            str = "";
        } else {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) axVar;
            if (this.bek == null || !(this.bek instanceof FrsActivity)) {
                i2 = 0;
                str = "";
            } else {
                str = ((FrsActivity) this.bek).getForumId();
                i2 = ((FrsActivity) this.bek).getPn();
            }
            if (this.bek != null && (this.bek instanceof FrsActivity)) {
                ((FrsActivity) this.bek).Qd().RF();
            }
            if (this.bek != null && (this.bek instanceof ff)) {
                ((ff) this.bek).RF();
            }
            if (!cVar.Nc && this.bek != null) {
                cVar.Nc = true;
                if (this.bek instanceof FrsActivity) {
                    ((FrsActivity) this.bek).a(cVar, "show");
                    ((FrsActivity) this.bek).b(cVar, "show");
                }
                if (this.bek instanceof ff) {
                    ((ff) this.bek).a(cVar, "show");
                    ((ff) this.bek).b(cVar, "show");
                }
            }
        }
        this.DV.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.DV.getLayoutMode().x(aVar.getView());
        at.k(aVar.getView(), t.f.addresslist_item_bg);
        com.baidu.tieba.card.a.d dVar = new com.baidu.tieba.card.a.d((com.baidu.tbadk.core.data.c) axVar);
        dVar.aRF = str;
        dVar.mPn = i2;
        aVar.boe.setFromCDN(this.mIsFromCDN);
        aVar.boe.d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        aVar.boe.a(dVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public com.baidu.tieba.card.d boe;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.boe = dVar;
        }
    }
}
