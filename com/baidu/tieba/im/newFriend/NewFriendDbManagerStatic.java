package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic bgK = new NewFriendDbManagerStatic();

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

    public static NewFriendDbManagerStatic Rh() {
        return bgK;
    }

    public void gt(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                eVar.setId(optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID));
                eVar.setName(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME));
                eVar.setPortrait(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                eVar.setContent(optJSONObject.optString("message"));
                eVar.fw(0);
                eVar.setStatus(1);
                com.baidu.tieba.im.e.a(new ag(this, eVar), new b(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gu(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                eVar.setId(optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID));
                eVar.setName(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME));
                eVar.setPortrait(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                eVar.setContent(optJSONObject.optString("message"));
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("pinyin");
                eVar.fw(0);
                eVar.setStatus(4);
                com.baidu.tieba.im.e.a(new c(this, eVar), new d(this, eVar, optString, optString2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gv(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.e.a(new e(this, optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID)), new f(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gw(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                long optInt = optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                String optString = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                int optInt2 = optJSONObject.optInt("type");
                if (optInt2 == 1) {
                    eVar.setStatus(3);
                } else if (optInt2 == 2) {
                    eVar.setStatus(1);
                }
                eVar.setContent(optString3);
                eVar.setId(optInt);
                eVar.fw(1);
                eVar.setName(optString);
                eVar.setPortrait(optString2);
                com.baidu.tieba.im.e.a(new g(this, eVar), new h(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gx(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                long optInt = optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                String optString = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                eVar.setStatus(3);
                eVar.setContent(optString3);
                eVar.setId(optInt);
                eVar.fw(1);
                eVar.setName(optString);
                eVar.setPortrait(optString2);
                com.baidu.tieba.im.e.a(new i(this, eVar), new j(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gy(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                long optInt = optJSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                String optString = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                eVar.setStatus(2);
                eVar.setContent(optString3);
                eVar.setId(optInt);
                eVar.fw(1);
                eVar.setName(optString);
                eVar.setPortrait(optString2);
                com.baidu.tieba.im.e.a(new k(this, eVar), new n(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
