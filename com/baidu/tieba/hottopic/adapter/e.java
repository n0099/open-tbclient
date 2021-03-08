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
import com.baidu.tieba.hottopic.holder.HotTopicIntervalItemHolder;
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.g, HotTopicIntervalItemHolder> {
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cb */
    public HotTopicIntervalItemHolder e(ViewGroup viewGroup) {
        return new HotTopicIntervalItemHolder(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        if (gVar != null && hotTopicIntervalItemHolder != null) {
            a(hotTopicIntervalItemHolder, view);
            a(hotTopicIntervalItemHolder, gVar);
        }
        return view;
    }

    private void a(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, View view) {
        if (hotTopicIntervalItemHolder != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (hotTopicIntervalItemHolder.aln != this.mSkinType) {
                hotTopicIntervalItemHolder.aln = this.mSkinType;
                ap.setBackgroundColor(hotTopicIntervalItemHolder.getView(), R.color.CAM_X0201);
                ap.setBackgroundColor(hotTopicIntervalItemHolder.kya, R.color.CAM_X0204);
                ap.setViewTextColor(hotTopicIntervalItemHolder.kyb, R.color.CAM_X0108, 1);
            }
        }
    }

    private void a(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, com.baidu.tieba.hottopic.data.g gVar) {
        if (hotTopicIntervalItemHolder == null || gVar == null || StringUtils.isNull(gVar.kwv)) {
            if (hotTopicIntervalItemHolder != null) {
                hotTopicIntervalItemHolder.kyb.setVisibility(8);
                return;
            }
            return;
        }
        hotTopicIntervalItemHolder.kyb.setVisibility(0);
        hotTopicIntervalItemHolder.kyb.setText(gVar.kwv);
    }
}
