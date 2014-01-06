package com.baidu.tieba.im.data;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.view.bv;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends ap implements bv {
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

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(jSONObject.optString(PushConstants.EXTRA_USER_ID, ""));
            cVar.b(jSONObject.optString("user_name", ""));
            cVar.c(jSONObject.optString("user_nickname", ""));
            cVar.d(jSONObject.optString("portrait", ""));
            cVar.e(jSONObject.optString("sex", ""));
            return cVar;
        } catch (Exception e) {
            bo.b("InviteFriendData", "parserJson", "error = " + e.getMessage());
            return null;
        }
    }

    public boolean a(c cVar) {
        if (cVar == null || cVar.a() == null || a() == null) {
            return false;
        }
        return cVar.a().equals(a());
    }

    @Override // com.baidu.tieba.util.ap, com.baidu.tieba.util.ar
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.ap, com.baidu.tieba.util.ar
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.d);
        return linkedList;
    }

    @Override // com.baidu.tieba.view.bv
    public boolean d() {
        return this.f;
    }

    @Override // com.baidu.tieba.view.bv
    public void a(boolean z) {
        this.f = z;
    }
}
