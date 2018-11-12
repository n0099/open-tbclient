package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class u extends h<v, w> {
    private final LinkedList<com.baidu.tbadk.k.f> dEM;
    private final LinkedList<RelativeLayout> dEN;
    private int mItemHeight;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dEM = new LinkedList<>();
        this.dEN = new LinkedList<>();
        this.mItemHeight = (com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.mItemHeight;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(17);
        com.baidu.tbadk.k.f fVar = new com.baidu.tbadk.k.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds140));
        fVar.attachView(relativeLayout);
        this.dEM.add(fVar);
        this.dEN.add(relativeLayout);
        w wVar = new w(relativeLayout);
        wVar.dEP = fVar;
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        if (wVar != null && wVar.dEP != null) {
            wVar.dEP.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        if (this.dEM.size() != 0 && this.dEN.size() == this.dEM.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dEM.size()) {
                    break;
                }
                this.dEM.get(i2).dettachView(this.dEN.get(i2));
                i = i2 + 1;
            }
        }
        this.dEM.clear();
        this.dEN.clear();
    }
}
