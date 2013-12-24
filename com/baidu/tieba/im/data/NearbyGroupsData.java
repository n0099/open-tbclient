package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NearbyGroupsData extends ArrayList<h> {
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

    public i findItemByGroupId(String str) {
        i iVar;
        if (str == null) {
            return null;
        }
        Iterator<h> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            h next = it.next();
            if ((next instanceof i) && ((i) next).c() != null && ((i) next).c().equals(str)) {
                iVar = (i) next;
                break;
            }
        }
        return iVar;
    }

    public g getFirstGroup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size()) {
                return null;
            }
            h hVar = get(i2);
            if (!(hVar instanceof g)) {
                i = i2 + 1;
            } else {
                return (g) hVar;
            }
        }
    }

    public g getLastGroup() {
        for (int size = size() - 1; size >= 0 && size >= 0; size--) {
            h hVar = get(size);
            if (hVar instanceof g) {
                return (g) hVar;
            }
        }
        return null;
    }
}
