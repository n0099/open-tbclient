package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData fqt;

    public UserData bAl() {
        return this.fqt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fqt = new UserData();
            this.fqt.parserProtobuf(dataRes.user);
        }
    }
}
