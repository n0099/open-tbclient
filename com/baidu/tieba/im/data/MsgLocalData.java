package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class MsgLocalData extends OrmObject implements Serializable {
    public static final long serialVersionUID = -6687040214263261976L;
    public long errno;
    public long retry;
    public long rid;
    public short status;
    public String upload_offset;

    public long getErrno() {
        return this.errno;
    }

    public long getRetry() {
        return this.retry;
    }

    public long getRid() {
        return this.rid;
    }

    public Short getStatus() {
        return Short.valueOf(this.status);
    }

    public String getUpload_offset() {
        return this.upload_offset;
    }

    public void setErrno(long j) {
        this.errno = j;
    }

    public void setRetry(long j) {
        this.retry = j;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    public void setStatus(Short sh) {
        this.status = sh.shortValue();
    }

    public void setUpload_offset(String str) {
        this.upload_offset = str;
    }
}
