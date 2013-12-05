package com.baidu.tieba.im.c;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
import com.baidu.tieba.im.message.QueryGroupCountMessage;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.im.pushNotify.k;
import com.baidu.tieba.im.pushNotify.l;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1527a = true;
    private int c;
    private int d;
    private e e;
    private boolean b = false;
    private g f = new b(this);
    private k g = new c(this);
    private g h = new d(this);

    public void a(e eVar) {
        this.e = eVar;
    }

    public void a() {
        if (this.b) {
            QueryGroupCountMessage queryGroupCountMessage = new QueryGroupCountMessage();
            queryGroupCountMessage.setLat(TiebaApplication.h().be());
            queryGroupCountMessage.setLng(TiebaApplication.h().bf());
            com.baidu.tieba.im.messageCenter.e.a().a(queryGroupCountMessage);
            return;
        }
        this.b = true;
        com.baidu.tieba.im.messageCenter.e.a().a(new QueryGroupCountLocalMessage());
    }

    @Override // com.baidu.tieba.im.pushNotify.k
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
                    f1527a = true;
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
        l.a().a("apply_join_success", this.g);
        l.a().a("kick_out", this.g);
        l.a().a("dismiss_group", this.g);
    }

    public void c() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.f);
        com.baidu.tieba.im.messageCenter.e.a().a(this.h);
        l.a().a(this.g);
    }
}
