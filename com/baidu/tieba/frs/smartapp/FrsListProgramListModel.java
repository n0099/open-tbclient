package com.baidu.tieba.frs.smartapp;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class FrsListProgramListModel extends BdBaseModel<BaseFragmentActivity> {
    private com.baidu.adp.framework.listener.a gIA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_SMART_APP, 309623) { // from class: com.baidu.tieba.frs.smartapp.FrsListProgramListModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            FrsListProgramListHttpResponseMessage frsListProgramListHttpResponseMessage;
            if (responsedMessage instanceof FrsListProgramListSocketResponseMessage) {
                FrsListProgramListSocketResponseMessage frsListProgramListSocketResponseMessage = (FrsListProgramListSocketResponseMessage) responsedMessage;
                if (frsListProgramListSocketResponseMessage != null) {
                    FrsListProgramListModel.this.gIz.a(frsListProgramListSocketResponseMessage.getList(), frsListProgramListSocketResponseMessage.getError(), frsListProgramListSocketResponseMessage.getErrorString(), frsListProgramListSocketResponseMessage.hasMore);
                } else {
                    return;
                }
            }
            if ((responsedMessage instanceof FrsListProgramListHttpResponseMessage) && (frsListProgramListHttpResponseMessage = (FrsListProgramListHttpResponseMessage) responsedMessage) != null) {
                FrsListProgramListModel.this.gIz.a(frsListProgramListHttpResponseMessage.getList(), frsListProgramListHttpResponseMessage.getError(), frsListProgramListHttpResponseMessage.getErrorString(), frsListProgramListHttpResponseMessage.hasMore);
            }
        }
    };
    private a gIz;

    /* loaded from: classes9.dex */
    public interface a {
        void a(ArrayList<b> arrayList, int i, String str, boolean z);
    }

    public FrsListProgramListModel(a aVar) {
        this.gIz = aVar;
        registerListener(this.gIA);
        com.baidu.tieba.tbadkCore.a.a.c(309623, FrsListProgramListSocketResponseMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(309623, CmdConfigHttp.CMD_HTTP_SMART_APP, TbConfig.SMART_APP_URL, FrsListProgramListHttpResponseMessage.class, false, false, true, false);
    }

    public void s(String str, int i, int i2) {
        FrsListProgramListRequestMessage frsListProgramListRequestMessage = new FrsListProgramListRequestMessage();
        frsListProgramListRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(str, 0L));
        frsListProgramListRequestMessage.setRn(String.valueOf(i2));
        frsListProgramListRequestMessage.setPn(i);
        MessageManager.getInstance().sendMessage(frsListProgramListRequestMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gIA);
    }
}
