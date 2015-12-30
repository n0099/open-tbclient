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
    private TextView bLg;
    private LinearLayout bLh;
    private TextView bLi;
    private TextView bLj;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.h.msg_msgmid_view);
        this.bLg = null;
        initView();
    }

    private void initView() {
        this.bLg = (TextView) findViewById(n.g.tex_msgcontent);
        this.bLg.setMovementMethod(LinkMovementMethod.getInstance());
        this.bLh = (LinearLayout) findViewById(n.g.lay_add_friend);
        this.bLi = (TextView) findViewById(n.g.btn_add_friend);
        this.bLj = (TextView) findViewById(n.g.text_add_friend);
        this.bLh.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.bLh.setVisibility(8);
        if (chatMessage == null) {
            this.bLg.setText("");
        } else if (!a(chatMessage)) {
            this.bLg.setVisibility(0);
            String w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.bLg.setText(w);
            } else {
                this.bLg.setText("");
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
            this.bLh.setVisibility(0);
            this.bLg.setVisibility(8);
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
            this.bLj.setText(optString2);
            if (optInt == 1) {
                this.bLi.setVisibility(0);
                this.bLi.setText(optString3);
                this.bLi.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
