package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BlackListItemData extends AbstractImageProvider {
    private String emd;
    private long userId;
    private String userName;
    private String userNameShow;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(aIo());
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

    public String aIo() {
        return this.emd;
    }

    public void nT(String str) {
        this.emd = str;
    }

    public void fY(String str) {
        this.userNameShow = str;
    }

    public String FA() {
        return StringUtils.isNull(this.userNameShow) ? this.userName : this.userNameShow;
    }
}
