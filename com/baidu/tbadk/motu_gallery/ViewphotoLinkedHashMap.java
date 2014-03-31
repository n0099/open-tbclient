package com.baidu.tbadk.motu_gallery;

import android.widget.ImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class ViewphotoLinkedHashMap extends LinkedHashMap<Integer, ImageView> {
    private static final long serialVersionUID = 3983900253652517307L;
    private final Lock lock;
    private final int maxCapacity;

    public ViewphotoLinkedHashMap(int i) {
        super(i, 0.75f, true);
        this.lock = new ReentrantLock();
        this.maxCapacity = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<Integer, ImageView> entry) {
        return size() > this.maxCapacity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public ImageView get(Object obj) {
        try {
            this.lock.lock();
            return (ImageView) super.get(obj);
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public ImageView put(Integer num, ImageView imageView) {
        try {
            this.lock.lock();
            return (ImageView) super.put((ViewphotoLinkedHashMap) num, (Integer) imageView);
        } finally {
            this.lock.unlock();
        }
    }
}
