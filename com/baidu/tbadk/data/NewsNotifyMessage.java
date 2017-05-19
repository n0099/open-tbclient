package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int apY = 0;
        private int apZ = 0;
        private int aqa = 0;
        private int aqc = 0;
        private int aqb = 0;
        private int aqd = 0;
        private int axH = 0;
        private int axI = 0;
        private int aqe = 0;
        private int axJ = 0;

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
        this.mData.apY = i;
        this.mData.apZ = i2;
        this.mData.aqa = i3;
        this.mData.aqb = i4;
        this.mData.aqd = i5;
        this.mData.axH = i6;
    }

    public int getMsgReplyme() {
        return this.mData.apY;
    }

    public void setMsgReplyme(int i) {
        this.mData.apY = i;
    }

    public int getMsgAtme() {
        return this.mData.apZ;
    }

    public void setMsgAtme(int i) {
        this.mData.apZ = i;
    }

    public int getMsgChat() {
        return this.mData.aqa;
    }

    public void setMsgChat(int i) {
        this.mData.aqa = i;
    }

    public void setMsgFans(int i) {
        this.mData.aqc = i;
    }

    public int getMsgFans() {
        return this.mData.aqc;
    }

    public int getMsgBookmark() {
        return this.mData.aqb;
    }

    public void setMsgBookmark(int i) {
        this.mData.aqb = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aqd;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aqd = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.axH = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.axH;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.axI = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.axI;
    }

    public void setMsgLiveVip(int i) {
        this.mData.aqe = i;
    }

    public int getMsgLiveVip() {
        return this.mData.aqe;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.axJ = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.axJ;
    }
}
