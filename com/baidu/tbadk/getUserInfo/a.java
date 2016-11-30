package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aya;

    public UserData Eg() {
        return this.aya;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aya = new UserData();
            this.aya.parserProtobuf(dataRes.user);
        }
    }
}
