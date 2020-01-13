package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.c.c;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    private boolean eil;
    private c eiu;
    private a eiv;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener eiw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021081 && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.mCurTag) {
                AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                if (alaNewSquareSubListResponseMessage.getError() != 0 || !alaNewSquareSubListResponseMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.eiv != null) {
                        AlaLiveTabYanzhiModel.this.eiv.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.eil);
                    }
                } else {
                    if (AlaLiveTabYanzhiModel.this.eil) {
                        AlaLiveTabYanzhiModel.this.eiu.j(alaNewSquareSubListResponseMessage.getLiveList(), alaNewSquareSubListResponseMessage.hasMore());
                        AlaLiveTabYanzhiModel.e(AlaLiveTabYanzhiModel.this);
                    } else {
                        if (AlaLiveTabYanzhiModel.this.eiu != null) {
                            AlaLiveTabYanzhiModel.this.eiu.clear();
                        }
                        AlaLiveTabYanzhiModel.this.eiu = new c(alaNewSquareSubListResponseMessage.getLiveList(), alaNewSquareSubListResponseMessage.hasMore());
                    }
                    AlaLiveTabYanzhiModel.this.hasMore = AlaLiveTabYanzhiModel.this.eiu.hasMore();
                    if (AlaLiveTabYanzhiModel.this.eiv != null) {
                        AlaLiveTabYanzhiModel.this.eiv.d(AlaLiveTabYanzhiModel.this.hasMore, AlaLiveTabYanzhiModel.this.eiu.getData());
                    }
                }
                AlaLiveTabYanzhiModel.this.eil = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes2.dex */
    public interface a {
        void d(boolean z, List<m> list);

        void e(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i = alaLiveTabYanzhiModel.mPn;
        alaLiveTabYanzhiModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.eiv = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.eiw);
    }

    public void refresh() {
        this.eil = false;
        this.mPn = 0;
        on(this.mPn);
    }

    public void aZN() {
        if (this.hasMore && !this.eil) {
            this.eil = true;
            on(this.mPn + 1);
        }
    }

    private void on(int i) {
        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
        alaNewSquareSubListRequestMessage.setPn(i);
        alaNewSquareSubListRequestMessage.setPs(20);
        alaNewSquareSubListRequestMessage.setSortType(null);
        alaNewSquareSubListRequestMessage.setEntryName("颜值");
        alaNewSquareSubListRequestMessage.setLableName(null);
        alaNewSquareSubListRequestMessage.setLat("");
        alaNewSquareSubListRequestMessage.setLng("");
        alaNewSquareSubListRequestMessage.setTag(this.mCurTag);
        alaNewSquareSubListRequestMessage.setHttpParams();
        sendMessage(alaNewSquareSubListRequestMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eiw);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
