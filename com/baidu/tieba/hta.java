package com.baidu.tieba;

import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface hta {
    void a(kta ktaVar);

    VideoFinishResult b(String str, int i) throws IOException;

    void cancel();
}
