package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class af extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        LiveRoomChatView x;
        if ((customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && p.getCmd() == "live_user_mute") {
            try {
                JSONObject jSONObject = new JSONObject(p.getContent());
                String optString = jSONObject.optString("userMsg");
                int optInt = jSONObject.optJSONObject("eventParam").optInt("type");
                this.a.showToast(optString);
                x = this.a.x();
                if (optInt == 1) {
                    x.ak();
                    x.e(true);
                } else if (optInt == 2) {
                    x.e(false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
