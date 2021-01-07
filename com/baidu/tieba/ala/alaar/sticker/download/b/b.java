package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes11.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d guL;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c guP = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.guL = dVar;
        this.guP.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.guP.setStatus(101);
        this.guP.bSZ().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.guP.setStatus(102);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.guP.setTime(j);
        this.guP.setAcceptRanges(z);
        this.guP.setStatus(103);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.guP.d(downloadException);
        this.guP.setStatus(108);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.guP.setStatus(107);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.guP.setFinished(j);
        this.guP.setLength(j2);
        this.guP.setPercent(i);
        this.guP.setStatus(104);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.guP.setStatus(105);
        this.guP.setSavedPath(str);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.guP.setStatus(106);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.guP.setStatus(107);
        this.guL.a(this.guP);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.guP.d(downloadException);
        this.guP.setStatus(108);
        this.guL.a(this.guP);
    }
}
