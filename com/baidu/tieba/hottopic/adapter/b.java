package com.baidu.tieba.hottopic.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.holder.HotRankListManualItemHolder;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.b, HotRankListManualItemHolder> {
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ca */
    public HotRankListManualItemHolder e(ViewGroup viewGroup) {
        return new HotRankListManualItemHolder(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (bVar != null) {
            a(hotRankListManualItemHolder);
            a(hotRankListManualItemHolder, bVar);
        }
        return view;
    }

    private void a(HotRankListManualItemHolder hotRankListManualItemHolder, final com.baidu.tieba.hottopic.data.b bVar) {
        if (hotRankListManualItemHolder != null && bVar != null) {
            String string = StringUtils.isNull(bVar.cRe()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_trend) : bVar.cRe();
            hotRankListManualItemHolder.knp.setText(bVar.cRd());
            hotRankListManualItemHolder.knn.setText(string);
            hotRankListManualItemHolder.knt.startLoad(bVar.cRc(), 10, false);
            if (StringUtils.isNull(bVar.getName())) {
                hotRankListManualItemHolder.kno.setVisibility(8);
                hotRankListManualItemHolder.knp.setPadding(0, 0, 0, 0);
            } else {
                hotRankListManualItemHolder.kno.setVisibility(0);
                hotRankListManualItemHolder.kno.setText(bVar.getName());
            }
            hotRankListManualItemHolder.knu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(bVar.getId()), bVar.getName(), "5")));
                    TiebaStatic.log(new aq("c10811").dW("obj_name", "" + bVar.getName()));
                }
            });
        }
    }

    private void a(HotRankListManualItemHolder hotRankListManualItemHolder) {
        if (hotRankListManualItemHolder != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (hotRankListManualItemHolder.akf != this.mSkinType) {
                hotRankListManualItemHolder.akf = this.mSkinType;
                ao.setBackgroundColor(hotRankListManualItemHolder.getView(), R.color.CAM_X0201);
                ao.setViewTextColor(hotRankListManualItemHolder.knn, R.color.CAM_X0109, 1);
                ao.setViewTextColor(hotRankListManualItemHolder.kno, R.color.CAM_X0105, 1);
                ao.setViewTextColor(hotRankListManualItemHolder.knp, R.color.CAM_X0108, 1);
                ao.setBackgroundColor(hotRankListManualItemHolder.knr, R.color.CAM_X0204);
                ao.setBackgroundColor(hotRankListManualItemHolder.kns, R.color.CAM_X0204);
                ao.setBackgroundResource(hotRankListManualItemHolder.knu, R.drawable.hot_topic_ranklist_bg);
            }
        }
    }
}
