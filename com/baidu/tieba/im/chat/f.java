package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends b<MsglistActivity<?>> {
    private TextView dCO;
    private LinearLayout dCP;
    private TextView dCQ;
    private TextView dCR;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgmid_view);
        this.dCO = null;
        initView();
    }

    private void initView() {
        this.dCO = (TextView) findViewById(d.g.tex_msgcontent);
        this.dCO.setMovementMethod(LinkMovementMethod.getInstance());
        this.dCP = (LinearLayout) findViewById(d.g.lay_add_friend);
        this.dCQ = (TextView) findViewById(d.g.btn_add_friend);
        this.dCR = (TextView) findViewById(d.g.text_add_friend);
        this.dCP.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.dCP.setVisibility(8);
        if (chatMessage == null) {
            this.dCO.setText("");
        } else if (!e(chatMessage)) {
            this.dCO.setVisibility(0);
            String z = com.baidu.tieba.im.util.e.z(chatMessage);
            if (!TextUtils.isEmpty(z)) {
                this.dCO.setText(z);
            } else {
                this.dCO.setText("");
            }
        }
    }

    private boolean e(ChatMessage chatMessage) {
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
            this.dCP.setVisibility(0);
            this.dCO.setVisibility(8);
            String optString2 = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (optJSONObject == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("button_type");
            String optString3 = optJSONObject.optString("name");
            final long optLong = optJSONObject.optLong("userId");
            if (chatMessage.getUserId() == optLong) {
                toUserInfo = chatMessage.getUserInfo();
            } else {
                toUserInfo = chatMessage.getToUserInfo();
            }
            final String userName = toUserInfo.getUserName();
            final String portrait = toUserInfo.getPortrait();
            this.dCR.setText(optString2);
            if (optInt == 1) {
                this.dCQ.setVisibility(0);
                this.dCQ.setText(optString3);
                this.dCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(f.this.mContext.getPageActivity(), String.valueOf(optLong), userName, portrait, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
                    }
                });
                return true;
            }
        }
        return false;
    }
}
