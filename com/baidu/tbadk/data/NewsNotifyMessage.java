package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int akG = 0;
        private int akH = 0;
        private int akI = 0;
        private int akK = 0;
        private int akJ = 0;
        private int akL = 0;
        private int asv = 0;
        private int asw = 0;
        private int akM = 0;
        private int asx = 0;

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
        this.mData.akG = i;
        this.mData.akH = i2;
        this.mData.akI = i3;
        this.mData.akJ = i4;
        this.mData.akL = i5;
        this.mData.asv = i6;
    }

    public int getMsgReplyme() {
        return this.mData.akG;
    }

    public void setMsgReplyme(int i) {
        this.mData.akG = i;
    }

    public int getMsgAtme() {
        return this.mData.akH;
    }

    public void setMsgAtme(int i) {
        this.mData.akH = i;
    }

    public int getMsgChat() {
        return this.mData.akI;
    }

    public void setMsgChat(int i) {
        this.mData.akI = i;
    }

    public void setMsgFans(int i) {
        this.mData.akK = i;
    }

    public int getMsgFans() {
        return this.mData.akK;
    }

    public int getMsgBookmark() {
        return this.mData.akJ;
    }

    public void setMsgBookmark(int i) {
        this.mData.akJ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.akL;
    }

    public void setMsgGiftNum(int i) {
        this.mData.akL = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.asv = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.asv;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.asw = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.asw;
    }

    public void setMsgLiveVip(int i) {
        this.mData.akM = i;
    }

    public int getMsgLiveVip() {
        return this.mData.akM;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.asx = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.asx;
    }
}
