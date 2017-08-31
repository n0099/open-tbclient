package com.baidu.tieba.i;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static long F(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    static a b(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j = length - IjkMediaMeta.AV_CH_TOP_BACK_CENTER;
        long j2 = j >= 0 ? j : 0L;
        int reverseBytes = Integer.reverseBytes(101010256);
        long j3 = length;
        do {
            randomAccessFile.seek(j3);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                a aVar = new a();
                aVar.size = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                aVar.evZ = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                return aVar;
            }
            j3--;
        } while (j3 >= j2);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = aVar.size;
        randomAccessFile.seek(aVar.evZ);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min((long) IjkMediaMeta.AV_CH_TOP_FRONT_RIGHT, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min((long) IjkMediaMeta.AV_CH_TOP_FRONT_RIGHT, j));
        }
        return crc32.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        long evZ;
        long size;

        a() {
        }
    }
}
