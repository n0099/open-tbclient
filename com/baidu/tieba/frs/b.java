package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData eWX;
    private String forumId;
    private ay iAa;
    private final ArrayList<bw> iAc;
    private boolean iAd;
    private boolean iAe;

    private b() {
        this.iAd = false;
        this.iAc = new ArrayList<>();
    }

    public static b cuL() {
        return a.iAf;
    }

    public boolean cuF() {
        return this.iAd;
    }

    public void V(boolean z, boolean z2) {
        this.iAd = z;
        if (this.iAa != null) {
            this.iAa.d(this.iAd, z2, 1);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.iAc.size() > 29) {
            if (this.iAa != null) {
                this.iAa.yu(1);
                return false;
            }
            return false;
        }
        this.iAc.add(bwVar);
        if (this.iAa != null) {
            this.iAa.ck(this.iAc.size(), 1);
        }
        return true;
    }

    public List<bw> cuI() {
        return this.iAc;
    }

    public void ak(bw bwVar) {
        this.iAc.remove(bwVar);
        if (this.iAa != null) {
            this.iAa.ck(this.iAc.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bw> it = this.iAc.iterator();
        while (it.hasNext()) {
            bw next = it.next();
            if (next != null) {
                next.iH(false);
            }
        }
        this.iAc.clear();
        if (this.iAa != null) {
            this.iAa.ck(0, 1);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.iAa = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b iAf = new b();
    }

    public AntiData cuM() {
        return this.eWX;
    }

    public void b(AntiData antiData) {
        this.eWX = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void pf(boolean z) {
        this.iAe = z;
    }

    public void cU(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.iAc)) {
            Iterator<bw> it = this.iAc.iterator();
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
            if (this.iAa != null) {
                this.iAa.ck(this.iAc.size(), 1);
            }
        }
    }

    public boolean cuN() {
        return this.iAe;
    }
}
