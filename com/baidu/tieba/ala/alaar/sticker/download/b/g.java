package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.a.e;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends d {
    public g(a aVar, i iVar, e.a aVar2) {
        super(aVar, iVar, aVar2);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected void a(i iVar) {
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected int getResponseCode() {
        return 206;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected void b(i iVar) {
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected Map<String, String> c(i iVar) {
        HashMap hashMap = new HashMap();
        long start = iVar.getStart() + iVar.getFinished();
        hashMap.put(Headers.RANGE, "bytes=" + start + Constants.ACCEPT_TIME_SEPARATOR_SERVER + iVar.getEnd());
        return hashMap;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected RandomAccessFile getFile(File file, String str, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(j);
        return randomAccessFile;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.b.d
    protected String getTag() {
        return getClass().getSimpleName();
    }
}
