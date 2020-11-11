package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d gcs;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c gcw = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.gcs = dVar;
        this.gcw.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.gcw.setStatus(101);
        this.gcw.bNu().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.gcw.setStatus(102);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.gcw.setTime(j);
        this.gcw.setAcceptRanges(z);
        this.gcw.setStatus(103);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.gcw.d(downloadException);
        this.gcw.setStatus(108);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.gcw.setStatus(107);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.gcw.setFinished(j);
        this.gcw.setLength(j2);
        this.gcw.setPercent(i);
        this.gcw.setStatus(104);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.gcw.setStatus(105);
        this.gcw.setSavedPath(str);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.gcw.setStatus(106);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.gcw.setStatus(107);
        this.gcs.a(this.gcw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.gcw.d(downloadException);
        this.gcw.setStatus(108);
        this.gcs.a(this.gcw);
    }
}
