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
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.b<MsglistActivity<?>> {
    private TextView edd;
    private LinearLayout ede;
    private TextView edf;
    private TextView edg;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgmid_view);
        this.edd = null;
        initView();
    }

    private void initView() {
        this.edd = (TextView) findViewById(d.g.tex_msgcontent);
        this.edd.setMovementMethod(LinkMovementMethod.getInstance());
        this.ede = (LinearLayout) findViewById(d.g.lay_add_friend);
        this.edf = (TextView) findViewById(d.g.btn_add_friend);
        this.edg = (TextView) findViewById(d.g.text_add_friend);
        this.ede.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.ede.setVisibility(8);
        if (chatMessage == null) {
            this.edd.setText("");
        } else if (!f(chatMessage)) {
            this.edd.setVisibility(0);
            String A = com.baidu.tieba.im.util.e.A(chatMessage);
            if (!TextUtils.isEmpty(A)) {
                this.edd.setText(A);
            } else {
                this.edd.setText("");
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
            this.ede.setVisibility(0);
            this.edd.setVisibility(8);
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
            this.edg.setText(optString2);
            if (optInt == 1) {
                this.edf.setVisibility(0);
                this.edf.setText(optString3);
                this.edf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
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
