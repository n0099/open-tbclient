package com.baidu.tieba.ala.alaar.sticker.download.b;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private boolean acceptRanges;
    private File dir;
    private long finished;
    private long length;
    private String name;
    private String uri;

    public a() {
    }

    public a(String str, String str2, File file) {
        this.name = str;
        this.uri = str2;
        this.dir = file;
    }

    public String getName() {
        return this.name;
    }

    public File getDir() {
        return this.dir;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public long getFinished() {
        return this.finished;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public void setAcceptRanges(boolean z) {
        this.acceptRanges = z;
    }
}
