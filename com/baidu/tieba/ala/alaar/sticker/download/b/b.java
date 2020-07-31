package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.c fmB = new com.baidu.tieba.ala.alaar.sticker.download.a.c();
    private com.baidu.tieba.ala.alaar.sticker.download.a.d fmx;

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.fmx = dVar;
        this.fmB.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.fmB.setStatus(101);
        this.fmB.bvz().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.fmB.setStatus(102);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.fmB.setTime(j);
        this.fmB.setAcceptRanges(z);
        this.fmB.setStatus(103);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.fmB.d(downloadException);
        this.fmB.setStatus(108);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.fmB.setStatus(107);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.fmB.setFinished(j);
        this.fmB.setLength(j2);
        this.fmB.setPercent(i);
        this.fmB.setStatus(104);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.fmB.setStatus(105);
        this.fmB.setSavedPath(str);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.fmB.setStatus(106);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.fmB.setStatus(107);
        this.fmx.a(this.fmB);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.fmB.d(downloadException);
        this.fmB.setStatus(108);
        this.fmx.a(this.fmB);
    }
}
