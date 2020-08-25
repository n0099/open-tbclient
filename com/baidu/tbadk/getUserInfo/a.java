package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes2.dex */
public class a {
    private UserData eNS;

    public UserData bsO() {
        return this.eNS;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eNS = new UserData();
            this.eNS.parserProtobuf(dataRes.user);
        }
    }
}
