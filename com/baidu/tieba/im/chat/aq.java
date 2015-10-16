package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.d<MsglistActivity<?>> {
    private TextView brP;
    private LinearLayout brQ;
    private TextView brR;
    private TextView brS;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgmid_view);
        this.brP = null;
        initView();
    }

    private void initView() {
        this.brP = (TextView) findViewById(i.f.tex_msgcontent);
        this.brP.setMovementMethod(LinkMovementMethod.getInstance());
        this.brQ = (LinearLayout) findViewById(i.f.lay_add_friend);
        this.brR = (TextView) findViewById(i.f.btn_add_friend);
        this.brS = (TextView) findViewById(i.f.text_add_friend);
        this.brQ.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.brQ.setVisibility(8);
        if (chatMessage == null) {
            this.brP.setText("");
        } else if (!a(chatMessage)) {
            this.brP.setVisibility(0);
            String w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.brP.setText(w);
            } else {
                this.brP.setText("");
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
            this.brQ.setVisibility(0);
            this.brP.setVisibility(8);
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
            this.brS.setText(optString2);
            if (optInt == 1) {
                this.brR.setVisibility(0);
                this.brR.setText(optString3);
                this.brR.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
