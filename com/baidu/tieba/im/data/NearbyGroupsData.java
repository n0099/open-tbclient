package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NearbyGroupsData extends ArrayList<g> {
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

    public h findItemByGroupId(String str) {
        h hVar;
        if (str == null) {
            return null;
        }
        Iterator<g> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                hVar = null;
                break;
            }
            g next = it.next();
            if ((next instanceof h) && ((h) next).c() != null && ((h) next).c().equals(str)) {
                hVar = (h) next;
                break;
            }
        }
        return hVar;
    }

    public f getFirstGroup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size()) {
                return null;
            }
            g gVar = get(i2);
            if (!(gVar instanceof f)) {
                i = i2 + 1;
            } else {
                return (f) gVar;
            }
        }
    }

    public f getLastGroup() {
        for (int size = size() - 1; size >= 0 && size >= 0; size--) {
            g gVar = get(size);
            if (gVar instanceof f) {
                return (f) gVar;
            }
        }
        return null;
    }
}
