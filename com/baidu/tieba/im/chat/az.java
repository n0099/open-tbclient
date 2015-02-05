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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.e<MsglistActivity<?>> {
    private TextView aRW;
    private LinearLayout aRX;
    private TextView aRY;
    private TextView aRZ;

    public az(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgmid_view);
        this.aRW = null;
        initView();
    }

    private void initView() {
        this.aRW = (TextView) findViewById(com.baidu.tieba.w.tex_msgcontent);
        this.aRW.setMovementMethod(LinkMovementMethod.getInstance());
        this.aRX = (LinearLayout) findViewById(com.baidu.tieba.w.lay_add_friend);
        this.aRY = (TextView) findViewById(com.baidu.tieba.w.btn_add_friend);
        this.aRZ = (TextView) findViewById(com.baidu.tieba.w.text_add_friend);
        this.aRX.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.aRX.setVisibility(8);
        if (chatMessage == null) {
            this.aRW.setText("");
        } else if (!a(chatMessage)) {
            this.aRW.setVisibility(0);
            String v = com.baidu.tieba.im.util.i.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.aRW.setText(v);
            } else {
                this.aRW.setText("");
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
            this.aRX.setVisibility(0);
            this.aRW.setVisibility(8);
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
            this.aRZ.setText(optString2);
            if (optInt == 1) {
                this.aRY.setVisibility(0);
                this.aRY.setText(optString3);
                this.aRY.setOnClickListener(new ba(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
