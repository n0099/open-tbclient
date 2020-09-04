package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d fxW;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c fya = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.fxW = dVar;
        this.fya.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.fya.setStatus(101);
        this.fya.bEv().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.fya.setStatus(102);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.fya.setTime(j);
        this.fya.setAcceptRanges(z);
        this.fya.setStatus(103);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.fya.d(downloadException);
        this.fya.setStatus(108);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.fya.setStatus(107);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.fya.setFinished(j);
        this.fya.setLength(j2);
        this.fya.setPercent(i);
        this.fya.setStatus(104);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.fya.setStatus(105);
        this.fya.setSavedPath(str);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.fya.setStatus(106);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.fya.setStatus(107);
        this.fxW.a(this.fya);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.fya.d(downloadException);
        this.fya.setStatus(108);
        this.fxW.a(this.fya);
    }
}
