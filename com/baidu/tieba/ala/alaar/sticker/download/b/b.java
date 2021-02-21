package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes11.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d gtc;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c gtg = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.gtc = dVar;
        this.gtg.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.gtg.setStatus(101);
        this.gtg.bPS().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.gtg.setStatus(102);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.gtg.setTime(j);
        this.gtg.setAcceptRanges(z);
        this.gtg.setStatus(103);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.gtg.d(downloadException);
        this.gtg.setStatus(108);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.gtg.setStatus(107);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.gtg.setFinished(j);
        this.gtg.setLength(j2);
        this.gtg.setPercent(i);
        this.gtg.setStatus(104);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.gtg.setStatus(105);
        this.gtg.setSavedPath(str);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.gtg.setStatus(106);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.gtg.setStatus(107);
        this.gtc.a(this.gtg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.gtg.d(downloadException);
        this.gtg.setStatus(108);
        this.gtc.a(this.gtg);
    }
}
