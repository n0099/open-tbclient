package com.baidu.tieba.im.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class PlayStatusChangedMessage extends CustomResponsedMessage<Object> {
    public static final int STATUS_ERROR = 10;
    public static final int STATUS_LOADING = 7;
    public static final int STATUS_PAUSED = 5;
    public static final int STATUS_PLAYING = 20;
    public static final int STATUS_STOPPED = 0;
    private int errorMsg;
    private int errorNo;
    private int groupId;
    private int status;
    private String url;

    public PlayStatusChangedMessage() {
        super(2001159);
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getErrorNo() {
        return this.errorNo;
    }

    public void setErrorNo(int i) {
        this.errorNo = i;
    }

    public int getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(int i) {
        this.errorMsg = i;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
