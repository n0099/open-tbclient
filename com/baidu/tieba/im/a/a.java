package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.c.l;
import com.baidu.tieba.im.c.m;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.t;
import com.baidu.tieba.im.message.u;
import com.baidu.tieba.im.messageCenter.g;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements l {
    public static boolean a = true;
    private int c;
    private int d;
    private e e;
    private boolean b = false;
    private g f = new b(this);
    private l g = new c(this);
    private g h = new d(this);

    public void a(e eVar) {
        this.e = eVar;
    }

    public void a() {
        if (this.b) {
            u uVar = new u();
            uVar.b(TiebaApplication.h().be());
            uVar.a(TiebaApplication.h().bf());
            com.baidu.tieba.im.messageCenter.e.a().a(uVar);
            return;
        }
        this.b = true;
        com.baidu.tieba.im.messageCenter.e.a().a(new t());
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("dismiss_group")) {
                b(groupNewsPojo);
            }
        }
    }

    private void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if (new JSONObject(groupNewsPojo.getContent()).getString("eventId").equals("107")) {
                    a = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b() {
        com.baidu.tieba.im.messageCenter.e.a().a(103011, this.f);
        com.baidu.tieba.im.messageCenter.e.a().a(-114, this.f);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this.h);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.h);
        com.baidu.tieba.im.messageCenter.e.a().a(103102, this.h);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.h);
        m.a().a("apply_join_success", this.g);
        m.a().a("kick_out", this.g);
        m.a().a("dismiss_group", this.g);
    }

    public void c() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.f);
        com.baidu.tieba.im.messageCenter.e.a().a(this.h);
        m.a().a(this.g);
    }
}
