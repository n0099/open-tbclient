package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData fbU;
    private String forumId;
    private ay iGL;
    private final ArrayList<bx> iGN;
    private boolean iGO;
    private boolean iGP;

    private b() {
        this.iGO = false;
        this.iGN = new ArrayList<>();
    }

    public static b cwO() {
        return a.iGQ;
    }

    public boolean cwI() {
        return this.iGO;
    }

    public void V(boolean z, boolean z2) {
        this.iGO = z;
        if (this.iGL != null) {
            this.iGL.d(this.iGO, z2, 1);
        }
    }

    public boolean al(bx bxVar) {
        if (bxVar == null) {
            return false;
        }
        if (this.iGN.size() > 29) {
            if (this.iGL != null) {
                this.iGL.zf(1);
                return false;
            }
            return false;
        }
        this.iGN.add(bxVar);
        if (this.iGL != null) {
            this.iGL.cm(this.iGN.size(), 1);
        }
        return true;
    }

    public List<bx> cwL() {
        return this.iGN;
    }

    public void am(bx bxVar) {
        this.iGN.remove(bxVar);
        if (this.iGL != null) {
            this.iGL.cm(this.iGN.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bx> it = this.iGN.iterator();
        while (it.hasNext()) {
            bx next = it.next();
            if (next != null) {
                next.iR(false);
            }
        }
        this.iGN.clear();
        if (this.iGL != null) {
            this.iGL.cm(0, 1);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.iGL = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b iGQ = new b();
    }

    public AntiData cwP() {
        return this.fbU;
    }

    public void b(AntiData antiData) {
        this.fbU = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void pr(boolean z) {
        this.iGP = z;
    }

    public void dc(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.iGN)) {
            Iterator<bx> it = this.iGN.iterator();
            while (it.hasNext()) {
                bx next = it.next();
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
            if (this.iGL != null) {
                this.iGL.cm(this.iGN.size(), 1);
            }
        }
    }

    public boolean cwQ() {
        return this.iGP;
    }
}
