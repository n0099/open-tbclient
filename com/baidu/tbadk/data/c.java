package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId awY = BdUniqueId.gen();
    public String awZ;
    private com.baidu.tbadk.core.data.UserData mUserData;
    public long mUserId;
    private int size;
    public String userName;

    public c() {
        if (this.mUserData != null) {
            this.mUserId = com.baidu.adp.lib.g.b.c(this.mUserData.getUserId(), 0L);
            this.userName = this.mUserData.getUserName();
            this.awZ = TbadkCoreApplication.m9getInst().getResources().getString(w.l.my_module);
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return awY;
    }

    public void a(com.baidu.tbadk.core.data.UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            this.mUserId = com.baidu.adp.lib.g.b.c(this.mUserData.getUserId(), 0L);
            this.userName = this.mUserData.getUserName();
            this.awZ = TbadkCoreApplication.m9getInst().getResources().getString(w.l.my_module);
        }
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }
}
