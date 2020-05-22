package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d eWI;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c eWM = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.eWI = dVar;
        this.eWM.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.eWM.setStatus(101);
        this.eWM.bpE().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.eWM.setStatus(102);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.eWM.setTime(j);
        this.eWM.setAcceptRanges(z);
        this.eWM.setStatus(103);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.eWM.d(downloadException);
        this.eWM.setStatus(108);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.eWM.setStatus(107);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.eWM.setFinished(j);
        this.eWM.setLength(j2);
        this.eWM.setPercent(i);
        this.eWM.setStatus(104);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.eWM.setStatus(105);
        this.eWM.setSavedPath(str);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.eWM.setStatus(106);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.eWM.setStatus(107);
        this.eWI.a(this.eWM);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.eWM.d(downloadException);
        this.eWM.setStatus(108);
        this.eWI.a(this.eWM);
    }
}
