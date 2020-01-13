package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.w;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, af<com.baidu.tieba.homepage.concern.b.b>> implements com.baidu.tieba.a.f {
    private String Lg;
    private com.baidu.adp.widget.ListView.r Oq;
    public BdUniqueId dxg;
    private NEGFeedBackView.a eJF;
    private TbPageContext<?> mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eJF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.concern.a.n.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                if (arrayList != null && alVar != null) {
                    CustomMessage customMessage = new CustomMessage(2921425, n.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    new a().execute(new Integer[0]);
                    TiebaStatic.log(new an("c13572"));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Oq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.d(this.mPageContext, this.dxg));
        aVar.mS().aR(0);
        aVar.mS().aT(0);
        aVar.mS().aS(0);
        aVar.mS().aN(0);
        af afVar = new af(aVar.a(true, viewGroup, this.Oq));
        afVar.setPageId(this.dxg);
        w ad = afVar.ad(false);
        ad.a(this.eJF);
        ad.setAutoProcess(false);
        ad.setHeadText(this.mContext.getString(R.string.concern_recommend_dialog_title));
        ad.ab(true);
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, af<com.baidu.tieba.homepage.concern.b.b> afVar) {
        if (bVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        an anVar = new an("c13565");
        anVar.Z("obj_source", bVar.bLJ() ? 1 : 2);
        com.baidu.tieba.card.r.btA().c(anVar);
        afVar.mU().setPosition(i);
        if (afVar.mU() instanceof com.baidu.tieba.a.e) {
            afVar.mU().setPage(this.Lg);
        }
        afVar.b((af<com.baidu.tieba.homepage.concern.b.b>) bVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return afVar.getView();
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<Integer, Integer, String> {
        private x mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new x();
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.mNetwork.addPostData("dislike_from", "concernpage");
                this.mNetwork.addPostData("dislike_type", "1");
                this.mNetwork.aDU().aEu().mIsNeedTbs = true;
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
    public void wu(String str) {
        this.Lg = str;
    }
}
