package com.baidu.tieba.enterForum.multiConcern;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MultiConcernModel extends BdBaseModel {
    com.baidu.adp.framework.listener.a bJt;
    private a bTO;

    /* loaded from: classes.dex */
    public interface a {
        void z(int i, String str);
    }

    public MultiConcernModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bJt = new com.baidu.tieba.enterForum.multiConcern.a(this, CmdConfigHttp.CMD_FORUM_MULTI_CONCERN, 309470);
        setUniqueId(BdUniqueId.gen());
        com.baidu.tieba.tbadkCore.a.a.a(309470, MultiConcernSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309470, CmdConfigHttp.CMD_FORUM_MULTI_CONCERN, "c/f/recommtag/multiConcern", MultiConcernHttpResponseMessage.class, false, false, false, false);
        registerListener(this.bJt);
    }

    public void C(ArrayList<Long> arrayList) {
        if (!z.t(arrayList)) {
            cancelMessage();
            MultiConcernRequestMessage multiConcernRequestMessage = new MultiConcernRequestMessage();
            multiConcernRequestMessage.setIdList(arrayList);
            sendMessage(multiConcernRequestMessage);
        }
    }

    public void a(a aVar) {
        this.bTO = aVar;
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
