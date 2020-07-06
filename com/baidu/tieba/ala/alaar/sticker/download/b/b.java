package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d fho;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c fhs = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.fho = dVar;
        this.fhs.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.fhs.setStatus(101);
        this.fhs.bsq().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.fhs.setStatus(102);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.fhs.setTime(j);
        this.fhs.setAcceptRanges(z);
        this.fhs.setStatus(103);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.fhs.d(downloadException);
        this.fhs.setStatus(108);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.fhs.setStatus(107);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.fhs.setFinished(j);
        this.fhs.setLength(j2);
        this.fhs.setPercent(i);
        this.fhs.setStatus(104);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.fhs.setStatus(105);
        this.fhs.setSavedPath(str);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.fhs.setStatus(106);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.fhs.setStatus(107);
        this.fho.a(this.fhs);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.fhs.d(downloadException);
        this.fhs.setStatus(108);
        this.fho.a(this.fhs);
    }
}
