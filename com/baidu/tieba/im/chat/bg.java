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
public class bg extends com.baidu.adp.base.e<MsglistActivity<?>> {
    private TextView aXE;
    private LinearLayout aXF;
    private TextView aXG;
    private TextView aXH;

    public bg(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.w.msg_msgmid_view);
        this.aXE = null;
        initView();
    }

    private void initView() {
        this.aXE = (TextView) findViewById(com.baidu.tieba.v.tex_msgcontent);
        this.aXE.setMovementMethod(LinkMovementMethod.getInstance());
        this.aXF = (LinearLayout) findViewById(com.baidu.tieba.v.lay_add_friend);
        this.aXG = (TextView) findViewById(com.baidu.tieba.v.btn_add_friend);
        this.aXH = (TextView) findViewById(com.baidu.tieba.v.text_add_friend);
        this.aXF.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.aXF.setVisibility(8);
        if (chatMessage == null) {
            this.aXE.setText("");
        } else if (!a(chatMessage)) {
            this.aXE.setVisibility(0);
            String w = com.baidu.tieba.im.util.i.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.aXE.setText(w);
            } else {
                this.aXE.setText("");
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
            this.aXF.setVisibility(0);
            this.aXE.setVisibility(8);
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
            this.aXH.setText(optString2);
            if (optInt == 1) {
                this.aXG.setVisibility(0);
                this.aXG.setText(optString3);
                this.aXG.setOnClickListener(new bh(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
