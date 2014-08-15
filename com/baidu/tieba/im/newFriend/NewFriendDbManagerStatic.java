package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic a = new NewFriendDbManagerStatic();

    static {
        MessageManager.getInstance().registerListener(new a(2001222));
        MessageManager.getInstance().registerListener(new i(2001173));
        MessageManager.getInstance().registerListener(new k(304100));
        MessageManager.getInstance().registerListener(new p(304102));
        MessageManager.getInstance().registerListener(new s(304101));
        MessageManager.getInstance().registerListener(new x(2001179));
        MessageManager.getInstance().registerListener(new aa(2001193));
        ab abVar = new ab(0);
        MessageManager.getInstance().registerListener(2001215, abVar);
        MessageManager.getInstance().registerListener(2001176, abVar);
        MessageManager.getInstance().registerListener(2001177, abVar);
        MessageManager.getInstance().registerListener(2001225, abVar);
        MessageManager.getInstance().registerListener(2001226, abVar);
        MessageManager.getInstance().registerListener(2001227, abVar);
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
                com.baidu.tieba.im.e.a(new ac(this, kVar), new b(this));
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
                com.baidu.tieba.im.e.a(new c(this, kVar), new d(this, kVar, optString, optString2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.e.a(new e(this, optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID)), new f(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
                long optInt = optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                String optString = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                kVar.c(optJSONObject.optString("message"));
                kVar.a(optInt);
                kVar.b(0);
                kVar.a(optString);
                kVar.b(optString2);
                kVar.a(0);
                com.baidu.tieba.im.e.a(new g(this, optInt, kVar), new h(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
