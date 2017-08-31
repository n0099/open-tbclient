package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int asB = 0;
        private int asC = 0;
        private int asD = 0;
        private int asF = 0;
        private int asE = 0;
        private int asG = 0;
        private int azZ = 0;
        private int aAa = 0;
        private int asH = 0;
        private int aAb = 0;

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
        this.mData.asB = i;
        this.mData.asC = i2;
        this.mData.asD = i3;
        this.mData.asE = i4;
        this.mData.asG = i5;
        this.mData.azZ = i6;
    }

    public int getMsgReplyme() {
        return this.mData.asB;
    }

    public void setMsgReplyme(int i) {
        this.mData.asB = i;
    }

    public int getMsgAtme() {
        return this.mData.asC;
    }

    public void setMsgAtme(int i) {
        this.mData.asC = i;
    }

    public int getMsgChat() {
        return this.mData.asD;
    }

    public void setMsgChat(int i) {
        this.mData.asD = i;
    }

    public void setMsgFans(int i) {
        this.mData.asF = i;
    }

    public int getMsgFans() {
        return this.mData.asF;
    }

    public int getMsgBookmark() {
        return this.mData.asE;
    }

    public void setMsgBookmark(int i) {
        this.mData.asE = i;
    }

    public int getMsgGiftNum() {
        return this.mData.asG;
    }

    public void setMsgGiftNum(int i) {
        this.mData.asG = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.azZ = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.azZ;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aAa = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aAa;
    }

    public void setMsgLiveVip(int i) {
        this.mData.asH = i;
    }

    public int getMsgLiveVip() {
        return this.mData.asH;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aAb = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aAb;
    }
}
