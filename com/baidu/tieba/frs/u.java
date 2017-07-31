package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class u extends d<v, w> {
    private final LinkedList<com.baidu.tbadk.k.f> clG;
    private final LinkedList<RelativeLayout> clH;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.clG = new LinkedList<>();
        this.clH = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.k.f fVar = new com.baidu.tbadk.k.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.f.ds140));
        fVar.J(relativeLayout);
        this.clG.add(fVar);
        this.clH.add(relativeLayout);
        w wVar = new w(relativeLayout);
        wVar.clJ = fVar;
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        if (wVar != null && wVar.clJ != null) {
            wVar.clJ.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.d
    public void release() {
        super.release();
        if (this.clG.size() != 0 && this.clH.size() == this.clG.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.clG.size()) {
                    break;
                }
                this.clG.get(i2).I(this.clH.get(i2));
                i = i2 + 1;
            }
        }
        this.clG.clear();
        this.clH.clear();
    }
}
