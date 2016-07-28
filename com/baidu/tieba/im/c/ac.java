package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String li(String str) {
        com.baidu.tbadk.coreExtra.data.d wx;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = com.baidu.tbadk.core.util.m.r(str, 1);
                cVar.w("type", 2);
                com.baidu.tbadk.coreExtra.data.e dY = cVar.dY(r);
                if (dY != null && dY.isSuccess() && (wx = dY.wx()) != null) {
                    String md5 = wx.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ag(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
