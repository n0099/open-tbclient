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
public class ap extends com.baidu.adp.base.d<MsglistActivity<?>> {
    private TextView cMT;
    private LinearLayout cMU;
    private TextView cMV;
    private TextView cMW;

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.j.msg_msgmid_view);
        this.cMT = null;
        initView();
    }

    private void initView() {
        this.cMT = (TextView) findViewById(r.h.tex_msgcontent);
        this.cMT.setMovementMethod(LinkMovementMethod.getInstance());
        this.cMU = (LinearLayout) findViewById(r.h.lay_add_friend);
        this.cMV = (TextView) findViewById(r.h.btn_add_friend);
        this.cMW = (TextView) findViewById(r.h.text_add_friend);
        this.cMU.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.cMU.setVisibility(8);
        if (chatMessage == null) {
            this.cMT.setText("");
        } else if (!a(chatMessage)) {
            this.cMT.setVisibility(0);
            String v = com.baidu.tieba.im.util.h.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.cMT.setText(v);
            } else {
                this.cMT.setText("");
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
            this.cMU.setVisibility(0);
            this.cMT.setVisibility(8);
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
            this.cMW.setText(optString2);
            if (optInt == 1) {
                this.cMV.setVisibility(0);
                this.cMV.setText(optString3);
                this.cMV.setOnClickListener(new aq(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
