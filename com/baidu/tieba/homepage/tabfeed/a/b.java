package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.widget.ListView.a<bn, ak<bn>> implements com.baidu.tieba.a.f {
    private String afx;
    private com.baidu.tbadk.h.f agN;
    private v ajt;
    public BdUniqueId eEU;
    private NEGFeedBackView.a fXo;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agN = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.homepage.tabfeed.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, MetaData metaData, int i, long j) {
                if (metaData != null) {
                    com.baidu.tieba.homepage.tabfeed.b.b("c13758", metaData, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, MetaData metaData, int i, long j) {
                if (metaData != null) {
                    com.baidu.tieba.homepage.tabfeed.b.c("c13758", metaData, i + 1);
                }
            }
        };
        this.fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.b.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                if (arrayList != null && aqVar != null) {
                    CustomMessage customMessage = new CustomMessage(2921425, b.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    new a().execute(new Integer[0]);
                    TiebaStatic.log(new ap("c13572"));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext, this.eEU);
        bVar.setOnItemCoverListener(this.agN);
        aVar.c(bVar);
        aVar.se().bq(0);
        aVar.se().bs(0);
        aVar.se().br(0);
        aVar.se().bm(0);
        ak akVar = new ak(aVar.a(true, viewGroup, this.ajt));
        akVar.setPageId(this.eEU);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bn bnVar, ak<bn> akVar) {
        if (bnVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.sg().setPosition(i);
        if (akVar.sg() instanceof com.baidu.tieba.a.e) {
            akVar.sg().setPage(this.afx);
        }
        akVar.b((ak<bn>) bnVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    /* loaded from: classes16.dex */
    private class a extends BdAsyncTask<Integer, Integer, String> {
        private z mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new z();
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.mNetwork.addPostData("dislike_from", "concernpage");
                this.mNetwork.addPostData("dislike_type", "1");
                this.mNetwork.bav().baW().mIsNeedTbs = true;
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
    public void AP(String str) {
        this.afx = str;
    }
}
