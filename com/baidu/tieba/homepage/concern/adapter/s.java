package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ab;
import com.baidu.card.ak;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.a, ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.a>> implements com.baidu.tieba.a.f {
    private String air;
    private com.baidu.adp.widget.ListView.s amu;
    public BdUniqueId fEN;
    private NEGFeedBackView.a hjg;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hjg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.concern.adapter.s.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                if (arrayList != null && atVar != null) {
                    CustomMessage customMessage = new CustomMessage(2921425, s.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    new a().execute(new Integer[0]);
                    TiebaStatic.log(new aq("c13572"));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amu = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.concern.view.a aVar2 = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext, this.fEN);
        aVar2.setHasBorder(true);
        aVar.c(aVar2);
        aVar.tl().bz(0);
        aVar.tl().bB(0);
        aVar.tl().bA(0);
        aVar.tl().bx(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amu));
        threadCardViewHolder.setPageId(this.fEN);
        ab aK = threadCardViewHolder.aK(false);
        aK.a(this.hjg);
        aK.setAutoProcess(false);
        aK.setHeadText(this.mContext.getString(R.string.concern_recommend_dialog_title));
        aK.aI(true);
        aK.ahM = true;
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.a aVar, ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        aq aqVar = new aq("c13565");
        aqVar.an("obj_source", aVar.bmL() ? 1 : 2);
        com.baidu.tieba.card.s.crj().e(aqVar);
        threadCardViewHolder.tm().setPosition(i);
        if (threadCardViewHolder.tm() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tm().setPage(this.air);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.a>) aVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Integer, Integer, String> {
        private com.baidu.tbadk.core.util.z mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z();
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.mNetwork.addPostData("dislike_from", "concernpage");
                this.mNetwork.addPostData("dislike_type", "1");
                this.mNetwork.brX().bsG().mIsNeedTbs = true;
                return this.mNetwork.postNetData();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }
}
