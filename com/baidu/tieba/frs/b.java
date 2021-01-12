package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String forumId;
    private AntiData fos;
    private av iZk;
    private final ArrayList<bz> iZm;
    private boolean iZn;
    private boolean iZo;

    private b() {
        this.iZn = false;
        this.iZm = new ArrayList<>();
    }

    public static b cAg() {
        return a.iZp;
    }

    public boolean cAa() {
        return this.iZn;
    }

    public void X(boolean z, boolean z2) {
        this.iZn = z;
        if (this.iZk != null) {
            this.iZk.e(this.iZn, z2, 1);
        }
    }

    public boolean al(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        if (this.iZm.size() > 29) {
            if (this.iZk != null) {
                this.iZk.yr(1);
                return false;
            }
            return false;
        }
        this.iZm.add(bzVar);
        if (this.iZk != null) {
            this.iZk.co(this.iZm.size(), 1);
        }
        return true;
    }

    public List<bz> cAd() {
        return this.iZm;
    }

    public void am(bz bzVar) {
        this.iZm.remove(bzVar);
        if (this.iZk != null) {
            this.iZk.co(this.iZm.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bz> it = this.iZm.iterator();
        while (it.hasNext()) {
            bz next = it.next();
            if (next != null) {
                next.jy(false);
            }
        }
        this.iZm.clear();
        if (this.iZk != null) {
            this.iZk.co(0, 1);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void a(av avVar) {
        this.iZk = avVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b iZp = new b();
    }

    public AntiData cAh() {
        return this.fos;
    }

    public void b(AntiData antiData) {
        this.fos = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void qh(boolean z) {
        this.iZo = z;
    }

    public void dn(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list) && !com.baidu.tbadk.core.util.x.isEmpty(this.iZm)) {
            Iterator<bz> it = this.iZm.iterator();
            while (it.hasNext()) {
                bz next = it.next();
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
            if (this.iZk != null) {
                this.iZk.co(this.iZm.size(), 1);
            }
        }
    }

    public boolean cAi() {
        return this.iZo;
    }
}
