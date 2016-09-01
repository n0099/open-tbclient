package com.baidu.tieba.im.data;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.util.a {
    private String cYM;
    private long userId;
    private String userName;

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(arV());
        return arrayList;
    }

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

    public String arV() {
        return this.cYM;
    }

    public void lh(String str) {
        this.cYM = str;
    }
}
