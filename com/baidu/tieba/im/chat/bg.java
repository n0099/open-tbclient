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
    private TextView bal;
    private LinearLayout bam;
    private TextView ban;
    private TextView bao;

    public bg(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.r.msg_msgmid_view);
        this.bal = null;
        initView();
    }

    private void initView() {
        this.bal = (TextView) findViewById(com.baidu.tieba.q.tex_msgcontent);
        this.bal.setMovementMethod(LinkMovementMethod.getInstance());
        this.bam = (LinearLayout) findViewById(com.baidu.tieba.q.lay_add_friend);
        this.ban = (TextView) findViewById(com.baidu.tieba.q.btn_add_friend);
        this.bao = (TextView) findViewById(com.baidu.tieba.q.text_add_friend);
        this.bam.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.bam.setVisibility(8);
        if (chatMessage == null) {
            this.bal.setText("");
        } else if (!a(chatMessage)) {
            this.bal.setVisibility(0);
            String w = com.baidu.tieba.im.util.i.w(chatMessage);
            if (!TextUtils.isEmpty(w)) {
                this.bal.setText(w);
            } else {
                this.bal.setText("");
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
            this.bam.setVisibility(0);
            this.bal.setVisibility(8);
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
            this.bao.setText(optString2);
            if (optInt == 1) {
                this.ban.setVisibility(0);
                this.ban.setText(optString3);
                this.ban.setOnClickListener(new bh(this, optLong, userName, portrait));
                return true;
            }
        }
        return false;
    }
}
