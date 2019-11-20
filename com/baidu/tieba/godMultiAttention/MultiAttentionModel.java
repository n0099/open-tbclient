package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.a.a;
import java.util.List;
/* loaded from: classes6.dex */
public class MultiAttentionModel extends BdBaseModel {
    private boolean mIsLoading;

    static {
        a.b(1003105, CmdConfigSocket.MULTI_ATTENTION_SOCKET_CMD, TbConfig.MULTI_FOLLOW, MultiAttentionHttpResponseMessage.class, MultiAttentionSocketResponseMessage.class);
    }

    public MultiAttentionModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bsp() {
        this.mIsLoading = false;
    }

    public void destory() {
        cancelMessage();
        this.mIsLoading = false;
    }

    public void m(List<String> list, boolean z) {
        if (!v.isEmpty(list) && !this.mIsLoading) {
            MultiAttentionRequestMessage multiAttentionRequestMessage = new MultiAttentionRequestMessage();
            multiAttentionRequestMessage.setPortraitList(list);
            multiAttentionRequestMessage.setAttentionAll(z);
            multiAttentionRequestMessage.setNetType(NetMessage.NetType.HTTP);
            sendMessage(multiAttentionRequestMessage);
        }
    }
}
