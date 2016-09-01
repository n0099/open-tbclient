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
    private TextView cTw;
    private LinearLayout cTx;
    private TextView cTy;
    private TextView cTz;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgmid_view);
        this.cTw = null;
        initView();
    }

    private void initView() {
        this.cTw = (TextView) findViewById(t.g.tex_msgcontent);
        this.cTw.setMovementMethod(LinkMovementMethod.getInstance());
        this.cTx = (LinearLayout) findViewById(t.g.lay_add_friend);
        this.cTy = (TextView) findViewById(t.g.btn_add_friend);
        this.cTz = (TextView) findViewById(t.g.text_add_friend);
        this.cTx.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.cTx.setVisibility(8);
        if (chatMessage == null) {
            this.cTw.setText("");
        } else if (!a(chatMessage)) {
            this.cTw.setVisibility(0);
            String x = com.baidu.tieba.im.util.h.x(chatMessage);
            if (!TextUtils.isEmpty(x)) {
                this.cTw.setText(x);
            } else {
                this.cTw.setText("");
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
            this.cTx.setVisibility(0);
            this.cTw.setVisibility(8);
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
            this.cTz.setText(optString2);
            if (optInt == 1) {
                this.cTy.setVisibility(0);
                this.cTy.setText(optString3);
                this.cTy.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
