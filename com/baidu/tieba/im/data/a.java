package com.baidu.tieba.im.data;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.util.a {
    private String bbV;
    private int userId;
    private String userName;

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Py());
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

    public String Py() {
        return this.bbV;
    }

    public void gl(String str) {
        this.bbV = str;
    }
}
