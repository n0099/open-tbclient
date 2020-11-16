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
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.a, am<com.baidu.tieba.homepage.concern.a.a>> implements com.baidu.tieba.a.f {
    private String ahw;
    private com.baidu.adp.widget.ListView.v alH;
    public BdUniqueId fsa;
    private NEGFeedBackView.a gSL;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gSL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.concern.adapter.s.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(as asVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
                if (arrayList != null && asVar != null) {
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

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.concern.view.a aVar2 = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext, this.fsa);
        aVar2.setHasBorder(true);
        aVar.c(aVar2);
        aVar.tV().bx(0);
        aVar.tV().bz(0);
        aVar.tV().by(0);
        aVar.tV().bv(0);
        am amVar = new am(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.alH));
        amVar.setPageId(this.fsa);
        com.baidu.card.ab aN = amVar.aN(false);
        aN.a(this.gSL);
        aN.setAutoProcess(false);
        aN.setHeadText(this.mContext.getString(R.string.concern_recommend_dialog_title));
        aN.aK(true);
        aN.agS = true;
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.a aVar, am<com.baidu.tieba.homepage.concern.a.a> amVar) {
        if (aVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        ar arVar = new ar("c13565");
        arVar.ak("obj_source", aVar.bkQ() ? 1 : 2);
        com.baidu.tieba.card.t.cnT().e(arVar);
        amVar.tW().setPosition(i);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahw);
        }
        amVar.b((am<com.baidu.tieba.homepage.concern.a.a>) aVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    /* loaded from: classes21.dex */
    private class a extends BdAsyncTask<Integer, Integer, String> {
        private com.baidu.tbadk.core.util.aa mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.aa();
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.mNetwork.addPostData("dislike_from", "concernpage");
                this.mNetwork.addPostData("dislike_type", "1");
                this.mNetwork.bqa().bqH().mIsNeedTbs = true;
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
    public void EA(String str) {
        this.ahw = str;
    }
}
