package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData bvz;

    public UserData Mn() {
        return this.bvz;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bvz = new UserData();
            this.bvz.parserProtobuf(dataRes.user);
        }
    }
}
