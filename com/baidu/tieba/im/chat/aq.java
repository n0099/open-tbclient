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
import com.baidu.tieba.n;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.d<MsglistActivity<?>> {
    private LinearLayout bHA;
    private TextView bHB;
    private TextView bHC;
    private TextView bHz;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.g.msg_msgmid_view);
        this.bHz = null;
        initView();
    }

    private void initView() {
        this.bHz = (TextView) findViewById(n.f.tex_msgcontent);
        this.bHz.setMovementMethod(LinkMovementMethod.getInstance());
        this.bHA = (LinearLayout) findViewById(n.f.lay_add_friend);
        this.bHB = (TextView) findViewById(n.f.btn_add_friend);
        this.bHC = (TextView) findViewById(n.f.text_add_friend);
        this.bHA.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.bHA.setVisibility(8);
        if (chatMessage == null) {
            this.bHz.setText("");
        } else if (!a(chatMessage)) {
            this.bHz.setVisibility(0);
            String w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.bHz.setText(w);
            } else {
                this.bHz.setText("");
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
            this.bHA.setVisibility(0);
            this.bHz.setVisibility(8);
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
            this.bHC.setText(optString2);
            if (optInt == 1) {
                this.bHB.setVisibility(0);
                this.bHB.setText(optString3);
                this.bHB.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
