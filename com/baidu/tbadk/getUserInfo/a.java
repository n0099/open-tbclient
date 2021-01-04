package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData fHQ;

    public UserData bGh() {
        return this.fHQ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fHQ = new UserData();
            this.fHQ.parserProtobuf(dataRes.user);
        }
    }
}
