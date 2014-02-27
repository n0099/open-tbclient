package com.baidu.tieba.a;

import android.app.Activity;
import android.content.Intent;
import com.baidu.tieba.im.data.GroupData;
/* loaded from: classes.dex */
public final class b extends com.baidu.tieba.f.a {
    private GroupData a;
    private String b;

    public b(Activity activity, int i, String str, long j, String str2) {
        super(activity);
        this.a = null;
        this.b = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        groupData.setName(str);
        groupData.setAuthorId(j);
        this.a = groupData;
        this.b = str2;
        Intent d = d();
        d.putExtra("chat_mode", 0);
        d.putExtra("group", groupData);
        d.putExtra("is_accept_notify", true);
        d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public final GroupData a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }
}
