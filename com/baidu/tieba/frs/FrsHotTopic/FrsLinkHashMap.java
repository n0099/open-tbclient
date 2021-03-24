package com.baidu.tieba.frs.FrsHotTopic;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsLinkHashMap<String, Long> extends LinkedHashMap<String, Long> {
    public static final int MAX_COUNT = 100;

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
        return size() > 100;
    }
}
