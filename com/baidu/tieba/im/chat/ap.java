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
import com.baidu.tieba.w;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.d<MsglistActivity<?>> {
    private TextView cJZ;
    private LinearLayout cKa;
    private TextView cKb;
    private TextView cKc;

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgmid_view);
        this.cJZ = null;
        initView();
    }

    private void initView() {
        this.cJZ = (TextView) findViewById(w.h.tex_msgcontent);
        this.cJZ.setMovementMethod(LinkMovementMethod.getInstance());
        this.cKa = (LinearLayout) findViewById(w.h.lay_add_friend);
        this.cKb = (TextView) findViewById(w.h.btn_add_friend);
        this.cKc = (TextView) findViewById(w.h.text_add_friend);
        this.cKa.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.cKa.setVisibility(8);
        if (chatMessage == null) {
            this.cJZ.setText("");
        } else if (!c(chatMessage)) {
            this.cJZ.setVisibility(0);
            String x = com.baidu.tieba.im.util.h.x(chatMessage);
            if (!TextUtils.isEmpty(x)) {
                this.cJZ.setText(x);
            } else {
                this.cJZ.setText("");
            }
        }
    }

    private boolean c(ChatMessage chatMessage) {
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
            this.cKa.setVisibility(0);
            this.cJZ.setVisibility(8);
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
            this.cKc.setText(optString2);
            if (optInt == 1) {
                this.cKb.setVisibility(0);
                this.cKb.setText(optString3);
                this.cKb.setOnClickListener(new aq(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
