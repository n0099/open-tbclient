package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes8.dex */
public class MultiAttentionModel extends BdBaseModel {
    static {
        a.b(1003105, CmdConfigSocket.MULTI_ATTENTION_SOCKET_CMD, TbConfig.MULTI_FOLLOW, MultiAttentionHttpResponseMessage.class, MultiAttentionSocketResponseMessage.class);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
