package com.baidu.tieba.ala.livecard.models;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ba;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements an {
    private BdUniqueId fEN;
    private int hiZ;
    private ba hja;
    private ar hjb;
    ArrayList<n> dataList = new ArrayList<>();
    private com.baidu.adp.framework.listener.a hjc = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.livecard.models.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.fEN) {
                List<Long> list = null;
                if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                }
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage ? ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds() : list;
                if (!x.isEmpty(a.this.dataList) && !x.isEmpty(closedIds)) {
                    boolean z2 = false;
                    int size = a.this.dataList.size() - 1;
                    while (size >= 0) {
                        if (a.this.dataList.get(size).getType() != bz.eOz) {
                            z = z2;
                        } else {
                            bz bzVar = (bz) a.this.dataList.get(size);
                            if (bzVar != null) {
                                if (bzVar.bnQ() == null) {
                                    z = z2;
                                } else if (closedIds.contains(Long.valueOf(bzVar.bnQ().live_id))) {
                                    a.this.dataList.remove(size);
                                    z = true;
                                }
                            }
                            z = z2;
                        }
                        size--;
                        z2 = z;
                    }
                    if (z2 && a.this.hjb != null) {
                        a.this.hjb.a(49, a.this.hiZ, a.this.hja, a.this.dataList);
                    }
                }
            }
        }
    };
    private HttpMessageListener fro = new HttpMessageListener(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD) { // from class: com.baidu.tieba.ala.livecard.models.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    a.this.hjb.a(49, a.this.hiZ, null, null);
                } else if (((FrsPageAlaTabResponseMessage) httpResponsedMessage).errCode != 0) {
                    if (a.this.hjb != null) {
                        a.this.hjb.a(49, a.this.hiZ, null, null);
                    }
                } else {
                    ArrayList<n> arrayList = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mThreadList;
                    ArrayList<n> arrayList2 = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).mAltList;
                    ba baVar = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).pageInfo;
                    int i = ((FrsPageAlaTabResponseMessage) httpResponsedMessage).alaLiveCount;
                    a.this.hja = baVar;
                    if (baVar.pn == 1) {
                        a.this.dataList.clear();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT, Integer.valueOf(i)));
                    if (a.this.hjb != null) {
                        if (arrayList != null && arrayList.size() > 0) {
                            a.this.dataList.addAll(arrayList);
                            a.this.hjb.a(49, a.this.hiZ, baVar, a.this.dataList);
                            return;
                        }
                        bz bzVar = new bz();
                        bzVar.setThreadType(51);
                        if (a.this.dataList.size() == 0 || (a.this.dataList.size() > 0 && ((bz) a.this.dataList.get(0)).getThreadType() != 51)) {
                            a.this.dataList.add(0, bzVar);
                        }
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            bzVar.eQF = true;
                            if (arrayList2.get(0) != null) {
                                ((bz) arrayList2.get(0)).eQE = true;
                            }
                            a.this.dataList.addAll(arrayList2);
                        }
                        a.this.hjb.a(49, a.this.hiZ, baVar, a.this.dataList);
                    }
                }
            }
        }
    };

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fEN = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        this.hiZ = i2;
        if (axVar != null && !TextUtils.isEmpty(axVar.forumName) && !TextUtils.isEmpty(axVar.forumId)) {
            if (axVar.pn <= 0) {
                axVar.pn = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, axVar.forumName, axVar.forumId, axVar.pn));
            return;
        }
        this.hjb.a(49, this.hiZ, null, null);
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.hjb = arVar;
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener();
    }

    private void registerListener() {
        if (this.fEN != null) {
            this.fro.setTag(this.fEN);
            this.hjc.setTag(this.fEN);
        }
        MessageManager.getInstance().registerListener(this.hjc);
        MessageManager.getInstance().registerListener(this.fro);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.hjc);
        MessageManager.getInstance().unRegisterListener(this.fro);
    }

    @Override // com.baidu.tieba.frs.an
    public void bXP() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        unRegisterListener();
    }
}
