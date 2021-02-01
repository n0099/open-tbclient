package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes11.dex */
public class b implements com.baidu.tieba.ala.alaar.sticker.download.a.b {
    private com.baidu.tieba.ala.alaar.sticker.download.a.d gsO;
    private com.baidu.tieba.ala.alaar.sticker.download.a.c gsS = new com.baidu.tieba.ala.alaar.sticker.download.a.c();

    public b(com.baidu.tieba.ala.alaar.sticker.download.a.d dVar, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        this.gsO = dVar;
        this.gsS.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onStarted() {
        this.gsS.setStatus(101);
        this.gsS.bPL().onStarted();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnecting() {
        this.gsS.setStatus(102);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnected(long j, long j2, boolean z) {
        this.gsS.setTime(j);
        this.gsS.setAcceptRanges(z);
        this.gsS.setStatus(103);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void b(DownloadException downloadException) {
        this.gsS.d(downloadException);
        this.gsS.setStatus(108);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onConnectCanceled() {
        this.gsS.setStatus(107);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadProgress(long j, long j2, int i) {
        this.gsS.setFinished(j);
        this.gsS.setLength(j2);
        this.gsS.setPercent(i);
        this.gsS.setStatus(104);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCompleted(String str) {
        this.gsS.setStatus(105);
        this.gsS.setSavedPath(str);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadPaused() {
        this.gsS.setStatus(106);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void onDownloadCanceled() {
        this.gsS.setStatus(107);
        this.gsO.a(this.gsS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.b
    public void c(DownloadException downloadException) {
        this.gsS.d(downloadException);
        this.gsS.setStatus(108);
        this.gsO.a(this.gsS);
    }
}
