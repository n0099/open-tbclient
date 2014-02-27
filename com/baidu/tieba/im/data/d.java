package com.baidu.tieba.im.data;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.au;
import com.baidu.tieba.view.cr;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d extends au implements cr {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f = false;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            d dVar = new d();
            dVar.a = jSONObject.optString(PushConstants.EXTRA_USER_ID, "");
            dVar.b = jSONObject.optString("user_name", "");
            dVar.c = jSONObject.optString("user_nickname", "");
            dVar.d = jSONObject.optString("portrait", "");
            dVar.e = jSONObject.optString("sex", "");
            return dVar;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("InviteFriendData", "parserJson", "error = " + e.getMessage());
            return null;
        }
    }

    public final boolean a(d dVar) {
        if (dVar == null || dVar.a == null || this.a == null) {
            return false;
        }
        return dVar.a.equals(this.a);
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public final LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public final LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.d);
        return linkedList;
    }

    @Override // com.baidu.tieba.view.cr
    public final boolean isChecked() {
        return this.f;
    }

    @Override // com.baidu.tieba.view.cr
    public final void setChecked(boolean z) {
        this.f = z;
    }
}
