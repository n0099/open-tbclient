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
    private ay iRD;
    private final ArrayList<by> iRF;
    private boolean iRG;
    private boolean iRH;

    private b() {
        this.iRG = false;
        this.iRF = new ArrayList<>();
    }

    public static b cBd() {
        return a.iRI;
    }

    public boolean cAX() {
        return this.iRG;
    }

    public void V(boolean z, boolean z2) {
        this.iRG = z;
        if (this.iRD != null) {
            this.iRD.d(this.iRG, z2, 1);
        }
    }

    public boolean al(by byVar) {
        if (byVar == null) {
            return false;
        }
        if (this.iRF.size() > 29) {
            if (this.iRD != null) {
                this.iRD.zK(1);
                return false;
            }
            return false;
        }
        this.iRF.add(byVar);
        if (this.iRD != null) {
            this.iRD.cq(this.iRF.size(), 1);
        }
        return true;
    }

    public List<by> cBa() {
        return this.iRF;
    }

    public void am(by byVar) {
        this.iRF.remove(byVar);
        if (this.iRD != null) {
            this.iRD.cq(this.iRF.size(), 1);
        }
    }

    public void clearData() {
        Iterator<by> it = this.iRF.iterator();
        while (it.hasNext()) {
            by next = it.next();
            if (next != null) {
                next.jg(false);
            }
        }
        this.iRF.clear();
        if (this.iRD != null) {
            this.iRD.cq(0, 1);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.iRD = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b iRI = new b();
    }

    public AntiData cBe() {
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
        this.iRH = z;
    }

    public void dg(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.iRF)) {
            Iterator<by> it = this.iRF.iterator();
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
            if (this.iRD != null) {
                this.iRD.cq(this.iRF.size(), 1);
            }
        }
    }

    public boolean cBf() {
        return this.iRH;
    }
}
