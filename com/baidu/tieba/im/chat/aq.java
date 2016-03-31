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
    private TextView bZm;
    private LinearLayout bZn;
    private TextView bZo;
    private TextView bZp;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgmid_view);
        this.bZm = null;
        initView();
    }

    private void initView() {
        this.bZm = (TextView) findViewById(t.g.tex_msgcontent);
        this.bZm.setMovementMethod(LinkMovementMethod.getInstance());
        this.bZn = (LinearLayout) findViewById(t.g.lay_add_friend);
        this.bZo = (TextView) findViewById(t.g.btn_add_friend);
        this.bZp = (TextView) findViewById(t.g.text_add_friend);
        this.bZn.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.bZn.setVisibility(8);
        if (chatMessage == null) {
            this.bZm.setText("");
        } else if (!a(chatMessage)) {
            this.bZm.setVisibility(0);
            String w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.bZm.setText(w);
            } else {
                this.bZm.setText("");
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
            this.bZn.setVisibility(0);
            this.bZm.setVisibility(8);
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
            this.bZp.setText(optString2);
            if (optInt == 1) {
                this.bZo.setVisibility(0);
                this.bZo.setText(optString3);
                this.bZo.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
