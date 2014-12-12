package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData Zj;

    public UserData vz() {
        return this.Zj;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.Zj = new UserData();
            this.Zj.parserProtobuf(dataRes.user);
        }
    }
}
