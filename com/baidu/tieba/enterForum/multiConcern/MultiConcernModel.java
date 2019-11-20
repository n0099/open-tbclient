package com.baidu.tieba.enterForum.multiConcern;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MultiConcernModel extends BdBaseModel {
    private a fct;
    com.baidu.adp.framework.listener.a fcu;

    /* loaded from: classes4.dex */
    public interface a {
        void ag(int i, String str);
    }

    public MultiConcernModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fcu = new com.baidu.adp.framework.listener.a(1003337, CmdConfigSocket.CMD_FORUM_MULTI_CONCERN) { // from class: com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof MultiConcernSocketResponseMessage) || (responsedMessage instanceof MultiConcernHttpResponseMessage)) && MultiConcernModel.this.fct != null) {
                        MultiConcernModel.this.fct.ag(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_MULTI_CONCERN, MultiConcernSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_MULTI_CONCERN, 1003337, Config.FORUM_MULTI_CONCERN, MultiConcernHttpResponseMessage.class, false, false, false, false);
        registerListener(this.fcu);
    }

    public void T(ArrayList<Long> arrayList) {
        if (!v.isEmpty(arrayList)) {
            cancelMessage();
            MultiConcernRequestMessage multiConcernRequestMessage = new MultiConcernRequestMessage();
            multiConcernRequestMessage.setIdList(arrayList);
            sendMessage(multiConcernRequestMessage);
        }
    }

    public void a(a aVar) {
        this.fct = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
