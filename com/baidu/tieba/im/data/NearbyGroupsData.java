package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NearbyGroupsData extends ArrayList<d> {
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

    public e findItemByGroupId(String str) {
        e eVar;
        if (str == null) {
            return null;
        }
        Iterator<d> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                eVar = null;
                break;
            }
            d next = it.next();
            if ((next instanceof e) && ((e) next).c() != null && ((e) next).c().equals(str)) {
                eVar = (e) next;
                break;
            }
        }
        return eVar;
    }

    public c getFirstGroup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size()) {
                return null;
            }
            d dVar = get(i2);
            if (!(dVar instanceof c)) {
                i = i2 + 1;
            } else {
                return (c) dVar;
            }
        }
    }

    public c getLastGroup() {
        for (int size = size() - 1; size >= 0 && size >= 0; size--) {
            d dVar = get(size);
            if (dVar instanceof c) {
                return (c) dVar;
            }
        }
        return null;
    }
}
