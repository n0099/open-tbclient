package com.baidu.tieba.ala.alaar.makeup.base;

import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class SafeConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V put(@NonNull K k, @NonNull V v) {
        if (k == null) {
            return null;
        }
        if (v == null) {
            return remove(k);
        }
        return (V) super.put(k, v);
    }
}
