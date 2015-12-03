package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aiC = 0;
        private int aiD = 0;
        private int aiE = 0;
        private int aiG = 0;
        private int aiF = 0;
        private int aiH = 0;
        private int apu = 0;
        private int apv = 0;
        private int aiI = 0;

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
        this.mData.aiC = i;
        this.mData.aiD = i2;
        this.mData.aiE = i3;
        this.mData.aiF = i4;
        this.mData.aiH = i5;
        this.mData.apu = i6;
    }

    public int getMsgReplyme() {
        return this.mData.aiC;
    }

    public void setMsgReplyme(int i) {
        this.mData.aiC = i;
    }

    public int getMsgAtme() {
        return this.mData.aiD;
    }

    public void setMsgAtme(int i) {
        this.mData.aiD = i;
    }

    public int getMsgChat() {
        return this.mData.aiE;
    }

    public void setMsgChat(int i) {
        this.mData.aiE = i;
    }

    public void setMsgFans(int i) {
        this.mData.aiG = i;
    }

    public int getMsgFans() {
        return this.mData.aiG;
    }

    public int getMsgBookmark() {
        return this.mData.aiF;
    }

    public void setMsgBookmark(int i) {
        this.mData.aiF = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aiH;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aiH = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.apu = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.apu;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.apv = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.apv;
    }

    public void setMsgLiveVip(int i) {
        this.mData.aiI = i;
    }

    public int getMsgLiveVip() {
        return this.mData.aiI;
    }
}
