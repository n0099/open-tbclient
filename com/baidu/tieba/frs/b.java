package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String forumId;
    private AntiData ftd;
    private av jdR;
    private final ArrayList<bz> jdT;
    private boolean jdU;
    private boolean jdV;

    private b() {
        this.jdU = false;
        this.jdT = new ArrayList<>();
    }

    public static b cDY() {
        return a.jdW;
    }

    public boolean cDS() {
        return this.jdU;
    }

    public void X(boolean z, boolean z2) {
        this.jdU = z;
        if (this.jdR != null) {
            this.jdR.e(this.jdU, z2, 1);
        }
    }

    public boolean al(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        if (this.jdT.size() > 29) {
            if (this.jdR != null) {
                this.jdR.zX(1);
                return false;
            }
            return false;
        }
        this.jdT.add(bzVar);
        if (this.jdR != null) {
            this.jdR.co(this.jdT.size(), 1);
        }
        return true;
    }

    public List<bz> cDV() {
        return this.jdT;
    }

    public void am(bz bzVar) {
        this.jdT.remove(bzVar);
        if (this.jdR != null) {
            this.jdR.co(this.jdT.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bz> it = this.jdT.iterator();
        while (it.hasNext()) {
            bz next = it.next();
            if (next != null) {
                next.jC(false);
            }
        }
        this.jdT.clear();
        if (this.jdR != null) {
            this.jdR.co(0, 1);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void a(av avVar) {
        this.jdR = avVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b jdW = new b();
    }

    public AntiData cDZ() {
        return this.ftd;
    }

    public void b(AntiData antiData) {
        this.ftd = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void ql(boolean z) {
        this.jdV = z;
    }

    public void dn(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list) && !com.baidu.tbadk.core.util.x.isEmpty(this.jdT)) {
            Iterator<bz> it = this.jdT.iterator();
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
            if (this.jdR != null) {
                this.jdR.co(this.jdT.size(), 1);
            }
        }
    }

    public boolean cEa() {
        return this.jdV;
    }
}
