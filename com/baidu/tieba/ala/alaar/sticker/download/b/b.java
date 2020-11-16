package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d gbZ;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c gcd = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.gbZ = dVar;
        this.gcd.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.gcd.setStatus(101);
        this.gcd.bMN().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.gcd.setStatus(102);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.gcd.setTime(j);
        this.gcd.setAcceptRanges(z);
        this.gcd.setStatus(103);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.gcd.d(downloadException);
        this.gcd.setStatus(108);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.gcd.setStatus(107);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.gcd.setFinished(j);
        this.gcd.setLength(j2);
        this.gcd.setPercent(i);
        this.gcd.setStatus(104);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.gcd.setStatus(105);
        this.gcd.setSavedPath(str);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.gcd.setStatus(106);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.gcd.setStatus(107);
        this.gbZ.a(this.gcd);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.gcd.d(downloadException);
        this.gcd.setStatus(108);
        this.gbZ.a(this.gcd);
    }
}
