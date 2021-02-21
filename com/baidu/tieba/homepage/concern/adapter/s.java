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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.a, ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.a>> implements com.baidu.tieba.a.f {
    private String aif;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a hnH;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hnH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.concern.adapter.s.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                if (arrayList != null && avVar != null) {
                    CustomMessage customMessage = new CustomMessage(2921425, s.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    new a().execute(new Integer[0]);
                    TiebaStatic.log(new ar("c13572"));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.concern.view.a aVar2 = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext, this.fGZ);
        aVar2.setHasBorder(true);
        aVar.c(aVar2);
        aVar.ti().bz(0);
        aVar.ti().bB(0);
        aVar.ti().bA(0);
        aVar.ti().bx(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amk));
        threadCardViewHolder.setPageId(this.fGZ);
        ab aK = threadCardViewHolder.aK(false);
        aK.a(this.hnH);
        aK.setAutoProcess(false);
        aK.setHeadText(this.mContext.getString(R.string.concern_recommend_dialog_title));
        aK.aI(true);
        aK.ahA = true;
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.a aVar, ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        ar arVar = new ar("c13565");
        arVar.ap("obj_source", aVar.bne() ? 1 : 2);
        com.baidu.tieba.card.t.csB().e(arVar);
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.homepage.concern.a.a>) aVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Integer, Integer, String> {
        private aa mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new aa();
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.mNetwork.addPostData("dislike_from", "concernpage");
                this.mNetwork.addPostData("dislike_type", "1");
                this.mNetwork.bsr().bta().mIsNeedTbs = true;
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
    public void Ew(String str) {
        this.aif = str;
    }
}
