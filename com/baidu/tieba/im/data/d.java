package com.baidu.tieba.im.data;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.al;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.bp;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements al, bp {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f = false;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String c() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            d dVar = new d();
            dVar.a(jSONObject.optString(PushConstants.EXTRA_USER_ID, ""));
            dVar.b(jSONObject.optString("user_name", ""));
            dVar.c(jSONObject.optString("user_nickname", ""));
            dVar.d(jSONObject.optString("portrait", ""));
            dVar.e(jSONObject.optString("sex", ""));
            return dVar;
        } catch (Exception e) {
            be.b("InviteFriendData", "parserJson", "error = " + e.getMessage());
            return null;
        }
    }

    public boolean a(d dVar) {
        if (dVar == null || dVar.a() == null || a() == null) {
            return false;
        }
        return dVar.a().equals(a());
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.d);
        return linkedList;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.view.bp
    public boolean d() {
        return this.f;
    }

    @Override // com.baidu.tieba.view.bp
    public void a(boolean z) {
        this.f = z;
    }
}
