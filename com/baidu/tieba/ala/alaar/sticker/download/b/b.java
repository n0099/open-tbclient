package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d fNr;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c fNv = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.fNr = dVar;
        this.fNv.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.fNv.setStatus(101);
        this.fNv.bIx().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.fNv.setStatus(102);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.fNv.setTime(j);
        this.fNv.setAcceptRanges(z);
        this.fNv.setStatus(103);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.fNv.d(downloadException);
        this.fNv.setStatus(108);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.fNv.setStatus(107);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.fNv.setFinished(j);
        this.fNv.setLength(j2);
        this.fNv.setPercent(i);
        this.fNv.setStatus(104);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.fNv.setStatus(105);
        this.fNv.setSavedPath(str);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.fNv.setStatus(106);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.fNv.setStatus(107);
        this.fNr.a(this.fNv);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.fNv.d(downloadException);
        this.fNv.setStatus(108);
        this.fNr.a(this.fNv);
    }
}
