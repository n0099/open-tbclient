package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData eOB;
    private String forumId;
    private ay inE;
    private final ArrayList<bw> inG;
    private boolean inH;
    private boolean inI;

    private b() {
        this.inH = false;
        this.inG = new ArrayList<>();
    }

    public static b crE() {
        return a.inJ;
    }

    public boolean cry() {
        return this.inH;
    }

    public void S(boolean z, boolean z2) {
        this.inH = z;
        if (this.inE != null) {
            this.inE.d(this.inH, z2, 1);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.inG.size() > 29) {
            if (this.inE != null) {
                this.inE.yb(1);
                return false;
            }
            return false;
        }
        this.inG.add(bwVar);
        if (this.inE != null) {
            this.inE.ci(this.inG.size(), 1);
        }
        return true;
    }

    public List<bw> crB() {
        return this.inG;
    }

    public void ak(bw bwVar) {
        this.inG.remove(bwVar);
        if (this.inE != null) {
            this.inE.ci(this.inG.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bw> it = this.inG.iterator();
        while (it.hasNext()) {
            bw next = it.next();
            if (next != null) {
                next.iu(false);
            }
        }
        this.inG.clear();
        if (this.inE != null) {
            this.inE.ci(0, 1);
        }
    }

    public void reset() {
        S(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.inE = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b inJ = new b();
    }

    public AntiData crF() {
        return this.eOB;
    }

    public void b(AntiData antiData) {
        this.eOB = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void oN(boolean z) {
        this.inI = z;
    }

    public void cL(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.inG)) {
            Iterator<bw> it = this.inG.iterator();
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
            if (this.inE != null) {
                this.inE.ci(this.inG.size(), 1);
            }
        }
    }

    public boolean crG() {
        return this.inI;
    }
}
