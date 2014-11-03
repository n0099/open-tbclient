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
    private TextView aPd;
    private LinearLayout aPe;
    private TextView aPf;
    private TextView aPg;

    public bz(Context context) {
        super(context, com.baidu.tieba.w.msg_msgmid_view);
        this.aPd = null;
        nu();
    }

    private void nu() {
        this.aPd = (TextView) findViewById(com.baidu.tieba.v.tex_msgcontent);
        this.aPd.setMovementMethod(LinkMovementMethod.getInstance());
        this.aPe = (LinearLayout) findViewById(com.baidu.tieba.v.lay_add_friend);
        this.aPf = (TextView) findViewById(com.baidu.tieba.v.btn_add_friend);
        this.aPg = (TextView) findViewById(com.baidu.tieba.v.text_add_friend);
        this.aPe.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.aPe.setVisibility(8);
        if (chatMessage == null) {
            this.aPd.setText("");
        } else if (!g(chatMessage)) {
            this.aPd.setVisibility(0);
            String w = com.baidu.tieba.im.util.i.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.aPd.setText(w);
            } else {
                this.aPd.setText("");
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
            this.aPe.setVisibility(0);
            this.aPd.setVisibility(8);
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
            this.aPg.setText(optString2);
            if (optInt == 1) {
                this.aPf.setVisibility(0);
                this.aPf.setText(optString3);
                this.aPf.setOnClickListener(new ca(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
