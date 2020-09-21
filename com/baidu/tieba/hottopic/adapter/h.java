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
/* loaded from: classes20.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.i, com.baidu.tieba.hottopic.a.d> {
    private HotTopicActivity jgc;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jgc = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
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
            if (this.jgc != null && dVar.aiX != this.mSkinType) {
                dVar.aiX = this.mSkinType;
                ap.setBackgroundColor(dVar.getView(), R.color.cp_bg_line_d);
                this.jgc.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.jgc.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.d dVar, com.baidu.tieba.hottopic.data.i iVar) {
        if (dVar != null && iVar != null) {
            dVar.jjn.setText(StringUtils.isNull(iVar.jht) ? this.jgc.getResources().getString(R.string.pk_topic_default) : iVar.jht.trim());
            dVar.jjo.setText(at.cutStringWithSuffix(iVar.jhu.trim(), 32, StringHelper.STRING_MORE));
            dVar.jjo.setText(iVar.jhu.trim());
            dVar.jjp.setData(iVar, this.jgc);
            dVar.jjq.setText(iVar.jil.trim());
            dVar.jjr.setText(iVar.jio.trim());
        }
    }
}
