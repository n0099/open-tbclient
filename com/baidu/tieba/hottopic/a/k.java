package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.g, com.baidu.tieba.hottopic.b.e> {
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public com.baidu.tieba.hottopic.b.e b(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.e(LayoutInflater.from(this.mContext).inflate(t.h.hot_topic_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.g gVar, com.baidu.tieba.hottopic.b.e eVar) {
        if (gVar != null && eVar != null) {
            a(eVar, view);
            a(eVar, gVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.e eVar, View view) {
        if (eVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (eVar.ahU != this.mSkinType) {
                eVar.ahU = this.mSkinType;
                ar.l(eVar.getView(), t.d.cp_bg_line_d);
                ar.l(eVar.bMi, t.d.cp_bg_line_c);
                ar.b(eVar.bMj, t.d.cp_cont_c, 1);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.e eVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (eVar != null && gVar != null) {
            eVar.bMj.setText(gVar.bKP);
        }
    }
}
