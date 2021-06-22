package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BlackListItemData extends AbstractImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public long f17290e;

    /* renamed from: f  reason: collision with root package name */
    public String f17291f;

    /* renamed from: g  reason: collision with root package name */
    public String f17292g;

    /* renamed from: h  reason: collision with root package name */
    public String f17293h;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(w());
        return arrayList;
    }

    public long getUserId() {
        return this.f17290e;
    }

    public void setUserId(long j) {
        this.f17290e = j;
    }

    public void setUserName(String str) {
        this.f17291f = str;
    }

    public String w() {
        return this.f17292g;
    }

    public String x() {
        if (StringUtils.isNull(this.f17293h)) {
            return this.f17291f;
        }
        return this.f17293h;
    }

    public void y(String str) {
        this.f17292g = str;
    }

    public void z(String str) {
        this.f17293h = str;
    }
}
