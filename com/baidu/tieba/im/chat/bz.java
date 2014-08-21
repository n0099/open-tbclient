package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bz extends com.baidu.adp.base.d<ChatMessage> {
    private TextView b;
    private LinearLayout c;
    private TextView d;
    private TextView e;

    public bz(Context context) {
        super(context, com.baidu.tieba.v.msg_msgmid_view);
        this.b = null;
        b();
    }

    private void b() {
        this.b = (TextView) a(com.baidu.tieba.u.tex_msgcontent);
        this.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.c = (LinearLayout) a(com.baidu.tieba.u.lay_add_friend);
        this.d = (TextView) a(com.baidu.tieba.u.btn_add_friend);
        this.e = (TextView) a(com.baidu.tieba.u.text_add_friend);
        this.c.setVisibility(8);
    }

    public void a(ChatMessage chatMessage) {
        this.c.setVisibility(8);
        this.c.setVisibility(8);
        if (chatMessage == null) {
            this.b.setText("");
        } else if (!b(chatMessage)) {
            this.b.setVisibility(0);
            String i = com.baidu.tieba.im.d.j.i(chatMessage);
            if (!TextUtils.isEmpty(i)) {
                this.b.setText(i);
            } else {
                this.b.setText("");
            }
        }
    }

    private boolean b(ChatMessage chatMessage) {
        JSONObject jSONObject;
        String optString;
        UserData toUserInfo;
        if (chatMessage == null || !(chatMessage instanceof PersonalChatMessage)) {
            return false;
        }
        if (chatMessage.getMsgType() != 11 || TextUtils.isEmpty(chatMessage.getContent())) {
            return false;
        }
        try {
            jSONObject = new JSONObject(chatMessage.getContent());
            optString = jSONObject.optString("eventId");
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (optString == null) {
            return false;
        }
        if (optString.equals("406")) {
            this.c.setVisibility(0);
            this.b.setVisibility(8);
            String optString2 = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (optJSONObject == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("button_type");
            String optString3 = optJSONObject.optString("name");
            long optLong = optJSONObject.optLong("userId");
            if (chatMessage.getUserId() == optLong) {
                toUserInfo = chatMessage.getUserInfo();
            } else {
                toUserInfo = chatMessage.getToUserInfo();
            }
            String userName = toUserInfo.getUserName();
            String portrait = toUserInfo.getPortrait();
            this.e.setText(optString2);
            if (optInt == 1) {
                this.d.setVisibility(0);
                this.d.setText(optString3);
                this.d.setOnClickListener(new ca(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
