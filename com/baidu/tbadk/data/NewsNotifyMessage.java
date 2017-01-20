package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int akl = 0;
        private int akm = 0;
        private int akn = 0;
        private int akp = 0;
        private int ako = 0;
        private int akq = 0;
        private int arX = 0;
        private int arY = 0;
        private int akr = 0;
        private int arZ = 0;

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
        this.mData.akl = i;
        this.mData.akm = i2;
        this.mData.akn = i3;
        this.mData.ako = i4;
        this.mData.akq = i5;
        this.mData.arX = i6;
    }

    public int getMsgReplyme() {
        return this.mData.akl;
    }

    public void setMsgReplyme(int i) {
        this.mData.akl = i;
    }

    public int getMsgAtme() {
        return this.mData.akm;
    }

    public void setMsgAtme(int i) {
        this.mData.akm = i;
    }

    public int getMsgChat() {
        return this.mData.akn;
    }

    public void setMsgChat(int i) {
        this.mData.akn = i;
    }

    public void setMsgFans(int i) {
        this.mData.akp = i;
    }

    public int getMsgFans() {
        return this.mData.akp;
    }

    public int getMsgBookmark() {
        return this.mData.ako;
    }

    public void setMsgBookmark(int i) {
        this.mData.ako = i;
    }

    public int getMsgGiftNum() {
        return this.mData.akq;
    }

    public void setMsgGiftNum(int i) {
        this.mData.akq = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.arX = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.arX;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.arY = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.arY;
    }

    public void setMsgLiveVip(int i) {
        this.mData.akr = i;
    }

    public int getMsgLiveVip() {
        return this.mData.akr;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.arZ = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.arZ;
    }
}
