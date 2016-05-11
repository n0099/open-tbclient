package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.GetFrsTabFollowPostNum.GetFrsTabFollowPostNumResIdl;
/* loaded from: classes.dex */
public class GetFrsTabFollowPostNumHttpResponsedMsg extends HttpResponsedMessage {
    private int mThreadNum;

    public GetFrsTabFollowPostNumHttpResponsedMsg(int i) {
        super(CmdConfigHttp.GET_FRS_TAB_FOLLOW_POST_NUM);
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetFrsTabFollowPostNumResIdl getFrsTabFollowPostNumResIdl = (GetFrsTabFollowPostNumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetFrsTabFollowPostNumResIdl.class);
        if (getFrsTabFollowPostNumResIdl.error != null) {
            setError(getFrsTabFollowPostNumResIdl.error.errorno.intValue());
            setErrorString(getFrsTabFollowPostNumResIdl.error.usermsg);
        }
        if (getError() == 0 && getFrsTabFollowPostNumResIdl.data != null) {
            this.mThreadNum = getFrsTabFollowPostNumResIdl.data.thread_num.intValue();
        }
    }
}
