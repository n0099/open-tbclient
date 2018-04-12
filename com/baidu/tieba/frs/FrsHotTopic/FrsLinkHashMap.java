package com.baidu.tieba.frs.FrsHotTopic;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FrsLinkHashMap<String, Long> extends LinkedHashMap<String, Long> {
    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, Long> entry) {
        return size() > 100;
    }
}
