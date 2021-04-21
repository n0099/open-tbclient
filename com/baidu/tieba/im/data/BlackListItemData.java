package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BlackListItemData extends AbstractImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public long f17588e;

    /* renamed from: f  reason: collision with root package name */
    public String f17589f;

    /* renamed from: g  reason: collision with root package name */
    public String f17590g;

    /* renamed from: h  reason: collision with root package name */
    public String f17591h;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(s());
        return arrayList;
    }

    public long getUserId() {
        return this.f17588e;
    }

    public String s() {
        return this.f17590g;
    }

    public void setUserId(long j) {
        this.f17588e = j;
    }

    public void setUserName(String str) {
        this.f17589f = str;
    }

    public String t() {
        if (StringUtils.isNull(this.f17591h)) {
            return this.f17589f;
        }
        return this.f17591h;
    }

    public void u(String str) {
        this.f17590g = str;
    }

    public void v(String str) {
        this.f17591h = str;
    }
}
