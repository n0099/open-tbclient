package com.baidu.tbadk.coreExtra.relationship;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes.dex */
public class h {
    private List<b> SU;
    private String mKey;

    public String getKey() {
        return this.mKey;
    }

    public List<b> getContacts() {
        if (this.SU == null) {
            this.SU = new ArrayList();
        }
        return this.SU;
    }

    public void a(listData listdata) {
        if (listdata != null) {
            this.mKey = listdata.key;
            if (listdata.friend_list != null) {
                this.SU = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    b bVar = new b();
                    bVar.a(friendlist);
                    bVar.dB(this.mKey);
                    this.SU.add(bVar);
                }
            }
        }
    }

    public void a(robotsList robotslist) {
        if (robotslist != null) {
            this.mKey = robotslist.key;
            if (robotslist.friend_list != null) {
                this.SU = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    b bVar = new b();
                    bVar.a(friendlist);
                    bVar.dB(this.mKey);
                    this.SU.add(bVar);
                }
            }
        }
    }
}
