package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d fBi;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c fBm = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.fBi = dVar;
        this.fBm.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.fBm.setStatus(101);
        this.fBm.bFL().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.fBm.setStatus(102);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.fBm.setTime(j);
        this.fBm.setAcceptRanges(z);
        this.fBm.setStatus(103);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.fBm.d(downloadException);
        this.fBm.setStatus(108);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.fBm.setStatus(107);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.fBm.setFinished(j);
        this.fBm.setLength(j2);
        this.fBm.setPercent(i);
        this.fBm.setStatus(104);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.fBm.setStatus(105);
        this.fBm.setSavedPath(str);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.fBm.setStatus(106);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.fBm.setStatus(107);
        this.fBi.a(this.fBm);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.fBm.d(downloadException);
        this.fBm.setStatus(108);
        this.fBi.a(this.fBm);
    }
}
