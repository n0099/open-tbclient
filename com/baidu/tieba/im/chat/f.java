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
    private TextView iQN;
    private LinearLayout iQO;
    private TextView iQP;
    private TextView iQQ;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.iQN = null;
        initView();
    }

    private void initView() {
        this.iQN = (TextView) findViewById(R.id.tex_msgcontent);
        this.iQN.setMovementMethod(LinkMovementMethod.getInstance());
        this.iQO = (LinearLayout) findViewById(R.id.lay_add_friend);
        this.iQP = (TextView) findViewById(R.id.btn_add_friend);
        this.iQQ = (TextView) findViewById(R.id.text_add_friend);
        this.iQO.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.iQO.setVisibility(8);
        if (chatMessage == null) {
            this.iQN.setText("");
        } else if (!a(chatMessage)) {
            this.iQN.setVisibility(0);
            String v = com.baidu.tieba.im.util.e.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.iQN.setText(v);
            } else {
                this.iQN.setText("");
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
            this.iQO.setVisibility(0);
            this.iQN.setVisibility(8);
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
            this.iQQ.setText(optString2);
            if (optInt == 1) {
                this.iQP.setVisibility(0);
                this.iQP.setText(optString3);
                this.iQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
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
