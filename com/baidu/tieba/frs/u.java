package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class u extends h<v, w> {
    private final LinkedList<com.baidu.tbadk.k.f> dpo;
    private final LinkedList<RelativeLayout> dpp;
    private int mItemHeight;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dpo = new LinkedList<>();
        this.dpp = new LinkedList<>();
        this.mItemHeight = (com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.mItemHeight;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(17);
        com.baidu.tbadk.k.f fVar = new com.baidu.tbadk.k.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(f.e.ds140));
        fVar.attachView(relativeLayout);
        this.dpo.add(fVar);
        this.dpp.add(relativeLayout);
        w wVar = new w(relativeLayout);
        wVar.dpr = fVar;
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        if (wVar != null && wVar.dpr != null) {
            wVar.dpr.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        if (this.dpo.size() != 0 && this.dpp.size() == this.dpo.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dpo.size()) {
                    break;
                }
                this.dpo.get(i2).Q(this.dpp.get(i2));
                i = i2 + 1;
            }
        }
        this.dpo.clear();
        this.dpp.clear();
    }
}
