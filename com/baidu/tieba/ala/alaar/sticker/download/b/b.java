package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d eKl;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c eKp = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.eKl = dVar;
        this.eKp.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.eKp.setStatus(101);
        this.eKp.bkk().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.eKp.setStatus(102);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.eKp.setTime(j);
        this.eKp.setAcceptRanges(z);
        this.eKp.setStatus(103);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.eKp.d(downloadException);
        this.eKp.setStatus(108);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.eKp.setStatus(107);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.eKp.setFinished(j);
        this.eKp.setLength(j2);
        this.eKp.setPercent(i);
        this.eKp.setStatus(104);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.eKp.setStatus(105);
        this.eKp.setSavedPath(str);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.eKp.setStatus(106);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.eKp.setStatus(107);
        this.eKl.a(this.eKp);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.eKp.d(downloadException);
        this.eKp.setStatus(108);
        this.eKl.a(this.eKp);
    }
}
