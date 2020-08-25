package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private AntiData eAl;
    private String forumId;
    private boolean hRA;
    private boolean hRB;
    private ay hRx;
    private final ArrayList<bw> hRz;

    private b() {
        this.hRA = false;
        this.hRz = new ArrayList<>();
    }

    public static b ckS() {
        return a.hRC;
    }

    public boolean ckM() {
        return this.hRA;
    }

    public void R(boolean z, boolean z2) {
        this.hRA = z;
        if (this.hRx != null) {
            this.hRx.d(this.hRA, z2, 1);
        }
    }

    public boolean ai(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.hRz.size() > 29) {
            if (this.hRx != null) {
                this.hRx.wW(1);
                return false;
            }
            return false;
        }
        this.hRz.add(bwVar);
        if (this.hRx != null) {
            this.hRx.cf(this.hRz.size(), 1);
        }
        return true;
    }

    public List<bw> ckP() {
        return this.hRz;
    }

    public void aj(bw bwVar) {
        this.hRz.remove(bwVar);
        if (this.hRx != null) {
            this.hRx.cf(this.hRz.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bw> it = this.hRz.iterator();
        while (it.hasNext()) {
            bw next = it.next();
            if (next != null) {
                next.ia(false);
            }
        }
        this.hRz.clear();
        if (this.hRx != null) {
            this.hRx.cf(0, 1);
        }
    }

    public void reset() {
        R(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.hRx = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static b hRC = new b();
    }

    public AntiData ckT() {
        return this.eAl;
    }

    public void b(AntiData antiData) {
        this.eAl = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void oa(boolean z) {
        this.hRB = z;
    }

    public void cC(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.hRz)) {
            Iterator<bw> it = this.hRz.iterator();
            while (it.hasNext()) {
                bw next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.hRx != null) {
                this.hRx.cf(this.hRz.size(), 1);
            }
        }
    }

    public boolean ckU() {
        return this.hRB;
    }
}
