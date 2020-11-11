package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes21.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.i, com.baidu.tieba.hottopic.a.d> {
    private HotTopicActivity jNy;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jNy = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public com.baidu.tieba.hottopic.a.d c(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.a.d(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_pk_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.i iVar, com.baidu.tieba.hottopic.a.d dVar) {
        if (iVar != null && dVar != null) {
            a(dVar, view);
            a(dVar, iVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.a.d dVar, View view) {
        if (dVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.jNy != null && dVar.ajq != this.mSkinType) {
                dVar.ajq = this.mSkinType;
                ap.setBackgroundColor(dVar.getView(), R.color.cp_bg_line_d);
                this.jNy.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.jNy.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.d dVar, com.baidu.tieba.hottopic.data.i iVar) {
        if (dVar != null && iVar != null) {
            dVar.jQI.setText(StringUtils.isNull(iVar.jOP) ? this.jNy.getResources().getString(R.string.pk_topic_default) : iVar.jOP.trim());
            dVar.jQJ.setText(at.cutStringWithSuffix(iVar.jOQ.trim(), 32, StringHelper.STRING_MORE));
            dVar.jQJ.setText(iVar.jOQ.trim());
            dVar.jQK.setData(iVar, this.jNy);
            dVar.jQL.setText(iVar.jPG.trim());
            dVar.jQM.setText(iVar.jPJ.trim());
        }
    }
}
