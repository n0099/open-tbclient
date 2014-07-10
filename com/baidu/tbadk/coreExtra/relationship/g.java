package com.baidu.tbadk.coreExtra.relationship;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
/* loaded from: classes.dex */
public class g {
    private String a;
    private List<b> b;

    public String a() {
        return this.a;
    }

    public List<b> b() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        return this.b;
    }

    public void a(listData listdata) {
        if (listdata != null) {
            this.a = listdata.key;
            if (listdata.friend_list != null) {
                this.b = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    b bVar = new b();
                    bVar.a(friendlist);
                    bVar.d(this.a);
                    this.b.add(bVar);
                }
            }
        }
    }
}
