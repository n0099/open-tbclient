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
/* loaded from: classes7.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.i, HotTopicPkItemHolder> {
    private HotTopicActivity kuR;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kuR = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
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
            if (this.kuR != null && hotTopicPkItemHolder.aln != this.mSkinType) {
                hotTopicPkItemHolder.aln = this.mSkinType;
                ap.setBackgroundColor(hotTopicPkItemHolder.getView(), R.color.CAM_X0201);
                this.kuR.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.kuR.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(HotTopicPkItemHolder hotTopicPkItemHolder, com.baidu.tieba.hottopic.data.i iVar) {
        if (hotTopicPkItemHolder != null && iVar != null) {
            hotTopicPkItemHolder.kyc.setText(StringUtils.isNull(iVar.kwi) ? this.kuR.getResources().getString(R.string.pk_topic_default) : iVar.kwi.trim());
            hotTopicPkItemHolder.kyd.setText(au.cutStringWithSuffix(iVar.kwj.trim(), 32, StringHelper.STRING_MORE));
            hotTopicPkItemHolder.kyd.setText(iVar.kwj.trim());
            hotTopicPkItemHolder.kye.setData(iVar, this.kuR);
            hotTopicPkItemHolder.kyf.setText(iVar.kxa.trim());
            hotTopicPkItemHolder.kyg.setText(iVar.kxd.trim());
        }
    }
}
