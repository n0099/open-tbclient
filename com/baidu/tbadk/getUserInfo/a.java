package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData alo;

    public UserData Ae() {
        return this.alo;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.alo = new UserData();
            this.alo.parserProtobuf(dataRes.user);
        }
    }
}
