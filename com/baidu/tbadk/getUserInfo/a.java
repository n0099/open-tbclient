package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData axG;

    public UserData Eb() {
        return this.axG;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.axG = new UserData();
            this.axG.parserProtobuf(dataRes.user);
        }
    }
}
