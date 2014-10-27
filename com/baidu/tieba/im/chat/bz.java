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
    private TextView aOP;
    private LinearLayout aOQ;
    private TextView aOR;
    private TextView aOS;

    public bz(Context context) {
        super(context, com.baidu.tieba.w.msg_msgmid_view);
        this.aOP = null;
        nu();
    }

    private void nu() {
        this.aOP = (TextView) findViewById(com.baidu.tieba.v.tex_msgcontent);
        this.aOP.setMovementMethod(LinkMovementMethod.getInstance());
        this.aOQ = (LinearLayout) findViewById(com.baidu.tieba.v.lay_add_friend);
        this.aOR = (TextView) findViewById(com.baidu.tieba.v.btn_add_friend);
        this.aOS = (TextView) findViewById(com.baidu.tieba.v.text_add_friend);
        this.aOQ.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.aOQ.setVisibility(8);
        if (chatMessage == null) {
            this.aOP.setText("");
        } else if (!g(chatMessage)) {
            this.aOP.setVisibility(0);
            String w = com.baidu.tieba.im.util.i.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.aOP.setText(w);
            } else {
                this.aOP.setText("");
            }
        }
    }

    private boolean g(ChatMessage chatMessage) {
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
            this.aOQ.setVisibility(0);
            this.aOP.setVisibility(8);
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
            this.aOS.setText(optString2);
            if (optInt == 1) {
                this.aOR.setVisibility(0);
                this.aOR.setText(optString3);
                this.aOR.setOnClickListener(new ca(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
