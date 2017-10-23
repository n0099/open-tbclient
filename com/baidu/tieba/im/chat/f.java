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
    private TextView dmR;
    private LinearLayout dmS;
    private TextView dmT;
    private TextView dmU;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgmid_view);
        this.dmR = null;
        initView();
    }

    private void initView() {
        this.dmR = (TextView) findViewById(d.h.tex_msgcontent);
        this.dmR.setMovementMethod(LinkMovementMethod.getInstance());
        this.dmS = (LinearLayout) findViewById(d.h.lay_add_friend);
        this.dmT = (TextView) findViewById(d.h.btn_add_friend);
        this.dmU = (TextView) findViewById(d.h.text_add_friend);
        this.dmS.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.dmS.setVisibility(8);
        if (chatMessage == null) {
            this.dmR.setText("");
        } else if (!d(chatMessage)) {
            this.dmR.setVisibility(0);
            String y = com.baidu.tieba.im.util.e.y(chatMessage);
            if (!TextUtils.isEmpty(y)) {
                this.dmR.setText(y);
            } else {
                this.dmR.setText("");
            }
        }
    }

    private boolean d(ChatMessage chatMessage) {
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
            this.dmS.setVisibility(0);
            this.dmR.setVisibility(8);
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
            this.dmU.setText(optString2);
            if (optInt == 1) {
                this.dmT.setVisibility(0);
                this.dmT.setText(optString3);
                this.dmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
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
