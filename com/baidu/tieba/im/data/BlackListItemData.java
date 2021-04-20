package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BlackListItemData extends AbstractImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public long f17580e;

    /* renamed from: f  reason: collision with root package name */
    public String f17581f;

    /* renamed from: g  reason: collision with root package name */
    public String f17582g;

    /* renamed from: h  reason: collision with root package name */
    public String f17583h;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(s());
        return arrayList;
    }

    public long getUserId() {
        return this.f17580e;
    }

    public String s() {
        return this.f17582g;
    }

    public void setUserId(long j) {
        this.f17580e = j;
    }

    public void setUserName(String str) {
        this.f17581f = str;
    }

    public String t() {
        if (StringUtils.isNull(this.f17583h)) {
            return this.f17581f;
        }
        return this.f17583h;
    }

    public void u(String str) {
        this.f17582g = str;
    }

    public void v(String str) {
        this.f17583h = str;
    }
}
