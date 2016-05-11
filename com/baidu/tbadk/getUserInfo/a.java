package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData asU;

    public UserData Cy() {
        return this.asU;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.asU = new UserData();
            this.asU.parserProtobuf(dataRes.user);
        }
    }
}
