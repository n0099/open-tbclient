package com.baidu.tieba.im.data;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.util.a {
    private String aWv;
    private int userId;
    private String userName;

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Mj());
        return arrayList;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String Mj() {
        return this.aWv;
    }

    public void gg(String str) {
        this.aWv = str;
    }
}
