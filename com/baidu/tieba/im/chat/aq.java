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
import com.baidu.tieba.u;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.d<MsglistActivity<?>> {
    private TextView cHQ;
    private LinearLayout cHR;
    private TextView cHS;
    private TextView cHT;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, u.h.msg_msgmid_view);
        this.cHQ = null;
        initView();
    }

    private void initView() {
        this.cHQ = (TextView) findViewById(u.g.tex_msgcontent);
        this.cHQ.setMovementMethod(LinkMovementMethod.getInstance());
        this.cHR = (LinearLayout) findViewById(u.g.lay_add_friend);
        this.cHS = (TextView) findViewById(u.g.btn_add_friend);
        this.cHT = (TextView) findViewById(u.g.text_add_friend);
        this.cHR.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.cHR.setVisibility(8);
        if (chatMessage == null) {
            this.cHQ.setText("");
        } else if (!a(chatMessage)) {
            this.cHQ.setVisibility(0);
            String x = com.baidu.tieba.im.util.h.x(chatMessage);
            if (!TextUtils.isEmpty(x)) {
                this.cHQ.setText(x);
            } else {
                this.cHQ.setText("");
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
            this.cHR.setVisibility(0);
            this.cHQ.setVisibility(8);
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
            this.cHT.setText(optString2);
            if (optInt == 1) {
                this.cHS.setVisibility(0);
                this.cHS.setText(optString3);
                this.cHS.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
