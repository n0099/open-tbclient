package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes21.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.g, com.baidu.tieba.hottopic.a.c> {
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public com.baidu.tieba.hottopic.a.c c(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.a.c(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.g gVar, com.baidu.tieba.hottopic.a.c cVar) {
        if (gVar != null && cVar != null) {
            a(cVar, view);
            a(cVar, gVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.a.c cVar, View view) {
        if (cVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (cVar.aku != this.mSkinType) {
                cVar.aku = this.mSkinType;
                ap.setBackgroundColor(cVar.getView(), R.color.CAM_X0201);
                ap.setBackgroundColor(cVar.keU, R.color.CAM_X0204);
                ap.setViewTextColor(cVar.keV, R.color.CAM_X0108, 1);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.c cVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (cVar == null || gVar == null || StringUtils.isNull(gVar.kdp)) {
            if (cVar != null) {
                cVar.keV.setVisibility(8);
                return;
            }
            return;
        }
        cVar.keV.setVisibility(0);
        cVar.keV.setText(gVar.kdp);
    }
}
