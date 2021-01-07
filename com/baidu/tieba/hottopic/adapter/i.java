package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.m;
import com.baidu.tieba.hottopic.holder.QualityThreadItemHolder;
/* loaded from: classes8.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, QualityThreadItemHolder> {
    private HotTopicActivity koZ;
    private a kpf;
    private w kpg;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kpf = new a();
        this.kpg = new w() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (nVar != null && (nVar instanceof m)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    i.this.a((m) nVar);
                }
            }
        };
        this.koZ = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public QualityThreadItemHolder e(ViewGroup viewGroup) {
        return new QualityThreadItemHolder(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_quality_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        if (mVar != null && qualityThreadItemHolder != null) {
            a(qualityThreadItemHolder, view);
            a(qualityThreadItemHolder, mVar);
        }
        return view;
    }

    private void a(QualityThreadItemHolder qualityThreadItemHolder, View view) {
        if (qualityThreadItemHolder != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.koZ != null && qualityThreadItemHolder.akW != this.mSkinType) {
                qualityThreadItemHolder.akW = this.mSkinType;
                ao.setBackgroundResource(qualityThreadItemHolder.getView(), R.drawable.list_item_selector);
                ao.setViewTextColor(qualityThreadItemHolder.ksj, R.color.CAM_X0108, 1);
                ao.setViewTextColor(qualityThreadItemHolder.eKc, R.color.CAM_X0105, 1);
                ao.setViewTextColor(qualityThreadItemHolder.kss, R.color.CAM_X0109, 1);
                ao.setBackgroundColor(qualityThreadItemHolder.ksq, R.color.CAM_X0204);
                ao.setBackgroundColor(qualityThreadItemHolder.ksi, R.color.CAM_X0204);
                qualityThreadItemHolder.ksr.setImageDrawable(null);
                this.koZ.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.koZ.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder != null && mVar != null) {
            if (mVar.cVm()) {
                qualityThreadItemHolder.ksi.setVisibility(0);
                qualityThreadItemHolder.ksj.setVisibility(0);
                qualityThreadItemHolder.ksq.setVisibility(8);
                qualityThreadItemHolder.ksp.setVisibility(8);
                qualityThreadItemHolder.ksj.setText(mVar.kqq.trim());
                ao.setBackgroundColor(qualityThreadItemHolder.getView(), R.color.CAM_X0201);
                return;
            }
            qualityThreadItemHolder.ksi.setVisibility(8);
            qualityThreadItemHolder.ksj.setVisibility(8);
            qualityThreadItemHolder.ksq.setVisibility(0);
            qualityThreadItemHolder.ksp.setVisibility(0);
            qualityThreadItemHolder.ksr.startLoad(mVar.eQh, 10, false);
            qualityThreadItemHolder.eKc.setText(mVar.title.trim());
            qualityThreadItemHolder.kss.setText(mVar.summary.trim());
            qualityThreadItemHolder.kst.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}));
            qualityThreadItemHolder.ksu.setText(at.numberUniformFormat(mVar.krB));
            qualityThreadItemHolder.ksv.setText(at.numFormatOver10000(mVar.replyNum));
            b(qualityThreadItemHolder, mVar);
        }
    }

    private void b(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder != null && mVar != null && this.koZ != null) {
            a(this.kpg);
            this.kpf.fr(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}), String.valueOf(mVar.fid));
            qualityThreadItemHolder.kst.setOnClickListener(this.kpf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private String fid;
        private String forumName;

        private a() {
        }

        public void fr(String str, String str2) {
            this.forumName = str;
            this.fid = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (at.isForumName(this.forumName)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new aq("c10523").dX("fid", this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar != null && !mVar.cVm()) {
            String valueOf = String.valueOf(mVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.koZ.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.postId), "hot_topic")));
            TiebaStatic.log(new aq("c10522").dX("tid", valueOf).dX("obj_id", this.koZ.cUL()));
        }
    }
}
