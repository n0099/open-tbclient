package com.baidu.tieba.im.data;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MemberData extends com.baidu.tbadk.core.util.a implements Serializable {
    private static final long serialVersionUID = 6241193622633380508L;
    private String portrait;
    private long userId;
    private String userName;

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.portrait);
        return arrayList;
    }
}
