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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.m, com.baidu.tieba.hottopic.a.e> {
    private HotTopicActivity iCm;
    private a iCs;
    private z iCt;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iCs = new a();
        this.iCt = new z() { // from class: com.baidu.tieba.hottopic.adapter.j.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.hottopic.data.m)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    j.this.a((com.baidu.tieba.hottopic.data.m) qVar);
                }
            }
        };
        this.iCm = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
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
            if (this.iCm != null && eVar.ahx != this.mSkinType) {
                eVar.ahx = this.mSkinType;
                an.setBackgroundResource(eVar.getView(), R.drawable.list_item_selector);
                an.setViewTextColor(eVar.iFw, R.color.cp_cont_c, 1);
                an.setViewTextColor(eVar.dDu, R.color.cp_cont_b, 1);
                an.setViewTextColor(eVar.iFF, R.color.cp_cont_d, 1);
                an.setBackgroundColor(eVar.iFD, R.color.cp_bg_line_c);
                an.setBackgroundColor(eVar.iFv, R.color.cp_bg_line_c);
                eVar.iFE.setImageDrawable(null);
                this.iCm.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.iCm.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.e eVar, com.baidu.tieba.hottopic.data.m mVar) {
        if (eVar != null && mVar != null) {
            if (mVar.clR()) {
                eVar.iFv.setVisibility(0);
                eVar.iFw.setVisibility(0);
                eVar.iFD.setVisibility(8);
                eVar.iFC.setVisibility(8);
                eVar.iFw.setText(mVar.iDE.trim());
                an.setBackgroundColor(eVar.getView(), R.color.cp_bg_line_d);
                return;
            }
            eVar.iFv.setVisibility(8);
            eVar.iFw.setVisibility(8);
            eVar.iFD.setVisibility(0);
            eVar.iFC.setVisibility(0);
            eVar.iFE.startLoad(mVar.dIO, 10, false);
            eVar.dDu.setText(mVar.title.trim());
            eVar.iFF.setText(mVar.summary.trim());
            eVar.iFG.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}));
            eVar.iFH.setText(ar.numberUniformFormat(mVar.iEO));
            eVar.iFI.setText(ar.numFormatOver10000(mVar.replyNum));
            b(eVar, mVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.a.e eVar, com.baidu.tieba.hottopic.data.m mVar) {
        if (eVar != null && mVar != null && this.iCm != null) {
            a(this.iCt);
            this.iCs.es(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}), String.valueOf(mVar.fid));
            eVar.iFG.setOnClickListener(this.iCs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private String fid;
        private String forumName;

        private a() {
        }

        public void es(String str, String str2) {
            this.forumName = str;
            this.fid = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.isForumName(this.forumName)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new ao("c10523").dk("fid", this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.hottopic.data.m mVar) {
        if (mVar != null && !mVar.clR()) {
            String valueOf = String.valueOf(mVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.iCm.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.postId), "hot_topic")));
            TiebaStatic.log(new ao("c10522").dk("tid", valueOf).dk("obj_id", this.iCm.clq()));
        }
    }
}
