package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int asu = 0;
        private int asv = 0;
        private int asw = 0;
        private int asy = 0;
        private int asx = 0;
        private int asz = 0;
        private int aAG = 0;
        private int aAH = 0;
        private int asA = 0;
        private int aAI = 0;

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
        this.mData.asu = i;
        this.mData.asv = i2;
        this.mData.asw = i3;
        this.mData.asx = i4;
        this.mData.asz = i5;
        this.mData.aAG = i6;
    }

    public int getMsgReplyme() {
        return this.mData.asu;
    }

    public void setMsgReplyme(int i) {
        this.mData.asu = i;
    }

    public int getMsgAtme() {
        return this.mData.asv;
    }

    public void setMsgAtme(int i) {
        this.mData.asv = i;
    }

    public int getMsgChat() {
        return this.mData.asw;
    }

    public void setMsgChat(int i) {
        this.mData.asw = i;
    }

    public void setMsgFans(int i) {
        this.mData.asy = i;
    }

    public int getMsgFans() {
        return this.mData.asy;
    }

    public int getMsgBookmark() {
        return this.mData.asx;
    }

    public void setMsgBookmark(int i) {
        this.mData.asx = i;
    }

    public int getMsgGiftNum() {
        return this.mData.asz;
    }

    public void setMsgGiftNum(int i) {
        this.mData.asz = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aAG = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aAG;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aAH = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aAH;
    }

    public void setMsgLiveVip(int i) {
        this.mData.asA = i;
    }

    public int getMsgLiveVip() {
        return this.mData.asA;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aAI = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aAI;
    }
}
