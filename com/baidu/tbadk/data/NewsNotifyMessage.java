package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int ahM = 0;
        private int ahN = 0;
        private int ahO = 0;
        private int ahQ = 0;
        private int ahP = 0;
        private int ahR = 0;
        private int aoZ = 0;
        private int apa = 0;
        private int ahS = 0;

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
        this.mData.ahM = i;
        this.mData.ahN = i2;
        this.mData.ahO = i3;
        this.mData.ahP = i4;
        this.mData.ahR = i5;
        this.mData.aoZ = i6;
    }

    public int getMsgReplyme() {
        return this.mData.ahM;
    }

    public void setMsgReplyme(int i) {
        this.mData.ahM = i;
    }

    public int getMsgAtme() {
        return this.mData.ahN;
    }

    public void setMsgAtme(int i) {
        this.mData.ahN = i;
    }

    public int getMsgChat() {
        return this.mData.ahO;
    }

    public void setMsgChat(int i) {
        this.mData.ahO = i;
    }

    public void setMsgFans(int i) {
        this.mData.ahQ = i;
    }

    public int getMsgFans() {
        return this.mData.ahQ;
    }

    public int getMsgBookmark() {
        return this.mData.ahP;
    }

    public void setMsgBookmark(int i) {
        this.mData.ahP = i;
    }

    public int getMsgGiftNum() {
        return this.mData.ahR;
    }

    public void setMsgGiftNum(int i) {
        this.mData.ahR = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aoZ = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aoZ;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.apa = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.apa;
    }

    public void setMsgLiveVip(int i) {
        this.mData.ahS = i;
    }

    public int getMsgLiveVip() {
        return this.mData.ahS;
    }
}
