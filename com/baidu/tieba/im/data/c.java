package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.view.p;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c extends com.baidu.tbadk.core.util.a implements p {
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

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a = jSONObject.optString("user_id", "");
            cVar.b = jSONObject.optString("user_name", "");
            cVar.c = jSONObject.optString("user_nickname", "");
            cVar.d = jSONObject.optString("portrait", "");
            cVar.e = jSONObject.optString("sex", "");
            return cVar;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("InviteFriendData", "parserJson", "error = " + e.getMessage());
            return null;
        }
    }

    public final boolean a(c cVar) {
        if (cVar == null || cVar.a == null || this.a == null) {
            return false;
        }
        return cVar.a.equals(this.a);
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.d);
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.view.p
    public final boolean isChecked() {
        return this.f;
    }

    @Override // com.baidu.tbadk.core.view.p
    public final void setChecked(boolean z) {
        this.f = z;
    }
}
