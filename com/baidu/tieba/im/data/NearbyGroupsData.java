package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NearbyGroupsData extends ArrayList<f> {
    private static final long serialVersionUID = 1;
    private int geo;
    private boolean hasMore;
    private int offset;

    public int getGeo() {
        return this.geo;
    }

    public void setGeo(int i) {
        this.geo = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public g findItemByGroupId(String str) {
        g gVar;
        if (str == null) {
            return null;
        }
        Iterator<f> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            f next = it.next();
            if ((next instanceof g) && ((g) next).c() != null && ((g) next).c().equals(str)) {
                gVar = (g) next;
                break;
            }
        }
        return gVar;
    }

    public e getFirstGroup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size()) {
                return null;
            }
            f fVar = get(i2);
            if (!(fVar instanceof e)) {
                i = i2 + 1;
            } else {
                return (e) fVar;
            }
        }
    }

    public e getLastGroup() {
        for (int size = size() - 1; size >= 0 && size >= 0; size--) {
            f fVar = get(size);
            if (fVar instanceof e) {
                return (e) fVar;
            }
        }
        return null;
    }
}
