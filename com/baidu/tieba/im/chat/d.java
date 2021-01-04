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
public class d extends com.baidu.adp.base.c<MsglistActivity<?>> {
    private TextView kwP;
    private LinearLayout kwQ;
    private TextView kwR;
    private TextView kwS;

    public d(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.kwP = null;
        initView();
    }

    private void initView() {
        this.kwP = (TextView) findViewById(R.id.tex_msgcontent);
        this.kwP.setMovementMethod(LinkMovementMethod.getInstance());
        this.kwQ = (LinearLayout) findViewById(R.id.lay_add_friend);
        this.kwR = (TextView) findViewById(R.id.btn_add_friend);
        this.kwS = (TextView) findViewById(R.id.text_add_friend);
        this.kwQ.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.kwQ.setVisibility(8);
        if (chatMessage == null) {
            this.kwP.setText("");
        } else if (!a(chatMessage)) {
            this.kwP.setVisibility(0);
            String v = com.baidu.tieba.im.util.c.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.kwP.setText(v);
            } else {
                this.kwP.setText("");
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
            this.kwQ.setVisibility(0);
            this.kwP.setVisibility(8);
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
            this.kwS.setText(optString2);
            if (optInt == 1) {
                this.kwR.setVisibility(0);
                this.kwR.setText(optString3);
                this.kwR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(d.this.mContext.getPageActivity(), String.valueOf(optLong), userName, portrait, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
                    }
                });
                return true;
            }
        }
        return false;
    }
}
