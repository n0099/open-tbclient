package com.baidu.tieba.ala.charm;

import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.List;
/* loaded from: classes11.dex */
public interface c {

    /* loaded from: classes11.dex */
    public interface a {
        void b(List<ALaCharmData> list, List<ALaCharmData> list2, String str);

        void onClose();

        void vh(String str);
    }

    void a(a aVar);

    void a(ALaCharmData aLaCharmData);

    void a(String str, String str2, String str3, boolean z, String str4, String str5);

    void bIn();

    void release();
}
