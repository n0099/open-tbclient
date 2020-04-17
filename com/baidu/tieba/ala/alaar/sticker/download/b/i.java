package com.baidu.tieba.ala.alaar.sticker.download.b;
/* loaded from: classes3.dex */
public class i {
    private long end;
    private long finished;
    private int id;
    private long start;
    private String tag;
    private String uri;

    public i() {
    }

    public i(int i, String str, String str2, long j) {
        this(i, str, str2, 0L, 0L, j);
    }

    public i(int i, String str, String str2, long j, long j2, long j3) {
        this.id = i;
        this.tag = str;
        this.uri = str2;
        this.start = j;
        this.end = j2;
        this.finished = j3;
    }

    public String getUri() {
        return this.uri;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public long getFinished() {
        return this.finished;
    }

    public void setFinished(long j) {
        this.finished = j;
    }
}
