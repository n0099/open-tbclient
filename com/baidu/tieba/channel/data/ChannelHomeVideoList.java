package com.baidu.tieba.channel.data;

import com.baidu.tieba.channel.config.a;
import com.baidu.tieba.channel.data.h;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ChannelHomeVideoList<E extends h> extends ArrayList<E> {
    public void checkBigVideoType() {
        int i = 0;
        if (size() > 5) {
            ((h) get(0)).setType(a.C0307a.eKj);
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 < size()) {
                    ((h) get(i3)).setType(a.C0307a.eKk);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                int i4 = i;
                if (i4 < size()) {
                    ((h) get(i4)).setType(a.C0307a.eKj);
                    i = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void setTopAndRemoveOldTop(h hVar) {
        unSetTop();
        setTop(hVar);
        checkBigVideoType();
    }

    public void setTop(h hVar) {
        hVar.setType(a.C0307a.eKj);
        hVar.pZ(1);
        int i = 0;
        while (true) {
            if (i >= size()) {
                i = 0;
                break;
            } else if (hVar == ((h) get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (i != 0) {
            remove(i);
            add(0, hVar);
        }
    }

    public void unSetTop() {
        if (size() > 0) {
            h hVar = (h) get(0);
            hVar.setType(a.C0307a.eKk);
            if (hVar.afj()) {
                hVar.pZ(0);
                int size = size() - 1;
                int i = 0;
                while (true) {
                    if (i >= size()) {
                        i = size;
                        break;
                    } else if (hVar.getCreateTime() > ((h) get(i)).getCreateTime()) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != 0) {
                    add(i, hVar);
                    remove(0);
                }
            }
        }
    }
}
