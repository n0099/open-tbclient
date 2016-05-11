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
    private TextView bZR;
    private LinearLayout bZS;
    private TextView bZT;
    private TextView bZU;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgmid_view);
        this.bZR = null;
        initView();
    }

    private void initView() {
        this.bZR = (TextView) findViewById(t.g.tex_msgcontent);
        this.bZR.setMovementMethod(LinkMovementMethod.getInstance());
        this.bZS = (LinearLayout) findViewById(t.g.lay_add_friend);
        this.bZT = (TextView) findViewById(t.g.btn_add_friend);
        this.bZU = (TextView) findViewById(t.g.text_add_friend);
        this.bZS.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.bZS.setVisibility(8);
        if (chatMessage == null) {
            this.bZR.setText("");
        } else if (!a(chatMessage)) {
            this.bZR.setVisibility(0);
            String w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.bZR.setText(w);
            } else {
                this.bZR.setText("");
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
            this.bZS.setVisibility(0);
            this.bZR.setVisibility(8);
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
            this.bZU.setText(optString2);
            if (optInt == 1) {
                this.bZT.setVisibility(0);
                this.bZT.setText(optString3);
                this.bZT.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
