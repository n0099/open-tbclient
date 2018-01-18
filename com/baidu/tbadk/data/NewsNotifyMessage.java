package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int bgM = 0;
        private int bgN = 0;
        private int bgO = 0;
        private int bgQ = 0;
        private int bgP = 0;
        private int bgR = 0;
        private int boL = 0;
        private int boM = 0;
        private int bgS = 0;
        private int boN = 0;

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
        this.mData.bgM = i;
        this.mData.bgN = i2;
        this.mData.bgO = i3;
        this.mData.bgP = i4;
        this.mData.bgR = i5;
        this.mData.boL = i6;
    }

    public int getMsgReplyme() {
        return this.mData.bgM;
    }

    public void setMsgReplyme(int i) {
        this.mData.bgM = i;
    }

    public int getMsgAtme() {
        return this.mData.bgN;
    }

    public void setMsgAtme(int i) {
        this.mData.bgN = i;
    }

    public int getMsgChat() {
        return this.mData.bgO;
    }

    public void setMsgChat(int i) {
        this.mData.bgO = i;
    }

    public void setMsgFans(int i) {
        this.mData.bgQ = i;
    }

    public int getMsgFans() {
        return this.mData.bgQ;
    }

    public int getMsgBookmark() {
        return this.mData.bgP;
    }

    public void setMsgBookmark(int i) {
        this.mData.bgP = i;
    }

    public int getMsgGiftNum() {
        return this.mData.bgR;
    }

    public void setMsgGiftNum(int i) {
        this.mData.bgR = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.boL = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.boL;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.boM = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.boM;
    }

    public void setMsgLiveVip(int i) {
        this.mData.bgS = i;
    }

    public int getMsgLiveVip() {
        return this.mData.bgS;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.boN = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.boN;
    }
}
