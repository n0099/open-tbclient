package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int arT = 0;
        private int arU = 0;
        private int arV = 0;
        private int arX = 0;
        private int arW = 0;
        private int arY = 0;
        private int azX = 0;
        private int azY = 0;
        private int arZ = 0;
        private int azZ = 0;

        public a() {
        }
    }

    public NewsNotifyMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.mData = new a();
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5, int i6) {
        super(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.mData = new a();
        this.mData.arT = i;
        this.mData.arU = i2;
        this.mData.arV = i3;
        this.mData.arW = i4;
        this.mData.arY = i5;
        this.mData.azX = i6;
    }

    public int getMsgReplyme() {
        return this.mData.arT;
    }

    public void setMsgReplyme(int i) {
        this.mData.arT = i;
    }

    public int getMsgAtme() {
        return this.mData.arU;
    }

    public void setMsgAtme(int i) {
        this.mData.arU = i;
    }

    public int getMsgChat() {
        return this.mData.arV;
    }

    public void setMsgChat(int i) {
        this.mData.arV = i;
    }

    public void setMsgFans(int i) {
        this.mData.arX = i;
    }

    public int getMsgFans() {
        return this.mData.arX;
    }

    public int getMsgBookmark() {
        return this.mData.arW;
    }

    public void setMsgBookmark(int i) {
        this.mData.arW = i;
    }

    public int getMsgGiftNum() {
        return this.mData.arY;
    }

    public void setMsgGiftNum(int i) {
        this.mData.arY = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.azX = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.azX;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.azY = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.azY;
    }

    public void setMsgLiveVip(int i) {
        this.mData.arZ = i;
    }

    public int getMsgLiveVip() {
        return this.mData.arZ;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.azZ = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.azZ;
    }
}
