package com.baidu.tieba.ala.liveroom.recommend.model;

import android.os.Handler;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.recommend.data.AlaRecommendLiveData;
import com.baidu.tieba.ala.liveroom.recommend.data.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    public long duration;
    public long gvZ;
    private a gwc;
    public List<AlaRecommendLiveData> gwd;
    public List<AlaRecommendLiveData> gwe;
    private HttpMessageListener gwf;
    private Runnable gwg;
    public Handler handler;
    public boolean hasMore;

    /* loaded from: classes4.dex */
    public interface a {
        void f(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.gwf = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.ala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.gwc != null) {
                            b.this.gwc.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    AlaRecommendLiveResponseMessage alaRecommendLiveResponseMessage = (AlaRecommendLiveResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.liveroom.recommend.model.a)) {
                        i = 0;
                        i2 = 0;
                    } else {
                        com.baidu.tieba.ala.liveroom.recommend.model.a aVar = (com.baidu.tieba.ala.liveroom.recommend.model.a) httpResponsedMessage.getOrginalMessage();
                        int i3 = aVar.Xq;
                        int i4 = aVar.gwb;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.gwd = new ArrayList();
                        b.this.gwe = new ArrayList();
                    } else {
                        if (b.this.gwd == null) {
                            b.this.gwd = new ArrayList();
                        }
                        if (b.this.gwe == null) {
                            b.this.gwe = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.gwi != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.gwi.list)) {
                        b.this.gwd.addAll(alaRecommendLiveResponseMessage.gwi.list);
                    }
                    if (alaRecommendLiveResponseMessage.gwj != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.gwj.list)) {
                        b.this.gwe.addAll(alaRecommendLiveResponseMessage.gwj.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.gwj.gvX == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.gwd != null && !b.this.gwd.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.gwd.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.gwd.size(); i5 += 2) {
                            com.baidu.tieba.ala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.ala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.gvV = b.this.gwd.get(i5);
                            if (i5 + 1 < b.this.gwd.size()) {
                                aVar2.gvW = b.this.gwd.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.gwe != null && !b.this.gwe.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.gwe.size(); i6 += 2) {
                            com.baidu.tieba.ala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.ala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.gvV = b.this.gwe.get(i6);
                            if (i6 + 1 < b.this.gwe.size()) {
                                aVar3.gvW = b.this.gwe.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.gwc != null) {
                        b.this.gwc.f(arrayList, ListUtils.getCount(b.this.gwd), i);
                    }
                }
            }
        };
        this.gwg = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.gvZ = 0L;
            }
        };
        MessageManager.getInstance().registerListener(this.gwf);
    }

    public void l(long j, int i) {
        com.baidu.tieba.ala.liveroom.recommend.model.a aVar = new com.baidu.tieba.ala.liveroom.recommend.model.a();
        aVar.gwb = i;
        if (i == 0) {
            this.gvZ = 0L;
        }
        if (this.gvZ == 0) {
            this.gvZ = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.gwg, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.gvZ = this.gvZ;
        aVar.Xq = i;
        aVar.gwa = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.gvZ = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.gwd = null;
        this.gwe = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean IZ() {
        return (this.gwd == null || this.gwd.isEmpty()) && (this.gwe == null || this.gwe.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gwf);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.gwc = null;
    }

    public void a(a aVar) {
        this.gwc = aVar;
    }
}
