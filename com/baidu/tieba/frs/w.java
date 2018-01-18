package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class w extends g<x, y> {
    private final LinkedList<com.baidu.tbadk.j.f> dDL;
    private final LinkedList<RelativeLayout> dDM;
    private int mItemHeight;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dDL = new LinkedList<>();
        this.dDM = new LinkedList<>();
        this.mItemHeight = (com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public y onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.mItemHeight;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(17);
        com.baidu.tbadk.j.f fVar = new com.baidu.tbadk.j.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.e.ds140));
        fVar.attachView(relativeLayout);
        this.dDL.add(fVar);
        this.dDM.add(relativeLayout);
        y yVar = new y(relativeLayout);
        yVar.dDO = fVar;
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, x xVar, y yVar) {
        if (yVar != null && yVar.dDO != null) {
            yVar.dDO.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.g
    public void release() {
        super.release();
        if (this.dDL.size() != 0 && this.dDM.size() == this.dDL.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dDL.size()) {
                    break;
                }
                this.dDL.get(i2).bk(this.dDM.get(i2));
                i = i2 + 1;
            }
        }
        this.dDL.clear();
        this.dDM.clear();
    }
}
