package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d fxS;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c fxW = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.fxS = dVar;
        this.fxW.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.fxW.setStatus(101);
        this.fxW.bEu().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.fxW.setStatus(102);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.fxW.setTime(j);
        this.fxW.setAcceptRanges(z);
        this.fxW.setStatus(103);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.fxW.d(downloadException);
        this.fxW.setStatus(108);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.fxW.setStatus(107);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.fxW.setFinished(j);
        this.fxW.setLength(j2);
        this.fxW.setPercent(i);
        this.fxW.setStatus(104);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.fxW.setStatus(105);
        this.fxW.setSavedPath(str);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.fxW.setStatus(106);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.fxW.setStatus(107);
        this.fxS.a(this.fxW);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.fxW.d(downloadException);
        this.fxW.setStatus(108);
        this.fxS.a(this.fxW);
    }
}
