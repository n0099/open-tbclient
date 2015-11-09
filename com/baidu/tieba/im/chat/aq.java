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
    private TextView bst;
    private LinearLayout bsu;
    private TextView bsv;
    private TextView bsw;

    public aq(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgmid_view);
        this.bst = null;
        initView();
    }

    private void initView() {
        this.bst = (TextView) findViewById(i.f.tex_msgcontent);
        this.bst.setMovementMethod(LinkMovementMethod.getInstance());
        this.bsu = (LinearLayout) findViewById(i.f.lay_add_friend);
        this.bsv = (TextView) findViewById(i.f.btn_add_friend);
        this.bsw = (TextView) findViewById(i.f.text_add_friend);
        this.bsu.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.bsu.setVisibility(8);
        if (chatMessage == null) {
            this.bst.setText("");
        } else if (!a(chatMessage)) {
            this.bst.setVisibility(0);
            String w = com.baidu.tieba.im.util.h.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.bst.setText(w);
            } else {
                this.bst.setText("");
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
            this.bsu.setVisibility(0);
            this.bst.setVisibility(8);
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
            this.bsw.setText(optString2);
            if (optInt == 1) {
                this.bsv.setVisibility(0);
                this.bsv.setText(optString3);
                this.bsv.setOnClickListener(new ar(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
