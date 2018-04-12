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
public class s extends f<t, u> {
    private final LinkedList<com.baidu.tbadk.j.f> cZV;
    private final LinkedList<RelativeLayout> cZW;
    private int mItemHeight;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cZV = new LinkedList<>();
        this.cZW = new LinkedList<>();
        this.mItemHeight = (com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public u onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.mItemHeight;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(17);
        com.baidu.tbadk.j.f fVar = new com.baidu.tbadk.j.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.e.ds140));
        fVar.attachView(relativeLayout);
        this.cZV.add(fVar);
        this.cZW.add(relativeLayout);
        u uVar = new u(relativeLayout);
        uVar.cZY = fVar;
        return uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, t tVar, u uVar) {
        if (uVar != null && uVar.cZY != null) {
            uVar.cZY.onChangeSkinType();
        }
        return view2;
    }

    @Override // com.baidu.tieba.frs.f
    public void release() {
        super.release();
        if (this.cZV.size() != 0 && this.cZW.size() == this.cZV.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.cZV.size()) {
                    break;
                }
                this.cZV.get(i2).P(this.cZW.get(i2));
                i = i2 + 1;
            }
        }
        this.cZV.clear();
        this.cZW.clear();
    }
}
