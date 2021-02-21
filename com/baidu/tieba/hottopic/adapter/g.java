package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.HotTopicPkItemHolder;
/* loaded from: classes8.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.i, HotTopicPkItemHolder> {
    private HotTopicActivity ksP;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.ksP = hotTopicActivity;
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
            if (this.ksP != null && hotTopicPkItemHolder.ajU != this.mSkinType) {
                hotTopicPkItemHolder.ajU = this.mSkinType;
                ap.setBackgroundColor(hotTopicPkItemHolder.getView(), R.color.CAM_X0201);
                this.ksP.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.ksP.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(HotTopicPkItemHolder hotTopicPkItemHolder, com.baidu.tieba.hottopic.data.i iVar) {
        if (hotTopicPkItemHolder != null && iVar != null) {
            hotTopicPkItemHolder.kwa.setText(StringUtils.isNull(iVar.kug) ? this.ksP.getResources().getString(R.string.pk_topic_default) : iVar.kug.trim());
            hotTopicPkItemHolder.kwb.setText(au.cutStringWithSuffix(iVar.kuh.trim(), 32, StringHelper.STRING_MORE));
            hotTopicPkItemHolder.kwb.setText(iVar.kuh.trim());
            hotTopicPkItemHolder.kwc.setData(iVar, this.ksP);
            hotTopicPkItemHolder.kwd.setText(iVar.kuY.trim());
            hotTopicPkItemHolder.kwe.setText(iVar.kvb.trim());
        }
    }
}
