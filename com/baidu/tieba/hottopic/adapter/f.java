package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.g, com.baidu.tieba.hottopic.a.c> {
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public com.baidu.tieba.hottopic.a.c b(ViewGroup viewGroup) {
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
            if (cVar.ahx != this.mSkinType) {
                cVar.ahx = this.mSkinType;
                an.setBackgroundColor(cVar.getView(), R.color.cp_bg_line_d);
                an.setBackgroundColor(cVar.iFv, R.color.cp_bg_line_c);
                an.setViewTextColor(cVar.iFw, R.color.cp_cont_c, 1);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.c cVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (cVar == null || gVar == null || StringUtils.isNull(gVar.iDR)) {
            if (cVar != null) {
                cVar.iFw.setVisibility(8);
                return;
            }
            return;
        }
        cVar.iFw.setVisibility(0);
        cVar.iFw.setText(gVar.iDR);
    }
}
