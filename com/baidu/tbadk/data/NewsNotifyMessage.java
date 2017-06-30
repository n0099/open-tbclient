package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aqJ = 0;
        private int aqK = 0;
        private int aqL = 0;
        private int aqN = 0;
        private int aqM = 0;
        private int aqO = 0;
        private int ayv = 0;
        private int ayw = 0;
        private int aqP = 0;
        private int ayx = 0;

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
        this.mData.aqJ = i;
        this.mData.aqK = i2;
        this.mData.aqL = i3;
        this.mData.aqM = i4;
        this.mData.aqO = i5;
        this.mData.ayv = i6;
    }

    public int getMsgReplyme() {
        return this.mData.aqJ;
    }

    public void setMsgReplyme(int i) {
        this.mData.aqJ = i;
    }

    public int getMsgAtme() {
        return this.mData.aqK;
    }

    public void setMsgAtme(int i) {
        this.mData.aqK = i;
    }

    public int getMsgChat() {
        return this.mData.aqL;
    }

    public void setMsgChat(int i) {
        this.mData.aqL = i;
    }

    public void setMsgFans(int i) {
        this.mData.aqN = i;
    }

    public int getMsgFans() {
        return this.mData.aqN;
    }

    public int getMsgBookmark() {
        return this.mData.aqM;
    }

    public void setMsgBookmark(int i) {
        this.mData.aqM = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aqO;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aqO = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.ayv = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.ayv;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.ayw = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.ayw;
    }

    public void setMsgLiveVip(int i) {
        this.mData.aqP = i;
    }

    public int getMsgLiveVip() {
        return this.mData.aqP;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.ayx = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.ayx;
    }
}
