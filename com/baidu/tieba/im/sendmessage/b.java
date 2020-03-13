package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.l;
/* loaded from: classes.dex */
public class b {
    public String Dw(String str) {
        l aJt;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String storeFile = m.getStoreFile(str, 1);
                bVar.addPostParam("type", 2);
                com.baidu.tbadk.coreExtra.data.m uf = bVar.uf(storeFile);
                if (uf != null && uf.isSuccess() && (aJt = uf.aJt()) != null) {
                    String md5 = aJt.getMd5();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
