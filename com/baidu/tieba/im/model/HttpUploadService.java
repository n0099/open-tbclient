package com.baidu.tieba.im.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.data.b;
import com.baidu.tbadk.coreExtra.data.c;
/* loaded from: classes.dex */
public class HttpUploadService {
    public String submitVoiceBinary(String str) {
        b ox;
        if (str != null) {
            try {
                c cI = new com.baidu.tbadk.coreExtra.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).cI(s.n(str, 1));
                if (cI != null && cI.isSuccess() && (ox = cI.ox()) != null) {
                    String ou = ox.ou();
                    com.baidu.tbadk.core.voice.a.b.P(str, ou);
                    return ou;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
