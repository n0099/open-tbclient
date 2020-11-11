package com.baidu.tieba.hottopicselect;

import GetSugTopic.GetSugTopicResIdl;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
/* loaded from: classes21.dex */
public class HotSelectCacheResponseMessage extends CustomResponsedMessage<Object> {
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    public c mBangData;
    public c mUserData;
    private int resultStatus;

    public HotSelectCacheResponseMessage() {
        super(CmdConfigCustom.CMD_HOT_TOPIC_SELECT_CACHE);
    }

    public int getResultStatus() {
        return this.resultStatus;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetSugTopicResIdl getSugTopicResIdl;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        byte[] bArr2 = com.baidu.tbadk.core.c.a.boX().dH("topic_select_space", currentAccount).get("topic_select_user");
        if (bArr2 == null) {
            this.resultStatus = 1;
        }
        try {
            getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr2, GetSugTopicResIdl.class);
        } catch (IOException e) {
            this.resultStatus = 3;
            getSugTopicResIdl = null;
        }
        if (getSugTopicResIdl == null || getSugTopicResIdl.data == null) {
            this.resultStatus = 3;
        }
        if (getSugTopicResIdl.data.user_his_topic != null) {
            c cVar = new c();
            cVar.a(getSugTopicResIdl.data.user_his_topic);
            cVar.setType(0);
            this.mUserData = cVar;
        }
        if (getSugTopicResIdl.data.bang_topic != null) {
            c cVar2 = new c();
            cVar2.a(getSugTopicResIdl.data.bang_topic);
            cVar2.setType(1);
            this.mBangData = cVar2;
        }
        this.resultStatus = 2;
    }
}
