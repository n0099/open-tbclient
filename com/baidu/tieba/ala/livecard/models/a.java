package com.baidu.tieba.ala.livecard.models;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ah {
    private BdUniqueId dBK;
    private int eOd;
    private ar eOe;
    private ak eOf;
    ArrayList<m> dataList = new ArrayList<>();
    private com.baidu.adp.framework.listener.a eOg = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.livecard.models.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.dBK) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                }
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage ? ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds() : list;
                if (!v.isEmpty(a.this.dataList) && !v.isEmpty(closedIds)) {
                    boolean z2 = false;
                    int size = a.this.dataList.size() - 1;
                    while (size >= 0) {
                        if (a.this.dataList.get(size).getType() != bj.cRO) {
                            z = z2;
                        } else {
                            bj bjVar = (bj) a.this.dataList.get(size);
                            if (bjVar != null) {
                                if (bjVar.aCK() == null) {
                                    z = z2;
                                } else if (closedIds.contains(Long.valueOf(bjVar.aCK().live_id))) {
                                    a.this.dataList.remove(size);
                                    z = true;
                                }
                            }
                            z = z2;
                        }
                        size--;
                        z2 = z;
                    }
                    if (z2 && a.this.eOf != null) {
                        a.this.eOf.a(49, a.this.eOd, a.this.eOe, a.this.dataList);
                    }
                }
            }
        }
    };
    private HttpMessageListener dGF = new HttpMessageListener(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD) { // from class: com.baidu.tieba.ala.livecard.models.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    a.this.eOf.a(49, a.this.eOd, null, null);
                } else if (((FrsPageAlaTabResponseMessage) httpResponsedMessage).errCode != 0) {
                    if (a.this.eOf != null) {
                        a.this.eOf.a(49, a.this.eOd, null, null);
                    }
                } else {
                    ArrayList<m> arrayList = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mThreadList;
                    ArrayList<m> arrayList2 = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mAltList;
                    ar arVar = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).pageInfo;
                    int i = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).alaLiveCount;
                    a.this.eOe = arVar;
                    if (arVar.pn == 1) {
                        a.this.dataList.clear();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT, Integer.valueOf(i)));
                    if (a.this.eOf != null) {
                        if (arrayList != null && arrayList.size() > 0) {
                            a.this.dataList.addAll(arrayList);
                            a.this.eOf.a(49, a.this.eOd, arVar, a.this.dataList);
                            return;
                        }
                        bj bjVar = new bj();
                        bjVar.setThreadType(51);
                        if (a.this.dataList.size() == 0 || (a.this.dataList.size() > 0 && ((bj) a.this.dataList.get(0)).getThreadType() != 51)) {
                            a.this.dataList.add(0, bjVar);
                        }
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            bjVar.cTT = true;
                            if (arrayList2.get(0) != null) {
                                ((bj) arrayList2.get(0)).cTS = true;
                            }
                            a.this.dataList.addAll(arrayList2);
                        }
                        a.this.eOf.a(49, a.this.eOd, arVar, a.this.dataList);
                    }
                }
            }
        }
    };

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dBK = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(int i, int i2, ao aoVar) {
        this.eOd = i2;
        if (aoVar != null && !TextUtils.isEmpty(aoVar.forumName) && !TextUtils.isEmpty(aoVar.forumId)) {
            if (aoVar.pn <= 0) {
                aoVar.pn = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, aoVar.forumName, aoVar.forumId, aoVar.pn));
            return;
        }
        this.eOf.a(49, this.eOd, null, null);
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(ak akVar) {
        this.eOf = akVar;
    }

    @Override // com.baidu.tieba.frs.ah
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener();
    }

    private void registerListener() {
        if (this.dBK != null) {
            this.dGF.setTag(this.dBK);
            this.eOg.setTag(this.dBK);
        }
        MessageManager.getInstance().registerListener(this.eOg);
        MessageManager.getInstance().registerListener(this.dGF);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eOg);
        MessageManager.getInstance().unRegisterListener(this.dGF);
    }

    @Override // com.baidu.tieba.frs.ah
    public void bhc() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        unRegisterListener();
    }
}
