package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData eQN;

    public UserData btT() {
        return this.eQN;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eQN = new UserData();
            this.eQN.parserProtobuf(dataRes.user);
        }
    }
}
