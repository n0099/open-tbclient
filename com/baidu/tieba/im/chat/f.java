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
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.b<MsglistActivity<?>> {
    private TextView gsO;
    private LinearLayout gsP;
    private TextView gsQ;
    private TextView gsR;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.gsO = null;
        initView();
    }

    private void initView() {
        this.gsO = (TextView) findViewById(R.id.tex_msgcontent);
        this.gsO.setMovementMethod(LinkMovementMethod.getInstance());
        this.gsP = (LinearLayout) findViewById(R.id.lay_add_friend);
        this.gsQ = (TextView) findViewById(R.id.btn_add_friend);
        this.gsR = (TextView) findViewById(R.id.text_add_friend);
        this.gsP.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.gsP.setVisibility(8);
        if (chatMessage == null) {
            this.gsO.setText("");
        } else if (!f(chatMessage)) {
            this.gsO.setVisibility(0);
            String A = com.baidu.tieba.im.util.e.A(chatMessage);
            if (!TextUtils.isEmpty(A)) {
                this.gsO.setText(A);
            } else {
                this.gsO.setText("");
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
            this.gsP.setVisibility(0);
            this.gsO.setVisibility(8);
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
            this.gsR.setText(optString2);
            if (optInt == 1) {
                this.gsQ.setVisibility(0);
                this.gsQ.setText(optString3);
                this.gsQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
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
