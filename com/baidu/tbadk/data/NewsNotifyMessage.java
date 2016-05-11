package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int agC = 0;
        private int agD = 0;
        private int agE = 0;
        private int agG = 0;
        private int agF = 0;
        private int agH = 0;
        private int anZ = 0;
        private int aoa = 0;
        private int agI = 0;
        private int aob = 0;

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
        this.mData.agC = i;
        this.mData.agD = i2;
        this.mData.agE = i3;
        this.mData.agF = i4;
        this.mData.agH = i5;
        this.mData.anZ = i6;
    }

    public int getMsgReplyme() {
        return this.mData.agC;
    }

    public void setMsgReplyme(int i) {
        this.mData.agC = i;
    }

    public int getMsgAtme() {
        return this.mData.agD;
    }

    public void setMsgAtme(int i) {
        this.mData.agD = i;
    }

    public int getMsgChat() {
        return this.mData.agE;
    }

    public void setMsgChat(int i) {
        this.mData.agE = i;
    }

    public void setMsgFans(int i) {
        this.mData.agG = i;
    }

    public int getMsgFans() {
        return this.mData.agG;
    }

    public int getMsgBookmark() {
        return this.mData.agF;
    }

    public void setMsgBookmark(int i) {
        this.mData.agF = i;
    }

    public int getMsgGiftNum() {
        return this.mData.agH;
    }

    public void setMsgGiftNum(int i) {
        this.mData.agH = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.anZ = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.anZ;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aoa = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aoa;
    }

    public void setMsgLiveVip(int i) {
        this.mData.agI = i;
    }

    public int getMsgLiveVip() {
        return this.mData.agI;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aob = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aob;
    }
}
