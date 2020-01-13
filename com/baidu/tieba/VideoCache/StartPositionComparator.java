package com.baidu.tieba.VideoCache;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes7.dex */
class StartPositionComparator implements Serializable, Comparator<File> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        if (file == null || file2 == null) {
            return 0;
        }
        try {
            long parseLong = Long.parseLong(file.getName());
            long parseLong2 = Long.parseLong(file2.getName());
            int i = parseLong > parseLong2 ? 1 : 0;
            if (parseLong < parseLong2) {
                return -1;
            }
            return i;
        } catch (Exception e) {
            return 0;
        }
    }
}
