package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData ejE;
    private String forumId;
    private aw hyv;
    private final ArrayList<bu> hyx;
    private boolean hyy;
    private boolean hyz;

    private b() {
        this.hyy = false;
        this.hyx = new ArrayList<>();
    }

    public static b bXc() {
        return a.hyA;
    }

    public boolean bWW() {
        return this.hyy;
    }

    public void M(boolean z, boolean z2) {
        this.hyy = z;
        if (this.hyv != null) {
            this.hyv.d(this.hyy, z2, 1);
        }
    }

    public boolean al(bu buVar) {
        if (buVar == null) {
            return false;
        }
        if (this.hyx.size() > 29) {
            if (this.hyv != null) {
                this.hyv.up(1);
                return false;
            }
            return false;
        }
        this.hyx.add(buVar);
        if (this.hyv != null) {
            this.hyv.bT(this.hyx.size(), 1);
        }
        return true;
    }

    public List<bu> bWZ() {
        return this.hyx;
    }

    public void am(bu buVar) {
        this.hyx.remove(buVar);
        if (this.hyv != null) {
            this.hyv.bT(this.hyx.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bu> it = this.hyx.iterator();
        while (it.hasNext()) {
            bu next = it.next();
            if (next != null) {
                next.ha(false);
            }
        }
        this.hyx.clear();
        if (this.hyv != null) {
            this.hyv.bT(0, 1);
        }
    }

    public void reset() {
        M(false, false);
        clearData();
    }

    public void a(aw awVar) {
        this.hyv = awVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b hyA = new b();
    }

    public AntiData bXd() {
        return this.ejE;
    }

    public void b(AntiData antiData) {
        this.ejE = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void mR(boolean z) {
        this.hyz = z;
    }

    public void cv(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.isEmpty(list) && !com.baidu.tbadk.core.util.w.isEmpty(this.hyx)) {
            Iterator<bu> it = this.hyx.iterator();
            while (it.hasNext()) {
                bu next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.ar.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.hyv != null) {
                this.hyv.bT(this.hyx.size(), 1);
            }
        }
    }

    public boolean bXe() {
        return this.hyz;
    }
}
