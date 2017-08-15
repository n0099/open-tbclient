package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int asT = 0;
        private int asU = 0;
        private int asV = 0;
        private int asX = 0;
        private int asW = 0;
        private int asY = 0;
        private int aAN = 0;
        private int aAO = 0;
        private int asZ = 0;
        private int aAP = 0;

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
        this.mData.asT = i;
        this.mData.asU = i2;
        this.mData.asV = i3;
        this.mData.asW = i4;
        this.mData.asY = i5;
        this.mData.aAN = i6;
    }

    public int getMsgReplyme() {
        return this.mData.asT;
    }

    public void setMsgReplyme(int i) {
        this.mData.asT = i;
    }

    public int getMsgAtme() {
        return this.mData.asU;
    }

    public void setMsgAtme(int i) {
        this.mData.asU = i;
    }

    public int getMsgChat() {
        return this.mData.asV;
    }

    public void setMsgChat(int i) {
        this.mData.asV = i;
    }

    public void setMsgFans(int i) {
        this.mData.asX = i;
    }

    public int getMsgFans() {
        return this.mData.asX;
    }

    public int getMsgBookmark() {
        return this.mData.asW;
    }

    public void setMsgBookmark(int i) {
        this.mData.asW = i;
    }

    public int getMsgGiftNum() {
        return this.mData.asY;
    }

    public void setMsgGiftNum(int i) {
        this.mData.asY = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aAN = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aAN;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aAO = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aAO;
    }

    public void setMsgLiveVip(int i) {
        this.mData.asZ = i;
    }

    public int getMsgLiveVip() {
        return this.mData.asZ;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aAP = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aAP;
    }
}
