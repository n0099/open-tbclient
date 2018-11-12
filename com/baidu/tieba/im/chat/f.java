package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.b<MsglistActivity<?>> {
    private TextView eBn;
    private LinearLayout eBo;
    private TextView eBp;
    private TextView eBq;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgmid_view);
        this.eBn = null;
        initView();
    }

    private void initView() {
        this.eBn = (TextView) findViewById(e.g.tex_msgcontent);
        this.eBn.setMovementMethod(LinkMovementMethod.getInstance());
        this.eBo = (LinearLayout) findViewById(e.g.lay_add_friend);
        this.eBp = (TextView) findViewById(e.g.btn_add_friend);
        this.eBq = (TextView) findViewById(e.g.text_add_friend);
        this.eBo.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.eBo.setVisibility(8);
        if (chatMessage == null) {
            this.eBn.setText("");
        } else if (!f(chatMessage)) {
            this.eBn.setVisibility(0);
            String A = com.baidu.tieba.im.util.e.A(chatMessage);
            if (!TextUtils.isEmpty(A)) {
                this.eBn.setText(A);
            } else {
                this.eBn.setText("");
            }
        }
    }

    private boolean f(ChatMessage chatMessage) {
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
            this.eBo.setVisibility(0);
            this.eBn.setVisibility(8);
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
            this.eBq.setText(optString2);
            if (optInt == 1) {
                this.eBp.setVisibility(0);
                this.eBp.setText(optString3);
                this.eBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(f.this.mContext.getPageActivity(), String.valueOf(optLong), userName, portrait, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
                    }
                });
                return true;
            }
        }
        return false;
    }
}
