package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData eCu;
    private String forumId;
    private ay hYD;
    private final ArrayList<bw> hYF;
    private boolean hYG;
    private boolean hYH;

    private b() {
        this.hYG = false;
        this.hYF = new ArrayList<>();
    }

    public static b cog() {
        return a.hYI;
    }

    public boolean coa() {
        return this.hYG;
    }

    public void T(boolean z, boolean z2) {
        this.hYG = z;
        if (this.hYD != null) {
            this.hYD.d(this.hYG, z2, 1);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.hYF.size() > 29) {
            if (this.hYD != null) {
                this.hYD.xv(1);
                return false;
            }
            return false;
        }
        this.hYF.add(bwVar);
        if (this.hYD != null) {
            this.hYD.ci(this.hYF.size(), 1);
        }
        return true;
    }

    public List<bw> cod() {
        return this.hYF;
    }

    public void ak(bw bwVar) {
        this.hYF.remove(bwVar);
        if (this.hYD != null) {
            this.hYD.ci(this.hYF.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bw> it = this.hYF.iterator();
        while (it.hasNext()) {
            bw next = it.next();
            if (next != null) {
                next.hY(false);
            }
        }
        this.hYF.clear();
        if (this.hYD != null) {
            this.hYD.ci(0, 1);
        }
    }

    public void reset() {
        T(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.hYD = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b hYI = new b();
    }

    public AntiData coh() {
        return this.eCu;
    }

    public void b(AntiData antiData) {
        this.eCu = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void oi(boolean z) {
        this.hYH = z;
    }

    public void cI(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.hYF)) {
            Iterator<bw> it = this.hYF.iterator();
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
            if (this.hYD != null) {
                this.hYD.ci(this.hYF.size(), 1);
            }
        }
    }

    public boolean coi() {
        return this.hYH;
    }
}
