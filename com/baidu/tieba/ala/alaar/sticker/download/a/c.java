package com.baidu.tieba.ala.alaar.sticker.download.a;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes7.dex */
public class c {
    private boolean acceptRanges;
    private boolean calledCompleted;
    private long finished;
    private DownloadException fxY;
    private a fxZ;
    private long length;
    private int percent;
    private String savedPath;
    private int status;
    private long time;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTime(long j) {
        this.time = j;
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

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public boolean isAcceptRanges() {
        return this.acceptRanges;
    }

    public void setAcceptRanges(boolean z) {
        this.acceptRanges = z;
    }

    public Exception getException() {
        return this.fxY;
    }

    public void d(DownloadException downloadException) {
        this.fxY = downloadException;
    }

    public a bEv() {
        return this.fxZ;
    }

    public void a(a aVar) {
        this.fxZ = aVar;
    }

    public String getSavedPath() {
        return this.savedPath;
    }

    public void setSavedPath(String str) {
        this.savedPath = str;
    }

    public void setCalledCompleted(boolean z) {
        this.calledCompleted = z;
    }

    public boolean getCalledCompleted() {
        return this.calledCompleted;
    }
}
