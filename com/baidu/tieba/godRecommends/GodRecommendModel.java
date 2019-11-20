package com.baidu.tieba.godRecommends;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class GodRecommendModel extends BdBaseModel {
    private boolean mIsLoading;

    static {
        com.baidu.tieba.tbadkCore.a.a.b(1003375, CmdConfigSocket.CMD_GET_GOD_RECOMMEND, TbConfig.URL_GET_RECOMMEND_GOD, GodRecommendHttpResponseMessage.class, GodRecommendSocketMessage.class);
    }

    public GodRecommendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void wL(String str) {
        if (!this.mIsLoading) {
            GodRecommendRequestMessage godRecommendRequestMessage = new GodRecommendRequestMessage();
            godRecommendRequestMessage.userId = str;
            sendMessage(godRecommendRequestMessage);
            this.mIsLoading = true;
        }
    }

    public void bsp() {
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
