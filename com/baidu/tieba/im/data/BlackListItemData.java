package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BlackListItemData extends AbstractImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public long f17903e;

    /* renamed from: f  reason: collision with root package name */
    public String f17904f;

    /* renamed from: g  reason: collision with root package name */
    public String f17905g;

    /* renamed from: h  reason: collision with root package name */
    public String f17906h;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(s());
        return arrayList;
    }

    public long getUserId() {
        return this.f17903e;
    }

    public String s() {
        return this.f17905g;
    }

    public void setUserId(long j) {
        this.f17903e = j;
    }

    public void setUserName(String str) {
        this.f17904f = str;
    }

    public String t() {
        if (StringUtils.isNull(this.f17906h)) {
            return this.f17904f;
        }
        return this.f17906h;
    }

    public void u(String str) {
        this.f17905g = str;
    }

    public void v(String str) {
        this.f17906h = str;
    }
}
