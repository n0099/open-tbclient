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
public class bl extends p<bm, bn> {
    private final LinkedList<com.baidu.tbadk.i.f> bQN;
    private final LinkedList<RelativeLayout> bQO;

    public bl(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bQN = new LinkedList<>();
        this.bQO = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public bn onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.i.f fVar = new com.baidu.tbadk.i.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(w.f.ds140));
        fVar.I(relativeLayout);
        this.bQN.add(fVar);
        this.bQO.add(relativeLayout);
        bn bnVar = new bn(relativeLayout);
        bnVar.bQQ = fVar;
        return bnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, bn bnVar) {
        if (bnVar != null && bnVar.bQQ != null) {
            bnVar.bQQ.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.p
    public void release() {
        super.release();
        if (this.bQN.size() != 0 && this.bQO.size() == this.bQN.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bQN.size()) {
                    break;
                }
                this.bQN.get(i2).H(this.bQO.get(i2));
                i = i2 + 1;
            }
        }
        this.bQN.clear();
        this.bQO.clear();
    }
}
