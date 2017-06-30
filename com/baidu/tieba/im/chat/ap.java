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
    private TextView cXt;
    private LinearLayout cXu;
    private TextView cXv;
    private TextView cXw;

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgmid_view);
        this.cXt = null;
        initView();
    }

    private void initView() {
        this.cXt = (TextView) findViewById(w.h.tex_msgcontent);
        this.cXt.setMovementMethod(LinkMovementMethod.getInstance());
        this.cXu = (LinearLayout) findViewById(w.h.lay_add_friend);
        this.cXv = (TextView) findViewById(w.h.btn_add_friend);
        this.cXw = (TextView) findViewById(w.h.text_add_friend);
        this.cXu.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.cXu.setVisibility(8);
        if (chatMessage == null) {
            this.cXt.setText("");
        } else if (!c(chatMessage)) {
            this.cXt.setVisibility(0);
            String x = com.baidu.tieba.im.util.h.x(chatMessage);
            if (!TextUtils.isEmpty(x)) {
                this.cXt.setText(x);
            } else {
                this.cXt.setText("");
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
            this.cXu.setVisibility(0);
            this.cXt.setVisibility(8);
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
            this.cXw.setText(optString2);
            if (optInt == 1) {
                this.cXv.setVisibility(0);
                this.cXv.setText(optString3);
                this.cXv.setOnClickListener(new aq(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
