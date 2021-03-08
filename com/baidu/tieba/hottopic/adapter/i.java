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
/* loaded from: classes7.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, QualityThreadItemHolder> {
    private HotTopicActivity kuR;
    private a kuX;
    private w kuY;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kuX = new a();
        this.kuY = new w() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (nVar != null && (nVar instanceof m)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    i.this.a((m) nVar);
                }
            }
        };
        this.kuR = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
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
            if (this.kuR != null && qualityThreadItemHolder.aln != this.mSkinType) {
                qualityThreadItemHolder.aln = this.mSkinType;
                ap.setBackgroundResource(qualityThreadItemHolder.getView(), R.drawable.list_item_selector);
                ap.setViewTextColor(qualityThreadItemHolder.kyb, R.color.CAM_X0108, 1);
                ap.setViewTextColor(qualityThreadItemHolder.eIY, R.color.CAM_X0105, 1);
                ap.setViewTextColor(qualityThreadItemHolder.kyk, R.color.CAM_X0109, 1);
                ap.setBackgroundColor(qualityThreadItemHolder.kyi, R.color.CAM_X0204);
                ap.setBackgroundColor(qualityThreadItemHolder.kya, R.color.CAM_X0204);
                qualityThreadItemHolder.kyj.setImageDrawable(null);
                this.kuR.getLayoutMode().setNightMode(this.mSkinType == 1);
                this.kuR.getLayoutMode().onModeChanged(view);
            }
        }
    }

    private void a(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder != null && mVar != null) {
            if (mVar.cTH()) {
                qualityThreadItemHolder.kya.setVisibility(0);
                qualityThreadItemHolder.kyb.setVisibility(0);
                qualityThreadItemHolder.kyi.setVisibility(8);
                qualityThreadItemHolder.kyh.setVisibility(8);
                qualityThreadItemHolder.kyb.setText(mVar.kwi.trim());
                ap.setBackgroundColor(qualityThreadItemHolder.getView(), R.color.CAM_X0201);
                return;
            }
            qualityThreadItemHolder.kya.setVisibility(8);
            qualityThreadItemHolder.kyb.setVisibility(8);
            qualityThreadItemHolder.kyi.setVisibility(0);
            qualityThreadItemHolder.kyh.setVisibility(0);
            qualityThreadItemHolder.kyj.startLoad(mVar.ePj, 10, false);
            qualityThreadItemHolder.eIY.setText(mVar.title.trim());
            qualityThreadItemHolder.kyk.setText(mVar.summary.trim());
            qualityThreadItemHolder.kyl.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}));
            qualityThreadItemHolder.kym.setText(au.numberUniformFormat(mVar.kxt));
            qualityThreadItemHolder.kyn.setText(au.numFormatOver10000(mVar.replyNum));
            b(qualityThreadItemHolder, mVar);
        }
    }

    private void b(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder != null && mVar != null && this.kuR != null) {
            a(this.kuY);
            this.kuX.fq(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.fname, 7, false)}), String.valueOf(mVar.fid));
            qualityThreadItemHolder.kyl.setOnClickListener(this.kuX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
        if (mVar != null && !mVar.cTH()) {
            String valueOf = String.valueOf(mVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.kuR.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.postId), "hot_topic")));
            TiebaStatic.log(new ar("c10522").dR("tid", valueOf).dR("obj_id", this.kuR.cTg()));
        }
    }
}
