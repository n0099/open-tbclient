package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic aIq = new NewFriendDbManagerStatic();

    static {
        MessageManager.getInstance().registerListener(new a(CmdConfigCustom.CMD_APPLY_MESSAGE));
        MessageManager.getInstance().registerListener(new l(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_ADD_LOCAL));
        MessageManager.getInstance().registerListener(new p(304100));
        MessageManager.getInstance().registerListener(new u(304102));
        MessageManager.getInstance().registerListener(new x(304101));
        MessageManager.getInstance().registerListener(new ac(CmdConfigCustom.CMD_REQUEST_UNREAD_NEW_FRIENDS_NUM));
        MessageManager.getInstance().registerListener(new af(CmdConfigCustom.CMD_DELETE_ACCOUNT));
        ag agVar = new ag(0);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_NEW_FRIEND_LOCAL, agVar);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, agVar);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, agVar);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, agVar);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, agVar);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, agVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID, new ah());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private NewFriendDbManagerStatic() {
    }

    public static NewFriendDbManagerStatic Hk() {
        return aIq;
    }

    public void gn(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.setId(optJSONObject.optLong("user_id"));
                bVar.setName(optJSONObject.optString("user_name"));
                bVar.setPortrait(optJSONObject.optString(IntentConfig.PORTRAIT));
                bVar.setContent(optJSONObject.optString("message"));
                bVar.hQ(0);
                bVar.setStatus(1);
                com.baidu.tbadk.util.n.b(new b(this, bVar), new c(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void go(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                bVar.setId(optJSONObject.optLong("user_id"));
                bVar.setName(optJSONObject.optString("user_name"));
                bVar.setPortrait(optJSONObject.optString(IntentConfig.PORTRAIT));
                bVar.setContent(optJSONObject.optString("message"));
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("pinyin");
                bVar.hQ(0);
                bVar.setStatus(4);
                com.baidu.tbadk.util.n.b(new d(this, bVar), new e(this, bVar, optString, optString2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gp(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tbadk.util.n.b(new f(this, optJSONObject.optLong("user_id")), new g(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gq(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(IntentConfig.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                int optInt = optJSONObject.optInt("type");
                if (optInt == 1) {
                    bVar.setStatus(3);
                } else if (optInt == 2) {
                    bVar.setStatus(1);
                }
                bVar.setContent(optString3);
                bVar.setId(optLong);
                bVar.hQ(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tbadk.util.n.b(new h(this, bVar), new i(this, optLong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gr(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(IntentConfig.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                bVar.setStatus(3);
                bVar.setContent(optString3);
                bVar.setId(optLong);
                bVar.hQ(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tbadk.util.n.b(new j(this, bVar), new k(this, optLong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gs(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(IntentConfig.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                bVar.setStatus(2);
                bVar.setContent(optString3);
                bVar.setId(optLong);
                bVar.hQ(1);
                bVar.setName(optString);
                bVar.setPortrait(optString2);
                com.baidu.tbadk.util.n.b(new n(this, bVar), new o(this, optLong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
