package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BlackListItemData extends AbstractImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public long f17902e;

    /* renamed from: f  reason: collision with root package name */
    public String f17903f;

    /* renamed from: g  reason: collision with root package name */
    public String f17904g;

    /* renamed from: h  reason: collision with root package name */
    public String f17905h;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(s());
        return arrayList;
    }

    public long getUserId() {
        return this.f17902e;
    }

    public String s() {
        return this.f17904g;
    }

    public void setUserId(long j) {
        this.f17902e = j;
    }

    public void setUserName(String str) {
        this.f17903f = str;
    }

    public String t() {
        if (StringUtils.isNull(this.f17905h)) {
            return this.f17903f;
        }
        return this.f17905h;
    }

    public void u(String str) {
        this.f17904g = str;
    }

    public void v(String str) {
        this.f17905h = str;
    }
}
