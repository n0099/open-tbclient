package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int alb = 0;
        private int alc = 0;
        private int ald = 0;
        private int alf = 0;
        private int ale = 0;
        private int alg = 0;
        private int asS = 0;
        private int asT = 0;
        private int alh = 0;
        private int asU = 0;

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
        this.mData.alb = i;
        this.mData.alc = i2;
        this.mData.ald = i3;
        this.mData.ale = i4;
        this.mData.alg = i5;
        this.mData.asS = i6;
    }

    public int getMsgReplyme() {
        return this.mData.alb;
    }

    public void setMsgReplyme(int i) {
        this.mData.alb = i;
    }

    public int getMsgAtme() {
        return this.mData.alc;
    }

    public void setMsgAtme(int i) {
        this.mData.alc = i;
    }

    public int getMsgChat() {
        return this.mData.ald;
    }

    public void setMsgChat(int i) {
        this.mData.ald = i;
    }

    public void setMsgFans(int i) {
        this.mData.alf = i;
    }

    public int getMsgFans() {
        return this.mData.alf;
    }

    public int getMsgBookmark() {
        return this.mData.ale;
    }

    public void setMsgBookmark(int i) {
        this.mData.ale = i;
    }

    public int getMsgGiftNum() {
        return this.mData.alg;
    }

    public void setMsgGiftNum(int i) {
        this.mData.alg = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.asS = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.asS;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.asT = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.asT;
    }

    public void setMsgLiveVip(int i) {
        this.mData.alh = i;
    }

    public int getMsgLiveVip() {
        return this.mData.alh;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.asU = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.asU;
    }
}
