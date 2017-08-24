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
public class u extends d<v, w> {
    private final LinkedList<com.baidu.tbadk.k.f> cmt;
    private final LinkedList<RelativeLayout> cmu;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cmt = new LinkedList<>();
        this.cmu = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.k.f fVar = new com.baidu.tbadk.k.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.f.ds140));
        fVar.J(relativeLayout);
        this.cmt.add(fVar);
        this.cmu.add(relativeLayout);
        w wVar = new w(relativeLayout);
        wVar.cmw = fVar;
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        if (wVar != null && wVar.cmw != null) {
            wVar.cmw.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.d
    public void release() {
        super.release();
        if (this.cmt.size() != 0 && this.cmu.size() == this.cmt.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.cmt.size()) {
                    break;
                }
                this.cmt.get(i2).I(this.cmu.get(i2));
                i = i2 + 1;
            }
        }
        this.cmt.clear();
        this.cmu.clear();
    }
}
