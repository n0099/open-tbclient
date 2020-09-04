package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData eAp;
    private String forumId;
    private ay hRD;
    private final ArrayList<bw> hRF;
    private boolean hRG;
    private boolean hRH;

    private b() {
        this.hRG = false;
        this.hRF = new ArrayList<>();
    }

    public static b ckT() {
        return a.hRI;
    }

    public boolean ckN() {
        return this.hRG;
    }

    public void R(boolean z, boolean z2) {
        this.hRG = z;
        if (this.hRD != null) {
            this.hRD.d(this.hRG, z2, 1);
        }
    }

    public boolean ai(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.hRF.size() > 29) {
            if (this.hRD != null) {
                this.hRD.wW(1);
                return false;
            }
            return false;
        }
        this.hRF.add(bwVar);
        if (this.hRD != null) {
            this.hRD.cf(this.hRF.size(), 1);
        }
        return true;
    }

    public List<bw> ckQ() {
        return this.hRF;
    }

    public void aj(bw bwVar) {
        this.hRF.remove(bwVar);
        if (this.hRD != null) {
            this.hRD.cf(this.hRF.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bw> it = this.hRF.iterator();
        while (it.hasNext()) {
            bw next = it.next();
            if (next != null) {
                next.ib(false);
            }
        }
        this.hRF.clear();
        if (this.hRD != null) {
            this.hRD.cf(0, 1);
        }
    }

    public void reset() {
        R(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.hRD = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b hRI = new b();
    }

    public AntiData ckU() {
        return this.eAp;
    }

    public void b(AntiData antiData) {
        this.eAp = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void oc(boolean z) {
        this.hRH = z;
    }

    public void cC(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.hRF)) {
            Iterator<bw> it = this.hRF.iterator();
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
            if (this.hRD != null) {
                this.hRD.cf(this.hRF.size(), 1);
            }
        }
    }

    public boolean ckV() {
        return this.hRH;
    }
}
