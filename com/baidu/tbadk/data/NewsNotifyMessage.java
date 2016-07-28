package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int ahV = 0;
        private int ahW = 0;
        private int ahX = 0;
        private int ahZ = 0;
        private int ahY = 0;
        private int aia = 0;
        private int apE = 0;
        private int apF = 0;
        private int aib = 0;
        private int apG = 0;

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
        this.mData.ahV = i;
        this.mData.ahW = i2;
        this.mData.ahX = i3;
        this.mData.ahY = i4;
        this.mData.aia = i5;
        this.mData.apE = i6;
    }

    public int getMsgReplyme() {
        return this.mData.ahV;
    }

    public void setMsgReplyme(int i) {
        this.mData.ahV = i;
    }

    public int getMsgAtme() {
        return this.mData.ahW;
    }

    public void setMsgAtme(int i) {
        this.mData.ahW = i;
    }

    public int getMsgChat() {
        return this.mData.ahX;
    }

    public void setMsgChat(int i) {
        this.mData.ahX = i;
    }

    public void setMsgFans(int i) {
        this.mData.ahZ = i;
    }

    public int getMsgFans() {
        return this.mData.ahZ;
    }

    public int getMsgBookmark() {
        return this.mData.ahY;
    }

    public void setMsgBookmark(int i) {
        this.mData.ahY = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aia;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aia = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.apE = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.apE;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.apF = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.apF;
    }

    public void setMsgLiveVip(int i) {
        this.mData.aib = i;
    }

    public int getMsgLiveVip() {
        return this.mData.aib;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.apG = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.apG;
    }
}
