package com.baidu.tieba.hottopicselect;

import GetSugTopic.GetSugTopicResIdl;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import d.a.j0.r.r.a;
import d.a.k0.d1.c;
import java.io.IOException;
/* loaded from: classes4.dex */
public class HotSelectCacheResponseMessage extends CustomResponsedMessage<Object> {
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    public c mBangData;
    public c mUserData;
    public int resultStatus;

    public HotSelectCacheResponseMessage() {
        super(2016491);
    }

    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        byte[] bArr2 = a.f().e("topic_select_space", currentAccount).get("topic_select_user");
        GetSugTopicResIdl getSugTopicResIdl = null;
        if (bArr2 == null) {
            this.resultStatus = 1;
        }
        try {
            getSugTopicResIdl = (GetSugTopicResIdl) new Wire(new Class[0]).parseFrom(bArr2, GetSugTopicResIdl.class);
        } catch (IOException unused) {
            this.resultStatus = 3;
        }
        if (getSugTopicResIdl == null || getSugTopicResIdl.data == null) {
            this.resultStatus = 3;
        }
        if (getSugTopicResIdl.data.user_his_topic != null) {
            c cVar = new c();
            cVar.d(getSugTopicResIdl.data.user_his_topic);
            cVar.f(0);
            this.mUserData = cVar;
        }
        if (getSugTopicResIdl.data.bang_topic != null) {
            c cVar2 = new c();
            cVar2.d(getSugTopicResIdl.data.bang_topic);
            cVar2.f(1);
            this.mBangData = cVar2;
        }
        this.resultStatus = 2;
    }

    public int getResultStatus() {
        return this.resultStatus;
    }
}
