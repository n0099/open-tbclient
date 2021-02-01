package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String forumId;
    private AntiData fqK;
    private av jeR;
    private final ArrayList<cb> jeT;
    private boolean jeU;
    private boolean jeV;

    private b() {
        this.jeU = false;
        this.jeT = new ArrayList<>();
    }

    public static b cBr() {
        return a.jeW;
    }

    public boolean cBl() {
        return this.jeU;
    }

    public void X(boolean z, boolean z2) {
        this.jeU = z;
        if (this.jeR != null) {
            this.jeR.g(this.jeU, z2, 1);
        }
    }

    public boolean am(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (this.jeT.size() > 29) {
            if (this.jeR != null) {
                this.jeR.yB(1);
                return false;
            }
            return false;
        }
        this.jeT.add(cbVar);
        if (this.jeR != null) {
            this.jeR.cl(this.jeT.size(), 1);
        }
        return true;
    }

    public List<cb> cBo() {
        return this.jeT;
    }

    public void an(cb cbVar) {
        this.jeT.remove(cbVar);
        if (this.jeR != null) {
            this.jeR.cl(this.jeT.size(), 1);
        }
    }

    public void clearData() {
        Iterator<cb> it = this.jeT.iterator();
        while (it.hasNext()) {
            cb next = it.next();
            if (next != null) {
                next.jA(false);
            }
        }
        this.jeT.clear();
        if (this.jeR != null) {
            this.jeR.cl(0, 1);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void a(av avVar) {
        this.jeR = avVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b jeW = new b();
    }

    public AntiData cBs() {
        return this.fqK;
    }

    public void b(AntiData antiData) {
        this.fqK = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void qr(boolean z) {
        this.jeV = z;
    }

    public void di(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.jeT)) {
            Iterator<cb> it = this.jeT.iterator();
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
            if (this.jeR != null) {
                this.jeR.cl(this.jeT.size(), 1);
            }
        }
    }

    public boolean cBt() {
        return this.jeV;
    }
}
