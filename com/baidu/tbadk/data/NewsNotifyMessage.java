package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int arA = 0;
        private int arB = 0;
        private int arC = 0;
        private int arE = 0;
        private int arD = 0;
        private int arF = 0;
        private int azv = 0;
        private int azw = 0;
        private int arG = 0;
        private int azx = 0;

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
        this.mData.arA = i;
        this.mData.arB = i2;
        this.mData.arC = i3;
        this.mData.arD = i4;
        this.mData.arF = i5;
        this.mData.azv = i6;
    }

    public int getMsgReplyme() {
        return this.mData.arA;
    }

    public void setMsgReplyme(int i) {
        this.mData.arA = i;
    }

    public int getMsgAtme() {
        return this.mData.arB;
    }

    public void setMsgAtme(int i) {
        this.mData.arB = i;
    }

    public int getMsgChat() {
        return this.mData.arC;
    }

    public void setMsgChat(int i) {
        this.mData.arC = i;
    }

    public void setMsgFans(int i) {
        this.mData.arE = i;
    }

    public int getMsgFans() {
        return this.mData.arE;
    }

    public int getMsgBookmark() {
        return this.mData.arD;
    }

    public void setMsgBookmark(int i) {
        this.mData.arD = i;
    }

    public int getMsgGiftNum() {
        return this.mData.arF;
    }

    public void setMsgGiftNum(int i) {
        this.mData.arF = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.azv = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.azv;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.azw = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.azw;
    }

    public void setMsgLiveVip(int i) {
        this.mData.arG = i;
    }

    public int getMsgLiveVip() {
        return this.mData.arG;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.azx = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.azx;
    }
}
