package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BlackListItemData extends AbstractImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public long f17907e;

    /* renamed from: f  reason: collision with root package name */
    public String f17908f;

    /* renamed from: g  reason: collision with root package name */
    public String f17909g;

    /* renamed from: h  reason: collision with root package name */
    public String f17910h;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(s());
        return arrayList;
    }

    public long getUserId() {
        return this.f17907e;
    }

    public String s() {
        return this.f17909g;
    }

    public void setUserId(long j) {
        this.f17907e = j;
    }

    public void setUserName(String str) {
        this.f17908f = str;
    }

    public String t() {
        if (StringUtils.isNull(this.f17910h)) {
            return this.f17908f;
        }
        return this.f17910h;
    }

    public void u(String str) {
        this.f17909g = str;
    }

    public void v(String str) {
        this.f17910h = str;
    }
}
