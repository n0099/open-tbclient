package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData epR;
    private String forumId;
    private aw hEj;
    private final ArrayList<bv> hEl;
    private boolean hEm;
    private boolean hEn;

    private b() {
        this.hEm = false;
        this.hEl = new ArrayList<>();
    }

    public static b caw() {
        return a.hEo;
    }

    public boolean caq() {
        return this.hEm;
    }

    public void N(boolean z, boolean z2) {
        this.hEm = z;
        if (this.hEj != null) {
            this.hEj.d(this.hEm, z2, 1);
        }
    }

    public boolean ai(bv bvVar) {
        if (bvVar == null) {
            return false;
        }
        if (this.hEl.size() > 29) {
            if (this.hEj != null) {
                this.hEj.uH(1);
                return false;
            }
            return false;
        }
        this.hEl.add(bvVar);
        if (this.hEj != null) {
            this.hEj.bX(this.hEl.size(), 1);
        }
        return true;
    }

    public List<bv> cat() {
        return this.hEl;
    }

    public void aj(bv bvVar) {
        this.hEl.remove(bvVar);
        if (this.hEj != null) {
            this.hEj.bX(this.hEl.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bv> it = this.hEl.iterator();
        while (it.hasNext()) {
            bv next = it.next();
            if (next != null) {
                next.hE(false);
            }
        }
        this.hEl.clear();
        if (this.hEj != null) {
            this.hEj.bX(0, 1);
        }
    }

    public void reset() {
        N(false, false);
        clearData();
    }

    public void a(aw awVar) {
        this.hEj = awVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b hEo = new b();
    }

    public AntiData cax() {
        return this.epR;
    }

    public void b(AntiData antiData) {
        this.epR = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void nw(boolean z) {
        this.hEn = z;
    }

    public void cA(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list) && !com.baidu.tbadk.core.util.x.isEmpty(this.hEl)) {
            Iterator<bv> it = this.hEl.iterator();
            while (it.hasNext()) {
                bv next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.as.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.hEj != null) {
                this.hEj.bX(this.hEl.size(), 1);
            }
        }
    }

    public boolean cay() {
        return this.hEn;
    }
}
