package com.baidu.tieba.im.message;

import com.baidu.tieba.im.codec.q;
/* loaded from: classes.dex */
public class ResponsedMessage extends Message {
    private String errMsg;
    private int errNo;
    private Message orginalMessage;

    public ResponsedMessage() {
    }

    public ResponsedMessage(int i) {
        setCmd(i);
    }

    public boolean hasError() {
        return this.errNo != 0;
    }

    public int getErrNo() {
        return this.errNo;
    }

    public void setErrNo(int i) {
        this.errNo = i;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setErrorInfo(q qVar) {
        if (qVar == null) {
            this.errNo = 0;
            return;
        }
        this.errNo = qVar.f1576a;
        this.errMsg = qVar.c;
    }

    public Message getOrginalMessage() {
        return this.orginalMessage;
    }

    public void setOrginalMessage(Message message) {
        this.orginalMessage = message;
    }
}
