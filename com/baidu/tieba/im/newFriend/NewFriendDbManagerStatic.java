package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic a = new NewFriendDbManagerStatic();

    static {
        MessageManager.getInstance().registerListener(new a(2001173));
        MessageManager.getInstance().registerListener(new e(304100));
        MessageManager.getInstance().registerListener(new j(304102));
        MessageManager.getInstance().registerListener(new m(304101));
        MessageManager.getInstance().registerListener(new r(2001179));
    }

    private NewFriendDbManagerStatic() {
    }

    public static NewFriendDbManagerStatic a() {
        return a;
    }

    public void a(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
                kVar.a(optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID));
                kVar.a(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME));
                kVar.b(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                kVar.c(optJSONObject.optString("message"));
                kVar.b(0);
                kVar.a(1);
                com.baidu.tieba.im.i.a(new u(this, kVar), new v(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
                kVar.a(optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID));
                kVar.a(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME));
                kVar.b(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                kVar.c(optJSONObject.optString("message"));
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("pinyin");
                kVar.b(0);
                kVar.a(4);
                com.baidu.tieba.im.i.a(new w(this, kVar), new x(this, kVar, optString, optString2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                long optInt = optJSONObject.optInt("friend_id");
                com.baidu.tieba.im.i.a(new c(this, optInt), new d(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
