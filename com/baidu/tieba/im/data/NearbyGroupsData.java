package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NearbyGroupsData extends ArrayList<c> {
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

    public d findItemByGroupId(String str) {
        d dVar;
        if (str == null) {
            return null;
        }
        Iterator<c> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            c next = it.next();
            if ((next instanceof d) && ((d) next).getGroupId() != null && ((d) next).getGroupId().equals(str)) {
                dVar = (d) next;
                break;
            }
        }
        return dVar;
    }

    public b getFirstGroup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size()) {
                return null;
            }
            c cVar = get(i2);
            if (!(cVar instanceof b)) {
                i = i2 + 1;
            } else {
                return (b) cVar;
            }
        }
    }

    public b getLastGroup() {
        for (int size = size() - 1; size >= 0 && size >= 0; size--) {
            c cVar = get(size);
            if (cVar instanceof b) {
                return (b) cVar;
            }
        }
        return null;
    }
}
