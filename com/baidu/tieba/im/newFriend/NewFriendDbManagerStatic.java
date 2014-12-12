package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic bjC = new NewFriendDbManagerStatic();

    static {
        MessageManager.getInstance().registerListener(new a(2001222));
        MessageManager.getInstance().registerListener(new l(2001173));
        MessageManager.getInstance().registerListener(new o(304100));
        MessageManager.getInstance().registerListener(new t(304102));
        MessageManager.getInstance().registerListener(new w(304101));
        MessageManager.getInstance().registerListener(new ab(2001179));
        MessageManager.getInstance().registerListener(new ae(2001193));
        af afVar = new af(0);
        MessageManager.getInstance().registerListener(2001215, afVar);
        MessageManager.getInstance().registerListener(2001176, afVar);
        MessageManager.getInstance().registerListener(2001177, afVar);
        MessageManager.getInstance().registerListener(2001225, afVar);
        MessageManager.getInstance().registerListener(2001226, afVar);
        MessageManager.getInstance().registerListener(2001227, afVar);
    }

    private NewFriendDbManagerStatic() {
    }

    public static NewFriendDbManagerStatic RB() {
        return bjC;
    }

    public void gU(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.setId(optJSONObject.optInt("user_id"));
                bVar.setName(optJSONObject.optString("user_name"));
                bVar.setPortrait(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                bVar.setContent(optJSONObject.optString("message"));
                bVar.fz(0);
                bVar.setStatus(1);
                com.baidu.tieba.im.i.a(new ag(this, bVar), new b(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gV(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.setId(optJSONObject.optInt("user_id"));
                bVar.setName(optJSONObject.optString("user_name"));
                bVar.setPortrait(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                bVar.setContent(optJSONObject.optString("message"));
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("pinyin");
                bVar.fz(0);
                bVar.setStatus(4);
                com.baidu.tieba.im.i.a(new c(this, bVar), new d(this, bVar, optString, optString2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gW(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.i.a(new e(this, optJSONObject.optInt("user_id")), new f(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gX(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optInt = optJSONObject.optInt("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                int optInt2 = optJSONObject.optInt("type");
                if (optInt2 == 1) {
                    bVar.setStatus(3);
                } else if (optInt2 == 2) {
                    bVar.setStatus(1);
                }
                bVar.setContent(optString3);
                bVar.setId(optInt);
                bVar.fz(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tieba.im.i.a(new g(this, bVar), new h(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gY(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optInt = optJSONObject.optInt("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                bVar.setStatus(3);
                bVar.setContent(optString3);
                bVar.setId(optInt);
                bVar.fz(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tieba.im.i.a(new i(this, bVar), new j(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gZ(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optInt = optJSONObject.optInt("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                bVar.setStatus(2);
                bVar.setContent(optString3);
                bVar.setId(optInt);
                bVar.fz(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tieba.im.i.a(new k(this, bVar), new n(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
