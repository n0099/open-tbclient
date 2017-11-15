package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aEG;

    public UserData Ei() {
        return this.aEG;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aEG = new UserData();
            this.aEG.parserProtobuf(dataRes.user);
        }
    }
}
