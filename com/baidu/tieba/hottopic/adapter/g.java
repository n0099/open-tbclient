package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.HotTopicPkItemHolder;
/* loaded from: classes7.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.i, HotTopicPkItemHolder> {
    private HotTopicActivity kku;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kku = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public HotTopicPkItemHolder e(ViewGroup viewGroup) {
        return new HotTopicPkItemHolder(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_pk_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.i iVar, HotTopicPkItemHolder hotTopicPkItemHolder) {
        if (iVar != null && hotTopicPkItemHolder != null) {
            a(hotTopicPkItemHolder, view);
            a(hotTopicPkItemHolder, iVar);
        }
        return view;
    }

    private void a(HotTopicPkItemHolder hotTopicPkItemHolder, View view) {
        if (hotTopicPkItemHolder != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.kku != null && hotTopicPkItemHolder.akf != this.mSkinType) {
                hotTopicPkItemHolder.akf = this.mSkinType;
                ao.setBackgroundColor(hotTopicPkItemHolder.getView(), R.color.CAM_X0201);
                this.kku.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.kku.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(HotTopicPkItemHolder hotTopicPkItemHolder, com.baidu.tieba.hottopic.data.i iVar) {
        if (hotTopicPkItemHolder != null && iVar != null) {
            hotTopicPkItemHolder.knF.setText(StringUtils.isNull(iVar.klL) ? this.kku.getResources().getString(R.string.pk_topic_default) : iVar.klL.trim());
            hotTopicPkItemHolder.knG.setText(at.cutStringWithSuffix(iVar.klM.trim(), 32, StringHelper.STRING_MORE));
            hotTopicPkItemHolder.knG.setText(iVar.klM.trim());
            hotTopicPkItemHolder.knH.setData(iVar, this.kku);
            hotTopicPkItemHolder.knI.setText(iVar.kmD.trim());
            hotTopicPkItemHolder.knJ.setText(iVar.kmG.trim());
        }
    }
}
