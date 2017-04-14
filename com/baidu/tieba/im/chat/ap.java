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
    private TextView cNF;
    private LinearLayout cNG;
    private TextView cNH;
    private TextView cNI;

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgmid_view);
        this.cNF = null;
        initView();
    }

    private void initView() {
        this.cNF = (TextView) findViewById(w.h.tex_msgcontent);
        this.cNF.setMovementMethod(LinkMovementMethod.getInstance());
        this.cNG = (LinearLayout) findViewById(w.h.lay_add_friend);
        this.cNH = (TextView) findViewById(w.h.btn_add_friend);
        this.cNI = (TextView) findViewById(w.h.text_add_friend);
        this.cNG.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.cNG.setVisibility(8);
        if (chatMessage == null) {
            this.cNF.setText("");
        } else if (!a(chatMessage)) {
            this.cNF.setVisibility(0);
            String v = com.baidu.tieba.im.util.h.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.cNF.setText(v);
            } else {
                this.cNF.setText("");
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
            this.cNG.setVisibility(0);
            this.cNF.setVisibility(8);
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
            this.cNI.setText(optString2);
            if (optInt == 1) {
                this.cNH.setVisibility(0);
                this.cNH.setText(optString3);
                this.cNH.setOnClickListener(new aq(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
