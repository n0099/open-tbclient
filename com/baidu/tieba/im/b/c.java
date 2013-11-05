package com.baidu.tieba.im.b;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class c {
    private GroupPermData c;
    private boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    public int f1380a = UtilHelper.a((Context) TiebaApplication.a(), 70.0f);
    public int b = UtilHelper.a((Context) TiebaApplication.a(), 70.0f);

    public GroupPermData a() {
        return this.c;
    }

    public void a(GroupPermData groupPermData) {
        this.c = groupPermData;
    }

    public boolean b() {
        if (this.d) {
            if (UtilHelper.b()) {
                if (com.baidu.tieba.im.c.a.a().c()) {
                    com.baidu.tieba.im.messageCenter.f.a().a(new GroupsByUidMessage(this.f1380a, this.b));
                    return true;
                }
                return true;
            }
            return false;
        }
        this.d = true;
        com.baidu.tieba.im.messageCenter.f.a().a(new GroupsByUidLocalMessage());
        return true;
    }

    public void c() {
        com.baidu.tieba.im.messageCenter.f.a().a(new GroupsByUidMessage(this.f1380a, this.b));
    }
}
