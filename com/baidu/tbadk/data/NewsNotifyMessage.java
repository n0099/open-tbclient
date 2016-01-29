package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aky = 0;
        private int akz = 0;
        private int akA = 0;
        private int akC = 0;
        private int akB = 0;
        private int akD = 0;
        private int arQ = 0;
        private int arR = 0;
        private int akE = 0;

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
        this.mData.aky = i;
        this.mData.akz = i2;
        this.mData.akA = i3;
        this.mData.akB = i4;
        this.mData.akD = i5;
        this.mData.arQ = i6;
    }

    public int getMsgReplyme() {
        return this.mData.aky;
    }

    public void setMsgReplyme(int i) {
        this.mData.aky = i;
    }

    public int getMsgAtme() {
        return this.mData.akz;
    }

    public void setMsgAtme(int i) {
        this.mData.akz = i;
    }

    public int getMsgChat() {
        return this.mData.akA;
    }

    public void setMsgChat(int i) {
        this.mData.akA = i;
    }

    public void setMsgFans(int i) {
        this.mData.akC = i;
    }

    public int getMsgFans() {
        return this.mData.akC;
    }

    public int getMsgBookmark() {
        return this.mData.akB;
    }

    public void setMsgBookmark(int i) {
        this.mData.akB = i;
    }

    public int getMsgGiftNum() {
        return this.mData.akD;
    }

    public void setMsgGiftNum(int i) {
        this.mData.akD = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.arQ = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.arQ;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.arR = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.arR;
    }

    public void setMsgLiveVip(int i) {
        this.mData.akE = i;
    }

    public int getMsgLiveVip() {
        return this.mData.akE;
    }
}
