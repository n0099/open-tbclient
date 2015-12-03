package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.e, com.baidu.tieba.hottopic.b.c> {
    private HotTopicActivity bCu;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bCu = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public com.baidu.tieba.hottopic.b.c a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.c(LayoutInflater.from(this.mContext).inflate(n.g.hot_topic_pk_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.e eVar, com.baidu.tieba.hottopic.b.c cVar) {
        if (eVar != null && cVar != null) {
            a(cVar, view);
            a(cVar, eVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.c cVar, View view) {
        if (cVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.bCu != null && cVar.afY != this.mSkinType) {
                cVar.afY = this.mSkinType;
                as.j(cVar.getView(), n.c.cp_bg_line_d);
                this.bCu.getLayoutMode().af(this.mSkinType == 1);
                this.bCu.getLayoutMode().k(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.c cVar, com.baidu.tieba.hottopic.data.e eVar) {
        if (cVar != null && eVar != null) {
            cVar.bEN.setText(StringUtils.isNull(eVar.bDw) ? this.bCu.getResources().getString(n.i.pk_topic_default) : eVar.bDw.trim());
            cVar.bEO.setText(ax.d(eVar.bDx.trim(), 32, "..."));
            cVar.bEO.setText(eVar.bDx.trim());
            cVar.bEP.a(eVar, this.bCu);
            cVar.bEQ.setText(eVar.bDU.trim());
            cVar.bER.setText(eVar.bDX.trim());
        }
    }
}
