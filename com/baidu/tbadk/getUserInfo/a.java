package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData avu;

    public UserData CD() {
        return this.avu;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.avu = new UserData();
            this.avu.parserProtobuf(dataRes.user);
        }
    }
}
