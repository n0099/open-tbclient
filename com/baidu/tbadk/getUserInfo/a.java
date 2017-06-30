package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aDc;

    public UserData DS() {
        return this.aDc;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aDc = new UserData();
            this.aDc.parserProtobuf(dataRes.user);
        }
    }
}
