package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.a.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes11.dex */
public class h extends d {
    public h(a aVar, i iVar, e.a aVar2) {
        super(aVar, iVar, aVar2);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected void a(i iVar) {
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected int getResponseCode() {
        return 200;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected void b(i iVar) {
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected Map<String, String> c(i iVar) {
        return null;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected RandomAccessFile getFile(File file, String str, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(0L);
        return randomAccessFile;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected String getTag() {
        return getClass().getSimpleName();
    }
}
