package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.q;
/* loaded from: classes.dex */
public class b {
    public String LC(String str) {
        p bnF;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String storeFile = n.getStoreFile(str, 1);
                bVar.addPostParam("type", 2);
                q Bm = bVar.Bm(storeFile);
                if (Bm != null && Bm.isSuccess() && (bnF = Bm.bnF()) != null) {
                    String md5 = bnF.getMd5();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
