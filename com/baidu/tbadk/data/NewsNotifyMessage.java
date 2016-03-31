package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int akP = 0;
        private int akQ = 0;
        private int akR = 0;
        private int akT = 0;
        private int akS = 0;
        private int akU = 0;
        private int asj = 0;
        private int ask = 0;
        private int akV = 0;
        private int asl = 0;

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
        this.mData.akP = i;
        this.mData.akQ = i2;
        this.mData.akR = i3;
        this.mData.akS = i4;
        this.mData.akU = i5;
        this.mData.asj = i6;
    }

    public int getMsgReplyme() {
        return this.mData.akP;
    }

    public void setMsgReplyme(int i) {
        this.mData.akP = i;
    }

    public int getMsgAtme() {
        return this.mData.akQ;
    }

    public void setMsgAtme(int i) {
        this.mData.akQ = i;
    }

    public int getMsgChat() {
        return this.mData.akR;
    }

    public void setMsgChat(int i) {
        this.mData.akR = i;
    }

    public void setMsgFans(int i) {
        this.mData.akT = i;
    }

    public int getMsgFans() {
        return this.mData.akT;
    }

    public int getMsgBookmark() {
        return this.mData.akS;
    }

    public void setMsgBookmark(int i) {
        this.mData.akS = i;
    }

    public int getMsgGiftNum() {
        return this.mData.akU;
    }

    public void setMsgGiftNum(int i) {
        this.mData.akU = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.asj = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.asj;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.ask = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.ask;
    }

    public void setMsgLiveVip(int i) {
        this.mData.akV = i;
    }

    public int getMsgLiveVip() {
        return this.mData.akV;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.asl = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.asl;
    }
}
