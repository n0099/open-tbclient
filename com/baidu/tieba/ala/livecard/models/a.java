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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements af {
    private BdUniqueId cJo;
    private int dSG;
    private ap dSH;
    private ai dSI;
    ArrayList<m> dataList = new ArrayList<>();
    private com.baidu.adp.framework.listener.a dSJ = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.livecard.models.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.cJo) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                }
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage ? ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds() : list;
                if (!v.isEmpty(a.this.dataList) && !v.isEmpty(closedIds)) {
                    boolean z2 = false;
                    int size = a.this.dataList.size() - 1;
                    while (size >= 0) {
                        if (a.this.dataList.get(size).getType() != bh.caS) {
                            z = z2;
                        } else {
                            bh bhVar = (bh) a.this.dataList.get(size);
                            if (bhVar != null) {
                                if (bhVar.aiX() == null) {
                                    z = z2;
                                } else if (closedIds.contains(Long.valueOf(bhVar.aiX().live_id))) {
                                    a.this.dataList.remove(size);
                                    z = true;
                                }
                            }
                            z = z2;
                        }
                        size--;
                        z2 = z;
                    }
                    if (z2 && a.this.dSI != null) {
                        a.this.dSI.a(49, a.this.dSG, a.this.dSH, a.this.dataList);
                    }
                }
            }
        }
    };
    private HttpMessageListener dSK = new HttpMessageListener(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD) { // from class: com.baidu.tieba.ala.livecard.models.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    a.this.dSI.a(49, a.this.dSG, null, null);
                } else if (((FrsPageAlaTabResponseMessage) httpResponsedMessage).errCode != 0) {
                    if (a.this.dSI != null) {
                        a.this.dSI.a(49, a.this.dSG, null, null);
                    }
                } else {
                    ArrayList<m> arrayList = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mThreadList;
                    ArrayList<m> arrayList2 = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mAltList;
                    ap apVar = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).pageInfo;
                    int i = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).alaLiveCount;
                    a.this.dSH = apVar;
                    if (apVar.pn == 1) {
                        a.this.dataList.clear();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT, Integer.valueOf(i)));
                    if (a.this.dSI != null) {
                        if (arrayList != null && arrayList.size() > 0) {
                            a.this.dataList.addAll(arrayList);
                            a.this.dSI.a(49, a.this.dSG, apVar, a.this.dataList);
                            return;
                        }
                        bh bhVar = new bh();
                        bhVar.setThreadType(51);
                        if (a.this.dataList.size() == 0 || (a.this.dataList.size() > 0 && ((bh) a.this.dataList.get(0)).getThreadType() != 51)) {
                            a.this.dataList.add(0, bhVar);
                        }
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            bhVar.ccW = true;
                            if (arrayList2.get(0) != null) {
                                ((bh) arrayList2.get(0)).ccV = true;
                            }
                            a.this.dataList.addAll(arrayList2);
                        }
                        a.this.dSI.a(49, a.this.dSG, apVar, a.this.dataList);
                    }
                }
            }
        }
    };

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cJo = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dSG = i2;
        if (amVar != null && !TextUtils.isEmpty(amVar.forumName) && !TextUtils.isEmpty(amVar.forumId)) {
            if (amVar.pn <= 0) {
                amVar.pn = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, amVar.forumName, amVar.forumId, amVar.pn));
            return;
        }
        this.dSI.a(49, this.dSG, null, null);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.dSI = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener();
    }

    private void registerListener() {
        if (this.cJo != null) {
            this.dSK.setTag(this.cJo);
            this.dSJ.setTag(this.cJo);
        }
        MessageManager.getInstance().registerListener(this.dSJ);
        MessageManager.getInstance().registerListener(this.dSK);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.dSJ);
        MessageManager.getInstance().unRegisterListener(this.dSK);
    }

    @Override // com.baidu.tieba.frs.af
    public void aMK() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        unRegisterListener();
    }
}
