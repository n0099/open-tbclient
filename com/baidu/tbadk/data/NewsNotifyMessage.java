package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int akZ = 0;
        private int ala = 0;
        private int alb = 0;
        private int ald = 0;
        private int alc = 0;
        private int ale = 0;
        private int asK = 0;
        private int asL = 0;
        private int alf = 0;
        private int asM = 0;

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
        this.mData.akZ = i;
        this.mData.ala = i2;
        this.mData.alb = i3;
        this.mData.alc = i4;
        this.mData.ale = i5;
        this.mData.asK = i6;
    }

    public int getMsgReplyme() {
        return this.mData.akZ;
    }

    public void setMsgReplyme(int i) {
        this.mData.akZ = i;
    }

    public int getMsgAtme() {
        return this.mData.ala;
    }

    public void setMsgAtme(int i) {
        this.mData.ala = i;
    }

    public int getMsgChat() {
        return this.mData.alb;
    }

    public void setMsgChat(int i) {
        this.mData.alb = i;
    }

    public void setMsgFans(int i) {
        this.mData.ald = i;
    }

    public int getMsgFans() {
        return this.mData.ald;
    }

    public int getMsgBookmark() {
        return this.mData.alc;
    }

    public void setMsgBookmark(int i) {
        this.mData.alc = i;
    }

    public int getMsgGiftNum() {
        return this.mData.ale;
    }

    public void setMsgGiftNum(int i) {
        this.mData.ale = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.asK = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.asK;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.asL = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.asL;
    }

    public void setMsgLiveVip(int i) {
        this.mData.alf = i;
    }

    public int getMsgLiveVip() {
        return this.mData.alf;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.asM = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.asM;
    }
}
