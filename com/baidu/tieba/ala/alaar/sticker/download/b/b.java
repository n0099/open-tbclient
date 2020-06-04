package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d eWT;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c eWX = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.eWT = dVar;
        this.eWX.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.eWX.setStatus(101);
        this.eWX.bpG().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.eWX.setStatus(102);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.eWX.setTime(j);
        this.eWX.setAcceptRanges(z);
        this.eWX.setStatus(103);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.eWX.d(downloadException);
        this.eWX.setStatus(108);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.eWX.setStatus(107);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.eWX.setFinished(j);
        this.eWX.setLength(j2);
        this.eWX.setPercent(i);
        this.eWX.setStatus(104);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.eWX.setStatus(105);
        this.eWX.setSavedPath(str);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.eWX.setStatus(106);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.eWX.setStatus(107);
        this.eWT.a(this.eWX);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.eWX.d(downloadException);
        this.eWX.setStatus(108);
        this.eWT.a(this.eWX);
    }
}
