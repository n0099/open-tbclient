package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData fcV;

    public UserData bwD() {
        return this.fcV;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fcV = new UserData();
            this.fcV.parserProtobuf(dataRes.user);
        }
    }
}
