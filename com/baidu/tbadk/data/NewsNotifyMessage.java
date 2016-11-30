package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int alA = 0;
        private int alB = 0;
        private int alC = 0;
        private int alE = 0;
        private int alD = 0;
        private int alF = 0;
        private int atp = 0;
        private int atq = 0;
        private int alG = 0;
        private int atr = 0;

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
        this.mData.alA = i;
        this.mData.alB = i2;
        this.mData.alC = i3;
        this.mData.alD = i4;
        this.mData.alF = i5;
        this.mData.atp = i6;
    }

    public int getMsgReplyme() {
        return this.mData.alA;
    }

    public void setMsgReplyme(int i) {
        this.mData.alA = i;
    }

    public int getMsgAtme() {
        return this.mData.alB;
    }

    public void setMsgAtme(int i) {
        this.mData.alB = i;
    }

    public int getMsgChat() {
        return this.mData.alC;
    }

    public void setMsgChat(int i) {
        this.mData.alC = i;
    }

    public void setMsgFans(int i) {
        this.mData.alE = i;
    }

    public int getMsgFans() {
        return this.mData.alE;
    }

    public int getMsgBookmark() {
        return this.mData.alD;
    }

    public void setMsgBookmark(int i) {
        this.mData.alD = i;
    }

    public int getMsgGiftNum() {
        return this.mData.alF;
    }

    public void setMsgGiftNum(int i) {
        this.mData.alF = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.atp = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.atp;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.atq = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.atq;
    }

    public void setMsgLiveVip(int i) {
        this.mData.alG = i;
    }

    public int getMsgLiveVip() {
        return this.mData.alG;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.atr = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.atr;
    }
}
