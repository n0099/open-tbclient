package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bm extends p<bn, bo> {
    private final LinkedList<com.baidu.tbadk.i.f> bWE;
    private final LinkedList<RelativeLayout> bWF;

    public bm(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bWE = new LinkedList<>();
        this.bWF = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public bo onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.i.f fVar = new com.baidu.tbadk.i.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(w.f.ds140));
        fVar.I(relativeLayout);
        this.bWE.add(fVar);
        this.bWF.add(relativeLayout);
        bo boVar = new bo(relativeLayout);
        boVar.bWH = fVar;
        return boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bn bnVar, bo boVar) {
        if (boVar != null && boVar.bWH != null) {
            boVar.bWH.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.p
    public void release() {
        super.release();
        if (this.bWE.size() != 0 && this.bWF.size() == this.bWE.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bWE.size()) {
                    break;
                }
                this.bWE.get(i2).H(this.bWF.get(i2));
                i = i2 + 1;
            }
        }
        this.bWE.clear();
        this.bWF.clear();
    }
}
