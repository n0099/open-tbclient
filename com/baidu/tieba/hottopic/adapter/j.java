package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes15.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.m, com.baidu.tieba.hottopic.a.e> {
    private HotTopicActivity iIs;
    private a iIy;
    private z iIz;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iIy = new a();
        this.iIz = new z() { // from class: com.baidu.tieba.hottopic.adapter.j.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.hottopic.data.m)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    j.this.a((com.baidu.tieba.hottopic.data.m) qVar);
                }
            }
        };
        this.iIs = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public com.baidu.tieba.hottopic.a.e b(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.a.e(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_quality_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.m mVar, com.baidu.tieba.hottopic.a.e eVar) {
        if (mVar != null && eVar != null) {
            a(eVar, view);
            a(eVar, mVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.a.e eVar, View view) {
        if (eVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.iIs != null && eVar.aho != this.mSkinType) {
                eVar.aho = this.mSkinType;
                ao.setBackgroundResource(eVar.getView(), R.drawable.list_item_selector);
                ao.setViewTextColor(eVar.iLC, R.color.cp_cont_c, 1);
                ao.setViewTextColor(eVar.dJr, R.color.cp_cont_b, 1);
                ao.setViewTextColor(eVar.iLL, R.color.cp_cont_d, 1);
                ao.setBackgroundColor(eVar.iLJ, R.color.cp_bg_line_c);
                ao.setBackgroundColor(eVar.iLB, R.color.cp_bg_line_c);
                eVar.iLK.setImageDrawable(null);
                this.iIs.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.iIs.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.e eVar, com.baidu.tieba.hottopic.data.m mVar) {
        if (eVar != null && mVar != null) {
            if (mVar.cpr()) {
                eVar.iLB.setVisibility(0);
                eVar.iLC.setVisibility(0);
                eVar.iLJ.setVisibility(8);
                eVar.iLI.setVisibility(8);
                eVar.iLC.setText(mVar.iJK.trim());
                ao.setBackgroundColor(eVar.getView(), R.color.cp_bg_line_d);
                return;
            }
            eVar.iLB.setVisibility(8);
            eVar.iLC.setVisibility(8);
            eVar.iLJ.setVisibility(0);
            eVar.iLI.setVisibility(0);
            eVar.iLK.startLoad(mVar.dOZ, 10, false);
            eVar.dJr.setText(mVar.title.trim());
            eVar.iLL.setText(mVar.summary.trim());
            eVar.iLM.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}));
            eVar.iLN.setText(as.numberUniformFormat(mVar.iKU));
            eVar.iLO.setText(as.numFormatOver10000(mVar.replyNum));
            b(eVar, mVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.a.e eVar, com.baidu.tieba.hottopic.data.m mVar) {
        if (eVar != null && mVar != null && this.iIs != null) {
            a(this.iIz);
            this.iIy.eu(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}), String.valueOf(mVar.fid));
            eVar.iLM.setOnClickListener(this.iIy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private String fid;
        private String forumName;

        private a() {
        }

        public void eu(String str, String str2) {
            this.forumName = str;
            this.fid = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (as.isForumName(this.forumName)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new ap("c10523").dn("fid", this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.hottopic.data.m mVar) {
        if (mVar != null && !mVar.cpr()) {
            String valueOf = String.valueOf(mVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.iIs.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.postId), "hot_topic")));
            TiebaStatic.log(new ap("c10522").dn("tid", valueOf).dn("obj_id", this.iIs.coQ()));
        }
    }
}
