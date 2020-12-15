package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d gkm;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c gkq = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.gkm = dVar;
        this.gkq.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.gkq.setStatus(101);
        this.gkq.bQz().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.gkq.setStatus(102);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.gkq.setTime(j);
        this.gkq.setAcceptRanges(z);
        this.gkq.setStatus(103);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.gkq.d(downloadException);
        this.gkq.setStatus(108);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.gkq.setStatus(107);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.gkq.setFinished(j);
        this.gkq.setLength(j2);
        this.gkq.setPercent(i);
        this.gkq.setStatus(104);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.gkq.setStatus(105);
        this.gkq.setSavedPath(str);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.gkq.setStatus(106);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.gkq.setStatus(107);
        this.gkm.a(this.gkq);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.gkq.d(downloadException);
        this.gkq.setStatus(108);
        this.gkm.a(this.gkq);
    }
}
