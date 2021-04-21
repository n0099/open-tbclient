package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.j0.d3.d0.a;
/* loaded from: classes4.dex */
public class MultiAttentionModel extends BdBaseModel {
    static {
        a.d(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388, TbConfig.MULTI_FOLLOW, MultiAttentionHttpResponseMessage.class, MultiAttentionSocketResponseMessage.class);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
