package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int ajI = 0;
        private int ajJ = 0;
        private int ajK = 0;
        private int ajM = 0;
        private int ajL = 0;
        private int ajN = 0;
        private int aqX = 0;
        private int aqY = 0;
        private int ajO = 0;

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
        this.mData.ajI = i;
        this.mData.ajJ = i2;
        this.mData.ajK = i3;
        this.mData.ajL = i4;
        this.mData.ajN = i5;
        this.mData.aqX = i6;
    }

    public int getMsgReplyme() {
        return this.mData.ajI;
    }

    public void setMsgReplyme(int i) {
        this.mData.ajI = i;
    }

    public int getMsgAtme() {
        return this.mData.ajJ;
    }

    public void setMsgAtme(int i) {
        this.mData.ajJ = i;
    }

    public int getMsgChat() {
        return this.mData.ajK;
    }

    public void setMsgChat(int i) {
        this.mData.ajK = i;
    }

    public void setMsgFans(int i) {
        this.mData.ajM = i;
    }

    public int getMsgFans() {
        return this.mData.ajM;
    }

    public int getMsgBookmark() {
        return this.mData.ajL;
    }

    public void setMsgBookmark(int i) {
        this.mData.ajL = i;
    }

    public int getMsgGiftNum() {
        return this.mData.ajN;
    }

    public void setMsgGiftNum(int i) {
        this.mData.ajN = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aqX = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aqX;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aqY = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aqY;
    }

    public void setMsgLiveVip(int i) {
        this.mData.ajO = i;
    }

    public int getMsgLiveVip() {
        return this.mData.ajO;
    }
}
