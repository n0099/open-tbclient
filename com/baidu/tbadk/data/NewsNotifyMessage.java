package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int apW = 0;
        private int apX = 0;
        private int apY = 0;
        private int aqa = 0;
        private int apZ = 0;
        private int aqb = 0;
        private int axI = 0;
        private int axJ = 0;
        private int aqc = 0;
        private int axK = 0;

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
        this.mData.apW = i;
        this.mData.apX = i2;
        this.mData.apY = i3;
        this.mData.apZ = i4;
        this.mData.aqb = i5;
        this.mData.axI = i6;
    }

    public int getMsgReplyme() {
        return this.mData.apW;
    }

    public void setMsgReplyme(int i) {
        this.mData.apW = i;
    }

    public int getMsgAtme() {
        return this.mData.apX;
    }

    public void setMsgAtme(int i) {
        this.mData.apX = i;
    }

    public int getMsgChat() {
        return this.mData.apY;
    }

    public void setMsgChat(int i) {
        this.mData.apY = i;
    }

    public void setMsgFans(int i) {
        this.mData.aqa = i;
    }

    public int getMsgFans() {
        return this.mData.aqa;
    }

    public int getMsgBookmark() {
        return this.mData.apZ;
    }

    public void setMsgBookmark(int i) {
        this.mData.apZ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aqb;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aqb = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.axI = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.axI;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.axJ = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.axJ;
    }

    public void setMsgLiveVip(int i) {
        this.mData.aqc = i;
    }

    public int getMsgLiveVip() {
        return this.mData.aqc;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.axK = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.axK;
    }
}
