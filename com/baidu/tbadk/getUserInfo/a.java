package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData ZH;

    public UserData vL() {
        return this.ZH;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ZH = new UserData();
            this.ZH.parserProtobuf(dataRes.user);
        }
    }
}
