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
    private TextView itC;
    private LinearLayout itD;
    private TextView itE;
    private TextView itF;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.itC = null;
        initView();
    }

    private void initView() {
        this.itC = (TextView) findViewById(R.id.tex_msgcontent);
        this.itC.setMovementMethod(LinkMovementMethod.getInstance());
        this.itD = (LinearLayout) findViewById(R.id.lay_add_friend);
        this.itE = (TextView) findViewById(R.id.btn_add_friend);
        this.itF = (TextView) findViewById(R.id.text_add_friend);
        this.itD.setVisibility(8);
    }

    public void setData(ChatMessage chatMessage) {
        this.itD.setVisibility(8);
        if (chatMessage == null) {
            this.itC.setText("");
        } else if (!a(chatMessage)) {
            this.itC.setVisibility(0);
            String v = com.baidu.tieba.im.util.e.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.itC.setText(v);
            } else {
                this.itC.setText("");
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
            this.itD.setVisibility(0);
            this.itC.setVisibility(8);
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
            this.itF.setText(optString2);
            if (optInt == 1) {
                this.itE.setVisibility(0);
                this.itE.setText(optString3);
                this.itE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.f.1
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
