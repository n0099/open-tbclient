package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.b<MsglistActivity<?>> {
    private TextView gyP;
    private LinearLayout gyQ;
    private TextView gyR;
    private TextView gyS;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.gyP = null;
        initView();
    }

    private void initView() {
        this.gyP = (TextView) findViewById(R.id.tex_msgcontent);
        this.gyP.setMovementMethod(LinkMovementMethod.getInstance());
        this.gyQ = (LinearLayout) findViewById(R.id.lay_add_friend);
        this.gyR = (TextView) findViewById(R.id.btn_add_friend);
        this.gyS = (TextView) findViewById(R.id.text_add_friend);
        this.gyQ.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.gyQ.setVisibility(8);
        if (chatMessage == null) {
            this.gyP.setText("");
        } else if (!a(chatMessage)) {
            this.gyP.setVisibility(0);
            String v = com.baidu.tieba.im.util.e.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.gyP.setText(v);
            } else {
                this.gyP.setText("");
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
            optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (optString == null) {
            return false;
        }
        if (optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
            this.gyQ.setVisibility(0);
            this.gyP.setVisibility(8);
            String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
            JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("button_type");
            String optString3 = optJSONObject.optString("name");
            final long optLong = optJSONObject.optLong(TbEnum.SystemMessage.KEY_USER_ID);
            if (chatMessage.getUserId() == optLong) {
                toUserInfo = chatMessage.getUserInfo();
            } else {
                toUserInfo = chatMessage.getToUserInfo();
            }
            final String userName = toUserInfo.getUserName();
            final String portrait = toUserInfo.getPortrait();
            this.gyS.setText(optString2);
            if (optInt == 1) {
                this.gyR.setVisibility(0);
                this.gyR.setText(optString3);
                this.gyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
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
