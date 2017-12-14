package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int asr = 0;
        private int ass = 0;
        private int ast = 0;
        private int asv = 0;
        private int asu = 0;
        private int asw = 0;
        private int aAD = 0;
        private int aAE = 0;
        private int asx = 0;
        private int aAF = 0;

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
        this.mData.asr = i;
        this.mData.ass = i2;
        this.mData.ast = i3;
        this.mData.asu = i4;
        this.mData.asw = i5;
        this.mData.aAD = i6;
    }

    public int getMsgReplyme() {
        return this.mData.asr;
    }

    public void setMsgReplyme(int i) {
        this.mData.asr = i;
    }

    public int getMsgAtme() {
        return this.mData.ass;
    }

    public void setMsgAtme(int i) {
        this.mData.ass = i;
    }

    public int getMsgChat() {
        return this.mData.ast;
    }

    public void setMsgChat(int i) {
        this.mData.ast = i;
    }

    public void setMsgFans(int i) {
        this.mData.asv = i;
    }

    public int getMsgFans() {
        return this.mData.asv;
    }

    public int getMsgBookmark() {
        return this.mData.asu;
    }

    public void setMsgBookmark(int i) {
        this.mData.asu = i;
    }

    public int getMsgGiftNum() {
        return this.mData.asw;
    }

    public void setMsgGiftNum(int i) {
        this.mData.asw = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aAD = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aAD;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aAE = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aAE;
    }

    public void setMsgLiveVip(int i) {
        this.mData.asx = i;
    }

    public int getMsgLiveVip() {
        return this.mData.asx;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aAF = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aAF;
    }
}
