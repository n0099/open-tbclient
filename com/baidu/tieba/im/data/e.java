package com.baidu.tieba.im.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.p;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.core.util.a implements p {
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

    public static e a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            e eVar = new e();
            eVar.a(jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_ID, ""));
            eVar.b(jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME, ""));
            eVar.c(jSONObject.optString("user_nickname", ""));
            eVar.d(jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, ""));
            eVar.e(jSONObject.optString("sex", ""));
            return eVar;
        } catch (Exception e) {
            BdLog.e("InviteFriendData", "parserJson", "error = " + e.getMessage());
            return null;
        }
    }

    public boolean a(e eVar) {
        if (eVar == null || eVar.a() == null || a() == null) {
            return false;
        }
        return eVar.a().equals(a());
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.d);
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.view.p
    public boolean isChecked() {
        return this.f;
    }

    @Override // com.baidu.tbadk.core.view.p
    public void setChecked(boolean z) {
        this.f = z;
    }
}
