package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes21.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.m, com.baidu.tieba.hottopic.a.e> {
    private HotTopicActivity kbN;
    private a kbT;
    private ab kbU;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kbT = new a();
        this.kbU = new ab() { // from class: com.baidu.tieba.hottopic.adapter.j.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.hottopic.data.m)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    j.this.a((com.baidu.tieba.hottopic.data.m) qVar);
                }
            }
        };
        this.kbN = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public com.baidu.tieba.hottopic.a.e c(ViewGroup viewGroup) {
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
            if (this.kbN != null && eVar.aku != this.mSkinType) {
                eVar.aku = this.mSkinType;
                ap.setBackgroundResource(eVar.getView(), R.drawable.list_item_selector);
                ap.setViewTextColor(eVar.keX, R.color.CAM_X0108, 1);
                ap.setViewTextColor(eVar.eAz, R.color.CAM_X0105, 1);
                ap.setViewTextColor(eVar.kfg, R.color.CAM_X0109, 1);
                ap.setBackgroundColor(eVar.kfe, R.color.CAM_X0204);
                ap.setBackgroundColor(eVar.keW, R.color.CAM_X0204);
                eVar.kff.setImageDrawable(null);
                this.kbN.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.kbN.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.e eVar, com.baidu.tieba.hottopic.data.m mVar) {
        if (eVar != null && mVar != null) {
            if (mVar.cSf()) {
                eVar.keW.setVisibility(0);
                eVar.keX.setVisibility(0);
                eVar.kfe.setVisibility(8);
                eVar.kfd.setVisibility(8);
                eVar.keX.setText(mVar.kde.trim());
                ap.setBackgroundColor(eVar.getView(), R.color.CAM_X0201);
                return;
            }
            eVar.keW.setVisibility(8);
            eVar.keX.setVisibility(8);
            eVar.kfe.setVisibility(0);
            eVar.kfd.setVisibility(0);
            eVar.kff.startLoad(mVar.eGr, 10, false);
            eVar.eAz.setText(mVar.title.trim());
            eVar.kfg.setText(mVar.summary.trim());
            eVar.kfh.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}));
            eVar.kfi.setText(au.numberUniformFormat(mVar.keo));
            eVar.kfj.setText(au.numFormatOver10000(mVar.replyNum));
            b(eVar, mVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.a.e eVar, com.baidu.tieba.hottopic.data.m mVar) {
        if (eVar != null && mVar != null && this.kbN != null) {
            a(this.kbU);
            this.kbT.fq(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}), String.valueOf(mVar.fid));
            eVar.kfh.setOnClickListener(this.kbT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private String fid;
        private String forumName;

        private a() {
        }

        public void fq(String str, String str2) {
            this.forumName = str;
            this.fid = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (au.isForumName(this.forumName)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new ar("c10523").dY("fid", this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.hottopic.data.m mVar) {
        if (mVar != null && !mVar.cSf()) {
            String valueOf = String.valueOf(mVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.kbN.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.postId), "hot_topic")));
            TiebaStatic.log(new ar("c10522").dY("tid", valueOf).dY("obj_id", this.kbN.cRE()));
        }
    }
}
