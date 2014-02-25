package com.baidu.tieba.im.data;

import com.baidu.tieba.util.au;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MemberData extends au implements Serializable {
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

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.portrait);
        return linkedList;
    }
}
