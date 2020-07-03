package com.baidu.tieba.ala.livecard.models;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ap {
    private BdUniqueId eyE;
    private int fRO;
    private bb fRP;
    private at fRQ;
    ArrayList<q> dataList = new ArrayList<>();
    private com.baidu.adp.framework.listener.a fRR = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.livecard.models.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.eyE) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                }
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage ? ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds() : list;
                if (!w.isEmpty(a.this.dataList) && !w.isEmpty(closedIds)) {
                    boolean z2 = false;
                    int size = a.this.dataList.size() - 1;
                    while (size >= 0) {
                        if (a.this.dataList.get(size).getType() != bu.dLI) {
                            z = z2;
                        } else {
                            bu buVar = (bu) a.this.dataList.get(size);
                            if (buVar != null) {
                                if (buVar.aSJ() == null) {
                                    z = z2;
                                } else if (closedIds.contains(Long.valueOf(buVar.aSJ().live_id))) {
                                    a.this.dataList.remove(size);
                                    z = true;
                                }
                            }
                            z = z2;
                        }
                        size--;
                        z2 = z;
                    }
                    if (z2 && a.this.fRQ != null) {
                        a.this.fRQ.a(49, a.this.fRO, a.this.fRP, a.this.dataList);
                    }
                }
            }
        }
    };
    private HttpMessageListener eDJ = new HttpMessageListener(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD) { // from class: com.baidu.tieba.ala.livecard.models.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    a.this.fRQ.a(49, a.this.fRO, null, null);
                } else if (((FrsPageAlaTabResponseMessage) httpResponsedMessage).errCode != 0) {
                    if (a.this.fRQ != null) {
                        a.this.fRQ.a(49, a.this.fRO, null, null);
                    }
                } else {
                    ArrayList<q> arrayList = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mThreadList;
                    ArrayList<q> arrayList2 = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mAltList;
                    bb bbVar = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).pageInfo;
                    int i = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).alaLiveCount;
                    a.this.fRP = bbVar;
                    if (bbVar.pn == 1) {
                        a.this.dataList.clear();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT, Integer.valueOf(i)));
                    if (a.this.fRQ != null) {
                        if (arrayList != null && arrayList.size() > 0) {
                            a.this.dataList.addAll(arrayList);
                            a.this.fRQ.a(49, a.this.fRO, bbVar, a.this.dataList);
                            return;
                        }
                        bu buVar = new bu();
                        buVar.setThreadType(51);
                        if (a.this.dataList.size() == 0 || (a.this.dataList.size() > 0 && ((bu) a.this.dataList.get(0)).getThreadType() != 51)) {
                            a.this.dataList.add(0, buVar);
                        }
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            buVar.dNM = true;
                            if (arrayList2.get(0) != null) {
                                ((bu) arrayList2.get(0)).dNL = true;
                            }
                            a.this.dataList.addAll(arrayList2);
                        }
                        a.this.fRQ.a(49, a.this.fRO, bbVar, a.this.dataList);
                    }
                }
            }
        }
    };

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eyE = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(int i, int i2, ay ayVar) {
        this.fRO = i2;
        if (ayVar != null && !TextUtils.isEmpty(ayVar.forumName) && !TextUtils.isEmpty(ayVar.forumId)) {
            if (ayVar.pn <= 0) {
                ayVar.pn = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, ayVar.forumName, ayVar.forumId, ayVar.pn));
            return;
        }
        this.fRQ.a(49, this.fRO, null, null);
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(at atVar) {
        this.fRQ = atVar;
    }

    @Override // com.baidu.tieba.frs.ap
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener();
    }

    private void registerListener() {
        if (this.eyE != null) {
            this.eDJ.setTag(this.eyE);
            this.fRR.setTag(this.eyE);
        }
        MessageManager.getInstance().registerListener(this.fRR);
        MessageManager.getInstance().registerListener(this.eDJ);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fRR);
        MessageManager.getInstance().unRegisterListener(this.eDJ);
    }

    @Override // com.baidu.tieba.frs.ap
    public void bzf() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        unRegisterListener();
    }
}
