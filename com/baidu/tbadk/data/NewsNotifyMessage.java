package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int asS = 0;
        private int asT = 0;
        private int asU = 0;
        private int asW = 0;
        private int asV = 0;
        private int asX = 0;
        private int aAM = 0;
        private int aAN = 0;
        private int asY = 0;
        private int aAO = 0;

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
        this.mData.asS = i;
        this.mData.asT = i2;
        this.mData.asU = i3;
        this.mData.asV = i4;
        this.mData.asX = i5;
        this.mData.aAM = i6;
    }

    public int getMsgReplyme() {
        return this.mData.asS;
    }

    public void setMsgReplyme(int i) {
        this.mData.asS = i;
    }

    public int getMsgAtme() {
        return this.mData.asT;
    }

    public void setMsgAtme(int i) {
        this.mData.asT = i;
    }

    public int getMsgChat() {
        return this.mData.asU;
    }

    public void setMsgChat(int i) {
        this.mData.asU = i;
    }

    public void setMsgFans(int i) {
        this.mData.asW = i;
    }

    public int getMsgFans() {
        return this.mData.asW;
    }

    public int getMsgBookmark() {
        return this.mData.asV;
    }

    public void setMsgBookmark(int i) {
        this.mData.asV = i;
    }

    public int getMsgGiftNum() {
        return this.mData.asX;
    }

    public void setMsgGiftNum(int i) {
        this.mData.asX = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aAM = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aAM;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aAN = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aAN;
    }

    public void setMsgLiveVip(int i) {
        this.mData.asY = i;
    }

    public int getMsgLiveVip() {
        return this.mData.asY;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aAO = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aAO;
    }
}
