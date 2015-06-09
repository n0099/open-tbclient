package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic azN = new NewFriendDbManagerStatic();

    static {
        MessageManager.getInstance().registerListener(new a(2001222));
        MessageManager.getInstance().registerListener(new l(2001173));
        MessageManager.getInstance().registerListener(new p(304100));
        MessageManager.getInstance().registerListener(new u(304102));
        MessageManager.getInstance().registerListener(new x(304101));
        MessageManager.getInstance().registerListener(new ac(2001179));
        MessageManager.getInstance().registerListener(new af(2001193));
        ag agVar = new ag(0);
        MessageManager.getInstance().registerListener(2001215, agVar);
        MessageManager.getInstance().registerListener(2001176, agVar);
        MessageManager.getInstance().registerListener(2001177, agVar);
        MessageManager.getInstance().registerListener(2001225, agVar);
        MessageManager.getInstance().registerListener(2001226, agVar);
        MessageManager.getInstance().registerListener(2001227, agVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001312, new ah());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private NewFriendDbManagerStatic() {
    }

    public static NewFriendDbManagerStatic FQ() {
        return azN;
    }

    public void fu(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.setId(optJSONObject.optInt("user_id"));
                bVar.setName(optJSONObject.optString("user_name"));
                bVar.setPortrait(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT));
                bVar.setContent(optJSONObject.optString("message"));
                bVar.fY(0);
                bVar.setStatus(1);
                com.baidu.tieba.im.l.a(new b(this, bVar), new c(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fv(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.setId(optJSONObject.optInt("user_id"));
                bVar.setName(optJSONObject.optString("user_name"));
                bVar.setPortrait(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT));
                bVar.setContent(optJSONObject.optString("message"));
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("pinyin");
                bVar.fY(0);
                bVar.setStatus(4);
                com.baidu.tieba.im.l.a(new d(this, bVar), new e(this, bVar, optString, optString2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fw(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.l.a(new f(this, optJSONObject.optInt("user_id")), new g(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fx(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optInt = optJSONObject.optInt("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                int optInt2 = optJSONObject.optInt("type");
                if (optInt2 == 1) {
                    bVar.setStatus(3);
                } else if (optInt2 == 2) {
                    bVar.setStatus(1);
                }
                bVar.setContent(optString3);
                bVar.setId(optInt);
                bVar.fY(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tieba.im.l.a(new h(this, bVar), new i(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fy(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optInt = optJSONObject.optInt("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                bVar.setStatus(3);
                bVar.setContent(optString3);
                bVar.setId(optInt);
                bVar.fY(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tieba.im.l.a(new j(this, bVar), new k(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fz(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optInt = optJSONObject.optInt("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                bVar.setStatus(2);
                bVar.setContent(optString3);
                bVar.setId(optInt);
                bVar.fY(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tieba.im.l.a(new n(this, bVar), new o(this, optInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
