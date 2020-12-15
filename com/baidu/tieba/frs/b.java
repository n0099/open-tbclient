package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.by;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData fju;
    private String forumId;
    private ay iRF;
    private final ArrayList<by> iRH;
    private boolean iRI;
    private boolean iRJ;

    private b() {
        this.iRI = false;
        this.iRH = new ArrayList<>();
    }

    public static b cBe() {
        return a.iRK;
    }

    public boolean cAY() {
        return this.iRI;
    }

    public void V(boolean z, boolean z2) {
        this.iRI = z;
        if (this.iRF != null) {
            this.iRF.d(this.iRI, z2, 1);
        }
    }

    public boolean al(by byVar) {
        if (byVar == null) {
            return false;
        }
        if (this.iRH.size() > 29) {
            if (this.iRF != null) {
                this.iRF.zK(1);
                return false;
            }
            return false;
        }
        this.iRH.add(byVar);
        if (this.iRF != null) {
            this.iRF.cq(this.iRH.size(), 1);
        }
        return true;
    }

    public List<by> cBb() {
        return this.iRH;
    }

    public void am(by byVar) {
        this.iRH.remove(byVar);
        if (this.iRF != null) {
            this.iRF.cq(this.iRH.size(), 1);
        }
    }

    public void clearData() {
        Iterator<by> it = this.iRH.iterator();
        while (it.hasNext()) {
            by next = it.next();
            if (next != null) {
                next.jg(false);
            }
        }
        this.iRH.clear();
        if (this.iRF != null) {
            this.iRF.cq(0, 1);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.iRF = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b iRK = new b();
    }

    public AntiData cBf() {
        return this.fju;
    }

    public void b(AntiData antiData) {
        this.fju = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void pO(boolean z) {
        this.iRJ = z;
    }

    public void dg(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.iRH)) {
            Iterator<by> it = this.iRH.iterator();
            while (it.hasNext()) {
                by next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.au.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.iRF != null) {
                this.iRF.cq(this.iRH.size(), 1);
            }
        }
    }

    public boolean cBg() {
        return this.iRJ;
    }
}
