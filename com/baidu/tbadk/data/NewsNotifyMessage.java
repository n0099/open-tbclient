package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int arG = 0;
        private int arH = 0;
        private int arI = 0;
        private int arK = 0;
        private int arJ = 0;
        private int arL = 0;
        private int azq = 0;
        private int azr = 0;
        private int arM = 0;
        private int azs = 0;

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
        this.mData.arG = i;
        this.mData.arH = i2;
        this.mData.arI = i3;
        this.mData.arJ = i4;
        this.mData.arL = i5;
        this.mData.azq = i6;
    }

    public int getMsgReplyme() {
        return this.mData.arG;
    }

    public void setMsgReplyme(int i) {
        this.mData.arG = i;
    }

    public int getMsgAtme() {
        return this.mData.arH;
    }

    public void setMsgAtme(int i) {
        this.mData.arH = i;
    }

    public int getMsgChat() {
        return this.mData.arI;
    }

    public void setMsgChat(int i) {
        this.mData.arI = i;
    }

    public void setMsgFans(int i) {
        this.mData.arK = i;
    }

    public int getMsgFans() {
        return this.mData.arK;
    }

    public int getMsgBookmark() {
        return this.mData.arJ;
    }

    public void setMsgBookmark(int i) {
        this.mData.arJ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.arL;
    }

    public void setMsgGiftNum(int i) {
        this.mData.arL = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.azq = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.azq;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.azr = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.azr;
    }

    public void setMsgLiveVip(int i) {
        this.mData.arM = i;
    }

    public int getMsgLiveVip() {
        return this.mData.arM;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.azs = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.azs;
    }
}
