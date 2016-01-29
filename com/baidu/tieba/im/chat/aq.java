package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.t;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.d<MsglistActivity<?>> {
    private TextView bOU;
    private LinearLayout bOV;
    private TextView bOW;
    private TextView bOX;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgmid_view);
        this.bOU = null;
        initView();
    }

    private void initView() {
        this.bOU = (TextView) findViewById(t.g.tex_msgcontent);
        this.bOU.setMovementMethod(LinkMovementMethod.getInstance());
        this.bOV = (LinearLayout) findViewById(t.g.lay_add_friend);
        this.bOW = (TextView) findViewById(t.g.btn_add_friend);
        this.bOX = (TextView) findViewById(t.g.text_add_friend);
        this.bOV.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.bOV.setVisibility(8);
        if (chatMessage == null) {
            this.bOU.setText("");
        } else if (!a(chatMessage)) {
            this.bOU.setVisibility(0);
            String w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.bOU.setText(w);
            } else {
                this.bOU.setText("");
            }
        }
    }

    private boolean a(ChatMessage chatMessage) {
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
            this.bOV.setVisibility(0);
            this.bOU.setVisibility(8);
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
            this.bOX.setText(optString2);
            if (optInt == 1) {
                this.bOW.setVisibility(0);
                this.bOW.setText(optString3);
                this.bOW.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
