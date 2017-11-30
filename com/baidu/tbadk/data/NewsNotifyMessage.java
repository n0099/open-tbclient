package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int asm = 0;
        private int asn = 0;
        private int aso = 0;
        private int asq = 0;
        private int asp = 0;
        private int asr = 0;
        private int aAy = 0;
        private int aAz = 0;
        private int ass = 0;
        private int aAA = 0;

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
        this.mData.asm = i;
        this.mData.asn = i2;
        this.mData.aso = i3;
        this.mData.asp = i4;
        this.mData.asr = i5;
        this.mData.aAy = i6;
    }

    public int getMsgReplyme() {
        return this.mData.asm;
    }

    public void setMsgReplyme(int i) {
        this.mData.asm = i;
    }

    public int getMsgAtme() {
        return this.mData.asn;
    }

    public void setMsgAtme(int i) {
        this.mData.asn = i;
    }

    public int getMsgChat() {
        return this.mData.aso;
    }

    public void setMsgChat(int i) {
        this.mData.aso = i;
    }

    public void setMsgFans(int i) {
        this.mData.asq = i;
    }

    public int getMsgFans() {
        return this.mData.asq;
    }

    public int getMsgBookmark() {
        return this.mData.asp;
    }

    public void setMsgBookmark(int i) {
        this.mData.asp = i;
    }

    public int getMsgGiftNum() {
        return this.mData.asr;
    }

    public void setMsgGiftNum(int i) {
        this.mData.asr = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aAy = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aAy;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aAz = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aAz;
    }

    public void setMsgLiveVip(int i) {
        this.mData.ass = i;
    }

    public int getMsgLiveVip() {
        return this.mData.ass;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aAA = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aAA;
    }
}
