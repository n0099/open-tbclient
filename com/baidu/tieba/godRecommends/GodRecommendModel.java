package com.baidu.tieba.godRecommends;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes3.dex */
public class GodRecommendModel extends BdBaseModel {
    private boolean mIsLoading;

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigHttp.CMD_GET_GOD_RECOMMEND, 309471, TbConfig.URL_GET_RECOMMEND_GOD, GodRecommendHttpResponseMessage.class, GodRecommendSocketMessage.class);
    }

    public GodRecommendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void np(String str) {
        if (!this.mIsLoading) {
            GodRecommendRequestMessage godRecommendRequestMessage = new GodRecommendRequestMessage();
            godRecommendRequestMessage.userId = str;
            sendMessage(godRecommendRequestMessage);
            this.mIsLoading = true;
        }
    }

    public void aBr() {
        this.mIsLoading = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destory() {
        cancelMessage();
        this.mIsLoading = false;
    }
}
