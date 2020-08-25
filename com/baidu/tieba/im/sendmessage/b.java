package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.p;
/* loaded from: classes2.dex */
public class b {
    public String KZ(String str) {
        o bmL;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String storeFile = n.getStoreFile(str, 1);
                bVar.addPostParam("type", 2);
                p AP = bVar.AP(storeFile);
                if (AP != null && AP.isSuccess() && (bmL = AP.bmL()) != null) {
                    String md5 = bmL.getMd5();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
