package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes15.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.i, com.baidu.tieba.hottopic.a.d> {
    private HotTopicActivity iIs;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iIs = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
    public com.baidu.tieba.hottopic.a.d b(ViewGroup viewGroup) {
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
            if (this.iIs != null && dVar.aho != this.mSkinType) {
                dVar.aho = this.mSkinType;
                ao.setBackgroundColor(dVar.getView(), R.color.cp_bg_line_d);
                this.iIs.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.iIs.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.d dVar, com.baidu.tieba.hottopic.data.i iVar) {
        if (dVar != null && iVar != null) {
            dVar.iLD.setText(StringUtils.isNull(iVar.iJK) ? this.iIs.getResources().getString(R.string.pk_topic_default) : iVar.iJK.trim());
            dVar.iLE.setText(as.cutStringWithSuffix(iVar.iJL.trim(), 32, StringHelper.STRING_MORE));
            dVar.iLE.setText(iVar.iJL.trim());
            dVar.iLF.setData(iVar, this.iIs);
            dVar.iLG.setText(iVar.iKB.trim());
            dVar.iLH.setText(iVar.iKE.trim());
        }
    }
}
