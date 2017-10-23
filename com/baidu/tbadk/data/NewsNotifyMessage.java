package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aru = 0;
        private int arv = 0;
        private int arw = 0;
        private int ary = 0;
        private int arx = 0;
        private int arz = 0;
        private int aze = 0;
        private int azf = 0;
        private int arA = 0;
        private int azg = 0;

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
        this.mData.aru = i;
        this.mData.arv = i2;
        this.mData.arw = i3;
        this.mData.arx = i4;
        this.mData.arz = i5;
        this.mData.aze = i6;
    }

    public int getMsgReplyme() {
        return this.mData.aru;
    }

    public void setMsgReplyme(int i) {
        this.mData.aru = i;
    }

    public int getMsgAtme() {
        return this.mData.arv;
    }

    public void setMsgAtme(int i) {
        this.mData.arv = i;
    }

    public int getMsgChat() {
        return this.mData.arw;
    }

    public void setMsgChat(int i) {
        this.mData.arw = i;
    }

    public void setMsgFans(int i) {
        this.mData.ary = i;
    }

    public int getMsgFans() {
        return this.mData.ary;
    }

    public int getMsgBookmark() {
        return this.mData.arx;
    }

    public void setMsgBookmark(int i) {
        this.mData.arx = i;
    }

    public int getMsgGiftNum() {
        return this.mData.arz;
    }

    public void setMsgGiftNum(int i) {
        this.mData.arz = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aze = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aze;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.azf = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.azf;
    }

    public void setMsgLiveVip(int i) {
        this.mData.arA = i;
    }

    public int getMsgLiveVip() {
        return this.mData.arA;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.azg = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.azg;
    }
}
