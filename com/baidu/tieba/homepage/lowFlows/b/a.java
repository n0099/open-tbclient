package com.baidu.tieba.homepage.lowFlows.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.a;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements a.InterfaceC0753a {
    private com.baidu.adp.framework.listener.a eEU;
    private String eVm;
    private boolean isLoading;
    private a.b kjE;
    private String mLFUser;
    private String mTaskId;
    private BdUniqueId ahU = null;
    private final HashMap<String, List<n>> kiv = new HashMap<>();

    public a(a.b bVar) {
        this.kjE = bVar;
        cQU();
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.InterfaceC0753a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (!j.isNetworkAvailableForImmediately() || bdUniqueId == null || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            if (this.kjE != null) {
                this.kjE.BW(-1);
                return false;
            }
            return false;
        } else if (this.isLoading) {
            return false;
        } else {
            if (this.eVm != null && this.eVm.equals(str) && this.kiv.size() > 0) {
                this.kjE.setData(this.kiv.get(str));
                return true;
            }
            u(bdUniqueId);
            setTabCode(str);
            setLFUser(str2);
            setTaskId(str3);
            MoreTreasureTroveReqMsg moreTreasureTroveReqMsg = new MoreTreasureTroveReqMsg();
            moreTreasureTroveReqMsg.setTag(bdUniqueId);
            moreTreasureTroveReqMsg.setTabCode(str);
            moreTreasureTroveReqMsg.setLfUser(str2);
            moreTreasureTroveReqMsg.setTaskId(str3);
            this.isLoading = MessageManager.getInstance().sendMessage(moreTreasureTroveReqMsg);
            return this.isLoading;
        }
    }

    private void cQU() {
        this.eEU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691) { // from class: com.baidu.tieba.homepage.lowFlows.b.a.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.isLoading = false;
                if (a.this.kjE != null) {
                    if (!(responsedMessage instanceof com.baidu.tieba.homepage.lowFlows.message.a)) {
                        a.this.kjE.BW(-1);
                    } else if (responsedMessage.getOrginalMessage() == null || a.this.ahU != responsedMessage.getOrginalMessage().getTag()) {
                        a.this.kjE.BW(-1);
                    } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        a.this.kjE.BW(responsedMessage.getError());
                    } else {
                        com.baidu.tieba.homepage.lowFlows.message.a aVar = (com.baidu.tieba.homepage.lowFlows.message.a) responsedMessage;
                        if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                            a.this.kjE.BW(-1);
                            return;
                        }
                        if (!StringUtils.isNull(a.this.eVm)) {
                            a.this.kiv.put(a.this.eVm, aVar.getDataList());
                        }
                        a.this.kjE.a(responsedMessage.getError(), aVar);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eEU);
    }

    public void setTabCode(String str) {
        this.eVm = str;
    }

    public void setLFUser(String str) {
        this.mLFUser = str;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public void u(BdUniqueId bdUniqueId) {
        this.ahU = bdUniqueId;
    }
}
