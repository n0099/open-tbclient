package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes10.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d gqe;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c gqi = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.gqe = dVar;
        this.gqi.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.gqi.setStatus(101);
        this.gqi.bPh().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.gqi.setStatus(102);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.gqi.setTime(j);
        this.gqi.setAcceptRanges(z);
        this.gqi.setStatus(103);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.gqi.d(downloadException);
        this.gqi.setStatus(108);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.gqi.setStatus(107);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.gqi.setFinished(j);
        this.gqi.setLength(j2);
        this.gqi.setPercent(i);
        this.gqi.setStatus(104);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.gqi.setStatus(105);
        this.gqi.setSavedPath(str);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.gqi.setStatus(106);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.gqi.setStatus(107);
        this.gqe.a(this.gqi);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.gqi.d(downloadException);
        this.gqi.setStatus(108);
        this.gqe.a(this.gqi);
    }
}
