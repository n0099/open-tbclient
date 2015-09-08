package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData auD;

    public UserData Ck() {
        return this.auD;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.auD = new UserData();
            this.auD.parserProtobuf(dataRes.user);
        }
    }
}
