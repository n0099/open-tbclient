package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NearbyGroupsData extends ArrayList<i> {
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

    public j findItemByGroupId(String str) {
        j jVar;
        if (str == null) {
            return null;
        }
        Iterator<i> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                jVar = null;
                break;
            }
            i next = it.next();
            if ((next instanceof j) && ((j) next).c() != null && ((j) next).c().equals(str)) {
                jVar = (j) next;
                break;
            }
        }
        return jVar;
    }

    public h getFirstGroup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size()) {
                return null;
            }
            i iVar = get(i2);
            if (!(iVar instanceof h)) {
                i = i2 + 1;
            } else {
                return (h) iVar;
            }
        }
    }

    public h getLastGroup() {
        for (int size = size() - 1; size >= 0 && size >= 0; size--) {
            i iVar = get(size);
            if (iVar instanceof h) {
                return (h) iVar;
            }
        }
        return null;
    }
}
