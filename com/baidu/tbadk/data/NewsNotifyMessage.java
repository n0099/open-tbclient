package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int ahg = 0;
        private int ahh = 0;
        private int ahi = 0;
        private int ahk = 0;
        private int ahj = 0;
        private int ahl = 0;
        private int aoO = 0;
        private int aoP = 0;
        private int ahm = 0;
        private int aoQ = 0;

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
        this.mData.ahg = i;
        this.mData.ahh = i2;
        this.mData.ahi = i3;
        this.mData.ahj = i4;
        this.mData.ahl = i5;
        this.mData.aoO = i6;
    }

    public int getMsgReplyme() {
        return this.mData.ahg;
    }

    public void setMsgReplyme(int i) {
        this.mData.ahg = i;
    }

    public int getMsgAtme() {
        return this.mData.ahh;
    }

    public void setMsgAtme(int i) {
        this.mData.ahh = i;
    }

    public int getMsgChat() {
        return this.mData.ahi;
    }

    public void setMsgChat(int i) {
        this.mData.ahi = i;
    }

    public void setMsgFans(int i) {
        this.mData.ahk = i;
    }

    public int getMsgFans() {
        return this.mData.ahk;
    }

    public int getMsgBookmark() {
        return this.mData.ahj;
    }

    public void setMsgBookmark(int i) {
        this.mData.ahj = i;
    }

    public int getMsgGiftNum() {
        return this.mData.ahl;
    }

    public void setMsgGiftNum(int i) {
        this.mData.ahl = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aoO = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aoO;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aoP = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aoP;
    }

    public void setMsgLiveVip(int i) {
        this.mData.ahm = i;
    }

    public int getMsgLiveVip() {
        return this.mData.ahm;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aoQ = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aoQ;
    }
}
