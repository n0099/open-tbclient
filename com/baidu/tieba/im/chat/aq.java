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
import com.baidu.tieba.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.d<MsglistActivity<?>> {
    private TextView daB;
    private LinearLayout daC;
    private TextView daD;
    private TextView daE;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_msgmid_view);
        this.daB = null;
        initView();
    }

    private void initView() {
        this.daB = (TextView) findViewById(r.g.tex_msgcontent);
        this.daB.setMovementMethod(LinkMovementMethod.getInstance());
        this.daC = (LinearLayout) findViewById(r.g.lay_add_friend);
        this.daD = (TextView) findViewById(r.g.btn_add_friend);
        this.daE = (TextView) findViewById(r.g.text_add_friend);
        this.daC.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.daC.setVisibility(8);
        if (chatMessage == null) {
            this.daB.setText("");
        } else if (!a(chatMessage)) {
            this.daB.setVisibility(0);
            String x = com.baidu.tieba.im.util.h.x(chatMessage);
            if (!TextUtils.isEmpty(x)) {
                this.daB.setText(x);
            } else {
                this.daB.setText("");
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
            this.daC.setVisibility(0);
            this.daB.setVisibility(8);
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
            this.daE.setText(optString2);
            if (optInt == 1) {
                this.daD.setVisibility(0);
                this.daD.setText(optString3);
                this.daD.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
