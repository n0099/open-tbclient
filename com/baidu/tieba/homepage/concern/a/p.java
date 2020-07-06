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
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, ak<com.baidu.tieba.homepage.concern.b.b>> implements com.baidu.tieba.a.f {
    private String afG;
    private com.baidu.adp.widget.ListView.v ajy;
    public BdUniqueId eyE;
    private NEGFeedBackView.a fRV;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fRV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.concern.a.p.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ap apVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ap apVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
                if (arrayList != null && apVar != null) {
                    CustomMessage customMessage = new CustomMessage(2921425, p.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    new a().execute(new Integer[0]);
                    TiebaStatic.log(new ao("c13572"));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.concern.view.b(this.mPageContext, this.eyE));
        aVar.sc().bo(0);
        aVar.sc().bq(0);
        aVar.sc().bp(0);
        aVar.sc().bk(0);
        ak akVar = new ak(aVar.a(true, viewGroup, this.ajy));
        akVar.setPageId(this.eyE);
        z aI = akVar.aI(false);
        aI.a(this.fRV);
        aI.setAutoProcess(false);
        aI.setHeadText(this.mContext.getString(R.string.concern_recommend_dialog_title));
        aI.aG(true);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, ak<com.baidu.tieba.homepage.concern.b.b> akVar) {
        if (bVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        ao aoVar = new ao("c13565");
        aoVar.ag("obj_source", bVar.aRD() ? 1 : 2);
        com.baidu.tieba.card.s.bOB().e(aoVar);
        akVar.se().setPosition(i);
        if (akVar.se() instanceof com.baidu.tieba.a.e) {
            akVar.se().setPage(this.afG);
        }
        akVar.b((ak<com.baidu.tieba.homepage.concern.b.b>) bVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Integer, Integer, String> {
        private y mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new y();
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.mNetwork.addPostData("dislike_from", "concernpage");
                this.mNetwork.addPostData("dislike_type", "1");
                this.mNetwork.aWu().aWV().mIsNeedTbs = true;
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
    public void Ae(String str) {
        this.afG = str;
    }
}
