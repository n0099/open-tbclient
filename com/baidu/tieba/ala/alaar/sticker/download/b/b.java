package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d gkk;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c gko = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.gkk = dVar;
        this.gko.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.gko.setStatus(101);
        this.gko.bQy().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.gko.setStatus(102);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.gko.setTime(j);
        this.gko.setAcceptRanges(z);
        this.gko.setStatus(103);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.gko.d(downloadException);
        this.gko.setStatus(108);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.gko.setStatus(107);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.gko.setFinished(j);
        this.gko.setLength(j2);
        this.gko.setPercent(i);
        this.gko.setStatus(104);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.gko.setStatus(105);
        this.gko.setSavedPath(str);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.gko.setStatus(106);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.gko.setStatus(107);
        this.gkk.a(this.gko);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.gko.d(downloadException);
        this.gko.setStatus(108);
        this.gkk.a(this.gko);
    }
}
