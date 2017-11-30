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
    private final LinkedList<com.baidu.tbadk.j.f> cJP;
    private final LinkedList<RelativeLayout> cJQ;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cJP = new LinkedList<>();
        this.cJQ = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public x onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.j.f fVar = new com.baidu.tbadk.j.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.e.ds140));
        fVar.P(relativeLayout);
        this.cJP.add(fVar);
        this.cJQ.add(relativeLayout);
        x xVar = new x(relativeLayout);
        xVar.cJS = fVar;
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, w wVar, x xVar) {
        if (xVar != null && xVar.cJS != null) {
            xVar.cJS.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.d
    public void release() {
        super.release();
        if (this.cJP.size() != 0 && this.cJQ.size() == this.cJP.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.cJP.size()) {
                    break;
                }
                this.cJP.get(i2).O(this.cJQ.get(i2));
                i = i2 + 1;
            }
        }
        this.cJP.clear();
        this.cJQ.clear();
    }
}
