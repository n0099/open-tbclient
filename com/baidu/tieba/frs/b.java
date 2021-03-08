package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String forumId;
    private AntiData fsl;
    private av jgO;
    private final ArrayList<cb> jgQ;
    private boolean jgR;
    private boolean jgS;

    private b() {
        this.jgR = false;
        this.jgQ = new ArrayList<>();
    }

    public static b cBE() {
        return a.jgT;
    }

    public boolean cBy() {
        return this.jgR;
    }

    public void X(boolean z, boolean z2) {
        this.jgR = z;
        if (this.jgO != null) {
            this.jgO.g(this.jgR, z2, 1);
        }
    }

    public boolean am(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (this.jgQ.size() > 29) {
            if (this.jgO != null) {
                this.jgO.yC(1);
                return false;
            }
            return false;
        }
        this.jgQ.add(cbVar);
        if (this.jgO != null) {
            this.jgO.cm(this.jgQ.size(), 1);
        }
        return true;
    }

    public List<cb> cBB() {
        return this.jgQ;
    }

    public void an(cb cbVar) {
        this.jgQ.remove(cbVar);
        if (this.jgO != null) {
            this.jgO.cm(this.jgQ.size(), 1);
        }
    }

    public void clearData() {
        Iterator<cb> it = this.jgQ.iterator();
        while (it.hasNext()) {
            cb next = it.next();
            if (next != null) {
                next.jA(false);
            }
        }
        this.jgQ.clear();
        if (this.jgO != null) {
            this.jgO.cm(0, 1);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void a(av avVar) {
        this.jgO = avVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b jgT = new b();
    }

    public AntiData cBF() {
        return this.fsl;
    }

    public void b(AntiData antiData) {
        this.fsl = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void qr(boolean z) {
        this.jgS = z;
    }

    public void di(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.jgQ)) {
            Iterator<cb> it = this.jgQ.iterator();
            while (it.hasNext()) {
                cb next = it.next();
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
            if (this.jgO != null) {
                this.jgO.cm(this.jgQ.size(), 1);
            }
        }
    }

    public boolean cBG() {
        return this.jgS;
    }
}
