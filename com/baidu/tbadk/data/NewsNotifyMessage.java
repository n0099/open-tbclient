package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int agQ = 0;
        private int agR = 0;
        private int agS = 0;
        private int agU = 0;
        private int agT = 0;
        private int agV = 0;
        private int anF = 0;
        private int anG = 0;
        private int agW = 0;

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
        this.mData.agQ = i;
        this.mData.agR = i2;
        this.mData.agS = i3;
        this.mData.agT = i4;
        this.mData.agV = i5;
        this.mData.anF = i6;
    }

    public int getMsgReplyme() {
        return this.mData.agQ;
    }

    public void setMsgReplyme(int i) {
        this.mData.agQ = i;
    }

    public int getMsgAtme() {
        return this.mData.agR;
    }

    public void setMsgAtme(int i) {
        this.mData.agR = i;
    }

    public int getMsgChat() {
        return this.mData.agS;
    }

    public void setMsgChat(int i) {
        this.mData.agS = i;
    }

    public void setMsgFans(int i) {
        this.mData.agU = i;
    }

    public int getMsgFans() {
        return this.mData.agU;
    }

    public int getMsgBookmark() {
        return this.mData.agT;
    }

    public void setMsgBookmark(int i) {
        this.mData.agT = i;
    }

    public int getMsgGiftNum() {
        return this.mData.agV;
    }

    public void setMsgGiftNum(int i) {
        this.mData.agV = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.anF = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.anF;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.anG = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.anG;
    }

    public void setMsgLiveVip(int i) {
        this.mData.agW = i;
    }

    public int getMsgLiveVip() {
        return this.mData.agW;
    }
}
