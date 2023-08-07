package com.baidu.tieba;

import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.IOException;
/* loaded from: classes5.dex */
public interface cda {
    void a(fda fdaVar);

    VideoFinishResult b(String str, int i) throws IOException;

    void cancel();
}
