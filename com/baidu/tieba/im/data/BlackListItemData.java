package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BlackListItemData extends AbstractImageProvider {
    private String bUG;
    private long userId;
    private String userName;
    private String userNameShow;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Yf());
        return arrayList;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String Yf() {
        return this.bUG;
    }

    public void jd(String str) {
        this.bUG = str;
    }

    public void CZ(String str) {
        this.userNameShow = str;
    }

    public String bxr() {
        return StringUtils.isNull(this.userNameShow) ? this.userName : this.userNameShow;
    }
}
