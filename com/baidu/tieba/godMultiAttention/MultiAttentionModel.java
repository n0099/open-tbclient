package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.a.a;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiAttentionModel extends BdBaseModel {
    private boolean mIsLoading;

    static {
        a.b(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388, TbConfig.MULTI_FOLLOW, MultiAttentionHttpResponseMessage.class, MultiAttentionSocketResponseMessage.class);
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

    public void aIi() {
        this.mIsLoading = false;
    }

    public void destory() {
        cancelMessage();
        this.mIsLoading = false;
    }

    public void k(List<String> list, boolean z) {
        if (!v.J(list) && !this.mIsLoading) {
            MultiAttentionRequestMessage multiAttentionRequestMessage = new MultiAttentionRequestMessage();
            multiAttentionRequestMessage.setPortraitList(list);
            multiAttentionRequestMessage.setAttentionAll(z);
            multiAttentionRequestMessage.setNetType(NetMessage.NetType.HTTP);
            sendMessage(multiAttentionRequestMessage);
        }
    }
}
