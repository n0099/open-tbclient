package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.q;
/* loaded from: classes.dex */
public class b {
    public String Ne(String str) {
        p bwr;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String storeFile = o.getStoreFile(str, 1);
                bVar.addPostParam("type", 2);
                q BP = bVar.BP(storeFile);
                if (BP != null && BP.isSuccess() && (bwr = BP.bwr()) != null) {
                    String md5 = bwr.getMd5();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
