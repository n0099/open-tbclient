package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BlackListItemData extends AbstractImageProvider {
    private String eik;
    private long userId;
    private String userName;
    private String userNameShow;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(aHH());
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

    public String aHH() {
        return this.eik;
    }

    public void nS(String str) {
        this.eik = str;
    }

    public void fU(String str) {
        this.userNameShow = str;
    }

    public String Fi() {
        return StringUtils.isNull(this.userNameShow) ? this.userName : this.userNameShow;
    }
}
