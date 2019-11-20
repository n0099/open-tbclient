package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData cHH;

    public UserData avj() {
        return this.cHH;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cHH = new UserData();
            this.cHH.parserProtobuf(dataRes.user);
        }
    }
}
