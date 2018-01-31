package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int bgU = 0;
        private int bgV = 0;
        private int bgW = 0;
        private int bgY = 0;
        private int bgX = 0;
        private int bgZ = 0;
        private int boU = 0;
        private int boV = 0;
        private int bha = 0;
        private int boW = 0;

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
        this.mData.bgU = i;
        this.mData.bgV = i2;
        this.mData.bgW = i3;
        this.mData.bgX = i4;
        this.mData.bgZ = i5;
        this.mData.boU = i6;
    }

    public int getMsgReplyme() {
        return this.mData.bgU;
    }

    public void setMsgReplyme(int i) {
        this.mData.bgU = i;
    }

    public int getMsgAtme() {
        return this.mData.bgV;
    }

    public void setMsgAtme(int i) {
        this.mData.bgV = i;
    }

    public int getMsgChat() {
        return this.mData.bgW;
    }

    public void setMsgChat(int i) {
        this.mData.bgW = i;
    }

    public void setMsgFans(int i) {
        this.mData.bgY = i;
    }

    public int getMsgFans() {
        return this.mData.bgY;
    }

    public int getMsgBookmark() {
        return this.mData.bgX;
    }

    public void setMsgBookmark(int i) {
        this.mData.bgX = i;
    }

    public int getMsgGiftNum() {
        return this.mData.bgZ;
    }

    public void setMsgGiftNum(int i) {
        this.mData.bgZ = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.boU = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.boU;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.boV = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.boV;
    }

    public void setMsgLiveVip(int i) {
        this.mData.bha = i;
    }

    public int getMsgLiveVip() {
        return this.mData.bha;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.boW = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.boW;
    }
}
