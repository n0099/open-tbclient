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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.b, com.baidu.tieba.hottopic.a.a> {
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public com.baidu.tieba.hottopic.a.a c(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.a.a(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.b bVar, com.baidu.tieba.hottopic.a.a aVar) {
        if (bVar != null) {
            a(aVar);
            a(aVar, bVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.a.a aVar, final com.baidu.tieba.hottopic.data.b bVar) {
        if (aVar != null && bVar != null) {
            String string = StringUtils.isNull(bVar.cMA()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_trend) : bVar.cMA();
            aVar.jRc.setText(bVar.cMz());
            aVar.jRa.setText(string);
            aVar.jRg.startLoad(bVar.cMy(), 10, false);
            if (StringUtils.isNull(bVar.getName())) {
                aVar.jRb.setVisibility(8);
                aVar.jRc.setPadding(0, 0, 0, 0);
            } else {
                aVar.jRb.setVisibility(0);
                aVar.jRb.setText(bVar.getName());
            }
            aVar.jRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(bVar.getId()), bVar.getName(), "5")));
                    TiebaStatic.log(new ar("c10811").dR("obj_name", "" + bVar.getName()));
                }
            });
        }
    }

    private void a(com.baidu.tieba.hottopic.a.a aVar) {
        if (aVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (aVar.ajv != this.mSkinType) {
                aVar.ajv = this.mSkinType;
                ap.setBackgroundColor(aVar.getView(), R.color.CAM_X0201);
                ap.setViewTextColor(aVar.jRa, R.color.CAM_X0109, 1);
                ap.setViewTextColor(aVar.jRb, R.color.CAM_X0105, 1);
                ap.setViewTextColor(aVar.jRc, R.color.CAM_X0108, 1);
                ap.setBackgroundColor(aVar.jRe, R.color.CAM_X0204);
                ap.setBackgroundColor(aVar.jRf, R.color.CAM_X0204);
                ap.setBackgroundResource(aVar.jRh, R.drawable.hot_topic_ranklist_bg);
            }
        }
    }
}
