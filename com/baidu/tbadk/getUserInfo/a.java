package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData akf;

    public UserData zl() {
        return this.akf;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.akf = new UserData();
            this.akf.parserProtobuf(dataRes.user);
        }
    }
}
