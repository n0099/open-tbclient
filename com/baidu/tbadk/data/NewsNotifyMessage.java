package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int asy = 0;
        private int asz = 0;
        private int asA = 0;
        private int asC = 0;
        private int asB = 0;
        private int asD = 0;
        private int azW = 0;
        private int azX = 0;
        private int asE = 0;
        private int azY = 0;

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
        this.mData.asy = i;
        this.mData.asz = i2;
        this.mData.asA = i3;
        this.mData.asB = i4;
        this.mData.asD = i5;
        this.mData.azW = i6;
    }

    public int getMsgReplyme() {
        return this.mData.asy;
    }

    public void setMsgReplyme(int i) {
        this.mData.asy = i;
    }

    public int getMsgAtme() {
        return this.mData.asz;
    }

    public void setMsgAtme(int i) {
        this.mData.asz = i;
    }

    public int getMsgChat() {
        return this.mData.asA;
    }

    public void setMsgChat(int i) {
        this.mData.asA = i;
    }

    public void setMsgFans(int i) {
        this.mData.asC = i;
    }

    public int getMsgFans() {
        return this.mData.asC;
    }

    public int getMsgBookmark() {
        return this.mData.asB;
    }

    public void setMsgBookmark(int i) {
        this.mData.asB = i;
    }

    public int getMsgGiftNum() {
        return this.mData.asD;
    }

    public void setMsgGiftNum(int i) {
        this.mData.asD = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.azW = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.azW;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.azX = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.azX;
    }

    public void setMsgLiveVip(int i) {
        this.mData.asE = i;
    }

    public int getMsgLiveVip() {
        return this.mData.asE;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.azY = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.azY;
    }
}
