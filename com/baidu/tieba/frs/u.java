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
    private final LinkedList<com.baidu.tbadk.k.f> dOI;
    private final LinkedList<RelativeLayout> dOJ;
    private int mItemHeight;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dOI = new LinkedList<>();
        this.dOJ = new LinkedList<>();
        this.mItemHeight = (com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.mItemHeight;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(17);
        com.baidu.tbadk.k.f fVar = new com.baidu.tbadk.k.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds140));
        fVar.attachView(relativeLayout);
        this.dOI.add(fVar);
        this.dOJ.add(relativeLayout);
        w wVar = new w(relativeLayout);
        wVar.dOL = fVar;
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        if (wVar != null && wVar.dOL != null) {
            wVar.dOL.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        if (this.dOI.size() != 0 && this.dOJ.size() == this.dOI.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dOI.size()) {
                    break;
                }
                this.dOI.get(i2).dettachView(this.dOJ.get(i2));
                i = i2 + 1;
            }
        }
        this.dOI.clear();
        this.dOJ.clear();
    }
}
