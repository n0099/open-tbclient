package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData fyj;

    public UserData bDN() {
        return this.fyj;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fyj = new UserData();
            this.fyj.parserProtobuf(dataRes.user);
        }
    }
}
