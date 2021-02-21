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
    private av jff;
    private final ArrayList<cb> jfh;
    private boolean jfi;
    private boolean jfj;

    private b() {
        this.jfi = false;
        this.jfh = new ArrayList<>();
    }

    public static b cBy() {
        return a.jfk;
    }

    public boolean cBs() {
        return this.jfi;
    }

    public void X(boolean z, boolean z2) {
        this.jfi = z;
        if (this.jff != null) {
            this.jff.g(this.jfi, z2, 1);
        }
    }

    public boolean am(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (this.jfh.size() > 29) {
            if (this.jff != null) {
                this.jff.yB(1);
                return false;
            }
            return false;
        }
        this.jfh.add(cbVar);
        if (this.jff != null) {
            this.jff.cm(this.jfh.size(), 1);
        }
        return true;
    }

    public List<cb> cBv() {
        return this.jfh;
    }

    public void an(cb cbVar) {
        this.jfh.remove(cbVar);
        if (this.jff != null) {
            this.jff.cm(this.jfh.size(), 1);
        }
    }

    public void clearData() {
        Iterator<cb> it = this.jfh.iterator();
        while (it.hasNext()) {
            cb next = it.next();
            if (next != null) {
                next.jA(false);
            }
        }
        this.jfh.clear();
        if (this.jff != null) {
            this.jff.cm(0, 1);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void a(av avVar) {
        this.jff = avVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b jfk = new b();
    }

    public AntiData cBz() {
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
        this.jfj = z;
    }

    public void di(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.jfh)) {
            Iterator<cb> it = this.jfh.iterator();
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
            if (this.jff != null) {
                this.jff.cm(this.jfh.size(), 1);
            }
        }
    }

    public boolean cBA() {
        return this.jfj;
    }
}
