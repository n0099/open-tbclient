package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData ata;

    public UserData BX() {
        return this.ata;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ata = new UserData();
            this.ata.parserProtobuf(dataRes.user);
        }
    }
}
