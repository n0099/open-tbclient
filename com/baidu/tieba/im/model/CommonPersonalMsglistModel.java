package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.i0.d1.w.c;
/* loaded from: classes3.dex */
public abstract class CommonPersonalMsglistModel extends MsglistModel {
    public final CustomMessageListener mCustomListener;
    public UserData mUser;

    public CommonPersonalMsglistModel() {
        this.mUser = null;
        this.mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.CommonPersonalMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2016012) {
                    if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                        return;
                    }
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 205001 && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                        CommonPersonalMsglistModel.this.processMsgACK((ResponseCommitPersonalMessage) socketResponsedMessage);
                    }
                } else if (customResponsedMessage.getCmd() == 2001215 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    UserData userData = CommonPersonalMsglistModel.this.mUser;
                    if (userData == null || userData.getUserId() == null) {
                        return;
                    }
                    if (CommonPersonalMsglistModel.this.mUser.getUserId().equals(String.valueOf(c.m(chatMessage)))) {
                        CommonPersonalMsglistModel.this.sendMsgFail(chatMessage);
                    }
                }
            }
        };
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016012, this.mCustomListener);
        MessageManager.getInstance().registerListener(2001215, this.mCustomListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    public UserData getUser() {
        return this.mUser;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    public void setUser(UserData userData) {
        this.mUser = userData;
        if (userData != null) {
            this.mId = userData.getUserIdLong();
        } else {
            this.mId = 0L;
        }
    }

    public CommonPersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mUser = null;
        this.mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.CommonPersonalMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2016012) {
                    if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                        return;
                    }
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 205001 && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                        CommonPersonalMsglistModel.this.processMsgACK((ResponseCommitPersonalMessage) socketResponsedMessage);
                    }
                } else if (customResponsedMessage.getCmd() == 2001215 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    UserData userData = CommonPersonalMsglistModel.this.mUser;
                    if (userData == null || userData.getUserId() == null) {
                        return;
                    }
                    if (CommonPersonalMsglistModel.this.mUser.getUserId().equals(String.valueOf(c.m(chatMessage)))) {
                        CommonPersonalMsglistModel.this.sendMsgFail(chatMessage);
                    }
                }
            }
        };
        registerListener();
    }
}
