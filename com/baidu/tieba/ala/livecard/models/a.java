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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements ar {
    private BdUniqueId ePz;
    private int gjk;
    private bd gjl;
    private av gjm;
    ArrayList<q> dataList = new ArrayList<>();
    private com.baidu.adp.framework.listener.a gjn = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.livecard.models.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.ePz) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                }
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage ? ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds() : list;
                if (!y.isEmpty(a.this.dataList) && !y.isEmpty(closedIds)) {
                    boolean z2 = false;
                    int size = a.this.dataList.size() - 1;
                    while (size >= 0) {
                        if (a.this.dataList.get(size).getType() != bw.ebt) {
                            z = z2;
                        } else {
                            bw bwVar = (bw) a.this.dataList.get(size);
                            if (bwVar != null) {
                                if (bwVar.beY() == null) {
                                    z = z2;
                                } else if (closedIds.contains(Long.valueOf(bwVar.beY().live_id))) {
                                    a.this.dataList.remove(size);
                                    z = true;
                                }
                            }
                            z = z2;
                        }
                        size--;
                        z2 = z;
                    }
                    if (z2 && a.this.gjm != null) {
                        a.this.gjm.a(49, a.this.gjk, a.this.gjl, a.this.dataList);
                    }
                }
            }
        }
    };
    private HttpMessageListener eDh = new HttpMessageListener(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD) { // from class: com.baidu.tieba.ala.livecard.models.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    a.this.gjm.a(49, a.this.gjk, null, null);
                } else if (((FrsPageAlaTabResponseMessage) httpResponsedMessage).errCode != 0) {
                    if (a.this.gjm != null) {
                        a.this.gjm.a(49, a.this.gjk, null, null);
                    }
                } else {
                    ArrayList<q> arrayList = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mThreadList;
                    ArrayList<q> arrayList2 = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mAltList;
                    bd bdVar = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).pageInfo;
                    int i = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).alaLiveCount;
                    a.this.gjl = bdVar;
                    if (bdVar.pn == 1) {
                        a.this.dataList.clear();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT, Integer.valueOf(i)));
                    if (a.this.gjm != null) {
                        if (arrayList != null && arrayList.size() > 0) {
                            a.this.dataList.addAll(arrayList);
                            a.this.gjm.a(49, a.this.gjk, bdVar, a.this.dataList);
                            return;
                        }
                        bw bwVar = new bw();
                        bwVar.setThreadType(51);
                        if (a.this.dataList.size() == 0 || (a.this.dataList.size() > 0 && ((bw) a.this.dataList.get(0)).getThreadType() != 51)) {
                            a.this.dataList.add(0, bwVar);
                        }
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            bwVar.edx = true;
                            if (arrayList2.get(0) != null) {
                                ((bw) arrayList2.get(0)).edw = true;
                            }
                            a.this.dataList.addAll(arrayList2);
                        }
                        a.this.gjm.a(49, a.this.gjk, bdVar, a.this.dataList);
                    }
                }
            }
        }
    };

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ePz = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.gjk = i2;
        if (baVar != null && !TextUtils.isEmpty(baVar.forumName) && !TextUtils.isEmpty(baVar.forumId)) {
            if (baVar.pn <= 0) {
                baVar.pn = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, baVar.forumName, baVar.forumId, baVar.pn));
            return;
        }
        this.gjm.a(49, this.gjk, null, null);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.gjm = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener();
    }

    private void registerListener() {
        if (this.ePz != null) {
            this.eDh.setTag(this.ePz);
            this.gjn.setTag(this.ePz);
        }
        MessageManager.getInstance().registerListener(this.gjn);
        MessageManager.getInstance().registerListener(this.eDh);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gjn);
        MessageManager.getInstance().unRegisterListener(this.eDh);
    }

    @Override // com.baidu.tieba.frs.ar
    public void bLP() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        unRegisterListener();
    }
}
