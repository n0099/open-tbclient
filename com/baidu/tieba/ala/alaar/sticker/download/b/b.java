package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d fWB;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c fWF = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.fWB = dVar;
        this.fWF.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.fWF.setStatus(101);
        this.fWF.bKV().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.fWF.setStatus(102);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.fWF.setTime(j);
        this.fWF.setAcceptRanges(z);
        this.fWF.setStatus(103);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.fWF.d(downloadException);
        this.fWF.setStatus(108);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.fWF.setStatus(107);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.fWF.setFinished(j);
        this.fWF.setLength(j2);
        this.fWF.setPercent(i);
        this.fWF.setStatus(104);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.fWF.setStatus(105);
        this.fWF.setSavedPath(str);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.fWF.setStatus(106);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.fWF.setStatus(107);
        this.fWB.a(this.fWF);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.fWF.d(downloadException);
        this.fWF.setStatus(108);
        this.fWB.a(this.fWF);
    }
}
