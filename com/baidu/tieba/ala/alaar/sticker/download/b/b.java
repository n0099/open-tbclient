package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d eKg;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c eKk = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.eKg = dVar;
        this.eKk.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.eKk.setStatus(101);
        this.eKk.bkm().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.eKk.setStatus(102);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.eKk.setTime(j);
        this.eKk.setAcceptRanges(z);
        this.eKk.setStatus(103);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.eKk.d(downloadException);
        this.eKk.setStatus(108);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.eKk.setStatus(107);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.eKk.setFinished(j);
        this.eKk.setLength(j2);
        this.eKk.setPercent(i);
        this.eKk.setStatus(104);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.eKk.setStatus(105);
        this.eKk.setSavedPath(str);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.eKk.setStatus(106);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.eKk.setStatus(107);
        this.eKg.a(this.eKk);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.eKk.d(downloadException);
        this.eKk.setStatus(108);
        this.eKg.a(this.eKk);
    }
}
