package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
/* loaded from: classes.dex */
public class b {
    public String oH(String str) {
        i BX;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = l.q(str, 1);
                bVar.x("type", 2);
                j ft = bVar.ft(q);
                if (ft != null && ft.isSuccess() && (BX = ft.BX()) != null) {
                    String BV = BX.BV();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, BV);
                    return BV;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
