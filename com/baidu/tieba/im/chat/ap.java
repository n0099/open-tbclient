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
    private TextView cPA;
    private TextView cPx;
    private LinearLayout cPy;
    private TextView cPz;

    public ap(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgmid_view);
        this.cPx = null;
        initView();
    }

    private void initView() {
        this.cPx = (TextView) findViewById(w.h.tex_msgcontent);
        this.cPx.setMovementMethod(LinkMovementMethod.getInstance());
        this.cPy = (LinearLayout) findViewById(w.h.lay_add_friend);
        this.cPz = (TextView) findViewById(w.h.btn_add_friend);
        this.cPA = (TextView) findViewById(w.h.text_add_friend);
        this.cPy.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.cPy.setVisibility(8);
        if (chatMessage == null) {
            this.cPx.setText("");
        } else if (!c(chatMessage)) {
            this.cPx.setVisibility(0);
            String x = com.baidu.tieba.im.util.h.x(chatMessage);
            if (!TextUtils.isEmpty(x)) {
                this.cPx.setText(x);
            } else {
                this.cPx.setText("");
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
            this.cPy.setVisibility(0);
            this.cPx.setVisibility(8);
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
            this.cPA.setText(optString2);
            if (optInt == 1) {
                this.cPz.setVisibility(0);
                this.cPz.setText(optString3);
                this.cPz.setOnClickListener(new aq(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
