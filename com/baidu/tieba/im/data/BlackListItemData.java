package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BlackListItemData extends AbstractImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public long f17208e;

    /* renamed from: f  reason: collision with root package name */
    public String f17209f;

    /* renamed from: g  reason: collision with root package name */
    public String f17210g;

    /* renamed from: h  reason: collision with root package name */
    public String f17211h;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(w());
        return arrayList;
    }

    public long getUserId() {
        return this.f17208e;
    }

    public void setUserId(long j) {
        this.f17208e = j;
    }

    public void setUserName(String str) {
        this.f17209f = str;
    }

    public String w() {
        return this.f17210g;
    }

    public String x() {
        if (StringUtils.isNull(this.f17211h)) {
            return this.f17209f;
        }
        return this.f17211h;
    }

    public void y(String str) {
        this.f17210g = str;
    }

    public void z(String str) {
        this.f17211h = str;
    }
}
