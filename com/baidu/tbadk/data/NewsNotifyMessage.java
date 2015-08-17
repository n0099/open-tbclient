package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int ahD = 0;
        private int ahE = 0;
        private int ahF = 0;
        private int ahH = 0;
        private int ahG = 0;
        private int ahI = 0;
        private int ann = 0;
        private int ano = 0;
        private int ahJ = 0;

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
        this.mData.ahD = i;
        this.mData.ahE = i2;
        this.mData.ahF = i3;
        this.mData.ahG = i4;
        this.mData.ahI = i5;
        this.mData.ann = i6;
    }

    public int getMsgReplyme() {
        return this.mData.ahD;
    }

    public void setMsgReplyme(int i) {
        this.mData.ahD = i;
    }

    public int getMsgAtme() {
        return this.mData.ahE;
    }

    public void setMsgAtme(int i) {
        this.mData.ahE = i;
    }

    public int getMsgChat() {
        return this.mData.ahF;
    }

    public void setMsgChat(int i) {
        this.mData.ahF = i;
    }

    public void setMsgFans(int i) {
        this.mData.ahH = i;
    }

    public int getMsgFans() {
        return this.mData.ahH;
    }

    public int getMsgBookmark() {
        return this.mData.ahG;
    }

    public void setMsgBookmark(int i) {
        this.mData.ahG = i;
    }

    public int getMsgGiftNum() {
        return this.mData.ahI;
    }

    public void setMsgGiftNum(int i) {
        this.mData.ahI = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.ann = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.ann;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.ano = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.ano;
    }

    public void setMsgLiveVip(int i) {
        this.mData.ahJ = i;
    }

    public int getMsgLiveVip() {
        return this.mData.ahJ;
    }
}
