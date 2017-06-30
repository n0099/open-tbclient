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
public class bn extends p<bo, bp> {
    private final LinkedList<com.baidu.tbadk.i.f> ceM;
    private final LinkedList<RelativeLayout> ceN;

    public bn(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.ceM = new LinkedList<>();
        this.ceN = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public bp onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.i.f fVar = new com.baidu.tbadk.i.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(w.f.ds140));
        fVar.J(relativeLayout);
        this.ceM.add(fVar);
        this.ceN.add(relativeLayout);
        bp bpVar = new bp(relativeLayout);
        bpVar.ceP = fVar;
        return bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bo boVar, bp bpVar) {
        if (bpVar != null && bpVar.ceP != null) {
            bpVar.ceP.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.p
    public void release() {
        super.release();
        if (this.ceM.size() != 0 && this.ceN.size() == this.ceM.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ceM.size()) {
                    break;
                }
                this.ceM.get(i2).I(this.ceN.get(i2));
                i = i2 + 1;
            }
        }
        this.ceM.clear();
        this.ceN.clear();
    }
}
