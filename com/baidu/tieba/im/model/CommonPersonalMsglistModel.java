package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.i;
/* loaded from: classes.dex */
public abstract class CommonPersonalMsglistModel extends MsglistModel {
    private final CustomMessageListener mCustomListener;
    protected UserData mUser;

    public CommonPersonalMsglistModel() {
        this.mUser = null;
        this.mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.CommonPersonalMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016012) {
                        if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                            SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                            if (socketResponsedMessage.getCmd() == 205001 && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                                CommonPersonalMsglistModel.this.processMsgACK((ResponseCommitPersonalMessage) socketResponsedMessage);
                            }
                        }
                    } else if (customResponsedMessage.getCmd() == 2001221 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                        ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                        if (CommonPersonalMsglistModel.this.mUser != null && CommonPersonalMsglistModel.this.mUser.getUserId() != null) {
                            if (CommonPersonalMsglistModel.this.mUser.getUserId().equals(String.valueOf(i.o(chatMessage)))) {
                                CommonPersonalMsglistModel.this.sendMsgFail(chatMessage);
                            }
                        }
                    }
                }
            }
        };
    }

    public CommonPersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mUser = null;
        this.mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.CommonPersonalMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016012) {
                        if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                            SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                            if (socketResponsedMessage.getCmd() == 205001 && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                                CommonPersonalMsglistModel.this.processMsgACK((ResponseCommitPersonalMessage) socketResponsedMessage);
                            }
                        }
                    } else if (customResponsedMessage.getCmd() == 2001221 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                        ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                        if (CommonPersonalMsglistModel.this.mUser != null && CommonPersonalMsglistModel.this.mUser.getUserId() != null) {
                            if (CommonPersonalMsglistModel.this.mUser.getUserId().equals(String.valueOf(i.o(chatMessage)))) {
                                CommonPersonalMsglistModel.this.sendMsgFail(chatMessage);
                            }
                        }
                    }
                }
            }
        };
        registerListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016012, this.mCustomListener);
        MessageManager.getInstance().registerListener(2001221, this.mCustomListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    public void setUser(UserData userData) {
        this.mUser = userData;
        if (this.mUser != null) {
            this.mId = this.mUser.getUserIdLong();
        } else {
            this.mId = 0L;
        }
    }

    public UserData getUser() {
        return this.mUser;
    }
}
