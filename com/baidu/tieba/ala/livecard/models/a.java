package com.baidu.tieba.ala.livecard.models;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ak {
    private BdUniqueId epM;
    private int fGu;
    private av fGv;
    private ao fGw;
    ArrayList<o> dataList = new ArrayList<>();
    private com.baidu.adp.framework.listener.a fGx = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.livecard.models.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.epM) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                }
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage ? ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds() : list;
                if (!v.isEmpty(a.this.dataList) && !v.isEmpty(closedIds)) {
                    boolean z2 = false;
                    int size = a.this.dataList.size() - 1;
                    while (size >= 0) {
                        if (a.this.dataList.get(size).getType() != bk.dEW) {
                            z = z2;
                        } else {
                            bk bkVar = (bk) a.this.dataList.get(size);
                            if (bkVar != null) {
                                if (bkVar.aQS() == null) {
                                    z = z2;
                                } else if (closedIds.contains(Long.valueOf(bkVar.aQS().live_id))) {
                                    a.this.dataList.remove(size);
                                    z = true;
                                }
                            }
                            z = z2;
                        }
                        size--;
                        z2 = z;
                    }
                    if (z2 && a.this.fGw != null) {
                        a.this.fGw.a(49, a.this.fGu, a.this.fGv, a.this.dataList);
                    }
                }
            }
        }
    };
    private HttpMessageListener euF = new HttpMessageListener(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD) { // from class: com.baidu.tieba.ala.livecard.models.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    a.this.fGw.a(49, a.this.fGu, null, null);
                } else if (((FrsPageAlaTabResponseMessage) httpResponsedMessage).errCode != 0) {
                    if (a.this.fGw != null) {
                        a.this.fGw.a(49, a.this.fGu, null, null);
                    }
                } else {
                    ArrayList<o> arrayList = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mThreadList;
                    ArrayList<o> arrayList2 = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mAltList;
                    av avVar = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).pageInfo;
                    int i = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).alaLiveCount;
                    a.this.fGv = avVar;
                    if (avVar.pn == 1) {
                        a.this.dataList.clear();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT, Integer.valueOf(i)));
                    if (a.this.fGw != null) {
                        if (arrayList != null && arrayList.size() > 0) {
                            a.this.dataList.addAll(arrayList);
                            a.this.fGw.a(49, a.this.fGu, avVar, a.this.dataList);
                            return;
                        }
                        bk bkVar = new bk();
                        bkVar.setThreadType(51);
                        if (a.this.dataList.size() == 0 || (a.this.dataList.size() > 0 && ((bk) a.this.dataList.get(0)).getThreadType() != 51)) {
                            a.this.dataList.add(0, bkVar);
                        }
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            bkVar.dHb = true;
                            if (arrayList2.get(0) != null) {
                                ((bk) arrayList2.get(0)).dHa = true;
                            }
                            a.this.dataList.addAll(arrayList2);
                        }
                        a.this.fGw.a(49, a.this.fGu, avVar, a.this.dataList);
                    }
                }
            }
        }
    };

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.epM = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        this.fGu = i2;
        if (asVar != null && !TextUtils.isEmpty(asVar.forumName) && !TextUtils.isEmpty(asVar.forumId)) {
            if (asVar.pn <= 0) {
                asVar.pn = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, asVar.forumName, asVar.forumId, asVar.pn));
            return;
        }
        this.fGw.a(49, this.fGu, null, null);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.fGw = aoVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener();
    }

    private void registerListener() {
        if (this.epM != null) {
            this.euF.setTag(this.epM);
            this.fGx.setTag(this.epM);
        }
        MessageManager.getInstance().registerListener(this.fGx);
        MessageManager.getInstance().registerListener(this.euF);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fGx);
        MessageManager.getInstance().unRegisterListener(this.euF);
    }

    @Override // com.baidu.tieba.frs.ak
    public void bwi() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        unRegisterListener();
    }
}
