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
import com.baidu.tbadk.core.util.aq;
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
    /* renamed from: bH */
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
            String string = StringUtils.isNull(bVar.cDC()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_trend) : bVar.cDC();
            aVar.jiX.setText(bVar.cDB());
            aVar.jiV.setText(string);
            aVar.jjb.startLoad(bVar.cDA(), 10, false);
            if (StringUtils.isNull(bVar.getName())) {
                aVar.jiW.setVisibility(8);
                aVar.jiX.setPadding(0, 0, 0, 0);
            } else {
                aVar.jiW.setVisibility(0);
                aVar.jiW.setText(bVar.getName());
            }
            aVar.jjc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(bVar.getId()), bVar.getName(), "5")));
                    TiebaStatic.log(new aq("c10811").dF("obj_name", "" + bVar.getName()));
                }
            });
        }
    }

    private void a(com.baidu.tieba.hottopic.a.a aVar) {
        if (aVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (aVar.aiX != this.mSkinType) {
                aVar.aiX = this.mSkinType;
                ap.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
                ap.setViewTextColor(aVar.jiV, R.color.cp_cont_d, 1);
                ap.setViewTextColor(aVar.jiW, R.color.cp_cont_b, 1);
                ap.setViewTextColor(aVar.jiX, R.color.cp_cont_c, 1);
                ap.setBackgroundColor(aVar.jiZ, R.color.cp_bg_line_c);
                ap.setBackgroundColor(aVar.jja, R.color.cp_bg_line_c);
                ap.setBackgroundResource(aVar.jjc, R.drawable.hot_topic_ranklist_bg);
            }
        }
    }
}
