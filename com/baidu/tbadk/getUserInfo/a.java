package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aSH;

    public UserData JW() {
        return this.aSH;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aSH = new UserData();
            this.aSH.parserProtobuf(dataRes.user);
        }
    }
}
