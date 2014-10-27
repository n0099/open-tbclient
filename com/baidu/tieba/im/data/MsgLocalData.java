package com.baidu.tieba.im.data;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgLocalData extends i implements Serializable {
    private static final long serialVersionUID = -6687040214263261976L;
    private long errno;
    private long retry;
    private long rid;
    private short status;
    private String upload_offset;

    public long getRid() {
        return this.rid;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    public Short getStatus() {
        return Short.valueOf(this.status);
    }

    public void setStatus(Short sh) {
        this.status = sh.shortValue();
    }

    public long getErrno() {
        return this.errno;
    }

    public void setErrno(long j) {
        this.errno = j;
    }

    public long getRetry() {
        return this.retry;
    }

    public void setRetry(long j) {
        this.retry = j;
    }

    public String getUpload_offset() {
        return this.upload_offset;
    }

    public void setUpload_offset(String str) {
        this.upload_offset = str;
    }
}
