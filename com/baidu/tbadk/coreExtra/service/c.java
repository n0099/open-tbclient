package com.baidu.tbadk.coreExtra.service;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.i;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
class c {
    private com.baidu.tbadk.coreExtra.data.b MB;
    private boolean MC = false;
    final /* synthetic */ b MD;
    private String mFileName;
    private ac mNetWork;
    private String mUrl;
    private String mVoiceMd5;

    public c(b bVar, String str, com.baidu.tbadk.coreExtra.data.b bVar2, String str2, String str3) {
        this.MD = bVar;
        this.mFileName = null;
        this.mUrl = null;
        this.MB = null;
        this.mVoiceMd5 = null;
        this.mFileName = str;
        this.MB = bVar2;
        this.mUrl = str2;
        this.mVoiceMd5 = str3;
    }

    public com.baidu.tbadk.coreExtra.data.c pF() {
        com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
        long ov = this.MB.ov();
        long j = ov % 30720 == 0 ? ov / 30720 : (ov / 30720) + 1;
        int ow = this.MB.ow();
        if (ow < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            if (randomAccessFile.skipBytes(ow * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < ow * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                cVar.ab(false);
                randomAccessFile.close();
                return cVar;
            }
            while (true) {
                int i = ow;
                if (i < j) {
                    int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (i == j - 1) {
                        i2 = (int) (ov - (30720 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.mNetWork = new ac(this.mUrl);
                        this.mNetWork.e("voice_chunk", bArr);
                        this.mNetWork.k("chunk_md5", this.MB.ou());
                        this.mNetWork.k("length", String.valueOf(read));
                        this.mNetWork.k("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                        this.mNetWork.k("total_length", String.valueOf(ov));
                        this.mNetWork.k("chunk_no", String.valueOf(i + 1));
                        this.mNetWork.k("total_num", String.valueOf(j));
                        this.mNetWork.k("voice_md5", this.mVoiceMd5);
                        boolean z = false;
                        if (this.MC) {
                            z = true;
                        } else if (this.mNetWork.lD() == null || !this.mNetWork.mc().nb().jq()) {
                            this.MB.bV(i);
                            i.a(this.MB);
                            randomAccessFile.close();
                            z = true;
                        }
                        if (z) {
                            cVar.setErrorCode(this.mNetWork.mg());
                            cVar.setErrorString(this.mNetWork.getErrorString());
                            cVar.b(this.MB);
                            cVar.ab(false);
                            return cVar;
                        }
                    }
                    ow = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        cVar.ab(true);
        return cVar;
    }
}
