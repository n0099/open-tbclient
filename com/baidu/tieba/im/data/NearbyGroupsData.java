package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NearbyGroupsData extends ArrayList<k> {
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

    public l findItemByGroupId(String str) {
        l lVar;
        if (str == null) {
            return null;
        }
        Iterator<k> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                lVar = null;
                break;
            }
            k next = it.next();
            if ((next instanceof l) && ((l) next).c() != null && ((l) next).c().equals(str)) {
                lVar = (l) next;
                break;
            }
        }
        return lVar;
    }

    public j getFirstGroup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size()) {
                return null;
            }
            k kVar = get(i2);
            if (!(kVar instanceof j)) {
                i = i2 + 1;
            } else {
                return (j) kVar;
            }
        }
    }

    public j getLastGroup() {
        for (int size = size() - 1; size >= 0 && size >= 0; size--) {
            k kVar = get(size);
            if (kVar instanceof j) {
                return (j) kVar;
            }
        }
        return null;
    }
}
