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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.m;
import com.baidu.tieba.hottopic.holder.QualityThreadItemHolder;
/* loaded from: classes8.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, QualityThreadItemHolder> {
    private HotTopicActivity ksB;
    private a ksH;
    private w ksI;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.ksH = new a();
        this.ksI = new w() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (nVar != null && (nVar instanceof m)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    i.this.a((m) nVar);
                }
            }
        };
        this.ksB = hotTopicActivity;
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
            if (this.ksB != null && qualityThreadItemHolder.ajU != this.mSkinType) {
                qualityThreadItemHolder.ajU = this.mSkinType;
                ap.setBackgroundResource(qualityThreadItemHolder.getView(), R.drawable.list_item_selector);
                ap.setViewTextColor(qualityThreadItemHolder.kvL, R.color.CAM_X0108, 1);
                ap.setViewTextColor(qualityThreadItemHolder.eHx, R.color.CAM_X0105, 1);
                ap.setViewTextColor(qualityThreadItemHolder.kvU, R.color.CAM_X0109, 1);
                ap.setBackgroundColor(qualityThreadItemHolder.kvS, R.color.CAM_X0204);
                ap.setBackgroundColor(qualityThreadItemHolder.kvK, R.color.CAM_X0204);
                qualityThreadItemHolder.kvT.setImageDrawable(null);
                this.ksB.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.ksB.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder != null && mVar != null) {
            if (mVar.cTt()) {
                qualityThreadItemHolder.kvK.setVisibility(0);
                qualityThreadItemHolder.kvL.setVisibility(0);
                qualityThreadItemHolder.kvS.setVisibility(8);
                qualityThreadItemHolder.kvR.setVisibility(8);
                qualityThreadItemHolder.kvL.setText(mVar.ktS.trim());
                ap.setBackgroundColor(qualityThreadItemHolder.getView(), R.color.CAM_X0201);
                return;
            }
            qualityThreadItemHolder.kvK.setVisibility(8);
            qualityThreadItemHolder.kvL.setVisibility(8);
            qualityThreadItemHolder.kvS.setVisibility(0);
            qualityThreadItemHolder.kvR.setVisibility(0);
            qualityThreadItemHolder.kvT.startLoad(mVar.eNI, 10, false);
            qualityThreadItemHolder.eHx.setText(mVar.title.trim());
            qualityThreadItemHolder.kvU.setText(mVar.summary.trim());
            qualityThreadItemHolder.kvV.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}));
            qualityThreadItemHolder.kvW.setText(au.numberUniformFormat(mVar.kvd));
            qualityThreadItemHolder.kvX.setText(au.numFormatOver10000(mVar.replyNum));
            b(qualityThreadItemHolder, mVar);
        }
    }

    private void b(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder != null && mVar != null && this.ksB != null) {
            a(this.ksI);
            this.ksH.fq(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}), String.valueOf(mVar.fid));
            qualityThreadItemHolder.kvV.setOnClickListener(this.ksH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new ar("c10523").dR("fid", this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar != null && !mVar.cTt()) {
            String valueOf = String.valueOf(mVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ksB.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.postId), "hot_topic")));
            TiebaStatic.log(new ar("c10522").dR("tid", valueOf).dR("obj_id", this.ksB.cSS()));
        }
    }
}
