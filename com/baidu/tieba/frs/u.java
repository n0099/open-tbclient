package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class u extends h<v, w> {
    private final LinkedList<com.baidu.tbadk.k.f> dvv;
    private final LinkedList<RelativeLayout> dvw;
    private int mItemHeight;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dvv = new LinkedList<>();
        this.dvw = new LinkedList<>();
        this.mItemHeight = (com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds90);
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
        com.baidu.tbadk.k.f fVar = new com.baidu.tbadk.k.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds140));
        fVar.attachView(relativeLayout);
        this.dvv.add(fVar);
        this.dvw.add(relativeLayout);
        w wVar = new w(relativeLayout);
        wVar.dvy = fVar;
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        if (wVar != null && wVar.dvy != null) {
            wVar.dvy.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        if (this.dvv.size() != 0 && this.dvw.size() == this.dvv.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dvv.size()) {
                    break;
                }
                this.dvv.get(i2).ad(this.dvw.get(i2));
                i = i2 + 1;
            }
        }
        this.dvv.clear();
        this.dvw.clear();
    }
}
