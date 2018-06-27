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
public class u extends h<v, w> {
    private final LinkedList<com.baidu.tbadk.j.f> dmy;
    private final LinkedList<RelativeLayout> dmz;
    private int mItemHeight;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dmy = new LinkedList<>();
        this.dmz = new LinkedList<>();
        this.mItemHeight = (com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.mItemHeight;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(17);
        com.baidu.tbadk.j.f fVar = new com.baidu.tbadk.j.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.e.ds140));
        fVar.attachView(relativeLayout);
        this.dmy.add(fVar);
        this.dmz.add(relativeLayout);
        w wVar = new w(relativeLayout);
        wVar.dmB = fVar;
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        if (wVar != null && wVar.dmB != null) {
            wVar.dmB.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        if (this.dmy.size() != 0 && this.dmz.size() == this.dmy.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dmy.size()) {
                    break;
                }
                this.dmy.get(i2).Q(this.dmz.get(i2));
                i = i2 + 1;
            }
        }
        this.dmy.clear();
        this.dmz.clear();
    }
}
