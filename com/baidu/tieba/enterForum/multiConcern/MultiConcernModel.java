package com.baidu.tieba.enterForum.multiConcern;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MultiConcernModel extends BdBaseModel {
    com.baidu.adp.framework.listener.a cXQ;
    private a diB;

    /* loaded from: classes2.dex */
    public interface a {
        void B(int i, String str);
    }

    public MultiConcernModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cXQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FORUM_MULTI_CONCERN, 309470) { // from class: com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof MultiConcernSocketResponseMessage) || (responsedMessage instanceof MultiConcernHttpResponseMessage)) && MultiConcernModel.this.diB != null) {
                        MultiConcernModel.this.diB.B(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        setUniqueId(BdUniqueId.gen());
        com.baidu.tieba.tbadkCore.a.a.a(309470, MultiConcernSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309470, CmdConfigHttp.CMD_FORUM_MULTI_CONCERN, "c/f/recommtag/multiConcern", MultiConcernHttpResponseMessage.class, false, false, false, false);
        registerListener(this.cXQ);
    }

    public void E(ArrayList<Long> arrayList) {
        if (!v.G(arrayList)) {
            cancelMessage();
            MultiConcernRequestMessage multiConcernRequestMessage = new MultiConcernRequestMessage();
            multiConcernRequestMessage.setIdList(arrayList);
            sendMessage(multiConcernRequestMessage);
        }
    }

    public void a(a aVar) {
        this.diB = aVar;
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
