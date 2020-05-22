package com.baidu.tieba.ala.liveroom.recommend.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.recommend.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private InterfaceC0571a gdE;
    private HttpMessageListener gdF;

    /* renamed from: com.baidu.tieba.ala.liveroom.recommend.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0571a {
        void g(List<IAdapterData> list, int i);

        void onFail(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gdF = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.ala.liveroom.recommend.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i = 0;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaRecommendLiveResponseMessage alaRecommendLiveResponseMessage = (AlaRecommendLiveResponseMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.gdE != null) {
                            a.this.gdE.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (alaRecommendLiveResponseMessage.gdH != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.gdH.list)) {
                        b bVar = new b(0);
                        bVar.count = alaRecommendLiveResponseMessage.gdH.total_count;
                        arrayList.add(bVar);
                        i = ListUtils.getCount(alaRecommendLiveResponseMessage.gdH.list);
                        arrayList.addAll(alaRecommendLiveResponseMessage.gdH.list);
                    }
                    if (alaRecommendLiveResponseMessage.gdI != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.gdI.list)) {
                        arrayList.add(new b(1));
                        arrayList.addAll(alaRecommendLiveResponseMessage.gdI.list);
                    }
                    if (a.this.gdE != null) {
                        a.this.gdE.g(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gdF);
    }

    public void dH(long j) {
        HttpMessage httpMessage = new HttpMessage(1021193);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("live_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gdF);
        cancelMessage();
        this.gdE = null;
    }

    public void a(InterfaceC0571a interfaceC0571a) {
        this.gdE = interfaceC0571a;
    }
}
