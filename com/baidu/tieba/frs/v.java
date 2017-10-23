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
public class v extends d<w, x> {
    private final LinkedList<com.baidu.tbadk.j.f> csV;
    private final LinkedList<RelativeLayout> csW;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.csV = new LinkedList<>();
        this.csW = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public x onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.j.f fVar = new com.baidu.tbadk.j.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.f.ds140));
        fVar.P(relativeLayout);
        this.csV.add(fVar);
        this.csW.add(relativeLayout);
        x xVar = new x(relativeLayout);
        xVar.csY = fVar;
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, w wVar, x xVar) {
        if (xVar != null && xVar.csY != null) {
            xVar.csY.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.d
    public void release() {
        super.release();
        if (this.csV.size() != 0 && this.csW.size() == this.csV.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.csV.size()) {
                    break;
                }
                this.csV.get(i2).O(this.csW.get(i2));
                i = i2 + 1;
            }
        }
        this.csV.clear();
        this.csW.clear();
    }
}
