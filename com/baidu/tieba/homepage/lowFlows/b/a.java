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
public class a implements a.InterfaceC0746a {
    private com.baidu.adp.framework.listener.a eDt;
    private String eTL;
    private boolean isLoading;
    private a.b khn;
    private String mLFUser;
    private String mTaskId;
    private BdUniqueId agC = null;
    private final HashMap<String, List<n>> kge = new HashMap<>();

    public a(a.b bVar) {
        this.khn = bVar;
        cQG();
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.InterfaceC0746a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (!j.isNetworkAvailableForImmediately() || bdUniqueId == null || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            if (this.khn != null) {
                this.khn.BT(-1);
                return false;
            }
            return false;
        } else if (this.isLoading) {
            return false;
        } else {
            if (this.eTL != null && this.eTL.equals(str) && this.kge.size() > 0) {
                this.khn.setData(this.kge.get(str));
                return true;
            }
            t(bdUniqueId);
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

    private void cQG() {
        this.eDt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691) { // from class: com.baidu.tieba.homepage.lowFlows.b.a.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.isLoading = false;
                if (a.this.khn != null) {
                    if (!(responsedMessage instanceof com.baidu.tieba.homepage.lowFlows.message.a)) {
                        a.this.khn.BT(-1);
                    } else if (responsedMessage.getOrginalMessage() == null || a.this.agC != responsedMessage.getOrginalMessage().getTag()) {
                        a.this.khn.BT(-1);
                    } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        a.this.khn.BT(responsedMessage.getError());
                    } else {
                        com.baidu.tieba.homepage.lowFlows.message.a aVar = (com.baidu.tieba.homepage.lowFlows.message.a) responsedMessage;
                        if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                            a.this.khn.BT(-1);
                            return;
                        }
                        if (!StringUtils.isNull(a.this.eTL)) {
                            a.this.kge.put(a.this.eTL, aVar.getDataList());
                        }
                        a.this.khn.a(responsedMessage.getError(), aVar);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eDt);
    }

    public void setTabCode(String str) {
        this.eTL = str;
    }

    public void setLFUser(String str) {
        this.mLFUser = str;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }
}
